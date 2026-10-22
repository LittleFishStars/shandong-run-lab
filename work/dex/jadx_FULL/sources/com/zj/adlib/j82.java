package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.king.zxing.CaptureHandler;
import com.king.zxing.c;
import com.king.zxing.camera.CameraManager;
import com.king.zxing.d;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class j82 extends Thread {
    public static final String f = "barcode_bitmap";
    public static final String g = "barcode_scaled_factor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f17337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaptureHandler f17338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CameraManager f17339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<DecodeHintType, Object> f17340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CountDownLatch f17341a = new CountDownLatch(1);

    public j82(Context context, CameraManager cameraManager, CaptureHandler captureHandler, Collection<BarcodeFormat> collection, Map<DecodeHintType, Object> map, String str, ResultPointCallback resultPointCallback) {
        this.f42526a = context;
        this.f17339a = cameraManager;
        this.f17338a = captureHandler;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.f17340a = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean(mx6.f43406a, true)) {
                collection.addAll(c.f15047a);
            }
            if (defaultSharedPreferences.getBoolean(mx6.b, true)) {
                collection.addAll(c.b);
            }
            if (defaultSharedPreferences.getBoolean(mx6.c, true)) {
                collection.addAll(c.d);
            }
            if (defaultSharedPreferences.getBoolean(mx6.d, true)) {
                collection.addAll(c.e);
            }
            if (defaultSharedPreferences.getBoolean(mx6.e, false)) {
                collection.addAll(c.f);
            }
            if (defaultSharedPreferences.getBoolean(mx6.f, false)) {
                collection.addAll(c.g);
            }
        }
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        enumMap.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
        u15.l("Hints: " + enumMap);
    }

    public Handler b() {
        try {
            this.f17341a.await();
        } catch (InterruptedException unused) {
        }
        return this.f17337a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f17337a = new d(this.f42526a, this.f17339a, this.f17338a, this.f17340a);
        this.f17341a.countDown();
        Looper.loop();
    }
}
