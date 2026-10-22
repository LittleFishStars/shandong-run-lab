package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/huachenjie/sport/bean/ReservePeriod;", "", "endStatus", "", "finishedReserveTotal", "", "reservePeriod", "", "reserveTotal", "timeFragmentCode", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getEndStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFinishedReserveTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReservePeriod", "()Ljava/lang/String;", "getReserveTotal", "getTimeFragmentCode", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/huachenjie/sport/bean/ReservePeriod;", "equals", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservePeriod {

    @Nullable
    private final Boolean endStatus;

    @Nullable
    private final Integer finishedReserveTotal;

    @Nullable
    private final String reservePeriod;

    @Nullable
    private final Integer reserveTotal;

    @Nullable
    private final String timeFragmentCode;

    public ReservePeriod() {
        this(null, null, null, null, null, 31, null);
    }

    public ReservePeriod(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2) {
        this.endStatus = bool;
        this.finishedReserveTotal = num;
        this.reservePeriod = str;
        this.reserveTotal = num2;
        this.timeFragmentCode = str2;
    }

    public static /* synthetic */ ReservePeriod copy$default(ReservePeriod reservePeriod, Boolean bool, Integer num, String str, Integer num2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = reservePeriod.endStatus;
        }
        if ((i & 2) != 0) {
            num = reservePeriod.finishedReserveTotal;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            str = reservePeriod.reservePeriod;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            num2 = reservePeriod.reserveTotal;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            str2 = reservePeriod.timeFragmentCode;
        }
        return reservePeriod.copy(bool, num3, str3, num4, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getEndStatus() {
        return this.endStatus;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getFinishedReserveTotal() {
        return this.finishedReserveTotal;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getReserveTotal() {
        return this.reserveTotal;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTimeFragmentCode() {
        return this.timeFragmentCode;
    }

    @NotNull
    public final ReservePeriod copy(@Nullable Boolean endStatus, @Nullable Integer finishedReserveTotal, @Nullable String reservePeriod, @Nullable Integer reserveTotal, @Nullable String timeFragmentCode) {
        return new ReservePeriod(endStatus, finishedReserveTotal, reservePeriod, reserveTotal, timeFragmentCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservePeriod)) {
            return false;
        }
        ReservePeriod reservePeriod = (ReservePeriod) other;
        return Intrinsics.areEqual(this.endStatus, reservePeriod.endStatus) && Intrinsics.areEqual(this.finishedReserveTotal, reservePeriod.finishedReserveTotal) && Intrinsics.areEqual(this.reservePeriod, reservePeriod.reservePeriod) && Intrinsics.areEqual(this.reserveTotal, reservePeriod.reserveTotal) && Intrinsics.areEqual(this.timeFragmentCode, reservePeriod.timeFragmentCode);
    }

    @Nullable
    public final Boolean getEndStatus() {
        return this.endStatus;
    }

    @Nullable
    public final Integer getFinishedReserveTotal() {
        return this.finishedReserveTotal;
    }

    @Nullable
    public final String getReservePeriod() {
        return this.reservePeriod;
    }

    @Nullable
    public final Integer getReserveTotal() {
        return this.reserveTotal;
    }

    @Nullable
    public final String getTimeFragmentCode() {
        return this.timeFragmentCode;
    }

    public int hashCode() {
        Boolean bool = this.endStatus;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.finishedReserveTotal;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.reservePeriod;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.reserveTotal;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.timeFragmentCode;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ReservePeriod(endStatus=" + this.endStatus + ", finishedReserveTotal=" + this.finishedReserveTotal + ", reservePeriod=" + this.reservePeriod + ", reserveTotal=" + this.reserveTotal + ", timeFragmentCode=" + this.timeFragmentCode + ')';
    }

    public /* synthetic */ ReservePeriod(Boolean bool, Integer num, String str, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str2);
    }
}
