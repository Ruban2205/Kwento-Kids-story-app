package in.rubangino.kwento.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import in.rubangino.kwento.BuildConfig;
import in.rubangino.kwento.R;

public class DeveloperSite extends AppCompatActivity {

    WebView webView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.search_and_exit_for_other_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.showShare){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, This app has amazing stories to entertain your kids. I've recommended you to download this app now: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

            return true;
        }
        else if (item.getItemId() == R.id.showExit){

            finish();

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_site);

        webView = findViewById(R.id.developerSite);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.rubangino.in/");

        //get action bar title
        getSupportActionBar().setTitle("DEVELOPER SITE");

        //display back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}