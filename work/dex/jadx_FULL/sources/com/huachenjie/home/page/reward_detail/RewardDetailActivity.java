package com.huachenjie.home.page.reward_detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.google.gson.Gson;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoMaterialBean;
import com.huachenjie.base.bean.reward.RewardInfoOrderBean;
import com.huachenjie.base.bean.reward.RewardInfoReceiveBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeActivityRewardDetailBinding;
import com.huachenjie.mall.utils.RewardOrderHelp;
import com.igexin.push.g.o;
import com.zj.adlib.su9;
import com.zj.adlib.xk0;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0019\u0012B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/home/page/reward_detail/RewardDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityRewardDetailBinding;", "Lcom/huachenjie/home/page/reward_detail/RewardDetailVM;", "", "", "", "V", "getLayoutResID", "", "initData", "W", "onDestroy", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "infoBean", "d0", "e0", "Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "b", "Lkotlin/Lazy;", "c0", "()Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "receiver", "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class RewardDetailActivity extends BaseMVVMActivity<HomeActivityRewardDetailBinding, RewardDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "reward_bean";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy receiver = LazyKt.lazy(new Function0<RewardOrderHelp.RewardOrderReceiver>() { // from class: com.huachenjie.home.page.reward_detail.RewardDetailActivity$receiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RewardOrderHelp.RewardOrderReceiver m427invoke() {
            final RewardDetailActivity rewardDetailActivity = this.this$0;
            return new RewardOrderHelp.RewardOrderReceiver(new Function2<String, String, Unit>() { // from class: com.huachenjie.home.page.reward_detail.RewardDetailActivity$receiver$2.1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str, @NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str, "orderNo");
                    Intrinsics.checkNotNullParameter(str2, "exchangeCode");
                    RewardInfoBean value = RewardDetailActivity.Z(rewardDetailActivity).i().getValue();
                    if (value != null) {
                        RewardDetailActivity rewardDetailActivity2 = rewardDetailActivity;
                        if (Intrinsics.areEqual(value.getWinningRecordNo(), str2)) {
                            RewardInfoOrderBean rewardInfoOrderBean = new RewardInfoOrderBean(str, null, 2, null);
                            value.setReceiveRecord(new RewardInfoReceiveBean(null, 0L, null, 7, null));
                            RewardInfoReceiveBean receiveRecord = value.getReceiveRecord();
                            Intrinsics.checkNotNull(receiveRecord);
                            receiveRecord.setOrderInfo(rewardInfoOrderBean);
                            value.setReceivedStatus(9);
                            RewardDetailActivity.Z(rewardDetailActivity2).i().setValue(value);
                        }
                    }
                }
            });
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/home/page/reward_detail/RewardDetailActivity$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/home/page/reward_detail/RewardDetailActivity;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RewardDetailActivity.Z(RewardDetailActivity.this).f();
        }

        public final void b(@NotNull View view) {
            RewardInfoMaterialBean materialInfo;
            RewardInfoMaterialBean materialInfo2;
            RewardInfoOrderBean orderInfo;
            String orderNo;
            RewardInfoMaterialBean materialInfo3;
            String itemNo;
            Intrinsics.checkNotNullParameter(view, "view");
            RewardInfoBean value = RewardDetailActivity.Z(RewardDetailActivity.this).i().getValue();
            if (value != null) {
                RewardDetailActivity rewardDetailActivity = RewardDetailActivity.this;
                RewardInfoDetailBean awardInfo = value.getAwardInfo();
                Integer numValueOf = awardInfo != null ? Integer.valueOf(awardInfo.getAwardType()) : null;
                if (numValueOf != null && numValueOf.intValue() == 1) {
                    String str = "";
                    if (value.getReceivedStatus() == 1) {
                        Postcard postcardBuild = ARouter.getInstance().build(zj7.g.GOOD_DETAIL);
                        RewardInfoDetailBean awardInfo2 = value.getAwardInfo();
                        if (awardInfo2 != null && (materialInfo3 = awardInfo2.getMaterialInfo()) != null && (itemNo = materialInfo3.getItemNo()) != null) {
                            str = itemNo;
                        }
                        postcardBuild.withString("goodsNo", str).withBoolean("fromReward", true).withString("exchangeCode", value.getWinningRecordNo()).navigation();
                        return;
                    }
                    Postcard postcardBuild2 = ARouter.getInstance().build(zj7.g.ORDER_DETAIL);
                    RewardInfoReceiveBean receiveRecord = value.getReceiveRecord();
                    if (receiveRecord != null && (orderInfo = receiveRecord.getOrderInfo()) != null && (orderNo = orderInfo.getOrderNo()) != null) {
                        str = orderNo;
                    }
                    postcardBuild2.withString("orderNo", str).navigation();
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 6) {
                    su9.x(rewardDetailActivity);
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    RewardInfoDetailBean awardInfo3 = value.getAwardInfo();
                    if ((awardInfo3 == null || (materialInfo2 = awardInfo3.getMaterialInfo()) == null || materialInfo2.getMaterialSubType() != 20) ? false : true) {
                        ARouter.getInstance().build(RoutePathConstants.SocialContact.b).navigation();
                        return;
                    }
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 4) {
                    RewardInfoDetailBean awardInfo4 = value.getAwardInfo();
                    if ((awardInfo4 == null || (materialInfo = awardInfo4.getMaterialInfo()) == null || materialInfo.getMaterialSubType() != 0) ? false : true) {
                        su9.e(rewardDetailActivity);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.page.reward_detail.RewardDetailActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/reward_detail/RewardDetailActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "infoBean", "", "a", "", "REWARD_BEAN", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull RewardInfoBean infoBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(infoBean, "infoBean");
            Intent intent = new Intent(context, (Class<?>) RewardDetailActivity.class);
            intent.putExtra(RewardDetailActivity.t, new Gson().toJson(infoBean));
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34365a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34365a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34365a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34365a.invoke(obj);
        }
    }

    public static final /* synthetic */ RewardDetailVM Z(RewardDetailActivity rewardDetailActivity) {
        return rewardDetailActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().i().observe(this, new c(new Function1<RewardInfoBean, Unit>() { // from class: com.huachenjie.home.page.reward_detail.RewardDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RewardInfoBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RewardInfoBean rewardInfoBean) {
                RewardDetailActivity rewardDetailActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(rewardInfoBean, o.f);
                rewardDetailActivity.d0(rewardInfoBean);
                this.this$0.e0(rewardInfoBean);
            }
        }));
    }

    public final RewardOrderHelp.RewardOrderReceiver c0() {
        return (RewardOrderHelp.RewardOrderReceiver) this.receiver.getValue();
    }

    public final void d0(RewardInfoBean infoBean) {
        Drawable background = getMBinding().f9311a.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (infoBean.getReceivedStatus() == 9) {
            gradientDrawable.setStroke(0, getResources().getColor(R.color.white));
        } else if (infoBean.getReceivedStatus() == 1) {
            gradientDrawable.setStroke(SizeUtils.b(2.0f), getResources().getColor(R.color.color_0BD3FF));
        } else {
            gradientDrawable.setStroke(SizeUtils.b(2.0f), getResources().getColor(R.color.color_CCCCCC));
        }
        getMBinding().f9311a.setBackground(gradientDrawable);
    }

    public final void e0(RewardInfoBean infoBean) {
        Drawable background = getMBinding().f9312a.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.setColor(ContextCompat.getColor(this, infoBean.formatterStatusBgColor()));
        getMBinding().f9312a.setBackground(gradientDrawable);
        getMBinding().f34213a.setTextColor(ContextCompat.getColor(this, infoBean.formatterStatusTvColor()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_reward_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().i().setValue(new Gson().fromJson(getIntent().getStringExtra(t), RewardInfoBean.class));
        RewardOrderHelp.f35274a.a(this, c0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RewardOrderHelp.f35274a.c(this, c0());
    }
}
