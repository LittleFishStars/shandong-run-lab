package com.zj.adlib;

import com.bwt.top.api.FunctionConfig;
import com.bwt.top.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lva {
    public static void a(PosInfoBean... posInfoBeanArr) {
        for (PosInfoBean posInfoBean : posInfoBeanArr) {
            posInfoBean.setExpand(FunctionConfig.instance().getExpand(posInfoBean.getPosPlatform()));
        }
    }
}
