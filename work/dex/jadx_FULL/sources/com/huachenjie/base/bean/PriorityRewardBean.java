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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/PriorityRewardBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "imgUrl", "awardType", "", "awardLinkNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAwardLinkNo", "()Ljava/lang/String;", "getAwardName", "getAwardNo", "getAwardType", "()I", "getImgUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PriorityRewardBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PriorityRewardBean> CREATOR = new Creator();

    @NotNull
    private final String awardLinkNo;

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final String imgUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PriorityRewardBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriorityRewardBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PriorityRewardBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriorityRewardBean[] newArray(int i) {
            return new PriorityRewardBean[i];
        }
    }

    public PriorityRewardBean() {
        this(null, null, null, 0, null, 31, null);
    }

    public PriorityRewardBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(str3, "imgUrl");
        Intrinsics.checkNotNullParameter(str4, "awardLinkNo");
        this.awardNo = str;
        this.awardName = str2;
        this.imgUrl = str3;
        this.awardType = i;
        this.awardLinkNo = str4;
    }

    public static /* synthetic */ PriorityRewardBean copy$default(PriorityRewardBean priorityRewardBean, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = priorityRewardBean.awardNo;
        }
        if ((i2 & 2) != 0) {
            str2 = priorityRewardBean.awardName;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = priorityRewardBean.imgUrl;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = priorityRewardBean.awardType;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str4 = priorityRewardBean.awardLinkNo;
        }
        return priorityRewardBean.copy(str, str5, str6, i3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAwardNo() {
        return this.awardNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getImgUrl() {
        return this.imgUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAwardLinkNo() {
        return this.awardLinkNo;
    }

    @NotNull
    public final PriorityRewardBean copy(@NotNull String awardNo, @NotNull String awardName, @NotNull String imgUrl, int awardType, @NotNull String awardLinkNo) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(awardLinkNo, "awardLinkNo");
        return new PriorityRewardBean(awardNo, awardName, imgUrl, awardType, awardLinkNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PriorityRewardBean)) {
            return false;
        }
        PriorityRewardBean priorityRewardBean = (PriorityRewardBean) other;
        return Intrinsics.areEqual(this.awardNo, priorityRewardBean.awardNo) && Intrinsics.areEqual(this.awardName, priorityRewardBean.awardName) && Intrinsics.areEqual(this.imgUrl, priorityRewardBean.imgUrl) && this.awardType == priorityRewardBean.awardType && Intrinsics.areEqual(this.awardLinkNo, priorityRewardBean.awardLinkNo);
    }

    @NotNull
    public final String getAwardLinkNo() {
        return this.awardLinkNo;
    }

    @NotNull
    public final String getAwardName() {
        return this.awardName;
    }

    @NotNull
    public final String getAwardNo() {
        return this.awardNo;
    }

    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    public int hashCode() {
        return (((((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + Integer.hashCode(this.awardType)) * 31) + this.awardLinkNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "PriorityRewardBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", imgUrl=" + this.imgUrl + ", awardType=" + this.awardType + ", awardLinkNo=" + this.awardLinkNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeString(this.imgUrl);
        parcel.writeInt(this.awardType);
        parcel.writeString(this.awardLinkNo);
    }

    public /* synthetic */ PriorityRewardBean(String str, String str2, String str3, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? "" : str4);
    }
}
