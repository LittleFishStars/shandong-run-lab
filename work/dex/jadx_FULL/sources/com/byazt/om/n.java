package com.byazt.om;

import android.text.TextUtils;
import com.byazt.vx.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 46})
public class n implements c {
    private int c(int i) {
        switch (i) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        com.byazt.bnd.c cVar = !com.byazt.bp.tt.tt().c(ttVarC.gu().gt(), ttVarC.gu().my()) ? new com.byazt.bnd.c(840031, com.byazt.pp.c.c(840031)) : null;
        if (cVar == null && !com.byazt.bp.tt.tt().tt(ttVarC.gu().my())) {
            cVar = new com.byazt.bnd.c(c(ttVarC.gu().my()), com.byazt.pp.c.c(c(ttVarC.gu().my())));
        }
        if (cVar == null && !com.byazt.sx.ve.tt()) {
            cVar = new com.byazt.bnd.c(1, com.byazt.pp.c.c(1));
        }
        if (cVar == null && ttVarC.da()) {
            cVar = new com.byazt.bnd.c(41044, com.byazt.pp.c.c(41044));
        }
        if (cVar == null && ttVarC.getContext() == null) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "Context为null！！！");
            cVar = new com.byazt.bnd.c(41005, com.byazt.pp.c.c(41005));
        }
        if (cVar == null && TextUtils.isEmpty(ttVarC.gu().gt())) {
            cVar = new com.byazt.bnd.c(840026, "广告位id不能为空");
        }
        if (cVar == null && (ttVarC.m() == null || p.c(ttVarC.m().l()))) {
            if (com.byazt.ck.uj.c().ve()) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(ttVarGu.gt()) + "settings config.......没有settings config配置信息,AdUnitId = " + ttVarGu.gt());
                cVar = new com.byazt.bnd.c(840040, com.byazt.pp.c.c(840040));
                com.byazt.ng.a.tt(ttVarGu, 1);
            } else if (ttVarC.m() == null || !p.c(ttVarC.m().l())) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(ttVarGu.gt()) + "settings config.......注意，AdUnitId = " + ttVarGu.gt() + " 的配置信息为 null ！！");
                cVar = new com.byazt.bnd.c(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.byazt.ng.a.tt(ttVarGu, 2);
            } else {
                com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(ttVarGu.gt()) + "settings config.......注意，AdUnitId = " + ttVarGu.gt() + "  没有对应的waterfall配置信息");
                com.byazt.ng.a.tt(ttVarGu, 3);
            }
            com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c(1);
        }
        if (cVar == null) {
            String strBx = ttVarGu.bx();
            if (!TextUtils.isEmpty(strBx) && !ttVarGu.sv() && !com.byazt.qv.uj.c(ttVarGu.gt(), strBx)) {
                cVar = new com.byazt.bnd.c(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.byazt.bnd.c cVar2 = cVar;
        if (cVar2 == null) {
            interfaceC0486c.c(interfaceC0486c.c());
        } else {
            com.byazt.ng.a.c(ttVarGu, ttVarC.m() != null ? ttVarC.m().lo() : null, !ttVarC.yv(), ttVarC.pf().c, cVar2.c, (Map<String, Object>) null);
            ttVarC.c(cVar2);
        }
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        if (ttVarC.da()) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "调用过销毁方法_destroy()！！！");
            ttVarC.c(new com.byazt.pp.c(41044, com.byazt.pp.c.c(41044)));
        } else if (ttVarC.nu().n()) {
            ttVarC.c(new com.byazt.pp.c(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0486c.c((String) null);
        }
    }
}
