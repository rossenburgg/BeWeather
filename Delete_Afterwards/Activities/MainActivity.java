package com.bsu.beweather.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.bsu.beweather.Adapters.HourlyAdapter;
import com.bsu.beweather.Domains.Hourly;
import com.bsu.beweather.R;
import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterhourly;
    private RecyclerView recyclerView;

    private LottieAnimationView lottieAnimationView;
    private ImageView imageView;

    private boolean isBearImagePressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRecycleview();
    }

    private void initViews() {
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        imageView = findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBearImagePressed = !isBearImagePressed;
                toggleBearAnimation(isBearImagePressed);
            }
        });
    }

    private void toggleBearAnimation(boolean isPressed) {
        if (isPressed) {
            // Show the LottieAnimationView and hide the ImageView
            imageView.setVisibility(View.GONE);
            lottieAnimationView.setVisibility(View.VISIBLE);

            // Set animation from the raw folder
            lottieAnimationView.setAnimation(R.raw.bear);
            lottieAnimationView.playAnimation();

            // Play bear sound
            playBearSound();
        } else {
            // Show the ImageView and hide the LottieAnimationView
            imageView.setVisibility(View.VISIBLE);
            lottieAnimationView.setVisibility(View.GONE);
        }
    }

    private void playBearSound() {
        // Use MediaPlayer to play the bear sound
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.monsterbear);
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Release the MediaPlayer resources after playback completes
                    mp.release();
                }
            });
            mediaPlayer.start();
        }
    }





    private void initRecycleview() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("9PM", 28, "sunny"));
        items.add(new Hourly("10PM", 29, "rainy"));
        items.add(new Hourly("11PM", 30, "partly_cloudy"));
        items.add(new Hourly("12PM", 31, "lightning"));
        items.add(new Hourly("1AM", 32, "rainy"));
        items.add(new Hourly("1AM", 33, "partly_cloudy"));
        items.add(new Hourly("1AM", 34, "sunny"));
        items.add(new Hourly("1AM", 35, "lightning"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterhourly=new HourlyAdapter(items);
        recyclerView.setAdapter(adapterhourly);
    }
}
