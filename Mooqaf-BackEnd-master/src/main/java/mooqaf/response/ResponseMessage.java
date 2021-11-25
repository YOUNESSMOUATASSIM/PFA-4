package mooqaf.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ResponseMessage {
	private Date timestamp;
	private String message;
	
}
