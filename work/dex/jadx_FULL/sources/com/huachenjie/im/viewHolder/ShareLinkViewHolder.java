package com.huachenjie.im.viewHolder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareLinkAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareLinkViewHolder extends BaseChatViewHolder {
    public ShareLinkViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareLinkAttachment shareLinkAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareLinkAttachment)) ? new ShareLinkAttachment() : (ShareLinkAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.share_link_image);
            Glide.with(imageView).load(shareLinkAttachment.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.o).into(imageView);
            if (TextUtils.isEmpty(shareLinkAttachment.getTitle())) {
                int i = R.id.share_link_title;
                setText(i, "");
                setGone(i, true);
            } else {
                int i2 = R.id.share_link_title;
                setText(i2, shareLinkAttachment.getTitle());
                setGone(i2, false);
            }
            if (TextUtils.isEmpty(shareLinkAttachment.getDesc())) {
                int i3 = R.id.share_link_des;
                setText(i3, "");
                setGone(i3, true);
            } else {
                int i4 = R.id.share_link_des;
                setText(i4, shareLinkAttachment.getDesc());
                setGone(i4, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
