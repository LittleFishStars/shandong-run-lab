package com.zj.adlib;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;
import com.google.android.exoplayer2.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f41283a = '<';

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float f16121a = 0.5f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f16122a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16123a = "lt";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, Integer> f16124a;
    public static final char b = '>';

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int f16126b = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f16127b = "gt";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Map<String, Integer> f16128b;
    public static final char c = '/';

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int f16130c = 3;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f16131c = "amp";
    public static final char d = '&';

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int f16132d = 4;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f16133d = "nbsp";
    public static final char e = ';';

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int f16134e = 5;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f16135e = "b";
    public static final char f = ' ';

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int f16136f = 1;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String f16137f = "c";
    public static final int g = 2;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String f16138g = "i";
    public static final String h = "lang";
    public static final String i = "ruby";
    public static final String j = "rt";
    public static final String k = "u";
    public static final String l = "v";
    public static final String m = "WebvttCueParser";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f16125a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f16129b = Pattern.compile("(\\S+?):(\\S+)");

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Comparator<b> f41284a = new Comparator() { // from class: com.zj.adlib.ev9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return dv9.b.e((dv9.b) obj, (dv9.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f16139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f16140a;

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f16140a.f41285a, bVar2.f16140a.f41285a);
        }

        public b(c cVar, int i) {
            this.f16140a = cVar;
            this.f16139a = i;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41285a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f16141a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set<String> f16142a;
        public final String b;

        public c(String str, int i, String str2, Set<String> set) {
            this.f41285a = i;
            this.f16141a = str;
            this.b = str2;
            this.f16142a = set;
        }

        public static c a(String str, int i) {
            String str2;
            String strTrim = str.trim();
            sb0.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrU1 = gj9.u1(strTrim, "\\.");
            String str3 = strArrU1[0];
            HashSet hashSet = new HashSet();
            for (int i2 = 1; i2 < strArrU1.length; i2++) {
                hashSet.add(strArrU1[i2]);
            }
            return new c(str3, i, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    public static final class d implements Comparable<d> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebvttCssStyle f41286a;

        public d(int i, WebvttCssStyle webvttCssStyle) {
            this.K = i;
            this.f41286a = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.K, dVar.K);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CharSequence f16145a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f16144a = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f16147b = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f16143a = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f41287a = -3.4028235E38f;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f16146b = 1;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f16148c = 0;
        public float b = -3.4028235E38f;
        public int d = Integer.MIN_VALUE;
        public float c = 1.0f;
        public int e = Integer.MIN_VALUE;

        public static float b(float f, int i) {
            if (f != -3.4028235E38f && i == 0 && (f < 0.0f || f > 1.0f)) {
                return 1.0f;
            }
            if (f != -3.4028235E38f) {
                return f;
            }
            return i == 0 ? 1.0f : -3.4028235E38f;
        }

        @Nullable
        public static Layout.Alignment c(int i) {
            if (i != 1) {
                if (i == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            Log.n(dv9.m, "Unknown textAlignment: " + i);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i, float f) {
            if (i == 0) {
                return 1.0f - f;
            }
            if (i == 1) {
                return f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            }
            if (i == 2) {
                return f;
            }
            throw new IllegalStateException(String.valueOf(i));
        }

        public static float e(int i) {
            if (i != 4) {
                return i != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return i != 5 ? 1 : 2;
            }
            return 0;
        }

        public cv9 a() {
            return new cv9(g().a(), this.f16144a, this.f16147b);
        }

        public Cue.b g() {
            float fE = this.b;
            if (fE == -3.4028235E38f) {
                fE = e(this.f16143a);
            }
            int iF = this.d;
            if (iF == Integer.MIN_VALUE) {
                iF = f(this.f16143a);
            }
            Cue.b bVarD = new Cue.b().B(c(this.f16143a)).t(b(this.f41287a, this.f16146b), this.f16146b).u(this.f16148c).w(fE).x(iF).z(Math.min(this.c, d(iF, fE))).D(this.e);
            CharSequence charSequence = this.f16145a;
            if (charSequence != null) {
                bVarD.A(charSequence);
            }
            return bVarD;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f16124a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f16128b = Collections.unmodifiableMap(map2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i2, int i3) {
        for (String str : set) {
            Map<String, Integer> map = f16124a;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i2, i3, 33);
            } else {
                Map<String, Integer> map2 = f16128b;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str).intValue()), i2, i3, 33);
                }
            }
        }
    }

    public static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        switch (str) {
            case "gt":
                spannableStringBuilder.append(b);
                break;
            case "lt":
                spannableStringBuilder.append(f41283a);
                break;
            case "amp":
                spannableStringBuilder.append(d);
                break;
            case "nbsp":
                spannableStringBuilder.append(' ');
                break;
            default:
                Log.n(m, "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, @Nullable String str, c cVar, List<b> list, List<WebvttCssStyle> list2) {
        int i2 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f41284a);
        int i3 = cVar.f41285a;
        int length = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(((b) arrayList.get(i4)).f16140a.f16141a)) {
                b bVar = (b) arrayList.get(i4);
                int iG = g(i(list2, str, bVar.f16140a), i2, 1);
                int i5 = bVar.f16140a.f41285a - length;
                int i6 = bVar.f16139a - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new cl7(charSequenceSubSequence.toString(), iG), i3, i5, 33);
                length += charSequenceSubSequence.length();
                i3 = i5;
            }
        }
    }

    public static void d(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        int i2 = cVar.f41285a;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f16141a;
        str2.hashCode();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, cVar.f16142a, i2, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                break;
            case "ruby":
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List<d> listH = h(list2, str, cVar);
        for (int i3 = 0; i3 < listH.size(); i3++) {
            e(spannableStringBuilder, listH.get(i3).f41286a, i2, length);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i2, int i3) {
        if (webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.i() != -1) {
            wl8.a(spannableStringBuilder, new StyleSpan(webvttCssStyle.i()), i2, i3, 33);
        }
        if (webvttCssStyle.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (webvttCssStyle.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (webvttCssStyle.k()) {
            wl8.a(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.c()), i2, i3, 33);
        }
        if (webvttCssStyle.j()) {
            wl8.a(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.a()), i2, i3, 33);
        }
        if (webvttCssStyle.d() != null) {
            wl8.a(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.d()), i2, i3, 33);
        }
        int iF = webvttCssStyle.f();
        if (iF == 1) {
            wl8.a(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.e(), true), i2, i3, 33);
        } else if (iF == 2) {
            wl8.a(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e()), i2, i3, 33);
        } else if (iF == 3) {
            wl8.a(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e() / 100.0f), i2, i3, 33);
        }
        if (webvttCssStyle.b()) {
            spannableStringBuilder.setSpan(new y14(), i2, i3, 33);
        }
    }

    public static int f(String str, int i2) {
        int iIndexOf = str.indexOf(62, i2);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    public static int g(int i2, int i3, int i4) {
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        if (i4 != -1) {
            return i4;
        }
        throw new IllegalArgumentException();
    }

    public static List<d> h(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCssStyle webvttCssStyle = list.get(i2);
            int iH = webvttCssStyle.h(str, cVar.f16141a, cVar.f16142a, cVar.b);
            if (iH > 0) {
                arrayList.add(new d(iH, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List<WebvttCssStyle> list, @Nullable String str, c cVar) {
        List<d> listH = h(list, str, cVar);
        for (int i2 = 0; i2 < listH.size(); i2++) {
            WebvttCssStyle webvttCssStyle = listH.get(i2).f41286a;
            if (webvttCssStyle.g() != -1) {
                return webvttCssStyle.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String strTrim = str.trim();
        sb0.a(!strTrim.isEmpty());
        return gj9.v1(strTrim, "[ \\.]")[0];
    }

    public static boolean k(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static Cue l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f16145a = charSequence;
        return eVar.g().a();
    }

    @Nullable
    public static cv9 m(om6 om6Var, List<WebvttCssStyle> list) {
        String strQ = om6Var.q();
        if (strQ == null) {
            return null;
        }
        Pattern pattern = f16125a;
        Matcher matcher = pattern.matcher(strQ);
        if (matcher.matches()) {
            return n(null, matcher, om6Var, list);
        }
        String strQ2 = om6Var.q();
        if (strQ2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strQ2);
        if (matcher2.matches()) {
            return n(strQ.trim(), matcher2, om6Var, list);
        }
        return null;
    }

    @Nullable
    public static cv9 n(@Nullable String str, Matcher matcher, om6 om6Var, List<WebvttCssStyle> list) {
        e eVar = new e();
        try {
            eVar.f16144a = hv9.d((String) sb0.g(matcher.group(1)));
            eVar.f16147b = hv9.d((String) sb0.g(matcher.group(2)));
            p((String) sb0.g(matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            String strQ = om6Var.q();
            while (!TextUtils.isEmpty(strQ)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strQ.trim());
                strQ = om6Var.q();
            }
            eVar.f16145a = q(str, sb.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            Log.n(m, "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    public static Cue.b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    public static void p(String str, e eVar) {
        Matcher matcher = f16129b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) sb0.g(matcher.group(1));
            String str3 = (String) sb0.g(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f16143a = v(str3);
                } else if ("position".equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.c = hv9.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.e = w(str3);
                } else {
                    Log.n(m, "Unknown cue setting " + str2 + u15.f19942b + str3);
                }
            } catch (NumberFormatException unused) {
                Log.n(m, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString q(@Nullable String str, String str2, List<WebvttCssStyle> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char cCharAt = str2.charAt(i2);
            if (cCharAt == '&') {
                i2++;
                int iIndexOf = str2.indexOf(59, i2);
                int iIndexOf2 = str2.indexOf(32, i2);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    b(str2.substring(i2, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i2 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i2++;
            } else {
                int iF = i2 + 1;
                if (iF < str2.length()) {
                    boolean z = str2.charAt(iF) == '/';
                    iF = f(str2, iF);
                    int i3 = iF - 2;
                    boolean z2 = str2.charAt(i3) == '/';
                    int i4 = i2 + (z ? 2 : 1);
                    if (!z2) {
                        i3 = iF - 1;
                    }
                    String strSubstring = str2.substring(i4, i3);
                    if (!strSubstring.trim().isEmpty()) {
                        String strJ = j(strSubstring);
                        if (k(strJ)) {
                            if (z) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f16141a.equals(strJ)) {
                                        break;
                                    }
                                }
                            } else if (!z2) {
                                arrayDeque.push(c.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i2 = iF;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static int r(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                Log.n(m, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f16148c = r(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.f41287a = hv9.c(str);
            eVar.f16146b = 0;
        } else {
            eVar.f41287a = Integer.parseInt(str);
            eVar.f16146b = 1;
        }
    }

    public static int t(String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                Log.n(m, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.d = t(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        eVar.b = hv9.c(str);
    }

    public static int v(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                Log.n(m, "Invalid alignment value: " + str);
                return 2;
        }
    }

    public static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        Log.n(m, "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
