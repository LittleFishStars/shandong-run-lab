package com.huachenjie.mall.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityEpisodesDetailBindingImpl extends MallActivityEpisodesDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10209a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10210b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EpisodesDetailActivity.a f34791a;

        public a a(EpisodesDetailActivity.a aVar) {
            this.f34791a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34791a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EpisodesDetailActivity.a f34792a;

        public b a(EpisodesDetailActivity.a aVar) {
            this.f34792a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34792a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        f10201a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34790a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.video_view, 9);
        sparseIntArray.put(com.huachenjie.mall.R.id.tab_layout, 10);
        sparseIntArray.put(com.huachenjie.mall.R.id.view_pager, 11);
    }

    public MallActivityEpisodesDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f10201a, f34790a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b8  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        boolean z;
        boolean z2;
        BindingTitleBean value;
        String str;
        Drawable drawable;
        String episodeName;
        String str2;
        a aVarA;
        b bVarA;
        long j2;
        String episodeDesc;
        Context context;
        int i;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f10202a;
            this.f10202a = 0L;
        }
        EpisodesDetailVM episodesDetailVM = ((MallActivityEpisodesDetailBinding) this).f10200a;
        EpisodesDetailActivity.a aVar = ((MallActivityEpisodesDetailBinding) this).f10199a;
        if ((190 & j) != 0) {
            if ((j & 162) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = episodesDetailVM != null ? episodesDetailVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            long j5 = j & 164;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = episodesDetailVM != null ? episodesDetailVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox) {
                        j3 = j | 512;
                        j4 = 8192;
                    } else {
                        j3 = j | 256;
                        j4 = 4096;
                    }
                    j = j3 | j4;
                }
                str = zSafeUnbox ? "继续播放" : "试看结束";
                if (zSafeUnbox) {
                    context = this.b.getContext();
                    i = com.huachenjie.mall.R.drawable.mall_ic_video_play_continue;
                } else {
                    context = this.b.getContext();
                    i = com.huachenjie.mall.R.drawable.ic_video_view_replay;
                }
                drawable = AppCompatResources.getDrawable(context, i);
            } else {
                str = null;
                drawable = null;
            }
            if ((j & 168) == 0) {
                episodeName = null;
                j2 = 176;
                episodeDesc = null;
            } else {
                MutableLiveData<EpisodeDetailBean> mutableLiveDataK = episodesDetailVM != null ? episodesDetailVM.k() : null;
                updateLiveDataRegistration(3, mutableLiveDataK);
                EpisodeDetailBean value2 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if (value2 != null) {
                    episodeDesc = value2.getEpisodeDesc();
                    episodeName = value2.getEpisodeName();
                    j2 = 176;
                } else {
                    episodeName = null;
                    j2 = 176;
                    episodeDesc = null;
                }
            }
            long j6 = j & j2;
            if (j6 != 0) {
                MutableLiveData<Integer> mutableLiveDataO = episodesDetailVM != null ? episodesDetailVM.o() : null;
                updateLiveDataRegistration(4, mutableLiveDataO);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                z = iSafeUnbox == 1;
                z2 = iSafeUnbox == 0;
                if (j6 != 0) {
                    j = z ? j | 2048 : j | 1024;
                }
            } else {
                iSafeUnbox = 0;
                z = false;
                z2 = false;
            }
            str2 = episodeDesc;
        } else {
            iSafeUnbox = 0;
            z = false;
            z2 = false;
            value = null;
            str = null;
            drawable = null;
            episodeName = null;
            str2 = null;
        }
        long j7 = j & 192;
        if (j7 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10208a;
            if (bVar == null) {
                bVar = new b();
                this.f10208a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10207a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10207a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        boolean z3 = (j & 1024) != 0 && iSafeUnbox == 3;
        long j8 = j & 176;
        if (j8 == 0) {
            z3 = false;
        } else if (z) {
            z3 = true;
        }
        if (j8 != 0) {
            CommonBindingAdapter.l0(this.f10204a, z2);
            CommonBindingAdapter.l0(this.f10203a, z3);
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.f10203a, aVarA, null);
            CommonBindingAdapter.q(this.f10209a, bVarA, null);
        }
        if ((164 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            TextViewBindingAdapter.setText(this.f10206a, str);
        }
        if ((168 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10210b, episodeName);
            TextViewBindingAdapter.setText(this.c, str2);
        }
        if ((j & 162) != 0) {
            ((MallActivityEpisodesDetailBinding) this).f10197a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityEpisodesDetailBinding) this).f10197a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10202a != 0) {
                return true;
            }
            return ((MallActivityEpisodesDetailBinding) this).f10197a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10202a = 128L;
        }
        ((MallActivityEpisodesDetailBinding) this).f10197a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityEpisodesDetailBinding
    public void l(@Nullable EpisodesDetailActivity.a aVar) {
        ((MallActivityEpisodesDetailBinding) this).f10199a = aVar;
        synchronized (this) {
            this.f10202a |= 64;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityEpisodesDetailBinding
    public void m(@Nullable EpisodesDetailVM episodesDetailVM) {
        ((MallActivityEpisodesDetailBinding) this).f10200a = episodesDetailVM;
        synchronized (this) {
            this.f10202a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10202a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<EpisodeDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10202a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 1) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10202a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10202a |= 16;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10202a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityEpisodesDetailBinding) this).f10197a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((EpisodesDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((EpisodesDetailActivity.a) obj);
        }
        return true;
    }

    public MallActivityEpisodesDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (SlidingTabLayout2) objArr[10], (LayoutToolbarBindingBinding) objArr[8], (AliVideoView) objArr[9], (ViewPager2) objArr[11]);
        this.f10202a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10205a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10204a = imageView;
        imageView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[2];
        this.f10203a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[3];
        this.f10209a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView2 = (ImageView) objArr[4];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f10206a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.f10210b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.c = textView3;
        textView3.setTag(null);
        setContainedBinding(((MallActivityEpisodesDetailBinding) this).f10197a);
        setRootTag(view);
        invalidateAll();
    }
}
