package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.zj.adlib.kz4;
import com.zj.adlib.qe7;
import com.zj.adlib.su3;
import com.zj.adlib.yw6;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
@WorkerThread
public class ModelLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32461a = new su3("ModelLoader", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ModelLoadingLogger f6641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public ModelLoadingState f6642a = ModelLoadingState.NO_MODEL_LOADED;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @KeepForSdk
    public final kz4 f6643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @KeepForSdk
    @VisibleForTesting
    public final qe7 f6644a;

    @KeepForSdk
    public interface ModelContentHandler {
        @KeepForSdk
        void a(@NonNull MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    @KeepForSdk
    public interface ModelLoadingLogger {
        @KeepForSdk
        void a(@NonNull List<Integer> list);
    }

    @KeepForSdk
    public enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    @KeepForSdk
    public ModelLoader(@Nullable qe7 qe7Var, @Nullable kz4 kz4Var, @NonNull ModelLoadingLogger modelLoadingLogger) {
        boolean z = true;
        if (qe7Var == null && kz4Var == null) {
            z = false;
        }
        yw6.b(z, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        yw6.l(modelLoadingLogger);
        this.f6644a = qe7Var;
        this.f6643a = kz4Var;
        this.f6641a = modelLoadingLogger;
    }

    @KeepForSdk
    public synchronized boolean a() {
        return this.f6642a == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    @KeepForSdk
    public synchronized void b(@NonNull ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean zE;
        ArrayList arrayList = new ArrayList();
        Exception e = null;
        boolean zD = false;
        try {
            zE = e(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e2) {
            exc = e2;
            zE = false;
        }
        if (zE) {
            this.f6641a.a(arrayList);
            this.f6642a = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            zD = d(modelContentHandler, arrayList);
        } catch (Exception e3) {
            e = e3;
        }
        if (zD) {
            this.f6641a.a(arrayList);
            this.f6642a = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.f6641a.a(arrayList);
        this.f6642a = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            throw new MlKitException("Remote model load failed with the model options: ".concat(String.valueOf(c())), 14, exc);
        }
        if (e == null) {
            throw new MlKitException("Cannot load any model with the model options: ".concat(String.valueOf(c())), 14);
        }
        throw new MlKitException("Local model load failed with the model options: ".concat(String.valueOf(c())), 14, e);
    }

    public final String c() {
        kz4 kz4Var = this.f6643a;
        String string = null;
        if (kz4Var != null) {
            if (kz4Var.a().b() != null) {
                string = this.f6643a.a().b();
            } else if (this.f6643a.a().a() != null) {
                string = this.f6643a.a().a();
            } else if (this.f6643a.a().c() != null) {
                string = ((Uri) yw6.l(this.f6643a.a().c())).toString();
            }
        }
        qe7 qe7Var = this.f6644a;
        return String.format("Local model path: %s. Remote model name: %s. ", string, qe7Var == null ? "unspecified" : qe7Var.b().f());
    }

    public final synchronized boolean d(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        MappedByteBuffer mappedByteBufferB;
        kz4 kz4Var = this.f6643a;
        if (kz4Var == null || (mappedByteBufferB = kz4Var.b()) == null) {
            return false;
        }
        try {
            modelContentHandler.a(mappedByteBufferB);
            f32461a.c("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e) {
            list.add(18);
            throw e;
        }
    }

    public final synchronized boolean e(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        qe7 qe7Var = this.f6644a;
        if (qe7Var != null) {
            try {
                MappedByteBuffer mappedByteBufferC = qe7Var.c();
                if (mappedByteBufferC != null) {
                    try {
                        modelContentHandler.a(mappedByteBufferC);
                        f32461a.c("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e) {
                        list.add(19);
                        throw e;
                    }
                }
                f32461a.c("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e2) {
                f32461a.c("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e2;
            }
        }
        return false;
    }
}
