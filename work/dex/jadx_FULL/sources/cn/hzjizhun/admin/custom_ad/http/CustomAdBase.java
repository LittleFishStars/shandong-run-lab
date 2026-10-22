package cn.hzjizhun.admin.custom_ad.http;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomAdBase implements Serializable {
    private CustomAdPosResult adPosResult;
    private String msg;

    public static CustomAdBase toBean(String str) {
        CustomAdBase customAdBase = new CustomAdBase();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("msg");
            CustomAdPosResult bean = CustomAdPosResult.toBean(jSONObject.optString("result"));
            customAdBase.setMsg(strOptString);
            customAdBase.setAdPosResult(bean);
        } catch (Throwable unused) {
        }
        return customAdBase;
    }

    public CustomAdPosResult getAdPosResult() {
        return this.adPosResult;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAdPosResult(CustomAdPosResult customAdPosResult) {
        this.adPosResult = customAdPosResult;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ChannelAdBase{msg='" + this.msg + "', adPosResult=" + this.adPosResult + '}';
    }
}
