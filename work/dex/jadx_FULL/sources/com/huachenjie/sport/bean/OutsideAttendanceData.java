package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/huachenjie/sport/bean/OutsideAttendanceData;", "", "attendDate", "", "attendStatus", "", "recordList", "", "Lcom/huachenjie/sport/bean/OutsideRecord;", "signInSegmentList", "Lcom/huachenjie/sport/bean/SignTimeSegment;", "signOutSegmentList", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAttendDate", "()Ljava/lang/String;", "getAttendStatus", "()I", "getRecordList", "()Ljava/util/List;", "getSignInSegmentList", "getSignOutSegmentList", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OutsideAttendanceData {

    @NotNull
    private final String attendDate;
    private final int attendStatus;

    @NotNull
    private final List<OutsideRecord> recordList;

    @NotNull
    private final List<SignTimeSegment> signInSegmentList;

    @NotNull
    private final List<SignTimeSegment> signOutSegmentList;

    public OutsideAttendanceData(@NotNull String str, int i, @NotNull List<OutsideRecord> list, @NotNull List<SignTimeSegment> list2, @NotNull List<SignTimeSegment> list3) {
        Intrinsics.checkNotNullParameter(str, "attendDate");
        Intrinsics.checkNotNullParameter(list, "recordList");
        Intrinsics.checkNotNullParameter(list2, "signInSegmentList");
        Intrinsics.checkNotNullParameter(list3, "signOutSegmentList");
        this.attendDate = str;
        this.attendStatus = i;
        this.recordList = list;
        this.signInSegmentList = list2;
        this.signOutSegmentList = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutsideAttendanceData copy$default(OutsideAttendanceData outsideAttendanceData, String str, int i, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = outsideAttendanceData.attendDate;
        }
        if ((i2 & 2) != 0) {
            i = outsideAttendanceData.attendStatus;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            list = outsideAttendanceData.recordList;
        }
        List list4 = list;
        if ((i2 & 8) != 0) {
            list2 = outsideAttendanceData.signInSegmentList;
        }
        List list5 = list2;
        if ((i2 & 16) != 0) {
            list3 = outsideAttendanceData.signOutSegmentList;
        }
        return outsideAttendanceData.copy(str, i3, list4, list5, list3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttendDate() {
        return this.attendDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAttendStatus() {
        return this.attendStatus;
    }

    @NotNull
    public final List<OutsideRecord> component3() {
        return this.recordList;
    }

    @NotNull
    public final List<SignTimeSegment> component4() {
        return this.signInSegmentList;
    }

    @NotNull
    public final List<SignTimeSegment> component5() {
        return this.signOutSegmentList;
    }

    @NotNull
    public final OutsideAttendanceData copy(@NotNull String attendDate, int attendStatus, @NotNull List<OutsideRecord> recordList, @NotNull List<SignTimeSegment> signInSegmentList, @NotNull List<SignTimeSegment> signOutSegmentList) {
        Intrinsics.checkNotNullParameter(attendDate, "attendDate");
        Intrinsics.checkNotNullParameter(recordList, "recordList");
        Intrinsics.checkNotNullParameter(signInSegmentList, "signInSegmentList");
        Intrinsics.checkNotNullParameter(signOutSegmentList, "signOutSegmentList");
        return new OutsideAttendanceData(attendDate, attendStatus, recordList, signInSegmentList, signOutSegmentList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutsideAttendanceData)) {
            return false;
        }
        OutsideAttendanceData outsideAttendanceData = (OutsideAttendanceData) other;
        return Intrinsics.areEqual(this.attendDate, outsideAttendanceData.attendDate) && this.attendStatus == outsideAttendanceData.attendStatus && Intrinsics.areEqual(this.recordList, outsideAttendanceData.recordList) && Intrinsics.areEqual(this.signInSegmentList, outsideAttendanceData.signInSegmentList) && Intrinsics.areEqual(this.signOutSegmentList, outsideAttendanceData.signOutSegmentList);
    }

    @NotNull
    public final String getAttendDate() {
        return this.attendDate;
    }

    public final int getAttendStatus() {
        return this.attendStatus;
    }

    @NotNull
    public final List<OutsideRecord> getRecordList() {
        return this.recordList;
    }

    @NotNull
    public final List<SignTimeSegment> getSignInSegmentList() {
        return this.signInSegmentList;
    }

    @NotNull
    public final List<SignTimeSegment> getSignOutSegmentList() {
        return this.signOutSegmentList;
    }

    public int hashCode() {
        return (((((((this.attendDate.hashCode() * 31) + Integer.hashCode(this.attendStatus)) * 31) + this.recordList.hashCode()) * 31) + this.signInSegmentList.hashCode()) * 31) + this.signOutSegmentList.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutsideAttendanceData(attendDate=" + this.attendDate + ", attendStatus=" + this.attendStatus + ", recordList=" + this.recordList + ", signInSegmentList=" + this.signInSegmentList + ", signOutSegmentList=" + this.signOutSegmentList + ')';
    }
}
