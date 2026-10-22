package com.huachenjie.mall.page.episodes_detail;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.video.AliVideoCallback;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.databinding.MallActivityEpisodesDetailBinding;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import com.zj.adlib.y6b;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002*\u001dB\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0016\u0010\u0018\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H\u0002J\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\fH\u0002R\u001d\u0010!\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010$\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001d\u0010'\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 ¨\u0006+"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityEpisodesDetailBinding;", "Lcom/huachenjie/mall/page/episodes_detail/EpisodesDetailVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "episodeItem", "n0", "W", "k0", "m0", "", "progress", "o0", "g0", "", "itemList", "q0", "", "lastEpisodeItemNo", "item", bo.g, "b", "Lkotlin/Lazy;", "h0", "()Ljava/lang/String;", "episodeNo", "c", "i0", "orderItemNo", "d", "j0", "skuNo", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEpisodesDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpisodesDetailActivity.kt\ncom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,275:1\n1855#2,2:276\n*S KotlinDebug\n*F\n+ 1 EpisodesDetailActivity.kt\ncom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity\n*L\n169#1:276,2\n*E\n"})
public final class EpisodesDetailActivity extends BaseMVVMActivity<MallActivityEpisodesDetailBinding, EpisodesDetailVM> {

    @NotNull
    public static final String A = "receiver_last_episodes_item_no";

    @NotNull
    public static final String B = "receiver_episodes_item_no";
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 40;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_episode_no";

    @NotNull
    public static final String x = "key_order_item_no";

    @NotNull
    public static final String y = "key_sku_no";

