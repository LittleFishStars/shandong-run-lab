package com.kc.dw.core.utils;

import android.app.Activity;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j0 implements com.kc.dw.core.router.service.a.InterfaceC1044a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f39375a;
    public long b;
    public long c;
    public boolean d;
    public volatile Boolean e;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f39376a;

        public a(j0 j0Var) {
            this.f39376a = j0Var;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            j0 j0Var;
            Boolean bool;
            super.safeRun();
            StringBuilder sbA = com.kc.dw.activity.a.a("dialog state 0 ：");
            sbA.append(this.f39376a.b);
            sbA.append(" ");
            sbA.append(com.kc.dw.core.service.c.a());
            LogUtil.dev("OpenAppDialogStateChecker", sbA.toString());
            long j = this.f39376a.b;
            if (j == 0) {
                LogUtil.dev("OpenAppDialogStateChecker", "dialog state 1");
                j0Var = this.f39376a;
                bool = Boolean.FALSE;
            } else {
                if (j <= 0) {
                    return;
                }
                if (com.kc.dw.core.service.c.a()) {
                    this.f39376a.d = true;
                    return;
                } else {
                    LogUtil.dev("OpenAppDialogStateChecker", "dialog state 2");
                    j0Var = this.f39376a;
                    bool = Boolean.TRUE;
                }
            }
            j0Var.e = bool;
            j0 j0Var2 = this.f39376a;
            j0.a(j0Var2, j0Var2.e.booleanValue());
        }
    }

    public j0(long j) {
        this(j, true);
    }

    public j0(long j, boolean z) {
        this.f39375a = true;
        this.b = 0L;
        this.c = 0L;
        this.d = false;
        this.e = null;
        this.f39375a = z;
        SdkHandler.getInstance().postDelay(new a(this), j <= 0 ? 900L : j);
    }

    public static void a(j0 j0Var, boolean z) {
        if (j0Var.f39375a) {
            if (com.kc.dw.core.service.c.c) {
                m0.a(z);
            } else {
                com.kc.dw.core.router.helper.a.a(new l0(z));
            }
        }
        com.kc.dw.core.router.helper.a.b(j0Var);
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onActivityPause(Activity activity) {
        this.b = System.currentTimeMillis();
        LogUtil.dev("OpenAppDialogStateChecker", "onActivityPause");
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onActivityResume(Activity activity) {
        this.c = System.currentTimeMillis();
        LogUtil.dev("OpenAppDialogStateChecker", "onActivityResume");
        long j = this.b;
        if (j <= 0 || this.c <= j || this.e != null) {
            com.kc.dw.core.router.helper.a.b(this);
        } else {
            LogUtil.dev("OpenAppDialogStateChecker", "dialog close");
            SdkHandler.getInstance().postDelay(new k0(this), 150L);
        }
    }

    @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
    public void onAppStateUpdate(boolean z) {
        LogUtil.dev("OpenAppDialogStateChecker", "onAppStateUpdate:" + z);
        System.currentTimeMillis();
    }
}
