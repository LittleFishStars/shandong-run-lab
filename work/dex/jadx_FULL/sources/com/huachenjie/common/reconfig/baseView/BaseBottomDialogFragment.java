package com.huachenjie.common.reconfig.baseView;

import com.huachenjie.common.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "()V", "getGravity", "", "initStyle", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseBottomDialogFragment extends BaseDialogFragment {
    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getGravity() {
        return 80;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public void initStyle() {
        setStyle(1, R.style.ActionSheetDialogStyle);
    }
}
