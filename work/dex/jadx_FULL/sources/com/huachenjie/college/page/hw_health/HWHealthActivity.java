package com.huachenjie.college.page.hw_health;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.HuaweiHealthSportRecordBean;
import com.huachenjie.college.databinding.CollegeActivityHwHealthBinding;
import com.huachenjie.college.databinding.CollegeViewHwHealthHeaderBinding;
import com.huachenjie.college.page.hw_health.HWHealthActivity;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.ErrorCode;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.uk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.c.HW_HEALTH)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR#\u0010#\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/huachenjie/college/page/hw_health/HWHealthActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/college/databinding/CollegeActivityHwHealthBinding;", "Lcom/huachenjie/college/page/hw_health/HWHealthVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "onDestroy", "initToolbar", "i0", "", HWHealthSportDetailActivity.x, "m0", "Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "b", "Lkotlin/Lazy;", "g0", "()Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "pickerHelper", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "c", "h0", "()Landroidx/activity/result/ActivityResultLauncher;", "sportDetailLauncher", "Lcom/huachenjie/college/databinding/CollegeViewHwHealthHeaderBinding;", "kotlin.jvm.PlatformType", "d", "f0", "()Lcom/huachenjie/college/databinding/CollegeViewHwHealthHeaderBinding;", "headerViewBinding", "<init>", "()V", "a", "college_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHWHealthActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWHealthActivity.kt\ncom/huachenjie/college/page/hw_health/HWHealthActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,155:1\n350#2,7:156\n*S KotlinDebug\n*F\n+ 1 HWHealthActivity.kt\ncom/huachenjie/college/page/hw_health/HWHealthActivity\n*L\n109#1:156,7\n*E\n"})
public final class HWHealthActivity extends BaseMVVMActivity<CollegeActivityHwHealthBinding, HWHealthVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy pickerHelper = LazyKt.lazy(new Function0<OptionsPickerHelper>() { // from class: com.huachenjie.college.page.hw_health.HWHealthActivity$pickerHelper$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OptionsPickerHelper m330invoke() {
            return new OptionsPickerHelper();
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy sportDetailLauncher = LazyKt.lazy(new HWHealthActivity$sportDetailLauncher$2(this));

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerViewBinding = LazyKt.lazy(new Function0<CollegeViewHwHealthHeaderBinding>() { // from class: com.huachenjie.college.page.hw_health.HWHealthActivity$headerViewBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CollegeViewHwHealthHeaderBinding m329invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.college_view_hw_health_header, null, false);
            HWHealthActivity hWHealthActivity = this.this$0;
            CollegeViewHwHealthHeaderBinding collegeViewHwHealthHeaderBinding = (CollegeViewHwHealthHeaderBinding) viewDataBindingInflate;
            collegeViewHwHealthHeaderBinding.m(HWHealthActivity.c0(hWHealthActivity));
            collegeViewHwHealthHeaderBinding.l(new HWHealthActivity.a());
            collegeViewHwHealthHeaderBinding.setLifecycleOwner(hWHealthActivity);
            return collegeViewHwHealthHeaderBinding;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/college/page/hw_health/HWHealthActivity$a;", "", "Landroid/view/View;", "view", "", "b", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nHWHealthActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HWHealthActivity.kt\ncom/huachenjie/college/page/hw_health/HWHealthActivity$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1549#2:156\n1620#2,3:157\n1549#2:160\n1620#2,3:161\n1#3:164\n*S KotlinDebug\n*F\n+ 1 HWHealthActivity.kt\ncom/huachenjie/college/page/hw_health/HWHealthActivity$ClickProxy\n*L\n134#1:156\n134#1:157,3\n135#1:160\n135#1:161,3\n*E\n"})
    public static final class a {
        public static final void c(HWHealthActivity hWHealthActivity, int i, int i2, String str, String str2) {
            Intrinsics.checkNotNullParameter(hWHealthActivity, "$activity");
            HWHealthVM hWHealthVMC0 = HWHealthActivity.c0(hWHealthActivity);
            Intrinsics.checkNotNullExpressionValue(str, "year");
            Integer intOrNull = StringsKt.toIntOrNull(StringsKt.removeSuffix(str, "年"));
            Intrinsics.checkNotNullExpressionValue(str2, "month");
            hWHealthVMC0.q(intOrNull, StringsKt.toIntOrNull(StringsKt.removeSuffix(str2, "月")));
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            final HWHealthActivity hWHealthActivity = context instanceof HWHealthActivity ? (HWHealthActivity) context : null;
            if (hWHealthActivity == null) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            int iCoerceIn = RangesKt.coerceIn(calendar.get(1), 2026, ErrorCode.CHECK_START_RUN_ERROR.f);
            int iIntValue = calendar.get(2) + 1;
            IntRange intRange = new IntRange(2026, ErrorCode.CHECK_START_RUN_ERROR.f);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            IntIterator it = intRange.iterator();
            while (it.hasNext()) {
                int iNextInt = it.nextInt();
                StringBuilder sb = new StringBuilder();
                sb.append(iNextInt);
                sb.append((char) 24180);
                arrayList.add(sb.toString());
            }
            IntRange intRange2 = new IntRange(1, 12);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
            IntIterator it2 = intRange2.iterator();
            while (it2.hasNext()) {
                int iNextInt2 = it2.nextInt();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%02d月", Arrays.copyOf(new Object[]{Integer.valueOf(iNextInt2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                arrayList2.add(str);
            }
            Integer numM = HWHealthActivity.c0(hWHealthActivity).getSelectedYear();
            if (numM != null) {
                iCoerceIn = numM.intValue();
            }
            int iCoerceIn2 = RangesKt.coerceIn(iCoerceIn, 2026, ErrorCode.CHECK_START_RUN_ERROR.f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iCoerceIn2);
            sb2.append((char) 24180);
            String string = sb2.toString();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[1];
            Integer numL = HWHealthActivity.c0(hWHealthActivity).getSelectedMonth();
            if (numL != null) {
                iIntValue = numL.intValue();
            }
            objArr[0] = Integer.valueOf(iIntValue);
            String str2 = String.format("%02d月", Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            hWHealthActivity.g0().n(hWHealthActivity, string, str2, arrayList, arrayList2, new OptionsPickerHelper.OnTwoColumnPickChangeListener() { // from class: com.zj.adlib.ux3
                @Override // com.huachenjie.base.widget.picker.OptionsPickerHelper.OnTwoColumnPickChangeListener
                public final void a(int i, int i2, String str3, String str4) {
                    HWHealthActivity.a.c(hWHealthActivity, i, i2, str3, str4);
                }
            });
        }
    }

    public static final /* synthetic */ HWHealthVM c0(HWHealthActivity hWHealthActivity) {
        return hWHealthActivity.getMViewModel();
    }

    public static final void j0(HWHealthActivity hWHealthActivity) {
        Intrinsics.checkNotNullParameter(hWHealthActivity, "this$0");
        hWHealthActivity.getMViewModel().o();
    }

    public static final void k0(HWHealthAdapter hWHealthAdapter, HWHealthActivity hWHealthActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(hWHealthAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(hWHealthActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        hWHealthActivity.h0().launch(HWHealthSportDetailActivity.INSTANCE.a(hWHealthActivity, hWHealthAdapter.getItem(i).getSportRecordCode()));
    }

    public static final void l0(HWHealthActivity hWHealthActivity, View view) {
        Intrinsics.checkNotNullParameter(hWHealthActivity, "this$0");
        hWHealthActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()));
    }

    public final CollegeViewHwHealthHeaderBinding f0() {
        return (CollegeViewHwHealthHeaderBinding) this.headerViewBinding.getValue();
    }

    public final OptionsPickerHelper g0() {
        return (OptionsPickerHelper) this.pickerHelper.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_activity_hw_health;
    }

    public final ActivityResultLauncher<Intent> h0() {
        Object value = this.sportDetailLauncher.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sportDetailLauncher>(...)");
        return (ActivityResultLauncher) value;
    }

    public final void i0() {
        MutableLiveData<HWHealthAdapter> mutableLiveDataJ = getMViewModel().j();
        final HWHealthAdapter hWHealthAdapter = new HWHealthAdapter();
        hWHealthAdapter.setHeaderWithEmptyEnable(true);
        View root = f0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerViewBinding.root");
        BaseQuickAdapter.setHeaderView$default(hWHealthAdapter, root, 0, 0, 6, null);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R….layout_empty_work, null)");
        hWHealthAdapter.setEmptyView(viewInflate);
        hWHealthAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.rx3
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                HWHealthActivity.j0(this.f44561a);
            }
        });
        y57.d(hWHealthAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.sx3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HWHealthActivity.k0(hWHealthAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataJ.setValue(hWHealthAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().p();
        getMViewModel().o();
    }

    public final void initToolbar() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setTitleName("运动健康");
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.tx3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWHealthActivity.l0(this.f45020a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initToolbar();
        i0();
        h0();
    }

    public final void m0(String sportRecordCode) {
        HWHealthAdapter value;
        int i = 0;
        if ((sportRecordCode.length() == 0) || (value = getMViewModel().j().getValue()) == null) {
            return;
        }
        List<HuaweiHealthSportRecordBean> data = value.getData();
        Iterator<HuaweiHealthSportRecordBean> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getSportRecordCode(), sportRecordCode)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        HuaweiHealthSportRecordBean huaweiHealthSportRecordBean = data.get(i);
        if (huaweiHealthSportRecordBean.getDeducted()) {
            return;
        }
        huaweiHealthSportRecordBean.setDeducted(true);
        value.setData(i, huaweiHealthSportRecordBean);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g0().i();
        super.onDestroy();
    }
}
