package io.alienlabs.gichukipaul.belikebill;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.swipe);
        imageView1 = findViewById(R.id.img);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // task ts = new task();
                // ts.execute();
                ts();
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        swipeRefreshLayout.setRefreshing(false);
    }

    public void ts() {
        imageView1.setBackgroundColor(Color.parseColor("#00ff00"));
        Picasso.get().load("https://belikebill.ga/billgen-API.php?default=1")
                .into(imageView1);
        swipeRefreshLayout.setRefreshing(false);
    }


    /*
    public class task extends AsyncTask<Void, Void, Bitmap> {
        ImageLoader imageLoader;
        SweetAlertDialog pDialog;

        @Override

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {

            imageLoader = ImageLoader.getInstance();
            //returns a bitmap
            return imageLoader.loadImageSync("https://belikebill.ga/billgen-API.php?default=1");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            //pDialog.dismissWithAnimation();
            imageView1.setImageBitmap(bitmap);
        }
    }
    */


}
