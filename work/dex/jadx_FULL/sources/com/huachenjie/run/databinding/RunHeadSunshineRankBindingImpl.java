package com.huachenjie.run.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SegmentTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankItemData;
import com.huachenjie.run.page.rankinglist.SunshineRankingFragment;
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.fq1;
import com.zj.adlib.g89;
import com.zj.adlib.h46;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunHeadSunshineRankBindingImpl extends RunHeadSunshineRankBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11898a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f11903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f11904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f11905a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11906d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ImageView k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @NonNull
    public final TextView f11907k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    @NonNull
    public final TextView u;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35598a;

        public a a(SunshineRankingFragment.a value) {
            this.f35598a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35598a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35599a;

        public b a(SunshineRankingFragment.a value) {
            this.f35599a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35599a.d(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35600a;

        public c a(SunshineRankingFragment.a value) {
            this.f35600a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35600a.f(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35601a;

        public d a(SunshineRankingFragment.a value) {
            this.f35601a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35601a.c(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35602a;

        public e a(SunshineRankingFragment.a value) {
            this.f35602a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35602a.e(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.a f35603a;

        public f a(SunshineRankingFragment.a value) {
            this.f35603a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35603a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35597a = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 39);
        sparseIntArray.put(R.id.tab, 40);
        sparseIntArray.put(R.id.mIvHeadView, 41);
        sparseIntArray.put(R.id.cl_top1, 42);
        sparseIntArray.put(R.id.ll_top2_shadow, 43);
        sparseIntArray.put(R.id.cl_top2, 44);
        sparseIntArray.put(R.id.ll_top3_shadow, 45);
        sparseIntArray.put(R.id.cl_top3, 46);
        sparseIntArray.put(R.id.tv_mine, 47);
        sparseIntArray.put(R.id.llStageName, 48);
    }

    public RunHeadSunshineRankBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 49, f11898a, f35597a));
    }

    /* JADX WARN: Code duplicated, block: B:183:0x03cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:184:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:185:0x03da  */
    /* JADX WARN: Code duplicated, block: B:188:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:189:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:192:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:193:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:195:0x03fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:196:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:197:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:200:0x0405  */
    /* JADX WARN: Code duplicated, block: B:201:0x040e  */
    /* JADX WARN: Code duplicated, block: B:203:0x041b  */
    /* JADX WARN: Code duplicated, block: B:206:0x042a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:207:0x042c  */
    /* JADX WARN: Code duplicated, block: B:208:0x0433  */
    /* JADX WARN: Code duplicated, block: B:211:0x043d  */
    /* JADX WARN: Code duplicated, block: B:212:0x0444  */
    /* JADX WARN: Code duplicated, block: B:214:0x0447  */
    /* JADX WARN: Code duplicated, block: B:215:0x0466  */
    /* JADX WARN: Code duplicated, block: B:217:0x0476 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:218:0x0478  */
    /* JADX WARN: Code duplicated, block: B:219:0x048a  */
    /* JADX WARN: Code duplicated, block: B:223:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:224:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:227:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:230:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:231:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:233:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:236:0x04fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:237:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:238:0x0508  */
    /* JADX WARN: Code duplicated, block: B:241:0x0512  */
    /* JADX WARN: Code duplicated, block: B:242:0x0519  */
    /* JADX WARN: Code duplicated, block: B:244:0x0557  */
    /* JADX WARN: Code duplicated, block: B:332:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:341:0x080c  */
    /* JADX WARN: Code duplicated, block: B:366:0x08a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:368:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:370:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:373:0x08af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:374:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:375:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:377:0x08bd  */
    /* JADX WARN: Code duplicated, block: B:380:0x08c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:381:0x08ca  */
    /* JADX WARN: Code duplicated, block: B:383:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:386:0x08d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:387:0x08da  */
    /* JADX WARN: Code duplicated, block: B:389:0x08df  */
    /* JADX WARN: Code duplicated, block: B:392:0x08e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:393:0x08ea  */
    /* JADX WARN: Code duplicated, block: B:395:0x08f1  */
    /* JADX WARN: Code duplicated, block: B:398:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:399:0x090c  */
    /* JADX WARN: Code duplicated, block: B:402:0x0917  */
    /* JADX WARN: Code duplicated, block: B:404:0x094c  */
    /* JADX WARN: Code duplicated, block: B:407:0x098e  */
    /* JADX WARN: Code duplicated, block: B:410:0x09cf  */
    /* JADX WARN: Code duplicated, block: B:413:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:415:0x0a1a  */
    /* JADX WARN: Code duplicated, block: B:418:0x0a3e  */
    /* JADX WARN: Code duplicated, block: B:420:0x0a6a  */
    /* JADX WARN: Code duplicated, block: B:422:0x0a71  */
    /* JADX WARN: Code duplicated, block: B:425:0x0a7f  */
    /* JADX WARN: Code duplicated, block: B:427:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:430:0x0a98  */
    /* JADX WARN: Code duplicated, block: B:432:0x0aa1  */
    /* JADX WARN: Code duplicated, block: B:435:0x0ab0  */
    /* JADX WARN: Code duplicated, block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        Drawable drawable;
        String str2;
        Drawable drawable2;
        Drawable drawable3;
        String stageName;
        Drawable drawable4;
        Drawable drawable5;
        boolean z;
        RankItemData value;
        MediatorLiveData<RankItemData> mediatorLiveDataB;
        MediatorLiveData<RankItemData> mediatorLiveData;
        int i3;
        String str3;
        boolean zSafeUnbox;
        Drawable drawable6;
        String strF;
        Drawable drawable7;
        String str4;
        Drawable drawable8;
        Drawable drawable9;
        RankItemData value2;
        String name;
        MediatorLiveData<RankItemData> mediatorLiveDataD;
        String strF2;
        MediatorLiveData<RankItemData> mediatorLiveDataS;
        boolean z2;
        RankItemData value3;
        RankItemData value4;
        int i4;
        boolean z3;
        String stageName2;
        String likeCount;
        String name2;
        String avatarUrl;
        Drawable drawable10;
        String stageName3;
        String name3;
        String likeCount2;
        String avatarUrl2;
        int i5;
        String likeCount3;
        String name4;
        String avatarUrl3;
        c cVar;
        a aVar;
        e eVarA;
        f fVar;
        d dVar;
        b bVar;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String stageName4;
        String value5;
        String str10;
        String str11;
        long j2;
        String str12;
        long j3;
        String str13;
        long j4;
        String str14;
        long j5;
        String str15;
        long j6;
        String str16;
        String str17;
        String str18;
        String str19;
        int iSafeUnbox;
        String strF3;
        MediatorLiveData<RankItemData> mediatorLiveDataC;
        long j7;
        int rankNumber;
        String value6;
        long j8;
        long j9;
        Drawable drawable11;
        MediatorLiveData<RankItemData> mediatorLiveDataB2;
        Drawable drawable12;
        String avatarUrl4;
        String likeCount4;
        MediatorLiveData<Boolean> mediatorLiveDataF;
        Boolean value7;
        float f2;
        boolean hasLiked;
        Drawable drawable13;
        int i6;
        long j10;
        long j11;
        MutableLiveData<Integer> mutableLiveDataT;
        Integer value8;
        boolean z4;
        Context context;
        int i7;
        long j12;
        int i8;
        int i9;
        float f3;
        boolean hasLiked2;
        Context context2;
        int i10;
        long j13;
        long j14;
        float f4;
        boolean hasLiked3;
        long j15;
        long j16;
        Context context3;
        int i11;
        long j17;
        long j18;
        synchronized (this) {
            j = this.f11899a;
            this.f11899a = 0L;
        }
        SunshineRankingVM sunshineRankingVM = ((RunHeadSunshineRankBinding) this).f11884a;
        SunshineRankingFragment.a aVar2 = ((RunHeadSunshineRankBinding) this).f11883a;
        if ((12287 & j) != 0) {
            long j19 = j & 10241;
            if (j19 != 0) {
                MutableLiveData<Integer> mutableLiveDataX = sunshineRankingVM != null ? sunshineRankingVM.x() : null;
                updateLiveDataRegistration(0, mutableLiveDataX);
                boolean z5 = ViewDataBinding.safeUnbox(mutableLiveDataX != null ? mutableLiveDataX.getValue() : null) == 2;
                if (j19 != 0) {
                    if (z5) {
                        j17 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072;
                        j18 = 34359738368L;
                    } else {
                        j17 = j | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        j18 = 17179869184L;
                    }
                    j = j17 | j18;
                }
                drawable4 = AppCompatResources.getDrawable(((RunHeadSunshineRankBinding) this).d.getContext(), z5 ? R.drawable.run_ic_default_ranking_avatar_boy : R.drawable.run_ic_default_ranking_avatar_girl);
                drawable = z5 ? AppCompatResources.getDrawable(((RunHeadSunshineRankBinding) this).b.getContext(), R.drawable.run_ic_default_ranking_avatar_boy) : AppCompatResources.getDrawable(((RunHeadSunshineRankBinding) this).b.getContext(), R.drawable.run_ic_default_ranking_avatar_girl);
                if (z5) {
                    context3 = ((RunHeadSunshineRankBinding) this).c.getContext();
                    i11 = R.drawable.run_ic_default_ranking_avatar_boy;
                } else {
                    context3 = ((RunHeadSunshineRankBinding) this).c.getContext();
                    i11 = R.drawable.run_ic_default_ranking_avatar_girl;
                }
                drawable5 = AppCompatResources.getDrawable(context3, i11);
            } else {
                drawable4 = null;
                drawable = null;
                drawable5 = null;
            }
            if ((j & 10938) != 0) {
                MutableLiveData<Integer> mutableLiveDataW = sunshineRankingVM != null ? sunshineRankingVM.w() : null;
                updateLiveDataRegistration(1, mutableLiveDataW);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
                z3 = ((j & 10242) == 0 || iSafeUnbox2 == 3) ? false : true;
                z = iSafeUnbox2 == 3;
                if ((j & 10250) != 0) {
                    j = z ? j | 2097152 : j | 1048576;
                }
                if ((j & 10402) != 0) {
                    j = z ? j | 2199023255552L : j | FileUtils.ONE_TB;
                }
                if ((j & 10754) != 0) {
                    j |= z ? 8796093022208L : 4398046511104L;
                }
                if ((j & 10258) != 0) {
                    j |= z ? 35184372088832L : 17592186044416L;
                }
            } else {
                z = false;
                z3 = false;
            }
            if ((j & 10244) != 0) {
                MutableLiveData<Integer> mutableLiveData = sunshineRankingVM != null ? ((BaseVM) sunshineRankingVM).b : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null) + jj8.a(44.0f)));
            } else {
                iSafeUnbox = 0;
            }
            long j20 = j & 10248;
            int i12 = RunIndexRecordAdapter.O;
            if (j20 != 0) {
                mediatorLiveDataC = sunshineRankingVM != null ? sunshineRankingVM.C() : null;
                updateLiveDataRegistration(3, mediatorLiveDataC);
                value = mediatorLiveDataC != null ? mediatorLiveDataC.getValue() : null;
                if (value != null) {
                    stageName2 = value.getStageName();
                    likeCount = value.formatLikeCount();
                    name2 = value.getName();
                    avatarUrl = value.getAvatarUrl();
                    float progress = value.getProgress();
                    hasLiked3 = value.getHasLiked();
                    f4 = progress;
                } else {
                    f4 = 0.0f;
                    stageName2 = null;
                    likeCount = null;
                    name2 = null;
                    avatarUrl = null;
                    hasLiked3 = false;
                }
                if (j20 != 0) {
                    if (hasLiked3) {
                        j15 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 33554432;
                        j16 = 549755813888L;
                    } else {
                        j15 = j | 262144 | 16777216;
                        j16 = 274877906944L;
                    }
                    j = j15 | j16;
                }
                strF3 = h46.f42049a.f(f4);
                drawable9 = hasLiked3 ? AppCompatResources.getDrawable(this.c.getContext(), R.drawable.run_bg_ranking_top2_liked) : AppCompatResources.getDrawable(this.c.getContext(), R.drawable.run_bg_ranking_top2_like);
                i4 = hasLiked3 ? -4079167 : -1;
                drawable8 = hasLiked3 ? AppCompatResources.getDrawable(this.i.getContext(), R.drawable.run_ic_ranking_like_gray) : AppCompatResources.getDrawable(this.i.getContext(), R.drawable.run_ic_ranking_like_white);
                j = j;
            } else {
                drawable9 = null;
                drawable8 = null;
                strF3 = null;
                mediatorLiveDataC = null;
                value = null;
                i4 = 0;
                stageName2 = null;
                likeCount = null;
                name2 = null;
                avatarUrl = null;
            }
            long j21 = j & 10256;
            if (j21 != 0) {
                if (sunshineRankingVM != null) {
                    i9 = 4;
                    mediatorLiveDataD = sunshineRankingVM.D();
                } else {
                    mediatorLiveDataD = null;
                    i9 = 4;
                }
                updateLiveDataRegistration(i9, mediatorLiveDataD);
                RankItemData value9 = mediatorLiveDataD != null ? mediatorLiveDataD.getValue() : null;
                if (value9 != null) {
                    hasLiked2 = value9.getHasLiked();
                    stageName3 = value9.getStageName();
                    float progress2 = value9.getProgress();
                    name3 = value9.getName();
                    likeCount2 = value9.formatLikeCount();
                    avatarUrl2 = value9.getAvatarUrl();
                    f3 = progress2;
                } else {
                    f3 = 0.0f;
                    hasLiked2 = false;
                    stageName3 = null;
                    name3 = null;
                    likeCount2 = null;
                    avatarUrl2 = null;
                }
                if (j21 != 0) {
                    if (hasLiked2) {
                        j13 = j | 8388608 | 134217728;
                        j14 = 137438953472L;
                    } else {
                        j13 = j | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED | 67108864;
                        j14 = 68719476736L;
                    }
                    j = j13 | j14;
                }
                long j22 = j;
                Drawable drawable14 = AppCompatResources.getDrawable(this.j.getContext(), hasLiked2 ? R.drawable.run_ic_ranking_like_gray : R.drawable.run_ic_ranking_like_white);
                int i13 = hasLiked2 ? -4079167 : -1;
                drawable10 = drawable14;
                if (hasLiked2) {
                    context2 = this.d.getContext();
                    i10 = R.drawable.run_bg_ranking_top3_liked;
                } else {
                    context2 = this.d.getContext();
                    i10 = R.drawable.run_bg_ranking_top3_like;
                }
                Drawable drawable15 = AppCompatResources.getDrawable(context2, i10);
                strF = h46.f42049a.f(f3);
                RankItemData rankItemData = value9;
                drawable7 = drawable15;
                j = j22;
                i5 = i13;
                value2 = rankItemData;
            } else {
                drawable9 = drawable9;
                drawable8 = drawable8;
                strF = null;
                drawable7 = null;
                drawable10 = null;
                value2 = null;
                stageName3 = null;
                mediatorLiveDataD = null;
                name3 = null;
                likeCount2 = null;
                avatarUrl2 = null;
                i5 = 0;
            }
            long j23 = j & 10272;
            if (j23 != 0) {
                if (sunshineRankingVM != null) {
                    i8 = 5;
                    mediatorLiveDataS = sunshineRankingVM.s();
                } else {
                    mediatorLiveDataS = null;
                    i8 = 5;
                }
                updateLiveDataRegistration(i8, mediatorLiveDataS);
                value3 = mediatorLiveDataS != null ? mediatorLiveDataS.getValue() : null;
                if (value3 != null) {
                    likeCount3 = value3.formatLikeCount();
                    rankNumber = value3.getRankNumber();
                    name4 = value3.getName();
                    avatarUrl3 = value3.getAvatarUrl();
                } else {
                    likeCount3 = null;
                    rankNumber = 0;
                    name4 = null;
                    avatarUrl3 = null;
                }
                z2 = rankNumber == 0;
                if (j23 != 0) {
                    j = z2 ? j | 2147483648L : j | FileUtils.ONE_GB;
                }
                j7 = 10304;
            } else {
                strF = strF;
                drawable7 = drawable7;
                mediatorLiveDataS = null;
                value3 = null;
                j7 = 10304;
                likeCount3 = null;
                rankNumber = 0;
                name4 = null;
                avatarUrl3 = null;
                z2 = false;
            }
            if ((j & j7) != 0) {
                MediatorLiveData<String> mediatorLiveDataR = sunshineRankingVM != null ? sunshineRankingVM.r() : null;
                updateLiveDataRegistration(6, mediatorLiveDataR);
                value6 = mediatorLiveDataR != null ? mediatorLiveDataR.getValue() : null;
                j8 = j & 10496;
                if (j8 != 0) {
                    if (sunshineRankingVM != null) {
                        mutableLiveDataT = sunshineRankingVM.t();
                    } else {
                        mutableLiveDataT = null;
                    }
                    updateLiveDataRegistration(8, mutableLiveDataT);
                    if (mutableLiveDataT != null) {
                        value8 = mutableLiveDataT.getValue();
                    } else {
                        value8 = null;
                    }
                    if (ViewDataBinding.safeUnbox(value8) == 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (j8 != 0) {
                        if (z4) {
                            j12 = 562949953421312L;
                        } else {
                            j12 = 281474976710656L;
                        }
                        j |= j12;
                    }
                    if (z4) {
                        context = ((RunHeadSunshineRankBinding) this).f11882a.getContext();
                        i7 = R.drawable.run_ic_default_ranking_avatar_boy;
                    } else {
                        context = ((RunHeadSunshineRankBinding) this).f11882a.getContext();
                        i7 = R.drawable.run_ic_default_ranking_avatar_girl;
                    }
                    drawable6 = AppCompatResources.getDrawable(context, i7);
                } else {
                    value6 = value6;
                    drawable4 = drawable4;
                    drawable6 = null;
                }
                j9 = j & 10752;
                if (j9 != 0) {
                    if (sunshineRankingVM != null) {
                        mediatorLiveDataB2 = sunshineRankingVM.B();
                    } else {
                        mediatorLiveDataB2 = null;
                    }
                    updateLiveDataRegistration(9, mediatorLiveDataB2);
                    if (mediatorLiveDataB2 != null) {
                        value4 = mediatorLiveDataB2.getValue();
                    } else {
                        value4 = null;
                    }
                    if (value4 != null) {
                        avatarUrl4 = value4.getAvatarUrl();
                        float progress3 = value4.getProgress();
                        name = value4.getName();
                        likeCount4 = value4.formatLikeCount();
                        hasLiked = value4.getHasLiked();
                        stageName = value4.getStageName();
                        f2 = progress3;
                    } else {
                        f2 = 0.0f;
                        avatarUrl4 = null;
                        name = null;
                        likeCount4 = null;
                        hasLiked = false;
                        stageName = null;
                    }
                    if (j9 != 0) {
                        if (hasLiked) {
                            j10 = j | 536870912 | g89.f;
                            j11 = 140737488355328L;
                        } else {
                            j10 = j | 268435456 | 4294967296L;
                            j11 = 70368744177664L;
                        }
                        j = j10 | j11;
                    }
                    strF2 = h46.f42049a.f(f2);
                    if (hasLiked) {
                        drawable13 = AppCompatResources.getDrawable(this.h.getContext(), R.drawable.run_ic_ranking_like_gray);
                    } else {
                        drawable13 = AppCompatResources.getDrawable(this.h.getContext(), R.drawable.run_ic_ranking_like_white);
                    }
                    if (!hasLiked) {
                        i12 = -1;
                    }
                    Context context4 = this.b.getContext();
                    if (hasLiked) {
                        i6 = R.drawable.run_bg_ranking_top1_liked;
                    } else {
                        i6 = R.drawable.run_bg_ranking_top1_like;
                    }
                    Drawable drawable16 = AppCompatResources.getDrawable(context4, i6);
                    drawable11 = drawable13;
                    i = i12;
                    drawable12 = drawable16;
                    j = j;
                } else {
                    drawable6 = drawable6;
                    strF2 = null;
                    drawable11 = null;
                    mediatorLiveDataB2 = null;
                    drawable12 = null;
                    i = 0;
                    avatarUrl4 = null;
                    value4 = null;
                    name = null;
                    likeCount4 = null;
                    stageName = null;
                }
                if ((j & 11264) != 0) {
                    if (sunshineRankingVM != null) {
                        mediatorLiveDataF = sunshineRankingVM.F();
                    } else {
                        mediatorLiveDataF = null;
                    }
                    updateLiveDataRegistration(10, mediatorLiveDataF);
                    if (mediatorLiveDataF != null) {
                        value7 = mediatorLiveDataF.getValue();
                    } else {
                        value7 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                    j = j;
                } else {
                    zSafeUnbox = false;
                }
                mediatorLiveDataB = mediatorLiveDataB2;
                str4 = strF3;
                i3 = iSafeUnbox;
                drawable2 = drawable12;
                str2 = avatarUrl4;
                str3 = value6;
                str = likeCount4;
                mediatorLiveData = mediatorLiveDataC;
                drawable3 = drawable11;
                i2 = rankNumber;
            } else {
                mediatorLiveDataS = mediatorLiveDataS;
                value3 = value3;
            }
            j8 = j & 10496;
            if (j8 != 0) {
                if (sunshineRankingVM != null) {
                    mutableLiveDataT = sunshineRankingVM.t();
                } else {
                    mutableLiveDataT = null;
                }
                updateLiveDataRegistration(8, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value8 = mutableLiveDataT.getValue();
                } else {
                    value8 = null;
                }
                if (ViewDataBinding.safeUnbox(value8) == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (j8 != 0) {
                    if (z4) {
                        j12 = 562949953421312L;
                    } else {
                        j12 = 281474976710656L;
                    }
                    j |= j12;
                }
                if (z4) {
                    context = ((RunHeadSunshineRankBinding) this).f11882a.getContext();
                    i7 = R.drawable.run_ic_default_ranking_avatar_boy;
                } else {
                    context = ((RunHeadSunshineRankBinding) this).f11882a.getContext();
                    i7 = R.drawable.run_ic_default_ranking_avatar_girl;
                }
                drawable6 = AppCompatResources.getDrawable(context, i7);
            } else {
                value6 = value6;
                drawable4 = drawable4;
                drawable6 = null;
            }
            j9 = j & 10752;
            if (j9 != 0) {
                if (sunshineRankingVM != null) {
                    mediatorLiveDataB2 = sunshineRankingVM.B();
                } else {
                    mediatorLiveDataB2 = null;
                }
                updateLiveDataRegistration(9, mediatorLiveDataB2);
                if (mediatorLiveDataB2 != null) {
                    value4 = mediatorLiveDataB2.getValue();
                } else {
                    value4 = null;
                }
                if (value4 != null) {
                    avatarUrl4 = value4.getAvatarUrl();
                    float progress4 = value4.getProgress();
                    name = value4.getName();
                    likeCount4 = value4.formatLikeCount();
                    hasLiked = value4.getHasLiked();
                    stageName = value4.getStageName();
                    f2 = progress4;
                } else {
                    f2 = 0.0f;
                    avatarUrl4 = null;
                    name = null;
                    likeCount4 = null;
                    hasLiked = false;
                    stageName = null;
                }
                if (j9 != 0) {
                    if (hasLiked) {
                        j10 = j | 536870912 | g89.f;
                        j11 = 140737488355328L;
                    } else {
                        j10 = j | 268435456 | 4294967296L;
                        j11 = 70368744177664L;
                    }
                    j = j10 | j11;
                }
                strF2 = h46.f42049a.f(f2);
                if (hasLiked) {
                    drawable13 = AppCompatResources.getDrawable(this.h.getContext(), R.drawable.run_ic_ranking_like_gray);
                } else {
                    drawable13 = AppCompatResources.getDrawable(this.h.getContext(), R.drawable.run_ic_ranking_like_white);
                }
                if (!hasLiked) {
                    i12 = -1;
                }
                Context context5 = this.b.getContext();
                if (hasLiked) {
                    i6 = R.drawable.run_bg_ranking_top1_liked;
                } else {
                    i6 = R.drawable.run_bg_ranking_top1_like;
                }
                Drawable drawable17 = AppCompatResources.getDrawable(context5, i6);
                drawable11 = drawable13;
                i = i12;
                drawable12 = drawable17;
                j = j;
            } else {
                drawable6 = drawable6;
                strF2 = null;
                drawable11 = null;
                mediatorLiveDataB2 = null;
                drawable12 = null;
                i = 0;
                avatarUrl4 = null;
                value4 = null;
                name = null;
                likeCount4 = null;
                stageName = null;
            }
            if ((j & 11264) != 0) {
                if (sunshineRankingVM != null) {
                    mediatorLiveDataF = sunshineRankingVM.F();
                } else {
                    mediatorLiveDataF = null;
                }
                updateLiveDataRegistration(10, mediatorLiveDataF);
                if (mediatorLiveDataF != null) {
                    value7 = mediatorLiveDataF.getValue();
                } else {
                    value7 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                j = j;
            } else {
                zSafeUnbox = false;
            }
            mediatorLiveDataB = mediatorLiveDataB2;
            str4 = strF3;
            i3 = iSafeUnbox;
            drawable2 = drawable12;
            str2 = avatarUrl4;
            str3 = value6;
            str = likeCount4;
            mediatorLiveData = mediatorLiveDataC;
            drawable3 = drawable11;
            i2 = rankNumber;
        } else {
            i = 0;
            i2 = 0;
            str = null;
            drawable = null;
            str2 = null;
            drawable2 = null;
            drawable3 = null;
            stageName = null;
            drawable4 = null;
            drawable5 = null;
            z = false;
            value = null;
            mediatorLiveDataB = null;
            mediatorLiveData = null;
            i3 = 0;
            str3 = null;
            zSafeUnbox = false;
            drawable6 = null;
            strF = null;
            drawable7 = null;
            str4 = null;
            drawable8 = null;
            drawable9 = null;
            value2 = null;
            name = null;
            mediatorLiveDataD = null;
            strF2 = null;
            mediatorLiveDataS = null;
            z2 = false;
            value3 = null;
            value4 = null;
            i4 = 0;
            z3 = false;
            stageName2 = null;
            likeCount = null;
            name2 = null;
            avatarUrl = null;
            drawable10 = null;
            stageName3 = null;
            name3 = null;
            likeCount2 = null;
            avatarUrl2 = null;
            i5 = 0;
            likeCount3 = null;
            name4 = null;
            avatarUrl3 = null;
        }
        long j24 = j & 12288;
        if (j24 == 0 || aVar2 == null) {
            cVar = null;
            aVar = null;
            eVarA = null;
            fVar = null;
            dVar = null;
            bVar = null;
        } else {
            f fVar2 = this.f11905a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f11905a = fVar2;
            }
            f fVarA = fVar2.a(aVar2);
            a aVar3 = this.f11900a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f11900a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f11901a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f11901a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f11902a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f11902a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar2 = this.f11903a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f11903a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            e eVar = this.f11904a;
            if (eVar == null) {
                eVar = new e();
                this.f11904a = eVar;
            }
            eVarA = eVar.a(aVar2);
            fVar = fVarA;
            aVar = aVarA;
            bVar = bVarA;
            cVar = cVarA;
            dVar = dVarA;
        }
        RequestOptions requestOptions = (j & 10776) != 0 ? ju3.f42674a : null;
        if ((j & FileUtils.ONE_GB) != 0) {
            str5 = "" + i2;
        } else {
            str5 = null;
        }
        if ((3145728 & j) != 0) {
            MediatorLiveData<RankItemData> mediatorLiveDataC2 = sunshineRankingVM != null ? sunshineRankingVM.C() : mediatorLiveData;
            updateLiveDataRegistration(3, mediatorLiveDataC2);
            if (mediatorLiveDataC2 != null) {
                value = mediatorLiveDataC2.getValue();
            }
            if ((1048576 & j) != 0) {
                str19 = String.format("%skm", ll7.f43096a.g(Long.valueOf(value != null ? value.getDistance() : 0L)));
            } else {
                str5 = str5;
                str19 = null;
            }
            if ((2097152 & j) != 0) {
                long updateTime = value != null ? value.getUpdateTime() : 0L;
                str7 = str19;
                str6 = String.format("%s", fq1.a(updateTime, "MM/dd HH:mm"));
            } else {
                str7 = str19;
                str6 = null;
            }
        } else {
            str5 = str5;
            str = str;
            str6 = null;
            str7 = null;
        }
        if ((52776558133248L & j) != 0) {
            if (sunshineRankingVM != null) {
                mediatorLiveDataD = sunshineRankingVM.D();
            }
            MediatorLiveData<RankItemData> mediatorLiveData2 = mediatorLiveDataD;
            updateLiveDataRegistration(4, mediatorLiveData2);
            if (mediatorLiveData2 != null) {
                value2 = mediatorLiveData2.getValue();
            }
            if ((17592186044416L & j) != 0) {
                str18 = String.format("%skm", ll7.f43096a.g(Long.valueOf(value2 != null ? value2.getDistance() : 0L)));
            } else {
                str18 = null;
            }
            if ((35184372088832L & j) != 0) {
                str9 = str18;
                str8 = String.format("%s", fq1.a(value2 != null ? value2.getUpdateTime() : 0L, "MM/dd HH:mm"));
            } else {
                str9 = str18;
                str8 = null;
            }
        } else {
            str6 = str6;
            str8 = null;
            str9 = null;
        }
        if ((j & FileUtils.ONE_TB) == 0) {
            stageName4 = null;
        } else {
            if (sunshineRankingVM != null) {
                mediatorLiveDataS = sunshineRankingVM.s();
            }
            MediatorLiveData<RankItemData> mediatorLiveData3 = mediatorLiveDataS;
            updateLiveDataRegistration(5, mediatorLiveData3);
            if (mediatorLiveData3 != null) {
                value3 = mediatorLiveData3.getValue();
            }
            if (value3 != null) {
                stageName4 = value3.getStageName();
            } else {
                stageName4 = null;
            }
        }
        if ((2199023255552L & j) == 0) {
            value5 = null;
        } else {
            MediatorLiveData<String> mediatorLiveDataU = sunshineRankingVM != null ? sunshineRankingVM.u() : null;
            updateLiveDataRegistration(7, mediatorLiveDataU);
            if (mediatorLiveDataU != null) {
                value5 = mediatorLiveDataU.getValue();
            } else {
                value5 = null;
            }
        }
        if ((j & 13194139533312L) != 0) {
            if (sunshineRankingVM != null) {
                mediatorLiveDataB = sunshineRankingVM.B();
            }
            MediatorLiveData<RankItemData> mediatorLiveData4 = mediatorLiveDataB;
            updateLiveDataRegistration(9, mediatorLiveData4);
            if (mediatorLiveData4 != null) {
                value4 = mediatorLiveData4.getValue();
            }
            if ((j & 4398046511104L) != 0) {
                str10 = String.format("%skm", ll7.f43096a.g(Long.valueOf(value4 != null ? value4.getDistance() : 0L)));
            } else {
                str10 = null;
            }
            if ((8796093022208L & j) != 0) {
                str11 = String.format("%s", fq1.a(value4 != null ? value4.getUpdateTime() : 0L, "MM/dd HH:mm"));
            }
            j2 = j & 10250;
            if (j2 != 0) {
                if (!z) {
                    str6 = str7;
                }
                str12 = str6;
            } else {
                str12 = null;
            }
            j3 = j & 10272;
            if (j3 != 0) {
                if (z2) {
                    str17 = "未上榜";
                } else {
                    str17 = str5;
                }
                str13 = str17;
            } else {
                str13 = null;
            }
            j4 = j & 10402;
            if (j4 != 0) {
                if (z) {
                    stageName4 = value5;
                }
                str14 = stageName4;
            } else {
                str14 = null;
            }
            j5 = j & 10754;
            if (j5 != 0) {
                if (z) {
                    str10 = str11;
                }
                str15 = str10;
            } else {
                str15 = null;
            }
            j6 = j & 10258;
            if (j6 != 0) {
                if (z) {
                    str9 = str8;
                }
                str16 = str9;
            } else {
                str16 = null;
            }
            if ((j & 10241) != 0) {
                ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).b, drawable);
                ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).c, drawable5);
                ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).d, drawable4);
            }
            if ((10752 & j) != 0) {
                CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).b, str2, requestOptions, false);
                ViewBindingAdapter.setBackground(this.b, drawable2);
                ImageViewBindingAdapter.setImageDrawable(this.h, drawable3);
                TextViewBindingAdapter.setText(this.n, str);
                this.n.setTextColor(i);
                TextViewBindingAdapter.setText(this.s, stageName);
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11879a, strF2);
                TextViewBindingAdapter.setText(super.h, name);
            }
            if (j24 != 0) {
                c cVar3 = cVar;
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).b, cVar3, null);
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).c, cVar3, null);
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).d, cVar3, null);
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11882a, cVar3, null);
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11885a, aVar, null);
                CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11895e, eVarA, null);
                CommonBindingAdapter.q(this.b, fVar, null);
                CommonBindingAdapter.q(this.c, dVar, null);
                CommonBindingAdapter.q(this.d, bVar, null);
            }
            if ((j & 10248) != 0) {
                CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).c, avatarUrl, requestOptions, false);
                ViewBindingAdapter.setBackground(this.c, drawable9);
                ImageViewBindingAdapter.setImageDrawable(this.i, drawable8);
                TextViewBindingAdapter.setText(this.o, likeCount);
                this.o.setTextColor(i4);
                TextViewBindingAdapter.setText(this.u, stageName2);
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11886b, str4);
                TextViewBindingAdapter.setText(super.i, name2);
            }
            if ((j & 10256) != 0) {
                CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).d, avatarUrl2, requestOptions, false);
                TextViewBindingAdapter.setText(this.l, stageName3);
                ViewBindingAdapter.setBackground(this.d, drawable7);
                ImageViewBindingAdapter.setImageDrawable(this.j, drawable10);
                TextViewBindingAdapter.setText(this.p, likeCount2);
                this.p.setTextColor(i5);
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11889c, strF);
                TextViewBindingAdapter.setText(super.j, name3);
            }
            if ((10496 & j) != 0) {
                ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).f11882a, drawable6);
            }
            if (j3 != 0) {
                aw9.d(((RunHeadSunshineRankBinding) this).f11882a, avatarUrl3, false, null);
                TextViewBindingAdapter.setText(this.q, str13);
                TextViewBindingAdapter.setText(this.r, likeCount3);
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11896f, name4);
            }
            if ((j & 10242) != 0) {
                boolean z6 = z3;
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11888b, z6);
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11891c, z6);
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11893d, z6);
                CommonBindingAdapter.i(((RunHeadSunshineRankBinding) this).f11895e, z6);
                CommonBindingAdapter.l0(this.k, z6);
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11879a, z);
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11886b, z);
                CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11889c, z);
            }
            if (j2 != 0) {
                TextViewBindingAdapter.setText(this.f11907k, str12);
            }
            if (j6 != 0) {
                TextViewBindingAdapter.setText(this.m, str16);
            }
            if ((11264 & j) != 0) {
                CommonBindingAdapter.l0(this.e, zSafeUnbox);
            }
            if (j5 != 0) {
                TextViewBindingAdapter.setText(this.t, str15);
            }
            if ((10304 & j) != 0) {
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11894e, str3);
            }
            if (j4 != 0) {
                TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11897g, str14);
            }
            if ((j & 10244) != 0) {
                CommonBindingAdapter.G(((RunHeadSunshineRankBinding) this).f35596a, i3);
            }
        }
        str8 = str8;
        stageName4 = stageName4;
        str10 = null;
        str11 = null;
        j2 = j & 10250;
        if (j2 != 0) {
            if (!z) {
                str6 = str7;
            }
            str12 = str6;
        } else {
            str12 = null;
        }
        j3 = j & 10272;
        if (j3 != 0) {
            if (z2) {
                str17 = "未上榜";
            } else {
                str17 = str5;
            }
            str13 = str17;
        } else {
            str13 = null;
        }
        j4 = j & 10402;
        if (j4 != 0) {
            if (z) {
                stageName4 = value5;
            }
            str14 = stageName4;
        } else {
            str14 = null;
        }
        j5 = j & 10754;
        if (j5 != 0) {
            if (z) {
                str10 = str11;
            }
            str15 = str10;
        } else {
            str15 = null;
        }
        j6 = j & 10258;
        if (j6 != 0) {
            if (z) {
                str9 = str8;
            }
            str16 = str9;
        } else {
            str16 = null;
        }
        if ((j & 10241) != 0) {
            ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).b, drawable);
            ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).c, drawable5);
            ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).d, drawable4);
        }
        if ((10752 & j) != 0) {
            CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).b, str2, requestOptions, false);
            ViewBindingAdapter.setBackground(this.b, drawable2);
            ImageViewBindingAdapter.setImageDrawable(this.h, drawable3);
            TextViewBindingAdapter.setText(this.n, str);
            this.n.setTextColor(i);
            TextViewBindingAdapter.setText(this.s, stageName);
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11879a, strF2);
            TextViewBindingAdapter.setText(super.h, name);
        }
        if (j24 != 0) {
            c cVar4 = cVar;
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).b, cVar4, null);
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).c, cVar4, null);
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).d, cVar4, null);
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11882a, cVar4, null);
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11885a, aVar, null);
            CommonBindingAdapter.q(((RunHeadSunshineRankBinding) this).f11895e, eVarA, null);
            CommonBindingAdapter.q(this.b, fVar, null);
            CommonBindingAdapter.q(this.c, dVar, null);
            CommonBindingAdapter.q(this.d, bVar, null);
        }
        if ((j & 10248) != 0) {
            CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).c, avatarUrl, requestOptions, false);
            ViewBindingAdapter.setBackground(this.c, drawable9);
            ImageViewBindingAdapter.setImageDrawable(this.i, drawable8);
            TextViewBindingAdapter.setText(this.o, likeCount);
            this.o.setTextColor(i4);
            TextViewBindingAdapter.setText(this.u, stageName2);
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11886b, str4);
            TextViewBindingAdapter.setText(super.i, name2);
        }
        if ((j & 10256) != 0) {
            CommonBindingAdapter.b0(((RunHeadSunshineRankBinding) this).d, avatarUrl2, requestOptions, false);
            TextViewBindingAdapter.setText(this.l, stageName3);
            ViewBindingAdapter.setBackground(this.d, drawable7);
            ImageViewBindingAdapter.setImageDrawable(this.j, drawable10);
            TextViewBindingAdapter.setText(this.p, likeCount2);
            this.p.setTextColor(i5);
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11889c, strF);
            TextViewBindingAdapter.setText(super.j, name3);
        }
        if ((10496 & j) != 0) {
            ViewBindingAdapter.setBackground(((RunHeadSunshineRankBinding) this).f11882a, drawable6);
        }
        if (j3 != 0) {
            aw9.d(((RunHeadSunshineRankBinding) this).f11882a, avatarUrl3, false, null);
            TextViewBindingAdapter.setText(this.q, str13);
            TextViewBindingAdapter.setText(this.r, likeCount3);
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11896f, name4);
        }
        if ((j & 10242) != 0) {
            boolean z7 = z3;
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11888b, z7);
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11891c, z7);
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11893d, z7);
            CommonBindingAdapter.i(((RunHeadSunshineRankBinding) this).f11895e, z7);
            CommonBindingAdapter.l0(this.k, z7);
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11879a, z);
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11886b, z);
            CommonBindingAdapter.l0(((RunHeadSunshineRankBinding) this).f11889c, z);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f11907k, str12);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.m, str16);
        }
        if ((11264 & j) != 0) {
            CommonBindingAdapter.l0(this.e, zSafeUnbox);
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(this.t, str15);
        }
        if ((10304 & j) != 0) {
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11894e, str3);
        }
        if (j4 != 0) {
            TextViewBindingAdapter.setText(((RunHeadSunshineRankBinding) this).f11897g, str14);
        }
        if ((j & 10244) != 0) {
            CommonBindingAdapter.G(((RunHeadSunshineRankBinding) this).f35596a, i3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11899a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11899a = 8192L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunHeadSunshineRankBinding
    public void l(@Nullable SunshineRankingFragment.a Click) {
        ((RunHeadSunshineRankBinding) this).f11883a = Click;
        synchronized (this) {
            this.f11899a |= 4096;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunHeadSunshineRankBinding
    public void m(@Nullable SunshineRankingVM Vm) {
        ((RunHeadSunshineRankBinding) this).f11884a = Vm;
        synchronized (this) {
            this.f11899a |= 2048;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MediatorLiveData<Boolean> VmIsShowMyRank, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 1024;
        }
        return true;
    }

    public final boolean o(MediatorLiveData<String> VmMyDistance, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return t((MutableLiveData) object, fieldId);
            case 1:
                return s((MutableLiveData) object, fieldId);
            case 2:
                return u((MutableLiveData) object, fieldId);
            case 3:
                return w((MediatorLiveData) object, fieldId);
            case 4:
                return x((MediatorLiveData) object, fieldId);
            case 5:
                return p((MediatorLiveData) object, fieldId);
            case 6:
                return o((MediatorLiveData) object, fieldId);
            case 7:
                return r((MediatorLiveData) object, fieldId);
            case 8:
                return q((MutableLiveData) object, fieldId);
            case 9:
                return v((MediatorLiveData) object, fieldId);
            case 10:
                return n((MediatorLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MediatorLiveData<RankItemData> VmMyRank, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 32;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> VmMySex, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 256;
        }
        return true;
    }

    public final boolean r(MediatorLiveData<String> VmMyUpdateMs, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 128;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> VmRankingListType, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRankingVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRankingFragment.a) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Integer> VmRankingType, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 1;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> VmStatusBarHeightPx, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 4;
        }
        return true;
    }

    public final boolean v(MediatorLiveData<RankItemData> VmTop1, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 512;
        }
        return true;
    }

    public final boolean w(MediatorLiveData<RankItemData> VmTop2, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 8;
        }
        return true;
    }

    public final boolean x(MediatorLiveData<RankItemData> VmTop3, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11899a |= 16;
        }
        return true;
    }

    public RunHeadSunshineRankBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 11, (ConstraintLayout) bindings[42], (ConstraintLayout) bindings[44], (ConstraintLayout) bindings[46], (ImageView) bindings[39], (ImageView) bindings[16], (ImageView) bindings[21], (ImageView) bindings[26], (AvatarView) bindings[32], (BLLinearLayout) bindings[33], (BLLinearLayout) bindings[3], (BLLinearLayout) bindings[7], (BLLinearLayout) bindings[11], (BLLinearLayout) bindings[2], (LinearLayout) bindings[48], (ImageView) bindings[43], (ImageView) bindings[45], (ImageView) bindings[41], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[13], (SegmentTabLayout) bindings[40], (TextView) bindings[47], (TextView) bindings[35], (TextView) bindings[36], (TextView) bindings[38], (TextView) bindings[15], (TextView) bindings[20], (TextView) bindings[25], (View) bindings[1]);
        this.f11899a = -1L;
        ((RunHeadSunshineRankBinding) this).b.setTag(null);
        ((RunHeadSunshineRankBinding) this).c.setTag(null);
        ((RunHeadSunshineRankBinding) this).d.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11882a.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11885a.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11888b.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11891c.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11893d.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11895e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11906d = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.f11907k = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[12];
        this.l = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.m = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[17];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[18];
        this.h = imageView;
        imageView.setTag(null);
        TextView textView4 = (TextView) bindings[19];
        this.n = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[22];
        this.c = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView2 = (ImageView) bindings[23];
        this.i = imageView2;
        imageView2.setTag(null);
        TextView textView5 = (TextView) bindings[24];
        this.o = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[27];
        this.d = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView3 = (ImageView) bindings[28];
        this.j = imageView3;
        imageView3.setTag(null);
        TextView textView6 = (TextView) bindings[29];
        this.p = textView6;
        textView6.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) bindings[30];
        this.e = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView7 = (TextView) bindings[31];
        this.q = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) bindings[34];
        this.r = textView8;
        textView8.setTag(null);
        ImageView imageView4 = (ImageView) bindings[37];
        this.k = imageView4;
        imageView4.setTag(null);
        TextView textView9 = (TextView) bindings[4];
        this.s = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) bindings[6];
        this.t = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) bindings[8];
        this.u = textView11;
        textView11.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11879a.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11886b.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11889c.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11894e.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11896f.setTag(null);
        ((RunHeadSunshineRankBinding) this).f11897g.setTag(null);
        super.h.setTag(null);
        super.i.setTag(null);
        super.j.setTag(null);
        ((RunHeadSunshineRankBinding) this).f35596a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
