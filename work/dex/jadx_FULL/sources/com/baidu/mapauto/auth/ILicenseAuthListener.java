package com.baidu.mapauto.auth;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ILicenseAuthListener {
    void onError(int i, String str);

    void onSuccess(Map<String, Integer> map);
}
