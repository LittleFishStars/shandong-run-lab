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
public class ChannelItemMyOrganizeBindingImpl extends ChannelItemMyOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8098a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f8100a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33291a = sparseIntArray;
        sparseIntArray.put(R.id.ll_member, 8);
    }

    public ChannelItemMyOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f8098a, f33291a));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String userCount;
        String str;
        String clubDescription;
        String messageCount;
        synchronized (this) {
            j = this.f8099a;
            this.f8099a = 0L;
        }
        Boolean bool = ((ChannelItemMyOrganizeBinding) this).f8096a;
        OrganizeBean organizeBean = ((ChannelItemMyOrganizeBinding) this).f8095a;
        long j2 = 5 & j;
        boolean zSafeUnbox = j2 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        long j3 = j & 6;
        String str2 = null;
        if (j3 != 0) {
            requestOptions = ju3.p;
            if (organizeBean != null) {
                String clubName = organizeBean.getClubName();
                userCount = organizeBean.formatUserCount();
                clubDescription = organizeBean.getClubDescription();
                messageCount = organizeBean.formatMessageCount();
                String coverUrl = organizeBean.getCoverUrl();
                str = clubName;
                str2 = coverUrl;
            } else {
                userCount = null;
            }
            if (j3 != 0) {
                CommonBindingAdapter.b0(((ChannelItemMyOrganizeBinding) this).f33290a, str2, requestOptions, false);
                TextViewBindingAdapter.setText(this.c, userCount);
                TextViewBindingAdapter.setText(this.d, messageCount);
                TextViewBindingAdapter.setText(((ChannelItemMyOrganizeBinding) this).f8094a, clubDescription);
                TextViewBindingAdapter.setText(((ChannelItemMyOrganizeBinding) this).f8097b, str);
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(((ChannelItemMyOrganizeBinding) this).b, zSafeUnbox);
                CommonBindingAdapter.l0(this.b, zSafeUnbox);
            }
        }
        requestOptions = null;
        userCount = null;
        str = userCount;
        clubDescription = str;
        messageCount = clubDescription;
        if (j3 != 0) {
            CommonBindingAdapter.b0(((ChannelItemMyOrganizeBinding) this).f33290a, str2, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, userCount);
            TextViewBindingAdapter.setText(this.d, messageCount);
            TextViewBindingAdapter.setText(((ChannelItemMyOrganizeBinding) this).f8094a, clubDescription);
            TextViewBindingAdapter.setText(((ChannelItemMyOrganizeBinding) this).f8097b, str);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((ChannelItemMyOrganizeBinding) this).b, zSafeUnbox);
            CommonBindingAdapter.l0(this.b, zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8099a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8099a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyOrganizeBinding
    public void l(@Nullable OrganizeBean organizeBean) {
        ((ChannelItemMyOrganizeBinding) this).f8095a = organizeBean;
        synchronized (this) {
            this.f8099a |= 2;
        }
        notifyPropertyChanged(tk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemMyOrganizeBinding
    public void m(@Nullable Boolean bool) {
        ((ChannelItemMyOrganizeBinding) this).f8096a = bool;
        synchronized (this) {
            this.f8099a |= 1;
        }
        notifyPropertyChanged(tk0.D);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.D == i) {
            m((Boolean) obj);
        } else {
            if (tk0.g != i) {
                return false;
            }
            l((OrganizeBean) obj);
        }
        return true;
    }

    public ChannelItemMyOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (LinearLayout) objArr[8], (LinearLayout) objArr[6], (TextView) objArr[3], (TextView) objArr[2]);
        this.f8099a = -1L;
        ((ChannelItemMyOrganizeBinding) this).f33290a.setTag(null);
        ((ChannelItemMyOrganizeBinding) this).b.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f8100a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.c = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.d = textView2;
        textView2.setTag(null);
        ((ChannelItemMyOrganizeBinding) this).f8094a.setTag(null);
        ((ChannelItemMyOrganizeBinding) this).f8097b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
