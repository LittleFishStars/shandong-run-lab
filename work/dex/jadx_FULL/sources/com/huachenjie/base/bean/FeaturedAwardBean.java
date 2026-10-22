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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/huachenjie/base/bean/FeaturedAwardBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "imgUrl", "awardType", "awardLinkNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAwardLinkNo", "()Ljava/lang/String;", "getAwardName", "getAwardNo", "getAwardType", "getImgUrl", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FeaturedAwardBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FeaturedAwardBean> CREATOR = new Creator();

    @NotNull
    private final String awardLinkNo;

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;

    @NotNull
    private final String awardType;

    @NotNull
    private final String imgUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FeaturedAwardBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FeaturedAwardBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeaturedAwardBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FeaturedAwardBean[] newArray(int i) {
            return new FeaturedAwardBean[i];
        }
    }

    public FeaturedAwardBean() {
        this(null, null, null, null, null, 31, null);
    }

    public FeaturedAwardBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(str3, "imgUrl");
        Intrinsics.checkNotNullParameter(str4, "awardType");
        Intrinsics.checkNotNullParameter(str5, "awardLinkNo");
        this.awardNo = str;
        this.awardName = str2;
        this.imgUrl = str3;
        this.awardType = str4;
        this.awardLinkNo = str5;
    }

    public static /* synthetic */ FeaturedAwardBean copy$default(FeaturedAwardBean featuredAwardBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = featuredAwardBean.awardNo;
        }
        if ((i & 2) != 0) {
            str2 = featuredAwardBean.awardName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = featuredAwardBean.imgUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = featuredAwardBean.awardType;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = featuredAwardBean.awardLinkNo;
        }
        return featuredAwardBean.copy(str, str6, str7, str8, str5);
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

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAwardType() {
        return this.awardType;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAwardLinkNo() {
        return this.awardLinkNo;
    }

    @NotNull
    public final FeaturedAwardBean copy(@NotNull String awardNo, @NotNull String awardName, @NotNull String imgUrl, @NotNull String awardType, @NotNull String awardLinkNo) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(awardType, "awardType");
        Intrinsics.checkNotNullParameter(awardLinkNo, "awardLinkNo");
        return new FeaturedAwardBean(awardNo, awardName, imgUrl, awardType, awardLinkNo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeaturedAwardBean)) {
            return false;
        }
        FeaturedAwardBean featuredAwardBean = (FeaturedAwardBean) other;
        return Intrinsics.areEqual(this.awardNo, featuredAwardBean.awardNo) && Intrinsics.areEqual(this.awardName, featuredAwardBean.awardName) && Intrinsics.areEqual(this.imgUrl, featuredAwardBean.imgUrl) && Intrinsics.areEqual(this.awardType, featuredAwardBean.awardType) && Intrinsics.areEqual(this.awardLinkNo, featuredAwardBean.awardLinkNo);
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

    @NotNull
    public final String getAwardType() {
        return this.awardType;
    }

    @NotNull
    public final String getImgUrl() {
        return this.imgUrl;
    }

    public int hashCode() {
        return (((((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + this.awardType.hashCode()) * 31) + this.awardLinkNo.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeaturedAwardBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", imgUrl=" + this.imgUrl + ", awardType=" + this.awardType + ", awardLinkNo=" + this.awardLinkNo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.awardType);
        parcel.writeString(this.awardLinkNo);
    }

    public /* synthetic */ FeaturedAwardBean(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }
}
