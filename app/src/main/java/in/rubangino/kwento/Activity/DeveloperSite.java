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
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_TEXT,"https://ruban-app-creations.blogspot.com/");
            startActivity(Intent.createChooser(sharingIntent, "share using..."));

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
        webView.loadUrl("https://ruban-app-creations.blogspot.com/");

        //get action bar title
        getSupportActionBar().setTitle("DEVELOPER SITE");

        //display back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}