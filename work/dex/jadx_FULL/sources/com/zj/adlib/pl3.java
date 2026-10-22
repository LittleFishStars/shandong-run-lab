package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.util.intercept.ActionIntercept;
import com.huachenjie.common.util.intercept.DialogIntercept;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/zj/adlib/pl3;", "Lcom/huachenjie/common/util/intercept/DialogIntercept;", "", "time", "", "k", "d", "c", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "a", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "dialog", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Ljava/lang/String;", y6b.g, "()Ljava/lang/String;", "tag", "J", "dismissTime", "<init>", "(Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class pl3 extends DialogIntercept {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long dismissTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FragmentManager fragmentManager;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final BaseDialogFragment dialog;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String tag;

    public pl3(@NotNull BaseDialogFragment baseDialogFragment, @NotNull FragmentManager fragmentManager, @NotNull String str) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "dialog");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.dialog = baseDialogFragment;
        this.fragmentManager = fragmentManager;
        this.tag = str;
    }

    public static final void i(pl3 pl3Var) {
        Intrinsics.checkNotNullParameter(pl3Var, "this$0");
        pl3Var.c();
    }

    public static final void j(pl3 pl3Var) {
        Intrinsics.checkNotNullParameter(pl3Var, "this$0");
        if (pl3Var.dialog.isShowing()) {
            pl3Var.dialog.dismiss();
        }
    }

    @Override // com.huachenjie.common.util.intercept.DialogIntercept
    public void c() {
        BaseDialogFragment baseDialogFragment = this.dialog;
        if (baseDialogFragment == null || baseDialogFragment.getContext() == null) {
            return;
        }
        if (this.dialog.getContext() instanceof Activity) {
            Context context = this.dialog.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).isFinishing()) {
                return;
            }
        }
        if (getNextActionIntercept() == null || !(getNextActionIntercept() instanceof pl3)) {
            return;
        }
        String skipClassTag = this.dialog.getSkipClassTag();
        ActionIntercept nextActionIntercept = getNextActionIntercept();
        Intrinsics.checkNotNull(nextActionIntercept, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.FragmentDialogIntercept");
        i4a.a("iDialogDismiss:" + ((pl3) nextActionIntercept).dialog.getClass().getName());
        if (TextUtils.isEmpty(skipClassTag)) {
            ActionIntercept nextActionIntercept2 = getNextActionIntercept();
            Intrinsics.checkNotNull(nextActionIntercept2, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.FragmentDialogIntercept");
            ((pl3) nextActionIntercept2).d();
            return;
        }
        ActionIntercept nextActionIntercept3 = getNextActionIntercept();
        Intrinsics.checkNotNull(nextActionIntercept3, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.FragmentDialogIntercept");
        while (true) {
            pl3 pl3Var = (pl3) nextActionIntercept3;
            i4a.a(pl3Var.dialog.getClass().getName());
            if (!skipClassTag.equals(pl3Var.dialog.getClass().getName())) {
                pl3Var.d();
                return;
            } else {
                if (pl3Var.getNextActionIntercept() == null) {
                    return;
                }
                nextActionIntercept3 = pl3Var.getNextActionIntercept();
                Intrinsics.checkNotNull(nextActionIntercept3, "null cannot be cast to non-null type com.huachenjie.common.util.intercept.FragmentDialogIntercept");
            }
        }
    }

    @Override // com.huachenjie.common.util.intercept.DialogIntercept
    public void d() {
        FragmentManager fragmentManager;
        i4a.a("DialogInterceptHandler:iDialogShow(" + this.tag + ")");
        if (this.dialog == null || (fragmentManager = this.fragmentManager) == null || fragmentManager.isDestroyed() || this.fragmentManager.findFragmentByTag(this.tag) != null) {
            return;
        }
        this.dialog.setFragmentDialogDismissCallback(new BaseDialogFragment.FragmentDialogDismissCallback() { // from class: com.zj.adlib.nl3
            @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment.FragmentDialogDismissCallback
            public final void onDismiss() {
                pl3.i(this.f43548a);
            }
        });
        this.dialog.show(this.fragmentManager, this.tag);
        if (this.dismissTime > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.ol3
                @Override // java.lang.Runnable
                public final void run() {
                    pl3.j(this.f43773a);
                }
            }, this.dismissTime);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public final void k(long time) {
        this.dismissTime = time;
    }
}
