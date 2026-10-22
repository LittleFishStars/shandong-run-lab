package cn.hzjizhun.admin;

import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PlatformInfoBean;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import com.zj.adlib.ghb;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class akdsd {
    public static dkkd a(String str, ghb ghbVar) {
        if (str == null || ghbVar == null) {
            return null;
        }
        List<PlatformInfoBean> platformInfo = FunctionConfig.instance().getPlatformInfo();
        List<PosInfoBean> posInfo = FunctionConfig.instance().getPosInfo(str);
        if (posInfo == null || posInfo.size() <= 0 || platformInfo == null || platformInfo.size() <= 0) {
            return null;
        }
        platformInfo.get(0);
        f fVar = new f(str, ghbVar);
        fVar.h(posInfo);
        return fVar;
    }
}
