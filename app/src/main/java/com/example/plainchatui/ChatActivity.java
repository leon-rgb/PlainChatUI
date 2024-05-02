package com.example.plainchatui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    List<UserMessage> messageList;
    MessageListAdapter mMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        messageList = new ArrayList<>();
        RecyclerView mMessageRecycler = findViewById(R.id.recycler_gchat);
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);

        Button send_button = findViewById(R.id.button_gchat_send);
        send_button.setOnClickListener(this);

        mMessageAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                mMessageRecycler.smoothScrollToPosition(mMessageAdapter.getItemCount());
            }
        });
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.edit_gchat_message);

        //Your Logic
        String messageText = editText.getText().toString();
        if(messageText.isEmpty()) return;
        UserMessage message;
        message = new UserMessage(messageText, MessageListAdapter.Sender.USER);
        messageList.add(message);
        editText.setText("");
        System.out.println(mMessageAdapter.getItemViewType(messageList.size()-1));
        System.out.println(messageList.size());
        /*
        ReceivedMessageHolder
        ViewGroup SentMessageHolder = ReceivedMessageHolder;
        mMessageAdapter.createViewHolder(mMessageAdapter.,1);
         */
        // Notify the adapter that a new message has been added
        mMessageAdapter.notifyItemInserted(messageList.size() - 1);

        message = new UserMessage("Sorry, I don't have functionality to answer at the moment.", MessageListAdapter.Sender.BOT);
        messageList.add(message);
        mMessageAdapter.notifyItemInserted(messageList.size() - 1);

    }

}
