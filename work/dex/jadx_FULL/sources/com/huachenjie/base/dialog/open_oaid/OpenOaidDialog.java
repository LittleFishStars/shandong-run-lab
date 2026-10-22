package com.huachenjie.base.dialog.open_oaid;

import android.os.Bundle;
import android.view.View;
import com.huachenjie.base.R;
import com.huachenjie.base.databinding.DialogOpenOaidBinding;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.zj.adlib.i62;
import com.zj.adlib.r90;
import com.zj.adlib.sk0;
import com.zj.adlib.su9;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/dialog/open_oaid/OpenOaidDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
public final class OpenOaidDialog extends BaseVMDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/dialog/open_oaid/OpenOaidDialog$a;", "", "Landroid/view/View;", "view", "", "d", "b", "a", "c", "<init>", "(Lcom/huachenjie/base/dialog/open_oaid/OpenOaidDialog;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DialogOpenOaidBinding dialogOpenOaidBinding = (DialogOpenOaidBinding) OpenOaidDialog.this.getBinding();
            if (dialogOpenOaidBinding == null) {
                return;
            }
            boolean zT = r90.t();
            r90.X(!zT);
            if (zT) {
                dialogOpenOaidBinding.f32827a.setImageResource(R.drawable.ic_checkbox_unchecked);
            } else {
                dialogOpenOaidBinding.f32827a.setImageResource(R.drawable.ic_checkbox_checked);
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.o(view.getContext());
            OpenOaidDialog.this.dismissAllowingStateLoss();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            OpenOaidDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.open_oaid.OpenOaidDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/base/dialog/open_oaid/OpenOaidDialog$b;", "", "Lcom/huachenjie/base/dialog/open_oaid/OpenOaidDialog;", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OpenOaidDialog a() {
            return new OpenOaidDialog();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_open_oaid), Integer.valueOf(sk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(sk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        DialogOpenOaidBinding dialogOpenOaidBinding = (DialogOpenOaidBinding) getBinding();
        if (dialogOpenOaidBinding == null) {
            return;
        }
        if (r90.t()) {
            dialogOpenOaidBinding.f32827a.setImageResource(R.drawable.ic_checkbox_checked);
        } else {
            dialogOpenOaidBinding.f32827a.setImageResource(R.drawable.ic_checkbox_unchecked);
        }
    }
}
