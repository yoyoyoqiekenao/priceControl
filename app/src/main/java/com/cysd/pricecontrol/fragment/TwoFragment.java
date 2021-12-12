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




public class TwoFragment extends Fragment {
    private FragmentTwoBinding binding;

    private TwoAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTwoBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();

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
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("xuwudi", "onDestory");
        if (binding != null) {
            binding = null;
        }
    }


}
