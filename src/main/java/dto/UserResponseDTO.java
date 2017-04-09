package dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rest.domain.Status;
import com.rest.domain.User;

@XmlRootElement(name = "xmlData")
public class UserResponseDTO extends DomainDTO {
	
	@XmlElement(name = "user")
	private List<User> users = new ArrayList<>();
	
	public UserResponseDTO(){}
	
	public UserResponseDTO(List<User> users, Status status) {
		this.users = users;
		this.status = status;
	}
	
	public UserResponseDTO(Status status, String message) {
		this.status = status;
		this.message = message;
	}
}
