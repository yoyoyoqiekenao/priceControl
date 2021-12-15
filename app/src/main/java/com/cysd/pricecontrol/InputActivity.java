package com.cysd.pricecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cysd.pricecontrol.adapter.InputAdapter;
import com.cysd.pricecontrol.adapter.TwoAdapter;
import com.cysd.pricecontrol.bean.ThingListBean;
import com.cysd.pricecontrol.databinding.ActivityInputBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.cysd.pricecontrol.util.ActivityManager;
import com.cysd.pricecontrol.util.ToastUtils;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityInputBinding binding;
    private InputAdapter mAdapter;

    private List<ThingListBean.DataDTO.ListDTO> mList = new ArrayList<>();
    private NormalPop_2 mPop;
    private SuccessPop mPop_success;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 1:
                    mPop_success.dismiss();
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        ActivityManager.addActivity(this);

        mAdapter = new InputAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.rc.setLayoutManager(manager);
        binding.rc.setAdapter(mAdapter);


        getThingsList("");

        binding.tvAllSave.setOnClickListener(this);
        binding.tvInput.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this);
    }

    //获取物品列表
    private void getThingsList(String search) {
        HttpNet.getThingList(this, search, new NetListener() {
            @Override
            public void getRetCodeString(String retCode, String result) {
                if ("200".equals(retCode)) {
                    ThingListBean bean = new Gson().fromJson(result, ThingListBean.class);
                    mList.addAll(bean.getData().getList());
                    mAdapter.setList(mList);
                    mAdapter.setImgUrl(bean.getData().getImageUrl());
                    mAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                            if (!TextUtils.isEmpty(mList.get(position).getCheck())) {
                                mList.get(position).setCheck("");
                            } else {
                                mList.get(position).setCheck("1");
                            }

                            mAdapter.setList(mList);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_input:
                boolean isPut = false;
                for (int i = 0; i < mList.size(); i++) {
                    if (!TextUtils.isEmpty(mList.get(i).getCheck())) {
                        isPut = true;
                    }
                }
                if (isPut == false) {
                    ToastUtils.showShort("请先选择需要倒入的案件");
                    return;
                }
                mPop = new NormalPop_2(this, "确定导入涉案财物管理系统吗", new NormalPop_2.OnClick() {
                    @Override
                    public void click() {
                        mPop.dismiss();
                        showSuccessPop();
                    }
                });
                mPop.setOutSideDismiss(true);
                mPop.setPopupGravity(Gravity.CENTER);
                mPop.showPopupWindow();
                break;
            case R.id.tv_allSave:
                for (int i = 0; i < mList.size(); i++) {
                    mList.get(i).setCheck("1");
                }
                mAdapter.setList(mList);
                break;
            default:
        }
    }

    private void showSuccessPop() {
        mPop_success = new SuccessPop(this, new SuccessPop.OnClick() {
            @Override
            public void click() {

            }
        });
        mPop_success.setOutSideDismiss(true);
        mPop_success.setPopupGravity(Gravity.CENTER);
        mPop_success.showPopupWindow();
        mHandler.sendEmptyMessageDelayed(1, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
