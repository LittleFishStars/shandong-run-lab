package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.video.spherical.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class AudioFormats {
    private static final int[] validSampleRates = {4000, 8000, 11025, 16000, 22050, a.h, 37800, 44056, i.K, 47250, 48000, 50000, 50400, 88200, 96000, 176400, 192000, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length - 3;
        for (int i = 0; i < length; i++) {
            iArr[i] = validSampleRates[i];
        }
        return length;
    }

    @CalledByNative
    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
