package com.huachenjie.sport.page.mine.qrcode;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.DialogQrCodeBinding;
import com.zj.adlib.dn1;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.c)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/huachenjie/sport/page/mine/qrcode/QRCodeDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/sport/page/mine/qrcode/QRCodeVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class QRCodeDialog extends BaseVMDialogFragment<QRCodeVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/qrcode/QRCodeDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/qrcode/QRCodeDialog;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QRCodeDialog.this.dismiss();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36708a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36708a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36708a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36708a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_qr_code), Integer.valueOf(ok0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…lickProxy()\n            )");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        ((QRCodeVM) ((BaseVMDialogFragment) this).mState).j();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        ((QRCodeVM) ((BaseVMDialogFragment) this).mState).i().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.qrcode.QRCodeDialog.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ViewDataBinding binding = QRCodeDialog.this.getBinding();
                Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.DialogQrCodeBinding");
                ((DialogQrCodeBinding) binding).f36454a.setImageBitmap(dn1.g(str, 600, -16777216, -1, null, 0, null, 0, 0.0f, 496, null));
            }
        }));
    }
}
