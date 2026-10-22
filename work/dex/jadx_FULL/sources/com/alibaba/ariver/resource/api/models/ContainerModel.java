package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ContainerModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<ContainerModel> CREATOR = new Parcelable.Creator<ContainerModel>() { // from class: com.alibaba.ariver.resource.api.models.ContainerModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContainerModel createFromParcel(Parcel parcel) {
            return new ContainerModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContainerModel[] newArray(int i) {
            return new ContainerModel[i];
        }
    };
    private static final long serialVersionUID = 4709959887517039667L;

    @JSONField
    private int downloadType;

    @JSONField
    private JSONObject launchParams;

    public ContainerModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    @Nullable
    public JSONObject getLaunchParams() {
        return this.launchParams;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public void setLaunchParams(JSONObject jSONObject) {
        this.launchParams = jSONObject;
    }

    public String toString() {
        return "ContainerModel{launchParams=" + this.launchParams + ", downloadType=" + this.downloadType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.launchParams);
        parcel.writeInt(this.downloadType);
    }

    public ContainerModel(Parcel parcel) {
        this.launchParams = (JSONObject) parcel.readSerializable();
        this.downloadType = parcel.readInt();
    }
}
