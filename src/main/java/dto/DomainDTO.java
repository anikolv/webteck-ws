package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rest.domain.Status;

@XmlRootElement(name = "xmlData")
public class DomainDTO {
	
	@XmlElement
	protected Status status;
	
	@XmlElement
	protected String message;
}
