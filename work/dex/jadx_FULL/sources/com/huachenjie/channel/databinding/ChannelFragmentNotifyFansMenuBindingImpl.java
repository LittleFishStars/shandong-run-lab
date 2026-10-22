package com.huachenjie.channel.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.dialog.NotifyFansMenuDialog;
import com.huachenjie.channel.external.dialog.NotifyFansMenuModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.aw9;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentNotifyFansMenuBindingImpl extends ChannelFragmentNotifyFansMenuBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7869a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f7873a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotifyFansMenuDialog.a f33205a;

        public a a(NotifyFansMenuDialog.a aVar) {
            this.f33205a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33205a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotifyFansMenuDialog.a f33206a;

        public b a(NotifyFansMenuDialog.a aVar) {
            this.f33206a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33206a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33204a = sparseIntArray;
        sparseIntArray.put(R.id.v_bg, 6);
    }

    public ChannelFragmentNotifyFansMenuBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7869a, f33204a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        String string;
        String avatar;
        String avatarFrameImgUrl;
        String nickName;
        b bVarA;
        a aVarA;
        boolean zIsAttentionPage;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f7870a;
            this.f7870a = 0L;
        }
        NotifyFansMenuModel notifyFansMenuModel = ((ChannelFragmentNotifyFansMenuBinding) this).f7865a;
        NotifyFansMenuDialog.a aVar = ((ChannelFragmentNotifyFansMenuBinding) this).f7864a;
        long j4 = j & 11;
        if (j4 != 0) {
            MutableLiveData<FansBean> mutableLiveDataI = notifyFansMenuModel != null ? notifyFansMenuModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            FansBean value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
            if (value != null) {
                avatar = value.getAvatar();
                avatarFrameImgUrl = value.getAvatarFrameImgUrl();
                zIsAttentionPage = value.isAttentionPage();
                nickName = value.getNickName();
                str = value.formatterAlumniId();
            } else {
                zIsAttentionPage = false;
                str = null;
                avatar = null;
                avatarFrameImgUrl = null;
                nickName = null;
            }
            if (j4 != 0) {
                if (zIsAttentionPage) {
                    j2 = j | 32;
                    j3 = 128;
                } else {
                    j2 = j | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            drawable = AppCompatResources.getDrawable(((ChannelFragmentNotifyFansMenuBinding) this).f7868b.getContext(), zIsAttentionPage ? R.drawable.channel_ic_notify_fans_unfollow : R.drawable.channel_ic_notify_fans_report);
            string = ((ChannelFragmentNotifyFansMenuBinding) this).f7868b.getResources().getString(zIsAttentionPage ? R.string.channel_notify_menu_dialog_unfollow : R.string.channel_notify_menu_report);
        } else {
            str = null;
            drawable = null;
            string = null;
            avatar = null;
            avatarFrameImgUrl = null;
            nickName = null;
        }
        long j5 = j & 12;
        if (j5 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f7872a;
            if (bVar == null) {
                bVar = new b();
                this.f7872a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7871a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7871a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(((ChannelFragmentNotifyFansMenuBinding) this).f7866a, bVarA, null);
            CommonBindingAdapter.q(((ChannelFragmentNotifyFansMenuBinding) this).f7868b, aVarA, null);
        }
        if ((j & 11) != 0) {
            TextViewBindingAdapter.setDrawableStart(((ChannelFragmentNotifyFansMenuBinding) this).f7868b, drawable);
            TextViewBindingAdapter.setText(((ChannelFragmentNotifyFansMenuBinding) this).f7868b, string);
            aw9.d(((ChannelFragmentNotifyFansMenuBinding) this).f7863a, avatar, false, null);
            aw9.c(((ChannelFragmentNotifyFansMenuBinding) this).f7863a, avatarFrameImgUrl, null);
            TextViewBindingAdapter.setText(((ChannelFragmentNotifyFansMenuBinding) this).f33203a, str);
            TextViewBindingAdapter.setText(((ChannelFragmentNotifyFansMenuBinding) this).b, nickName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7870a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7870a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentNotifyFansMenuBinding
    public void l(@Nullable NotifyFansMenuDialog.a aVar) {
        ((ChannelFragmentNotifyFansMenuBinding) this).f7864a = aVar;
        synchronized (this) {
            this.f7870a |= 4;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentNotifyFansMenuBinding
    public void m(@Nullable NotifyFansMenuModel notifyFansMenuModel) {
        ((ChannelFragmentNotifyFansMenuBinding) this).f7865a = notifyFansMenuModel;
        synchronized (this) {
            this.f7870a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<FansBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7870a |= 1;
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
            m((NotifyFansMenuModel) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((NotifyFansMenuDialog.a) obj);
        }
        return true;
    }

    public ChannelFragmentNotifyFansMenuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (DrawableCenterButton) objArr[5], (DrawableCenterButton) objArr[4], (AvatarView) objArr[1], (TextView) objArr[3], (TextView) objArr[2], (BLView) objArr[6]);
        this.f7870a = -1L;
        ((ChannelFragmentNotifyFansMenuBinding) this).f7866a.setTag(null);
        ((ChannelFragmentNotifyFansMenuBinding) this).f7868b.setTag(null);
        ((ChannelFragmentNotifyFansMenuBinding) this).f7863a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f7873a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((ChannelFragmentNotifyFansMenuBinding) this).f33203a.setTag(null);
        ((ChannelFragmentNotifyFansMenuBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
