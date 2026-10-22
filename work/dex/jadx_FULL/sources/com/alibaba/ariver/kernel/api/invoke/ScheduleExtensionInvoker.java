package com.alibaba.ariver.kernel.api.invoke;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ScheduleExtensionInvoker extends ExtensionInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24213a = "AriverKernel:ExtensionInvoker:Schedule";
    private RVExecutorService b;

    /* JADX INFO: renamed from: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType;

        static {
            int[] iArr = new int[ExecutorType.values().length];
            $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType = iArr;
            try {
                iArr[ExecutorType.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[ExecutorType.URGENT_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ScheduleExtensionInvoker(ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.b = (RVExecutorService) RVProxy.get(RVExecutorService.class);
    }

    private boolean a() {
        return TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_disable_trans_sync_thread", null), "yes");
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(final ImmutableList<Extension> immutableList, final Object obj, final Method method, final Object[] objArr) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        ThreadType threadType = (ThreadType) method.getAnnotation(ThreadType.class);
        ExecutorType executorTypeValue = threadType != null ? threadType.value() : ExecutorType.SYNC;
        if (threadType != null && ExecutorUtils.currentThreadInArray(threadType.transSyncThreadNames()) && !a()) {
            executorTypeValue = ExecutorType.SYNC;
        }
        int i = AnonymousClass3.$SwitchMap$com$alibaba$ariver$kernel$common$service$executor$ExecutorType[executorTypeValue.ordinal()];
        boolean z = true;
        if (i == 1) {
            RVLogger.debug(f24213a, "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return ExtensionInvoker.InvokeResult.proceed();
        }
        if (i == 2) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker.1
                @Override // java.lang.Runnable
                public void run() {
                    RVLogger.debug(ScheduleExtensionInvoker.f24213a, "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    ScheduleExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
                }
            });
            return ExtensionInvoker.InvokeResult.pending();
        }
        if (i == 3) {
            Class<?> cls = obj.getClass().getInterfaces().length > 0 ? obj.getClass().getInterfaces()[0] : null;
            if (cls == null || (!cls.getName().startsWith("com.alipay.mobile.nebulax") && !cls.getName().startsWith("com.alibaba.ariver"))) {
                z = false;
            }
            if (!z) {
                RVLogger.w(f24213a, "extension " + obj + " want to execute on URGENT_DISPLAY but not nebulax class!");
                executorTypeValue = ExecutorType.URGENT;
            }
        }
        this.b.getExecutor(executorTypeValue).execute(new Runnable() { // from class: com.alibaba.ariver.kernel.api.invoke.ScheduleExtensionInvoker.2
            @Override // java.lang.Runnable
            public void run() {
                RVLogger.debug(ScheduleExtensionInvoker.f24213a, "method " + method + " cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
                ScheduleExtensionInvoker.this.proceedSafe(immutableList, obj, method, objArr);
            }
        });
        return ExtensionInvoker.InvokeResult.pending();
    }
}
