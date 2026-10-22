package com.cicada.player.utils.ass;

import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AssUtils {
    static {
        f.b();
    }

    public static void loadClass() {
    }

    private static native Object nParseAssDialogue(Object obj, String str);

    private static native Object nParseAssHeader(String str);

    public static AssDialogue parseAssDialogue(AssHeader assHeader, String str) {
        return (AssDialogue) nParseAssDialogue(assHeader, str);
    }

    public static AssHeader parseAssHeader(String str) {
        return (AssHeader) nParseAssHeader(str);
    }
}
