package com.kc.bw.common.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CustomVideoView extends VideoView {
    public int mVideoHeight;
    public int mVideoWidth;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(this.mVideoWidth, i), View.getDefaultSize(this.mVideoHeight, i2));
    }

    public void setVolume(float f, VideoView videoView) {
        try {
            Field declaredField = Class.forName(dexg.dexa("boespje/xjehfu/WjefpWjfx")).getDeclaredField(dexg.dexa("nNfejbQmbzfs"));
            declaredField.setAccessible(true);
            MediaPlayer mediaPlayer = (MediaPlayer) declaredField.get(videoView);
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f, f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
