package com.kc.dw.platform.custom;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CustomFactory {
    private static Map<String, CustomInitLoader> initLoaderMap = new ConcurrentHashMap();

    public static CustomInitLoader getInitLoader(String str) {
        if (initLoaderMap.containsKey(str)) {
            return initLoaderMap.get(str);
        }
        return null;
    }

    public static void putInitLoader(String str, CustomInitLoader customInitLoader) {
        if (initLoaderMap.containsKey(str)) {
            return;
        }
        initLoaderMap.put(str, customInitLoader);
    }
}
