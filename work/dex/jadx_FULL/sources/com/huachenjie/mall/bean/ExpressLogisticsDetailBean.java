package com.huachenjie.mall.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressLogisticsDetailBean;", "", "time", "", "desc", "", "(JLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExpressLogisticsDetailBean {

    @NotNull
    private final String desc;
    private final long time;

    public ExpressLogisticsDetailBean() {
        this(0L, null, 3, null);
    }

    public ExpressLogisticsDetailBean(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        this.time = j;
        this.desc = str;
    }

    public static /* synthetic */ ExpressLogisticsDetailBean copy$default(ExpressLogisticsDetailBean expressLogisticsDetailBean, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = expressLogisticsDetailBean.time;
        }
        if ((i & 2) != 0) {
            str = expressLogisticsDetailBean.desc;
        }
        return expressLogisticsDetailBean.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final ExpressLogisticsDetailBean copy(long time, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new ExpressLogisticsDetailBean(time, desc);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressLogisticsDetailBean)) {
            return false;
        }
        ExpressLogisticsDetailBean expressLogisticsDetailBean = (ExpressLogisticsDetailBean) other;
        return this.time == expressLogisticsDetailBean.time && Intrinsics.areEqual(this.desc, expressLogisticsDetailBean.desc);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (Long.hashCode(this.time) * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExpressLogisticsDetailBean(time=" + this.time + ", desc=" + this.desc + ')';
    }

    public /* synthetic */ ExpressLogisticsDetailBean(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str);
    }
}