    @NotNull
    public static final String z = "com.huachenjie.shandong_school.receiver.mall.episodes_play_change";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy episodeNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$episodeNo$2
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
    public final Lazy orderItemNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$orderItemNo$2
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
    public final Lazy skuNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$skuNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_sku_no");
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (EpisodesDetailActivity.c0(EpisodesDetailActivity.this).j().getValue() == null) {
                return;
            }
            if (!Intrinsics.areEqual(EpisodesDetailActivity.c0(EpisodesDetailActivity.this).m().getValue(), Boolean.TRUE)) {
                EpisodesDetailActivity.c0(EpisodesDetailActivity.this).o().setValue(4);
                return;
            }
            EpisodesDetailActivity episodesDetailActivity = EpisodesDetailActivity.this;
            EpisodeItemBean value = EpisodesDetailActivity.c0(episodesDetailActivity).j().getValue();
            Intrinsics.checkNotNull(value);
            episodesDetailActivity.n0(value);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity$b;", "", "Landroid/content/Context;", "context", "", "episodeNo", "", "a", "orderItemNo", "b", "skuNo", "c", "KEY_EPISODE_NO", "Ljava/lang/String;", "KEY_ORDER_ITEM_NO", "KEY_SKU_NO", "", "PAGE_SIZE", "I", "RECEIVER_EPISODES_ITEM_NO", "RECEIVER_LAST_EPISODES_ITEM_NO", "RECEIVER_PLAY_CHANGE", "STATUS_INIT", "STATUS_ITEM_READY", "STATUS_PLAYING", "STATUS_RE_TRY_SEE", "STATUS_TRY_SEE_END", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String episodeNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(episodeNo, "episodeNo");
            Intent intent = new Intent(context, (Class<?>) EpisodesDetailActivity.class);
            intent.putExtra("key_episode_no", episodeNo);
            context.startActivity(intent);
        }

        public final void b(@NotNull Context context, @NotNull String orderItemNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(orderItemNo, "orderItemNo");
            Intent intent = new Intent(context, (Class<?>) EpisodesDetailActivity.class);
            intent.putExtra("key_order_item_no", orderItemNo);
            context.startActivity(intent);
        }

        public final void c(@NotNull Context context, @NotNull String skuNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuNo, "skuNo");
            Intent intent = new Intent(context, (Class<?>) EpisodesDetailActivity.class);
            intent.putExtra("key_sku_no", skuNo);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/mall/page/episodes_detail/EpisodesDetailActivity$c", "Lcom/huachenjie/common/video/AliVideoCallback;", "", "tag", "", "e", "Lcom/huachenjie/common/video/AliVideoView;", "view", "f", "", "progress", "totalProgress", "i", "c", y6b.g, "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements AliVideoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f35172a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ EpisodesDetailActivity f11113a;

        public c(ConstraintLayout constraintLayout, EpisodesDetailActivity episodesDetailActivity) {
            this.f35172a = constraintLayout;
            this.f11113a = episodesDetailActivity;
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void c() {
            if (Intrinsics.areEqual(EpisodesDetailActivity.c0(this.f11113a).m().getValue(), Boolean.TRUE)) {
                this.f11113a.g0();
            } else {
                EpisodesDetailActivity.c0(this.f11113a).o().setValue(3);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void e(int tag) {
            if (tag == 0) {
                this.f35172a.setVisibility(8);
            } else {
                if (tag != 1) {
                    return;
                }
                this.f35172a.setVisibility(0);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void f(@Nullable AliVideoView view) {
            if (Intrinsics.areEqual(EpisodesDetailActivity.c0(this.f11113a).m().getValue(), Boolean.TRUE)) {
                return;
            }
            EpisodesDetailActivity.c0(this.f11113a).o().setValue(3);
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void h() {
            this.f11113a.g0();
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void i(long progress, long totalProgress) {
            EpisodeItemBean value = EpisodesDetailActivity.c0(this.f11113a).j().getValue();
            if (value != null && Intrinsics.areEqual(EpisodesDetailActivity.c0(this.f11113a).m().getValue(), Boolean.TRUE)) {
                long j = progress / ((long) 1000);
                value.updateSeeDuration(j);
                if (Math.abs(j - value.getLastReportDuration()) >= 60 || (progress == totalProgress && j != value.getLastReportDuration())) {
                    this.f11113a.o0(j);
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35173a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35173a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35173a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35173a.invoke(obj);
        }
    }

    public static final /* synthetic */ EpisodesDetailVM c0(EpisodesDetailActivity episodesDetailActivity) {
        return episodesDetailActivity.getMViewModel();
    }

    public static final void l0(EpisodesDetailActivity episodesDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(episodesDetailActivity, "this$0");
        episodesDetailActivity.onBackPressed();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().l().observe(this, new d(new Function1<List<? extends EpisodeItemBean>, Unit>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<EpisodeItemBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<EpisodeItemBean> list) {
                List<EpisodeItemBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                EpisodesDetailActivity episodesDetailActivity = this.this$0;
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                episodesDetailActivity.q0(list);
            }
        }));
        getMViewModel().j().observe(this, new d(new Function1<EpisodeItemBean, Unit>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((EpisodeItemBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(EpisodeItemBean episodeItemBean) {
                if (episodeItemBean == null) {
                    return;
                }
                List<EpisodeItemBean> value = EpisodesDetailActivity.c0(this.this$0).l().getValue();
                int iIndexOf = value != null ? value.indexOf(episodeItemBean) : -1;
                if (iIndexOf < 0) {
                    return;
                }
                int i = iIndexOf / 40;
                if (this.this$0.getMBinding().f10196a.getCurrentTab() != i) {
                    this.this$0.getMBinding().f10196a.setCurrentTab(i, false);
                }
                EpisodesDetailActivity episodesDetailActivity = this.this$0;
                EpisodeItemBean lastPlayItem = EpisodesDetailActivity.c0(episodesDetailActivity).getLastPlayItem();
                episodesDetailActivity.p0(lastPlayItem != null ? lastPlayItem.getEpisodeItemNo() : null, episodeItemBean);
            }
        }));
        getMViewModel().o().observe(this, new d(new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity$initDataObserve$3
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
                    EpisodeDetailBean value = EpisodesDetailActivity.c0(this.this$0).k().getValue();
                    if (value == null || (coverUrl2 = value.getCoverUrl()) == null) {
                        return;
                    }
                    this.this$0.getMBinding().f10198a.showCover(coverUrl2);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    EpisodeItemBean value2 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                    if (value2 == null || (coverUrl = value2.getCoverUrl()) == null) {
                        return;
                    }
                    this.this$0.getMBinding().f10198a.showCover(coverUrl);
                    return;
                }
                if (num == null || num.intValue() != 2) {
                    if (num != null && num.intValue() == 4) {
                        this.this$0.getMBinding().f10198a.replay();
                        return;
                    }
                    return;
                }
                if (EpisodesDetailActivity.c0(this.this$0).j().getValue() == null) {
                    return;
                }
                if (Intrinsics.areEqual(EpisodesDetailActivity.c0(this.this$0).m().getValue(), Boolean.TRUE)) {
                    AliVideoView aliVideoView = this.this$0.getMBinding().f10198a;
                    EpisodeItemBean value3 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                    Intrinsics.checkNotNull(value3);
                    String videoUrl = value3.getVideoUrl();
                    EpisodeItemBean value4 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                    Intrinsics.checkNotNull(value4);
                    String coverUrl3 = value4.getCoverUrl();
                    EpisodeItemBean value5 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                    Intrinsics.checkNotNull(value5);
                    aliVideoView.playVideo(videoUrl, coverUrl3, value5.getSeeDuration() * ((long) 1000), true);
                    return;
                }
                AliVideoView aliVideoView2 = this.this$0.getMBinding().f10198a;
                EpisodeItemBean value6 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                Intrinsics.checkNotNull(value6);
                String videoUrl2 = value6.getVideoUrl();
                EpisodeItemBean value7 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                Intrinsics.checkNotNull(value7);
                String coverUrl4 = value7.getCoverUrl();
                EpisodeItemBean value8 = EpisodesDetailActivity.c0(this.this$0).j().getValue();
                Intrinsics.checkNotNull(value8);
                aliVideoView2.playPreview(videoUrl2, coverUrl4, value8.getTryTime() * ((long) 1000), true);
            }
        }));
    }

    public final void g0() {
        int iIndexOf;
        List<EpisodeItemBean> value = getMViewModel().l().getValue();
        List<EpisodeItemBean> list = value;
        if (!(list == null || list.isEmpty()) && (iIndexOf = CollectionsKt.indexOf(value, getMViewModel().j().getValue())) < value.size() - 1) {
            if (Intrinsics.areEqual(getMViewModel().m().getValue(), Boolean.TRUE)) {
                n0(value.get(iIndexOf + 1));
                return;
            }
            int size = value.size();
            for (int i = iIndexOf + 1; i < size; i++) {
                EpisodeItemBean episodeItemBean = value.get(i);
                if (episodeItemBean.getTrySee() == 1) {
                    n0(episodeItemBean);
                    return;
                }
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_episodes_detail;
    }

    public final String h0() {
        return (String) this.episodeNo.getValue();
    }

    public final String i0() {
        return (String) this.orderItemNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().m().setValue(Boolean.valueOf(!TextUtils.isEmpty(i0())));
        getMViewModel().p(h0(), i0(), j0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().addFlags(128);
        k0();
        m0();
    }

    public final String j0() {
        return (String) this.skuNo.getValue();
    }

    public final void k0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("剧集详情").setTitleTextColor(-13877680).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.r43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EpisodesDetailActivity.l0(this.f44362a, view);
            }
        }));
    }

    public final void m0() {
        ConstraintLayout constraintLayout = getMBinding().f10197a.f8702a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.toolbar.clTitle");
        getMBinding().f10198a.setLifecycle(getLifecycle());
        int iJ = fx7.j();
        getMBinding().f10198a.setVideoPortraitSize(iJ, (int) ((iJ * 9.0f) / 16.0f));
        getMBinding().f10198a.setCallback(new c(constraintLayout, this));
    }

    public final void n0(@NotNull EpisodeItemBean episodeItem) {
        Intrinsics.checkNotNullParameter(episodeItem, "episodeItem");
        getMViewModel().q(episodeItem, i0());
    }

    public final void o0(long progress) {
        EpisodeItemBean value = getMViewModel().j().getValue();
        if (value == null) {
            return;
        }
        value.setLastReportDuration(progress);
        getMViewModel().r(i0(), value.getEpisodeItemNo(), value.getSort(), progress);
    }

    public final void p0(String lastEpisodeItemNo, EpisodeItemBean item) {
        Intent intent = new Intent(z);
        if (!TextUtils.isEmpty(lastEpisodeItemNo)) {
            intent.putExtra(A, lastEpisodeItemNo);
        }
        intent.putExtra(B, item.getEpisodeItemNo());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public final void q0(List<EpisodeItemBean> itemList) {
        List<List> listChunked = CollectionsKt.chunked(itemList, 40);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (List list : listChunked) {
            if (list.size() > 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(((EpisodeItemBean) CollectionsKt.first(list)).getSort());
                sb.append('-');
                sb.append(((EpisodeItemBean) CollectionsKt.last(list)).getSort());
                arrayList.add(sb.toString());
            } else {
                arrayList.add(String.valueOf(((EpisodeItemBean) CollectionsKt.first(list)).getSort()));
            }
            arrayList2.add(EpisodesListFragment.INSTANCE.a(new ArrayList<>(list), i0()));
        }
        getMBinding().f10196a.setViewPager(getMBinding().f34789a, arrayList, this, arrayList2);
    }
}
