package batfia.agendacaltest;

import java.util.ArrayList;

/**
 * Created by Arefin on 01-Aug-16.
 */

public class DataObject {
    private String time;
    private String label;
    private ArrayList<String> mList;

    DataObject (String text1,String text2, ArrayList<String> list){
        time = text1;
        label=text2;
        mList = list;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String mText1) {
        time = mText1;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String mText2) {
        this.label = mText2;
    }


    public ArrayList<String> getmList() {
        return mList;
    }

    public void setmList(ArrayList<String> mList)
    {
        this.mList = mList;
    }
}
