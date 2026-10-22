package com.ltmb.ltadsdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.ib;
import com.ltmb.ltadsdk.pkg.p7;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public class SYDownloadNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (context == null || intent == null || !Intrinsics.areEqual(intent.getAction(), "action_change_download_status")) {
            return;
        }
        String stringExtra = intent.getStringExtra("task_download_id");
        d9 d9Var = d9.d;
        d9Var.a("NotificationReceiver downloadId=" + stringExtra);
        SYDownloadProcessor.b bVar = SYDownloadProcessor.l;
        bVar.a().getClass();
        SYDownloadTask sYDownloadTaskB = null;
        if (!TextUtils.isEmpty(stringExtra)) {
            ib.b bVar2 = ib.f;
            ib ibVarA = bVar2.a();
            Intrinsics.checkNotNull(stringExtra);
            p7 p7VarB = ibVarA.b(stringExtra);
            d9Var.a("queryDownloadInfoById record=" + p7VarB);
            if (p7VarB != null) {
                if (new File(p7VarB.g).exists() || (!new File(p7VarB.g).exists() && p7VarB.i == 0)) {
                    sYDownloadTaskB = p7VarB.b();
                } else {
                    bVar2.a().a(p7VarB.a);
                }
            }
        }
        if (sYDownloadTaskB != null) {
            if (sYDownloadTaskB.getStatus() == 2) {
                bVar.a().a(stringExtra);
                return;
            }
            if (sYDownloadTaskB.getStatus() == 3 || sYDownloadTaskB.getStatus() == 5) {
                bVar.a().c(stringExtra);
            } else if (sYDownloadTaskB.getStatus() == 4) {
                bVar.a().a(sYDownloadTaskB);
            }
        }
    }
}
