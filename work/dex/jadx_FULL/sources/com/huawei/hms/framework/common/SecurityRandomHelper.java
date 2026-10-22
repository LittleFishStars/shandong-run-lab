package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SecurityRandomHelper {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile SecurityRandomHelper instance;

    private SecurityRandomHelper() {
    }

    public static SecurityRandomHelper getInstance() {
        if (instance == null) {
            synchronized (SecurityRandomHelper.class) {
                if (instance == null) {
                    EncryptUtil.setBouncycastleFlag(true);
                    instance = new SecurityRandomHelper();
                }
            }
        }
        return instance;
    }

    public byte[] generateSecureRandom(int i) {
        return EncryptUtil.generateSecureRandom(i);
    }

    public String generateSecureRandomStr(int i) {
        return EncryptUtil.generateSecureRandomStr(i);
    }
}
