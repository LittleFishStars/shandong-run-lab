package com.huachenjie.mall.page.course_detail;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.video.AliVideoCallback;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.databinding.MallActivityCourseDetailBinding;
import com.huachenjie.mall.databinding.MallViewCourseDetailHeaderBinding;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002+\u0018B\u0007¢\u0006\u0004\b)\u0010*J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR#\u0010(\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/huachenjie/mall/page/course_detail/CourseDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityCourseDetailBinding;", "Lcom/huachenjie/mall/page/course_detail/CourseDetailVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "n0", "l0", bo.g, "", "progress", "r0", "g0", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "episodeItem", "q0", "", "b", "Lkotlin/Lazy;", "h0", "()Ljava/lang/String;", "episodeNo", "c", "j0", "orderItemNo", "d", "k0", "skuNo", "Lcom/huachenjie/mall/databinding/MallViewCourseDetailHeaderBinding;", "kotlin.jvm.PlatformType", "e", "i0", "()Lcom/huachenjie/mall/databinding/MallViewCourseDetailHeaderBinding;", "headerBinding", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CourseDetailActivity extends BaseMVVMActivity<MallActivityCourseDetailBinding, CourseDetailVM> {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_episode_no";

    @NotNull
    public static final String x = "key_order_item_no";

    @NotNull
    public static final String y = "key_sku_no";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy episodeNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$episodeNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_episode_no");
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderItemNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$orderItemNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_order_item_no");
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy skuNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$skuNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_sku_no");
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerBinding = LazyKt.lazy(new Function0<MallViewCourseDetailHeaderBinding>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$headerBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallViewCourseDetailHeaderBinding m512invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_view_course_detail_header, null, false);
            CourseDetailActivity courseDetailActivity = this.this$0;
            MallViewCourseDetailHeaderBinding mallViewCourseDetailHeaderBinding = (MallViewCourseDetailHeaderBinding) viewDataBindingInflate;
            mallViewCourseDetailHeaderBinding.k(CourseDetailActivity.d0(courseDetailActivity));
            mallViewCourseDetailHeaderBinding.setLifecycleOwner(courseDetailActivity);
            return mallViewCourseDetailHeaderBinding;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/course_detail/CourseDetailActivity$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/page/course_detail/CourseDetailActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (CourseDetailActivity.d0(CourseDetailActivity.this).k().getValue() == null) {
                return;
            }
            if (!Intrinsics.areEqual(CourseDetailActivity.d0(CourseDetailActivity.this).m().getValue(), Boolean.TRUE)) {
                CourseDetailActivity.d0(CourseDetailActivity.this).o().setValue(4);
                return;
            }
            CourseDetailActivity courseDetailActivity = CourseDetailActivity.this;
            EpisodeItemBean value = CourseDetailActivity.d0(courseDetailActivity).k().getValue();
            Intrinsics.checkNotNull(value);
            courseDetailActivity.q0(value);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.course_detail.CourseDetailActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/course_detail/CourseDetailActivity$b;", "", "Landroid/content/Context;", "context", "", "episodeNo", "", "a", "orderItemNo", "b", "skuNo", "c", "KEY_EPISODE_NO", "Ljava/lang/String;", "KEY_ORDER_ITEM_NO", "KEY_SKU_NO", "", "STATUS_INIT", "I", "STATUS_ITEM_READY", "STATUS_PLAYING", "STATUS_RE_TRY_SEE", "STATUS_TRY_SEE_END", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String episodeNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(episodeNo, "episodeNo");
            Intent intent = new Intent(context, (Class<?>) CourseDetailActivity.class);
            intent.putExtra("key_episode_no", episodeNo);
            context.startActivity(intent);
        }

        public final void b(@NotNull Context context, @NotNull String orderItemNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
            Intent intent = new Intent(context, (Class<?>) CourseDetailActivity.class);
            intent.putExtra("key_order_item_no", orderItemNo);
            context.startActivity(intent);
        }

        public final void c(@NotNull Context context, @NotNull String skuNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuNo, "skuNo");
            Intent intent = new Intent(context, (Class<?>) CourseDetailActivity.class);
            intent.putExtra("key_sku_no", skuNo);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/mall/page/course_detail/CourseDetailActivity$c", "Lcom/huachenjie/common/video/AliVideoCallback;", "", "tag", "", "e", "Lcom/huachenjie/common/video/AliVideoView;", "view", "f", "", "progress", "totalProgress", "i", "c", y6b.g, "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements AliVideoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f35166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CourseDetailActivity f11112a;

        public c(ConstraintLayout constraintLayout, CourseDetailActivity courseDetailActivity) {
            this.f35166a = constraintLayout;
            this.f11112a = courseDetailActivity;
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void c() {
            if (Intrinsics.areEqual(CourseDetailActivity.d0(this.f11112a).m().getValue(), Boolean.TRUE)) {
                this.f11112a.g0();
            } else {
                CourseDetailActivity.d0(this.f11112a).o().setValue(3);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void e(int tag) {
            if (tag == 0) {
                this.f35166a.setVisibility(8);
            } else {
                if (tag != 1) {
                    return;
                }
                this.f35166a.setVisibility(0);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void f(@Nullable AliVideoView view) {
            if (Intrinsics.areEqual(CourseDetailActivity.d0(this.f11112a).m().getValue(), Boolean.TRUE)) {
                return;
            }
            CourseDetailActivity.d0(this.f11112a).o().setValue(3);
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void h() {
            this.f11112a.g0();
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void i(long progress, long totalProgress) {
            CourseDetailAdapter value;
            EpisodeItemBean value2 = CourseDetailActivity.d0(this.f11112a).k().getValue();
            if (value2 != null && Intrinsics.areEqual(CourseDetailActivity.d0(this.f11112a).m().getValue(), Boolean.TRUE)) {
                long seeDuration = value2.getSeeDuration();
                long j = progress / ((long) 1000);
                value2.updateSeeDuration(j);
                if (seeDuration != j && (value = CourseDetailActivity.d0(this.f11112a).j().getValue()) != null) {
                    value.notifyItemChanged(value.getItemPosition(value2) + value.getHeaderLayoutCount());
                }
                if (Math.abs(j - value2.getLastReportDuration()) >= 60 || (progress == totalProgress && j != value2.getLastReportDuration())) {
                    this.f11112a.r0(j);
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35167a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35167a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35167a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35167a.invoke(obj);
        }
    }

    public static final /* synthetic */ CourseDetailVM d0(CourseDetailActivity courseDetailActivity) {
        return courseDetailActivity.getMViewModel();
    }

    public static final void m0(CourseDetailAdapter courseDetailAdapter, CourseDetailActivity courseDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(courseDetailAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(courseDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        EpisodeItemBean item = courseDetailAdapter.getItem(i);
        if (item.isPlaying()) {
            return;
        }
        if (courseDetailAdapter.getHasBuy() || item.getTrySee() != 0) {
            courseDetailActivity.q0(item);
        }
    }

    public static final void o0(CourseDetailActivity courseDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(courseDetailActivity, "this$0");
        courseDetailActivity.onBackPressed();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().k().observe(this, new d(new Function1<EpisodeItemBean, Unit>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((EpisodeItemBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(EpisodeItemBean episodeItemBean) {
                CourseDetailAdapter value;
                if (episodeItemBean == null || (value = CourseDetailActivity.d0(this.this$0).j().getValue()) == null) {
                    return;
                }
                value.e(CourseDetailActivity.d0(this.this$0).getLastPlayItem(), episodeItemBean);
            }
        }));
        getMViewModel().o().observe(this, new d(new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.course_detail.CourseDetailActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                String coverUrl;
                String coverUrl2;
                if (num != null && num.intValue() == 0) {
                    EpisodeDetailBean value = CourseDetailActivity.d0(this.this$0).l().getValue();
                    if (value == null || (coverUrl2 = value.getCoverUrl()) == null) {
                        return;
                    }
                    this.this$0.getMBinding().f10184a.showCover(coverUrl2);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    EpisodeItemBean value2 = CourseDetailActivity.d0(this.this$0).k().getValue();
                    if (value2 == null || (coverUrl = value2.getCoverUrl()) == null) {
                        return;
                    }
                    this.this$0.getMBinding().f10184a.showCover(coverUrl);
                    return;
                }
                if (num == null || num.intValue() != 2) {
                    if (num != null && num.intValue() == 4) {
                        this.this$0.getMBinding().f10184a.replay();
                        return;
                    }
                    return;
                }
                if (CourseDetailActivity.d0(this.this$0).k().getValue() == null) {
                    return;
                }
                if (Intrinsics.areEqual(CourseDetailActivity.d0(this.this$0).m().getValue(), Boolean.TRUE)) {
                    AliVideoView aliVideoView = this.this$0.getMBinding().f10184a;
                    EpisodeItemBean value3 = CourseDetailActivity.d0(this.this$0).k().getValue();
                    Intrinsics.checkNotNull(value3);
                    String videoUrl = value3.getVideoUrl();
                    EpisodeItemBean value4 = CourseDetailActivity.d0(this.this$0).k().getValue();
                    Intrinsics.checkNotNull(value4);
                    String coverUrl3 = value4.getCoverUrl();
                    EpisodeItemBean value5 = CourseDetailActivity.d0(this.this$0).k().getValue();
                    Intrinsics.checkNotNull(value5);
                    aliVideoView.playVideo(videoUrl, coverUrl3, value5.getSeeDuration() * ((long) 1000), true);
                    return;
                }
                AliVideoView aliVideoView2 = this.this$0.getMBinding().f10184a;
                EpisodeItemBean value6 = CourseDetailActivity.d0(this.this$0).k().getValue();
                Intrinsics.checkNotNull(value6);
                String videoUrl2 = value6.getVideoUrl();
                EpisodeItemBean value7 = CourseDetailActivity.d0(this.this$0).k().getValue();
                Intrinsics.checkNotNull(value7);
                String coverUrl4 = value7.getCoverUrl();
                EpisodeItemBean value8 = CourseDetailActivity.d0(this.this$0).k().getValue();
                Intrinsics.checkNotNull(value8);
                aliVideoView2.playPreview(videoUrl2, coverUrl4, value8.getTryTime() * ((long) 1000), true);
            }
        }));
    }

    public final void g0() {
        int iIndexOf;
        CourseDetailAdapter value = getMViewModel().j().getValue();
        List<EpisodeItemBean> data = value != null ? value.getData() : null;
        List<EpisodeItemBean> list = data;
        if (!(list == null || list.isEmpty()) && (iIndexOf = CollectionsKt.indexOf(data, getMViewModel().k().getValue())) < data.size() - 1) {
            if (Intrinsics.areEqual(getMViewModel().m().getValue(), Boolean.TRUE)) {
                q0(data.get(iIndexOf + 1));
                return;
            }
            int size = data.size();
            for (int i = iIndexOf + 1; i < size; i++) {
                EpisodeItemBean episodeItemBean = data.get(i);
                if (episodeItemBean.getTrySee() == 1) {
                    q0(episodeItemBean);
                    return;
                }
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_course_detail;
    }

    public final String h0() {
        return (String) this.episodeNo.getValue();
    }

    public final MallViewCourseDetailHeaderBinding i0() {
        return (MallViewCourseDetailHeaderBinding) this.headerBinding.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().m().setValue(Boolean.valueOf(!TextUtils.isEmpty(j0())));
        getMViewModel().p(h0(), j0(), k0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().addFlags(128);
        n0();
        l0();
        p0();
    }

    public final String j0() {
        return (String) this.orderItemNo.getValue();
    }

    public final String k0() {
        return (String) this.skuNo.getValue();
    }

    public final void l0() {
        getMBinding().f34785a.setItemAnimator(null);
        MutableLiveData<CourseDetailAdapter> mutableLiveDataJ = getMViewModel().j();
        final CourseDetailAdapter courseDetailAdapter = new CourseDetailAdapter(!TextUtils.isEmpty(j0()));
        View root = i0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerBinding.root");
        BaseQuickAdapter.setHeaderView$default(courseDetailAdapter, root, 0, 0, 6, null);
        y57.d(courseDetailAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.lw1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CourseDetailActivity.m0(courseDetailAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataJ.setValue(courseDetailAdapter);
    }

    public final void n0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("课程详情").setTitleTextColor(-13877680).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.kw1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CourseDetailActivity.o0(this.f42926a, view);
            }
        }));
    }

    public final void p0() {
        ConstraintLayout constraintLayout = getMBinding().f10183a.f8702a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.toolbar.clTitle");
        getMBinding().f10184a.setLifecycle(getLifecycle());
        int iJ = fx7.j();
        getMBinding().f10184a.setVideoPortraitSize(iJ, (int) ((iJ * 9.0f) / 16.0f));
        getMBinding().f10184a.setCallback(new c(constraintLayout, this));
    }

    public final void q0(EpisodeItemBean episodeItem) {
        getMViewModel().q(episodeItem, j0());
    }

    public final void r0(long progress) {
        EpisodeItemBean value = getMViewModel().k().getValue();
        if (value == null) {
            return;
        }
        value.setLastReportDuration(progress);
        getMViewModel().r(j0(), value.getEpisodeItemNo(), value.getSort(), progress);
    }
}
