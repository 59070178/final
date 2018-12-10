package th.ac.it;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button cf = getView().findViewById(R.id.name_btn);
        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = getView().findViewById(R.id.name);
                String str = name.getText().toString();
                if (str.length() < 3 || !(Character.isUpperCase(str.charAt(0)))){
                    Toast.makeText
                            (getActivity(),"ข้อมูลไม่ถูกต้อง",Toast.LENGTH_SHORT)
                            .show();
                }else {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new Menu())
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}
