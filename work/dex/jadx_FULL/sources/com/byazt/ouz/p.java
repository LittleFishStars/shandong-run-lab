package com.byazt.ouz;

import android.view.ViewGroup;
import com.byazt.aas.nb;
import com.byazt.aas.or;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.omf.d;
import com.byazt.omf.zb;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 350})
public class p implements SSWebView.tt {
    public SSWebView c;
    public ic tt;
    public d ve;

    public p(SSWebView sSWebView, d dVar, ic icVar) {
        this.c = sSWebView;
        this.tt = icVar;
        this.ve = dVar;
    }

    private boolean c() {
        SSWebView sSWebView = this.c;
        if (sSWebView == null) {
            return false;
        }
        return zb.tt(sSWebView, 50, nb.sl(this.tt));
    }

    @Override // com.byazt.el.SSWebView.tt
    public void c(final int i) {
        boolean zC = c();
        com.byazt.nr.m.tt("xeasy", "wv:".concat(String.valueOf(zC)));
        if (zC) {
            if (com.byazt.omf.gt.tt().rh()) {
                SSWebView sSWebView = this.c;
                if (sSWebView != null) {
                    or.c((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.byazt.hkv.ve() { // from class: com.byazt.ouz.p.1
                        @Override // com.byazt.hkv.ve
                        public void c() {
                            if (p.this.ve != null) {
                                p.this.ve.c(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            d dVar = this.ve;
            if (dVar != null) {
                dVar.c(i);
            }
        }
    }
}
