package com.ltmb.ltadsdk.core.download;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.igexin.push.g.o;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.g;
import com.ltmb.ltadsdk.pkg.gb;
import com.ltmb.ltadsdk.pkg.hb;
import com.ltmb.ltadsdk.pkg.ib;
import com.ltmb.ltadsdk.pkg.jb;
import com.ltmb.ltadsdk.pkg.lb;
import com.ltmb.ltadsdk.pkg.lc;
import com.ltmb.ltadsdk.pkg.mb;
import com.ltmb.ltadsdk.pkg.nb;
import com.ltmb.ltadsdk.pkg.o7;
import com.ltmb.ltadsdk.pkg.p7;
import com.ltmb.ltadsdk.pkg.pb;
import com.ltmb.ltadsdk.pkg.rb;
import com.ltmb.ltadsdk.pkg.s7;
import com.ltmb.ltadsdk.pkg.u6;
import com.ltmb.ltadsdk.pkg.ub;
import com.ltmb.ltadsdk.pkg.x6;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class SYDownloadProcessor {
    public Context d;
    public lb e;
    public hb f;
    public PackageReceiver g;
    public SYDownloadNotificationReceiver h;
    public boolean i;
    public static final b l = new b();

    @NotNull
    public static final Lazy k = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, a.f40349a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mb f40347a = new mb();
    public final ConcurrentHashMap<String, SYDownloadTask> b = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, rb> c = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Function2<Long, byte[], Unit>> j = new ConcurrentHashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadProcessor$PackageReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/ltmb/ltadsdk/core/download/SYDownloadProcessor;)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public final class PackageReceiver extends BroadcastReceiver {
        public PackageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            lb lbVar;
            String str;
            if (context == null || intent == null) {
                return;
            }
            try {
                if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) || TextUtils.equals("android.intent.action.PACKAGE_REPLACED", intent.getAction())) {
                    Uri data = intent.getData();
                    Intrinsics.checkNotNull(data);
                    Intrinsics.checkNotNullExpressionValue(data, "intent.data!!");
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    String stringExtra = intent.getStringExtra("install_uuid");
                    d9 d9Var = d9.d;
                    d9Var.a("installedPackageName=" + schemeSpecificPart + ", installId=" + stringExtra);
                    g gVar = g.a;
                    Intrinsics.checkNotNullExpressionValue(schemeSpecificPart, "installedPackageName");
                    g.a aVarA = gVar.a(context, schemeSpecificPart);
                    d9Var.a("willInstallInfo=" + aVarA);
                    if (aVarA != null) {
                        String strC = x6.g.c(context, schemeSpecificPart);
                        d9Var.a("安装app的签名：" + strC);
                        if (TextUtils.isEmpty(strC) || !Intrinsics.areEqual(strC, aVarA.b)) {
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.setAction("com.ltmb.ltadsdk.download.will_install_pkg");
                        Context context2 = SYDownloadProcessor.this.d;
                        intent2.setPackage(context2 != null ? context2.getPackageName() : null);
                        Bundle bundle = new Bundle();
                        bundle.putString("installed_pkg", schemeSpecificPart);
                        bundle.putString("requestId", aVarA.d);
                        d9Var.a(schemeSpecificPart + "安装成功发送广告");
                        intent2.putExtras(bundle);
                        Context context3 = SYDownloadProcessor.this.d;
                        if (context3 != null) {
                            Context contextA = u6.n.a();
                            if (contextA != null) {
                                str = contextA.getPackageName() + ".download.PRIVATE_BROADCAST_PERMISSION";
                            } else {
                                str = "com.ltmb.ltadsdk.download.PRIVATE_BROADCAST_PERMISSION";
                            }
                            context3.sendBroadcast(intent2, str);
                        }
                        ib.f.a().a(aVarA.a);
                        File file = new File(aVarA.e);
                        if (file.exists()) {
                            file.delete();
                        }
                        int i = aVarA.c;
                        if (i == 0 || (lbVar = SYDownloadProcessor.this.e) == null) {
                            return;
                        }
                        lbVar.a.cancel(i);
                    }
                }
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
    }

    public static final class a extends Lambda implements Function0<SYDownloadProcessor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40349a = new a();

        public a() {
            super(0);
        }

        public Object invoke() {
            return new SYDownloadProcessor();
        }
    }

    public static final class b {
        @NotNull
        public final SYDownloadProcessor a() {
            Lazy lazy = SYDownloadProcessor.k;
            b bVar = SYDownloadProcessor.l;
            return (SYDownloadProcessor) lazy.getValue();
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SYDownloadTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SYDownloadTask sYDownloadTask) {
            super(0);
            this.b = sYDownloadTask;
        }

        public Object invoke() {
            SYDownloadProcessor.a(SYDownloadProcessor.this, this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.b = str;
        }

        public Object invoke() {
            p7 p7VarB = ib.f.a().b(this.b);
            if (p7VarB != null) {
                SYDownloadProcessor.this.b(p7VarB.b());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SYDownloadTask b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SYDownloadTask sYDownloadTask) {
            super(0);
            this.b = sYDownloadTask;
        }

        public Object invoke() {
            long jInsert;
            if (TextUtils.isEmpty(this.b.getDownloadId())) {
                p7 p7VarC = this.b.isDownloadApk() ? ib.f.a().c(this.b.getAppPkgName()) : ib.f.a().d(this.b.getUrl());
                d9 d9Var = d9.d;
                d9Var.a("startDownload record=" + p7VarC);
                if (p7VarC != null) {
                    File file = new File(p7VarC.g);
                    if (p7VarC.h == 4 && file.exists()) {
                        d9Var.a("目标文件大小：" + file.length() + ", 数据库记录：" + p7VarC.j);
                        if (file.length() != p7VarC.j) {
                            ib.f.a().a(p7VarC.a);
                            file.delete();
                        }
                    } else if (!file.exists()) {
                        ib.f.a().a(p7VarC.a);
                    }
                    if (!SYDownloadProcessor.this.f40347a.a(p7VarC.a)) {
                        SYDownloadProcessor.this.f40347a.a(p7VarC.b());
                    }
                } else {
                    ib ibVarA = ib.f.a();
                    p7 p7VarConvertToInsertRecord = this.b.convertToInsertRecord();
                    ibVarA.getClass();
                    Intrinsics.checkNotNullParameter(p7VarConvertToInsertRecord, AliyunLogCommon.SubModule.RECORD);
                    SQLiteDatabase sQLiteDatabase = ibVarA.c;
                    if (sQLiteDatabase != null) {
                        try {
                            jInsert = sQLiteDatabase.insert("DownloadRecord", null, p7VarConvertToInsertRecord.a());
                        } catch (Throwable th) {
                            d9.d.a(th);
                            jInsert = -1;
                        }
                    } else {
                        jInsert = -1;
                    }
                    d9.d.a("startDownload insert result id=" + jInsert);
                    if (jInsert > 0) {
                        SYDownloadProcessor.this.f40347a.a(this.b);
                    }
                }
                SYDownloadProcessor.a(SYDownloadProcessor.this);
            } else if (!SYDownloadProcessor.this.f40347a.a(this.b.getDownloadId())) {
                SYDownloadProcessor.this.f40347a.a(this.b);
                SYDownloadProcessor.a(SYDownloadProcessor.this);
            }
            return Unit.INSTANCE;
        }
    }

    public static final void a(SYDownloadProcessor sYDownloadProcessor, SYDownloadTask sYDownloadTask) {
        sYDownloadProcessor.getClass();
        Intent intent = new Intent();
        intent.setAction("com.ltmb.ltadsdk.download.notify_status");
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadTask", sYDownloadTask);
        bundle.putInt("status", 6);
        intent.putExtras(bundle);
        Context context = sYDownloadProcessor.d;
        intent.setPackage(context != null ? context.getPackageName() : null);
        Context context2 = sYDownloadProcessor.d;
        if (context2 != null) {
            context2.sendBroadcast(intent, SYDownloadReceiver.INSTANCE.a());
        }
    }

    @Nullable
    public final SYDownloadTask b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ib.b bVar = ib.f;
        ib ibVarA = bVar.a();
        Intrinsics.checkNotNull(str);
        p7 p7VarD = ibVarA.d(str);
        d9.d.a("queryDownloadInfo record=" + p7VarD);
        if (p7VarD == null) {
            return null;
        }
        if (new File(p7VarD.g).exists() || (!new File(p7VarD.g).exists() && p7VarD.i == 0)) {
            return p7VarD.b();
        }
        bVar.a().a(p7VarD.a);
        return null;
    }

    public final void c(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        lc.i.d(new d(str));
    }

    public static final void a(SYDownloadProcessor sYDownloadProcessor) {
        SYDownloadTask sYDownloadTask;
        sYDownloadProcessor.getClass();
        d9.d.a("processNextTask");
        if (sYDownloadProcessor.b.size() >= 5) {
            return;
        }
        mb mbVar = sYDownloadProcessor.f40347a;
        synchronized (mbVar) {
            sYDownloadTask = (SYDownloadTask) mbVar.a.poll();
        }
        if (sYDownloadTask != null) {
            sYDownloadProcessor.b.put(sYDownloadTask.getDownloadId(), sYDownloadTask);
            lc.i.d(new pb(sYDownloadProcessor, sYDownloadTask));
        }
    }

    public final void b(@NotNull SYDownloadTask sYDownloadTask) {
        Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        lc.i.d(new e(sYDownloadTask));
    }

    public final void a(@NotNull Context context) {
        List<File> listEmptyList;
        SQLiteDatabase sQLiteDatabase;
        Intrinsics.checkNotNullParameter(context, "context");
        d9 d9Var = d9.d;
        d9Var.a("DownloadProcessor init mInited=" + this.i);
        if (this.i) {
            d9Var.a("multi init DownloadProcessor");
            return;
        }
        ib ibVarA = ib.f.a();
        ibVarA.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (!ibVarA.a) {
            ibVarA.a = true;
            ib.c cVar = new ib.c(ibVarA, context);
            ibVarA.c = cVar.getWritableDatabase();
            ibVarA.d = cVar.getReadableDatabase();
            Unit unit = Unit.INSTANCE;
            ibVarA.b = cVar;
            ArrayList<p7> arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase2 = ibVarA.d;
            if (sQLiteDatabase2 != null) {
                Cursor cursorQuery = sQLiteDatabase2.query("DownloadRecord", null, null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    try {
                        p7.a aVar = p7.t;
                        Intrinsics.checkNotNullExpressionValue(cursorQuery, o.f);
                        arrayList.add(aVar.a(cursorQuery));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(cursorQuery, th);
                            throw th2;
                        }
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, (Throwable) null);
            }
            d9.d.a("checkRecord list.size=" + arrayList.size());
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList<p7> arrayList3 = new ArrayList();
                for (p7 p7Var : arrayList) {
                    File file = new File(p7Var.g);
                    d9.d.a("checkRecord record=" + p7Var);
                    if (!file.exists()) {
                        arrayList2.add(p7Var);
                    } else if (p7Var.h == 2) {
                        p7Var.h = 3;
                        arrayList3.add(p7Var);
                    }
                }
                try {
                    SQLiteDatabase sQLiteDatabase3 = ibVarA.c;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.beginTransaction();
                        ArrayList arrayList4 = new ArrayList();
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(((p7) it.next()).a);
                        }
                        String str = "downloadId in (" + CollectionsKt.joinToString$default(arrayList4, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, jb.a, 30, (Object) null) + ')';
                        Object[] array = arrayList4.toArray(new String[0]);
                        if (array != null) {
                            sQLiteDatabase3.delete("DownloadRecord", str, (String[]) array);
                            for (p7 p7Var2 : arrayList3) {
                                sQLiteDatabase3.update("DownloadRecord", p7Var2.c(), "downloadId=?", new String[]{p7Var2.b});
                            }
                            sQLiteDatabase3.setTransactionSuccessful();
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    sQLiteDatabase = ibVarA.c;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Throwable th3) {
                    try {
                        d9.d.a(th3);
                        sQLiteDatabase = ibVarA.c;
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Throwable th4) {
                        SQLiteDatabase sQLiteDatabase4 = ibVarA.c;
                        if (sQLiteDatabase4 != null) {
                            sQLiteDatabase4.endTransaction();
                        }
                        throw th4;
                    }
                }
            }
        }
        this.d = context;
        this.e = new lb(context);
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            File file2 = new File(context.getFilesDir(), "yltmbad/dld");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "ad_downloads");
            if (!file3.exists()) {
                file3.mkdirs();
            }
        } catch (Throwable unused) {
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            File file4 = new File(context.getFilesDir(), "yltmbad/dld");
            if (!file4.exists()) {
                file4.mkdirs();
            }
            File[] fileArrListFiles = file4.listFiles();
            if (fileArrListFiles == null || (listEmptyList = ArraysKt.sortedWith(fileArrListFiles, new gb())) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                hb hbVar = l.a().f;
                long length = 0;
                long j = hbVar != null ? hbVar.d : 0L;
                if (j != 0) {
                    List<File> mutableList = CollectionsKt.toMutableList(listEmptyList);
                    ArrayList arrayList5 = new ArrayList();
                    for (File file5 : listEmptyList) {
                        if (length < j) {
                            length += file5.length();
                            arrayList5.add(file5);
                        }
                    }
                    mutableList.removeAll(arrayList5);
                    ArrayList arrayList6 = new ArrayList();
                    for (File file6 : mutableList) {
                        String absolutePath = file6.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                        arrayList6.add(absolutePath);
                        file6.delete();
                    }
                    ib.f.a().a(arrayList6);
                }
            }
        } catch (Throwable th5) {
            d9.d.a(th5);
        }
        try {
            if (o7.a.a(context)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                PackageReceiver packageReceiver = new PackageReceiver();
                this.g = packageReceiver;
                context.registerReceiver(packageReceiver, intentFilter);
            }
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("action_change_download_status");
            SYDownloadNotificationReceiver sYDownloadNotificationReceiver = new SYDownloadNotificationReceiver();
            this.h = sYDownloadNotificationReceiver;
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(sYDownloadNotificationReceiver, intentFilter2, 4);
            } else {
                context.registerReceiver(sYDownloadNotificationReceiver, intentFilter2);
            }
        } catch (Throwable th6) {
            d9.d.a(th6);
        }
        this.i = true;
    }

    @Nullable
    public final SYDownloadTask a(@Nullable String str, @Nullable String str2) {
        d9.d.a("dldprocess queryApkDownloadInfo pkgName=" + str + ", versionName=" + str2);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ib.b bVar = ib.f;
        ib ibVarA = bVar.a();
        Intrinsics.checkNotNull(str);
        p7 p7VarC = ibVarA.c(str);
        if (p7VarC == null) {
            if (!x6.g.a(u6.n.a(), str)) {
                return null;
            }
            SYDownloadTask sYDownloadTask = new SYDownloadTask();
            sYDownloadTask.setAppPkgName(str);
            sYDownloadTask.setStatus(7);
            if (str2 == null) {
                str2 = "";
            }
            sYDownloadTask.setAppVersion(str2);
            return sYDownloadTask;
        }
        if (TextUtils.equals(p7VarC.d, str2) && new File(p7VarC.g).exists()) {
            int i = p7VarC.h;
            if ((i == 4 || i == 6) && x6.g.a(u6.n.a(), p7VarC.c)) {
                p7VarC.h = 7;
                bVar.a().a(p7VarC.a);
            }
            return p7VarC.b();
        }
        if (!new File(p7VarC.g).exists() && p7VarC.i == 0) {
            return p7VarC.b();
        }
        bVar.a().a(p7VarC.a);
        return null;
    }

    public final void a(@NotNull SYDownloadTask sYDownloadTask, long j, long j2) {
        Context context;
        Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        ib ibVarA = ib.f.a();
        String downloadId = sYDownloadTask.getDownloadId();
        ibVarA.getClass();
        Intrinsics.checkNotNullParameter(downloadId, "downloadId");
        SQLiteDatabase sQLiteDatabase = ibVarA.c;
        if (sQLiteDatabase != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("downloadedBytes", Long.valueOf(j2));
                contentValues.put("totalBytes", Long.valueOf(j));
                sQLiteDatabase.update("DownloadRecord", contentValues, "downloadId=?", new String[]{downloadId});
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
        sYDownloadTask.setDownloadedBytes(j2);
        if (!sYDownloadTask.isDownloadApk() || (context = this.d) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.ltmb.ltadsdk.download.notify_progress");
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadTask", sYDownloadTask);
        bundle.putLong("totalBytes", j);
        bundle.putLong("downloadedBytes", j2);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent, SYDownloadReceiver.INSTANCE.a());
        lb lbVar = this.e;
        if (lbVar != null) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            try {
                if (s7.a.a(lbVar.b, sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String()) && System.currentTimeMillis() - lbVar.d >= 500) {
                    lbVar.d = System.currentTimeMillis();
                    lb.a aVar = (lb.a) lbVar.b.get(sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String());
                    RemoteViews remoteViewsC = lbVar.c(sYDownloadTask);
                    if (j == j2) {
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_title, "下载完成：" + sYDownloadTask.getAppName());
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_progress, "下载完成，点击安装");
                        remoteViewsC.setViewVisibility(R.id.syad_notify_progress_bar, 4);
                        PendingIntent pendingIntentB = lbVar.b(sYDownloadTask);
                        aVar.getClass();
                        Intrinsics.checkNotNullParameter(pendingIntentB, "contentIntent");
                        aVar.c = pendingIntentB;
                    } else {
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_progress, "已完成：" + lbVar.a(j2) + ", 总大小：" + lbVar.a(j));
                        int i = (int) ((((float) j2) / ((float) j)) * ((float) 100));
                        int i2 = R.id.syad_notify_progress_bar;
                        remoteViewsC.setProgressBar(i2, 100, i, false);
                        remoteViewsC.setViewVisibility(i2, 0);
                    }
                    aVar.a(remoteViewsC);
                    lbVar.a.notify(sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String(), aVar.a());
                }
            } catch (Throwable th2) {
                d9.d.a(th2);
            }
        }
    }

    public final void a(@NotNull SYDownloadTask sYDownloadTask, int i) {
        Context context;
        lb lbVar;
        Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        sYDownloadTask.setStatus(i);
        ib ibVarA = ib.f.a();
        String downloadId = sYDownloadTask.getDownloadId();
        ibVarA.getClass();
        Intrinsics.checkNotNullParameter(downloadId, "downloadId");
        SQLiteDatabase sQLiteDatabase = ibVarA.c;
        if (sQLiteDatabase != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i));
                sQLiteDatabase.update("DownloadRecord", contentValues, "downloadId=?", new String[]{downloadId});
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
        if (!sYDownloadTask.isDownloadApk() || (context = this.d) == null) {
            return;
        }
        d9 d9Var = d9.d;
        d9Var.a("notifyUpdateDownloadStatus status=" + i);
        Intent intent = new Intent();
        intent.setAction("com.ltmb.ltadsdk.download.notify_status");
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadTask", sYDownloadTask);
        bundle.putInt("status", i);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        Context context2 = this.d;
        if (context2 != null) {
            context2.sendBroadcast(intent, SYDownloadReceiver.INSTANCE.a());
        }
        if (i != 6 && (lbVar = this.e) != null) {
            Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
            if (s7.a.a(lbVar.b, sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String())) {
                d9Var.a("updateDownloadStatus notificationId=" + sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String() + ", status=" + i);
                try {
                    lb.a aVarA = lbVar.a(sYDownloadTask);
                    RemoteViews remoteViewsC = lbVar.c(sYDownloadTask);
                    if (i == 3) {
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_title, "暂停下载：" + sYDownloadTask.getAppName());
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_progress, "已暂停");
                        int color = lbVar.e.getResources().getColor(R.color.ltad_color_white);
                        int i2 = R.id.syad_notify_tv_action;
                        remoteViewsC.setTextColor(i2, color);
                        remoteViewsC.setTextViewText(i2, "继续");
                        remoteViewsC.setInt(i2, "setBackgroundResource", R.drawable.ltad_bg_notify_button_download_pause);
                    } else if (i == 5) {
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_title, "下载失败：" + sYDownloadTask.getAppName());
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_progress, "下载失败");
                        int color2 = lbVar.e.getResources().getColor(R.color.ltad_color_white);
                        int i3 = R.id.syad_notify_tv_action;
                        remoteViewsC.setTextColor(i3, color2);
                        remoteViewsC.setTextViewText(i3, "继续");
                        remoteViewsC.setInt(i3, "setBackgroundResource", R.drawable.ltad_bg_notify_button_download_pause);
                    } else if (i == 4) {
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_title, "下载完成：" + sYDownloadTask.getAppName());
                        remoteViewsC.setTextViewText(R.id.syad_notify_tv_progress, "下载完成，点击安装");
                        int color3 = lbVar.e.getResources().getColor(R.color.ltad_color_white);
                        int i4 = R.id.syad_notify_tv_action;
                        remoteViewsC.setTextColor(i4, color3);
                        remoteViewsC.setTextViewText(i4, "安装");
                        remoteViewsC.setInt(i4, "setBackgroundResource", R.drawable.ltad_bg_notify_button_download_pause);
                    }
                    remoteViewsC.setViewVisibility(R.id.syad_notify_progress_bar, 4);
                    aVarA.a(remoteViewsC);
                    lbVar.a.notify(sYDownloadTask.getCom.huachenjie.common.service.LocationService.f java.lang.String(), aVarA.a());
                } catch (Throwable th2) {
                    d9.d.a(th2);
                }
            }
        }
        if (i == 4) {
            g.a.a(this.d, sYDownloadTask, new nb(this, i, sYDownloadTask));
        }
    }

    public final void a(@NotNull SYDownloadTask sYDownloadTask, int i, @Nullable String str) {
        Context context;
        Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        if (!sYDownloadTask.isDownloadApk() || (context = this.d) == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.ltmb.ltadsdk.download.notify_fail");
        Bundle bundle = new Bundle();
        bundle.putParcelable("downloadTask", sYDownloadTask);
        bundle.putInt("errorCode", i);
        bundle.putString("errorMsg", str);
        intent.putExtras(bundle);
        intent.setPackage(context.getPackageName());
        Context context2 = this.d;
        if (context2 != null) {
            context2.sendBroadcast(intent, SYDownloadReceiver.INSTANCE.a());
        }
    }

    public final void a(@NotNull String str, long j, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bArr, "content");
        if (this.j.containsKey(str)) {
            Iterator<Map.Entry<String, Function2<Long, byte[], Unit>>> it = this.j.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().invoke(Long.valueOf(j), bArr);
            }
        }
    }

    public final void a(@Nullable String str) {
        rb rbVar;
        ub ubVar;
        if (str == null || str.length() == 0) {
            return;
        }
        d9 d9Var = d9.d;
        d9Var.a("pauseDownload downloadId=" + str + ", mActiveWorks=" + this.c);
        if (!this.c.containsKey(str) || (rbVar = this.c.get(str)) == null || (ubVar = rbVar.c) == null) {
            return;
        }
        ubVar.u.compareAndSet(false, true);
        d9Var.a("pauseDownload mPauseDownload=" + ubVar.u.get());
    }

    public final void a(@NotNull SYDownloadTask sYDownloadTask) {
        Intrinsics.checkNotNullParameter(sYDownloadTask, "task");
        Context context = this.d;
        if (context != null) {
            g.a.a(context, sYDownloadTask, new c(sYDownloadTask));
        }
    }
}
