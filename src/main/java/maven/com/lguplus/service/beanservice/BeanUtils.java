package maven.com.lguplus.service.beanservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;


import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


//@Component
@Slf4j
public class BeanUtils {

  //  private final AnnotationConfigServletWebServerApplicationContext ac;

//    @Autowired
//    public BeanUtils(AnnotationConfigServletWebServerApplicationContext ac) {
//        this.ac = ac;
//    }

    /** Bean 이름으로 단일 Bean 조회 */
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

    /**
     * 전체 Bean Name을 조회한다.
     * @return
     */
    public static String[] getBeanNames(){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        return applicationContext.getBeanDefinitionNames();
    }
    //<T> T createBean(Class<T> var1)

    /**
     * 특정 Bean을 Class Name으로 조회하여 return한다.
     * @param var1
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> var1){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        return applicationContext.getBean(var1);
    }

    public static String[] getBeanNamesApplication(){
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        if( applicationContext == null ) {
            throw new NullPointerException("Spring의 ApplicationContext초기화 안됨");
        }
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        int j =0;
        for (String beanDefinitionName : beanDefinitionNames) {
            if(beanDefinitionName.contains("bean")) {
                System.out.println("beanDefinitionName = " + beanDefinitionName);
            }
        }

        return applicationContext.getBeanDefinitionNames();
    }

    public String[] getAppBeans() {
       // String applicationName = ac.getApplicationName();
      //  log.info( "applicationName = {}", applicationName );

        return null;
    }
}
