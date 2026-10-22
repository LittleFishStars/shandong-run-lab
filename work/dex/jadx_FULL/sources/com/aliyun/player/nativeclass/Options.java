package com.aliyun.player.nativeclass;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Options {
    private static final int FLAG_APPEND = 1;
    private static final int FLAG_REPLACE = 2;
    private Map<String, String> mOptions = new HashMap();

    public String get(String str) {
        return this.mOptions.get(str);
    }

    public void reset() {
        this.mOptions.clear();
    }

    public boolean set(String str, String str2, int i) {
        Map<String, String> map;
        if (!this.mOptions.containsKey(str)) {
            map = this.mOptions;
        } else if (i == 1) {
            map = this.mOptions;
            str2 = this.mOptions.get(str) + str2;
        } else {
            if (i != 2) {
                return false;
            }
            map = this.mOptions;
        }
        map.put(str, str2);
        return true;
    }
}
