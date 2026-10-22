package com.kc.aw;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lb {
    public static final HashMap _a;

    static {
        HashMap map = new HashMap();
        _a = map;
        map.put("1", "dXNlcl9pZA==");
        map.put("2", "dHJhbnNfaWQ=");
        map.put("3", "cmV3YXJkX25hbWU=");
        map.put("4", "cmV3YXJkX2Ftb3VudA==");
        map.put("5", "ZXh0cmE=");
        map.put("6", "c2lnbg==");
        map.put("7", "YXBwX2lk");
        map.put(PrepareException.ERROR_AUTH_FAIL, "c2xvdF9pZA==");
    }

    public static String _a(String str) {
        return com.kc.aw.lib.utils._a._a((String) _a.get(str));
    }
}
