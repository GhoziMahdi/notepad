package com.blank.root.buku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.blank.root.buku.Helper.RealmHelper;
import com.blank.root.buku.Model.ArticelModel;
import java.util.ArrayList;

/**
 * Created by root on 23/06/16.
 */
public class MainNew extends AppCompatActivity{
    ///////////////////////////////
    private RealmHelper realmHelper;
    private EditText inputTitle,inputDescripsi;
    private ImageButton save;
    ///////////////////////////////
    private Toolbar toolbar;
    private ImageButton imagebutton;
    private EditText formtitle,formcode;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);


        set();
        data();
    }
    ///////////////////////////////////////////
    public void set(){
        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_reply_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });


    }

    private void data() {
        realmHelper = new RealmHelper(MainNew.this);

        inputTitle = (EditText) findViewById(R.id.formtitle);
        inputDescripsi = (EditText)findViewById(R.id.formcode);
        save = (ImageButton)findViewById(R.id.fbsave);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(inputTitle.getText().toString().isEmpty()){
                    inputTitle.setError("Tiitle Not Found");
                }else {
                    String title, descripsi;
                    title = inputTitle.getText().toString();
                    descripsi = inputDescripsi.getText().toString();
                    realmHelper.addArtikel(title, descripsi);
                    Intent i = new Intent(MainNew.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }


}
