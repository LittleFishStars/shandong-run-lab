package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.utils.t0;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39544a;
    public ShakeUtil.c b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String i;
    public long j;
    public SsdAdInfo.DClickData k;
    public int l;
    public int o;
    public double p;
    public double q;
    public boolean r;
    public boolean s;
    public boolean t;
    public long u;
    public int h = 1;
    public int m = 1;
    public int n = 1;

    public boolean a() {
        if (this.r) {
            return System.currentTimeMillis() - r.a().a("last_dynamic_time", 0L) > ((long) (this.l * 1000));
        }
        return false;
    }

    public void b() {
        SsdAdInfo.DClickData dClickData;
        try {
            t0.a aVar = t0.f39405a.get(this.i + this.j);
            if ((aVar == null || !aVar.b) && (dClickData = this.k) != null) {
                int power = dClickData.getPower();
                int ptime = this.k.getPtime();
                if (ptime <= 0 || power >= this.d) {
                    return;
                }
                this.l = ptime;
                this.r = true;
                if (power < 1 || power > 100) {
                    return;
                }
                this.o = power;
                double d = (((double) power) * 45.0d) / 100.0d;
                this.p = d;
                if (d < 2.0d) {
                    this.p = 2.0d;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        this.n++;
    }
}
