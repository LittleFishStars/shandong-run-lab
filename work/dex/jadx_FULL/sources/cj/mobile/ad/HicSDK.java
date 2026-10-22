package cj.mobile.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJIconListener;
import cj.mobile.p.h;
import com.hxad.sdk.ling.ic.bh.ad.bean.BHAdInfo;
import com.hxad.sdk.ling.ic.bh.ad.impl.BHServiceAd;
import com.hxad.sdk.ling.ic.bh.ad.listener.BHBannerAdListener;
import com.hxad.sdk.ling.ic.bh.exception.BHAdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class HicSDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f22067a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public String f;
    public String g;
    public Context h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public FrameLayout m;
    public Handler n;

    /* JADX INFO: renamed from: cj.mobile.ad.HicSDK$2, reason: invalid class name */
    public class AnonymousClass2 extends BHBannerAdListener {
        public final /* synthetic */ HicSDK this$0;
        public final /* synthetic */ String val$cjPosId;
        public final /* synthetic */ h val$itemListener;
        public final /* synthetic */ CJIconListener val$listener;
        public final /* synthetic */ String val$posId;
        public final /* synthetic */ String val$requestId;
        public final /* synthetic */ BHServiceAd val$serviceAd;

        public AnonymousClass2(HicSDK hicSDK, BHServiceAd bHServiceAd, String str, String str2, h hVar, String str3, CJIconListener cJIconListener) {
        }

        public void onAdClick(BHAdInfo bHAdInfo) {
        }

        public void onAdClick(BHAdInfo bHAdInfo, String str) {
        }

        public void onAdClose(BHAdInfo bHAdInfo) {
        }

        public void onAdExpose(BHAdInfo bHAdInfo) {
        }

        public void onAdFailed(BHAdError bHAdError) {
        }

        public void onAdReceive(BHAdInfo bHAdInfo) {
        }
    }

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HicSDK f22068a;

        public a(HicSDK hicSDK, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public HicSDK b(int i) {
        this.b = i;
        return this;
    }

    public void a(Context context, String str, String str2) {
    }

    public View a() {
        return this.m;
    }

    public HicSDK a(boolean z) {
        this.d = z;
        return this;
    }

    public HicSDK a(int i) {
        this.c = i;
        return this;
    }

    public HicSDK a(boolean z, boolean z2, boolean z3) {
    }

    public void a(Activity activity, String str, String str2, String str3, CJIconListener cJIconListener, h hVar) {
    }
}
