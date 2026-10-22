package com.aliyun.svideosdk.multirecorder;

import android.graphics.Bitmap;
import android.net.Uri;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import com.aliyun.svideosdk.recorder.EncoderInfoCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIVideoRecorder {
    int addWaterMark(EffectImage effectImage);

    void cancelRecording();

    int clearBackground();

    void destroy();

    int finishRecording();

    Uri finishRecordingForEdit();

    AliyunIClipManager getClipManager();

    AliyunIVideoCapture getVideoCapture();

    void prepare();

    void removeMusic();

    int removeWaterMark(EffectImage effectImage);

    int setBackgroundColor(int i);

    int setBackgroundDisplayMode(int i);

    int setBackgroundImage(Bitmap bitmap);

    int setBackgroundImage(String str);

    void setEncoderInfoCallback(EncoderInfoCallback encoderInfoCallback);

    void setIsAutoClearClipVideos(boolean z);

    int setMicDenoiseWeight(int i);

    void setMixAudioWeight(int i, int i2);

    int setMusic(String str, long j, long j2);

    void setMute(boolean z);

    void setOnAudioCallback(OnAudioCallBack onAudioCallBack);

    void setOnRecordListener(OnVideoRecordListener onVideoRecordListener);

    void setOpenMicAEC(boolean z);

    void setOpenMixAudioMode(boolean z);

    void setRate(float f);

    int startPreview();

    int startRecording();

    void stopPreview();

    int stopRecording();

    int updateVideoSize(int i, int i2);

    String version();
}
