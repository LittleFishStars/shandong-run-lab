package com.huachenjie.common.reconfig.mvvm;

import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "()V", "getGravity", "", "initStyle", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseMVVMBottomDialogFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseMVVMDialogFragment<V, VM> {
    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getGravity() {
        return 80;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public void initStyle() {
        setStyle(1, R.style.ActionSheetDialogStyle);
    }
}
