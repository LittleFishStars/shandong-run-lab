package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.aliyun.openapiutil.Client;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import com.zj.adlib.e60;
import com.zj.adlib.ttd;
import com.zj.adlib.uz3;
import com.zj.adlib.wud;
import com.zj.adlib.yw6;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@CheckReturnValue
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f31279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile zzaf f5637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzl f5638a = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    public static final zzl b = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    public static final zzl c = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    public static final zzl d = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f5639a = new Object();

    public static wud a(String str, zzj zzjVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return h(str, zzjVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static wud b(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, true);
    }

    public static wud c(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, false);
    }

    public static /* synthetic */ String d(boolean z, String str, zzj zzjVar) throws Exception {
        String str2 = true != (!z && h(str, zzjVar, true, false).f20574a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = e60.b(Client.HASH_SHA256);
        yw6.l(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, uz3.a(messageDigestB.digest(zzjVar.zzf())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void e(Context context) {
        if (f31279a != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f31279a = context.getApplicationContext();
        }
    }

    public static boolean f() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                return f5637a.zzg();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return false;
        }
    }

    public static boolean g() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                j();
                return f5637a.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return false;
        }
    }

    public static wud h(final String str, final zzj zzjVar, final boolean z, boolean z2) {
        try {
            j();
            yw6.l(f31279a);
            try {
                return f5637a.zzh(new zzs(str, zzjVar, z, z2), ObjectWrapper.wrap(f31279a.getPackageManager())) ? wud.b() : new ttd(new Callable() { // from class: com.google.android.gms.common.d
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return f.d(z, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return wud.d("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return wud.d("module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    public static wud i(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        wud wudVarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            yw6.l(f31279a);
            try {
                j();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.wrap(f31279a), false);
                try {
                    zzq zzqVarZze = z4 ? f5637a.zze(zzoVar) : f5637a.zzf(zzoVar);
                    if (zzqVarZze.zzb()) {
                        wudVarD = wud.f(zzqVarZze.zzc());
                    } else {
                        String strZza = zzqVarZze.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = zzqVarZze.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        wudVarD = wud.g(zzqVarZze.zzc(), zzqVarZze.zzd(), strZza, nameNotFoundException);
                    }
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    wudVarD = wud.d("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                wudVarD = wud.d("module init: ".concat(String.valueOf(e2.getMessage())), e2);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return wudVarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void j() throws DynamiteModule.LoadingException {
        if (f5637a != null) {
            return;
        }
        yw6.l(f31279a);
        synchronized (f5639a) {
            if (f5637a == null) {
                f5637a = com.google.android.gms.common.internal.zzae.zzb(DynamiteModule.e(f31279a, DynamiteModule.f5734e, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
