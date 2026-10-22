package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.zj.adlib.e98;
import com.zj.adlib.hnd;
import com.zj.adlib.hq5;
import com.zj.adlib.iod;
import com.zj.adlib.jz4;
import com.zj.adlib.kz1;
import com.zj.adlib.q6c;
import com.zj.adlib.qq5;
import com.zj.adlib.qt1;
import com.zj.adlib.snd;
import com.zj.adlib.su3;
import com.zj.adlib.yw6;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class CustomModelLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32459a = new su3("CustomModelLoader", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("CustomModelLoader.class")
    public static final Map f6630a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final a f6631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f6632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hnd f6633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f6634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final jz4 f6635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final kz1 f6636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6637a;

    @KeepForSdk
    public interface CustomModelLoaderHelper {
        @KeepForSdk
        boolean a(@NonNull jz4 jz4Var) throws MlKitException;

        @KeepForSdk
        void b() throws MlKitException;
    }

    public CustomModelLoader(@NonNull hq5 hq5Var, @Nullable jz4 jz4Var, @Nullable kz1 kz1Var) {
        if (kz1Var != null) {
            b bVar = new b(hq5Var, kz1Var, null, new qq5(hq5Var), new q6c(hq5Var, kz1Var.f()));
            this.f6632a = bVar;
            this.f6631a = a.g(hq5Var, kz1Var, new qq5(hq5Var), bVar, (ModelInfoRetrieverInterop) hq5Var.a(ModelInfoRetrieverInterop.class));
            this.f6637a = true;
        } else {
            this.f6632a = null;
            this.f6631a = null;
        }
        this.f6634a = hq5Var;
        this.f6635a = jz4Var;
        this.f6636a = kz1Var;
        this.f6633a = iod.b("common");
    }

    @NonNull
    @KeepForSdk
    public static synchronized CustomModelLoader e(@NonNull hq5 hq5Var, @Nullable jz4 jz4Var, @Nullable kz1 kz1Var) {
        String string;
        Map map;
        try {
            string = kz1Var == null ? ((jz4) yw6.l(jz4Var)).toString() : kz1Var.f();
            map = f6630a;
            if (!map.containsKey(string)) {
                map.put(string, new CustomModelLoader(hq5Var, jz4Var, kz1Var));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (CustomModelLoader) map.get(string);
    }

    @WorkerThread
    public static final jz4 i(File file) {
        if (file.isDirectory()) {
            jz4.a aVar = new jz4.a();
            aVar.c(new File(file.getAbsolutePath(), qt1.c).toString());
            return aVar.a();
        }
        jz4.a aVar2 = new jz4.a();
        aVar2.b(file.getAbsolutePath());
        return aVar2.a();
    }

    @VisibleForTesting
    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized jz4 a() throws MlKitException {
        f32459a.c("CustomModelLoader", "Try to get the latest existing model file.");
        File fileG = g();
        if (fileG == null) {
            return null;
        }
        return i(fileG);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0098 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:24:0x009a A[Catch: all -> 0x00a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0022, B:9:0x002a, B:24:0x009a, B:10:0x002e, B:12:0x0045, B:15:0x004e, B:16:0x0067, B:18:0x006f, B:19:0x008b), top: B:30:0x0001 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x0098, please report this as an issue */
    @VisibleForTesting
    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized jz4 b() throws MlKitException {
        File fileU;
        su3 su3Var = f32459a;
        su3Var.c("CustomModelLoader", "Try to get newly downloaded model file.");
        Long lC = ((a) yw6.l(this.f6631a)).c();
        String strD = this.f6631a.d();
        if (lC == null || strD == null) {
            su3Var.c("CustomModelLoader", "No new model is downloading.");
            h();
        } else {
            Integer numE = this.f6631a.e();
            if (numE == null) {
                h();
            } else {
                su3Var.c("CustomModelLoader", "Download Status code: ".concat(numE.toString()));
                if (numE.intValue() == 8) {
                    fileU = this.f6631a.u(strD);
                    if (fileU != null) {
                        su3Var.c("CustomModelLoader", "Moved the downloaded model to private folder successfully: ".concat(String.valueOf(fileU.getParent())));
                        this.f6631a.l(strD);
                    }
                    if (fileU == null) {
                        return null;
                    }
                    return i(fileU);
                }
                if (numE.intValue() == 16) {
                    this.f6633a.e(snd.g(), (RemoteModel) yw6.l(this.f6636a), false, this.f6631a.f(lC));
                    h();
                }
            }
        }
        fileU = null;
        if (fileU == null) {
            return null;
        }
        return i(fileU);
    }

    @KeepForSdk
    @VisibleForTesting
    @WorkerThread
    public void c() throws MlKitException {
        File fileG = g();
        if (fileG != null) {
            ((b) yw6.l(this.f6632a)).e(fileG);
            e98.g(this.f6634a).c((RemoteModel) yw6.l(this.f6636a));
        }
    }

    @KeepForSdk
    @VisibleForTesting
    @WorkerThread
    public void d(@NonNull jz4 jz4Var) throws MlKitException {
        File parentFile = new File((String) yw6.l(jz4Var.a())).getParentFile();
        if (!((b) yw6.l(this.f6632a)).f((File) yw6.l(parentFile))) {
            f32459a.e("CustomModelLoader", "Failed to delete old models");
        } else {
            f32459a.c("CustomModelLoader", "All old models are deleted.");
            this.f6632a.c(parentFile);
        }
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void f(@NonNull CustomModelLoaderHelper customModelLoaderHelper) throws MlKitException {
        jz4 jz4VarA = this.f6635a;
        if (jz4VarA == null) {
            jz4VarA = b();
        }
        if (jz4VarA == null) {
            jz4VarA = a();
        }
        if (jz4VarA == null) {
            throw new MlKitException("Model is not available.", 14);
        }
        while (!customModelLoaderHelper.a(jz4VarA)) {
            if (this.f6636a != null) {
                c();
                jz4VarA = a();
            } else {
                jz4VarA = null;
            }
            if (jz4VarA == null) {
                customModelLoaderHelper.b();
                return;
            }
        }
        if (this.f6636a != null && this.f6637a) {
            d((jz4) yw6.l(jz4VarA));
            this.f6637a = false;
        }
        customModelLoaderHelper.b();
    }

    @Nullable
    @WorkerThread
    public final File g() throws MlKitException {
        String strD = ((b) yw6.l(this.f6632a)).d();
        if (strD == null) {
            f32459a.c("CustomModelLoader", "No existing model file");
            return null;
        }
        File file = new File(strD);
        File[] fileArrListFiles = file.listFiles();
        return ((File[]) yw6.l(fileArrListFiles)).length == 1 ? fileArrListFiles[0] : file;
    }

    @WorkerThread
    public final void h() throws MlKitException {
        ((a) yw6.l(this.f6631a)).j();
    }
}
