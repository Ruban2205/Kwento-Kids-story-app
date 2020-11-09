package in.rubangino.kwento.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import in.rubangino.kwento.R;

public class Tips extends AppCompatActivity {

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
            sharingIntent.putExtra(Intent.EXTRA_TEXT,"https://this-is-ruban.blogspot.com/2020/09/tips-to-reading-stories-with-kwento.html");
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
        setContentView(R.layout.activity_tips);

        webView = findViewById(R.id.tipsInWeb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://this-is-ruban.blogspot.com/2020/09/tips-to-reading-stories-with-kwento.html");

        //get window title
        getSupportActionBar().setTitle("TIPS");

        //parent activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}