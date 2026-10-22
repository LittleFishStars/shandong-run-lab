package com.byazt.hz;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 15})
public abstract class uj extends da {
    public boolean c;
    public int gr;
    public SoftReference<Activity> gt;
    public int gu;
    public final Application.ActivityLifecycleCallbacks h;
    public boolean m;
    public String md;
    public SoftReference<Activity> my;
    public Object p;
    public int qy;
    public Handler rl;
    public volatile boolean tt;
    public com.byazt.yl.ve yv;
    public int zm;

    @com.byazt.zqa.c(c = {0, 1, 701, 123})
    public static class c implements Runnable {
        public Toast c;
        public final int tt;
        public final Handler ve;

        @Override // java.lang.Runnable
        public void run() {
            if (this.tt <= 0) {
                this.c.cancel();
                return;
            }
            this.c.cancel();
            Toast toastMakeText = Toast.makeText(com.byazt.bp.tt.getContext(), this.tt + "秒后播放下一个广告", 0);
            this.c = toastMakeText;
            toastMakeText.show();
            Handler handler = this.ve;
            handler.postDelayed(new c(this.c, this.tt - 1, handler), 1000L);
        }

        private c(Toast toast, int i, Handler handler) {
            this.c = toast;
            this.tt = i;
            this.ve = handler;
        }
    }

