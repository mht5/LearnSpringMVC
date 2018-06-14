package chapter13.stub;

import java.math.BigDecimal;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

/**
 * 与dummy不同的是stub中的方法会被实际调用
 * @author mohan
 *
 */
public class ProductDAOStub implements ProductDAO {

	@Override
	public BigDecimal calculateDiscount() {
		return new BigDecimal(12);
	}

	@Override
	public boolean isOnSale(int productId) {
		return true;
	}

	@Override
	public Product buy() {
		return new Product();
	}

	@Override
	public void add(Product product) {
	}

	@Override
	public List<Product> listMembers() {
		return null;
	}

}
