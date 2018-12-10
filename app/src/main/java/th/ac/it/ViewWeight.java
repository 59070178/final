package th.ac.it;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewWeight extends Fragment {

    ArrayList<Weight> arrayList = new ArrayList<>();
    String cDate,cWeight;
    private SQLiteDatabase database;

    private ListView listView;
    private ViewAdapter viewAdapter;

    @Nullable
    @Override

    public View onCreateView
            (@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container,
             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview, container, false);
    }

    @Override
    public void onActivityCreated
            (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        listView = getView().findViewById(R.id.list);
        viewAdapter = new ViewAdapter(getActivity(), R.layout.weight_item, arrayList);

        //open to use db
        database = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);


        //create table if not exist

//        database.execSQL("drop table if exists orders");
        database.execSQL(
                "CREATE TABLE IF NOT EXISTS db (_id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR(5), weight VARCHAR(3))"
        );

        String date,weight;
        //query data
        Cursor db_query = database.rawQuery("SELECT * FROM db", null);

        viewAdapter.clear();

        while(db_query.moveToNext()) {
            date = db_query.getString(1);
            weight = db_query.getString(2);


            arrayList.add(new Weight(date,weight));
        }

        listView.setAdapter(viewAdapter);
        viewAdapter.notifyDataSetChanged();
    }
}
