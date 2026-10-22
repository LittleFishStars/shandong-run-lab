package com.byazt.ck;

import android.text.TextUtils;
import com.byazt.it.n;
import com.byazt.nr.m;
import com.zj.adlib.bv9;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 603, 13})
public class tt {
    public static volatile tt c;
    public int ve = -1;
    public long uj = -1;
    public int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28367a = -1;
    public int sp = -1;
    public int x = -1;
    public int i = -1;
    public int da = -1;
    public n tt = com.byazt.rq.c.tt();

    private tt() {
    }

    private synchronized JSONObject i() {
        try {
            n nVar = this.tt;
            if (nVar == null) {
                return null;
            }
            String string = nVar.getString("app_common_config", null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (!string.startsWith("[") && !string.startsWith(bv9.b)) {
                string = com.byazt.vx.c.tt(string, com.byazt.vx.tt.c());
            }
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (Throwable th) {
                    m.c(th);
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void tt(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("event_batch_size", 100);
        this.ve = iOptInt;
        if (iOptInt <= 0 || iOptInt > 1000) {
            this.ve = 100;
        }
        long jOptLong = jSONObject.optLong("event_routine_interval", com.igexin.push.config.c.l);
        this.uj = jOptLong;
        if (jOptLong < 10000 || jOptLong > 300000) {
            this.uj = com.igexin.push.config.c.l;
        }
        int iOptInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.n = iOptInt2;
        if (iOptInt2 != 0 && iOptInt2 != 1) {
            this.n = 0;
        }
        this.sp = jSONObject.optInt("rv_start_time", 5000);
        int iOptInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
        this.f28367a = iOptInt3;
        if (iOptInt3 != 0 && iOptInt3 != 1) {
            this.f28367a = 0;
        }
        com.byazt.ix.uj.c().c(jSONObject.optInt("pre_fetch_count", 20));
        this.x = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
        this.i = jSONObject.optInt("can_log", -1);
        this.da = jSONObject.optInt("enable_abtest_id", 0);
    }

    public int a() {
        int i = this.sp;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return 5000;
        }
        tt(jSONObjectI);
        return this.sp;
    }

    public int n() {
        int i = this.f28367a;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return 0;
        }
        tt(jSONObjectI);
        return this.f28367a;
    }

    public boolean sp() {
        int i = this.i;
        if (i != -1) {
            return i == 1;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI != null) {
            tt(jSONObjectI);
            if (this.i == 1) {
                return true;
            }
        }
        return false;
    }

    public int uj() {
        int i = this.n;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return 0;
        }
        tt(jSONObjectI);
        return this.n;
    }

    public synchronized long ve() {
        long j = this.uj;
        if (j != -1) {
            return j;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return com.igexin.push.config.c.l;
        }
        tt(jSONObjectI);
        return this.uj;
    }

    public int x() {
        int i = this.da;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return 0;
        }
        tt(jSONObjectI);
        return this.da;
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public synchronized void c(final JSONObject jSONObject) {
        if (jSONObject != null) {
            tt(jSONObject);
            if (com.byazt.bp.tt.tt().ve()) {
                com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.ck.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        tt.this.tt.put("app_common_config", string);
                    }
                });
            } else {
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    this.tt.put("app_common_config", string);
                }
            }
        }
    }

    public synchronized int tt() {
        int i = this.ve;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectI = i();
        if (jSONObjectI == null) {
            return 100;
        }
        tt(jSONObjectI);
        return this.ve;
    }
}
