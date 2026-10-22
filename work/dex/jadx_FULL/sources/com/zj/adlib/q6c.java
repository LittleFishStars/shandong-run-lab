package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class q6c implements RemoteModelFileMover {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f44140a = new su3("CustomModelFileMover", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qq5 f19021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19022a;

    public q6c(@NonNull hq5 hq5Var, @NonNull String str) {
        this.f19022a = str;
        this.f19021a = new qq5(hq5Var);
    }

    public static boolean c(File file, File file2) {
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (file.renameTo(file2)) {
            f44140a.c("CustomModelFileMover", String.format("Moved file from %s to %s successfully", absolutePath, absolutePath2));
            file2.setExecutable(false);
            file2.setWritable(false);
            return true;
        }
        su3 su3Var = f44140a;
        su3Var.c("CustomModelFileMover", String.format("Move file to %s failed, remove the temp file %s.", absolutePath2, absolutePath));
        if (!file.delete()) {
            su3Var.c("CustomModelFileMover", "Failed to delete the temp file: ".concat(String.valueOf(absolutePath)));
        }
        return false;
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover
    @Nullable
    public final File a(File file) throws MlKitException {
        File file2;
        qq5 qq5Var = this.f19021a;
        String str = this.f19022a;
        ModelType modelType = ModelType.CUSTOM;
        File fileE = qq5Var.e(str, modelType);
        File file3 = new File(new File(fileE, String.valueOf(this.f19021a.d(fileE) + 1)), qt1.f44294a);
        File parentFile = file3.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            ((File) yw6.l(parentFile)).mkdirs();
        }
        File file4 = null;
        if (!c(file, file3)) {
            return null;
        }
        File fileH = this.f19021a.h(this.f19022a, modelType, "labels.txt");
        if (fileH.exists()) {
            file2 = new File(parentFile, "labels.txt");
            if (!c(fileH, file2)) {
                return null;
            }
        } else {
            file2 = null;
        }
        File fileH2 = this.f19021a.h(this.f19022a, modelType, qt1.c);
        if (fileH2.exists()) {
            File file5 = new File(parentFile, qt1.c);
            if (!c(fileH2, file5)) {
                return null;
            }
            file4 = file5;
        }
        return (file2 == null && file4 == null) ? file3 : parentFile;
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover
    public final File b() throws MlKitException {
        File fileE = this.f19021a.e(this.f19022a, ModelType.CUSTOM);
        return new File(new File(fileE, String.valueOf(this.f19021a.d(fileE) + 1)), qt1.f44294a);
    }
}
