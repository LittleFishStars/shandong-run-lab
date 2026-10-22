package cj.mobile.wm;

import cj.mobile.wm.common.utils.DebugLog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexf extends dexg {
    @Override // cj.mobile.wm.dexg
    public Class<?> dexa() {
        try {
            return Class.forName(dexc.dexa("boespje/bqq/JBdujwjuzNbobhfs"));
        } catch (Throwable th) {
            DebugLog.hook_w(dexc.dexa("hfuJBdujwjuzNbobhfsDmbtt)puifs*!gbjm!") + th);
            return null;
        }
    }

    @Override // cj.mobile.wm.dexg
    public Field dexc() {
        try {
            Field declaredField = Class.forName(dexc.dexa("boespje/bqq/BdujwjuzNbobhfsObujwf")).getDeclaredField(dexc.dexa("hEfgbvmu"));
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            DebugLog.hook_w(dexc.dexa("hfuJBdujwjuzUbtlNbobhfsGjfme)puifs*!gbjm!") + th);
            return null;
        }
    }
}
