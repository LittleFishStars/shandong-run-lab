package com.byazt.hr;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 66})
public class t {
    public static final String c = "TTMediationSDK_" + t.class.getSimpleName();
    public Map<String, Long> tt;

    @com.byazt.zqa.c(c = {0, 1, 29, 125})
    public static class c {
        public static t c = new t();
    }

    public void delete(String str, String str2) {
        da.c().c(str, str2);
    }

    public i uj(String str, String str2) {
        return da.c().tt(str, str2);
    }

    public boolean ve(String str, String str2) {
        String str3 = c;
        com.byazt.eu.tt.c(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        i iVarUj = uj(str, str2);
        if (iVarUj != null && iVarUj.x() && iVarUj.t()) {
            long time = new Date().getTime();
            long jSl = iVarUj.sl();
            long jSl2 = iVarUj.sl() + iVarUj.i();
            com.byazt.eu.tt.c(str3, "adn checkPacing currentTime = " + a.tt(time) + " showTime = " + a.tt(jSl) + " pacingBean.getPacing() = " + iVarUj.i() + " pacingTime = " + a.tt(jSl2));
            if (time <= jSl2) {
                this.tt.put(str + LoginConstants.UNDER_LINE + str2, Long.valueOf(time - jSl));
                return false;
            }
        }
        return true;
    }

    private t() {
        this.tt = new ConcurrentHashMap();
    }

    public static t c() {
        return c.c;
    }

    public void tt(final String str, final String str2) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.hr.t.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eu.tt.c(t.c, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                i iVarUj = t.this.uj(str, str2);
                if (iVarUj == null || !iVarUj.x()) {
                    return;
                }
                Date date = new Date();
                com.byazt.eu.tt.c(t.c, "adn updateShowPacingTime save time = " + a.tt(date.getTime()));
                t.this.c(str, str2, date.getTime());
            }
        });
    }

    public long c(String str, String str2) {
        Long l = this.tt.get(str + LoginConstants.UNDER_LINE + str2);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void tt(i iVar) {
        da.c().c(iVar);
    }

    public boolean c(i iVar) {
        if (iVar == null) {
            return false;
        }
        i iVarUj = uj(iVar.tt(), iVar.ve());
        if (iVarUj == null) {
            com.byazt.eu.tt.c(c, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(iVar.da())) {
            com.byazt.eu.tt.c(c, "adn pacing ruleId 为空 清空本地数据 ");
            delete(iVar.tt(), iVar.ve());
            return false;
        }
        if (TextUtils.equals(iVarUj.da(), iVar.da())) {
            com.byazt.eu.tt.c(c, "adn pacing ruleId 一致 ruleId = " + iVarUj.da() + " 无需处理");
            return false;
        }
        com.byazt.eu.tt.c(c, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + iVarUj.da() + "  new ruleId = " + iVar.da());
        delete(iVar.tt(), iVar.ve());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, long j) {
        da.c().c(str, str2, j);
    }
}
