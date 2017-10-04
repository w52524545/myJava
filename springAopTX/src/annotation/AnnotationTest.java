package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationTest {

	@Qc(gender = 0, name = "tom", age = 18)
	public static User user;

	@Qc(gender = 1)
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("annotation.AnnotationTest");
			Field user = cls.getField("user");
			Annotation[] annotations = user.getAnnotations();
			for (int i = 0; i < annotations.length; i++) {
				Annotation annotation = annotations[i];
				Qc qc = (Qc) annotation;
				String name = qc.name();
				int age = qc.age();
				int gender = qc.gender();
				System.out.println("name:" + name + "  age:" + age + "  gender:" + gender);
				System.out.println(annotation.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
