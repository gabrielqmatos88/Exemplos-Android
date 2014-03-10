/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.dartmouth.cs.fragmentalertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Demonstrates how to show an AlertDialog that is managed by a Fragment.
 */

public class FragmentDialogAlarmActivity extends Activity {

	OnClickListener cListener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_dialog_alarm);

		View tv = findViewById(R.id.text);
		((TextView) tv)
				.setText("Example of displaying an alert dialog with a DialogFragment");
		
		cListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
			}
		};

		// Watch for button clicks.
		Button button = (Button) findViewById(R.id.show);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog();
			}
		});
	}

	void showDialog() {
		DialogFragment newFragment = MyAlertDialogFragment
				.newInstance(R.string.alert_dialog_two_buttons_title,cListener);
		newFragment.show(getFragmentManager(), "dialog");
	}

	public void doPositiveClick() {
		// Do stuff here.
		Log.i("FragmentAlertDialog", "Positive click!");
	}

	public void doNegativeClick() {
		// Do stuff here.
		Log.i("FragmentAlertDialog", "Negative click!");
	}

	public static class MyAlertDialogFragment extends DialogFragment {

		static OnClickListener clickListener;
		public static MyAlertDialogFragment newInstance(int title,OnClickListener cListener) {
			MyAlertDialogFragment frag = new MyAlertDialogFragment();
			Bundle args = new Bundle();
			args.putInt("title", title);
			frag.setArguments(args);
			clickListener = cListener;
			return frag;
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			int title = getArguments().getInt("title");
			
			LayoutInflater inflater = LayoutInflater.from(getActivity());
			View v = inflater.inflate(R.layout.dialog_view, null);
			TextView text = (TextView)v.findViewById(R.id.text);
			Button btRefresh = (Button)v.findViewById(R.id.btRefresh);
			ImageView image = (ImageView)v.findViewById(R.id.imageView1);
			
			if(clickListener != null)
			{
				btRefresh.setOnClickListener(clickListener);
			}

			return new AlertDialog.Builder(getActivity()).setView(v).create();
		}
	}

}
