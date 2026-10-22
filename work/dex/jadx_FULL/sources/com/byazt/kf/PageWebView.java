package com.byazt.kf;

import android.content.Context;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.byazt.aas.cu;
import com.byazt.aas.gt;
import com.byazt.aas.nb;
import com.byazt.bzd.x;
import com.byazt.ddx.a;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.jwd.tt;
import com.byazt.jwd.uj;
import com.byazt.jwd.ve;
import com.byazt.nt.n;
import com.byazt.omf.d;
import com.byazt.omf.p;
import com.byazt.sz.yp;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1176, SecExceptionCode.SEC_ERROR_GENERIC_AVMP_AVMPINIT_FAILED})
public class PageWebView extends FrameLayout implements n {
    public static final SparseArray<WeakReference<DownloadListener>> c = new SparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yp f28725a;
    public d n;
    public SSWebView tt;
    public ic uj;
    public Context ve;

    public PageWebView(@NonNull Context context) {
        super(context);
        this.ve = context;
        SSWebView sSWebView = new SSWebView(context);
        this.tt = sSWebView;
        sSWebView.setMaterialMeta(cu.c(this.uj));
        addView(this.tt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        tt.c(this.ve).c(false).tt(false).c(this.tt);
        SSWebView sSWebView = this.tt;
        if (sSWebView != null) {
            gt.c(sSWebView, p.uj, ic.n(this.uj));
        }
        this.tt.setMixedContentMode(0);
        if (jSONObject == null || (weakReference = c.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.tt.setDownloadListener(weakReference.get());
    }

    @Override // com.byazt.nt.n
    public void c(boolean z, JSONArray jSONArray) {
    }

    public void setMeta(ic icVar) {
        this.uj = icVar;
        SSWebView sSWebView = this.tt;
        if (sSWebView != null) {
            sSWebView.setMaterialMeta(cu.c(icVar));
        }
    }

    public void setUGenContext(yp ypVar) {
        this.f28725a = ypVar;
    }

    public void tt(final JSONObject jSONObject) {
        x.c(new Runnable() { // from class: com.byazt.kf.PageWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PageWebView.this.ve(jSONObject);
            }
        });
    }

    public static void c(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        c.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            c.remove(jSONObject.hashCode());
        }
    }

    public void c() {
        Map<String, Object> mapTt;
        if (this.tt == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.uj);
        this.n = new d(this.ve);
        yp ypVar = this.f28725a;
        if (ypVar != null && (mapTt = ypVar.tt()) != null && mapTt.containsKey("key_reward_page")) {
            Object obj = mapTt.get("key_reward_page");
            if (obj instanceof Map) {
                this.n.c((Map<String, Object>) obj);
            }
        }
        this.n.tt(this.tt).c(this.uj).ve(arrayList).tt(this.uj.uj()).uj(this.uj.w_()).ve(7).c(nb.tt(this.uj)).n(nb.my(this.uj)).c(this.tt).c(true).tt(com.byazt.wz.x.c(this.uj)).c((n) this);
        this.tt.setWebViewClient(new uj(this.ve, this.n, this.uj.uj(), new a(this.uj, this.tt), null));
        this.tt.setWebChromeClient(new ve(this.n));
    }

    public void c(String str) {
        SSWebView sSWebView = this.tt;
        if (sSWebView != null) {
            sSWebView.loadUrl(str);
        }
    }
}
