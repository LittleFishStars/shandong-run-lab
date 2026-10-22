package com.aliyun.svideosdk.editor;

import android.graphics.Bitmap;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface b {
    int addAnimationEff(String str, long j, long j2, String str2);

    int addCaption(AliyunCaption aliyunCaption);

    int addGifTextView(String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2, BitmapGenerator bitmapGenerator, float f6, float f7, float f8, float f9, float f10, int i, int i2, long j3, long j4, boolean z3, long j5);

    int addGifView(String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2);

    int addImgView(Bitmap bitmap, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i);

    int addImgView(BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j, long j2, boolean z, long j3);

    int addImgView(String str, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i);

    int deleteView(int i, int i2);

    List<AliyunCaption> findCaptions(long j);

    int removeCaption(AliyunCaption aliyunCaption);

    int updateAnimationEff(int i, long j, long j2, String str);

    int updateCaption(AliyunCaption aliyunCaption);

    int updateTransition(int i, String str);
}
