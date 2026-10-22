package com.huachenjie.sport.bean;

import android.text.TextUtils;
import com.alibaba.ariver.jsapi.multimedia.camera.a;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/bean/AttendanceRecordBean;", "", a.b, "Lcom/huachenjie/sport/bean/ClockRecordBean;", "endRecord", "(Lcom/huachenjie/sport/bean/ClockRecordBean;Lcom/huachenjie/sport/bean/ClockRecordBean;)V", "getEndRecord", "()Lcom/huachenjie/sport/bean/ClockRecordBean;", "getStartRecord", "component1", "component2", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "showEndClock", "showStartLocation", "toString", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AttendanceRecordBean {

    @Nullable
    private final ClockRecordBean endRecord;

    @Nullable
    private final ClockRecordBean startRecord;

    /* JADX WARN: Illegal instructions before constructor call */
    public AttendanceRecordBean() {
        ClockRecordBean clockRecordBean = null;
        this(clockRecordBean, clockRecordBean, 3, clockRecordBean);
    }

    public AttendanceRecordBean(@Nullable ClockRecordBean clockRecordBean, @Nullable ClockRecordBean clockRecordBean2) {
        this.startRecord = clockRecordBean;
        this.endRecord = clockRecordBean2;
    }

    public static /* synthetic */ AttendanceRecordBean copy$default(AttendanceRecordBean attendanceRecordBean, ClockRecordBean clockRecordBean, ClockRecordBean clockRecordBean2, int i, Object obj) {
        if ((i & 1) != 0) {
            clockRecordBean = attendanceRecordBean.startRecord;
        }
        if ((i & 2) != 0) {
            clockRecordBean2 = attendanceRecordBean.endRecord;
        }
        return attendanceRecordBean.copy(clockRecordBean, clockRecordBean2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ClockRecordBean getStartRecord() {
        return this.startRecord;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ClockRecordBean getEndRecord() {
        return this.endRecord;
    }

    @NotNull
    public final AttendanceRecordBean copy(@Nullable ClockRecordBean startRecord, @Nullable ClockRecordBean endRecord) {
        return new AttendanceRecordBean(startRecord, endRecord);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendanceRecordBean)) {
            return false;
        }
        AttendanceRecordBean attendanceRecordBean = (AttendanceRecordBean) other;
        return Intrinsics.areEqual(this.startRecord, attendanceRecordBean.startRecord) && Intrinsics.areEqual(this.endRecord, attendanceRecordBean.endRecord);
    }

    @Nullable
    public final ClockRecordBean getEndRecord() {
        return this.endRecord;
    }

    @Nullable
    public final ClockRecordBean getStartRecord() {
        return this.startRecord;
    }

    public int hashCode() {
        ClockRecordBean clockRecordBean = this.startRecord;
        int iHashCode = (clockRecordBean == null ? 0 : clockRecordBean.hashCode()) * 31;
        ClockRecordBean clockRecordBean2 = this.endRecord;
        return iHashCode + (clockRecordBean2 != null ? clockRecordBean2.hashCode() : 0);
    }

    public final boolean showEndClock() {
        return this.endRecord != null;
    }

    public final boolean showStartLocation() {
        ClockRecordBean clockRecordBean = this.startRecord;
        return !TextUtils.isEmpty(clockRecordBean != null ? clockRecordBean.getLocation() : null);
    }

    @NotNull
    public String toString() {
        return "AttendanceRecordBean(startRecord=" + this.startRecord + ", endRecord=" + this.endRecord + ')';
    }

    public /* synthetic */ AttendanceRecordBean(ClockRecordBean clockRecordBean, ClockRecordBean clockRecordBean2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : clockRecordBean, (i & 2) != 0 ? null : clockRecordBean2);
    }
}
