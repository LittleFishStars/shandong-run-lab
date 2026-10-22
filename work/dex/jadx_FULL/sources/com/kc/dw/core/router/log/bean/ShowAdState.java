package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ShowAdState extends EventBean<ShowAdState> {
    private static final long serialVersionUID = 1;

    public ShowAdState setFail(int i, int i2, String str) {
        if (this.data == null) {
            this.data = new HashMap(6);
        }
        this.data.put("code", Integer.valueOf(i));
        this.data.put("errno", Integer.valueOf(i2));
        this.data.put("msg", str);
        return this;
    }

    public ShowAdState setSuccess(int i, int i2) {
        if (this.data == null) {
            this.data = new HashMap(4);
        }
        this.data.put("act_type", Integer.valueOf(i));
        this.data.put("source", Integer.valueOf(i2));
        return this;
    }
}
