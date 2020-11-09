package in.rubangino.kwento.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import in.rubangino.kwento.R;

public class DetailsOfTheStory extends AppCompatActivity {

    //variable declaration
    TextView storyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_the_story);

        //hooks
        storyContent = findViewById(R.id.contentOfStory);

        //Receive data through intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("titleOfStory");
        String content = intent.getStringExtra("contentOfStory");

        //set the app bar title
        getSupportActionBar().setTitle(title);

        //set the content of the Story to textView
        storyContent.setText(content);

        //set scrolling movement method
        storyContent.setMovementMethod(new ScrollingMovementMethod());

        //enable back button in details activity to home activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}