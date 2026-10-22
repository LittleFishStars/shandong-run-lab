package com.kc.openset.sdk.apiad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.apiad.tools.c;
import com.kc.openset.util.ApkDownloader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETDownloadActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ApkDownloader f39880a;
    private c b;

    @Keep
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETDownloadActivity f39881a;

        static {
            OSETSDKProtected.interface11(4810);
        }

        public a(OSETDownloadActivity oSETDownloadActivity) {
            this.f39881a = oSETDownloadActivity;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETDownloadActivity f39882a;

        static {
            OSETSDKProtected.interface11(4811);
        }

        public b(OSETDownloadActivity oSETDownloadActivity) {
            this.f39882a = oSETDownloadActivity;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    static {
        OSETSDKProtected.interface11(4812);
    }

    public static native /* synthetic */ c a(OSETDownloadActivity oSETDownloadActivity);

    public static native void a(Context context, c cVar);

    private native boolean a();

    public static native /* synthetic */ ApkDownloader b(OSETDownloadActivity oSETDownloadActivity);

    private native void b();

    public native String a(c cVar);

    @Override // android.app.Activity
    public native void finish();

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onDestroy();

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public native boolean onKeyDown(int i, KeyEvent keyEvent);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public native boolean onKeyUp(int i, KeyEvent keyEvent);

    @Override // android.app.Activity
    public native void onRestoreInstanceState(Bundle bundle);

    @Override // android.app.Activity
    public native void onSaveInstanceState(Bundle bundle);

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public native void startActivity(Intent intent);
}
