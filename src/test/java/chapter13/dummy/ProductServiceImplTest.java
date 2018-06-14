package chapter13.dummy;

import org.junit.Assert;
import org.junit.Test;

import chapter13.dao.ProductDAO;
import chapter13.service.ProductService;
import chapter13.service.ProductServiceImpl;

public class ProductServiceImplTest {
	@Test
	public void testCalculateDIscount() {
		ProductDAO productDAO = new ProductDAODummy();
		ProductService productService = new ProductServiceImpl(productDAO);
		Assert.assertNotNull(productService);
	}
}
