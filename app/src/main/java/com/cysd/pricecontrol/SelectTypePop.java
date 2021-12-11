package com.cysd.pricecontrol;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cysd.pricecontrol.util.ToastUtils;

import razerdp.basepopup.BasePopupWindow;

public class SelectTypePop extends BasePopupWindow implements View.OnClickListener {

    private RelativeLayout rl_1, rl_2;
    private ImageView iv_close, iv_1, iv_2;
    private TextView tvSave;

    private String mContent;
    private onClick mClick;

    public interface onClick {
        void click(String content);
    }

    public SelectTypePop(Context context, String content, onClick click) {
        super(context);
        mContent = content;
        mClick = click;

        if ("办案单位移送".equals(mContent)) {
            iv_1.setVisibility(View.VISIBLE);
            iv_2.setVisibility(View.GONE);
        } else if ("上门取件".equals(mContent)) {
            iv_1.setVisibility(View.GONE);
            iv_2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_select_type);
        rl_1 = view.findViewById(R.id.rl_1);
        rl_2 = view.findViewById(R.id.rl_2);
        iv_close = view.findViewById(R.id.iv_close);
        iv_1 = view.findViewById(R.id.iv_1);
        iv_2 = view.findViewById(R.id.iv_2);
        tvSave = view.findViewById(R.id.tvSave);

        rl_1.setOnClickListener(this);
        rl_2.setOnClickListener(this);
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
                if(!TextUtils.isEmpty(mContent)){
                    mClick.click(mContent);
                }else {
                    ToastUtils.showShort("请选择交接方式");
                }

                break;
            case R.id.rl_1:
                mContent = "办案单位移送";
                iv_1.setVisibility(View.VISIBLE);
                iv_2.setVisibility(View.GONE);
                break;
            case R.id.rl_2:
                mContent = "上门取件";
                iv_1.setVisibility(View.GONE);
                iv_2.setVisibility(View.VISIBLE);
                break;
            default:
        }
    }
}
