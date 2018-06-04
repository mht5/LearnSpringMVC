package chapter02.validator;

import java.util.ArrayList;
import java.util.List;

import chapter02.form.ProductForm;

public class ProductValidator {
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<String>();
		String name = productForm.getName();
		String price = productForm.getPrice();
		if (name == null || name.trim().isEmpty()) {
			errors.add("Product must have a name.");
		}
		if (price == null || price.trim().isEmpty()) {
			errors.add("Product must have a price.");
		} else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("Invalid price value.");
			}
		}
		
		return errors;
	}
}
