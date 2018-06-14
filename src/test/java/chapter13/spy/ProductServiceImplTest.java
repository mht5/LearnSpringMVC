package chapter13.spy;

import org.junit.Assert;
import org.junit.Test;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;
import chapter13.service.ProductService;
import chapter13.service.ProductServiceImpl;

public class ProductServiceImplTest {
	@Test
	public void testCalculateDIscount() {
		ProductDAO productDAO = new ProductDAOSpy();
		ProductService productService = new ProductServiceImpl(productDAO);
		
		Product product1 = productService.buy();
		Product product2 = productService.buy();
		Product product3 = productService.buy();

		Assert.assertNotNull(product1);
		Assert.assertNotNull(product2);
		Assert.assertNotNull(product3);
	}
}
