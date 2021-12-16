package com.cysd.pricecontrol.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cysd.pricecontrol.DetailActivity;
import com.cysd.pricecontrol.InputActivity;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.SearchActivity;
import com.cysd.pricecontrol.adapter.TwoAdapter;
import com.cysd.pricecontrol.bean.ThingListBean;
import com.cysd.pricecontrol.databinding.FragmentOneBinding;
import com.cysd.pricecontrol.databinding.FragmentTwoBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class TwoFragment extends Fragment implements View.OnClickListener {
    private FragmentTwoBinding binding;

    private TwoAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTwoBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();
        EventBus.getDefault().register(this);
        mAdapter = new TwoAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.rc.setLayoutManager(manager);
        binding.rc.setAdapter(mAdapter);

        binding.ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });

        getThingsList("");
        binding.ivInput.setOnClickListener(this);
        return binding.getRoot();
    }

    //获取物品列表
    private void getThingsList(String search) {
        HttpNet.getThingList(getContext(), search, new NetListener() {
            @Override
            public void getRetCodeString(String retCode, String result) {
                if ("200".equals(retCode)) {
                    ThingListBean bean = new Gson().fromJson(result, ThingListBean.class);
                    mAdapter.setList(bean.getData().getList());
                    mAdapter.setImgUrl(bean.getData().getImageUrl());
                    mAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                            Intent intent = new Intent(getContext(), DetailActivity.class);
                            intent.putExtra("id", bean.getData().getList().get(position).getId());
                            startActivity(intent);
                        }
                    });
                    if (bean.getData().getList() != null && bean.getData().getList().size() > 0) {
                        binding.rc.setVisibility(View.VISIBLE);
                    } else {
                        binding.rc.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(String str) {
        if ("refresh".equals(str)) {
            getThingsList("");
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding = null;
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_input:
                startActivity(new Intent(getContext(), InputActivity.class));
                break;
            default:
        }
    }
}
