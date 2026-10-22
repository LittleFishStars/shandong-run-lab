package com.alibaba.alibclinkpartner.smartlink.manager;

import android.content.Context;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLAppCheckManager {
    public static List<String> getInstallAppList(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        arrayList.add(str);
                    }
                } catch (Exception e) {
                    ALSLLogUtil.d("ALSLAppCheckManager", "getInstallAppList：", "获取矩阵APP异常：" + e.toString());
                }
            }
            ALSLLogUtil.d("ALSLAppCheckManager", "getInstallAppList：", "矩阵APP匹配中的数量：" + arrayList.size());
        }
        return arrayList;
    }

    public static boolean isAppCanOpen(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
