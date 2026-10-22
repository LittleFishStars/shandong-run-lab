package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/common/bean/SunRunActivityData;", "Landroid/os/Parcelable;", "isRunFlag", "", "activityCode", "", "content", "(ZLjava/lang/String;Ljava/lang/String;)V", "getActivityCode", "()Ljava/lang/String;", "setActivityCode", "(Ljava/lang/String;)V", "getContent", "setContent", "()Z", "setRunFlag", "(Z)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SunRunActivityData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SunRunActivityData> CREATOR = new Creator();

    @Nullable
    private String activityCode;

    @Nullable
    private String content;
    private boolean isRunFlag;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SunRunActivityData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunRunActivityData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SunRunActivityData(parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunRunActivityData[] newArray(int i) {
            return new SunRunActivityData[i];
        }
    }

    public SunRunActivityData() {
        this(false, null, null, 7, null);
    }

    public SunRunActivityData(boolean z, @Nullable String str, @Nullable String str2) {
        this.isRunFlag = z;
        this.activityCode = str;
        this.content = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getActivityCode() {
        return this.activityCode;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: isRunFlag, reason: from getter */
    public final boolean getIsRunFlag() {
        return this.isRunFlag;
    }

    public final void setActivityCode(@Nullable String str) {
        this.activityCode = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setRunFlag(boolean z) {
        this.isRunFlag = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isRunFlag ? 1 : 0);
        parcel.writeString(this.activityCode);
        parcel.writeString(this.content);
    }

    public /* synthetic */ SunRunActivityData(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
