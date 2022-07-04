package com.contacto.consumer.android.example.initatechat.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.contacto.consumer.android.ContactoClient;
import com.contacto.consumer.android.example.base.ICommon;
import com.contacto.consumer.android.example.initatechat.databinding.ChatActivityBinding;
import com.contacto.consumer.android.ui.model.User;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ChatActivityBinding binding = ChatActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChat.setOnClickListener(v -> {
            String appId = ((ICommon) getApplication()).getAppId();
            String appKey = ((ICommon) getApplication()).getAppKey();
            if (appId == null || appKey == null || appId.trim().equals("") || appKey.trim().equals("")) {
                Toast.makeText(this, "Please provide AppId and AppKey", Toast.LENGTH_LONG).show();
                return;
            }

            User user = new User("918050574001", "abcdef@gmail.com");

            ContactoClient.INSTANCE.init(appId, appKey);
            ContactoClient.INSTANCE.loadChat(this, null);
        });

        binding.actionBar1.tvTitle.setText("Chat Now");
        binding.actionBar1.backAction.setVisibility(View.VISIBLE);
        binding.actionBar1.backAction.setOnClickListener(v -> {
            finish();
        });
    }
}
