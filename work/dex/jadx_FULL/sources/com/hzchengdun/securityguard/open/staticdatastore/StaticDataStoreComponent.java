package com.hzchengdun.securityguard.open.staticdatastore;

import com.hzchengdun.securityguard.adapter.JNICLibrary;
import com.hzchengdun.securityguard.open.SecException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class StaticDataStoreComponent {
    public String getAppKeyByIndex(int i, String str) throws SecException {
        return (String) JNICLibrary.doCommand(10602, Integer.valueOf(i), str);
    }

    public String getExtraData(String str, String str2) throws SecException {
        return (String) JNICLibrary.doCommand(10603, str, str2);
    }
}
