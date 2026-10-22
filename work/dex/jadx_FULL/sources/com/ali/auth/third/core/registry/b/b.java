package com.ali.auth.third.core.registry.b;

import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.model.Constants;
import com.ali.auth.third.core.registry.ServiceRegistration;
import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements com.ali.auth.third.core.registry.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ali.auth.third.core.registry.a f23425a;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f23426a;
        final /* synthetic */ Map b;

        public a(Class cls, Map map) {
            this.f23426a = cls;
            this.b = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object objA = b.this.f23425a.a(this.f23426a, this.b);
            if (objA != null) {
                return method.invoke(objA, objArr);
            }
            Object[] objArr2 = new Object[2];
            objArr2[0] = this.f23426a.getName();
            Map map = this.b;
            objArr2[1] = map != null ? map.toString() : "";
            SDKLogger.e("kernel", Message.create(17, objArr2).toString());
            return null;
        }
    }

    public b(com.ali.auth.third.core.registry.a aVar) {
        this.f23425a = aVar;
    }

    @Override // com.ali.auth.third.core.registry.a
    public ServiceRegistration a(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        return this.f23425a.a(clsArr, obj, map);
    }

    @Override // com.ali.auth.third.core.registry.a
    public Object a(ServiceRegistration serviceRegistration) {
        return this.f23425a.a(serviceRegistration);
    }

    @Override // com.ali.auth.third.core.registry.a
    public <T> T a(Class<T> cls, Map<String, String> map) {
        T t = (T) this.f23425a.a(cls, map);
        if (t != null || map == null) {
            return t;
        }
        map.get(Constants.ISV_SCOPE_FLAG);
        return cls.isInterface() ? cls.cast(Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, new a(cls, map))) : t;
    }

    @Override // com.ali.auth.third.core.registry.a
    public <T> T[] b(Class<T> cls, Map<String, String> map) {
        return (T[]) this.f23425a.b(cls, map);
    }
}
