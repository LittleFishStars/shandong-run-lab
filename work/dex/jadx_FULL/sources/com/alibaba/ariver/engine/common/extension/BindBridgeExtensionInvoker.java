package com.alibaba.ariver.engine.common.extension;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingExecutor;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingId;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy;
import com.alibaba.ariver.engine.common.bridge.DefaultApiContext;
import com.alibaba.ariver.engine.common.bridge.internal.DefaultBridgeCallback;
import com.alibaba.ariver.engine.common.extension.bind.ApiContextBinder;
import com.alibaba.ariver.engine.common.extension.bind.Binder;
import com.alibaba.ariver.engine.common.extension.bind.CallbackBinder;
import com.alibaba.ariver.engine.common.extension.bind.ExecutorBinder;
import com.alibaba.ariver.engine.common.extension.bind.IdBinder;
import com.alibaba.ariver.engine.common.extension.bind.NodeBinder;
import com.alibaba.ariver.engine.common.extension.bind.ParamBinder;
import com.alibaba.ariver.engine.common.extension.bind.RequestBinder;
import com.alibaba.ariver.engine.common.extension.bind.RequiredParamNotFoundException;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.ariver.kernel.api.extension.bridge.ActionMeta;
import com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker;
import com.alibaba.ariver.kernel.api.invoke.InvokeException;
import com.alibaba.ariver.kernel.api.invoke.NodeAwareUtils;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableList;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BindBridgeExtensionInvoker extends ExtensionInvoker {
    public static final String TAG = "AriverEngine:BridgeExtensionInvoker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<Class> f24064a;
    private final BridgeResponseHelper b;
    private JSONObject c;
    private ApiContext d;
    private NativeCallContext e;
    private ActionMeta f;
    private String g;

    static {
        HashSet hashSet = new HashSet();
        f24064a = hashSet;
        hashSet.add(BindingApiContext.class);
        hashSet.add(BindingCallback.class);
        hashSet.add(BindingExecutor.class);
        hashSet.add(BindingId.class);
        hashSet.add(BindingNode.class);
        hashSet.add(BindingParam.class);
        hashSet.add(BindingRequest.class);
    }

    public BindBridgeExtensionInvoker(Node node, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ActionMeta actionMeta) {
        this(node, nativeCallContext, bridgeResponseHelper, actionMeta, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SparseArrayCompat<Annotation[]> a(Method method, ActionMeta actionMeta) {
        SparseArrayCompat<Annotation[]> sparseArrayCompat = new SparseArrayCompat<>();
        if (method == null) {
            return sparseArrayCompat;
        }
        Class[] clsArr = actionMeta.paramTypes;
        Annotation[][] annotationArr = actionMeta.paramAnnotationArray;
        if (clsArr != null && clsArr.length != 0) {
            for (int i = 0; i < clsArr.length; i++) {
                Annotation[] annotationArr2 = annotationArr[i];
                if (annotationArr2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Annotation annotation : annotationArr2) {
                        if (annotation != null && annotation.annotationType() != null && f24064a.contains(annotation.annotationType())) {
                            arrayList.add(annotation);
                        }
                    }
                    if (arrayList.size() > 0) {
                        sparseArrayCompat.put(i, arrayList.toArray(new Annotation[arrayList.size()]));
                    }
                }
            }
        }
        return sparseArrayCompat;
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionOpt.MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls) {
        return ExtensionOpt.getMethodInvokeOptimizer(cls, true);
    }

    @Override // com.alibaba.ariver.kernel.api.invoke.ExtensionInvoker
    public ExtensionInvoker.InvokeResult onInvoke(ImmutableList<Extension> immutableList, Object obj, Method method, Object[] objArr) {
        JSONObject jSONObject;
        if (this.f.paramRequired && ((jSONObject = this.c) == null || jSONObject.isEmpty())) {
            new DefaultBridgeCallback(this.b, false).sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return ExtensionInvoker.InvokeResult.decide(null);
        }
        int length = method.getParameterTypes().length;
        Object[] objArr2 = new Object[length];
        SparseArrayCompat<Annotation[]> sparseArrayCompatA = a(method, this.f);
        for (int i = 0; i < length; i++) {
            try {
                objArr2[i] = a(this.f.paramTypes[i], sparseArrayCompatA.get(i));
            } catch (RequiredParamNotFoundException e) {
                new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(2, e.getMessage()));
                return ExtensionInvoker.InvokeResult.decide(null);
            }
        }
        try {
            NodeAwareUtils.handleSetNode(this.targetNode, immutableList.get(0));
            this.b.setTargetExtension(immutableList.get(0));
            this.e.getStatData().executeTimeStamp = SystemClock.elapsedRealtime();
            if (((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).preInvoke(this.targetNode, this.e, this.d, this.b)) {
                RVLogger.d(TAG, "preInvoke handled!\nExtension: " + immutableList.get(0) + "\nMethod: " + method);
                return ExtensionInvoker.InvokeResult.decide(null);
            }
            Object objProceed = proceed(immutableList, obj, method, objArr2);
            if (((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).postInvoke(this.targetNode, this.e, this.d, this.b)) {
                RVLogger.d(TAG, "postInvoke handled!\nExtension: " + immutableList.get(0) + "\nMethod: " + method);
                return ExtensionInvoker.InvokeResult.decide(objProceed);
            }
            if (this.f.autoCallback) {
                if (objProceed == null) {
                    RVLogger.w("AutoCallback but got null!!! " + immutableList.get(0) + " method: " + method);
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(BridgeResponse.SUCCESS);
                    return ExtensionInvoker.InvokeResult.decide(null);
                }
                if (objProceed instanceof BridgeResponse) {
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse((BridgeResponse) objProceed);
                } else if (objProceed instanceof JSONObject) {
                    new DefaultBridgeCallback(this.b, false).sendJSONResponse((JSONObject) objProceed);
                } else {
                    new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(2, "method " + method.getName() + " return type not recognized " + objProceed.getClass().getName()));
                }
            }
            return ExtensionInvoker.InvokeResult.decide(objProceed);
        } catch (InvokeException e2) {
            RVLogger.e(TAG, "Java exception happened!\nExtension: " + immutableList.get(0) + "\nMethod: " + method, e2);
            new DefaultBridgeCallback(this.b, false).sendBridgeResponse(new BridgeResponse.Error(6, "Java exception happen in method: " + method + " message: " + e2.getMessage()));
            return ExtensionInvoker.InvokeResult.decide(null);
        }
    }

    public BindBridgeExtensionInvoker(Node node, NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper, ActionMeta actionMeta, @Nullable ApiContext apiContext, Class<? extends Extension> cls) {
        super(node, null, cls);
        this.b = bridgeResponseHelper;
        this.c = nativeCallContext.getParams();
        this.e = nativeCallContext;
        this.f = actionMeta;
        this.g = nativeCallContext.getId();
        if (apiContext == null) {
            this.d = new DefaultApiContext(node, nativeCallContext.getPluginId(), nativeCallContext.getContextId());
        } else {
            this.d = apiContext;
        }
    }

    private Object a(Class cls, Annotation[] annotationArr) {
        Binder idBinder;
        Annotation annotation = (annotationArr == null || annotationArr.length <= 0) ? null : annotationArr[0];
        if (annotation instanceof BindingParam) {
            idBinder = new ParamBinder(this.c);
        } else if (annotation instanceof BindingRequest) {
            idBinder = new RequestBinder(this.c);
        } else if (annotation instanceof BindingCallback) {
            idBinder = new CallbackBinder(this.b);
        } else if (annotation instanceof BindingExecutor) {
            idBinder = new ExecutorBinder();
        } else if (annotation instanceof BindingNode) {
            idBinder = new NodeBinder(this.targetNode);
        } else if (annotation instanceof BindingApiContext) {
            idBinder = new ApiContextBinder(this.d);
        } else {
            idBinder = annotation instanceof BindingId ? new IdBinder(this.g) : null;
        }
        Object objBind = idBinder != null ? idBinder.bind(cls, annotation) : null;
        if (objBind == null && cls.isPrimitive()) {
            return 0;
        }
        return objBind;
    }
}
