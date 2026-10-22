package com.huachenjie.im.viewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.im.R;
import com.netease.nimlib.sdk.msg.attachment.ImageAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.fx7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatImageViewHolder extends BaseChatViewHolder {
    public int K;
    public int L;

    public ChatImageViewHolder(@NonNull View view) {
        super(view);
        f();
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ImageAttachment imageAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ImageAttachment)) ? new ImageAttachment() : (ImageAttachment) iMMessage.getAttachment();
        try {
            int width = imageAttachment.getWidth();
            int height = imageAttachment.getHeight();
            String url = imageAttachment.getUrl();
            ImageView imageView = (ImageView) getView(R.id.ivImage);
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
                Glide.with(imageView).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        if (this.K == 0 || this.L == 0) {
            int iE = fx7.e();
            int iRound = Math.round((iE / 375.0f) * 60.0f);
            this.L = iRound;
            this.K = Math.round((iE - iRound) / 2.0f);
        }
    }
}
