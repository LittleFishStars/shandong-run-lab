package com.byazt.gq;

import android.os.SystemClock;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 67})
public class u {
    public static final String c = "u";

    @com.byazt.zqa.c(c = {0, 1, 52, 57})
    public class c implements Runnable {
        public final com.byazt.dd.tt tt;

        public c(com.byazt.dd.tt ttVar) {
            this.tt = ttVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.tt.da(true);
                    u.this.tt(this.tt);
                } catch (Exception e) {
                    m.c(e);
                }
            } finally {
                this.tt.da(false);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 52, 2243})
    public static class tt {
        public static u c = new u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.dd.tt ttVar) {
        JSONObject jSONObject = new JSONObject();
        int iC = com.byazt.hu.n.c(ttVar);
        int iTt = com.byazt.hu.n.tt(ttVar);
        if (com.byazt.hu.n.n(ttVar) && com.byazt.hu.n.uj(ttVar)) {
            com.byazt.hu.t.c().c(c, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            c(ttVar, iC, iTt, jSONObject);
        } else {
            com.byazt.hu.t.c().c(c, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            tt(ttVar, 15, 20000, jSONObject);
        }
    }

    private u() {
    }

    public static u c() {
        return tt.c;
    }

    public void c(com.byazt.dd.tt ttVar) {
        com.byazt.hu.t.c().c(c, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.byazt.di.n.c().ve(new c(ttVar));
    }

    private void c(com.byazt.dd.tt ttVar, int i, int i2, JSONObject jSONObject) {
        int iA;
        if (ttVar.pf() == 4) {
            iA = t.i().optInt("market_install_finish_check_time", 600);
        } else {
            iA = com.byazt.hu.n.a(ttVar);
        }
        int i3 = ((iA * 1000) / 20000) + 1;
        com.byazt.hu.t tVarC = com.byazt.hu.t.c();
        String str = c;
        tVarC.c(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (tt(ttVar, i3, 20000, jSONObject)) {
            return;
        }
        if (((long) iA) * 1000 < com.byazt.hu.n.sp(ttVar)) {
            com.byazt.hu.t.c().c(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (tt(ttVar, i, i2, jSONObject)) {
                return;
            }
            com.byazt.hu.t.c().c(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.byazt.hu.t.c().c(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean tt(com.byazt.dd.tt ttVar, int i, int i2, JSONObject jSONObject) {
        com.byazt.hu.t.c().c(c, "realListenInstallFinishEvent", "开始轮询检测,轮询时间间隔为" + i2 + ",轮询次数为" + i);
        long j = (long) i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.byazt.hu.u.tt(ttVar)) {
                com.byazt.di.c.c().c(ttVar.n());
                com.byazt.hu.t.c().c(c, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
