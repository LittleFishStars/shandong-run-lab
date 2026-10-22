package com.aliyun.svideosdk.mixrecorder;

import android.graphics.Bitmap;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIMixComposer {
    int cancel();

    AliyunMixTrack createTrack(AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam);

    int pause();

    int release();

    int resume();

    int setBackgroundColor(int i);

    int setBackgroundImage(Bitmap bitmap, int i);

    int setBackgroundImage(String str, int i);

    int setOutputParam(AliyunMixOutputParam aliyunMixOutputParam);

    int start(AliyunMixCallback aliyunMixCallback);
}
