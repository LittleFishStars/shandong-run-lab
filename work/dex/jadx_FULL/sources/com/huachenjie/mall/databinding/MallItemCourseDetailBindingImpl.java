package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemCourseDetailBindingImpl extends MallItemCourseDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10760a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f10765a;

    @NonNull
    public final TextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34987a = sparseIntArray;
        sparseIntArray.put(R.id.jsonAnimationView, 7);
    }

    public MallItemCourseDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10760a, f34987a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0152  */
    /* JADX WARN: Code duplicated, block: B:103:0x0155  */
    /* JADX WARN: Code duplicated, block: B:104:0x0157  */
    /* JADX WARN: Code duplicated, block: B:107:0x015f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0162  */
    /* JADX WARN: Code duplicated, block: B:110:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0167  */
    /* JADX WARN: Code duplicated, block: B:112:0x016a  */
    /* JADX WARN: Code duplicated, block: B:114:0x016f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0178  */
    /* JADX WARN: Code duplicated, block: B:119:0x0189  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x014d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zIsPlaying;
        boolean z;
        String str;
        String str2;
        String str3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        long j2;
        boolean z5;
        boolean z6;
        boolean z7;
        String episodeItemName;
        int sort;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f10761a;
            this.f10761a = 0L;
        }
        Boolean bool = ((MallItemCourseDetailBinding) this).f10759a;
        EpisodeItemBean episodeItemBean = ((MallItemCourseDetailBinding) this).f10757a;
        if ((j & 7) != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            if ((j & 551) != 0) {
                j |= zSafeUnbox ? 4096L : 2048L;
            }
            zIsPlaying = episodeItemBean != null ? episodeItemBean.isPlaying() : false;
            if ((j & 7) != 0) {
                j = zIsPlaying ? j | 64 | 1024 : j | 32 | 512;
            }
            z = !zSafeUnbox;
            if ((j & 7) != 0) {
                if (z) {
                    j3 = j | 256;
                    j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                } else {
                    j3 = j | 128;
                    j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                j = j3 | j4;
            }
            String info = episodeItemBean != null ? episodeItemBean.formatInfo(zSafeUnbox) : null;
            if ((j & 6) != 0) {
                if (episodeItemBean != null) {
                    sort = episodeItemBean.getSort();
                    episodeItemName = episodeItemBean.getEpisodeItemName();
                } else {
                    episodeItemName = null;
                    sort = 0;
                }
                str2 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(sort));
                str = info;
                str3 = episodeItemName;
            } else {
                str2 = null;
                str3 = null;
                str = info;
            }
        } else {
            zSafeUnbox = false;
            zIsPlaying = false;
            z = false;
            str = null;
            str2 = null;
            str3 = null;
        }
        if ((j & 67840) != 0) {
            int trySee = episodeItemBean != null ? episodeItemBean.getTrySee() : 0;
            z3 = (256 & j) != 0 && trySee == 0;
            z2 = (j & 67584) != 0 && trySee == 1;
        } else {
            z2 = false;
            z3 = false;
        }
        long j5 = j & 7;
        if (j5 != 0) {
            if (!z) {
                z3 = false;
            }
            z4 = z ? z2 : false;
        } else {
            z4 = false;
            z3 = false;
        }
        if ((j & 551) != 0) {
            if (zSafeUnbox) {
                z2 = true;
            }
            if (j5 != 0) {
                j = z2 ? j | 16 : j | 8;
            }
            if ((j & 512) != 0) {
                j |= z2 ? PlaybackStateCompat.ACTION_PREPARE : 8192L;
            }
            if ((j & 32) != 0) {
                j |= z2 ? 262144L : 131072L;
            }
            long j6 = j & 512;
            i2 = RunIndexRecordAdapter.O;
            if (j6 != 0) {
                i = z2 ? -7759964 : -4079167;
            } else {
                i = 0;
            }
            if ((j & 32) != 0) {
                if (z2) {
                    i2 = -13877680;
                }
            }
            j2 = 7 & j;
            if (j2 != 0) {
                if (zIsPlaying) {
                    i2 = -10155284;
                }
                if (zIsPlaying) {
                    i = -10155284;
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if ((j & 16) != 0) {
                z5 = !zIsPlaying;
            } else {
                z5 = false;
            }
            if (j2 != 0) {
                if (z2) {
                    z7 = z5;
                } else {
                    z7 = false;
                }
                z6 = z7;
            } else {
                z6 = false;
            }
            if ((j & 6) != 0) {
                CommonBindingAdapter.l0(this.f10765a, zIsPlaying);
                TextViewBindingAdapter.setText(this.f10763a, str3);
                TextViewBindingAdapter.setText(((MallItemCourseDetailBinding) this).f10756a, str2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(this.f10762a, z3);
                this.f10763a.setTextColor(i2);
                TextViewBindingAdapter.setText(this.b, str);
                this.b.setTextColor(i);
                CommonBindingAdapter.l0(((MallItemCourseDetailBinding) this).f10756a, z6);
                CommonBindingAdapter.l0(((MallItemCourseDetailBinding) this).f10758a, z4);
            }
        }
        i = 0;
        z2 = false;
        i2 = 0;
        j2 = 7 & j;
        if (j2 != 0) {
            if (zIsPlaying) {
                i2 = -10155284;
            }
            if (zIsPlaying) {
                i = -10155284;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if ((j & 16) != 0) {
            z5 = !zIsPlaying;
        } else {
            z5 = false;
        }
        if (j2 != 0) {
            if (z2) {
                z7 = z5;
            } else {
                z7 = false;
            }
            z6 = z7;
        } else {
            z6 = false;
        }
        if ((j & 6) != 0) {
            CommonBindingAdapter.l0(this.f10765a, zIsPlaying);
            TextViewBindingAdapter.setText(this.f10763a, str3);
            TextViewBindingAdapter.setText(((MallItemCourseDetailBinding) this).f10756a, str2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f10762a, z3);
            this.f10763a.setTextColor(i2);
            TextViewBindingAdapter.setText(this.b, str);
            this.b.setTextColor(i);
            CommonBindingAdapter.l0(((MallItemCourseDetailBinding) this).f10756a, z6);
            CommonBindingAdapter.l0(((MallItemCourseDetailBinding) this).f10758a, z4);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10761a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10761a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemCourseDetailBinding
    public void l(@Nullable EpisodeItemBean episodeItemBean) {
        ((MallItemCourseDetailBinding) this).f10757a = episodeItemBean;
        synchronized (this) {
            this.f10761a |= 2;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemCourseDetailBinding
    public void m(@Nullable Boolean bool) {
        ((MallItemCourseDetailBinding) this).f10759a = bool;
        synchronized (this) {
            this.f10761a |= 1;
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

    public MallItemCourseDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LottieAnimationView) objArr[7], (CustomerTextView) objArr[1], (BLTextView) objArr[4]);
        this.f10761a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10764a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[2];
        this.f10765a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f10762a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.f10763a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.b = textView2;
        textView2.setTag(null);
        ((MallItemCourseDetailBinding) this).f10756a.setTag(null);
        ((MallItemCourseDetailBinding) this).f10758a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
