package com.example.vaccinefinder;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    Button pinButton,aSwitch;
    LinearLayout pinLayout;
    EditText pinCode;
    String dateStr;
    String pinCode1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.layout);
        aSwitch=findViewById(R.id.aSwitch);
        pinLayout=findViewById(R.id.pinLayout);
        pinCode=findViewById(R.id.pinCode);
        pinButton=findViewById(R.id.pinButton);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("https://selfregistration.cowin.gov.in/");
                Intent i=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });
            pinButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                     pinCode1 =pinCode.getText().toString();
                    if (pinCode1.length() != 6) {
                        // this method is called when users enter invalid pin code.
                        Toast.makeText(MainActivity.this, "Please enter valid pin code", Toast.LENGTH_SHORT).show();
                    } else {
                            final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                            View mView = getLayoutInflater().inflate(R.layout.customdialog,null);
                            Button button=mView.findViewById(R.id.button);
                            alert.setView(mView);
                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    final Calendar c = Calendar.getInstance();
                                    int year = c.get(Calendar.YEAR);
                                    int month = c.get(Calendar.MONTH);
                                    int day = c.get(Calendar.DAY_OF_MONTH);
                                    dateStr=day+"-"+(month+1)+"-"+year+"";
                                    String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+pinCode1+"&date="+dateStr;
                                    Intent i=new Intent(MainActivity.this,HomePage.class);
                                    i.putExtra("Url",url);
                                    startActivity(i);
                                }
                            });
                            final AlertDialog alertDialog = alert.create();
                            alertDialog.setCanceledOnTouchOutside(false);
                            alert.show();
                    }
                    }
                });
        }
    }
