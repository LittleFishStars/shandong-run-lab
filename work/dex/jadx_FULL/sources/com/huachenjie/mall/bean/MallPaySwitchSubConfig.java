package com.huachenjie.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mall/bean/MallPaySwitchSubConfig;", "Landroid/os/Parcelable;", "code", "", "desc", "", "(ILjava/lang/String;)V", "getCode", "()I", "getDesc", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MallPaySwitchSubConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MallPaySwitchSubConfig> CREATOR = new Creator();
    private final int code;

    @NotNull
    private final String desc;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MallPaySwitchSubConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MallPaySwitchSubConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MallPaySwitchSubConfig(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MallPaySwitchSubConfig[] newArray(int i) {
            return new MallPaySwitchSubConfig[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MallPaySwitchSubConfig() {
        String str = null;
        this(0, str, 3, str);
    }

    public MallPaySwitchSubConfig(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "desc");
        this.code = i;
        this.desc = str;
    }

    public static /* synthetic */ MallPaySwitchSubConfig copy$default(MallPaySwitchSubConfig mallPaySwitchSubConfig, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mallPaySwitchSubConfig.code;
        }
        if ((i2 & 2) != 0) {
            str = mallPaySwitchSubConfig.desc;
        }
        return mallPaySwitchSubConfig.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final MallPaySwitchSubConfig copy(int code, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new MallPaySwitchSubConfig(code, desc);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MallPaySwitchSubConfig)) {
            return false;
        }
        MallPaySwitchSubConfig mallPaySwitchSubConfig = (MallPaySwitchSubConfig) other;
        return this.code == mallPaySwitchSubConfig.code && Intrinsics.areEqual(this.desc, mallPaySwitchSubConfig.desc);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public int hashCode() {
        return (Integer.hashCode(this.code) * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "MallPaySwitchSubConfig(code=" + this.code + ", desc=" + this.desc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeString(this.desc);
    }

    public /* synthetic */ MallPaySwitchSubConfig(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str);
    }
}
