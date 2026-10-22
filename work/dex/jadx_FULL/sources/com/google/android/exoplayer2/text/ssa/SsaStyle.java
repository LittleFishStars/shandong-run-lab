package com.google.android.exoplayer2.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import com.google.common.primitives.Ints;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SsaStyle {
    public static final String b = "SsaStyle";
    public static final int c = -1;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 8;
    public static final int l = 9;
    public static final int m = -1;
    public static final int n = 1;
    public static final int o = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f31019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f4604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @ColorInt
    public final Integer f4605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f4607a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f4608b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    @ColorInt
    public final Integer f4609b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f4610b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f4611c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f4612d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaBorderStyle {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31020a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f31020a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = i11;
        }

        @Nullable
        public static a a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                String strG = com.google.common.base.a.g(strArrSplit[i11].trim());
                strG.hashCode();
                switch (strG) {
                    case "italic":
                        i7 = i11;
                        break;
                    case "underline":
                        i8 = i11;
                        break;
                    case "strikeout":
                        i9 = i11;
                        break;
                    case "primarycolour":
                        i3 = i11;
                        break;
                    case "bold":
                        i6 = i11;
                        break;
                    case "name":
                        i = i11;
                        break;
                    case "fontsize":
                        i5 = i11;
                        break;
                    case "borderstyle":
                        i10 = i11;
                        break;
                    case "alignment":
                        i2 = i11;
                        break;
                    case "outlinecolour":
                        i4 = i11;
                        break;
                }
            }
            if (i != -1) {
                return new a(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, strArrSplit.length);
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f31021a = "SsaStyle.Overrides";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final Pattern f4613a = Pattern.compile("\\{([^}]*)\\}");
        public static final String b = "\\s*\\d+(?:\\.\\d+)?\\s*";

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public static final Pattern f4614b = Pattern.compile(gj9.H("\\\\pos\\((%1$s),(%1$s)\\)", b));
        public static final Pattern c = Pattern.compile(gj9.H("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", b));
        public static final Pattern d = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f4615a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final PointF f4616a;

        public b(int i, @Nullable PointF pointF) {
            this.f4615a = i;
            this.f4616a = pointF;
        }

        public static int a(String str) {
            Matcher matcher = d.matcher(str);
            if (matcher.find()) {
                return SsaStyle.e((String) sb0.g(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f4613a.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) sb0.g(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i, pointF);
        }

        @Nullable
        public static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f4614b.matcher(str);
            Matcher matcher2 = c.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    Log.h(f31021a, "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) sb0.g(strGroup)).trim()), Float.parseFloat(((String) sb0.g(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f4613a.matcher(str).replaceAll("");
        }
    }

    public SsaStyle(String str, int i2, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i3) {
        this.f4606a = str;
        this.f4604a = i2;
        this.f4605a = num;
        this.f4609b = num2;
        this.f31019a = f2;
        this.f4607a = z;
        this.f4610b = z2;
        this.f4611c = z3;
        this.f4612d = z4;
        this.f4608b = i3;
    }

    @Nullable
    public static SsaStyle b(String str, a aVar) {
        sb0.a(str.startsWith(com.google.android.exoplayer2.text.ssa.a.d));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i2 = aVar.k;
        if (length != i2) {
            Log.n(b, gj9.H("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i2), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f31020a].trim();
            int i3 = aVar.b;
            int iE = i3 != -1 ? e(strArrSplit[i3].trim()) : -1;
            int i4 = aVar.c;
            Integer numH = i4 != -1 ? h(strArrSplit[i4].trim()) : null;
            int i5 = aVar.d;
            Integer numH2 = i5 != -1 ? h(strArrSplit[i5].trim()) : null;
            int i6 = aVar.e;
            float fI = i6 != -1 ? i(strArrSplit[i6].trim()) : -3.4028235E38f;
            int i7 = aVar.f;
            boolean z = i7 != -1 && f(strArrSplit[i7].trim());
            int i8 = aVar.g;
            boolean z2 = i8 != -1 && f(strArrSplit[i8].trim());
            int i9 = aVar.h;
            boolean z3 = i9 != -1 && f(strArrSplit[i9].trim());
            int i10 = aVar.i;
            boolean z4 = i10 != -1 && f(strArrSplit[i10].trim());
            int i11 = aVar.j;
            return new SsaStyle(strTrim, iE, numH, numH2, fI, z, z2, z3, z4, i11 != -1 ? g(strArrSplit[i11].trim()) : -1);
        } catch (RuntimeException e2) {
            Log.o(b, "Skipping malformed 'Style:' line: '" + str + "'", e2);
            return null;
        }
    }

    public static boolean c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean d(int i2) {
        return i2 == 1 || i2 == 3;
    }

    public static int e(String str) {
        try {
            int i2 = Integer.parseInt(str.trim());
            if (c(i2)) {
                return i2;
            }
        } catch (NumberFormatException unused) {
        }
        Log.n(b, "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean f(String str) {
        try {
            int i2 = Integer.parseInt(str);
            return i2 == 1 || i2 == -1;
        } catch (NumberFormatException e2) {
            Log.o(b, "Failed to parse boolean value: '" + str + "'", e2);
            return false;
        }
    }

    public static int g(String str) {
        try {
            int i2 = Integer.parseInt(str.trim());
            if (d(i2)) {
                return i2;
            }
        } catch (NumberFormatException unused) {
        }
        Log.n(b, "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    @Nullable
    @ColorInt
    public static Integer h(String str) {
        try {
            long j2 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            sb0.a(j2 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.d(((j2 >> 24) & 255) ^ 255), Ints.d(j2 & 255), Ints.d((j2 >> 8) & 255), Ints.d((j2 >> 16) & 255)));
        } catch (IllegalArgumentException e2) {
            Log.o(b, "Failed to parse color expression: '" + str + "'", e2);
            return null;
        }
    }

    public static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            Log.o(b, "Failed to parse font size: '" + str + "'", e2);
            return -3.4028235E38f;
        }
    }
}
