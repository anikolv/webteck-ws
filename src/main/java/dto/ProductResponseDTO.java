package dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rest.domain.Product;
import com.rest.domain.Status;

@XmlRootElement(name = "xmlData")
public class ProductResponseDTO extends DomainDTO {
	
	@XmlElement(name = "product")
	private List<Product> products = new ArrayList<>();
	
	public ProductResponseDTO(){}
	
	public ProductResponseDTO(List<Product> products, Status status) {
		this.products = products;
		this.status = status;
	}
	
	public ProductResponseDTO(Status status, String message) {
		this.status = status;
		this.message = message;
	}
}
