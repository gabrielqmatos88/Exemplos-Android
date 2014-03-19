package app.copa.manausplace.json.parsers;

import java.util.ArrayList;
import java.util.Arrays;

import app.copa.manausplace.models.Categoria;

import com.google.gson.Gson;

public class CategoriaJsonParser extends JsonObjectParser<Categoria> {

	Gson conversor;

	public CategoriaJsonParser() {
		conversor = new Gson();
	}

	@Override
	public Categoria objectFromJson(String json) {
		return conversor.fromJson(json, Categoria.class);
	}

	@Override
	public ArrayList<Categoria> collectionFromJson(String json) {
		return new ArrayList<Categoria>(Arrays.asList(conversor.fromJson(json,
				Categoria[].class)));
	}
}
