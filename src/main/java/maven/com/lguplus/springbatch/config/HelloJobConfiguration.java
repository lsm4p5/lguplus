package maven.com.lguplus.springbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Configuration
@EnableBatchProcessing()
public class HelloJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;





    //    @Bean
//    @Primary
//    public BatchProperties batchProperties () {
//
//        final String SCHEMA_LOCATION = "classpath:sql/h2.sql";
////        final String SCHEMA_LOCATION = "classpath:org/springframework/"
////                + "batch/core/schema-@@platform@@.sql";
//        System.out.println( "SCHEMA_LOCATION = " + SCHEMA_LOCATION );
//        BatchProperties batchProperties = new BatchProperties();
//        batchProperties.setSchema(SCHEMA_LOCATION);
//
//        return batchProperties;
//    }

    @Bean
    public Job helloJob() {
        return jobBuilderFactory.get( "helloJob" )
                .start( helloStep1() )
                .next( helloStep2() )
                .build();
    }

    @Bean
    public Step helloStep1() {
        return stepBuilderFactory.get("helloStep1")
                .tasklet( new Tasklet(){
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println( "stepContribution = " + stepContribution );
                        System.out.println( "============================" );
                        System.out.println( ">>[1] hello Stpring Batch!!!" );
                        System.out.println( "============================" );
                        return RepeatStatus.FINISHED;

                    }
                })
                .build();
    }
    @Bean
    public Step helloStep2() {
        return stepBuilderFactory.get("helloStep2")
                .tasklet( new Tasklet(){
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println( "stepContribution = " + stepContribution );
                        System.out.println( "============================" );
                        System.out.println( ">>[2] hello Stpring Batch!!!" );
                        System.out.println( "============================" );
                        return RepeatStatus.FINISHED;

                    }
                })
                .build();
    }

}
