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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemOrganizeTeamBindingImpl extends ChannelItemOrganizeTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8162a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8164a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33309a = sparseIntArray;
        sparseIntArray.put(R.id.iv_icon, 2);
    }

    public ChannelItemOrganizeTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f8162a, f33309a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8163a;
            this.f8163a = 0L;
        }
        OrganizeTeamBean organizeTeamBean = ((ChannelItemOrganizeTeamBinding) this).f8161a;
        long j2 = j & 3;
        String teamTitle = (j2 == 0 || organizeTeamBean == null) ? null : organizeTeamBean.getTeamTitle();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ChannelItemOrganizeTeamBinding) this).f8160a, teamTitle);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8163a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8163a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemOrganizeTeamBinding
    public void k(@Nullable OrganizeTeamBean organizeTeamBean) {
        ((ChannelItemOrganizeTeamBinding) this).f8161a = organizeTeamBean;
        synchronized (this) {
            this.f8163a |= 1;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.g != i) {
            return false;
        }
        k((OrganizeTeamBean) obj);
        return true;
    }

    public ChannelItemOrganizeTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[1]);
        this.f8163a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8164a = linearLayout;
        linearLayout.setTag(null);
        ((ChannelItemOrganizeTeamBinding) this).f8160a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
