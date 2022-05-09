package maven.com.lguplus.service.beanservice;

import maven.com.lguplus.service.discount.DiscountService;
import org.springframework.context.ApplicationContext;

public class BeanUtils {

    public static Object getBean(String beanId) {

        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }

//        String[] names = applicationContext.getBeanDefinitionNames();
//         for (int i=0; i<names.length; i++) {
//             System.out.println("[" +i+ "]th :"+ names[i]);
//         }

        return applicationContext.getBean(beanId);
    }

    public static String[] getBeanNames(){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        return applicationContext.getBeanDefinitionNames();
    }
    //<T> T createBean(Class<T> var1)

    public static <T> T getBean(Class<T> var1){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        return applicationContext.getBean(var1);
    }
}
