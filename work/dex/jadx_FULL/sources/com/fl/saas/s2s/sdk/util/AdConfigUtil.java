package com.fl.saas.s2s.sdk.util;

import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.util.TypeUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdConfigUtil {
    public static int getType(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo != null) {
            TypeUtil.TypeBean type = TypeUtil.getType(adInfoPoJo.click_value);
            adInfoPoJo.cbr = type.getValue();
            return type.getType();
        }
        if (adInfoPoJo == null) {
            return 1;
        }
        adInfoPoJo.cbr = "empty";
        return 1;
    }
}
