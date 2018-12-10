package th.ac.it;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends Fragment {

    private SQLiteDatabase database;
    private ContentValues cv;
    SharedPreferences sp;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add, container,false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cv = new ContentValues();

        initRecordBtn();

    }

    void initRecordBtn(){
        Button add = getView().findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText dateEdit  = getView().findViewById(R.id.date);
                EditText weightEdit = getView().findViewById(R.id.weight);

                String date = dateEdit.getText().toString();
                String weight = weightEdit.getText().toString();

                database = getActivity().openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);

                database.execSQL(
                        "CREATE TABLE IF NOT EXISTS db (_id INTEGER PRIMARY KEY AUTOINCREMENT, date VARCHAR(5), weight VARCHAR(3))"
                );

                Weight item = new Weight();

                item.setContent(date,weight);
                cv = item.getContent();


                database.insert("db", null, cv);

                Toast.makeText(getActivity(), "Save Success"
                        , Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
