package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.GiftGivingAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.i4a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatGiftViewHolder extends BaseChatViewHolder {
    public ChatGiftViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        GiftGivingAttachment giftGivingAttachment;
        MsgAttachment attachment = iMMessage.getAttachment();
        if (attachment != null) {
            if (attachment instanceof GiftGivingAttachment) {
                giftGivingAttachment = (GiftGivingAttachment) attachment;
            } else {
                try {
                    giftGivingAttachment = (GiftGivingAttachment) new Gson().fromJson(attachment.toJson(false), GiftGivingAttachment.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    giftGivingAttachment = null;
                }
            }
            if (giftGivingAttachment == null) {
                return;
            }
            try {
                setText(R.id.tvCount, "X" + giftGivingAttachment.getCount());
                setText(R.id.tvItemName, giftGivingAttachment.getItemName());
                setText(R.id.tvItemDescription, giftGivingAttachment.getItemDescription());
                if (giftGivingAttachment.getType() == 2) {
                    setText(R.id.tvCreateBy, "制作人：" + giftGivingAttachment.getCreateBy());
                } else {
                    setText(R.id.tvCreateBy, "");
                }
                ImageView imageView = (ImageView) getView(R.id.ivGiftImage);
                if (imageView != null) {
                    Glide.with(imageView).load(giftGivingAttachment.getItemImgUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                i4a.a("自定义赠送礼物消息解析失败");
            }
        }
    }
}
