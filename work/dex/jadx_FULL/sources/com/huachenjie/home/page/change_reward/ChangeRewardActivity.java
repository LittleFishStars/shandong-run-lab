package com.huachenjie.home.page.change_reward;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.flyco.tablayout.SlidingTabLayout2;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.ChangeRewardBean;
import com.huachenjie.home.bean.reward.JackpotListBean;
import com.huachenjie.home.databinding.HomeActivityChangeRewardBinding;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ef1;
import com.zj.adlib.fx7;
import com.zj.adlib.xk0;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = zj7.e.CHANGE_REWARD)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\tH\u0002J\u001e\u0010\u0016\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityChangeRewardBinding;", "Lcom/huachenjie/home/page/change_reward/ChangeRewardVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "W", "g0", "inspiration", "k0", "initTitleBar", "", "Lcom/huachenjie/home/bean/reward/JackpotListBean;", "jackpotList", "selIndex", "h0", "listBean", "i0", "", "b", "Lkotlin/Lazy;", "f0", "()Z", yj7.c.KEY_CHANGE_IMPORTANT_REWARD, "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChangeRewardActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChangeRewardActivity.kt\ncom/huachenjie/home/page/change_reward/ChangeRewardActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1549#2:195\n1620#2,3:196\n*S KotlinDebug\n*F\n+ 1 ChangeRewardActivity.kt\ncom/huachenjie/home/page/change_reward/ChangeRewardActivity\n*L\n113#1:195\n113#1:196,3\n*E\n"})
public final class ChangeRewardActivity extends BaseMVVMActivity<HomeActivityChangeRewardBinding, ChangeRewardVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy changeImportantReward = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.home.page.change_reward.ChangeRewardActivity$changeImportantReward$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m406invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(yj7.c.KEY_CHANGE_IMPORTANT_REWARD, false));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardActivity$a;", "", "Landroid/view/View;", "view", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/home/page/change_reward/ChangeRewardActivity;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            String probabilityPublicityUrl;
            Intrinsics.checkNotNullParameter(view, "view");
            ChangeRewardBean value = ChangeRewardActivity.c0(ChangeRewardActivity.this).j().getValue();
            if (value == null || (probabilityPublicityUrl = value.getProbabilityPublicityUrl()) == null) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", probabilityPublicityUrl).navigation();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChangeRewardActivity.this.startActivity(new Intent(ChangeRewardActivity.this, (Class<?>) RewardRecordActivity.class));
        }

        public final void c(@NotNull View view) {
            String ruleDescriptionUrl;
            Intrinsics.checkNotNullParameter(view, "view");
            ChangeRewardBean value = ChangeRewardActivity.c0(ChangeRewardActivity.this).j().getValue();
            if (value == null || (ruleDescriptionUrl = value.getRuleDescriptionUrl()) == null) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", ruleDescriptionUrl).navigation();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34332a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34332a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34332a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34332a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChangeRewardVM c0(ChangeRewardActivity changeRewardActivity) {
        return changeRewardActivity.getMViewModel();
    }

    public static final void j0(ChangeRewardActivity changeRewardActivity, View view) {
        Intrinsics.checkNotNullParameter(changeRewardActivity, "this$0");
        changeRewardActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().j().observe(this, new b(new Function1<ChangeRewardBean, Unit>() { // from class: com.huachenjie.home.page.change_reward.ChangeRewardActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChangeRewardBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ChangeRewardBean changeRewardBean) {
                if (changeRewardBean == null) {
                    return;
                }
                MutableLiveData<BindingTitleBean> mutableLiveDataI = ChangeRewardActivity.c0(this.this$0).i();
                BindingTitleBean value = ChangeRewardActivity.c0(this.this$0).i().getValue();
                if (value != null) {
                    value.setTitleName(changeRewardBean.getLotteryThemeConfig().getThemeName());
                } else {
                    value = null;
                }
                mutableLiveDataI.setValue(value);
                if (changeRewardBean.getJackpotList().isEmpty()) {
                    return;
                }
                int i = 0;
                if (this.this$0.f0()) {
                    Iterator<JackpotListBean> it = changeRewardBean.getJackpotList().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        if (it.next().getJackpotType() == 3) {
                            i = i2;
                        } else {
                            i2++;
                        }
                    }
                    i = -1;
                }
                this.this$0.h0(changeRewardBean.getJackpotList(), i);
                this.this$0.i0(changeRewardBean.getJackpotList().get(i));
            }
        }));
    }

    public final boolean f0() {
        return ((Boolean) this.changeImportantReward.getValue()).booleanValue();
    }

    public final int g0() {
        ChangeRewardBean value = getMViewModel().j().getValue();
        if (value != null) {
            return value.getInspiration();
        }
        return 0;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_change_reward;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h0(final List<JackpotListBean> jackpotList, int selIndex) {
        BaseViewPager2Adapter<String> baseViewPager2Adapter = new BaseViewPager2Adapter<String>(this) { // from class: com.huachenjie.home.page.change_reward.ChangeRewardActivity$initTab$pagerAdapter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
            }

            @Override // com.huachenjie.base.adapter.BaseViewPager2Adapter
            @NotNull
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Fragment c(int position, @NotNull String bean) {
                Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                return ChangeRewardListFragment.Companion.a(jackpotList.get(position));
            }
        };
        List<JackpotListBean> list = jackpotList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JackpotListBean) it.next()).getJackpotName());
        }
        baseViewPager2Adapter.setList(arrayList);
        getMBinding().f9263a.setAdapter(baseViewPager2Adapter);
        getMBinding().f9264a.setViewPager(getMBinding().f9263a, arrayList);
        CustomTabStyle customTabStyle = new CustomTabStyle();
        SlidingTabLayout2 slidingTabLayout2 = getMBinding().f9264a;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout2, "mBinding.tabLayout");
        CustomTabStyle.h(customTabStyle, slidingTabLayout2, getMBinding().f9263a, null, 0, 12, null);
        getMBinding().f9264a.setCurrentTab(selIndex);
        final int iJ = (fx7.j() - SizeUtils.b(32.0f)) / 3;
        final int iB = (iJ - SizeUtils.b(16.0f)) / 2;
        ViewGroup.LayoutParams layoutParams = getMBinding().b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).leftMargin = (selIndex * iJ) + iB;
        getMBinding().f9263a.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.home.page.change_reward.ChangeRewardActivity$initTab$2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ViewGroup.LayoutParams layoutParams2 = this.f34333a.getMBinding().b.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ((RelativeLayout.LayoutParams) layoutParams2).leftMargin = iB + (iJ * position);
                this.f34333a.i0(jackpotList.get(position));
            }
        });
    }

    public final void i0(JackpotListBean listBean) {
        Drawable drawable = AppCompatResources.getDrawable(this, R.drawable.base_ic_inspiration);
        if (drawable != null) {
            drawable.setBounds(0, 0, SizeUtils.b(16.0f), SizeUtils.b(16.0f));
        }
        String strValueOf = String.valueOf(listBean.getJackpotUse());
        BLTextView bLTextView = getMBinding().f9271b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "消耗  ");
        Intrinsics.checkNotNull(drawable);
        spannableStringBuilder.setSpan(new ef1(drawable), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) (' ' + strValueOf));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(RunIndexRecordAdapter.N), spannableStringBuilder.length() - strValueOf.length(), spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) ("闪金币，" + listBean.getJackpotRemarks()));
        bLTextView.setText(spannableStringBuilder);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k();
    }

    public final void initTitleBar() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("");
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleTextColor(-1);
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_white);
        bindingTitleBean.setBackTintColor(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vh1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeRewardActivity.j0(this.f45350a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
    }

    public final void k0(int inspiration) {
        ChangeRewardBean value = getMViewModel().j().getValue();
        if (value != null) {
            value.setInspiration(value.getInspiration() + inspiration);
        }
    }
}
