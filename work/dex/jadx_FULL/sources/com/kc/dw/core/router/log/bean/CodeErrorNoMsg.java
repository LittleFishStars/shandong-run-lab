package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CodeErrorNoMsg extends EventBean<CodeErrorNoMsg> {
    private static final long serialVersionUID = 1;

    public CodeErrorNoMsg setData(int i, int i2, String str) {
        HashMap map = new HashMap(6);
        this.data = map;
        map.put("code", Integer.valueOf(i));
        this.data.put("errno", Integer.valueOf(i2));
        this.data.put("msg", str);
        return this;
    }
}
