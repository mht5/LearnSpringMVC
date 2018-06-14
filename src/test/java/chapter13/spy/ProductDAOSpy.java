package chapter13.spy;

import java.math.BigDecimal;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

/**
 * spy是更智能的stub， 可以保留状态
 * @author mohan
 *
 */
public class ProductDAOSpy implements ProductDAO {
	private int storage = 2;

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
		if(storage > 0) {
			storage--;
			return new Product();
		} else {
			return null;
		}
	}

	@Override
	public void add(Product product) {
	}

	@Override
	public List<Product> listMembers() {
		return null;
	}

}
