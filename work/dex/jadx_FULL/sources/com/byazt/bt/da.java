package com.byazt.bt;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.alipay.sdk.m.y.l;
import com.byazt.dna.qp;
import com.byazt.el.SSWebView;
import com.zj.adlib.c49;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 72})
public class da {
    public static volatile String c = "";
    public static final AtomicBoolean tt = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.bt.da$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 274, 494})
    public static class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Context c;
        public final /* synthetic */ com.byazt.dna.c tt;
        public final /* synthetic */ int ve;

        public AnonymousClass2(Context context, com.byazt.dna.c cVar, int i) {
            this.c = context;
            this.tt = cVar;
            this.ve = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = da.c = da.ve(new SSWebView(this.c).getUserAgentString());
                x.c("sdk_local_web_ua", da.c, this.tt, this.ve);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(Context context, com.byazt.dna.c cVar, int i) {
        try {
            c = ve(WebSettings.getDefaultUserAgent(context));
            x.c("sdk_local_web_ua", c, cVar, i);
            tt.set(false);
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(l.b);
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            String strSubstring = strConcat.substring(0, i);
            strConcat = strSubstring.concat(" " + Locale.getDefault().getLanguage() + c49.f40900a + Locale.getDefault().getCountry() + l.b).concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static void tt(final Context context, final com.byazt.dna.c cVar, final int i) {
        ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("tt-webua") { // from class: com.byazt.bt.da.1
            @Override // java.lang.Runnable
            public void run() {
                da.ve(context, cVar, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String c(Context context, com.byazt.dna.c cVar, boolean z, boolean z2, int i) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        return c(z, context, cVar, z2, i);
    }

    private static String c(boolean z, Context context, com.byazt.dna.c cVar, boolean z2, int i) {
        String string;
        long j;
        try {
            String strTt = x.tt("sdk_local_web_ua", "", cVar);
            if (TextUtils.isEmpty(strTt)) {
                string = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strTt);
                string = jSONObject.getString("value");
                j = jSONObject.getLong("time");
                c = string;
            }
            if (!z && z2) {
                return c;
            }
            if (TextUtils.isEmpty(string)) {
                ve(context, cVar, i);
            } else if (System.currentTimeMillis() - j > 259200000 && tt.compareAndSet(false, true)) {
                tt(context, cVar, i);
            }
            return c;
        } catch (Throwable unused) {
        }
    }
}
