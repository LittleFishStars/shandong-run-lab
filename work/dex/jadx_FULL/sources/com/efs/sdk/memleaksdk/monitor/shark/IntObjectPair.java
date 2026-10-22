package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cy, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/IntObjectPair;", "B", "", "first", "", "second", "(ILjava/lang/Object;)V", "getFirst", "()I", "getSecond", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", OperatePopupWindow.g, "(ILjava/lang/Object;)Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/IntObjectPair;", "equals", "", "other", "hashCode", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class IntObjectPair<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from toString */
    public final int first;

    /* JADX INFO: renamed from: b, reason: from toString */
    public final B second;

    public IntObjectPair(int i, B b) {
        this.first = i;
        this.second = b;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntObjectPair)) {
            return false;
        }
        IntObjectPair intObjectPair = (IntObjectPair) other;
        return this.first == intObjectPair.first && Intrinsics.areEqual(this.second, intObjectPair.second);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.first) * 31;
        B b = this.second;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "IntObjectPair(first=" + this.first + ", second=" + this.second + ")";
    }
}
