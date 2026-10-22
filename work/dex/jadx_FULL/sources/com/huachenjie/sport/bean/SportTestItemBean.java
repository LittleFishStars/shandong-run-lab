package com.huachenjie.sport.bean;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0092\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/huachenjie/sport/bean/SportTestItemBean;", "", "fitnessTestConfigCode", "", "fitnessTestDate", "fitnessTestStatus", "", "fitnessType", RequestParameters.SUBRESOURCE_LOCATION, "reservePeriod", "reserveStartTime", "", "reserveEndTime", "reserveTimeStatus", "title", "userReserveStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFitnessTestConfigCode", "()Ljava/lang/String;", "getFitnessTestDate", "getFitnessTestStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFitnessType", "getLocation", "getReserveEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReservePeriod", "getReserveStartTime", "getReserveTimeStatus", "getTitle", "getUserReserveStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/huachenjie/sport/bean/SportTestItemBean;", "equals", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SportTestItemBean {

    @Nullable
    private final String fitnessTestConfigCode;

    @Nullable
    private final String fitnessTestDate;

    @Nullable
    private final Integer fitnessTestStatus;

    @Nullable
    private final Integer fitnessType;

    @Nullable
    private final String location;

    @Nullable
    private final Long reserveEndTime;

    @Nullable
    private final String reservePeriod;

    @Nullable
    private final Long reserveStartTime;

    @Nullable
    private final Integer reserveTimeStatus;

    @Nullable
    private final String title;

    @Nullable
    private final Boolean userReserveStatus;

    public SportTestItemBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public SportTestItemBean(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable Long l, @Nullable Long l2, @Nullable Integer num3, @Nullable String str5, @Nullable Boolean bool) {
        this.fitnessTestConfigCode = str;
        this.fitnessTestDate = str2;
        this.fitnessTestStatus = num;
        this.fitnessType = num2;
        this.location = str3;
        this.reservePeriod = str4;
        this.reserveStartTime = l;
        this.reserveEndTime = l2;
        this.reserveTimeStatus = num3;
        this.title = str5;
        this.userReserveStatus = bool;
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFitnessTestConfigCode() {
        return this.fitnessTestConfigCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getUserReserveStatus() {
        return this.userReserveStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFitnessTestDate() {
        return this.fitnessTestDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getFitnessTestStatus() {
        return this.fitnessTestStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getFitnessType() {
        return this.fitnessType;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getReserveStartTime() {
        return this.reserveStartTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getReserveEndTime() {
        return this.reserveEndTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getReserveTimeStatus() {
        return this.reserveTimeStatus;
    }

    @NotNull
    public final SportTestItemBean copy(@Nullable String fitnessTestConfigCode, @Nullable String fitnessTestDate, @Nullable Integer fitnessTestStatus, @Nullable Integer fitnessType, @Nullable String location, @Nullable String reservePeriod, @Nullable Long reserveStartTime, @Nullable Long reserveEndTime, @Nullable Integer reserveTimeStatus, @Nullable String title, @Nullable Boolean userReserveStatus) {
        return new SportTestItemBean(fitnessTestConfigCode, fitnessTestDate, fitnessTestStatus, fitnessType, location, reservePeriod, reserveStartTime, reserveEndTime, reserveTimeStatus, title, userReserveStatus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportTestItemBean)) {
            return false;
        }
        SportTestItemBean sportTestItemBean = (SportTestItemBean) other;
        return Intrinsics.areEqual(this.fitnessTestConfigCode, sportTestItemBean.fitnessTestConfigCode) && Intrinsics.areEqual(this.fitnessTestDate, sportTestItemBean.fitnessTestDate) && Intrinsics.areEqual(this.fitnessTestStatus, sportTestItemBean.fitnessTestStatus) && Intrinsics.areEqual(this.fitnessType, sportTestItemBean.fitnessType) && Intrinsics.areEqual(this.location, sportTestItemBean.location) && Intrinsics.areEqual(this.reservePeriod, sportTestItemBean.reservePeriod) && Intrinsics.areEqual(this.reserveStartTime, sportTestItemBean.reserveStartTime) && Intrinsics.areEqual(this.reserveEndTime, sportTestItemBean.reserveEndTime) && Intrinsics.areEqual(this.reserveTimeStatus, sportTestItemBean.reserveTimeStatus) && Intrinsics.areEqual(this.title, sportTestItemBean.title) && Intrinsics.areEqual(this.userReserveStatus, sportTestItemBean.userReserveStatus);
    }

    @Nullable
    public final String getFitnessTestConfigCode() {
        return this.fitnessTestConfigCode;
    }

    @Nullable
    public final String getFitnessTestDate() {
        return this.fitnessTestDate;
    }

    @Nullable
    public final Integer getFitnessTestStatus() {
        return this.fitnessTestStatus;
    }

    @Nullable
    public final Integer getFitnessType() {
        return this.fitnessType;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final Long getReserveEndTime() {
        return this.reserveEndTime;
    }

    @Nullable
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    public final Long getReserveStartTime() {
        return this.reserveStartTime;
    }

    @Nullable
    public final Integer getReserveTimeStatus() {
        return this.reserveTimeStatus;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean getUserReserveStatus() {
        return this.userReserveStatus;
    }

    public int hashCode() {
        String str = this.fitnessTestConfigCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fitnessTestDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.fitnessTestStatus;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fitnessType;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.location;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.reservePeriod;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.reserveStartTime;
        int iHashCode7 = (iHashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.reserveEndTime;
        int iHashCode8 = (iHashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num3 = this.reserveTimeStatus;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.userReserveStatus;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportTestItemBean(fitnessTestConfigCode=" + this.fitnessTestConfigCode + ", fitnessTestDate=" + this.fitnessTestDate + ", fitnessTestStatus=" + this.fitnessTestStatus + ", fitnessType=" + this.fitnessType + ", location=" + this.location + ", reservePeriod=" + this.reservePeriod + ", reserveStartTime=" + this.reserveStartTime + ", reserveEndTime=" + this.reserveEndTime + ", reserveTimeStatus=" + this.reserveTimeStatus + ", title=" + this.title + ", userReserveStatus=" + this.userReserveStatus + ')';
    }

    public /* synthetic */ SportTestItemBean(String str, String str2, Integer num, Integer num2, String str3, String str4, Long l, Long l2, Integer num3, String str5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : str5, (i & 1024) == 0 ? bool : null);
    }
}
