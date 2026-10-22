package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemEpisodesListBindingImpl extends MallItemEpisodesListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34989a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10769a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f10772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10773a;

    public MallItemEpisodesListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10769a, f34989a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zIsPlaying;
        int i;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        int i3;
        int i4;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f10770a;
            this.f10770a = 0L;
        }
        Boolean bool = ((MallItemEpisodesListBinding) this).f10768a;
        EpisodeItemBean episodeItemBean = ((MallItemEpisodesListBinding) this).f10766a;
        String str2 = null;
        if ((j & 7) != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if ((j & 2048) != 0) {
                j |= zSafeUnbox ? 64L : 32L;
            }
            zIsPlaying = episodeItemBean != null ? episodeItemBean.isPlaying() : false;
            if ((j & 6) != 0) {
                j |= zIsPlaying ? 256L : 128L;
            }
            if ((j & 7) != 0) {
                j = zIsPlaying ? j | 4096 : j | 2048;
            }
            z = !zSafeUnbox;
            if ((j & 7) != 0) {
                if (z) {
                    j2 = j | 16;
                    j3 = 1024;
                } else {
                    j2 = j | 8;
                    j3 = 512;
                }
                j = j2 | j3;
            }
            long j4 = j & 6;
            if (j4 != 0) {
                i4 = zIsPlaying ? -10155284 : -1;
            } else {
                i4 = 0;
            }
            if (j4 != 0) {
                str2 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(episodeItemBean != null ? episodeItemBean.getSort() : 0));
            }
            str = str2;
            i = i4;
        } else {
            zSafeUnbox = false;
            zIsPlaying = false;
            i = 0;
            z = false;
            str = null;
        }
        if ((j & 1072) != 0) {
            int trySee = episodeItemBean != null ? episodeItemBean.getTrySee() : 0;
            z3 = (16 & j) != 0 && trySee == 0;
            z2 = (j & 1056) != 0 && trySee == 1;
        } else {
            z2 = false;
            z3 = false;
        }
        if ((j & 7) != 0) {
            if (!z) {
                z3 = false;
            }
            z4 = z ? z2 : false;
        } else {
            z3 = false;
            z4 = false;
        }
        long j5 = 2048 & j;
        if (j5 != 0) {
            boolean z5 = zSafeUnbox ? true : z2;
            if (j5 != 0) {
                j |= z5 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            i2 = z5 ? -13877680 : RunIndexRecordAdapter.O;
        } else {
            i2 = 0;
        }
        long j6 = j & 7;
        if (j6 != 0) {
            i3 = zIsPlaying ? -1 : i2;
        } else {
            i3 = 0;
        }
        if ((j & 6) != 0) {
            CommonBindingAdapter.l0(((MallItemEpisodesListBinding) this).f34988a, zIsPlaying);
            TextViewBindingAdapter.setText(this.f10771a, str);
            ((MallItemEpisodesListBinding) this).f10767a.setTextColor(i);
        }
        if (j6 != 0) {
            this.f10771a.setTextColor(i3);
            CommonBindingAdapter.l0(this.f10773a, z3);
            CommonBindingAdapter.l0(((MallItemEpisodesListBinding) this).f10767a, z4);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10770a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10770a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemEpisodesListBinding
    public void l(@Nullable EpisodeItemBean episodeItemBean) {
        ((MallItemEpisodesListBinding) this).f10766a = episodeItemBean;
        synchronized (this) {
            this.f10770a |= 2;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemEpisodesListBinding
    public void m(@Nullable Boolean bool) {
        ((MallItemEpisodesListBinding) this).f10768a = bool;
        synchronized (this) {
            this.f10770a |= 1;
        }
        notifyPropertyChanged(hk0.u);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.u == i) {
            m((Boolean) obj);
        } else {
            if (hk0.g != i) {
                return false;
            }
            l((EpisodeItemBean) obj);
        }
        return true;
    }

    public MallItemEpisodesListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LottieAnimationView) objArr[4], (BLTextView) objArr[2]);
        this.f10770a = -1L;
        ((MallItemEpisodesListBinding) this).f34988a.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[0];
        this.f10772a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f10771a = textView;
        textView.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[3];
        this.f10773a = bLImageView;
        bLImageView.setTag(null);
        ((MallItemEpisodesListBinding) this).f10767a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
