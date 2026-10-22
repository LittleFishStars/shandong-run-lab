package com.huachenjie.mall.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationDialog;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationVM;
import com.huachenjie.mall.widget.PriceView;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogGoodsSpecificationBindingImpl extends MallDialogGoodsSpecificationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10576a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f10584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10585a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final PriceView f10586b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLImageView f10587b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f10588b;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsSpecificationDialog.a f34918a;

        public a a(GoodsSpecificationDialog.a aVar) {
            this.f34918a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34918a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsSpecificationDialog.a f34919a;

        public b a(GoodsSpecificationDialog.a aVar) {
            this.f34919a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34919a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsSpecificationDialog.a f34920a;

        public c a(GoodsSpecificationDialog.a aVar) {
            this.f34920a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34920a.d(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsSpecificationDialog.a f34921a;

        public d a(GoodsSpecificationDialog.a aVar) {
            this.f34921a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34921a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34917a = sparseIntArray;
        sparseIntArray.put(R.id.tv_sel_title, 17);
        sparseIntArray.put(R.id.ll_num, 18);
        sparseIntArray.put(R.id.ll_spec, 19);
        sparseIntArray.put(R.id.cv_bottom, 20);
    }

    public MallDialogGoodsSpecificationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 21, f10576a, f34917a));
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:111:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:115:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:117:0x01cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:119:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:120:0x01db  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:125:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:128:0x0200  */
    /* JADX WARN: Code duplicated, block: B:129:0x0207  */
    /* JADX WARN: Code duplicated, block: B:133:0x0214 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x0216  */
    /* JADX WARN: Code duplicated, block: B:135:0x021d  */
    /* JADX WARN: Code duplicated, block: B:138:0x0227  */
    /* JADX WARN: Code duplicated, block: B:139:0x022e  */
    /* JADX WARN: Code duplicated, block: B:143:0x0239 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x023b  */
    /* JADX WARN: Code duplicated, block: B:145:0x0248  */
    /* JADX WARN: Code duplicated, block: B:148:0x0254  */
    /* JADX WARN: Code duplicated, block: B:149:0x025b  */
    /* JADX WARN: Code duplicated, block: B:152:0x0264  */
    /* JADX WARN: Code duplicated, block: B:153:0x0266  */
    /* JADX WARN: Code duplicated, block: B:155:0x0269 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:156:0x026b  */
    /* JADX WARN: Code duplicated, block: B:157:0x0271  */
    /* JADX WARN: Code duplicated, block: B:160:0x0280  */
    /* JADX WARN: Code duplicated, block: B:162:0x0283  */
    /* JADX WARN: Code duplicated, block: B:163:0x0286  */
    /* JADX WARN: Code duplicated, block: B:165:0x028a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x028c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0292  */
    /* JADX WARN: Code duplicated, block: B:169:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:16:0x0047  */
    /* JADX WARN: Code duplicated, block: B:171:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:238:0x0423 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:240:0x0426  */
    /* JADX WARN: Code duplicated, block: B:242:0x042a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:243:0x042c  */
    /* JADX WARN: Code duplicated, block: B:244:0x042f  */
    /* JADX WARN: Code duplicated, block: B:245:0x0435  */
    /* JADX WARN: Code duplicated, block: B:248:0x043f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:249:0x0441  */
    /* JADX WARN: Code duplicated, block: B:250:0x0444  */
    /* JADX WARN: Code duplicated, block: B:252:0x0448 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:253:0x044a  */
    /* JADX WARN: Code duplicated, block: B:254:0x0450  */
    /* JADX WARN: Code duplicated, block: B:257:0x0459  */
    /* JADX WARN: Code duplicated, block: B:258:0x045d  */
    /* JADX WARN: Code duplicated, block: B:259:0x0461  */
    /* JADX WARN: Code duplicated, block: B:262:0x046b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:263:0x046d  */
    /* JADX WARN: Code duplicated, block: B:265:0x0470 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:266:0x0472  */
    /* JADX WARN: Code duplicated, block: B:267:0x0476  */
    /* JADX WARN: Code duplicated, block: B:269:0x047c  */
    /* JADX WARN: Code duplicated, block: B:272:0x0485 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:273:0x0487  */
    /* JADX WARN: Code duplicated, block: B:274:0x0494  */
    /* JADX WARN: Code duplicated, block: B:277:0x049f  */
    /* JADX WARN: Code duplicated, block: B:278:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:280:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:283:0x04bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:284:0x04be  */
    /* JADX WARN: Code duplicated, block: B:285:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:288:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:290:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:293:0x04df  */
    /* JADX WARN: Code duplicated, block: B:294:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:298:0x04ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:299:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:301:0x04f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:302:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:303:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:305:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:308:0x0505 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x050a  */
    /* JADX WARN: Code duplicated, block: B:313:0x0514 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:314:0x0516  */
    /* JADX WARN: Code duplicated, block: B:316:0x051c  */
    /* JADX WARN: Code duplicated, block: B:319:0x0525  */
    /* JADX WARN: Code duplicated, block: B:320:0x0527  */
    /* JADX WARN: Code duplicated, block: B:321:0x0529  */
    /* JADX WARN: Code duplicated, block: B:324:0x0533 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:325:0x0535  */
    /* JADX WARN: Code duplicated, block: B:326:0x0538  */
    /* JADX WARN: Code duplicated, block: B:328:0x053c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:329:0x053e  */
    /* JADX WARN: Code duplicated, block: B:330:0x0542  */
    /* JADX WARN: Code duplicated, block: B:333:0x0549  */
    /* JADX WARN: Code duplicated, block: B:334:0x054d  */
    /* JADX WARN: Code duplicated, block: B:335:0x0551  */
    /* JADX WARN: Code duplicated, block: B:338:0x055a  */
    /* JADX WARN: Code duplicated, block: B:341:0x0580  */
    /* JADX WARN: Code duplicated, block: B:344:0x058c  */
    /* JADX WARN: Code duplicated, block: B:347:0x0599  */
    /* JADX WARN: Code duplicated, block: B:350:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:353:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:356:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:359:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:362:0x060f  */
    /* JADX WARN: Code duplicated, block: B:365:0x0624  */
    /* JADX WARN: Code duplicated, block: B:368:0x0631  */
    /* JADX WARN: Code duplicated, block: B:371:0x063f  */
    /* JADX WARN: Code duplicated, block: B:374:0x064d  */
    /* JADX WARN: Code duplicated, block: B:377:0x065a  */
    /* JADX WARN: Code duplicated, block: B:384:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x013b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        int i;
        String value;
        boolean z2;
        String activityPriceLabel;
        String strI;
        boolean z3;
        boolean z4;
        boolean zSafeUnbox;
        String value2;
        int type;
        MutableLiveData<GoodsDetailSku> mutableLiveData;
        String value3;
        String value4;
        GoodsDetailBean goodsDetailBeanM;
        String str2;
        boolean zIsEmpty;
        boolean z5;
        boolean z6;
        int i2;
        String value5;
        GoodsDetailSku value6;
        boolean z7;
        String value7;
        c cVarA;
        b bVar;
        d dVar;
        a aVar;
        String str3;
        boolean z8;
        MutableLiveData<GoodsDetailSku> mutableLiveDataU;
        boolean z9;
        int availableStock;
        boolean z10;
        long j2;
        long j3;
        int i3;
        long j4;
        boolean zSafeUnbox2;
        boolean z11;
        boolean z12;
        long j5;
        boolean z13;
        boolean z14;
        long j6;
        int i4;
        boolean z15;
        long j7;
        long j8;
        MutableLiveData<GoodsDetailSku> mutableLiveDataU2;
        MutableLiveData<Boolean> mutableLiveDataJ;
        Boolean value8;
        long j9;
        boolean z16;
        long j10;
        GoodsDetailBean goodsDetailBeanM2;
        int iSafeUnbox;
        long j11;
        MutableLiveData<GoodsDetailSku> mutableLiveDataU3;
        String value9;
        long j12;
        MutableLiveData<Integer> mutableLiveDataP;
        Integer value10;
        int iSafeUnbox2;
        boolean z17;
        long j13;
        boolean z18;
        MutableLiveData<String> mutableLiveDataK;
        MutableLiveData<String> mutableLiveDataR;
        int i5;
        int i6;
        synchronized (this) {
            j = this.f10577a;
            this.f10577a = 0L;
        }
        GoodsSpecificationVM goodsSpecificationVM = ((MallDialogGoodsSpecificationBinding) this).f10572a;
        GoodsSpecificationDialog.a aVar2 = ((MallDialogGoodsSpecificationBinding) this).f10571a;
        if ((24575 & j) != 0) {
            if ((j & 20481) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = goodsSpecificationVM != null ? goodsSpecificationVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value5 = mutableLiveDataL.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 20482) != 0) {
                MutableLiveData<Boolean> mutableLiveDataS = goodsSpecificationVM != null ? goodsSpecificationVM.s() : null;
                updateLiveDataRegistration(1, mutableLiveDataS);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataS != null ? mutableLiveDataS.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 20480) != 0) {
                if (goodsSpecificationVM != null) {
                    strI = goodsSpecificationVM.i();
                    goodsDetailBeanM2 = goodsSpecificationVM.m();
                } else {
                    strI = null;
                    goodsDetailBeanM2 = null;
                }
                if (goodsDetailBeanM2 != null) {
                    int type2 = goodsDetailBeanM2.getType();
                    int limitBuy = goodsDetailBeanM2.getLimitBuy();
                    activityPriceLabel = goodsDetailBeanM2.getActivityPriceLabel();
                    type = type2;
                    i6 = limitBuy;
                } else {
                    type = 0;
                    i6 = 0;
                    activityPriceLabel = null;
                }
                z3 = type != 2;
                z2 = i6 > 0;
                str = String.format("(限购%d件)", Integer.valueOf(i6));
                z = !TextUtils.isEmpty(activityPriceLabel);
            } else {
                type = 0;
                z = false;
                z3 = false;
                z2 = false;
                str = null;
                strI = null;
                goodsDetailBeanM2 = null;
                activityPriceLabel = null;
            }
            long j14 = j & 20484;
            if (j14 != 0) {
                MutableLiveData<String> mutableLiveDataW = goodsSpecificationVM != null ? goodsSpecificationVM.w() : null;
                updateLiveDataRegistration(2, mutableLiveDataW);
                value3 = mutableLiveDataW != null ? mutableLiveDataW.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value3);
                if (j14 != 0) {
                    j |= zIsEmpty ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            } else {
                value3 = null;
                zIsEmpty = false;
            }
            if ((j & 20488) != 0) {
                MutableLiveData<String> mutableLiveDataT = goodsSpecificationVM != null ? goodsSpecificationVM.t() : null;
                updateLiveDataRegistration(3, mutableLiveDataT);
                value2 = mutableLiveDataT != null ? mutableLiveDataT.getValue() : null;
                z4 = !TextUtils.isEmpty(value2);
            } else {
                value2 = null;
                z4 = false;
            }
            if ((j & 20496) == 0) {
                value7 = null;
            } else {
                MutableLiveData<String> mutableLiveDataQ = goodsSpecificationVM != null ? goodsSpecificationVM.q() : null;
                updateLiveDataRegistration(4, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value7 = mutableLiveDataQ.getValue();
                } else {
                    value7 = null;
                }
            }
            if ((j & 20992) != 0) {
                BaseViewModel.b bVarE = goodsSpecificationVM != null ? goodsSpecificationVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(9, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 8));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 20512) != 0) {
                MutableLiveData<String> mutableLiveDataO = goodsSpecificationVM != null ? goodsSpecificationVM.o() : null;
                updateLiveDataRegistration(5, mutableLiveDataO);
                value = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                j11 = j & 20672;
                if (j11 != 0) {
                    if (goodsSpecificationVM != null) {
                        i5 = 7;
                        mutableLiveDataU3 = goodsSpecificationVM.u();
                    } else {
                        mutableLiveDataU3 = null;
                        i5 = 7;
                    }
                    updateLiveDataRegistration(i5, mutableLiveDataU3);
                    if (mutableLiveDataU3 != null) {
                        value6 = mutableLiveDataU3.getValue();
                    } else {
                        value6 = null;
                    }
                    if (value6 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (j11 != 0) {
                        if (z6) {
                            j |= 262144;
                        } else {
                            j |= 131072;
                        }
                    }
                } else {
                    value = value;
                    iSafeUnbox = iSafeUnbox;
                    mutableLiveDataU3 = null;
                    value6 = null;
                    z6 = false;
                }
                if ((j & 20736) != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataR = goodsSpecificationVM.r();
                    } else {
                        mutableLiveDataR = null;
                    }
                    updateLiveDataRegistration(8, mutableLiveDataR);
                    value4 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                    if ((j & 21504) != 0) {
                        if (goodsSpecificationVM != null) {
                            mutableLiveDataK = goodsSpecificationVM.k();
                        } else {
                            mutableLiveDataK = null;
                        }
                        updateLiveDataRegistration(10, mutableLiveDataK);
                        value9 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                        j12 = j & 22656;
                        if (j12 != 0) {
                            if (goodsSpecificationVM != null) {
                                mutableLiveDataP = goodsSpecificationVM.p();
                            } else {
                                mutableLiveDataP = null;
                            }
                            updateLiveDataRegistration(11, mutableLiveDataP);
                            if (mutableLiveDataP != null) {
                                value10 = mutableLiveDataP.getValue();
                            } else {
                                value10 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                            if (iSafeUnbox2 == 99) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (j12 != 0) {
                                if (z17) {
                                    j |= FileUtils.ONE_GB;
                                } else {
                                    j |= 536870912;
                                }
                            }
                            j13 = j & 22528;
                            z7 = z17;
                            if (j13 != 0) {
                                if (iSafeUnbox2 == 1) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (j13 != 0) {
                                    if (z18) {
                                        j |= 16777216;
                                    } else {
                                        j |= 8388608;
                                    }
                                }
                                z5 = z18;
                            } else {
                                z5 = false;
                            }
                            str2 = value9;
                            i = iSafeUnbox2;
                        } else {
                            value6 = value6;
                            str = str;
                            z4 = z4;
                            value7 = value7;
                            value = value;
                            z5 = false;
                            z7 = false;
                            value2 = value2;
                            strI = strI;
                            zIsEmpty = zIsEmpty;
                            str2 = value9;
                            i = 0;
                        }
                        goodsDetailBeanM = goodsDetailBeanM2;
                        mutableLiveData = mutableLiveDataU3;
                        i2 = iSafeUnbox;
                    } else {
                        value4 = value4;
                    }
                    j12 = j & 22656;
                    if (j12 != 0) {
                        if (goodsSpecificationVM != null) {
                            mutableLiveDataP = goodsSpecificationVM.p();
                        } else {
                            mutableLiveDataP = null;
                        }
                        updateLiveDataRegistration(11, mutableLiveDataP);
                        if (mutableLiveDataP != null) {
                            value10 = mutableLiveDataP.getValue();
                        } else {
                            value10 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                        if (iSafeUnbox2 == 99) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (j12 != 0) {
                            if (z17) {
                                j |= FileUtils.ONE_GB;
                            } else {
                                j |= 536870912;
                            }
                        }
                        j13 = j & 22528;
                        z7 = z17;
                        if (j13 != 0) {
                            if (iSafeUnbox2 == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (j13 != 0) {
                                if (z18) {
                                    j |= 16777216;
                                } else {
                                    j |= 8388608;
                                }
                            }
                            z5 = z18;
                        } else {
                            z5 = false;
                        }
                        str2 = value9;
                        i = iSafeUnbox2;
                    } else {
                        value6 = value6;
                        str = str;
                        z4 = z4;
                        value7 = value7;
                        value = value;
                        z5 = false;
                        z7 = false;
                        value2 = value2;
                        strI = strI;
                        zIsEmpty = zIsEmpty;
                        str2 = value9;
                        i = 0;
                    }
                    goodsDetailBeanM = goodsDetailBeanM2;
                    mutableLiveData = mutableLiveDataU3;
                    i2 = iSafeUnbox;
                } else {
                    mutableLiveDataU3 = mutableLiveDataU3;
                }
                if ((j & 21504) != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataK = goodsSpecificationVM.k();
                    } else {
                        mutableLiveDataK = null;
                    }
                    updateLiveDataRegistration(10, mutableLiveDataK);
                    if (mutableLiveDataK != null) {
                    }
                    j12 = j & 22656;
                    if (j12 != 0) {
                        if (goodsSpecificationVM != null) {
                            mutableLiveDataP = goodsSpecificationVM.p();
                        } else {
                            mutableLiveDataP = null;
                        }
                        updateLiveDataRegistration(11, mutableLiveDataP);
                        if (mutableLiveDataP != null) {
                            value10 = mutableLiveDataP.getValue();
                        } else {
                            value10 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                        if (iSafeUnbox2 == 99) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (j12 != 0) {
                            if (z17) {
                                j |= FileUtils.ONE_GB;
                            } else {
                                j |= 536870912;
                            }
                        }
                        j13 = j & 22528;
                        z7 = z17;
                        if (j13 != 0) {
                            if (iSafeUnbox2 == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (j13 != 0) {
                                if (z18) {
                                    j |= 16777216;
                                } else {
                                    j |= 8388608;
                                }
                            }
                            z5 = z18;
                        } else {
                            z5 = false;
                        }
                        str2 = value9;
                        i = iSafeUnbox2;
                    } else {
                        value6 = value6;
                        str = str;
                        z4 = z4;
                        value7 = value7;
                        value = value;
                        z5 = false;
                        z7 = false;
                        value2 = value2;
                        strI = strI;
                        zIsEmpty = zIsEmpty;
                        str2 = value9;
                        i = 0;
                    }
                    goodsDetailBeanM = goodsDetailBeanM2;
                    mutableLiveData = mutableLiveDataU3;
                    i2 = iSafeUnbox;
                } else {
                    value4 = value4;
                }
                j12 = j & 22656;
                if (j12 != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataP = goodsSpecificationVM.p();
                    } else {
                        mutableLiveDataP = null;
                    }
                    updateLiveDataRegistration(11, mutableLiveDataP);
                    if (mutableLiveDataP != null) {
                        value10 = mutableLiveDataP.getValue();
                    } else {
                        value10 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                    if (iSafeUnbox2 == 99) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (j12 != 0) {
                        if (z17) {
                            j |= FileUtils.ONE_GB;
                        } else {
                            j |= 536870912;
                        }
                    }
                    j13 = j & 22528;
                    z7 = z17;
                    if (j13 != 0) {
                        if (iSafeUnbox2 == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (j13 != 0) {
                            if (z18) {
                                j |= 16777216;
                            } else {
                                j |= 8388608;
                            }
                        }
                        z5 = z18;
                    } else {
                        z5 = false;
                    }
                    str2 = value9;
                    i = iSafeUnbox2;
                } else {
                    value6 = value6;
                    str = str;
                    z4 = z4;
                    value7 = value7;
                    value = value;
                    z5 = false;
                    z7 = false;
                    value2 = value2;
                    strI = strI;
                    zIsEmpty = zIsEmpty;
                    str2 = value9;
                    i = 0;
                }
                goodsDetailBeanM = goodsDetailBeanM2;
                mutableLiveData = mutableLiveDataU3;
                i2 = iSafeUnbox;
            } else {
                value7 = value7;
            }
            j11 = j & 20672;
            if (j11 != 0) {
                if (goodsSpecificationVM != null) {
                    i5 = 7;
                    mutableLiveDataU3 = goodsSpecificationVM.u();
                } else {
                    mutableLiveDataU3 = null;
                    i5 = 7;
                }
                updateLiveDataRegistration(i5, mutableLiveDataU3);
                if (mutableLiveDataU3 != null) {
                    value6 = mutableLiveDataU3.getValue();
                } else {
                    value6 = null;
                }
                if (value6 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (j11 != 0) {
                    if (z6) {
                        j |= 262144;
                    } else {
                        j |= 131072;
                    }
                }
            } else {
                value = value;
                iSafeUnbox = iSafeUnbox;
                mutableLiveDataU3 = null;
                value6 = null;
                z6 = false;
            }
            if ((j & 20736) != 0) {
                if (goodsSpecificationVM != null) {
                    mutableLiveDataR = goodsSpecificationVM.r();
                } else {
                    mutableLiveDataR = null;
                }
                updateLiveDataRegistration(8, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                }
                if ((j & 21504) != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataK = goodsSpecificationVM.k();
                    } else {
                        mutableLiveDataK = null;
                    }
                    updateLiveDataRegistration(10, mutableLiveDataK);
                    if (mutableLiveDataK != null) {
                    }
                    j12 = j & 22656;
                    if (j12 != 0) {
                        if (goodsSpecificationVM != null) {
                            mutableLiveDataP = goodsSpecificationVM.p();
                        } else {
                            mutableLiveDataP = null;
                        }
                        updateLiveDataRegistration(11, mutableLiveDataP);
                        if (mutableLiveDataP != null) {
                            value10 = mutableLiveDataP.getValue();
                        } else {
                            value10 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                        if (iSafeUnbox2 == 99) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (j12 != 0) {
                            if (z17) {
                                j |= FileUtils.ONE_GB;
                            } else {
                                j |= 536870912;
                            }
                        }
                        j13 = j & 22528;
                        z7 = z17;
                        if (j13 != 0) {
                            if (iSafeUnbox2 == 1) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (j13 != 0) {
                                if (z18) {
                                    j |= 16777216;
                                } else {
                                    j |= 8388608;
                                }
                            }
                            z5 = z18;
                        } else {
                            z5 = false;
                        }
                        str2 = value9;
                        i = iSafeUnbox2;
                    } else {
                        value6 = value6;
                        str = str;
                        z4 = z4;
                        value7 = value7;
                        value = value;
                        z5 = false;
                        z7 = false;
                        value2 = value2;
                        strI = strI;
                        zIsEmpty = zIsEmpty;
                        str2 = value9;
                        i = 0;
                    }
                    goodsDetailBeanM = goodsDetailBeanM2;
                    mutableLiveData = mutableLiveDataU3;
                    i2 = iSafeUnbox;
                } else {
                    value4 = value4;
                }
                j12 = j & 22656;
                if (j12 != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataP = goodsSpecificationVM.p();
                    } else {
                        mutableLiveDataP = null;
                    }
                    updateLiveDataRegistration(11, mutableLiveDataP);
                    if (mutableLiveDataP != null) {
                        value10 = mutableLiveDataP.getValue();
                    } else {
                        value10 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                    if (iSafeUnbox2 == 99) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (j12 != 0) {
                        if (z17) {
                            j |= FileUtils.ONE_GB;
                        } else {
                            j |= 536870912;
                        }
                    }
                    j13 = j & 22528;
                    z7 = z17;
                    if (j13 != 0) {
                        if (iSafeUnbox2 == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (j13 != 0) {
                            if (z18) {
                                j |= 16777216;
                            } else {
                                j |= 8388608;
                            }
                        }
                        z5 = z18;
                    } else {
                        z5 = false;
                    }
                    str2 = value9;
                    i = iSafeUnbox2;
                } else {
                    value6 = value6;
                    str = str;
                    z4 = z4;
                    value7 = value7;
                    value = value;
                    z5 = false;
                    z7 = false;
                    value2 = value2;
                    strI = strI;
                    zIsEmpty = zIsEmpty;
                    str2 = value9;
                    i = 0;
                }
                goodsDetailBeanM = goodsDetailBeanM2;
                mutableLiveData = mutableLiveDataU3;
                i2 = iSafeUnbox;
            } else {
                mutableLiveDataU3 = mutableLiveDataU3;
            }
            if ((j & 21504) != 0) {
                if (goodsSpecificationVM != null) {
                    mutableLiveDataK = goodsSpecificationVM.k();
                } else {
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(10, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                }
                j12 = j & 22656;
                if (j12 != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataP = goodsSpecificationVM.p();
                    } else {
                        mutableLiveDataP = null;
                    }
                    updateLiveDataRegistration(11, mutableLiveDataP);
                    if (mutableLiveDataP != null) {
                        value10 = mutableLiveDataP.getValue();
                    } else {
                        value10 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                    if (iSafeUnbox2 == 99) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (j12 != 0) {
                        if (z17) {
                            j |= FileUtils.ONE_GB;
                        } else {
                            j |= 536870912;
                        }
                    }
                    j13 = j & 22528;
                    z7 = z17;
                    if (j13 != 0) {
                        if (iSafeUnbox2 == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (j13 != 0) {
                            if (z18) {
                                j |= 16777216;
                            } else {
                                j |= 8388608;
                            }
                        }
                        z5 = z18;
                    } else {
                        z5 = false;
                    }
                    str2 = value9;
                    i = iSafeUnbox2;
                } else {
                    value6 = value6;
                    str = str;
                    z4 = z4;
                    value7 = value7;
                    value = value;
                    z5 = false;
                    z7 = false;
                    value2 = value2;
                    strI = strI;
                    zIsEmpty = zIsEmpty;
                    str2 = value9;
                    i = 0;
                }
                goodsDetailBeanM = goodsDetailBeanM2;
                mutableLiveData = mutableLiveDataU3;
                i2 = iSafeUnbox;
            } else {
                value4 = value4;
            }
            j12 = j & 22656;
            if (j12 != 0) {
                if (goodsSpecificationVM != null) {
                    mutableLiveDataP = goodsSpecificationVM.p();
                } else {
                    mutableLiveDataP = null;
                }
                updateLiveDataRegistration(11, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value10 = mutableLiveDataP.getValue();
                } else {
                    value10 = null;
                }
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value10);
                if (iSafeUnbox2 == 99) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (j12 != 0) {
                    if (z17) {
                        j |= FileUtils.ONE_GB;
                    } else {
                        j |= 536870912;
                    }
                }
                j13 = j & 22528;
                z7 = z17;
                if (j13 != 0) {
                    if (iSafeUnbox2 == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (j13 != 0) {
                        if (z18) {
                            j |= 16777216;
                        } else {
                            j |= 8388608;
                        }
                    }
                    z5 = z18;
                } else {
                    z5 = false;
                }
                str2 = value9;
                i = iSafeUnbox2;
            } else {
                value6 = value6;
                str = str;
                z4 = z4;
                value7 = value7;
                value = value;
                z5 = false;
                z7 = false;
                value2 = value2;
                strI = strI;
                zIsEmpty = zIsEmpty;
                str2 = value9;
                i = 0;
            }
            goodsDetailBeanM = goodsDetailBeanM2;
            mutableLiveData = mutableLiveDataU3;
            i2 = iSafeUnbox;
        } else {
            z = false;
            str = null;
            i = 0;
            value = null;
            z2 = false;
            activityPriceLabel = null;
            strI = null;
            z3 = false;
            z4 = false;
            zSafeUnbox = false;
            value2 = null;
            type = 0;
            mutableLiveData = null;
            value3 = null;
            value4 = null;
            goodsDetailBeanM = null;
            str2 = null;
            zIsEmpty = false;
            z5 = false;
            z6 = false;
            i2 = 0;
            value5 = null;
            value6 = null;
            z7 = false;
            value7 = null;
        }
        if ((j & 24576) == 0 || aVar2 == null) {
            cVarA = null;
            bVar = null;
            dVar = null;
            aVar = null;
        } else {
            d dVar2 = this.f10581a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f10581a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            a aVar3 = this.f10578a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f10578a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f10579a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f10579a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar = this.f10580a;
            if (cVar == null) {
                cVar = new c();
                this.f10580a = cVar;
            }
            cVarA = cVar.a(aVar2);
            bVar = bVarA;
            dVar = dVarA;
            aVar = aVarA;
        }
        RequestOptions requestOptions = (j & 20512) != 0 ? ju3.p : null;
        if ((j & 20484) != 0) {
            if (zIsEmpty) {
                value3 = "请选择规格";
            }
            str3 = value3;
        } else {
            str3 = null;
        }
        if ((j & 8388608) != 0) {
            if (goodsSpecificationVM != null) {
                goodsDetailBeanM = goodsSpecificationVM.m();
            }
            if (goodsDetailBeanM != null) {
                type = goodsDetailBeanM.getType();
            }
            int i7 = type;
            z8 = i7 == 2;
            type = i7;
        } else {
            z8 = false;
        }
        if ((j & 537133056) != 0) {
            mutableLiveDataU = goodsSpecificationVM != null ? goodsSpecificationVM.u() : mutableLiveData;
            updateLiveDataRegistration(7, mutableLiveDataU);
            if (mutableLiveDataU != null) {
                value6 = mutableLiveDataU.getValue();
            }
            z9 = (j & 536870912) != 0 && value6 == null;
            if ((j & 262144) != 0) {
                availableStock = value6 != null ? value6.getAvailableStock() : 0;
                z10 = availableStock > 0;
                j2 = j & 20672;
                if (j2 != 0) {
                    if (!z6) {
                        z10 = false;
                    }
                    if (j2 != 0) {
                        if (z10) {
                            j |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                        } else {
                            j |= 2097152;
                        }
                    }
                } else {
                    z10 = false;
                }
                j3 = j & 22528;
                if (j3 != 0) {
                    if (z5) {
                        z16 = true;
                    } else {
                        z16 = z8;
                    }
                    if (j3 != 0) {
                        if (z16) {
                            j10 = 4294967296L;
                        } else {
                            j10 = 2147483648L;
                        }
                        j |= j10;
                    }
                    if (z16) {
                        i3 = RunIndexRecordAdapter.O;
                    } else {
                        i3 = -13877680;
                    }
                } else {
                    i3 = 0;
                }
                j4 = j & 22656;
                if (j4 != 0) {
                    if (z7) {
                        z9 = true;
                    }
                    if (j4 != 0) {
                        if (z9) {
                            j9 = 1048576;
                        } else {
                            j9 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        }
                        j |= j9;
                    }
                } else {
                    z9 = false;
                }
                if ((j & PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataJ = goodsSpecificationVM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                        value8 = mutableLiveDataJ.getValue();
                    } else {
                        value8 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(value8);
                } else {
                    zSafeUnbox = zSafeUnbox;
                    mutableLiveDataU = mutableLiveDataU;
                    zSafeUnbox2 = false;
                }
                if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                    if (goodsSpecificationVM != null) {
                        mutableLiveDataU2 = goodsSpecificationVM.u();
                    } else {
                        mutableLiveDataU2 = mutableLiveDataU;
                    }
                    z11 = zSafeUnbox2;
                    updateLiveDataRegistration(7, mutableLiveDataU2);
                    if (mutableLiveDataU2 != null) {
                        value6 = mutableLiveDataU2.getValue();
                    }
                    if (value6 != null) {
                        availableStock = value6.getAvailableStock();
                    }
                    z12 = availableStock <= i;
                    j5 = j & 22656;
                    if (j5 != 0) {
                        if (z9) {
                            z12 = true;
                        }
                        if (j5 != 0) {
                            if (z12) {
                                j8 = 67108864;
                            } else {
                                j8 = 33554432;
                            }
                            j |= j8;
                        }
                    } else {
                        z12 = false;
                    }
                    if ((j & 20672) == 0 && z10) {
                        z13 = z11;
                    } else {
                        z13 = false;
                    }
                    if ((j & 33554432) != 0) {
                        if (goodsSpecificationVM != null) {
                            goodsDetailBeanM = goodsSpecificationVM.m();
                        }
                        if (goodsDetailBeanM != null) {
                            type = goodsDetailBeanM.getType();
                        }
                        if (type == 2) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                    } else {
                        z14 = z8;
                    }
                    j6 = j & 22656;
                    if (j6 != 0) {
                        if (z12) {
                            z15 = true;
                        } else {
                            z15 = z14;
                        }
                        if (j6 != 0) {
                            if (z15) {
                                j7 = 268435456;
                            } else {
                                j7 = 134217728;
                            }
                            j |= j7;
                        }
                        if (z15) {
                            i4 = RunIndexRecordAdapter.O;
                        } else {
                            i4 = -13877680;
                        }
                    } else {
                        i4 = 0;
                    }
                    if ((j & 20480) != 0) {
                        CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
                        TextViewBindingAdapter.setText(this.d, str);
                        CommonBindingAdapter.l0(this.d, z2);
                        TextViewBindingAdapter.setText(this.f10585a, strI);
                        TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
                        CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
                    }
                    if ((j & 20512) != 0) {
                        CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
                    }
                    if ((j & 20482) != 0) {
                        CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
                    }
                    if ((j & 24576) != 0) {
                        CommonBindingAdapter.q(this.b, bVar, null);
                        CommonBindingAdapter.q(this.f10582a, dVar, 0L);
                        CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
                        CommonBindingAdapter.q(this.f10583a, aVar, null);
                    }
                    if ((j & 22528) != 0) {
                        CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
                    }
                    if ((j & 22656) != 0) {
                        CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
                    }
                    if ((j & 20672) != 0) {
                        CommonBindingAdapter.e0(this.f10583a, z13);
                        CommonBindingAdapter.e0(this.f10585a, z13);
                        CommonBindingAdapter.e0(this.e, z13);
                    }
                    if ((20992 & j) != 0) {
                        CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
                    }
                    if ((j & 20488) != 0) {
                        TextViewBindingAdapter.setText(this.e, value2);
                        CommonBindingAdapter.l0(this.e, z4);
                    }
                    if ((20496 & j) != 0) {
                        TextViewBindingAdapter.setText(this.f10586b, value7);
                    }
                    if ((j & 20481) != 0) {
                        TextViewBindingAdapter.setText(this.f, value5);
                    }
                    if ((21504 & j) != 0) {
                        TextViewBindingAdapter.setText(this.f10588b, str2);
                    }
                    if ((20736 & j) != 0) {
                        TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
                    }
                    if ((j & 20484) != 0) {
                        TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
                    }
                }
                z11 = zSafeUnbox2;
                j5 = j & 22656;
                if (j5 != 0) {
                    if (z9) {
                        z12 = true;
                    }
                    if (j5 != 0) {
                        if (z12) {
                            j8 = 67108864;
                        } else {
                            j8 = 33554432;
                        }
                        j |= j8;
                    }
                } else {
                    z12 = false;
                }
                if ((j & 20672) == 0) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if ((j & 33554432) != 0) {
                    if (goodsSpecificationVM != null) {
                        goodsDetailBeanM = goodsSpecificationVM.m();
                    }
                    if (goodsDetailBeanM != null) {
                        type = goodsDetailBeanM.getType();
                    }
                    if (type == 2) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                } else {
                    z14 = z8;
                }
                j6 = j & 22656;
                if (j6 != 0) {
                    if (z12) {
                        z15 = true;
                    } else {
                        z15 = z14;
                    }
                    if (j6 != 0) {
                        if (z15) {
                            j7 = 268435456;
                        } else {
                            j7 = 134217728;
                        }
                        j |= j7;
                    }
                    if (z15) {
                        i4 = RunIndexRecordAdapter.O;
                    } else {
                        i4 = -13877680;
                    }
                } else {
                    i4 = 0;
                }
                if ((j & 20480) != 0) {
                    CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
                    TextViewBindingAdapter.setText(this.d, str);
                    CommonBindingAdapter.l0(this.d, z2);
                    TextViewBindingAdapter.setText(this.f10585a, strI);
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
                    CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
                }
                if ((j & 20512) != 0) {
                    CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
                }
                if ((j & 20482) != 0) {
                    CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
                }
                if ((j & 24576) != 0) {
                    CommonBindingAdapter.q(this.b, bVar, null);
                    CommonBindingAdapter.q(this.f10582a, dVar, 0L);
                    CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
                    CommonBindingAdapter.q(this.f10583a, aVar, null);
                }
                if ((j & 22528) != 0) {
                    CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
                }
                if ((j & 22656) != 0) {
                    CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
                }
                if ((j & 20672) != 0) {
                    CommonBindingAdapter.e0(this.f10583a, z13);
                    CommonBindingAdapter.e0(this.f10585a, z13);
                    CommonBindingAdapter.e0(this.e, z13);
                }
                if ((20992 & j) != 0) {
                    CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
                }
                if ((j & 20488) != 0) {
                    TextViewBindingAdapter.setText(this.e, value2);
                    CommonBindingAdapter.l0(this.e, z4);
                }
                if ((20496 & j) != 0) {
                    TextViewBindingAdapter.setText(this.f10586b, value7);
                }
                if ((j & 20481) != 0) {
                    TextViewBindingAdapter.setText(this.f, value5);
                }
                if ((21504 & j) != 0) {
                    TextViewBindingAdapter.setText(this.f10588b, str2);
                }
                if ((20736 & j) != 0) {
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
                }
                if ((j & 20484) != 0) {
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
                }
            }
            j2 = j & 20672;
            if (j2 != 0) {
                if (!z6) {
                    z10 = false;
                }
                if (j2 != 0) {
                    if (z10) {
                        j |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                    } else {
                        j |= 2097152;
                    }
                }
            } else {
                z10 = false;
            }
            j3 = j & 22528;
            if (j3 != 0) {
                if (z5) {
                    z16 = true;
                } else {
                    z16 = z8;
                }
                if (j3 != 0) {
                    if (z16) {
                        j10 = 4294967296L;
                    } else {
                        j10 = 2147483648L;
                    }
                    j |= j10;
                }
                if (z16) {
                    i3 = RunIndexRecordAdapter.O;
                } else {
                    i3 = -13877680;
                }
            } else {
                i3 = 0;
            }
            j4 = j & 22656;
            if (j4 != 0) {
                if (z7) {
                    z9 = true;
                }
                if (j4 != 0) {
                    if (z9) {
                        j9 = 1048576;
                    } else {
                        j9 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    }
                    j |= j9;
                }
            } else {
                z9 = false;
            }
            if ((j & PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) != 0) {
                if (goodsSpecificationVM != null) {
                    mutableLiveDataJ = goodsSpecificationVM.j();
                } else {
                    mutableLiveDataJ = null;
                }
                updateLiveDataRegistration(6, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value8 = mutableLiveDataJ.getValue();
                } else {
                    value8 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(value8);
            } else {
                zSafeUnbox = zSafeUnbox;
                mutableLiveDataU = mutableLiveDataU;
                zSafeUnbox2 = false;
            }
            if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
                if (goodsSpecificationVM != null) {
                    mutableLiveDataU2 = goodsSpecificationVM.u();
                } else {
                    mutableLiveDataU2 = mutableLiveDataU;
                }
                z11 = zSafeUnbox2;
                updateLiveDataRegistration(7, mutableLiveDataU2);
                if (mutableLiveDataU2 != null) {
                    value6 = mutableLiveDataU2.getValue();
                }
                if (value6 != null) {
                    availableStock = value6.getAvailableStock();
                }
                if (availableStock <= i) {
                }
                j5 = j & 22656;
                if (j5 != 0) {
                    if (z9) {
                        z12 = true;
                    }
                    if (j5 != 0) {
                        if (z12) {
                            j8 = 67108864;
                        } else {
                            j8 = 33554432;
                        }
                        j |= j8;
                    }
                } else {
                    z12 = false;
                }
                if ((j & 20672) == 0) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if ((j & 33554432) != 0) {
                    if (goodsSpecificationVM != null) {
                        goodsDetailBeanM = goodsSpecificationVM.m();
                    }
                    if (goodsDetailBeanM != null) {
                        type = goodsDetailBeanM.getType();
                    }
                    if (type == 2) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                } else {
                    z14 = z8;
                }
                j6 = j & 22656;
                if (j6 != 0) {
                    if (z12) {
                        z15 = true;
                    } else {
                        z15 = z14;
                    }
                    if (j6 != 0) {
                        if (z15) {
                            j7 = 268435456;
                        } else {
                            j7 = 134217728;
                        }
                        j |= j7;
                    }
                    if (z15) {
                        i4 = RunIndexRecordAdapter.O;
                    } else {
                        i4 = -13877680;
                    }
                } else {
                    i4 = 0;
                }
                if ((j & 20480) != 0) {
                    CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
                    TextViewBindingAdapter.setText(this.d, str);
                    CommonBindingAdapter.l0(this.d, z2);
                    TextViewBindingAdapter.setText(this.f10585a, strI);
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
                    CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
                }
                if ((j & 20512) != 0) {
                    CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
                }
                if ((j & 20482) != 0) {
                    CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
                }
                if ((j & 24576) != 0) {
                    CommonBindingAdapter.q(this.b, bVar, null);
                    CommonBindingAdapter.q(this.f10582a, dVar, 0L);
                    CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
                    CommonBindingAdapter.q(this.f10583a, aVar, null);
                }
                if ((j & 22528) != 0) {
                    CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
                }
                if ((j & 22656) != 0) {
                    CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
                }
                if ((j & 20672) != 0) {
                    CommonBindingAdapter.e0(this.f10583a, z13);
                    CommonBindingAdapter.e0(this.f10585a, z13);
                    CommonBindingAdapter.e0(this.e, z13);
                }
                if ((20992 & j) != 0) {
                    CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
                }
                if ((j & 20488) != 0) {
                    TextViewBindingAdapter.setText(this.e, value2);
                    CommonBindingAdapter.l0(this.e, z4);
                }
                if ((20496 & j) != 0) {
                    TextViewBindingAdapter.setText(this.f10586b, value7);
                }
                if ((j & 20481) != 0) {
                    TextViewBindingAdapter.setText(this.f, value5);
                }
                if ((21504 & j) != 0) {
                    TextViewBindingAdapter.setText(this.f10588b, str2);
                }
                if ((20736 & j) != 0) {
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
                }
                if ((j & 20484) != 0) {
                    TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
                }
            }
            z11 = zSafeUnbox2;
            j5 = j & 22656;
            if (j5 != 0) {
                if (z9) {
                    z12 = true;
                }
                if (j5 != 0) {
                    if (z12) {
                        j8 = 67108864;
                    } else {
                        j8 = 33554432;
                    }
                    j |= j8;
                }
            } else {
                z12 = false;
            }
            if ((j & 20672) == 0) {
                z13 = false;
            } else {
                z13 = false;
            }
            if ((j & 33554432) != 0) {
                if (goodsSpecificationVM != null) {
                    goodsDetailBeanM = goodsSpecificationVM.m();
                }
                if (goodsDetailBeanM != null) {
                    type = goodsDetailBeanM.getType();
                }
                if (type == 2) {
                    z14 = true;
                } else {
                    z14 = false;
                }
            } else {
                z14 = z8;
            }
            j6 = j & 22656;
            if (j6 != 0) {
                if (z12) {
                    z15 = true;
                } else {
                    z15 = z14;
                }
                if (j6 != 0) {
                    if (z15) {
                        j7 = 268435456;
                    } else {
                        j7 = 134217728;
                    }
                    j |= j7;
                }
                if (z15) {
                    i4 = RunIndexRecordAdapter.O;
                } else {
                    i4 = -13877680;
                }
            } else {
                i4 = 0;
            }
            if ((j & 20480) != 0) {
                CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
                TextViewBindingAdapter.setText(this.d, str);
                CommonBindingAdapter.l0(this.d, z2);
                TextViewBindingAdapter.setText(this.f10585a, strI);
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
                CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
            }
            if ((j & 20512) != 0) {
                CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
            }
            if ((j & 20482) != 0) {
                CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
            }
            if ((j & 24576) != 0) {
                CommonBindingAdapter.q(this.b, bVar, null);
                CommonBindingAdapter.q(this.f10582a, dVar, 0L);
                CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
                CommonBindingAdapter.q(this.f10583a, aVar, null);
            }
            if ((j & 22528) != 0) {
                CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
            }
            if ((j & 22656) != 0) {
                CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
            }
            if ((j & 20672) != 0) {
                CommonBindingAdapter.e0(this.f10583a, z13);
                CommonBindingAdapter.e0(this.f10585a, z13);
                CommonBindingAdapter.e0(this.e, z13);
            }
            if ((20992 & j) != 0) {
                CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
            }
            if ((j & 20488) != 0) {
                TextViewBindingAdapter.setText(this.e, value2);
                CommonBindingAdapter.l0(this.e, z4);
            }
            if ((20496 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10586b, value7);
            }
            if ((j & 20481) != 0) {
                TextViewBindingAdapter.setText(this.f, value5);
            }
            if ((21504 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10588b, str2);
            }
            if ((20736 & j) != 0) {
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
            }
            if ((j & 20484) != 0) {
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
            }
        }
        z8 = z8;
        mutableLiveDataU = mutableLiveData;
        z9 = false;
        availableStock = 0;
        j2 = j & 20672;
        if (j2 != 0) {
            if (!z6) {
                z10 = false;
            }
            if (j2 != 0) {
                if (z10) {
                    j |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                } else {
                    j |= 2097152;
                }
            }
        } else {
            z10 = false;
        }
        j3 = j & 22528;
        if (j3 != 0) {
            if (z5) {
                z16 = true;
            } else {
                z16 = z8;
            }
            if (j3 != 0) {
                if (z16) {
                    j10 = 4294967296L;
                } else {
                    j10 = 2147483648L;
                }
                j |= j10;
            }
            if (z16) {
                i3 = RunIndexRecordAdapter.O;
            } else {
                i3 = -13877680;
            }
        } else {
            i3 = 0;
        }
        j4 = j & 22656;
        if (j4 != 0) {
            if (z7) {
                z9 = true;
            }
            if (j4 != 0) {
                if (z9) {
                    j9 = 1048576;
                } else {
                    j9 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                }
                j |= j9;
            }
        } else {
            z9 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED) != 0) {
            if (goodsSpecificationVM != null) {
                mutableLiveDataJ = goodsSpecificationVM.j();
            } else {
                mutableLiveDataJ = null;
            }
            updateLiveDataRegistration(6, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value8 = mutableLiveDataJ.getValue();
            } else {
                value8 = null;
            }
            zSafeUnbox2 = ViewDataBinding.safeUnbox(value8);
        } else {
            zSafeUnbox = zSafeUnbox;
            mutableLiveDataU = mutableLiveDataU;
            zSafeUnbox2 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) != 0) {
            if (goodsSpecificationVM != null) {
                mutableLiveDataU2 = goodsSpecificationVM.u();
            } else {
                mutableLiveDataU2 = mutableLiveDataU;
            }
            z11 = zSafeUnbox2;
            updateLiveDataRegistration(7, mutableLiveDataU2);
            if (mutableLiveDataU2 != null) {
                value6 = mutableLiveDataU2.getValue();
            }
            if (value6 != null) {
                availableStock = value6.getAvailableStock();
            }
            if (availableStock <= i) {
            }
            j5 = j & 22656;
            if (j5 != 0) {
                if (z9) {
                    z12 = true;
                }
                if (j5 != 0) {
                    if (z12) {
                        j8 = 67108864;
                    } else {
                        j8 = 33554432;
                    }
                    j |= j8;
                }
            } else {
                z12 = false;
            }
            if ((j & 20672) == 0) {
                z13 = false;
            } else {
                z13 = false;
            }
            if ((j & 33554432) != 0) {
                if (goodsSpecificationVM != null) {
                    goodsDetailBeanM = goodsSpecificationVM.m();
                }
                if (goodsDetailBeanM != null) {
                    type = goodsDetailBeanM.getType();
                }
                if (type == 2) {
                    z14 = true;
                } else {
                    z14 = false;
                }
            } else {
                z14 = z8;
            }
            j6 = j & 22656;
            if (j6 != 0) {
                if (z12) {
                    z15 = true;
                } else {
                    z15 = z14;
                }
                if (j6 != 0) {
                    if (z15) {
                        j7 = 268435456;
                    } else {
                        j7 = 134217728;
                    }
                    j |= j7;
                }
                if (z15) {
                    i4 = RunIndexRecordAdapter.O;
                } else {
                    i4 = -13877680;
                }
            } else {
                i4 = 0;
            }
            if ((j & 20480) != 0) {
                CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
                TextViewBindingAdapter.setText(this.d, str);
                CommonBindingAdapter.l0(this.d, z2);
                TextViewBindingAdapter.setText(this.f10585a, strI);
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
                CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
            }
            if ((j & 20512) != 0) {
                CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
            }
            if ((j & 20482) != 0) {
                CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
            }
            if ((j & 24576) != 0) {
                CommonBindingAdapter.q(this.b, bVar, null);
                CommonBindingAdapter.q(this.f10582a, dVar, 0L);
                CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
                CommonBindingAdapter.q(this.f10583a, aVar, null);
            }
            if ((j & 22528) != 0) {
                CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
            }
            if ((j & 22656) != 0) {
                CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
            }
            if ((j & 20672) != 0) {
                CommonBindingAdapter.e0(this.f10583a, z13);
                CommonBindingAdapter.e0(this.f10585a, z13);
                CommonBindingAdapter.e0(this.e, z13);
            }
            if ((20992 & j) != 0) {
                CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
            }
            if ((j & 20488) != 0) {
                TextViewBindingAdapter.setText(this.e, value2);
                CommonBindingAdapter.l0(this.e, z4);
            }
            if ((20496 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10586b, value7);
            }
            if ((j & 20481) != 0) {
                TextViewBindingAdapter.setText(this.f, value5);
            }
            if ((21504 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10588b, str2);
            }
            if ((20736 & j) != 0) {
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
            }
            if ((j & 20484) != 0) {
                TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
            }
        }
        z11 = zSafeUnbox2;
        j5 = j & 22656;
        if (j5 != 0) {
            if (z9) {
                z12 = true;
            }
            if (j5 != 0) {
                if (z12) {
                    j8 = 67108864;
                } else {
                    j8 = 33554432;
                }
                j |= j8;
            }
        } else {
            z12 = false;
        }
        if ((j & 20672) == 0) {
            z13 = false;
        } else {
            z13 = false;
        }
        if ((j & 33554432) != 0) {
            if (goodsSpecificationVM != null) {
                goodsDetailBeanM = goodsSpecificationVM.m();
            }
            if (goodsDetailBeanM != null) {
                type = goodsDetailBeanM.getType();
            }
            if (type == 2) {
                z14 = true;
            } else {
                z14 = false;
            }
        } else {
            z14 = z8;
        }
        j6 = j & 22656;
        if (j6 != 0) {
            if (z12) {
                z15 = true;
            } else {
                z15 = z14;
            }
            if (j6 != 0) {
                if (z15) {
                    j7 = 268435456;
                } else {
                    j7 = 134217728;
                }
                j |= j7;
            }
            if (z15) {
                i4 = RunIndexRecordAdapter.O;
            } else {
                i4 = -13877680;
            }
        } else {
            i4 = 0;
        }
        if ((j & 20480) != 0) {
            CommonBindingAdapter.e0(((MallDialogGoodsSpecificationBinding) this).f34916a, z3);
            TextViewBindingAdapter.setText(this.d, str);
            CommonBindingAdapter.l0(this.d, z2);
            TextViewBindingAdapter.setText(this.f10585a, strI);
            TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10569a, activityPriceLabel);
            CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10569a, z);
        }
        if ((j & 20512) != 0) {
            CommonBindingAdapter.b0(((MallDialogGoodsSpecificationBinding) this).f10567a, value, requestOptions, false);
        }
        if ((j & 20482) != 0) {
            CommonBindingAdapter.l0(((MallDialogGoodsSpecificationBinding) this).f10568a, zSafeUnbox);
        }
        if ((j & 24576) != 0) {
            CommonBindingAdapter.q(this.b, bVar, null);
            CommonBindingAdapter.q(this.f10582a, dVar, 0L);
            CommonBindingAdapter.q(this.f10587b, cVarA, 0L);
            CommonBindingAdapter.q(this.f10583a, aVar, null);
        }
        if ((j & 22528) != 0) {
            CommonBindingAdapter.Y(this.f10582a, Integer.valueOf(i3));
        }
        if ((j & 22656) != 0) {
            CommonBindingAdapter.Y(this.f10587b, Integer.valueOf(i4));
        }
        if ((j & 20672) != 0) {
            CommonBindingAdapter.e0(this.f10583a, z13);
            CommonBindingAdapter.e0(this.f10585a, z13);
            CommonBindingAdapter.e0(this.e, z13);
        }
        if ((20992 & j) != 0) {
            CommonBindingAdapter.I(this.f10583a, 16, 8, 16, i2, null);
        }
        if ((j & 20488) != 0) {
            TextViewBindingAdapter.setText(this.e, value2);
            CommonBindingAdapter.l0(this.e, z4);
        }
        if ((20496 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10586b, value7);
        }
        if ((j & 20481) != 0) {
            TextViewBindingAdapter.setText(this.f, value5);
        }
        if ((21504 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10588b, str2);
        }
        if ((20736 & j) != 0) {
            TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10573a, value4);
        }
        if ((j & 20484) != 0) {
            TextViewBindingAdapter.setText(((MallDialogGoodsSpecificationBinding) this).f10574b, str3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10577a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10577a = PlaybackStateCompat.ACTION_PREPARE;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogGoodsSpecificationBinding
    public void l(@Nullable GoodsSpecificationDialog.a aVar) {
        ((MallDialogGoodsSpecificationBinding) this).f10571a = aVar;
        synchronized (this) {
            this.f10577a |= 8192;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogGoodsSpecificationBinding
    public void m(@Nullable GoodsSpecificationVM goodsSpecificationVM) {
        ((MallDialogGoodsSpecificationBinding) this).f10572a = goodsSpecificationVM;
        synchronized (this) {
            this.f10577a |= 4096;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 64;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 1024;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return p((MutableLiveData) obj, i2);
            case 1:
                return u((MutableLiveData) obj, i2);
            case 2:
                return x((MutableLiveData) obj, i2);
            case 3:
                return v((MutableLiveData) obj, i2);
            case 4:
                return s((MutableLiveData) obj, i2);
            case 5:
                return q((MutableLiveData) obj, i2);
            case 6:
                return n((MutableLiveData) obj, i2);
            case 7:
                return w((MutableLiveData) obj, i2);
            case 8:
                return t((MutableLiveData) obj, i2);
            case 9:
                return y((MutableLiveData) obj, i2);
            case 10:
                return o((MutableLiveData) obj, i2);
            case 11:
                return r((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 32;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 2048;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((GoodsSpecificationVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsSpecificationDialog.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 256;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 2;
        }
        return true;
    }

    public final boolean v(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 8;
        }
        return true;
    }

    public final boolean w(MutableLiveData<GoodsDetailSku> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 128;
        }
        return true;
    }

    public final boolean x(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 4;
        }
        return true;
    }

    public final boolean y(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10577a |= 512;
        }
        return true;
    }

    public MallDialogGoodsSpecificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 12, (CardView) objArr[20], (EditText) objArr[12], (ImageView) objArr[2], (LinearLayout) objArr[7], (LinearLayout) objArr[18], (LinearLayout) objArr[19], (PriceView) objArr[4], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[17]);
        this.f10577a = -1L;
        ((MallDialogGoodsSpecificationBinding) this).f34916a.setTag(null);
        ((MallDialogGoodsSpecificationBinding) this).f10567a.setTag(null);
        ((MallDialogGoodsSpecificationBinding) this).f10568a.setTag(null);
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f10584a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.b = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.d = textView;
        textView.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[11];
        this.f10582a = bLImageView;
        bLImageView.setTag(null);
        BLImageView bLImageView2 = (BLImageView) objArr[13];
        this.f10587b = bLImageView2;
        bLImageView2.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[14];
        this.f10583a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[15];
        this.f10585a = bLTextView;
        bLTextView.setTag(null);
        TextView textView2 = (TextView) objArr[16];
        this.e = textView2;
        textView2.setTag(null);
        PriceView priceView = (PriceView) objArr[5];
        this.f10586b = priceView;
        priceView.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.f = textView3;
        textView3.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[9];
        this.f10588b = bLTextView2;
        bLTextView2.setTag(null);
        ((MallDialogGoodsSpecificationBinding) this).f10573a.setTag(null);
        ((MallDialogGoodsSpecificationBinding) this).f10569a.setTag(null);
        ((MallDialogGoodsSpecificationBinding) this).f10574b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
