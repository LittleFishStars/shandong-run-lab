package com.kc.openset.e;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.notch.INotchScreen;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a implements INotchScreen {

    /* JADX INFO: renamed from: com.kc.openset.e.a$a, reason: collision with other inner class name */
    @Keep
    public class RunnableC1112a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f39762a;
        final INotchScreen.NotchSizeCallback b;
        final a c;

        static {
            OSETSDKProtected.interface11(4419);
        }

        public RunnableC1112a(a aVar, View view, INotchScreen.NotchSizeCallback notchSizeCallback) {
            this.c = aVar;
            this.f39762a = view;
            this.b = notchSizeCallback;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    static {
        OSETSDKProtected.interface11(4420);
    }

    @Override // com.kc.openset.util.notch.INotchScreen
    public native void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback);

    @Override // com.kc.openset.util.notch.INotchScreen
    public native boolean hasNotch(Activity activity);

    @Override // com.kc.openset.util.notch.INotchScreen
    public native void setDisplayInNotch(Activity activity);
}
