package com.gilangwinduasmara.simplenewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewsActivity extends AppCompatActivity {
    EditText editTextTitle, editTextBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_news);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextBody = findViewById(R.id. editTextBody);
    }

    public void submit(View view){
        Intent i = new Intent();
        if(editTextTitle.getText().toString().trim().isEmpty() || editTextBody.getText().toString().trim().isEmpty()){
            Toast.makeText(this, R.string.ERROR_FIELDS_REQUIRED, Toast.LENGTH_SHORT).show();
            return;
        }
        i.putExtra(MainActivity.CREATED_NEWS, new News(editTextTitle.getText().toString(), editTextBody.getText().toString()));
        setResult(MainActivity.RESULT_OK, i);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}