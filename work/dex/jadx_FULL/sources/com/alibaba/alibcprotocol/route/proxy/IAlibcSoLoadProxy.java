package com.alibaba.alibcprotocol.route.proxy;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@a(a = "com.alibaba.alibc_dynamicload.AlibcSoLoad")
public interface IAlibcSoLoadProxy extends IProxy {
    void initSoLoad(Context context, String str, String str2);

    void loadSo(Context context, String str, String str2, String str3);

    void registerSoLoad(String str, String str2);

    void unRegisterSoLoad(String str);
}
