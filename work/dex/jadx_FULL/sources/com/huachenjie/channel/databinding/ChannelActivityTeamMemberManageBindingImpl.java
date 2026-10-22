package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageAdapter;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CommonSearchView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityTeamMemberManageBindingImpl extends ChannelActivityTeamMemberManageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7705a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TeamMemberManageActivity.a f33132a;

        public a a(TeamMemberManageActivity.a aVar) {
            this.f33132a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33132a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TeamMemberManageActivity.a f33133a;

        public b a(TeamMemberManageActivity.a aVar) {
            this.f33133a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33133a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f7696a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33131a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.search_view, 6);
    }

    public ChannelActivityTeamMemberManageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7696a, f33131a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        TeamMemberManageAdapter value;
        BindingTitleBean value2;
        Integer value3;
        Drawable drawable;
        a aVarA;
        long j2;
        b bVarA;
        synchronized (this) {
            j = this.f7697a;
            this.f7697a = 0L;
        }
        TeamMemberManageVM teamMemberManageVM = ((ChannelActivityTeamMemberManageBinding) this).f7694a;
        TeamMemberManageActivity.a aVar = ((ChannelActivityTeamMemberManageBinding) this).f33130a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = teamMemberManageVM != null ? teamMemberManageVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            long j3 = j & 42;
            if (j3 != 0) {
                MutableLiveData<Integer> mutableLiveDataR = teamMemberManageVM != null ? teamMemberManageVM.r() : null;
                updateLiveDataRegistration(1, mutableLiveDataR);
                value3 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                z = ViewDataBinding.safeUnbox(value3) == 0;
                if (j3 != 0) {
                    j = z ? j | 128 | 512 : j | 64 | 256;
                }
                drawable = AppCompatResources.getDrawable(this.f7700a.getContext(), z ? com.huachenjie.channel.R.drawable.channel_bg_topic_team_member_remove : com.huachenjie.channel.R.drawable.channel_bg_topic_team_member_remove_enable);
            } else {
                z = false;
                value3 = null;
                drawable = null;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<TeamMemberManageAdapter> mutableLiveDataN = teamMemberManageVM != null ? teamMemberManageVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value = mutableLiveDataN.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            z = false;
            value = null;
            value2 = null;
            value3 = null;
            drawable = null;
        }
        long j4 = 48 & j;
        if (j4 == 0 || aVar == null) {
            aVarA = null;
            j2 = 256;
            bVarA = null;
        } else {
            b bVar = this.f7703a;
            if (bVar == null) {
                bVar = new b();
                this.f7703a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7702a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7702a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            j2 = 256;
        }
        String str = (j2 & j) != 0 ? String.format("移出(%d)", value3) : null;
        long j5 = 42 & j;
        if (j5 == 0) {
            str = null;
        } else if (z) {
            str = "移出";
        }
        if ((41 & j) != 0) {
            this.f7704a.k(value2);
        }
        if (j5 != 0) {
            ViewBindingAdapter.setBackground(this.f7700a, drawable);
            TextViewBindingAdapter.setText(this.f7700a, str);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.f7700a, aVarA, null);
            CommonBindingAdapter.q(this.f7705a, bVarA, null);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(this.f7701a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f7704a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7697a != 0) {
                return true;
            }
            return this.f7704a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7697a = 32L;
        }
        this.f7704a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityTeamMemberManageBinding
    public void l(@Nullable TeamMemberManageActivity.a aVar) {
        ((ChannelActivityTeamMemberManageBinding) this).f33130a = aVar;
        synchronized (this) {
            this.f7697a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityTeamMemberManageBinding
    public void m(@Nullable TeamMemberManageVM teamMemberManageVM) {
        ((ChannelActivityTeamMemberManageBinding) this).f7694a = teamMemberManageVM;
        synchronized (this) {
            this.f7697a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<TeamMemberManageAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7697a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7697a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7697a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7704a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((TeamMemberManageVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((TeamMemberManageActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityTeamMemberManageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CommonSearchView) objArr[6]);
        this.f7697a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7699a = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.f7698a = frameLayout;
        frameLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f7704a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        TextView textView = (TextView) objArr[2];
        this.f7700a = textView;
        textView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f7701a = recyclerView;
        recyclerView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f7705a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
