package app.copa.manausplace.json.parsers;

import java.util.ArrayList;


public abstract class JsonObjectParser<T> {

	public abstract T objectFromJson(String json);
	
	public abstract ArrayList<T> collectionFromJson(String json);
	
//	public abstract String toJson(T object);
//	
//	public abstract String collectionToJson(ArrayList<T> collection);
	
}
