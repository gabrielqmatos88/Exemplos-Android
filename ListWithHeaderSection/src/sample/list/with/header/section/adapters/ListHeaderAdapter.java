package sample.list.with.header.section.adapters;

import java.util.ArrayList;
import java.util.zip.Inflater;

import sample.list.with.header.section.R;
import sample.list.with.header.section.models.ItemList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListHeaderAdapter extends BaseAdapter {

	Context contexto;
	ArrayList<ItemList> itens;

	public ListHeaderAdapter(Context c, ArrayList<ItemList> list) {
		contexto = c;
		itens = list;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int posicao) {
		return itens.get(posicao);
	}

	@Override
	public long getItemId(int posicao) {
		return 0;
	}

	@Override
	public View getView(int posicao, View view, ViewGroup viewGroup) {
		ViewHolder holder = null;
		if (view != null) {

			holder = (ViewHolder) view.getTag();

		} else {
			
			holder = new ViewHolder();
			view = LayoutInflater.from(contexto).inflate(R.layout.list_item, null);
			holder.headerLayout = (RelativeLayout)view.findViewById(R.id.headerLayout);
			holder.sectionLayout = (RelativeLayout)view.findViewById(R.id.sectionLayout);
			holder.headerText = (TextView)view.findViewById(R.id.headerText);
			holder.sectionText = (TextView)view.findViewById(R.id.sectionText);
			view.setTag(holder);

		}
		holder.setValues(itens.get(posicao));
		return view;
	}

	static class ViewHolder {
		public TextView headerText, sectionText;
		public RelativeLayout headerLayout, sectionLayout;

		public void setValues(ItemList item) {
			if (item.isHeader()) {
				headerLayout.setVisibility(RelativeLayout.VISIBLE);
				sectionLayout.setVisibility(RelativeLayout.GONE);
				headerText.setText(item.getText());
			} else {
				headerLayout.setVisibility(RelativeLayout.GONE);
				sectionLayout.setVisibility(RelativeLayout.VISIBLE);
				sectionText.setText(item.getText());
			}
		}
	}

}
