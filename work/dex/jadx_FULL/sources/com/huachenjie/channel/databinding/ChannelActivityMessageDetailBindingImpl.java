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
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.channel.page.message_detail.MessageDetailVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CommonBanner;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.tk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityMessageDetailBindingImpl extends ChannelActivityMessageDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f7584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7585a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f7581a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        f33091a = null;
    }

    public ChannelActivityMessageDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7581a, f33091a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        BindingTitleBean bindingTitleBean;
        boolean z;
        BindingTitleBean value;
        String avatar;
        String applyTimeStr;
        String messageTitle;
        String nickName;
        synchronized (this) {
            j = this.f7582a;
            this.f7582a = 0L;
        }
        MessageDetailVM messageDetailVM = ((ChannelActivityMessageDetailBinding) this).f7579a;
        long j2 = 14 & j;
        String str6 = null;
        List<ImageBean> list = null;
        str6 = null;
        RequestOptions requestOptions = j2 != 0 ? ju3.b : null;
        if ((15 & j) != 0) {
            if ((j & 13) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = messageDetailVM != null ? messageDetailVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if (j2 != 0) {
                MutableLiveData<ClubMessageBean> mutableLiveDataK = messageDetailVM != null ? messageDetailVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                ClubMessageBean value2 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if (value2 != null) {
                    String clubName = value2.getClubName();
                    String messageContent = value2.getMessageContent();
                    List<ImageBean> imgList = value2.getImgList();
                    applyTimeStr = value2.getApplyTimeStr();
                    messageTitle = value2.getMessageTitle();
                    nickName = value2.getNickName();
                    avatar = value2.getAvatar();
                    str4 = clubName;
                    list = imgList;
                    str5 = messageContent;
                } else {
                    avatar = null;
                    str4 = null;
                    str5 = null;
                    applyTimeStr = null;
                    messageTitle = null;
                    nickName = null;
                }
                boolean z2 = (list != null ? list.size() : 0) > 0;
                str6 = avatar;
                bindingTitleBean = value;
                z = z2;
                str = applyTimeStr;
                str3 = messageTitle;
                str2 = nickName;
            } else {
                str = null;
                str3 = null;
                str4 = null;
                str5 = null;
                bindingTitleBean = value;
                z = false;
                str2 = null;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            bindingTitleBean = null;
            z = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((ChannelActivityMessageDetailBinding) this).f7580a, z);
            CommonBindingAdapter.b0(((ChannelActivityMessageDetailBinding) this).f33090a, str6, requestOptions, false);
            TextViewBindingAdapter.setText(this.f7585a, str4);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(this.d, str5);
            TextViewBindingAdapter.setText(((ChannelActivityMessageDetailBinding) this).f7578a, str2);
            TextViewBindingAdapter.setText(this.b, str3);
        }
        if ((j & 13) != 0) {
            this.f7584a.k(bindingTitleBean);
        }
        ViewDataBinding.executeBindingsOn(this.f7584a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7582a != 0) {
                return true;
            }
            return this.f7584a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7582a = 8L;
        }
        this.f7584a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityMessageDetailBinding
    public void k(@Nullable MessageDetailVM messageDetailVM) {
        ((ChannelActivityMessageDetailBinding) this).f7579a = messageDetailVM;
        synchronized (this) {
            this.f7582a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ClubMessageBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7582a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7582a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7584a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((MessageDetailVM) obj);
        return true;
    }

    public ChannelActivityMessageDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CommonBanner) objArr[1], (ImageView) objArr[3], (TextView) objArr[4], (TextView) objArr[6]);
        this.f7582a = -1L;
        ((ChannelActivityMessageDetailBinding) this).f7580a.setTag(null);
        ((ChannelActivityMessageDetailBinding) this).f33090a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[8];
        this.f7584a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7583a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f7585a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.d = textView2;
        textView2.setTag(null);
        ((ChannelActivityMessageDetailBinding) this).f7578a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
