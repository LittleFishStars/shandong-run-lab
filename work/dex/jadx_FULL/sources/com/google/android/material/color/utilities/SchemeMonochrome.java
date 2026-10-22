package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct hct, boolean z, double d) {
        super(hct, Variant.MONOCHROME, z, d, TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
