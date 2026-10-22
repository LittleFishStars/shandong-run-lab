package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class PluginModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<PluginModel> CREATOR = new Parcelable.Creator<PluginModel>() { // from class: com.alibaba.ariver.resource.api.models.PluginModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginModel createFromParcel(Parcel parcel) {
            return new PluginModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginModel[] newArray(int i) {
            return new PluginModel[i];
        }
    };
    private static final long serialVersionUID = 5268600696037076004L;

    @JSONField
    private String appId;

    @JSONField
    private String appKey;

    @JSONField
    private String developerVersion;

    @JSONField
    private JSONObject extendInfo;

    @JSONField
    private String packageSize;

    @JSONField
    private String packageUrl;

    @JSONField
    private JSONObject permission;

    @JSONField
    private String requireVersion;

    @JSONField(name = "deployVersion")
    private String version;

    public PluginModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getDeveloperVersion() {
        return this.developerVersion;
    }

    public JSONObject getExtendInfo() {
        return this.extendInfo;
    }

    public String getPackageSize() {
        return this.packageSize;
    }

    public String getPackageUrl() {
        return this.packageUrl;
    }

    public JSONObject getPermission() {
        return this.permission;
    }

    public String getRequireVersion() {
        return this.requireVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setDeveloperVersion(String str) {
        this.developerVersion = str;
    }

    public void setExtendInfo(JSONObject jSONObject) {
        this.extendInfo = jSONObject;
    }

    public void setPackageSize(String str) {
        this.packageSize = str;
    }

    public void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public void setPermission(JSONObject jSONObject) {
        this.permission = jSONObject;
    }

    public void setRequireVersion(String str) {
        this.requireVersion = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @JSONField(deserialize = false, serialize = false)
    public AppModel toAppModel() {
        AppModel appModel = new AppModel();
        AppInfoModel appInfoModel = new AppInfoModel();
        appInfoModel.setAppId(this.appId);
        appInfoModel.setVersion(this.version);
        appInfoModel.setDeveloperVersion(this.developerVersion);
        appInfoModel.setPackageUrl(this.packageUrl);
        appInfoModel.setPackageSize(this.packageSize);
        appInfoModel.setAppKey(this.appKey);
        appModel.setAppInfoModel(appInfoModel);
        appModel.setPermissionModel(PermissionModel.generateFromJSON(this.permission));
        return appModel;
    }

    public String toString() {
        return "PluginModel{appId='" + this.appId + "', appKey='" + this.appKey + "', packageUrl='" + this.packageUrl + "', developerVersion='" + this.developerVersion + "', requireVersion='" + this.requireVersion + "', version='" + this.version + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appKey);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.packageSize);
        parcel.writeString(this.developerVersion);
        parcel.writeString(this.requireVersion);
        parcel.writeString(this.version);
        byte[] bArrMarshallJSONObject = JSONUtils.marshallJSONObject(this.permission);
        int length = bArrMarshallJSONObject == null ? 0 : bArrMarshallJSONObject.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(bArrMarshallJSONObject);
        }
        byte[] bArrMarshallJSONObject2 = JSONUtils.marshallJSONObject(this.extendInfo);
        int length2 = bArrMarshallJSONObject2 != null ? bArrMarshallJSONObject2.length : 0;
        parcel.writeInt(length2);
        if (length2 > 0) {
            parcel.writeByteArray(bArrMarshallJSONObject2);
        }
    }

    public PluginModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.appKey = parcel.readString();
        this.packageUrl = parcel.readString();
        this.packageSize = parcel.readString();
        this.developerVersion = parcel.readString();
        this.requireVersion = parcel.readString();
        this.version = parcel.readString();
        int i = parcel.readInt();
        if (i > 0) {
            byte[] buf = IOUtils.getBuf(i);
            parcel.readByteArray(buf);
            this.permission = JSONUtils.unmarshallJSONObject(buf);
        }
        int i2 = parcel.readInt();
        if (i2 > 0) {
            byte[] buf2 = IOUtils.getBuf(i2);
            parcel.readByteArray(buf2);
            this.extendInfo = JSONUtils.unmarshallJSONObject(buf2);
        }
    }
}
