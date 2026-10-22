package com.huachenjie.common.util;

import android.media.AudioAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.blankj.utilcode.util.Utils;
import com.zj.adlib.i4a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/common/util/VibratorUtils;", "", "", "c", "a", "", "[J", "VIBRATE_INTERVAL_ARR", "Landroid/os/Vibrator;", "Lkotlin/Lazy;", "b", "()Landroid/os/Vibrator;", "vibrator", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class VibratorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VibratorUtils f33913a = new VibratorUtils();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final long[] VIBRATE_INTERVAL_ARR = {100, 2000, 1000, 1000, 3000};

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy vibrator = LazyKt.lazy(new Function0<Vibrator>() { // from class: com.huachenjie.common.util.VibratorUtils$vibrator$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Vibrator m359invoke() {
            Object systemService = Utils.a().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            return (Vibrator) systemService;
        }
    });

    @JvmStatic
    public static final void a() {
        f33913a.b().cancel();
    }

    @JvmStatic
    public static final void c() {
        try {
            VibratorUtils vibratorUtils = f33913a;
            if (vibratorUtils.b().hasVibrator()) {
                vibratorUtils.b().vibrate(VibrationEffect.createWaveform(VIBRATE_INTERVAL_ARR, 0), new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
            }
        } catch (Exception e) {
            i4a.d("VibratorUtils", "播放异常:" + e.getMessage());
        }
    }

    public final Vibrator b() {
        return (Vibrator) vibrator.getValue();
    }
}
