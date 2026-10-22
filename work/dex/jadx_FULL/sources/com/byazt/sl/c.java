package com.byazt.sl;

import com.byazt.nr.m;
import com.byazt.vb.n;
import com.byazt.vb.tt;
import com.byazt.vb.uj;
import com.byazt.vb.x;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 158, 20})
public class c {
    public StringBuffer c = new StringBuffer();
    public StringBuffer tt = new StringBuffer();
    public AtomicLong ve = new AtomicLong(0);
    public AtomicLong uj = new AtomicLong(0);
    public AtomicLong n = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicLong f29026a = new AtomicLong(0);
    public AtomicLong sp = new AtomicLong(0);
    public AtomicLong x = new AtomicLong(0);
    public AtomicLong i = new AtomicLong(0);
    public AtomicLong da = new AtomicLong(0);
    public AtomicLong sl = new AtomicLong(0);
    public AtomicLong t = new AtomicLong(0);
    public AtomicLong u = new AtomicLong(0);
    public AtomicLong yp = new AtomicLong(0);
    public AtomicLong z = new AtomicLong(0);
    public AtomicLong m = new AtomicLong(0);
    public AtomicLong nu = new AtomicLong(0);
    public AtomicLong rh = new AtomicLong(0);
    public AtomicLong my = new AtomicLong(0);
    public AtomicLong gt = new AtomicLong(0);
    public AtomicLong rl = new AtomicLong(0);
    public AtomicLong qy = new AtomicLong(0);
    public AtomicLong gu = new AtomicLong(0);
    public AtomicLong gr = new AtomicLong(0);
    public AtomicLong zm = new AtomicLong(0);
    public AtomicLong yv = new AtomicLong(0);
    public AtomicLong p = new AtomicLong(0);
    public AtomicLong md = new AtomicLong(0);
    public AtomicLong h = new AtomicLong(0);
    public AtomicLong d = new AtomicLong(0);
    public AtomicLong eo = new AtomicLong(0);
    public AtomicLong zb = new AtomicLong(0);
    public AtomicLong or = new AtomicLong(0);
    public AtomicLong cu = new AtomicLong(0);
    public AtomicLong qp = new AtomicLong(0);
    public AtomicLong nb = new AtomicLong(0);
    public AtomicLong pf = new AtomicLong(0);
    public AtomicLong bx = new AtomicLong(0);

    public synchronized void a() {
        u().set(0L);
        cu().set(0L);
        qp().set(0L);
        or().set(0L);
        pf().set(0L);
        nb().set(0L);
        zb().set(0L);
        qy().set(0L);
        gu().set(0L);
        gr().set(0L);
        zm().set(0L);
        yv().set(0L);
        d().set(0L);
        p().set(0L);
        md().set(0L);
        h().set(0L);
        eo().set(0L);
        m().set(0L);
        t().set(0L);
        yp().set(0L);
        nu().set(0L);
        rh().set(0L);
        my().set(0L);
        gt().set(0L);
        rl().set(0L);
        z().set(0L);
        da().set(0L);
        x().set(0L);
        i().set(0L);
        sp().set(0L);
        sl().set(0L);
        uj().set(0L);
        ve().set(0L);
        tt().set(0L);
        c().set(0L);
        try {
            if (this.c.length() != 0) {
                this.c.setLength(0);
            }
        } catch (Exception unused) {
        }
        try {
            if (this.tt.length() != 0) {
                this.tt.setLength(0);
            }
        } catch (Exception unused2) {
        }
    }

    public StringBuffer bx() {
        return this.c;
    }

    public AtomicLong c() {
        return this.bx;
    }

    public AtomicLong cu() {
        return this.d;
    }

    public AtomicLong d() {
        return this.rl;
    }

    public AtomicLong da() {
        return this.m;
    }

    public AtomicLong eo() {
        return this.zm;
    }

    public AtomicLong gr() {
        return this.rh;
    }

    public AtomicLong gt() {
        return this.yp;
    }

    public AtomicLong gu() {
        return this.nu;
    }

    public AtomicLong h() {
        return this.gr;
    }

    public AtomicLong i() {
        return this.uj;
    }

    public AtomicLong m() {
        return this.i;
    }

