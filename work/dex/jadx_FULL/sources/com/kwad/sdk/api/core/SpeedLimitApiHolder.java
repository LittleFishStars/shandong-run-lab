package com.kwad.sdk.api.core;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Loader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SpeedLimitApiHolder {
    private static volatile SpeedLimitApi instance;

    @Nullable
    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                if (instance == null) {
                    instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                }
            }
        }
        return instance;
    }
}
