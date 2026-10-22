package com.fl.saas.config.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ConfigUtils {
    public static boolean checkImpressFreq(String str) {
        try {
            String string = SPUtil.getInstance().getString(str + "lastShowDay");
            int i = SPUtil.getInstance().getInt(str + "lastDayShowNumber");
            long j = SPUtil.getInstance().getLong(str + "lastShowHour");
            int i2 = SPUtil.getInstance().getInt(str + "lastHourShowNumber");
            long j2 = SPUtil.getInstance().getLong(str + "lastShowSec");
            int i3 = SPUtil.getInstance().getInt(str + "impressFreqDay");
            int i4 = SPUtil.getInstance().getInt(str + "impressFreqHour");
            int i5 = SPUtil.getInstance().getInt(str + "impressFreqInterval");
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            String date = DeviceUtil.getDate();
            if (i5 > 0 && jCurrentTimeMillis - j2 <= i5) {
                return true;
            }
            if (i4 <= 0 || jCurrentTimeMillis - j > 3600 || i2 < i4) {
                return i3 > 0 && date.equals(string) && i >= i3;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
