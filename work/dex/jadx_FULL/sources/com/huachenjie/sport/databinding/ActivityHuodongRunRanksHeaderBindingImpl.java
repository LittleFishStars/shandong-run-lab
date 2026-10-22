package com.huachenjie.sport.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
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
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.RunRankBean;
import com.huachenjie.sport.bean.UserRunRankBean;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ju3;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityHuodongRunRanksHeaderBindingImpl extends ActivityHuodongRunRanksHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13301a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13304a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HuodongRunRanksActivity.a f36415a;

        public a a(HuodongRunRanksActivity.a aVar) {
            this.f36415a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36415a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36414a = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 19);
        sparseIntArray.put(R.id.tab, 20);
        sparseIntArray.put(R.id.mIvHeadView, 21);
        sparseIntArray.put(R.id.cl_top1, 22);
        sparseIntArray.put(R.id.ll_top2_shadow, 23);
        sparseIntArray.put(R.id.cl_top2, 24);
        sparseIntArray.put(R.id.ll_top3_shadow, 25);
        sparseIntArray.put(R.id.cl_top3, 26);
        sparseIntArray.put(R.id.tv_mine, 27);
    }

    public ActivityHuodongRunRanksHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 28, f13301a, f36414a));
    }

    /* JADX WARN: Code duplicated, block: B:135:0x0232  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x0131  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        String avatarUrl;
        int i;
        String avatarUrl2;
        String str;
        String str2;
        boolean z;
        String str3;
        boolean z2;
        Drawable drawable2;
        UserRunRankBean value;
        Drawable drawable3;
        int i2;
        String str4;
        String nickName;
        String duration;
        String str5;
        String nickName2;
        boolean z3;
        Drawable drawable4;
        String avatarUrl3;
        boolean zSafeUnbox;
        String nickName3;
        a aVarA;
        String str6;
        String str7;
        boolean z4;
        Drawable drawable5;
        boolean z5;
        Drawable drawable6;
        boolean z6;
        int iSafeUnbox;
        String duration2;
        String avatarUrl4;
        int rankNumber;
        long j2;
        String duration3;
        long j3;
        String nickName4;
        String distance;
        long j4;
        long j5;
        synchronized (this) {
            j = this.f13302a;
            this.f13302a = 0L;
        }
        HuodongRunRanksVM huodongRunRanksVM = ((ActivityHuodongRunRanksHeaderBinding) this).f13291a;
        HuodongRunRanksActivity.a aVar = ((ActivityHuodongRunRanksHeaderBinding) this).f13290a;
        if ((1535 & j) != 0) {
            long j6 = j & 1281;
            if (j6 != 0) {
                MediatorLiveData<Integer> mediatorLiveDataQ = huodongRunRanksVM != null ? huodongRunRanksVM.q() : null;
                updateLiveDataRegistration(0, mediatorLiveDataQ);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(mediatorLiveDataQ != null ? mediatorLiveDataQ.getValue() : null);
                z6 = iSafeUnbox2 == 1;
                z5 = iSafeUnbox2 == 2;
                if (j6 != 0) {
                    if (z5) {
                        j4 = j | 4096 | PlaybackStateCompat.ACTION_PREPARE;
                        j5 = 262144;
                    } else {
                        j4 = j | 2048 | 8192;
                        j5 = 131072;
                    }
                    j = j4 | j5;
                }
                drawable = AppCompatResources.getDrawable(((ActivityHuodongRunRanksHeaderBinding) this).d.getContext(), z5 ? R.drawable.run_ic_default_ranking_avatar_boy : R.drawable.run_ic_default_ranking_avatar_girl);
                drawable6 = AppCompatResources.getDrawable(((ActivityHuodongRunRanksHeaderBinding) this).b.getContext(), z5 ? R.drawable.run_ic_default_ranking_avatar_boy : R.drawable.run_ic_default_ranking_avatar_girl);
                drawable5 = z5 ? AppCompatResources.getDrawable(((ActivityHuodongRunRanksHeaderBinding) this).c.getContext(), R.drawable.run_ic_default_ranking_avatar_boy) : AppCompatResources.getDrawable(((ActivityHuodongRunRanksHeaderBinding) this).c.getContext(), R.drawable.run_ic_default_ranking_avatar_girl);
            } else {
                drawable = null;
                drawable5 = null;
                z5 = false;
                drawable6 = null;
                z6 = false;
            }
            if ((j & 1282) != 0) {
                MutableLiveData<Integer> mutableLiveData = huodongRunRanksVM != null ? ((BaseVM) huodongRunRanksVM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 1284) == 0) {
                duration2 = null;
                nickName2 = null;
                avatarUrl = null;
            } else {
                MediatorLiveData<RunRankBean> mediatorLiveDataT = huodongRunRanksVM != null ? huodongRunRanksVM.t() : null;
                updateLiveDataRegistration(2, mediatorLiveDataT);
                RunRankBean value2 = mediatorLiveDataT != null ? mediatorLiveDataT.getValue() : null;
                if (value2 != null) {
                    nickName2 = value2.getNickName();
                    avatarUrl = value2.getAvatarUrl();
                    duration2 = value2.formatDuration();
                } else {
                    duration2 = null;
                    nickName2 = null;
                    avatarUrl = null;
                }
            }
            if ((j & 1288) == 0) {
                nickName = null;
                duration = null;
                avatarUrl4 = null;
            } else {
                MediatorLiveData<RunRankBean> mediatorLiveDataU = huodongRunRanksVM != null ? huodongRunRanksVM.u() : null;
                updateLiveDataRegistration(3, mediatorLiveDataU);
                RunRankBean value3 = mediatorLiveDataU != null ? mediatorLiveDataU.getValue() : null;
                if (value3 != null) {
                    duration = value3.formatDuration();
                    avatarUrl4 = value3.getAvatarUrl();
                    nickName = value3.getNickName();
                } else {
                    nickName = null;
                    duration = null;
                    avatarUrl4 = null;
                }
            }
            long j7 = j & 1296;
            if (j7 != 0) {
                MediatorLiveData<UserRunRankBean> mediatorLiveDataN = huodongRunRanksVM != null ? huodongRunRanksVM.n() : null;
                updateLiveDataRegistration(4, mediatorLiveDataN);
                value = mediatorLiveDataN != null ? mediatorLiveDataN.getValue() : null;
                if (value != null) {
                    rankNumber = value.getRankNumber();
                    avatarUrl3 = value.getAvatarUrl();
                    distance = value.formatDistance();
                    nickName3 = value.getNickName();
                } else {
                    rankNumber = 0;
                    avatarUrl3 = null;
                    distance = null;
                    nickName3 = null;
                }
                z3 = rankNumber == 0;
                str4 = String.format("跑步目标里程  %s", distance);
                if (j7 != 0) {
                    j = z3 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 2097152;
                }
                j2 = 1312;
            } else {
                str4 = null;
                value = null;
                rankNumber = 0;
                j2 = 1312;
                avatarUrl3 = null;
                nickName3 = null;
                z3 = false;
            }
            long j8 = j & j2;
            if (j8 != 0) {
                MediatorLiveData<Integer> mediatorLiveDataO = huodongRunRanksVM != null ? huodongRunRanksVM.o() : null;
                updateLiveDataRegistration(5, mediatorLiveDataO);
                boolean z7 = ViewDataBinding.safeUnbox(mediatorLiveDataO != null ? mediatorLiveDataO.getValue() : null) == 2;
                if (j8 != 0) {
                    j |= z7 ? 1048576L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                drawable4 = AppCompatResources.getDrawable(((ActivityHuodongRunRanksHeaderBinding) this).f13289a.getContext(), z7 ? R.drawable.run_ic_default_ranking_avatar_boy : R.drawable.run_ic_default_ranking_avatar_girl);
            } else {
                str4 = str4;
                drawable4 = null;
            }
            if ((j & 1344) == 0) {
                duration3 = null;
                avatarUrl2 = null;
                j3 = 1408;
                nickName4 = null;
            } else {
                MediatorLiveData<RunRankBean> mediatorLiveDataS = huodongRunRanksVM != null ? huodongRunRanksVM.s() : null;
                updateLiveDataRegistration(6, mediatorLiveDataS);
                RunRankBean value4 = mediatorLiveDataS != null ? mediatorLiveDataS.getValue() : null;
                if (value4 != null) {
                    avatarUrl2 = value4.getAvatarUrl();
                    nickName4 = value4.getNickName();
                    duration3 = value4.formatDuration();
                    j3 = 1408;
                } else {
                    duration3 = null;
                    avatarUrl2 = null;
                    j3 = 1408;
                    nickName4 = null;
                }
            }
            if ((j & j3) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataW = huodongRunRanksVM != null ? huodongRunRanksVM.w() : null;
                updateLiveDataRegistration(7, mediatorLiveDataW);
                zSafeUnbox = ViewDataBinding.safeUnbox(mediatorLiveDataW != null ? mediatorLiveDataW.getValue() : null);
                j = j;
            } else {
                zSafeUnbox = false;
            }
            String str8 = avatarUrl4;
            str2 = duration3;
            i = rankNumber;
            drawable3 = drawable5;
            str = nickName4;
            str5 = str8;
            boolean z8 = z5;
            str3 = duration2;
            z = z8;
            int i3 = iSafeUnbox;
            drawable2 = drawable6;
            z2 = z6;
            i2 = i3;
        } else {
            drawable = null;
            avatarUrl = null;
            i = 0;
            avatarUrl2 = null;
            str = null;
            str2 = null;
            z = false;
            str3 = null;
            z2 = false;
            drawable2 = null;
            value = null;
            drawable3 = null;
            i2 = 0;
            str4 = null;
            nickName = null;
            duration = null;
            str5 = null;
            nickName2 = null;
            z3 = false;
            drawable4 = null;
            avatarUrl3 = null;
            zSafeUnbox = false;
            nickName3 = null;
        }
        long j9 = j & 1536;
        if (j9 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13303a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13303a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        RequestOptions requestOptions = (j & 1356) != 0 ? ju3.f42674a : null;
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            str6 = "" + i;
        } else {
            str6 = null;
        }
        if ((j & 2097152) != 0) {
            str7 = "" + (value != null ? value.formatDuration() : null);
        } else {
            str7 = null;
        }
        long j10 = j & 1296;
        if (j10 != 0) {
            if (z3) {
                str6 = "未完成";
            }
            if (z3) {
                str7 = "不计成绩";
            }
        } else {
            str6 = null;
            str7 = null;
        }
        if ((j & 1281) != 0) {
            ViewBindingAdapter.setBackground(((ActivityHuodongRunRanksHeaderBinding) this).b, drawable2);
            ViewBindingAdapter.setBackground(((ActivityHuodongRunRanksHeaderBinding) this).c, drawable3);
            ViewBindingAdapter.setBackground(((ActivityHuodongRunRanksHeaderBinding) this).d, drawable);
            CommonBindingAdapter.e0(this.f13304a, z2);
            CommonBindingAdapter.e0(this.b, z);
        }
        if ((1344 & j) != 0) {
            z4 = false;
            CommonBindingAdapter.b0(((ActivityHuodongRunRanksHeaderBinding) this).b, avatarUrl2, requestOptions, false);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13287a, str2);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13299f, str);
        } else {
            z4 = false;
        }
        if ((j & 1284) != 0) {
            CommonBindingAdapter.b0(((ActivityHuodongRunRanksHeaderBinding) this).c, avatarUrl, requestOptions, z4);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13293b, str3);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13300g, nickName2);
        }
        if ((j & 1288) != 0) {
            CommonBindingAdapter.b0(((ActivityHuodongRunRanksHeaderBinding) this).d, str5, requestOptions, z4);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13295c, duration);
            TextViewBindingAdapter.setText(this.h, nickName);
        }
        if ((1312 & j) != 0) {
            ViewBindingAdapter.setBackground(((ActivityHuodongRunRanksHeaderBinding) this).f13289a, drawable4);
        }
        if (j10 != 0) {
            aw9.d(((ActivityHuodongRunRanksHeaderBinding) this).f13289a, avatarUrl3, false, null);
            TextViewBindingAdapter.setText(this.i, str6);
            TextViewBindingAdapter.setText(this.j, nickName3);
            TextViewBindingAdapter.setText(this.k, str4);
            TextViewBindingAdapter.setText(((ActivityHuodongRunRanksHeaderBinding) this).f13298e, str7);
        }
        if ((1408 & j) != 0) {
            CommonBindingAdapter.l0(this.e, zSafeUnbox);
        }
        if (j9 != 0) {
            a aVar3 = aVarA;
            CommonBindingAdapter.q(this.f13304a, aVar3, null);
            CommonBindingAdapter.q(this.b, aVar3, null);
        }
        if ((j & 1282) != 0) {
            CommonBindingAdapter.I(((ActivityHuodongRunRanksHeaderBinding) this).f36413a, 0, i2, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13302a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13302a = 1024L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityHuodongRunRanksHeaderBinding
    public void l(@Nullable HuodongRunRanksActivity.a aVar) {
        ((ActivityHuodongRunRanksHeaderBinding) this).f13290a = aVar;
        synchronized (this) {
            this.f13302a |= 512;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityHuodongRunRanksHeaderBinding
    public void m(@Nullable HuodongRunRanksVM huodongRunRanksVM) {
        ((ActivityHuodongRunRanksHeaderBinding) this).f13291a = huodongRunRanksVM;
        synchronized (this) {
            this.f13302a |= 256;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 128;
        }
        return true;
    }

    public final boolean o(MediatorLiveData<UserRunRankBean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return q((MediatorLiveData) obj, i2);
            case 1:
                return r((MutableLiveData) obj, i2);
            case 2:
                return t((MediatorLiveData) obj, i2);
            case 3:
                return u((MediatorLiveData) obj, i2);
            case 4:
                return o((MediatorLiveData) obj, i2);
            case 5:
                return p((MediatorLiveData) obj, i2);
            case 6:
                return s((MediatorLiveData) obj, i2);
            case 7:
                return n((MediatorLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MediatorLiveData<Integer> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 32;
        }
        return true;
    }

    public final boolean q(MediatorLiveData<Integer> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 2;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<RunRankBean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((HuodongRunRanksVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((HuodongRunRanksActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MediatorLiveData<RunRankBean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 4;
        }
        return true;
    }

    public final boolean u(MediatorLiveData<RunRankBean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13302a |= 8;
        }
        return true;
    }

    public ActivityHuodongRunRanksHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[24], (ConstraintLayout) objArr[26], (ImageView) objArr[19], (ImageView) objArr[9], (ImageView) objArr[11], (ImageView) objArr[13], (AvatarView) objArr[16], (ImageView) objArr[23], (ImageView) objArr[25], (ImageView) objArr[21], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (BLLinearLayout) objArr[20], (TextView) objArr[27], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[10], (TextView) objArr[12], (View) objArr[1]);
        this.f13302a = -1L;
        ((ActivityHuodongRunRanksHeaderBinding) this).b.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).c.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).d.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13289a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.d = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[14];
        this.e = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.i = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[18];
        this.j = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[2];
        this.k = textView3;
        textView3.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f13304a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[4];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13287a.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13293b.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13295c.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13298e.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13299f.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f13300g.setTag(null);
        this.h.setTag(null);
        ((ActivityHuodongRunRanksHeaderBinding) this).f36413a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
