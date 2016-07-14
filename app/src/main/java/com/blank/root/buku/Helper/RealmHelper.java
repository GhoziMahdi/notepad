package com.blank.root.buku.Helper;

import android.util.Log;
import android.view.ContextMenu;
import android.widget.Toast;

import com.blank.root.buku.MainActivity;
import com.blank.root.buku.Model.ArticelModel;
import com.blank.root.buku.MainNew;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import android.content.Context;

/**
 * Created by root on 22/06/16.
 */
public class RealmHelper {
    private static final String TAG = "RealmHelper";

    private Realm realm;
    private RealmResults<Articel> realmResults;

    public Context context;
    public RealmHelper(Context context){
        realm = Realm.getInstance(context);
        this.context = context;
    }
    public void addArtikel(String title,String descripsi){
        Articel articel = new Articel();
        articel.setId((int)(System.currentTimeMillis()/1000));
        articel.setTitle(title);
        articel.setDescripsi(descripsi);

        realm.beginTransaction();
        realm.copyToRealm(articel);
        realm.commitTransaction();

        showLog("Add :" + title);
        showToast(title + " " + "Berhasil disimpan.");
    }
    public ArrayList<ArticelModel> findAllArticel(){
        ArrayList<ArticelModel> data = new ArrayList<ArticelModel>();

        realmResults = realm.where(Articel.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);

        if(realmResults.size() > 0){
            showLog("Size :" + realmResults.size());

            for(int i = 0;i < realmResults.size();i++){
                String title,descripsi;
                int id = realmResults.get(i).getId();
                title = realmResults.get(i).getTitle();
                descripsi = realmResults.get(i).getDescripsi();
                data.add(new ArticelModel(id,title,descripsi));
            }
        }else{
            showLog("Size : 0");
            showToast("Note Kosong");
        }
        return (data);
    }
    public void updateArticel(int id,String title){
        realm.beginTransaction();
        Articel articel = realm.where(Articel.class).equalTo("id",id).findFirst();
        articel.setTitle(title);
        realm.commitTransaction();
        showLog("Updated:" + title);
        showToast(title + " " + "berhasil diupdate");
    }
    public void updateArticel(int id,String title,String descripsi){
        realm.beginTransaction();
        Articel articel = realm.where(Articel.class).equalTo("id",id).findFirst();
        articel.setTitle(title);
        articel.setDescripsi(descripsi);
        realm.commitTransaction();
        showLog("Updated:" + title);
        showToast(title + " " +"berhasil diupdate");
    }
    public void deleteData(int id){
        RealmResults<Articel> dataDesults = realm.where(Articel.class).equalTo("id",id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
        dataDesults.removeLast();
        dataDesults.clear();
        realm.commitTransaction();

        showLog("Hapus data berhasil");
    }
    private void showLog(String s){
        Log.d(TAG, s);
    }
    private void showToast(String s){
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
}
