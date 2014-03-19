package sample.list.with.header.section;

import java.util.ArrayList;

import sample.list.with.header.section.adapters.ListHeaderAdapter;
import sample.list.with.header.section.models.HeaderItem;
import sample.list.with.header.section.models.ItemList;
import sample.list.with.header.section.models.SectionItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SampleFragment extends Fragment {

	ListView lista;
	ListHeaderAdapter adapter;
	ArrayList<ItemList> itens;

	public SampleFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_principal, null,
				false);
		lista = (ListView) rootView.findViewById(R.id.listView);
		itens = new ArrayList<ItemList>();
		preencherItens();
		adapter = new ListHeaderAdapter(getActivity().getApplicationContext(),
				itens);
		lista.setAdapter(adapter);
		return rootView;
	}

	private void preencherItens() {
		addHeader("Pessoas");
		addSection("Gabriel");
		addSection("Samantha");
		addSection("Jéssica");
		addSection("Jocyneide");
		addSection("Luis");
		addHeader("Frutas");
		addSection("Goiaba");
		addSection("Laranja");
		addSection("Maracuja");
		addSection("Acerola");
		addHeader("Objetos");
		addSection("Lápis");
		addSection("Caneta");
		addSection("Apontador");
		addSection("Borracha");
	}

	private void addHeader(String text) {
		itens.add(new HeaderItem(text));
	}

	private void addSection(String text) {
		itens.add(new SectionItem(text));
	}

}
