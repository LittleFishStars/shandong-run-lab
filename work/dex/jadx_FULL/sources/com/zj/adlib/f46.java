package com.zj.adlib;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¨\u0006\u0007"}, d2 = {"Lcom/zj/adlib/f46;", "", "targetObj", "defaultValue", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class f46 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f46 f41591a = new f46();

    @NotNull
    public final Object a(@Nullable Object targetObj, @Nullable Object defaultValue) {
        if (defaultValue instanceof String) {
            return targetObj == null ? defaultValue : targetObj;
        }
        if (defaultValue instanceof Boolean) {
            return targetObj == null ? Boolean.FALSE : targetObj;
        }
        if (defaultValue instanceof Integer) {
            if (targetObj == null) {
                return 0;
            }
            return targetObj;
        }
        if (defaultValue instanceof Long) {
            if (targetObj == null) {
                return 0L;
            }
            return targetObj;
        }
        if (defaultValue instanceof Float) {
            return targetObj == null ? Float.valueOf(0.0f) : targetObj;
        }
        if (defaultValue instanceof Double) {
            return targetObj == null ? Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE) : targetObj;
        }
        if (targetObj == null) {
            return defaultValue == null ? "" : defaultValue;
        }
        return targetObj;
    }
}
