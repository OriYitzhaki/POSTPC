package com.example.oriyitzhaki.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements InputMessageFragment.DialogListener ,MessageAdapter.OnMessageLongClickListener, LongClickFragment.DeleteHandler {

    EditText editText;
    RecyclerView listView;
    MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.InputEditText);
        listView = findViewById(R.id.ListTextView);
        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessageAdapter(this);
        listView.setAdapter(messageAdapter);
    }

    public void onClickSendButton(View view) {
        String string = editText.getText().toString();
        if (string.isEmpty()){
            return;
        }
        messageAdapter.addMessage(new Message(string,new Date().toString()));
        editText.setText(null);
    }

    public void onClickOpenDialog(View view) {
        InputMessageFragment.newInstance(this).show(getSupportFragmentManager(),"");
    }

    @Override
    public void SendMessage(String string) {
        messageAdapter.addMessage(new Message(string,new Date().toString()));

    }

    @Override
    public void onMessageLongClick(Message message) {
        LongClickFragment.newInstance(this,message).show(getSupportFragmentManager(),"");
    }

    @Override
    public void DeleteMessage(Message message) {
        this.messageAdapter.removeMessage(message);
    }
}
