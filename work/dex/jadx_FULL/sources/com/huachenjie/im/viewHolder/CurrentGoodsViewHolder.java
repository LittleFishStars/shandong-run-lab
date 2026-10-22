package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class CurrentGoodsViewHolder extends BaseChatViewHolder {
    public CurrentGoodsViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareGoodsAttachment shareGoodsAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareGoodsAttachment)) ? new ShareGoodsAttachment() : (ShareGoodsAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.iv_current_goods);
            Glide.with(imageView).load(shareGoodsAttachment.getGoodsImage()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.m).into(imageView);
            setText(R.id.tv_current_goods_name, shareGoodsAttachment.getGoodsName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
