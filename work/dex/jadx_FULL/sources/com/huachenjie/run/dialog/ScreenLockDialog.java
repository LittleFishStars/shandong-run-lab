package com.huachenjie.run.dialog;

import android.app.Dialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.RunActionButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/dialog/ScreenLockDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "initData", "Lkotlin/Function0;", "onUnlock", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ScreenLockDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ScreenLockDialog";

    @Nullable
    private Function0<Unit> onUnlock;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.ScreenLockDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/dialog/ScreenLockDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fm", "Lkotlin/Function0;", "", "onUnlock", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fm, @NotNull Function0<Unit> onUnlock) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(onUnlock, "onUnlock");
            Fragment fragmentFindFragmentByTag = fm.findFragmentByTag(ScreenLockDialog.TAG);
            ScreenLockDialog screenLockDialog = fragmentFindFragmentByTag instanceof ScreenLockDialog ? (ScreenLockDialog) fragmentFindFragmentByTag : null;
            if (screenLockDialog != null) {
                screenLockDialog.onUnlock = onUnlock;
                return;
            }
            ScreenLockDialog screenLockDialog2 = new ScreenLockDialog();
            screenLockDialog2.onUnlock = onUnlock;
            screenLockDialog2.show(fm, ScreenLockDialog.TAG);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_screen_lock;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        ((RunActionButton) requireView().findViewById(R.id.unlockButton)).setOnActionLongPress(new Function0<Unit>() { // from class: com.huachenjie.run.dialog.ScreenLockDialog.initView.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m624invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m624invoke() {
                Function0 function0 = ScreenLockDialog.this.onUnlock;
                if (function0 != null) {
                    function0.invoke();
                }
                ScreenLockDialog.this.dismissAllowingStateLoss();
            }
        });
    }
}
