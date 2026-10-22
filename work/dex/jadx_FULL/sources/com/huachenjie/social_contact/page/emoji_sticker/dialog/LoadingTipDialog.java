package com.huachenjie.social_contact.page.emoji_sticker.dialog;

import android.os.Bundle;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.DialogLoadingTipBinding;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/LoadingTipDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "", "tip", "setTip", "mTip", "Ljava/lang/String;", "getMTip", "()Ljava/lang/String;", "setMTip", "(Ljava/lang/String;)V", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class LoadingTipDialog extends BaseVMDialogFragment<BaseVM> {

    @NotNull
    private String mTip = "加载中...";

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_loading_tip), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState);
    }

    @NotNull
    public final String getMTip() {
        return this.mTip;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        setCancelable(false);
        setTip(this.mTip);
    }

    public final void setMTip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTip = str;
    }

    public final void setTip(@NotNull String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        DialogLoadingTipBinding dialogLoadingTipBinding = (DialogLoadingTipBinding) getBinding();
        if (dialogLoadingTipBinding != null) {
            dialogLoadingTipBinding.f36147a.setText(tip);
        }
        this.mTip = tip;
    }
}
