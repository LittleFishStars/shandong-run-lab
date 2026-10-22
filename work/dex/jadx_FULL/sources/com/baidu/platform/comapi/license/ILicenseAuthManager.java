package com.baidu.platform.comapi.license;

import android.content.Context;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ILicenseAuthManager {
    boolean isEffective(String str, String str2);

    boolean isHaveAuthority();

    boolean isHaveAuthority(Map<String, Integer> map);

    void loadAuth(Context context, ILicenseAuthManagerListener iLicenseAuthManagerListener);

    Map<String, Integer> loadLocalAuth(Context context) throws BaseLicenseAuthDataStandardProcess.ProcessException;
}
