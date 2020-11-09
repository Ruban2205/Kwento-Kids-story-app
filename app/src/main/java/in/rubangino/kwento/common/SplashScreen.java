package in.rubangino.kwento.common;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import in.rubangino.kwento.Activity.HomeActivity;
import in.rubangino.kwento.R;

public class SplashScreen extends AppCompatActivity {

    public static int SPLASH_SCREEN = 5000;

    //Variables
    ImageView imageView;
    TextView title, slogan, coprText;
    Animation top_animation, bottom_animation, fadein_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //Hooks
        imageView = findViewById(R.id.appImage);
        title = findViewById(R.id.title);
        slogan = findViewById(R.id.slogan);
        coprText = findViewById(R.id.coprightText);

        //hooks for Animations
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        fadein_animation = AnimationUtils.loadAnimation(this,R.anim.fadein_animation);

        //set animations
        imageView.setAnimation(top_animation);
        title.setAnimation(bottom_animation);
        slogan.setAnimation(bottom_animation);
        coprText.setAnimation(fadein_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}