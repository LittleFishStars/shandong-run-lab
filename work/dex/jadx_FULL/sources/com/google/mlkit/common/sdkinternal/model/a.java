package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.android.gms.internal.mlkit_common.zzpq;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.zj.adlib.e98;
import com.zj.adlib.hnd;
import com.zj.adlib.hq5;
import com.zj.adlib.i76;
import com.zj.adlib.iod;
import com.zj.adlib.mq1;
import com.zj.adlib.qq5;
import com.zj.adlib.snd;
import com.zj.adlib.sp2;
import com.zj.adlib.su3;
import com.zj.adlib.tq5;
import com.zj.adlib.yw6;
import com.zj.adlib.z09;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f32463a = new su3("ModelDownloadManager", "");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("RemoteModelDownloadManager.class")
    public static final Map f6647a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DownloadManager f6648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RemoteModel f6650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ModelType f6651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ModelInfoRetrieverInterop f6652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f6653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final e98 f6654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hnd f6655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hq5 f6656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qq5 f6657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sp2 f6658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final LongSparseArray f6649a = new LongSparseArray();

    @GuardedBy("this")
    public final LongSparseArray b = new LongSparseArray();

    @VisibleForTesting
    public a(@NonNull hq5 hq5Var, @NonNull RemoteModel remoteModel, @NonNull qq5 qq5Var, @NonNull b bVar, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop, @NonNull hnd hndVar) {
        this.f6656a = hq5Var;
        this.f6651a = remoteModel.e();
        this.f6650a = remoteModel;
        DownloadManager downloadManager = (DownloadManager) hq5Var.b().getSystemService("download");
        this.f6648a = downloadManager;
        this.f6655a = hndVar;
        if (downloadManager == null) {
            f32463a.c("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.f6657a = qq5Var;
        this.f6654a = e98.g(hq5Var);
        this.f6652a = modelInfoRetrieverInterop;
        this.f6653a = bVar;
    }

    @NonNull
    @KeepForSdk
    public static synchronized a g(@NonNull hq5 hq5Var, @NonNull RemoteModel remoteModel, @NonNull qq5 qq5Var, @NonNull b bVar, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        Map map;
        map = f6647a;
        if (!map.containsKey(remoteModel)) {
            map.put(remoteModel, new a(hq5Var, remoteModel, qq5Var, bVar, modelInfoRetrieverInterop, iod.b("common")));
        }
        return (a) map.get(remoteModel);
    }

    @Nullable
    @WorkerThread
    public final synchronized Long A(@NonNull tq5 tq5Var, @NonNull sp2 sp2Var) throws MlKitException {
        yw6.m(sp2Var, "DownloadConditions can not be null");
        String strD = this.f6654a.d(this.f6650a);
        Integer numE = e();
        if (strD != null && strD.equals(tq5Var.a()) && numE != null) {
            Integer numE2 = e();
            if (numE2 == null || (numE2.intValue() != 8 && numE2.intValue() != 16)) {
                hnd hndVar = this.f6655a;
                zzpq zzpqVarG = snd.g();
                RemoteModel remoteModel = this.f6650a;
                hndVar.f(zzpqVarG, remoteModel, zzlm.NO_ERROR, false, remoteModel.e(), zzls.DOWNLOADING);
            }
            f32463a.c("ModelDownloadManager", "New model is already in downloading, do nothing.");
            return null;
        }
        su3 su3Var = f32463a;
        su3Var.c("ModelDownloadManager", "Need to download a new model.");
        j();
        DownloadManager.Request request = new DownloadManager.Request(tq5Var.d());
        if (this.f6657a.i(tq5Var.b(), tq5Var.c())) {
            su3Var.c("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
            this.f6655a.f(snd.g(), this.f6650a, zzlm.NO_ERROR, false, tq5Var.c(), zzls.UPDATE_AVAILABLE);
        }
        request.setRequiresCharging(sp2Var.a());
        if (sp2Var.b()) {
            request.setAllowedNetworkTypes(2);
        }
        return z(request, tq5Var);
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public Task<Void> a() {
        MlKitException mlKitException;
        tq5 tq5VarS;
        this.f6655a.f(snd.g(), this.f6650a, zzlm.NO_ERROR, false, ModelType.UNKNOWN, zzls.EXPLICITLY_REQUESTED);
        Long lA = null;
        try {
            tq5VarS = s();
            mlKitException = null;
        } catch (MlKitException e) {
            mlKitException = e;
            tq5VarS = null;
        }
        try {
            Integer numE = e();
            Long lC = c();
            if (!i() && (numE == null || numE.intValue() != 8)) {
                if (numE != null && numE.intValue() == 16) {
                    MlKitException mlKitExceptionX = x(lC);
                    j();
                    return com.google.android.gms.tasks.a.d(mlKitExceptionX);
                }
                if (numE == null || (!(numE.intValue() == 4 || numE.intValue() == 2 || numE.intValue() == 1) || lC == null || d() == null)) {
                    if (tq5VarS != null) {
                        lA = A(tq5VarS, this.f6658a);
                    }
                    return lA == null ? com.google.android.gms.tasks.a.d(new MlKitException("Failed to schedule the download task", 13, mlKitException)) : v(lA.longValue());
                }
                hnd hndVar = this.f6655a;
                zzpq zzpqVarG = snd.g();
                RemoteModel remoteModel = this.f6650a;
                hndVar.f(zzpqVarG, remoteModel, zzlm.NO_ERROR, false, remoteModel.e(), zzls.DOWNLOADING);
                return v(lC.longValue());
            }
            if (tq5VarS != null) {
                Long lA2 = A(tq5VarS, this.f6658a);
                if (lA2 != null) {
                    return v(lA2.longValue());
                }
                f32463a.h("ModelDownloadManager", "Didn't schedule download for the updated model");
            }
            return com.google.android.gms.tasks.a.e(null);
        } catch (MlKitException e2) {
            return com.google.android.gms.tasks.a.d(new MlKitException("Failed to ensure the model is downloaded.", 13, e2));
        }
    }

    @Nullable
    @KeepForSdk
    public synchronized ParcelFileDescriptor b() {
        Long lC = c();
        DownloadManager downloadManager = this.f6648a;
        ParcelFileDescriptor parcelFileDescriptorOpenDownloadedFile = null;
        if (downloadManager == null || lC == null) {
            return null;
        }
        try {
            parcelFileDescriptorOpenDownloadedFile = downloadManager.openDownloadedFile(lC.longValue());
        } catch (FileNotFoundException unused) {
            f32463a.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptorOpenDownloadedFile;
    }

    @Nullable
    @KeepForSdk
    public synchronized Long c() {
        return this.f6654a.e(this.f6650a);
    }

    @Nullable
    @KeepForSdk
    public synchronized String d() {
        return this.f6654a.d(this.f6650a);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0044 A[Catch: all -> 0x0091, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x000e, B:18:0x0044, B:34:0x006f, B:41:0x008e, B:40:0x0079, B:9:0x0027, B:11:0x002d, B:21:0x0049, B:23:0x0050, B:25:0x0057, B:27:0x005d, B:29:0x0065), top: B:48:0x0001, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0049 A[Catch: all -> 0x003d, TRY_ENTER, TryCatch #3 {all -> 0x003d, blocks: (B:9:0x0027, B:11:0x002d, B:21:0x0049, B:23:0x0050, B:25:0x0057, B:27:0x005d, B:29:0x0065), top: B:53:0x0027, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    @Nullable
    @KeepForSdk
    public synchronized Integer e() {
        Integer numValueOf;
        Long lC = c();
        DownloadManager downloadManager = this.f6648a;
        if (downloadManager != null && lC != null) {
            Cursor cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(lC.longValue()));
            if (cursorQuery == null) {
                numValueOf = null;
                if (numValueOf == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                if (numValueOf.intValue() != 2) {
                }
                cursorQuery.close();
                return num;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    numValueOf = Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("status")));
                } else {
                    numValueOf = null;
                }
                if (numValueOf == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                Integer num = (numValueOf.intValue() != 2 || numValueOf.intValue() == 4 || numValueOf.intValue() == 1 || numValueOf.intValue() == 8 || numValueOf.intValue() == 16) ? numValueOf : null;
                cursorQuery.close();
                return num;
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
            throw th;
        }
        return null;
    }

    @KeepForSdk
    public int f(@NonNull Long l) {
        int columnIndex;
        DownloadManager downloadManager = this.f6648a;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex(MediationConstant.KEY_REASON)) == -1) {
            return 0;
        }
        return cursorQuery.getInt(columnIndex);
    }

    @KeepForSdk
    @WorkerThread
    public boolean h() throws MlKitException {
        try {
            if (i()) {
                return true;
            }
        } catch (MlKitException unused) {
            f32463a.c("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long lC = c();
        String strD = d();
        if (lC == null || strD == null) {
            f32463a.c("ModelDownloadManager", "No new model is downloading.");
            j();
            return false;
        }
        Integer numE = e();
        f32463a.c("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(numE)));
        if (numE != null) {
            return i76.b(numE, 8) && u(strD) != null;
        }
        j();
        return false;
    }

    @KeepForSdk
    public boolean i() throws MlKitException {
        return this.f6657a.i(this.f6650a.f(), this.f6651a);
    }

    @KeepForSdk
    public synchronized void j() throws MlKitException {
        Long lC = c();
        if (this.f6648a != null && lC != null) {
            f32463a.c("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(lC.toString()));
            if (this.f6648a.remove(lC.longValue()) > 0 || e() == null) {
                this.f6657a.c(this.f6650a.f(), this.f6650a.e());
                this.f6654a.a(this.f6650a);
            }
        }
    }

    @KeepForSdk
    public void k(@NonNull sp2 sp2Var) {
        yw6.m(sp2Var, "DownloadConditions can not be null");
        this.f6658a = sp2Var;
    }

    @KeepForSdk
    public synchronized void l(@NonNull String str) throws MlKitException {
        this.f6654a.o(this.f6650a, str);
        j();
    }

    @Nullable
    @WorkerThread
    public final synchronized tq5 s() throws MlKitException {
        boolean z;
        boolean zI = i();
        if (zI) {
            hnd hndVar = this.f6655a;
            zzpq zzpqVarG = snd.g();
            RemoteModel remoteModel = this.f6650a;
            hndVar.f(zzpqVarG, remoteModel, zzlm.NO_ERROR, false, remoteModel.e(), zzls.LIVE);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.f6652a;
        if (modelInfoRetrieverInterop == null) {
            throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
        }
        tq5 tq5VarA = modelInfoRetrieverInterop.a(this.f6650a);
        if (tq5VarA == null) {
            return null;
        }
        hq5 hq5Var = this.f6656a;
        RemoteModel remoteModel2 = this.f6650a;
        String strA = tq5VarA.a();
        e98 e98VarG = e98.g(hq5Var);
        boolean zEquals = strA.equals(e98VarG.f(remoteModel2));
        boolean z2 = false;
        if (zEquals && mq1.a(hq5Var.b()).equals(e98VarG.l())) {
            f32463a.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
            z = false;
        } else {
            z = true;
        }
        if (!zI) {
            this.f6654a.c(this.f6650a);
        }
        boolean z3 = !tq5VarA.a().equals(e98.g(this.f6656a).h(this.f6650a));
        if (!z) {
            z2 = z3;
        } else if (!zI || z3) {
            return tq5VarA;
        }
        if (zI && (z2 ^ z)) {
            return null;
        }
        throw new MlKitException("The model " + this.f6650a.c() + " is incompatible with TFLite runtime", 100);
    }

    @Nullable
    public final File u(@NonNull String str) throws MlKitException {
        su3 su3Var = f32463a;
        su3Var.c("ModelDownloadManager", "Model downloaded successfully");
        this.f6655a.f(snd.g(), this.f6650a, zzlm.NO_ERROR, true, this.f6651a, zzls.SUCCEEDED);
        ParcelFileDescriptor parcelFileDescriptorB = b();
        if (parcelFileDescriptorB == null) {
            j();
            return null;
        }
        su3Var.c("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.f6653a.b(parcelFileDescriptorB, str, this.f6650a);
        } finally {
            j();
        }
    }

    public final Task v(long j) {
        this.f6656a.b().registerReceiver(y(j), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, com.google.mlkit.common.sdkinternal.b.b().a());
        return w(j).a();
    }

    public final synchronized z09 w(long j) {
        z09 z09Var = (z09) this.b.get(j);
        if (z09Var != null) {
            return z09Var;
        }
        z09 z09Var2 = new z09();
        this.b.put(j, z09Var2);
        return z09Var2;
    }

    public final MlKitException x(@Nullable Long l) {
        DownloadManager downloadManager = this.f6648a;
        Cursor cursorQuery = null;
        if (downloadManager != null && l != null) {
            cursorQuery = downloadManager.query(new DownloadManager.Query().setFilterById(l.longValue()));
        }
        int i = 13;
        String str = "Model downloading failed";
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(MediationConstant.KEY_REASON));
            if (i2 == 1006) {
                str = "Model downloading failed due to insufficient space on the device.";
                i = 101;
            } else {
                str = "Model downloading failed due to error code: " + i2 + " from Android DownloadManager";
            }
        }
        return new MlKitException(str, i);
    }

    public final synchronized zzd y(long j) {
        zzd zzdVar = (zzd) this.f6649a.get(j);
        if (zzdVar != null) {
            return zzdVar;
        }
        zzd zzdVar2 = new zzd(this, j, w(j), null);
        this.f6649a.put(j, zzdVar2);
        return zzdVar2;
    }

    @Nullable
    public final synchronized Long z(@NonNull DownloadManager.Request request, @NonNull tq5 tq5Var) {
        DownloadManager downloadManager = this.f6648a;
        if (downloadManager == null) {
            return null;
        }
        long jEnqueue = downloadManager.enqueue(request);
        f32463a.c("ModelDownloadManager", "Schedule a new downloading task: " + jEnqueue);
        this.f6654a.m(jEnqueue, tq5Var);
        this.f6655a.f(snd.g(), this.f6650a, zzlm.NO_ERROR, false, tq5Var.c(), zzls.SCHEDULED);
        return Long.valueOf(jEnqueue);
    }
}
