package com.huachenjie.channel.databinding;

import android.content.res.Resources;
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
import com.huachenjie.channel.adapter.AllMemberAdapter;
import com.huachenjie.channel.page.all_member.AllMemberActivity;
import com.huachenjie.channel.page.all_member.AllMemberModel;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityAllMemberBindingImpl extends ChannelActivityAllMemberBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7410a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f7407a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33033a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.state_layout, 4);
    }

    public ChannelActivityAllMemberBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7407a, f33033a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:48:0x009e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        AllMemberAdapter value;
        String string;
        BindingTitleBean bindingTitleBean;
        BindingTitleBean value2;
        Resources resources;
        int i;
        synchronized (this) {
            j = this.f7408a;
            this.f7408a = 0L;
        }
        AllMemberModel allMemberModel = ((ChannelActivityAllMemberBinding) this).f7404a;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = allMemberModel != null ? allMemberModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 26;
            if (j2 != 0) {
                MutableLiveData<Integer> type = allMemberModel != null ? allMemberModel.getType() : null;
                updateLiveDataRegistration(1, type);
                boolean z = ViewDataBinding.safeUnbox(type != null ? type.getValue() : null) == AllMemberActivity.K;
                if (j2 != 0) {
                    j |= z ? 64L : 32L;
                }
                if (z) {
                    resources = ((ChannelActivityAllMemberBinding) this).f7406a.getResources();
                    i = com.huachenjie.channel.R.string.channel_all_member_channel_search_hint;
                } else {
                    resources = ((ChannelActivityAllMemberBinding) this).f7406a.getResources();
                    i = com.huachenjie.channel.R.string.channel_all_member_topic_search_hint;
                }
                string = resources.getString(i);
            } else {
                string = null;
            }
            if ((j & 28) == 0) {
                bindingTitleBean = value2;
                value = null;
            } else {
                MutableLiveData<AllMemberAdapter> mutableLiveDataB = allMemberModel != null ? allMemberModel.B() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                    bindingTitleBean = value2;
                } else {
                    bindingTitleBean = value2;
                    value = null;
                }
            }
        } else {
            value = null;
            string = null;
            bindingTitleBean = null;
        }
        if ((25 & j) != 0) {
            this.f7410a.k(bindingTitleBean);
        }
        if ((j & 28) != 0) {
            CommonBindingAdapter.g(((ChannelActivityAllMemberBinding) this).f33032a, value, false, false);
        }
        if ((j & 26) != 0) {
            CommonBindingAdapter.r(((ChannelActivityAllMemberBinding) this).f7406a, string);
        }
        ViewDataBinding.executeBindingsOn(this.f7410a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7408a != 0) {
                return true;
            }
            return this.f7410a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7408a = 16L;
        }
        this.f7410a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAllMemberBinding
    public void k(@Nullable AllMemberModel allMemberModel) {
        ((ChannelActivityAllMemberBinding) this).f7404a = allMemberModel;
        synchronized (this) {
            this.f7408a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<AllMemberAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7408a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7408a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7408a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7410a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((AllMemberModel) obj);
        return true;
    }

    public ChannelActivityAllMemberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[2], (CommonSearchView) objArr[1], (StateLayout) objArr[4]);
        this.f7408a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f7410a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7409a = linearLayout;
        linearLayout.setTag(null);
        ((ChannelActivityAllMemberBinding) this).f33032a.setTag(null);
        ((ChannelActivityAllMemberBinding) this).f7406a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
