package com.huachenjie.mall.page.address.modify;

import android.text.TextUtils;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallItemShippingAddressModifyBinding;
import com.zj.adlib.y6b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemShippingAddressModifyBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "address", y6b.g, "Landroid/view/View;", "view", y6b.f, "i", "f", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShippingAddressModifyAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressModifyAdapter.kt\ncom/huachenjie/mall/page/address/modify/ShippingAddressModifyAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1#2:76\n350#3,7:77\n350#3,7:84\n350#3,7:91\n*S KotlinDebug\n*F\n+ 1 ShippingAddressModifyAdapter.kt\ncom/huachenjie/mall/page/address/modify/ShippingAddressModifyAdapter\n*L\n35#1:77,7\n43#1:84,7\n48#1:91,7\n*E\n"})
public final class ShippingAddressModifyAdapter extends BaseQuickAdapter<ShippingAddressBean, BaseDataBindingHolder<MallItemShippingAddressModifyBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public ShippingAddressModifyAdapter() {
        super(R.layout.mall_item_shipping_address_modify, null, 2, null);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void h(@NotNull ShippingAddressBean address) {
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((ShippingAddressBean) next).isSelected());
        ShippingAddressBean shippingAddressBean = (ShippingAddressBean) next;
        int i = -1;
        boolean z = false;
        if (shippingAddressBean == null) {
            Iterator<ShippingAddressBean> it2 = getData().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (TextUtils.equals(address.getAddressNo(), it2.next().getAddressNo())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0 && i < getData().size()) {
                z = true;
            }
            if (z) {
                getData().get(i).setSelected(true);
                notifyItemChanged(i + getHeaderLayoutCount());
                return;
            }
            return;
        }
        if (TextUtils.equals(address.getAddressNo(), shippingAddressBean.getAddressNo())) {
            return;
        }
        Iterator<ShippingAddressBean> it3 = getData().iterator();
        int i3 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (TextUtils.equals(shippingAddressBean.getAddressNo(), it3.next().getAddressNo())) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (i3 >= 0 && i3 < getData().size()) {
            getData().get(i3).setSelected(false);
            notifyItemChanged(i3 + getHeaderLayoutCount());
        }
        Iterator<ShippingAddressBean> it4 = getData().iterator();
        int i4 = 0;
        while (it4.hasNext()) {
            if (TextUtils.equals(address.getAddressNo(), it4.next().getAddressNo())) {
                i = i4;
                break;
            }
            i4++;
        }
        if (i >= 0 && i < getData().size()) {
            z = true;
        }
        if (z) {
            getData().get(i).setSelected(true);
            notifyItemChanged(i + getHeaderLayoutCount());
        }
    }

    public final void i() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemShippingAddressModifyBinding> holder, @NotNull ShippingAddressBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemShippingAddressModifyBinding mallItemShippingAddressModifyBinding = (MallItemShippingAddressModifyBinding) holder.getDataBinding();
        if (mallItemShippingAddressModifyBinding != null) {
            mallItemShippingAddressModifyBinding.k(item);
            mallItemShippingAddressModifyBinding.executePendingBindings();
        }
    }
}
