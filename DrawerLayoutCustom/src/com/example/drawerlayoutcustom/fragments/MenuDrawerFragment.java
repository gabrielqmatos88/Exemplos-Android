package com.example.drawerlayoutcustom.fragments;

import com.example.drawerlayoutcustom.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuDrawerFragment extends Fragment {

	public MenuDrawerFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_menu, null);
		return rootView;
	}

}
