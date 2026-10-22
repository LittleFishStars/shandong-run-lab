package com.huachenjie.compat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class KeyNameInfo implements Parcelable {
    public static final Parcelable.Creator<KeyNameInfo> CREATOR = new Parcelable.Creator<KeyNameInfo>() { // from class: com.huachenjie.compat.bean.KeyNameInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyNameInfo createFromParcel(Parcel parcel) {
            return new KeyNameInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeyNameInfo[] newArray(int i) {
            return new KeyNameInfo[i];
        }
    };
    ArrayList<KeyNameInfo> children;
    String key;
    String name;

    public KeyNameInfo() {
        this.key = "";
        this.name = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<KeyNameInfo> getChildren() {
        return this.children;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public void setChildren(ArrayList<KeyNameInfo> arrayList) {
        this.children = arrayList;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeTypedList(this.children);
    }

    public KeyNameInfo(Parcel parcel) {
        this.key = "";
        this.name = "";
        this.key = parcel.readString();
        this.name = parcel.readString();
        this.children = parcel.createTypedArrayList(CREATOR);
    }
}
