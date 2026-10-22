package com.byazt.no;

import com.byazt.hs.sp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 785, 54})
public class ve implements sp {
    public static final ArrayList<String> n;
    public final String c;
    public boolean da;
    public boolean i;
    public sp sl;
    public int sp;
    public final long tt;
    public List<com.byazt.t.ve> ve;
    public long x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f28842a = null;
    public final Object uj = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        n = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add(com.ipd.dsp.internal.g0.c.g);
        arrayList.add("Content-Disposition");
    }

    public ve(String str, List<com.byazt.t.ve> list, long j) {
        this.c = str;
        this.ve = list;
        this.tt = j;
    }

    public boolean a() {
        return System.currentTimeMillis() - this.x < tt.tt;
    }

    public void c() throws Exception {
        if (this.f28842a != null) {
            return;
        }
        try {
            this.da = true;
            this.sl = com.byazt.zz.ve.c(this.c, this.ve);
            synchronized (this.uj) {
                if (this.sl != null) {
                    HashMap map = new HashMap();
                    this.f28842a = map;
                    c(this.sl, map);
                    this.sp = this.sl.tt();
                    this.x = System.currentTimeMillis();
                    this.i = c(this.sp);
                }
                this.da = false;
                this.uj.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.uj) {
                if (this.sl != null) {
                    HashMap map2 = new HashMap();
                    this.f28842a = map2;
                    c(this.sl, map2);
                    this.sp = this.sl.tt();
                    this.x = System.currentTimeMillis();
                    this.i = c(this.sp);
                }
                this.da = false;
                this.uj.notifyAll();
                throw th;
            }
        }
    }

    public boolean c(int i) {
        return i >= 200 && i < 300;
    }

    public Map<String, String> i() {
        return this.f28842a;
    }

    public boolean n() {
        return this.i;
    }

    public boolean sp() {
        return this.da;
    }

    @Override // com.byazt.hs.sp
    public int tt() throws IOException {
        return this.sp;
    }

    public void uj() throws InterruptedException {
        synchronized (this.uj) {
            if (this.da && this.f28842a == null) {
                this.uj.wait();
            }
        }
    }

    @Override // com.byazt.hs.sp
    public void ve() {
        sp spVar = this.sl;
        if (spVar != null) {
            spVar.ve();
        }
    }

    public List<com.byazt.t.ve> x() {
        return this.ve;
    }

    private void c(sp spVar, Map<String, String> map) {
        if (spVar == null || map == null) {
            return;
        }
        for (String str : n) {
            map.put(str, spVar.c(str));
        }
    }

    @Override // com.byazt.hs.sp
    public String c(String str) {
        Map<String, String> map = this.f28842a;
        if (map != null) {
            return map.get(str);
        }
        sp spVar = this.sl;
        if (spVar != null) {
            return spVar.c(str);
        }
        return null;
    }
}
