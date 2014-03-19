package app.copa.manausplace.activities;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import app.copa.manausplace.R;
import app.copa.manausplace.adapters.CategoriasGridAdapter;
import app.copa.manausplace.fragments.GridCategoriaFragment;
import app.copa.manausplace.fragments.GridCategoriaFragment.OnViewStateReadyListener;
import app.copa.manausplace.fragments.WaitLoadingFragment;
import app.copa.manausplace.json.parsers.CategoriaJsonParser;
import app.copa.manausplace.models.Categoria;

public class GridActivity extends ActionBarActivity  implements OnViewStateReadyListener {

	static final String URL = "http://gqmclass.com/api/categorias/?idioma=0";
	GridView grid;
	CategoriasGridAdapter adapter;
	ArrayList<Categoria> categorias;
	Dialog dialog;
	GridCategoriaFragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new WaitLoadingFragment()).commit();
			getCategorias();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void getCategorias() {
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(30);
		client.get(URL, new AsyncHttpResponseHandler() {
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] response, Throwable arg3) {

				aoFalharCarregamento();
				super.onFailure(statusCode, headers, response, arg3);
			}

			@Override
			public void onSuccess(int statusCode, Header[] arg1, byte[] response) {

				if (statusCode == 200) {
					try {
						categorias = new CategoriaJsonParser()
								.collectionFromJson(new String(response,
										"UTF-8"));
						fragment = new GridCategoriaFragment();
						fragment.setOnViewStateReadyListener(GridActivity.this);
						getSupportFragmentManager()
						.beginTransaction()
								.replace(R.id.container, fragment)
								.commit();
						//fragment.preencherCategorias(categorias);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				super.onSuccess(statusCode, arg1, response);
			}
		});
	}

	private void aoFalharCarregamento() {

		Toast.makeText(this, "Falha ao carregar", Toast.LENGTH_LONG).show();
		dialog = new AlertDialog.Builder(this).setTitle("Falha ao carregar")
				.setMessage("Deseja tentar novamente?").setCancelable(false)
				.setPositiveButton("Sim", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						getCategorias();
					}
				}).setNegativeButton("Não", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						finish();
					}
				}).create();
		dialog.show();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_grid_view,
					container, false);
			return rootView;
		}
	}

	@Override
	public void viewIsReady() {
		
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				fragment.preencherCategorias(categorias);
			}
		});
	}

}
