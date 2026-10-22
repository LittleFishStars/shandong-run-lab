package com.byazt.psp;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.byazt.nr.m;
import com.byazt.uy.sp;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.y6b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 20})
public abstract class c {
    public final Map<String, String> c = new HashMap();
    public final com.byazt.it.ve tt;

    public c(String str) {
        this.tt = com.byazt.vif.uj.c(com.byazt.bp.c.t().u(), str);
        ve();
    }

    public static String c(int i) {
        switch (i) {
            case 1:
                return MediationConstant.RIT_TYPE_BANNER;
            case 2:
                return MediationConstant.RIT_TYPE_INTERSTITIAL;
            case 3:
            case 4:
                return MediationConstant.RIT_TYPE_SPLASH;
            case 5:
                return "native";
            case 6:
            default:
                return null;
            case 7:
                return MediationConstant.RIT_TYPE_REWARD_VIDEO;
            case 8:
                return "fullscreenVideo";
            case 9:
                return MediationConstant.RIT_TYPE_DRAW;
            case 10:
                return MediationConstant.RIT_TYPE_INTERSTITIAL_FULL;
        }
    }

    private void ve(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.tt.put(str, d + LoginConstants.UNDER_LINE + System.currentTimeMillis());
        c(str);
    }

    public abstract Map<String, String> c();

    public abstract JSONObject c(com.byazt.nbs.ve veVar);

    public void c(int i, String str, int i2, double d) {
        if (i2 == 1) {
            c(i, str, d);
        } else if (i2 == 3) {
            tt(i, str, d);
        } else if (i2 == 2) {
            ve(i, str, d);
        }
    }

    public abstract void c(String str, int i, String str2);

    public abstract void c(String str, String str2);

