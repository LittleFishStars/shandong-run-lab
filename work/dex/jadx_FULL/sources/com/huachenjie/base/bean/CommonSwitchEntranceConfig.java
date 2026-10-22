package com.huachenjie.base.bean;

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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/base/bean/CommonSwitchEntranceConfig;", "Landroid/os/Parcelable;", "entryType", "", "entrySwitch", "url", "", "(IILjava/lang/String;)V", "getEntrySwitch", "()I", "getEntryType", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CommonSwitchEntranceConfig implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CommonSwitchEntranceConfig> CREATOR = new Creator();
    private final int entrySwitch;
    private final int entryType;

    @NotNull
    private final String url;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonSwitchEntranceConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonSwitchEntranceConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CommonSwitchEntranceConfig(parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonSwitchEntranceConfig[] newArray(int i) {
            return new CommonSwitchEntranceConfig[i];
        }
    }

    public CommonSwitchEntranceConfig() {
        this(0, 0, null, 7, null);
    }

    public CommonSwitchEntranceConfig(int i, int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.entryType = i;
        this.entrySwitch = i2;
        this.url = str;
    }

    public static /* synthetic */ CommonSwitchEntranceConfig copy$default(CommonSwitchEntranceConfig commonSwitchEntranceConfig, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = commonSwitchEntranceConfig.entryType;
        }
        if ((i3 & 2) != 0) {
            i2 = commonSwitchEntranceConfig.entrySwitch;
        }
        if ((i3 & 4) != 0) {
            str = commonSwitchEntranceConfig.url;
        }
        return commonSwitchEntranceConfig.copy(i, i2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEntryType() {
        return this.entryType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEntrySwitch() {
        return this.entrySwitch;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final CommonSwitchEntranceConfig copy(int entryType, int entrySwitch, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new CommonSwitchEntranceConfig(entryType, entrySwitch, url);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonSwitchEntranceConfig)) {
            return false;
        }
        CommonSwitchEntranceConfig commonSwitchEntranceConfig = (CommonSwitchEntranceConfig) other;
        return this.entryType == commonSwitchEntranceConfig.entryType && this.entrySwitch == commonSwitchEntranceConfig.entrySwitch && Intrinsics.areEqual(this.url, commonSwitchEntranceConfig.url);
    }

    public final int getEntrySwitch() {
        return this.entrySwitch;
    }

    public final int getEntryType() {
        return this.entryType;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.entryType) * 31) + Integer.hashCode(this.entrySwitch)) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommonSwitchEntranceConfig(entryType=" + this.entryType + ", entrySwitch=" + this.entrySwitch + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.entryType);
        parcel.writeInt(this.entrySwitch);
        parcel.writeString(this.url);
    }

    public /* synthetic */ CommonSwitchEntranceConfig(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "" : str);
    }
}
