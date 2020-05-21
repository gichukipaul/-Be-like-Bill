package io.alienlabs.gichukipaul.belikebill;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import cn.pedant.SweetAlert.SweetAlertDialog;

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
                ts();
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
       // swipeRefreshLayout.setRefreshing(false);
    }
    public  void ts(){
        imageView1.setBackgroundColor(Color.parseColor("#00ff00"));
        Picasso.get().load("https://belikebill.ga/billgen-API.php?default=1")
                .into(imageView1);
        swipeRefreshLayout.setRefreshing(false);
    }

}