    public uj(Context context) {
        super(context);
        this.c = false;
        this.m = true;
        this.tt = false;
        this.my = new SoftReference<>(null);
        this.gt = new SoftReference<>(null);
        this.qy = 0;
        this.gu = 2;
        this.gr = 0;
        this.zm = 15000;
        this.h = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.hz.uj.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull @ForbidWrapParam Activity activity, @Nullable Bundle bundle) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated: activity: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) uj.this.gt.get();
                if (activity2 == null) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity");
                    if (activity instanceof TTTransparentActivity) {
                        uj.this.gt = new SoftReference(activity);
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        uj ujVar = uj.this;
                        ujVar.tt(ujVar.yv, activity, uj.this.p, uj.this.md);
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated: end");
                        return;
                    }
                    return;
                }
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated again, showingActivity: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.byazt.cz.c.tt(name)) {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated again, is adn ad activity: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    uj.this.gt = new SoftReference(activity);
                } else {
                    com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated again, is not adn ad activity");
                }
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- onActivityCreated: end 2");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull @ForbidWrapParam Activity activity, @NonNull Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull @ForbidWrapParam Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull @ForbidWrapParam Activity activity) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Handler handler = this.rl;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application applicationC = com.byazt.bp.tt.c.c();
        if (applicationC != null) {
            applicationC.unregisterActivityLifecycleCallbacks(this.h);
        }
    }

    private int md() {
        CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayListSl;
        CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayListYp;
        CopyOnWriteArrayList<com.byazt.yl.ve> copyOnWriteArrayListT;
        boolean z;
        com.byazt.iz.tt ttVar = this.ve;
        List<com.byazt.nbs.da> listTt = null;
        if (ttVar != null) {
            copyOnWriteArrayListSl = ttVar.sl();
            copyOnWriteArrayListYp = this.ve.yp();
            copyOnWriteArrayListT = this.ve.t();
        } else {
            copyOnWriteArrayListSl = null;
            copyOnWriteArrayListYp = null;
            copyOnWriteArrayListT = null;
        }
        if (copyOnWriteArrayListSl == null || copyOnWriteArrayListSl.size() <= 0) {
            z = false;
        } else {
            z = false;
            for (com.byazt.yl.ve veVar : copyOnWriteArrayListSl) {
                if (veVar != null && veVar.isReady(this.n) && !veVar.isHasShown()) {
                    if (!uj(veVar) && !com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListT != null && copyOnWriteArrayListT.size() > 0) {
            for (com.byazt.yl.ve veVar2 : copyOnWriteArrayListT) {
                if (veVar2 != null && veVar2.isReady(this.n) && !veVar2.isHasShown()) {
                    if (!uj(veVar2) && !com.byazt.cz.c.c(veVar2.getAdNetWorkName(), veVar2.getAdType(), veVar2.getSubAdType())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListYp != null && copyOnWriteArrayListYp.size() > 0) {
            for (com.byazt.yl.ve veVar3 : copyOnWriteArrayListYp) {
                if (veVar3 != null && veVar3.isReady(this.n) && !veVar3.isHasShown()) {
                    if (!uj(veVar3) && !com.byazt.cz.c.c(veVar3.getAdNetWorkName(), veVar3.getAdType(), veVar3.getSubAdType())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        try {
            listTt = tt();
        } catch (Throwable th) {
            m.c(th);
        }
        if (listTt != null && listTt.size() > 0) {
            for (com.byazt.nbs.da daVar : listTt) {
                String strRh = daVar.rh();
                if (daVar.gt() && com.byazt.hk.c.c().uj(this.n, strRh, rh()) && com.byazt.hk.c.c().c(strRh, this.f28639a, false) == 3) {
                    if (!c(daVar) && !com.byazt.cz.c.c(daVar.z(), daVar.u(), daVar.a())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        return z ? 1 : 2;
    }

    public void c(Activity activity, Object obj, String str) {
    }

    public final void gr() {
        if (uj()) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 用户点击了广告，停止轮播");
            a();
        }
    }

    public final void gu() {
        if (uj()) {
            if (!this.m) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 调用finish触发了close回调");
                return;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 用户关闭了广告，停止轮播");
            Activity activity = this.gt.get();
            if (activity instanceof TTTransparentActivity) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 用户关闭了广告，finish showingActivity");
                activity.finish();
                this.gt = new SoftReference<>(null);
            }
            a();
        }
    }

    public final void qy() {
        if (uj()) {
            this.m = true;
            this.qy++;
            final Activity activity = this.my.get();
            final Activity activity2 = this.gt.get();
            final com.byazt.yl.ve veVar = this.yv;
            if (!c(activity2, activity, veVar)) {
                a();
                return;
            }
            Handler handler = this.rl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                c(this.rl, activity2);
                this.rl.postDelayed(new Runnable() { // from class: com.byazt.hz.uj.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!uj.this.c(activity2)) {
                            uj.this.a();
                            return;
                        }
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播 开始，先showingActivity finish");
                        uj.this.m = false;
                        activity2.finish();
                        veVar.onDestroy();
                        uj.this.gt = new SoftReference(null);
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播开始 showingActivity finish end");
                        uj.this.c = true;
                        uj ujVar = uj.this;
                        ujVar.c(activity, ujVar.p, uj.this.md);
                    }
                }, this.zm);
            }
        }
    }

    @Override // com.byazt.hz.da
    public boolean rl() {
        return this.c;
    }

    private void n() {
        if (this.tt) {
            return;
        }
        Application applicationC = com.byazt.bp.tt.c.c();
        if (applicationC == null) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        applicationC.unregisterActivityLifecycleCallbacks(this.h);
        applicationC.registerActivityLifecycleCallbacks(this.h);
        this.tt = true;
    }

    private boolean uj() {
        return this.gr != 0;
    }

    public void tt(com.byazt.ll.tt ttVar) {
        c(ttVar);
        com.byazt.nbs.tt ttVar2 = this.sp;
        if (ttVar2 != null) {
            this.gr = ttVar2.m();
            if (!uj()) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- inter full refresh is not enabled");
                return;
            }
            this.gu = this.sp.nu();
            com.byazt.nbs.tt ttVar3 = this.sp;
            int iSl = ttVar3.sl(ttVar3.pf());
            this.zm = iSl;
            if (iSl <= 0) {
                this.zm = 15000;
            }
            this.rl = new Handler(Looper.getMainLooper());
        }
    }

    private boolean uj(com.byazt.yl.ve veVar) {
        return veVar.isCustomAd() && veVar.getIsRefresh() != 1;
    }

    @Override // com.byazt.hz.da
    public void c(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        if (uj()) {
            n();
            this.my = new SoftReference<>(activity);
            this.yv = veVar;
            this.uj = veVar;
            this.p = obj;
            this.md = str;
            Intent intent = new Intent(com.byazt.bp.tt.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(268435456);
            com.byazt.bp.tt.getContext().startActivity(intent);
            return;
        }
        super.c(veVar, activity, obj, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.yl.ve veVar, Activity activity, Object obj, String str) {
        super.c(veVar, activity, obj, str);
    }

    private void c(final Handler handler, final Activity activity) {
        int i = this.zm + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
        if (i <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.byazt.hz.uj.2
            @Override // java.lang.Runnable
            public void run() {
                if (!uj.this.c(activity)) {
                    uj.this.a();
                    return;
                }
                Toast toastMakeText = Toast.makeText(com.byazt.bp.tt.getContext(), "2秒后播放下一个广告", 0);
                toastMakeText.show();
                Handler handler2 = handler;
                handler2.postDelayed(new c(toastMakeText, 1, handler2), 1000L);
            }
        }, i);
    }

    private boolean c(com.byazt.nbs.da daVar) {
        return daVar.sv() && daVar.c() != 1;
    }

    private boolean c(Activity activity, Activity activity2, com.byazt.yl.ve veVar) {
        if (this.qy >= this.gu) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，轮播次数已达上限: " + this.gu);
            return false;
        }
        if (activity2 == null) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播 停止轮播 developerActivity为null");
            return false;
        }
        if (veVar == null) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，ttBaseAd为null，不轮播");
            return false;
        }
        if (uj(veVar)) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，展示的是自定义adn，则不轮播");
            return false;
        }
        if (!com.byazt.cz.c.c(veVar.getAdNetWorkName(), veVar.getAdType(), veVar.getSubAdType())) {
            if (activity != null) {
                return true;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity是null，停止轮播");
            com.byazt.ng.a.c(this.f28639a, 81010);
            return false;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，当前展示的广告不支持轮播: " + veVar.getAdNetWorkName() + ", adtype: " + veVar.getAdType() + ", subType: " + veVar.getSubAdType());
        com.byazt.ng.a.c(this.f28639a, 81011);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            int iMd = md();
            if (iMd == 2) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，无任何广告可用，停止轮播");
                com.byazt.ng.a.c(this.f28639a, 81008);
                return false;
            }
            if (iMd == 1) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，仅有自定义adn广告可用，停止轮播");
                com.byazt.ng.a.c(this.f28639a, 81009);
                return false;
            }
            int iTt = tt.tt(this.n);
            if (iTt == 0) {
                return true;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，命中了展示频控，停止轮播");
            com.byazt.ng.a.c(this.f28639a, iTt);
            return false;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==--- 插全屏轮播，showingActivity正在finish或已经destroy，停止轮播");
        return false;
    }
}
