package com.huachenjie.common.page.qrcode;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.util.ActivityLifecycleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/page/qrcode/a;", "", "Lcom/huachenjie/common/page/qrcode/QRCodeResultFragment$ScanResultListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "showAlbum", "", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f33831a = new a();

    public static /* synthetic */ void b(a aVar, QRCodeResultFragment.ScanResultListener scanResultListener, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        aVar.a(scanResultListener, z);
    }

    public final void a(@NotNull QRCodeResultFragment.ScanResultListener listener, boolean showAlbum) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Activity activityM = ActivityLifecycleManager.l().m();
        if (activityM instanceof AppCompatActivity) {
            QRCodeResultFragment qRCodeResultFragmentA = QRCodeResultFragment.INSTANCE.a((AppCompatActivity) activityM);
            qRCodeResultFragmentA.setListener(listener);
            qRCodeResultFragmentA.startScan(showAlbum);
        }
    }
}
