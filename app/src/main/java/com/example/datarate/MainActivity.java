package com.example.datarate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText senderName, receiver;
    DatabaseReference reff;
    OneWayDelay onewaydelay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        senderName = (EditText)findViewById(R.id.editTextTextPersonName);
        receiver = (EditText)findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.button2);
        onewaydelay= new OneWayDelay();
        reff = FirebaseDatabase.getInstance().getReference().child("OneWayDelay");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float t0 = Float.parseFloat("12.232");
                Float t1 = Float.parseFloat("134.232");
                Float t2 = Float.parseFloat("112.232");
                Float t3 = Float.parseFloat("132.232");
                onewaydelay.setReceiver(receiver.getText().toString().trim());
                onewaydelay.setSenderName(senderName.getText().toString().trim());
                onewaydelay.setT0(t0);
                onewaydelay.setT1(t1);
                onewaydelay.setT2(t2);
                onewaydelay.setT3(t3);
                reff.push().setValue(onewaydelay);


                openDataRate();
            }
        });

    }
    public void openDataRate()
    {
        Intent intent = new Intent(this, DataRateActivity.class);
        intent.putExtra("t0", DataRateActivity.class);
        intent.putExtra("t1", DataRateActivity.class);
        intent.putExtra("t2", DataRateActivity.class);
        intent.putExtra("t3", DataRateActivity.class);
        intent.putExtra("senderName", DataRateActivity.class);
        intent.putExtra("rec", DataRateActivity.class);

        startActivity(intent);
    }

}