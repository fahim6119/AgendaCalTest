package batfia.agendacaltest;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import batfia.agendacaltest.medication.AddMedicationActivity;
import batfia.agendacaltest.medication.MedicationDetailsActivity;
import batfia.agendacaltest.medication.MedicationListActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // region Lifecycle methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.cardview_row);
        setContentView(R.layout.activity_main);

        Intent I =new Intent(MainActivity.this,AddMedicationActivity.class);
        //Intent I =new Intent(MainActivity.this,MedicationListActivity.class);
        //Intent I =new Intent(MainActivity.this,MedicationDetailsActivity.class);
        startActivity(I);
    }


}