package src.com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
	static Map<String,ArrayList<String>> data = new  HashMap<String,ArrayList<String>>();
	public static void insert(String src, String dest){
		ArrayList<String> list = new ArrayList<String>();
		if(data.containsKey(src)){
			data.get(src).add(0,dest);
		}
		else{
			list.add(0,dest);
			data.put(src,list);
		}
	}

    public static Map<String,ArrayList<String>> getDBFromFile(String fileName) throws Exception {
        String file = "";
        try{
            file = MyReader.readFile(fileName);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        String[] lines = file.trim().split("\n");
        for(String city : lines){
          String src = city.split(",")[0];
          String dest = city.split(",")[1];
          insert(src.trim(), dest.trim());
        }
        return data;
    }
	public String toString(){
		return data.toString();
	}
}
