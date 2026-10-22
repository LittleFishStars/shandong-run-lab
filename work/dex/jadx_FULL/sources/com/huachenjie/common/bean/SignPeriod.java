package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/common/bean/SignPeriod;", "Landroid/os/Parcelable;", "timeSegmentList", "", "Lcom/huachenjie/common/bean/SignSegment;", "weekDay", "", "(Ljava/util/List;I)V", "getTimeSegmentList", "()Ljava/util/List;", "getWeekDay", "()I", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getWeek", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignPeriod implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SignPeriod> CREATOR = new Creator();

    @NotNull
    private final List<SignSegment> timeSegmentList;
    private final int weekDay;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SignPeriod> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SignPeriod createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(SignSegment.CREATOR.createFromParcel(parcel));
            }
            return new SignPeriod(arrayList, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SignPeriod[] newArray(int i) {
            return new SignPeriod[i];
        }
    }

    public SignPeriod(@NotNull List<SignSegment> list, int i) {
        Intrinsics.checkNotNullParameter(list, "timeSegmentList");
        this.timeSegmentList = list;
        this.weekDay = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignPeriod copy$default(SignPeriod signPeriod, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = signPeriod.timeSegmentList;
        }
        if ((i2 & 2) != 0) {
            i = signPeriod.weekDay;
        }
        return signPeriod.copy(list, i);
    }

    @NotNull
    public final List<SignSegment> component1() {
        return this.timeSegmentList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWeekDay() {
        return this.weekDay;
    }

    @NotNull
    public final SignPeriod copy(@NotNull List<SignSegment> timeSegmentList, int weekDay) {
        Intrinsics.checkNotNullParameter(timeSegmentList, "timeSegmentList");
        return new SignPeriod(timeSegmentList, weekDay);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPeriod)) {
            return false;
        }
        SignPeriod signPeriod = (SignPeriod) other;
        return Intrinsics.areEqual(this.timeSegmentList, signPeriod.timeSegmentList) && this.weekDay == signPeriod.weekDay;
    }

    @NotNull
    public final List<SignSegment> getTimeSegmentList() {
        return this.timeSegmentList;
    }

    @NotNull
    public final String getWeek() {
        switch (this.weekDay) {
            case 1:
                return "周一";
            case 2:
                return "周二";
            case 3:
                return "周三";
            case 4:
                return "周四";
            case 5:
                return "周五";
            case 6:
                return "周六";
            case 7:
                return "周日";
            default:
                return "";
        }
    }

    public final int getWeekDay() {
        return this.weekDay;
    }

    public int hashCode() {
        return (this.timeSegmentList.hashCode() * 31) + Integer.hashCode(this.weekDay);
    }

    @NotNull
    public String toString() {
        return "SignPeriod(timeSegmentList=" + this.timeSegmentList + ", weekDay=" + this.weekDay + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<SignSegment> list = this.timeSegmentList;
        parcel.writeInt(list.size());
        Iterator<SignSegment> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.weekDay);
    }
}
