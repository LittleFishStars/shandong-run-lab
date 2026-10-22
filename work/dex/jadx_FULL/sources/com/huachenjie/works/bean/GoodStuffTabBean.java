package com.huachenjie.works.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/bean/GoodStuffTabBean;", "", "zoneNo", "", "zoneName", "sortNum", "", "zoneType", "recommendFlag", "(Ljava/lang/String;Ljava/lang/String;III)V", "getRecommendFlag", "()I", "getSortNum", "getZoneName", "()Ljava/lang/String;", "getZoneNo", "getZoneType", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodStuffTabBean {
    private final int recommendFlag;
    private final int sortNum;

    @NotNull
    private final String zoneName;

    @NotNull
    private final String zoneNo;
    private final int zoneType;

    public GoodStuffTabBean() {
        this(null, null, 0, 0, 0, 31, null);
    }

    public GoodStuffTabBean(@NotNull String str, @NotNull String str2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "zoneNo");
        Intrinsics.checkNotNullParameter(str2, "zoneName");
        this.zoneNo = str;
        this.zoneName = str2;
        this.sortNum = i;
        this.zoneType = i2;
        this.recommendFlag = i3;
    }

    public static /* synthetic */ GoodStuffTabBean copy$default(GoodStuffTabBean goodStuffTabBean, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = goodStuffTabBean.zoneNo;
        }
        if ((i4 & 2) != 0) {
            str2 = goodStuffTabBean.zoneName;
        }
        String str3 = str2;
        if ((i4 & 4) != 0) {
            i = goodStuffTabBean.sortNum;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = goodStuffTabBean.zoneType;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = goodStuffTabBean.recommendFlag;
        }
        return goodStuffTabBean.copy(str, str3, i5, i6, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getZoneNo() {
        return this.zoneNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getZoneName() {
        return this.zoneName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSortNum() {
        return this.sortNum;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getZoneType() {
        return this.zoneType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getRecommendFlag() {
        return this.recommendFlag;
    }

    @NotNull
    public final GoodStuffTabBean copy(@NotNull String zoneNo, @NotNull String zoneName, int sortNum, int zoneType, int recommendFlag) {
        Intrinsics.checkNotNullParameter(zoneNo, "zoneNo");
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        return new GoodStuffTabBean(zoneNo, zoneName, sortNum, zoneType, recommendFlag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodStuffTabBean)) {
            return false;
        }
        GoodStuffTabBean goodStuffTabBean = (GoodStuffTabBean) other;
        return Intrinsics.areEqual(this.zoneNo, goodStuffTabBean.zoneNo) && Intrinsics.areEqual(this.zoneName, goodStuffTabBean.zoneName) && this.sortNum == goodStuffTabBean.sortNum && this.zoneType == goodStuffTabBean.zoneType && this.recommendFlag == goodStuffTabBean.recommendFlag;
    }

    public final int getRecommendFlag() {
        return this.recommendFlag;
    }

    public final int getSortNum() {
        return this.sortNum;
    }

    @NotNull
    public final String getZoneName() {
        return this.zoneName;
    }

    @NotNull
    public final String getZoneNo() {
        return this.zoneNo;
    }

    public final int getZoneType() {
        return this.zoneType;
    }

    public int hashCode() {
        return (((((((this.zoneNo.hashCode() * 31) + this.zoneName.hashCode()) * 31) + Integer.hashCode(this.sortNum)) * 31) + Integer.hashCode(this.zoneType)) * 31) + Integer.hashCode(this.recommendFlag);
    }

    @NotNull
    public String toString() {
        return "GoodStuffTabBean(zoneNo=" + this.zoneNo + ", zoneName=" + this.zoneName + ", sortNum=" + this.sortNum + ", zoneType=" + this.zoneType + ", recommendFlag=" + this.recommendFlag + ')';
    }

    public /* synthetic */ GoodStuffTabBean(String str, String str2, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) == 0 ? str2 : "", (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }
}
