package com.example.oriyitzhaki.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.InputEditText);
        listView = findViewById(R.id.ListTextView);
        messageAdapter = new MessageAdapter(this,new ArrayList<Message>());
        listView.setAdapter(messageAdapter);
    }

    public void onClickSendButton(View view) {
        String string = editText.getText().toString();
        if (string.isEmpty()){
            return;
        }
        messageAdapter.add(new Message(string,new Date().toString()));
        editText.setText(null);
    }

}
