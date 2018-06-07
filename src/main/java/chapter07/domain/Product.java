package chapter07.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * 可以使用JSR303注解来进行验证
 * @author mohan
 *
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(min=1, max=10)
	private String name;
	private String description;
	private BigDecimal price;
	@Past
	private LocalDate productionDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", productionDate="
				+ productionDate + "]";
	}
}
