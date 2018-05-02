package com.example.oriyitzhaki.selfchat;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LongClickFragment extends DialogFragment implements View.OnClickListener {

    private DeleteHandler deleteHandler;

    public interface DeleteHandler{
        void DeleteMessage(Message message);
    }

    private Message message;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ok_long_click:
                this.handleDelete(view);
                break;
            case R.id.back_long_click:
                this.handleBack(view);
                break;
        }
    }

    private void handleBack(View view) {
        dismiss();
    }

    private void handleDelete(View view) {
        this.deleteHandler.DeleteMessage(message);
        dismiss();
    }


    public static LongClickFragment newInstance(DeleteHandler deleteHandler,Message message) {

        Bundle args = new Bundle();
        LongClickFragment fragment = new LongClickFragment();
        fragment.setArguments(args);
        fragment.message = message;
        fragment.deleteHandler=deleteHandler;
        return fragment;
    }


    TextView textViewInfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.long_click_layout,container,false);
        view.findViewById(R.id.ok_long_click).setOnClickListener(this);
        view.findViewById(R.id.back_long_click).setOnClickListener(this);
        textViewInfo = view.findViewById(R.id.info_msg);
        textViewInfo.setText(this.resolveMessage(message));
        return view;
    }

    private String resolveMessage(Message message) {
        return message.toString();
    }


}
