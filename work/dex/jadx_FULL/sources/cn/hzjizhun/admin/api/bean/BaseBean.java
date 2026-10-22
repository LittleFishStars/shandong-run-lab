package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BaseBean implements Serializable {
    private InitConfigBean initConfig;
    private String msg;
    private String resultJson;

    public static BaseBean toBean(String str) {
        BaseBean baseBean = new BaseBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            baseBean.msg = jSONObject.optString("msg");
            String strOptString = jSONObject.optString("result");
            baseBean.initConfig = InitConfigBean.toBean(strOptString);
            baseBean.resultJson = strOptString;
        } catch (Throwable unused) {
        }
        return baseBean;
    }

    public InitConfigBean getInitConfig() {
        return this.initConfig;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getResultJson() {
        return this.resultJson;
    }

    public boolean isOk() {
        String str = this.msg;
        return str != null && str.toLowerCase().equals("ok");
    }

    public String toString() {
        return "BaseBean{msg='" + this.msg + "', initConfig=" + this.initConfig + '}';
    }
}
