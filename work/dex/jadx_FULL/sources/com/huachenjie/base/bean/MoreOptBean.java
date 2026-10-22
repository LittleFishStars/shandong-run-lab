package com.huachenjie.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/base/bean/MoreOptBean;", "Landroid/os/Parcelable;", "name", "", RemoteMessageConst.Notification.ICON, "", "optType", "(Ljava/lang/String;II)V", "getIcon", "()I", "getName", "()Ljava/lang/String;", "getOptType", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MoreOptBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MoreOptBean> CREATOR = new Creator();
    private final int icon;

    @NotNull
    private final String name;
    private final int optType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MoreOptBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MoreOptBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MoreOptBean(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MoreOptBean[] newArray(int i) {
            return new MoreOptBean[i];
        }
    }

    public MoreOptBean() {
        this(null, 0, 0, 7, null);
    }

    public MoreOptBean(@NotNull String str, @DrawableRes int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.icon = i;
        this.optType = i2;
    }

    public static /* synthetic */ MoreOptBean copy$default(MoreOptBean moreOptBean, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = moreOptBean.name;
        }
        if ((i3 & 2) != 0) {
            i = moreOptBean.icon;
        }
        if ((i3 & 4) != 0) {
            i2 = moreOptBean.optType;
        }
        return moreOptBean.copy(str, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getOptType() {
        return this.optType;
    }

    @NotNull
    public final MoreOptBean copy(@NotNull String name, @DrawableRes int icon, int optType) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MoreOptBean(name, icon, optType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoreOptBean)) {
            return false;
        }
        MoreOptBean moreOptBean = (MoreOptBean) other;
        return Intrinsics.areEqual(this.name, moreOptBean.name) && this.icon == moreOptBean.icon && this.optType == moreOptBean.optType;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getOptType() {
        return this.optType;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.icon)) * 31) + Integer.hashCode(this.optType);
    }

    @NotNull
    public String toString() {
        return "MoreOptBean(name=" + this.name + ", icon=" + this.icon + ", optType=" + this.optType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeInt(this.icon);
        parcel.writeInt(this.optType);
    }

    public /* synthetic */ MoreOptBean(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }
}
