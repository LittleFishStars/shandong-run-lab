package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.qr_code_scan.ScanAlipayQRCodeActivity;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.NfcPauseTipDialog;
import com.zj.adlib.fx7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/run/dialog/NfcPauseTipDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "seconds", "", "buildTitle", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "getWidth", "getHeight", "getLayoutResID", "", "initView", "updateLeftSeconds", "Lkotlin/Function0;", "onResume", "Lkotlin/jvm/functions/Function0;", "leftSeconds$delegate", "Lkotlin/Lazy;", "getLeftSeconds", "()I", "leftSeconds", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class NfcPauseTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int HIGHLIGHT_COLOR = -28392;

    @NotNull
    private static final String KEY_LEFT_SECONDS = "left_seconds";

    /* JADX INFO: renamed from: leftSeconds$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftSeconds = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.dialog.NfcPauseTipDialog$leftSeconds$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m614invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("left_seconds") : 0);
        }
    });

    @Nullable
    private Function0<Unit> onResume;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.NfcPauseTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/run/dialog/NfcPauseTipDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "leftSeconds", "Lkotlin/Function0;", "", "onResume", "onShown", "Lcom/huachenjie/run/dialog/NfcPauseTipDialog;", "a", "HIGHLIGHT_COLOR", "I", "", "KEY_LEFT_SECONDS", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.huachenjie.run.dialog.NfcPauseTipDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/dialog/NfcPauseTipDialog$a$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "run_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0814a implements BaseDialogFragment.DialogFragmentListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f35754a;

            public C0814a(Function0<Unit> function0) {
                this.f35754a = function0;
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onShow() {
                Function0<Unit> function0 = this.f35754a;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NfcPauseTipDialog b(Companion companion, FragmentManager fragmentManager, int i, Function0 function0, Function0 function1, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                function1 = null;
            }
            return companion.a(fragmentManager, i, function0, function1);
        }

        @JvmStatic
        @NotNull
        public final NfcPauseTipDialog a(@NotNull FragmentManager fragmentManager, int leftSeconds, @NotNull Function0<Unit> onResume, @Nullable Function0<Unit> onShown) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(onResume, "onResume");
            NfcPauseTipDialog nfcPauseTipDialog = new NfcPauseTipDialog();
            nfcPauseTipDialog.onResume = onResume;
            Bundle bundle = new Bundle();
            bundle.putInt(NfcPauseTipDialog.KEY_LEFT_SECONDS, leftSeconds);
            nfcPauseTipDialog.setArguments(bundle);
            nfcPauseTipDialog.setDialogFragmentListener(new C0814a(onShown));
            nfcPauseTipDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(NfcPauseTipDialog.class).getSimpleName());
            return nfcPauseTipDialog;
        }
    }

    private final CharSequence buildTitle(int seconds) {
        String strValueOf = String.valueOf(seconds);
        String string = getString(R.string.run_nfc_pause_title, strValueOf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.run_n…pause_title, secondsText)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int iIndexOf$default = StringsKt.indexOf$default(string, strValueOf, 0, false, 6, (Object) null);
        if (iIndexOf$default >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-28392), iIndexOf$default, strValueOf.length() + iIndexOf$default, 33);
        }
        return spannableStringBuilder;
    }

    private final int getLeftSeconds() {
        return ((Number) this.leftSeconds.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NfcPauseTipDialog nfcPauseTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcPauseTipDialog, "this$0");
        Function0<Unit> function0 = nfcPauseTipDialog.onResume;
        if (function0 != null) {
            function0.invoke();
        }
        nfcPauseTipDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(NfcPauseTipDialog nfcPauseTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcPauseTipDialog, "this$0");
        nfcPauseTipDialog.startActivity(new Intent(nfcPauseTipDialog.getContext(), (Class<?>) ScanAlipayQRCodeActivity.class));
    }

    @JvmStatic
    @NotNull
    public static final NfcPauseTipDialog show(@NotNull FragmentManager fragmentManager, int i, @NotNull Function0<Unit> function0, @Nullable Function0<Unit> function1) {
        return INSTANCE.a(fragmentManager, i, function0, function1);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_nfc_pause_tip;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(76.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View viewFindViewById;
        TextView textView;
        super.initView();
        setCancelable(false);
        updateLeftSeconds(getLeftSeconds());
        View view = getView();
        if (view != null && (textView = (TextView) view.findViewById(R.id.tv_resume)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ty5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NfcPauseTipDialog.initView$lambda$0(this.f45027a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 == null || (viewFindViewById = view2.findViewById(R.id.ll_scan)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.uy5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                NfcPauseTipDialog.initView$lambda$1(this.f45249a, view3);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setType(1000);
        }
        return dialogOnCreateDialog;
    }

    public final void updateLeftSeconds(int seconds) {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.tv_title) : null;
        if (textView == null) {
            return;
        }
        textView.setText(buildTitle(seconds));
    }
}
