package cj.mobile.wm.okhttp.exception;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CacheException extends Exception {
    public static final long serialVersionUID = 845628123701073013L;

    public CacheException(String str) {
        super(str);
    }

    public static CacheException NON_AND_304(String str) {
        return new CacheException(dexc.dexa("uif!iuuq!sftqpotf!dpef!jt!415-!cvu!uif!dbdif!xjui!dbdifLfz!>!") + str + dexc.dexa("!jt!ovmm!ps!fyqjsfe\""));
    }

    public static CacheException NON_OR_EXPIRE(String str) {
        return new CacheException(dexc.dexa("dbdifLfz!>!") + str + dexc.dexa("!-dbo(u!gjoe!dbdif!cz!dbdifLfz-!ps!dbdif!ibt!fyqjsfe\""));
    }
}
