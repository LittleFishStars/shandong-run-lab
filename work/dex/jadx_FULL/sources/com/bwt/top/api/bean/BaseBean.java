package com.bwt.top.api.bean;

import com.easyjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BaseBean implements Serializable {

    @JSONField(name = "result")
    private InitConfigBean initConfig;
    private String msg;
    private String reason;

    public InitConfigBean getInitConfig() {
        return this.initConfig;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isOk() {
        String str = this.msg;
        return str != null && str.toLowerCase().equals("ok");
    }

    public void setInitConfig(InitConfigBean initConfigBean) {
        this.initConfig = initConfigBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "BaseBean{msg='" + this.msg + "'reason=" + this.reason + "', initConfig=" + this.initConfig + '}';
    }
}
