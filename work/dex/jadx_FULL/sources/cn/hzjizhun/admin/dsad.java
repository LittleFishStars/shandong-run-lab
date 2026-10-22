package cn.hzjizhun.admin;

import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PosInfoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class dsad {
    public static void a(PosInfoBean... posInfoBeanArr) {
        for (PosInfoBean posInfoBean : posInfoBeanArr) {
            posInfoBean.setExpand(FunctionConfig.instance().getExpand(posInfoBean.getPosPlatform()));
        }
    }
}
