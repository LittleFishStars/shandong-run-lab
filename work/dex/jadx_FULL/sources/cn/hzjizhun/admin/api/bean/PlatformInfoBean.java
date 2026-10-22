package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PlatformInfoBean implements Serializable {
    private String appId;
    private String download;
    private String expand;
    private String id;
    private String platformName;
    private String platformType;
    private int sort;
    private String thirdAppId;
    private String tip;

    public static PlatformInfoBean toBean(String str) {
        PlatformInfoBean platformInfoBean = new PlatformInfoBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            platformInfoBean.platformName = jSONObject.optString("name");
            platformInfoBean.platformType = jSONObject.optString("type");
            platformInfoBean.appId = jSONObject.optString("appid");
            platformInfoBean.thirdAppId = jSONObject.optString("thirdappid");
            platformInfoBean.download = jSONObject.optString("download");
            platformInfoBean.tip = jSONObject.optString("tip");
            platformInfoBean.id = jSONObject.optString("id");
            platformInfoBean.sort = jSONObject.optInt("sort");
            platformInfoBean.expand = jSONObject.optString("expand");
        } catch (Throwable unused) {
        }
        return platformInfoBean;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDownload() {
        return this.download;
    }

    public String getExpand() {
        return this.expand;
    }

    public String getId() {
        return this.id;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public int getSort() {
        return this.sort;
    }

    public String getThirdAppId() {
        return this.thirdAppId;
    }

    public String getTip() {
        return this.tip;
    }

    public String toString() {
        return "PlatformInfoBean{platformName='" + this.platformName + "', platformType='" + this.platformType + "', appId='" + this.appId + "', thirdAppId='" + this.thirdAppId + "', id='" + this.id + "', sort=" + this.sort + ", expand='" + this.expand + "'}";
    }
}
