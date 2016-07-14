//package com.blank.root.buku;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.blank.root.buku.Adapter.AdapterArticel;
//import com.blank.root.buku.Helper.RealmHelper;
//import com.blank.root.buku.Model.ArticelModel;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;
//
///**
// * Created by root on 28/06/16.
// */
//public class keterangan extends AppCompatActivity{
//
//    private Toolbar toolbar;
//    private TextView textView;
//    private Button button;
//    private RealmHelper helper;
//    private ArrayList<ArticelModel> data;
//
//    protected void onCreate(Bundle savedInstaceState) {
//        super.onCreate(savedInstaceState);
//        setContentView(R.layout.showket);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar3);
//        toolbar.setTitle("Deskripsi");
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_reply_black_24dp));
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });
//        textView = (TextView)findViewById(R.id.txt_edit);
//        button = (Button)findViewById(R.id.btn_edit);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                aksi();
//            }
//        });
//        aksi();
//    }
//
//    public void aksi() {
//        data = new ArrayList<>();
//        helper = new RealmHelper(keterangan.this);
//                try {
//                    data = helper.findAllArticel();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                AdapterArticel adapter = new AdapterArticel(data, new AdapterArticel.OnItemClickListener() {
//                    public void onClick(ArticelModel item) {
//                        Intent i = new Intent(getApplicationContext(), MainNew2.class);
//                        i.putExtra("id", item.getId());
//                        i.putExtra("title", item.getTitle());
//                        i.putExtra("descripsi", item.getDescripsi());
//                        startActivity(i);
//                        finish();
//                    }
//                });
//    }
//    protected void onResume(){
//        super.onResume();
//        try{
//            data = helper.findAllArticel();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        aksi();
//    }
//}
