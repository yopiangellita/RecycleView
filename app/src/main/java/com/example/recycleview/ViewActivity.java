package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewActivity extends AppCompatActivity {
    ActionBar actionBar;
    TextView tvBPName,tvBPS;
    ImageView imgBPlogo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_item_view);
        actionBar =getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvBPName=findViewById(R.id.buah_name);
        tvBPS=findViewById(R.id.buah_description);
        imgBPlogo=findViewById(R.id.image_buah);

        String name= getIntent().getStringExtra("name");
        String S=getIntent().getStringExtra("s");
        int logo=getIntent().getIntExtra("logo",R.mipmap.ic_launcher);

        tvBPName.setText(name);
        tvBPS.setText(S);
        imgBPlogo.setImageResource(logo);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}