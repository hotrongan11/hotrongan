package com.yep.message_reader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import android.app.Activity;
import android.widget.TextView;
import com.yep.message_reader.R;
import com.yep.message_reader.TinNhan;
import com.yep.message_reader.model.MSG;

import java.util.List;

public class AdapterTinNhan extends ArrayAdapter<MSG> {
    Activity context;
    int resource;
    @NonNull List<MSG> objects;
    public AdapterTinNhan(@NonNull Activity context, int resource, @NonNull List<MSG> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);
        TextView _number = row.findViewById(R.id.txt_phone);
        TextView _time = row.findViewById(R.id.txt_time);
        TextView _body = row.findViewById(R.id.txt_body);

        _number.setText(this.objects.get(position).getNumber());
        _time.setText(this.objects.get(position).getTime());
        _body.setText(this.objects.get(position).getBody());

        return row;

    }
}
