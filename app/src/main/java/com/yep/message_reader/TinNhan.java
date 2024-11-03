package com.yep.message_reader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yep.message_reader.adapter.AdapterTinNhan;
import com.yep.message_reader.model.MSG;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TinNhan extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSON = 1001;
    ListView lvDocTinNhan;
    ArrayList<MSG> dsTinNhan;
    AdapterTinNhan adapterTinNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tin_nhan);
        addcontroll();
        doctoanbotinnhan();
    }

    private void doctoanbotinnhan() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsTinNhan.clear();
        while(cursor.moveToNext()){
            int indexphoneNumber = cursor.getColumnIndex("address");
            int indexTimeStamp = cursor.getColumnIndex("date");
            int indexBody = cursor.getColumnIndex("body");

            String phoneNunber = cursor.getString(indexphoneNumber);
            String TimeStamp = cursor.getString(indexTimeStamp);
            String Body = cursor.getString(indexBody);
            dsTinNhan.add(new MSG(phoneNunber, sdf.format(Long.parseLong(TimeStamp)), Body));
            adapterTinNhan.notifyDataSetChanged();
        }
    }

    private void addcontroll() {
        lvDocTinNhan = findViewById(R.id.lvDocTinNhan);
        dsTinNhan = new ArrayList<>();
        adapterTinNhan = new AdapterTinNhan(
                TinNhan.this,R.layout.item_tinnhan,dsTinNhan);
        lvDocTinNhan.setAdapter(adapterTinNhan);
    }
}