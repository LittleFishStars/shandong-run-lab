package com.huachenjie.mall.page.address;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallItemShippingAddressBinding;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/huachenjie/mall/page/address/ShippingAddressAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemShippingAddressBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "address", "k", "j", "Landroid/view/View;", "view", "i", t.d, y6b.g, "", "K", "I", "topMargin", "L", "horizontalMargin", "M", "bottomMargin", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShippingAddressAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressAdapter.kt\ncom/huachenjie/mall/page/address/ShippingAddressAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1#2:137\n350#3,7:138\n350#3,7:145\n350#3,7:152\n350#3,7:159\n350#3,7:166\n350#3,7:173\n*S KotlinDebug\n*F\n+ 1 ShippingAddressAdapter.kt\ncom/huachenjie/mall/page/address/ShippingAddressAdapter\n*L\n72#1:138,7\n80#1:145,7\n85#1:152,7\n97#1:159,7\n104#1:166,7\n109#1:173,7\n*E\n"})
public final class ShippingAddressAdapter extends BaseQuickAdapter<ShippingAddressBean, BaseDataBindingHolder<MallItemShippingAddressBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int topMargin;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int horizontalMargin;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final int bottomMargin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public ShippingAddressAdapter() {
        super(R.layout.mall_item_shipping_address, null, 2, null);
        this.topMargin = jj8.a(20.0f);
        this.horizontalMargin = jj8.a(16.0f);
        this.bottomMargin = jj8.a(12.0f);
    }

    public final void h() {
        removeEmptyView();
    }

    public final void i(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void j(@NotNull ShippingAddressBean address) {
        Object next;
        Intrinsics.checkNotNullParameter(address, "address");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((ShippingAddressBean) next).getDefaultFlag());
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
                getData().get(i).setDefaultFlag(true);
                notifyItemChanged(i);
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
            getData().get(i3).setDefaultFlag(false);
            notifyItemChanged(i3);
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
            getData().get(i).setDefaultFlag(true);
            notifyItemChanged(i);
        }
    }

    public final void k(@NotNull ShippingAddressBean address) {
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
                notifyItemChanged(i);
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
            notifyItemChanged(i3);
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
            notifyItemChanged(i);
        }
    }

    public final void l() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.mall.page.address.ShippingAddressAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (ShippingAddressAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        if (childAdapterPosition != 0) {
                            outRect.set(ShippingAddressAdapter.this.horizontalMargin, 0, ShippingAddressAdapter.this.horizontalMargin, ShippingAddressAdapter.this.bottomMargin);
                        } else {
                            outRect.set(ShippingAddressAdapter.this.horizontalMargin, ShippingAddressAdapter.this.topMargin, ShippingAddressAdapter.this.horizontalMargin, ShippingAddressAdapter.this.bottomMargin);
                        }
                        break;
                }
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemShippingAddressBinding> holder, @NotNull ShippingAddressBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemShippingAddressBinding mallItemShippingAddressBinding = (MallItemShippingAddressBinding) holder.getDataBinding();
        if (mallItemShippingAddressBinding != null) {
            mallItemShippingAddressBinding.k(item);
            mallItemShippingAddressBinding.executePendingBindings();
        }
    }
}
