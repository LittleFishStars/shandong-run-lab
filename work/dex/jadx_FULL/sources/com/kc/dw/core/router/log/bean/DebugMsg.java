package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DebugMsg extends EventBean<DebugMsg> {
    private static final long serialVersionUID = 1;

    public DebugMsg setData(String str, int i, String str2) {
        HashMap map = new HashMap(6);
        this.data = map;
        map.put("event", str);
        this.data.put("code", Integer.valueOf(i));
        this.data.put("msg", str2);
        return this;
    }
}
