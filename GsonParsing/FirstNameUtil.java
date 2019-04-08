import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public final class FirstNameUtil {
	
	public String calculateAverageName(String[] list) {
		String output = "";
		
		for (String x : list) {
			
		}
		
		return output;
	}
	
	
//	public String frequencyNameGenerator(String[] input) {
////		StringBuilder output = new StringBuilder();
//		String output = "";
//		ArrayList<HashMap<String,Integer>> map = new ArrayList();
//		                                                                                                                                                                                                      
//		
//		for (String str : input) {
//			for (int count = 0; count < str.length(); count++) {
//				map.get(count).put();
//			}
//		}
//		
//		return output.toString();
//	}
	
	private String enbase(int x) {
	    if (x < 26) {
	    	return "" + alphabet(x);
	    }
		return enbase(x/26) + alphabet(x%26);
	}
	private char alphabet(int index) {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		return alpha.charAt(index);
	}
}
