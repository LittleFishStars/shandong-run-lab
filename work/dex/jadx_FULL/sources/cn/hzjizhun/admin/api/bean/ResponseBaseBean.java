package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResponseBaseBean implements Serializable {
    private String msg;
    private Object result;

    public static ResponseBaseBean toBean(String str) {
        ResponseBaseBean responseBaseBean = new ResponseBaseBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            responseBaseBean.msg = jSONObject.optString("msg");
            responseBaseBean.result = jSONObject.opt("result");
        } catch (Throwable unused) {
        }
        return responseBaseBean;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getResult() {
        return this.result;
    }

    public boolean isOk() {
        String str = this.msg;
        return str != null && str.toLowerCase().equals("ok");
    }

    public Boolean objectToBean() {
        try {
            Object obj = this.result;
            if (obj != null && (obj instanceof Boolean)) {
                return (Boolean) obj;
            }
        } catch (Throwable unused) {
        }
        return Boolean.FALSE;
    }

    public String objectToString() {
        try {
            Object obj = this.result;
            return (obj == null || !(obj instanceof String)) ? "" : (String) obj;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "BaseBean{msg='" + this.msg + "', result=" + this.result + '}';
    }
}
