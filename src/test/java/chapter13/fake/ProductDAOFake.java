package chapter13.fake;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

/**
 * fake������ʵ���õ��࣬��Ϊ�����߽ݾ�������ʹ���ڴ�洢���������ݿ�
 * @author mohan
 *
 */
public class ProductDAOFake implements ProductDAO {
	private int storage = 2;
	private List<Product> productList = new ArrayList<Product>();

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
		productList.add(product);
	}

	@Override
	public List<Product> listMembers() {
		return productList;
	}

}
