package com.huachenjie.im.viewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.fx7;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatEmojiStickerViewHolder extends BaseChatViewHolder {
    public int K;
    public int L;

    public ChatEmojiStickerViewHolder(@NonNull View view) {
        super(view);
        f();
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        EmojiStickerAttachment emojiStickerAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof EmojiStickerAttachment)) ? new EmojiStickerAttachment() : (EmojiStickerAttachment) iMMessage.getAttachment();
        try {
            int width = emojiStickerAttachment.getWidth();
            int height = emojiStickerAttachment.getHeight();
            String emojiUrl = emojiStickerAttachment.getEmojiUrl();
            ImageView imageView = (ImageView) getView(R.id.gifImage);
            if (imageView != null) {
                int iMax = Math.max(width, height);
                float f = width / height;
                f();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i = this.L;
                if (iMax < i || iMax > this.K) {
                    if (iMax >= i) {
                        i = this.K;
                    }
                    if (f > 1.0f) {
                        layoutParams.width = i;
                        layoutParams.height = Math.round(i / f);
                    } else {
                        layoutParams.width = Math.round(i * f);
                        layoutParams.height = i;
                    }
                } else {
                    layoutParams.width = width;
                    layoutParams.height = height;
                }
                imageView.setLayoutParams(layoutParams);
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

    public final void f() {
        if (this.K == 0 || this.L == 0) {
            float fE = fx7.e() / 375.0f;
            this.L = Math.round(150.0f * fE);
            this.K = Math.round(fE * 200.0f);
        }
    }
}
