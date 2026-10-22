package com.ltmb.ltadsdk.core.download;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.ib;
import com.ltmb.ltadsdk.pkg.lb;
import com.ltmb.ltadsdk.pkg.s7;
import com.ltmb.ltadsdk.pkg.u6;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadService;", "Landroid/app/Service;", "<init>", "()V", "a", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYDownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f40354a = new a(this);

    public final class a extends com.ltmb.ltadsdk.a.AbstractBinderC1318a {
        public a(SYDownloadService sYDownloadService) {
        }

        @Nullable
        public SYDownloadTask a(@Nullable String str, @Nullable String str2) {
            return SYDownloadProcessor.l.a().a(str, str2);
        }

        public void b(@Nullable SYDownloadTask sYDownloadTask) {
            d9.d.a("receiver info=" + sYDownloadTask);
            if (sYDownloadTask == null) {
                return;
            }
            SYDownloadProcessor.l.a().b(sYDownloadTask);
        }

        @Nullable
        public SYDownloadTask c(@Nullable String str) {
            return SYDownloadProcessor.l.a().b(str);
        }

        public void d(@Nullable String str) {
            SYDownloadProcessor.l.a().c(str);
        }

        public void a(@Nullable SYDownloadTask sYDownloadTask) {
            if (sYDownloadTask != null) {
                SYDownloadProcessor.l.a().a(sYDownloadTask);
            }
        }

        public void b(@Nullable String str) {
            d9.d.a("receiver pauseDownload downloadId=" + str);
            SYDownloadProcessor.l.a().a(str);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        public Object invoke() {
            u6.n.a((Application) SYDownloadService.this.getApplicationContext(), false, false);
            SYDownloadProcessor.l.a().a(SYDownloadService.this);
            return Unit.INSTANCE;
        }
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.f40354a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s7.a.a(new b(), "SYDownloadService onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Context context;
        super.onDestroy();
        SYDownloadProcessor sYDownloadProcessorA = SYDownloadProcessor.l.a();
        sYDownloadProcessorA.getClass();
        try {
            sYDownloadProcessorA.i = false;
            sYDownloadProcessorA.b.clear();
            sYDownloadProcessorA.c.clear();
            sYDownloadProcessorA.f40347a.a.clear();
            ib ibVarA = ib.f.a();
            SQLiteDatabase sQLiteDatabase = ibVarA.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            SQLiteDatabase sQLiteDatabase2 = ibVarA.d;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.close();
            }
            ib.c cVar = ibVarA.b;
            if (cVar != null) {
                cVar.close();
            }
            ibVarA.a = false;
            lb lbVar = sYDownloadProcessorA.e;
            if (lbVar != null) {
                lbVar.c.clear();
                lbVar.b.clear();
            }
            SYDownloadProcessor.PackageReceiver packageReceiver = sYDownloadProcessorA.g;
            if (packageReceiver != null && (context = sYDownloadProcessorA.d) != null) {
                context.unregisterReceiver(packageReceiver);
            }
            Context context2 = sYDownloadProcessorA.d;
            if (context2 != null) {
                context2.unregisterReceiver(sYDownloadProcessorA.h);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        return 1;
    }
}
