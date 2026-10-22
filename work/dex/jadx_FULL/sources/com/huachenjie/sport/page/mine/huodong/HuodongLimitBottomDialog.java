package com.huachenjie.sport.page.mine.huodong;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.DialogHuodongLimitBottomBinding;
import com.huachenjie.sport.page.mine.huodong.HuodongLimitBottomDialog;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongLimitBottomDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongLimitBottomDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.huodong.HuodongLimitBottomDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongLimitBottomDialog$a;", "", "", "ruleString", "Lcom/huachenjie/sport/page/mine/huodong/HuodongLimitBottomDialog;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HuodongLimitBottomDialog a(@NotNull String ruleString) {
            Intrinsics.checkNotNullParameter(ruleString, "ruleString");
            HuodongLimitBottomDialog huodongLimitBottomDialog = new HuodongLimitBottomDialog();
            Bundle bundle = new Bundle();
            bundle.putString("ruleString", ruleString);
            huodongLimitBottomDialog.setArguments(bundle);
            return huodongLimitBottomDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(HuodongLimitBottomDialog huodongLimitBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(huodongLimitBottomDialog, "this$0");
        huodongLimitBottomDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_huodong_limit_bottom), Integer.valueOf(ok0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return SizeUtils.b(385.0f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.DialogHuodongLimitBottomBinding");
        DialogHuodongLimitBottomBinding dialogHuodongLimitBottomBinding = (DialogHuodongLimitBottomBinding) binding;
        dialogHuodongLimitBottomBinding.f13397a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.g34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuodongLimitBottomDialog.init$lambda$0(this.f41809a, view);
            }
        });
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ruleString") : null;
        TextView textView = dialogHuodongLimitBottomBinding.f13398a;
        if (string == null) {
            string = "";
        }
        textView.setText(string);
    }
}
