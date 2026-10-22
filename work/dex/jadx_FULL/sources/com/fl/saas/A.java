package com.fl.saas;

import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class A {
    public static boolean a(String str) {
        try {
            String strC = S0.a().c(str + "lastShowDay");
            int iA = S0.a().a(str + "lastDayShowNumber");
            long jB = S0.a().b(str + "lastShowHour");
            int iA2 = S0.a().a(str + "lastHourShowNumber");
            long jB2 = S0.a().b(str + "lastShowSec");
            int iA3 = S0.a().a(str + "impressFreqDay");
            int iA4 = S0.a().a(str + "impressFreqHour");
            int iA5 = S0.a().a(str + "impressFreqInterval");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String date = DeviceUtil.getDate();
            if (iA5 > 0 && jCurrentTimeMillis - jB2 <= iA5) {
                return true;
            }
            if (iA4 <= 0 || jCurrentTimeMillis - jB > 3600 || iA2 < iA4) {
                return iA3 > 0 && date.equals(strC) && iA >= iA3;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
