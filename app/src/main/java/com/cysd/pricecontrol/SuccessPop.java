package com.cysd.pricecontrol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;

import razerdp.basepopup.BasePopupWindow;

public class SuccessPop extends BasePopupWindow {

    private OnClick mClick;

    public interface OnClick {
        void click();
    }


    public SuccessPop(Context context, OnClick click) {
        super(context);
        mClick = click;
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_success);
        return view;
    }
}
