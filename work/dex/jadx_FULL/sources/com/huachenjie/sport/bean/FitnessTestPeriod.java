package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/huachenjie/sport/bean/FitnessTestPeriod;", "", "dayCode", "", "dayTimeStamp", "", "naturalDay", "reservePeriods", "", "Lcom/huachenjie/sport/bean/ReservePeriod;", "weekDay", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDayCode", "()Ljava/lang/String;", "getDayTimeStamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNaturalDay", "getReservePeriods", "()Ljava/util/List;", "getWeekDay", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/huachenjie/sport/bean/FitnessTestPeriod;", "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FitnessTestPeriod {

    @Nullable
    private final String dayCode;

    @Nullable
    private final Long dayTimeStamp;

    @Nullable
    private final String naturalDay;

    @Nullable
    private final List<ReservePeriod> reservePeriods;

    @Nullable
    private final String weekDay;

    public FitnessTestPeriod() {
        this(null, null, null, null, null, 31, null);
    }

    public FitnessTestPeriod(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable List<ReservePeriod> list, @Nullable String str3) {
        this.dayCode = str;
        this.dayTimeStamp = l;
        this.naturalDay = str2;
        this.reservePeriods = list;
        this.weekDay = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FitnessTestPeriod copy$default(FitnessTestPeriod fitnessTestPeriod, String str, Long l, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fitnessTestPeriod.dayCode;
        }
        if ((i & 2) != 0) {
            l = fitnessTestPeriod.dayTimeStamp;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str2 = fitnessTestPeriod.naturalDay;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            list = fitnessTestPeriod.reservePeriods;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            str3 = fitnessTestPeriod.weekDay;
        }
        return fitnessTestPeriod.copy(str, l2, str4, list2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDayCode() {
        return this.dayCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getDayTimeStamp() {
        return this.dayTimeStamp;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNaturalDay() {
        return this.naturalDay;
    }

    @Nullable
    public final List<ReservePeriod> component4() {
        return this.reservePeriods;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getWeekDay() {
        return this.weekDay;
    }

    @NotNull
    public final FitnessTestPeriod copy(@Nullable String dayCode, @Nullable Long dayTimeStamp, @Nullable String naturalDay, @Nullable List<ReservePeriod> reservePeriods, @Nullable String weekDay) {
        return new FitnessTestPeriod(dayCode, dayTimeStamp, naturalDay, reservePeriods, weekDay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FitnessTestPeriod)) {
            return false;
        }
        FitnessTestPeriod fitnessTestPeriod = (FitnessTestPeriod) other;
        return Intrinsics.areEqual(this.dayCode, fitnessTestPeriod.dayCode) && Intrinsics.areEqual(this.dayTimeStamp, fitnessTestPeriod.dayTimeStamp) && Intrinsics.areEqual(this.naturalDay, fitnessTestPeriod.naturalDay) && Intrinsics.areEqual(this.reservePeriods, fitnessTestPeriod.reservePeriods) && Intrinsics.areEqual(this.weekDay, fitnessTestPeriod.weekDay);
    }

    @Nullable
    public final String getDayCode() {
        return this.dayCode;
    }

    @Nullable
    public final Long getDayTimeStamp() {
        return this.dayTimeStamp;
    }

    @Nullable
    public final String getNaturalDay() {
        return this.naturalDay;
    }

    @Nullable
    public final List<ReservePeriod> getReservePeriods() {
        return this.reservePeriods;
    }

    @Nullable
    public final String getWeekDay() {
        return this.weekDay;
    }

    public int hashCode() {
        String str = this.dayCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.dayTimeStamp;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.naturalDay;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ReservePeriod> list = this.reservePeriods;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.weekDay;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FitnessTestPeriod(dayCode=" + this.dayCode + ", dayTimeStamp=" + this.dayTimeStamp + ", naturalDay=" + this.naturalDay + ", reservePeriods=" + this.reservePeriods + ", weekDay=" + this.weekDay + ')';
    }

    public /* synthetic */ FitnessTestPeriod(String str, Long l, String str2, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str3);
    }
}
