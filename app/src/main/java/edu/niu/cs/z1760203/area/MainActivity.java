/*****************************************************************************

 CSCI 522 - Mid-Term part 2
 Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 03/010/2016

 Purpose   : This application is displays 3 shapes to be selected by the user.
             When the user selects a shape, a new activity is opened. Here, the
             user needs to enter the required information to calculate the area
             of the selected shape.

 ******************************************************************************/

package edu.niu.cs.z1760203.area;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    // Initializing variables to hold screen objects
    public String shape = "";
    private RadioGroup shapeRG;
    private Button calculateButton;
    private TextView areaTV;
    static final int REQUEST_CODE = 1;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the initialized variables with the screen objects
        calculateButton = (Button)findViewById(R.id.calcButton);
        shapeRG = (RadioGroup)findViewById(R.id.shapeRadioGroup);
        areaTV = (TextView)findViewById(R.id.areaTextView);

        shapeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //using switch case to check which shape is selected
                switch (checkedId) {

                    case R.id.triangleRadioButton:
                        shape = "Triangle";
                        break;
                    case R.id.circleRadioButton:
                        shape = "Circle";
                        break;
                    case R.id.ellipseRadioButton:
                        shape = "Ellipse";
                        break;
                }//switch ends

            }//onCheckedChanged ends here
        });//onCheckedListener ends here


    }//onCreate ends here


    public void doCalc(View v)
    {
        if(shape.equals("Circle")||shape.equals("Ellipse") || shape.equals("Triangle")) {
            // Starting an intent(newIntent) to start the ContentActivity
            Intent newIntent = new Intent(MainActivity.this, area.class);
            newIntent.putExtra("selection", shape);
            startActivityForResult(newIntent, REQUEST_CODE);
        }//if condition creates here

        //to display toast message when no shape is selected
        else{
            Toast.makeText(v.getContext(), "Please select a shape", Toast.LENGTH_LONG).show();
        }
    }//doCalc ends here


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        String returnedString;

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
           Double returnedArea = data.getDoubleExtra("Area", 0.0);

            //using decimalFormat to format the result
            DecimalFormat df = new DecimalFormat("0.000");
            returnedString = df.format(returnedArea);
            areaTV.setText("The area is : " + returnedString);
        }//if ends here

    }//onActivityResult ends here

}//MainActivity ends here
