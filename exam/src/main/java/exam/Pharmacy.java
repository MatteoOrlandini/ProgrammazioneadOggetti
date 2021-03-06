package exam;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a generic pharmacy that can describe the rows of the dataset.
 *
 */
public class Pharmacy {
	private String id;
	private String name;
	private String address;
	private String vatNumber;
	private String postalCode;
	private String cityCode;
	private String city;
	private String provinceCode;
	private String provinceAbbreviation;
	private String provinceName;
	private String regionCode;
	private String regionName;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/Rome")
	private Date beginValidity;
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "Europe/Rome")
	private Date endValidity;
	private double latitude;
	private double longitude;
	private int localize;

	public Pharmacy() {

	}

	public Pharmacy(String id, String name, String address, String vatNumber, String postalCode, String cityCode,
			String city, String provinceCode, String provinceAbbreviation, String provinceName, String regionCode,
			String regionName, Date beginValidity, Date endValidity, double latitude, double longitude, int localize) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.vatNumber = vatNumber;
		this.postalCode = postalCode;
		this.cityCode = cityCode;
		this.city = city;
		this.provinceCode = provinceCode;
		this.provinceAbbreviation = provinceAbbreviation;
		this.provinceName = provinceName;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.beginValidity = beginValidity;
		this.endValidity = endValidity;
		this.latitude = latitude;
		this.longitude = longitude;
		this.localize = localize;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceAbbreviation() {
		return provinceAbbreviation;
	}

	public void setProvinceAbbreviation(String provinceAbbreviation) {
		this.provinceAbbreviation = provinceAbbreviation;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Date getBeginValidity() {
		return beginValidity;
	}

	public void setBeginValidity(Date beginValidity) {
		this.beginValidity = beginValidity;
	}

	public Date getEndValidity() {
		return endValidity;
	}

	public void setEndValidity(Date endValidity) {
		this.endValidity = endValidity;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getLocalize() {
		return localize;
	}

	public void setLocalize(int localize) {
		this.localize = localize;
	}
}
