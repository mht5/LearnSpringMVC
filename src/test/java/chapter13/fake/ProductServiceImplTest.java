package chapter13.fake;

import org.junit.Assert;
import org.junit.Test;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;
import chapter13.service.ProductService;
import chapter13.service.ProductServiceImpl;

public class ProductServiceImplTest {
	@Test
	public void testCalculateDIscount() {
		ProductDAO productDAO = new ProductDAOFake();
		ProductService productService = new ProductServiceImpl(productDAO);

		productService.add(new Product("product1", 1));
		productService.add(new Product("product2", 2));
		productService.add(new Product("product3", 3));
		
		Assert.assertEquals(3, productService.listMembers().size());
	}
}
