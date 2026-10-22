package com.byazt.dyf;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byazt.nc.a;
import com.byazt.nc.sp;
import com.byazt.nr.da;
import com.byazt.nr.m;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 746, 13})
public class tt extends sp {
    public static final String AD_TAG_BANNER = "banner_ad";
    public static final String AD_TAG_DISLIKE = "dislike";
    public static final String AD_TAG_EXPRESS_BANNER = "slide_banner_ad";
    public static final String AD_TAG_FEED = "embeded_ad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f28438a;
    public final Context c;
    public c da;
    public HandlerC0392tt i;
    public TTDislikeToast n;
    public final List<com.byazt.sif.c> sl;
    public boolean sp;
    public com.byazt.vo.tt tt;
    public ve uj;
    public uj ve;
    public SoftReference<View> x;

    public interface c {
        void c();

        void c(int i, String str, boolean z);

        void tt();
    }

    /* JADX INFO: renamed from: com.byazt.dyf.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 746, 240})
    public static class HandlerC0392tt extends Handler {
        public WeakReference<Context> c;

        public HandlerC0392tt(Context context) {
            this.c = new WeakReference<>(context);
        }
    }

    public tt(Context context, com.byazt.vo.tt ttVar, String str, boolean z, final com.byazt.dyf.c cVar) {
        this.f28438a = new AtomicBoolean(false);
        this.sl = new ArrayList();
        ttVar.tt(str);
        ttVar.c("other");
        this.c = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            m.ve("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.tt = ttVar;
        this.sp = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c(cVar);
        } else {
            da.tt().post(new Runnable() { // from class: com.byazt.dyf.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.c(cVar);
                }
            });
        }
    }

    public void addInterceptor(com.byazt.sif.c cVar) {
        this.sl.add(cVar);
        ve veVar = this.uj;
        if (veVar != null) {
            veVar.c(cVar);
        }
    }

    @Override // com.byazt.nc.sp
    public boolean isShow() {
        if (!(this.c instanceof Activity)) {
            return false;
        }
        uj ujVar = this.ve;
        boolean zIsShowing = ujVar != null ? ujVar.isShowing() : false;
        ve veVar = this.uj;
        return veVar != null ? zIsShowing | veVar.isShowing() : zIsShowing;
    }

    public void resetData(com.byazt.vo.tt ttVar) {
        if ((this.c instanceof Activity) && ttVar != null) {
            this.ve.c(ttVar);
            this.uj.c(ttVar);
        }
    }

    @Override // com.byazt.nc.sp
    public void resetDislikeStatus() {
        if (this.c instanceof Activity) {
            uj ujVar = this.ve;
            if (ujVar != null) {
                ujVar.hide();
            }
            ve veVar = this.uj;
            if (veVar != null) {
                veVar.c();
            }
            TTDislikeToast tTDislikeToast = this.n;
            if (tTDislikeToast != null) {
                tTDislikeToast.c();
            }
            this.f28438a.set(false);
        }
    }

    @Override // com.byazt.nc.sp
    public void setDislikeInteractionCallback(final com.byazt.dhf.c cVar) {
        this.da = new c() { // from class: com.byazt.dyf.tt.4
            @Override // com.byazt.dyf.tt.c
            public void c() {
                com.byazt.dhf.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }

            @Override // com.byazt.dyf.tt.c
            public void tt() {
                com.byazt.dhf.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.tt();
                }
            }

            @Override // com.byazt.dyf.tt.c
            public void c(int i, String str, boolean z) {
                com.byazt.dhf.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(i, str, z);
                }
            }
        };
    }

    @Override // com.byazt.nc.sp
    public void setDislikeSource(String str) {
        com.byazt.vo.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.c(str);
        }
    }

    public void setMonitorView(View view) {
        this.x = new SoftReference<>(view);
    }

    @Override // com.byazt.nc.sp
    public void showDislikeDialog() {
        TTDislikeToast tTDislikeToast;
        Context context = this.c;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.f28438a.get() && this.sp && (tTDislikeToast = this.n) != null) {
            try {
                tTDislikeToast.c("您已成功提交反馈，请勿重复提交哦！");
                return;
            } catch (Throwable th) {
                m.c(th);
                return;
            }
        }
        if (!z || isShow()) {
            return;
        }
        this.ve.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        com.byazt.vo.tt ttVar = this.tt;
        if (ttVar == null) {
            return;
        }
        final String strX = ttVar.x();
        if (AD_TAG_EXPRESS_BANNER.equals(strX) || AD_TAG_BANNER.equals(strX) || AD_TAG_FEED.equals(strX)) {
            if (this.x.get() != null && this.tt.i()) {
                this.x.get().setVisibility(8);
            }
            if (this.i == null) {
                this.i = new HandlerC0392tt(this.c);
            }
            this.i.postDelayed(new Runnable() { // from class: com.byazt.dyf.tt.5
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.tt.tt(tt.AD_TAG_DISLIKE);
                    if (tt.this.x == null || tt.this.x.get() == null || !((View) tt.this.x.get()).isShown()) {
                        com.byazt.pr.c.c().c(tt.this.c, tt.this.tt, "close_success");
                    } else {
                        com.byazt.pr.c.c().c(tt.this.c, tt.this.tt, "close_fail");
                    }
                    tt.this.tt.tt(strX);
                }
            }, 500L);
        }
    }

    public void setDislikeInteractionCallback(c cVar) {
        this.da = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.dyf.c cVar) {
        ViewGroup viewGroup;
        uj ujVar = new uj(this.c, this.tt, cVar);
        this.ve = ujVar;
        ujVar.c(new com.byazt.sif.ve() { // from class: com.byazt.dyf.tt.2
            @Override // com.byazt.sif.ve
            public void c() {
                tt.this.c();
            }

            @Override // com.byazt.sif.ve
            public void tt() {
                if (tt.this.da != null) {
                    tt.this.da.c();
                }
            }

            @Override // com.byazt.sif.ve
            public void ve() {
                m.uj("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (tt.this.da == null || tt.this.isShow()) {
                        return;
                    }
                    tt.this.da.tt();
                } catch (Throwable th) {
                    m.ve("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }

            @Override // com.byazt.sif.ve
            public void c(int i, a aVar) {
                try {
                    if (!tt.this.sl.isEmpty()) {
                        String strUj = tt.this.uj != null ? tt.this.uj.uj() : "";
                        Iterator it = tt.this.sl.iterator();
                        while (it.hasNext()) {
                            ((com.byazt.sif.c) it.next()).c(aVar, strUj, tt.this.uj);
                        }
                    }
                    if (!aVar.hasSecondOptions()) {
                        if (tt.this.da != null) {
                            tt.this.da.c(i, aVar.getName(), tt.this.tt != null ? tt.this.tt.i() : false);
                        }
                        tt.this.f28438a.set(true);
                        if ("99:1".equals(aVar.getId())) {
                            return;
                        }
                        if (tt.this.n != null) {
                            tt.this.n.c("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                        }
                        tt.this.tt();
                    }
                    m.uj("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + aVar.getName());
                } catch (Throwable th) {
                    m.ve("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
        ve veVar = new ve(this.c, this.tt);
        this.uj = veVar;
        veVar.c(new com.byazt.sif.tt() { // from class: com.byazt.dyf.tt.3
            @Override // com.byazt.sif.tt
            public void c() {
                try {
                    if (tt.this.f28438a.get()) {
                        return;
                    }
                    tt.this.ve.show();
                    if (tt.this.uj != null) {
                        String strUj = tt.this.uj.uj();
                        if (TextUtils.isEmpty(strUj)) {
                            return;
                        }
                        tt.this.ve.c(strUj);
                    }
                } catch (Throwable th) {
                    m.ve("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.byazt.sif.tt
            public void c(int i, a aVar) {
                try {
                    if (aVar.hasSecondOptions()) {
                        return;
                    }
                    if (tt.this.da != null) {
                        tt.this.da.c(i, aVar.getName(), tt.this.tt != null ? tt.this.tt.i() : false);
                    }
                    tt.this.f28438a.set(true);
                    if (tt.this.n != null) {
                        tt.this.n.c("感谢您的反馈！\n我们将为您带来更优质的广告体验");
                    }
                    tt.this.tt();
                } catch (Throwable th) {
                    m.ve("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.c instanceof Activity) && this.sp) {
            this.n = new TTDislikeToast(this.c);
            Window window = ((Activity) this.c).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Context context = this.c;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.uj.isShowing()) {
            this.uj.show();
        }
    }

    public tt(Context context, com.byazt.vo.tt ttVar, boolean z, com.byazt.dyf.c cVar) {
        this(context, ttVar, null, z, cVar);
    }
}
