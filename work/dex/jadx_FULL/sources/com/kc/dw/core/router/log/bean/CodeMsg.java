package com.kc.dw.core.router.log.bean;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CodeMsg extends EventBean<CodeMsg> {
    private static final long serialVersionUID = 1;

    public CodeMsg setData(int i, String str) {
        HashMap map = new HashMap(4);
        this.data = map;
        map.put("code", Integer.valueOf(i));
        this.data.put("msg", str);
        return this;
    }
}
