package maven.com.lguplus.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.domain.primary.Entity.Item;
import maven.com.lguplus.repository.primary.ItemRepository;
import maven.com.lguplus.web.formdto.ItemSaveForm;
import maven.com.lguplus.web.formdto.ItemUpdateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemWebController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        //로그인 여부 체크
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "items/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        //로그인 여부 체크
        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            model.addAttribute("item", item);
            return "items/item";
        }
        else{
            return "items/items";
        }

    }

    @GetMapping("/add")
    public String addForm(Model model) {
        //로그인 여부 체크
        model.addAttribute("item", new Item());
        return "items/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //특정 필드 예외가 아닌 전체 예외
        if (form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "items/addForm";
        }

        //성공 로직
        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setQuantity(form.getQuantity());

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            model.addAttribute("item", item);
            return "items/editForm";
        }
        else{
            return "items/items";
        }

    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @Validated @ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult) {

        //특정 필드 예외가 아닌 전체 예외
        if (form.getPrice() != null && form.getQuantity() != null) {
            int resultPrice = form.getPrice() * form.getQuantity();
            if (resultPrice < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "items/editForm";
        }

        Item itemParam = new Item();
        itemParam.setItemName(form.getItemName());
        itemParam.setPrice(form.getPrice());
        itemParam.setQuantity(form.getQuantity());

        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if(optionalItem.isPresent()) {
            Item findItem = optionalItem.get();
            log.info("===== As-Isz(Item ======= {} " ,findItem);
            findItem.setItemName(itemParam.getItemName());
            findItem.setPrice(itemParam.getPrice());
            findItem.setQuantity(itemParam.getQuantity());
            Item saved = itemRepository.save(findItem);
            log.info("=======Updated(To-Be) =========={}",saved);
            return "redirect:/items/{itemId}";
        }
        else{
            return "items/items";
        }
    }

}
