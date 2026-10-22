package com.alibaba.ariver.engine.api.bridge.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateParams implements Parcelable {
    public static final Parcelable.Creator<CreateParams> CREATOR = new Parcelable.Creator<CreateParams>() { // from class: com.alibaba.ariver.engine.api.bridge.model.CreateParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateParams createFromParcel(Parcel parcel) {
            return new CreateParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CreateParams[] newArray(int i) {
            return new CreateParams[i];
        }
    };
    public int containerHeight;
    public int containerWidth;
    public String createUrl;
    public ArrayList<String> resourceUrls;
    public Bundle startParams;
    public URLVisitListener urlVisitListener;
    public boolean useForEmbed;

    public CreateParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.startParams);
        parcel.writeString(this.createUrl);
        parcel.writeInt(this.containerWidth);
        parcel.writeInt(this.containerHeight);
        parcel.writeByte(this.useForEmbed ? (byte) 1 : (byte) 0);
        parcel.writeList(this.resourceUrls);
    }

    public CreateParams(Parcel parcel) {
        this.startParams = parcel.readBundle(CreateParams.class.getClassLoader());
        this.createUrl = parcel.readString();
        this.containerWidth = parcel.readInt();
        this.containerHeight = parcel.readInt();
        this.useForEmbed = parcel.readByte() != 0;
        this.resourceUrls = parcel.readArrayList(String.class.getClassLoader());
    }
}
