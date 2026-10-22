package com.zj.adlib;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Singleton
public class tn5 implements BackendRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44963a = "BackendRegistry";
    public static final String b = "backend:";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f19868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ux1 f19869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, TransportBackend> f19870a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f44964a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, String> f19871a = null;

        public a(Context context) {
            this.f44964a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(tn5.f44963a, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(tn5.f44963a, "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(tn5.f44963a, "Application info not found.");
                return null;
            }
        }

        public final Map<String, String> a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w(tn5.f44963a, "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith(tn5.b)) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        @Nullable
        public BackendFactory b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (BackendFactory) Class.forName(str2).asSubclass(BackendFactory.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w(tn5.f44963a, String.format("Class %s is not found.", str2), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w(tn5.f44963a, String.format("Could not instantiate %s.", str2), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w(tn5.f44963a, String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w(tn5.f44963a, String.format("Could not instantiate %s", str2), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w(tn5.f44963a, String.format("Could not instantiate %s", str2), e5);
                return null;
            }
        }

        public final Map<String, String> c() {
            if (this.f19871a == null) {
                this.f19871a = a(this.f44964a);
            }
            return this.f19871a;
        }
    }

    @Inject
    public tn5(Context context, ux1 ux1Var) {
        this(new a(context), ux1Var);
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    @Nullable
    public synchronized TransportBackend a(String str) {
        if (this.f19870a.containsKey(str)) {
            return this.f19870a.get(str);
        }
        BackendFactory backendFactoryB = this.f19868a.b(str);
        if (backendFactoryB == null) {
            return null;
        }
        TransportBackend transportBackendCreate = backendFactoryB.create(this.f19869a.a(str));
        this.f19870a.put(str, transportBackendCreate);
        return transportBackendCreate;
    }

    public tn5(a aVar, ux1 ux1Var) {
        this.f19870a = new HashMap();
        this.f19868a = aVar;
        this.f19869a = ux1Var;
    }
}
