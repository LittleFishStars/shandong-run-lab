package cj.mobile.wm;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m1 {
    public static volatile m1 dexh;
    public WeakReference<Activity> dexc;
    public com.wangmai.insightvision.openadsdk.common.f dexf;
    public dexa dexg;
    public final String dexa = "DeepLinkMonitorManager";
    public final AtomicBoolean dexb = new AtomicBoolean(false);
    public volatile long dexd = 0;
    public boolean dexe = false;

    public interface dexa {
        void a();

        void a(boolean z);
    }

    private void dexa(boolean z) {
        f1.dexa("DeepLinkMonitorManager", "onDeepLinkJumped userConfirmed = " + z);
        this.dexe = true;
        dexa dexaVar = this.dexg;
        if (dexaVar != null) {
            dexaVar.a(z);
        }
    }

    public static m1 dexb() {
        if (dexh == null) {
            synchronized (m1.class) {
                if (dexh == null) {
                    dexh = new m1();
                }
            }
        }
        return dexh;
    }

    private void dexc() {
        f1.dexa("DeepLinkMonitorManager", "onDeepLinkCanceled");
        this.dexe = false;
        dexa dexaVar = this.dexg;
        if (dexaVar != null) {
            dexaVar.a();
        }
    }

    private void dexd() {
        this.dexb.set(false);
    }

    public void dexa() {
        if (this.dexb.get()) {
            return;
        }
        f1.dexa("DeepLinkMonitorManager", "startMonitoring ");
        this.dexb.set(true);
        this.dexc = null;
        this.dexe = false;
    }

    public void dexa(Activity activity) {
        if (this.dexb.get()) {
            f1.dexa("DeepLinkMonitorManager", "onActivityDestroy " + activity.getClass().getSimpleName());
            WeakReference<Activity> weakReference = this.dexc;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            dexd();
        }
    }

    public void dexa(dexa dexaVar) {
        this.dexg = dexaVar;
    }

    public void dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        this.dexf = fVar;
    }

    public void dexb(Activity activity) {
        if (this.dexb.get()) {
            WeakReference<Activity> weakReference = this.dexc;
            if (weakReference == null || weakReference.get() == null) {
                dexe(activity);
                this.dexd = System.currentTimeMillis();
            }
        }
    }

    public void dexc(Activity activity) {
        if (this.dexb.get()) {
            f1.dexa("DeepLinkMonitorManager", "onActivityResume " + activity.getClass().getSimpleName());
            WeakReference<Activity> weakReference = this.dexc;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            f1.dexa("DeepLinkMonitorManager", "页面切回 视作用户点击弹窗取消 唤端失败");
            dexd();
            dexc();
        }
    }

    public void dexd(Activity activity) {
        if (this.dexb.get()) {
            f1.dexa("DeepLinkMonitorManager", "onActivityStop " + activity.getClass().getSimpleName());
            WeakReference<Activity> weakReference = this.dexc;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            dexa(System.currentTimeMillis() - this.dexd > com.igexin.push.config.c.j);
            dexd();
        }
    }

    public void dexe(Activity activity) {
        if (activity == null) {
            this.dexc = null;
            return;
        }
        this.dexc = new WeakReference<>(activity);
        f1.dexa("DeepLinkMonitorManager", "设置目标 Activity: " + activity.getClass().getSimpleName());
    }
}
