package com.byazt.f;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 953, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28535a;
    public final ve c;
    public final long n;
    public List<String> tt;
    public Long uj;
    public Long ve;

    public uj(ve veVar, long j, boolean z) {
        this(veVar, j, null, z);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
    public void c() {
        if (this.f28535a) {
            return;
        }
        this.f28535a = true;
        if (this.tt == null) {
            this.tt = new ArrayList();
        }
        n nVarT = this.c.t();
        long jTt = nVarT.tt();
        n nVarU = this.c.u();
        long jTt2 = nVarU.tt();
        n nVarSl = this.c.sl();
        long jTt3 = nVarSl.tt();
        long j = 0;
        if (nVarT.c() == 0) {
            if (nVarSl.c() == 0) {
                this.tt.add("Error: zero orig time -- cannot compute delay/offset");
                return;
            } else {
                this.uj = Long.valueOf(jTt3 - this.n);
                this.tt.add("Error: zero orig time -- cannot compute delay");
                return;
            }
        }
        if (nVarU.c() == 0 || nVarSl.c() == 0) {
            this.tt.add("Warning: zero rcvNtpTime or xmitNtpTime");
            long j2 = this.n;
            if (jTt > j2) {
                this.tt.add("Error: OrigTime > DestRcvTime");
            } else {
                this.ve = Long.valueOf(j2 - jTt);
            }
            if (nVarU.c() != 0) {
                this.uj = Long.valueOf(jTt2 - jTt);
                return;
            } else {
                if (nVarSl.c() != 0) {
                    this.uj = Long.valueOf(jTt3 - this.n);
                    return;
                }
                return;
            }
        }
        long j3 = this.n - jTt;
        if (jTt3 >= jTt2) {
            long j4 = jTt3 - jTt2;
            if (j4 <= j3) {
                j = j3 - j4;
            } else if (j4 - j3 != 1) {
                this.tt.add("Warning: processing time > total network time");
            } else if (j3 != 0) {
                this.tt.add("Info: processing time > total network time by 1 ms -> assume zero delay");
            }
            this.ve = Long.valueOf(j);
            if (jTt > this.n) {
                this.tt.add("Error: OrigTime > DestRcvTime");
            }
            this.uj = Long.valueOf(((jTt2 - jTt) + (jTt3 - this.n)) / 2);
        }
        this.tt.add("Error: xmitTime < rcvTime");
        j = j3;
        this.ve = Long.valueOf(j);
        if (jTt > this.n) {
            this.tt.add("Error: OrigTime > DestRcvTime");
        }
        this.uj = Long.valueOf(((jTt2 - jTt) + (jTt3 - this.n)) / 2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            uj ujVar = (uj) obj;
            if (this.n == ujVar.n && this.c.equals(ujVar.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.n) * 31) + this.c.hashCode();
    }

    public ve tt() {
        return this.c;
    }

    public uj(ve veVar, long j, List<String> list, boolean z) {
        if (veVar == null) {
            throw new IllegalArgumentException("message cannot be null");
        }
        this.n = j;
        this.c = veVar;
        this.tt = list;
        if (z) {
            c();
        }
    }
}
