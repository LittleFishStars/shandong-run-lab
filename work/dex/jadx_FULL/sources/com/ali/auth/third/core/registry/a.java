package com.ali.auth.third.core.registry;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface a {
    ServiceRegistration a(Class<?>[] clsArr, Object obj, Map<String, String> map);

    Object a(ServiceRegistration serviceRegistration);

    <T> T a(Class<T> cls, Map<String, String> map);

    <T> T[] b(Class<T> cls, Map<String, String> map);
}
