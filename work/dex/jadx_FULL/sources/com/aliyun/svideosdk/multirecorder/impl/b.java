package com.aliyun.svideosdk.multirecorder.impl;

import android.view.SurfaceView;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface b {
    void a(float f);

    void a(float f, float f2);

    void a(float f, float f2, float f3, float f4, EffectBase effectBase);

    void a(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, String str);

    void a(int i);

    void a(int i, long j);

    void a(long j);

    void a(SurfaceView surfaceView);

    void a(EffectImage effectImage, float f, float f2, float f3, float f4, int i);

    void a(EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, String str, float f6);

    void a(CameraParam cameraParam);

    void a(CameraType cameraType);

    void a(FlashType flashType);

    void a(FlashType flashType, boolean z);

    void a(Object obj);

    void a(String str);

    void a(String str, int i);

    void a(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2);

    void a(boolean z);

    void b(float f);

    void b(int i);

    void b(String str);

    void b(String str, int i);

    void b(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2);

    void b(boolean z);

    void c(int i);

    void d(int i);

    void e(int i);

    void f(int i);

    void g(int i);

    void h(int i);
}
