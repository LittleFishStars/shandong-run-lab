package com.byazt.du;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.byazt.nr.m;
import com.byazt.xl.u;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 158})
public class sl {
    public static final Set<String> c = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.byazt.dyf.tt.AD_TAG_DISLIKE, "close", "close-fill", "webview-close")));
    public static String tt;

    /* JADX WARN: Code duplicated, block: B:216:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:219:0x0402 A[Catch: Exception -> 0x0413, TryCatch #5 {Exception -> 0x0413, blocks: (B:217:0x03f8, B:219:0x0402, B:224:0x040c), top: B:267:0x03f8 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x0408 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:223:0x040b  */
    public static tt.ve c(String str, String str2, String str3, boolean z, boolean z2, int i, com.byazt.aq.x xVar, double d, int i2, double d2, String str4, u uVar) {
        int i3;
        int i4;
        float f;
        float f2;
        tt.ve veVarC;
        int i5;
        com.byazt.aq.a aVarN;
        String strOptString = str;
        int i6 = i;
        String strA = uVar.a();
        if (com.byazt.sr.uj.c() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new tt.ve(0.0f, 0.0f);
        }
        tt.ve veVar = new tt.ve();
        if (strOptString.startsWith("<svg") || c.contains(str2)) {
            try {
                if ("close".equals(str2) || (com.byazt.sr.uj.c() && "close-fill".equals(str2))) {
                    float fOptDouble = (float) new JSONObject(str3).optDouble("fontSize");
                    veVar.c = fOptDouble;
                    veVar.tt = fOptDouble;
                    return veVar;
                }
            } catch (Exception unused) {
            }
            veVar.c = 10.0f;
            veVar.tt = 10.0f;
            return veVar;
        }
        if ("logo".equals(str2)) {
            if (!com.byazt.sr.uj.c() && ((!TextUtils.isEmpty(str) && strOptString.contains("adx:")) || tt())) {
                return tt() ? c(veVar, strOptString, str3, tt) : c(veVar, strOptString, str3, "");
            }
            veVar.c = "union".equals(strOptString) ? 10.0f : 20.0f;
            veVar.tt = 10.0f;
            if (com.byazt.sr.uj.c()) {
                String str5 = str2 + strOptString;
                float fTt = (float) tt(str3);
                if (str5.contains("logoad")) {
                    return c("AD", str3);
                }
                veVar.tt = fTt;
            }
            return veVar;
        }
        if ("development-name".equals(str2)) {
            strOptString = "开发者：".concat(strOptString);
        }
        if ("app-version".equals(str2)) {
            strOptString = "版本号：V".concat(String.valueOf(strOptString));
        }
        if ("score-count".equals(str2)) {
            try {
                i3 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
            if (com.byazt.sr.uj.c() && i3 < 0) {
                return new tt.ve(0.0f, 0.0f);
            }
            return c("(" + String.format("%1$s个评分", Integer.valueOf(i3)) + ")", str3);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i4 = Integer.parseInt(strOptString);
            } catch (NumberFormatException unused3) {
                i4 = 0;
            }
            if (com.byazt.sr.uj.c() && i4 < 0) {
                return new tt.ve(0.0f, 0.0f);
            }
            return c("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3);
        }
        if ("feedback-dislike".equals(str2)) {
            if (!com.byazt.sr.uj.c()) {
                return c("反馈", str3);
            }
            tt.ve veVar2 = new tt.ve();
            float fTt2 = (float) tt(str3);
            veVar2.c = fTt2;
            veVar2.tt = fTt2;
            return veVar2;
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (uVar.ve() && com.byazt.or.sp.tt(strA)) {
                return c("0s", str3);
            }
            return d < 10.0d ? c("0S", str3) : c("00S", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return c("| 跳过", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return c("| ".concat(String.valueOf(String.format("%1$ss后可跳过", "00"))), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            tt.ve veVarC2 = c("| 跳过", str3);
            if (com.byazt.sr.uj.c()) {
                try {
                    veVarC2.tt = (float) ((((double) veVarC2.tt) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                veVarC2.c = veVarC2.tt;
            }
            return veVarC2;
        }
        if (FreeSpaceBox.TYPE.equals(str2)) {
            return c("跳过", str3);
        }
        if ("timedown".equals(str2)) {
            return c("0.0", str3);
        }
        if ("text_star".equals(str2)) {
            return (!com.byazt.sr.uj.c() || (d2 >= AudioStats.AUDIO_AMPLITUDE_NONE && d2 <= 5.0d)) ? c("0.0", str3) : new tt.ve(0.0f, 0.0f);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return c("功能 | 权限 | 隐私", str3);
        }
        if ("arrowButton".equals(str2)) {
            return c("Download", str3);
        }
        if ("text".equals(str2) && com.byazt.sr.uj.c() && TextUtils.isEmpty(strOptString) && (aVarN = xVar.da().n()) != null) {
            strOptString = aVarN.r() != null ? xVar.da().n().r().optString(com.byazt.or.x.uj(com.byazt.sr.uj.getContext())) : "";
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || (("source".equals(str2) && !(com.byazt.sr.uj.c() && "open_ad".equals(strA))) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2))) {
            return c(strOptString, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = strOptString.length();
            float fOptDouble2 = (float) jSONObject.optDouble("fontSize");
            float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
            float f3 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            m.uj("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f3);
            if ("muted".equals(str2)) {
                veVar.c = fOptDouble2;
                veVar.tt = fOptDouble2;
                return veVar;
            }
            if ("star".equals(str2)) {
                if (com.byazt.sr.uj.c() && (d2 < AudioStats.AUDIO_AMPLITUDE_NONE || d2 > 5.0d || i2 != 4)) {
                    return new tt.ve(0.0f, 0.0f);
                }
                tt.ve veVarC3 = c("str", str3);
                veVarC3.c = fOptDouble2 * 5.0f;
                return veVarC3;
            }
            if (RemoteMessageConst.Notification.ICON.equals(str2)) {
                veVar.c = fOptDouble2;
                veVar.tt = fOptDouble2;
                return veVar;
            }
            if (!z) {
                f = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f3 <= fOptDouble5) {
                    f2 = f3;
                }
                if ("title".equals(str2) || (com.byazt.sr.uj.c() && "open_ad".equals(strA) && "source".equals(str2))) {
                    try {
                        veVarC = c(strOptString.replace('\n', ' '), str3, false);
                        if (z) {
                            i5 = ((int) (f3 / fOptDouble5)) + 1;
                            if (z2 || i5 < i6) {
                                i6 = i5;
                            }
                            veVarC.tt *= i6;
                        }
                        return veVarC;
                    } catch (Exception unused5) {
                    }
                }
                veVar.c = f2;
                veVar.tt = f;
                return veVar;
            }
            int i7 = ((int) (f3 / fOptDouble5)) + 1;
            if (z2 && i7 >= i6) {
                i7 = i6;
            }
            f = (float) (((double) (fOptDouble4 * fOptDouble2 * i7)) * 1.2d);
            f2 = fOptDouble5;
            if ("title".equals(str2)) {
                veVarC = c(strOptString.replace('\n', ' '), str3, false);
                if (z) {
                    i5 = ((int) (f3 / fOptDouble5)) + 1;
                    if (z2) {
                        i6 = i5;
                    } else {
                        i6 = i5;
                    }
                    veVarC.tt *= i6;
                }
                return veVarC;
            }
            veVarC = c(strOptString.replace('\n', ' '), str3, false);
            if (z) {
                i5 = ((int) (f3 / fOptDouble5)) + 1;
                if (z2) {
                    i6 = i5;
                } else {
                    i6 = i5;
                }
                veVarC.tt *= i6;
            }
            return veVarC;
            return veVar;
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static double tt(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static int[] tt(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.byazt.sr.uj.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean tt() {
        return !TextUtils.isEmpty(tt);
    }

    public static String c(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static tt.ve c(tt.ve veVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            veVar.c = 0.0f;
            veVar.tt = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = c(str);
            }
            if (TextUtils.isEmpty(str3)) {
                veVar.c = 0.0f;
                veVar.tt = 0.0f;
            } else {
                return c(str3, str2);
            }
        }
        return veVar;
    }

    public static tt.ve c(String str, String str2) {
        return c(str, str2, false);
    }

    public static tt.ve c(String str, String str2, boolean z) {
        tt.ve veVar = new tt.ve();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrC = c(str, (float) tt(str2), z);
            veVar.c = iArrC[0];
            veVar.tt = iArrC[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == AudioStats.AUDIO_AMPLITUDE_NONE) {
                veVar.tt = 0.0f;
            }
        } catch (Exception e) {
            m.c(e);
        }
        return veVar;
    }

    public static int[] c(String str, float f, boolean z) {
        int[] iArrTt = tt(str, f, z);
        return new int[]{com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), iArrTt[0]), com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), iArrTt[1])};
    }

    public static String c() {
        return tt;
    }
}
