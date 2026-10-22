package com.huachenjie.base.broadcast.works;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zj.adlib.oz9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/huachenjie/base/broadcast/works/WorkOperateListener;", "a", "Lcom/huachenjie/base/broadcast/works/WorkOperateListener;", "mListener", "<init>", "(Lcom/huachenjie/base/broadcast/works/WorkOperateListener;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class WorkOperateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final WorkOperateListener mListener;

    public WorkOperateReceiver(@NotNull WorkOperateListener workOperateListener) {
        Intrinsics.checkNotNullParameter(workOperateListener, "mListener");
        this.mListener = workOperateListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        if (intent != null) {
            switch (intent.getIntExtra(oz9.b, 0)) {
                case 1:
                    this.mListener.a();
                    break;
                case 2:
                    String stringExtra = intent.getStringExtra("workNo");
                    str = stringExtra != null ? stringExtra : "";
                    Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(WorkOperateHelper.WORK_NO) ?: \"\"");
                    this.mListener.d(str, intent.getBooleanExtra(oz9.f, false), intent.getIntExtra(oz9.d, 0));
                    break;
                case 3:
                    String stringExtra2 = intent.getStringExtra("workNo");
                    str = stringExtra2 != null ? stringExtra2 : "";
                    Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(WorkOperateHelper.WORK_NO) ?: \"\"");
                    this.mListener.b(str, intent.getBooleanExtra(oz9.f, false), intent.getIntExtra(oz9.e, 0));
                    break;
                case 4:
                    this.mListener.f(intent.getParcelableExtra(oz9.g));
                    break;
                case 5:
                    this.mListener.c();
                    break;
                case 6:
                    String stringExtra3 = intent.getStringExtra("workNo");
                    str = stringExtra3 != null ? stringExtra3 : "";
                    Intrinsics.checkNotNullExpressionValue(str, "getStringExtra(WorkOperateHelper.WORK_NO) ?: \"\"");
                    this.mListener.e(str, intent.getIntExtra(oz9.h, 0));
                    break;
            }
        }
    }
}
