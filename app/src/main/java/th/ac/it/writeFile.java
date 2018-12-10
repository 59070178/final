package th.ac.it;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class writeFile extends Fragment {

     String fileName = "data.txt";
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/readwrite";


    public View onCreateView
            (@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container,
             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first, container, false);
    }

    @Override
    public void onActivityCreated
            (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        File dir = new File(path);
        dir.mkdir();



        write();
        view();
    }



    void write() {

        Button b = getView().findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) getView().findViewById(R.id.name);
//                EditText nick = (EditText) getView().findViewById(R.id.nick);
//                EditText age = (EditText) getView().findViewById(R.id.age);


                String nameSt = name.getText().toString();
//                String nickSt = nick.getText().toString();
//                String ageSt = age.getText().toString();

//                File file = new File(path+fileName);

                try {
//                    String path2 = Environment.getExternalStorageState();
                    File file=null;

                    File folder = new File(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_DOWNLOADS)+"/Email_Client/");
                    folder.mkdirs();


                    file=new File(folder,fileName);
                    //Automatically creates the new empty file specified by the name,   if it is not exist.
                    file.createNewFile();


                    String[] saveText = String.valueOf(name.getText()).split(System.getProperty("line.separator"));
                    name.setText("");

//                    Save (file,saveText);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }

    void view(){
        Button v = getView().findViewById(R.id.view);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = getView().findViewById(R.id.view);

                File file = new File(path+fileName);
                String [] load = Load(file);

                String str = "";

                for (int i = 0;i<load.length ; i++){
                    str += load[i] + System.getProperty("line.separator");
                }

                tv.setText(str);
            }
        });
    }

    public static String[] Load(File file){

        FileInputStream fis = null;
        int ar = 0;
        String test;
        try {
            fis = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        try {
            while ((test = br.readLine()) != null)
            {
                ar ++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            fis.getChannel().position(0);
        }catch (IOException e){
            e.printStackTrace();
        }


        String[] array = new String[ar];

        String line;
        int i = 0;

        try {
            while ((line=br.readLine()) != null){
                array[i] = line;
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        return array;

    }

    public static void Save(File file,String[] data){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);

            for (int i = 0 ; i<data.length ; i++){
                fos.write(data[i].getBytes());

                if (i < data.length-1){
                    fos.write("\n".getBytes());

                }

                fos.close();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
