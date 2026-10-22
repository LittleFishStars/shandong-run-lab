package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.zj.adlib.ku7;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Module
abstract class ExecutionModule {
    @Provides
    @Singleton
    public static Executor a() {
        return new ku7(Executors.newSingleThreadExecutor());
    }
}