    public AtomicLong md() {
        return this.gu;
    }

    public AtomicLong my() {
        return this.u;
    }

    public AtomicLong n() {
        return this.p;
    }

    public AtomicLong nb() {
        return this.zb;
    }

    public AtomicLong nu() {
        return this.sl;
    }

    public AtomicLong or() {
        return this.h;
    }

    public AtomicLong p() {
        return this.qy;
    }

    public AtomicLong pf() {
        return this.or;
    }

    public AtomicLong qp() {
        return this.eo;
    }

    public AtomicLong qy() {
        return this.yv;
    }

    public AtomicLong rh() {
        return this.t;
    }

    public AtomicLong rl() {
        return this.z;
    }

    public AtomicLong sl() {
        return this.cu;
    }

    public AtomicLong sp() {
        return this.da;
    }

    public StringBuffer sv() {
        return this.tt;
    }

    public AtomicLong t() {
        return this.ve;
    }

    public AtomicLong tt() {
        return this.pf;
    }

    public AtomicLong u() {
        return this.n;
    }

    public AtomicLong uj() {
        return this.qp;
    }

    public AtomicLong ve() {
        return this.nb;
    }

    public AtomicLong x() {
        return this.f29026a;
    }

    public AtomicLong yp() {
        return this.sp;
    }

    public AtomicLong yv() {
        return this.gt;
    }

    public AtomicLong z() {
        return this.x;
    }

    public AtomicLong zb() {
        return this.md;
    }

    public AtomicLong zm() {
        return this.my;
    }

    public synchronized void c(long j, tt ttVar) {
        this.ve.getAndAdd(j);
        this.uj.incrementAndGet();
        if (com.byazt.ml.c.c(ttVar)) {
            this.u.incrementAndGet();
        } else {
            if (com.byazt.ml.c.tt(ttVar)) {
                this.z.incrementAndGet();
            }
        }
    }

    public JSONObject c(long j, n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = i().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (t().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = x().get();
            jSONObject.put("save_upload_cost_ts_avg", (u().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.p.get());
            jSONObject.put("all_delete_count", yp().get());
            jSONObject.put("success_delete_count", z().get());
            jSONObject.put("invalid_delete_count", m().get());
            jSONObject.put("will_save_count", nu().get());
            jSONObject.put("will_save_show_count", rh().get());
            jSONObject.put("save_success_show_count", my().get());
            jSONObject.put("will_save_click_count", gt().get());
            jSONObject.put("save_success_click_count", rl().get());
            jSONObject.put("did_send_count", da().get());
            jSONObject.put("did_send_distinct_count", gu().get());
            jSONObject.put("did_send_show_count", gr().get());
            jSONObject.put("did_send_show_distinct_count", zm().get());
            jSONObject.put("send_show_success_valid_count", yv().get());
            jSONObject.put("send_show_success_invalid_count", d().get());
            jSONObject.put("did_send_click_count", p().get());
            jSONObject.put("did_send_click_distinct_count", md().get());
            jSONObject.put("send_click_success_valid_count", h().get());
            jSONObject.put("send_click_success_invalid_count", eo().get());
            jSONObject.put("send_success_valid_count", qy().get());
            long j5 = sp().get();
            jSONObject.put("send_success_invalid_count", zb().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", sl().get());
            jSONObject.put("success_tm", uj().get());
            jSONObject.put("queue_timeout_tm", ve().get());
            jSONObject.put("after_upload_tm", tt().get());
            jSONObject.put("quit_tm", c().get());
            long j6 = cu().get();
            long j7 = qp().get();
            jSONObject.put("success_request_cost_ts_avg", (nb().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = pf().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", or().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", nVar.sl());
            jSONObject.put("app_start_time", com.byazt.mv.tt.ve);
            jSONObject.put("app_first_time", com.byazt.mv.tt.uj);
            jSONObject.put("fail_code_list", this.c.toString());
            jSONObject.put("delete_msg", this.tt.toString());
            uj ujVarUj = nVar.uj();
            if (ujVarUj != null) {
                jSONObject.put("is_debug", ujVarUj.c());
                x xVarT = ujVarUj.t();
                if (xVarT != null) {
                    jSONObject.put("is_plugin", xVarT.x());
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }
}
