package com.huachenjie.social_contact.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\rHÆ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\u0013\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00069"}, d2 = {"Lcom/huachenjie/social_contact/bean/SuitBean;", "Landroid/os/Parcelable;", "metaverseSuitCode", "", "partName", "partDescription", "freeFlag", "", "sellingRemak", "crystalValue", "starDrill", "skinVoucher", "haveFlag", "", "img", "checkedFlag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIZLjava/lang/String;Z)V", "getCheckedFlag", "()Z", "setCheckedFlag", "(Z)V", "getCrystalValue", "()I", "getFreeFlag", "getHaveFlag", "setHaveFlag", "getImg", "()Ljava/lang/String;", "getMetaverseSuitCode", "getPartDescription", "getPartName", "getSellingRemak", "getSkinVoucher", "getStarDrill", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SuitBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SuitBean> CREATOR = new Creator();
    private boolean checkedFlag;
    private final int crystalValue;
    private final int freeFlag;
    private boolean haveFlag;

    @NotNull
    private final String img;

    @NotNull
    private final String metaverseSuitCode;

    @NotNull
    private final String partDescription;

    @NotNull
    private final String partName;

    @NotNull
    private final String sellingRemak;
    private final int skinVoucher;
    private final int starDrill;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SuitBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuitBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SuitBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuitBean[] newArray(int i) {
            return new SuitBean[i];
        }
    }

    public SuitBean(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2, int i3, int i4, boolean z, @NotNull String str5, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "metaverseSuitCode");
        Intrinsics.checkNotNullParameter(str2, "partName");
        Intrinsics.checkNotNullParameter(str3, "partDescription");
        Intrinsics.checkNotNullParameter(str4, "sellingRemak");
        Intrinsics.checkNotNullParameter(str5, "img");
        this.metaverseSuitCode = str;
        this.partName = str2;
        this.partDescription = str3;
        this.freeFlag = i;
        this.sellingRemak = str4;
        this.crystalValue = i2;
        this.starDrill = i3;
        this.skinVoucher = i4;
        this.haveFlag = z;
        this.img = str5;
        this.checkedFlag = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMetaverseSuitCode() {
        return this.metaverseSuitCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getImg() {
        return this.img;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCheckedFlag() {
        return this.checkedFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPartName() {
        return this.partName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPartDescription() {
        return this.partDescription;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFreeFlag() {
        return this.freeFlag;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSellingRemak() {
        return this.sellingRemak;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getCrystalValue() {
        return this.crystalValue;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStarDrill() {
        return this.starDrill;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getHaveFlag() {
        return this.haveFlag;
    }

    @NotNull
    public final SuitBean copy(@NotNull String metaverseSuitCode, @NotNull String partName, @NotNull String partDescription, int freeFlag, @NotNull String sellingRemak, int crystalValue, int starDrill, int skinVoucher, boolean haveFlag, @NotNull String img, boolean checkedFlag) {
        Intrinsics.checkNotNullParameter(metaverseSuitCode, "metaverseSuitCode");
        Intrinsics.checkNotNullParameter(partName, "partName");
        Intrinsics.checkNotNullParameter(partDescription, "partDescription");
        Intrinsics.checkNotNullParameter(sellingRemak, "sellingRemak");
        Intrinsics.checkNotNullParameter(img, "img");
        return new SuitBean(metaverseSuitCode, partName, partDescription, freeFlag, sellingRemak, crystalValue, starDrill, skinVoucher, haveFlag, img, checkedFlag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuitBean)) {
            return false;
        }
        SuitBean suitBean = (SuitBean) other;
        return Intrinsics.areEqual(this.metaverseSuitCode, suitBean.metaverseSuitCode) && Intrinsics.areEqual(this.partName, suitBean.partName) && Intrinsics.areEqual(this.partDescription, suitBean.partDescription) && this.freeFlag == suitBean.freeFlag && Intrinsics.areEqual(this.sellingRemak, suitBean.sellingRemak) && this.crystalValue == suitBean.crystalValue && this.starDrill == suitBean.starDrill && this.skinVoucher == suitBean.skinVoucher && this.haveFlag == suitBean.haveFlag && Intrinsics.areEqual(this.img, suitBean.img) && this.checkedFlag == suitBean.checkedFlag;
    }

    public final boolean getCheckedFlag() {
        return this.checkedFlag;
    }

    public final int getCrystalValue() {
        return this.crystalValue;
    }

    public final int getFreeFlag() {
        return this.freeFlag;
    }

    public final boolean getHaveFlag() {
        return this.haveFlag;
    }

    @NotNull
    public final String getImg() {
        return this.img;
    }

    @NotNull
    public final String getMetaverseSuitCode() {
        return this.metaverseSuitCode;
    }

    @NotNull
    public final String getPartDescription() {
        return this.partDescription;
    }

    @NotNull
    public final String getPartName() {
        return this.partName;
    }

    @NotNull
    public final String getSellingRemak() {
        return this.sellingRemak;
    }

    public final int getSkinVoucher() {
        return this.skinVoucher;
    }

    public final int getStarDrill() {
        return this.starDrill;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((this.metaverseSuitCode.hashCode() * 31) + this.partName.hashCode()) * 31) + this.partDescription.hashCode()) * 31) + Integer.hashCode(this.freeFlag)) * 31) + this.sellingRemak.hashCode()) * 31) + Integer.hashCode(this.crystalValue)) * 31) + Integer.hashCode(this.starDrill)) * 31) + Integer.hashCode(this.skinVoucher)) * 31;
        boolean z = this.haveFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.img.hashCode()) * 31;
        boolean z2 = this.checkedFlag;
        return iHashCode2 + (z2 ? 1 : z2);
    }

    public final void setCheckedFlag(boolean z) {
        this.checkedFlag = z;
    }

    public final void setHaveFlag(boolean z) {
        this.haveFlag = z;
    }

    @NotNull
    public String toString() {
        return "SuitBean(metaverseSuitCode=" + this.metaverseSuitCode + ", partName=" + this.partName + ", partDescription=" + this.partDescription + ", freeFlag=" + this.freeFlag + ", sellingRemak=" + this.sellingRemak + ", crystalValue=" + this.crystalValue + ", starDrill=" + this.starDrill + ", skinVoucher=" + this.skinVoucher + ", haveFlag=" + this.haveFlag + ", img=" + this.img + ", checkedFlag=" + this.checkedFlag + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.metaverseSuitCode);
        parcel.writeString(this.partName);
        parcel.writeString(this.partDescription);
        parcel.writeInt(this.freeFlag);
        parcel.writeString(this.sellingRemak);
        parcel.writeInt(this.crystalValue);
        parcel.writeInt(this.starDrill);
        parcel.writeInt(this.skinVoucher);
        parcel.writeInt(this.haveFlag ? 1 : 0);
        parcel.writeString(this.img);
        parcel.writeInt(this.checkedFlag ? 1 : 0);
    }
}
