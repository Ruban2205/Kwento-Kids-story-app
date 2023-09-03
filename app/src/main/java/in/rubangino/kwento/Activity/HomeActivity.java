package in.rubangino.kwento.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

import in.rubangino.kwento.BuildConfig;
import in.rubangino.kwento.R;

public class HomeActivity extends AppCompatActivity {

    //Variable
    RecyclerView recyclerView;
    //Adapter Variable
    Adapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_items, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.share){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, This app has amazing stories to entertain your kids. I've recommended you to download this app now: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

            return true;
        }
        else if (item.getItemId() == R.id.tips){

            PermissionListener tipsPermission = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(HomeActivity.this, "Please Wait...", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(HomeActivity.this, Tips.class);
                    startActivity(intent);
                }

                @Override
                public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                    Toast.makeText(HomeActivity.this, "Please Check Your Connection...", Toast.LENGTH_LONG).show();
                }
            };

            TedPermission.with(HomeActivity.this)
                    .setPermissionListener(tipsPermission)
                    .setPermissions(Manifest.permission.INTERNET)
                    .check();
            return true;
        }

        else if (item.getItemId() == R.id.visit_site){

            PermissionListener developerSite = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(HomeActivity.this, "Please Wait...", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(HomeActivity.this, DeveloperSite.class);
                    startActivity(intent);
                }

                @Override
                public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                    Toast.makeText(HomeActivity.this, "Check your connection...", Toast.LENGTH_LONG).show();
                }
            };

            TedPermission.with(HomeActivity.this)
                    .setPermissionListener(developerSite)
                    .setPermissions(Manifest.permission.INTERNET)
                    .check();

            return true;
        }

        else if (item.getItemId() == R.id.feedback){
            Log.d(" ", "Send Email: ");
            String[] TO_EMAILS = {"app.feedback.rubancreations@gmail.com"};

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);

            intent.putExtra(Intent.EXTRA_SUBJECT, "Set your issue as Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Elaborate your issue here...");

            startActivity(Intent.createChooser(intent, "choose your mail client..."));

            return true;
        }
        else if (item.getItemId() == R.id.privacyPolicy){

            PermissionListener privacy = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(HomeActivity.this, "Please Wait...", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(HomeActivity.this, PrivacyPolicy.class);
                    startActivity(intent);
                }

                @Override
                public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                    Toast.makeText(HomeActivity.this, "Check your connection...", Toast.LENGTH_LONG).show();
                }
            };

            TedPermission.with(HomeActivity.this)
                    .setPermissionListener(privacy)
                    .setPermissions(Manifest.permission.INTERNET)
                    .check();

            return true;
        }
        
        else if (item.getItemId() == R.id.exit){
            Toast.makeText(HomeActivity.this, "Hey!! Thanks for using Kwento.", Toast.LENGTH_LONG).show();
            finish();
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //Call the String array form strings.xml
        String[] title = getResources().getStringArray(R.array.storyTitles);
        String[] content = getResources().getStringArray(R.array.stories);
        String[] number = getResources().getStringArray(R.array.storyNumber);

        //recycler view Hooks
        recyclerView = findViewById(R.id.storyListView);

        //set layout manager for recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //call adapter titles and contents
        adapter = new Adapter(this, title, content, number);
        recyclerView.setAdapter(adapter);
    }
}