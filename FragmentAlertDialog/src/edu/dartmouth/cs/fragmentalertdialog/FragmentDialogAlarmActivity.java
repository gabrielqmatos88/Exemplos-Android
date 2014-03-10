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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Demonstrates how to show an AlertDialog that is managed by a Fragment.
 */

public class FragmentDialogAlarmActivity extends Activity {

	OnClickListener cListener;
	static Dialog dialog;
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
				createDialog();
			}
		});
	}
	
	void createDialog()
	{
		dialog = new Dialog(this);
	    dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
	    dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    // layout to display
	    dialog.setContentView(R.layout.dialog_view);
//	    dialog.setContentView();
	    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
	    Button bt_refresh = (Button) dialog.findViewById(R.id.btRefresh);
	    bt_refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	    dialog.show();
	    ImageView image = (ImageView)dialog.findViewById(R.id.imageView1);
	    /*RotateAnimation anim = new RotateAnimation(0f, 360f, width, height);
	    anim.setInterpolator(new LinearInterpolator());
	    anim.setRepeatCount(Animation.INFINITE);
	    anim.setDuration(700);*/
	    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_image);
	    image.startAnimation(anim);
	}
	
	View inflateView ()
	{
		LayoutInflater inflater = LayoutInflater.from(this);
		View v = inflater.inflate(R.layout.dialog_view, null);
		Button btRefresh = (Button)v.findViewById(R.id.btRefresh);
		
		return v;
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
			//TextView text = (TextView)v.findViewById(R.id.text);
			Button btRefresh = (Button)v.findViewById(R.id.btRefresh);
			//ImageView image = (ImageView)v.findViewById(R.id.imageView1);
			
			if(clickListener != null)
			{
				btRefresh.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						dismiss();
					}
				});
			}
			Dialog dialog = new AlertDialog.Builder(getActivity())
					.setView(v)
					.create();
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

			return dialog ;
		}
	}

}
