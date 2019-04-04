import java.util.Arrays;

public class Flag {
	
	private String countryName;
	private String[] colors;
	private boolean isRetired;
	
	public Flag() {
		
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	public boolean isRetired() {
		return isRetired;
	}
	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(countryName);
		str.append(", Colors: " + Arrays.toString(colors));
		str.append(", Retired: " + isRetired);
		return str.toString();
	}
}
