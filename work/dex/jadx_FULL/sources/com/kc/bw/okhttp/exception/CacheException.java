package com.kc.bw.okhttp.exception;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CacheException extends Exception {
    public static final long serialVersionUID = 845628123701073013L;

    public CacheException(String str) {
        super(str);
    }

    public static CacheException NON_AND_304(String str) {
        return new CacheException(dexg.dexa("uif!iuuq!sftqpotf!dpef!jt!415-!cvu!uif!dbdif!xjui!dbdifLfz!>!") + str + dexg.dexa("!jt!ovmm!ps!fyqjsfe\""));
    }

    public static CacheException NON_OR_EXPIRE(String str) {
        return new CacheException(dexg.dexa("dbdifLfz!>!") + str + dexg.dexa("!-dbo(u!gjoe!dbdif!cz!dbdifLfz-!ps!dbdif!ibt!fyqjsfe\""));
    }
}
