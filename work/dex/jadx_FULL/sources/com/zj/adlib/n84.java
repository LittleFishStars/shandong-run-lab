package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.NotchUtils;
import com.gyf.immersionbar.OnBarListener;
import com.gyf.immersionbar.a;
import com.gyf.immersionbar.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class n84 implements Runnable {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnBarListener f43470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f18368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public vl0 f18369a;

    public n84(Object obj) {
        if (obj instanceof Activity) {
            if (this.f18368a == null) {
                this.f18368a = new e((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.f18368a == null) {
                if (obj instanceof DialogFragment) {
                    this.f18368a = new e((DialogFragment) obj);
                    return;
                } else {
                    this.f18368a = new e((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.f18368a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f18368a = new e((android.app.DialogFragment) obj);
            } else {
                this.f18368a = new e((android.app.Fragment) obj);
            }
        }
    }

    public final void a(Configuration configuration) {
        e eVar = this.f18368a;
        if (eVar == null || !eVar.e1()) {
            return;
        }
        OnBarListener onBarListener = this.f18368a.m0().f20090a;
        this.f43470a = onBarListener;
        if (onBarListener != null) {
            Activity activity = this.f18368a.getActivity();
            if (this.f18369a == null) {
                this.f18369a = new vl0();
            }
            this.f18369a.s(configuration.orientation == 1);
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 1) {
                this.f18369a.l(true);
                this.f18369a.m(false);
            } else if (rotation == 3) {
                this.f18369a.l(false);
                this.f18369a.m(true);
            } else {
                this.f18369a.l(false);
                this.f18369a.m(false);
            }
            activity.getWindow().getDecorView().post(this);
        }
    }

    public e b() {
        return this.f18368a;
    }

    public void c(Configuration configuration) {
        a(configuration);
    }

    public void d(Configuration configuration) {
        e eVar = this.f18368a;
        if (eVar != null) {
            eVar.L1(configuration);
            a(configuration);
        }
    }

    public void e() {
        this.f18369a = null;
        this.f43470a = null;
        e eVar = this.f18368a;
        if (eVar != null) {
            eVar.M1();
            this.f18368a = null;
        }
    }

    public void f() {
        e eVar = this.f18368a;
        if (eVar != null) {
            eVar.N1();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar = this.f18368a;
        if (eVar == null || eVar.getActivity() == null) {
            return;
        }
        Activity activity = this.f18368a.getActivity();
        a aVar = new a(activity);
        this.f18369a.t(aVar.k());
        this.f18369a.n(aVar.m());
        this.f18369a.o(aVar.d());
        this.f18369a.p(aVar.g());
        this.f18369a.k(aVar.a());
        boolean zHasNotchScreen = NotchUtils.hasNotchScreen(activity);
        this.f18369a.r(zHasNotchScreen);
        if (zHasNotchScreen && this.K == 0) {
            int notchHeight = NotchUtils.getNotchHeight(activity);
            this.K = notchHeight;
            this.f18369a.q(notchHeight);
        }
        this.f43470a.a(this.f18369a);
    }

    public n84(Activity activity, Dialog dialog) {
        if (this.f18368a == null) {
            this.f18368a = new e(activity, dialog);
        }
    }
}
