package com.huachenjie.sport.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/sport/bean/CalendarDate;", "Landroid/os/Parcelable;", "year", "", "month", "day", "(III)V", "getDay", "()I", "getMonth", "getYear", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "getTimeMillis", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CalendarDate implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CalendarDate> CREATOR = new Creator();
    private final int day;
    private final int month;
    private final int year;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarDate> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CalendarDate createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CalendarDate(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CalendarDate[] newArray(int i) {
            return new CalendarDate[i];
        }
    }

    public CalendarDate() {
        this(0, 0, 0, 7, null);
    }

    public CalendarDate(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static /* synthetic */ CalendarDate copy$default(CalendarDate calendarDate, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = calendarDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = calendarDate.month;
        }
        if ((i4 & 4) != 0) {
            i3 = calendarDate.day;
        }
        return calendarDate.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDay() {
        return this.day;
    }

    @NotNull
    public final CalendarDate copy(int year, int month, int day) {
        return new CalendarDate(year, month, day);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarDate)) {
            return false;
        }
        CalendarDate calendarDate = (CalendarDate) other;
        return this.year == calendarDate.year && this.month == calendarDate.month && this.day == calendarDate.day;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getMonth() {
        return this.month;
    }

    public final long getTimeMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month, this.day);
        return calendar.getTimeInMillis();
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.year) * 31) + Integer.hashCode(this.month)) * 31) + Integer.hashCode(this.day);
    }

    @NotNull
    public String toString() {
        String string;
        String string2;
        int i = this.month;
        if (i > 9) {
            string = String.valueOf(i);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            sb.append(this.month);
            string = sb.toString();
        }
        int i2 = this.day;
        if (i2 > 9) {
            string2 = String.valueOf(i2);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('0');
            sb2.append(this.day);
            string2 = sb2.toString();
        }
        return this.year + '-' + string + '-' + string2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.day);
    }

    public /* synthetic */ CalendarDate(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1997 : i, (i4 & 2) != 0 ? 1 : i2, (i4 & 4) != 0 ? 1 : i3);
    }
}
