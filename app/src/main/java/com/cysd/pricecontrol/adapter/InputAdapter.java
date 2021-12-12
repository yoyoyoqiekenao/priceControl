package com.cysd.pricecontrol.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.bean.ThingListBean;
import com.cysd.pricecontrol.util.DensityUtil;

public class InputAdapter extends BaseQuickAdapter<ThingListBean.DataDTO.ListDTO, BaseViewHolder> {
    public InputAdapter() {
        super(R.layout.item_input);
    }

    private String imgUrl;

    public void setImgUrl(String url) {
        imgUrl = url;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ThingListBean.DataDTO.ListDTO listDTO) {
        baseViewHolder.setText(R.id.tv_no, "案件编号" + listDTO.getNumber() + "");
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.iv_img_add)
                .transforms(new RoundedCorners(DensityUtil.dip2px(getContext(), 4)));
        Glide.with(getContext()).load(imgUrl + listDTO.getImageUse()).apply(options)
                .into((ImageView) baseViewHolder.getView(R.id.iv));
        baseViewHolder.setText(R.id.tv_name, listDTO.getName() + "");
        baseViewHolder.setText(R.id.tv_person, "交接人:" + listDTO.getHandover() + "");
        baseViewHolder.setText(R.id.tv_addTime, listDTO.getAddDate() + "");
        baseViewHolder.setText(R.id.tv_time, listDTO.getEscrowStart() + "至" + listDTO.getEscrowEnd());

        ImageView iv_check = baseViewHolder.getView(R.id.iv_check);
        if (!TextUtils.isEmpty(listDTO.getCheck())) {
            iv_check.setImageResource(R.mipmap.iv_check);
        } else {
            iv_check.setImageResource(R.mipmap.iv_uncheck);
        }
    }
}
