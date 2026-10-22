package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.huawei.hms.push.AttributionReporter;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppModel implements Parcelable, Serializable {

    @JSONField(serialize = false)
    public static final Comparator<AppModel> COMPARATOR = new Comparator<AppModel>() { // from class: com.alibaba.ariver.resource.api.models.AppModel.1
        @Override // java.util.Comparator
        public int compare(AppModel appModel, AppModel appModel2) {
            if (appModel == null) {
                return appModel2 == null ? 0 : -1;
            }
            if (appModel2 == null) {
                return 1;
            }
            return RVResourceUtils.compareVersion(appModel.getAppVersion(), appModel2.getAppVersion());
        }
    };
    public static final Parcelable.Creator<AppModel> CREATOR = new Parcelable.Creator<AppModel>() { // from class: com.alibaba.ariver.resource.api.models.AppModel.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppModel createFromParcel(Parcel parcel) {
            return new AppModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppModel[] newArray(int i) {
            return new AppModel[i];
        }
    };
    private static final long serialVersionUID = 435160091756780155L;

    @JSONField(serialize = false)
    private String appId;

    @JSONField(name = "appInfo")
    private AppInfoModel appInfoModel;

    @JSONField(serialize = false)
    private String appVersion;

    @JSONField(name = "container")
    private ContainerModel containerInfo;

    @JSONField(name = "extendInfo")
    private JSONObject extendInfos;

    @JSONField(name = AttributionReporter.SYSTEM_PERMISSION)
    private PermissionModel permissionModel;

    public AppModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public AppInfoModel getAppInfoModel() {
        return this.appInfoModel;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public ContainerModel getContainerInfo() {
        return this.containerInfo;
    }

    public JSONObject getExtendInfos() {
        return this.extendInfos;
    }

    @Nullable
    public PermissionModel getPermissionModel() {
        return this.permissionModel;
    }

    public void setAppInfoModel(AppInfoModel appInfoModel) {
        this.appInfoModel = appInfoModel;
        this.appId = appInfoModel.getAppId();
        this.appVersion = appInfoModel.getVersion();
    }

    public void setContainerInfo(ContainerModel containerModel) {
        this.containerInfo = containerModel;
    }

    public void setExtendInfos(JSONObject jSONObject) {
        this.extendInfos = jSONObject;
    }

    public void setPermissionModel(PermissionModel permissionModel) {
        this.permissionModel = permissionModel;
    }

    public String toString() {
        return "AppModel{appId='" + this.appId + "', appVersion='" + this.appVersion + "', appInfoModel=" + this.appInfoModel + ", containerInfo=" + this.containerInfo + ", extendInfos=" + this.extendInfos + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
        parcel.writeParcelable(this.appInfoModel, 0);
        parcel.writeParcelable(this.containerInfo, 0);
        parcel.writeSerializable(this.extendInfos);
        parcel.writeParcelable(this.permissionModel, 0);
    }

    public AppModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.appVersion = parcel.readString();
        this.appInfoModel = (AppInfoModel) parcel.readParcelable(AppModel.class.getClassLoader());
        this.containerInfo = (ContainerModel) parcel.readParcelable(AppModel.class.getClassLoader());
        this.extendInfos = (JSONObject) parcel.readSerializable();
        this.permissionModel = (PermissionModel) parcel.readParcelable(AppModel.class.getClassLoader());
    }
}
