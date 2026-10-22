package com.huachenjie.home.dialog.sign;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignConfigBean;
import com.huachenjie.home.databinding.HomeDialogSignBinding;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ew;
import com.zj.adlib.fb4;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.vb8;
import com.zj.adlib.xk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/home/dialog/sign/SignDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/home/databinding/HomeDialogSignBinding;", "Lcom/huachenjie/home/dialog/sign/SignVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initView", "initData", "initDataObserve", "<init>", "()V", "Companion", "a", "b", "home_release"}, k = 1, mv = {1, 8, 0})
public final class SignDialog extends BaseMVVMDialogFragment<HomeDialogSignBinding, SignVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/home/dialog/sign/SignDialog$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/home/dialog/sign/SignDialog;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.home.dialog.sign.SignDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\r"}, d2 = {"com/huachenjie/home/dialog/sign/SignDialog$a$a", "Lcom/huachenjie/ad/interfaces/RewardVideoAdListener;", "", "loadSupplier", "", "platform", "", "d", "e", "b", "code", "message", "c", "home_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0802a extends RewardVideoAdListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SignDialog f34319a;

            public C0802a(SignDialog signDialog) {
                this.f34319a = signDialog;
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void b(int loadSupplier) {
                SignDialog.access$getMViewModel(this.f34319a).c();
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void c(int loadSupplier, @Nullable String code, @Nullable String message) {
                SignDialog.access$getMViewModel(this.f34319a).c();
                fv5.b("广告加载失败，请稍后再试");
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void d(int loadSupplier, @Nullable String platform) {
                SignDialog.access$getMViewModel(this.f34319a).n();
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void e(int loadSupplier, @Nullable String platform) {
                SignDialog.access$getMViewModel(this.f34319a).c();
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SignDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SignConfigBean value = SignDialog.access$getMViewModel(SignDialog.this).j().getValue();
            if (value == null) {
                return;
            }
            if (!value.getTodaySigned()) {
                SignDialog.access$getMViewModel(SignDialog.this).m();
            } else {
                if (!value.getVideoConfig().getAllowVideo() || value.getVideoConfig().getTodayWatchedCount() >= value.getVideoConfig().getMaxCount()) {
                    return;
                }
                SignDialog.access$getMViewModel(SignDialog.this).g();
                ew.j().i(vb8.j, SignDialog.this.requireActivity(), SignDialog.this.getLifecycle(), new C0802a(SignDialog.this));
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.sign.SignDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/home/dialog/sign/SignDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "a", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            new SignDialog().show(fragmentManager, Reflection.getOrCreateKotlinClass(SignDialog.class).getSimpleName());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34320a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34320a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34320a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34320a.invoke(obj);
        }
    }

    public static final /* synthetic */ HomeDialogSignBinding access$getMBinding(SignDialog signDialog) {
        return signDialog.getMBinding();
    }

    public static final /* synthetic */ SignVM access$getMViewModel(SignDialog signDialog) {
        return signDialog.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_sign;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - (SizeUtils.b(16.0f) * 2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().l();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        getMViewModel().j().observe(this, new c(new Function1<SignConfigBean, Unit>() { // from class: com.huachenjie.home.dialog.sign.SignDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SignConfigBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SignConfigBean signConfigBean) {
                StrokeTextView strokeTextView;
                StrokeTextView strokeTextView2;
                StrokeTextView strokeTextView3;
                StrokeTextView strokeTextView4;
                if (!signConfigBean.getTodaySigned()) {
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding = SignDialog.access$getMBinding(SignDialog.this);
                    StrokeTextView strokeTextView5 = homeDialogSignBindingAccess$getMBinding != null ? homeDialogSignBindingAccess$getMBinding.f9381a : null;
                    if (strokeTextView5 != null) {
                        strokeTextView5.setText("签到领取");
                    }
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding2 = SignDialog.access$getMBinding(SignDialog.this);
                    StrokeTextView strokeTextView6 = homeDialogSignBindingAccess$getMBinding2 != null ? homeDialogSignBindingAccess$getMBinding2.f9381a : null;
                    if (strokeTextView6 != null) {
                        strokeTextView6.setTextSize(22.0f);
                    }
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding3 = SignDialog.access$getMBinding(SignDialog.this);
                    if (homeDialogSignBindingAccess$getMBinding3 == null || (strokeTextView4 = homeDialogSignBindingAccess$getMBinding3.f9381a) == null) {
                        return;
                    }
                    strokeTextView4.setBackgroundResource(R.drawable.home_bg_sign_btn);
                    return;
                }
                if (signConfigBean.getVideoConfig().getAllowVideo() && signConfigBean.getVideoConfig().getTodayWatchedCount() < signConfigBean.getVideoConfig().getMaxCount()) {
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding4 = SignDialog.access$getMBinding(SignDialog.this);
                    StrokeTextView strokeTextView7 = homeDialogSignBindingAccess$getMBinding4 != null ? homeDialogSignBindingAccess$getMBinding4.f9381a : null;
                    if (strokeTextView7 != null) {
                        strokeTextView7.setText("看视频额外领取" + signConfigBean.getVideoConfig().getVideoReward() + fe9.b.FLASH_COINS);
                    }
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding5 = SignDialog.access$getMBinding(SignDialog.this);
                    StrokeTextView strokeTextView8 = homeDialogSignBindingAccess$getMBinding5 != null ? homeDialogSignBindingAccess$getMBinding5.f9381a : null;
                    if (strokeTextView8 != null) {
                        strokeTextView8.setTextSize(18.0f);
                    }
                    HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding6 = SignDialog.access$getMBinding(SignDialog.this);
                    if (homeDialogSignBindingAccess$getMBinding6 == null || (strokeTextView3 = homeDialogSignBindingAccess$getMBinding6.f9381a) == null) {
                        return;
                    }
                    strokeTextView3.setBackgroundResource(R.drawable.home_bg_sign_btn_long);
                    return;
                }
                HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding7 = SignDialog.access$getMBinding(SignDialog.this);
                StrokeTextView strokeTextView9 = homeDialogSignBindingAccess$getMBinding7 != null ? homeDialogSignBindingAccess$getMBinding7.f9381a : null;
                if (strokeTextView9 != null) {
                    strokeTextView9.setText("今日已签到");
                }
                HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding8 = SignDialog.access$getMBinding(SignDialog.this);
                StrokeTextView strokeTextView10 = homeDialogSignBindingAccess$getMBinding8 != null ? homeDialogSignBindingAccess$getMBinding8.f9381a : null;
                if (strokeTextView10 != null) {
                    strokeTextView10.setTextSize(22.0f);
                }
                HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding9 = SignDialog.access$getMBinding(SignDialog.this);
                StrokeTextView strokeTextView11 = homeDialogSignBindingAccess$getMBinding9 != null ? homeDialogSignBindingAccess$getMBinding9.f9381a : null;
                if (strokeTextView11 != null) {
                    strokeTextView11.setBackground(new DrawableCreator.Builder().setSolidColor(-3355444).setCornersRadius(SizeUtils.b(26.0f)).setStrokeWidth(SizeUtils.b(4.0f)).setStrokeColor(-1513240).build());
                }
                HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding10 = SignDialog.access$getMBinding(SignDialog.this);
                if (homeDialogSignBindingAccess$getMBinding10 != null && (strokeTextView2 = homeDialogSignBindingAccess$getMBinding10.f9381a) != null) {
                    strokeTextView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                HomeDialogSignBinding homeDialogSignBindingAccess$getMBinding11 = SignDialog.access$getMBinding(SignDialog.this);
                ViewGroup.LayoutParams layoutParams = (homeDialogSignBindingAccess$getMBinding11 == null || (strokeTextView = homeDialogSignBindingAccess$getMBinding11.f9381a) == null) ? null : strokeTextView.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = SizeUtils.b(36.0f);
                    layoutParams2.bottomMargin = SizeUtils.b(36.0f);
                }
            }
        }));
        getMViewModel().k().observe(this, new c(new Function1<Integer, Unit>() { // from class: com.huachenjie.home.dialog.sign.SignDialog.initDataObserve.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                if (num == null) {
                    return;
                }
                fb4 fb4Var = fb4.f41638a;
                Context contextRequireContext = SignDialog.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                fb4Var.a(contextRequireContext, num.intValue());
                Context contextRequireContext2 = SignDialog.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                fb4Var.b(contextRequireContext2);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        HomeDialogSignBinding mBinding = getMBinding();
        RecyclerView recyclerView = mBinding != null ? mBinding.f9380a : null;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
        }
        HomeDialogSignBinding mBinding2 = getMBinding();
        RecyclerView recyclerView2 = mBinding2 != null ? mBinding2.f9380a : null;
        if (recyclerView2 != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 4);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.huachenjie.home.dialog.sign.SignDialog$initView$1$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    return position == 6 ? 2 : 1;
                }
            });
            recyclerView2.setLayoutManager(gridLayoutManager);
        }
        getMViewModel().i().setValue(new SignAdapter());
    }
}
