package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.qr_code_scan.ScanAlipayQRCodeActivity;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.NfcVerifyTipDialog;
import com.zj.adlib.fx7;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/run/dialog/NfcVerifyTipDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "buildTitle", "buildMessage", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "pauseSeconds", "I", "Lkotlin/Function0;", "onKnow", "Lkotlin/jvm/functions/Function0;", "onPause", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class NfcVerifyTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int HIGHLIGHT_COLOR = -28392;

    @Nullable
    private Function0<Unit> onKnow;

    @Nullable
    private Function0<Unit> onPause;
    private int pauseSeconds = 30;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.NfcVerifyTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JF\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/dialog/NfcVerifyTipDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "pauseSeconds", "Lkotlin/Function0;", "", "onKnow", "onPause", "onShown", "Lcom/huachenjie/run/dialog/NfcVerifyTipDialog;", "a", "HIGHLIGHT_COLOR", "I", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: com.huachenjie.run.dialog.NfcVerifyTipDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/dialog/NfcVerifyTipDialog$a$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "run_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0815a implements BaseDialogFragment.DialogFragmentListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f35755a;

            public C0815a(Function0<Unit> function0) {
                this.f35755a = function0;
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onShow() {
                Function0<Unit> function0 = this.f35755a;
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
        public static /* synthetic */ NfcVerifyTipDialog b(Companion companion, FragmentManager fragmentManager, int i, Function0 function0, Function0 function1, Function0 function2, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                function2 = null;
            }
            return companion.a(fragmentManager, i, function0, function1, function2);
        }

        @JvmStatic
        @NotNull
        public final NfcVerifyTipDialog a(@NotNull FragmentManager fragmentManager, int pauseSeconds, @NotNull Function0<Unit> onKnow, @NotNull Function0<Unit> onPause, @Nullable Function0<Unit> onShown) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(onKnow, "onKnow");
            Intrinsics.checkNotNullParameter(onPause, "onPause");
            NfcVerifyTipDialog nfcVerifyTipDialog = new NfcVerifyTipDialog();
            if (pauseSeconds <= 0) {
                pauseSeconds = 30;
            }
            nfcVerifyTipDialog.pauseSeconds = pauseSeconds;
            nfcVerifyTipDialog.onKnow = onKnow;
            nfcVerifyTipDialog.onPause = onPause;
            nfcVerifyTipDialog.setDialogFragmentListener(new C0815a(onShown));
            nfcVerifyTipDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(NfcVerifyTipDialog.class).getSimpleName());
            return nfcVerifyTipDialog;
        }
    }

    private final CharSequence buildMessage() {
        String string = getString(R.string.run_nfc_verify_msg_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.run_nfc_verify_msg_prefix)");
        String string2 = getString(R.string.run_nfc_verify_msg_highlight);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.run_nfc_verify_msg_highlight)");
        String str = string + string2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = string.length();
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-28392), length, str.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), length, str.length(), 33);
        return spannableStringBuilder;
    }

    private final CharSequence buildTitle() {
        String strValueOf = String.valueOf(this.pauseSeconds);
        String string = getString(R.string.run_nfc_verify_title, strValueOf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.run_n…erify_title, secondsText)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int iIndexOf$default = StringsKt.indexOf$default(string, strValueOf, 0, false, 6, (Object) null);
        if (iIndexOf$default >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-28392), iIndexOf$default, strValueOf.length() + iIndexOf$default, 33);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NfcVerifyTipDialog nfcVerifyTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcVerifyTipDialog, "this$0");
        Function0<Unit> function0 = nfcVerifyTipDialog.onKnow;
        if (function0 != null) {
            function0.invoke();
        }
        nfcVerifyTipDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(NfcVerifyTipDialog nfcVerifyTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcVerifyTipDialog, "this$0");
        Function0<Unit> function0 = nfcVerifyTipDialog.onPause;
        if (function0 != null) {
            function0.invoke();
        }
        nfcVerifyTipDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(NfcVerifyTipDialog nfcVerifyTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcVerifyTipDialog, "this$0");
        nfcVerifyTipDialog.startActivity(new Intent(nfcVerifyTipDialog.getContext(), (Class<?>) ScanAlipayQRCodeActivity.class));
    }

    @JvmStatic
    @NotNull
    public static final NfcVerifyTipDialog show(@NotNull FragmentManager fragmentManager, int i, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function1, @Nullable Function0<Unit> function2) {
        return INSTANCE.a(fragmentManager, i, function0, function1, function2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_nfc_verify_tip;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(76.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View viewFindViewById;
        TextView textView;
        TextView textView2;
        super.initView();
        setCancelable(false);
        View view = getView();
        TextView textView3 = view != null ? (TextView) view.findViewById(R.id.tv_title) : null;
        if (textView3 != null) {
            textView3.setText(buildTitle());
        }
        View view2 = getView();
        TextView textView4 = view2 != null ? (TextView) view2.findViewById(R.id.tv_message) : null;
        if (textView4 != null) {
            textView4.setText(buildMessage());
        }
        View view3 = getView();
        if (view3 != null && (textView2 = (TextView) view3.findViewById(R.id.tv_know)) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zy5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    NfcVerifyTipDialog.initView$lambda$0(this.f46368a, view4);
                }
            });
        }
        View view4 = getView();
        if (view4 != null && (textView = (TextView) view4.findViewById(R.id.tv_pause)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.az5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    NfcVerifyTipDialog.initView$lambda$1(this.f40642a, view5);
                }
            });
        }
        View view5 = getView();
        if (view5 == null || (viewFindViewById = view5.findViewById(R.id.ll_scan)) == null) {
            return;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bz5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                NfcVerifyTipDialog.initView$lambda$2(this.f40868a, view6);
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
}
