package com.huachenjie.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\bHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Landroid/os/Parcelable;", "shipperName", "", "shipperCode", "(Ljava/lang/String;Ljava/lang/String;)V", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "getShipperCode", "()Ljava/lang/String;", "getShipperName", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpressCompanyBean implements MultiItemEntity, Parcelable {
    public static final int TYPE_EXPRESS_COMPANY = 0;
    public static final int TYPE_EXPRESS_TITLE = 1;

    @NotNull
    private final String shipperCode;

    @NotNull
    private final String shipperName;

    @NotNull
    public static final Parcelable.Creator<ExpressCompanyBean> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExpressCompanyBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExpressCompanyBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExpressCompanyBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExpressCompanyBean[] newArray(int i) {
            return new ExpressCompanyBean[i];
        }
    }

    public ExpressCompanyBean(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "shipperName");
        Intrinsics.checkNotNullParameter(str2, "shipperCode");
        this.shipperName = str;
        this.shipperCode = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return StringsKt.isBlank(this.shipperCode) ? 1 : 0;
    }

    @NotNull
    public final String getShipperCode() {
        return this.shipperCode;
    }

    @NotNull
    public final String getShipperName() {
        return this.shipperName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.shipperName);
        parcel.writeString(this.shipperCode);
    }

    public /* synthetic */ ExpressCompanyBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }
}
