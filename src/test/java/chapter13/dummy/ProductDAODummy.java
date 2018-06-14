package chapter13.dummy;

import java.math.BigDecimal;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

/**
 * dummy不会改变SUT的行为，通常用于使SUT可实例化
 * @author mohan
 *
 */
public class ProductDAODummy implements ProductDAO{

	@Override
	public BigDecimal calculateDiscount() {
		return null;
	}

	@Override
	public boolean isOnSale(int productId) {
		return true;
	}

	@Override
	public Product buy() {
		return null;
	}

	@Override
	public void add(Product product) {
	}

	@Override
	public List<Product> listMembers() {
		return null;
	}

}
