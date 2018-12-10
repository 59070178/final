package th.ac.it;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu, container, false);    }

    ArrayList<String> _menu = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        _menu.add("Add");
        _menu.add("View");
        _menu.add("Write");
        _menu.add("Image");


        final ArrayAdapter<String> _menuAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                _menu
        );

        ListView _menuList = (ListView) getView().findViewById(R.id.menu_list);
        _menuList.setAdapter(_menuAdapter);

        _menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("MENU", "Click on menu = "+_menu.get(i));

                if (_menu.get(i).equals("Add")){
                    _menu.clear();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new Add())
                            .addToBackStack(null)
                            .commit();


                }else if (_menu.get(i).equals("View")){

                    _menu.clear();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new ViewWeight())
                            .addToBackStack(null)
                            .commit();

                    Log.d("USER", "GOTO Theme");
                    Toast.makeText
                            (getContext(),"GO TO MENU",Toast.LENGTH_SHORT)
                            .show();
                }
                else if (_menu.get(i).equals("Write")){
                    _menu.clear();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new writeFile())
                            .addToBackStack(null)
                            .commit();


                }
                else if (_menu.get(i).equals("Image")){
                    _menu.clear();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new ImageWithLink())
                            .addToBackStack(null)
                            .commit();
                }

            }
        });

    }

}
