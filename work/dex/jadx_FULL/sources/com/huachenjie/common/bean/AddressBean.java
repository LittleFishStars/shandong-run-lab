package com.huachenjie.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AddressBean implements Parcelable {
    public static final Parcelable.Creator<AddressBean> CREATOR = new Parcelable.Creator<AddressBean>() { // from class: com.huachenjie.common.bean.AddressBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressBean createFromParcel(Parcel in) {
            return new AddressBean(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };
    public String cityCode;
    public String cityName;
    public String detailAddress;
    public String districtCode;
    public String districtName;
    public String provinceCode;
    public String provinceName;

    public AddressBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getDetailAddress() {
        return this.detailAddress;
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public String getStudentAddress() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.provinceName)) {
            stringBuffer.append(this.provinceName);
        }
        if (!TextUtils.isEmpty(this.cityName)) {
            stringBuffer.append(this.cityName);
        }
        if (!TextUtils.isEmpty(this.districtName)) {
            stringBuffer.append(this.districtName);
        }
        if (!TextUtils.isEmpty(this.detailAddress)) {
            stringBuffer.append(this.detailAddress);
        }
        return stringBuffer.toString();
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.detailAddress);
        dest.writeString(this.provinceCode);
        dest.writeString(this.provinceName);
        dest.writeString(this.cityCode);
        dest.writeString(this.cityName);
        dest.writeString(this.districtCode);
        dest.writeString(this.districtName);
    }

    public AddressBean(Parcel in) {
        this.detailAddress = in.readString();
        this.provinceCode = in.readString();
        this.provinceName = in.readString();
        this.cityCode = in.readString();
        this.cityName = in.readString();
        this.districtCode = in.readString();
        this.districtName = in.readString();
    }
}
