package com.cysd.pricecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cysd.pricecontrol.adapter.TwoAdapter;
import com.cysd.pricecontrol.bean.ThingListBean;
import com.cysd.pricecontrol.databinding.ActivitySearchBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

public class SearchActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;

    private TwoAdapter mAdapter;
    private String mSearchKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        mAdapter = new TwoAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.rc.setLayoutManager(manager);
        binding.rc.setAdapter(mAdapter);

        binding.edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (!TextUtils.isEmpty(binding.edSearch.getText().toString().trim())) {
                        mSearchKey = binding.edSearch.getText().toString().trim();
                        getThingsList(mSearchKey);
                        return true;
                    }
                }
                return false;
            }
        });

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //获取物品列表
    private void getThingsList(String search) {
        HttpNet.getThingList(this, search, new NetListener() {
            @Override
            public void getRetCodeString(String retCode, String result) {
                if ("200".equals(retCode)) {
                    ThingListBean bean = new Gson().fromJson(result, ThingListBean.class);
                    if (bean.getData().getList() != null && bean.getData().getList().size() > 0) {
                        binding.rc.setVisibility(View.VISIBLE);
                        binding.llEmpty.setVisibility(View.GONE);
                        mAdapter.setList(bean.getData().getList());
                        mAdapter.setImgUrl(bean.getData().getImageUrl());
                    } else {
                        binding.rc.setVisibility(View.GONE);
                        binding.llEmpty.setVisibility(View.VISIBLE);
                    }

                    mAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                            Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                            intent.putExtra("id", bean.getData().getList().get(position).getId());
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
    }
}