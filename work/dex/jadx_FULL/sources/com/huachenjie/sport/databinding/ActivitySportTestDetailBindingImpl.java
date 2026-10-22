package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.bean.SportTestDetailBean;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySportTestDetailBindingImpl extends ActivitySportTestDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13350a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13351b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13352c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13353d;

    @NonNull
    public final TextView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13354e;

    @NonNull
    public final TextView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13355f;

    @NonNull
    public final TextView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13356g;

    @NonNull
    public final TextView h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13357h;

    @NonNull
    public final TextView i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13358i;

    @NonNull
    public final TextView j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13359j;

    @NonNull
    public final TextView k;

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

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestDetailActivity.a f36430a;

        public a a(SportTestDetailActivity.a aVar) {
            this.f36430a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36430a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestDetailActivity.a f36431a;

        public b a(SportTestDetailActivity.a aVar) {
            this.f36431a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36431a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestDetailActivity.a f36432a;

        public c a(SportTestDetailActivity.a aVar) {
            this.f36432a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36432a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestDetailActivity.a f36433a;

        public d a(SportTestDetailActivity.a aVar) {
            this.f36433a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36433a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(31);
        f13341a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{28}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36429a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.ll_group_class, 29);
        sparseIntArray.put(com.huachenjie.sport.R.id.ll_group_sign, 30);
    }

    public ActivitySportTestDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 31, f13341a, f36429a));
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0232 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0234  */
    /* JADX WARN: Code duplicated, block: B:117:0x023b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0244  */
    /* JADX WARN: Code duplicated, block: B:121:0x024b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0258 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x025a  */
    /* JADX WARN: Code duplicated, block: B:127:0x025f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0266  */
    /* JADX WARN: Code duplicated, block: B:131:0x028c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:172:0x038c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:174:0x038f  */
    /* JADX WARN: Code duplicated, block: B:177:0x0394  */
    /* JADX WARN: Code duplicated, block: B:180:0x0399  */
    /* JADX WARN: Code duplicated, block: B:182:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:184:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:187:0x0668  */
    /* JADX WARN: Code duplicated, block: B:190:0x0677  */
    /* JADX WARN: Code duplicated, block: B:192:0x12af  */
    /* JADX WARN: Code duplicated, block: B:195:0x12d4  */
    /* JADX WARN: Code duplicated, block: B:198:0x12eb  */
    /* JADX WARN: Code duplicated, block: B:201:0x12fa  */
    /* JADX WARN: Code duplicated, block: B:204:0x1309  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String testProjectNames;
        String str3;
        int i;
        String str4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        SportTestDetailBean sportTestDetailBean;
        BindingTitleBean bindingTitleBean;
        boolean z6;
        int i3;
        boolean hasInformedConsent;
        String str5;
        int i4;
        Integer value;
        String value2;
        String str6;
        String reserveDate;
        String title;
        String fitnessTestDate;
        String reserveNumber;
        String reservePeriods;
        c cVarA;
        d dVar;
        a aVar;
        b bVar;
        boolean zSafeUnbox;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String value3;
        int iSafeUnbox;
        int i5;
        boolean z11;
        boolean z12;
        long j2;
        String teacherNames;
        String location;
        boolean z13;
        String remark;
        MutableLiveData<Integer> mutableLiveDataJ;
        MutableLiveData<BindingTitleBean> mutableLiveDataM;
        MediatorLiveData<String> mediatorLiveDataK;
        int i6;
        String reservePeriod;
        Boolean canBeModified;
        Integer reserveTimeStatus;
        Integer fitnessType;
        Integer fitnessTestStatus;
        boolean z14;
        boolean z15;
        long j3;
        long j4;
        long j5;
        long j6;
        synchronized (this) {
            j = this.f13342a;
            this.f13342a = 0L;
        }
        SportTestDetailVM sportTestDetailVM = ((ActivitySportTestDetailBinding) this).f13340a;
        SportTestDetailActivity.a aVar2 = ((ActivitySportTestDetailBinding) this).f13339a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value3 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataL = sportTestDetailVM != null ? sportTestDetailVM.l() : null;
                updateLiveDataRegistration(0, mediatorLiveDataL);
                if (mediatorLiveDataL != null) {
                    value3 = mediatorLiveDataL.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 322) != 0) {
                MutableLiveData<Integer> mutableLiveData = sportTestDetailVM != null ? ((BaseVM) sportTestDetailVM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j7 = j & 324;
            if (j7 != 0) {
                MutableLiveData<SportTestDetailBean> mutableLiveDataH = sportTestDetailVM != null ? sportTestDetailVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                SportTestDetailBean value4 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                if (value4 != null) {
                    reservePeriod = value4.getReservePeriod();
                    teacherNames = value4.getTeacherNames();
                    location = value4.getLocation();
                    canBeModified = value4.getCanBeModified();
                    testProjectNames = value4.getTestProjectNames();
                    reserveDate = value4.getReserveDate();
                    reserveTimeStatus = value4.getReserveTimeStatus();
                    hasInformedConsent = value4.getHasInformedConsent();
                    title = value4.getTitle();
                    fitnessType = value4.getFitnessType();
                    fitnessTestDate = value4.getFitnessTestDate();
                    reserveNumber = value4.getReserveNumber();
                    remark = value4.getRemark();
                    fitnessTestStatus = value4.getFitnessTestStatus();
                    reservePeriods = value4.getReservePeriods();
                } else {
                    reservePeriod = null;
                    teacherNames = null;
                    location = null;
                    canBeModified = null;
                    testProjectNames = null;
                    reserveDate = null;
                    reserveTimeStatus = null;
                    hasInformedConsent = false;
                    title = null;
                    fitnessType = null;
                    fitnessTestDate = null;
                    reserveNumber = null;
                    remark = null;
                    fitnessTestStatus = null;
                    reservePeriods = null;
                }
                if (j7 != 0) {
                    j = hasInformedConsent ? j | 16777216 : j | 8388608;
                }
                String str7 = "时间：" + reservePeriod;
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(canBeModified);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(reserveTimeStatus);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(fitnessType);
                boolean zIsEmpty = TextUtils.isEmpty(remark);
                int iSafeUnbox4 = ViewDataBinding.safeUnbox(fitnessTestStatus);
                boolean z16 = iSafeUnbox2 == 3;
                z5 = iSafeUnbox2 != 3;
                if (iSafeUnbox2 == 2) {
                    z14 = true;
                    z15 = true;
                } else {
                    z14 = true;
                    z15 = false;
                }
                z13 = iSafeUnbox3 == z14 ? z14 : false;
                boolean z17 = iSafeUnbox3 == 2 ? z14 : false;
                boolean z18 = zIsEmpty ^ z14;
                boolean z19 = iSafeUnbox4 != 3 ? z14 : false;
                if ((j & 324) != 0) {
                    j |= z16 ? 262144L : 131072L;
                }
                if ((j & 324) != 0) {
                    if (z15) {
                        j5 = j | 1024 | PlaybackStateCompat.ACTION_PREPARE;
                        j6 = PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    } else {
                        j5 = j | 512 | 8192;
                        j6 = 2097152;
                    }
                    j = j5 | j6;
                }
                if ((j & 324) != 0) {
                    if (z17) {
                        j3 = j | 4096;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j3 = j | 2048;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                    j = j3 | j4;
                }
                if ((j & 324) != 0) {
                    j |= z19 ? 1048576L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                String str8 = z16 ? "预约已结束" : "立即预约体测";
                int colorFromResource = z15 ? ViewDataBinding.getColorFromResource(this.f13355f, com.huachenjie.sport.R.color.color_main_v2) : ViewDataBinding.getColorFromResource(this.f13355f, com.huachenjie.sport.R.color.color_D7D7D7);
                int colorFromResource2 = z15 ? ViewDataBinding.getColorFromResource(this.h, com.huachenjie.sport.R.color.white) : ViewDataBinding.getColorFromResource(this.h, com.huachenjie.sport.R.color.color_999999);
                int colorFromResource3 = ViewDataBinding.getColorFromResource(this.g, z15 ? com.huachenjie.sport.R.color.white : com.huachenjie.sport.R.color.color_333333);
                sportTestDetailBean = value4;
                str = str8;
                j2 = 328;
                z12 = zSafeUnbox2;
                i2 = colorFromResource;
                z3 = z19;
                str5 = str7;
                z11 = z17;
                z2 = z18;
                i4 = colorFromResource2;
                i5 = colorFromResource3;
                j = j;
            } else {
                i4 = 0;
                i5 = 0;
                z11 = false;
                z2 = false;
                z3 = false;
                str5 = null;
                z12 = false;
                i2 = 0;
                sportTestDetailBean = null;
                str = null;
                j2 = 328;
                teacherNames = null;
                location = null;
                testProjectNames = null;
                reserveDate = null;
                z5 = false;
                hasInformedConsent = false;
                title = null;
                z13 = false;
                fitnessTestDate = null;
                reserveNumber = null;
                remark = null;
                reservePeriods = null;
            }
            if ((j & j2) != 0) {
                if (sportTestDetailVM != null) {
                    i6 = 3;
                    mediatorLiveDataK = sportTestDetailVM.k();
                } else {
                    mediatorLiveDataK = null;
                    i6 = 3;
                }
                updateLiveDataRegistration(i6, mediatorLiveDataK);
                value2 = mediatorLiveDataK != null ? mediatorLiveDataK.getValue() : null;
                if ((j & 336) != 0) {
                    if (sportTestDetailVM != null) {
                        mutableLiveDataM = sportTestDetailVM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataM);
                    BindingTitleBean value5 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                    if ((j & 352) == 0) {
                        value = null;
                    } else {
                        if (sportTestDetailVM != null) {
                            mutableLiveDataJ = sportTestDetailVM.j();
                        } else {
                            mutableLiveDataJ = null;
                        }
                        updateLiveDataRegistration(5, mutableLiveDataJ);
                        if (mutableLiveDataJ != null) {
                            value = mutableLiveDataJ.getValue();
                        } else {
                            value = null;
                        }
                    }
                    z = z11;
                    i = i5;
                    i3 = iSafeUnbox;
                    str4 = location;
                    z6 = z12;
                    z4 = z13;
                    str6 = value3;
                    str3 = teacherNames;
                    bindingTitleBean = value5;
                    str2 = remark;
                } else {
                    value2 = value2;
                }
                if ((j & 352) == 0) {
                    value = null;
                } else {
                    if (sportTestDetailVM != null) {
                        mutableLiveDataJ = sportTestDetailVM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                        value = mutableLiveDataJ.getValue();
                    } else {
                        value = null;
                    }
                }
                z = z11;
                i = i5;
                i3 = iSafeUnbox;
                str4 = location;
                z6 = z12;
                z4 = z13;
                str6 = value3;
                str3 = teacherNames;
                bindingTitleBean = value5;
                str2 = remark;
            } else {
                i4 = i4;
                i5 = i5;
            }
            if ((j & 336) != 0) {
                if (sportTestDetailVM != null) {
                    mutableLiveDataM = sportTestDetailVM.m();
                } else {
                    mutableLiveDataM = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                }
                if ((j & 352) == 0) {
                    value = null;
                } else {
                    if (sportTestDetailVM != null) {
                        mutableLiveDataJ = sportTestDetailVM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                        value = mutableLiveDataJ.getValue();
                    } else {
                        value = null;
                    }
                }
                z = z11;
                i = i5;
                i3 = iSafeUnbox;
                str4 = location;
                z6 = z12;
                z4 = z13;
                str6 = value3;
                str3 = teacherNames;
                bindingTitleBean = value5;
                str2 = remark;
            } else {
                value2 = value2;
            }
            if ((j & 352) == 0) {
                value = null;
            } else {
                if (sportTestDetailVM != null) {
                    mutableLiveDataJ = sportTestDetailVM.j();
                } else {
                    mutableLiveDataJ = null;
                }
                updateLiveDataRegistration(5, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            z = z11;
            i = i5;
            i3 = iSafeUnbox;
            str4 = location;
            z6 = z12;
            z4 = z13;
            str6 = value3;
            str3 = teacherNames;
            bindingTitleBean = value5;
            str2 = remark;
        } else {
            str = null;
            str2 = null;
            testProjectNames = null;
            str3 = null;
            i = 0;
            str4 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i2 = 0;
            sportTestDetailBean = null;
            bindingTitleBean = null;
            z6 = false;
            i3 = 0;
            hasInformedConsent = false;
            str5 = null;
            i4 = 0;
            value = null;
            value2 = null;
            str6 = null;
            reserveDate = null;
            title = null;
            fitnessTestDate = null;
            reserveNumber = null;
            reservePeriods = null;
        }
        long j8 = j & 384;
        if (j8 == 0 || aVar2 == null) {
            cVarA = null;
            dVar = null;
            aVar = null;
            bVar = null;
        } else {
            d dVar2 = this.f13350a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f13350a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            a aVar3 = this.f13347a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f13347a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f13348a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f13348a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar = this.f13349a;
            if (cVar == null) {
                cVar = new c();
                this.f13349a = cVar;
            }
            cVarA = cVar.a(aVar2);
            dVar = dVarA;
            aVar = aVarA;
            bVar = bVarA;
        }
        boolean hasConsent = ((j & 16777216) == 0 || sportTestDetailBean == null) ? false : sportTestDetailBean.getHasConsent();
        long j9 = j & 324;
        boolean z20 = (j9 == 0 || !z3) ? false : z;
        if ((j & 69632) != 0) {
            zSafeUnbox = ViewDataBinding.safeUnbox(sportTestDetailBean != null ? sportTestDetailBean.getUserReserveStatus() : null);
            z7 = (j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0 ? !zSafeUnbox : false;
            if (j9 != 0) {
                if (!z) {
                    zSafeUnbox = false;
                }
                if (!z) {
                    z7 = false;
                }
                if (!hasInformedConsent) {
                    hasConsent = false;
                }
                z8 = zSafeUnbox;
                z9 = hasConsent;
                z10 = z7;
            } else {
                z8 = false;
                z9 = false;
                z10 = false;
            }
            if (j9 != 0) {
                TextViewBindingAdapter.setText(this.f13344a, str4);
                TextViewBindingAdapter.setText(this.b, str3);
                TextViewBindingAdapter.setText(this.c, testProjectNames);
                CommonBindingAdapter.l0(this.f13351b, z4);
                CommonBindingAdapter.l0(this.f13352c, z);
                CommonBindingAdapter.l0(this.f13353d, z2);
                TextViewBindingAdapter.setText(this.d, str2);
                CommonBindingAdapter.l0(this.e, z);
                CommonBindingAdapter.l0(this.f13354e, z10);
                DrawablesBindingAdapter.h(this.f13355f, 0, Integer.valueOf(i2), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                CommonBindingAdapter.l0(this.f, z9);
                TextViewBindingAdapter.setText(this.g, str);
                this.g.setTextColor(i);
                CommonBindingAdapter.l0(this.h, z5);
                this.h.setTextColor(i4);
                CommonBindingAdapter.l0(this.f13356g, z8);
                TextViewBindingAdapter.setText(this.i, reserveNumber);
                TextViewBindingAdapter.setText(this.j, str5);
                CommonBindingAdapter.l0(this.k, z6);
                TextViewBindingAdapter.setText(this.l, title);
                CommonBindingAdapter.l0(this.n, z20);
                CommonBindingAdapter.l0(this.o, z20);
                TextViewBindingAdapter.setText(this.o, reserveDate);
                TextViewBindingAdapter.setText(this.p, fitnessTestDate);
                TextViewBindingAdapter.setText(this.q, reservePeriods);
            }
            if ((j & 336) != 0) {
                this.f13346a.k(bindingTitleBean);
            }
            if ((j & 256) != 0) {
                LinearLayoutCompat linearLayoutCompat = this.f13351b;
                int i7 = com.huachenjie.sport.R.color.white;
                DrawablesBindingAdapter.h(linearLayoutCompat, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat, i7)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                LinearLayoutCompat linearLayoutCompat2 = this.f13352c;
                DrawablesBindingAdapter.h(linearLayoutCompat2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat2, i7)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                LinearLayoutCompat linearLayoutCompat3 = this.f13353d;
                DrawablesBindingAdapter.h(linearLayoutCompat3, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat3, i7)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                LinearLayoutCompat linearLayoutCompat4 = this.f13357h;
                DrawablesBindingAdapter.h(linearLayoutCompat4, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat4, com.huachenjie.sport.R.color.color_EFF3FC)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                LinearLayoutCompat linearLayoutCompat5 = this.f13359j;
                DrawablesBindingAdapter.h(linearLayoutCompat5, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat5, i7)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            }
            if (j8 != 0) {
                CommonBindingAdapter.q(this.e, cVarA, null);
                CommonBindingAdapter.q(this.f13355f, dVar, null);
                CommonBindingAdapter.q(this.f, aVar, null);
                CommonBindingAdapter.q(this.f13358i, bVar, null);
            }
            if ((j & 322) != 0) {
                CommonBindingAdapter.I(this.f, 0, i3, 0, 0, null);
            }
            if ((j & 321) != 0) {
                TextViewBindingAdapter.setText(this.h, str6);
            }
            if ((j & 328) != 0) {
                TextViewBindingAdapter.setText(this.m, value2);
            }
            if ((j & 352) != 0) {
                CommonBindingAdapter.V(this.m, value);
            }
            ViewDataBinding.executeBindingsOn(this.f13346a);
        }
        zSafeUnbox = false;
        if (j9 != 0) {
            if (!z) {
                zSafeUnbox = false;
            }
            if (!z) {
                z7 = false;
            }
            if (!hasInformedConsent) {
                hasConsent = false;
            }
            z8 = zSafeUnbox;
            z9 = hasConsent;
            z10 = z7;
        } else {
            z8 = false;
            z9 = false;
            z10 = false;
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setText(this.f13344a, str4);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(this.c, testProjectNames);
            CommonBindingAdapter.l0(this.f13351b, z4);
            CommonBindingAdapter.l0(this.f13352c, z);
            CommonBindingAdapter.l0(this.f13353d, z2);
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.e, z);
            CommonBindingAdapter.l0(this.f13354e, z10);
            DrawablesBindingAdapter.h(this.f13355f, 0, Integer.valueOf(i2), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.l0(this.f, z9);
            TextViewBindingAdapter.setText(this.g, str);
            this.g.setTextColor(i);
            CommonBindingAdapter.l0(this.h, z5);
            this.h.setTextColor(i4);
            CommonBindingAdapter.l0(this.f13356g, z8);
            TextViewBindingAdapter.setText(this.i, reserveNumber);
            TextViewBindingAdapter.setText(this.j, str5);
            CommonBindingAdapter.l0(this.k, z6);
            TextViewBindingAdapter.setText(this.l, title);
            CommonBindingAdapter.l0(this.n, z20);
            CommonBindingAdapter.l0(this.o, z20);
            TextViewBindingAdapter.setText(this.o, reserveDate);
            TextViewBindingAdapter.setText(this.p, fitnessTestDate);
            TextViewBindingAdapter.setText(this.q, reservePeriods);
        }
        if ((j & 336) != 0) {
            this.f13346a.k(bindingTitleBean);
        }
        if ((j & 256) != 0) {
            LinearLayoutCompat linearLayoutCompat6 = this.f13351b;
            int i8 = com.huachenjie.sport.R.color.white;
            DrawablesBindingAdapter.h(linearLayoutCompat6, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat6, i8)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat7 = this.f13352c;
            DrawablesBindingAdapter.h(linearLayoutCompat7, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat7, i8)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat8 = this.f13353d;
            DrawablesBindingAdapter.h(linearLayoutCompat8, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat8, i8)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat9 = this.f13357h;
            DrawablesBindingAdapter.h(linearLayoutCompat9, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat9, com.huachenjie.sport.R.color.color_EFF3FC)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat10 = this.f13359j;
            DrawablesBindingAdapter.h(linearLayoutCompat10, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat10, i8)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j8 != 0) {
            CommonBindingAdapter.q(this.e, cVarA, null);
            CommonBindingAdapter.q(this.f13355f, dVar, null);
            CommonBindingAdapter.q(this.f, aVar, null);
            CommonBindingAdapter.q(this.f13358i, bVar, null);
        }
        if ((j & 322) != 0) {
            CommonBindingAdapter.I(this.f, 0, i3, 0, 0, null);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.h, str6);
        }
        if ((j & 328) != 0) {
            TextViewBindingAdapter.setText(this.m, value2);
        }
        if ((j & 352) != 0) {
            CommonBindingAdapter.V(this.m, value);
        }
        ViewDataBinding.executeBindingsOn(this.f13346a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13342a != 0) {
                return true;
            }
            return this.f13346a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13342a = 256L;
        }
        this.f13346a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestDetailBinding
    public void l(@Nullable SportTestDetailActivity.a aVar) {
        ((ActivitySportTestDetailBinding) this).f13339a = aVar;
        synchronized (this) {
            this.f13342a |= 128;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestDetailBinding
    public void m(@Nullable SportTestDetailVM sportTestDetailVM) {
        ((ActivitySportTestDetailBinding) this).f13340a = sportTestDetailVM;
        synchronized (this) {
            this.f13342a |= 64;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SportTestDetailBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MediatorLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MediatorLiveData) obj, i2);
        }
        if (i == 4) {
            return s((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 32;
        }
        return true;
    }

    public final boolean q(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 8;
        }
        return true;
    }

    public final boolean r(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13342a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13346a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((SportTestDetailVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((SportTestDetailActivity.a) obj);
        }
        return true;
    }

    public ActivitySportTestDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (LinearLayout) objArr[29], (LinearLayout) objArr[30]);
        this.f13342a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13345a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.f13343a = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.f13344a = textView;
        textView.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[28];
        this.f13346a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        TextView textView2 = (TextView) objArr[11];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[12];
        this.c = textView3;
        textView3.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) objArr[13];
        this.f13351b = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) objArr[14];
        this.f13352c = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) objArr[15];
        this.f13353d = linearLayoutCompat4;
        linearLayoutCompat4.setTag(null);
        TextView textView4 = (TextView) objArr[16];
        this.d = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[17];
        this.e = textView5;
        textView5.setTag(null);
        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) objArr[18];
        this.f13354e = linearLayoutCompat5;
        linearLayoutCompat5.setTag(null);
        LinearLayoutCompat linearLayoutCompat6 = (LinearLayoutCompat) objArr[19];
        this.f13355f = linearLayoutCompat6;
        linearLayoutCompat6.setTag(null);
        TextView textView6 = (TextView) objArr[2];
        this.f = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[20];
        this.g = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[21];
        this.h = textView8;
        textView8.setTag(null);
        LinearLayoutCompat linearLayoutCompat7 = (LinearLayoutCompat) objArr[22];
        this.f13356g = linearLayoutCompat7;
        linearLayoutCompat7.setTag(null);
        LinearLayoutCompat linearLayoutCompat8 = (LinearLayoutCompat) objArr[23];
        this.f13357h = linearLayoutCompat8;
        linearLayoutCompat8.setTag(null);
        TextView textView9 = (TextView) objArr[24];
        this.i = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[25];
        this.j = textView10;
        textView10.setTag(null);
        LinearLayoutCompat linearLayoutCompat9 = (LinearLayoutCompat) objArr[26];
        this.f13358i = linearLayoutCompat9;
        linearLayoutCompat9.setTag(null);
        TextView textView11 = (TextView) objArr[27];
        this.k = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[3];
        this.l = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[4];
        this.m = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[5];
        this.n = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[6];
        this.o = textView15;
        textView15.setTag(null);
        LinearLayoutCompat linearLayoutCompat10 = (LinearLayoutCompat) objArr[7];
        this.f13359j = linearLayoutCompat10;
        linearLayoutCompat10.setTag(null);
        TextView textView16 = (TextView) objArr[8];
        this.p = textView16;
        textView16.setTag(null);
        TextView textView17 = (TextView) objArr[9];
        this.q = textView17;
        textView17.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
