package com.huachenjie.login.page.info.portrait;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.RegisterConfigHeadBean;
import com.huachenjie.login.databinding.LoginItemChoosePortraitBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/login/page/info/portrait/ChoosePortraitAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/login/bean/RegisterConfigHeadBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/login/databinding/LoginItemChoosePortraitBinding;", "holder", "item", "", "convert", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "selectIndex", "<init>", "(Landroidx/lifecycle/MutableLiveData;)V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChoosePortraitAdapter extends BaseQuickAdapter<RegisterConfigHeadBean, BaseDataBindingHolder<LoginItemChoosePortraitBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePortraitAdapter(@NotNull MutableLiveData<Integer> mutableLiveData) {
        super(R.layout.login_item_choose_portrait, null, 2, null);
        Intrinsics.checkNotNullParameter(mutableLiveData, "selectIndex");
        this.selectIndex = mutableLiveData;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<LoginItemChoosePortraitBinding> holder, @NotNull RegisterConfigHeadBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        LoginItemChoosePortraitBinding loginItemChoosePortraitBinding = (LoginItemChoosePortraitBinding) holder.getDataBinding();
        if (loginItemChoosePortraitBinding != null) {
            loginItemChoosePortraitBinding.m(item.getHeadImgUrl());
            Integer value = this.selectIndex.getValue();
            loginItemChoosePortraitBinding.l(Boolean.valueOf(value != null && value.intValue() == holder.getAbsoluteAdapterPosition()));
            loginItemChoosePortraitBinding.executePendingBindings();
        }
    }
}
