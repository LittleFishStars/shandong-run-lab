package com.huachenjie.im.custom;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.im.custom.base.BaseAttachment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\t\u0010\u0019\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/huachenjie/im/custom/ShareGoodsAttachment;", "Lcom/huachenjie/im/custom/base/BaseAttachment;", "Landroid/os/Parcelable;", "goodsNo", "", "goodsName", "goodsImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGoodsImage", "()Ljava/lang/String;", "getGoodsName", "getGoodsNo", "setGoodsNo", "(Ljava/lang/String;)V", "component1", "component2", "component3", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "getCustomType", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ShareGoodsAttachment extends BaseAttachment implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ShareGoodsAttachment> CREATOR = new Creator();

    @NotNull
    private final String goodsImage;

    @NotNull
    private final String goodsName;

    @NotNull
    private String goodsNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ShareGoodsAttachment> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShareGoodsAttachment createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareGoodsAttachment(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShareGoodsAttachment[] newArray(int i) {
            return new ShareGoodsAttachment[i];
        }
    }

    public ShareGoodsAttachment() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ ShareGoodsAttachment(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ ShareGoodsAttachment copy$default(ShareGoodsAttachment shareGoodsAttachment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareGoodsAttachment.goodsNo;
        }
        if ((i & 2) != 0) {
            str2 = shareGoodsAttachment.goodsName;
        }
        if ((i & 4) != 0) {
            str3 = shareGoodsAttachment.goodsImage;
        }
        return shareGoodsAttachment.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final ShareGoodsAttachment copy(@NotNull String goodsNo, @NotNull String goodsName, @NotNull String goodsImage) {
        Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
        Intrinsics.checkNotNullParameter(goodsName, "goodsName");
        Intrinsics.checkNotNullParameter(goodsImage, "goodsImage");
        return new ShareGoodsAttachment(goodsNo, goodsName, goodsImage);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareGoodsAttachment)) {
            return false;
        }
        ShareGoodsAttachment shareGoodsAttachment = (ShareGoodsAttachment) other;
        return Intrinsics.areEqual(this.goodsNo, shareGoodsAttachment.goodsNo) && Intrinsics.areEqual(this.goodsName, shareGoodsAttachment.goodsName) && Intrinsics.areEqual(this.goodsImage, shareGoodsAttachment.goodsImage);
    }

    @Override // com.huachenjie.im.custom.base.BaseAttachment
    public int getCustomType() {
        return 14;
    }

    @NotNull
    public final String getGoodsImage() {
        return this.goodsImage;
    }

    @NotNull
    public final String getGoodsName() {
        return this.goodsName;
    }

    @NotNull
    public final String getGoodsNo() {
        return this.goodsNo;
    }

    public int hashCode() {
        return (((this.goodsNo.hashCode() * 31) + this.goodsName.hashCode()) * 31) + this.goodsImage.hashCode();
    }

    public final void setGoodsNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsNo = str;
    }

    @NotNull
    public String toString() {
        return "ShareGoodsAttachment(goodsNo=" + this.goodsNo + ", goodsName=" + this.goodsName + ", goodsImage=" + this.goodsImage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.goodsNo);
        parcel.writeString(this.goodsName);
        parcel.writeString(this.goodsImage);
    }

    public ShareGoodsAttachment(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "goodsNo");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "goodsImage");
        this.goodsNo = str;
        this.goodsName = str2;
        this.goodsImage = str3;
    }
}
