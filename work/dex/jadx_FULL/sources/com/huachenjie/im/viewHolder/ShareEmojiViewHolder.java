package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareEmojiAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareEmojiViewHolder extends BaseChatViewHolder {
    public ShareEmojiViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareEmojiAttachment shareEmojiAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareEmojiAttachment)) ? new ShareEmojiAttachment() : (ShareEmojiAttachment) iMMessage.getAttachment();
        try {
            setText(R.id.emojiName, shareEmojiAttachment.getEmojiBagName());
            String emojiUrl = shareEmojiAttachment.getEmojiUrl();
            ImageView imageView = (ImageView) getView(R.id.emojiImage);
            if (imageView != null) {
                RequestManager requestManagerWith = Glide.with(imageView);
                if (emojiUrl != null && emojiUrl.endsWith(".gif")) {
                    requestManagerWith.asGif();
                }
                if (emojiUrl == null) {
                    emojiUrl = "";
                }
                requestManagerWith.load(emojiUrl).apply((BaseRequestOptions<?>) ju3.l).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
