package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/UniqueCode;", "", "dayCode", "", "timeFragmentCode", "yearMonthCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDayCode", "()Ljava/lang/String;", "getTimeFragmentCode", "getYearMonthCode", "component1", "component2", "component3", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UniqueCode {

    @Nullable
    private final String dayCode;

    @Nullable
    private final String timeFragmentCode;

    @Nullable
    private final String yearMonthCode;

    public UniqueCode() {
        this(null, null, null, 7, null);
    }

    public UniqueCode(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.dayCode = str;
        this.timeFragmentCode = str2;
        this.yearMonthCode = str3;
    }

    public static /* synthetic */ UniqueCode copy$default(UniqueCode uniqueCode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uniqueCode.dayCode;
        }
        if ((i & 2) != 0) {
            str2 = uniqueCode.timeFragmentCode;
        }
        if ((i & 4) != 0) {
            str3 = uniqueCode.yearMonthCode;
        }
        return uniqueCode.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDayCode() {
        return this.dayCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTimeFragmentCode() {
        return this.timeFragmentCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getYearMonthCode() {
        return this.yearMonthCode;
    }

    @NotNull
    public final UniqueCode copy(@Nullable String dayCode, @Nullable String timeFragmentCode, @Nullable String yearMonthCode) {
        return new UniqueCode(dayCode, timeFragmentCode, yearMonthCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UniqueCode)) {
            return false;
        }
        UniqueCode uniqueCode = (UniqueCode) other;
        return Intrinsics.areEqual(this.dayCode, uniqueCode.dayCode) && Intrinsics.areEqual(this.timeFragmentCode, uniqueCode.timeFragmentCode) && Intrinsics.areEqual(this.yearMonthCode, uniqueCode.yearMonthCode);
    }

    @Nullable
    public final String getDayCode() {
        return this.dayCode;
    }

    @Nullable
    public final String getTimeFragmentCode() {
        return this.timeFragmentCode;
    }

    @Nullable
    public final String getYearMonthCode() {
        return this.yearMonthCode;
    }

    public int hashCode() {
        String str = this.dayCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.timeFragmentCode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.yearMonthCode;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UniqueCode(dayCode=" + this.dayCode + ", timeFragmentCode=" + this.timeFragmentCode + ", yearMonthCode=" + this.yearMonthCode + ')';
    }

    public /* synthetic */ UniqueCode(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }
}
