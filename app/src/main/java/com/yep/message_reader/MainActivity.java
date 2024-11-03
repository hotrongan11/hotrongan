package com.yep.message_reader;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACT_ASK_PERMISSONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSONS = 1002;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addcontroll();
        addevent();
    }

    private void addevent() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLySMS();
            }
        });
    }

    private void XuLySMS() {

        if((ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED)){
            ActivityCompat.requestPermissions(this,new String[]{""+"android.permission.READ_SMS"},REQUEST_SMS_ASK_PERMISSONS);
        }else{
            Intent intent = new Intent(MainActivity.this,TinNhan.class);
            intent.setClassName("com.yep.message_reader","com.yep.message_reader.TinNhan");
            startActivity(intent);
        }

    }

    private void addcontroll() {
        btn = findViewById(R.id.btn1);
    }
}