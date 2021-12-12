package com.cysd.pricecontrol;

import android.content.Context;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import razerdp.basepopup.BasePopupWindow;

public class NormalPop extends BasePopupWindow implements View.OnClickListener {

    private EditText ed_content;
    private TextView tv_cancel, tv_submit, tv_type;
    private OnItemClick mClick;

    private String mContent;
    private String mType;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                mClick.click(ed_content.getText().toString().trim());
                break;
            case R.id.tv_cancel:
                dismiss();
                break;
            default:
        }
    }

    public interface OnItemClick {
        void click(String content);
    }

    public NormalPop(Context context, String content, String type, OnItemClick click) {
        super(context);
        mContent = content;
        mType = type;
        mClick = click;

        switch (mType) {
            case "1":
                tv_type.setText("案件名称");
                ed_content.setHint("请输入案件名称");
                break;
            case "2":
                tv_type.setText("案件编号");
                ed_content.setHint("请输入案件编号");
                ed_content.setKeyListener(DigitsKeyListener.getInstance("0123456789"));

                break;
            case "3":
                tv_type.setText("请输入承办单位");
                ed_content.setHint("请输入请输入承办单位");
                break;
            case "4":
                tv_type.setText("请输入交接人");
                ed_content.setHint("请输入请输入交接人");
                break;
            case "5":
                tv_type.setText("交接人联系方式");
                ed_content.setHint("请输入交接人联系方式");
                ed_content.setKeyListener(DigitsKeyListener.getInstance("0123456789"));

                break;
            default:
        }
        ed_content.setText(mContent);
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_normal);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_submit = view.findViewById(R.id.tv_submit);
        tv_type = view.findViewById(R.id.tv_type);
        ed_content = view.findViewById(R.id.ed_content);

        tv_cancel.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
        return view;
    }
}
