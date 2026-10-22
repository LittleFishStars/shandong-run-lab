package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelViewOrganizeDetailHeaderBindingImpl extends ChannelViewOrganizeDetailHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8247a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8250a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33343a = sparseIntArray;
        sparseIntArray.put(R.id.v_empty, 5);
        sparseIntArray.put(R.id.tv_message_title, 6);
    }

    public ChannelViewOrganizeDetailHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f8247a, f33343a));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        int iSafeUnbox;
        String coverUrl;
        String clubName;
        String clubDescription;
        synchronized (this) {
            j = this.f8248a;
            this.f8248a = 0L;
        }
        OrganizeDetailVM organizeDetailVM = ((ChannelViewOrganizeDetailHeaderBinding) this).f8246a;
        long j2 = 25 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.h : null;
        if ((31 & j) != 0) {
            if ((j & 28) != 0) {
                BaseViewModel.b bVarE = organizeDetailVM != null ? organizeDetailVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 75));
            } else {
                iSafeUnbox = 0;
            }
            if (j2 == 0) {
                coverUrl = null;
                clubName = null;
                clubDescription = null;
            } else {
                MutableLiveData<OrganizeBean> mutableLiveDataM = organizeDetailVM != null ? organizeDetailVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                OrganizeBean value = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                if (value != null) {
                    clubName = value.getClubName();
                    clubDescription = value.getClubDescription();
                    coverUrl = value.getCoverUrl();
                } else {
                    coverUrl = null;
                    clubName = null;
                    clubDescription = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<Integer> mutableLiveDataN = organizeDetailVM != null ? organizeDetailVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                str4 = String.format("%s条内容", mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                i = iSafeUnbox;
                str2 = coverUrl;
                str3 = clubName;
                str = clubDescription;
            } else {
                i = iSafeUnbox;
                str2 = coverUrl;
                str3 = clubName;
                str = clubDescription;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((ChannelViewOrganizeDetailHeaderBinding) this).f8243a, str2, requestOptions, false);
                aw9.f(((ChannelViewOrganizeDetailHeaderBinding) this).f8245a, str);
                TextViewBindingAdapter.setText(this.b, str3);
            }
            if ((j & 26) != 0) {
                TextViewBindingAdapter.setText(this.f8250a, str4);
            }
            if ((j & 28) != 0) {
                CommonBindingAdapter.I(this.b, 0, i, 0, 0, null);
            }
        }
        i = 0;
        str = null;
        str2 = null;
        str3 = null;
        str4 = null;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((ChannelViewOrganizeDetailHeaderBinding) this).f8243a, str2, requestOptions, false);
            aw9.f(((ChannelViewOrganizeDetailHeaderBinding) this).f8245a, str);
            TextViewBindingAdapter.setText(this.b, str3);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.f8250a, str4);
        }
        if ((j & 28) != 0) {
            CommonBindingAdapter.I(this.b, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8248a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8248a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewOrganizeDetailHeaderBinding
    public void k(@Nullable OrganizeDetailVM organizeDetailVM) {
        ((ChannelViewOrganizeDetailHeaderBinding) this).f8246a = organizeDetailVM;
        synchronized (this) {
            this.f8248a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<OrganizeBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8248a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8248a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f8248a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((OrganizeDetailVM) obj);
        return true;
    }

    public ChannelViewOrganizeDetailHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[1], (ExpandableTextView) objArr[3], (TextView) objArr[6], (TextView) objArr[2], (View) objArr[5]);
        this.f8248a = -1L;
        ((ChannelViewOrganizeDetailHeaderBinding) this).f8243a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8249a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f8250a = bLTextView;
        bLTextView.setTag(null);
        ((ChannelViewOrganizeDetailHeaderBinding) this).f8245a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
