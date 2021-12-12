package com.cysd.pricecontrol.adapter;

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

public class TwoAdapter extends BaseQuickAdapter<ThingListBean.DataDTO.ListDTO, BaseViewHolder> {
    public TwoAdapter() {
        super(R.layout.item_two);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ThingListBean.DataDTO.ListDTO listDTO) {
        baseViewHolder.setText(R.id.tv_no, "案件编号" + listDTO.getNumber() + "");
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.iv_img_add)
                .transforms(new RoundedCorners(DensityUtil.dip2px(getContext(), 4)));
        Glide.with(getContext()).load(listDTO.getImageUse()).apply(options)
                .into((ImageView) baseViewHolder.getView(R.id.iv));
        baseViewHolder.setText(R.id.tv_name, listDTO.getName() + "");
        baseViewHolder.setText(R.id.tv_person, "交接人:" + listDTO.getHandover() + "");
        baseViewHolder.setText(R.id.tv_addTime, listDTO.getAddDate() + "");
        baseViewHolder.setText(R.id.tv_time, listDTO.getEscrowStart() + "至" + listDTO.getEscrowEnd());
    }
}
