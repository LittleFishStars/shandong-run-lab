package cj.mobile.wm;

import cj.mobile.wm.common.utils.DebugLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexe extends dexg {
    @Override // cj.mobile.wm.dexg
    public Class<?> dexa() {
        try {
            return Class.forName(dexc.dexa("boespje/bqq/JBdujwjuzUbtlNbobhfs"));
        } catch (Throwable th) {
            DebugLog.hook_w(dexc.dexa("hfuJBdujwjuzNbobhfsDmbtt)3:*!gbjm!") + th);
            return null;
        }
    }

    @Override // cj.mobile.wm.dexg
    public Field dexc() {
        Field declaredField = null;
        try {
            declaredField = Class.forName(dexc.dexa("boespje/bqq/BdujwjuzUbtlNbobhfs")).getDeclaredField(dexc.dexa("JBdujwjuzUbtlNbobhfsTjohmfupo"));
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            DebugLog.hook_w(dexc.dexa("hfuJBdujwjuzUbtlNbobhfsGjfme)3:*!gbjm!") + th);
            return declaredField;
        }
    }
}
