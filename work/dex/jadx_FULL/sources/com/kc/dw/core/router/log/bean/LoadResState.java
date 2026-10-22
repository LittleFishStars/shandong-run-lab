package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LoadResState extends EventBean<LoadResState> {
    private static final long serialVersionUID = 1;

    public LoadResState setFail(int i) {
        if (this.data == null) {
            this.data = new HashMap(8);
        }
        this.data.put("code", Integer.valueOf(i));
        return this;
    }

    public LoadResState setSuccess(int i, int i2, int i3) {
        if (this.data == null) {
            this.data = new HashMap(8);
        }
        this.data.put("type", Integer.valueOf(i));
        this.data.put("source", Integer.valueOf(i2));
        this.data.put("cache", Integer.valueOf(i3));
        return this;
    }
}
