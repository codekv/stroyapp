package com.tarun.storytale;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StoriesActivity extends AppCompatActivity {
        TextView Story_text;
        Toolbar toolbar;
        String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        Story_text = findViewById(R.id.Story_text);
        Intent i = getIntent();
        String title = i.getStringExtra("title");
        getSupportActionBar().setTitle(title);
        content = i.getStringExtra("contents");
        Story_text.setText(content);
        Story_text.setMovementMethod(new ScrollingMovementMethod());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.story_activity_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.copy_btn:
                copyText();
            case R.id.share_btn:
                shareIt();
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
    private void copyText() {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("txt",content);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(this, "Text copied successfully", Toast.LENGTH_SHORT).show();
    }
    private void shareIt() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT,content);
        sharingIntent = Intent.createChooser(sharingIntent,"Share via");
        startActivity(sharingIntent);
    }
}
