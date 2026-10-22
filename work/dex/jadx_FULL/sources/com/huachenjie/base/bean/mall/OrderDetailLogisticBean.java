package com.huachenjie.base.bean.mall;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/mall/OrderDetailLogisticBean;", "Landroid/os/Parcelable;", ExpressLogisticsActivity.t, "", "currentNodeDesc", "currentNode", "", "nodeItemDesc", "curentNodeTime", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCurentNodeTime", "()Ljava/lang/String;", "getCurrentNode", "()I", "getCurrentNodeDesc", "getLogisticNo", "getNodeItemDesc", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OrderDetailLogisticBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<OrderDetailLogisticBean> CREATOR = new Creator();

    @NotNull
    private final String curentNodeTime;
    private final int currentNode;

    @NotNull
    private final String currentNodeDesc;

    @NotNull
    private final String logisticNo;

    @NotNull
    private final String nodeItemDesc;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OrderDetailLogisticBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderDetailLogisticBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OrderDetailLogisticBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderDetailLogisticBean[] newArray(int i) {
            return new OrderDetailLogisticBean[i];
        }
    }

    public OrderDetailLogisticBean() {
        this(null, null, 0, null, null, 31, null);
    }

    public OrderDetailLogisticBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, ExpressLogisticsActivity.t);
        Intrinsics.checkNotNullParameter(str2, "currentNodeDesc");
        Intrinsics.checkNotNullParameter(str3, "nodeItemDesc");
        Intrinsics.checkNotNullParameter(str4, "curentNodeTime");
        this.logisticNo = str;
        this.currentNodeDesc = str2;
        this.currentNode = i;
        this.nodeItemDesc = str3;
        this.curentNodeTime = str4;
    }

    public static /* synthetic */ OrderDetailLogisticBean copy$default(OrderDetailLogisticBean orderDetailLogisticBean, String str, String str2, int i, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = orderDetailLogisticBean.logisticNo;
        }
        if ((i2 & 2) != 0) {
            str2 = orderDetailLogisticBean.currentNodeDesc;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            i = orderDetailLogisticBean.currentNode;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = orderDetailLogisticBean.nodeItemDesc;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = orderDetailLogisticBean.curentNodeTime;
        }
        return orderDetailLogisticBean.copy(str, str5, i3, str6, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogisticNo() {
        return this.logisticNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrentNodeDesc() {
        return this.currentNodeDesc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCurrentNode() {
        return this.currentNode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNodeItemDesc() {
        return this.nodeItemDesc;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCurentNodeTime() {
        return this.curentNodeTime;
    }

    @NotNull
    public final OrderDetailLogisticBean copy(@NotNull String logisticNo, @NotNull String currentNodeDesc, int currentNode, @NotNull String nodeItemDesc, @NotNull String curentNodeTime) {
        Intrinsics.checkNotNullParameter(logisticNo, ExpressLogisticsActivity.t);
        Intrinsics.checkNotNullParameter(currentNodeDesc, "currentNodeDesc");
        Intrinsics.checkNotNullParameter(nodeItemDesc, "nodeItemDesc");
        Intrinsics.checkNotNullParameter(curentNodeTime, "curentNodeTime");
        return new OrderDetailLogisticBean(logisticNo, currentNodeDesc, currentNode, nodeItemDesc, curentNodeTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderDetailLogisticBean)) {
            return false;
        }
        OrderDetailLogisticBean orderDetailLogisticBean = (OrderDetailLogisticBean) other;
        return Intrinsics.areEqual(this.logisticNo, orderDetailLogisticBean.logisticNo) && Intrinsics.areEqual(this.currentNodeDesc, orderDetailLogisticBean.currentNodeDesc) && this.currentNode == orderDetailLogisticBean.currentNode && Intrinsics.areEqual(this.nodeItemDesc, orderDetailLogisticBean.nodeItemDesc) && Intrinsics.areEqual(this.curentNodeTime, orderDetailLogisticBean.curentNodeTime);
    }

    @NotNull
    public final String getCurentNodeTime() {
        return this.curentNodeTime;
    }

    public final int getCurrentNode() {
        return this.currentNode;
    }

    @NotNull
    public final String getCurrentNodeDesc() {
        return this.currentNodeDesc;
    }

    @NotNull
    public final String getLogisticNo() {
        return this.logisticNo;
    }

    @NotNull
    public final String getNodeItemDesc() {
        return this.nodeItemDesc;
    }

    public int hashCode() {
        return (((((((this.logisticNo.hashCode() * 31) + this.currentNodeDesc.hashCode()) * 31) + Integer.hashCode(this.currentNode)) * 31) + this.nodeItemDesc.hashCode()) * 31) + this.curentNodeTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "OrderDetailLogisticBean(logisticNo=" + this.logisticNo + ", currentNodeDesc=" + this.currentNodeDesc + ", currentNode=" + this.currentNode + ", nodeItemDesc=" + this.nodeItemDesc + ", curentNodeTime=" + this.curentNodeTime + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.logisticNo);
        parcel.writeString(this.currentNodeDesc);
        parcel.writeInt(this.currentNode);
        parcel.writeString(this.nodeItemDesc);
        parcel.writeString(this.curentNodeTime);
    }

    public /* synthetic */ OrderDetailLogisticBean(String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4);
    }
}
