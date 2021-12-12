package com.cysd.pricecontrol.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.bean.ImageBean;
import com.cysd.pricecontrol.util.DensityUtil;

public class ImageAdapter extends BaseQuickAdapter<ImageBean, BaseViewHolder> {
    public ImageAdapter() {
        super(R.layout.item_image);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImageBean imageBean) {
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.iv_img_add)
                .transforms(new RoundedCorners(DensityUtil.dip2px(getContext(), 4)));
        Glide.with(getContext()).load(imageBean.getImgUrl()).apply(options)
                .into((ImageView) baseViewHolder.getView(R.id.iv));


    }
}
