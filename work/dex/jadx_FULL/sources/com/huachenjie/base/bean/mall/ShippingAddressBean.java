package com.huachenjie.base.bean.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.o38;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001J\u0013\u0010?\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\u0006\u0010B\u001a\u00020\u0003J\u0006\u0010C\u001a\u00020\u0003J\u0006\u0010D\u001a\u00020\u0003J\t\u0010E\u001a\u00020>HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020>HÖ\u0001R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001d\"\u0004\b$\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u0006L"}, d2 = {"Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "Landroid/os/Parcelable;", "addressNo", "", "orderAddressNo", "receiverName", "receiverPhone", "provinceCode", "provinceName", "cityCode", "cityName", "districtCode", "districtName", "address", "defaultFlag", "", "isSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAddressNo", "setAddressNo", "getCityCode", "setCityCode", "getCityName", "setCityName", "getDefaultFlag", "()Z", "setDefaultFlag", "(Z)V", "getDistrictCode", "setDistrictCode", "getDistrictName", "setDistrictName", "setSelected", "getOrderAddressNo", "setOrderAddressNo", "getProvinceCode", "setProvinceCode", "getProvinceName", "setProvinceName", "getReceiverName", "setReceiverName", "getReceiverPhone", "setReceiverPhone", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "", "equals", "other", "", "formatCity", "formatPhone", "formatShippingUser", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ShippingAddressBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ShippingAddressBean> CREATOR = new Creator();

    @NotNull
    private String address;

    @NotNull
    private String addressNo;

    @NotNull
    private String cityCode;

    @NotNull
    private String cityName;
    private boolean defaultFlag;

    @NotNull
    private String districtCode;

    @NotNull
    private String districtName;
    private boolean isSelected;

    @NotNull
    private String orderAddressNo;

    @NotNull
    private String provinceCode;

    @NotNull
    private String provinceName;

    @NotNull
    private String receiverName;

    @NotNull
    private String receiverPhone;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ShippingAddressBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShippingAddressBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShippingAddressBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShippingAddressBean[] newArray(int i) {
            return new ShippingAddressBean[i];
        }
    }

    public ShippingAddressBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, false, 8191, null);
    }

    public ShippingAddressBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "addressNo");
        Intrinsics.checkNotNullParameter(str2, "orderAddressNo");
        Intrinsics.checkNotNullParameter(str3, "receiverName");
        Intrinsics.checkNotNullParameter(str4, "receiverPhone");
        Intrinsics.checkNotNullParameter(str5, "provinceCode");
        Intrinsics.checkNotNullParameter(str6, "provinceName");
        Intrinsics.checkNotNullParameter(str7, "cityCode");
        Intrinsics.checkNotNullParameter(str8, "cityName");
        Intrinsics.checkNotNullParameter(str9, "districtCode");
        Intrinsics.checkNotNullParameter(str10, "districtName");
        Intrinsics.checkNotNullParameter(str11, "address");
        this.addressNo = str;
        this.orderAddressNo = str2;
        this.receiverName = str3;
        this.receiverPhone = str4;
        this.provinceCode = str5;
        this.provinceName = str6;
        this.cityCode = str7;
        this.cityName = str8;
        this.districtCode = str9;
        this.districtName = str10;
        this.address = str11;
        this.defaultFlag = z;
        this.isSelected = z2;
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddressNo() {
        return this.addressNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDistrictName() {
        return this.districtName;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getDefaultFlag() {
        return this.defaultFlag;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrderAddressNo() {
        return this.orderAddressNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReceiverName() {
        return this.receiverName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getReceiverPhone() {
        return this.receiverPhone;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProvinceCode() {
        return this.provinceCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getProvinceName() {
        return this.provinceName;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCityCode() {
        return this.cityCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDistrictCode() {
        return this.districtCode;
    }

    @NotNull
    public final ShippingAddressBean copy(@NotNull String addressNo, @NotNull String orderAddressNo, @NotNull String receiverName, @NotNull String receiverPhone, @NotNull String provinceCode, @NotNull String provinceName, @NotNull String cityCode, @NotNull String cityName, @NotNull String districtCode, @NotNull String districtName, @NotNull String address, boolean defaultFlag, boolean isSelected) {
        Intrinsics.checkNotNullParameter(addressNo, "addressNo");
        Intrinsics.checkNotNullParameter(orderAddressNo, "orderAddressNo");
        Intrinsics.checkNotNullParameter(receiverName, "receiverName");
        Intrinsics.checkNotNullParameter(receiverPhone, "receiverPhone");
        Intrinsics.checkNotNullParameter(provinceCode, "provinceCode");
        Intrinsics.checkNotNullParameter(provinceName, "provinceName");
        Intrinsics.checkNotNullParameter(cityCode, "cityCode");
        Intrinsics.checkNotNullParameter(cityName, "cityName");
        Intrinsics.checkNotNullParameter(districtCode, "districtCode");
        Intrinsics.checkNotNullParameter(districtName, "districtName");
        Intrinsics.checkNotNullParameter(address, "address");
        return new ShippingAddressBean(addressNo, orderAddressNo, receiverName, receiverPhone, provinceCode, provinceName, cityCode, cityName, districtCode, districtName, address, defaultFlag, isSelected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShippingAddressBean)) {
            return false;
        }
        ShippingAddressBean shippingAddressBean = (ShippingAddressBean) other;
        return Intrinsics.areEqual(this.addressNo, shippingAddressBean.addressNo) && Intrinsics.areEqual(this.orderAddressNo, shippingAddressBean.orderAddressNo) && Intrinsics.areEqual(this.receiverName, shippingAddressBean.receiverName) && Intrinsics.areEqual(this.receiverPhone, shippingAddressBean.receiverPhone) && Intrinsics.areEqual(this.provinceCode, shippingAddressBean.provinceCode) && Intrinsics.areEqual(this.provinceName, shippingAddressBean.provinceName) && Intrinsics.areEqual(this.cityCode, shippingAddressBean.cityCode) && Intrinsics.areEqual(this.cityName, shippingAddressBean.cityName) && Intrinsics.areEqual(this.districtCode, shippingAddressBean.districtCode) && Intrinsics.areEqual(this.districtName, shippingAddressBean.districtName) && Intrinsics.areEqual(this.address, shippingAddressBean.address) && this.defaultFlag == shippingAddressBean.defaultFlag && this.isSelected == shippingAddressBean.isSelected;
    }

    @NotNull
    public final String formatCity() {
        String str = "";
        if (!TextUtils.isEmpty(this.provinceName)) {
            str = "" + this.provinceName;
        }
        if (!TextUtils.isEmpty(this.cityName)) {
            str = (str + ' ') + this.cityName;
        }
        if (TextUtils.isEmpty(this.districtName)) {
            return str;
        }
        return (str + ' ') + this.districtName;
    }

    @NotNull
    public final String formatPhone() {
        String strB = o38.b(this.receiverPhone);
        Intrinsics.checkNotNullExpressionValue(strB, "getDesensitizationPhone(receiverPhone)");
        return strB;
    }

    @NotNull
    public final String formatShippingUser() {
        return this.receiverName;
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getAddressNo() {
        return this.addressNo;
    }

    @NotNull
    public final String getCityCode() {
        return this.cityCode;
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    public final boolean getDefaultFlag() {
        return this.defaultFlag;
    }

    @NotNull
    public final String getDistrictCode() {
        return this.districtCode;
    }

    @NotNull
    public final String getDistrictName() {
        return this.districtName;
    }

    @NotNull
    public final String getOrderAddressNo() {
        return this.orderAddressNo;
    }

    @NotNull
    public final String getProvinceCode() {
        return this.provinceCode;
    }

    @NotNull
    public final String getProvinceName() {
        return this.provinceName;
    }

    @NotNull
    public final String getReceiverName() {
        return this.receiverName;
    }

    @NotNull
    public final String getReceiverPhone() {
        return this.receiverPhone;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.addressNo.hashCode() * 31) + this.orderAddressNo.hashCode()) * 31) + this.receiverName.hashCode()) * 31) + this.receiverPhone.hashCode()) * 31) + this.provinceCode.hashCode()) * 31) + this.provinceName.hashCode()) * 31) + this.cityCode.hashCode()) * 31) + this.cityName.hashCode()) * 31) + this.districtCode.hashCode()) * 31) + this.districtName.hashCode()) * 31) + this.address.hashCode()) * 31;
        boolean z = this.defaultFlag;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.isSelected;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final void setAddressNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addressNo = str;
    }

    public final void setCityCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityCode = str;
    }

    public final void setCityName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cityName = str;
    }

    public final void setDefaultFlag(boolean z) {
        this.defaultFlag = z;
    }

    public final void setDistrictCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.districtCode = str;
    }

    public final void setDistrictName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.districtName = str;
    }

    public final void setOrderAddressNo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderAddressNo = str;
    }

    public final void setProvinceCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.provinceCode = str;
    }

    public final void setProvinceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.provinceName = str;
    }

    public final void setReceiverName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiverName = str;
    }

    public final void setReceiverPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiverPhone = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @NotNull
    public String toString() {
        return "ShippingAddressBean(addressNo=" + this.addressNo + ", orderAddressNo=" + this.orderAddressNo + ", receiverName=" + this.receiverName + ", receiverPhone=" + this.receiverPhone + ", provinceCode=" + this.provinceCode + ", provinceName=" + this.provinceName + ", cityCode=" + this.cityCode + ", cityName=" + this.cityName + ", districtCode=" + this.districtCode + ", districtName=" + this.districtName + ", address=" + this.address + ", defaultFlag=" + this.defaultFlag + ", isSelected=" + this.isSelected + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.addressNo);
        parcel.writeString(this.orderAddressNo);
        parcel.writeString(this.receiverName);
        parcel.writeString(this.receiverPhone);
        parcel.writeString(this.provinceCode);
        parcel.writeString(this.provinceName);
        parcel.writeString(this.cityCode);
        parcel.writeString(this.cityName);
        parcel.writeString(this.districtCode);
        parcel.writeString(this.districtName);
        parcel.writeString(this.address);
        parcel.writeInt(this.defaultFlag ? 1 : 0);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public /* synthetic */ ShippingAddressBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) == 0 ? str11 : "", (i & 2048) != 0 ? false : z, (i & 4096) == 0 ? z2 : false);
    }
}
