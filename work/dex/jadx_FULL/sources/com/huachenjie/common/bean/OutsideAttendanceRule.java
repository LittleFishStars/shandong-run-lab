package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.mcssdk.constant.b;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u001d\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012HÆ\u0003J}\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\b2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012HÆ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u00068"}, d2 = {"Lcom/huachenjie/common/bean/OutsideAttendanceRule;", "Landroid/os/Parcelable;", "attendanceName", "", "attendanceTimes", "", "weekTimes", b.t, "", "exerciseTime", "locationName", "signPeriodList", "", "Lcom/huachenjie/common/bean/SignPeriod;", b.s, "locationList", "Ljava/util/ArrayList;", "Lcom/huachenjie/common/bean/LocationRangeBean;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;IIJILjava/lang/String;Ljava/util/List;JLjava/util/ArrayList;)V", "getAttendanceName", "()Ljava/lang/String;", "getAttendanceTimes", "()I", "getEndDate", "()J", "getExerciseTime", "getLocationList", "()Ljava/util/ArrayList;", "getLocationName", "getSignPeriodList", "()Ljava/util/List;", "getStartDate", "getWeekTimes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OutsideAttendanceRule implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OutsideAttendanceRule> CREATOR = new Creator();

    @NotNull
    private final String attendanceName;
    private final int attendanceTimes;
    private final long endDate;
    private final int exerciseTime;

    @Nullable
    private final ArrayList<LocationRangeBean> locationList;

    @NotNull
    private final String locationName;

    @NotNull
    private final List<SignPeriod> signPeriodList;
    private final long startDate;
    private final int weekTimes;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OutsideAttendanceRule> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OutsideAttendanceRule createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            long j = parcel.readLong();
            int i3 = parcel.readInt();
            String string2 = parcel.readString();
            int i4 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i4);
            for (int i5 = 0; i5 != i4; i5++) {
                arrayList2.add(SignPeriod.CREATOR.createFromParcel(parcel));
            }
            long j2 = parcel.readLong();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i6 = parcel.readInt();
                arrayList = new ArrayList(i6);
                for (int i7 = 0; i7 != i6; i7++) {
                    arrayList.add(LocationRangeBean.CREATOR.createFromParcel(parcel));
                }
            }
            return new OutsideAttendanceRule(string, i, i2, j, i3, string2, arrayList2, j2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OutsideAttendanceRule[] newArray(int i) {
            return new OutsideAttendanceRule[i];
        }
    }

    public OutsideAttendanceRule(@NotNull String str, int i, int i2, long j, int i3, @NotNull String str2, @NotNull List<SignPeriod> list, long j2, @Nullable ArrayList<LocationRangeBean> arrayList) {
        Intrinsics.checkNotNullParameter(str, "attendanceName");
        Intrinsics.checkNotNullParameter(str2, "locationName");
        Intrinsics.checkNotNullParameter(list, "signPeriodList");
        this.attendanceName = str;
        this.attendanceTimes = i;
        this.weekTimes = i2;
        this.endDate = j;
        this.exerciseTime = i3;
        this.locationName = str2;
        this.signPeriodList = list;
        this.startDate = j2;
        this.locationList = arrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttendanceName() {
        return this.attendanceName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getAttendanceTimes() {
        return this.attendanceTimes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWeekTimes() {
        return this.weekTimes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getExerciseTime() {
        return this.exerciseTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLocationName() {
        return this.locationName;
    }

    @NotNull
    public final List<SignPeriod> component7() {
        return this.signPeriodList;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getStartDate() {
        return this.startDate;
    }

    @Nullable
    public final ArrayList<LocationRangeBean> component9() {
        return this.locationList;
    }

    @NotNull
    public final OutsideAttendanceRule copy(@NotNull String attendanceName, int attendanceTimes, int weekTimes, long endDate, int exerciseTime, @NotNull String locationName, @NotNull List<SignPeriod> signPeriodList, long startDate, @Nullable ArrayList<LocationRangeBean> locationList) {
        Intrinsics.checkNotNullParameter(attendanceName, "attendanceName");
        Intrinsics.checkNotNullParameter(locationName, "locationName");
        Intrinsics.checkNotNullParameter(signPeriodList, "signPeriodList");
        return new OutsideAttendanceRule(attendanceName, attendanceTimes, weekTimes, endDate, exerciseTime, locationName, signPeriodList, startDate, locationList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutsideAttendanceRule)) {
            return false;
        }
        OutsideAttendanceRule outsideAttendanceRule = (OutsideAttendanceRule) other;
        return Intrinsics.areEqual(this.attendanceName, outsideAttendanceRule.attendanceName) && this.attendanceTimes == outsideAttendanceRule.attendanceTimes && this.weekTimes == outsideAttendanceRule.weekTimes && this.endDate == outsideAttendanceRule.endDate && this.exerciseTime == outsideAttendanceRule.exerciseTime && Intrinsics.areEqual(this.locationName, outsideAttendanceRule.locationName) && Intrinsics.areEqual(this.signPeriodList, outsideAttendanceRule.signPeriodList) && this.startDate == outsideAttendanceRule.startDate && Intrinsics.areEqual(this.locationList, outsideAttendanceRule.locationList);
    }

    @NotNull
    public final String getAttendanceName() {
        return this.attendanceName;
    }

    public final int getAttendanceTimes() {
        return this.attendanceTimes;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final int getExerciseTime() {
        return this.exerciseTime;
    }

    @Nullable
    public final ArrayList<LocationRangeBean> getLocationList() {
        return this.locationList;
    }

    @NotNull
    public final String getLocationName() {
        return this.locationName;
    }

    @NotNull
    public final List<SignPeriod> getSignPeriodList() {
        return this.signPeriodList;
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public final int getWeekTimes() {
        return this.weekTimes;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.attendanceName.hashCode() * 31) + Integer.hashCode(this.attendanceTimes)) * 31) + Integer.hashCode(this.weekTimes)) * 31) + Long.hashCode(this.endDate)) * 31) + Integer.hashCode(this.exerciseTime)) * 31) + this.locationName.hashCode()) * 31) + this.signPeriodList.hashCode()) * 31) + Long.hashCode(this.startDate)) * 31;
        ArrayList<LocationRangeBean> arrayList = this.locationList;
        return iHashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    @NotNull
    public String toString() {
        return "OutsideAttendanceRule(attendanceName=" + this.attendanceName + ", attendanceTimes=" + this.attendanceTimes + ", weekTimes=" + this.weekTimes + ", endDate=" + this.endDate + ", exerciseTime=" + this.exerciseTime + ", locationName=" + this.locationName + ", signPeriodList=" + this.signPeriodList + ", startDate=" + this.startDate + ", locationList=" + this.locationList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.attendanceName);
        parcel.writeInt(this.attendanceTimes);
        parcel.writeInt(this.weekTimes);
        parcel.writeLong(this.endDate);
        parcel.writeInt(this.exerciseTime);
        parcel.writeString(this.locationName);
        List<SignPeriod> list = this.signPeriodList;
        parcel.writeInt(list.size());
        Iterator<SignPeriod> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeLong(this.startDate);
        ArrayList<LocationRangeBean> arrayList = this.locationList;
        if (arrayList == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(arrayList.size());
        Iterator<LocationRangeBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }
}
