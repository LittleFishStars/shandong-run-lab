package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.NestedEditTextView;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.page.apply_refund.ApplyRefundActivity;
import com.huachenjie.mall.page.apply_refund.ApplyRefundFileAdapter;
import com.huachenjie.mall.page.apply_refund.ApplyRefundVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityApplyRefundBindingImpl extends MallActivityApplyRefundBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedEditTextView f10139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f10142a;
    public InverseBindingListener b;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallActivityApplyRefundBinding) MallActivityApplyRefundBindingImpl.this).f34764a);
            ApplyRefundVM applyRefundVM = ((MallActivityApplyRefundBinding) MallActivityApplyRefundBindingImpl.this).f10131a;
            if (applyRefundVM != null) {
                MutableLiveData<String> mutableLiveDataN = applyRefundVM.n();
                if (mutableLiveDataN != null) {
                    mutableLiveDataN.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(MallActivityApplyRefundBindingImpl.this.f10139a);
            ApplyRefundVM applyRefundVM = ((MallActivityApplyRefundBinding) MallActivityApplyRefundBindingImpl.this).f10131a;
            if (applyRefundVM != null) {
                MutableLiveData<String> mutableLiveDataP = applyRefundVM.p();
                if (mutableLiveDataP != null) {
                    mutableLiveDataP.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplyRefundActivity.ClickProxy f34768a;

        public c a(ApplyRefundActivity.ClickProxy clickProxy) {
            this.f34768a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34768a.a(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplyRefundActivity.ClickProxy f34769a;

        public d a(ApplyRefundActivity.ClickProxy clickProxy) {
            this.f34769a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34769a.c(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ApplyRefundActivity.ClickProxy f34770a;

        public e a(ApplyRefundActivity.ClickProxy clickProxy) {
            this.f34770a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34770a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        f10134a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{13}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34765a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_sub_info, 14);
        sparseIntArray.put(com.huachenjie.mall.R.id.rg_type, 15);
        sparseIntArray.put(com.huachenjie.mall.R.id.rb_type1, 16);
    }

    public MallActivityApplyRefundBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f10134a, f34765a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0195 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0197  */
    /* JADX WARN: Code duplicated, block: B:104:0x019e  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:139:0x0286 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x0289  */
    /* JADX WARN: Code duplicated, block: B:143:0x028c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x028e  */
    /* JADX WARN: Code duplicated, block: B:145:0x0291  */
    /* JADX WARN: Code duplicated, block: B:146:0x0296  */
    /* JADX WARN: Code duplicated, block: B:149:0x029f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:153:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:155:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:156:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:159:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:161:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:164:0x02cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:168:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:171:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:174:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:175:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:178:0x0303  */
    /* JADX WARN: Code duplicated, block: B:181:0x0325  */
    /* JADX WARN: Code duplicated, block: B:184:0x0335  */
    /* JADX WARN: Code duplicated, block: B:187:0x0352  */
    /* JADX WARN: Code duplicated, block: B:190:0x0360  */
    /* JADX WARN: Code duplicated, block: B:193:0x036d  */
    /* JADX WARN: Code duplicated, block: B:196:0x0380  */
    /* JADX WARN: Code duplicated, block: B:198:0x0389  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x008d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0095  */
    /* JADX WARN: Code duplicated, block: B:42:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:64:0x0100  */
    /* JADX WARN: Code duplicated, block: B:66:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0105  */
    /* JADX WARN: Code duplicated, block: B:68:0x0108  */
    /* JADX WARN: Code duplicated, block: B:69:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0118  */
    /* JADX WARN: Code duplicated, block: B:74:0x011d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0124  */
    /* JADX WARN: Code duplicated, block: B:78:0x012b  */
    /* JADX WARN: Code duplicated, block: B:81:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0136  */
    /* JADX WARN: Code duplicated, block: B:83:0x013b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0142  */
    /* JADX WARN: Code duplicated, block: B:87:0x0149  */
    /* JADX WARN: Code duplicated, block: B:89:0x0159  */
    /* JADX WARN: Code duplicated, block: B:92:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0167  */
    /* JADX WARN: Code duplicated, block: B:94:0x0174  */
    /* JADX WARN: Code duplicated, block: B:97:0x017f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0186  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ApplyRefundFileAdapter applyRefundFileAdapter;
        String str;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        String str3;
        String str4;
        String goodsName;
        boolean zSafeUnbox;
        OrderReasonBean value;
        MutableLiveData<OrderReasonBean> mutableLiveData;
        String value2;
        MutableLiveData<String> mutableLiveDataP;
        BindingTitleBean bindingTitleBean;
        String str5;
        String str6;
        c cVar;
        e eVar;
        d dVarA;
        boolean z4;
        long j2;
        String str7;
        boolean z5;
        long j3;
        boolean z6;
        MutableLiveData<String> mutableLiveData2;
        int length;
        MutableLiveData<OrderReasonBean> mutableLiveDataO;
        int i;
        MutableLiveData<OrderReasonBean> mutableLiveDataO2;
        String desc;
        MutableLiveData<String> mutableLiveDataP2;
        String str8;
        boolean returnGoodsFlag;
        String str9;
        String goodsSpec;
        String goodsImage;
        long j4;
        boolean z7;
        String value3;
        boolean zSafeUnbox2;
        BindingTitleBean value4;
        MutableLiveData<ApplyRefundFileAdapter> mutableLiveDataM;
        MutableLiveData<BindingTitleBean> mutableLiveDataI;
        MutableLiveData<Boolean> mutableLiveDataR;
        Boolean value5;
        MutableLiveData<String> mutableLiveDataN;
        MutableLiveData<Integer> mutableLiveDataQ;
        Integer value6;
        MutableLiveData<OrderGoodsBean> mutableLiveDataL;
        OrderGoodsBean value7;
        String refundAmountMax;
        int length2;
        synchronized (this) {
            j = this.f10135a;
            this.f10135a = 0L;
        }
        ApplyRefundVM applyRefundVM = ((MallActivityApplyRefundBinding) this).f10131a;
        ApplyRefundActivity.ClickProxy clickProxy = ((MallActivityApplyRefundBinding) this).f10130a;
        long j5 = j & 2564;
        RequestOptions requestOptions = j5 != 0 ? ju3.m : null;
        if ((3039 & j) != 0) {
            if ((j & 2561) != 0) {
                mutableLiveDataO2 = applyRefundVM != null ? applyRefundVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO2);
                value = mutableLiveDataO2 != null ? mutableLiveDataO2.getValue() : null;
                desc = value != null ? value.getDesc() : null;
                if ((j & 2562) != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataP2 = applyRefundVM.p();
                    } else {
                        mutableLiveDataP2 = null;
                    }
                    updateLiveDataRegistration(1, mutableLiveDataP2);
                    if (mutableLiveDataP2 != null) {
                        value2 = mutableLiveDataP2.getValue();
                    } else {
                        value2 = null;
                    }
                    if (value2 != null) {
                        length2 = value2.length();
                    } else {
                        length2 = 0;
                    }
                    str8 = String.format("%d/300", Integer.valueOf(length2));
                } else {
                    mutableLiveDataP2 = null;
                    str8 = null;
                    value2 = null;
                }
                if (j5 != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataL = applyRefundVM.l();
                    } else {
                        mutableLiveDataL = null;
                    }
                    updateLiveDataRegistration(2, mutableLiveDataL);
                    if (mutableLiveDataL != null) {
                        value7 = mutableLiveDataL.getValue();
                    } else {
                        value7 = null;
                    }
                    if (value7 != null) {
                        goodsName = value7.getGoodsName();
                        goodsSpec = value7.getGoodsSpec();
                        refundAmountMax = value7.getRefundAmountMax();
                        goodsImage = value7.getGoodsImage();
                        returnGoodsFlag = value7.getReturnGoodsFlag();
                    } else {
                        returnGoodsFlag = false;
                        goodsName = null;
                        goodsSpec = null;
                        refundAmountMax = null;
                        goodsImage = null;
                    }
                    str9 = String.format("￥%s", refundAmountMax);
                } else {
                    returnGoodsFlag = false;
                    str9 = null;
                    goodsName = null;
                    goodsSpec = null;
                    goodsImage = null;
                }
                j4 = j & 2571;
                if (j4 != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataQ = applyRefundVM.q();
                    } else {
                        mutableLiveDataQ = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveDataQ);
                    if (mutableLiveDataQ != null) {
                        value6 = mutableLiveDataQ.getValue();
                    } else {
                        value6 = null;
                    }
                    if (ViewDataBinding.safeUnbox(value6) > 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (j4 != 0) {
                        if (z7) {
                            j |= 8192;
                        } else {
                            j |= 4096;
                        }
                    }
                } else {
                    z7 = false;
                }
                if ((j & 2576) == 0) {
                    value3 = null;
                } else {
                    if (applyRefundVM != null) {
                        mutableLiveDataN = applyRefundVM.n();
                    } else {
                        mutableLiveDataN = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataN);
                    if (mutableLiveDataN != null) {
                        value3 = mutableLiveDataN.getValue();
                    } else {
                        value3 = null;
                    }
                }
                if ((j & 2624) != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataR = applyRefundVM.r();
                    } else {
                        mutableLiveDataR = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveDataR);
                    if (mutableLiveDataR != null) {
                        value5 = mutableLiveDataR.getValue();
                    } else {
                        value5 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(value5);
                    zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox2));
                } else {
                    zSafeUnbox2 = false;
                    zSafeUnbox = false;
                }
                if ((j & 2688) != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataI = applyRefundVM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataI);
                    value4 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                    if ((j & 2816) != 0) {
                        if (applyRefundVM != null) {
                            mutableLiveDataM = applyRefundVM.m();
                        } else {
                            mutableLiveDataM = null;
                        }
                        updateLiveDataRegistration(8, mutableLiveDataM);
                        if (mutableLiveDataM != null) {
                            ApplyRefundFileAdapter value8 = mutableLiveDataM.getValue();
                            str = str9;
                            str5 = str8;
                            str4 = goodsSpec;
                            mutableLiveDataP = mutableLiveDataP2;
                            z3 = returnGoodsFlag;
                            z2 = zSafeUnbox2;
                            z = z7;
                            str2 = value3;
                            str6 = desc;
                            mutableLiveData = mutableLiveDataO2;
                            str3 = goodsImage;
                            bindingTitleBean = value4;
                            applyRefundFileAdapter = value8;
                            j = j;
                        }
                    } else {
                        j = j;
                    }
                    str = str9;
                    j = j;
                    str5 = str8;
                    str4 = goodsSpec;
                    mutableLiveDataP = mutableLiveDataP2;
                    z3 = returnGoodsFlag;
                    z2 = zSafeUnbox2;
                    z = z7;
                    str2 = value3;
                    str6 = desc;
                    mutableLiveData = mutableLiveDataO2;
                    str3 = goodsImage;
                    bindingTitleBean = value4;
                    applyRefundFileAdapter = null;
                } else {
                    str9 = str9;
                    value3 = value3;
                }
                if ((j & 2816) != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataM = applyRefundVM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(8, mutableLiveDataM);
                    if (mutableLiveDataM != null) {
                        ApplyRefundFileAdapter value9 = mutableLiveDataM.getValue();
                        str = str9;
                        str5 = str8;
                        str4 = goodsSpec;
                        mutableLiveDataP = mutableLiveDataP2;
                        z3 = returnGoodsFlag;
                        z2 = zSafeUnbox2;
                        z = z7;
                        str2 = value3;
                        str6 = desc;
                        mutableLiveData = mutableLiveDataO2;
                        str3 = goodsImage;
                        bindingTitleBean = value4;
                        applyRefundFileAdapter = value9;
                        j = j;
                    }
                } else {
                    j = j;
                }
                str = str9;
                j = j;
                str5 = str8;
                str4 = goodsSpec;
                mutableLiveDataP = mutableLiveDataP2;
                z3 = returnGoodsFlag;
                z2 = zSafeUnbox2;
                z = z7;
                str2 = value3;
                str6 = desc;
                mutableLiveData = mutableLiveDataO2;
                str3 = goodsImage;
                bindingTitleBean = value4;
                applyRefundFileAdapter = null;
            } else {
                mutableLiveDataO2 = null;
                value = null;
            }
            if ((j & 2562) != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataP2 = applyRefundVM.p();
                } else {
                    mutableLiveDataP2 = null;
                }
                updateLiveDataRegistration(1, mutableLiveDataP2);
                if (mutableLiveDataP2 != null) {
                    value2 = mutableLiveDataP2.getValue();
                } else {
                    value2 = null;
                }
                if (value2 != null) {
                    length2 = value2.length();
                } else {
                    length2 = 0;
                }
                str8 = String.format("%d/300", Integer.valueOf(length2));
            } else {
                mutableLiveDataP2 = null;
                str8 = null;
                value2 = null;
            }
            if (j5 != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataL = applyRefundVM.l();
                } else {
                    mutableLiveDataL = null;
                }
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value7 = mutableLiveDataL.getValue();
                } else {
                    value7 = null;
                }
                if (value7 != null) {
                    goodsName = value7.getGoodsName();
                    goodsSpec = value7.getGoodsSpec();
                    refundAmountMax = value7.getRefundAmountMax();
                    goodsImage = value7.getGoodsImage();
                    returnGoodsFlag = value7.getReturnGoodsFlag();
                } else {
                    returnGoodsFlag = false;
                    goodsName = null;
                    goodsSpec = null;
                    refundAmountMax = null;
                    goodsImage = null;
                }
                str9 = String.format("￥%s", refundAmountMax);
            } else {
                returnGoodsFlag = false;
                str9 = null;
                goodsName = null;
                goodsSpec = null;
                goodsImage = null;
            }
            j4 = j & 2571;
            if (j4 != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataQ = applyRefundVM.q();
                } else {
                    mutableLiveDataQ = null;
                }
                updateLiveDataRegistration(3, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value6 = mutableLiveDataQ.getValue();
                } else {
                    value6 = null;
                }
                if (ViewDataBinding.safeUnbox(value6) > 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (j4 != 0) {
                    if (z7) {
                        j |= 8192;
                    } else {
                        j |= 4096;
                    }
                }
            } else {
                z7 = false;
            }
            if ((j & 2576) == 0) {
                value3 = null;
            } else {
                if (applyRefundVM != null) {
                    mutableLiveDataN = applyRefundVM.n();
                } else {
                    mutableLiveDataN = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value3 = mutableLiveDataN.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 2624) != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataR = applyRefundVM.r();
                } else {
                    mutableLiveDataR = null;
                }
                updateLiveDataRegistration(6, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value5 = mutableLiveDataR.getValue();
                } else {
                    value5 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(value5);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox2));
            } else {
                zSafeUnbox2 = false;
                zSafeUnbox = false;
            }
            if ((j & 2688) != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataI = applyRefundVM.i();
                } else {
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(7, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                }
                if ((j & 2816) != 0) {
                    if (applyRefundVM != null) {
                        mutableLiveDataM = applyRefundVM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(8, mutableLiveDataM);
                    if (mutableLiveDataM != null) {
                        ApplyRefundFileAdapter value10 = mutableLiveDataM.getValue();
                        str = str9;
                        str5 = str8;
                        str4 = goodsSpec;
                        mutableLiveDataP = mutableLiveDataP2;
                        z3 = returnGoodsFlag;
                        z2 = zSafeUnbox2;
                        z = z7;
                        str2 = value3;
                        str6 = desc;
                        mutableLiveData = mutableLiveDataO2;
                        str3 = goodsImage;
                        bindingTitleBean = value4;
                        applyRefundFileAdapter = value10;
                        j = j;
                    }
                } else {
                    j = j;
                }
                str = str9;
                j = j;
                str5 = str8;
                str4 = goodsSpec;
                mutableLiveDataP = mutableLiveDataP2;
                z3 = returnGoodsFlag;
                z2 = zSafeUnbox2;
                z = z7;
                str2 = value3;
                str6 = desc;
                mutableLiveData = mutableLiveDataO2;
                str3 = goodsImage;
                bindingTitleBean = value4;
                applyRefundFileAdapter = null;
            } else {
                str9 = str9;
                value3 = value3;
            }
            if ((j & 2816) != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataM = applyRefundVM.m();
                } else {
                    mutableLiveDataM = null;
                }
                updateLiveDataRegistration(8, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    ApplyRefundFileAdapter value11 = mutableLiveDataM.getValue();
                    str = str9;
                    str5 = str8;
                    str4 = goodsSpec;
                    mutableLiveDataP = mutableLiveDataP2;
                    z3 = returnGoodsFlag;
                    z2 = zSafeUnbox2;
                    z = z7;
                    str2 = value3;
                    str6 = desc;
                    mutableLiveData = mutableLiveDataO2;
                    str3 = goodsImage;
                    bindingTitleBean = value4;
                    applyRefundFileAdapter = value11;
                    j = j;
                }
            } else {
                j = j;
            }
            str = str9;
            j = j;
            str5 = str8;
            str4 = goodsSpec;
            mutableLiveDataP = mutableLiveDataP2;
            z3 = returnGoodsFlag;
            z2 = zSafeUnbox2;
            z = z7;
            str2 = value3;
            str6 = desc;
            mutableLiveData = mutableLiveDataO2;
            str3 = goodsImage;
            bindingTitleBean = value4;
            applyRefundFileAdapter = null;
        } else {
            applyRefundFileAdapter = null;
            str = null;
            str2 = null;
            z = false;
            z2 = false;
            z3 = false;
            str3 = null;
            str4 = null;
            goodsName = null;
            zSafeUnbox = false;
            value = null;
            mutableLiveData = null;
            value2 = null;
            mutableLiveDataP = null;
            bindingTitleBean = null;
            str5 = null;
            str6 = null;
        }
        if ((j & 3072) == 0 || clickProxy == null) {
            cVar = null;
            eVar = null;
            dVarA = null;
        } else {
            e eVar2 = this.f10142a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f10142a = eVar2;
            }
            e eVarA = eVar2.a(clickProxy);
            c cVar2 = this.f10140a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f10140a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar = this.f10141a;
            if (dVar == null) {
                dVar = new d();
                this.f10141a = dVar;
            }
            dVarA = dVar.a(clickProxy);
            eVar = eVarA;
            cVar = cVarA;
        }
        if ((j & 8192) != 0) {
            if (applyRefundVM != null) {
                i = 0;
                mutableLiveDataO = applyRefundVM.o();
            } else {
                mutableLiveDataO = mutableLiveData;
                i = 0;
            }
            updateLiveDataRegistration(i, mutableLiveDataO);
            if (mutableLiveDataO != null) {
                value = mutableLiveDataO.getValue();
            }
            z4 = value != null;
            j2 = j & 2571;
            if (j2 != 0) {
                if (!z) {
                    z4 = false;
                }
                if (j2 != 0) {
                    if (z4) {
                        j |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        j |= PlaybackStateCompat.ACTION_PREPARE;
                    }
                }
            } else {
                z4 = false;
            }
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
                if (applyRefundVM != null) {
                    mutableLiveDataP = applyRefundVM.p();
                }
                mutableLiveData2 = mutableLiveDataP;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value2 = mutableLiveData2.getValue();
                }
                if (value2 != null) {
                    length = value2.length();
                } else {
                    length = 0;
                }
                z5 = length > 0;
                str7 = value2;
            } else {
                str7 = value2;
                z5 = false;
            }
            j3 = j & 2571;
            if (j3 != 0) {
                if (!z4) {
                    z5 = false;
                }
                z6 = z5;
            } else {
                z6 = false;
            }
            if ((j & 2576) != 0) {
                TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f34764a, str2);
            }
            if ((2048 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((MallActivityApplyRefundBinding) this).f34764a, null, null, null, this.f10137a);
                TextViewBindingAdapter.setTextWatcher(this.f10139a, null, null, null, this.b);
            }
            if ((2564 & j) != 0) {
                CommonBindingAdapter.b0(((MallActivityApplyRefundBinding) this).f10125a, str3, requestOptions, false);
                TextViewBindingAdapter.setText(this.f, str);
                CommonBindingAdapter.e0(((MallActivityApplyRefundBinding) this).b, z3);
                TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f10128a, goodsName);
                TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f10133b, str4);
            }
            if ((j & 2624) != 0) {
                CommonBindingAdapter.l0(this.d, zSafeUnbox);
                CommonBindingAdapter.l0(this.f10138a, z2);
            }
            if ((j & 3072) != 0) {
                CommonBindingAdapter.q(this.d, cVar, null);
                CommonBindingAdapter.q(this.e, eVar, null);
                CommonBindingAdapter.q(((MallActivityApplyRefundBinding) this).f10132a, dVarA, null);
            }
            if ((2816 & j) != 0) {
                CommonBindingAdapter.g(this.f10138a, applyRefundFileAdapter, false, false);
            }
            if ((j & 2561) != 0) {
                TextViewBindingAdapter.setText(this.e, str6);
            }
            if ((j & 2562) != 0) {
                TextViewBindingAdapter.setText(this.f10139a, str7);
                TextViewBindingAdapter.setText(this.g, str5);
            }
            if ((j & 2688) != 0) {
                ((MallActivityApplyRefundBinding) this).f10129a.k(bindingTitleBean);
            }
            if (j3 != 0) {
                CommonBindingAdapter.e0(((MallActivityApplyRefundBinding) this).f10132a, z6);
            }
            ViewDataBinding.executeBindingsOn(((MallActivityApplyRefundBinding) this).f10129a);
        }
        cVar = cVar;
        eVar = eVar;
        j2 = j & 2571;
        if (j2 != 0) {
            if (!z) {
                z4 = false;
            }
            if (j2 != 0) {
                if (z4) {
                    j |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                } else {
                    j |= PlaybackStateCompat.ACTION_PREPARE;
                }
            }
        } else {
            z4 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            if (applyRefundVM != null) {
                mutableLiveDataP = applyRefundVM.p();
            }
            mutableLiveData2 = mutableLiveDataP;
            updateLiveDataRegistration(1, mutableLiveData2);
            if (mutableLiveData2 != null) {
                value2 = mutableLiveData2.getValue();
            }
            if (value2 != null) {
                length = value2.length();
            } else {
                length = 0;
            }
            if (length > 0) {
            }
            str7 = value2;
        } else {
            str7 = value2;
            z5 = false;
        }
        j3 = j & 2571;
        if (j3 != 0) {
            if (!z4) {
                z5 = false;
            }
            z6 = z5;
        } else {
            z6 = false;
        }
        if ((j & 2576) != 0) {
            TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f34764a, str2);
        }
        if ((2048 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((MallActivityApplyRefundBinding) this).f34764a, null, null, null, this.f10137a);
            TextViewBindingAdapter.setTextWatcher(this.f10139a, null, null, null, this.b);
        }
        if ((2564 & j) != 0) {
            CommonBindingAdapter.b0(((MallActivityApplyRefundBinding) this).f10125a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(this.f, str);
            CommonBindingAdapter.e0(((MallActivityApplyRefundBinding) this).b, z3);
            TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f10128a, goodsName);
            TextViewBindingAdapter.setText(((MallActivityApplyRefundBinding) this).f10133b, str4);
        }
        if ((j & 2624) != 0) {
            CommonBindingAdapter.l0(this.d, zSafeUnbox);
            CommonBindingAdapter.l0(this.f10138a, z2);
        }
        if ((j & 3072) != 0) {
            CommonBindingAdapter.q(this.d, cVar, null);
            CommonBindingAdapter.q(this.e, eVar, null);
            CommonBindingAdapter.q(((MallActivityApplyRefundBinding) this).f10132a, dVarA, null);
        }
        if ((2816 & j) != 0) {
            CommonBindingAdapter.g(this.f10138a, applyRefundFileAdapter, false, false);
        }
        if ((j & 2561) != 0) {
            TextViewBindingAdapter.setText(this.e, str6);
        }
        if ((j & 2562) != 0) {
            TextViewBindingAdapter.setText(this.f10139a, str7);
            TextViewBindingAdapter.setText(this.g, str5);
        }
        if ((j & 2688) != 0) {
            ((MallActivityApplyRefundBinding) this).f10129a.k(bindingTitleBean);
        }
        if (j3 != 0) {
            CommonBindingAdapter.e0(((MallActivityApplyRefundBinding) this).f10132a, z6);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityApplyRefundBinding) this).f10129a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10135a != 0) {
                return true;
            }
            return ((MallActivityApplyRefundBinding) this).f10129a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10135a = 2048L;
        }
        ((MallActivityApplyRefundBinding) this).f10129a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityApplyRefundBinding
    public void l(@Nullable ApplyRefundActivity.ClickProxy clickProxy) {
        ((MallActivityApplyRefundBinding) this).f10130a = clickProxy;
        synchronized (this) {
            this.f10135a |= 1024;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityApplyRefundBinding
    public void m(@Nullable ApplyRefundVM applyRefundVM) {
        ((MallActivityApplyRefundBinding) this).f10131a = applyRefundVM;
        synchronized (this) {
            this.f10135a |= 512;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return s((MutableLiveData) obj, i2);
            case 1:
                return t((MutableLiveData) obj, i2);
            case 2:
                return p((MutableLiveData) obj, i2);
            case 3:
                return u((MutableLiveData) obj, i2);
            case 4:
                return r((MutableLiveData) obj, i2);
            case 5:
                return o((LayoutToolbarBindingBinding) obj, i2);
            case 6:
                return v((MutableLiveData) obj, i2);
            case 7:
                return w((MutableLiveData) obj, i2);
            case 8:
                return q((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<OrderGoodsBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<ApplyRefundFileAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 256;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 16;
        }
        return true;
    }

    public final boolean s(MutableLiveData<OrderReasonBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityApplyRefundBinding) this).f10129a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((ApplyRefundVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((ApplyRefundActivity.ClickProxy) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 2;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 8;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 64;
        }
        return true;
    }

    public final boolean w(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10135a |= 128;
        }
        return true;
    }

    public MallActivityApplyRefundBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (EditText) objArr[6], (ImageView) objArr[1], (RadioButton) objArr[16], (RadioButton) objArr[4], (RadioGroup) objArr[15], (LayoutToolbarBindingBinding) objArr[13], (BLTextView) objArr[12], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[14]);
        this.f10137a = new a();
        this.b = new b();
        this.f10135a = -1L;
        ((MallActivityApplyRefundBinding) this).f34764a.setTag(null);
        ((MallActivityApplyRefundBinding) this).f10125a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10136a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.d = textView;
        textView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[11];
        this.f10138a = recyclerView;
        recyclerView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.e = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.f = textView3;
        textView3.setTag(null);
        NestedEditTextView nestedEditTextView = (NestedEditTextView) objArr[8];
        this.f10139a = nestedEditTextView;
        nestedEditTextView.setTag(null);
        TextView textView4 = (TextView) objArr[9];
        this.g = textView4;
        textView4.setTag(null);
        ((MallActivityApplyRefundBinding) this).b.setTag(null);
        setContainedBinding(((MallActivityApplyRefundBinding) this).f10129a);
        ((MallActivityApplyRefundBinding) this).f10132a.setTag(null);
        ((MallActivityApplyRefundBinding) this).f10128a.setTag(null);
        ((MallActivityApplyRefundBinding) this).f10133b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
