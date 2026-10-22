package com.byazt.ji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 34})
public class a extends tt implements com.byazt.cd.i.c {
    public boolean gr;
    public boolean gt;
    public int gu;
    public int m;
    public boolean my;
    public Handler nu;
    public long qy;
    public int rh;
    public boolean rl;
    public int sl;
    public int t;
    public String u;
    public int yp;
    public int z;
    public final List<sp> zm;

    public a(Context context) {
        super(context);
        this.t = 0;
        this.u = "";
        this.yp = 0;
        this.z = 0;
        this.m = 0;
        this.nu = new com.byazt.cd.i(Looper.getMainLooper(), this);
        this.rh = 0;
        this.my = false;
        this.gt = false;
        this.rl = false;
        this.qy = 0L;
        this.gu = 0;
        this.gr = false;
        this.zm = new ArrayList();
    }

    private void n() {
        if (this.rl) {
            return;
        }
        this.gu = (int) Math.max(0L, this.qy - SystemClock.uptimeMillis());
        this.nu.removeMessages(1001);
        this.rl = true;
    }

    private void sl() {
        if (this.rl) {
            this.rl = false;
            int i = this.gu;
            this.gu = 0;
            tt(i);
        }
    }

    private void t() {
        if (this.zm.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.zm).iterator();
        while (it.hasNext()) {
            ((sp) it.next()).c(this.u);
        }
    }

    private void tt(int i) {
        this.nu.removeMessages(1001);
        long jMax = Math.max(0, i);
        this.qy = SystemClock.uptimeMillis() + jMax;
        this.nu.sendEmptyMessageDelayed(1001, jMax);
    }

    private void u() {
        if (this.zm.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.zm).iterator();
        while (it.hasNext()) {
            ((sp) it.next()).tt(this.u);
        }
    }

    private void uj() {
        if (this.gt) {
            com.byazt.xj.ve veVar = this.tt;
            View viewI = veVar != null ? veVar.i() : null;
            if ((this.z & 2) != 0 && viewI != null && viewI.getVisibility() != 0) {
                this.m |= 2;
            }
            if ((this.z & 1) != 0 && viewI != null && !viewI.hasWindowFocus()) {
                this.m |= 1;
            }
            if (this.m != 0) {
                n();
            } else {
                sl();
            }
        }
    }

    private void ve() {
        if (this.gt) {
            return;
        }
        this.gt = true;
        this.my = false;
        this.rl = false;
        this.gu = 0;
        this.gr = false;
        this.m = 0;
        t();
        tt(this.t);
        uj();
    }

    @Override // com.byazt.ji.tt
    public void a() {
        super.a();
        Map<String, Object> map = this.n;
        if (map == null) {
            this.u = "";
            return;
        }
        Object obj = map.get("name");
        if (obj != null) {
            this.u = String.valueOf(obj);
        } else {
            this.u = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a4  */
    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Map<String, Object> map = this.n;
        if (map != null) {
            Object obj = map.get("name");
            if (obj != null) {
                this.u = String.valueOf(obj);
            } else {
                this.u = "";
            }
            Object obj2 = this.n.get("condition");
            if (obj2 != null) {
                this.yp = com.byazt.cd.ve.c(String.valueOf(obj2), 0);
            } else {
                this.yp = 0;
            }
            Object obj3 = this.n.get("pauseMode");
            if (obj3 != null) {
                this.z = com.byazt.cd.ve.c(String.valueOf(obj3), 0);
            } else {
                this.z = 0;
            }
            Object obj4 = this.n.get("loop");
            if (obj4 != null) {
                this.sl = com.byazt.cd.ve.c(String.valueOf(obj4), 1);
            } else {
                this.sl = 1;
            }
            int i = this.sl;
            if (i <= 0) {
                this.rh = -1;
            } else {
                this.rh = i;
            }
            Object obj5 = this.n.get("duration");
            if (obj5 == null) {
                this.t = 0;
            } else {
                this.t = com.byazt.cd.ve.c(String.valueOf(obj5), 0);
            }
        }
        int i2 = this.yp;
        if (i2 == 0) {
            ve();
        } else if (i2 == 1) {
            com.byazt.xj.ve veVar = this.tt;
            if (veVar == null || veVar.i() == null || this.tt.i().getVisibility() != 0) {
                this.my = true;
            } else {
                ve();
            }
        } else if (i2 == 2) {
            this.my = true;
        } else {
            ve();
        }
        return true;
    }

    public String tt() {
        return this.u;
    }

    public void c(int i) {
        if (this.yp == 1 && this.my && i == 0) {
            ve();
        }
        if (!this.gt || (this.z & 2) == 0) {
            return;
        }
        if (i == 0) {
            this.m &= -3;
        } else {
            this.m |= 2;
        }
        uj();
    }

    public void c() {
        if (this.yp == 2 && this.my) {
            ve();
        }
    }

    public void c(boolean z) {
        if (!this.gt || (this.z & 1) == 0) {
            return;
        }
        if (z) {
            this.m &= -2;
        } else {
            this.m |= 1;
        }
        uj();
    }

    @Override // com.byazt.cd.i.c
    public void c(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.c.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
        int i3 = this.rh - 1;
        this.rh = i3;
        if (i3 < 0 && (i2 = this.t) != 0) {
            tt(i2);
            return;
        }
        if (i3 > 0 && (i = this.t) != 0) {
            tt(i);
            return;
        }
        this.nu.removeMessages(1001);
        this.qy = 0L;
        if (this.gr) {
            return;
        }
        this.gr = true;
        u();
    }

    public void c(sp spVar) {
        if (spVar == null || this.zm.contains(spVar)) {
            return;
        }
        this.zm.add(spVar);
    }
}
