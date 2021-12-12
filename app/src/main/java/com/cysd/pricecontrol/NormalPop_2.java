package com.cysd.pricecontrol;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import razerdp.basepopup.BasePopupWindow;

public class NormalPop_2 extends BasePopupWindow implements View.OnClickListener {
    private TextView tv_title, tv_cancel, tv_submit;
    private OnClick mClick;


    public interface OnClick {
        void click();
    }

    public NormalPop_2(Context context, String title, OnClick click) {
        super(context);
        mClick = click;

        tv_title.setText(title);
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_normal_2);
        tv_title = view.findViewById(R.id.tv_title);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_submit = view.findViewById(R.id.tv_submit);

        tv_cancel.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                dismiss();
                break;
            case R.id.tv_submit:
                mClick.click();
                break;
            default:
        }
    }
}
