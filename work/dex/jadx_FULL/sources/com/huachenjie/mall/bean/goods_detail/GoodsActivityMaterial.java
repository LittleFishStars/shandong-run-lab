package com.huachenjie.mall.bean.goods_detail;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsActivityMaterial;", "Landroid/os/Parcelable;", "materialType", "", "name", "", "picUrl", "(ILjava/lang/String;Ljava/lang/String;)V", "getMaterialType", "()I", "getName", "()Ljava/lang/String;", "getPicUrl", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsActivityMaterial implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsActivityMaterial> CREATOR = new Creator();
    private final int materialType;

    @NotNull
    private final String name;

    @NotNull
    private final String picUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsActivityMaterial> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsActivityMaterial createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsActivityMaterial(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsActivityMaterial[] newArray(int i) {
            return new GoodsActivityMaterial[i];
        }
    }

    public GoodsActivityMaterial() {
        this(0, null, null, 7, null);
    }

    public GoodsActivityMaterial(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "picUrl");
        this.materialType = i;
        this.name = str;
        this.picUrl = str2;
    }

    public static /* synthetic */ GoodsActivityMaterial copy$default(GoodsActivityMaterial goodsActivityMaterial, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = goodsActivityMaterial.materialType;
        }
        if ((i2 & 2) != 0) {
            str = goodsActivityMaterial.name;
        }
        if ((i2 & 4) != 0) {
            str2 = goodsActivityMaterial.picUrl;
        }
        return goodsActivityMaterial.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMaterialType() {
        return this.materialType;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final GoodsActivityMaterial copy(int materialType, @NotNull String name, @NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new GoodsActivityMaterial(materialType, name, picUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsActivityMaterial)) {
            return false;
        }
        GoodsActivityMaterial goodsActivityMaterial = (GoodsActivityMaterial) other;
        return this.materialType == goodsActivityMaterial.materialType && Intrinsics.areEqual(this.name, goodsActivityMaterial.name) && Intrinsics.areEqual(this.picUrl, goodsActivityMaterial.picUrl);
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.materialType) * 31) + this.name.hashCode()) * 31) + this.picUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "GoodsActivityMaterial(materialType=" + this.materialType + ", name=" + this.name + ", picUrl=" + this.picUrl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.materialType);
        parcel.writeString(this.name);
        parcel.writeString(this.picUrl);
    }

    public /* synthetic */ GoodsActivityMaterial(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
