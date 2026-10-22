package com.kc.openset.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f40006a;

    static {
        OSETSDKProtected.interface11(5078);
    }

    public a(int i) {
        this.f40006a = i;
    }

    @Override // android.view.ViewOutlineProvider
    public native void getOutline(View view, Outline outline);
}
