package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.comm.managers.GDTAdSdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class d extends BaseInit {

    @Keep
    public class a implements GDTAdSdk.OnStartListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39670a;

        static {
            OSETSDKProtected.interface11(3938);
        }

        public a(d dVar) {
            this.f39670a = dVar;
        }

        public native void onStartFailed(Exception exc);

        public native void onStartSuccess();
    }

    static {
        OSETSDKProtected.interface11(3939);
    }

    public static native int a(WinAdData winAdData);

    public static native String a(Map<String, Object> map);

    public static native HashMap<String, Object> a(int i);

    public static native Map<String, Object> a(boolean z, WinAdData winAdData);

    private static native void a();

    public static native /* synthetic */ void a(d dVar, String str);

    public static native /* synthetic */ void b(d dVar, String str);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void startTestTool(Activity activity);
}
