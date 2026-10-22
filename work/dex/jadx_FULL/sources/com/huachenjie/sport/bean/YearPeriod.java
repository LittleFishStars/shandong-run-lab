package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/sport/bean/YearPeriod;", "", "fitnessTestPeriods", "", "Lcom/huachenjie/sport/bean/FitnessTestPeriod;", "yearMonth", "", "yearMonthCode", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getFitnessTestPeriods", "()Ljava/util/List;", "getYearMonth", "()Ljava/lang/String;", "getYearMonthCode", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class YearPeriod {

    @Nullable
    private final List<FitnessTestPeriod> fitnessTestPeriods;

    @Nullable
    private final String yearMonth;

    @Nullable
    private final String yearMonthCode;

    public YearPeriod() {
        this(null, null, null, 7, null);
    }

    public YearPeriod(@Nullable List<FitnessTestPeriod> list, @Nullable String str, @Nullable String str2) {
        this.fitnessTestPeriods = list;
        this.yearMonth = str;
        this.yearMonthCode = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YearPeriod copy$default(YearPeriod yearPeriod, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = yearPeriod.fitnessTestPeriods;
        }
        if ((i & 2) != 0) {
            str = yearPeriod.yearMonth;
        }
        if ((i & 4) != 0) {
            str2 = yearPeriod.yearMonthCode;
        }
        return yearPeriod.copy(list, str, str2);
    }

    @Nullable
    public final List<FitnessTestPeriod> component1() {
        return this.fitnessTestPeriods;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getYearMonth() {
        return this.yearMonth;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getYearMonthCode() {
        return this.yearMonthCode;
    }

    @NotNull
    public final YearPeriod copy(@Nullable List<FitnessTestPeriod> fitnessTestPeriods, @Nullable String yearMonth, @Nullable String yearMonthCode) {
        return new YearPeriod(fitnessTestPeriods, yearMonth, yearMonthCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YearPeriod)) {
            return false;
        }
        YearPeriod yearPeriod = (YearPeriod) other;
        return Intrinsics.areEqual(this.fitnessTestPeriods, yearPeriod.fitnessTestPeriods) && Intrinsics.areEqual(this.yearMonth, yearPeriod.yearMonth) && Intrinsics.areEqual(this.yearMonthCode, yearPeriod.yearMonthCode);
    }

    @Nullable
    public final List<FitnessTestPeriod> getFitnessTestPeriods() {
        return this.fitnessTestPeriods;
    }

    @Nullable
    public final String getYearMonth() {
        return this.yearMonth;
    }

    @Nullable
    public final String getYearMonthCode() {
        return this.yearMonthCode;
    }

    public int hashCode() {
        List<FitnessTestPeriod> list = this.fitnessTestPeriods;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.yearMonth;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.yearMonthCode;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "YearPeriod(fitnessTestPeriods=" + this.fitnessTestPeriods + ", yearMonth=" + this.yearMonth + ", yearMonthCode=" + this.yearMonthCode + ')';
    }

    public /* synthetic */ YearPeriod(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
