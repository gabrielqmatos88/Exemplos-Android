package app.copa.manausplace.image;

import android.graphics.Bitmap;

public class ImageScaleUtil {

	public static Bitmap ScaleBitmap(Bitmap bm, float scalingFactor) {
		int scaleHeight = (int) (bm.getHeight() * scalingFactor);
		int scaleWidth = (int) (bm.getWidth() * scalingFactor);

		return Bitmap.createScaledBitmap(bm, scaleWidth, scaleHeight, true);
	}
}
