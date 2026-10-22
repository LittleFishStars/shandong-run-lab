package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cz, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongPair;", "", "first", "", "second", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LongLongPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from toString */
    public final long first;

    /* JADX INFO: renamed from: b, reason: from toString */
    public final long second;

    public LongLongPair(long j, long j2) {
        this.first = j;
        this.second = j2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) other;
        return this.first == longLongPair.first && this.second == longLongPair.second;
    }

    public int hashCode() {
        return (Long.hashCode(this.first) * 31) + Long.hashCode(this.second);
    }

    @NotNull
    public String toString() {
        return "LongLongPair(first=" + this.first + ", second=" + this.second + ")";
    }
}
