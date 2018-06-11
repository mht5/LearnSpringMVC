package chapter11.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min=1, max=10)
	private String name;
	private String description;
	private BigDecimal price;
	private List<MultipartFile> files;
	
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
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", files=" + files + "]";
	}
}
