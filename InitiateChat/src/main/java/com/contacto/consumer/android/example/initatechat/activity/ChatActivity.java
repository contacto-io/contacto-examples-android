package com.contacto.consumer.android.example.initatechat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.contacto.consumer.android.ContactoClient;
import com.contacto.consumer.android.example.base.ICommon;
import com.contacto.consumer.android.example.initatechat.databinding.ChatActivityBinding;
import com.contacto.consumer.android.ui.model.User;
import com.contacto.consumer.android.utility.Constants;
import com.google.android.material.snackbar.Snackbar;

public class ChatActivity extends AppCompatActivity {

    ChatActivityBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChatActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnChat.setOnClickListener(v -> {

            String fName = ((ICommon) getApplication()).getFirstName() == null ? "Alex" : "";
            String lName = ((ICommon) getApplication()).getLastName() == null ? "Nikiforov" : "";
            String email = ((ICommon) getApplication()).getEmail() == null ? "alex@example.com" : "";
            String phone = ((ICommon) getApplication()).getPhone() == null ? "9980965754" : "";

            String appId = ((ICommon) getApplication()).getAppId();
            String appKey = ((ICommon) getApplication()).getAppKey();
            if (appId == null || appKey == null || appId.trim().equals("") || appKey.trim().equals("")) {
                Toast.makeText(this, "Please provide AppId and AppKey", Toast.LENGTH_LONG).show();
                return;
            }

            User user = new User(
                    fName,
                    lName,
                    phone,
                    email
            );

            ContactoClient.INSTANCE.init(appId, appKey);
            ContactoClient.INSTANCE.loadChat(this, user);
        });

        binding.actionBar1.tvTitle.setText("Chat Now");
        binding.actionBar1.backAction.setVisibility(View.VISIBLE);
        binding.actionBar1.backAction.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Constants.ERROR_CODE) {
            String error = data.getStringExtra(Constants.PARAM_ERROR);
            Snackbar.make(binding.getRoot(), error == null ? "Something went wrong!" : error, Snackbar.LENGTH_SHORT).show();
        }
    }
}
