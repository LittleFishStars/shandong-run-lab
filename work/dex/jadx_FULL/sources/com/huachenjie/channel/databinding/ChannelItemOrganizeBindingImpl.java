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
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemOrganizeBindingImpl extends ChannelItemOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8138a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8140a;

    @NonNull
    public final TextView f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33301a = sparseIntArray;
        sparseIntArray.put(R.id.ll_member, 7);
        sparseIntArray.put(R.id.tv_edit, 8);
        sparseIntArray.put(R.id.v_line_1, 9);
        sparseIntArray.put(R.id.tv_appoint, 10);
    }

    public ChannelItemOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f8138a, f33301a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    /* JADX WARN: Code duplicated, block: B:20:0x0063  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        RequestOptions requestOptions;
        String teamGroup;
        String userCount;
        String clubDescription;
        long j2;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.f8139a;
            this.f8139a = 0L;
        }
        OrganizeBean organizeBean = ((ChannelItemOrganizeBinding) this).f8135a;
        Boolean bool = ((ChannelItemOrganizeBinding) this).f8136a;
        long j3 = 5 & j;
        String coverUrl = null;
        if (j3 != 0) {
            requestOptions = ju3.p;
            if (organizeBean != null) {
                String clubName = organizeBean.getClubName();
                teamGroup = organizeBean.formatTeamGroup();
                userCount = organizeBean.formatUserCount();
                clubDescription = organizeBean.getClubDescription();
                coverUrl = organizeBean.getCoverUrl();
                str = clubName;
            } else {
                str = null;
                teamGroup = null;
            }
            j2 = j & 6;
            if (j2 != 0) {
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            } else {
                zSafeUnbox = false;
            }
            if (j3 != 0) {
                CommonBindingAdapter.b0(((ChannelItemOrganizeBinding) this).f8132a, coverUrl, requestOptions, false);
                TextViewBindingAdapter.setText(this.f, userCount);
                TextViewBindingAdapter.setText(((ChannelItemOrganizeBinding) this).f8137b, teamGroup);
                TextViewBindingAdapter.setText(this.c, clubDescription);
                TextViewBindingAdapter.setText(this.e, str);
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(((ChannelItemOrganizeBinding) this).f8137b, zSafeUnbox);
                CommonBindingAdapter.l0(((ChannelItemOrganizeBinding) this).b, zSafeUnbox);
            }
        }
        str = null;
        requestOptions = null;
        teamGroup = null;
        userCount = teamGroup;
        clubDescription = userCount;
        j2 = j & 6;
        if (j2 != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
        } else {
            zSafeUnbox = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((ChannelItemOrganizeBinding) this).f8132a, coverUrl, requestOptions, false);
            TextViewBindingAdapter.setText(this.f, userCount);
            TextViewBindingAdapter.setText(((ChannelItemOrganizeBinding) this).f8137b, teamGroup);
            TextViewBindingAdapter.setText(this.c, clubDescription);
            TextViewBindingAdapter.setText(this.e, str);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((ChannelItemOrganizeBinding) this).f8137b, zSafeUnbox);
            CommonBindingAdapter.l0(((ChannelItemOrganizeBinding) this).b, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8139a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8139a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemOrganizeBinding
    public void l(@Nullable OrganizeBean organizeBean) {
        ((ChannelItemOrganizeBinding) this).f8135a = organizeBean;
        synchronized (this) {
            this.f8139a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemOrganizeBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemOrganizeBinding) this).f8136a = bool;
        synchronized (this) {
            this.f8139a |= 2;
        }
        notifyPropertyChanged(tk0.y);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g == i) {
            l((OrganizeBean) obj);
        } else {
            if (tk0.y != i) {
                return false;
            }
            m((Boolean) obj);
        }
        return true;
    }

    public ChannelItemOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[7], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[8], (TextView) objArr[2], (View) objArr[9], (View) objArr[5]);
        this.f8139a = -1L;
        ((ChannelItemOrganizeBinding) this).f8132a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f8140a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f = textView;
        textView.setTag(null);
        ((ChannelItemOrganizeBinding) this).f8137b.setTag(null);
        this.c.setTag(null);
        this.e.setTag(null);
        ((ChannelItemOrganizeBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
