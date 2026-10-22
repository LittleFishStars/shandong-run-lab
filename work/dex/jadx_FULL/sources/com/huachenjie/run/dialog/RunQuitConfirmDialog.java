package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.ViewModelProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogQuitConfirmBinding;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.service.DataComponent;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003%&'B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/huachenjie/run/dialog/RunQuitConfirmDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogQuitConfirmBinding;", "Lcom/huachenjie/run/page/sun_run/SunshineRunVM;", "activityVm", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "onStart", "initData", "onDestroyView", "Lcom/huachenjie/run/service/DataComponent;", "dc", "bindRunData", "Landroidx/fragment/app/FragmentManager;", "fm", "", "tag", "showDialog", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$OnQuitConfirmListener;", "mListener", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$OnQuitConfirmListener;", "", "showing", "Z", "pendingBind", "Lcom/huachenjie/run/service/DataComponent;", "isShowing", "()Z", "<init>", "()V", "Companion", "a", "b", "OnQuitConfirmListener", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunQuitConfirmDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunQuitConfirmDialog.kt\ncom/huachenjie/run/dialog/RunQuitConfirmDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
public final class RunQuitConfirmDialog extends BaseMVVMBottomDialogFragment<RunDialogQuitConfirmBinding, SunshineRunVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnQuitConfirmListener mListener;

    @Nullable
    private DataComponent pendingBind;
    private boolean showing;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$OnQuitConfirmListener;", "", "", "a", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public interface OnQuitConfirmListener {
        boolean a();

        void b();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/run/dialog/RunQuitConfirmDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            OnQuitConfirmListener onQuitConfirmListener = RunQuitConfirmDialog.this.mListener;
            boolean z = false;
            if (onQuitConfirmListener != null && onQuitConfirmListener.a()) {
                z = true;
            }
            if (z) {
                RunQuitConfirmDialog.this.dismissAllowingStateLoss();
            }
        }

        public final void b(@Nullable View v) {
            OnQuitConfirmListener onQuitConfirmListener = RunQuitConfirmDialog.this.mListener;
            if (onQuitConfirmListener != null) {
                onQuitConfirmListener.b();
            }
            RunQuitConfirmDialog.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.RunQuitConfirmDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$b;", "", "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog$OnQuitConfirmListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/huachenjie/run/dialog/RunQuitConfirmDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RunQuitConfirmDialog a(@Nullable OnQuitConfirmListener listener) {
            RunQuitConfirmDialog runQuitConfirmDialog = new RunQuitConfirmDialog();
            runQuitConfirmDialog.mListener = listener;
            return runQuitConfirmDialog;
        }
    }

    private final SunshineRunVM activityVm() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        return (SunshineRunVM) new ViewModelProvider(fragmentActivityRequireActivity).get(SunshineRunVM.class);
    }

    public final void bindRunData(@Nullable DataComponent dc) {
        this.pendingBind = dc;
        if (isAdded()) {
            activityVm().i(dc);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_quit_confirm;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), activityVm()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        activityVm().p().setValue(Boolean.TRUE);
        DataComponent dataComponent = this.pendingBind;
        if (dataComponent != null) {
            activityVm().i(dataComponent);
        }
    }

    public final boolean isShowing() {
        return this.showing || isAdded();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        activityVm().p().setValue(Boolean.FALSE);
        this.showing = false;
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(false);
        this.showing = true;
    }

    public final void showDialog(@NotNull FragmentManager fm, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        if (isAdded() || this.showing) {
            return;
        }
        try {
            Fragment fragmentFindFragmentByTag = fm.findFragmentByTag(tag == null ? "" : tag);
            if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag != this) {
                fm.beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
            }
            this.showing = true;
            super.show(fm, tag);
        } catch (Exception e) {
            this.showing = false;
            e.printStackTrace();
        }
    }
}
