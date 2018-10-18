package com.antor.aspire.galaxy1;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    LinearLayout linearLayouthorizontal;
    ImageSwitcher imgswitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linearLayouthorizontal=(LinearLayout)findViewById(R.id.linear_layout_horizontal);
        imgswitcher= (ImageSwitcher) findViewById(R.id.imgswitcher);

        imgswitcher.setFactory((ViewSwitcher.ViewFactory) MainActivity.this);

        imgswitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        imgswitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));

        for (int index = 0; index < Galaxy.galaxyImages.length; index++) {
            final int i = index;
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Galaxy.galaxyImages[index]);
            letsSetlayoutParamsForImageView(imageView);
            imageView.setPadding(100, 100, 100, 100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgswitcher.setImageResource(Galaxy.galaxyImages[i]);
                    Toast.makeText(MainActivity.this, "This is " + Galaxy.galaxyNames[i],
                            Toast.LENGTH_SHORT).show();
                }
            });
            linearLayouthorizontal.addView(imageView);


        }
    }
    public void letsSetlayoutParamsForImageView(ImageView imageView){

        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }

    @Override
    public View makeView() {
        ImageView imgView = new ImageView(MainActivity.this);
        imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return imgView;
    }
}
