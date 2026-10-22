package com.huachenjie.home.dialog.reward;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoImageInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoMaterialBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeDialogRewardInfoBinding;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.su9;
import com.zj.adlib.xk0;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = zj7.e.REWARD_INFO_DIALOG)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/home/dialog/reward/RewardInfoDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/home/databinding/HomeDialogRewardInfoBinding;", "Lcom/huachenjie/home/dialog/reward/RewardInfoVM;", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "infoBean", "", "initRewardBg", "initRewardImg", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "onStart", "initData", "<init>", "()V", "Companion", "a", "b", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRewardInfoDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardInfoDialog.kt\ncom/huachenjie/home/dialog/reward/RewardInfoDialog\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,134:1\n470#2:135\n470#2:136\n470#2:137\n470#2:138\n*S KotlinDebug\n*F\n+ 1 RewardInfoDialog.kt\ncom/huachenjie/home/dialog/reward/RewardInfoDialog\n*L\n82#1:135\n83#1:136\n89#1:137\n90#1:138\n*E\n"})
public final class RewardInfoDialog extends BaseMVVMDialogFragment<HomeDialogRewardInfoBinding, RewardInfoVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String REWARD_BEAN = "reward_bean";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/home/dialog/reward/RewardInfoDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/home/dialog/reward/RewardInfoDialog;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RewardInfoDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            String itemNo;
            RewardInfoDetailBean awardInfo;
            RewardInfoMaterialBean materialInfo;
            RewardInfoDetailBean awardInfo2;
            Intrinsics.checkNotNullParameter(view, "view");
            RewardInfoBean value = RewardInfoDialog.access$getMViewModel(RewardInfoDialog.this).i().getValue();
            Integer numValueOf = (value == null || (awardInfo2 = value.getAwardInfo()) == null) ? null : Integer.valueOf(awardInfo2.getAwardType());
            if (numValueOf != null && numValueOf.intValue() == 1) {
                Postcard postcardBuild = ARouter.getInstance().build(zj7.g.GOOD_DETAIL);
                RewardInfoBean value2 = RewardInfoDialog.access$getMViewModel(RewardInfoDialog.this).i().getValue();
                if (value2 == null || (awardInfo = value2.getAwardInfo()) == null || (materialInfo = awardInfo.getMaterialInfo()) == null || (itemNo = materialInfo.getItemNo()) == null) {
                    itemNo = "";
                }
                postcardBuild.withString("goodsNo", itemNo).withBoolean("fromReward", true).navigation();
            } else if (numValueOf != null && numValueOf.intValue() == 6) {
                su9.x(RewardInfoDialog.this.getContext());
            }
            RewardInfoDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.reward.RewardInfoDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/dialog/reward/RewardInfoDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "infoBean", "", "a", "", "REWARD_BEAN", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull RewardInfoBean infoBean) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(infoBean, "infoBean");
            RewardInfoDialog rewardInfoDialog = new RewardInfoDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reward_bean", infoBean);
            rewardInfoDialog.setArguments(bundle);
            rewardInfoDialog.show(fragmentManager, "RewardInfoDialog");
        }
    }

    public static final /* synthetic */ RewardInfoVM access$getMViewModel(RewardInfoDialog rewardInfoDialog) {
        return rewardInfoDialog.getMViewModel();
    }

    private final void initRewardBg(RewardInfoBean infoBean) {
        BLFrameLayout bLFrameLayout;
        RewardInfoDetailBean awardInfo;
        HomeDialogRewardInfoBinding mBinding = getMBinding();
        if (mBinding == null || (bLFrameLayout = mBinding.f9371a) == null) {
            return;
        }
        GradientDrawable gradientDrawable = infoBean != null && (awardInfo = infoBean.getAwardInfo()) != null && awardInfo.getAwardType() == 6 ? new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#F6DFC5"), Color.parseColor("#FEFADB")}) : new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#B6F2FF"), Color.parseColor("#80dafffb")});
        float fB = SizeUtils.b(20.0f);
        gradientDrawable.setCornerRadii(new float[]{fB, fB, fB, fB, fB, fB, fB, fB});
        bLFrameLayout.setBackground(gradientDrawable);
    }

    private final void initRewardImg(RewardInfoBean infoBean) {
        ImageView imageView;
        String url;
        RewardInfoDetailBean awardInfo;
        RewardInfoImageInfoBean imageInfo;
        HomeDialogRewardInfoBinding mBinding = getMBinding();
        if (mBinding == null || (imageView = mBinding.f34233a) == null) {
            return;
        }
        boolean z = false;
        if (infoBean != null && infoBean.isTaskDialog()) {
            z = true;
        }
        if (z) {
            imageView.setImageResource(R.drawable.base_ic_inspiration);
            Unit unit = Unit.INSTANCE;
            return;
        }
        RequestManager requestManagerWith = Glide.with(this);
        if (infoBean == null || (awardInfo = infoBean.getAwardInfo()) == null || (imageInfo = awardInfo.getImageInfo()) == null || (url = imageInfo.getUrl()) == null) {
            url = "";
        }
        Intrinsics.checkNotNullExpressionValue(requestManagerWith.load(url).into(imageView), "{\n                Glide.…to(ivAWard)\n            }");
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_reward_info;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @Nullable
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        Bundle arguments = getArguments();
        RewardInfoBean rewardInfoBean = arguments != null ? (RewardInfoBean) arguments.getParcelable("reward_bean") : null;
        getMViewModel().i().setValue(rewardInfoBean);
        initRewardBg(rewardInfoBean);
        initRewardImg(rewardInfoBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator startDelay;
        super.onStart();
        View view = getView();
        if (view == null || (viewPropertyAnimatorAnimate = view.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(1.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(300L)) == null || (startDelay = duration.setStartDelay(300L)) == null) {
            return;
        }
        startDelay.start();
    }
}