    public void tt() {
        Map all = this.tt.getAll();
        if (all != null) {
            for (Map.Entry entry : all.entrySet()) {
                if (entry != null) {
                    c(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    public abstract boolean tt(String str, JSONObject jSONObject, Map<String, Object> map);

    public double c(int i, String str, int i2) {
        if (i2 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(c(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(tt(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return i2 == 2 ? BigDecimal.valueOf(Double.parseDouble(ve(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private void tt(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.tt.put(str, d + LoginConstants.UNDER_LINE + System.currentTimeMillis());
        c(str);
    }

    private String ve(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String string = this.tt.getString(str, null);
            if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                String[] strArrSplit = string.split(LoginConstants.UNDER_LINE);
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.byazt.bp.tt.tt().c(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.tt.remove(str);
                        } catch (NumberFormatException unused) {
                            this.tt.remove(str);
                            sp.c("自定义上报 saveTime format exception valueTimestamp " + string);
                        }
                    } else {
                        this.tt.remove(str);
                        sp.c("自定义上报 saveTime is not number valueTimestamp " + string);
                    }
                }
            }
        }
        return "0";
    }

    public void c(double d, double d2, String str, String str2) {
        if (this.tt == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        c(str, "_last_post_cpm_", str2, d);
        c(str, "_last_bidding_cpm_", str2, d2);
    }

    private String tt(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String string = this.tt.getString(str, null);
            if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                String[] strArrSplit = string.split(LoginConstants.UNDER_LINE);
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.byazt.bp.tt.tt().c(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.tt.remove(str);
                }
            }
        }
        return "0";
    }

    /* JADX WARN: Code duplicated, block: B:14:0x008f  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x0100  */
    /* JADX WARN: Code duplicated, block: B:70:0x013e  */
    public double[] c(int i, double d, double d2, String str, String str2) {
        double dDoubleValue;
        double dDoubleValue2;
        double dDoubleValue3;
        int i2;
        int i3;
        String string = this.tt.getString(str2 + "_last_post_cpm_", "");
        String string2 = this.tt.getString(str2 + "_last_load_cpm_", "");
        String string3 = this.tt.getString(str2 + "_last_bidding_cpm_", "");
        if (TextUtils.isEmpty(string)) {
            dDoubleValue = 0.0d;
        } else {
            String[] strArrSplit = string.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (TextUtils.isEmpty(str3) || !TextUtils.equals(str3, str)) {
                    dDoubleValue = 0.0d;
                } else {
                    String str4 = strArrSplit[1];
                    if (TextUtils.isEmpty(str4)) {
                        str4 = "0";
                    }
                    dDoubleValue = BigDecimal.valueOf(Double.parseDouble(str4)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue = 0.0d;
            }
        }
        if (TextUtils.isEmpty(string2)) {
            dDoubleValue2 = 0.0d;
        } else {
            String[] strArrSplit2 = string2.split(LoginConstants.UNDER_LINE);
            if (strArrSplit2.length == 2) {
                String str5 = strArrSplit2[0];
                if (TextUtils.isEmpty(str5) || !TextUtils.equals(str5, str)) {
                    dDoubleValue2 = 0.0d;
                } else {
                    String str6 = strArrSplit2[1];
                    if (TextUtils.isEmpty(str6)) {
                        str6 = "0";
                    }
                    dDoubleValue2 = BigDecimal.valueOf(Double.parseDouble(str6)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue2 = 0.0d;
            }
        }
        if (TextUtils.isEmpty(string3)) {
            dDoubleValue3 = 0.0d;
        } else {
            String[] strArrSplit3 = string3.split(LoginConstants.UNDER_LINE);
            if (strArrSplit3.length == 2) {
                String str7 = strArrSplit3[0];
                if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, str)) {
                    dDoubleValue3 = 0.0d;
                } else {
                    String str8 = strArrSplit3[1];
                    dDoubleValue3 = BigDecimal.valueOf(Double.parseDouble(TextUtils.isEmpty(str8) ? "0" : str8)).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
            } else {
                dDoubleValue3 = 0.0d;
            }
        }
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE && dDoubleValue == AudioStats.AUDIO_AMPLITUDE_NONE && dDoubleValue2 == AudioStats.AUDIO_AMPLITUDE_NONE && d2 == AudioStats.AUDIO_AMPLITUDE_NONE && dDoubleValue3 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        }
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            dDoubleValue = d;
            i2 = 2;
        } else {
            i2 = 3;
        }
        if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
            dDoubleValue3 = d2;
            i3 = 5;
        } else {
            i3 = 4;
        }
        if (dDoubleValue >= dDoubleValue2) {
            if (dDoubleValue >= dDoubleValue3) {
                dDoubleValue2 = dDoubleValue;
            } else {
                dDoubleValue2 = dDoubleValue3;
                i2 = i3;
            }
        } else if (dDoubleValue2 > dDoubleValue3) {
            i2 = 1;
        } else {
            dDoubleValue2 = dDoubleValue3;
            i2 = i3;
        }
        if (i == 3 && i2 == 3) {
            i2 = 2;
        }
        return new double[]{dDoubleValue2, (i == 3 && i2 == 4) ? 5 : i2};
    }

    public String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(this.c.get(String.valueOf(c)));
        }
        return sb.toString();
    }

    public void ve() {
        this.c.put("0", "a");
        this.c.put("1", "b");
        this.c.put("2", "c");
        this.c.put("3", "d");
        this.c.put("4", "e");
        this.c.put("5", "f");
        this.c.put("6", y6b.f);
        this.c.put("7", y6b.g);
        this.c.put(PrepareException.ERROR_AUTH_FAIL, "i");
        this.c.put("9", "j");
        this.c.put(Consts.DOT, "k");
    }

    public void c(String str, String str2, String str3, double d) {
        String str4 = str + str2;
        this.tt.put(str4, str3 + LoginConstants.UNDER_LINE + d);
    }

    private synchronized void c(int i, String str, double d) {
        String str2 = "label_size_" + str;
        int i2 = this.tt.getInt(str2, 0) + 1;
        String strC = c(str, i2);
        String strC2 = c(str, d);
        c(strC, i, strC2);
        this.tt.put(strC, strC2);
        this.tt.put(str2, i2);
    }

    private String c(int i, String str) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return "0";
        }
        double[] dArr = new double[2];
        Iterator<Map.Entry<String, String>> it = c().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next != null) {
                String value = next.getValue();
                if (!TextUtils.isEmpty(value) && value.contains(str)) {
                    String[] strArrSplit = value.split(LoginConstants.UNDER_LINE);
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    String str4 = strArrSplit[2];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (com.byazt.bp.tt.tt().c(System.currentTimeMillis() - Long.parseLong(str4))) {
                            dArr[0] = dArr[0] + 1.0d;
                            dArr[1] = dArr[1] + Double.parseDouble(str3);
                        } else {
                            it.remove();
                            this.tt.remove(next.getKey());
                            String str5 = "label_size_" + str;
                            int i2 = this.tt.getInt(str5, 0);
                            if (i2 > 0) {
                                this.tt.put(str5, i2 - 1);
                            }
                        }
                    }
                }
            }
        }
        return c(dArr);
    }

    public void c(String str) {
        for (int i = this.tt.getInt("label_size_" + str, 0); i > 0; i--) {
            try {
                String strC = c(str, i);
                this.tt.remove(strC);
                c().remove(strC);
            } catch (Throwable th) {
                com.byazt.eu.tt.uj("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String c(String str, int i) {
        return "cpm_key_" + str + LoginConstants.UNDER_LINE + i;
    }

    private String c(String str, double d) {
        return str + LoginConstants.UNDER_LINE + d + LoginConstants.UNDER_LINE + System.currentTimeMillis();
    }

    public String c(double[] dArr) {
        double d = dArr[0];
        return d != AudioStats.AUDIO_AMPLITUDE_NONE ? new BigDecimal(dArr[1] / d).setScale(2, RoundingMode.HALF_UP).toString() : "-1.0";
    }

    public void c(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.byazt.bp.tt.tt().kk() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (tt(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get(HiAnalyticsConstant.BI_KEY_COST_TIME) == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get(HiAnalyticsConstant.BI_KEY_COST_TIME));
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }
}
