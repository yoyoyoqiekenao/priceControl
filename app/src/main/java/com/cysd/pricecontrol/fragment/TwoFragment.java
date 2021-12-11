package com.cysd.pricecontrol.fragment;

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

import com.cysd.pricecontrol.adapter.TwoAdapter;
import com.cysd.pricecontrol.databinding.FragmentOneBinding;
import com.cysd.pricecontrol.databinding.FragmentTwoBinding;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {
    private FragmentTwoBinding binding;

    private TwoAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentTwoBinding.inflate(inflater, container, false);

        mAdapter = new TwoAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        binding.rc.setLayoutManager(manager);
        binding.rc.setAdapter(mAdapter);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mAdapter.setList(list);
        return binding.getRoot();
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
