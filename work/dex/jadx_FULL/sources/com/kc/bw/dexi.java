package com.kc.bw;

import com.kc.bw.common.utils.DebugLog;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexi extends dexk {
    @Override // com.kc.bw.dexk
    public Class<?> dexa() {
        try {
            return Class.forName(dexg.dexa("boespje/bqq/JBdujwjuzUbtlNbobhfs"));
        } catch (Throwable th) {
            DebugLog.hook_w(dexg.dexa("hfuJBdujwjuzNbobhfsDmbtt)3:*!gbjm!") + th);
            return null;
        }
    }

    @Override // com.kc.bw.dexk
    public Field dexc() {
        Field declaredField = null;
        try {
            declaredField = Class.forName(dexg.dexa("boespje/bqq/BdujwjuzUbtlNbobhfs")).getDeclaredField(dexg.dexa("JBdujwjuzUbtlNbobhfsTjohmfupo"));
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            DebugLog.hook_w(dexg.dexa("hfuJBdujwjuzUbtlNbobhfsGjfme)3:*!gbjm!") + th);
            return declaredField;
        }
    }
}
