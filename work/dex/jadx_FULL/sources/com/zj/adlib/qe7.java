package com.zj.adlib;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover;
import com.google.mlkit.common.sdkinternal.model.RemoteModelLoaderHelper;
import com.google.mlkit.common.sdkinternal.model.a;
import com.google.mlkit.common.sdkinternal.model.b;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class qe7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f44193a = new su3("RemoteModelLoader", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("RemoteModelLoader.class")
    public static final Map f19075a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RemoteModel f19076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RemoteModelLoaderHelper f19077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f19078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f19079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hnd f19080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f19081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19082a;

    public qe7(@NonNull hq5 hq5Var, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        b bVar = new b(hq5Var, remoteModel, modelValidator, new qq5(hq5Var), remoteModelFileMover);
        this.f19079a = bVar;
        this.f19082a = true;
        this.f19078a = a.g(hq5Var, remoteModel, new qq5(hq5Var), bVar, (ModelInfoRetrieverInterop) hq5Var.a(ModelInfoRetrieverInterop.class));
        this.f19077a = remoteModelLoaderHelper;
        this.f19081a = hq5Var;
        this.f19076a = remoteModel;
        this.f19080a = iod.b("common");
    }

    @NonNull
    @KeepForSdk
    public static synchronized qe7 a(@NonNull hq5 hq5Var, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        String strF;
        Map map;
        strF = remoteModel.f();
        map = f19075a;
        if (!map.containsKey(strF)) {
            map.put(strF, new qe7(hq5Var, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
        }
        return (qe7) map.get(strF);
    }

    @NonNull
    @KeepForSdk
    public RemoteModel b() {
        return this.f19076a;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00b5 A[Catch: all -> 0x00f6, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:26:0x00b5, B:28:0x00c4, B:30:0x00cc, B:33:0x00d2, B:34:0x00f0, B:35:0x00f1, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x006d, B:19:0x0075, B:20:0x0087, B:22:0x008f, B:23:0x00a6), top: B:42:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c4 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:26:0x00b5, B:28:0x00c4, B:30:0x00cc, B:33:0x00d2, B:34:0x00f0, B:35:0x00f1, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x006d, B:19:0x0075, B:20:0x0087, B:22:0x008f, B:23:0x00a6), top: B:42:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f1 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:26:0x00b5, B:28:0x00c4, B:30:0x00cc, B:33:0x00d2, B:34:0x00f0, B:35:0x00f1, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x006d, B:19:0x0075, B:20:0x0087, B:22:0x008f, B:23:0x00a6), top: B:42:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized MappedByteBuffer c() throws MlKitException {
        MappedByteBuffer mappedByteBufferD;
        MappedByteBuffer mappedByteBufferE;
        String strD;
        su3 su3Var = f44193a;
        su3Var.c("RemoteModelLoader", "Try to load newly downloaded model file.");
        boolean z = this.f19082a;
        Long lC = this.f19078a.c();
        String strD2 = this.f19078a.d();
        mappedByteBufferD = null;
        if (lC == null || strD2 == null) {
            su3Var.c("RemoteModelLoader", "No new model is downloading.");
            this.f19078a.j();
        } else {
            Integer numE = this.f19078a.e();
            if (numE == null) {
                this.f19078a.j();
            } else {
                su3Var.c("RemoteModelLoader", "Download Status code: ".concat(numE.toString()));
                if (numE.intValue() == 8) {
                    File fileU = this.f19078a.u(strD2);
                    if (fileU != null) {
                        mappedByteBufferE = e(fileU);
                        su3Var.c("RemoteModelLoader", "Moved the downloaded model to private folder successfully: ".concat(String.valueOf(fileU.getParent())));
                        this.f19078a.l(strD2);
                        if (z && this.f19079a.f(fileU)) {
                            su3Var.c("RemoteModelLoader", "All old models are deleted.");
                            mappedByteBufferE = e(this.f19079a.c(fileU));
                        }
                    }
                    if (mappedByteBufferE == null) {
                        su3Var.c("RemoteModelLoader", "Loading existing model file.");
                        strD = this.f19079a.d();
                        if (strD == null) {
                            su3Var.c("RemoteModelLoader", "No existing model file");
                        } else {
                            try {
                                mappedByteBufferD = d(strD);
                            } catch (Exception e) {
                                this.f19079a.e(new File(strD));
                                e98.g(this.f19081a).c(this.f19076a);
                                throw new MlKitException("Failed to load an already downloaded model.", 14, e);
                            }
                        }
                    } else {
                        this.f19082a = false;
                        mappedByteBufferD = mappedByteBufferE;
                    }
                } else if (numE.intValue() == 16) {
                    this.f19080a.e(snd.g(), this.f19076a, false, this.f19078a.f(lC));
                    this.f19078a.j();
                }
            }
        }
        mappedByteBufferE = null;
        if (mappedByteBufferE == null) {
            su3Var.c("RemoteModelLoader", "Loading existing model file.");
            strD = this.f19079a.d();
            if (strD == null) {
                su3Var.c("RemoteModelLoader", "No existing model file");
            } else {
                mappedByteBufferD = d(strD);
            }
        } else {
            this.f19082a = false;
            mappedByteBufferD = mappedByteBufferE;
        }
        return mappedByteBufferD;
    }

    @NonNull
    @WorkerThread
    public final MappedByteBuffer d(@NonNull String str) throws MlKitException {
        return this.f19077a.a(str);
    }

    public final MappedByteBuffer e(File file) throws MlKitException {
        try {
            return d(file.getAbsolutePath());
        } catch (Exception e) {
            this.f19079a.e(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e);
        }
    }
}
