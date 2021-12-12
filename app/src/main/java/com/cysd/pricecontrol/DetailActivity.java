package com.cysd.pricecontrol;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cysd.pricecontrol.adapter.ImageAdapter;
import com.cysd.pricecontrol.adapter.SelectImgPop;
import com.cysd.pricecontrol.bean.DetailBean;
import com.cysd.pricecontrol.bean.ImageBean;
import com.cysd.pricecontrol.bean.ImageUpLoadBean;
import com.cysd.pricecontrol.databinding.ActivityDetailBinding;
import com.cysd.pricecontrol.http.HttpNet;
import com.cysd.pricecontrol.http.NetListener;
import com.cysd.pricecontrol.util.SharedPreferenceUtils;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.greenrobot.eventbus.EventBus;

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

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityDetailBinding binding;
    private String mId;

    private NormalPop mPop;
    private SelectTypePop mPop_type;
    private SelectTimePop mPop_time;
    private SelectImgPop mPop_img;

    private String mName;
    private String mNo;
    private String mUnit;
    private String mPerson;
    private String mMobile;
    private String mType;

    private String mStart_year, mStart_month, mStart_day;
    private String mEnd_year, mEnd_month, mEnd_day;

    private ImageAdapter mAdapter;
    private List<ImageBean> mList = new ArrayList<>();
    private List<ImageBean> mList2 = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ImmersionBar.with(this).statusBarDarkFont(true).init();
        mId = getIntent().getStringExtra("id");


        mAdapter = new ImageAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rcImg.setLayoutManager(layoutManager);
        binding.rcImg.setAdapter(mAdapter);
        mList.add(new ImageBean("", "add"));


        binding.rlName.setOnClickListener(this);
        binding.rlMobile.setOnClickListener(this);
        binding.rlNo.setOnClickListener(this);
        binding.rlPerson.setOnClickListener(this);
        binding.rlUnit.setOnClickListener(this);
        binding.rlType.setOnClickListener(this);
        binding.rlTime.setOnClickListener(this);
        binding.tvSave.setOnClickListener(this);
        binding.ivBack.setOnClickListener(this);

        getDetail();
    }

    private void getDetail() {
        HttpNet.getThingDetail(this, mId, new NetListener() {
            @Override
            public void getRetCodeString(String retCode, String result) {
                if ("200".equals(retCode)) {
                    DetailBean bean = new Gson().fromJson(result, DetailBean.class);

                    mName = bean.getData().getInfo().getName();
                    mNo = bean.getData().getInfo().getNumber();
                    mUnit = bean.getData().getInfo().getCompany();
                    mPerson = bean.getData().getInfo().getHandover();
                    mMobile = bean.getData().getInfo().getHandoverMobile();
                    mType = bean.getData().getInfo().getHtype();

                    mStart_year = bean.getData().getInfo().getEscrowStart().substring(0, 4);
                    mStart_month = bean.getData().getInfo().getEscrowStart().substring(5, 7);
                    mStart_day = bean.getData().getInfo().getEscrowStart().substring(8, 10);

                    mEnd_year = bean.getData().getInfo().getEscrowEnd().substring(0, 4);
                    mEnd_month = bean.getData().getInfo().getEscrowEnd().substring(5, 7);
                    mEnd_day = bean.getData().getInfo().getEscrowEnd().substring(8, 10);

                    binding.tvName.setText(bean.getData().getInfo().getName());
                    binding.tvNo.setText(bean.getData().getInfo().getNumber());
                    binding.tvUnit.setText(bean.getData().getInfo().getCompany() + "");
                    binding.tvPerson.setText(bean.getData().getInfo().getHandover() + "");
                    binding.tvMobile.setText(bean.getData().getInfo().getHandoverMobile() + "");
                    binding.tvType.setText(bean.getData().getInfo().getHtype());
                    binding.tvTime.setText(bean.getData().getInfo().getEscrowStart() + "-" +
                            bean.getData().getInfo().getEscrowEnd());
                    binding.edRemark.setText(bean.getData().getInfo().getRemark() + "");

                    mList.clear();
                    list.clear();
                    for (int i = 0; i < bean.getData().getInfo().getImage().size(); i++) {
                        mList.add(new ImageBean(bean.getData().getImageUrl() + bean.getData().getInfo().getImage().get(i), ""));
                        list.add(bean.getData().getInfo().getImage().get(i));
                    }

                    if (mList.size() < 9) {
                        mList.add(new ImageBean("", "add"));

                    }
                    mAdapter.setList(mList);

                    mAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                            if ("add".equals(mList.get(position).getType())) {
                                showImgPop();
                            }
                        }
                    });
                    mAdapter.addChildClickViewIds(R.id.ll_delete);
                    mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                            list.remove(position);
                            mList.remove(position);
                            mAdapter.removeAt(position);
                        }
                    });
                }
            }
        });
    }

    //图片选择
    private void showImgPop() {
        mPop_img = new SelectImgPop(this, new SelectImgPop.OnClick() {
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

    private void openPhoto() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .maxSelectNum(10 - mList.size())
                .compress(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    private void openCamera() {
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())
                .compress(true)
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                update();
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

    //修改
    private void update() {
        HttpNet.updateThingDetail(this, mId, mName, mNo, mUnit, mPerson, mMobile, mType,
                mStart_year + "." + mStart_month + "." + mStart_day,
                mEnd_year + "." + mEnd_month + "." + mEnd_day, binding.edRemark.getText().toString().trim(),
                list, new NetListener() {
                    @Override
                    public void getRetCodeString(String retCode, String result) {
                        if ("200".equals(retCode)) {
                            EventBus.getDefault().post("refresh");
                            finish();
                        }
                    }
                });
    }

    private void showPop(String content, String type) {
        mPop = new NormalPop(this, content, type, new NormalPop.OnItemClick() {
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
        mPop.setPopupGravity(Gravity.CENTER);
        mPop.showPopupWindow();

        showSoftKeyboard();
    }

    //显示键盘
    public void showSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void showTypePop(String content) {
        mPop_type = new SelectTypePop(this, content, new SelectTypePop.onClick() {
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

    //选择时间
    private void showTimePop(String startYear, String startMonth, String startDay,
                             String endYear, String endMonth, String endDay) {
        mPop_time = new SelectTimePop(this, startYear, startMonth, startDay,
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            List<LocalMedia> selectListRequest = PictureSelector.obtainMultipleResult(data);
            mList2.clear();
            for (int i = 0; i < selectListRequest.size(); i++) {
                mList.add(0, new ImageBean(selectListRequest.get(i).getCompressPath(), ""));
                mList2.add(0, new ImageBean(selectListRequest.get(i).getCompressPath(), ""));

            }

            uploadImg(mList2);
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
                    .addHeader("token", SharedPreferenceUtils.getLoginSp(this))
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
        if (mList.size() == 10) {
            for (int i = mList.size() - 1; i >= 0; i--) {
                if ("add".equals(mList.get(i).getType())) {
                    mList.remove(i);
                }
            }
        }

        mAdapter.setList(mList);

    }
}
