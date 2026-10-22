package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ChannelUrlBean implements Serializable {
    private String baseUrl;
    private String name;

    public static ChannelUrlBean toBean(String str) {
        ChannelUrlBean channelUrlBean = new ChannelUrlBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            channelUrlBean.name = jSONObject.optString("name");
            channelUrlBean.baseUrl = jSONObject.optString("baseUrl");
        } catch (Throwable unused) {
        }
        return channelUrlBean;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "ChannelUrlBean{name='" + this.name + "', baseUrl='" + this.baseUrl + "'}";
    }
}
