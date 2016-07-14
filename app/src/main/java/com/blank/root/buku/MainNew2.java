package com.blank.root.buku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.blank.root.buku.Helper.RealmHelper;
import com.blank.root.buku.Model.ArticelModel;

import java.util.ArrayList;

/**
 * Created by root on 24/06/16.
 */
public class MainNew2 extends AppCompatActivity {
    private int position;
    private ImageButton save;
    private EditText inputTitle, inputDescripsi;
    private RealmHelper helper;
    private String title, descripsi;
    private String intentTitle, intentDescripsi;
    private ArrayList<ArticelModel> data;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_reply_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
        toolbar.setTitle("Edit Note");

        helper = new RealmHelper(MainNew2.this);
        data = new ArrayList<>();
        position = getIntent().getIntExtra("id", 0);
        intentTitle = getIntent().getStringExtra("title");
        intentDescripsi = getIntent().getStringExtra("descripsi");

        save = (ImageButton) findViewById(R.id.fbsave);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                title = inputTitle.getText().toString();
                descripsi = inputDescripsi.getText().toString();

                helper.updateArticel(position, title, descripsi);

                startActivity(new Intent(MainNew2.this, MainActivity.class));
                finish();
            }
        });
        inputTitle = (EditText) findViewById(R.id.formtitle);
        inputDescripsi = (EditText) findViewById(R.id.formcode);
        inputTitle.setText(intentTitle);
        inputDescripsi.setText(intentDescripsi);
    }
}
