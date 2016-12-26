package edu.niu.cs.z1760203.area;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class area extends Activity {

    // Initializing variables to hold screen objects
    EditText num1ET, num2ET;
    TextView txt1, num1TV, num2TV;
    Double num1, num2, result;
    final Double PI = 3.141;


    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        // Connecting the initialized variables with the screen objects
        txt1 = (TextView) findViewById(R.id.titleTextView);
        num1ET = (EditText)findViewById(R.id.num1EditText);
        num2ET = (EditText)findViewById(R.id.num2EditText);
        num1TV = (TextView)findViewById(R.id.num1TextView);
        num2TV = (TextView)findViewById(R.id.num2TextView);

       String selected = getIntent().getStringExtra("selection");

        //checking if selected shape is triangle
        if (selected.equals("Triangle")) {
            //to set the title
            txt1.setText(R.string.triangleStr1);
            num1TV.setText("Base : ");
            num2TV.setText("Height : ");

            // Connecting the screen button object
            Button calBtn = (Button) findViewById(R.id.cal2Button);

            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //check for data in textfields

                    if (num1ET.getText().toString().matches("") ||
                            num2ET.getText().toString().matches("")) {
                        Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
                        return;
                    }

                    //get the numbers
                    num1 = Double.parseDouble(num1ET.getText().toString());
                    num2 = Double.parseDouble(num2ET.getText().toString());

                    //calculate the area

                    result = (num1 * num2) * 0.5;

                    Intent intent = getIntent();
                    intent.putExtra("Area", result);
                    ((Activity) v.getContext()).setResult(RESULT_OK, intent);

                    finish();
                }
            });

        }

        //checking if selected shape is triangle
                else if (selected.equals("Circle")) {
            //to set the title
            txt1.setText(R.string.circleStr1);
            num2TV.setText("Radius : ");
            num1TV.setVisibility(View.GONE);
            num1ET.setVisibility(View.GONE);

            // Connecting the screen button object
            Button calBtn = (Button) findViewById(R.id.cal2Button);

            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //check for data in textfields

                    if (num2ET.getText().toString().matches("")) {
                        Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
                        return;
                    }

                    //get the numbers
                    num1 = Double.parseDouble(num2ET.getText().toString());

                    //calculate the area

                    result = (num1 * num1) * PI;

                    Intent intent = getIntent();
                    intent.putExtra("Area", result);
                    ((Activity) v.getContext()).setResult(RESULT_OK, intent);

                    finish();
                }
            });

        }

                else if (selected.equals("Ellipse")) {
            //to set the title
            txt1.setText(R.string.ellipseStr1);
            num1TV.setText("Semi - Major Axis : ");
            num2TV.setText("Semi - Minor Axis : ");

            // Connecting the screen button object
            Button calBtn = (Button) findViewById(R.id.cal2Button);

            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //check for data in textfields

                    if (num1ET.getText().toString().matches("") ||
                            num2ET.getText().toString().matches("")) {
                        Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
                        return;
                    }

                    //get the numbers
                    num1 = Double.parseDouble(num1ET.getText().toString());
                    num2 = Double.parseDouble(num2ET.getText().toString());

                    //calculate the area

                    result = (num1 * num2) * PI;

                    Intent intent = getIntent();
                    intent.putExtra("Area", result);
                    ((Activity) v.getContext()).setResult(RESULT_OK, intent);

                    finish();
                }
            });

        }

    }//onCreate ends here
}//MainActivity ends here
