package com.huachenjie.social_contact.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.DialogBuySuccessBinding;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/social_contact/dialog/BuySuccessDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "Landroid/view/View;", "mRootView", "initView", "<init>", "()V", "Companion", "a", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class BuySuccessDialog extends BaseVMDialogFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String STAR_DRILL = "starDrill";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/dialog/BuySuccessDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/social_contact/dialog/BuySuccessDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            BuySuccessDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.dialog.BuySuccessDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/dialog/BuySuccessDialog$b;", "", "", BuySuccessDialog.STAR_DRILL, "Lcom/huachenjie/social_contact/dialog/BuySuccessDialog;", "a", "", "STAR_DRILL", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BuySuccessDialog a(int starDrill) {
            BuySuccessDialog buySuccessDialog = new BuySuccessDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(BuySuccessDialog.STAR_DRILL, starDrill);
            buySuccessDialog.setArguments(bundle);
            return buySuccessDialog;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_buy_success), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(\n     …m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        setCancelable(true);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initView(@Nullable View mRootView) {
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt(STAR_DRILL) : 0;
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.DialogBuySuccessBinding");
        TextView textView = ((DialogBuySuccessBinding) binding).f36127a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
    }
}
