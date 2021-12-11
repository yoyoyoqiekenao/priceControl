package com.cysd.pricecontrol;

import android.app.Dialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.view.WheelView;
import com.cysd.pricecontrol.util.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

public class SelectTimePop extends BasePopupWindow implements View.OnClickListener {

    private LinearLayout ll_start;
    private LinearLayout ll_end;
    private TimePickerView pvTime;
    private TextView tv_start_year, tv_start_month, tv_start_day;
    private TextView tv_end_year, tv_end_month, tv_end_day;
    private TextView tvSave;
    private ImageView iv_close;

    private String mStart_year, mStart_month, mStart_day;
    private String mEnd_year, mEnd_month, mEnd_day;
    private Date mStartData, mEndData;

    public onClick mClick;

    public interface onClick {
        void click(String startYear, String startMonth, String startDay,
                   String endYear, String endMonth, String endDay);
    }

    public SelectTimePop(Context context, String startYear, String startMonth, String startDay,
                         String endYear, String endMonth, String endDay, onClick click) {
        super(context);
        mStart_year = startYear;
        mStart_month = startMonth;
        mStart_day = startDay;
        mEnd_year = endYear;
        mEnd_month = endMonth;
        mEnd_day = endDay;

        tv_start_year.setText(mStart_year);
        tv_start_month.setText(mStart_month);
        tv_start_day.setText(mStart_day);

        tv_end_year.setText(mEnd_year);
        tv_end_month.setText(mEnd_month);
        tv_end_day.setText(mEnd_day);

        mClick = click;
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_select_time);
        tvSave = view.findViewById(R.id.tvSave);
        iv_close = view.findViewById(R.id.iv_close);

        ll_start = view.findViewById(R.id.ll_start);
        tv_start_year = view.findViewById(R.id.tv_start_year);
        tv_start_month = view.findViewById(R.id.tv_start_month);
        tv_start_day = view.findViewById(R.id.tv_start_day);

        ll_end = view.findViewById(R.id.ll_end);
        tv_end_year = view.findViewById(R.id.tv_end_year);
        tv_end_month = view.findViewById(R.id.tv_end_month);
        tv_end_day = view.findViewById(R.id.tv_end_day);

        ll_start.setOnClickListener(this);
        ll_end.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        iv_close.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                dismiss();
                break;
            case R.id.tvSave:
                if (!TextUtils.isEmpty(mStart_year) && !TextUtils.isEmpty(mStart_month) && !TextUtils.isEmpty(mStart_day)
                        && !TextUtils.isEmpty(mEnd_year) && !TextUtils.isEmpty(mEnd_month) && !TextUtils.isEmpty(mEnd_day)) {
                    mClick.click(mStart_year, mStart_month, mStart_day, mEnd_year, mEnd_month, mEnd_day);
                } else {
                    ToastUtils.showShort("请设置完整的开始时间和结束时间");
                }

                break;
            case R.id.ll_start:
                initTimePick("1", ll_start);
                break;
            case R.id.ll_end:
                initTimePick("2", ll_end);
                break;
            default:
        }
    }

    private void initTimePick(String type, View view) {
        pvTime = new TimePickerBuilder(getContext(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

                if ("1".equals(type)) {
                    mStartData = date;
                    mStart_year = getTime(date).substring(0, 4);
                    mStart_month = getTime(date).substring(5, 7);
                    mStart_day = getTime(date).substring(8, 10);

                    tv_start_year.setText(mStart_year);
                    tv_start_month.setText(mStart_month);
                    tv_start_day.setText(mStart_day);
                } else {
                    mEndData = date;
                    mEnd_year = getTime(date).substring(0, 4);
                    mEnd_month = getTime(date).substring(5, 7);
                    mEnd_day = getTime(date).substring(8, 10);

                    tv_end_year.setText(mEnd_year);
                    tv_end_month.setText(mEnd_month);
                    tv_end_day.setText(mEnd_day);
                }


            }
        }).setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
            @Override
            public void onTimeSelectChanged(Date date) {

            }
        }).setType(new boolean[]{true, true, true, false, false, false})
                .isDialog(true)
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setItemVisibleCount(5)
                .setLineSpacingMultiplier(2.0f)
                .isAlphaGradient(true)
                .build();
        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.3f);
            }
        }
        pvTime.show(view);
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
