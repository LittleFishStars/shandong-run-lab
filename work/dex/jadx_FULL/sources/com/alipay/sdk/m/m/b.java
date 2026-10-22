package com.alipay.sdk.m.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.y.d;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";
    public static final String J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";
    public static final String a0 = "ErrActNull";
    public static final String b0 = "ErrActEx";
    public static final String c0 = "ErrActNull2";
    public static final String d0 = "ErrActEx2";
    public static final String e0 = "ErrActNotCreated";
    public static final String f0 = "GetInstalledAppEx";
    public static final String g0 = "StartLaunchAppTransEx";
    public static final String h0 = "CheckLaunchAppExistEx";
    public static final String i0 = "LogBindCalledH5";
    public static final String j0 = "LogCalledH5";
    public static final String k = "net";
    public static final String k0 = "LogHkLoginByIntent";
    public static final String l = "biz";
    public static final String l0 = "SchemePayWrongHashEx";
    public static final String m = "cp";
    public static final String m0 = "LogAppFetchConfigTimeout";
    public static final String n = "auth";
    public static final String n0 = "H5CbUrlEmpty";
    public static final String o = "third";
    public static final String o0 = "H5CbEx";
    public static final String p = "wlt";
    public static final String p0 = "StartActivityEx";
    public static final String q = "FormatResultEx";
    public static final String q0 = "JSONEx";
    public static final String r = "GetApdidEx";
    public static final String r0 = "ParseBundleSerializableError";
    public static final String s = "GetApdidNull";
    public static final String s0 = "ParseSchemeQueryError";
    public static final String t = "GetApdidTimeout";
    public static final String t0 = "TbChk";
    public static final String u = "GetUtdidEx";
    public static final String u0 = "TbStart";
    public static final String v = "GetPackageInfoEx";
    public static final String v0 = "TbCancel";
    public static final String w = "NotIncludeSignatures";
    public static final String w0 = "TbUnknown";
    public static final String x = "GetPublicKeyFromSignEx";
    public static final String x0 = "TbOk";
    public static final String y = "webError";
    public static final String y0 = "TbActFail";
    public static final String z = "SSLError";
    public static final String z0 = "partner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25466a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h = "";
    public String i = "";
    public String j;

    public b(Context context, boolean z2) {
        context = context != null ? context.getApplicationContext() : context;
        this.f25466a = b();
        this.c = a(context);
        this.d = a(z2 ? 0L : a.f.a(context));
        this.e = a();
        this.f = b(context);
        this.g = c49.f40900a;
        this.j = c49.f40900a;
    }

    public static String e() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public void a(String str, String str2, Throwable th) {
        d(str, str2, a(th));
    }

    public final synchronized void b(String str, String str2, String str3) {
        if (com.alipay.sdk.m.o.b.i().h(null)) {
            g.d(com.alipay.sdk.m.n.a.B, "event " + str + " " + str2 + " " + str3);
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.h)) {
                sb.append("^");
            }
            sb.append(TextUtils.isEmpty(str) ? c49.f40900a : b(str));
            sb.append(",");
            sb.append(b(str2));
            sb.append(",");
            sb.append(b(str3));
            sb.append(",-,-,-,-,-,-,-,-,-,-,");
            sb.append(c());
            this.h += ((Object) sb);
        } else {
            g.d(com.alipay.sdk.m.n.a.B, String.format("event %s %s %s", str, str2, str3));
            String str4 = "";
            if (!TextUtils.isEmpty(this.h)) {
                str4 = "^";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            Object[] objArr = new Object[4];
            objArr[0] = TextUtils.isEmpty(str) ? c49.f40900a : b(str);
            objArr[1] = b(str2);
            objArr[2] = b(str3);
            objArr[3] = b(c());
            sb2.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
            this.h += sb2.toString();
        }
    }

    public void c(String str, String str2, String str3) {
        d(str, str2, str3);
    }

    public final boolean d() {
        return TextUtils.isEmpty(this.i);
    }

    public static String c() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    public final synchronized void d(String str, String str2, String str3) {
        g.c(com.alipay.sdk.m.n.a.B, String.format("err %s %s %s", str, str2, str3));
        String str4 = "";
        if (!TextUtils.isEmpty(this.i)) {
            str4 = "^";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? c49.f40900a : b(str3);
        objArr[3] = b(c());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.i += sb.toString();
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? c49.f40900a : str;
    }

    public void a(String str, String str2, Throwable th, String str3) {
        d(str, str2, str3 + ": " + a(th));
    }

    public void a(String str, String str2, String str3) {
        b("", str, str2 + "|" + str3);
    }

    public void a(String str, String str2) {
        b("", str, str2);
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(u15.f19942b);
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i++;
                    if (i > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public String d(String str) {
        String strA = a(str);
        this.b = strA;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f25466a, strA, this.c, this.d, this.e, this.f, this.g, c(this.h), c(this.i), this.j);
    }

    public static String a(String str) {
        String string;
        String strReplace;
        if (str == null) {
            str = "";
        }
        String[] strArrSplit = str.split("&");
        String strReplace2 = null;
        if (strArrSplit != null) {
            string = null;
            strReplace = null;
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2 != null && strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equalsIgnoreCase(z0)) {
                        strReplace2 = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(A0)) {
                        string = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(B0)) {
                        strReplace = strArrSplit2[1].replace("\"", "");
                    } else if (strArrSplit2[0].equalsIgnoreCase(C0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(q.e(com.alipay.sdk.m.w.a.f(), strArrSplit2[1]));
                            if (TextUtils.isEmpty(string)) {
                                string = jSONObject.getString(A0);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (strArrSplit2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(strReplace2)) {
                        strReplace2 = strArrSplit2[1];
                    }
                }
            }
        } else {
            string = null;
            strReplace = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", b(strReplace), b(string), b(strReplace2));
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return e() + "," + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
    }

    public static String b(Context context) {
        return b(d.c(context)) + ",android," + b(Build.VERSION.RELEASE) + "," + b(Build.MODEL) + "," + c49.f40900a + ",0," + b(d.d(context).c()) + ",gw," + b(com.alipay.sdk.m.a0.b.b(null, context)) + ",-";
    }

    public static String a(Context context) {
        String packageName;
        String str;
        String str2 = c49.f40900a;
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str2 = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable th) {
                    th = th;
                    g.a(th);
                }
            } catch (Throwable th2) {
                th = th2;
                packageName = c49.f40900a;
            }
            str = str2;
            str2 = packageName;
        } else {
            str = c49.f40900a;
        }
        return b(str2) + "," + b(str) + ",-,-,-";
    }

    public static String a(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String strSubstring;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    String strA = q.a((com.alipay.sdk.m.w.a) null, signature.toByteArray());
                    strSubstring = TextUtils.isEmpty(strA) ? "?" : q.g(strA).substring(0, 8);
                } catch (Throwable unused) {
                }
                sb.append(c49.f40900a);
                sb.append(strSubstring);
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String a(long j) {
        return "android,3," + b("15.8.42") + "," + b("h.a.3.8.42") + ",com.alipay.mcpay,5.0,-,~" + j + ",-";
    }

    public static String a() {
        return b(com.alipay.sdk.m.x.a.a(com.alipay.sdk.m.w.b.c().b()).f()) + "," + b(com.alipay.sdk.m.w.b.c().d()) + ",-,-,-";
    }
}
