package chapter13.stub;

import org.junit.Assert;
import org.junit.Test;

import chapter13.dao.ProductDAO;
import chapter13.service.ProductService;
import chapter13.service.ProductServiceImpl;

public class ProductServiceImplTest {
	@Test
	public void testCalculateDIscount() {
		ProductDAO productDAO = new ProductDAOStub();
		ProductService productService = new ProductServiceImpl(productDAO);
		boolean result = productService.isOnSale(1);
		Assert.assertEquals(true, result);
	}
}
