package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.zj.adlib.qv3;
import com.zj.adlib.yw6;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ProviderInstaller {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public static final String f5838a = "GmsCore_OpenSSL";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qv3 f31406a = qv3.i();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5837a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("ProviderInstaller.lock")
    public static Method f5839a = null;

    @GuardedBy("ProviderInstaller.lock")
    public static Method b = null;

    public interface ProviderInstallListener {
        void a();

        void b(int i, @Nullable Intent intent);
    }

    public static void a(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context contextB;
        yw6.m(context, "Context must not be null");
        f31406a.p(context, 11925000);
        synchronized (f5837a) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                contextB = DynamiteModule.e(context, DynamiteModule.f5734e, "com.google.android.gms.providerinstaller.dynamite").b();
            } catch (DynamiteModule.LoadingException e) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e.getMessage())));
                contextB = null;
            }
            if (contextB != null) {
                e(contextB, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            Context contextI = b.i(context);
            if (contextI != null) {
                try {
                    if (b == null) {
                        Class cls = Long.TYPE;
                        b = d(contextI, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    b.invoke(null, context, Long.valueOf(jElapsedRealtime), Long.valueOf(jElapsedRealtime2));
                } catch (Exception e2) {
                    Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e2.getMessage())));
                }
            }
            if (contextI != null) {
                e(contextI, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void b(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        yw6.m(context, "Context must not be null");
        yw6.m(providerInstallListener, "Listener must not be null");
        yw6.g("Must be called on the UI thread");
        new a(context, providerInstallListener).execute(new Void[0]);
    }

    public static Method d(Context context, String str, String str2, Class[] clsArr) throws NoSuchMethodException, ClassNotFoundException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    @GuardedBy("ProviderInstaller.lock")
    public static void e(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (f5839a == null) {
                f5839a = d(context, str, "insertProvider", new Class[]{Context.class});
            }
            f5839a.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
