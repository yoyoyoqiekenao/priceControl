package com.cysd.pricecontrol.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cysd.pricecontrol.databinding.FragmentThreeBinding;
import com.cysd.pricecontrol.databinding.FragmentTwoBinding;
import com.gyf.immersionbar.ImmersionBar;

public class ThreeFragment extends Fragment {
    private FragmentThreeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentThreeBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();
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
