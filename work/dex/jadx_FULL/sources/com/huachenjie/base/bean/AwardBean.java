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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006("}, d2 = {"Lcom/huachenjie/base/bean/AwardBean;", "Landroid/os/Parcelable;", "awardNo", "", "awardName", "imgUrl", "awardType", "", "price", "", "stock", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;)V", "getAwardName", "()Ljava/lang/String;", "getAwardNo", "getAwardType", "()I", "getImgUrl", "getPrice", "()F", "getStock", "component1", "component2", "component3", "component4", "component5", "component6", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AwardBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AwardBean> CREATOR = new Creator();

    @NotNull
    private final String awardName;

    @NotNull
    private final String awardNo;
    private final int awardType;

    @NotNull
    private final String imgUrl;
    private final float price;

    @NotNull
    private final String stock;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AwardBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AwardBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readFloat(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AwardBean[] newArray(int i) {
            return new AwardBean[i];
        }
    }

    public AwardBean() {
        this(null, null, null, 0, 0.0f, null, 63, null);
    }

    public AwardBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, float f, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "awardNo");
        Intrinsics.checkNotNullParameter(str2, "awardName");
        Intrinsics.checkNotNullParameter(str3, "imgUrl");
        Intrinsics.checkNotNullParameter(str4, "stock");
        this.awardNo = str;
        this.awardName = str2;
        this.imgUrl = str3;
        this.awardType = i;
        this.price = f;
        this.stock = str4;
    }

    public static /* synthetic */ AwardBean copy$default(AwardBean awardBean, String str, String str2, String str3, int i, float f, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = awardBean.awardNo;
        }
        if ((i2 & 2) != 0) {
            str2 = awardBean.awardName;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = awardBean.imgUrl;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            i = awardBean.awardType;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            f = awardBean.price;
        }
        float f2 = f;
        if ((i2 & 32) != 0) {
            str4 = awardBean.stock;
        }
        return awardBean.copy(str, str5, str6, i3, f2, str4);
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getPrice() {
        return this.price;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStock() {
        return this.stock;
    }

    @NotNull
    public final AwardBean copy(@NotNull String awardNo, @NotNull String awardName, @NotNull String imgUrl, int awardType, float price, @NotNull String stock) {
        Intrinsics.checkNotNullParameter(awardNo, "awardNo");
        Intrinsics.checkNotNullParameter(awardName, "awardName");
        Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
        Intrinsics.checkNotNullParameter(stock, "stock");
        return new AwardBean(awardNo, awardName, imgUrl, awardType, price, stock);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardBean)) {
            return false;
        }
        AwardBean awardBean = (AwardBean) other;
        return Intrinsics.areEqual(this.awardNo, awardBean.awardNo) && Intrinsics.areEqual(this.awardName, awardBean.awardName) && Intrinsics.areEqual(this.imgUrl, awardBean.imgUrl) && this.awardType == awardBean.awardType && Float.compare(this.price, awardBean.price) == 0 && Intrinsics.areEqual(this.stock, awardBean.stock);
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

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getStock() {
        return this.stock;
    }

    public int hashCode() {
        return (((((((((this.awardNo.hashCode() * 31) + this.awardName.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + Integer.hashCode(this.awardType)) * 31) + Float.hashCode(this.price)) * 31) + this.stock.hashCode();
    }

    @NotNull
    public String toString() {
        return "AwardBean(awardNo=" + this.awardNo + ", awardName=" + this.awardName + ", imgUrl=" + this.imgUrl + ", awardType=" + this.awardType + ", price=" + this.price + ", stock=" + this.stock + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.awardNo);
        parcel.writeString(this.awardName);
        parcel.writeString(this.imgUrl);
        parcel.writeInt(this.awardType);
        parcel.writeFloat(this.price);
        parcel.writeString(this.stock);
    }

    public /* synthetic */ AwardBean(String str, String str2, String str3, int i, float f, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? 0.0f : f, (i2 & 32) != 0 ? "" : str4);
    }
}
