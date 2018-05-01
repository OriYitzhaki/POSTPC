package com.example.oriyitzhaki.selfchat;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private final OnMessageLongClickListener listener;

    private List<Message> messages;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView messageContentView;
        TextView messageNameView;
        TextView messageTimeView;
        public ViewHolder(View itemView) {
            super(itemView);
            messageNameView = itemView.findViewById(R.id.name);
            messageContentView = itemView.findViewById(R.id.content);
            messageTimeView = itemView.findViewById(R.id.time);
        }
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        final Message m = messages.get(position);
        holder.messageNameView.setText(m.getName());
        holder.messageContentView.setText(m.getContent());
        holder.messageTimeView.setText(m.getTime());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onMessageLongClick(m);
                return true;
            }
        });
    }


    public MessageAdapter(OnMessageLongClickListener listener) {
        super();
        this.messages = new ArrayList<>();
        this.listener = listener;
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void addMessage(Message message) {
        Log.d("stuff", message.toString());
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    public void removeMessage(Message message) {
        final int position = messages.indexOf(message);
        messages.remove(position);
        notifyItemRemoved(position);
    }


    public interface OnMessageLongClickListener {
        void onMessageLongClick(Message message);
    }
}
