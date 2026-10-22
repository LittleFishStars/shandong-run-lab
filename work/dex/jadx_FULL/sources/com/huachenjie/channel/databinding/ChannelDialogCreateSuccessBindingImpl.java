package com.huachenjie.channel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.page.my_channel.CreateSuccessDialog;
import com.huachenjie.channel.page.my_channel.CreateSuccessVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogCreateSuccessBindingImpl extends ChannelDialogCreateSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7735a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f7737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7738a;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateSuccessDialog.a f33147a;

        public a a(CreateSuccessDialog.a aVar) {
            this.f33147a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33147a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33146a = sparseIntArray;
        sparseIntArray.put(R.id.rl_box, 5);
        sparseIntArray.put(R.id.rl_top, 6);
        sparseIntArray.put(R.id.tv_title, 7);
        sparseIntArray.put(R.id.tv_info, 8);
        sparseIntArray.put(R.id.tv_host, 9);
    }

    public ChannelDialogCreateSuccessBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f7735a, f33146a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String avatar;
        String avatarFrameImgUrl;
        String nickName;
        String firstAcquireTip;
        a aVarA;
        synchronized (this) {
            j = this.f7736a;
            this.f7736a = 0L;
        }
        CreateSuccessVM createSuccessVM = ((ChannelDialogCreateSuccessBinding) this).f7730a;
        CreateSuccessDialog.a aVar = ((ChannelDialogCreateSuccessBinding) this).f7729a;
        long j2 = 11 & j;
        if (j2 != 0) {
            MutableLiveData<MyChannelDetail> mutableLiveDataI = createSuccessVM != null ? createSuccessVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            MyChannelDetail value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
            if (value != null) {
                avatarFrameImgUrl = value.getAvatarFrameImgUrl();
                nickName = value.getNickName();
                firstAcquireTip = value.getFirstAcquireTip();
                avatar = value.getAvatar();
            } else {
                avatar = null;
                avatarFrameImgUrl = null;
                nickName = null;
                firstAcquireTip = null;
            }
            z = !TextUtils.isEmpty(firstAcquireTip);
        } else {
            z = false;
            avatar = null;
            avatarFrameImgUrl = null;
            nickName = null;
            firstAcquireTip = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7738a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7738a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            aw9.d(((ChannelDialogCreateSuccessBinding) this).f7728a, avatar, false, null);
            aw9.c(((ChannelDialogCreateSuccessBinding) this).f7728a, avatarFrameImgUrl, null);
            CommonBindingAdapter.l0(this.d, z);
            TextViewBindingAdapter.setText(this.d, firstAcquireTip);
            TextViewBindingAdapter.setText(((ChannelDialogCreateSuccessBinding) this).b, nickName);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelDialogCreateSuccessBinding) this).f7732a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7736a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7736a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogCreateSuccessBinding
    public void l(@Nullable CreateSuccessDialog.a aVar) {
        ((ChannelDialogCreateSuccessBinding) this).f7729a = aVar;
        synchronized (this) {
            this.f7736a |= 4;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogCreateSuccessBinding
    public void m(@Nullable CreateSuccessVM createSuccessVM) {
        ((ChannelDialogCreateSuccessBinding) this).f7730a = createSuccessVM;
        synchronized (this) {
            this.f7736a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<MyChannelDetail> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7736a |= 1;
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
        if (tk0.p0 == i) {
            m((CreateSuccessVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((CreateSuccessDialog.a) obj);
        }
        return true;
    }

    public ChannelDialogCreateSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (AvatarView) objArr[1], (BLRelativeLayout) objArr[5], (BLRelativeLayout) objArr[6], (BLTextView) objArr[4], (BLTextView) objArr[9], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[7]);
        this.f7736a = -1L;
        ((ChannelDialogCreateSuccessBinding) this).f7728a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f7737a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.d = textView;
        textView.setTag(null);
        ((ChannelDialogCreateSuccessBinding) this).f7732a.setTag(null);
        ((ChannelDialogCreateSuccessBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
