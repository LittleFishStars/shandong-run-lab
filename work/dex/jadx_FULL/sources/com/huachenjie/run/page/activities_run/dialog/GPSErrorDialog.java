package com.huachenjie.run.page.activities_run.dialog;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.R;
import com.zj.adlib.cr2;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/GPSErrorDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getWidth", "getHeight", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "Lkotlin/Function0;", "cancelListener", "Lkotlin/jvm/functions/Function0;", "changeNetListener", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class GPSErrorDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function0<Unit> cancelListener;

    @Nullable
    private Function0<Unit> changeNetListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/GPSErrorDialog$a;", "", "Landroid/view/View;", "view", "", "b", "a", "c", "<init>", "(Lcom/huachenjie/run/page/activities_run/dialog/GPSErrorDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            Function0 function0 = GPSErrorDialog.this.changeNetListener;
            if (function0 != null) {
                function0.invoke();
            }
            GPSErrorDialog.this.dismiss();
        }

        public final void b(@Nullable View view) {
            Function0 function0 = GPSErrorDialog.this.cancelListener;
            if (function0 != null) {
                function0.invoke();
            }
            GPSErrorDialog.this.dismiss();
        }

        public final void c(@Nullable View view) {
            ARouter.getInstance().build(RoutePathConstants.Run.l).navigation();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.dialog.GPSErrorDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/GPSErrorDialog$b;", "", "Lkotlin/Function0;", "", "cancelListener", "retryListener", "Lcom/huachenjie/run/page/activities_run/dialog/GPSErrorDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GPSErrorDialog a(@Nullable Function0<Unit> cancelListener, @Nullable Function0<Unit> retryListener) {
            GPSErrorDialog gPSErrorDialog = new GPSErrorDialog();
            gPSErrorDialog.cancelListener = cancelListener;
            gPSErrorDialog.changeNetListener = retryListener;
            return gPSErrorDialog;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_dialog_gps_error), Integer.valueOf(lk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return fx7.h() - cr2.c(getContext(), 88.0f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        setCancelable(false);
    }
}
