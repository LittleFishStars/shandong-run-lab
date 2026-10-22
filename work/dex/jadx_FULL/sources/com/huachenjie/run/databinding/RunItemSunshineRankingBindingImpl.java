package com.huachenjie.run.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankItemData;
import com.zj.adlib.aw9;
import com.zj.adlib.fq1;
import com.zj.adlib.h46;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemSunshineRankingBindingImpl extends RunItemSunshineRankingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11982a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f11985a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11986b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35636a = sparseIntArray;
        sparseIntArray.put(R.id.ll_like_num, 9);
    }

    public RunItemSunshineRankingBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f11982a, f35636a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        Drawable drawable;
        String likeCount;
        String avatarUrl;
        String name;
        Drawable drawable2;
        boolean z;
        boolean z2;
        String str2;
        String str3;
        String stageName;
        long j2;
        String str4;
        String str5;
        Context context;
        int i;
        int i2;
        boolean hasLiked;
        synchronized (this) {
            j = this.f11983a;
            this.f11983a = 0L;
        }
        RankItemData rankItemData = ((RunItemSunshineRankingBinding) this).f11980a;
        Integer num = ((RunItemSunshineRankingBinding) this).f11981a;
        Integer num2 = ((RunItemSunshineRankingBinding) this).b;
        long j3 = j & 9;
        if (j3 != 0) {
            if (rankItemData != null) {
                likeCount = rankItemData.formatLikeCount();
                avatarUrl = rankItemData.getAvatarUrl();
                name = rankItemData.getName();
                int rankNumber = rankItemData.getRankNumber();
                hasLiked = rankItemData.getHasLiked();
                i2 = rankNumber;
            } else {
                i2 = 0;
                likeCount = null;
                avatarUrl = null;
                name = null;
                hasLiked = false;
            }
            if (j3 != 0) {
                j |= hasLiked ? 32L : 16L;
            }
            str = "" + i2;
            drawable = AppCompatResources.getDrawable(this.b.getContext(), hasLiked ? R.drawable.run_ic_ranking_like : R.drawable.run_ic_ranking_like_gray);
        } else {
            str = null;
            drawable = null;
            likeCount = null;
            avatarUrl = null;
            name = null;
        }
        long j4 = j & 10;
        if (j4 != 0) {
            boolean z3 = ViewDataBinding.safeUnbox(num) == 2;
            if (j4 != 0) {
                j |= z3 ? 2048L : 1024L;
            }
            if (z3) {
                context = ((RunItemSunshineRankingBinding) this).f11979a.getContext();
                i = R.drawable.run_ic_default_ranking_avatar_boy;
            } else {
                context = ((RunItemSunshineRankingBinding) this).f11979a.getContext();
                i = R.drawable.run_ic_default_ranking_avatar_girl;
            }
            drawable2 = AppCompatResources.getDrawable(context, i);
        } else {
            drawable2 = null;
        }
        long j5 = j & 13;
        if (j5 != 0) {
            int iSafeUnbox = ViewDataBinding.safeUnbox(num2);
            z2 = iSafeUnbox == 3;
            if (j5 != 0) {
                j = z2 ? j | 128 | 512 : j | 64 | 256;
            }
            z = ((j & 12) == 0 || iSafeUnbox == 3) ? false : true;
        } else {
            z = false;
            z2 = false;
        }
        if ((j & 960) != 0) {
            if ((j & 256) != 0) {
                str4 = String.format("%skm", ll7.f43096a.g(Long.valueOf(rankItemData != null ? rankItemData.getDistance() : 0L)));
            } else {
                str4 = null;
            }
            stageName = ((j & 64) == 0 || rankItemData == null) ? null : rankItemData.getStageName();
            if ((j & 512) != 0) {
                str2 = String.format("%s", h46.f42049a.f(rankItemData != null ? rankItemData.getProgress() : 0.0f));
            } else {
                str2 = null;
            }
            if ((j & 128) != 0) {
                str3 = String.format("%s", fq1.a(rankItemData != null ? rankItemData.getUpdateTime() : 0L, "MM/dd HH:mm"));
            } else {
                str2 = str2;
                str3 = null;
            }
            j2 = 13;
        } else {
            str2 = null;
            str3 = null;
            stageName = null;
            j2 = 13;
            str4 = null;
        }
        long j6 = j & j2;
        if (j6 != 0) {
            if (!z2) {
                str3 = stageName;
            }
            if (z2) {
                str4 = str2;
            }
            str5 = str4;
        } else {
            str5 = null;
            str3 = null;
        }
        if ((j & 10) != 0) {
            ViewBindingAdapter.setBackground(((RunItemSunshineRankingBinding) this).f11979a, drawable2);
        }
        if ((9 & j) != 0) {
            aw9.d(((RunItemSunshineRankingBinding) this).f11979a, avatarUrl, false, null);
            TextViewBindingAdapter.setText(this.f11986b, str);
            TextViewBindingAdapter.setText(this.c, name);
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable);
            TextViewBindingAdapter.setText(this.e, likeCount);
        }
        if ((j & 12) != 0) {
            CommonBindingAdapter.l0(this.f11984a, z);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.d, str3);
            TextViewBindingAdapter.setText(((RunItemSunshineRankingBinding) this).f11978a, str5);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11983a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11983a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemSunshineRankingBinding
    public void m(@Nullable Integer ListType) {
        ((RunItemSunshineRankingBinding) this).b = ListType;
        synchronized (this) {
            this.f11983a |= 4;
        }
        notifyPropertyChanged(lk0.K);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemSunshineRankingBinding
    public void n(@Nullable Integer SexType) {
        ((RunItemSunshineRankingBinding) this).f11981a = SexType;
        synchronized (this) {
            this.f11983a |= 2;
        }
        notifyPropertyChanged(lk0.U);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemSunshineRankingBinding
    public void o(@Nullable RankItemData Vm) {
        ((RunItemSunshineRankingBinding) this).f11980a = Vm;
        synchronized (this) {
            this.f11983a |= 1;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            o((RankItemData) variable);
        } else if (lk0.U == variableId) {
            n((Integer) variable);
        } else {
            if (lk0.K != variableId) {
                return false;
            }
            m((Integer) variable);
        }
        return true;
    }

    public RunItemSunshineRankingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AvatarView) bindings[2], (LinearLayout) bindings[9], (TextView) bindings[6]);
        this.f11983a = -1L;
        ((RunItemSunshineRankingBinding) this).f11979a.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.f11985a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f11986b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.c = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.f11984a = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) bindings[5];
        this.d = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) bindings[7];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView4 = (TextView) bindings[8];
        this.e = textView4;
        textView4.setTag(null);
        ((RunItemSunshineRankingBinding) this).f11978a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
