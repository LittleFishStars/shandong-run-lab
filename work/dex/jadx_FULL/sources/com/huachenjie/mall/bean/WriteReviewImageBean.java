package com.huachenjie.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mall/bean/WriteReviewImageBean;", "Landroid/os/Parcelable;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "imagePath", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "getImageUrl", "setImageUrl", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class WriteReviewImageBean implements Parcelable, MultiItemEntity {

    @NotNull
    public static final Parcelable.Creator<WriteReviewImageBean> CREATOR = new Creator();

    @NotNull
    private String imagePath;

    @NotNull
    private String imageUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WriteReviewImageBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WriteReviewImageBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WriteReviewImageBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final WriteReviewImageBean[] newArray(int i) {
            return new WriteReviewImageBean[i];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WriteReviewImageBean() {
        String str = null;
        this(str, str, 3, str);
    }

    public WriteReviewImageBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "imagePath");
        Intrinsics.checkNotNullParameter(str2, "imageUrl");
        this.imagePath = str;
        this.imageUrl = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int getItemType() {
        return 0;
    }

    public final void setImagePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imagePath = str;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.imagePath);
        parcel.writeString(this.imageUrl);
    }

    public /* synthetic */ WriteReviewImageBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
