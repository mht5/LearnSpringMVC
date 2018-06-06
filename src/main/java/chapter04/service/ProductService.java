package chapter04.service;

import chapter02.bean.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
