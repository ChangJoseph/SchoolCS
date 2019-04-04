import java.util.Arrays;

public class FirstName {
	
	private Object meta;
//	private String meta;
	private Object[][] data;
	
	
	public Object getMeta() {
		return meta;
	}
	public void setMeta(Object meta) {
		this.meta = meta;
	}
	public Object[][] getData() {
		return data;
	}
	public void setData(Object[][] data) {
		this.data = data;
	}
	
	public String toString() {
		return Arrays.deepToString(data);
	}
}
