package com.google.mlkit.common.sdkinternal.model;

import android.annotation.SuppressLint;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.zj.adlib.e98;
import com.zj.adlib.hq5;
import com.zj.adlib.iod;
import com.zj.adlib.mq1;
import com.zj.adlib.qq5;
import com.zj.adlib.snd;
import com.zj.adlib.su3;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32464a = new su3("RemoteModelFileManager", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ModelType f6659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ModelValidator f6660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RemoteModelFileMover f6661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e98 f6662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f6663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qq5 f6664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f6665a;

    @SuppressLint({"FirebaseLambdaLast"})
    public b(@NonNull hq5 hq5Var, @NonNull RemoteModel remoteModel, @Nullable ModelValidator modelValidator, @NonNull qq5 qq5Var, @NonNull RemoteModelFileMover remoteModelFileMover) {
        this.f6663a = hq5Var;
        ModelType modelTypeE = remoteModel.e();
        this.f6659a = modelTypeE;
        this.f6665a = modelTypeE == ModelType.TRANSLATE ? remoteModel.d() : remoteModel.f();
        this.f6660a = modelValidator;
        this.f6662a = e98.g(hq5Var);
        this.f6664a = qq5Var;
        this.f6661a = remoteModelFileMover;
    }

    @NonNull
    @KeepForSdk
    public File a(boolean z) {
        return this.f6664a.f(this.f6665a, this.f6659a, z);
    }

    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized File b(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull String str, @NonNull RemoteModel remoteModel) throws MlKitException {
        File file;
        MlKitException mlKitException;
        ModelValidator modelValidator;
        file = new File(this.f6664a.j(this.f6665a, this.f6659a), "to_be_validated_model.tmp");
        ModelValidator.ValidationResult validationResultA = null;
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = autoCloseInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        try {
                            autoCloseInputStream.close();
                        } catch (Throwable th) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                        }
                        throw th;
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    autoCloseInputStream.close();
                    boolean zD = ModelUtils.d(file, str);
                    if (zD && (modelValidator = this.f6660a) != null) {
                        validationResultA = modelValidator.a(file, remoteModel);
                        if (validationResultA.a().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                            String strA = mq1.a(this.f6663a.b());
                            this.f6662a.n(remoteModel, str, strA);
                            String strValueOf = String.valueOf(str);
                            su3 su3Var = f32464a;
                            su3Var.c("RemoteModelFileManager", "Model is not compatible. Model hash: ".concat(strValueOf));
                            su3Var.c("RemoteModelFileManager", "The current app version is: ".concat(String.valueOf(strA)));
                        }
                    }
                    if (zD && (validationResultA == null || validationResultA.c())) {
                    }
                    if (zD) {
                        mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                    } else {
                        f32464a.c("RemoteModelFileManager", "Hash does not match with expected: ".concat(String.valueOf(str)));
                        iod.b("common").f(snd.g(), remoteModel, zzlm.MODEL_HASH_MISMATCH, true, this.f6659a, zzls.SUCCEEDED);
                        mlKitException = new MlKitException("Hash does not match with expected", 102);
                    }
                    if (file.delete()) {
                        throw mlKitException;
                    }
                    f32464a.c("RemoteModelFileManager", "Failed to delete the temp file: ".concat(String.valueOf(file.getAbsolutePath())));
                    throw mlKitException;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                autoCloseInputStream.close();
                throw th4;
            }
        } catch (IOException e) {
            f32464a.e("RemoteModelFileManager", "Failed to copy downloaded model file to private folder: ".concat(e.toString()));
            return null;
        }
        return this.f6661a.a(file);
    }

    @NonNull
    @WorkerThread
    public final synchronized File c(@NonNull File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.f6664a.e(this.f6665a, this.f6659a).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        return file.renameTo(file2) ? file2 : file;
    }

    @Nullable
    @WorkerThread
    public final synchronized String d() throws MlKitException {
        return this.f6664a.k(this.f6665a, this.f6659a);
    }

    @WorkerThread
    public final synchronized void e(@NonNull File file) {
        File fileA = a(false);
        if (fileA.exists()) {
            File[] fileArrListFiles = fileA.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.equals(file)) {
                        this.f6664a.b(file);
                        return;
                    }
                }
            }
        }
    }

    @WorkerThread
    public final synchronized boolean f(@NonNull File file) throws MlKitException {
        File fileE = this.f6664a.e(this.f6665a, this.f6659a);
        if (!fileE.exists()) {
            return false;
        }
        File[] fileArrListFiles = fileE.listFiles();
        boolean z = true;
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.equals(file) && !this.f6664a.b(file2)) {
                z = false;
            }
        }
        return z;
    }
}
