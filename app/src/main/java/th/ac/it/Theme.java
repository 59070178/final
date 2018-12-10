package th.ac.it;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Theme extends Fragment {

    public View onCreateView
            (@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container,
             @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.theme, container, false);
    }

    @Override
    public void onActivityCreated
            (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        dark();

    }

    void dark(){
        Button d = getView().findViewById(R.id.dark);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getContext().setTheme(R.style.FirstTheme);

                Toast.makeText
                        (getContext(),"Dark Theme",Toast.LENGTH_SHORT)
                        .show();

            }
        });
    }
}
