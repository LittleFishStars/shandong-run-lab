package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberAdapter;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyMemberManagerVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityBuddyMemberManagerBindingImpl extends ChannelActivityBuddyMemberManagerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7440a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuddyMemberManagerActivity.a f33044a;

        public a a(BuddyMemberManagerActivity.a aVar) {
            this.f33044a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33044a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f7434a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f33043a = null;
    }

    public ChannelActivityBuddyMemberManagerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7434a, f33043a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String value;
        BindingTitleBean value2;
        BuddyMemberAdapter value3;
        a aVarA;
        synchronized (this) {
            j = this.f7435a;
            this.f7435a = 0L;
        }
        BuddyMemberManagerVM buddyMemberManagerVM = ((ChannelActivityBuddyMemberManagerBinding) this).f7433a;
        BuddyMemberManagerActivity.a aVar = ((ChannelActivityBuddyMemberManagerBinding) this).f7432a;
        if ((95 & j) != 0) {
            if ((j & 81) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = buddyMemberManagerVM != null ? buddyMemberManagerVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 82) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = buddyMemberManagerVM != null ? buddyMemberManagerVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BuddyMemberAdapter> mutableLiveDataM = buddyMemberManagerVM != null ? buddyMemberManagerVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value3 = mutableLiveDataM.getValue();
                } else {
                    value3 = null;
                }
            }
            long j2 = j & 88;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = buddyMemberManagerVM != null ? buddyMemberManagerVM.o() : null;
                updateLiveDataRegistration(3, mutableLiveDataO);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox ? 256L : 128L;
                }
                str = zSafeUnbox ? "解散搭子" : "退出搭子";
            } else {
                str = null;
            }
        } else {
            str = null;
            value = null;
            value2 = null;
            value3 = null;
        }
        long j3 = 96 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7438a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7438a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 82) != 0) {
            this.f7439a.k(value2);
        }
        if ((j & 81) != 0) {
            TextViewBindingAdapter.setText(this.f7437a, value);
        }
        if ((88 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7440a, str);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f7440a, aVarA, null);
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.g(((ChannelActivityBuddyMemberManagerBinding) this).f33042a, value3, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f7439a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7435a != 0) {
                return true;
            }
            return this.f7439a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7435a = 64L;
        }
        this.f7439a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityBuddyMemberManagerBinding
    public void l(@Nullable BuddyMemberManagerActivity.a aVar) {
        ((ChannelActivityBuddyMemberManagerBinding) this).f7432a = aVar;
        synchronized (this) {
            this.f7435a |= 32;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityBuddyMemberManagerBinding
    public void m(@Nullable BuddyMemberManagerVM buddyMemberManagerVM) {
        ((ChannelActivityBuddyMemberManagerBinding) this).f7433a = buddyMemberManagerVM;
        synchronized (this) {
            this.f7435a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7435a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7435a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BuddyMemberAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7435a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7435a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7439a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((BuddyMemberManagerVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((BuddyMemberManagerActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityBuddyMemberManagerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[2]);
        this.f7435a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f7439a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7436a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f7437a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f7440a = bLTextView;
        bLTextView.setTag(null);
        ((ChannelActivityBuddyMemberManagerBinding) this).f33042a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
