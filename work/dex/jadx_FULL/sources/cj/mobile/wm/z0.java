package cj.mobile.wm;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.u15;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z0 extends u0 {
    public a1 dexe;

    public class dexa implements x0 {
        public final /* synthetic */ String dexa;

        public dexa(String str) {
            this.dexa = str;
        }

        @Override // cj.mobile.wm.x0
        public void a() {
            z0.this.dexs();
        }

        @Override // cj.mobile.wm.x0
        public void a(int i, String str) {
            z0 z0Var = z0.this;
            if (z0Var.dexb != null) {
                z0Var.dexa.dexa(4);
                z0 z0Var2 = z0.this;
                z0Var2.dexb.dexa(z0Var2.dexa, i, str);
            }
        }

        @Override // cj.mobile.wm.x0
        public void b() {
            z0 z0Var = z0.this;
            if (z0Var.dexb != null) {
                z0Var.dexa.dexa(3);
                z0 z0Var2 = z0.this;
                z0Var2.dexb.dexa(z0Var2.dexa, false);
            }
        }

        @Override // cj.mobile.wm.x0
        public void c() {
            z0 z0Var = z0.this;
            if (z0Var.dexb != null) {
                z0Var.dexa.dexa(4);
                z0 z0Var2 = z0.this;
                z0Var2.dexb.dexa(z0Var2.dexa);
            }
        }

        @Override // cj.mobile.wm.x0
        public void dexa(int i, String str) {
            z0.this.dexa(i, str, this.dexa);
        }

        @Override // cj.mobile.wm.x0
        public void dexa(long j, long j2, Map<String, String> map) {
            z0.this.dexa(j, j2, map);
        }
    }

    private long dexa(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] strArrSplit = str.split(com.alipay.sdk.m.y.l.b);
        if (strArrSplit.length == 0) {
            return 0L;
        }
        try {
            for (String str3 : strArrSplit) {
                String[] strArrSplit2 = str3.split(u15.f19942b);
                if (strArrSplit2.length == 2 && str2.equals(strArrSplit2[0])) {
                    return be.dexc(strArrSplit2[1]);
                }
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(int i, String str, String str2) {
        if (this.dexb != null) {
            String str3 = str2 + File.separator + this.dexa.dexg();
            String strDexa = he.dexa(InsightProxy.getApplication(), str3);
            if (!TextUtils.isEmpty(strDexa)) {
                this.dexa.dexa(5);
                this.dexa.dexe(strDexa);
                this.dexa.dexa(he.dexe(InsightProxy.getApplication(), str3));
                this.dexa.dexb(str3);
                this.dexa.dexb(dexa(str, "speed"));
                this.dexb.dexa(this.dexa, false, dexa(str, "cost"), str3);
                dexa(5);
            }
            dexq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexa(long j, long j2, Map<String, String> map) {
        if (this.dexb != null) {
            this.dexa.dexa(2);
            if (j <= 0 || j2 <= 0) {
                return;
            }
            this.dexa.dexa(j2);
            this.dexa.dexa((100 * j) / j2);
            this.dexb.dexa(this.dexa, j, j2);
        }
    }

    private void dexp() {
    }

    private void dexq() {
        r0 r0Var = this.dexa;
        if (r0Var == null || !"3".equals(r0Var.dexd())) {
            if (he.dexd(InsightProxy.getApplication(), this.dexa.dexh()) != null) {
                this.dexa.dexa(7);
                dexj();
            } else if (!he.dexa((Context) InsightProxy.getApplication(), this.dexc)) {
                this.dexa.dexa(0);
                dexk();
            } else {
                this.dexa.dexa(6);
                dexi();
                he.dexf(InsightProxy.getApplication(), this.dexc);
                dexa();
            }
        }
    }

    private void dexr() {
        if (this.dexa.dexj() == 1) {
            return;
        }
        String strDexa = s0.dexa();
        if (!TextUtils.isEmpty(strDexa)) {
            File file = new File(strDexa);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        this.dexa.dexb(strDexa);
        this.dexa.dexa(1);
        if (TextUtils.isEmpty(this.dexc)) {
            this.dexc = s0.dexa() + WVNativeCallbackUtil.SEPERATER + this.dexa.dexg();
        }
        a1 a1Var = new a1(this.dexa, new dexa(strDexa));
        this.dexe = a1Var;
        a1Var.dexb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexs() {
        if (this.dexb != null) {
            this.dexa.dexa(1);
            this.dexb.dexd(this.dexa);
        }
        dexa(1);
    }

    @Override // cj.mobile.wm.u0
    public u0 dexd() {
        super.dexd();
        return this;
    }

    @Override // cj.mobile.wm.u0
    public void dexm() {
        dexn();
    }

    @Override // cj.mobile.wm.u0
    public void dexn() {
        super.dexn();
        if (!dexe()) {
            dexr();
            return;
        }
        if (TextUtils.isEmpty(this.dexc)) {
            this.dexc = s0.dexa() + WVNativeCallbackUtil.SEPERATER + this.dexa.dexg();
        }
        dexq();
    }

    @Override // cj.mobile.wm.u0
    public void dexo() {
        if (this.dexa.dexj() == 3) {
            return;
        }
        this.dexe.dexa();
        dexp();
        r0 r0Var = this.dexa;
        if (r0Var != null) {
            r0Var.dexa(3);
        }
        b1 b1Var = this.dexb;
        if (b1Var != null) {
            b1Var.dexa(this.dexa, false);
        }
    }
}
