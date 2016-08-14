package batfia.agendacaltest.medication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import batfia.agendacaltest.R;


/*
    Medication List with name, details, icon, color theme

 */

public class MedicationListActivity extends AppCompatActivity {

    ListView medication_list;
    int drawableId[];
    String[] medicationListName=new String[] { "iCap", "iTab","Napa Syrup","HepaInjection","Azmasol Inhaler","Napa Suppository","Eye Drop" };
    String[] medicationListDetails=new String[] { "Capsule", "Tablet","Syrup","Injection","Inhaler","Suppository","Drop" };
    int listSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_list);
        listSize=medicationListName.length;
        drawableId=new int[listSize];
        for (int j = 0; j < listSize; j++)
        {
            drawableId[j]  =getResources().getIdentifier("type"+j, "drawable", getPackageName());
        }

        medication_list = (ListView) findViewById(R.id.medication_list);
        medication_list.setAdapter(new yourAdapter(getBaseContext(),medicationListName,medicationListDetails ,drawableId));

        medication_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               // Object o = medication_list.getItemAtPosition(position);
                ViewHolder holder=(ViewHolder) view.getTag();
                Log.i("checkLog","Item Clicked "+medicationListName[position]);
                String name=holder.getName().getText().toString();
                String detail=holder.getDetail().getText().toString();
                int icon=drawableId[position];
                Intent I =new Intent(MedicationListActivity.this,MedicationDetailsActivity.class);
                I.putExtra("name",name);
                I.putExtra("detail",detail);
                I.putExtra("icon",icon);
                startActivity(I);

            }
        });
    }
}

class yourAdapter extends BaseAdapter {

    Context context;
    String[] name,details;
    int[] drawableId;
    private static LayoutInflater inflater = null;

    public yourAdapter(Context context, String[] name,String[] details,int[] drawableId) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.name = name;
        this.details = details;
        this.drawableId=drawableId;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.activity_medication_list_row, null,false);
            holder = new ViewHolder(vi);
            vi.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) vi.getTag();
        }
        holder.getName().setText(name[position]);
        holder.getDetail().setText(details[position]);
        holder.getIcon().setBackgroundResource(drawableId[position]);
        return vi;
    }

}

class ViewHolder {
    private View row;
    private TextView  medication_list_name = null, medication_list_detail = null;
    ImageView medication_list_icon=null;
    public ViewHolder(View row) {
        this.row = row;
    }

    public TextView getName() {
        if (this.medication_list_name == null) {
            this.medication_list_name = (TextView) row.findViewById(R.id.medication_list_name);
        }
        return this.medication_list_name;
    }

    public TextView getDetail() {
        if (this.medication_list_detail == null) {
            this.medication_list_detail = (TextView) row.findViewById(R.id.medication_list_detail);
        }
        return this.medication_list_detail;
    }

    public ImageView getIcon()
    {
        if (this.medication_list_icon == null) {
            medication_list_icon=(ImageView)row.findViewById(R.id.medication_list_icon);
        }
        return this.medication_list_icon;
    }

}
