package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.ui.c;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.cl7;
import com.zj.adlib.e24;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.y14;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f31085a = Pattern.compile("(&#13;)?&#10;");

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31086a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Map<String, String> f4972a;

        public b(String str, Map<String, String> map) {
            this.f31086a = str;
            this.f4972a = map;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.c$c, reason: collision with other inner class name */
    public static final class C0698c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Comparator<C0698c> f31087a = new Comparator() { // from class: com.zj.adlib.im8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.C0698c.e((c.C0698c) obj, (c.C0698c) obj2);
            }
        };
        public static final Comparator<C0698c> b = new Comparator() { // from class: com.zj.adlib.jm8
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.C0698c.f((c.C0698c) obj, (c.C0698c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f4973a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4974a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final int f4975b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final String f4976b;

        public static /* synthetic */ int e(C0698c c0698c, C0698c c0698c2) {
            int iCompare = Integer.compare(c0698c2.f4975b, c0698c.f4975b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = c0698c.f4974a.compareTo(c0698c2.f4974a);
            return iCompareTo != 0 ? iCompareTo : c0698c.f4976b.compareTo(c0698c2.f4976b);
        }

        public static /* synthetic */ int f(C0698c c0698c, C0698c c0698c2) {
            int iCompare = Integer.compare(c0698c2.f4973a, c0698c.f4973a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = c0698c2.f4974a.compareTo(c0698c.f4974a);
            return iCompareTo != 0 ? iCompareTo : c0698c2.f4976b.compareTo(c0698c.f4976b);
        }

        public C0698c(int i, int i2, String str, String str2) {
            this.f4973a = i;
            this.f4975b = i2;
            this.f4974a = str;
            this.f4976b = str2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0698c> f31088a = new ArrayList();
        public final List<C0698c> b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f) {
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            map.put(e24.a("bg_" + iIntValue), gj9.H("background-color:%s;", e24.b(iIntValue)));
        }
        SparseArray<d> sparseArrayC = c(spanned, f);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i);
            sb.append(b(spanned.subSequence(i2, iKeyAt)));
            d dVar = sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.b, C0698c.b);
            Iterator it2 = dVar.b.iterator();
            while (it2.hasNext()) {
                sb.append(((C0698c) it2.next()).f4976b);
            }
            Collections.sort(dVar.f31088a, C0698c.f31087a);
            Iterator it3 = dVar.f31088a.iterator();
            while (it3.hasNext()) {
                sb.append(((C0698c) it3.next()).f4974a);
            }
            i++;
            i2 = iKeyAt;
        }
        sb.append(b(spanned.subSequence(i2, spanned.length())));
        return new b(sb.toString(), map);
    }

    public static String b(CharSequence charSequence) {
        return f31085a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    public static SparseArray<d> c(Spanned spanned, float f) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                sb0.g(strD);
                C0698c c0698c = new C0698c(spanStart, spanEnd, strE, strD);
                f(sparseArray, spanStart).f31088a.add(c0698c);
                f(sparseArray, spanEnd).b.add(c0698c);
            }
        }
        return sparseArray;
    }

    @Nullable
    public static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof y14) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof cl7) {
                return "<rt>" + b(((cl7) obj).f15852a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @Nullable
    public static String e(Object obj, float f) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return gj9.H("<span style='color:%s;'>", e24.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return gj9.H("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof y14) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            return gj9.H("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f));
        }
        if (obj instanceof RelativeSizeSpan) {
            return gj9.H("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return gj9.H("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof cl7)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof TextEmphasisSpan)) {
                return null;
            }
            TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
            return gj9.H("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(textEmphasisSpan.f31018a, textEmphasisSpan.b), g(textEmphasisSpan.c));
        }
        int i = ((cl7) obj).f40991a;
        if (i == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    public static d f(SparseArray<d> sparseArray, int i) {
        d dVar = sparseArray.get(i);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i, dVar2);
        return dVar2;
    }

    public static String g(int i) {
        return i != 2 ? "over right" : "under left";
    }

    public static String h(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("filled ");
        } else if (i2 == 2) {
            sb.append("open ");
        }
        if (i == 0) {
            sb.append("none");
        } else if (i == 1) {
            sb.append("circle");
        } else if (i == 2) {
            sb.append("dot");
        } else if (i != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }
}
