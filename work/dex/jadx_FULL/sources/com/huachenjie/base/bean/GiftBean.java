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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006*"}, d2 = {"Lcom/huachenjie/base/bean/GiftBean;", "Landroid/os/Parcelable;", "giftImg", "", "giftType", "", "giftName", "giftCount", "geneType", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getGeneType", "()Ljava/lang/String;", "setGeneType", "(Ljava/lang/String;)V", "getGiftCount", "()I", "setGiftCount", "(I)V", "getGiftImg", "setGiftImg", "getGiftName", "setGiftName", "getGiftType", "setGiftType", "component1", "component2", "component3", "component4", "component5", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GiftBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GiftBean> CREATOR = new Creator();

    @NotNull
    private String geneType;
    private int giftCount;

    @NotNull
    private String giftImg;

    @NotNull
    private String giftName;
    private int giftType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GiftBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GiftBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GiftBean(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GiftBean[] newArray(int i) {
            return new GiftBean[i];
        }
    }

    public GiftBean() {
        this(null, 0, null, 0, null, 31, null);
    }

    public GiftBean(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "giftImg");
        Intrinsics.checkNotNullParameter(str2, "giftName");
        Intrinsics.checkNotNullParameter(str3, "geneType");
        this.giftImg = str;
        this.giftType = i;
        this.giftName = str2;
        this.giftCount = i2;
        this.geneType = str3;
    }

    public static /* synthetic */ GiftBean copy$default(GiftBean giftBean, String str, int i, String str2, int i2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = giftBean.giftImg;
        }
        if ((i3 & 2) != 0) {
            i = giftBean.giftType;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = giftBean.giftName;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i2 = giftBean.giftCount;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str3 = giftBean.geneType;
        }
        return giftBean.copy(str, i4, str4, i5, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGiftImg() {
        return this.giftImg;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGiftType() {
        return this.giftType;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGiftName() {
        return this.giftName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getGiftCount() {
        return this.giftCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGeneType() {
        return this.geneType;
    }

    @NotNull
    public final GiftBean copy(@NotNull String giftImg, int giftType, @NotNull String giftName, int giftCount, @NotNull String geneType) {
        Intrinsics.checkNotNullParameter(giftImg, "giftImg");
        Intrinsics.checkNotNullParameter(giftName, "giftName");
        Intrinsics.checkNotNullParameter(geneType, "geneType");
        return new GiftBean(giftImg, giftType, giftName, giftCount, geneType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftBean)) {
            return false;
        }
        GiftBean giftBean = (GiftBean) other;
        return Intrinsics.areEqual(this.giftImg, giftBean.giftImg) && this.giftType == giftBean.giftType && Intrinsics.areEqual(this.giftName, giftBean.giftName) && this.giftCount == giftBean.giftCount && Intrinsics.areEqual(this.geneType, giftBean.geneType);
    }

    @NotNull
    public final String getGeneType() {
        return this.geneType;
    }

    public final int getGiftCount() {
        return this.giftCount;
    }

    @NotNull
    public final String getGiftImg() {
        return this.giftImg;
    }

    @NotNull
    public final String getGiftName() {
        return this.giftName;
    }

    public final int getGiftType() {
        return this.giftType;
    }

    public int hashCode() {
        return (((((((this.giftImg.hashCode() * 31) + Integer.hashCode(this.giftType)) * 31) + this.giftName.hashCode()) * 31) + Integer.hashCode(this.giftCount)) * 31) + this.geneType.hashCode();
    }

    public final void setGeneType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.geneType = str;
    }

    public final void setGiftCount(int i) {
        this.giftCount = i;
    }

    public final void setGiftImg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftImg = str;
    }

    public final void setGiftName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.giftName = str;
    }

    public final void setGiftType(int i) {
        this.giftType = i;
    }

    @NotNull
    public String toString() {
        return "GiftBean(giftImg=" + this.giftImg + ", giftType=" + this.giftType + ", giftName=" + this.giftName + ", giftCount=" + this.giftCount + ", geneType=" + this.geneType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.giftImg);
        parcel.writeInt(this.giftType);
        parcel.writeString(this.giftName);
        parcel.writeInt(this.giftCount);
        parcel.writeString(this.geneType);
    }

    public /* synthetic */ GiftBean(String str, int i, String str2, int i2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str3);
    }
}
