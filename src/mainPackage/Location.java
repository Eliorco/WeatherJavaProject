package mainPackage;

import java.sql.Time;

public class Location {
	
	private Double coordLon;
	private  Double coordLat;
	private  Integer sysType;
	private  Integer sysID;
	private  Double sysMessage;
	private  String sysCountry="";
	private  Time sysSunrise;
	private  Time sysSunset;
	private  String id="";
	private  String name="";
	private  Integer cod;
	
//////
	public Location(){
		
	}
	public Location(String name,String country){
		this.name = name;
		this.sysCountry = country;
	}
	
	public Double getCoordLon() {
		return coordLon;
	}

	public void setCoordLon(Double coordLon) {
		this.coordLon = coordLon;
	}

	public Double getCoordLat() {
		return coordLat;
	}

	public void setCoordLat(Double coordLat) {
		this.coordLat = coordLat;
	}

	public Integer getSysType() {
		return sysType;
	}

	public void setSysType(Integer sysType) {
		this.sysType = sysType;
	}

	public Integer getSysID() {
		return sysID;
	}

	public void setSysID(Integer sysID) {
		this.sysID = sysID;
	}

	public Double getSysMessage() {
		return sysMessage;
	}

	public void setSysMessage(Double sysMessage) {
		this.sysMessage = sysMessage;
	}

	public String getSysCountry() {
		return sysCountry;
	}

	public void setSysCountry(String sysCountry) {
		this.sysCountry = sysCountry;
	}

	public Time getSysSunrise() {
		return sysSunrise;
	}

	public void setSysSunrise(Long sysSunrise) {
		this.sysSunrise = new Time(sysSunrise.longValue()*1000);
	}

	public Time getSysSunset() {
		return sysSunset;
	}

	public void setSysSunset(Long sysSunset) {
		this.sysSunset = new Time(sysSunset.longValue()*1000);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}
	

}
