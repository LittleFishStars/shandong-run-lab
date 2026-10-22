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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/huachenjie/base/bean/AwardShowcaseBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "awardType", "", "imageInfo", "Lcom/huachenjie/base/bean/AwardImageBean;", "(Ljava/lang/String;Ljava/lang/String;ILcom/huachenjie/base/bean/AwardImageBean;)V", "getAwardName", "()Ljava/lang/String;", "getAwardNo", "getAwardType", "()I", "getImageInfo", "()Lcom/huachenjie/base/bean/AwardImageBean;", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "formatImageUrl", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AwardShowcaseBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AwardShowcaseBean> CREATOR = new Creator();

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final AwardImageBean imageInfo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AwardShowcaseBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardShowcaseBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AwardShowcaseBean(parcel.readString(), parcel.readString(), parcel.readInt(), AwardImageBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardShowcaseBean[] newArray(int i) {
            return new AwardShowcaseBean[i];
        }
    }

    public AwardShowcaseBean() {
        this(null, null, 0, null, 15, null);
    }

    public AwardShowcaseBean(@NotNull String str, @NotNull String str2, int i, @NotNull AwardImageBean awardImageBean) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(awardImageBean, "imageInfo");
        this.awardNo = str;
        this.awardName = str2;
        this.awardType = i;
        this.imageInfo = awardImageBean;
    }

    public static /* synthetic */ AwardShowcaseBean copy$default(AwardShowcaseBean awardShowcaseBean, String str, String str2, int i, AwardImageBean awardImageBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = awardShowcaseBean.awardNo;
        }
        if ((i2 & 2) != 0) {
            str2 = awardShowcaseBean.awardName;
        }
        if ((i2 & 4) != 0) {
            i = awardShowcaseBean.awardType;
        }
        if ((i2 & 8) != 0) {
            awardImageBean = awardShowcaseBean.imageInfo;
        }
        return awardShowcaseBean.copy(str, str2, i, awardImageBean);
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

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AwardImageBean getImageInfo() {
        return this.imageInfo;
    }

    @NotNull
    public final AwardShowcaseBean copy(@NotNull String awardNo, @NotNull String awardName, int awardType, @NotNull AwardImageBean imageInfo) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        return new AwardShowcaseBean(awardNo, awardName, awardType, imageInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardShowcaseBean)) {
            return false;
        }
        AwardShowcaseBean awardShowcaseBean = (AwardShowcaseBean) other;
        return Intrinsics.areEqual(this.awardNo, awardShowcaseBean.awardNo) && Intrinsics.areEqual(this.awardName, awardShowcaseBean.awardName) && this.awardType == awardShowcaseBean.awardType && Intrinsics.areEqual(this.imageInfo, awardShowcaseBean.imageInfo);
    }

    @NotNull
    public final String formatImageUrl() {
        return this.imageInfo.getUrl();
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
    public final AwardImageBean getImageInfo() {
        return this.imageInfo;
    }

    public int hashCode() {
        return (((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + Integer.hashCode(this.awardType)) * 31) + this.imageInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AwardShowcaseBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", awardType=" + this.awardType + ", imageInfo=" + this.imageInfo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeInt(this.awardType);
        this.imageInfo.writeToParcel(parcel, flags);
    }

    public /* synthetic */ AwardShowcaseBean(String str, String str2, int i, AwardImageBean awardImageBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new AwardImageBean(null, 0, 0, 0, 15, null) : awardImageBean);
    }
}
