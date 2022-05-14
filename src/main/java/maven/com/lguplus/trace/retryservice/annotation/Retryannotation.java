package maven.com.lguplus.trace.retryservice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface Retryannotation {
    int value() default 3;
}
