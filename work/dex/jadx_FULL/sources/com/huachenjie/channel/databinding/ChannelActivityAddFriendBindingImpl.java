package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.adapter.AddFriendAdapter;
import com.huachenjie.channel.page.add_friend.AddFriendActivity;
import com.huachenjie.channel.page.add_friend.AddFriendVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityAddFriendBindingImpl extends ChannelActivityAddFriendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7374a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddFriendActivity.a f33019a;

        public a a(AddFriendActivity.a aVar) {
            this.f33019a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33019a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddFriendActivity.a f33020a;

        public b a(AddFriendActivity.a aVar) {
            this.f33020a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33020a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AddFriendActivity.a f33021a;

        public c a(AddFriendActivity.a aVar) {
            this.f33021a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33021a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f7367a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33018a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.ivSearch, 6);
        sparseIntArray.put(com.huachenjie.channel.R.id.ivScan, 7);
        sparseIntArray.put(com.huachenjie.channel.R.id.state_layout, 8);
    }

    public ChannelActivityAddFriendBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7367a, f33018a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        AddFriendAdapter value;
        BindingTitleBean value2;
        b bVarA;
        a aVarA;
        c cVarA;
        synchronized (this) {
            j = this.f7368a;
            this.f7368a = 0L;
        }
        AddFriendVM addFriendVM = ((ChannelActivityAddFriendBinding) this).f7363a;
        AddFriendActivity.a aVar = ((ChannelActivityAddFriendBinding) this).f7362a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = addFriendVM != null ? addFriendVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<AddFriendAdapter> mutableLiveDataB = addFriendVM != null ? addFriendVM.B() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f7373a;
            if (cVar == null) {
                cVar = new c();
                this.f7373a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f7371a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7371a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f7372a;
            if (bVar == null) {
                bVar = new b();
                this.f7372a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 21) != 0) {
            this.f7374a.k(value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7370a, bVarA, null);
            CommonBindingAdapter.q(((ChannelActivityAddFriendBinding) this).f7365a, aVarA, null);
            CommonBindingAdapter.q(((ChannelActivityAddFriendBinding) this).f7366b, cVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(((ChannelActivityAddFriendBinding) this).f7361a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f7374a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7368a != 0) {
                return true;
            }
            return this.f7374a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7368a = 16L;
        }
        this.f7374a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAddFriendBinding
    public void l(@Nullable AddFriendActivity.a aVar) {
        ((ChannelActivityAddFriendBinding) this).f7362a = aVar;
        synchronized (this) {
            this.f7368a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityAddFriendBinding
    public void m(@Nullable AddFriendVM addFriendVM) {
        ((ChannelActivityAddFriendBinding) this).f7363a = addFriendVM;
        synchronized (this) {
            this.f7368a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<AddFriendAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7368a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7368a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7374a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((AddFriendVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((AddFriendActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityAddFriendBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[7], (ImageView) objArr[6], (RecyclerView) objArr[4], (ShadowConstraintLayout) objArr[2], (ShadowConstraintLayout) objArr[1], (StateLayout) objArr[8]);
        this.f7368a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f7374a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7369a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f7370a = textView;
        textView.setTag(null);
        ((ChannelActivityAddFriendBinding) this).f7361a.setTag(null);
        ((ChannelActivityAddFriendBinding) this).f7365a.setTag(null);
        ((ChannelActivityAddFriendBinding) this).f7366b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
