package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class TemplateConfigModel implements Parcelable, Serializable {
    public static final Parcelable.Creator<TemplateConfigModel> CREATOR = new Parcelable.Creator<TemplateConfigModel>() { // from class: com.alibaba.ariver.resource.api.models.TemplateConfigModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplateConfigModel createFromParcel(Parcel parcel) {
            return new TemplateConfigModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplateConfigModel[] newArray(int i) {
            return new TemplateConfigModel[i];
        }
    };
    private static final long serialVersionUID = 1908013183340485762L;

    @JSONField
    private String appKey;

    @JSONField(name = LoginConstants.EXT)
    private TemplateExtModel extModel;

    @JSONField(name = "extUrl")
    private String extUrl;

    @JSONField(name = RVStartParams.KEY_TEMPLATE_ID)
    private String templateId;

    @JSONField
    private String templateVersion;

    public TemplateConfigModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public TemplateExtModel getExtModel() {
        return this.extModel;
    }

    public String getExtUrl() {
        return this.extUrl;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateVersion() {
        return this.templateVersion;
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isTemplateValid() {
        return (TextUtils.isEmpty(this.templateId) || (this.extModel == null && TextUtils.isEmpty(this.extUrl))) ? false : true;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setExtModel(TemplateExtModel templateExtModel) {
        this.extModel = templateExtModel;
    }

    public void setExtUrl(String str) {
        this.extUrl = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateVersion(String str) {
        this.templateVersion = str;
    }

    public String toString() {
        return "TemplateConfigModel{ext=" + this.extModel + ", extUrl=" + this.extUrl + ", templateId='" + this.templateId + "', templateVersion='" + this.templateVersion + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.extUrl);
        parcel.writeParcelable(this.extModel, 0);
        parcel.writeString(this.templateId);
        parcel.writeString(this.templateVersion);
        parcel.writeString(this.appKey);
    }

    public TemplateConfigModel(Parcel parcel) {
        this.extUrl = parcel.readString();
        this.extModel = (TemplateExtModel) parcel.readParcelable(TemplateConfigModel.class.getClassLoader());
        this.templateId = parcel.readString();
        this.templateVersion = parcel.readString();
        this.appKey = parcel.readString();
    }
}
