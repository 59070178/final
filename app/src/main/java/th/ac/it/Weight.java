package th.ac.it;

import android.content.ContentValues;

public class Weight {

    String date;
    String weight;
    ContentValues row = new ContentValues();


    public Weight() {
    }

    public Weight(String date, String weight) {
        this.date = date;
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public ContentValues getContent() {
        return row;
    }

    public void setContent(String date, String weight) {

        this.row.put("date", date);
        this.row.put("weight", weight);

    }
}
