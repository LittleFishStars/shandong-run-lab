package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.zj.adlib.oh9;
import com.zj.adlib.ut9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Module
public abstract class TimeModule {
    @Provides
    @WallTime
    public static Clock a() {
        return new ut9();
    }

    @Provides
    @Monotonic
    public static Clock b() {
        return new oh9();
    }
}
