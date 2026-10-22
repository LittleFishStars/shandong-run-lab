package com.kc.openset.util;

import android.content.Context;
import android.util.Pair;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OAIDUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CountDownLatch f39947a;
    private static final CountDownLatch b;
    private static final CountDownLatch c;
    private static final List<c> d;
    private static final List<OAIDType> e;
    private static String f;
    private static String g;
    private static boolean h;
    private static boolean i;

    @Keep
    public enum OAIDType {
        OAID_API(OSETSDKProtected.getString2(3174)),
        OAID_AAR(OSETSDKProtected.getString2(3176)),
        OAID_FW(OSETSDKProtected.getString2(3178)),
        OAID_WM(OSETSDKProtected.getString2(3180)),
        OAID_ZY(OSETSDKProtected.getString2(3182));

        private String name;

        static {
            OSETSDKProtected.interface11(4955);
        }

        OAIDType(String str) {
            this.name = str;
        }

        public static native /* synthetic */ String access$000(OAIDType oAIDType);

        public static native OAIDType valueOf(String str);

        public static native OAIDType[] values();
    }

    @Keep
    public interface OnOAIDLoadCompleteListener {
        void onAllOAIDLoadComplete(List<c> list);

        void onSsOAIDLoadComplete(Pair<String, String> pair);
    }

    @Keep
    public class a implements OAIDHelper.OAIDLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f39948a;

        static {
            OSETSDKProtected.interface11(4957);
        }

        public a(long j) {
            this.f39948a = j;
        }

        @Override // com.kc.openset.util.OAIDHelper.OAIDLoadListener
        public native void OnError(int i, String str);

        @Override // com.kc.openset.util.OAIDHelper.OAIDLoadListener
        public native void onSuccess(String str);
    }

    @Keep
    public class b implements IGetter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f39949a;

        static {
            OSETSDKProtected.interface11(4958);
        }

        public b(long j) {
            this.f39949a = j;
        }

        @Override // com.kc.openset.oaid.IGetter
        public native void onOAIDGetComplete(String str);

        @Override // com.kc.openset.oaid.IGetter
        public native void onOAIDGetError(Exception exc);
    }

    @Keep
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f39950a;
        String b;
        String c;
        boolean d;

        static {
            OSETSDKProtected.interface11(4959);
        }

        public c(OAIDType oAIDType, String str) {
            this.f39950a = "";
            this.b = "";
            this.c = str;
            this.b = OAIDType.access$000(oAIDType);
        }

        public c(String str, OAIDType oAIDType) {
            this.b = "";
            this.c = "";
            this.f39950a = str;
            this.b = OAIDType.access$000(oAIDType);
            this.d = DeviceIdUtils.a(str);
        }

        public native String a();

        public native String b();

        public native String c();

        public native boolean d();

        public native String toString();
    }

    public static native /* synthetic */ void $r8$lambda$6sZFCvfz2S4WeUX9HzhgZ0UhgbA(Method method, Context context);

    public static native /* synthetic */ void $r8$lambda$9xBjvnD6zMfWivoBIcAPiNcxr80(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    /* JADX INFO: renamed from: $r8$lambda$FBgPhB-pYD1pg_qoay-ItYdArAI, reason: not valid java name */
    public static native /* synthetic */ void m1049$r8$lambda$FBgPhBpYD1pg_qoayItYdArAI(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    /* JADX INFO: renamed from: $r8$lambda$GWY73HK3pzh9l4-zd9TekQImpe0, reason: not valid java name */
    public static native /* synthetic */ Object m1050$r8$lambda$GWY73HK3pzh9l4zd9TekQImpe0(Object obj, Method method, Object[] objArr);

    /* JADX INFO: renamed from: $r8$lambda$fpvOhUPF9J075ke-aCtS_I_XVk0, reason: not valid java name */
    public static native /* synthetic */ void m1051$r8$lambda$fpvOhUPF9J075keaCtS_I_XVk0(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    /* JADX INFO: renamed from: $r8$lambda$iP9SHAqq0b-CcKq6fIM_EzzvgcM, reason: not valid java name */
    public static native /* synthetic */ void m1052$r8$lambda$iP9SHAqq0bCcKq6fIM_EzzvgcM(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    public static native /* synthetic */ void $r8$lambda$mRoMW74FYl6PAgvwbWkKLAukcbM(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    /* JADX INFO: renamed from: $r8$lambda$vQWwu8cjWL-zsC-1bDAn1Vfu5Ko, reason: not valid java name */
    public static native /* synthetic */ Object m1053$r8$lambda$vQWwu8cjWLzsC1bDAn1Vfu5Ko(Object obj, Method method, Object[] objArr);

    static {
        OSETSDKProtected.interface11(4960);
        f39947a = new CountDownLatch(5);
        b = new CountDownLatch(2);
        c = new CountDownLatch(1);
        d = Collections.synchronizedList(new ArrayList());
        e = Collections.synchronizedList(new ArrayList());
        f = "";
        g = "";
        h = false;
        i = false;
    }

    private static native /* synthetic */ Object a(Object obj, Method method, Object[] objArr);

    public static native /* synthetic */ String a(String str);

    public static native /* synthetic */ List a();

    public static native void a(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    private static native /* synthetic */ void a(Method method, Context context);

    private static native /* synthetic */ Object b(Object obj, Method method, Object[] objArr);

    public static native /* synthetic */ String b(String str);

    public static native /* synthetic */ CountDownLatch b();

    private static native /* synthetic */ void b(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    public static native /* synthetic */ List c();

    private static native /* synthetic */ void c(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    public static native /* synthetic */ CountDownLatch d();

    private static native /* synthetic */ void d(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    public static native /* synthetic */ CountDownLatch e();

    private static native /* synthetic */ void e(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    private static native void f();

    private static native /* synthetic */ void f(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    private static native void g();

    private static native void g(OnOAIDLoadCompleteListener onOAIDLoadCompleteListener);

    private static native void h();

    private static native void i();

    private static native void j();
}
