package com.huachenjie.channel.page.channel_home;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.base.broadcast.channel.ChannelOperateListener;
import com.huachenjie.base.broadcast.channel.ChannelOperateReceiver;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.channel.databinding.ChannelActivityChannelHomeBinding;
import com.huachenjie.channel.page.all_channel.JoinAllChannelActivity;
import com.huachenjie.channel.page.channel_home.ChannelHomeActivity;
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeActivity;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.bw9;
import com.zj.adlib.ew;
import com.zj.adlib.fi1;
import com.zj.adlib.hp4;
import com.zj.adlib.i4a;
import com.zj.adlib.ju3;
import com.zj.adlib.kq5;
import com.zj.adlib.p44;
import com.zj.adlib.qi1;
import com.zj.adlib.r90;
import com.zj.adlib.tk0;
import com.zj.adlib.wt1;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)-B\u0007¢\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u00020\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0002J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0014J\b\u0010(\u001a\u00020\u0004H\u0014R\u0016\u0010+\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R \u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020403028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00108¨\u0006<"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityChannelHomeBinding;", "Lcom/huachenjie/channel/page/channel_home/ChannelHomeVM;", "", "w0", "u0", "v0", "initToolbar", "Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Landroidx/fragment/app/Fragment;", "o0", bo.g, "", "status", "x0", "", "logo", "", qi1.CHANNEL_STATUS_CHANGE, "A0", "teamId", qi1.FROM_ORGANIZE, "B0", "s0", "y0", "z0", "Lkotlin/Function0;", "afterLogin", "l0", "", "", "V", "getLayoutResID", "W", "initView", "initData", "U", "onResume", "onDestroy", "a", "Z", "needRefreshList", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "b", "Lkotlin/Lazy;", "q0", "()Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "channelOperateReceiver", "Lcom/netease/nimlib/sdk/Observer;", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "Lcom/netease/nimlib/sdk/Observer;", "contactObserver", "", "J", "lastImLoginTime", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannelHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelHomeActivity.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1855#2,2:367\n*S KotlinDebug\n*F\n+ 1 ChannelHomeActivity.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeActivity\n*L\n320#1:367,2\n*E\n"})
public final class ChannelHomeActivity extends BaseMVVMActivity<ChannelActivityChannelHomeBinding, ChannelHomeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long lastImLoginTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean needRefreshList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelOperateReceiver = LazyKt.lazy(new Function0<ChannelOperateReceiver>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$channelOperateReceiver$2

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/channel/page/channel_home/ChannelHomeActivity$channelOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;", "", "channelNo", "logo", "", "isCrested", "", "b", "a", qi1.CHANNEL_STATUS_CHANGE, "d", "teamId", qi1.FROM_ORGANIZE, "c", "channel_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nChannelHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelHomeActivity.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeActivity$channelOperateReceiver$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,366:1\n1#2:367\n*E\n"})
        public static final class a implements ChannelOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ChannelHomeActivity f33378a;

            public a(ChannelHomeActivity channelHomeActivity) {
                this.f33378a = channelHomeActivity;
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void a(@NotNull String channelNo) {
                List<ChannelHomeItemBean> data;
                Object next;
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                ChannelHomeAdapter value = ChannelHomeActivity.f0(this.f33378a).p().getValue();
                if (value == null || (data = value.getData()) == null) {
                    return;
                }
                Iterator<T> it = data.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!TextUtils.equals(channelNo, ((ChannelHomeItemBean) next).getChannelNo()));
                ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) next;
                if (channelHomeItemBean != null) {
                    this.f33378a.p0(channelHomeItemBean);
                }
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void b(@NotNull String channelNo, @NotNull String logo, boolean isCrested) {
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(logo, "logo");
                this.f33378a.needRefreshList = true;
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void c(@NotNull String channelNo, @NotNull String teamId, boolean fromOrganize) {
                List<ChannelHomeItemBean> data;
                Object next;
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(teamId, "teamId");
                ChannelHomeAdapter value = ChannelHomeActivity.f0(this.f33378a).p().getValue();
                if (value == null || (data = value.getData()) == null) {
                    return;
                }
                Iterator<T> it = data.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!TextUtils.equals(channelNo, ((ChannelHomeItemBean) next).getChannelNo()));
                ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) next;
                if (channelHomeItemBean != null) {
                    this.f33378a.B0(channelHomeItemBean, teamId, fromOrganize);
                }
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void d(@NotNull String channelNo, @NotNull String logo, boolean channelStatusChange) {
                List<ChannelHomeItemBean> data;
                Object next;
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(logo, "logo");
                ChannelHomeAdapter value = ChannelHomeActivity.f0(this.f33378a).p().getValue();
                if (value == null || (data = value.getData()) == null) {
                    return;
                }
                Iterator<T> it = data.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!TextUtils.equals(channelNo, ((ChannelHomeItemBean) next).getChannelNo()));
                ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) next;
                if (channelHomeItemBean != null) {
                    this.f33378a.A0(channelHomeItemBean, logo, channelStatusChange);
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelOperateReceiver m257invoke() {
            return new ChannelOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Observer<List<RecentContact>> contactObserver = new fi1(this);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/channel/page/channel_home/ChannelHomeActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelHomeActivity.f0(ChannelHomeActivity.this).E();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChannelHomeActivity.this.startActivity(new Intent(ChannelHomeActivity.this, (Class<?>) JoinAllChannelActivity.class));
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeActivity$b;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) ChannelHomeActivity.class));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/channel_home/ChannelHomeActivity$c", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f33377a;

        public c(Function0<Unit> function0) {
            this.f33377a = function0;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            if (code == 200) {
                wt1.h().o();
            }
            Function0<Unit> function0 = this.f33377a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/channel/page/channel_home/ChannelHomeActivity$d", "Lcom/huachenjie/ad/interfaces/FDAdListener;", "", "d", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends FDAdListener {
        public d() {
        }

        @Override // com.huachenjie.ad.interfaces.FDAdListener
        public void b() {
            super.b();
            ChannelHomeActivity.e0(ChannelHomeActivity.this).f33045a.setVisibility(8);
        }

        @Override // com.huachenjie.ad.interfaces.FDAdListener
        public void d() {
            ChannelHomeActivity.e0(ChannelHomeActivity.this).f33045a.setVisibility(0);
            kq5.b(ChannelHomeActivity.this, "BagAdLoadedSuccessful", null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements androidx.p002lifecycle.Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33380a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33380a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof androidx.p002lifecycle.Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33380a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33380a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChannelActivityChannelHomeBinding e0(ChannelHomeActivity channelHomeActivity) {
        return channelHomeActivity.getMBinding();
    }

    public static final /* synthetic */ ChannelHomeVM f0(ChannelHomeActivity channelHomeActivity) {
        return channelHomeActivity.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m0(ChannelHomeActivity channelHomeActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        channelHomeActivity.l0(function0);
    }

    public static final void n0(ChannelHomeActivity channelHomeActivity, List list) {
        Intrinsics.checkNotNullParameter(channelHomeActivity, "this$0");
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(list, o.f);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RecentContact recentContact = (RecentContact) it.next();
            if (!arrayList.contains(recentContact.getContactId())) {
                String contactId = recentContact.getContactId();
                Intrinsics.checkNotNullExpressionValue(contactId, "contact.contactId");
                arrayList.add(contactId);
            }
        }
        channelHomeActivity.getMViewModel().n(arrayList);
    }

    public static final void r0(ChannelHomeActivity channelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(channelHomeActivity, "this$0");
        channelHomeActivity.finish();
    }

    public static final void t0(AdPlatformSwitch adPlatformSwitch, View view) {
        Intrinsics.checkNotNullParameter(adPlatformSwitch, "$adConfig");
        ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", adPlatformSwitch.getLinkUrl()).navigation();
    }

    public final void A0(ChannelHomeItemBean bean, String logo, boolean channelStatusChange) {
        ChannelHomeAdapter value = getMViewModel().p().getValue();
        if (value == null) {
            return;
        }
        bean.setLogo(logo);
        if (channelStatusChange) {
            bean.setChannelStatus(1);
        }
        value.notifyItemChanged(value.getData().indexOf(bean));
    }

    public final void B0(ChannelHomeItemBean bean, String teamId, boolean fromOrganize) {
        ChannelHomeAdapter value = getMViewModel().p().getValue();
        if (value == null) {
            return;
        }
        if (fromOrganize) {
            bean.getClubTeamIdList().add(teamId);
        } else {
            bean.getSubjectTeamIdList().add(teamId);
        }
        bean.setUnreadCount(wt1.h().k().k(bean.formatTeamIdList()));
        value.notifyItemChanged(value.getData().indexOf(bean));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity
    public void U() {
        super.U();
        y0();
        qi1.f44215a.registerReceiver(this, q0());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        w0();
        u0();
        v0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_channel_home;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        s0();
    }

    public final void initToolbar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataW = getMViewModel().w();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataW.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_flash_message_tab_channel)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ei1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelHomeActivity.r0(this.f41439a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initToolbar();
        getMBinding().f7443a.setUserInputEnabled(false);
        getMViewModel().x().setValue(new BaseViewPager2Adapter<ChannelHomeItemBean>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity.initView.1
            {
                super(ChannelHomeActivity.this);
            }

            @Override // com.huachenjie.base.adapter.BaseViewPager2Adapter
            @NotNull
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Fragment c(int position, @NotNull ChannelHomeItemBean bean) {
                Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
                return ChannelHomeActivity.this.o0(bean);
            }
        });
        bw9 bw9Var = bw9.f40853a;
        RecyclerView recyclerView = getMBinding().f7442a;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.recycler");
        bw9Var.d(recyclerView);
        ViewPager2 viewPager2 = getMBinding().f7443a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        bw9Var.g(viewPager2);
    }

    public final void l0(Function0<Unit> afterLogin) {
        if (p44.r()) {
            i4a.a("已经登录云信，无需再次登录");
            if (afterLogin != null) {
                afterLogin.invoke();
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastImLoginTime >= 60000) {
            this.lastImLoginTime = jCurrentTimeMillis;
            p44.x(new c(afterLogin));
        } else {
            i4a.a("登录云信间隔小于一分钟");
            if (afterLogin != null) {
                afterLogin.invoke();
            }
        }
    }

    public final Fragment o0(final ChannelHomeItemBean bean) {
        return MyChannelFragment.INSTANCE.a(bean.getChannelNo(), bean.getChannelType(), new Function0<Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$createChannelFragment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m258invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m258invoke() {
                this.this$0.p0(bean);
            }
        }, new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$createChannelFragment$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                this.this$0.x0(bean, i);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        z0();
        qi1.f44215a.unregisterReceiver(this, q0());
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l0(new Function0<Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity.onResume.1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m259invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m259invoke() {
                List<ChannelHomeItemBean> value = ChannelHomeActivity.f0(ChannelHomeActivity.this).s().getValue();
                if (value == null || value.isEmpty()) {
                    ChannelHomeActivity.f0(ChannelHomeActivity.this).B();
                } else if (ChannelHomeActivity.this.needRefreshList) {
                    ChannelHomeActivity.this.needRefreshList = false;
                    ChannelHomeActivity.f0(ChannelHomeActivity.this).B();
                }
            }
        });
    }

    public final void p0(ChannelHomeItemBean bean) {
        BaseViewPager2Adapter<ChannelHomeItemBean> value;
        List<ChannelHomeItemBean> value2;
        ChannelHomeAdapter value3 = getMViewModel().p().getValue();
        if (value3 == null || (value = getMViewModel().x().getValue()) == null) {
            return;
        }
        value3.e(value3.getData().get(0));
        getMViewModel().D(0);
        List<ChannelHomeItemBean> value4 = getMViewModel().s().getValue();
        if ((value4 != null ? value4.indexOf(bean) : -1) > -1 && (value2 = getMViewModel().s().getValue()) != null) {
            value2.remove(bean);
        }
        int iIndexOf = value3.getData().indexOf(bean);
        value3.removeAt(iIndexOf);
        value.removeAt(iIndexOf);
    }

    public final ChannelOperateReceiver q0() {
        return (ChannelOperateReceiver) this.channelOperateReceiver.getValue();
    }

    public final void s0() {
        final AdPlatformSwitch adPlatformSwitchE = r90.e("sxmlb");
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            if (adPlatformSwitchE.getAdType() != 1 || TextUtils.isEmpty(adPlatformSwitchE.getImgUrl())) {
                ew.f().g(hp4.d, this, getLifecycle(), getMBinding().f33045a, new d());
                return;
            }
            ImageView imageView = new ImageView(this);
            if (!TextUtils.isEmpty(adPlatformSwitchE.getLinkUrl())) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gi1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChannelHomeActivity.t0(adPlatformSwitchE, view);
                    }
                });
            }
            Glide.with((FragmentActivity) this).load(adPlatformSwitchE.getImgUrl()).apply((BaseRequestOptions<?>) ju3.m).into(imageView);
            getMBinding().f33045a.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            getMBinding().f33045a.setVisibility(0);
        }
    }

    public final void u0() {
        getMViewModel().s().observe(this, new e(new Function1<List<ChannelHomeItemBean>, Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$observeChannelList$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ChannelHomeItemBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ChannelHomeItemBean> list) {
                ChannelHomeAdapter value = ChannelHomeActivity.f0(this.this$0).p().getValue();
                if (value != null) {
                    value.setList(list);
                }
                BaseViewPager2Adapter<ChannelHomeItemBean> value2 = ChannelHomeActivity.f0(this.this$0).x().getValue();
                if (value2 != null) {
                    value2.setList(list);
                }
                ChannelHomeActivity.f0(this.this$0).D(0);
            }
        }));
        getMViewModel().u().observe(this, new e(new Function1<List<ChannelHomeItemBean>, Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$observeChannelList$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<ChannelHomeItemBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<ChannelHomeItemBean> list) {
                ChannelHomeAdapter value = ChannelHomeActivity.f0(this.this$0).p().getValue();
                if (value != null) {
                    Intrinsics.checkNotNullExpressionValue(list, o.f);
                    value.addData((Collection) list);
                }
                BaseViewPager2Adapter<ChannelHomeItemBean> value2 = ChannelHomeActivity.f0(this.this$0).x().getValue();
                if (value2 != null) {
                    Intrinsics.checkNotNullExpressionValue(list, o.f);
                    value2.b(list);
                }
            }
        }));
    }

    public final void v0() {
        getMViewModel().r().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$observeCreateChannelCheckFlag$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ChooseChannelTypeActivity.Companion.b(ChooseChannelTypeActivity.INSTANCE, this.this$0, null, 2, null);
                }
            }
        }));
    }

    public final void w0() {
        getMViewModel().v().observe(this, new e(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.channel_home.ChannelHomeActivity$observeSelectPosition$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                ViewPager2 viewPager2 = ChannelHomeActivity.e0(this.this$0).f7443a;
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                viewPager2.setCurrentItem(num.intValue(), false);
            }
        }));
    }

    public final void x0(ChannelHomeItemBean bean, int status) {
        ChannelHomeAdapter value;
        if (bean.getChannelStatus() == status || (value = getMViewModel().p().getValue()) == null) {
            return;
        }
        bean.setChannelStatus(status);
        value.notifyItemChanged(value.getData().indexOf(bean));
    }

    public final void y0() {
        wt1.h().k().c(this.contactObserver);
    }

    public final void z0() {
        wt1.h().k().p(this.contactObserver);
    }
}
