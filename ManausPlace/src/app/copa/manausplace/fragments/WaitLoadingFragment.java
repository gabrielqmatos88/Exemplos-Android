package app.copa.manausplace.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import app.copa.manausplace.R;

public class WaitLoadingFragment extends Fragment {

	ImageView imgView;
	public WaitLoadingFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.wait_loading_fragment, null);
		imgView = (ImageView)root.findViewById(R.id.waitImage);
		Animation anim = AnimationUtils.loadAnimation(
				getActivity().getApplicationContext(), R.anim.rotate_image);
		imgView.startAnimation(anim);
		return root;
	}

}
