package app.copa.manausplace.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import app.copa.manausplace.R;
import app.copa.manausplace.adapters.CategoriasGridAdapter;
import app.copa.manausplace.image.ImageLoader.NotifierImageLoaded;
import app.copa.manausplace.models.Categoria;

public class GridCategoriaFragment extends Fragment implements NotifierImageLoaded {

	GridView grid;
	CategoriasGridAdapter adapter;
	ArrayList<Categoria> categorias;
	OnViewStateReadyListener listener;

	public GridCategoriaFragment() {
		// TODO Auto-generated constructor stub
	}
	
	public void  setOnViewStateReadyListener(OnViewStateReadyListener listener)
	{
		if(listener != null)
		{
			this.listener = listener;
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_grid_view, null,false);
		grid = (GridView)rootView.findViewById(R.id.categoriasGrid);
		adapter = new CategoriasGridAdapter(getActivity().getApplicationContext(),new ArrayList<Categoria>(), this );
		grid.setAdapter(adapter);
		listener.viewIsReady();
		return rootView;
	}
	
	public void preencherCategorias(ArrayList<Categoria> lista) {
		adapter.AtualizarLista(lista);
	}
	
	public interface OnViewStateReadyListener
	{
		void viewIsReady();
	}

	@Override
	public void atualizarView() {
		
	}
}
