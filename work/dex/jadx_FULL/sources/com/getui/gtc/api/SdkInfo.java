package com.getui.gtc.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.getui.gtc.entity.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SdkInfo implements Parcelable {
    public static final Parcelable.Creator<SdkInfo> CREATOR = new Parcelable.Creator<SdkInfo>() { // from class: com.getui.gtc.api.SdkInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkInfo createFromParcel(Parcel parcel) {
            return new SdkInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkInfo[] newArray(int i) {
            return new SdkInfo[i];
        }
    };
    private String appid;
    private String cid;
    private String moduleName;
    private String psUrl;
    private List<a.C0657a> stubs;
    private String version;

    public static class Builder {
        private String appid;
        private String cid;
        private String moduleName;
        private String psUrl;
        private List<a.C0657a> stubs = new ArrayList();
        private String version;

        public Builder addStub(String str, boolean z) {
            a.C0657a c0657a = new a.C0657a();
            c0657a.d = str;
            c0657a.j = z;
            this.stubs.add(c0657a);
            return this;
        }

        public Builder appid(String str) {
            this.appid = str;
            return this;
        }

        public SdkInfo build() {
            return new SdkInfo(this);
        }

        public Builder cid(String str) {
            this.cid = str;
            return this;
        }

        public Builder moduleName(String str) {
            this.moduleName = str;
            return this;
        }

        public Builder psUrl(String str) {
            this.psUrl = str;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }
    }

    public SdkInfo(Parcel parcel) {
        this.moduleName = parcel.readString();
        this.version = parcel.readString();
        this.appid = parcel.readString();
        this.cid = parcel.readString();
        this.psUrl = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.stubs = arrayList;
        parcel.readTypedList(arrayList, a.C0657a.CREATOR);
    }

    public SdkInfo(Builder builder) {
        this.moduleName = builder.moduleName;
        this.version = builder.version;
        this.appid = builder.appid;
        this.cid = builder.cid;
        this.psUrl = builder.psUrl;
        ArrayList arrayList = new ArrayList();
        this.stubs = arrayList;
        arrayList.addAll(builder.stubs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getCid() {
        return this.cid;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getPsUrl() {
        return this.psUrl;
    }

    public List<a.C0657a> getStubs() {
        return this.stubs;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setPsUrl(String str) {
        this.psUrl = str;
    }

    public void setStubs(List<a.C0657a> list) {
        this.stubs = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.moduleName);
        parcel.writeString(this.version);
        parcel.writeString(this.appid);
        parcel.writeString(this.cid);
        parcel.writeString(this.psUrl);
        parcel.writeTypedList(this.stubs);
    }
}
