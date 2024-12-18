package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddvActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button b3,b4;
    String get1,get2,get3,get4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addv);
        et1=(EditText) findViewById(R.id.fn);
        et2=(EditText) findViewById(R.id.ln);
        et3=(EditText) findViewById(R.id.p);
        et4=(EditText) findViewById(R.id.wtm);
        b3=(Button) findViewById(R.id.s);
        b4=(Button) findViewById(R.id.btm);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get1=et1.getText().toString();
                get2=et2.getText().toString();
                get3=et3.getText().toString();
                get4=et4.getText().toString();
                Toast.makeText(getApplicationContext(),get1+" "+get2+" "+get3+" "+get4,Toast.LENGTH_SHORT).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }
}