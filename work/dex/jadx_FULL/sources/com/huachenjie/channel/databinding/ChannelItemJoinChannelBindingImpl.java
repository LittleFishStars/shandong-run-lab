package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.external.bean.ChannelBean;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelItemJoinChannelBindingImpl extends ChannelItemJoinChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8005a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8008a;

    @NonNull
    public final TextView c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33255a = sparseIntArray;
        sparseIntArray.put(R.id.view_bg, 6);
        sparseIntArray.put(R.id.bt_join, 7);
        sparseIntArray.put(R.id.v_line, 8);
    }

    public ChannelItemJoinChannelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f8005a, f33255a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsEmpty;
        String avatar;
        String str;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        String coverImgUrl;
        String formatterPopularity;
        String formatterFollowedCount;
        String channelName;
        synchronized (this) {
            j = this.f8006a;
            this.f8006a = 0L;
        }
        ChannelBean channelBean = ((ChannelItemJoinChannelBinding) this).f8002a;
        long j2 = j & 3;
        Object drawable = null;
        if (j2 != 0) {
            requestOptions = ju3.b;
            requestOptions2 = ju3.n;
            if (channelBean != null) {
                coverImgUrl = channelBean.getCoverImgUrl();
                formatterPopularity = channelBean.getFormatterPopularity();
                formatterFollowedCount = channelBean.getFormatterFollowedCount();
                channelName = channelBean.getChannelName();
                avatar = channelBean.getAvatar();
            } else {
                avatar = null;
                coverImgUrl = null;
                formatterPopularity = null;
                formatterFollowedCount = null;
                channelName = null;
            }
            zIsEmpty = TextUtils.isEmpty(coverImgUrl);
            if (j2 != 0) {
                j |= zIsEmpty ? 8L : 4L;
            }
            str = channelName;
        } else {
            zIsEmpty = false;
            avatar = null;
            str = null;
            requestOptions = null;
            requestOptions2 = null;
            coverImgUrl = null;
            formatterPopularity = null;
            formatterFollowedCount = null;
        }
        long j3 = j & 3;
        if (j3 != 0) {
            drawable = zIsEmpty ? AppCompatResources.getDrawable(this.f8008a.getContext(), R.drawable.base_bg_channel_main_head) : coverImgUrl;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((ChannelItemJoinChannelBinding) this).f8000a, avatar, requestOptions, false);
            CommonBindingAdapter.b0(this.f8008a, drawable, requestOptions2, false);
            TextViewBindingAdapter.setText(this.c, formatterFollowedCount);
            TextViewBindingAdapter.setText(((ChannelItemJoinChannelBinding) this).f8001a, formatterPopularity);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8006a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8006a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelItemJoinChannelBinding
    public void k(@Nullable ChannelBean channelBean) {
        ((ChannelItemJoinChannelBinding) this).f8002a = channelBean;
        synchronized (this) {
            this.f8006a |= 1;
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
        k((ChannelBean) obj);
        return true;
    }

    public ChannelItemJoinChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[7], (ImageView) objArr[2], (TextView) objArr[4], (TextView) objArr[3], (View) objArr[8], (BLView) objArr[6]);
        this.f8006a = -1L;
        ((ChannelItemJoinChannelBinding) this).f8000a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8007a = constraintLayout;
        constraintLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f8008a = bLImageView;
        bLImageView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.c = textView;
        textView.setTag(null);
        ((ChannelItemJoinChannelBinding) this).f8001a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
