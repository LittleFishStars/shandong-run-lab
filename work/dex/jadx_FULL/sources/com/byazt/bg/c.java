package com.byazt.bg;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1535, 20})
public class c {
    public static final com.byazt.it.ve c = com.byazt.vif.uj.c(com.byazt.bp.c.t().u(), "gm_tt_user_live_day_time");
    public static final SimpleDateFormat tt = new SimpleDateFormat("yyyy-MM-dd");
    public static final Calendar ve = Calendar.getInstance();

    public static int a(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return -1;
        }
        return i(c.getString(tt(str, "_click_count_"), null));
    }

    public static void c() {
        com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.byazt.bp.tt.tt().l());
        if (com.byazt.bp.tt.tt().l()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strSp = sp();
            com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(strSp)));
            com.byazt.it.ve veVar = c;
            if (veVar.getBoolean(strSp, false)) {
                com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "key=" + strSp + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(veVar.getString("start_index", null))) {
                veVar.put("start_index", strSp);
                com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(strSp)));
            }
            veVar.put(strSp, true);
            veVar.put("user_live_times", veVar.getInt("user_live_times", 0) + 1);
            String string = veVar.getString("start_index", null);
            if (TextUtils.equals(string, strSp)) {
                com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "startDay:" + string + ",key=" + strSp + "，同一天，不处理");
            } else {
                try {
                    SimpleDateFormat simpleDateFormat = tt;
                    Date date = simpleDateFormat.parse(string);
                    Date date2 = simpleDateFormat.parse(strSp);
                    if (date2 == null) {
                        date2 = new Date();
                    }
                    if (date != null) {
                        int iC = c(date.getTime(), date2.getTime());
                        int iV = com.byazt.bp.tt.tt().v();
                        if (iV - iC < 0) {
                            int i = iC - iV;
                            String strC = c(date, i);
                            if (!TextUtils.isEmpty(strC)) {
                                veVar.put("start_index", strC);
                                c(string, date, i);
                            }
                            com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "old-startIndex:" + string + ",diff=" + i + ",new-startIndex:" + strC);
                        }
                    }
                } catch (ParseException e) {
                    com.byazt.eu.tt.uj("AdLoadDynamicParamHandler", "计算生成日期出错：" + e.getMessage());
                }
            }
            com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
    }

    private static int i(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
        if (strArrSplit.length != 2 || (str2 = strArrSplit[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public static void n(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return;
        }
        c(str, "_click_count_");
    }

    public static void sp(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return;
        }
        String strTt = tt(str, "_show_current_time_");
        String strTt2 = tt(str, "_show_last_time_");
        com.byazt.it.ve veVar = c;
        String string = veVar.getString("_show_gap_time_day", null);
        String strSp = sp();
        com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + strTt + ",lastKey :" + strTt2 + ",today:" + strSp + ",recordDate:" + string);
        if (TextUtils.equals(string, strSp)) {
            veVar.put(strTt2, veVar.getLong(strTt, 0L));
            veVar.put(strTt, System.currentTimeMillis());
        } else {
            veVar.put(strTt2, 0L);
            veVar.put(strTt, System.currentTimeMillis());
            veVar.put("_show_gap_time_day", strSp);
        }
    }

    public static int tt() {
        if (com.byazt.bp.tt.tt().l()) {
            return c.getInt("user_live_times", 0);
        }
        return -1;
    }

    public static int uj(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return -1;
        }
        return i(c.getString(tt(str, "_show_count_"), null));
    }

    public static void ve(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return;
        }
        c(str, "_show_count_");
    }

    public static long x(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return -1L;
        }
        String strTt = tt(str, "_show_current_time_");
        String strTt2 = tt(str, "_show_last_time_");
        com.byazt.it.ve veVar = c;
        if (!TextUtils.equals(veVar.getString("_show_gap_time_day", null), sp())) {
            return 0L;
        }
        long j = veVar.getLong(strTt2, 0L);
        if (j == 0) {
            return 0L;
        }
        long j2 = veVar.getLong(strTt, 0L) - j;
        if (j2 < 0) {
            return 0L;
        }
        return Math.round(j2 / 1000.0f);
    }

    public static int n() {
        if (com.byazt.bp.tt.tt().l()) {
            return c(com.byazt.bp.c.t().ve(), System.currentTimeMillis());
        }
        return -1;
    }

    public static int tt(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return -1;
        }
        return i(c.getString(tt(str, "_dislike_count_"), ""));
    }

    public static void ve() {
        com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.byazt.bp.tt.tt().l());
        if (com.byazt.bp.tt.tt().l()) {
            c((String) null, "tt_sdk_start_count_");
        }
    }

    public static long a() {
        if (!com.byazt.bp.tt.tt().l()) {
            return -1L;
        }
        float fN = com.byazt.bp.c.t().n() / 60000.0f;
        if (fN <= 0.0f || fN >= 1.0f) {
            return Math.round(fN);
        }
        return 1L;
    }

    public static int uj() {
        if (com.byazt.bp.tt.tt().l()) {
            return i(c.getString("tt_sdk_start_count_", null));
        }
        return -1;
    }

    private static String tt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + str2;
    }

    private static String sp() {
        return tt.format(new Date());
    }

    private static void c(String str, Date date, int i) {
        if (i == 1) {
            com.byazt.it.ve veVar = c;
            if (veVar.getBoolean(str, false)) {
                veVar.put("user_live_times", Math.max(veVar.getInt("user_live_times", 0) - 1, 0));
            }
            veVar.remove(str);
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String strC = c(date, i2);
            com.byazt.it.ve veVar2 = c;
            if (veVar2.getBoolean(strC, false)) {
                veVar2.put("user_live_times", Math.max(veVar2.getInt("user_live_times", 0) - 1, 0));
            }
            veVar2.remove(strC);
        }
    }

    public static void c(String str) {
        if (!com.byazt.bp.tt.tt().l() || str == null) {
            return;
        }
        c(str, "_dislike_count_");
    }

    private static void c(String str, String str2) {
        String strTt = tt(str, str2);
        String strSp = sp();
        com.byazt.it.ve veVar = c;
        String string = veVar.getString(strTt, null);
        com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction key:" + strTt + ",old value:" + string);
        int i = 1;
        if (!TextUtils.isEmpty(string)) {
            String[] strArrSplit = string.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(strSp, str3)) {
                    i = 1 + Integer.parseInt(strArrSplit[1]);
                    strSp = str3;
                }
                string = c(strSp, i);
            }
            com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction key:" + strTt + "，new value：" + string);
            veVar.put(strTt, string);
            return;
        }
        veVar.put(strTt, c(strSp, 1));
        com.byazt.eu.tt.tt("AdLoadDynamicParamHandler", "saveTomGlobalStorageByAction 首次记录 key:" + strTt + "，new value：" + c(strSp, 1));
    }

    private static String c(String str, int i) {
        return str + LoginConstants.UNDER_LINE + i;
    }

    private static int c(long j, long j2) {
        return Period.between(Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate(), Instant.ofEpochMilli(j2).atZone(ZoneId.systemDefault()).toLocalDate()).getDays();
    }

    private static String c(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar calendar = ve;
        calendar.setTime(date);
        calendar.add(5, i);
        return tt.format(calendar.getTime());
    }

    public static void c(List<com.byazt.yl.ve> list, com.byazt.nbs.tt ttVar) {
        if (!com.byazt.bp.tt.tt().l() || list == null || ttVar == null) {
            return;
        }
        for (com.byazt.yl.ve veVar : list) {
            if (veVar != null) {
                veVar.getMediaExtraInfo().put(MediationConstant.KEY_GM_PRIME_RIT, ttVar.nb());
            }
        }
    }
}
