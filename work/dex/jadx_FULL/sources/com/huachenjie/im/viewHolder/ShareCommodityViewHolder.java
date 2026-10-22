package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareCommodityViewHolder extends BaseChatViewHolder {
    public ShareCommodityViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareCommodityAttachment shareCommodityAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareCommodityAttachment)) ? new ShareCommodityAttachment() : (ShareCommodityAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.commodityImage);
            Glide.with(imageView).load(shareCommodityAttachment.getMainImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.o).into(imageView);
            setText(R.id.commodityTitle, shareCommodityAttachment.getGoodsName());
            setText(R.id.commodityDes, shareCommodityAttachment.getSalePoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
