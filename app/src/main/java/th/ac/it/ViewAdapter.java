package th.ac.it;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends ArrayAdapter<Weight> {

    private List<Weight> weightList;
    private Context context;

    public ViewAdapter(@NonNull Context context, int resource, @NonNull List<Weight> objects) {
        super(context, resource, objects);
        this.weightList = objects;
        this.context = context;
    }

    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent){


        View item = LayoutInflater.from(context).inflate(R.layout.weight_item,parent,false);

        TextView date = (TextView) item.findViewById(R.id.d);
        TextView weight = (TextView) item.findViewById(R.id.w);

        Weight sl = weightList.get(position);


        date.setText(sl.getDate());
        weight.setText(sl.getWeight());

        return item;


    }
}
