package com.cysd.pricecontrol.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cysd.pricecontrol.R;

import razerdp.basepopup.BasePopupWindow;

public class SelectImgPop extends BasePopupWindow implements View.OnClickListener {
    private LinearLayout ll_photo, ll_camera;
    private ImageView iv_close;

    private OnClick mClick;

    public interface OnClick {
        void click(int position);
    }

    public SelectImgPop(Context context, OnClick click) {
        super(context);
        mClick = click;
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_select_img);
        ll_photo = view.findViewById(R.id.ll_photo);
        ll_camera = view.findViewById(R.id.ll_camera);
        iv_close = view.findViewById(R.id.iv_close);

        iv_close.setOnClickListener(this);
        ll_photo.setOnClickListener(this);
        ll_camera.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_photo:
                mClick.click(0);
                break;
            case R.id.ll_camera:
                mClick.click(1);
                break;
            case R.id.iv_close:
                dismiss();
                break;
            default:
        }
    }
}
