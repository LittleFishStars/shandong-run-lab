package com.facebook.imagepipeline.cache;

import androidx.camera.video.AudioStats;
import com.facebook.common.memory.MemoryTrimType;
import com.zj.adlib.ad3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class d implements CountingMemoryCache.CacheTrimStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29988a = "NativeMemoryCacheTrimStrategy";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29989a;

        static {
            int[] iArr = new int[MemoryTrimType.values().length];
            f29989a = iArr;
            try {
                iArr[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29989a[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29989a[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29989a[MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.CacheTrimStrategy
    public double a(MemoryTrimType memoryTrimType) {
        int i = a.f29989a[memoryTrimType.ordinal()];
        if (i == 1) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (i == 2 || i == 3 || i == 4) {
            return 1.0d;
        }
        ad3.y0(f29988a, "unknown trim type: %s", memoryTrimType);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
