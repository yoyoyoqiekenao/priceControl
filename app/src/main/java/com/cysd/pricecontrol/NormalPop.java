package com.cysd.pricecontrol;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cysd.pricecontrol.util.ToastUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                if ("5".equals(mType)) {
                    if (isMobilPhone(ed_content.getText().toString().trim())) {
                        mClick.click(ed_content.getText().toString().trim());
                    } else {
                        ToastUtils.showShort("手机号格式输入错误");
                    }
                } else {
                    mClick.click(ed_content.getText().toString().trim());
                }

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
                //ed_content.setKeyListener(DigitsKeyListener.getInstance("0123456789"));

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

    public static boolean isMobilPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        //String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        String regex = "^1\\d{10}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            return isMatch;
        }
    }
}
