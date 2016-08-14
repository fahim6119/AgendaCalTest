package batfia.agendacaltest.medication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import batfia.agendacaltest.R;


/*
    Medication Name, Icon, color theme, Alarm Time ,Day, Dosage, Frequency
    Details of Medication, Usage, Buddy name, email
 */

public class MedicationDetailsActivity extends AppCompatActivity {
    String LOG_TAG="checkLog";
    String username="team.batfia@gmail.com";
    String password="pushpopbatfia";
    private String[] medicationStateSpinner,medicationFrequencySpinner;
    LinearLayout.LayoutParams lp;
    View reminderLayout[];
    Button setDosageBtn;
    TextView Dosage[];
    int dosageNum;
    LinearLayout frequencyLayout;

    TextView medicationName,medicationType;
    ImageView medicationLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_details);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String detail = intent.getExtras().getString("detail");
        int icon = intent.getExtras().getInt("icon");

        medicationName=(TextView)findViewById(R.id.medicationName);
        medicationType=(TextView)findViewById(R.id.medicationDetail);
        medicationLabel=(ImageView)findViewById(R.id.medicationLabel);

        medicationName.setText(name);
        medicationType.setText(detail);
        medicationLabel.setBackgroundResource(icon);

        medicationStateSpinner = new String[] {
                "Taken", "Snoozed", "To be taken within 5 minutes", "Not for today"};
        Spinner stateSpinner = (Spinner) findViewById(R.id.medicationState);
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, medicationStateSpinner);
        stateAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        stateSpinner.setAdapter(stateAdapter);
        String state = stateSpinner.getSelectedItem().toString();
        Log.i(LOG_TAG,state);

        medicationFrequencySpinner = new String[] {
                "Daily", "Weekly", "Monthly", "Other"};
        final Spinner freqSpinner = (Spinner) findViewById(R.id.medicationFrequencySpinner);
        ArrayAdapter<String> frequencyAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, medicationFrequencySpinner);
        frequencyAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        freqSpinner.setAdapter(frequencyAdapter);
        freqSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                createFrequencyGUI(position);
                Object item = parent.getItemAtPosition(position);
                String frequency = freqSpinner.getSelectedItem().toString();
                Log.i(LOG_TAG,"freqSpinner"+ frequency);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void createFrequencyGUI(int position)
    {
        dosageNum=position;
        frequencyLayout =(LinearLayout) findViewById(R.id.medicationTimes);
        lp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.FILL_PARENT,    LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 1, 0, 2);
        frequencyLayout.removeAllViews();
        reminderLayout=new View[dosageNum];
        for(int i=0;i<dosageNum;i++)
        {
            addDosage(i);
        }
        //dailyGUI(position);
        createDosageBtn();
    }

    public void dailyGUI(int dosageNum)
    {

        //reminderLayout=getLayoutInflater().inflate(R.layout.reminder_layout, null);
        /*
        Dosage=new TextView[dosageNum];
        for(int l=0;l<dosageNum;l++) {
            Dosage[l] = new TextView(this);
            Dosage[l].setText("Dosage "+l);
            Dosage[l].setTextSize(15);
            Dosage[l].setLayoutParams(lp);
            Dosage[l].setId(l);
            frequencyLayout.addView(Dosage[l]);
        }
        */
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }
    public void addDosage(int dosageID)
    {
        reminderLayout[dosageID] = getLayoutInflater().inflate(R.layout.reminder_layout, null);
        TextView t=(TextView)reminderLayout[dosageID].findViewById(R.id.medication_time);
        t.setText((2+4*dosageID)+":00 PM ");
        frequencyLayout.addView(reminderLayout[dosageID]);
    }

    public void createDosageBtn()
    {
        setDosageBtn=new Button(this);
        setDosageBtn.setText("Add new dose");
        setDosageBtn.setTextSize(10);
        setDosageBtn.setTextColor(Color.WHITE);
        setDosageBtn.setLayoutParams(lp);
        setDosageBtn.setPadding(5,0,5,0);
        setDosageBtn.setBackgroundColor(Color.TRANSPARENT);
        setDosageBtn.setTextColor(getResources().getColor(R.color.blue_dark));
        setDosageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dosageNum++;
                createFrequencyGUI(dosageNum);
            }
        });
        frequencyLayout.addView(setDosageBtn);
    }


    public void addCompanion(View V)
    {
        Log.i(LOG_TAG,"Added Companion");
    }

}
