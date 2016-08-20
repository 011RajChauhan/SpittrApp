package spittr;

import java.util.Date;

public class Spittle {
	private final String message;
	private final Date date;
	private Double latitude;
	private Double longitude;
	public Spittle(String message,Date time){
		this(message,time,null,null);
	}
	public Spittle(String message,Date time,Double longitude,Double latitude){
		this.id=null;
		this.message=message;
		this.date=time;
		this.latitude=latitude;
		this.longitude=longitude;
	}
	
	private final Long id;
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getDate() {
		return date;
	}
	

}
