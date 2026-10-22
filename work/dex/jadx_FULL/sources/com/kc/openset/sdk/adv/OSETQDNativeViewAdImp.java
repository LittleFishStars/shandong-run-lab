package com.kc.openset.sdk.adv;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.QDImages;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.OnAdTouchListener;
import com.kc.openset.sdk.apiad.tools.i;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETQDNativeViewAdImp implements OSETQDNativeViewAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.kc.openset.sdk.apiad.tools.c f39813a;
    private QDNativeViewInnerListener b;
    private View c;
    private OSETQDNativeViewAd.OnQDAdInteractionListener d;
    private boolean e = true;

    @Keep
    public interface QDNativeViewInnerListener {
        View getRotateView(Context context);

        int[] getTiltSensorSen();

        View getVideoView(Context context);

        boolean isClickCallback();

        boolean isUsable();

        void onClick(View view, OSETClicksData oSETClicksData);

        void onClose(ViewGroup viewGroup);

        void onShow(ViewGroup viewGroup);
    }

    @Keep
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ViewGroup f39814a;
        final OSETQDNativeViewAd.OnQDAdInteractionListener b;
        final OSETQDNativeViewAdImp c;

        static {
            OSETSDKProtected.interface11(4695);
        }

        public a(OSETQDNativeViewAdImp oSETQDNativeViewAdImp, ViewGroup viewGroup, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener) {
            this.c = oSETQDNativeViewAdImp;
            this.f39814a = viewGroup;
            this.b = onQDAdInteractionListener;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public native boolean onPreDraw();
    }

    @Keep
    public class b extends OnAdTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f39815a;
        final OSETQDNativeViewAd.OnQDAdInteractionListener b;
        final OSETQDNativeViewAdImp c;

        static {
            OSETSDKProtected.interface11(4696);
        }

        public b(OSETQDNativeViewAdImp oSETQDNativeViewAdImp, View view, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener) {
            this.c = oSETQDNativeViewAdImp;
            this.f39815a = view;
            this.b = onQDAdInteractionListener;
        }

        @Override // com.kc.openset.sdk.apiad.tools.OnAdTouchListener
        public native void touchAd(View view, i iVar, i iVar2);
    }

    @Keep
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ViewGroup f39816a;
        final OSETQDNativeViewAd.OnQDAdInteractionListener b;
        final OSETQDNativeViewAdImp c;

        static {
            OSETSDKProtected.interface11(4697);
        }

        public c(OSETQDNativeViewAdImp oSETQDNativeViewAdImp, ViewGroup viewGroup, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener) {
            this.c = oSETQDNativeViewAdImp;
            this.f39816a = viewGroup;
            this.b = onQDAdInteractionListener;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39817a;
        final String b;
        final int c;
        final OSETQDNativeViewAdImp d;

        static {
            OSETSDKProtected.interface11(4698);
        }

        public d(OSETQDNativeViewAdImp oSETQDNativeViewAdImp, Context context, String str, int i) {
            this.d = oSETQDNativeViewAdImp;
            this.f39817a = context;
            this.b = str;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    static {
        OSETSDKProtected.interface11(4699);
    }

    public OSETQDNativeViewAdImp(com.kc.openset.sdk.apiad.tools.c cVar) {
        this.f39813a = cVar;
    }

    public static native /* synthetic */ QDNativeViewInnerListener a(OSETQDNativeViewAdImp oSETQDNativeViewAdImp);

    private native void a(Context context, TextView textView, String str, int i);

    public static native /* synthetic */ boolean b(OSETQDNativeViewAdImp oSETQDNativeViewAdImp);

    public static native /* synthetic */ com.kc.openset.sdk.apiad.tools.c c(OSETQDNativeViewAdImp oSETQDNativeViewAdImp);

    public native View a();

    public native void a(QDNativeViewInnerListener qDNativeViewInnerListener);

    public native void b();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native void bindPrivacyInfoClickListener(Context context, TextView textView, TextView textView2, TextView textView3);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean enableRotate();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdActionText();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdContent();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native int getAdEcpm();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdIcon();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native List<QDImages> getAdImageUrls();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdSource();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdSourceImg();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdTitle();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppDeveloper();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppName();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppPrivacyInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppVersion();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getIntroductionInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getPackageName();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getPermissionInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getRequestId();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native View getRotateView(Context context);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getVideoCoverImageUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native View getVideoView(Context context);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isAppInfoVisibility();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isUsable();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isVideoMaterial();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener);
}
