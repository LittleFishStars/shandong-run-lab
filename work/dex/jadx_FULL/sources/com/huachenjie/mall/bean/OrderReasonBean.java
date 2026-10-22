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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/mall/bean/OrderReasonBean;", "Landroid/os/Parcelable;", "code", "", "desc", "", "isChecked", "", "(ILjava/lang/String;Z)V", "getCode", "()I", "getDesc", "()Ljava/lang/String;", "()Z", "setChecked", "(Z)V", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderReasonBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrderReasonBean> CREATOR = new Creator();
    private final int code;

    @NotNull
    private final String desc;
    private boolean isChecked;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderReasonBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderReasonBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderReasonBean(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderReasonBean[] newArray(int i) {
            return new OrderReasonBean[i];
        }
    }

    public OrderReasonBean() {
        this(0, null, false, 7, null);
    }

    public OrderReasonBean(int i, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "desc");
        this.code = i;
        this.desc = str;
        this.isChecked = z;
    }

    public static /* synthetic */ OrderReasonBean copy$default(OrderReasonBean orderReasonBean, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = orderReasonBean.code;
        }
        if ((i2 & 2) != 0) {
            str = orderReasonBean.desc;
        }
        if ((i2 & 4) != 0) {
            z = orderReasonBean.isChecked;
        }
        return orderReasonBean.copy(i, str, z);
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

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    @NotNull
    public final OrderReasonBean copy(int code, @NotNull String desc, boolean isChecked) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new OrderReasonBean(code, desc, isChecked);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderReasonBean)) {
            return false;
        }
        OrderReasonBean orderReasonBean = (OrderReasonBean) other;
        return this.code == orderReasonBean.code && Intrinsics.areEqual(this.desc, orderReasonBean.desc) && this.isChecked == orderReasonBean.isChecked;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.code) * 31) + this.desc.hashCode()) * 31;
        boolean z = this.isChecked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    @NotNull
    public String toString() {
        return "OrderReasonBean(code=" + this.code + ", desc=" + this.desc + ", isChecked=" + this.isChecked + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.code);
        parcel.writeString(this.desc);
        parcel.writeInt(this.isChecked ? 1 : 0);
    }

    public /* synthetic */ OrderReasonBean(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z);
    }
}
