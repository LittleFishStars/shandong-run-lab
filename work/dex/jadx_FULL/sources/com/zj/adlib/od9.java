package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class od9 {
    public static final String A = "fontSize";
    public static final String B = "fontFamily";
    public static final String C = "fontWeight";
    public static final String D = "color";
    public static final String E = "ruby";
    public static final String F = "rubyPosition";
    public static final String G = "textDecoration";
    public static final String H = "textAlign";
    public static final String I = "textCombine";
    public static final String J = "textEmphasis";
    public static final String K = "writingMode";
    public static final String L = "shear";
    public static final String M = "multiRowAlign";
    public static final String N = "container";
    public static final String O = "base";
    public static final String P = "baseContainer";
    public static final String Q = "text";
    public static final String R = "textContainer";
    public static final String S = "delimiter";
    public static final String T = "before";
    public static final String U = "after";
    public static final String V = "outside";
    public static final String W = "linethrough";
    public static final String X = "nolinethrough";
    public static final String Y = "underline";
    public static final String Z = "nounderline";
    public static final String a0 = "italic";
    public static final String b0 = "bold";
    public static final String c0 = "left";
    public static final String d0 = "center";
    public static final String e = "tt";
    public static final String e0 = "right";
    public static final String f = "head";
    public static final String f0 = "start";
    public static final String g = "body";
    public static final String g0 = "end";
    public static final String h = "div";
    public static final String h0 = "none";
    public static final String i = "p";
    public static final String i0 = "all";
    public static final String j = "span";
    public static final String j0 = "tb";
    public static final String k = "br";
    public static final String k0 = "tblr";
    public static final String l = "style";
    public static final String l0 = "tbrl";
    public static final String m = "styling";
    public static final String m0 = "none";
    public static final String n = "layout";
    public static final String n0 = "auto";
    public static final String o = "region";
    public static final String o0 = "dot";
    public static final String p = "metadata";
    public static final String p0 = "sesame";
    public static final String q = "image";
    public static final String q0 = "circle";
    public static final String r = "data";
    public static final String r0 = "filled";
    public static final String s = "information";
    public static final String s0 = "open";
    public static final String t = "";
    public static final String u = "id";
    public static final String v = "origin";
    public static final String w = "extent";
    public static final String x = "displayAlign";
    public static final String y = "backgroundColor";
    public static final String z = "fontStyle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TtmlStyle f18613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final od9 f18614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f18615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, Integer> f18616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<od9> f18617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f18618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String[] f18619a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final String f18620b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final HashMap<String, Integer> f18621b;
    public final String c;

    @Nullable
    public final String d;

    public od9(@Nullable String str, @Nullable String str2, long j2, long j3, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable od9 od9Var) {
        this.f18615a = str;
        this.f18620b = str2;
        this.d = str4;
        this.f18613a = ttmlStyle;
        this.f18619a = strArr;
        this.f18618a = str2 != null;
        this.f43726a = j2;
        this.b = j3;
        this.c = (String) sb0.g(str3);
        this.f18614a = od9Var;
        this.f18616a = new HashMap<>();
        this.f18621b = new HashMap<>();
    }

    public static od9 c(@Nullable String str, long j2, long j3, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable od9 od9Var) {
        return new od9(str, null, j2, j3, ttmlStyle, strArr, str2, str3, od9Var);
    }

    public static od9 d(String str) {
        return new od9(null, qd9.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (mk2 mk2Var : (mk2[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), mk2.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(mk2Var), spannableStringBuilder.getSpanEnd(mk2Var), "");
        }
        for (int i2 = 0; i2 < spannableStringBuilder.length(); i2++) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                int i3 = i2 + 1;
                int i4 = i3;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                int i5 = i4 - i3;
                if (i5 > 0) {
                    spannableStringBuilder.delete(i2, i5 + i2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == '\n') {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ') {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder k(String str, Map<String, Cue.b> map) {
        if (!map.containsKey(str)) {
            Cue.b bVar = new Cue.b();
            bVar.A(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) sb0.g(map.get(str).k());
    }

    public void a(od9 od9Var) {
        if (this.f18617a == null) {
            this.f18617a = new ArrayList();
        }
        this.f18617a.add(od9Var);
    }

    public final void b(Map<String, TtmlStyle> map, Cue.b bVar, int i2, int i3, int i4) {
        TtmlStyle ttmlStyleF = qd9.f(this.f18613a, this.f18619a, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.k();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.A(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (ttmlStyleF != null) {
            qd9.a(spannableStringBuilder2, i2, i3, ttmlStyleF, this.f18614a, map, i4);
            if ("p".equals(this.f18615a)) {
                if (ttmlStyleF.k() != Float.MAX_VALUE) {
                    bVar.y((ttmlStyleF.k() * (-90.0f)) / 100.0f);
                }
                if (ttmlStyleF.m() != null) {
                    bVar.B(ttmlStyleF.m());
                }
                if (ttmlStyleF.h() != null) {
                    bVar.v(ttmlStyleF.h());
                }
            }
        }
    }

    public od9 f(int i2) {
        List<od9> list = this.f18617a;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<od9> list = this.f18617a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> h(long j2, Map<String, TtmlStyle> map, Map<String, pd9> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j2, this.c, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j2, false, this.c, treeMap);
        o(j2, map, map2, this.c, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                pd9 pd9Var = (pd9) sb0.g(map2.get(pair.first));
                arrayList2.add(new Cue.b().r(bitmapDecodeByteArray).w(pd9Var.f43957a).x(0).t(pd9Var.b, 0).u(pd9Var.f18822b).z(pd9Var.c).s(pd9Var.d).D(pd9Var.f18824d).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            pd9 pd9Var2 = (pd9) sb0.g(map2.get(entry.getKey()));
            Cue.b bVar = (Cue.b) entry.getValue();
            e((SpannableStringBuilder) sb0.g(bVar.k()));
            bVar.t(pd9Var2.b, pd9Var2.f18820a);
            bVar.u(pd9Var2.f18822b);
            bVar.w(pd9Var2.f43957a);
            bVar.z(pd9Var2.c);
            bVar.C(pd9Var2.e, pd9Var2.f18823c);
            bVar.D(pd9Var2.f18824d);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public final void i(TreeSet<Long> treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.f18615a);
        boolean zEquals2 = "div".equals(this.f18615a);
        if (z2 || zEquals || (zEquals2 && this.d != null)) {
            long j2 = this.f43726a;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.b;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f18617a == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18617a.size(); i2++) {
            this.f18617a.get(i2).i(treeSet, z2 || zEquals);
        }
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i2 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.f18619a;
    }

    public boolean m(long j2) {
        long j3 = this.f43726a;
        return (j3 == -9223372036854775807L && this.b == -9223372036854775807L) || (j3 <= j2 && this.b == -9223372036854775807L) || ((j3 == -9223372036854775807L && j2 < this.b) || (j3 <= j2 && j2 < this.b));
    }

    public final void n(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.c)) {
            str = this.c;
        }
        if (m(j2) && "div".equals(this.f18615a) && this.d != null) {
            list.add(new Pair<>(str, this.d));
            return;
        }
        for (int i2 = 0; i2 < g(); i2++) {
            f(i2).n(j2, str, list);
        }
    }

    public final void o(long j2, Map<String, TtmlStyle> map, Map<String, pd9> map2, String str, Map<String, Cue.b> map3) {
        int i2;
        if (m(j2)) {
            String str2 = "".equals(this.c) ? str : this.c;
            Iterator<Map.Entry<String, Integer>> it = this.f18621b.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.f18616a.containsKey(key) ? this.f18616a.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (Cue.b) sb0.g(map3.get(key)), iIntValue, iIntValue2, ((pd9) sb0.g(map2.get(str2))).f18824d);
                }
            }
            for (i2 = 0; i2 < g(); i2++) {
                f(i2).o(j2, map, map2, str2, map3);
            }
        }
    }

    public final void p(long j2, boolean z2, String str, Map<String, Cue.b> map) {
        this.f18616a.clear();
        this.f18621b.clear();
        if ("metadata".equals(this.f18615a)) {
            return;
        }
        if (!"".equals(this.c)) {
            str = this.c;
        }
        if (this.f18618a && z2) {
            k(str, map).append((CharSequence) sb0.g(this.f18620b));
            return;
        }
        if ("br".equals(this.f18615a) && z2) {
            k(str, map).append('\n');
            return;
        }
        if (m(j2)) {
            for (Map.Entry<String, Cue.b> entry : map.entrySet()) {
                this.f18616a.put(entry.getKey(), Integer.valueOf(((CharSequence) sb0.g(entry.getValue().k())).length()));
            }
            boolean zEquals = "p".equals(this.f18615a);
            for (int i2 = 0; i2 < g(); i2++) {
                f(i2).p(j2, z2 || zEquals, str, map);
            }
            if (zEquals) {
                qd9.c(k(str, map));
            }
            for (Map.Entry<String, Cue.b> entry2 : map.entrySet()) {
                this.f18621b.put(entry2.getKey(), Integer.valueOf(((CharSequence) sb0.g(entry2.getValue().k())).length()));
            }
        }
    }
}
