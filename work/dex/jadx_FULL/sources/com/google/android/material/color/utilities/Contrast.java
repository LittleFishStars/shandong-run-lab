package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    private Contrast() {
    }

    public static double darker(double d, double d2) {
        if (d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d);
            double d3 = ((dYFromLstar + 5.0d) / d2) - 5.0d;
            if (d3 >= AudioStats.AUDIO_AMPLITUDE_NONE && d3 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(dYFromLstar, d3);
                double dAbs = Math.abs(dRatioOfYs - d2);
                if (dRatioOfYs < d2 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d3) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= AudioStats.AUDIO_AMPLITUDE_NONE && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double darkerUnsafe(double d, double d2) {
        return Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, darker(d, d2));
    }

    public static double lighter(double d, double d2) {
        if (d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d);
            double d3 = ((dYFromLstar + 5.0d) * d2) - 5.0d;
            if (d3 >= AudioStats.AUDIO_AMPLITUDE_NONE && d3 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(d3, dYFromLstar);
                double dAbs = Math.abs(dRatioOfYs - d2);
                if (dRatioOfYs < d2 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d3) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= AudioStats.AUDIO_AMPLITUDE_NONE && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double lighterUnsafe(double d, double d2) {
        double dLighter = lighter(d, d2);
        if (dLighter < AudioStats.AUDIO_AMPLITUDE_NONE) {
            return 100.0d;
        }
        return dLighter;
    }

    public static double ratioOfTones(double d, double d2) {
        return ratioOfYs(ColorUtils.yFromLstar(d), ColorUtils.yFromLstar(d2));
    }

    public static double ratioOfYs(double d, double d2) {
        double dMax = Math.max(d, d2);
        if (dMax != d2) {
            d = d2;
        }
        return (dMax + 5.0d) / (d + 5.0d);
    }
}
