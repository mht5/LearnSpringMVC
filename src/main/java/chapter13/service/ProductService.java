package chapter13.service;

import java.math.BigDecimal;
import java.util.List;

import chapter13.domain.Product;

public interface ProductService {
	
	BigDecimal calculateDiscount();
	
	boolean isOnSale(int productId);
	
	Product buy();
	
	void add(Product product);
	
	List<Product> listMembers();
}
