package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.reconfig.baseView.BaseBottomDialogFragment;
import com.huachenjie.run.R;
import com.igexin.push.g.o;
import com.zj.adlib.f46;
import com.zj.adlib.sq9;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/huachenjie/run/dialog/RunFailDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "Lcom/huachenjie/common/bean/AlertTip;", "tip", "", "bindAlertTip", "", "buildSubText", "", "getWidth", "getHeight", "getLayoutResID", "onStart", "initView", "initData", "onDestroyView", "onDestroy", "Lkotlin/Function0;", "onRetry", "Lkotlin/jvm/functions/Function0;", "onQuit", "Landroid/widget/TextView;", "tvFailContent", "Landroid/widget/TextView;", "tvFailSubContent", "", "isShowing", "()Z", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunFailDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunFailDialog.kt\ncom/huachenjie/run/dialog/RunFailDialog\n+ 2 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n28#2:116\n262#3,2:117\n766#4:119\n857#4,2:120\n*S KotlinDebug\n*F\n+ 1 RunFailDialog.kt\ncom/huachenjie/run/dialog/RunFailDialog\n*L\n62#1:116\n106#1:117,2\n112#1:119\n112#1:120,2\n*E\n"})
public final class RunFailDialog extends BaseBottomDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_ALERT_TIP = "alertTip";

    @NotNull
    private static final String TAG = "RunFailDialog";

    @Nullable
    private Function0<Unit> onQuit;

    @Nullable
    private Function0<Unit> onRetry;

    @Nullable
    private TextView tvFailContent;

    @Nullable
    private TextView tvFailSubContent;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.RunFailDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J4\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/dialog/RunFailDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/huachenjie/common/bean/AlertTip;", "alertTip", "Lkotlin/Function0;", "", "onRetry", "onQuit", "a", "", "KEY_ALERT_TIP", "Ljava/lang/String;", "TAG", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nRunFailDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunFailDialog.kt\ncom/huachenjie/run/dialog/RunFailDialog$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fm, @Nullable AlertTip alertTip, @NotNull Function0<Unit> onRetry, @NotNull Function0<Unit> onQuit) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(onRetry, "onRetry");
            Intrinsics.checkNotNullParameter(onQuit, "onQuit");
            Fragment fragmentFindFragmentByTag = fm.findFragmentByTag(RunFailDialog.TAG);
            RunFailDialog runFailDialog = fragmentFindFragmentByTag instanceof RunFailDialog ? (RunFailDialog) fragmentFindFragmentByTag : null;
            if (runFailDialog != null) {
                RunFailDialog runFailDialog2 = runFailDialog.isShowing() ? runFailDialog : null;
                if (runFailDialog2 != null) {
                    runFailDialog2.onRetry = onRetry;
                    runFailDialog2.onQuit = onQuit;
                    runFailDialog2.bindAlertTip(alertTip);
                    return;
                }
            }
            RunFailDialog runFailDialog3 = new RunFailDialog();
            runFailDialog3.onRetry = onRetry;
            runFailDialog3.onQuit = onQuit;
            runFailDialog3.setArguments(BundleKt.bundleOf(TuplesKt.to("alertTip", alertTip)));
            runFailDialog3.show(fm, RunFailDialog.TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindAlertTip(AlertTip tip) {
        TextView textView;
        TextView textView2 = this.tvFailContent;
        if (textView2 == null || (textView = this.tvFailSubContent) == null) {
            return;
        }
        textView2.setText(f46.f41591a.a(tip != null ? tip.getContent() : null, "").toString());
        String strBuildSubText = buildSubText(tip);
        textView.setText(strBuildSubText);
        textView.setVisibility(StringsKt.isBlank(strBuildSubText) ^ true ? 0 : 8);
    }

    private final String buildSubText(AlertTip tip) {
        f46 f46Var = f46.f41591a;
        List listListOf = CollectionsKt.listOf(new String[]{f46Var.a(tip != null ? tip.subTitle : null, "").toString(), f46Var.a(tip != null ? tip.subContent : null, "").toString()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_fail;
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
        View viewRequireView = requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView()");
        this.tvFailContent = (TextView) viewRequireView.findViewById(R.id.tvFailContent);
        this.tvFailSubContent = (TextView) viewRequireView.findViewById(R.id.tvFailSubContent);
        bindAlertTip((AlertTip) requireArguments().getParcelable("alertTip"));
        View viewFindViewById = viewRequireView.findViewById(R.id.tvRetry);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "root.findViewById<TextView>(R.id.tvRetry)");
        sq9.f(viewFindViewById, null, new Function1<View, Unit>() { // from class: com.huachenjie.run.dialog.RunFailDialog.initView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, o.f);
                RunFailDialog.this.dismissAllowingStateLoss();
                Function0 function0 = RunFailDialog.this.onRetry;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, 1, null);
        View viewFindViewById2 = viewRequireView.findViewById(R.id.tvQuit);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "root.findViewById<TextView>(R.id.tvQuit)");
        sq9.f(viewFindViewById2, null, new Function1<View, Unit>() { // from class: com.huachenjie.run.dialog.RunFailDialog.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, o.f);
                RunFailDialog.this.dismissAllowingStateLoss();
                Function0 function0 = RunFailDialog.this.onQuit;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, 1, null);
    }

    public final boolean isShowing() {
        if (!isAdded()) {
            return false;
        }
        Dialog dialog = getDialog();
        return dialog != null && dialog.isShowing();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.onRetry = null;
        this.onQuit = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.tvFailContent = null;
        this.tvFailSubContent = null;
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
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
    }
}
