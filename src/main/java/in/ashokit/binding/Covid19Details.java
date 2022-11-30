package in.ashokit.binding;

import lombok.Data;

@Data
public class Covid19Details
{
	private String country;
	private String code;
	private long confirmed;
	private long recovered;
	private long critical;
	private long deaths;
	private Double latitude;
	private Double longitude;
	private String lastChange; 
	private String lastUpdate;
}
