package com.huachenjie.sport.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/sport/bean/AttendDate;", "", "attendTimestamp", "", "status", "", "(JI)V", "getAttendTimestamp", "()J", "getStatus", "()I", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendDate {
    private final long attendTimestamp;
    private final int status;

    public AttendDate(long j, int i) {
        this.attendTimestamp = j;
        this.status = i;
    }

    public static /* synthetic */ AttendDate copy$default(AttendDate attendDate, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = attendDate.attendTimestamp;
        }
        if ((i2 & 2) != 0) {
            i = attendDate.status;
        }
        return attendDate.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getAttendTimestamp() {
        return this.attendTimestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final AttendDate copy(long attendTimestamp, int status) {
        return new AttendDate(attendTimestamp, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendDate)) {
            return false;
        }
        AttendDate attendDate = (AttendDate) other;
        return this.attendTimestamp == attendDate.attendTimestamp && this.status == attendDate.status;
    }

    public final long getAttendTimestamp() {
        return this.attendTimestamp;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (Long.hashCode(this.attendTimestamp) * 31) + Integer.hashCode(this.status);
    }

    @NotNull
    public String toString() {
        return "AttendDate(attendTimestamp=" + this.attendTimestamp + ", status=" + this.status + ')';
    }
}
