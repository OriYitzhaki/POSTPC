package com.example.oriyitzhaki.selfchat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class InputMessageFragment extends DialogFragment implements View.OnClickListener{



    public interface DialogListener {
        void SendMessage(String string);
    }

    private DialogListener dialogListener;
    private EditText editText;


    public static InputMessageFragment newInstance(DialogListener dialogListener){
        InputMessageFragment that = new InputMessageFragment();
        that.dialogListener = dialogListener;
        return that;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_layout,container,false);
        view.findViewById(R.id.dialog_text_cancel).setOnClickListener(this);
        view.findViewById(R.id.dialog_text_send).setOnClickListener(this);
        editText = view.findViewById(R.id.dialog_text);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialog_text_cancel:
                this.handleCancelClick(view);
                break;
            case R.id.dialog_text_send:
                this.handleSendClick(view);
                break;
        }
    }

    private void handleSendClick(View view) {
        dialogListener.SendMessage(editText.getText().toString());
        dismiss();
    }

    private void handleCancelClick(View view) {
        dismiss();
    }
}
