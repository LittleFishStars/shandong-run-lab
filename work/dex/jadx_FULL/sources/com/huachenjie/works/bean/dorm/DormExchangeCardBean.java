package com.huachenjie.works.bean.dorm;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/bean/dorm/DormExchangeCardBean;", "Landroid/os/Parcelable;", "perksNo", "", "perksName", "charmCost", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCharmCost", "()I", "getPerksName", "()Ljava/lang/String;", "getPerksNo", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormExchangeCardBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<DormExchangeCardBean> CREATOR = new Creator();
    private final int charmCost;

    @NotNull
    private final String perksName;

    @NotNull
    private final String perksNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DormExchangeCardBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DormExchangeCardBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DormExchangeCardBean(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DormExchangeCardBean[] newArray(int i) {
            return new DormExchangeCardBean[i];
        }
    }

    public DormExchangeCardBean() {
        this(null, null, 0, 7, null);
    }

    public DormExchangeCardBean(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "perksNo");
        Intrinsics.checkNotNullParameter(str2, "perksName");
        this.perksNo = str;
        this.perksName = str2;
        this.charmCost = i;
    }

    public static /* synthetic */ DormExchangeCardBean copy$default(DormExchangeCardBean dormExchangeCardBean, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dormExchangeCardBean.perksNo;
        }
        if ((i2 & 2) != 0) {
            str2 = dormExchangeCardBean.perksName;
        }
        if ((i2 & 4) != 0) {
            i = dormExchangeCardBean.charmCost;
        }
        return dormExchangeCardBean.copy(str, str2, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPerksNo() {
        return this.perksNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPerksName() {
        return this.perksName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCharmCost() {
        return this.charmCost;
    }

    @NotNull
    public final DormExchangeCardBean copy(@NotNull String perksNo, @NotNull String perksName, int charmCost) {
        Intrinsics.checkNotNullParameter(perksNo, "perksNo");
        Intrinsics.checkNotNullParameter(perksName, "perksName");
        return new DormExchangeCardBean(perksNo, perksName, charmCost);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormExchangeCardBean)) {
            return false;
        }
        DormExchangeCardBean dormExchangeCardBean = (DormExchangeCardBean) other;
        return Intrinsics.areEqual(this.perksNo, dormExchangeCardBean.perksNo) && Intrinsics.areEqual(this.perksName, dormExchangeCardBean.perksName) && this.charmCost == dormExchangeCardBean.charmCost;
    }

    public final int getCharmCost() {
        return this.charmCost;
    }

    @NotNull
    public final String getPerksName() {
        return this.perksName;
    }

    @NotNull
    public final String getPerksNo() {
        return this.perksNo;
    }

    public int hashCode() {
        return (((this.perksNo.hashCode() * 31) + this.perksName.hashCode()) * 31) + Integer.hashCode(this.charmCost);
    }

    @NotNull
    public String toString() {
        return "DormExchangeCardBean(perksNo=" + this.perksNo + ", perksName=" + this.perksName + ", charmCost=" + this.charmCost + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.perksNo);
        parcel.writeString(this.perksName);
        parcel.writeInt(this.charmCost);
    }

    public /* synthetic */ DormExchangeCardBean(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }
}
