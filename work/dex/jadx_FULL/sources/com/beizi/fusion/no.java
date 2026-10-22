package com.beizi.fusion;

import android.graphics.Color;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import androidx.camera.video.AudioStats;
import com.alibaba.android.arouter.utils.Consts;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class no {

    public static abstract class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27568a;
        private final String b;

        public a(String str, String str2) {
            this.f27568a = str;
            this.b = str2;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor(this.b));
            textPaint.setUnderlineText(false);
        }
    }

    public static double a(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
            }
        }
        return d;
    }

    public static String b(String str) {
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
        } catch (MalformedURLException unused) {
            if (!str.contains("?")) {
                return str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
            }
            String strSubstring = str.substring(0, str.indexOf("?"));
            return strSubstring.substring(strSubstring.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
        }
    }

    public static String c(String str) {
        String strB = b(str);
        return strB.contains(Consts.DOT) ? strB.substring(strB.lastIndexOf(Consts.DOT) + 1) : strB;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return rl.a(str, "#[a-fA-F\\d]{6}") || rl.a(str, "#[a-fA-F\\d]{8}");
    }

    public static boolean e(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str) && str.contains("%");
    }

    public static double g(String str) {
        if (TextUtils.isEmpty(str)) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static float h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    public static int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long j(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static float k(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("%")) {
            return 0.0f;
        }
        return h(str.substring(0, str.indexOf("%")).trim()) / 100.0f;
    }

    public static String a(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static String a(long j) {
        return a(j, "yyyy-MM-dd HH:MM:SS");
    }

    public static String a(List list, String str) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(((fd) it.next()).toJsonString());
            sb.append(",");
        }
        if (sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, ']');
        } else {
            sb.append("]");
        }
        return sb.toString();
    }

    public static Set a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(((fd) it.next()).toJsonString());
        }
        return hashSet;
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                sb.append(cCharAt);
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static SpannableString a(String str, a... aVarArr) {
        SpannableString spannableString = new SpannableString(str);
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                int iIndexOf = str.indexOf(aVar.f27568a);
                spannableString.setSpan(aVar, iIndexOf, aVar.f27568a.length() + iIndexOf, 33);
            }
        }
        return spannableString;
    }

    public static String a(String str, boolean z) {
        return (z && str.startsWith("http://")) ? str.replace("http://", "https://") : str;
    }
}
