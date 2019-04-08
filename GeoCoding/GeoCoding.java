import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class GeoCoding {
	
	public GeoCoding() {
		
	}
	
	private Location getCoordinates(String address) {
		Location coordinates = new Location(0d,0d);
		
		// Geolocation here
		
		return coordinates;
	}
	private double getDistanceKilometer(String address1, String address2) {
		Location coor1 = getCoordinates(address1);
		Location coor2 = getCoordinates(address2);
		
		//This is the calculation for distance of 2 points
		double a = Math.pow(Math.sin((coor2.getLatitude()-coor1.getLatitude())/2),2) + Math.cos(coor1.getLatitude()) * Math.cos(coor2.getLatitude()) * Math.pow(Math.sin((coor2.getLongitude()-coor1.getLongitude())/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double earthRadius = 6371;
		double distance = earthRadius * c;
		return distance;
	}
	
	
//	private String getRequest(String url) throws Exception {
//
//        final URL obj = new URL(url);
//        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        con.setRequestMethod("GET");
//
//        if (con.getResponseCode() != 200) {
//            return null;
//        }
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        return response.toString();
//    }
//
//    public Map<String, Double> getCoordinates(String address) {
//        Map<String, Double> res;
//        StringBuffer query;
//        String[] split = address.split(" ");
//        String queryResult = null;
//
//        query = new StringBuffer();
//        res = new HashMap<String, Double>();
//
//        query.append("http://nominatim.openstreetmap.org/search?q=");
//
//        if (split.length == 0) {
//            return null;
//        }
//
//        for (int i = 0; i < split.length; i++) {
//            query.append(split[i]);
//            if (i < (split.length - 1)) {
//                query.append("+");
//            }
//        }
//        query.append("&format=json&addressdetails=1");
//
//        log.debug("Query:" + query);
//
//        try {
//            queryResult = getRequest(query.toString());
//        } catch (Exception e) {
//            log.error("Error when trying to get data with the following query " + query);
//        }
//
//        if (queryResult == null) {
//            return null;
//        }
//
//        Object obj = JSONValue.parse(queryResult);
//        log.debug("obj=" + obj);
//
//        if (obj instanceof JsonArray) {
//            JsonArray array = (JsonArray) obj;
//            if (array.size() > 0) {
//                JsonObject jsonObject = (JsonObject) array.get(0);
//
//                String lon = (String) jsonObject.get("lon");
//                String lat = (String) jsonObject.get("lat");
//                log.debug("lon=" + lon);
//                log.debug("lat=" + lat);
//                res.put("lon", Double.parseDouble(lon));
//                res.put("lat", Double.parseDouble(lat));
//
//            }
//        }
//
//        return res;
//    }
}
