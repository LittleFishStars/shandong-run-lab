package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeVibrant extends DynamicScheme {
    private static final double[] HUES = {AudioStats.AUDIO_AMPLITUDE_NONE, 41.0d, 61.0d, 101.0d, 131.0d, 181.0d, 251.0d, 301.0d, 360.0d};
    private static final double[] SECONDARY_ROTATIONS = {18.0d, 15.0d, 10.0d, 12.0d, 15.0d, 18.0d, 15.0d, 12.0d, 12.0d};
    private static final double[] TERTIARY_ROTATIONS = {35.0d, 30.0d, 20.0d, 25.0d, 30.0d, 35.0d, 30.0d, 25.0d, 25.0d};

    /* JADX WARN: Illegal instructions before constructor call */
    public SchemeVibrant(Hct hct, boolean z, double d) {
        Variant variant = Variant.VIBRANT;
        TonalPalette tonalPaletteFromHueAndChroma = TonalPalette.fromHueAndChroma(hct.getHue(), 200.0d);
        double[] dArr = HUES;
        super(hct, variant, z, d, tonalPaletteFromHueAndChroma, TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(hct, dArr, SECONDARY_ROTATIONS), 24.0d), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(hct, dArr, TERTIARY_ROTATIONS), 32.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 10.0d), TonalPalette.fromHueAndChroma(hct.getHue(), 12.0d));
    }
}
