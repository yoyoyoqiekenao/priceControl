package com.cysd.pricecontrol.fragment;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cysd.pricecontrol.NormalPop;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.SelectTimePop;
import com.cysd.pricecontrol.SelectTypePop;
import com.cysd.pricecontrol.databinding.FragmentOneBinding;
import com.gyf.immersionbar.ImmersionBar;

public class OneFragment extends Fragment implements View.OnClickListener {

    private FragmentOneBinding binding;
    private NormalPop mPop;
    private SelectTypePop mPop_type;
    private SelectTimePop mPop_time;


    private String mName;
    private String mNo;
    private String mUnit;
    private String mPerson;
    private String mMobile;
    private String mType;

    private String mStart_year, mStart_month, mStart_day;
    private String mEnd_year, mEnd_month, mEnd_day;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOneBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();
        binding.rlName.setOnClickListener(this);
        binding.rlMobile.setOnClickListener(this);
        binding.rlNo.setOnClickListener(this);
        binding.rlPerson.setOnClickListener(this);
        binding.rlUnit.setOnClickListener(this);
        binding.rlType.setOnClickListener(this);
        binding.rlTime.setOnClickListener(this);
        return binding.getRoot();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (binding != null) {
            binding = null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_time:
                showTimePop(mStart_year, mStart_month, mStart_day, mEnd_year, mEnd_month, mEnd_day);
                break;
            case R.id.rl_type:
                showTypePop(mType);
                break;
            case R.id.rl_mobile:
                showPop(mMobile, "5");
                break;
            case R.id.rl_person:
                showPop(mPerson, "4");
                break;
            case R.id.rl_unit:
                showPop(mUnit, "3");
                break;
            case R.id.rl_no:
                showPop(mNo, "2");
                break;
            case R.id.rl_name:
                showPop(mName, "1");
                break;
            default:
        }
    }

    //选择时间
    private void showTimePop(String startYear, String startMonth, String startDay,
                             String endYear, String endMonth, String endDay) {
        mPop_time = new SelectTimePop(getContext(), startYear, startMonth, startDay,
                endYear, endMonth, endDay, new SelectTimePop.onClick() {
            @Override
            public void click(String startYear, String startMonth, String startDay, String endYear, String endMonth, String endDay) {
                mStart_year = startYear;
                mStart_month = startMonth;
                mStart_day = startDay;
                mEnd_year = endYear;
                mEnd_month = endMonth;
                mEnd_day = endDay;
                mPop_time.dismiss();

                binding.tvTime.setText(mStart_year + "." + mStart_month + "." + mStart_day + "-" +
                        mEnd_year + "." + mEnd_month + "." + mEnd_day);
            }
        });

        mPop_time.setOutSideDismiss(true);
        mPop_time.setPopupGravity(Gravity.BOTTOM);
        mPop_time.showPopupWindow();
    }

    private void showTypePop(String content) {
        mPop_type = new SelectTypePop(getContext(), content, new SelectTypePop.onClick() {
            @Override
            public void click(String content) {
                mType = content;
                binding.tvType.setText(mType);
                mPop_type.dismiss();
            }
        });
        mPop_type.setOutSideDismiss(true);
        mPop_type.setPopupGravity(Gravity.BOTTOM);
        mPop_type.showPopupWindow();
    }

    private void showPop(String content, String type) {
        mPop = new NormalPop(getContext(), content, type, new NormalPop.OnItemClick() {
            @Override
            public void click(String str) {
                switch (type) {
                    case "1":
                        mName = str;
                        binding.tvName.setText(mName);
                        break;
                    case "2":
                        mNo = str;
                        binding.tvNo.setText(mNo);
                        break;
                    case "3":
                        mUnit = str;
                        binding.tvUnit.setText(mUnit);
                        break;
                    case "4":
                        mPerson = str;
                        binding.tvPerson.setText(mPerson);
                        break;
                    case "5":
                        mMobile = str;
                        binding.tvMobile.setText(mMobile);
                        break;

                    default:
                }
                mPop.dismiss();
            }

        });

        mPop.setOutSideDismiss(true);
        mPop.setPopupGravity(Gravity.BOTTOM);
        mPop.showPopupWindow();

        showSoftKeyboard();
    }

    //显示键盘
    public void showSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
