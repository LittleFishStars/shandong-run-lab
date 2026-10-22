package com.fl.saas.common.util.feature.joor;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class EventAnnotation {
    private final String TAG = CommConstant.getClassTag(EventAnnotation.class);
    private final Map<Class<?>, Method> annMethod = new HashMap();
    private final Class<?> type;

    public EventAnnotation(@NonNull Object obj, Class<?>... clsArr) {
        this.type = obj.getClass();
        parseMethodAnn(clsArr);
    }

    private void parseMethodAnn(Class<?>... clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return;
        }
        List listAsList = Arrays.asList(clsArr);
        for (Method method : this.type.getMethods()) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            if (declaredAnnotations.length == 0) {
                return;
            }
            for (Annotation annotation : declaredAnnotations) {
                Class<?> cls = annotation.getClass();
                if (listAsList.contains(cls)) {
                    method.setAccessible(true);
                    this.annMethod.put(cls, method);
                }
            }
        }
    }

    public void handleAnnMethod(@NonNull Object obj, Class<?> cls, Function<Class<?>[], Object[]> function) {
        Class<?> cls2 = obj.getClass();
        if (cls2 != this.type) {
            LogcatUtil.d(this.TAG, String.format(Locale.getDefault(), "type mismatch,type:%s, obj:%s.", this.type.getName(), cls2.getName()));
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
}
