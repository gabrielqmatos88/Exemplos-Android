package app.copa.manausplace.models;

import com.google.gson.annotations.SerializedName;

public class Categoria {

	@SerializedName("id")
	public int id;
	
	@SerializedName("descricao")
	public String descricao;
	
	@SerializedName("idioma")
	public int idioma;
	
	@SerializedName("url_img")
	public String url_img;

	public Categoria() {

	}
}
