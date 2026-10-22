package com.byazt.lu;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ds.i;
import com.byazt.ds.x;
import com.byazt.tv.da;
import com.byazt.yv.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 91})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f28781a = new AtomicLong(1000);
    public static c z;
    public final x c;
    public volatile boolean da;
    public long i = -1;
    public String n;
    public long sl;
    public long sp;
    public int t;
    public final i tt;
    public String u;
    public com.byazt.tv.i uj;
    public com.byazt.tv.i ve;
    public int x;
    public com.byazt.tv.a yp;

    @com.byazt.zqa.c(c = {0, 1, 772, 180})
    public static class c extends da {
        private c() {
        }
    }

    public sp(i iVar, x xVar) {
        this.tt = iVar;
        this.c = xVar;
    }

    public static c n() {
        if (z == null) {
            z = new c();
        }
        z.tt = System.currentTimeMillis();
        return z;
    }

    public static long uj() {
        return f28781a.incrementAndGet();
    }

    public String c() {
        return this.n;
    }

    public boolean tt() {
        return this.da;
    }

    public boolean ve() {
        return tt() && this.sl == 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    public synchronized Bundle c(long j, long j2) {
        Bundle bundle;
        if (this.c.a() && ve()) {
            long j3 = this.sp;
            if (j3 <= 0 || j - j3 <= j2) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putInt("session_no", this.t);
                int i = this.x + 1;
                this.x = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.sp) / 1000);
                bundle.putString("session_start_time", com.byazt.tv.c.tt(this.i));
                this.sp = j;
            }
        } else {
            bundle = null;
        }
        return bundle;
    }

    public void tt(com.byazt.tv.c cVar) {
        if (cVar != null) {
            if (this.c.rl()) {
                cVar.x = com.byazt.gj.c.n();
            }
            cVar.f29074a = com.byazt.gj.c.sl();
            cVar.sp = com.byazt.gj.c.da();
            cVar.uj = this.n;
            cVar.ve = uj();
        }
    }

    private synchronized void c(com.byazt.tv.c cVar, ArrayList<com.byazt.tv.c> arrayList, boolean z2) {
        long j = cVar instanceof c ? -1L : cVar.tt;
        this.n = UUID.randomUUID().toString();
        f28781a.set(1000L);
        this.i = j;
        this.da = z2;
        this.sl = 0L;
        this.sp = 0L;
        if (com.byazt.yv.da.tt) {
            com.byazt.yv.da.c("startSession, " + this.n + ", hadUi:" + z2 + " data:" + cVar, null);
        }
        if (z2) {
            Calendar calendar = Calendar.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(calendar.get(1));
            sb.append(calendar.get(2));
            sb.append(calendar.get(5));
            String string = sb.toString();
            if (TextUtils.isEmpty(this.u)) {
                this.u = this.c.ve();
                this.t = this.c.uj();
            }
            if (!string.equals(this.u)) {
                this.u = string;
                this.t = 1;
            } else {
                this.t++;
            }
            this.c.c(string, this.t);
            this.x = 0;
            this.sp = cVar.tt;
        }
        if (j != -1) {
            com.byazt.tv.a aVar = new com.byazt.tv.a(false);
            aVar.uj = this.n;
            aVar.ve = uj();
            aVar.tt = this.i;
            aVar.yp = this.da ? false : true;
            aVar.u = this.tt.ve();
            aVar.t = this.tt.tt();
            aVar.f29074a = com.byazt.gj.c.sl();
            aVar.sp = com.byazt.gj.c.da();
            if (this.c.rl()) {
                aVar.x = com.byazt.gj.c.n();
            }
            arrayList.add(aVar);
            this.yp = aVar;
            if (com.byazt.yv.da.tt) {
                com.byazt.yv.da.c("gen launch, " + aVar.uj + ", hadUi:" + z2, null);
            }
        }
    }

    public static boolean c(com.byazt.tv.c cVar) {
        if (cVar instanceof com.byazt.tv.i) {
            return ((com.byazt.tv.i) cVar).da();
        }
        return false;
    }

    public boolean c(com.byazt.tv.c cVar, ArrayList<com.byazt.tv.c> arrayList) {
        boolean z2 = cVar instanceof com.byazt.tv.i;
        boolean zC = c(cVar);
        boolean z3 = true;
        if (this.i == -1) {
            c(cVar, arrayList, c(cVar));
        } else if (!this.da && zC) {
            c(cVar, arrayList, true);
        } else {
            long j = this.sl;
            if (j == 0 || cVar.tt <= j + this.c.gu()) {
                if (this.i > cVar.tt + com.heytap.mcssdk.constant.a.n) {
                    c(cVar, arrayList, zC);
                } else {
                    z3 = false;
                }
            } else if (!u.tt() && u.c()) {
                c(cVar, arrayList, zC);
            }
        }
        if (z2) {
            com.byazt.tv.i iVar = (com.byazt.tv.i) cVar;
            if (iVar.da()) {
                this.sl = 0L;
                arrayList.add(cVar);
                if (TextUtils.isEmpty(iVar.u)) {
                    com.byazt.tv.i iVar2 = this.uj;
                    if (iVar2 != null && (iVar.tt - iVar2.tt) - iVar2.t < 500) {
                        iVar.u = iVar2.yp;
                    } else {
                        com.byazt.tv.i iVar3 = this.ve;
                        if (iVar3 != null && (iVar.tt - iVar3.tt) - iVar3.t < 500) {
                            iVar.u = iVar3.yp;
                        }
                    }
                }
            } else {
                Bundle bundleC = c(cVar.tt, 0L);
                if (bundleC != null) {
                    com.byazt.gj.c.c("play_session", bundleC);
                }
                this.sl = iVar.tt;
                arrayList.add(cVar);
                if (iVar.sl()) {
                    this.ve = iVar;
                } else {
                    this.uj = iVar;
                    this.ve = null;
                }
            }
        } else if (!(cVar instanceof c)) {
            arrayList.add(cVar);
        }
        tt(cVar);
        return z3;
    }
}
