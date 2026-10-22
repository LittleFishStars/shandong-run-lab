package cj.mobile.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJSplashListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cj.mobile.e.a f21970a;
    public cj.mobile.f.a b;
    public cj.mobile.d.a c;
    public String d;
    public String e;
    public boolean f;
    public int g;
    public boolean h;

    public class a implements cj.mobile.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21971a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ n f;

        public a(n nVar, Context context, String str, String str2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
        }

        @Override // cj.mobile.f.b
        public void a(int i, String str) {
        }

        @Override // cj.mobile.f.b
        public void b(int i, String str) {
        }

        @Override // cj.mobile.f.b
        public void onClose() {
        }

        @Override // cj.mobile.f.b
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.f.b
        public void onLoad() {
        }
    }

    public class b implements cj.mobile.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21972a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJInterstitialListener d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ n f;

        public b(n nVar, Context context, String str, String str2, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
        }

        @Override // cj.mobile.d.b
        public void a(int i, String str) {
        }

        @Override // cj.mobile.d.b
        public void b(int i, String str) {
        }

        @Override // cj.mobile.d.b
        public void onClose() {
        }

        @Override // cj.mobile.d.b
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.d.b
        public void onLoad() {
        }
    }

    public n a(int i) {
        this.g = i;
        return this;
    }

    public n b(boolean z) {
        this.h = z;
        return this;
    }

    public n a(String str, String str2) {
        this.d = str;
        this.e = str2;
        return this;
    }

    public void b(Activity activity) {
    }

    public n a(boolean z) {
        this.f = z;
        return this;
    }

    public class c implements cj.mobile.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21973a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CJRewardListener d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ n f;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f21974a;

            public a(c cVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public c(n nVar, Context context, String str, String str2, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
        }

        @Override // cj.mobile.e.b
        public void a(int i, String str) {
        }

        @Override // cj.mobile.e.b
        public void b(int i, String str) {
        }

        @Override // cj.mobile.e.b
        public void onClose() {
        }

        @Override // cj.mobile.e.b
        public void onLoad() {
        }

        @Override // cj.mobile.e.b
        public void onVideoEnd() {
        }

        @Override // cj.mobile.e.b
        public void onVideoStart() {
        }

        @Override // cj.mobile.e.b
        public void a() {
        }
    }

    public void a(Context context, String str, String str2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, CJInterstitialListener cJInterstitialListener, cj.mobile.p.h hVar) {
    }

    public void a(Activity activity) {
    }

    public void a(Context context, String str, String str2, CJRewardListener cJRewardListener, cj.mobile.p.h hVar) {
    }
}
