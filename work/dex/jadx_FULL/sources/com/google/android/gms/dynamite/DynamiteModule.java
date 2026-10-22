package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.zj.adlib.i76;
import com.zj.adlib.lbc;
import com.zj.adlib.lld;
import com.zj.adlib.qec;
import com.zj.adlib.qv3;
import com.zj.adlib.thc;
import com.zj.adlib.u15;
import com.zj.adlib.wgd;
import com.zj.adlib.yw1;
import com.zj.adlib.yw6;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class DynamiteModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public static final int f31325a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzq f5723a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static zzr f5724a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static Boolean f5725a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static String f5726a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("DynamiteModule.class")
    public static boolean f5728a = false;

    @KeepForSdk
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    @GuardedBy("DynamiteModule.class")
    public static Boolean f5730b = null;

    @KeepForSdk
    public static final int c = 0;

    @KeepForSdk
    public static final int d = 0;

    @GuardedBy("DynamiteModule.class")
    public static int e = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f5735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadLocal f5727a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ThreadLocal f5731b = new thc();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final VersionPolicy.IVersions f5721a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final VersionPolicy f5722a = new b();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final VersionPolicy f5729b = new c();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final VersionPolicy f5732c = new d();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final VersionPolicy f5733d = new e();

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final VersionPolicy f5734e = new f();

    @NonNull
    @KeepForSdk
    public static final VersionPolicy f = new g();

    @NonNull
    public static final VersionPolicy g = new h();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {

        @Nullable
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, lld lldVar) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, lld lldVar) {
            super(str, th);
        }
    }

    public interface VersionPolicy {

        @KeepForSdk
        public interface IVersions {
            int a(@NonNull Context context, @NonNull String str);

            int b(@NonNull Context context, @NonNull String str, boolean z) throws LoadingException;
        }

        @KeepForSdk
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @KeepForSdk
            public int f31326a = 0;

            @KeepForSdk
            public int b = 0;

            @KeepForSdk
            public int c = 0;
        }

        @NonNull
        @KeepForSdk
        a a(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    public DynamiteModule(Context context) {
        yw6.l(context);
        this.f5735a = context;
    }

    @KeepForSdk
    public static int a(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (i76.b(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int c(@NonNull Context context, @NonNull String str) {
        return f(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0203 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x020c A[Catch: all -> 0x0215, TRY_ENTER, TryCatch #2 {, blocks: (B:29:0x00a2, B:31:0x00a8, B:32:0x00aa, B:102:0x020c, B:103:0x0214), top: B:152:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0290 A[Catch: all -> 0x02d9, TryCatch #5 {all -> 0x02d9, blocks: (B:108:0x0219, B:109:0x0224, B:111:0x0226, B:113:0x0228, B:114:0x0230, B:132:0x0290, B:133:0x02a7, B:116:0x0232, B:118:0x0250, B:120:0x0261, B:130:0x0287, B:131:0x028f, B:134:0x02a8, B:135:0x02d8, B:26:0x009d), top: B:153:0x006a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x007d A[Catch: all -> 0x02dd, TRY_LEAVE, TryCatch #7 {all -> 0x02dd, blocks: (B:3:0x0025, B:7:0x006f, B:12:0x0077, B:15:0x007d, B:26:0x009d), top: B:156:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0085  */
    /* JADX WARN: Code duplicated, block: B:19:0x0089  */
    /* JADX WARN: Code duplicated, block: B:22:0x0094  */
    /* JADX WARN: Code duplicated, block: B:25:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a8 A[Catch: all -> 0x0215, TryCatch #2 {, blocks: (B:29:0x00a2, B:31:0x00a8, B:32:0x00aa, B:102:0x020c, B:103:0x0214), top: B:152:0x00a2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00da A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0150 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x015c A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0180 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0187 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x018f A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x019e A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x01a9 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01b9 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01ce A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TRY_LEAVE, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01db  */
    /* JADX WARN: Code duplicated, block: B:90:0x01df  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f1 A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01fa A[Catch: all -> 0x0218, LoadingException -> 0x0225, RemoteException -> 0x0227, TryCatch #8 {RemoteException -> 0x0227, LoadingException -> 0x0225, all -> 0x0218, blocks: (B:28:0x00a1, B:34:0x00ad, B:36:0x00b4, B:37:0x00d4, B:41:0x00da, B:43:0x00e2, B:45:0x00e6, B:46:0x00f2, B:53:0x00ff, B:55:0x0105, B:57:0x012c, B:59:0x0134, B:60:0x013b, B:61:0x0143, B:56:0x0119, B:64:0x0146, B:65:0x0147, B:66:0x014f, B:67:0x0150, B:68:0x0158, B:71:0x015b, B:72:0x015c, B:74:0x0180, B:76:0x0187, B:78:0x018f, B:84:0x01c8, B:86:0x01ce, B:96:0x01f1, B:97:0x01f9, B:79:0x019e, B:80:0x01a6, B:82:0x01a9, B:83:0x01b9, B:98:0x01fa, B:99:0x0202, B:100:0x0203, B:101:0x020b, B:106:0x0217), top: B:157:0x00a1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:132:0x0290, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00b4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x015c, please report this as an issue */
    @NonNull
    @KeepForSdk
    public static DynamiteModule e(@NonNull Context context, @NonNull VersionPolicy versionPolicy, @NonNull String str) throws Throwable {
        long j;
        int i;
        Boolean bool;
        zzq zzqVarL;
        int iZze;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule;
        wgd wgdVar;
        Cursor cursor;
        zzr zzrVar;
        wgd wgdVar2;
        Boolean boolValueOf;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor2;
        ThreadLocal threadLocal = f5727a;
        wgd wgdVar3 = (wgd) threadLocal.get();
        wgd wgdVar4 = new wgd(null);
        threadLocal.set(wgdVar4);
        ThreadLocal threadLocal2 = f5731b;
        long jLongValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.a aVarA = versionPolicy.a(context, str, f5721a);
            Log.i("DynamiteModule", "Considering local module " + str + u15.f19942b + aVarA.f31326a + " and remote module " + str + u15.f19942b + aVarA.b);
            int i2 = aVarA.c;
            try {
                if (i2 != 0) {
                    if (i2 != -1) {
                        if (i2 == 1 || aVarA.b != 0) {
                            if (i2 == -1) {
                                DynamiteModule dynamiteModuleH = h(context, str);
                                if (jLongValue == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(jLongValue));
                                }
                                cursor2 = wgdVar4.f45594a;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                threadLocal.set(wgdVar3);
                                return dynamiteModuleH;
                            }
                            if (i2 == 1) {
                                throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                            }
                            try {
                                i = aVarA.b;
                                try {
                                    synchronized (DynamiteModule.class) {
                                        if (k(context)) {
                                            throw new LoadingException("Remote loading disabled", null);
                                        }
                                        bool = f5725a;
                                    }
                                    if (bool != null) {
                                        throw new LoadingException("Failed to determine which loading route to use.", null);
                                    }
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                        synchronized (DynamiteModule.class) {
                                            zzrVar = f5724a;
                                        }
                                        if (zzrVar != null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        wgdVar2 = (wgd) threadLocal.get();
                                        if (wgdVar2 != null || wgdVar2.f45594a == null) {
                                            throw new LoadingException("No result cursor", null);
                                        }
                                        Context applicationContext = context.getApplicationContext();
                                        Cursor cursor3 = wgdVar2.f45594a;
                                        ObjectWrapper.wrap(null);
                                        synchronized (DynamiteModule.class) {
                                            boolValueOf = Boolean.valueOf(e >= 2);
                                        }
                                        if (boolValueOf.booleanValue()) {
                                            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                            iObjectWrapperZze = zzrVar.zzf(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor3));
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                            iObjectWrapperZze = zzrVar.zze(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor3));
                                        }
                                        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                        if (context2 == null) {
                                            throw new LoadingException("Failed to get module context", null);
                                        }
                                        dynamiteModule = new DynamiteModule(context2);
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                        zzqVarL = l(context);
                                        if (zzqVarL != null) {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                        iZze = zzqVarL.zze();
                                        if (iZze >= 3) {
                                            wgdVar = (wgd) threadLocal.get();
                                            if (wgdVar != null) {
                                                throw new LoadingException("No cached result cursor holder", null);
                                            }
                                            iObjectWrapperZzh = zzqVarL.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(wgdVar.f45594a));
                                        } else if (iZze == 2) {
                                            Log.w("DynamiteModule", "IDynamite loader version = 2");
                                            iObjectWrapperZzh = zzqVarL.zzj(ObjectWrapper.wrap(context), str, i);
                                        } else {
                                            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                            iObjectWrapperZzh = zzqVarL.zzh(ObjectWrapper.wrap(context), str, i);
                                        }
                                        objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                        if (objUnwrap != null) {
                                            throw new LoadingException("Failed to load remote module.", null);
                                        }
                                        dynamiteModule = new DynamiteModule((Context) objUnwrap);
                                    }
                                    if (jLongValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(jLongValue));
                                    }
                                    cursor = wgdVar4.f45594a;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    threadLocal.set(wgdVar3);
                                    return dynamiteModule;
                                } catch (RemoteException e2) {
                                    throw new LoadingException("Failed to load remote module.", e2, null);
                                } catch (LoadingException e3) {
                                    throw e3;
                                } catch (Throwable th) {
                                    yw1.a(context, th);
                                    throw new LoadingException("Failed to load remote module.", th, null);
                                }
                            } catch (LoadingException e4) {
                                Log.w("DynamiteModule", "Failed to load remote module: " + e4.getMessage());
                                int i3 = aVarA.f31326a;
                                if (i3 == 0 || versionPolicy.a(context, str, new i(i3, 0)).c != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e4, null);
                                }
                                DynamiteModule dynamiteModuleH2 = h(context, str);
                                if (jLongValue == 0) {
                                    f5731b.remove();
                                } else {
                                    f5731b.set(Long.valueOf(jLongValue));
                                }
                                Cursor cursor4 = wgdVar4.f45594a;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                f5727a.set(wgdVar3);
                                return dynamiteModuleH2;
                            }
                        }
                    } else if (aVarA.f31326a != 0) {
                        i2 = -1;
                        if (i2 == 1) {
                        }
                        if (i2 == -1) {
                            DynamiteModule dynamiteModuleH3 = h(context, str);
                            if (jLongValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(jLongValue));
                            }
                            cursor2 = wgdVar4.f45594a;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            threadLocal.set(wgdVar3);
                            return dynamiteModuleH3;
                        }
                        if (i2 == 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                        }
                        i = aVarA.b;
                        synchronized (DynamiteModule.class) {
                            if (k(context)) {
                                throw new LoadingException("Remote loading disabled", null);
                            }
                            bool = f5725a;
                            if (bool != null) {
                                throw new LoadingException("Failed to determine which loading route to use.", null);
                            }
                            if (bool.booleanValue()) {
                                Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                synchronized (DynamiteModule.class) {
                                    zzrVar = f5724a;
                                    if (zzrVar != null) {
                                        throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                    }
                                    wgdVar2 = (wgd) threadLocal.get();
                                    if (wgdVar2 != null) {
                                    }
                                    throw new LoadingException("No result cursor", null);
                                }
                            }
                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                            zzqVarL = l(context);
                            if (zzqVarL != null) {
                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                            }
                            iZze = zzqVarL.zze();
                            if (iZze >= 3) {
                                wgdVar = (wgd) threadLocal.get();
                                if (wgdVar != null) {
                                    throw new LoadingException("No cached result cursor holder", null);
                                }
                                iObjectWrapperZzh = zzqVarL.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(wgdVar.f45594a));
                            } else if (iZze == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                iObjectWrapperZzh = zzqVarL.zzj(ObjectWrapper.wrap(context), str, i);
                            } else {
                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                iObjectWrapperZzh = zzqVarL.zzh(ObjectWrapper.wrap(context), str, i);
                            }
                            objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                            if (objUnwrap != null) {
                                throw new LoadingException("Failed to load remote module.", null);
                            }
                            dynamiteModule = new DynamiteModule((Context) objUnwrap);
                            if (jLongValue == 0) {
                                threadLocal2.remove();
                            } else {
                                threadLocal2.set(Long.valueOf(jLongValue));
                            }
                            cursor = wgdVar4.f45594a;
                            if (cursor != null) {
                                cursor.close();
                            }
                            threadLocal.set(wgdVar3);
                            return dynamiteModule;
                        }
                    }
                }
                throw new LoadingException("No acceptable module " + str + " found. Local version is " + aVarA.f31326a + " and remote version is " + aVarA.b + Consts.DOT, null);
            } catch (Throwable th2) {
                th = th2;
                j = 0;
                if (jLongValue == j) {
                    f5731b.remove();
                } else {
                    f5731b.set(Long.valueOf(jLongValue));
                }
                Cursor cursor5 = wgdVar4.f45594a;
                if (cursor5 != null) {
                    cursor5.close();
                }
                f5727a.set(wgdVar3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j = 0;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:135:0x01b6 */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7 A[Catch: all -> 0x00b2, TryCatch #5 {, blocks: (B:9:0x0026, B:11:0x0032, B:48:0x00b0, B:14:0x0038, B:16:0x003f, B:18:0x0045, B:21:0x0048, B:23:0x004c, B:27:0x0056, B:29:0x005e, B:32:0x0065, B:39:0x008f, B:40:0x0097, B:35:0x006c, B:37:0x0072, B:38:0x0081, B:43:0x009a, B:46:0x009d, B:47:0x00a7, B:15:0x003b), top: B:129:0x0026, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0166 A[Catch: all -> 0x01c2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01c2, blocks: (B:3:0x0002, B:61:0x00d9, B:63:0x00df, B:68:0x0100, B:90:0x0158, B:94:0x0166, B:115:0x01bb, B:116:0x01be, B:110:0x01b3, B:66:0x00e5, B:119:0x01c1, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:59:0x00d6, B:19:0x0046, B:41:0x0098, B:44:0x009b, B:52:0x00b4, B:60:0x00d8, B:58:0x00ba), top: B:128:0x0002, inners: #9, #12 }] */
    public static int f(@NonNull Context context, @NonNull String str, boolean z) {
        Throwable th;
        RemoteException e2;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f5725a;
                Cursor cursor2 = null;
                int iZzf = 0;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else if (classLoader != null) {
                                try {
                                    i(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            } else {
                                if (!k(context)) {
                                    return 0;
                                }
                                if (f5728a) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    Boolean bool2 = Boolean.TRUE;
                                    if (bool2.equals(null)) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iG = g(context, str, z, true);
                                            String str2 = f5726a;
                                            if (str2 != null && !str2.isEmpty()) {
                                                ClassLoader classLoaderA = lbc.a();
                                                if (classLoaderA == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        String str3 = f5726a;
                                                        yw6.l(str3);
                                                        classLoaderA = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                    } else {
                                                        String str4 = f5726a;
                                                        yw6.l(str4);
                                                        classLoaderA = new qec(str4, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                i(classLoaderA);
                                                declaredField.set(null, classLoaderA);
                                                f5725a = bool2;
                                                return iG;
                                            }
                                            return iG;
                                        } catch (LoadingException unused2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                }
                            }
                            f5725a = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e3.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return g(context, str, z, false);
                    } catch (LoadingException e4) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e4.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarL = l(context);
                try {
                    if (zzqVarL != null) {
                        try {
                            int iZze = zzqVarL.zze();
                            if (iZze >= 3) {
                                wgd wgdVar = (wgd) f5727a.get();
                                if (wgdVar == null || (cursor = wgdVar.f45594a) == null) {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzqVarL.zzk(ObjectWrapper.wrap(context), str, z, ((Long) f5731b.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i = cursor3.getInt(0);
                                                cursor2 = (i <= 0 || !j(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iZzf = i;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e5) {
                                            e2 = e5;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e2.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iZzf = cursor.getInt(0);
                                }
                            } else if (iZze == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iZzf = zzqVarL.zzg(ObjectWrapper.wrap(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iZzf = zzqVarL.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e6) {
                            e2 = e6;
                        }
                    }
                    return iZzf;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            yw1.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00c9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static int g(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception e2;
        ?? r0 = 0;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) f5731b.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    f5726a = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        e = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        f5728a = z3;
                                        z4 = z3;
                                    }
                                }
                                if (j(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r2 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        if (e2 instanceof LoadingException) {
                            throw e2;
                        }
                        throw new LoadingException("V2 version check failed", e2, r1 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r3 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r0 = context;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
        } catch (Throwable th3) {
            th = th3;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    public static void i(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        lld lldVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            f5724a = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, lldVar);
        }
    }

    public static boolean j(Cursor cursor) {
        wgd wgdVar = (wgd) f5727a.get();
        if (wgdVar == null || wgdVar.f45594a != null) {
            return false;
        }
        wgdVar.f45594a = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    public static boolean k(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f5730b)) {
            return true;
        }
        boolean zBooleanValue = false;
        if (f5730b == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (qv3.i().k(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                zBooleanValue = true;
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            f5730b = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
            if (zBooleanValue && providerInfoResolveContentProvider != null && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f5728a = true;
            }
        }
        if (!zBooleanValue) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return zBooleanValue;
    }

    @Nullable
    public static zzq l(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = f5723a;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    f5723a = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public Context b() {
        return this.f5735a;
    }

    @NonNull
    @KeepForSdk
    public IBinder d(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.f5735a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e2, null);
        }
    }
}
