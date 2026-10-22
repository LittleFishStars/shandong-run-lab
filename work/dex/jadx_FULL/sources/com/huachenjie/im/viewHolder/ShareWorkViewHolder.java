package com.huachenjie.im.viewHolder;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.fx7;
import com.zj.adlib.i4a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareWorkViewHolder extends BaseChatViewHolder {
    public int K;
    public int L;
    public int M;

    public ShareWorkViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareWorkAttachment shareWorkAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareWorkAttachment)) ? new ShareWorkAttachment() : (ShareWorkAttachment) iMMessage.getAttachment();
        try {
            int coverWidth = shareWorkAttachment.getCoverWidth();
            int coverHeight = shareWorkAttachment.getCoverHeight();
            boolean z = true;
            int iMax = Math.max(coverWidth, 1);
            int iMax2 = Math.max(coverHeight, 1);
            String coverUrl = shareWorkAttachment.getCoverUrl();
            ImageView imageView = (ImageView) getView(R.id.workImage);
            if (imageView != null) {
                float f = iMax / iMax2;
                f(imageView.getContext());
                if (imageView.getWidth() > 0) {
                    this.M = imageView.getWidth();
                }
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = (int) Math.min(Math.max(this.M / f, this.L), this.K);
                imageView.setLayoutParams(layoutParams);
                Glide.with(imageView).load(coverUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            }
            g(R.id.tvTitle, shareWorkAttachment.getTitle(), "");
            g(R.id.tvLevel, shareWorkAttachment.getChannelName(), "@");
            ((AvatarView) findView(R.id.workAvatar)).loadAvatar(shareWorkAttachment.getAvatar());
            g(R.id.tvNickname, shareWorkAttachment.getNickName(), "");
            String popularityValue = shareWorkAttachment.getPopularityValue();
            if (TextUtils.isEmpty(popularityValue)) {
                popularityValue = "0";
            }
            g(R.id.tvHot, popularityValue, "");
            int i = R.id.ivVideoIcon;
            if (shareWorkAttachment.getType() != 1) {
                z = false;
            }
            setGone(i, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f(Context context) {
        if (this.K == 0 || this.L == 0 || this.M == 0) {
            int iE = fx7.e();
            float fApplyDimension = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
            this.L = Math.round(140.0f * fApplyDimension);
            this.K = Math.round(240.0f * fApplyDimension);
            this.M = iE - Math.round(fApplyDimension * 186.0f);
            i4a.a("view width is " + this.M);
        }
    }

    public final void g(int i, CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(charSequence)) {
            setGone(i, true);
            return;
        }
        setGone(i, false);
        if (!TextUtils.isEmpty(str)) {
            charSequence = str + ((Object) charSequence);
        }
        setText(i, charSequence);
    }
}
