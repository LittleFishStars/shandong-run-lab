package com.huachenjie.social_contact.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.adapter.ReceiveSysGiftAdapter;
import com.huachenjie.social_contact.vm.ReceiveSysGiftVM;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014R*\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ReceiveSysGiftDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/social_contact/vm/ReceiveSysGiftVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "", "setStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "mRootView", "initView", "Ljava/util/ArrayList;", "Lcom/huachenjie/base/bean/GiftBean;", "Lkotlin/collections/ArrayList;", "giftList", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ReceiveSysGiftDialog extends BaseVMDialogFragment<ReceiveSysGiftVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private ArrayList<GiftBean> giftList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ReceiveSysGiftDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/social_contact/dialog/ReceiveSysGiftDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ReceiveSysGiftDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.dialog.ReceiveSysGiftDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ReceiveSysGiftDialog$b;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/base/bean/GiftBean;", "Lkotlin/collections/ArrayList;", GoodsSpecificationPreviewActivity.z, "Lcom/huachenjie/social_contact/dialog/ReceiveSysGiftDialog;", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReceiveSysGiftDialog a(@NotNull ArrayList<GiftBean> list) {
            Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
            ReceiveSysGiftDialog receiveSysGiftDialog = new ReceiveSysGiftDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(UserConstants.NOTICE_PARAMS.f33734a, list);
            receiveSysGiftDialog.setArguments(bundle);
            return receiveSysGiftDialog;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_receive_sys_gift), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        MutableLiveData<ReceiveSysGiftAdapter> mutableLiveDataH;
        ReceiveSysGiftAdapter value;
        Bundle arguments = getArguments();
        this.giftList = arguments != null ? arguments.getParcelableArrayList(UserConstants.NOTICE_PARAMS.f33734a) : null;
        ReceiveSysGiftVM receiveSysGiftVM = (ReceiveSysGiftVM) ((BaseVMDialogFragment) this).mState;
        MutableLiveData<ReceiveSysGiftAdapter> mutableLiveDataH2 = receiveSysGiftVM != null ? receiveSysGiftVM.h() : null;
        if (mutableLiveDataH2 != null) {
            mutableLiveDataH2.setValue(new ReceiveSysGiftAdapter(R.layout.item_receive_sys_gift));
        }
        ReceiveSysGiftVM receiveSysGiftVM2 = (ReceiveSysGiftVM) ((BaseVMDialogFragment) this).mState;
        if (receiveSysGiftVM2 == null || (mutableLiveDataH = receiveSysGiftVM2.h()) == null || (value = mutableLiveDataH.getValue()) == null) {
            return;
        }
        value.setList(this.giftList);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initView(@Nullable View mRootView) {
    }

    public final void setStatusBar() {
        e.x3(this).M2(0).T2(true).k3().G1(true).a1();
    }
}
