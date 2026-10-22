package com.huachenjie.sport.page.mine.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.DialogExamNotFinishTipBinding;
import com.huachenjie.sport.page.mine.exam.ExamNotFinishTipDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eJ\u0016\u0010\u0012\u001a\u00020\u00002\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamNotFinishTipDialog;", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "Lkotlin/Function0;", "clickLeftCallBack", "setOnLeftClickListener", "clickRightCallBack", "setOnRightClickListener", "Lkotlin/jvm/functions/Function0;", "Lcom/huachenjie/sport/databinding/DialogExamNotFinishTipBinding;", "inflate", "Lcom/huachenjie/sport/databinding/DialogExamNotFinishTipBinding;", "getInflate", "()Lcom/huachenjie/sport/databinding/DialogExamNotFinishTipBinding;", "setInflate", "(Lcom/huachenjie/sport/databinding/DialogExamNotFinishTipBinding;)V", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ExamNotFinishTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function0<Unit> clickLeftCallBack;

    @Nullable
    private Function0<Unit> clickRightCallBack;
    public DialogExamNotFinishTipBinding inflate;

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.exam.ExamNotFinishTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamNotFinishTipDialog$a;", "", "", "process", "max", "Lcom/huachenjie/sport/page/mine/exam/ExamNotFinishTipDialog;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExamNotFinishTipDialog a(int process, int max) {
            ExamNotFinishTipDialog examNotFinishTipDialog = new ExamNotFinishTipDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("process", process);
            bundle.putInt("max", max);
            examNotFinishTipDialog.setArguments(bundle);
            return examNotFinishTipDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ExamNotFinishTipDialog examNotFinishTipDialog, View view) {
        Intrinsics.checkNotNullParameter(examNotFinishTipDialog, "this$0");
        Function0<Unit> function0 = examNotFinishTipDialog.clickLeftCallBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ExamNotFinishTipDialog examNotFinishTipDialog, View view) {
        Intrinsics.checkNotNullParameter(examNotFinishTipDialog, "this$0");
        Function0<Unit> function0 = examNotFinishTipDialog.clickRightCallBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @NotNull
    public final DialogExamNotFinishTipBinding getInflate() {
        DialogExamNotFinishTipBinding dialogExamNotFinishTipBinding = this.inflate;
        if (dialogExamNotFinishTipBinding != null) {
            return dialogExamNotFinishTipBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inflate");
        return null;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.dialog_style);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogExamNotFinishTipBinding dialogExamNotFinishTipBindingD = DialogExamNotFinishTipBinding.d(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogExamNotFinishTipBindingD, "inflate(inflater, container, false)");
        setInflate(dialogExamNotFinishTipBindingD);
        ConstraintLayout root = getInflate().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("process");
            int i2 = arguments.getInt("max");
            getInflate().f13396a.setMax(i2);
            getInflate().f13396a.setProgress(i);
            getInflate().e.setText(String.valueOf(i));
            TextView textView = getInflate().d;
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            sb.append(i2);
            textView.setText(sb.toString());
        }
        getInflate().f36447a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExamNotFinishTipDialog.onViewCreated$lambda$1(this.f44617a, view2);
            }
        });
        getInflate().b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.t63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExamNotFinishTipDialog.onViewCreated$lambda$2(this.f44854a, view2);
            }
        });
    }

    public final void setInflate(@NotNull DialogExamNotFinishTipBinding dialogExamNotFinishTipBinding) {
        Intrinsics.checkNotNullParameter(dialogExamNotFinishTipBinding, "<set-?>");
        this.inflate = dialogExamNotFinishTipBinding;
    }

    @NotNull
    public final ExamNotFinishTipDialog setOnLeftClickListener(@Nullable Function0<Unit> clickLeftCallBack) {
        this.clickLeftCallBack = clickLeftCallBack;
        return this;
    }

    @NotNull
    public final ExamNotFinishTipDialog setOnRightClickListener(@Nullable Function0<Unit> clickRightCallBack) {
        this.clickRightCallBack = clickRightCallBack;
        return this;
    }
}
