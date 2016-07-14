package com.blank.root.buku;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blank.root.buku.Adapter.AdapterArticel;
import com.blank.root.buku.Helper.RealmHelper;
import com.blank.root.buku.Model.ArticelModel;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<ArticelModel> data;
    private ImageButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set();
    }

    public void set() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        //////////////////////////////

        ///////////
        data = new ArrayList<>();
        helper = new RealmHelper(MainActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.rvArticle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fb = (ImageButton) findViewById(R.id.fbnew);
        fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainNew.class));
                finish();
            }
        });
        setRecylerView();
    }
    private void setRecylerView() {
        try{
            data = helper.findAllArticel();
        }catch (Exception e){
            e.printStackTrace();
        }
        AdapterArticel adapter = new AdapterArticel(data, new AdapterArticel.OnItemClickListener(){
            public void onClick(ArticelModel item){
//                startActivity(new Intent(getApplicationContext(), keterangan.class));
                Intent i = new Intent(getApplicationContext(), MainNew2.class);
                i.putExtra("id", item.getId());
                i.putExtra("title", item.getTitle());
                i.putExtra("descripsi", item.getDescripsi());
                startActivity(i);
                finish();
            }
        });
        recyclerView.setAdapter(adapter);
    }
    protected void onResume(){
        super.onResume();
        try{
            data = helper.findAllArticel();
        }catch (Exception e){
            e.printStackTrace();
        }
        setRecylerView();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
