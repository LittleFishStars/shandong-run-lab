package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.sport.bean.HuodongDetail;
import com.huachenjie.sport.bean.HuodongDetailBean;
import com.huachenjie.sport.page.mine.huodong.HuodongDetailActivity;
import com.huachenjie.sport.page.mine.huodong.HuodongDetailVM;
import com.huachenjie.sport.widget.HuodongSignButton;
import com.huachenjie.sport.widget.HuodongStatusWidget;
import com.huachenjie.sport.widget.ProgressBarView;
import com.noober.background.view.BLTextView;
import com.zj.adlib.n34;
import com.zj.adlib.ok0;
import com.zj.adlib.q34;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityHuodongDetailBindingImpl extends ActivityHuodongDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13280a;

    @NonNull
    public final View b;

    @NonNull
    public final View c;

    @NonNull
    public final LinearLayoutCompat d;

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

    @NonNull
    public final TextView v;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HuodongDetailActivity.a f36408a;

        public a a(HuodongDetailActivity.a aVar) {
            this.f36408a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36408a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HuodongDetailActivity.a f36409a;

        public b a(HuodongDetailActivity.a aVar) {
            this.f36409a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36409a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HuodongDetailActivity.a f36410a;

        public c a(HuodongDetailActivity.a aVar) {
            this.f36410a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36410a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(46);
        f13274a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{27}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36407a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.sv, 28);
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_title, 29);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_ic_huodong_time, 30);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_huodong_time_title, 31);
        sparseIntArray.put(com.huachenjie.sport.R.id.ll_huodong_time, 32);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_ic_sign_time, 33);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_sign_time_title, 34);
        sparseIntArray.put(com.huachenjie.sport.R.id.ll_sign_time, 35);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_ic_huodong_type, 36);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_huodong_type_title, 37);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_ic_huodong_address, 38);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_huodong_address_title, 39);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_ic_huodong_organization, 40);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_huodong_organization_title, 41);
        sparseIntArray.put(com.huachenjie.sport.R.id.v_place_holder, 42);
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_content, 43);
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_bottom_bar, 44);
        sparseIntArray.put(com.huachenjie.sport.R.id.ll_sign_count, 45);
    }

    public ActivityHuodongDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 46, f13274a, f36407a));
    }

    public final boolean A(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 4;
        }
        return true;
    }

    public final boolean B(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 128;
        }
        return true;
    }

    public final boolean C(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:132:0x025a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x025c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0263  */
    /* JADX WARN: Code duplicated, block: B:137:0x026d  */
    /* JADX WARN: Code duplicated, block: B:138:0x0274  */
    /* JADX WARN: Code duplicated, block: B:142:0x0282 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0284  */
    /* JADX WARN: Code duplicated, block: B:144:0x028b  */
    /* JADX WARN: Code duplicated, block: B:147:0x0295  */
    /* JADX WARN: Code duplicated, block: B:148:0x029c  */
    /* JADX WARN: Code duplicated, block: B:152:0x02a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:157:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:158:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:163:0x02d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:165:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:169:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:16:0x0052  */
    /* JADX WARN: Code duplicated, block: B:171:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:25:0x0070  */
    /* JADX WARN: Code duplicated, block: B:34:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x011e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        String str6;
        String str7;
        String str8;
        String str9;
        BindingTitleBean bindingTitleBean;
        String str10;
        String str11;
        String str12;
        int i3;
        String str13;
        String value;
        String str14;
        String str15;
        long signUpRemainTime;
        boolean z2;
        boolean z3;
        String str16;
        String value2;
        boolean zSafeUnbox;
        Integer value3;
        b bVarA;
        a aVar;
        c cVar;
        String value4;
        String value5;
        String value6;
        BindingTitleBean value7;
        String value8;
        String value9;
        boolean zSafeUnbox2;
        String value10;
        String str17;
        String activityDescription;
        String str18;
        String strValueOf;
        String location;
        String coverImage;
        String activityTitle;
        int signUpLimit;
        String activityOrganizer;
        String strValueOf2;
        String value11;
        boolean zSafeUnbox3;
        MediatorLiveData<Boolean> mediatorLiveDataT;
        Boolean value12;
        MediatorLiveData<Boolean> mediatorLiveDataR;
        Boolean value13;
        MediatorLiveData<String> mediatorLiveDataK;
        MediatorLiveData<String> mediatorLiveDataN;
        MutableLiveData<HuodongDetailBean> mutableLiveDataI;
        MediatorLiveData<Integer> mediatorLiveDataS;
        int i4;
        String distance;
        HuodongDetail detail;
        synchronized (this) {
            j = this.f13275a;
            this.f13275a = 0L;
        }
        HuodongDetailVM huodongDetailVM = ((ActivityHuodongDetailBinding) this).f13261a;
        HuodongDetailActivity.a aVar2 = ((ActivityHuodongDetailBinding) this).f13260a;
        if ((392191 & j) != 0) {
            if ((j & 327681) == 0) {
                value4 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataV = huodongDetailVM != null ? huodongDetailVM.v() : null;
                updateLiveDataRegistration(0, mediatorLiveDataV);
                if (mediatorLiveDataV != null) {
                    value4 = mediatorLiveDataV.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 327682) == 0) {
                value5 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataQ = huodongDetailVM != null ? huodongDetailVM.q() : null;
                updateLiveDataRegistration(1, mediatorLiveDataQ);
                if (mediatorLiveDataQ != null) {
                    value5 = mediatorLiveDataQ.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 327684) == 0) {
                value6 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataW = huodongDetailVM != null ? huodongDetailVM.w() : null;
                updateLiveDataRegistration(2, mediatorLiveDataW);
                if (mediatorLiveDataW != null) {
                    value6 = mediatorLiveDataW.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 327688) == 0) {
                value7 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataY = huodongDetailVM != null ? huodongDetailVM.y() : null;
                updateLiveDataRegistration(3, mutableLiveDataY);
                if (mutableLiveDataY != null) {
                    value7 = mutableLiveDataY.getValue();
                } else {
                    value7 = null;
                }
            }
            if ((j & 327696) == 0) {
                value8 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataL = huodongDetailVM != null ? huodongDetailVM.l() : null;
                updateLiveDataRegistration(4, mediatorLiveDataL);
                if (mediatorLiveDataL != null) {
                    value8 = mediatorLiveDataL.getValue();
                } else {
                    value8 = null;
                }
            }
            if ((j & 327712) == 0) {
                value9 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataM = huodongDetailVM != null ? huodongDetailVM.m() : null;
                updateLiveDataRegistration(5, mediatorLiveDataM);
                if (mediatorLiveDataM != null) {
                    value9 = mediatorLiveDataM.getValue();
                } else {
                    value9 = null;
                }
            }
            if ((j & 327744) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataP = huodongDetailVM != null ? huodongDetailVM.p() : null;
                updateLiveDataRegistration(6, mediatorLiveDataP);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mediatorLiveDataP != null ? mediatorLiveDataP.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 327808) == 0) {
                value10 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataX = huodongDetailVM != null ? huodongDetailVM.x() : null;
                updateLiveDataRegistration(7, mediatorLiveDataX);
                if (mediatorLiveDataX != null) {
                    value10 = mediatorLiveDataX.getValue();
                } else {
                    value10 = null;
                }
            }
            if ((j & 329984) != 0) {
                if (huodongDetailVM != null) {
                    mediatorLiveDataS = huodongDetailVM.s();
                    mutableLiveDataI = huodongDetailVM.i();
                } else {
                    mutableLiveDataI = null;
                    mediatorLiveDataS = null;
                }
                updateLiveDataRegistration(8, mediatorLiveDataS);
                updateLiveDataRegistration(11, mutableLiveDataI);
                value3 = mediatorLiveDataS != null ? mediatorLiveDataS.getValue() : null;
                HuodongDetailBean value14 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                long j2 = j & 329728;
                if (j2 != 0) {
                    if (value14 != null) {
                        int activityStatus = value14.getActivityStatus();
                        location = value14.getLocation();
                        int signUpCount = value14.getSignUpCount();
                        coverImage = value14.getCoverImage();
                        int activityType = value14.getActivityType();
                        activityTitle = value14.getActivityTitle();
                        signUpLimit = value14.getSignUpLimit();
                        distance = value14.formatDistance();
                        detail = value14.getDetail();
                        activityOrganizer = value14.getActivityOrganizer();
                        i4 = activityType;
                        i = signUpCount;
                        i3 = activityStatus;
                    } else {
                        i4 = 0;
                        location = null;
                        i3 = 0;
                        coverImage = null;
                        i = 0;
                        activityTitle = null;
                        signUpLimit = 0;
                        distance = null;
                        detail = null;
                        activityOrganizer = null;
                    }
                    strValueOf2 = String.valueOf(i);
                    str16 = value4;
                    z = i4 == 2;
                    strValueOf = String.valueOf(signUpLimit);
                    bindingTitleBean = value7;
                    str17 = String.format("%s", distance);
                    if (j2 != 0) {
                        j |= z ? 1048576L : PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                    activityDescription = detail != null ? detail.getActivityDescription() : null;
                    str18 = z ? "跑步活动" : "普通活动";
                } else {
                    value3 = value3;
                    str16 = value4;
                    bindingTitleBean = value7;
                    z = false;
                    str17 = null;
                    activityDescription = null;
                    str18 = null;
                    strValueOf = null;
                    location = null;
                    i3 = 0;
                    coverImage = null;
                    i = 0;
                    activityTitle = null;
                    signUpLimit = 0;
                    activityOrganizer = null;
                    strValueOf2 = null;
                }
                signUpRemainTime = value14 != null ? value14.getSignUpRemainTime() : 0L;
            } else {
                str16 = value4;
                bindingTitleBean = value7;
                z = false;
                str17 = null;
                activityDescription = null;
                str18 = null;
                strValueOf = null;
                value3 = null;
                location = null;
                i3 = 0;
                coverImage = null;
                i = 0;
                activityTitle = null;
                signUpLimit = 0;
                signUpRemainTime = 0;
                activityOrganizer = null;
                strValueOf2 = null;
            }
            if ((j & 328192) != 0) {
                MediatorLiveData<String> mediatorLiveDataU = huodongDetailVM != null ? huodongDetailVM.u() : null;
                updateLiveDataRegistration(9, mediatorLiveDataU);
                value2 = mediatorLiveDataU != null ? mediatorLiveDataU.getValue() : null;
                if ((j & 331776) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataN = huodongDetailVM.n();
                    } else {
                        mediatorLiveDataN = null;
                    }
                    updateLiveDataRegistration(12, mediatorLiveDataN);
                    value = mediatorLiveDataN != null ? mediatorLiveDataN.getValue() : null;
                    if ((j & 335872) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataK = huodongDetailVM.k();
                        } else {
                            mediatorLiveDataK = null;
                        }
                        updateLiveDataRegistration(13, mediatorLiveDataK);
                        value11 = mediatorLiveDataK != null ? mediatorLiveDataK.getValue() : null;
                        if ((j & 344064) != 0) {
                            if (huodongDetailVM != null) {
                                mediatorLiveDataR = huodongDetailVM.r();
                            } else {
                                mediatorLiveDataR = null;
                            }
                            updateLiveDataRegistration(14, mediatorLiveDataR);
                            if (mediatorLiveDataR != null) {
                                value13 = mediatorLiveDataR.getValue();
                            } else {
                                value13 = null;
                            }
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                        } else {
                            value11 = value11;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 360448) != 0) {
                            if (huodongDetailVM != null) {
                                mediatorLiveDataT = huodongDetailVM.t();
                            } else {
                                mediatorLiveDataT = null;
                            }
                            updateLiveDataRegistration(15, mediatorLiveDataT);
                            if (mediatorLiveDataT != null) {
                                value12 = mediatorLiveDataT.getValue();
                            } else {
                                value12 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                        } else {
                            zSafeUnbox = false;
                        }
                        str11 = value6;
                        i2 = signUpLimit;
                        str15 = value5;
                        str5 = str18;
                        str9 = location;
                        str12 = value8;
                        str4 = activityDescription;
                        str3 = str17;
                        str2 = activityOrganizer;
                        z2 = zSafeUnbox2;
                        str7 = activityTitle;
                        str14 = value9;
                        str6 = strValueOf;
                        str10 = value10;
                        str8 = coverImage;
                        str13 = value11;
                        String str19 = strValueOf2;
                        z3 = zSafeUnbox3;
                        str = str19;
                    } else {
                        value = value;
                    }
                    if ((j & 344064) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataR = huodongDetailVM.r();
                        } else {
                            mediatorLiveDataR = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataR);
                        if (mediatorLiveDataR != null) {
                            value13 = mediatorLiveDataR.getValue();
                        } else {
                            value13 = null;
                        }
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                    } else {
                        value11 = value11;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 360448) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataT = huodongDetailVM.t();
                        } else {
                            mediatorLiveDataT = null;
                        }
                        updateLiveDataRegistration(15, mediatorLiveDataT);
                        if (mediatorLiveDataT != null) {
                            value12 = mediatorLiveDataT.getValue();
                        } else {
                            value12 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                    } else {
                        zSafeUnbox = false;
                    }
                    str11 = value6;
                    i2 = signUpLimit;
                    str15 = value5;
                    str5 = str18;
                    str9 = location;
                    str12 = value8;
                    str4 = activityDescription;
                    str3 = str17;
                    str2 = activityOrganizer;
                    z2 = zSafeUnbox2;
                    str7 = activityTitle;
                    str14 = value9;
                    str6 = strValueOf;
                    str10 = value10;
                    str8 = coverImage;
                    str13 = value11;
                    String str110 = strValueOf2;
                    z3 = zSafeUnbox3;
                    str = str110;
                } else {
                    value2 = value2;
                }
                if ((j & 335872) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataK = huodongDetailVM.k();
                    } else {
                        mediatorLiveDataK = null;
                    }
                    updateLiveDataRegistration(13, mediatorLiveDataK);
                    if (mediatorLiveDataK != null) {
                    }
                    if ((j & 344064) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataR = huodongDetailVM.r();
                        } else {
                            mediatorLiveDataR = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataR);
                        if (mediatorLiveDataR != null) {
                            value13 = mediatorLiveDataR.getValue();
                        } else {
                            value13 = null;
                        }
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                    } else {
                        value11 = value11;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 360448) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataT = huodongDetailVM.t();
                        } else {
                            mediatorLiveDataT = null;
                        }
                        updateLiveDataRegistration(15, mediatorLiveDataT);
                        if (mediatorLiveDataT != null) {
                            value12 = mediatorLiveDataT.getValue();
                        } else {
                            value12 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                    } else {
                        zSafeUnbox = false;
                    }
                    str11 = value6;
                    i2 = signUpLimit;
                    str15 = value5;
                    str5 = str18;
                    str9 = location;
                    str12 = value8;
                    str4 = activityDescription;
                    str3 = str17;
                    str2 = activityOrganizer;
                    z2 = zSafeUnbox2;
                    str7 = activityTitle;
                    str14 = value9;
                    str6 = strValueOf;
                    str10 = value10;
                    str8 = coverImage;
                    str13 = value11;
                    String str111 = strValueOf2;
                    z3 = zSafeUnbox3;
                    str = str111;
                } else {
                    value = value;
                }
                if ((j & 344064) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataR = huodongDetailVM.r();
                    } else {
                        mediatorLiveDataR = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataR);
                    if (mediatorLiveDataR != null) {
                        value13 = mediatorLiveDataR.getValue();
                    } else {
                        value13 = null;
                    }
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                } else {
                    value11 = value11;
                    zSafeUnbox3 = false;
                }
                if ((j & 360448) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataT = huodongDetailVM.t();
                    } else {
                        mediatorLiveDataT = null;
                    }
                    updateLiveDataRegistration(15, mediatorLiveDataT);
                    if (mediatorLiveDataT != null) {
                        value12 = mediatorLiveDataT.getValue();
                    } else {
                        value12 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                } else {
                    zSafeUnbox = false;
                }
                str11 = value6;
                i2 = signUpLimit;
                str15 = value5;
                str5 = str18;
                str9 = location;
                str12 = value8;
                str4 = activityDescription;
                str3 = str17;
                str2 = activityOrganizer;
                z2 = zSafeUnbox2;
                str7 = activityTitle;
                str14 = value9;
                str6 = strValueOf;
                str10 = value10;
                str8 = coverImage;
                str13 = value11;
                String str112 = strValueOf2;
                z3 = zSafeUnbox3;
                str = str112;
            } else {
                z = z;
            }
            if ((j & 331776) != 0) {
                if (huodongDetailVM != null) {
                    mediatorLiveDataN = huodongDetailVM.n();
                } else {
                    mediatorLiveDataN = null;
                }
                updateLiveDataRegistration(12, mediatorLiveDataN);
                if (mediatorLiveDataN != null) {
                }
                if ((j & 335872) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataK = huodongDetailVM.k();
                    } else {
                        mediatorLiveDataK = null;
                    }
                    updateLiveDataRegistration(13, mediatorLiveDataK);
                    if (mediatorLiveDataK != null) {
                    }
                    if ((j & 344064) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataR = huodongDetailVM.r();
                        } else {
                            mediatorLiveDataR = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataR);
                        if (mediatorLiveDataR != null) {
                            value13 = mediatorLiveDataR.getValue();
                        } else {
                            value13 = null;
                        }
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                    } else {
                        value11 = value11;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 360448) != 0) {
                        if (huodongDetailVM != null) {
                            mediatorLiveDataT = huodongDetailVM.t();
                        } else {
                            mediatorLiveDataT = null;
                        }
                        updateLiveDataRegistration(15, mediatorLiveDataT);
                        if (mediatorLiveDataT != null) {
                            value12 = mediatorLiveDataT.getValue();
                        } else {
                            value12 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                    } else {
                        zSafeUnbox = false;
                    }
                    str11 = value6;
                    i2 = signUpLimit;
                    str15 = value5;
                    str5 = str18;
                    str9 = location;
                    str12 = value8;
                    str4 = activityDescription;
                    str3 = str17;
                    str2 = activityOrganizer;
                    z2 = zSafeUnbox2;
                    str7 = activityTitle;
                    str14 = value9;
                    str6 = strValueOf;
                    str10 = value10;
                    str8 = coverImage;
                    str13 = value11;
                    String str113 = strValueOf2;
                    z3 = zSafeUnbox3;
                    str = str113;
                } else {
                    value = value;
                }
                if ((j & 344064) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataR = huodongDetailVM.r();
                    } else {
                        mediatorLiveDataR = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataR);
                    if (mediatorLiveDataR != null) {
                        value13 = mediatorLiveDataR.getValue();
                    } else {
                        value13 = null;
                    }
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                } else {
                    value11 = value11;
                    zSafeUnbox3 = false;
                }
                if ((j & 360448) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataT = huodongDetailVM.t();
                    } else {
                        mediatorLiveDataT = null;
                    }
                    updateLiveDataRegistration(15, mediatorLiveDataT);
                    if (mediatorLiveDataT != null) {
                        value12 = mediatorLiveDataT.getValue();
                    } else {
                        value12 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                } else {
                    zSafeUnbox = false;
                }
                str11 = value6;
                i2 = signUpLimit;
                str15 = value5;
                str5 = str18;
                str9 = location;
                str12 = value8;
                str4 = activityDescription;
                str3 = str17;
                str2 = activityOrganizer;
                z2 = zSafeUnbox2;
                str7 = activityTitle;
                str14 = value9;
                str6 = strValueOf;
                str10 = value10;
                str8 = coverImage;
                str13 = value11;
                String str114 = strValueOf2;
                z3 = zSafeUnbox3;
                str = str114;
            } else {
                value2 = value2;
            }
            if ((j & 335872) != 0) {
                if (huodongDetailVM != null) {
                    mediatorLiveDataK = huodongDetailVM.k();
                } else {
                    mediatorLiveDataK = null;
                }
                updateLiveDataRegistration(13, mediatorLiveDataK);
                if (mediatorLiveDataK != null) {
                }
                if ((j & 344064) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataR = huodongDetailVM.r();
                    } else {
                        mediatorLiveDataR = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataR);
                    if (mediatorLiveDataR != null) {
                        value13 = mediatorLiveDataR.getValue();
                    } else {
                        value13 = null;
                    }
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
                } else {
                    value11 = value11;
                    zSafeUnbox3 = false;
                }
                if ((j & 360448) != 0) {
                    if (huodongDetailVM != null) {
                        mediatorLiveDataT = huodongDetailVM.t();
                    } else {
                        mediatorLiveDataT = null;
                    }
                    updateLiveDataRegistration(15, mediatorLiveDataT);
                    if (mediatorLiveDataT != null) {
                        value12 = mediatorLiveDataT.getValue();
                    } else {
                        value12 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value12);
                } else {
                    zSafeUnbox = false;
                }
                str11 = value6;
                i2 = signUpLimit;
                str15 = value5;
                str5 = str18;
                str9 = location;
                str12 = value8;
                str4 = activityDescription;
                str3 = str17;
                str2 = activityOrganizer;
                z2 = zSafeUnbox2;
                str7 = activityTitle;
                str14 = value9;
                str6 = strValueOf;
                str10 = value10;
                str8 = coverImage;
                str13 = value11;
                String str115 = strValueOf2;
                z3 = zSafeUnbox3;
                str = str115;
            } else {
                value = value;
            }
            if ((j & 344064) != 0) {
                if (huodongDetailVM != null) {
                    mediatorLiveDataR = huodongDetailVM.r();
                } else {
                    mediatorLiveDataR = null;
                }
                updateLiveDataRegistration(14, mediatorLiveDataR);
                if (mediatorLiveDataR != null) {
                    value13 = mediatorLiveDataR.getValue();
                } else {
                    value13 = null;
                }
                zSafeUnbox3 = ViewDataBinding.safeUnbox(value13);
            } else {
                value11 = value11;
                zSafeUnbox3 = false;
            }
            if ((j & 360448) != 0) {
                if (huodongDetailVM != null) {
                    mediatorLiveDataT = huodongDetailVM.t();
                } else {
                    mediatorLiveDataT = null;
                }
                updateLiveDataRegistration(15, mediatorLiveDataT);
                if (mediatorLiveDataT != null) {
                    value12 = mediatorLiveDataT.getValue();
                } else {
                    value12 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value12);
            } else {
                zSafeUnbox = false;
            }
            str11 = value6;
            i2 = signUpLimit;
            str15 = value5;
            str5 = str18;
            str9 = location;
            str12 = value8;
            str4 = activityDescription;
            str3 = str17;
            str2 = activityOrganizer;
            z2 = zSafeUnbox2;
            str7 = activityTitle;
            str14 = value9;
            str6 = strValueOf;
            str10 = value10;
            str8 = coverImage;
            str13 = value11;
            String str116 = strValueOf2;
            z3 = zSafeUnbox3;
            str = str116;
        } else {
            z = false;
            str = null;
            i = 0;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i2 = 0;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            bindingTitleBean = null;
            str10 = null;
            str11 = null;
            str12 = null;
            i3 = 0;
            str13 = null;
            value = null;
            str14 = null;
            str15 = null;
            signUpRemainTime = 0;
            z2 = false;
            z3 = false;
            str16 = null;
            value2 = null;
            zSafeUnbox = false;
            value3 = null;
        }
        long j3 = j & 393216;
        if (j3 == 0 || aVar2 == null) {
            bVarA = null;
            aVar = null;
            cVar = null;
        } else {
            c cVar2 = this.f13279a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f13279a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            a aVar3 = this.f13277a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f13277a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar = this.f13278a;
            if (bVar == null) {
                bVar = new b();
                this.f13278a = bVar;
            }
            bVarA = bVar.a(aVar2);
            cVar = cVarA;
            aVar = aVarA;
        }
        if ((j & 329728) != 0) {
            CommonBindingAdapter.b0(((ActivityHuodongDetailBinding) this).f13253a, str8, null, false);
            CommonBindingAdapter.l0(((ActivityHuodongDetailBinding) this).c, z);
            TextViewBindingAdapter.setText(this.n, str4);
            TextViewBindingAdapter.setText(this.o, str);
            TextViewBindingAdapter.setText(this.p, str6);
            ((ActivityHuodongDetailBinding) this).f13264a.setMax(i2);
            ((ActivityHuodongDetailBinding) this).f13264a.setProgress(i);
            TextViewBindingAdapter.setText(((ActivityHuodongDetailBinding) this).f13254a, str9);
            CommonBindingAdapter.l0(((ActivityHuodongDetailBinding) this).f13268c, z);
            CommonBindingAdapter.l0(((ActivityHuodongDetailBinding) this).f13270d, z);
            TextViewBindingAdapter.setText(((ActivityHuodongDetailBinding) this).f13270d, str3);
            TextViewBindingAdapter.setText(((ActivityHuodongDetailBinding) this).f13271e, str2);
            TextViewBindingAdapter.setText(this.i, str5);
            TextViewBindingAdapter.setText(this.k, str7);
            q34.a(((ActivityHuodongDetailBinding) this).f13263a, Integer.valueOf(i3));
        }
        if ((j & 262144) != 0) {
            DrawablesBindingAdapter.h(this.b, 0, -2565928, 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            DrawablesBindingAdapter.h(this.c, 0, -2565928, 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((j & 328192) != 0) {
            TextViewBindingAdapter.setText(this.l, value2);
        }
        if ((j & 327681) != 0) {
            TextViewBindingAdapter.setText(this.m, str16);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.d, bVarA, null);
            CommonBindingAdapter.q(this.f13280a, aVar, null);
            CommonBindingAdapter.q(((ActivityHuodongDetailBinding) this).f13262a, cVar, null);
        }
        if ((j & 344064) != 0) {
            CommonBindingAdapter.l0(this.f13280a, z3);
        }
        if ((j & 327744) != 0) {
            CommonBindingAdapter.e0(this.f13280a, z2);
        }
        if ((j & 327682) != 0) {
            TextViewBindingAdapter.setText(this.f13280a, str15);
        }
        if ((j & 327712) != 0) {
            TextViewBindingAdapter.setText(this.q, str14);
        }
        if ((j & 331776) != 0) {
            TextViewBindingAdapter.setText(this.r, value);
        }
        if ((j & 335872) != 0) {
            TextViewBindingAdapter.setText(this.s, str13);
        }
        if ((j & 327696) != 0) {
            TextViewBindingAdapter.setText(this.t, str12);
        }
        if ((j & 327684) != 0) {
            TextViewBindingAdapter.setText(this.u, str11);
        }
        if ((j & 327808) != 0) {
            TextViewBindingAdapter.setText(this.v, str10);
        }
        if ((j & 360448) != 0) {
            CommonBindingAdapter.l0(((ActivityHuodongDetailBinding) this).f13262a, zSafeUnbox);
        }
        if ((j & 329984) != 0) {
            n34.a(((ActivityHuodongDetailBinding) this).f13262a, value3, Long.valueOf(signUpRemainTime));
        }
        if ((j & 327688) != 0) {
            ((ActivityHuodongDetailBinding) this).f13257a.k(bindingTitleBean);
        }
        ViewDataBinding.executeBindingsOn(((ActivityHuodongDetailBinding) this).f13257a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13275a != 0) {
                return true;
            }
            return ((ActivityHuodongDetailBinding) this).f13257a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13275a = 262144L;
        }
        ((ActivityHuodongDetailBinding) this).f13257a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityHuodongDetailBinding
    public void l(@Nullable HuodongDetailActivity.a aVar) {
        ((ActivityHuodongDetailBinding) this).f13260a = aVar;
        synchronized (this) {
            this.f13275a |= 131072;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityHuodongDetailBinding
    public void m(@Nullable HuodongDetailVM huodongDetailVM) {
        ((ActivityHuodongDetailBinding) this).f13261a = huodongDetailVM;
        synchronized (this) {
            this.f13275a |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 1024;
        }
        return true;
    }

    public final boolean o(MutableLiveData<HuodongDetailBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 2048;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return z((MediatorLiveData) obj, i2);
            case 1:
                return u((MediatorLiveData) obj, i2);
            case 2:
                return A((MediatorLiveData) obj, i2);
            case 3:
                return C((MutableLiveData) obj, i2);
            case 4:
                return q((MediatorLiveData) obj, i2);
            case 5:
                return r((MediatorLiveData) obj, i2);
            case 6:
                return t((MediatorLiveData) obj, i2);
            case 7:
                return B((MediatorLiveData) obj, i2);
            case 8:
                return w((MediatorLiveData) obj, i2);
            case 9:
                return y((MediatorLiveData) obj, i2);
            case 10:
                return n((LayoutToolbarBindingBinding) obj, i2);
            case 11:
                return o((MutableLiveData) obj, i2);
            case 12:
                return s((MediatorLiveData) obj, i2);
            case 13:
                return p((MediatorLiveData) obj, i2);
            case 14:
                return v((MediatorLiveData) obj, i2);
            case 15:
                return x((MediatorLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 8192;
        }
        return true;
    }

    public final boolean q(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 16;
        }
        return true;
    }

    public final boolean r(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 32;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 4096;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ActivityHuodongDetailBinding) this).f13257a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((HuodongDetailVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((HuodongDetailActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 64;
        }
        return true;
    }

    public final boolean u(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 2;
        }
        return true;
    }

    public final boolean v(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    public final boolean w(MediatorLiveData<Integer> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 256;
        }
        return true;
    }

    public final boolean x(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    public final boolean y(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 512;
        }
        return true;
    }

    public final boolean z(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13275a |= 1;
        }
        return true;
    }

    public ActivityHuodongDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 16, (ShadowConstraintLayout) objArr[44], (ShadowLayout) objArr[43], (ShadowConstraintLayout) objArr[29], (ImageView) objArr[1], (ImageView) objArr[38], (ImageView) objArr[14], (ImageView) objArr[40], (ImageView) objArr[30], (ImageView) objArr[36], (ImageView) objArr[33], (LinearLayoutCompat) objArr[32], (LinearLayoutCompat) objArr[45], (LinearLayoutCompat) objArr[35], (ProgressBarView) objArr[21], (HuodongSignButton) objArr[25], (NestedScrollView) objArr[28], (LayoutToolbarBindingBinding) objArr[27], (TextView) objArr[17], (TextView) objArr[39], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[18], (TextView) objArr[41], (TextView) objArr[31], (TextView) objArr[37], (TextView) objArr[13], (TextView) objArr[34], (TextView) objArr[2], (View) objArr[42], (HuodongStatusWidget) objArr[19]);
        this.f13275a = -1L;
        ((ActivityHuodongDetailBinding) this).f13253a.setTag(null);
        ((ActivityHuodongDetailBinding) this).c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13276a = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) objArr[10];
        this.b = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.l = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.m = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[20];
        this.n = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[22];
        this.o = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[23];
        this.p = textView5;
        textView5.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[24];
        this.d = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[26];
        this.f13280a = bLTextView;
        bLTextView.setTag(null);
        TextView textView6 = (TextView) objArr[3];
        this.q = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[4];
        this.r = textView7;
        textView7.setTag(null);
        View view3 = (View) objArr[5];
        this.c = view3;
        view3.setTag(null);
        TextView textView8 = (TextView) objArr[6];
        this.s = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[7];
        this.t = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[8];
        this.u = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[9];
        this.v = textView11;
        textView11.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13264a.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13262a.setTag(null);
        setContainedBinding(((ActivityHuodongDetailBinding) this).f13257a);
        ((ActivityHuodongDetailBinding) this).f13254a.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13268c.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13270d.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13271e.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        ((ActivityHuodongDetailBinding) this).f13263a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
