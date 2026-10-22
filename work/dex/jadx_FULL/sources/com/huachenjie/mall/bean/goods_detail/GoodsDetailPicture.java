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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\""}, d2 = {"Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailPicture;", "Landroid/os/Parcelable;", "url", "", "width", "", "height", "positionType", "(Ljava/lang/String;III)V", "getHeight", "()I", "getPositionType", "setPositionType", "(I)V", "getUrl", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GoodsDetailPicture implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GoodsDetailPicture> CREATOR = new Creator();
    private final int height;
    private int positionType;

    @NotNull
    private final String url;
    private final int width;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodsDetailPicture> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailPicture createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoodsDetailPicture(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GoodsDetailPicture[] newArray(int i) {
            return new GoodsDetailPicture[i];
        }
    }

    public GoodsDetailPicture() {
        this(null, 0, 0, 0, 15, null);
    }

    public GoodsDetailPicture(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.width = i;
        this.height = i2;
        this.positionType = i3;
    }

    public static /* synthetic */ GoodsDetailPicture copy$default(GoodsDetailPicture goodsDetailPicture, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = goodsDetailPicture.url;
        }
        if ((i4 & 2) != 0) {
            i = goodsDetailPicture.width;
        }
        if ((i4 & 4) != 0) {
            i2 = goodsDetailPicture.height;
        }
        if ((i4 & 8) != 0) {
            i3 = goodsDetailPicture.positionType;
        }
        return goodsDetailPicture.copy(str, i, i2, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPositionType() {
        return this.positionType;
    }

    @NotNull
    public final GoodsDetailPicture copy(@NotNull String url, int width, int height, int positionType) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new GoodsDetailPicture(url, width, height, positionType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoodsDetailPicture)) {
            return false;
        }
        GoodsDetailPicture goodsDetailPicture = (GoodsDetailPicture) other;
        return Intrinsics.areEqual(this.url, goodsDetailPicture.url) && this.width == goodsDetailPicture.width && this.height == goodsDetailPicture.height && this.positionType == goodsDetailPicture.positionType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getPositionType() {
        return this.positionType;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.positionType);
    }

    public final void setPositionType(int i) {
        this.positionType = i;
    }

    @NotNull
    public String toString() {
        return "GoodsDetailPicture(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", positionType=" + this.positionType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.positionType);
    }

    public /* synthetic */ GoodsDetailPicture(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
