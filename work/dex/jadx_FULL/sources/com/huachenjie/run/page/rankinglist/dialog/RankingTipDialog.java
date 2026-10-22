package com.huachenjie.run.page.rankinglist.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogRankingTipBinding;
import com.huachenjie.run.page.rankinglist.dialog.RankingTipDialog;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/dialog/RankingTipDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RankingTipDialog extends BaseVMBottomDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.run.page.rankinglist.dialog.RankingTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/dialog/RankingTipDialog$a;", "", "Lcom/huachenjie/run/page/rankinglist/dialog/RankingTipDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RankingTipDialog a() {
            return new RankingTipDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2$lambda$0(RankingTipDialog rankingTipDialog, View view) {
        Intrinsics.checkNotNullParameter(rankingTipDialog, "this$0");
        rankingTipDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2$lambda$1(RankingTipDialog rankingTipDialog, View view) {
        Intrinsics.checkNotNullParameter(rankingTipDialog, "this$0");
        rankingTipDialog.dismiss();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.run_dialog_ranking_tip), Integer.valueOf(lk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        e.x3(this).l3().T2(false).a1();
        ((BaseVMDialogFragment) this).mState.b.setValue(Integer.valueOf(e.K0(this)));
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunDialogRankingTipBinding");
        RunDialogRankingTipBinding runDialogRankingTipBinding = (RunDialogRankingTipBinding) binding;
        runDialogRankingTipBinding.f35555a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wa7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingTipDialog.init$lambda$2$lambda$0(this.f45558a, view);
            }
        });
        runDialogRankingTipBinding.f11768a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xa7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankingTipDialog.init$lambda$2$lambda$1(this.f45778a, view);
            }
        });
    }
}
