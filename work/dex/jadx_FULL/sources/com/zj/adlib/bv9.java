package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.y.l;
import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40847a = "WebvttCssParser";
    public static final String b = "{";
    public static final String c = "}";
    public static final String d = "color";
    public static final String e = "background-color";
    public static final String f = "font-family";
    public static final String g = "font-weight";
    public static final String h = "font-size";
    public static final String i = "ruby-position";
    public static final String j = "over";
    public static final String k = "under";
    public static final String l = "text-combine-upright";
    public static final String m = "all";
    public static final String n = "digits";
    public static final String o = "text-decoration";
    public static final String p = "bold";
    public static final String q = "underline";
    public static final String r = "font-style";
    public static final String s = "italic";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15646a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuilder f15647a = new StringBuilder();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f15644a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f15645b = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    public static boolean b(om6 om6Var) {
        int iE = om6Var.e();
        int iF = om6Var.f();
        byte[] bArrD = om6Var.d();
        if (iE + 2 > iF) {
            return false;
        }
        int i2 = iE + 1;
        if (bArrD[iE] != 47) {
            return false;
        }
        int i3 = i2 + 1;
        if (bArrD[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= iF) {
                om6Var.T(iF - om6Var.e());
                return true;
            }
            if (((char) bArrD[i3]) == '*' && ((char) bArrD[i4]) == '/') {
                i3 = i4 + 1;
                iF = i3;
            } else {
                i3 = i4;
            }
        }
    }

    public static boolean c(om6 om6Var) {
        char cK = k(om6Var, om6Var.e());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        om6Var.T(1);
        return true;
    }

    public static void e(String str, WebvttCssStyle webvttCssStyle) {
        Matcher matcher = f15645b.matcher(a.g(str));
        if (!matcher.matches()) {
            Log.n(f40847a, "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) sb0.g(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                webvttCssStyle.t(3);
                break;
            case "em":
                webvttCssStyle.t(2);
                break;
            case "px":
                webvttCssStyle.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        webvttCssStyle.s(Float.parseFloat((String) sb0.g(matcher.group(1))));
    }

    public static String f(om6 om6Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iE = om6Var.e();
        int iF = om6Var.f();
        while (iE < iF && !z) {
            char c2 = (char) om6Var.d()[iE];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                iE++;
                sb.append(c2);
            }
        }
        om6Var.T(iE - om6Var.e());
        return sb.toString();
    }

    @Nullable
    public static String g(om6 om6Var, StringBuilder sb) {
        n(om6Var);
        if (om6Var.a() == 0) {
            return null;
        }
        String strF = f(om6Var, sb);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) om6Var.G());
    }

    @Nullable
    public static String h(om6 om6Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iE = om6Var.e();
            String strG = g(om6Var, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || l.b.equals(strG)) {
                om6Var.S(iE);
                z = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    @Nullable
    public static String i(om6 om6Var, StringBuilder sb) {
        n(om6Var);
        if (om6Var.a() < 5 || !"::cue".equals(om6Var.D(5))) {
            return null;
        }
        int iE = om6Var.e();
        String strG = g(om6Var, sb);
        if (strG == null) {
            return null;
        }
        if (b.equals(strG)) {
            om6Var.S(iE);
            return "";
        }
        String strL = "(".equals(strG) ? l(om6Var) : null;
        if (")".equals(g(om6Var, sb))) {
            return strL;
        }
        return null;
    }

    public static void j(om6 om6Var, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        n(om6Var);
        String strF = f(om6Var, sb);
        if (!"".equals(strF) && u15.f19942b.equals(g(om6Var, sb))) {
            n(om6Var);
            String strH = h(om6Var, sb);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iE = om6Var.e();
            String strG = g(om6Var, sb);
            if (!l.b.equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    om6Var.S(iE);
                }
            }
            if ("color".equals(strF)) {
                webvttCssStyle.q(un1.b(strH));
                return;
            }
            if (e.equals(strF)) {
                webvttCssStyle.n(un1.b(strH));
                return;
            }
            boolean z = true;
            if (i.equals(strF)) {
                if (j.equals(strH)) {
                    webvttCssStyle.w(1);
                    return;
                } else {
                    if (k.equals(strH)) {
                        webvttCssStyle.w(2);
                        return;
                    }
                    return;
                }
            }
            if (l.equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith(n)) {
                    z = false;
                }
                webvttCssStyle.p(z);
                return;
            }
            if (o.equals(strF)) {
                if ("underline".equals(strH)) {
                    webvttCssStyle.B(true);
                    return;
                }
                return;
            }
            if (f.equals(strF)) {
                webvttCssStyle.r(strH);
                return;
            }
            if (g.equals(strF)) {
                if ("bold".equals(strH)) {
                    webvttCssStyle.o(true);
                }
            } else if (r.equals(strF)) {
                if ("italic".equals(strH)) {
                    webvttCssStyle.u(true);
                }
            } else if (h.equals(strF)) {
                e(strH, webvttCssStyle);
            }
        }
    }

    public static char k(om6 om6Var, int i2) {
        return (char) om6Var.d()[i2];
    }

    public static String l(om6 om6Var) {
        int iE = om6Var.e();
        int iF = om6Var.f();
        boolean z = false;
        while (iE < iF && !z) {
            int i2 = iE + 1;
            z = ((char) om6Var.d()[iE]) == ')';
            iE = i2;
        }
        return om6Var.D((iE - 1) - om6Var.e()).trim();
    }

    public static void m(om6 om6Var) {
        while (!TextUtils.isEmpty(om6Var.q())) {
        }
    }

    public static void n(om6 om6Var) {
        while (true) {
            for (boolean z = true; om6Var.a() > 0 && z; z = false) {
                if (!c(om6Var) && !b(om6Var)) {
                }
            }
            return;
        }
    }

    public final void a(WebvttCssStyle webvttCssStyle, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f15644a.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                webvttCssStyle.A((String) sb0.g(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrU1 = gj9.u1(str, "\\.");
        String str2 = strArrU1[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            webvttCssStyle.z(str2.substring(0, iIndexOf2));
            webvttCssStyle.y(str2.substring(iIndexOf2 + 1));
        } else {
            webvttCssStyle.z(str2);
        }
        if (strArrU1.length > 1) {
            webvttCssStyle.x((String[]) gj9.f1(strArrU1, 1, strArrU1.length));
        }
    }

    public List<WebvttCssStyle> d(om6 om6Var) {
        this.f15647a.setLength(0);
        int iE = om6Var.e();
        m(om6Var);
        this.f15646a.Q(om6Var.d(), om6Var.e());
        this.f15646a.S(iE);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f15646a, this.f15647a);
            if (strI == null || !b.equals(g(this.f15646a, this.f15647a))) {
                return arrayList;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            a(webvttCssStyle, strI);
            String str = null;
            boolean z = false;
            while (!z) {
                int iE2 = this.f15646a.e();
                String strG = g(this.f15646a, this.f15647a);
                boolean z2 = strG == null || "}".equals(strG);
                if (!z2) {
                    this.f15646a.S(iE2);
                    j(this.f15646a, webvttCssStyle, this.f15647a);
                }
                str = strG;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }
}
