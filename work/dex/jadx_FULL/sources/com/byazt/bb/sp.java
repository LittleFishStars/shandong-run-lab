package com.byazt.bb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.byazt.eia.sl;
import com.byazt.ete.ic;
import com.byazt.omf.p;
import com.byazt.tk.AdBaseConstants;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 91})
public class sp implements com.byazt.hl.c {
    public com.byazt.ete.n c;
    public Map<String, Object> n;
    public Context tt;
    public sl uj;
    public String ve;

    public sp(com.byazt.ete.n nVar, Context context, sl slVar, Map<String, Object> map) {
        this.c = nVar;
        this.tt = context;
        this.uj = slVar;
        this.n = map;
    }

    private void tt() {
        new CountDownTimer(3000L, 3000L) { // from class: com.byazt.bb.sp.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (com.byazt.omf.x.m() == null || com.byazt.omf.x.m().c()) {
                    sp.this.c(true);
                } else {
                    sp.this.c(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    private ic ve() {
        return com.byazt.ppf.ve.c(this.uj, this.n);
    }

    public void c(String str) {
        this.ve = str;
    }

    @Override // com.byazt.hl.c
    public boolean c(Map<String, Object> map) {
        return c();
    }

    public boolean tt(String str) {
        if (this.tt == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.byazt.nr.tt.startActivity(this.tt, intent, TextUtils.equals(p.x, "internal"));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean c() {
        com.byazt.ete.n nVar = this.c;
        if (nVar == null) {
            com.byazt.ppf.ve.c(this.n, com.byazt.cr.n.x);
            return false;
        }
        String strC = nVar.c();
        if (this.uj.a() == 3 && !TextUtils.isEmpty(strC)) {
            boolean zTt = tt(strC);
            if (zTt) {
                tt();
                com.byazt.ppf.ve.c(this.n, com.byazt.cr.n.ve);
            } else {
                c(false);
                com.byazt.ppf.ve.c(this.n, com.byazt.cr.n.i);
            }
            return zTt;
        }
        com.byazt.ppf.ve.c(this.n, com.byazt.cr.n.x);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (z) {
            com.byazt.ddx.uj.tt(ve(), this.ve, "quickapp_success");
        } else {
            com.byazt.ddx.uj.tt(ve(), this.ve, "quickapp_fail");
        }
    }
}
