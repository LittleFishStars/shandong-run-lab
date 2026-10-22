package com.huachenjie.common.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.databinding.DialogBottomExamNoticeBinding;
import com.huachenjie.common.widget.ExamNoticeBottomDialog;
import com.zj.adlib.dv5;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.vk0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/common/widget/ExamNoticeBottomDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "Lkotlin/Function0;", "block", "setCloseCallback", "closeCallBack", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "common_release"}, k = 1, mv = {1, 8, 0})
public final class ExamNoticeBottomDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function0<Unit> closeCallBack;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/common/widget/ExamNoticeBottomDialog$Companion;", "", "()V", "getInstance", "Lcom/huachenjie/common/widget/ExamNoticeBottomDialog;", "buttonString", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExamNoticeBottomDialog getInstance(@NotNull String buttonString) {
            Intrinsics.checkNotNullParameter(buttonString, "buttonString");
            ExamNoticeBottomDialog examNoticeBottomDialog = new ExamNoticeBottomDialog();
            Bundle bundle = new Bundle();
            bundle.putString("buttonString", buttonString);
            examNoticeBottomDialog.setArguments(bundle);
            return examNoticeBottomDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(ExamNoticeBottomDialog examNoticeBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(examNoticeBottomDialog, "this$0");
        Function0<Unit> function0 = examNoticeBottomDialog.closeCallBack;
        if (function0 != null) {
            function0.invoke();
        }
        examNoticeBottomDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_bottom_exam_notice), Integer.valueOf(vk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return (int) (fx7.c() * 0.6f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        String string;
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.common.databinding.DialogBottomExamNoticeBinding");
        DialogBottomExamNoticeBinding dialogBottomExamNoticeBinding = (DialogBottomExamNoticeBinding) binding;
        TextView textView = dialogBottomExamNoticeBinding.f33750a;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("buttonString")) == null) {
            string = "我知道了";
        }
        textView.setText(string);
        dialogBottomExamNoticeBinding.f33750a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.u63
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamNoticeBottomDialog.init$lambda$0(this.f45069a, view);
            }
        });
        dv5.Companion companion = dv5.INSTANCE;
        String string2 = getString(R.string.exam_tip);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.exam_tip)");
        dialogBottomExamNoticeBinding.b.setText(companion.a(string2, new String[]{"强制收卷", "左右滑动手机屏幕切换", "手动交卷"}, zn1.a(R.color.color_FF1919)));
    }

    public final void setCloseCallback(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.closeCallBack = block;
    }
}
