package com.machuskyj1.gpa_machuskyj1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private int GPA = 0;

    public  void calculateFunction(){

        EditText field1 = (EditText) findViewById(R.id.field1);
        EditText field2 = (EditText) findViewById(R.id.field2);
        EditText field3 = (EditText) findViewById(R.id.field3);
        EditText field4 = (EditText) findViewById(R.id.field4);
        EditText field5 = (EditText) findViewById(R.id.field5);

        //Get Strings to check if there are empty fields
        String Text1 = field1.getText().toString();
        String Text2 = field2.getText().toString();
        String Text3 = field3.getText().toString();
        String Text4 = field4.getText().toString();
        String Text5 = field5.getText().toString();

        if(Text1.matches("") || Text2.matches("") || Text3.matches("") || Text4.matches("") || Text5.matches("")){
            Toast.makeText(getApplicationContext(),"Please fill out all fields",Toast.LENGTH_LONG).show();


        }else{
        int Grade1 = Integer.parseInt(field1.getText().toString());
        int Grade2 = Integer.parseInt(field2.getText().toString());
        int Grade3 = Integer.parseInt(field3.getText().toString());
        int Grade4 = Integer.parseInt(field4.getText().toString());
        int Grade5 = Integer.parseInt(field5.getText().toString());


        GPA = ((Grade1+Grade2+Grade3+Grade4+Grade5)/5);


        //Set GPA label to the GPA
        TextView gpaView = (TextView) findViewById(R.id.gpaView);
        gpaView.setText("Your GPA is: "+GPA);

        //Set button text color to clear
        Button computeButton = (Button) findViewById(R.id.computeButton);
        computeButton.setTextColor(Color.TRANSPARENT);

        //Set background color correctly
        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        if (GPA<60){
            myLayout.setBackgroundColor(Color.RED);
        }else if (GPA >=60 && GPA < 80){
            myLayout.setBackgroundColor(Color.YELLOW);
        }else if (GPA>=80){
            myLayout.setBackgroundColor(Color.GREEN);
        }

    }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button computeButton = (Button) findViewById(R.id.computeButton);
        computeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i("MyApp","The button was pressed!");
               calculateFunction();
            }
        });

    }
}
