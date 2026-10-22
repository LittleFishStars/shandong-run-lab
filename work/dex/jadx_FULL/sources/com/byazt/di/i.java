package com.byazt.di;

import com.byazt.hu.t;
import com.byazt.hu.u;
import com.byazt.s.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 42})
public class i {
    public static final String c = "i";
    public static boolean tt = false;

    @com.byazt.zqa.c(c = {0, 1, 345, 64})
    public static class c {
        public static i c = new i();
    }

    public static i c() {
        return c.c;
    }

    private i() {
    }

    public void c(com.byazt.nn.n nVar, final com.byazt.dd.tt ttVar) {
        if (!com.byazt.hu.n.ve(ttVar)) {
            t.c().c(c, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (ttVar == null) {
            t.c().tt(c, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (ttVar.kp()) {
            t.c().tt(c, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            t tVarC = t.c();
            String str = c;
            tVarC.c(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.byazt.hu.n.uj(ttVar)) {
                t.c().c(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int iOptInt = com.byazt.gq.t.i().optInt("market_install_finish_check_time", 600);
                if (ttVar.r() == 0 || System.currentTimeMillis() - ttVar.r() > ((long) iOptInt) * 1000) {
                    ttVar.da(System.currentTimeMillis());
                    c(iOptInt, new z() { // from class: com.byazt.di.i.1
                        @Override // com.byazt.s.z
                        public void c() {
                            t.c().c(i.c, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - ttVar.r()));
                            ttVar.da(true);
                            com.byazt.nn.a.c().c(ttVar);
                        }

                        @Override // com.byazt.s.z
                        public void tt() {
                            t.c().c(i.c, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                            if (!u.tt(ttVar)) {
                                t.c().c(i.c, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                            }
                            ttVar.da(false);
                            com.byazt.nn.a.c().c(ttVar);
                        }
                    });
                } else {
                    t.c().c(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
            }
            if (com.byazt.hu.n.n(ttVar)) {
                t.c().c(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.byazt.gq.u.c().c(ttVar);
            }
            com.byazt.nn.i.c().c(ttVar);
        } catch (Exception unused) {
            com.byazt.dm.ve.c().c(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void c(final com.byazt.dd.tt ttVar) {
        if (!com.byazt.hu.n.ve(ttVar)) {
            t.c().c(c, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (ttVar == null) {
            t.c().tt(c, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (ttVar.n.get() && System.currentTimeMillis() - ttVar.r() > 30000) {
            t.c().c(c, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.byazt.hu.n.uj(ttVar)) {
            long jOptInt = ((long) com.byazt.gq.t.i().optInt("market_install_finish_check_time", 600)) * 1000;
            if (System.currentTimeMillis() - ttVar.r() >= jOptInt) {
                t.c().c(c, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                c((int) (((ttVar.r() + jOptInt) - System.currentTimeMillis()) / 1000), new z() { // from class: com.byazt.di.i.2
                    @Override // com.byazt.s.z
                    public void c() {
                        t.c().c(i.c, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        ttVar.n.compareAndSet(false, true);
                        com.byazt.nn.i.c().c(ttVar);
                    }

                    @Override // com.byazt.s.z
                    public void tt() {
                        t.c().c(i.c, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!u.tt(ttVar)) {
                            t.c().c(i.c, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        ttVar.n.compareAndSet(true, false);
                        ttVar.da(false);
                        com.byazt.nn.i.c().c(ttVar);
                    }
                });
            }
        }
    }

    public void c(int i, z zVar) {
        t.c().c(c, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!tt) {
            com.byazt.z.uj.sl().c(zVar);
            tt = true;
        }
        com.byazt.z.uj.sl().c(i);
    }
}
