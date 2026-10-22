package com.fl.saas;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import com.fl.saas.adx.api.FLInterstitial;
import com.fl.saas.adx.api.FLSpread;
import com.fl.saas.adx.base.activity.FLSpreadActivity;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.FLAdTempHelper;
import com.fl.saas.adx.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.adx.base.interfaces.AdViewSpreadListener;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.adx.util.DeviceUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f30057a;
    private boolean b;
    private boolean c;
    private long d;
    private long e;
    private C1415j f;
    private boolean g;
    private WeakReference h;
    private FLSpread i;
    private FLInterstitial j;
    private String k;
    private String l;
    private long m;
    private String n;
    private String o;
    public int p;

    public class a implements AdViewSpreadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f30058a;

        public a(List list) {
            this.f30058a = list;
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdClick(String str) {
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdClose() {
            if (J.this.i != null) {
                FLAdTempHelper.getInstance().closeSpreadSpread(J.this.i.getReqId());
                J.this.i.destroy();
                J.this.i = null;
                J.this.a(this.f30058a);
            }
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerSpreadListener
        public void onAdDisplay() {
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            if (J.this.i != null) {
                FLAdTempHelper.getInstance().closeSpreadSpread(J.this.i.getReqId());
                J.this.i.destroy();
                J.this.i = null;
                J.this.a(this.f30058a);
            }
        }
    }

    public class b implements AdViewInterstitialListener {
        public b() {
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
        public void onAdClick(String str) {
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
        public void onAdClosed() {
            if (J.this.j != null) {
                J.this.j.destroy();
                J.this.j = null;
            }
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
        public void onAdDisplay() {
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            if (J.this.j != null) {
                J.this.j.destroy();
                J.this.j = null;
            }
        }

        @Override // com.fl.saas.adx.base.base.listener.InnerInterstitialListener
        public void onAdReady() {
            if (J.this.h != null && J.this.h.get() != null && !((Activity) J.this.h.get()).isFinishing()) {
                Activity topActivity = DeviceUtil.getTopActivity();
                if (topActivity != null) {
                    J.this.k = topActivity.getComponentName().getClassName();
                }
                if (J.this.j != null && J.this.l.equals(J.this.k)) {
                    J.this.j.show((Activity) J.this.h.get());
                    return;
                } else if (J.this.j == null) {
                    return;
                }
            } else if (J.this.j == null) {
                return;
            }
            J.this.j.destroy();
            J.this.j = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!J.this.g || J.this.f == null) {
                return;
            }
            E0.a().a(J.this.f, "0", 0L);
            J.this.f = null;
        }
    }

    public class d implements Application.ActivityLifecycleCallbacks {
        private d() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            try {
                if (!J.this.c(activity) && J.this.f30057a.incrementAndGet() == 1 && J.this.b) {
                    J.this.b = false;
                    J.this.d(activity);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            try {
                if (J.this.c(activity) || J.this.f30057a.decrementAndGet() != 0) {
                    return;
                }
                J.this.b = true;
                J.this.c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public /* synthetic */ d(J j, a aVar) {
            this();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final J f30062a = new J(null);
    }

    private J() {
        this.f30057a = new AtomicInteger(0);
        this.b = false;
        this.c = false;
        this.d = 0L;
        this.e = 0L;
        this.g = false;
        this.k = "";
        this.l = "";
        this.m = 0L;
        this.n = "";
        this.o = "";
        this.p = 0;
    }

    public /* synthetic */ J(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List list) {
        C1438u0 c1438u0;
        if (list == null || list.isEmpty()) {
            return;
        }
        WeakReference weakReference = this.h;
        if (weakReference != null && weakReference.get() != null && !((Activity) this.h.get()).isFinishing()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c1438u0 = null;
                    break;
                }
                c1438u0 = (C1438u0) it.next();
                if (c1438u0.c() == 1 && c1438u0.a() > 0) {
                    break;
                }
            }
            if (c1438u0 != null && (System.currentTimeMillis() - this.d) / 1000 > c1438u0.a()) {
                if (this.i != null) {
                    a(list);
                    return;
                }
                FLSpread fLSpreadBuild = new FLSpread.Builder((Context) this.h.get()).setIsHot(true).setKey(c1438u0.b()).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.zj.adlib.wh4
                    @Override // com.fl.saas.adx.base.interfaces.SpreadLoadListener
                    public final void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                        this.f45597a.a(spreadAd);
                    }
                }).setSpreadListener(new a(list)).build();
                this.i = fLSpreadBuild;
                fLSpreadBuild.requestSpread();
                return;
            }
        }
        a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity) {
        this.e = System.currentTimeMillis() - this.d;
        if (activity == null) {
            return;
        }
        a((Context) activity);
        this.k = activity.getComponentName().getClassName();
        this.h = new WeakReference(activity);
        if (this.f != null) {
            this.g = false;
            E0.a().a(this.f, "1", System.currentTimeMillis() - this.d);
            this.f = null;
        }
        if (E0.a().d()) {
            E0.a().a(new E0.e() { // from class: com.zj.adlib.xh4
                @Override // com.fl.saas.E0.e
                public final void a(List list) {
                    this.f45824a.b(list);
                }
            });
        }
    }

    public boolean c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            return (attributes.width == -2) || (attributes.height == -2) || ((attributes.flags & 2) != 0) || b(activity) || a(activity);
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean b(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.g = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.d = jCurrentTimeMillis;
        if (jCurrentTimeMillis - this.m > 3000) {
            this.m = 0L;
            this.n = "";
            this.o = "";
            this.p = 0;
        }
    }

    public static J b() {
        return e.f30062a;
    }

    public void b(Context context) {
        if (context != null) {
            try {
                if (this.c) {
                    return;
                }
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new d(this, null));
                this.c = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean a(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsFloating});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list) {
        WeakReference weakReference;
        C1438u0 c1438u0;
        if (list == null || list.isEmpty() || (weakReference = this.h) == null || weakReference.get() == null || ((Activity) this.h.get()).isFinishing()) {
            return;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                c1438u0 = null;
                break;
            }
            c1438u0 = (C1438u0) it.next();
            if (c1438u0.c() == 3 && c1438u0.a() > 0) {
                break;
            }
        }
        if (c1438u0 == null || (System.currentTimeMillis() - this.d) / 1000 <= c1438u0.a() || !this.l.equals(((Activity) this.h.get()).getComponentName().getClassName())) {
            return;
        }
        FLInterstitial fLInterstitialBuild = new FLInterstitial.Builder((Context) this.h.get()).setKey(c1438u0.b()).setIsHot(true).setInterstitialListener(new b()).build();
        this.j = fLInterstitialBuild;
        fLInterstitialBuild.requestInterstitial();
    }

    public long a() {
        return this.e;
    }

    private void a(Context context) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(this.n)) {
                    if (this.p == 0) {
                        FLH5Activity.launchWithEnableQuickApp(context, this.n, QuickAppHelper.getInstance().enableQuickApp(this.o));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(this.n));
                        context.startActivity(intent);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SpreadLoadListener.SpreadAd spreadAd) {
        WeakReference weakReference;
        if (this.i == null || (weakReference = this.h) == null || weakReference.get() == null || ((Activity) this.h.get()).isFinishing()) {
            return;
        }
        FLAdTempHelper.getInstance().setSpreadAd(spreadAd);
        Intent intent = new Intent((Context) this.h.get(), (Class<?>) FLSpreadActivity.class);
        intent.putExtra("id", this.i.getReqId());
        ((Activity) this.h.get()).startActivity(intent);
    }

    public void a(C1415j c1415j) {
        this.f = c1415j;
        if (c1415j != null) {
            this.g = true;
            DeviceUtil.postUIDelayed(5000L, new c());
        }
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str, String str2, int i) {
        this.m = System.currentTimeMillis();
        this.n = str;
        this.o = str2;
        this.p = i;
    }

    public void a(String str) {
        this.l = str;
    }
}
