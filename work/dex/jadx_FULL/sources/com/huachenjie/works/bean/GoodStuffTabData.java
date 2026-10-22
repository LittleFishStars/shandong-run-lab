package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/works/bean/GoodStuffTabData;", "", "adZoneInfoList", "", "Lcom/huachenjie/works/bean/GoodStuffTabBean;", "(Ljava/util/List;)V", "getAdZoneInfoList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodStuffTabData {

    @NotNull
    private final List<GoodStuffTabBean> adZoneInfoList;

    /* JADX WARN: Illegal instructions before constructor call */
    public GoodStuffTabData() {
        List list = null;
        this(list, 1, list);
    }

    public GoodStuffTabData(@NotNull List<GoodStuffTabBean> list) {
        Intrinsics.checkNotNullParameter(list, "adZoneInfoList");
        this.adZoneInfoList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoodStuffTabData copy$default(GoodStuffTabData goodStuffTabData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = goodStuffTabData.adZoneInfoList;
        }
        return goodStuffTabData.copy(list);
    }

    @NotNull
    public final List<GoodStuffTabBean> component1() {
        return this.adZoneInfoList;
    }

    @NotNull
    public final GoodStuffTabData copy(@NotNull List<GoodStuffTabBean> adZoneInfoList) {
        Intrinsics.checkNotNullParameter(adZoneInfoList, "adZoneInfoList");
        return new GoodStuffTabData(adZoneInfoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GoodStuffTabData) && Intrinsics.areEqual(this.adZoneInfoList, ((GoodStuffTabData) other).adZoneInfoList);
    }

    @NotNull
    public final List<GoodStuffTabBean> getAdZoneInfoList() {
        return this.adZoneInfoList;
    }

    public int hashCode() {
        return this.adZoneInfoList.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodStuffTabData(adZoneInfoList=" + this.adZoneInfoList + ')';
    }

    public /* synthetic */ GoodStuffTabData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
