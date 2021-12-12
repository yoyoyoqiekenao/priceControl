package com.cysd.pricecontrol.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cysd.pricecontrol.DetailActivity;
import com.cysd.pricecontrol.GlideCacheEngine;
import com.cysd.pricecontrol.GlideEngine;
import com.cysd.pricecontrol.NormalPop;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.SelectTimePop;
import com.cysd.pricecontrol.SelectTypePop;
import com.cysd.pricecontrol.adapter.ImageAdapter;
import com.cysd.pricecontrol.adapter.SelectImgPop;
import com.cysd.pricecontrol.bean.ImageBean;
import com.cysd.pricecontrol.bean.ImageUpLoadBean;
import com.cysd.pricecontrol.databinding.FragmentOneBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.cysd.pricecontrol.util.ToastUtils;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.SdkVersionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

public class OneFragment extends Fragment implements View.OnClickListener {

    private FragmentOneBinding binding;
    private NormalPop mPop;
    private SelectTypePop mPop_type;
    private SelectTimePop mPop_time;
    private SelectImgPop mPop_img;
    private ImageAdapter mAdapter;


    private String mName;
    private String mNo;
    private String mUnit;
    private String mPerson;
    private String mMobile;
    private String mType;

    private String mStart_year, mStart_month, mStart_day;
    private String mEnd_year, mEnd_month, mEnd_day;

    private List<ImageBean> mList = new ArrayList<>();
    private List<String> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOneBinding.inflate(inflater, container, false);
        ImmersionBar.with(getActivity()).statusBarView(binding.view).statusBarDarkFont(true).init();


        mAdapter = new ImageAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rcImg.setLayoutManager(layoutManager);
        binding.rcImg.setAdapter(mAdapter);
        mList.add(new ImageBean("", "add"));

        mAdapter.setList(mList);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if ("add".equals(mList.get(position).getType())) {
                    showImgPop();
                }
            }
        });


        binding.rlName.setOnClickListener(this);
        binding.rlMobile.setOnClickListener(this);
        binding.rlNo.setOnClickListener(this);
        binding.rlPerson.setOnClickListener(this);
        binding.rlUnit.setOnClickListener(this);
        binding.rlType.setOnClickListener(this);
        binding.rlTime.setOnClickListener(this);
        binding.tvSave.setOnClickListener(this);
        return binding.getRoot();
    }

    //图片选择
    private void showImgPop() {
        mPop_img = new SelectImgPop(getContext(), new SelectImgPop.OnClick() {
            @Override
            public void click(int position) {
                if (0 == position) {
                    openPhoto();
                } else if (1 == position) {
                    openCamera();
                }
                mPop_img.dismiss();
            }
        });
        mPop_img.setOutSideDismiss(true);
        mPop_img.setPopupGravity(Gravity.BOTTOM);
        mPop_img.showPopupWindow();
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
            case R.id.tv_save:
                save();
                break;
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

    private void save() {
        if (list.size() > 0) {
            HttpNet.save(getContext(), mName, mNo, mUnit, mPerson, mMobile, mType, mStart_year + "." + mStart_month + "." + mStart_day,
                    mEnd_year + "." + mEnd_month + "." + mEnd_day, binding.edRemark.getText().toString().trim(), list, new NetListener() {
                        @Override
                        public void getRetCodeString(String retCode, String result) {
                            if ("200".equals(retCode)) {
                                mName = "";
                                mNo = "";
                                mUnit = "";
                                mPerson = "";
                                mMobile = "";
                                mType = "";
                                mStart_year = "";
                                mStart_month = "";
                                mStart_day = "";
                                mEnd_year = "";
                                mEnd_month = "";
                                mEnd_day = "";
                                binding.edRemark.setText("");
                                list.clear();
                                mList.clear();

                                binding.tvName.setText(mName);
                                binding.tvNo.setText(mNo);
                                binding.tvUnit.setText(mUnit);
                                binding.tvPerson.setText(mPerson);
                                binding.tvMobile.setText(mMobile);
                                binding.tvType.setText(mType);
                                binding.tvTime.setText("");
                                mAdapter.setList(mList);


                                ToastUtils.showShort("录入成功,请到物品页查看");
                            }
                        }
                    });
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

    private void openCamera() {
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .compress(true)
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    private void openPhoto() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .maxSelectNum(9 - mList.size())
                .compress(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            List<LocalMedia> selectListRequest = PictureSelector.obtainMultipleResult(data);

            for (int i = 0; i < selectListRequest.size(); i++) {
                mList.add(new ImageBean(selectListRequest.get(i).getCompressPath(), ""));
            }
            Log.d("xuwudi", "数据===" + mList.toString());
            uploadImg(mList);
        }

    }


    private void uploadImg(List<ImageBean> imgList) {

        for (int i = 0; i < imgList.size(); i++) {
            OkHttpClient okHttpClient = new OkHttpClient();
            File file = new File(imgList.get(i).getImgUrl());
            RequestBody image = RequestBody.create(MediaType.parse("image/jpeg"), file);
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", imgList.get(i).getImgUrl(), image)
                    .build();
            Request request = new Request.Builder()
                    .url("http://139.196.162.235/index.php/api/index/upload")
                    .addHeader("token", SharedPreferenceUtils.getLoginSp(getContext()))
                    .post(requestBody)
                    .build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Gson gson = new Gson();
                    ImageUpLoadBean bean = gson.fromJson(response.body().string(), ImageUpLoadBean.class);
                    list.add(bean.getData().getUrl());
                }
            });


        }
        if (imgList.size() < 9) {
            imgList.add(new ImageBean("", "add"));
        }
        mAdapter.setList(imgList);

    }
}
