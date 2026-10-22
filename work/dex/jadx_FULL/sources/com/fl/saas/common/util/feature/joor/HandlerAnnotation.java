package com.fl.saas.common.util.feature.joor;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Predicate;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HandlerAnnotation {
    private static final String TAG = CommConstant.getClassTag(EventAnnotation.class);
    private final Class<?> type;
    private final Map<Class<?>, Method> annMethod = new HashMap();
    private final Map<Class<?>, Field> annField = new HashMap();

    public HandlerAnnotation(@NonNull Class<?> cls) {
        this.type = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$parseFieldAnn$0(Predicate predicate, Field field, Class cls) {
        if (this.annField.containsKey(cls)) {
            throw new AnnontationException("Repeated registration, can only be registered once:" + cls.getName());
        }
        if (!predicate.test(cls)) {
            return Boolean.FALSE;
        }
        field.setAccessible(true);
        this.annField.put(cls, field);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$parseMethodAnn$1(Predicate predicate, Method method, Class cls) {
        if (this.annMethod.containsKey(cls)) {
            throw new AnnontationException("Repeated registration, can only be registered once:" + cls.getName());
        }
        if (!predicate.test(cls)) {
            return Boolean.FALSE;
        }
        method.setAccessible(true);
        this.annMethod.put(cls, method);
        return Boolean.TRUE;
    }

    public void invoke(@NonNull Object obj, Class<?> cls, Function<Class<?>[], Object[]> function) {
        Class<?> cls2 = obj.getClass();
        if (cls2 != this.type) {
            LogcatUtil.d(TAG, String.format(Locale.getDefault(), "type mismatch,type:%s, obj:%s.", this.type.getName(), cls2.getName()));
            return;
        }
        Method method = this.annMethod.get(cls);
        if (method == null) {
            return;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        try {
            method.invoke(obj, (parameterTypes.length == 0 || function == null) ? null : function.apply(parameterTypes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseAnn(AnnotatedElement annotatedElement, Function<Class<?>, Boolean> function) {
        Annotation[] annotations = annotatedElement.getAnnotations();
        int length = annotations.length;
        for (int i = 0; i < length && !function.apply(annotations[i].getClass()).booleanValue(); i++) {
        }
    }

    public void parseFieldAnn(@NonNull final Predicate<Class<?>> predicate) {
        for (final Field field : this.type.getFields()) {
            parseAnn(field, new Function() { // from class: com.zj.adlib.cy3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f15902a.lambda$parseFieldAnn$0(predicate, field, (Class) obj);
                }
            });
        }
    }

    public void parseMethodAnn(@NonNull final Predicate<Class<?>> predicate) {
        for (final Method method : this.type.getMethods()) {
            parseAnn(method, new Function() { // from class: com.zj.adlib.by3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f15655a.lambda$parseMethodAnn$1(predicate, method, (Class) obj);
                }
            });
        }
    }
}
