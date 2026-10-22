package com.huachenjie.works.page.broadcast_floor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.triver.basic.api.RequestPermission;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.source.rtsp.i;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorBean;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.huachenjie.works.databinding.WorksActivityBroadcastFloorBinding;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity;
import com.huachenjie.works.page.broadcast_floor.comment.CommentInputDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.noober.background.drawable.DrawableCreator;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.zj.adlib.cr2;
import com.zj.adlib.f64;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.jj8;
import com.zj.adlib.jw3;
import com.zj.adlib.kq5;
import com.zj.adlib.p01;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.BROADCAST_FLOOR)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u000210B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\n\u0010!\u001a\u0004\u0018\u00010 H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010 H\u0002R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityBroadcastFloorBinding;", "Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "", "result", "s0", "j0", i.m, "t0", "o0", "", "darkMode", "u0", "showSurvey", "n0", "m0", "r0", "Landroid/widget/ImageView;", "k0", "l0", "K", "I", "lastVerticalOffset", "", "Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorFragment;", "c", "Ljava/util/List;", "fragmentArray", "d", "Landroid/widget/ImageView;", "curView", "<init>", "()V", "a", "ClickProxy", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBroadcastFloorActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastFloorActivity.kt\ncom/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,341:1\n1855#2,2:342\n*S KotlinDebug\n*F\n+ 1 BroadcastFloorActivity.kt\ncom/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity\n*L\n127#1:342,2\n*E\n"})
public final class BroadcastFloorActivity extends BaseMVVMActivity<WorksActivityBroadcastFloorBinding, BroadcastFloorVM> {
    public static final int L = 1002;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int lastVerticalOffset;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<BroadcastFloorFragment> fragmentArray = new ArrayList();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public ImageView curView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "a", "b", "c", "d", "<init>", "(Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BroadcastFloorActivity.this.finish();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            f64.b().j();
            CommentInputDialog.Companion aVar = CommentInputDialog.INSTANCE;
            final BroadcastFloorActivity broadcastFloorActivity = BroadcastFloorActivity.this;
            CommentInputDialog commentInputDialogA = aVar.a("输入内容", new Function3<String, BroadcastFloorMessageImageBean, BroadcastFloorMessageVoiceBean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity$ClickProxy$clickPublishMessage$1
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((String) obj, (BroadcastFloorMessageImageBean) obj2, (BroadcastFloorMessageVoiceBean) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str, @Nullable BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, @Nullable BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean) {
                    BroadcastFloorActivity.e0(broadcastFloorActivity).q(broadcastFloorActivity, str, broadcastFloorMessageImageBean, broadcastFloorMessageVoiceBean);
                }
            });
            FragmentManager supportFragmentManager = BroadcastFloorActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            commentInputDialogA.show(supportFragmentManager, CommentInputDialog.class.getSimpleName());
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            BroadcastFloorBean value = BroadcastFloorActivity.e0(BroadcastFloorActivity.this).l().getValue();
            boolean z = false;
            if (value != null && value.getHandled()) {
                z = true;
            }
            if (z) {
                fv5.b("你已参与了该广播楼的心灵测试~");
            } else {
                su9.s(BroadcastFloorActivity.this, 1002);
            }
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Integer value = BroadcastFloorActivity.e0(BroadcastFloorActivity.this).m().getValue();
            if (value != null && value.intValue() == 1) {
                BroadcastFloorActivity.e0(BroadcastFloorActivity.this).m().setValue(2);
                fv5.b("已切换至全国校友说~");
            } else {
                BroadcastFloorActivity.e0(BroadcastFloorActivity.this).m().setValue(1);
                fv5.b("已切换至本校校友说~");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/works/page/broadcast_floor/BroadcastFloorActivity$b", "Lcom/youth/banner/listener/OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastFloorActivity f37201a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BroadcastFloorBannerAdapter f14874a;

        public b(BroadcastFloorBannerAdapter broadcastFloorBannerAdapter, BroadcastFloorActivity broadcastFloorActivity) {
            this.f14874a = broadcastFloorBannerAdapter;
            this.f37201a = broadcastFloorActivity;
        }

        public void onPageScrollStateChanged(int state) {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            ImageView curView;
            if (this.f14874a.getRealCount() == 0) {
                return;
            }
            String str = (String) this.f14874a.getData(position);
            ImageView imageViewK0 = this.f37201a.k0();
            if (imageViewK0 == null || (curView = this.f37201a.getCurView()) == null) {
                return;
            }
            Glide.with(imageViewK0).load(str).into(imageViewK0);
            this.f37201a.curView = imageViewK0;
            jw3.b(curView, imageViewK0);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37202a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37202a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37202a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37202a.invoke(obj);
        }
    }

    public static final /* synthetic */ BroadcastFloorVM e0(BroadcastFloorActivity broadcastFloorActivity) {
        return broadcastFloorActivity.getMViewModel();
    }

    public static final void p0(BroadcastFloorActivity broadcastFloorActivity, WorksActivityBroadcastFloorBinding worksActivityBroadcastFloorBinding, float f, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(broadcastFloorActivity, "this$0");
        Intrinsics.checkNotNullParameter(worksActivityBroadcastFloorBinding, "$this_apply");
        if (broadcastFloorActivity.lastVerticalOffset == i) {
            return;
        }
        broadcastFloorActivity.lastVerticalOffset = i;
        i4a.c("OnOffsetChangedListener");
        float fAbs = Math.abs(i) / (worksActivityBroadcastFloorBinding.f13824a.getHeight() - worksActivityBroadcastFloorBinding.f13820a.getHeight());
        if (fAbs > 0.5d) {
            broadcastFloorActivity.u0(true);
            worksActivityBroadcastFloorBinding.f13831d.setTextColor(Color.parseColor("#FF2C3E50"));
            worksActivityBroadcastFloorBinding.b.setImageResource(R.drawable.works_ic_broadcast_floor_back_black);
            worksActivityBroadcastFloorBinding.f13829b.setTextColor(Color.parseColor("#FF2C3E50"));
            Drawable drawable = appBarLayout.getContext().getDrawable(R.drawable.works_ic_broadcast_floor_switch);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, Color.parseColor("#FF2C3E50"));
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                worksActivityBroadcastFloorBinding.f13829b.setCompoundDrawables(drawable, null, null, null);
            }
        } else {
            broadcastFloorActivity.u0(false);
            worksActivityBroadcastFloorBinding.f13831d.setTextColor(-1);
            worksActivityBroadcastFloorBinding.b.setImageResource(R.drawable.works_ic_broadcast_floor_back_white);
            worksActivityBroadcastFloorBinding.f13829b.setTextColor(-1);
            Drawable drawable2 = appBarLayout.getContext().getDrawable(R.drawable.works_ic_broadcast_floor_switch);
            if (drawable2 != null) {
                DrawableCompat.setTint(drawable2, -1);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                worksActivityBroadcastFloorBinding.f13829b.setCompoundDrawables(drawable2, null, null, null);
            }
        }
        worksActivityBroadcastFloorBinding.f13820a.setBackgroundColor(Color.argb((int) (255 * fAbs), 255, 255, 255));
        float f2 = f * (1 - fAbs);
        worksActivityBroadcastFloorBinding.f13827a.setBackground(new DrawableCreator.Builder().setGradientColor(Color.parseColor("#FFFFFF"), Color.parseColor("#FFF5F5F5")).setCornersRadius(0.0f, 0.0f, f2, f2).build());
    }

    public static final void q0(BroadcastFloorActivity broadcastFloorActivity) {
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(broadcastFloorActivity, "this$0");
        WorksActivityBroadcastFloorBinding mBinding = broadcastFloorActivity.getMBinding();
        int height = (mBinding == null || (constraintLayout = mBinding.f13821a) == null) ? 0 : constraintLayout.getHeight();
        i4a.a("height:" + height);
        if (height > 0) {
            WorksActivityBroadcastFloorBinding mBinding2 = broadcastFloorActivity.getMBinding();
            ViewGroup.LayoutParams layoutParams = (mBinding2 == null || (frameLayout = mBinding2.f13817a) == null) ? null : frameLayout.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = height + jj8.a(20.0f);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new c(new Function1<BroadcastFloorBean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BroadcastFloorBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BroadcastFloorBean broadcastFloorBean) {
                ImageView imageView;
                this.this$0.getMBinding().f13818a.setAlpha(1.0f);
                this.this$0.getMBinding().f13818a.setImageDrawable(null);
                this.this$0.getMBinding().d.setAlpha(0.0f);
                this.this$0.getMBinding().d.setImageDrawable(null);
                BroadcastFloorActivity broadcastFloorActivity = this.this$0;
                broadcastFloorActivity.curView = broadcastFloorActivity.getMBinding().f13818a;
                if ((!broadcastFloorBean.getCoverImages().isEmpty()) && (imageView = this.this$0.curView) != null) {
                    Glide.with(imageView).load(broadcastFloorBean.getCoverImages().get(0)).into(imageView);
                }
                this.this$0.getMBinding().f13828a.setDatas(broadcastFloorBean.getCoverImages());
                this.this$0.n0(!TextUtils.isEmpty(broadcastFloorBean.getSurveyNo()));
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                if (num != null && num.intValue() == 1) {
                    this.this$0.getMBinding().f13829b.setText(fe9.b.ALUMNI);
                } else {
                    this.this$0.getMBinding().f13829b.setText("全国");
                }
                BroadcastFloorActivity broadcastFloorActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(num, i.m);
                broadcastFloorActivity.t0(num.intValue());
            }
        }));
        getMViewModel().o().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                this.this$0.s0(str);
            }
        }));
        getMViewModel().n().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (!bool.booleanValue()) {
                    this.this$0.j0();
                    return;
                }
                kq5.b(this.this$0, "publishAlumniSay", null);
                BroadcastFloorActivity broadcastFloorActivity = this.this$0;
                Integer value = BroadcastFloorActivity.e0(broadcastFloorActivity).m().getValue();
                Intrinsics.checkNotNull(value);
                broadcastFloorActivity.t0(value.intValue());
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_broadcast_floor;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s();
        getMViewModel().r();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        TextView textView;
        Drawable drawable;
        ConstraintLayout constraintLayout;
        u0(false);
        o0();
        m0();
        r0();
        WorksActivityBroadcastFloorBinding mBinding = getMBinding();
        if (mBinding != null && (constraintLayout = mBinding.f13821a) != null) {
            constraintLayout.postDelayed(new Runnable() { // from class: com.zj.adlib.f01
                @Override // java.lang.Runnable
                public final void run() {
                    BroadcastFloorActivity.q0(this.f41560a);
                }
            }, 500L);
        }
        WorksActivityBroadcastFloorBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (textView = mBinding2.f13829b) == null || (drawable = textView.getContext().getDrawable(R.drawable.works_ic_broadcast_floor_switch)) == null) {
            return;
        }
        DrawableCompat.setTint(drawable, -1);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    public final void j0() {
        p01.f43867a.a(this);
        finish();
    }

    public final ImageView k0() {
        ImageView imageView = this.curView;
        if (imageView == null) {
            return null;
        }
        Intrinsics.checkNotNull(imageView);
        return imageView.getId() == R.id.curImage ? getMBinding().d : getMBinding().f13818a;
    }

    /* JADX INFO: renamed from: l0, reason: from getter */
    public final ImageView getCurView() {
        return this.curView;
    }

    public final void m0() {
        Banner banner = getMBinding().f13828a;
        Intrinsics.checkNotNullExpressionValue(banner, "mBinding.vpBroadcastFloorBanner");
        BroadcastFloorBannerAdapter broadcastFloorBannerAdapter = new BroadcastFloorBannerAdapter();
        banner.addBannerLifecycleObserver(this).setAdapter(broadcastFloorBannerAdapter).setIndicator(new CircleIndicator(banner.getContext()));
        banner.addOnPageChangeListener(new b(broadcastFloorBannerAdapter, this));
    }

    public final void n0(boolean showSurvey) {
        Integer value;
        List<BroadcastFloorFragment> listMutableListOf;
        MutableLiveData<Integer> mutableLiveDataM;
        Integer value2;
        Integer value3;
        MutableLiveData<Integer> mutableLiveDataM2;
        MutableLiveData<Integer> mutableLiveDataM3;
        WorksActivityBroadcastFloorBinding mBinding = getMBinding();
        if (mBinding != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
            mBinding.f13822a.setAdapter(viewPagerAdapter);
            List<String> listListOf = showSurvey ? CollectionsKt.listOf(new String[]{"校友说", "与你匹配"}) : CollectionsKt.listOf("校友说");
            if (showSurvey) {
                BroadcastFloorFragment[] broadcastFloorFragmentArr = new BroadcastFloorFragment[2];
                BroadcastFloorFragment.Companion aVar = BroadcastFloorFragment.INSTANCE;
                BroadcastFloorVM mViewModel = getMViewModel();
                if (mViewModel == null || (mutableLiveDataM3 = mViewModel.m()) == null || (value2 = mutableLiveDataM3.getValue()) == null) {
                    value2 = 2;
                }
                Intrinsics.checkNotNullExpressionValue(value2, "mViewModel?.broadcastRange?.value ?: 2");
                broadcastFloorFragmentArr[0] = aVar.a(value2.intValue(), 0);
                BroadcastFloorVM mViewModel2 = getMViewModel();
                if (mViewModel2 == null || (mutableLiveDataM2 = mViewModel2.m()) == null || (value3 = mutableLiveDataM2.getValue()) == null) {
                    value3 = 2;
                }
                Intrinsics.checkNotNullExpressionValue(value3, "mViewModel?.broadcastRange?.value ?: 2");
                broadcastFloorFragmentArr[1] = aVar.a(value3.intValue(), 1);
                listMutableListOf = CollectionsKt.mutableListOf(broadcastFloorFragmentArr);
            } else {
                BroadcastFloorFragment[] broadcastFloorFragmentArr2 = new BroadcastFloorFragment[1];
                BroadcastFloorFragment.Companion aVar2 = BroadcastFloorFragment.INSTANCE;
                BroadcastFloorVM mViewModel3 = getMViewModel();
                if (mViewModel3 == null || (mutableLiveDataM = mViewModel3.m()) == null || (value = mutableLiveDataM.getValue()) == null) {
                    value = 2;
                }
                Intrinsics.checkNotNullExpressionValue(value, "mViewModel?.broadcastRange?.value ?: 2");
                broadcastFloorFragmentArr2[0] = aVar2.a(value.intValue(), 0);
                listMutableListOf = CollectionsKt.mutableListOf(broadcastFloorFragmentArr2);
            }
            this.fragmentArray = listMutableListOf;
            mBinding.f13822a.setOffscreenPageLimit(listListOf.size());
            viewPagerAdapter.a(listListOf, this.fragmentArray);
            mBinding.f13823a.setViewPager(mBinding.f13822a, listListOf);
        }
    }

    public final void o0() {
        final float fC = cr2.c(this, 20.0f);
        Integer value = getMViewModel().e().c().getValue();
        if (value == null) {
            value = 0;
        }
        int iIntValue = value.intValue();
        final WorksActivityBroadcastFloorBinding mBinding = getMBinding();
        if (mBinding != null) {
            Toolbar toolbar = mBinding.f13820a;
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            layoutParams.height += iIntValue;
            toolbar.setLayoutParams(layoutParams);
            mBinding.f13820a.setPadding(0, iIntValue, 0, 0);
            mBinding.f13824a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.zj.adlib.g01
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    BroadcastFloorActivity.p0(this.f16651a, mBinding, fC, appBarLayout, i);
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1002 || data == null) {
            return;
        }
        String stringExtra = data.getStringExtra("result");
        i4a.a("close result:" + stringExtra);
        MutableLiveData<String> mutableLiveDataO = getMViewModel().o();
        if (stringExtra == null) {
            stringExtra = "";
        }
        mutableLiveDataO.setValue(stringExtra);
    }

    public final void r0() {
        BroadcastFloorMessageBean broadcastFloorMessageBean;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (broadcastFloorMessageBean = (BroadcastFloorMessageBean) extras.getParcelable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY)) == null) {
            return;
        }
        BroadcastFloorDetailDialog.Companion aVar = BroadcastFloorDetailDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        aVar.a(supportFragmentManager, broadcastFloorMessageBean);
    }

    public final void s0(@Nullable String result) {
        MutableLiveData<BroadcastFloorBean> mutableLiveDataL;
        if (TextUtils.isEmpty(result)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(result);
            String strOptString = jSONObject.optString("resultTitle");
            String strOptString2 = jSONObject.optString("resultImage");
            BroadcastFloorBean value = null;
            kq5.b(this, "finishQuestionnaire", null);
            BroadcastFloorVM mViewModel = getMViewModel();
            if (mViewModel != null && (mutableLiveDataL = mViewModel.l()) != null) {
                value = mutableLiveDataL.getValue();
            }
            if (value != null) {
                value.setHandled(true);
            }
            Integer value2 = getMViewModel().m().getValue();
            if (value2 == null) {
                value2 = 2;
            }
            t0(value2.intValue());
            SurveySuccessDialog.Companion aVar = SurveySuccessDialog.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(strOptString, "resultTitle");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "resultImage");
            SurveySuccessDialog surveySuccessDialogA = aVar.a(strOptString, strOptString2);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            surveySuccessDialogA.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(SurveySuccessDialog.class).getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void t0(int range) {
        for (BroadcastFloorFragment broadcastFloorFragment : this.fragmentArray) {
            if (broadcastFloorFragment.getVisibleToUser()) {
                broadcastFloorFragment.refresh(range);
            } else {
                broadcastFloorFragment.setNeedRefresh(true);
            }
        }
    }

    public final void u0(boolean darkMode) {
        e.p3(this).G2(R.color.transparent).T2(darkMode).q1(false).u1(R.color.white).G1(true).a1();
    }
}
