package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final Function<DynamicScheme, Double> chroma;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final Function<DynamicScheme, Double> hue;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaConstraint> toneDeltaConstraint;
    public final Function<DynamicScheme, Double> toneMaxContrast;
    public final Function<DynamicScheme, Double> toneMinContrast;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.DynamicColor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$TonePolarity;

        static {
            int[] iArr = new int[TonePolarity.values().length];
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity = iArr;
            try {
                iArr[TonePolarity.DARKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.LIGHTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.NO_PREFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DynamicColor(Function<DynamicScheme, Double> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, Double> function3, Function<DynamicScheme, Double> function4, Function<DynamicScheme, DynamicColor> function5, Function<DynamicScheme, Double> function6, Function<DynamicScheme, Double> function7, Function<DynamicScheme, ToneDeltaConstraint> function8) {
        this.hue = function;
        this.chroma = function2;
        this.tone = function3;
        this.opacity = function4;
        this.background = function5;
        this.toneMinContrast = function6;
        this.toneMaxContrast = function7;
        this.toneDeltaConstraint = function8;
    }

    public static double calculateDynamicTone(DynamicScheme dynamicScheme, Function<DynamicScheme, Double> function, Function<DynamicColor, Double> function2, BiFunction<Double, Double, Double> biFunction, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, ToneDeltaConstraint> function4, Function<Double, Double> function5, Function<Double, Double> function6) {
        double dDoubleValue = function.apply(dynamicScheme).doubleValue();
        DynamicColor dynamicColorApply = function3 == null ? null : function3.apply(dynamicScheme);
        if (dynamicColorApply == null) {
            return dDoubleValue;
        }
        double dRatioOfTones = Contrast.ratioOfTones(dDoubleValue, dynamicColorApply.tone.apply(dynamicScheme).doubleValue());
        double dDoubleValue2 = function2.apply(dynamicColorApply).doubleValue();
        double dDoubleValue3 = biFunction.apply(Double.valueOf(dRatioOfTones), Double.valueOf(dDoubleValue2)).doubleValue();
        double dRatioOfTones2 = Contrast.ratioOfTones(dDoubleValue2, dDoubleValue3);
        double dDoubleValue4 = 1.0d;
        if (function5 != null && function5.apply(Double.valueOf(dRatioOfTones)) != null) {
            dDoubleValue4 = function5.apply(Double.valueOf(dRatioOfTones)).doubleValue();
        }
        double dClampDouble = MathUtils.clampDouble(dDoubleValue4, (function6 == null || function6.apply(Double.valueOf(dRatioOfTones)) == null) ? 21.0d : function6.apply(Double.valueOf(dRatioOfTones)).doubleValue(), dRatioOfTones2);
        if (dClampDouble != dRatioOfTones2) {
            dDoubleValue3 = contrastingTone(dDoubleValue2, dClampDouble);
        }
        Function<DynamicScheme, DynamicColor> function7 = dynamicColorApply.background;
        return ensureToneDelta((function7 == null || function7.apply(dynamicScheme) == null) ? enableLightForeground(dDoubleValue3) : dDoubleValue3, dDoubleValue, dynamicScheme, function4, function2);
    }

    public static double contrastingTone(double d, double d2) {
        double dLighterUnsafe = Contrast.lighterUnsafe(d, d2);
        double dDarkerUnsafe = Contrast.darkerUnsafe(d, d2);
        double dRatioOfTones = Contrast.ratioOfTones(dLighterUnsafe, d);
        double dRatioOfTones2 = Contrast.ratioOfTones(dDarkerUnsafe, d);
        if (tonePrefersLightForeground(d)) {
            return (dRatioOfTones >= d2 || dRatioOfTones >= dRatioOfTones2 || ((Math.abs(dRatioOfTones - dRatioOfTones2) > 0.1d ? 1 : (Math.abs(dRatioOfTones - dRatioOfTones2) == 0.1d ? 0 : -1)) < 0 && (dRatioOfTones > d2 ? 1 : (dRatioOfTones == d2 ? 0 : -1)) < 0 && (dRatioOfTones2 > d2 ? 1 : (dRatioOfTones2 == d2 ? 0 : -1)) < 0)) ? dLighterUnsafe : dDarkerUnsafe;
        }
        return (dRatioOfTones2 >= d2 || dRatioOfTones2 >= dRatioOfTones) ? dDarkerUnsafe : dLighterUnsafe;
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    public static double ensureToneDelta(double d, double d2, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function, Function<DynamicColor, Double> function2) {
        ToneDeltaConstraint toneDeltaConstraintApply = function == null ? null : function.apply(dynamicScheme);
        if (toneDeltaConstraintApply == null) {
            return d;
        }
        double d3 = toneDeltaConstraintApply.delta;
        double dDoubleValue = function2.apply(toneDeltaConstraintApply.keepAway).doubleValue();
        double dAbs = Math.abs(d - dDoubleValue);
        if (dAbs >= d3) {
            return d;
        }
        int i = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$TonePolarity[toneDeltaConstraintApply.keepAwayPolarity.ordinal()];
        boolean z = true;
        if (i == 1) {
            return MathUtils.clampDouble(AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d, dDoubleValue + d3);
        }
        if (i == 2) {
            return MathUtils.clampDouble(AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d, dDoubleValue - d3);
        }
        if (i != 3) {
            return d;
        }
        boolean z2 = d2 > toneDeltaConstraintApply.keepAway.tone.apply(dynamicScheme).doubleValue();
        double dAbs2 = Math.abs(dAbs - d3);
        if (!z2 ? d >= dAbs2 : d + dAbs2 > 100.0d) {
            z = false;
        }
        return z ? d + dAbs2 : d - dAbs2;
    }

    public static DynamicColor fromArgb(int i) {
        final Hct hctFromInt = Hct.fromInt(i);
        final TonalPalette tonalPaletteFromInt = TonalPalette.fromInt(i);
        return fromPalette(new Function() { // from class: com.zj.adlib.dt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$0(tonalPaletteFromInt, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.zj.adlib.et2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$1(hctFromInt, (DynamicScheme) obj);
            }
        });
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return fromPalette(function, function2, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromArgb$1(Hct hct, DynamicScheme dynamicScheme) {
        return Double.valueOf(hct.getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$2(int i, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$3(int i, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$4(int i, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$5(Function function, DynamicScheme dynamicScheme) {
        return Double.valueOf(((TonalPalette) function.apply(dynamicScheme)).getHue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$6(Function function, DynamicScheme dynamicScheme) {
        return Double.valueOf(((TonalPalette) function.apply(dynamicScheme)).getChroma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$7(Function function, Function function2, Function function3, DynamicScheme dynamicScheme) {
        return Double.valueOf(toneMinContrastDefault(function, function2, dynamicScheme, function3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$8(Function function, Function function2, Function function3, DynamicScheme dynamicScheme) {
        return Double.valueOf(toneMaxContrastDefault(function, function2, dynamicScheme, function3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$10(double d, Double d2, Double d3) {
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$getTone$11(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return dynamicColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$12(double d, Double d2) {
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$13(double d, Double d2) {
        return Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$9(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return Double.valueOf(dynamicColor.getTone(dynamicScheme));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$17(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return dynamicColor.toneMaxContrast.apply(dynamicScheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$18(Function function, DynamicScheme dynamicScheme, Double d, Double d2) {
        return function != null && function.apply(dynamicScheme) != null && ((DynamicColor) function.apply(dynamicScheme)).background != null && ((DynamicColor) function.apply(dynamicScheme)).background.apply(dynamicScheme) != null ? Double.valueOf(contrastingTone(d2.doubleValue(), 7.0d)) : Double.valueOf(contrastingTone(d2.doubleValue(), Math.max(7.0d, d.doubleValue())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$14(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return dynamicColor.toneMinContrast.apply(dynamicScheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$15(Function function, DynamicScheme dynamicScheme, Function function2, Double d, Double d2) {
        double dDoubleValue = ((Double) function.apply(dynamicScheme)).doubleValue();
        if (d.doubleValue() >= 7.0d) {
            dDoubleValue = contrastingTone(d2.doubleValue(), 4.5d);
        } else if (d.doubleValue() >= 3.0d) {
            dDoubleValue = contrastingTone(d2.doubleValue(), 3.0d);
        } else {
            if ((function2 == null || function2.apply(dynamicScheme) == null || ((DynamicColor) function2.apply(dynamicScheme)).background == null || ((DynamicColor) function2.apply(dynamicScheme)).background.apply(dynamicScheme) == null) ? false : true) {
                dDoubleValue = contrastingTone(d2.doubleValue(), d.doubleValue());
            }
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$16(Double d) {
        return d;
    }

    public static boolean toneAllowsLightForeground(double d) {
        return Math.round(d) <= 49;
    }

    public static double toneMaxContrastDefault(Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new Function() { // from class: com.zj.adlib.ft2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$toneMaxContrastDefault$17(dynamicScheme, (DynamicColor) obj);
            }
        }, new BiFunction() { // from class: com.zj.adlib.gt2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$toneMaxContrastDefault$18(function2, dynamicScheme, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, null);
    }

    public static double toneMinContrastDefault(final Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new Function() { // from class: com.zj.adlib.kt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$toneMinContrastDefault$14(dynamicScheme, (DynamicColor) obj);
            }
        }, new BiFunction() { // from class: com.zj.adlib.lt2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$toneMinContrastDefault$15(function, dynamicScheme, function2, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, new Function() { // from class: com.zj.adlib.mt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$toneMinContrastDefault$16((Double) obj);
            }
        });
    }

    public static boolean tonePrefersLightForeground(double d) {
        return Math.round(d) < 60;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (i & 16777215);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hctFrom = Hct.from(this.hue.apply(dynamicScheme).doubleValue(), this.chroma.apply(dynamicScheme).doubleValue(), getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hctFrom);
        return hctFrom;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00ca A[PHI: r11
      0x00ca: PHI (r11v1 double) = (r11v0 double), (r11v4 double) binds: [B:18:0x0054, B:33:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    public double getTone(final DynamicScheme dynamicScheme) {
        final double dRatioOfTones;
        final double dDoubleValue = this.tone.apply(dynamicScheme).doubleValue();
        double d = dynamicScheme.contrastLevel;
        boolean z = d < AudioStats.AUDIO_AMPLITUDE_NONE;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            double dDoubleValue2 = this.tone.apply(dynamicScheme).doubleValue();
            dDoubleValue = dDoubleValue2 + (((z ? this.toneMinContrast : this.toneMaxContrast).apply(dynamicScheme).doubleValue() - dDoubleValue2) * Math.abs(dynamicScheme.contrastLevel));
        }
        Function<DynamicScheme, DynamicColor> function = this.background;
        final DynamicColor dynamicColorApply = function == null ? null : function.apply(dynamicScheme);
        final double dMin = 1.0d;
        if (dynamicColorApply == null) {
            dRatioOfTones = 21.0d;
        } else {
            Function<DynamicScheme, DynamicColor> function2 = dynamicColorApply.background;
            boolean z2 = (function2 == null || function2.apply(dynamicScheme) == null) ? false : true;
            dRatioOfTones = Contrast.ratioOfTones(this.tone.apply(dynamicScheme).doubleValue(), dynamicColorApply.tone.apply(dynamicScheme).doubleValue());
            if (z) {
                double dRatioOfTones2 = Contrast.ratioOfTones(this.toneMinContrast.apply(dynamicScheme).doubleValue(), dynamicColorApply.toneMinContrast.apply(dynamicScheme).doubleValue());
                if (z2) {
                    dMin = dRatioOfTones2;
                }
            } else {
                double dRatioOfTones3 = Contrast.ratioOfTones(this.toneMaxContrast.apply(dynamicScheme).doubleValue(), dynamicColorApply.toneMaxContrast.apply(dynamicScheme).doubleValue());
                dMin = z2 ? Math.min(dRatioOfTones3, dRatioOfTones) : 1.0d;
                if (z2) {
                    dRatioOfTones = Math.max(dRatioOfTones3, dRatioOfTones);
                } else {
                    dRatioOfTones = 21.0d;
                }
            }
        }
        return calculateDynamicTone(dynamicScheme, this.tone, new Function() { // from class: com.zj.adlib.pt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$getTone$9(dynamicScheme, (DynamicColor) obj);
            }
        }, new BiFunction() { // from class: com.zj.adlib.ys2
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$getTone$10(dDoubleValue, (Double) obj, (Double) obj2);
            }
        }, new Function() { // from class: com.zj.adlib.zs2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$getTone$11(this.f46332a, (DynamicScheme) obj);
            }
        }, this.toneDeltaConstraint, new Function() { // from class: com.zj.adlib.at2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$getTone$12(dMin, (Double) obj);
            }
        }, new Function() { // from class: com.zj.adlib.bt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$getTone$13(dRatioOfTones, (Double) obj);
            }
        });
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, DynamicColor> function3) {
        return fromPalette(function, function2, function3, null);
    }

    public static DynamicColor fromPalette(final Function<DynamicScheme, TonalPalette> function, final Function<DynamicScheme, Double> function2, final Function<DynamicScheme, DynamicColor> function3, final Function<DynamicScheme, ToneDeltaConstraint> function4) {
        return new DynamicColor(new Function() { // from class: com.zj.adlib.xs2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromPalette$5(function, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.zj.adlib.ht2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromPalette$6(function, (DynamicScheme) obj);
            }
        }, function2, null, function3, new Function() { // from class: com.zj.adlib.it2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromPalette$7(function2, function3, function4, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.zj.adlib.jt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromPalette$8(function2, function3, function4, (DynamicScheme) obj);
            }
        }, function4);
    }

    public static DynamicColor fromArgb(final int i, Function<DynamicScheme, Double> function) {
        return fromPalette(new Function() { // from class: com.zj.adlib.ot2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$2(i, (DynamicScheme) obj);
            }
        }, function);
    }

    public static DynamicColor fromArgb(final int i, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2) {
        return fromPalette(new Function() { // from class: com.zj.adlib.nt2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$3(i, (DynamicScheme) obj);
            }
        }, function, function2);
    }

    public static DynamicColor fromArgb(final int i, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return fromPalette(new Function() { // from class: com.zj.adlib.ct2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.lambda$fromArgb$4(i, (DynamicScheme) obj);
            }
        }, function, function2, function3);
    }
}
