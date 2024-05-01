package com.example.plainchatui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var leftChatLayout: LinearLayout
    private lateinit var rightChatLayout: LinearLayout
    private lateinit var leftChatTextView: TextView
    private lateinit var rightChatTextView: TextView
    private lateinit var messageInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_layout)

        /**
        leftChatLayout = findViewById(R.id.left_chat_layout)
        rightChatLayout = findViewById(R.id.right_chat_layout)
        leftChatTextView = findViewById(R.id.left_chat_textview)
        rightChatTextView = findViewById(R.id.right_chat_textview)



        messageInput = findViewById(R.id.message_input)
        val sendButton: Button = findViewById(R.id.send_button)

        sendButton.setOnClickListener {
        val message = messageInput.text.toString().trim()
        if (message.isNotEmpty()) {
        addMessage("User", message)
        messageInput.text.clear()
        addMessage("Bot", "I currently don't have the functionality to answer your request.")
        }
        }

        }

        private fun addMessage(sender: String, message: String) {
        val textView = TextView(this)
        textView.text = "$sender: $message" //(${getTime()})"
        if(sender == "User"){
        leftChatTextView.text = textView.text
        } else {
        rightChatTextView.text = textView.text
        }
        }



        private fun getTime(): String {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return sdf.format(Date())
        }
         */
    }

}