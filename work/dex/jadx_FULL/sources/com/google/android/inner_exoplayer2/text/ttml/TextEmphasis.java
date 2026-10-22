package com.google.android.inner_exoplayer2.text.ttml;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class TextEmphasis {
    public static final int MARK_SHAPE_AUTO = -1;
    public static final int POSITION_OUTSIDE = -2;
    public final int markFill;
    public final int markShape;
    public final int position;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final ImmutableSet<String> SINGLE_STYLE_VALUES = ImmutableSet.of("auto", "none");
    private static final ImmutableSet<String> MARK_SHAPE_VALUES = ImmutableSet.of("dot", "sesame", "circle");
    private static final ImmutableSet<String> MARK_FILL_VALUES = ImmutableSet.of("filled", "open");
    private static final ImmutableSet<String> POSITION_VALUES = ImmutableSet.of("after", "before", "outside");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }

    @Nullable
    public static TextEmphasis parse(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String strG = a.g(str.trim());
        if (strG.isEmpty()) {
            return null;
        }
        return parseWords(ImmutableSet.copyOf(TextUtils.split(strG, WHITESPACE_PATTERN)));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:55:0x00da  */
    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:69:0x0101  */
    /* JADX WARN: Code duplicated, block: B:71:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0106  */
    /* JADX WARN: Code duplicated, block: B:73:0x0108  */
    private static TextEmphasis parseWords(ImmutableSet<String> immutableSet) {
        byte b;
        int i;
        int i2;
        String str;
        int iHashCode;
        String str2 = (String) o.v(Sets.n(POSITION_VALUES, immutableSet), "outside");
        int iHashCode2 = str2.hashCode();
        byte b2 = 0;
        int i3 = 2;
        int i4 = -1;
        if (iHashCode2 != -1392885889) {
            if (iHashCode2 != -1106037339) {
                if (iHashCode2 == 92734940 && str2.equals("after")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("outside")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str2.equals("before")) {
            b = 2;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        Sets.SetView setViewN = Sets.n(SINGLE_STYLE_VALUES, immutableSet);
        if (!setViewN.isEmpty()) {
            String str3 = (String) setViewN.iterator().next();
            int iHashCode3 = str3.hashCode();
            if (iHashCode3 == 3005871) {
                str3.equals("auto");
            } else if (iHashCode3 == 3387192 && str3.equals("none")) {
                i4 = 0;
            }
            return new TextEmphasis(i4, 0, i);
        }
        Sets.SetView setViewN2 = Sets.n(MARK_FILL_VALUES, immutableSet);
        Sets.SetView setViewN3 = Sets.n(MARK_SHAPE_VALUES, immutableSet);
        if (setViewN2.isEmpty() && setViewN3.isEmpty()) {
            return new TextEmphasis(-1, 0, i);
        }
        String str4 = (String) o.v(setViewN2, "filled");
        int iHashCode4 = str4.hashCode();
        if (iHashCode4 != -1274499742) {
            if (iHashCode4 == 3417674 && str4.equals("open")) {
                i2 = 2;
            }
            str = (String) o.v(setViewN3, "circle");
            iHashCode = str.hashCode();
            if (iHashCode != -1360216880) {
                if (iHashCode != -905816648) {
                    if (iHashCode == 99657 || !str.equals("dot")) {
                        b2 = -1;
                    }
                } else if (str.equals("sesame")) {
                    b2 = 1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("circle")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 != 0) {
                if (b2 != 1) {
                    i3 = 1;
                } else {
                    i3 = 3;
                }
            }
            return new TextEmphasis(i3, i2, i);
        }
        str4.equals("filled");
        i2 = 1;
        str = (String) o.v(setViewN3, "circle");
        iHashCode = str.hashCode();
        if (iHashCode != -1360216880) {
            if (iHashCode != -905816648) {
                if (iHashCode == 99657) {
                    b2 = -1;
                } else {
                    b2 = -1;
                }
            } else if (str.equals("sesame")) {
                b2 = 1;
            } else {
                b2 = -1;
            }
        } else if (str.equals("circle")) {
            b2 = 2;
        } else {
            b2 = -1;
        }
        if (b2 != 0) {
            if (b2 != 1) {
                i3 = 1;
            } else {
                i3 = 3;
            }
        }
        return new TextEmphasis(i3, i2, i);
    }
}
