package com.huachenjie.im.viewHolder;

import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.im.R;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.f64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatAudioViewHolder extends BaseChatViewHolder {
    public ChatAudioViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        AudioAttachment attachment = iMMessage.getAttachment();
        if (attachment == null || !(attachment instanceof AudioAttachment)) {
            setText(R.id.tvAudio, "0S");
        } else {
            setText(R.id.tvAudio, String.format("%dS", Long.valueOf(attachment.getDuration() / 1000)));
        }
        if (f64.b().c().equals(iMMessage.getUuid())) {
            setGone(R.id.ivAudio, true);
            int i = R.id.jsonAudio;
            setGone(i, false);
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) getView(i);
            lottieAnimationView.post(new Runnable() { // from class: com.zj.adlib.bj1
                @Override // java.lang.Runnable
                public final void run() {
                    lottieAnimationView.playAnimation();
                }
            });
            return;
        }
        setGone(R.id.ivAudio, false);
        int i2 = R.id.jsonAudio;
        setGone(i2, true);
        final LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getView(i2);
        lottieAnimationView2.post(new Runnable() { // from class: com.zj.adlib.cj1
            @Override // java.lang.Runnable
            public final void run() {
                lottieAnimationView2.cancelAnimation();
            }
        });
    }
}
