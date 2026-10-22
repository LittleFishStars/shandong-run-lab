package com.huachenjie.works.page.alumni.channel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.ad.impl.JzAdLoader;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentAlumniChannelBinding;
import com.huachenjie.works.databinding.WorksLayoutAlumniChannelHeaderBinding;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.external.bean.WorkNativeAdBean;
import com.huachenjie.works.page.alumni.channel.AlumniChannelFragment;
import com.huachenjie.works.page.channel.list.AllChannelActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ew;
import com.zj.adlib.fx7;
import com.zj.adlib.hp4;
import com.zj.adlib.i4a;
import com.zj.adlib.pi4;
import com.zj.adlib.qk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huachenjie/works/page/alumni/channel/AlumniChannelFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentAlumniChannelBinding;", "Lcom/huachenjie/works/page/alumni/channel/AlumniChannelVM;", "", "loadNativeAd", "", "", "", "getVariables", "getLayoutResID", "initData", "initDataObservable", "initView", "", "isDark", "Z", "()Z", "setDark", "(Z)V", "Lcom/huachenjie/works/databinding/WorksLayoutAlumniChannelHeaderBinding;", "kotlin.jvm.PlatformType", "mHeaderBinding$delegate", "Lkotlin/Lazy;", "getMHeaderBinding", "()Lcom/huachenjie/works/databinding/WorksLayoutAlumniChannelHeaderBinding;", "mHeaderBinding", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AlumniChannelFragment extends BaseMVVMFragment<WorksFragmentAlumniChannelBinding, AlumniChannelVM> {
    private boolean isDark;

    /* JADX INFO: renamed from: mHeaderBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHeaderBinding = LazyKt.lazy(new Function0<WorksLayoutAlumniChannelHeaderBinding>() { // from class: com.huachenjie.works.page.alumni.channel.AlumniChannelFragment$mHeaderBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksLayoutAlumniChannelHeaderBinding m846invoke() {
            return (WorksLayoutAlumniChannelHeaderBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.works_layout_alumni_channel_header, null, false);
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.d50
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            AlumniChannelFragment.onRefreshListener$lambda$0(this.f41107a);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/alumni/channel/AlumniChannelFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/alumni/channel/AlumniChannelFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AlumniChannelFragment.this.startActivity(new Intent(view.getContext(), (Class<?>) AllChannelActivity.class));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/works/page/alumni/channel/AlumniChannelFragment$b", "Lcom/zj/adlib/pi4;", "Lcn/hzjizhun/admin/ad/bean/JZUnifiedAdInfo;", "unifiedAdInfo", "", "c", "adInfo", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends pi4 {
        public b() {
        }

        @Override // com.zj.adlib.pi4
        public void a(@Nullable JZUnifiedAdInfo adInfo) {
        }

        @Override // com.zj.adlib.pi4
        public void c(@Nullable JZUnifiedAdInfo unifiedAdInfo) {
            AlumniChannelVM alumniChannelVMAccess$getMViewModel;
            MutableLiveData<WorksAdapter> mutableLiveDataN;
            WorksAdapter value;
            MutableLiveData<Boolean> mutableLiveDataS;
            if (unifiedAdInfo == null) {
                return;
            }
            try {
                AlumniChannelVM alumniChannelVMAccess$getMViewModel2 = AlumniChannelFragment.access$getMViewModel(AlumniChannelFragment.this);
                if (((alumniChannelVMAccess$getMViewModel2 == null || (mutableLiveDataS = alumniChannelVMAccess$getMViewModel2.s()) == null) ? false : Intrinsics.areEqual(mutableLiveDataS.getValue(), Boolean.TRUE)) || (alumniChannelVMAccess$getMViewModel = AlumniChannelFragment.access$getMViewModel(AlumniChannelFragment.this)) == null || (mutableLiveDataN = alumniChannelVMAccess$getMViewModel.n()) == null || (value = mutableLiveDataN.getValue()) == null || value.getData().isEmpty()) {
                    return;
                }
                int iMin = Math.min(4, value.getData().size());
                int i = -1;
                for (int i2 = 0; i2 < iMin; i2++) {
                    if (((WorkItemBean) value.getData().get(i2)).getPostType() == 4) {
                        i = i2;
                    }
                }
                if (i == -1) {
                    WorkNativeAdBean workNativeAdBean = new WorkNativeAdBean();
                    workNativeAdBean.setAdInfo(unifiedAdInfo);
                    value.addData(1, workNativeAdBean);
                } else {
                    WorkItemBean workItemBean = (WorkItemBean) value.getData().get(i);
                    Intrinsics.checkNotNull(workItemBean, "null cannot be cast to non-null type com.huachenjie.works.external.bean.WorkNativeAdBean");
                    ((WorkNativeAdBean) workItemBean).setAdInfo(unifiedAdInfo);
                    value.notifyItemChanged(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37161a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37161a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37161a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37161a.invoke(obj);
        }
    }

    public static final /* synthetic */ AlumniChannelVM access$getMViewModel(AlumniChannelFragment alumniChannelFragment) {
        return alumniChannelFragment.getMViewModel();
    }

    private final WorksLayoutAlumniChannelHeaderBinding getMHeaderBinding() {
        return (WorksLayoutAlumniChannelHeaderBinding) this.mHeaderBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataObservable$lambda$3(AlumniChannelFragment alumniChannelFragment, Object obj) {
        WorksFragmentAlumniChannelBinding mBinding;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(alumniChannelFragment, "this$0");
        if (!(obj instanceof String)) {
            if (!(obj instanceof Integer) || (mBinding = alumniChannelFragment.getMBinding()) == null || (imageView = mBinding.f14157a) == null) {
                return;
            }
            imageView.setImageResource(((Number) obj).intValue());
            return;
        }
        WorksFragmentAlumniChannelBinding mBinding2 = alumniChannelFragment.getMBinding();
        if (mBinding2 == null || (imageView2 = mBinding2.f14157a) == null) {
            return;
        }
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(imageView2).load((String) obj);
        int i = R.drawable.works_ic_channel_header_placeholder;
        requestBuilderLoad.placeholder(i).error(i).into(imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNativeAd() {
        JzAdLoader jzAdLoaderF;
        FragmentActivity activity = getActivity();
        if (activity == null || (jzAdLoaderF = ew.f()) == null) {
            return;
        }
        jzAdLoaderF.i(activity, hp4.h, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(AlumniChannelFragment alumniChannelFragment) {
        Intrinsics.checkNotNullParameter(alumniChannelFragment, "this$0");
        alumniChannelFragment.getMViewModel().x();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_alumni_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().x();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().p().observe(this, new Observer() { // from class: com.zj.adlib.c50
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                AlumniChannelFragment.initDataObservable$lambda$3(this.f40903a, obj);
            }
        });
        getMViewModel().q().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.alumni.channel.AlumniChannelFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    AlumniChannelFragment.this.loadNativeAd();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        MutableLiveData<WorksAdapter> mutableLiveDataN;
        WorksFragmentAlumniChannelBinding mBinding = getMBinding();
        if (mBinding != null) {
            RecyclerView recyclerView = mBinding.f14158a;
            VerticalGridLayoutManager verticalGridLayoutManager = new VerticalGridLayoutManager(2, 1);
            verticalGridLayoutManager.setGapStrategy(0);
            recyclerView.setLayoutManager(verticalGridLayoutManager);
            mBinding.f14158a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.channel.AlumniChannelFragment$initView$1$2

                /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
                public int verticalOffset;

                /* JADX INFO: renamed from: a, reason: from getter */
                public final int getVerticalOffset() {
                    return this.verticalOffset;
                }

                public final void b(int i) {
                    this.verticalOffset = i;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                    View view;
                    View view2;
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    this.verticalOffset += dy;
                    AlumniChannelFragment.access$getMViewModel(this.f14857a).r().setValue(Integer.valueOf(-this.verticalOffset));
                    i4a.a(String.valueOf(this.verticalOffset));
                    WorksFragmentAlumniChannelBinding mBinding2 = this.f14857a.getMBinding();
                    float fAbs = Math.abs(this.verticalOffset) / ((mBinding2 == null || (view2 = mBinding2.b) == null) ? 1 : view2.getHeight());
                    boolean z = ((double) fAbs) > 0.5d;
                    if (this.f14857a.getIsDark() != z) {
                        this.f14857a.setDark(z);
                    }
                    if (fAbs < 0.0f) {
                        fAbs = 0.0f;
                    }
                    if (fAbs > 1.0f) {
                        fAbs = 1.0f;
                    }
                    int iArgb = Color.argb((int) (fAbs * 255), 255, 255, 255);
                    WorksFragmentAlumniChannelBinding mBinding3 = this.f14857a.getMBinding();
                    if (mBinding3 == null || (view = mBinding3.b) == null) {
                        return;
                    }
                    view.setBackgroundColor(iArgb);
                }
            });
            AlumniChannelVM mViewModel = getMViewModel();
            WorksAdapter value = (mViewModel == null || (mutableLiveDataN = mViewModel.n()) == null) ? null : mutableLiveDataN.getValue();
            if (value != null) {
                value.setHeaderWithEmptyEnable(true);
            }
            getMHeaderBinding().f14775a.setLayoutManager(new HorizontalLinearLayoutManager(getContext()));
            float fJ = (fx7.j() - SizeUtils.b(28.0f)) / 3.0f;
            AllChannelListAdapter value2 = getMViewModel().o().getValue();
            if (value2 != null) {
                value2.u(fJ);
            }
            final float fB = fJ + SizeUtils.b(3.0f);
            getMHeaderBinding().f14775a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.channel.AlumniChannelFragment$initView$1$3

                /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
                public int horizontalOffset;

                /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                public int lastIndex;

                /* JADX INFO: renamed from: a, reason: from getter */
                public final int getHorizontalOffset() {
                    return this.horizontalOffset;
                }

                /* JADX INFO: renamed from: b, reason: from getter */
                public final int getLastIndex() {
                    return this.lastIndex;
                }

                public final void c(int i) {
                    this.horizontalOffset = i;
                }

                public final void d(int i) {
                    this.lastIndex = i;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                    Object objValueOf;
                    Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                    this.horizontalOffset += dx;
                    AllChannelListAdapter value3 = AlumniChannelFragment.access$getMViewModel(this.f14859a).o().getValue();
                    if (value3 == null) {
                        return;
                    }
                    int i = this.horizontalOffset;
                    float f = fB;
                    int i2 = (int) (i / f);
                    if (!(((float) i) % f == 0.0f)) {
                        i2++;
                    }
                    if ((i2 >= 0 && i2 < value3.getData().size()) && this.lastIndex != i2) {
                        this.lastIndex = i2;
                        String coverImgUrl = value3.getData().get(i2).getCoverImgUrl();
                        MutableLiveData<Object> mutableLiveDataP = AlumniChannelFragment.access$getMViewModel(this.f14859a).p();
                        if (TextUtils.isEmpty(coverImgUrl)) {
                            objValueOf = coverImgUrl;
                            objValueOf = Integer.valueOf(R.drawable.works_ic_channel_header_empty);
                        }
                        objValueOf = coverImgUrl;
                        mutableLiveDataP.setValue(objValueOf);
                    }
                }
            });
            getMHeaderBinding().m(getMViewModel());
            getMHeaderBinding().l(new a());
            getMHeaderBinding().executePendingBindings();
            WorksAdapter value3 = getMViewModel().n().getValue();
            if (value3 != null) {
                Intrinsics.checkNotNullExpressionValue(value3, "value");
                View root = getMHeaderBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "mHeaderBinding.root");
                BaseQuickAdapter.setHeaderView$default(value3, root, 0, 0, 6, null);
            }
        }
    }

    /* JADX INFO: renamed from: isDark, reason: from getter */
    public final boolean getIsDark() {
        return this.isDark;
    }

    public final void setDark(boolean z) {
        this.isDark = z;
    }
}
