package com.huachenjie.mall.page.refund_detail;

import android.widget.TextView;
import com.alibaba.android.arouter.utils.TextUtils;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallDialogOrderRemarkBinding;
import com.huachenjie.mall.page.check_order.OrderRemarkDialog;
import com.huachenjie.mall.page.check_order.OrderRemarkVM;
import com.noober.background.view.BLEditText;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/refund_detail/RefundCancelDialog;", "Lcom/huachenjie/mall/page/check_order/OrderRemarkDialog;", "()V", "checkConfirm", "", "getViewModelClass", "Ljava/lang/Class;", "Lcom/huachenjie/mall/page/check_order/OrderRemarkVM;", "initView", "", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RefundCancelDialog extends OrderRemarkDialog {
    @Override // com.huachenjie.mall.page.check_order.OrderRemarkDialog
    public boolean checkConfirm() {
        String string;
        BLEditText bLEditText;
        CharSequence hint;
        if (!TextUtils.isEmpty(getMViewModel().j().getValue())) {
            return super.checkConfirm();
        }
        MallDialogOrderRemarkBinding mBinding = getMBinding();
        if (mBinding == null || (bLEditText = mBinding.f10592a) == null || (hint = bLEditText.getHint()) == null || (string = hint.toString()) == null) {
            string = "";
        }
        fv5.b(string);
        return false;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Class<OrderRemarkVM> getViewModelClass() {
        return OrderRemarkVM.class;
    }

    @Override // com.huachenjie.mall.page.check_order.OrderRemarkDialog, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MallDialogOrderRemarkBinding mBinding = getMBinding();
        TextView textView = mBinding != null ? mBinding.f10589a : null;
        if (textView != null) {
            textView.setText(getString(R.string.mall_cancel_refund_dialog_title));
        }
        MallDialogOrderRemarkBinding mBinding2 = getMBinding();
        BLEditText bLEditText = mBinding2 != null ? mBinding2.f10592a : null;
        if (bLEditText == null) {
            return;
        }
        bLEditText.setHint(getString(R.string.mall_cancel_refund_dialog_hint));
    }
}
