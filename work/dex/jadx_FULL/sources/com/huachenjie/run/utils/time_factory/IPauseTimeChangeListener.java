package com.huachenjie.run.utils.time_factory;

import com.huachenjie.run.bean.SunshineRunServiceData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/utils/time_factory/IPauseTimeChangeListener;", "", "Lcom/huachenjie/run/bean/SunshineRunServiceData;", "data", "d", "", "used", "c", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public interface IPauseTimeChangeListener {
    long a(@NotNull SunshineRunServiceData data);

    @NotNull
    SunshineRunServiceData b(@NotNull SunshineRunServiceData data, long used);

    @NotNull
    SunshineRunServiceData c(@NotNull SunshineRunServiceData data, long used);

    @NotNull
    SunshineRunServiceData d(@NotNull SunshineRunServiceData data);
}
