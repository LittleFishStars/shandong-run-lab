package cj.mobile.wm;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.security.InvalidParameterException;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class u0 {
    public r0 dexa;
    public b1 dexb;
    public String dexc;
    public boolean dexd;

    public class dexa implements Runnable {
        public dexa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.dexa == null || he.dexd(InsightProxy.getApplication(), u0.this.dexa.dexh()) == null) {
                return;
            }
            u0.this.dexa.dexa(7);
            u0.this.dexj();
        }
    }

    public u0 dexa(b1 b1Var) {
        this.dexb = b1Var;
        return this;
    }

    public u0 dexa(r0 r0Var) {
        this.dexa = r0Var;
        return this;
    }

    public void dexa() {
        InsightProxy.getInstance().getThreadPoolProxy().dexa("", new dexa());
    }

    public void dexa(int i) {
    }

    public r0 dexb() {
        return this.dexa;
    }

    public int dexc() {
        r0 r0Var = this.dexa;
        if (r0Var != null) {
            return r0Var.dexj();
        }
        return -1;
    }

    public u0 dexd() {
        if (this.dexa == null) {
            throw new InvalidParameterException("init download app info is null");
        }
        this.dexd = true;
        return this;
    }

    public boolean dexe() {
        int iDexc = dexc();
        return iDexc == 5 || iDexc == 6;
    }

    public boolean dexf() {
        return dexc() == 2;
    }

    public boolean dexg() {
        return dexc() == 7;
    }

    public boolean dexh() {
        return dexc() == 3;
    }

    public void dexi() {
        b1 b1Var = this.dexb;
        if (b1Var != null) {
            b1Var.dexc(this.dexa);
        }
    }

    public void dexj() {
        b1 b1Var = this.dexb;
        if (b1Var != null) {
            b1Var.dexb(this.dexa);
        }
    }

    public void dexk() {
        b1 b1Var = this.dexb;
        if (b1Var != null) {
            b1Var.dexe(this.dexa);
        }
    }

    public void dexl() {
        if (this.dexa == null) {
            return;
        }
        if (he.dexd(InsightProxy.getApplication(), this.dexa.dexh()) != null) {
            this.dexa.dexa(7);
            return;
        }
        String str = s0.dexa() + WVNativeCallbackUtil.SEPERATER + this.dexa.dexg();
        if (fe.dexa(str)) {
            this.dexa.dexa(5);
            this.dexa.dexb(str);
            return;
        }
        if (Math.abs(this.dexa.dexc() - 100.0f) <= 1.0E-6f) {
            this.dexa.dexa(0.0f);
        }
        if (v0.dexb().dexa(this)) {
            this.dexa.dexa(3);
        } else {
            this.dexa.dexa(-1);
        }
    }

    public abstract void dexm();

    public void dexn() {
        if (!this.dexd) {
            throw new IllegalStateException("task don't init");
        }
        v0.dexb().dexb(this);
    }

    public abstract void dexo();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.dexa.equals(((u0) obj).dexa);
    }

    public int hashCode() {
        return Objects.hash(this.dexa);
    }
}
