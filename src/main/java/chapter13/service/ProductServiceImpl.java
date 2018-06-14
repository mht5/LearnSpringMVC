package chapter13.service;

import java.math.BigDecimal;
import java.util.List;

import chapter13.dao.ProductDAO;
import chapter13.domain.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	
	public ProductServiceImpl(ProductDAO productDAO) {
		if (productDAO == null) {
			throw new NullPointerException("ProductDAO cannot be null");
		}
		this.productDAO = productDAO;
	}
	
	@Override
	public BigDecimal calculateDiscount() {
		return productDAO.calculateDiscount();
	}

	@Override
	public boolean isOnSale(int productId) {
		return productDAO.isOnSale(productId);
	}

	@Override
	public Product buy() {
		return productDAO.buy();
	}

	@Override
	public void add(Product product) {
		productDAO.add(product);
	}

	@Override
	public List<Product> listMembers() {
		return productDAO.listMembers();
	}

}
