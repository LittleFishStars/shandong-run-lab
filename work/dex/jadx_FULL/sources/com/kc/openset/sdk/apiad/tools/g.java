package com.kc.openset.sdk.apiad.tools;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class g {

    @Keep
    public class a extends OnDoubleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39922a;
        final Context b;

        static {
            OSETSDKProtected.interface11(4891);
        }

        public a(c cVar, Context context) {
            this.f39922a = cVar;
            this.b = context;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnDoubleClickListener
        public native void onDoubleClick(View view);
    }

    public static native /* synthetic */ void $r8$lambda$f88S4KcQUo9lhjDWqKP0ouKEHdA(View view, long j);

    static {
        OSETSDKProtected.interface11(4892);
    }

    public static native String a();

    public static native void a(Context context, View view, c cVar);

    public static native void a(Context context, ImageView imageView, int i, String str);

    private static native /* synthetic */ void a(View view, long j);

    public static native void b(View view, long j);
}
