package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.zj.adlib.qq5;
import com.zj.adlib.um0;
import com.zj.adlib.z09;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public abstract class LegacyModelMigrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f32460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public final qq5 f6638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z09 f6639a = new z09();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f6640a = com.google.mlkit.common.sdkinternal.b.g();

    @KeepForSdk
    public LegacyModelMigrator(@NonNull Context context, @NonNull qq5 qq5Var) {
        this.f32460a = context;
        this.f6638a = qq5Var;
    }

    @KeepForSdk
    @VisibleForTesting
    public static void c(@NonNull File file, @NonNull File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                Log.e("MlKitLegacyMigration", "Error moving model file " + String.valueOf(file) + " to " + String.valueOf(file2));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            Log.e("MlKitLegacyMigration", "Error deleting model file ".concat(String.valueOf(file)));
        }
    }

    @KeepForSdk
    public static void deleteIfEmpty(@NonNull File file) {
        File[] fileArrListFiles = file.listFiles();
        if ((fileArrListFiles == null || fileArrListFiles.length == 0) && !file.delete()) {
            Log.e("MlKitLegacyMigration", "Error deleting model directory ".concat(String.valueOf(file)));
        }
    }

    @KeepForSdk
    public static boolean isValidFirebasePersistenceKey(@NonNull String str) {
        String[] strArrSplit = str.split("\\+", -1);
        if (strArrSplit.length != 2) {
            return false;
        }
        try {
            um0.c(strArrSplit[0]);
            um0.c(strArrSplit[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @NonNull
    @KeepForSdk
    @VisibleForTesting
    public File a() {
        return new File(this.f32460a.getNoBackupFilesDir(), getLegacyModelDirName());
    }

    @NonNull
    @KeepForSdk
    public Task<Void> b() {
        return this.f6639a.a();
    }

    @KeepForSdk
    public void d() {
        this.f6640a.execute(new Runnable() { // from class: com.zj.adlib.t6c
            @Override // java.lang.Runnable
            public final void run() {
                this.f44859a.e();
            }
        });
    }

    public final /* synthetic */ void e() {
        File fileA = a();
        File[] fileArrListFiles = fileA.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                migrateAllModelDirs(file);
            }
            deleteIfEmpty(fileA);
        }
        this.f6639a.setResult(null);
    }

    @NonNull
    @KeepForSdk
    @VisibleForTesting
    public abstract String getLegacyModelDirName();

    @KeepForSdk
    public abstract void migrateAllModelDirs(@NonNull File file);
}
