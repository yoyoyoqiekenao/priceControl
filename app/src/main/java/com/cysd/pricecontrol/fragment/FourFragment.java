package com.cysd.pricecontrol.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cysd.pricecontrol.databinding.FragmentFourBinding;
import com.cysd.pricecontrol.databinding.FragmentThreeBinding;
import com.gyf.immersionbar.ImmersionBar;

public class FourFragment extends Fragment {
    private FragmentFourBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFourBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();
        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binding != null) {
            binding = null;
        }
    }
}
