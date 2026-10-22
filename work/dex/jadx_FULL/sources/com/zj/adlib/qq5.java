package com.zj.adlib;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class qq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public static final int f44277a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final su3 f19161a = new su3("ModelFileHelper", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @VisibleForTesting
    public static final String f19162a = String.format("com.google.mlkit.%s.models", "translate");

    @NonNull
    @VisibleForTesting
    public static final String b = String.format("com.google.mlkit.%s.models", "custom");

    @VisibleForTesting
    public static final String c = String.format("com.google.mlkit.%s.models", "base");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f19163a;

    public qq5(@NonNull hq5 hq5Var) {
        this.f19163a = hq5Var;
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void a(@NonNull ModelType modelType, @NonNull String str) {
        b(f(str, modelType, false));
        b(f(str, modelType, true));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032 A[RETURN] */
    @KeepForSdk
    @WorkerThread
    public boolean b(@Nullable File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            boolean z = true;
            for (File file2 : (File[]) yw6.l(file.listFiles())) {
                z = z && b(file2);
            }
            if (z) {
                if (file.delete()) {
                    return true;
                }
            }
        } else if (file.delete()) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    @WorkerThread
    public void c(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File fileL = l(str, modelType, true);
        if (b(fileL)) {
            return;
        }
        f19161a.e("ModelFileHelper", "Failed to delete the temp labels file directory: ".concat(String.valueOf(fileL != null ? fileL.getAbsolutePath() : null)));
    }

    @KeepForSdk
    @WorkerThread
    public int d(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        int iMax = -1;
        if (fileArrListFiles != null && (fileArrListFiles.length) != 0) {
            for (File file2 : fileArrListFiles) {
                try {
                    iMax = Math.max(iMax, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    f19161a.c("ModelFileHelper", "Contains non-integer file name ".concat(String.valueOf(file2.getName())));
                }
            }
        }
        return iMax;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File e(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return l(str, modelType, false);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File f(@NonNull String str, @NonNull ModelType modelType, boolean z) {
        String str2;
        ModelType modelType2 = ModelType.UNKNOWN;
        int iOrdinal = modelType.ordinal();
        if (iOrdinal == 1) {
            str2 = c;
        } else if (iOrdinal == 2) {
            str2 = f19162a;
        } else {
            if (iOrdinal != 4) {
                throw new IllegalArgumentException("Unknown model type " + modelType.name() + ". Cannot find a dir to store the downloaded model.");
            }
            str2 = b;
        }
        File file = new File(this.f19163a.b().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File g(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return l(str, modelType, true);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public File h(@NonNull String str, @NonNull ModelType modelType, @NonNull String str2) throws MlKitException {
        File fileL = l(str, modelType, true);
        if (fileL.exists() && fileL.isFile() && !fileL.delete()) {
            throw new MlKitException("Failed to delete the temp labels file: ".concat(String.valueOf(fileL.getAbsolutePath())), 13);
        }
        if (!fileL.exists()) {
            f19161a.c("ModelFileHelper", "Temp labels folder does not exist, creating one: ".concat(String.valueOf(fileL.getAbsolutePath())));
            if (!fileL.mkdirs()) {
                throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
            }
        }
        return new File(fileL, str2);
    }

    @KeepForSdk
    @WorkerThread
    public boolean i(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        String strK;
        if (modelType == ModelType.UNKNOWN || (strK = k(str, modelType)) == null) {
            return false;
        }
        File file = new File(strK);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, qt1.f44294a);
        f19161a.h("ModelFileHelper", "Model file path: ".concat(String.valueOf(file2.getAbsolutePath())));
        return file2.exists();
    }

    @NonNull
    @WorkerThread
    public final File j(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return l(str, modelType, true);
    }

    @Nullable
    @WorkerThread
    public final String k(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        File fileE = e(str, modelType);
        int iD = d(fileE);
        if (iD == -1) {
            return null;
        }
        return fileE.getAbsolutePath() + WVNativeCallbackUtil.SEPERATER + iD;
    }

    @WorkerThread
    public final File l(@NonNull String str, @NonNull ModelType modelType, boolean z) throws MlKitException {
        File fileF = f(str, modelType, z);
        if (!fileF.exists()) {
            f19161a.c("ModelFileHelper", "model folder does not exist, creating one: ".concat(String.valueOf(fileF.getAbsolutePath())));
            if (!fileF.mkdirs()) {
                throw new MlKitException("Failed to create model folder: ".concat(String.valueOf(fileF)), 13);
            }
        } else if (!fileF.isDirectory()) {
            throw new MlKitException("Can not create model folder, since an existing file has the same name: ".concat(String.valueOf(fileF)), 6);
        }
        return fileF;
    }
}
