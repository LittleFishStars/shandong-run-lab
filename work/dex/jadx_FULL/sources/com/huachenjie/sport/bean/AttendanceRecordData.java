package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/bean/AttendanceRecordData;", "", "recordList", "", "Lcom/huachenjie/sport/bean/RecordBean;", "(Ljava/util/List;)V", "getRecordList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendanceRecordData {

    @NotNull
    private final List<RecordBean> recordList;

    public AttendanceRecordData(@NotNull List<RecordBean> list) {
        Intrinsics.checkNotNullParameter(list, "recordList");
        this.recordList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AttendanceRecordData copy$default(AttendanceRecordData attendanceRecordData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = attendanceRecordData.recordList;
        }
        return attendanceRecordData.copy(list);
    }

    @NotNull
    public final List<RecordBean> component1() {
        return this.recordList;
    }

    @NotNull
    public final AttendanceRecordData copy(@NotNull List<RecordBean> recordList) {
        Intrinsics.checkNotNullParameter(recordList, "recordList");
        return new AttendanceRecordData(recordList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AttendanceRecordData) && Intrinsics.areEqual(this.recordList, ((AttendanceRecordData) other).recordList);
    }

    @NotNull
    public final List<RecordBean> getRecordList() {
        return this.recordList;
    }

    public int hashCode() {
        return this.recordList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AttendanceRecordData(recordList=" + this.recordList + ')';
    }
}
