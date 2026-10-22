package com.zj.adlib;

import com.huachenjie.run.bean.SunshineRunServiceData;
import com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/zj/adlib/sd3;", "Lcom/huachenjie/run/utils/time_factory/IPauseTimeChangeListener;", "Lcom/huachenjie/run/bean/SunshineRunServiceData;", "data", "d", "", "used", "c", "b", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class sd3 implements IPauseTimeChangeListener {
    @Override // com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener
    public long a(@NotNull SunshineRunServiceData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.getFaceCheckData().getFaceLeftTime();
    }

    @Override // com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener
    @NotNull
    public SunshineRunServiceData b(@NotNull SunshineRunServiceData data, long used) {
        Intrinsics.checkNotNullParameter(data, "data");
        data.getFaceCheckData().setFaceUseSaveTime(used);
        return data;
    }

    @Override // com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener
    @NotNull
    public SunshineRunServiceData c(@NotNull SunshineRunServiceData data, long used) {
        Intrinsics.checkNotNullParameter(data, "data");
        data.getFaceCheckData().setFaceUseTime(used);
        return data;
    }

    @Override // com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener
    @NotNull
    public SunshineRunServiceData d(@NotNull SunshineRunServiceData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        data.getFaceCheckData().setFaceLeftTime(RangesKt.coerceAtLeast(0L, ((((long) data.getFaceCheckData().getFaceTime()) * 1000) - data.getFaceCheckData().getFaceUseTime()) - data.getFaceCheckData().getFaceUseSaveTime()));
        return data;
    }
}
