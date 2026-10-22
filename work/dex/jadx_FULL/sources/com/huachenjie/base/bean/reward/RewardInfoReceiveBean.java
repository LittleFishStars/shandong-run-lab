package com.huachenjie.base.bean.reward;

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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/huachenjie/base/bean/reward/RewardInfoReceiveBean;", "Landroid/os/Parcelable;", "recordNo", "", "receivedTime", "", "orderInfo", "Lcom/huachenjie/base/bean/reward/RewardInfoOrderBean;", "(Ljava/lang/String;JLcom/huachenjie/base/bean/reward/RewardInfoOrderBean;)V", "getOrderInfo", "()Lcom/huachenjie/base/bean/reward/RewardInfoOrderBean;", "setOrderInfo", "(Lcom/huachenjie/base/bean/reward/RewardInfoOrderBean;)V", "getReceivedTime", "()J", "getRecordNo", "()Ljava/lang/String;", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RewardInfoReceiveBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<RewardInfoReceiveBean> CREATOR = new Creator();

    @Nullable
    private RewardInfoOrderBean orderInfo;
    private final long receivedTime;

    @NotNull
    private final String recordNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RewardInfoReceiveBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoReceiveBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RewardInfoReceiveBean(parcel.readString(), parcel.readLong(), parcel.readInt() == 0 ? null : RewardInfoOrderBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RewardInfoReceiveBean[] newArray(int i) {
            return new RewardInfoReceiveBean[i];
        }
    }

    public RewardInfoReceiveBean() {
        this(null, 0L, null, 7, null);
    }

    public RewardInfoReceiveBean(@NotNull String str, long j, @Nullable RewardInfoOrderBean rewardInfoOrderBean) {
        Intrinsics.checkNotNullParameter(str, "recordNo");
        this.recordNo = str;
        this.receivedTime = j;
        this.orderInfo = rewardInfoOrderBean;
    }

    public static /* synthetic */ RewardInfoReceiveBean copy$default(RewardInfoReceiveBean rewardInfoReceiveBean, String str, long j, RewardInfoOrderBean rewardInfoOrderBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rewardInfoReceiveBean.recordNo;
        }
        if ((i & 2) != 0) {
            j = rewardInfoReceiveBean.receivedTime;
        }
        if ((i & 4) != 0) {
            rewardInfoOrderBean = rewardInfoReceiveBean.orderInfo;
        }
        return rewardInfoReceiveBean.copy(str, j, rewardInfoOrderBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRecordNo() {
        return this.recordNo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getReceivedTime() {
        return this.receivedTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RewardInfoOrderBean getOrderInfo() {
        return this.orderInfo;
    }

    @NotNull
    public final RewardInfoReceiveBean copy(@NotNull String recordNo, long receivedTime, @Nullable RewardInfoOrderBean orderInfo) {
        Intrinsics.checkNotNullParameter(recordNo, "recordNo");
        return new RewardInfoReceiveBean(recordNo, receivedTime, orderInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardInfoReceiveBean)) {
            return false;
        }
        RewardInfoReceiveBean rewardInfoReceiveBean = (RewardInfoReceiveBean) other;
        return Intrinsics.areEqual(this.recordNo, rewardInfoReceiveBean.recordNo) && this.receivedTime == rewardInfoReceiveBean.receivedTime && Intrinsics.areEqual(this.orderInfo, rewardInfoReceiveBean.orderInfo);
    }

    @Nullable
    public final RewardInfoOrderBean getOrderInfo() {
        return this.orderInfo;
    }

    public final long getReceivedTime() {
        return this.receivedTime;
    }

    @NotNull
    public final String getRecordNo() {
        return this.recordNo;
    }

    public int hashCode() {
        int iHashCode = ((this.recordNo.hashCode() * 31) + Long.hashCode(this.receivedTime)) * 31;
        RewardInfoOrderBean rewardInfoOrderBean = this.orderInfo;
        return iHashCode + (rewardInfoOrderBean == null ? 0 : rewardInfoOrderBean.hashCode());
    }

    public final void setOrderInfo(@Nullable RewardInfoOrderBean rewardInfoOrderBean) {
        this.orderInfo = rewardInfoOrderBean;
    }

    @NotNull
    public String toString() {
        return "RewardInfoReceiveBean(recordNo=" + this.recordNo + ", receivedTime=" + this.receivedTime + ", orderInfo=" + this.orderInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.recordNo);
        parcel.writeLong(this.receivedTime);
        RewardInfoOrderBean rewardInfoOrderBean = this.orderInfo;
        if (rewardInfoOrderBean == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            rewardInfoOrderBean.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ RewardInfoReceiveBean(String str, long j, RewardInfoOrderBean rewardInfoOrderBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? null : rewardInfoOrderBean);
    }
}
