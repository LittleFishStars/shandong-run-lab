package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModelProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogPauseBinding;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.service.DataComponent;
import com.huachenjie.run.widget.RunActionButton;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002-.B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u0011R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/huachenjie/run/dialog/RunPauseDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogPauseBinding;", "Lcom/huachenjie/run/page/sun_run/SunshineRunVM;", "activityVm", "", "getWidth", "getHeight", "getLayoutResID", "", "getVariables", "", "onStart", "initView", "initDataObserve", "initData", "onDestroyView", "", "secs", "updateLeftTime", "Lcom/huachenjie/run/service/DataComponent;", "dc", "bindRunData", "Landroidx/fragment/app/FragmentManager;", "fm", "", "tag", "showDialog", "mRestTotalSecs", "J", "mRestFrom", "Lcom/huachenjie/run/dialog/RunPauseDialog$OnRunActionListener;", "mListener", "Lcom/huachenjie/run/dialog/RunPauseDialog$OnRunActionListener;", "leftTimeSecs", "", "showing", "Z", "pendingBind", "Lcom/huachenjie/run/service/DataComponent;", "isShowing", "()Z", "<init>", "()V", "Companion", "a", "OnRunActionListener", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunPauseDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunPauseDialog.kt\ncom/huachenjie/run/dialog/RunPauseDialog\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n28#2:140\n1#3:141\n*S KotlinDebug\n*F\n+ 1 RunPauseDialog.kt\ncom/huachenjie/run/dialog/RunPauseDialog\n*L\n54#1:140\n*E\n"})
public final class RunPauseDialog extends BaseMVVMBottomDialogFragment<RunDialogPauseBinding, SunshineRunVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long leftTimeSecs = 120;

    @Nullable
    private OnRunActionListener mListener;
    private long mRestFrom;
    private long mRestTotalSecs;

    @Nullable
    private DataComponent pendingBind;
    private boolean showing;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/RunPauseDialog$OnRunActionListener;", "", "", "restTotalSecs", "", "a", "", "b", "run_release"}, k = 1, mv = {1, 8, 0})
    public interface OnRunActionListener {
        boolean a(int restTotalSecs);

        void b(int restTotalSecs);
    }

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.RunPauseDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/RunPauseDialog$a;", "", "Lcom/huachenjie/run/dialog/RunPauseDialog$OnRunActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/huachenjie/run/dialog/RunPauseDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RunPauseDialog a(@Nullable OnRunActionListener listener) {
            RunPauseDialog runPauseDialog = new RunPauseDialog();
            runPauseDialog.mListener = listener;
            return runPauseDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35756a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35756a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35756a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35756a.invoke(obj);
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
        return R.layout.run_dialog_pause;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, SunshineRunVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), activityVm()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        activityVm().D().setValue(Long.valueOf(this.leftTimeSecs));
        DataComponent dataComponent = this.pendingBind;
        if (dataComponent != null) {
            activityVm().i(dataComponent);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        activityVm().D().observe(getViewLifecycleOwner(), new b(new Function1<Long, Unit>() { // from class: com.huachenjie.run.dialog.RunPauseDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                if (l == null || l.longValue() != 0) {
                    return;
                }
                RunPauseDialog.this.dismissAllowingStateLoss();
                RunPauseDialog runPauseDialog = RunPauseDialog.this;
                runPauseDialog.mRestTotalSecs = runPauseDialog.mRestFrom;
                OnRunActionListener onRunActionListener = RunPauseDialog.this.mListener;
                if (onRunActionListener != null) {
                    onRunActionListener.b((int) RunPauseDialog.this.mRestTotalSecs);
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        RunDialogPauseBinding runDialogPauseBinding = (RunDialogPauseBinding) getMBinding();
        RunActionButton runActionButton = runDialogPauseBinding != null ? runDialogPauseBinding.f11754a : null;
        if (runActionButton != null) {
            runActionButton.setOnActionLongPress(new Function0<Unit>() { // from class: com.huachenjie.run.dialog.RunPauseDialog.initView.1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m622invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m622invoke() {
                    OnRunActionListener onRunActionListener = RunPauseDialog.this.mListener;
                    if (onRunActionListener != null) {
                        onRunActionListener.b((int) RunPauseDialog.this.mRestTotalSecs);
                    }
                }
            });
        }
        RunDialogPauseBinding runDialogPauseBinding2 = (RunDialogPauseBinding) getMBinding();
        RunActionButton runActionButton2 = runDialogPauseBinding2 != null ? runDialogPauseBinding2.f11756b : null;
        if (runActionButton2 == null) {
            return;
        }
        runActionButton2.setOnActionClick(new Function0<Unit>() { // from class: com.huachenjie.run.dialog.RunPauseDialog.initView.2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m623invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m623invoke() {
                OnRunActionListener onRunActionListener = RunPauseDialog.this.mListener;
                boolean z = false;
                if (onRunActionListener != null && onRunActionListener.a((int) RunPauseDialog.this.mRestTotalSecs)) {
                    z = true;
                }
                if (z) {
                    RunPauseDialog.this.dismissAllowingStateLoss();
                }
            }
        });
    }

    public final boolean isShowing() {
        return this.showing || isAdded();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
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
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                Intrinsics.checkNotNullExpressionValue(attributes, "attributes");
                attributes.flags |= 8;
            } else {
                attributes = null;
            }
            window.setAttributes(attributes);
        }
        setCancelable(false);
        this.showing = true;
    }

    public final void showDialog(@NotNull FragmentManager fm, @Nullable String tag, long secs) {
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.leftTimeSecs = secs;
        this.mRestFrom = secs;
        this.mRestTotalSecs = 0L;
        if (isAdded()) {
            activityVm().D().setValue(Long.valueOf(secs));
        }
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

    public final void updateLeftTime(long secs) {
        if (isAdded()) {
            activityVm().D().setValue(Long.valueOf(secs));
        } else {
            this.leftTimeSecs = secs;
        }
        this.mRestTotalSecs = this.mRestFrom - secs;
    }
}
