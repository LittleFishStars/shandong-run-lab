package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/sport/bean/CampusLetterInfo;", "", "businessType", "", "businessSubType", "businessRelationCode", "", "(IILjava/lang/String;)V", "getBusinessRelationCode", "()Ljava/lang/String;", "getBusinessSubType", "()I", "getBusinessType", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CampusLetterInfo {

    @NotNull
    private final String businessRelationCode;
    private final int businessSubType;
    private final int businessType;

    public CampusLetterInfo() {
        this(0, 0, null, 7, null);
    }

    public CampusLetterInfo(int i, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "businessRelationCode");
        this.businessType = i;
        this.businessSubType = i2;
        this.businessRelationCode = str;
    }

    public static /* synthetic */ CampusLetterInfo copy$default(CampusLetterInfo campusLetterInfo, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = campusLetterInfo.businessType;
        }
        if ((i3 & 2) != 0) {
            i2 = campusLetterInfo.businessSubType;
        }
        if ((i3 & 4) != 0) {
            str = campusLetterInfo.businessRelationCode;
        }
        return campusLetterInfo.copy(i, i2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBusinessSubType() {
        return this.businessSubType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBusinessRelationCode() {
        return this.businessRelationCode;
    }

    @NotNull
    public final CampusLetterInfo copy(int businessType, int businessSubType, @NotNull String businessRelationCode) {
        Intrinsics.checkNotNullParameter(businessRelationCode, "businessRelationCode");
        return new CampusLetterInfo(businessType, businessSubType, businessRelationCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampusLetterInfo)) {
            return false;
        }
        CampusLetterInfo campusLetterInfo = (CampusLetterInfo) other;
        return this.businessType == campusLetterInfo.businessType && this.businessSubType == campusLetterInfo.businessSubType && Intrinsics.areEqual(this.businessRelationCode, campusLetterInfo.businessRelationCode);
    }

    @NotNull
    public final String getBusinessRelationCode() {
        return this.businessRelationCode;
    }

    public final int getBusinessSubType() {
        return this.businessSubType;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.businessType) * 31) + Integer.hashCode(this.businessSubType)) * 31) + this.businessRelationCode.hashCode();
    }

    @NotNull
    public String toString() {
        return "CampusLetterInfo(businessType=" + this.businessType + ", businessSubType=" + this.businessSubType + ", businessRelationCode=" + this.businessRelationCode + ')';
    }

    public /* synthetic */ CampusLetterInfo(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "" : str);
    }
}
