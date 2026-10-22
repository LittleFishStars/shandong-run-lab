package com.byazt.hr;

import android.text.TextUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 54})
public class ve {
    public Map<String, tt> c;
    public Map<String, ConcurrentHashMap<String, com.byazt.hr.c>> tt;

    @com.byazt.zqa.c(c = {0, 1, 29, 24})
    public static class c {
        public static ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    private ve() {
        this.tt = new ConcurrentHashMap();
    }

    public void c(ConcurrentHashMap<String, tt> concurrentHashMap) {
        this.c = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void c(String str, String str2, String str3) {
        boolean z;
        com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, tt> map = this.c;
        tt ttVar = map != null ? map.get(str) : null;
        if (ttVar == null) {
            z = false;
            break;
        }
        Iterator<String> it = ttVar.tt().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String next = it.next();
            if (TextUtils.equals(next, str3)) {
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(next)));
                z = true;
                break;
            }
        }
        if (z) {
            long time = new Date().getTime() + ttVar.c();
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + a.tt(time));
            com.byazt.hr.c cVar = new com.byazt.hr.c(str, str2, time);
            if (this.tt != null) {
                ConcurrentHashMap<String, com.byazt.hr.c> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, cVar);
                this.tt.put(str, concurrentHashMap);
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.tt);
            }
        }
    }

    public com.byazt.pp.c c(String str, String str2) {
        com.byazt.hr.c cVar;
        ConcurrentHashMap<String, com.byazt.hr.c> concurrentHashMap;
        com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.byazt.hr.c>> map = this.tt;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            cVar = null;
        } else {
            cVar = concurrentHashMap.get(str2);
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(cVar)));
        }
        if (cVar != null && cVar.c() != 0) {
            long time = new Date().getTime();
            if (time <= cVar.c()) {
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + a.tt(time));
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + a.tt(cVar.c()));
                return new com.byazt.bnd.c(40044, com.byazt.pp.c.c(40044));
            }
        }
        return null;
    }
}
