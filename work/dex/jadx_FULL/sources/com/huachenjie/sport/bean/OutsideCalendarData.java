package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/OutsideCalendarData;", "", "attendDateList", "", "Lcom/huachenjie/sport/bean/AttendDate;", "today", "", "(Ljava/util/List;Ljava/lang/String;)V", "getAttendDateList", "()Ljava/util/List;", "getToday", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OutsideCalendarData {

    @Nullable
    private final List<AttendDate> attendDateList;

    @NotNull
    private final String today;

    public OutsideCalendarData(@Nullable List<AttendDate> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "today");
        this.attendDateList = list;
        this.today = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutsideCalendarData copy$default(OutsideCalendarData outsideCalendarData, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = outsideCalendarData.attendDateList;
        }
        if ((i & 2) != 0) {
            str = outsideCalendarData.today;
        }
        return outsideCalendarData.copy(list, str);
    }

    @Nullable
    public final List<AttendDate> component1() {
        return this.attendDateList;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToday() {
        return this.today;
    }

    @NotNull
    public final OutsideCalendarData copy(@Nullable List<AttendDate> attendDateList, @NotNull String today) {
        Intrinsics.checkNotNullParameter(today, "today");
        return new OutsideCalendarData(attendDateList, today);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutsideCalendarData)) {
            return false;
        }
        OutsideCalendarData outsideCalendarData = (OutsideCalendarData) other;
        return Intrinsics.areEqual(this.attendDateList, outsideCalendarData.attendDateList) && Intrinsics.areEqual(this.today, outsideCalendarData.today);
    }

    @Nullable
    public final List<AttendDate> getAttendDateList() {
        return this.attendDateList;
    }

    @NotNull
    public final String getToday() {
        return this.today;
    }

    public int hashCode() {
        List<AttendDate> list = this.attendDateList;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.today.hashCode();
    }

    @NotNull
    public String toString() {
        return "OutsideCalendarData(attendDateList=" + this.attendDateList + ", today=" + this.today + ')';
    }
}
