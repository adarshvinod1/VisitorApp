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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
                if (get1.isEmpty()||get2.isEmpty()||get3.isEmpty()||get4.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All the fields are mandatory!",Toast.LENGTH_SHORT).show();
                }

                else {
                    try {
                        callApi();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            private void callApi() throws JSONException {
                String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data= new JSONObject();
                try {
                    data.put("firstname",get1);
                    data.put("lastname",get2);
                    data.put("purpose",get3);
                    data.put("whomToMeet",get4);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest request=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        data,
                        response -> Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_SHORT).show(),
                        error -> Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT).show()
                );
                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                queue.add(request);

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