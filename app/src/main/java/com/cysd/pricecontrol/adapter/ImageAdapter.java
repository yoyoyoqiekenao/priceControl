package com.cysd.pricecontrol.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cysd.pricecontrol.R;
import com.cysd.pricecontrol.bean.ImageBean;

public class ImageAdapter extends BaseQuickAdapter<ImageBean, BaseViewHolder> {
    public ImageAdapter() {
        super(R.layout.item_image);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ImageBean imageBean) {

    }
}
