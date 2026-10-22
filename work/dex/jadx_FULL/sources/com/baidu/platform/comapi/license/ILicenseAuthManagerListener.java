package com.baidu.platform.comapi.license;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ILicenseAuthManagerListener {
    void onError(String str, String str2, int i, int i2, String str3);

    void onSuccess(String str, String str2, int i, Map<String, Integer> map);
}
