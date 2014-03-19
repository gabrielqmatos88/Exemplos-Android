package app.copa.manausplace.components;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WebImageView extends ImageView {

    private Drawable placeholder, image;

    public WebImageView(Context context) {
        super(context);
    }
    public WebImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public WebImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setPlaceholderImage(Drawable drawable) {
        placeholder = drawable;
        if (image == null) {
            setImageDrawable(placeholder);
        }
    }
    public void setPlaceholderImage(int resid) {
        placeholder = getResources().getDrawable(resid);
        if (image == null) {
            setImageDrawable(placeholder);
        }
    }

    public void setImageUrl(String url) {
        DownloadTask task = new DownloadTask();  
        task.execute(url);
    }

    private class DownloadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            try {
                URLConnection conn = (new URL(url)).openConnection();
                InputStream is = conn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);

                ByteArrayBuffer baf = new ByteArrayBuffer(50); 
                int current = 0;
                while ((current=bis.read()) != -1) {
                    baf.append((byte)current);
                }

                byte[] imageData = baf.toByteArray();
                return BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {
   
            if (result != null) {
            	setImageBitmap(result);
            }
        }
    }
}
