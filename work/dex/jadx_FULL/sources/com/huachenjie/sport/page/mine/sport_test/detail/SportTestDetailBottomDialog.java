package com.huachenjie.sport.page.mine.sport_test.detail;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.DialogBottomSportTestDetailBinding;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailBottomDialog;
import com.zj.adlib.i62;
import com.zj.adlib.vk0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailBottomDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "Lkotlin/Function0;", "block", "setCloseCallback", "closeCallBack", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestDetailBottomDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function0<Unit> closeCallBack;

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailBottomDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailBottomDialog$a;", "", "Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailBottomDialog;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SportTestDetailBottomDialog a() {
            return new SportTestDetailBottomDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(SportTestDetailBottomDialog sportTestDetailBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(sportTestDetailBottomDialog, "this$0");
        Function0<Unit> function0 = sportTestDetailBottomDialog.closeCallBack;
        if (function0 != null) {
            function0.invoke();
        }
        sportTestDetailBottomDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_bottom_sport_test_detail), Integer.valueOf(vk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return this.WARP;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.DialogBottomSportTestDetailBinding");
        ((DialogBottomSportTestDetailBinding) binding).f36445a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestDetailBottomDialog.init$lambda$0(this.f43567a, view);
            }
        });
    }

    public final void setCloseCallback(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.closeCallBack = block;
    }
}
