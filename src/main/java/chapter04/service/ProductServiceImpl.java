package chapter04.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import chapter02.bean.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private Map<Long, Product> products = new HashMap<Long, Product>();
	private AtomicLong generator = new AtomicLong();
	
	public ProductServiceImpl(){
		Product product = new Product();
		product.setName("DELL monitor");
		product.setName("a really nice one.");
		product.setPrice(new BigDecimal(1999.9));
		System.out.println(product);
		
		add(product);
	}

	@Override
	public Product add(Product product) {
		long newId = generator.incrementAndGet();
		product.setId(newId);
		products.put(newId, product);
		return product;
	}

	@Override
	public Product get(long id) {
		return products.get(id);
	}

}
