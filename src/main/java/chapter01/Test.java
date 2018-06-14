package chapter01;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter01.bean.Employee;
import chapter01.bean.Product;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"spring-config-chapter01.xml"});
		
		Product product = context.getBean("product", Product.class);
		product.setName("test");
		System.out.println(product);
		
		LocalDate localDate = context.getBean("localDate", LocalDate.class);
		System.out.println("LocalDate: " + localDate);
		
		Product featuredProduct = context.getBean("featuredProduct", Product.class);
		System.out.println(featuredProduct);
		
		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
	}
}
