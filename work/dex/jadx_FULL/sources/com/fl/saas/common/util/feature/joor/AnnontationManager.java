package com.fl.saas.common.util.feature.joor;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.common.util.feature.joor.AnnontationManager;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class AnnontationManager {
    private static final String TAG = CommConstant.getClassTag(AnnontationManager.class);
    private final HashMap<Class<?>, HandlerAnnotation> handlerAnnMap;

    public static final class Holder {
        private static final AnnontationManager INSTANCE = new AnnontationManager();

        private Holder() {
        }
    }

    private AnnontationManager() {
        this.handlerAnnMap = new HashMap<>();
    }

    public static AnnontationManager getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$handleAnnMethod$2(Object[] objArr, Class[] clsArr) {
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadHandlerAnn$0(Class cls) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadHandlerAnn$1(Class cls) {
        return false;
    }

    private HandlerAnnotation loadHandlerAnn(Class<?> cls) {
        HandlerAnnotation handlerAnnotation = this.handlerAnnMap.get(cls);
        if (handlerAnnotation != null) {
            return handlerAnnotation;
        }
        HandlerAnnotation handlerAnnotation2 = new HandlerAnnotation(cls);
        handlerAnnotation2.parseFieldAnn(new Predicate() { // from class: com.zj.adlib.f70
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return AnnontationManager.lambda$loadHandlerAnn$0((Class) obj);
            }
        });
        handlerAnnotation2.parseMethodAnn(new Predicate() { // from class: com.zj.adlib.g70
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return AnnontationManager.lambda$loadHandlerAnn$1((Class) obj);
            }
        });
        this.handlerAnnMap.put(cls, handlerAnnotation2);
        return handlerAnnotation2;
    }

    public void handleAnnMethod(Object obj, @NonNull Class<?> cls, Function<Class<?>[], Object[]> function) {
        if (obj != null) {
            loadHandlerAnn(obj.getClass()).invoke(obj, cls, function);
            return;
        }
        LogcatUtil.d(TAG, "handleAnnMethod but obj is empty, ann:" + cls.getName());
    }

    public void handleAnnMethod(Object obj, @NonNull Class<?> cls, final Object... objArr) {
        handleAnnMethod(obj, cls, (objArr == null || objArr.length <= 0) ? null : new Function() { // from class: com.zj.adlib.h70
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj2) {
                return AnnontationManager.lambda$handleAnnMethod$2(objArr, (Class[]) obj2);
            }
        });
    }
}
