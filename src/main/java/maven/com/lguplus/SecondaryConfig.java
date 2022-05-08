package maven.com.lguplus;



import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactorySecondary",
//        transactionManagerRef="transactionManagerSecondary",
//        basePackages= { "com.lguplus.repository.EntitySecond" }) //  Repository
public class SecondaryConfig {

//    @Autowired
//    @Qualifier("secondaryDataSource")
//    private DataSource secondaryDataSource;
//    @Bean(name = "secondaryEntityManager")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
//    }
//    @Bean(name = "secondaryEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(secondaryDataSource)
//                .properties(getVendorProperties(secondaryDataSource))
//                .packages("com.lguplus.domain.EntitySecond") //
//                .persistenceUnit("secondaryPersistenceUnit")
//                .build();
//    }
//    @Autowired
//    private JpaProperties jpaProperties;
////    private Map<String, String> getVendorProperties(DataSource dataSource) {
////
////        return jpaProperties.getHibernateProperties(dataSource);
////
////    }
//
//    //private Properties getVendorProperties(DataSource dataSource) {
//    private Map getVendorProperties(DataSource dataSource) {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        return properties;
//
//    }
//
//
//
//    @Bean(name = "secondaryTransactionManager")
//    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
//    }


}