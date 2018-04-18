package com.example.oriyitzhaki.selfchat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message> {

    Context context;
    List<Message> objects;

    public MessageAdapter(@NonNull Context context, @NonNull List<Message> objects) {
        super(context, 0, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitem = convertView;
        if (listitem == null) {
            listitem = LayoutInflater.from(context).inflate(R.layout.message_layout, parent, false);
        }
        Message message = objects.get(position);
        TextView textViewName = listitem.findViewById(R.id.name);
        textViewName.setText(message.getName());
        TextView textViewContent = listitem.findViewById(R.id.content);
        textViewContent.setText(message.getContent());
        TextView textViewTime = listitem.findViewById(R.id.time);
        textViewTime.setText(message.getTime());
        return listitem;
    }

    @Override
    public void add(@Nullable Message object) {
        this.objects.add(object);
        notifyDataSetChanged();
    }
}
