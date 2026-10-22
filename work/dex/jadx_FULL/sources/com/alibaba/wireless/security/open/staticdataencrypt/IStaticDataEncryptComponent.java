package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.open.SecException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IStaticDataEncryptComponent {
    public static final int ALGORITHM_MAX_NUMBER = 19;
    public static final int OPEN_ENUM_CIPHER = 3;
    public static final int OPEN_ENUM_CIPHER_AES128 = 16;
    public static final int OPEN_ENUM_CIPHER_AES192 = 17;
    public static final int OPEN_ENUM_CIPHER_AES256 = 18;

    String staticSafeDecrypt(int i, String str, String str2, String str3) throws SecException;

    String staticSafeEncrypt(int i, String str, String str2, String str3) throws SecException;
}
