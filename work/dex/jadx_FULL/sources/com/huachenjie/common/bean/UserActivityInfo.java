package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003Ji\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u00061"}, d2 = {"Lcom/huachenjie/common/bean/UserActivityInfo;", "Landroid/os/Parcelable;", "activityPlace", "", "activityName", "", "activityUrl", "activityPicUrl", "activityStartTime", "", "activityEndTime", "activityShowStartTime", "activityShowEndTime", "title", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/String;)V", "getActivityEndTime", "()J", "getActivityName", "()Ljava/lang/String;", "getActivityPicUrl", "getActivityPlace", "()I", "getActivityShowEndTime", "getActivityShowStartTime", "getActivityStartTime", "getActivityUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserActivityInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<UserActivityInfo> CREATOR = new Creator();
    private final long activityEndTime;

    @Nullable
    private final String activityName;

    @Nullable
    private final String activityPicUrl;
    private final int activityPlace;
    private final long activityShowEndTime;
    private final long activityShowStartTime;
    private final long activityStartTime;

    @Nullable
    private final String activityUrl;

    @NotNull
    private final String title;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserActivityInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserActivityInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserActivityInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserActivityInfo[] newArray(int i) {
            return new UserActivityInfo[i];
        }
    }

    public UserActivityInfo() {
        this(0, null, null, null, 0L, 0L, 0L, 0L, null, 511, null);
    }

    public UserActivityInfo(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, long j, long j2, long j3, long j4, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str4, "title");
        this.activityPlace = i;
        this.activityName = str;
        this.activityUrl = str2;
        this.activityPicUrl = str3;
        this.activityStartTime = j;
        this.activityEndTime = j2;
        this.activityShowStartTime = j3;
        this.activityShowEndTime = j4;
        this.title = str4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getActivityPlace() {
        return this.activityPlace;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getActivityStartTime() {
        return this.activityStartTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getActivityEndTime() {
        return this.activityEndTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getActivityShowStartTime() {
        return this.activityShowStartTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getActivityShowEndTime() {
        return this.activityShowEndTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final UserActivityInfo copy(int activityPlace, @Nullable String activityName, @Nullable String activityUrl, @Nullable String activityPicUrl, long activityStartTime, long activityEndTime, long activityShowStartTime, long activityShowEndTime, @NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return new UserActivityInfo(activityPlace, activityName, activityUrl, activityPicUrl, activityStartTime, activityEndTime, activityShowStartTime, activityShowEndTime, title);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserActivityInfo)) {
            return false;
        }
        UserActivityInfo userActivityInfo = (UserActivityInfo) other;
        return this.activityPlace == userActivityInfo.activityPlace && Intrinsics.areEqual(this.activityName, userActivityInfo.activityName) && Intrinsics.areEqual(this.activityUrl, userActivityInfo.activityUrl) && Intrinsics.areEqual(this.activityPicUrl, userActivityInfo.activityPicUrl) && this.activityStartTime == userActivityInfo.activityStartTime && this.activityEndTime == userActivityInfo.activityEndTime && this.activityShowStartTime == userActivityInfo.activityShowStartTime && this.activityShowEndTime == userActivityInfo.activityShowEndTime && Intrinsics.areEqual(this.title, userActivityInfo.title);
    }

    public final long getActivityEndTime() {
        return this.activityEndTime;
    }

    @Nullable
    public final String getActivityName() {
        return this.activityName;
    }

    @Nullable
    public final String getActivityPicUrl() {
        return this.activityPicUrl;
    }

    public final int getActivityPlace() {
        return this.activityPlace;
    }

    public final long getActivityShowEndTime() {
        return this.activityShowEndTime;
    }

    public final long getActivityShowStartTime() {
        return this.activityShowStartTime;
    }

    public final long getActivityStartTime() {
        return this.activityStartTime;
    }

    @Nullable
    public final String getActivityUrl() {
        return this.activityUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.activityPlace) * 31;
        String str = this.activityName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.activityUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.activityPicUrl;
        return ((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.activityStartTime)) * 31) + Long.hashCode(this.activityEndTime)) * 31) + Long.hashCode(this.activityShowStartTime)) * 31) + Long.hashCode(this.activityShowEndTime)) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserActivityInfo(activityPlace=" + this.activityPlace + ", activityName=" + this.activityName + ", activityUrl=" + this.activityUrl + ", activityPicUrl=" + this.activityPicUrl + ", activityStartTime=" + this.activityStartTime + ", activityEndTime=" + this.activityEndTime + ", activityShowStartTime=" + this.activityShowStartTime + ", activityShowEndTime=" + this.activityShowEndTime + ", title=" + this.title + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.activityPlace);
        parcel.writeString(this.activityName);
        parcel.writeString(this.activityUrl);
        parcel.writeString(this.activityPicUrl);
        parcel.writeLong(this.activityStartTime);
        parcel.writeLong(this.activityEndTime);
        parcel.writeLong(this.activityShowStartTime);
        parcel.writeLong(this.activityShowEndTime);
        parcel.writeString(this.title);
    }

    public /* synthetic */ UserActivityInfo(int i, String str, String str2, String str3, long j, long j2, long j3, long j4, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) == 0 ? str3 : null, (i2 & 16) != 0 ? 0L : j, (i2 & 32) != 0 ? 0L : j2, (i2 & 64) != 0 ? 0L : j3, (i2 & 128) == 0 ? j4 : 0L, (i2 & 256) != 0 ? "" : str4);
    }
}
