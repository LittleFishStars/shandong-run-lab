package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.comment.detail.CommentDetailVM;
import com.huachenjie.mall.page.comment.list.CommodityCommentAdapter;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityCommodityCommentDetailBindingImpl extends MallActivityCommodityCommentDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10176a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f10174a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f34782a = null;
    }

    public MallActivityCommodityCommentDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10174a, f34782a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f10175a;
            this.f10175a = 0L;
        }
        CommentDetailVM commentDetailVM = ((MallActivityCommodityCommentDetailBinding) this).f10173a;
        CommodityCommentAdapter value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = commentDetailVM != null ? commentDetailVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<CommodityCommentAdapter> mutableLiveDataJ = commentDetailVM != null ? commentDetailVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityCommodityCommentDetailBinding) this).f34781a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((MallActivityCommodityCommentDetailBinding) this).f10172a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityCommodityCommentDetailBinding) this).f10172a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10175a != 0) {
                return true;
            }
            return ((MallActivityCommodityCommentDetailBinding) this).f10172a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10175a = 16L;
        }
        ((MallActivityCommodityCommentDetailBinding) this).f10172a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCommodityCommentDetailBinding
    public void k(@Nullable CommentDetailVM commentDetailVM) {
        ((MallActivityCommodityCommentDetailBinding) this).f10173a = commentDetailVM;
        synchronized (this) {
            this.f10175a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10175a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<CommodityCommentAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10175a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10175a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityCommodityCommentDetailBinding) this).f10172a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((CommentDetailVM) obj);
        return true;
    }

    public MallActivityCommodityCommentDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[1], (LayoutToolbarBindingBinding) objArr[2]);
        this.f10175a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10176a = linearLayout;
        linearLayout.setTag(null);
        ((MallActivityCommodityCommentDetailBinding) this).f34781a.setTag(null);
        setContainedBinding(((MallActivityCommodityCommentDetailBinding) this).f10172a);
        setRootTag(view);
        invalidateAll();
    }
}
