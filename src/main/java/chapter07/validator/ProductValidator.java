package chapter07.validator;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import chapter07.domain.Product;


public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> klass) {
		return Product.class.isAssignableFrom(klass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		BigDecimal price = product.getPrice();
		LocalDate productionDate = product.getProductionDate();
		
		ValidationUtils.rejectIfEmpty(errors, "name", "productName.required");
		ValidationUtils.rejectIfEmpty(errors, "price", "price.required");
		ValidationUtils.rejectIfEmpty(errors, "productionDate", "productionDate.required");
		
		if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
			errors.rejectValue("price", "price.negative");
		}
		if (productionDate != null) {
			if (productionDate.isAfter(LocalDate.now())) {
				errors.rejectValue("productionDate", "productionDate.invalid");
			}
		}
	}
	
}
