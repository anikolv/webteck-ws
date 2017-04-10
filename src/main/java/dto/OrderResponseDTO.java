package dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rest.domain.Order;
import com.rest.domain.Status;

@XmlRootElement(name = "xmlData")
public class OrderResponseDTO extends DomainDTO {
	
	@XmlElement(name = "order")
	private List<Order> orders = new ArrayList<>();
	
	public OrderResponseDTO(){}
	
	public OrderResponseDTO(List<Order> orders, Status status) {
		this.orders = orders;
		this.status = status;
	}
	
	public OrderResponseDTO(Status status, String message) {
		this.status = status;
		this.message = message;
	}
}
