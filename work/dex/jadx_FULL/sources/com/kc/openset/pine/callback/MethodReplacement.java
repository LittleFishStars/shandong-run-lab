package com.kc.openset.pine.callback;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class MethodReplacement extends MethodHook {
    public static final MethodReplacement DO_NOTHING;

    /* JADX INFO: renamed from: com.kc.openset.pine.callback.MethodReplacement$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends MethodReplacement {
        final Object val$result;

        static {
            OSETSDKProtected.interface11(4580);
        }

        public AnonymousClass2(Object obj) {
            this.val$result = obj;
        }

        @Override // com.kc.openset.pine.callback.MethodReplacement
        public native Object replaceCall(Pine.CallFrame callFrame);
    }

    static {
        OSETSDKProtected.interface11(4581);
        DO_NOTHING = new MethodReplacement() { // from class: com.kc.openset.pine.callback.MethodReplacement.1
            static {
                OSETSDKProtected.interface11(4579);
            }

            @Override // com.kc.openset.pine.callback.MethodReplacement
            public native Object replaceCall(Pine.CallFrame callFrame);
        };
    }

    public static native MethodReplacement returnConstant(Object obj);

    @Override // com.kc.openset.pine.callback.MethodHook
    public final native void afterCall(Pine.CallFrame callFrame);

    @Override // com.kc.openset.pine.callback.MethodHook
    public final native void beforeCall(Pine.CallFrame callFrame);

    public abstract Object replaceCall(Pine.CallFrame callFrame) throws Throwable;
}
