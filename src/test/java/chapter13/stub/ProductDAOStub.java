package chapter13.stub;

import java.math.BigDecimal;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

/**
 * ��dummy��ͬ����stub�еķ����ᱻʵ�ʵ���
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
