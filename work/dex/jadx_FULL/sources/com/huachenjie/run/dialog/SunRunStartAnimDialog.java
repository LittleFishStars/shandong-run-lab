package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.SunRunStartAnimDialog;
import com.huachenjie.run.widget.SunRunStartAnimView;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/run/dialog/SunRunStartAnimDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "Lcom/huachenjie/run/widget/SunRunStartAnimView;", "animView", "", "getWidth", "getHeight", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "initView", "initData", "onStart", "onDestroyView", "Lkotlin/Function0;", "onComplete", "Lkotlin/jvm/functions/Function0;", "", "finished", "Z", "aborted", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunRunStartAnimDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SunRunStartAnimDialog";
    private boolean aborted;
    private boolean finished;

    @Nullable
    private Function0<Unit> onComplete;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.SunRunStartAnimDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/dialog/SunRunStartAnimDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fm", "Lkotlin/Function0;", "", "onComplete", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fm, @NotNull Function0<Unit> onComplete) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(onComplete, "onComplete");
            if (fm.findFragmentByTag(SunRunStartAnimDialog.TAG) != null) {
                return;
            }
            SunRunStartAnimDialog sunRunStartAnimDialog = new SunRunStartAnimDialog();
            sunRunStartAnimDialog.onComplete = onComplete;
            sunRunStartAnimDialog.show(fm, SunRunStartAnimDialog.TAG);
        }
    }

    private final SunRunStartAnimView animView() {
        View view = getView();
        SunRunStartAnimView sunRunStartAnimView = view instanceof SunRunStartAnimView ? (SunRunStartAnimView) view : null;
        if (sunRunStartAnimView != null) {
            return sunRunStartAnimView;
        }
        View view2 = getView();
        if (view2 != null) {
            return (SunRunStartAnimView) view2.findViewById(R.id.sun_run_start_anim);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$0(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_sun_run_start_anim;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() throws IOException {
        if (this.aborted) {
            return;
        }
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.zj.adlib.kv8
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return SunRunStartAnimDialog.initView$lambda$0(dialogInterface, i, keyEvent);
                }
            });
        }
        SunRunStartAnimView sunRunStartAnimViewAnimView = animView();
        if (sunRunStartAnimViewAnimView != null) {
            sunRunStartAnimViewAnimView.start(new Function0<Unit>() { // from class: com.huachenjie.run.dialog.SunRunStartAnimDialog.initView.2
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m625invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m625invoke() {
                    SunRunStartAnimDialog.this.finished = true;
                    Function0 function0 = SunRunStartAnimDialog.this.onComplete;
                    SunRunStartAnimDialog.this.onComplete = null;
                    SunRunStartAnimDialog.this.dismissAllowingStateLoss();
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        if (savedInstanceState != null) {
            this.aborted = true;
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() throws IOException {
        SunRunStartAnimView sunRunStartAnimViewAnimView = animView();
        if (sunRunStartAnimViewAnimView != null) {
            sunRunStartAnimViewAnimView.cancel();
        }
        super.onDestroyView();
        if (this.finished) {
            return;
        }
        this.onComplete = null;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null || (window = dialog2.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.0f;
        window.setAttributes(window.getAttributes());
        window.setLayout(-1, -1);
    }
}
