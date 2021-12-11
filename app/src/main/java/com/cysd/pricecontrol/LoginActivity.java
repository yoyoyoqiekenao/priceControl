package com.cysd.pricecontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;


import com.cysd.pricecontrol.bean.LoginBean;
import com.cysd.pricecontrol.databinding.ActivityLoginBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

public class LoginActivity extends Activity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        binding.tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }

    private void Login() {
        HttpNet.Login(LoginActivity.this, binding.edAccount.getText().toString().trim(),
                binding.edPwd.getText().toString().trim(), new NetListener() {
                    @Override
                    public void getRetCodeString(String retCode, String result) {
                        if ("200".equals(retCode)) {
                            LoginBean bean = new Gson().fromJson(result, LoginBean.class);
                            SharedPreferenceUtils.setLoginSp(LoginActivity.this, bean.getData().getToken());
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }

}
