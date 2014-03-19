package app.copa.manausplace.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.copa.manausplace.R;
import app.copa.manausplace.components.WebImageView;
import app.copa.manausplace.image.ImageLoader;
import app.copa.manausplace.image.ImageLoader.NotifierImageLoaded;
import app.copa.manausplace.models.Categoria;

public class CategoriasGridAdapter extends BaseAdapter  {

	Context contexto;
	ArrayList<Categoria> categorias;
	NotifierImageLoaded viewUpdater;
	
	public CategoriasGridAdapter(Context c, ArrayList<Categoria> lista , NotifierImageLoaded updater) {
		contexto = c;
		categorias = lista;
		viewUpdater = updater;
	}

	@Override
	public int getCount() {
		return categorias.size();
	}

	@Override
	public Object getItem(int posicao) {
		
		return categorias.get(posicao);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	
	public void AtualizarLista(ArrayList<Categoria> list)
	{
		if(list != null)
		{
			categorias.clear();
			categorias.addAll(list);
			notifyDataSetChanged();
		}
	}

	@Override
	public View getView(int posicao, View view, ViewGroup arg2) {
	
		ViewHolder holder = null;
		if(view != null)
		{
			holder = (ViewHolder)view.getTag();
		}else
		{
			LayoutInflater inflater = LayoutInflater.from(contexto);
			view = inflater.inflate(R.layout.grid_item, null);
			holder = new ViewHolder();
			holder.text = (TextView)view.findViewById(R.id.text);
			holder.img = (WebImageView)view.findViewById(R.id.img);
			//holder.img.setPlaceholderImage(R.drawable.ic_launcher);
			view.setTag(holder);
		}
		holder.setValues(categorias.get(posicao));
		return view;
	}
	
	
	static class ViewHolder
	{
		public TextView text;
		public WebImageView img;
		//public ImageLoader loader;

		public void setValues(Categoria categoria)
		{
			Log.i("Url para consulta", categoria.url_img);
			text.setText(categoria.descricao);
			img.setImageUrl(categoria.url_img);
			//loader.DisplayImage(categoria.url_img, R.drawable.ic_launcher, img);
		}
	}
	
}
