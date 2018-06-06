package chapter01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring-config_chapter01.xml"});
		Product product = context.getBean("product", Product.class);
		product.setName("test");
		System.out.println("Product name: " + product.getName());
	}
}
