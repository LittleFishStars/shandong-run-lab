package com.byazt.hr;

import android.text.TextUtils;
import android.util.Pair;
import com.ali.auth.third.login.LoginConstants;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 158})
public class sl {
    public static final String c = "TTMediationSDK_" + sl.class.getSimpleName();
    public Map<String, Pair<String, String>> tt;

    @com.byazt.zqa.c(c = {0, 1, 29, 925})
    public static class c {
        public static sl c = new sl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sp uj(String str, String str2) {
        return x.c().tt(str, str2);
    }

    public void delete(String str, String str2) {
        x.c().c(str, str2);
    }

    public boolean ve(String str, String str2) {
        com.byazt.eu.tt.c(c, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        sp spVarUj = uj(str, str2);
        if (spVarUj == null || !spVarUj.x()) {
            return true;
        }
        for (n nVar : spVarUj.sl()) {
            Date date = new Date();
            String str3 = c;
            com.byazt.eu.tt.c(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + nVar.uj());
            if (date.getTime() > nVar.uj()) {
                c(spVarUj, nVar.ve(), 0);
                c(spVarUj, nVar.ve(), a.c(nVar.tt()));
                com.byazt.eu.tt.c(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + nVar.ve());
            } else {
                if (nVar.n() >= nVar.c()) {
                    com.byazt.eu.tt.c(str3, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + nVar.ve() + " count = " + nVar.n());
                    Map<String, Pair<String, String>> map = this.tt;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(LoginConstants.UNDER_LINE);
                    sb.append(str2);
                    String string = sb.toString();
                    String strVe = nVar.ve();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(nVar.n());
                    map.put(string, new Pair<>(strVe, sb2.toString()));
                    return false;
                }
                com.byazt.eu.tt.c(str3, "adn checkFreqctl 未到上线可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + nVar.ve() + " count = " + nVar.n());
            }
        }
        return true;
    }

    private sl() {
        this.tt = new ConcurrentHashMap();
    }

    public void tt(final String str, final String str2) {
        com.byazt.eu.n.c(new Runnable() { // from class: com.byazt.hr.sl.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eu.tt.c(sl.c, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                sp spVarUj = sl.this.uj(str, str2);
                if (spVarUj == null || !spVarUj.x()) {
                    return;
                }
                for (n nVar : spVarUj.sl()) {
                    if (nVar.n() < nVar.c()) {
                        sl.this.c(spVarUj, nVar.ve(), nVar.n() + 1);
                    }
                }
            }
        });
    }

    public static sl c() {
        return c.c;
    }

    public void tt(sp spVar) {
        u.c().tt(spVar);
    }

    public Pair<String, String> c(String str, String str2) {
        return this.tt.get(str + LoginConstants.UNDER_LINE + str2);
    }

    public boolean c(sp spVar) {
        if (spVar == null) {
            return false;
        }
        sp spVarUj = uj(spVar.tt(), spVar.ve());
        if (spVarUj == null) {
            com.byazt.eu.tt.c(c, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(spVar.a())) {
            com.byazt.eu.tt.c(c, "adn freqctl version 为空 清空本地数据 ");
            delete(spVarUj.tt(), spVarUj.ve());
            return false;
        }
        if (TextUtils.equals(spVarUj.a(), spVar.a())) {
            com.byazt.eu.tt.c(c, "adn freqctl version 一致 version = " + spVarUj.a() + " 无需处理");
            return false;
        }
        com.byazt.eu.tt.c(c, "adn freqctl version不一致，缓存新规则 old version = " + spVarUj.a() + "  new version " + spVar.a());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sp spVar, String str, int i) {
        x.c().c(spVar, str, i);
    }

    private void c(sp spVar, String str, long j) {
        x.c().c(spVar, str, j);
    }
}
