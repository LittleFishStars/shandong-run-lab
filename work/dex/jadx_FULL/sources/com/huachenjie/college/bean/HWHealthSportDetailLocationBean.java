package com.huachenjie.college.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/college/bean/HWHealthSportDetailLocationBean;", "", "sourceDataType", "", "points", "", "Lcom/huachenjie/college/bean/HWHealthSportDetailPointBean;", "(Ljava/lang/String;Ljava/util/List;)V", "getPoints", "()Ljava/util/List;", "getSourceDataType", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HWHealthSportDetailLocationBean {

    @NotNull
    private final List<HWHealthSportDetailPointBean> points;

    @NotNull
    private final String sourceDataType;

    /* JADX WARN: Multi-variable type inference failed */
    public HWHealthSportDetailLocationBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public HWHealthSportDetailLocationBean(@NotNull String str, @NotNull List<HWHealthSportDetailPointBean> list) {
        Intrinsics.checkNotNullParameter(str, "sourceDataType");
        Intrinsics.checkNotNullParameter(list, "points");
        this.sourceDataType = str;
        this.points = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HWHealthSportDetailLocationBean copy$default(HWHealthSportDetailLocationBean hWHealthSportDetailLocationBean, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hWHealthSportDetailLocationBean.sourceDataType;
        }
        if ((i & 2) != 0) {
            list = hWHealthSportDetailLocationBean.points;
        }
        return hWHealthSportDetailLocationBean.copy(str, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSourceDataType() {
        return this.sourceDataType;
    }

    @NotNull
    public final List<HWHealthSportDetailPointBean> component2() {
        return this.points;
    }

    @NotNull
    public final HWHealthSportDetailLocationBean copy(@NotNull String sourceDataType, @NotNull List<HWHealthSportDetailPointBean> points) {
        Intrinsics.checkNotNullParameter(sourceDataType, "sourceDataType");
        Intrinsics.checkNotNullParameter(points, "points");
        return new HWHealthSportDetailLocationBean(sourceDataType, points);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HWHealthSportDetailLocationBean)) {
            return false;
        }
        HWHealthSportDetailLocationBean hWHealthSportDetailLocationBean = (HWHealthSportDetailLocationBean) other;
        return Intrinsics.areEqual(this.sourceDataType, hWHealthSportDetailLocationBean.sourceDataType) && Intrinsics.areEqual(this.points, hWHealthSportDetailLocationBean.points);
    }

    @NotNull
    public final List<HWHealthSportDetailPointBean> getPoints() {
        return this.points;
    }

    @NotNull
    public final String getSourceDataType() {
        return this.sourceDataType;
    }

    public int hashCode() {
        return (this.sourceDataType.hashCode() * 31) + this.points.hashCode();
    }

    @NotNull
    public String toString() {
        return "HWHealthSportDetailLocationBean(sourceDataType=" + this.sourceDataType + ", points=" + this.points + ')';
    }

    public /* synthetic */ HWHealthSportDetailLocationBean(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : list);
    }
}
