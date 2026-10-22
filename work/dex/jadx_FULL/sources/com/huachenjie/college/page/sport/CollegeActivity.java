package com.huachenjie.college.page.sport;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.base.dialog.letter.ImportantLettersDialog;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.CampusApplicationBean;
import com.huachenjie.college.bean.CollegeTownBannerBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.college.databinding.CollegeActivityHomeBinding;
import com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBinding;
import com.huachenjie.college.page.lightningPlay.LightningPlayActivity;
import com.huachenjie.college.page.popcorn.PopcornWebActivity;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.kuaishou.weapon.p0.bo;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.ai9;
import com.zj.adlib.ew;
import com.zj.adlib.fe9;
import com.zj.adlib.fx7;
import com.zj.adlib.ju3;
import com.zj.adlib.kq5;
import com.zj.adlib.qx6;
import com.zj.adlib.r8a;
import com.zj.adlib.r90;
import com.zj.adlib.su9;
import com.zj.adlib.uk0;
import com.zj.adlib.vb8;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.c.HOME)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR#\u0010(\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/huachenjie/college/page/sport/CollegeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/college/databinding/CollegeActivityHomeBinding;", "Lcom/huachenjie/college/page/sport/CollegeVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "onResume", "W", "j0", "l0", "q0", "m0", "r0", "Lcom/huachenjie/college/bean/CollegeTownBannerBean;", MediationConstant.RIT_TYPE_BANNER, "e0", "Lcom/huachenjie/college/bean/CampusApplicationBean;", "item", bo.g, "o0", "Lcom/bumptech/glide/request/RequestOptions;", "b", "Lkotlin/Lazy;", "h0", "()Lcom/bumptech/glide/request/RequestOptions;", "bgOption", "c", "g0", "badgeOption", "Lcom/huachenjie/college/databinding/CollegeLayoutHomeHeaderBinding;", "kotlin.jvm.PlatformType", "d", "i0", "()Lcom/huachenjie/college/databinding/CollegeLayoutHomeHeaderBinding;", "mHeaderBinding", "", "e", "f0", "()Z", "adOpen", "<init>", "()V", "a", "college_release"}, k = 1, mv = {1, 8, 0})
public final class CollegeActivity extends BaseMVVMActivity<CollegeActivityHomeBinding, CollegeVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy bgOption = LazyKt.lazy(new Function0<RequestOptions>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$bgOption$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RequestOptions m339invoke() {
            RequestOptions requestOptionsCenterCropTransform = RequestOptions.centerCropTransform();
            int i = R.drawable.college_bg_home;
            return requestOptionsCenterCropTransform.placeholder(i).error(i).diskCacheStrategy(DiskCacheStrategy.ALL);
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy badgeOption = LazyKt.lazy(new Function0<RequestOptions>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$badgeOption$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RequestOptions m338invoke() {
            RequestOptions requestOptionsCircleCropTransform = RequestOptions.circleCropTransform();
            int i = R.drawable.college_ic_school_badge_default;
            return requestOptionsCircleCropTransform.placeholder(i).error(i).diskCacheStrategy(DiskCacheStrategy.ALL);
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy mHeaderBinding = LazyKt.lazy(new Function0<CollegeLayoutHomeHeaderBinding>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$mHeaderBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CollegeLayoutHomeHeaderBinding m340invoke() {
            return (CollegeLayoutHomeHeaderBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.college_layout_home_header, null, false);
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy adOpen = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$adOpen$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m337invoke() {
            AdPlatformSwitch adPlatformSwitchE = r90.e("csb");
            boolean z = false;
            if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/college/page/sport/CollegeActivity$a;", "", "Landroid/view/View;", "view", "", "c", "d", y6b.f, "a", "b", "e", "f", y6b.g, "<init>", "(Lcom/huachenjie/college/page/sport/CollegeActivity;)V", "college_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ai9.m()) {
                com.huachenjie.base.flutter.a.b(CollegeActivity.this, com.huachenjie.base.flutter.a.PAGE_AI_ENTRANCE);
            } else {
                ARouter.getInstance().build(RoutePathConstants.Common.b).greenChannel().navigation();
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Run.k).navigation();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CollegeActivity.this.finish();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CollegeActivity.c0(CollegeActivity.this).r().setValue(1);
            if (Intrinsics.areEqual(CollegeActivity.c0(CollegeActivity.this).p().getValue(), Boolean.TRUE)) {
                CollegeActivity.c0(CollegeActivity.this).o();
            } else {
                CollegeActivity.this.r0();
            }
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Run.n).navigation();
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Run.p).navigation();
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CollegeActivity.c0(CollegeActivity.this).r().setValue(2);
            if (Intrinsics.areEqual(CollegeActivity.c0(CollegeActivity.this).p().getValue(), Boolean.TRUE)) {
                CollegeActivity.c0(CollegeActivity.this).o();
            } else {
                CollegeActivity.this.r0();
            }
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CollegeActivity.c0(CollegeActivity.this).t();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33617a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33617a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33617a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33617a.invoke(obj);
        }
    }

    public static final /* synthetic */ CollegeVM c0(CollegeActivity collegeActivity) {
        return collegeActivity.getMViewModel();
    }

    public static final void k0(CollegeActivity collegeActivity, CollegeAdapter collegeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(collegeActivity, "this$0");
        Intrinsics.checkNotNullParameter(collegeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        collegeActivity.p0(collegeAdapter.getData().get(i));
    }

    public static final void n0(CollegeActivity collegeActivity, CollegeTownBannerBean collegeTownBannerBean, int i) {
        Intrinsics.checkNotNullParameter(collegeActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(collegeTownBannerBean, "data");
        collegeActivity.e0(collegeTownBannerBean);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(uk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(uk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().k().observe(this, new b(new Function1<CollegeTownBean, Unit>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CollegeTownBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CollegeTownBean collegeTownBean) {
                Banner banner;
                CollegeLayoutHomeHeaderBinding collegeLayoutHomeHeaderBindingI0 = this.this$0.i0();
                if (collegeLayoutHomeHeaderBindingI0 == null || (banner = collegeLayoutHomeHeaderBindingI0.f8429a) == null) {
                    return;
                }
                banner.setDatas(collegeTownBean.getBannerList());
            }
        }));
        getMViewModel().m().observe(this, new b(new CollegeActivity$initDataObserve$2(this)));
        getMViewModel().n().observe(this, new b(new Function1<List<? extends LetterBean>, Unit>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$initDataObserve$3

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/college/page/sport/CollegeActivity$initDataObserve$3$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "college_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements BaseDialogFragment.DialogFragmentListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CollegeActivity f33619a;

                public a(CollegeActivity collegeActivity) {
                    this.f33619a = collegeActivity;
                }

                @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
                public void onDismiss() {
                    this.f33619a.r0();
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<LetterBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<LetterBean> list) {
                if (list == null || list.isEmpty()) {
                    this.this$0.r0();
                    return;
                }
                ImportantLettersDialog importantLettersDialogA = ImportantLettersDialog.INSTANCE.a(new ArrayList<>(list));
                importantLettersDialogA.setDialogFragmentListener(new a(this.this$0));
                FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                importantLettersDialogA.show(supportFragmentManager, "ImportantLettersDialog");
            }
        }));
    }

    public final void e0(CollegeTownBannerBean banner) {
        kq5.c(this, MobClickConstants.d);
        switch (banner.getJumpType()) {
            case 1:
                if (!TextUtils.isEmpty(banner.getRelationUrl())) {
                    su9.l(this, banner.getRelationUrl());
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(banner.getRelationUrl())) {
                    su9.q(this, banner.getRelationUrl());
                }
                break;
            case 3:
                if (TextUtils.equals(banner.getRelationUrl(), "homeTaskList")) {
                    ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
                }
                break;
            case 5:
                if (!TextUtils.isEmpty(banner.getRelationUrl())) {
                    su9.q(this, banner.getRelationUrl());
                }
                break;
            case 6:
                LightningPlayActivity.INSTANCE.a(this, banner.getRelationUrl());
                break;
            case 7:
                if (!TextUtils.isEmpty(banner.getRelationUrl())) {
                    ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", banner.getRelationUrl()).navigation();
                }
                break;
            case 8:
                if (!TextUtils.isEmpty(banner.getRelationUrl())) {
                    ARouter.getInstance().build(zj7.g.MERCHANTS).withString("shopNo", banner.getRelationUrl()).navigation();
                }
                break;
            case 9:
                Intent intent = new Intent(this, (Class<?>) PopcornWebActivity.class);
                intent.putExtra("url", banner.getRelationUrl());
                startActivity(intent);
                break;
        }
    }

    public final boolean f0() {
        return ((Boolean) this.adOpen.getValue()).booleanValue();
    }

    public final RequestOptions g0() {
        return (RequestOptions) this.badgeOption.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.college_activity_home;
    }

    public final RequestOptions h0() {
        return (RequestOptions) this.bgOption.getValue();
    }

    public final CollegeLayoutHomeHeaderBinding i0() {
        return (CollegeLayoutHomeHeaderBinding) this.mHeaderBinding.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().u();
        getMViewModel().s();
        getMViewModel().j();
        getMViewModel().v();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        j0();
        if (f0()) {
            o0();
        }
    }

    public final void j0() {
        final CollegeAdapter collegeAdapter = new CollegeAdapter();
        l0();
        View root = i0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mHeaderBinding.root");
        BaseQuickAdapter.setHeaderView$default(collegeAdapter, root, 0, 0, 6, null);
        collegeAdapter.setHeaderWithEmptyEnable(true);
        y57.d(collegeAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.kn1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CollegeActivity.k0(this.f42863a, collegeAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().i().setValue(collegeAdapter);
        final CollegeActivityHomeBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f8324a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.college.page.sport.CollegeActivity$initAdapter$1$1

                /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
                public int offsetY;

                /* JADX INFO: renamed from: a, reason: from getter */
                public final int getOffsetY() {
                    return this.offsetY;
                }

                public final void b(int i) {
                    this.offsetY = i;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    this.offsetY += dy;
                    CollegeActivityHomeBinding collegeActivityHomeBinding = mBinding;
                    LinearLayout linearLayout = collegeActivityHomeBinding.f8323a;
                    if (linearLayout.getHeight() == 0) {
                        return;
                    }
                    float height = this.offsetY / linearLayout.getHeight();
                    if (height < 0.0f) {
                        height = 0.0f;
                    }
                    if (height > 1.0f) {
                        height = 1.0f;
                    }
                    collegeActivityHomeBinding.f8328a.setAlpha(height);
                }
            });
        }
    }

    public final void l0() {
        i0().setLifecycleOwner(this);
        i0().getRoot().setTag("SunshineRunHomeHeader");
        i0();
        m0();
        q0();
    }

    public final void m0() {
        Banner banner;
        Banner banner2;
        BannerImageAdapter<CollegeTownBannerBean> bannerImageAdapter = new BannerImageAdapter<CollegeTownBannerBean>() { // from class: com.huachenjie.college.page.sport.CollegeActivity$initHeaderBanner$bannerAdapter$1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onBindView(@NotNull BannerImageHolder holder, @NotNull CollegeTownBannerBean data, int position, int size) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(data, "data");
                Glide.with(holder.itemView).load(data.getCoverImg()).apply((BaseRequestOptions<?>) ju3.n).into(holder.imageView);
            }
        };
        bannerImageAdapter.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.jn1
            public final void OnBannerClick(Object obj, int i) {
                CollegeActivity.n0(this.f42621a, (CollegeTownBannerBean) obj, i);
            }
        });
        CollegeLayoutHomeHeaderBinding collegeLayoutHomeHeaderBindingI0 = i0();
        if (collegeLayoutHomeHeaderBindingI0 != null && (banner2 = collegeLayoutHomeHeaderBindingI0.f8429a) != null) {
            banner2.setAdapter(bannerImageAdapter);
        }
        CollegeLayoutHomeHeaderBinding collegeLayoutHomeHeaderBindingI1 = i0();
        Banner banner3 = collegeLayoutHomeHeaderBindingI1 != null ? collegeLayoutHomeHeaderBindingI1.f8429a : null;
        if (banner3 != null) {
            banner3.setIndicator(new CircleIndicator(this));
        }
        CollegeLayoutHomeHeaderBinding collegeLayoutHomeHeaderBindingI2 = i0();
        if (collegeLayoutHomeHeaderBindingI2 == null || (banner = collegeLayoutHomeHeaderBindingI2.f8429a) == null) {
            return;
        }
        banner.addBannerLifecycleObserver(this);
    }

    public final void o0() {
        int iJ = fx7.j();
        ew.n(this, vb8.c, r8a.l, getLifecycle(), getMBinding().f33550a, iJ, (iJ * 50) / 320, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().w();
    }

    public final void p0(CampusApplicationBean item) {
        int type = item.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    return;
                }
                ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", item.getLinkUrl()).navigation();
                return;
            } else if ((item.getSubType() == 7 || item.getSubType() == 8 || item.getSubType() == 10 || item.getSubType() == 11 || item.getSubType() == 20 || item.getSubType() == 21) && !ai9.m()) {
                ARouter.getInstance().build(RoutePathConstants.Common.b).greenChannel().navigation();
                return;
            } else {
                ARouter.getInstance().build(RoutePathConstants.Base.b).withString("url", item.getLinkUrl()).navigation();
                return;
            }
        }
        switch (item.getSubType()) {
            case -1:
                com.huachenjie.common.page.qrcode.a.b(com.huachenjie.common.page.qrcode.a.f33831a, new com.huachenjie.base.qr_code_scan.a(true), false, 2, null);
                break;
            case 1:
                ARouter.getInstance().build(RoutePathConstants.Sport.r).navigation();
                break;
            case 2:
                ARouter.getInstance().build(RoutePathConstants.Sport.g).navigation();
                break;
            case 3:
                ARouter.getInstance().build(RoutePathConstants.Sport.d).navigation();
                break;
            case 4:
                ARouter.getInstance().build(RoutePathConstants.Sport.n).navigation();
                break;
            case 5:
                ARouter.getInstance().build(RoutePathConstants.Sport.q).navigation();
                break;
            case 6:
                ARouter.getInstance().build(RoutePathConstants.Sport.b).withInt("type", 1).navigation();
                break;
        }
    }

    public final void q0() {
        i0().setVariable(uk0.p0, getMViewModel());
        i0().setVariable(uk0.k, new a());
        i0().setVariable(uk0.h, h0());
        i0().setVariable(uk0.e, g0());
        i0().executePendingBindings();
    }

    public final void r0() {
        Integer value = getMViewModel().r().getValue();
        if (value != null && value.intValue() == 1) {
            ARouter.getInstance().build(RoutePathConstants.Sport.j).navigation();
        } else if (value != null && value.intValue() == 2) {
            Postcard postcardBuild = ARouter.getInstance().build(RoutePathConstants.Run.j);
            qx6.f44321a.a(postcardBuild);
            postcardBuild.navigation();
        }
    }
}
