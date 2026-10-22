package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.open.SecException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IDynamicDataEncryptComponent {
    String dynamicDecryptDDp(String str) throws SecException;

    String dynamicEncryptDDp(String str) throws SecException;
}
