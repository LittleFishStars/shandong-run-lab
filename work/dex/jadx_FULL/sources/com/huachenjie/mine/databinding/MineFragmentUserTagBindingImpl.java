package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.dressing_table.tag.UserTagFragment;
import com.huachenjie.mine.page.dressing_table.tag.UserTagVM;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentUserTagBindingImpl extends MineFragmentUserTagBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35342a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11314a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11318a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserTagFragment.a f35343a;

        public a a(UserTagFragment.a aVar) {
            this.f35343a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35343a.a(view);
        }
    }

    public MineFragmentUserTagBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f11314a, f35342a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        SettingInterestTagsAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f11315a;
            this.f11315a = 0L;
        }
        UserTagVM userTagVM = ((MineFragmentUserTagBinding) this).f11313a;
        UserTagFragment.a aVar = ((MineFragmentUserTagBinding) this).f11312a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<SettingInterestTagsAdapter> mutableLiveDataI = userTagVM != null ? userTagVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11317a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11317a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11318a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((MineFragmentUserTagBinding) this).f35341a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11315a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11315a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentUserTagBinding
    public void l(@Nullable UserTagFragment.a aVar) {
        ((MineFragmentUserTagBinding) this).f11312a = aVar;
        synchronized (this) {
            this.f11315a |= 4;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentUserTagBinding
    public void m(@Nullable UserTagVM userTagVM) {
        ((MineFragmentUserTagBinding) this).f11313a = userTagVM;
        synchronized (this) {
            this.f11315a |= 2;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SettingInterestTagsAdapter> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11315a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((UserTagVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((UserTagFragment.a) obj);
        }
        return true;
    }

    public MineFragmentUserTagBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[1]);
        this.f11315a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11316a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f11318a = bLTextView;
        bLTextView.setTag(null);
        ((MineFragmentUserTagBinding) this).f35341a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
