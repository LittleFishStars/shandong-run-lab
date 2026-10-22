package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.extractor.flv.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/common/bean/RunTimeAreaData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "timeType", "", c.f2766e, "tagType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getTagType", "()I", "setTagType", "(I)V", "getTimeType", "()Ljava/lang/String;", "setTimeType", "(Ljava/lang/String;)V", "getTimes", "setTimes", "describeContents", "writeToParcel", "", "flags", "CREATOR", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunTimeAreaData implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int tagType;

    @Nullable
    private String timeType;

    @Nullable
    private String times;

    /* JADX INFO: renamed from: com.huachenjie.common.bean.RunTimeAreaData$CREATOR, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/huachenjie/common/bean/RunTimeAreaData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/huachenjie/common/bean/RunTimeAreaData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/huachenjie/common/bean/RunTimeAreaData;", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<RunTimeAreaData> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RunTimeAreaData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RunTimeAreaData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RunTimeAreaData[] newArray(int size) {
            return new RunTimeAreaData[size];
        }
    }

    public RunTimeAreaData(@Nullable String str, @Nullable String str2, int i) {
        this.timeType = str;
        this.times = str2;
        this.tagType = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getTagType() {
        return this.tagType;
    }

    @Nullable
    public final String getTimeType() {
        return this.timeType;
    }

    @Nullable
    public final String getTimes() {
        return this.times;
    }

    public final void setTagType(int i) {
        this.tagType = i;
    }

    public final void setTimeType(@Nullable String str) {
        this.timeType = str;
    }

    public final void setTimes(@Nullable String str) {
        this.times = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.timeType);
        parcel.writeString(this.times);
        parcel.writeInt(this.tagType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RunTimeAreaData(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
