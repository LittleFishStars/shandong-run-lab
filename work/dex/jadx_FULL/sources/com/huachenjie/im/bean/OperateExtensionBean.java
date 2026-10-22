package com.huachenjie.im.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/im/bean/OperateExtensionBean;", "Landroid/os/Parcelable;", RemoteMessageConst.Notification.ICON, "", "operateName", "", "(ILjava/lang/String;)V", "getIcon", "()I", "getOperateName", "()Ljava/lang/String;", "component1", "component2", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OperateExtensionBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OperateExtensionBean> CREATOR = new Creator();
    private final int icon;

    @NotNull
    private final String operateName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OperateExtensionBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OperateExtensionBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OperateExtensionBean(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OperateExtensionBean[] newArray(int i) {
            return new OperateExtensionBean[i];
        }
    }

    public OperateExtensionBean(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "operateName");
        this.icon = i;
        this.operateName = str;
    }

    public static /* synthetic */ OperateExtensionBean copy$default(OperateExtensionBean operateExtensionBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = operateExtensionBean.icon;
        }
        if ((i2 & 2) != 0) {
            str = operateExtensionBean.operateName;
        }
        return operateExtensionBean.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOperateName() {
        return this.operateName;
    }

    @NotNull
    public final OperateExtensionBean copy(int icon, @NotNull String operateName) {
        Intrinsics.checkNotNullParameter(operateName, "operateName");
        return new OperateExtensionBean(icon, operateName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperateExtensionBean)) {
            return false;
        }
        OperateExtensionBean operateExtensionBean = (OperateExtensionBean) other;
        return this.icon == operateExtensionBean.icon && Intrinsics.areEqual(this.operateName, operateExtensionBean.operateName);
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getOperateName() {
        return this.operateName;
    }

    public int hashCode() {
        return (Integer.hashCode(this.icon) * 31) + this.operateName.hashCode();
    }

    @NotNull
    public String toString() {
        return "OperateExtensionBean(icon=" + this.icon + ", operateName=" + this.operateName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.icon);
        parcel.writeString(this.operateName);
    }

    public /* synthetic */ OperateExtensionBean(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str);
    }
}
