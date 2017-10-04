package annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD, ElementType.TYPE, ElementType.FIELD })
@Inherited
public @interface Qc { // 注解就是一个接口，但要用@interface
	String name() default "tom"; // 注解设置默认值

	int age() default 11;

	int gender();
}