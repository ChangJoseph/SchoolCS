import java.awt.Window.Type;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class Runner {

//	public static void main(String[] args) {
//		Gson gson = new Gson();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		
//		Flag flag1 = new Flag();
//		flag1.setColors(new String[]{"Red","White","Blue"});
//		flag1.setCountryName("Korea");
//		flag1.setRetired(false);
//		
//		Flag flag2 = new Flag();
//		flag2.setColors(new String[]{"Green","White"});
//		flag2.setCountryName("Nigeria");
//		flag2.setRetired(false);
//		
//		Flag[] flags = new Flag[] {flag1, flag2};
//		
//		ArrayList<Flag> flagsList = new ArrayList<Flag>();
//		flagsList.add(flag1);
//		flagsList.add(flag2);
//		
//		HashMap<Integer, Flag> flagsMap = new HashMap();
//		flagsMap.put(1, flag1);
//		flagsMap.put(2, flag2);
//		
//		String json1 = gson.toJson(flag1);
//		String json2 = gson.toJson(flag2);
//		String jsonFlags = gson.toJson(flags);
//		String jsonList = gson.toJson(flagsList);
//		String jsonMap = gson.toJson(flagsMap);
		
//		System.out.println(json1);
//		System.out.println(json2);
//		System.out.println(jsonFlags);
//		System.out.println(jsonList);
//		System.out.println(jsonMap);
		
//		Flag flag3 = gson.fromJson(json1, Flag.class);
//		System.out.println(flag3);
		
//		Flag[] flags2 = gson.fromJson(jsonFlags, Flag[].class);
//		for (Flag x : flags2) {
//			System.out.println(x);
//		}
		
//		ArrayList<Flag> flag4 = gson.fromJson(jsonList, ArrayList.class);
//		System.out.println(flag4);
		
		
//	}
	
	public static void main(String[] args) {
		try {
//			String json = new String(Files.readAllBytes(Paths.get("C:\\Users\\ChangJI19\\Documents\\Gson\\PopularFirstNamesMetaAndData.json")));
//			
//			Gson gson = new GsonBuilder().registerTypeAdapter(Type.class,
//		            new TypeAdapter<Type>() {
//
//		                @Override
//		                public void write(JsonWriter out, Type value)
//		                        throws IOException {
//		                    out.value(value.name().toLowerCase());
//		                }
//
//		                @Override
//		                public Type read(JsonReader in) throws IOException {
//		                    return Type.valueOf(in.nextString().toUpperCase());
//		                }
//		            }).setPrettyPrinting().create();
//			
//			FirstName childs = gson.fromJson(json, FirstName.class);
//			System.out.println(childs);
			
			
			
			
			// This is for the clean format dataset
			String json = new String(Files.readAllBytes(Paths.get("C:\\Users\\ChangJI19\\Documents\\Gson\\PopularFirstNames.json")));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Child[] childs = gson.fromJson(json, Child[].class);
			for (Child x : childs) {
				System.out.println(x);
			}
			
		}
		catch (IOException e) {
			System.out.println("no");
			return;
		}
		
	}
}
