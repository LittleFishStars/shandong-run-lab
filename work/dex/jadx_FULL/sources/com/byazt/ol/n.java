package com.byazt.ol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.el.SSWebView;
import com.byazt.nr.da;
import com.byazt.pct.zm;
import com.bytedance.component.sdk.annotation.UiThread;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 41, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28873a = 10;
    public static volatile n i = null;
    public static final byte[] n = new byte[0];
    public static int sp = 10;
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final List<SSWebView> c = new ArrayList();
    public final List<SSWebView> tt = new ArrayList();
    public final WeakHashMap<com.byazt.nl.uj, ve> ve = new WeakHashMap<>();
    public final WeakHashMap<com.byazt.nl.uj, uj> uj = new WeakHashMap<>();

    private n() {
        com.byazt.mf.ve veVarVe = com.byazt.mf.c.c().ve();
        if (veVarVe != null) {
            f28873a = veVarVe.x();
            sp = veVarVe.i();
        }
    }

    public static n c() {
        if (i == null) {
            synchronized (n.class) {
                if (i == null) {
                    i = new n();
                }
            }
        }
        return i;
    }

    public void a(SSWebView sSWebView) {
        ve veVar;
        if (sSWebView == null || (veVar = this.ve.get(sSWebView)) == null) {
            return;
        }
        veVar.c(null);
    }

    public boolean n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        sSWebView.destroy();
        return true;
    }

    @UiThread
    public void tt(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.M_();
        a(sSWebView);
        c(sSWebView);
    }

    public void uj(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.c.size() >= f28873a) {
            sSWebView.destroy();
        } else {
            if (this.c.contains(sSWebView)) {
                return;
            }
            this.c.add(sSWebView);
            ve();
        }
    }

    @UiThread
    public void ve(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        sSWebView.M_();
        a(sSWebView);
        uj(sSWebView);
    }

    public int n() {
        return this.c.size() + uj();
    }

    public SSWebView tt(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (ve() <= 0 || (sSWebViewRemove = this.c.remove(0)) == null) {
            return null;
        }
        ve();
        return sSWebViewRemove;
    }

    public int ve() {
        return this.c.size();
    }

    public int uj() {
        return this.tt.size();
    }

    public SSWebView c(Context context, String str) {
        SSWebView sSWebViewRemove;
        if (uj() <= 0 || (sSWebViewRemove = this.tt.remove(0)) == null) {
            return null;
        }
        this.tt.size();
        return sSWebViewRemove;
    }

    public void tt() {
        for (SSWebView sSWebView : this.c) {
            if (sSWebView != null) {
                sSWebView.destroy();
            }
        }
        this.c.clear();
        for (SSWebView sSWebView2 : this.tt) {
            if (sSWebView2 != null) {
                sSWebView2.destroy();
            }
        }
        this.tt.clear();
        synchronized (this.uj) {
            this.uj.clear();
        }
    }

    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.tt.size() >= sp) {
            sSWebView.destroy();
        } else {
            if (this.tt.contains(sSWebView)) {
                return;
            }
            this.tt.add(sSWebView);
            this.tt.size();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void c(SSWebView sSWebView, tt ttVar) {
        if (sSWebView == null || ttVar == null) {
            return;
        }
        ve veVar = this.ve.get(sSWebView);
        if (veVar != null) {
            veVar.c(ttVar);
        } else {
            veVar = new ve(ttVar);
            this.ve.put(sSWebView, veVar);
        }
        sSWebView.addJavascriptInterface(veVar, "SDK_INJECT_GLOBAL");
    }

    private static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            da.tt().post(runnable);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void c(final com.byazt.nl.uj ujVar, zm zmVar, final String str) {
        final uj ujVar2;
        if (ujVar == null || zmVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.uj) {
            ujVar2 = this.uj.get(ujVar);
            if (ujVar2 != null) {
                ujVar2.c(zmVar);
            } else {
                ujVar2 = new uj(zmVar);
                this.uj.put(ujVar, ujVar2);
            }
        }
        c(new Runnable() { // from class: com.byazt.ol.n.1
            @Override // java.lang.Runnable
            public void run() {
                ujVar.addJavascriptInterface(ujVar2, str);
            }
        });
    }

    public void c(final com.byazt.nl.uj ujVar, final String str) {
        if (ujVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.uj) {
            uj ujVar2 = this.uj.get(ujVar);
            if (ujVar2 != null) {
                ujVar2.c(null);
            }
        }
        c(new Runnable() { // from class: com.byazt.ol.n.2
            @Override // java.lang.Runnable
            public void run() {
                ujVar.removeJavascriptInterface(str);
            }
        });
    }
}
