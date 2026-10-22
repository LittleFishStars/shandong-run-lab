package com.zj.adlib;

import com.bwt.top.ad.adapter.AdapterAdLoader;
import com.bwt.top.ad.loader.ddksa.b;
import com.bwt.top.ad.loader.ddksa.ddksa;
import com.bwt.top.api.FunctionConfig;
import com.bwt.top.api.bean.PlatformInfoBean;
import com.bwt.top.api.bean.PosInfoBean;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class jwa {
    public static <T extends ygb, Y extends AdapterAdLoader> ddksa a(String str, T t) {
        if (str == null || t == null) {
            return null;
        }
        List<PlatformInfoBean> platformInfo = FunctionConfig.instance().getPlatformInfo();
        List<PosInfoBean> posInfo = FunctionConfig.instance().getPosInfo(str);
        if (posInfo == null || posInfo.size() <= 0 || platformInfo == null || platformInfo.size() <= 0) {
            return null;
        }
        platformInfo.get(0);
        b bVar = new b(str, t);
        bVar.g(posInfo);
        return bVar;
    }
}
