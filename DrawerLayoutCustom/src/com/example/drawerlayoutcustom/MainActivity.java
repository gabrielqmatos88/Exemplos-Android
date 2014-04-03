package com.example.drawerlayoutcustom;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	DrawerLayout drawerLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindView();
		
	}
	
	private void bindView()
	{
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
