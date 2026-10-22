package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ClickAdState extends EventBean<ClickAdState> {
    private static final long serialVersionUID = 1;

    public ClickAdState setData(int i, int i2) {
        HashMap map = new HashMap(4);
        this.data = map;
        map.put("act_type", Integer.valueOf(i));
        this.data.put("power", Integer.valueOf(i2));
        return this;
    }
}
