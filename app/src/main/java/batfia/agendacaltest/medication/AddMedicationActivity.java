package batfia.agendacaltest.medication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import batfia.agendacaltest.R;
import batfia.agendacaltest.dialogs.fragment.SimpleDialogFragment;

public class AddMedicationActivity extends AppCompatActivity implements View.OnClickListener {


    /*
    Medication Name, Icon, color theme, Alarm Time ,Day, Dosage, Frequency
    Details of Medication, Usage, Buddy name, email
 */
    List<View> view;
    View name,shape,dosage,details,companions,frequencyDays,dailyDosage,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);
        LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        viewInit();

        /*
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager())
                .setTitle("Error: Update required")
                .setMessage("Set the name for Med")
                .setPositiveButtonText("Save")
                .setNegativeButtonText("Cancel")
                .setRequestCode(0)
                .show();
*/
    }

    void viewInit()
    {
        view=new ArrayList<>();

        name=findViewById(R.id.addMedicationName);
        shape=findViewById(R.id.addMedicationShape);
        dosage=findViewById(R.id.addMedicationDosage);
        details=findViewById(R.id.addMedicationDetails);
        companions=findViewById(R.id.addMedicationCompanion);
        frequencyDays=findViewById(R.id.addMedicationFrequencyDays);
        dailyDosage=findViewById(R.id.addMedicationDailyDosage);
        time=findViewById(R.id.addMedicationTime);

        view.add(name);
        view.add(shape);
        view.add(dosage);
        view.add(details);
        view.add(companions);
        view.add(frequencyDays);
        view.add(dailyDosage);
        view.add(time);

        for(int i=0;i<view.size();i++)
            view.get(i).setOnClickListener(this);

        setUpView(R.id.addMedicationName,"Name",R.drawable.edit);
        setUpView(R.id.addMedicationShape,"Shape",R.drawable.pill);
        setUpView(R.id.addMedicationDetails,"Details",R.drawable.details);

        setUpView(R.id.addMedicationCompanion,"Add New Companion",R.drawable.companion);

        setUpView(R.id.addMedicationFrequencyDays,"Every Day",R.drawable.event);
        setUpView(R.id.addMedicationDailyDosage,"Once a Day",R.drawable.frequency);


        //These Two Rows include Double Details

        setUpDetailView(R.id.addMedicationDosage,"Dosage",R.drawable.dosage,"80mg");
        setUpDetailView(R.id.addMedicationTime,"8:00 AM",R.drawable.clock,"1 unit");
    }



    void setUpView(int viewID,String text,int imageID)
    {
        View mylayout=findViewById(viewID);
        TextView tv=(TextView) mylayout.findViewById(R.id.add_medication_row_name);
        tv.setText(text);
        ImageView imageView=(ImageView) mylayout.findViewById(R.id.add_medication_row_icon);
        imageView.setBackgroundResource(imageID);
    }

    void setUpDetailView(int viewID,String text,int imageID,String details)
    {
        View mylayout=findViewById(viewID);
        TextView tv=(TextView) mylayout.findViewById(R.id.add_medication_detail_row_name);
        tv.setText(text);
        ImageView imageView=(ImageView) mylayout.findViewById(R.id.add_medication_detail_row_icon);
        imageView.setBackgroundResource(imageID);
        TextView detailView=(TextView) mylayout.findViewById(R.id.add_medication_detail_row_details);
        detailView.setText(details);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.addMedicationName:
                Log.i("checkLog","Requested to Set Name");
                v.findViewById(R.id.add_medication_detail_row_name).setVisibility(View.INVISIBLE);
               // v.findViewById(R.id.add_medication_detail_row_name_edit).setVisibility(View.VISIBLE);
                break;
            case R.id.addMedicationShape:
                Log.i("checkLog","Requested to Set Shape");
                break;
            case R.id.addMedicationDetails:
                Log.i("checkLog","Requested to Set Details");
                break;
            case R.id.addMedicationCompanion:
                Log.i("checkLog","Requested to Set Companion");
                break;
            case R.id.addMedicationFrequencyDays:
                Log.i("checkLog","Requested to Set FrequencyDays");
                break;
            case R.id.addMedicationDailyDosage:
                Log.i("checkLog","Requested to Set DailyDosage");
                break;
            case R.id.addMedicationDosage:
                Log.i("checkLog","Requested to Set Dosage");
                break;
            case R.id.addMedicationTime:
                Log.i("checkLog","Requested to Set Time");
                break;
            default:
                break;
        }

    }

}
