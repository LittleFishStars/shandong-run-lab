package com.google.android.exoplayer2.text.ttml;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.a;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.o;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TextEmphasis {
    public static final int d = -1;
    public static final int e = -2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f4625a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f4626b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f4627c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f4623a = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableSet<String> f31023a = ImmutableSet.of("auto", "none");
    public static final ImmutableSet<String> b = ImmutableSet.of("dot", "sesame", "circle");
    public static final ImmutableSet<String> c = ImmutableSet.of("filled", "open");

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final ImmutableSet<String> f4624d = ImmutableSet.of("after", "before", "outside");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public TextEmphasis(int i, int i2, int i3) {
        this.f4625a = i;
        this.f4626b = i2;
        this.f4627c = i3;
    }

    @Nullable
    public static TextEmphasis a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strG = a.g(str.trim());
        if (strG.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(strG, f4623a)));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:37:0x0084  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x0113  */
    public static TextEmphasis b(ImmutableSet<String> immutableSet) {
        byte b2;
        int i;
        byte b3;
        String str = (String) o.v(Sets.n(f4624d, immutableSet), "outside");
        int iHashCode = str.hashCode();
        int i2 = 2;
        byte b4 = 0;
        byte b5 = 1;
        if (iHashCode != -1392885889) {
            if (iHashCode != -1106037339) {
                if (iHashCode == 92734940 && str.equals("after")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("outside")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("before")) {
            b2 = 2;
        } else {
            b2 = -1;
        }
        if (b2 != 0) {
            i = b2 != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        Sets.SetView setViewN = Sets.n(f31023a, immutableSet);
        if (!setViewN.isEmpty()) {
            String str2 = (String) setViewN.iterator().next();
            int iHashCode2 = str2.hashCode();
            if (iHashCode2 != 3005871) {
                if (iHashCode2 == 3387192 && str2.equals("none")) {
                    b5 = 0;
                } else {
                    b5 = -1;
                }
            } else if (!str2.equals("auto")) {
                b5 = -1;
            }
            return new TextEmphasis(b5 == 0 ? 0 : -1, 0, i);
        }
        Sets.SetView setViewN2 = Sets.n(c, immutableSet);
        Sets.SetView setViewN3 = Sets.n(b, immutableSet);
        if (setViewN2.isEmpty() && setViewN3.isEmpty()) {
            return new TextEmphasis(-1, 0, i);
        }
        String str3 = (String) o.v(setViewN2, "filled");
        int iHashCode3 = str3.hashCode();
        if (iHashCode3 != -1274499742) {
            if (iHashCode3 == 3417674 && str3.equals("open")) {
                b3 = 0;
            } else {
                b3 = -1;
            }
        } else if (str3.equals("filled")) {
            b3 = 1;
        } else {
            b3 = -1;
        }
        int i3 = b3 != 0 ? 1 : 2;
        String str4 = (String) o.v(setViewN3, "circle");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1360216880) {
            if (iHashCode4 != -905816648) {
                if (iHashCode4 != 99657 || !str4.equals("dot")) {
                    b4 = -1;
                }
            } else if (str4.equals("sesame")) {
                b4 = 1;
            } else {
                b4 = -1;
            }
        } else if (str4.equals("circle")) {
            b4 = 2;
        } else {
            b4 = -1;
        }
        if (b4 != 0) {
            i2 = b4 != 1 ? 1 : 3;
        }
        return new TextEmphasis(i2, i3, i);
    }
}
