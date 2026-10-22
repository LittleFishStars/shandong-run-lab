package com.kc.openset.pine.callback;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Member;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class MethodHook {

    @Keep
    public class Unhook {
        private final Pine.HookRecord hookRecord;
        final MethodHook this$0;

        static {
            OSETSDKProtected.interface11(4577);
        }

        public Unhook(MethodHook methodHook, Pine.HookRecord hookRecord) {
            this.this$0 = methodHook;
            this.hookRecord = hookRecord;
        }

        public native MethodHook getCallback();

        public native Member getTarget();

        public native void unhook();
    }

    static {
        OSETSDKProtected.interface11(4578);
    }

    public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

    public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
}
