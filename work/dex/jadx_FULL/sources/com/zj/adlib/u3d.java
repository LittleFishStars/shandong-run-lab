package com.zj.adlib;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.upstream.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u3d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45060a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f19959a = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    public static final String[] b;
    public static final String[] c;

    static {
        String[] strArr = new String[2];
        strArr[0] = "media";
        String str = Build.HARDWARE;
        strArr[1] = true != (str.equals("goldfish") || str.equals("ranchu")) ? "" : "androidx.test.services.storage.runfiles";
        b = strArr;
        c = new String[]{"", "", "com.google.android.apps.docs.storage.legacy"};
    }

    public static AssetFileDescriptor a(Context context, Uri uri, String str) throws FileNotFoundException {
        pzc pzcVar = pzc.f44092a;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriC = c(uri);
        String scheme = uriC.getScheme();
        if (c.h.equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(uriC, "r");
        }
        if ("content".equals(scheme)) {
            if (!i(context, uriC, 1, pzcVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriC, "r");
            d(assetFileDescriptorOpenAssetFileDescriptor);
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uriC, "r");
        d(assetFileDescriptorOpenAssetFileDescriptor2);
        try {
            h(context, assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor(), uriC, pzcVar);
            return assetFileDescriptorOpenAssetFileDescriptor2;
        } catch (FileNotFoundException e) {
            f(assetFileDescriptorOpenAssetFileDescriptor2, e);
            throw e;
        } catch (IOException e2) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e2);
            f(assetFileDescriptorOpenAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    public static InputStream b(Context context, Uri uri, pzc pzcVar) throws IllegalAccessException, FileNotFoundException, InvocationTargetException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriC = c(uri);
        String scheme = uriC.getScheme();
        if (c.h.equals(scheme)) {
            return contentResolver.openInputStream(uriC);
        }
        if ("content".equals(scheme)) {
            if (!i(context, uriC, 1, pzcVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uriC);
            d(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(uriC.getPath()).getCanonicalFile()), "r");
            try {
                h(context, parcelFileDescriptorOpenFileDescriptor, uriC, pzcVar);
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorOpenFileDescriptor);
            } catch (FileNotFoundException e) {
                g(parcelFileDescriptorOpenFileDescriptor, e);
                throw e;
            } catch (IOException e2) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e2);
                g(parcelFileDescriptorOpenFileDescriptor, fileNotFoundException);
                throw fileNotFoundException;
            }
        } catch (IOException e3) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
            fileNotFoundException2.initCause(e3);
            throw fileNotFoundException2;
        }
    }

    public static Uri c(Uri uri) {
        return Build.VERSION.SDK_INT < 30 ? Uri.parse(uri.toString()) : uri;
    }

    public static Object d(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    public static String e(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith(WVNativeCallbackUtil.SEPERATER) ? canonicalPath.concat(WVNativeCallbackUtil.SEPERATER) : canonicalPath;
    }

    public static void f(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) throws IllegalAccessException, InvocationTargetException {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e);
        }
    }

    public static void g(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) throws IllegalAccessException, InvocationTargetException {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e);
        }
    }

    public static void h(final Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, pzc pzcVar) throws IOException {
        File dataDir;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        jnd jndVarA = jnd.a(parcelFileDescriptor.getFileDescriptor());
        jnd jndVarB = jnd.b(canonicalPath);
        if (jndVarB.f17441a) {
            throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(canonicalPath)));
        }
        if (jndVarA.f42628a != jndVarB.f42628a || jndVarA.b != jndVarB.b) {
            throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(canonicalPath)));
        }
        if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
            pzc.a(pzcVar);
            File dataDir2 = ContextCompat.getDataDir(context);
            boolean z = true;
            if (dataDir2 == null ? !canonicalPath.startsWith(e(Environment.getDataDirectory())) : !canonicalPath.startsWith(e(dataDir2))) {
                Context contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                if (contextCreateDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(contextCreateDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(e(dataDir))) {
                    File[] fileArrJ = j(new Callable() { // from class: com.zj.adlib.sec
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Context context2 = context;
                            int i = u3d.f45060a;
                            return ContextCompat.getExternalFilesDirs(context2, null);
                        }
                    });
                    int length = fileArrJ.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            File file = fileArrJ[i];
                            if (file != null && canonicalPath.startsWith(e(file))) {
                                break;
                            } else {
                                i++;
                            }
                        } else {
                            File[] fileArrJ2 = j(new Callable() { // from class: com.zj.adlib.vhc
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    Context context2 = context;
                                    int i2 = u3d.f45060a;
                                    return ContextCompat.getExternalCacheDirs(context2);
                                }
                            });
                            int length2 = fileArrJ2.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length2) {
                                    File file2 = fileArrJ2[i2];
                                    if (file2 != null && canonicalPath.startsWith(e(file2))) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (z == pzcVar.f18969a) {
                return;
            }
        }
        throw new FileNotFoundException("Can't open file: ".concat(canonicalPath));
    }

    public static boolean i(Context context, Uri uri, int i, pzc pzcVar) {
        String authority = uri.getAuthority();
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider == null) {
            int iLastIndexOf = authority.lastIndexOf(64);
            if (iLastIndexOf >= 0) {
                authority = authority.substring(iLastIndexOf + 1);
                providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (providerInfoResolveContentProvider == null) {
                return !pzcVar.f18969a;
            }
        }
        if (pzc.c(pzcVar, context, new dpd(uri, providerInfoResolveContentProvider, authority)) - 1 == 1) {
            return false;
        }
        if (context.getPackageName().equals(providerInfoResolveContentProvider.packageName)) {
            return pzcVar.f18969a;
        }
        if (pzcVar.f18969a) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && providerInfoResolveContentProvider.exported) {
            String[] strArr = b;
            int length = strArr.length;
            for (int i2 = 0; i2 < 2; i2++) {
                if (strArr[i2].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = c;
            int length2 = strArr2.length;
            for (int i3 = 0; i3 < 3; i3++) {
                if (strArr2[i3].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = f19959a;
            for (int i4 = 0; i4 < 6; i4++) {
                String str = strArr3[i4];
                if (str.charAt(str.length() - 1) == '.') {
                    if (providerInfoResolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (providerInfoResolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static File[] j(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
