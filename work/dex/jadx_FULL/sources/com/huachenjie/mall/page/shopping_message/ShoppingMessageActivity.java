package com.huachenjie.mall.page.shopping_message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coroutines.DataBindingUtil;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MessageContactBean;
import com.huachenjie.mall.databinding.MallActivityShoppingMessageBinding;
import com.huachenjie.mall.databinding.MallItemShoppingMessageHeaderBinding;
import com.huachenjie.mall.page.shopping_message.ShoppingMessageActivity;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.zj.adlib.dj1;
import com.zj.adlib.hk0;
import com.zj.adlib.i4a;
import com.zj.adlib.na8;
import com.zj.adlib.oa8;
import com.zj.adlib.p44;
import com.zj.adlib.r57;
import com.zj.adlib.wt1;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.SHOPPING_MESSAGE)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b8\u00109J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR$\u0010 \u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001d0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00100R#\u00107\u001a\n 3*\u0004\u0018\u000102028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/huachenjie/mall/page/shopping_message/ShoppingMessageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityShoppingMessageBinding;", "Lcom/huachenjie/mall/page/shopping_message/ShoppingMessageVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "A0", "F0", "onDestroy", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "r0", "x0", "y0", "s0", "m0", "", "a", "J", "lastRefreshTime", "", "Z", "hasObserveContact", "Lcom/netease/nimlib/sdk/Observer;", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "Lcom/netease/nimlib/sdk/Observer;", "contactObserver", "b", "contactDeletedObserve", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "Lcom/huachenjie/im/DefaultCallback;", RenderCallContext.TYPE_CALLBACK, "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Lcom/qiyukf/unicorn/api/UnreadCountChangeListener;", "Lcom/qiyukf/unicorn/api/UnreadCountChangeListener;", "onOfficeUnreadCountChange", "Lcom/huachenjie/base/widget/OperatePopupWindow;", "operatePopupWindow", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "Lcom/huachenjie/base/widget/OperatePopupWindow$OnClickCallback;", "operateCallback", "Lcom/huachenjie/mall/databinding/MallItemShoppingMessageHeaderBinding;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "q0", "()Lcom/huachenjie/mall/databinding/MallItemShoppingMessageHeaderBinding;", "headerView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ShoppingMessageActivity extends BaseMVVMActivity<MallActivityShoppingMessageBinding, ShoppingMessageVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long lastRefreshTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OperatePopupWindow operatePopupWindow;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean hasObserveContact;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Observer<List<RecentContact>> contactObserver = new na8(this);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Observer<RecentContact> contactDeletedObserve = new oa8(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final DefaultCallback<IMTokenBean> callback = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.pa8
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            ShoppingMessageActivity.C0(this.f43939a);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final UnreadCountChangeListener onOfficeUnreadCountChange = new UnreadCountChangeListener() { // from class: com.zj.adlib.qa8
        public final void onUnreadCountChange(int i) {
            ShoppingMessageActivity.B0(this.f44164a, i);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final OperatePopupWindow.OnClickCallback operateCallback = new OperatePopupWindow.OnClickCallback() { // from class: com.zj.adlib.ra8
        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public final void a(View view, int i, Object obj) {
            ShoppingMessageActivity.E0(this.f44412a, view, i, obj);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy headerView = LazyKt.lazy(new Function0<MallItemShoppingMessageHeaderBinding>() { // from class: com.huachenjie.mall.page.shopping_message.ShoppingMessageActivity$headerView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallItemShoppingMessageHeaderBinding m578invoke() {
            return (MallItemShoppingMessageHeaderBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_item_shopping_message_header, null, false);
        }
    });

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mall/page/shopping_message/ShoppingMessageActivity$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<IMTokenBean> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM;
            ShoppingMessageAdapter value;
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM2;
            ShoppingMessageAdapter value2;
            i4a.a("loginIM callback");
            if (code == 200 && result != null) {
                ShoppingMessageActivity.l0(ShoppingMessageActivity.this).o().setValue(result);
                ShoppingMessageActivity.l0(ShoppingMessageActivity.this).q();
                return;
            }
            ShoppingMessageVM shoppingMessageVML0 = ShoppingMessageActivity.l0(ShoppingMessageActivity.this);
            if (shoppingMessageVML0 != null && (mutableLiveDataM2 = shoppingMessageVML0.m()) != null && (value2 = mutableLiveDataM2.getValue()) != null) {
                value2.setList(null);
            }
            ShoppingMessageVM shoppingMessageVML1 = ShoppingMessageActivity.l0(ShoppingMessageActivity.this);
            if (shoppingMessageVML1 == null || (mutableLiveDataM = shoppingMessageVML1.m()) == null || (value = mutableLiveDataM.getValue()) == null) {
                return;
            }
            value.j();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mall/page/shopping_message/ShoppingMessageActivity$b", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<IMTokenBean> {
        public b() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM;
            ShoppingMessageAdapter value;
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM2;
            ShoppingMessageAdapter value2;
            if (code == 200 && result != null) {
                wt1.h().o();
                ShoppingMessageActivity.l0(ShoppingMessageActivity.this).o().setValue(result);
                return;
            }
            ShoppingMessageVM shoppingMessageVML0 = ShoppingMessageActivity.l0(ShoppingMessageActivity.this);
            if (shoppingMessageVML0 != null && (mutableLiveDataM2 = shoppingMessageVML0.m()) != null && (value2 = mutableLiveDataM2.getValue()) != null) {
                value2.setList(null);
            }
            ShoppingMessageVM shoppingMessageVML1 = ShoppingMessageActivity.l0(ShoppingMessageActivity.this);
            if (shoppingMessageVML1 == null || (mutableLiveDataM = shoppingMessageVML1.m()) == null || (value = mutableLiveDataM.getValue()) == null) {
                return;
            }
            value.j();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mall/page/shopping_message/ShoppingMessageActivity$c", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DefaultCallback<Void> {
        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
        }
    }

    public static final void B0(ShoppingMessageActivity shoppingMessageActivity, int i) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        shoppingMessageActivity.getMViewModel().n().setValue(Integer.valueOf(i));
    }

    public static final void C0(final ShoppingMessageActivity shoppingMessageActivity) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        if (shoppingMessageActivity.isFinishing()) {
            return;
        }
        shoppingMessageActivity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.ma8
            @Override // java.lang.Runnable
            public final void run() {
                ShoppingMessageActivity.D0(this.f43258a);
            }
        });
    }

    public static final void D0(ShoppingMessageActivity shoppingMessageActivity) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        p44.j(shoppingMessageActivity.callback);
    }

    public static final void E0(ShoppingMessageActivity shoppingMessageActivity, View view, int i, Object obj) {
        ShoppingMessageVM mViewModel;
        MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM;
        ShoppingMessageAdapter value;
        List<MessageContactBean> data;
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        if (view == null || i != 1001 || obj == null || !(obj instanceof Integer) || (mViewModel = shoppingMessageActivity.getMViewModel()) == null || (mutableLiveDataM = mViewModel.m()) == null || (value = mutableLiveDataM.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        int size = data.size();
        int iIntValue = ((Integer) obj).intValue();
        boolean z = false;
        if (iIntValue >= 0 && iIntValue < size) {
            z = true;
        }
        if (z) {
            dj1.q(data.get(((Number) obj).intValue()).getAccId(), SessionTypeEnum.P2P, new c());
        }
    }

    public static final /* synthetic */ ShoppingMessageVM l0(ShoppingMessageActivity shoppingMessageActivity) {
        return shoppingMessageActivity.getMViewModel();
    }

    public static final void n0(ShoppingMessageActivity shoppingMessageActivity) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        p44.x(shoppingMessageActivity.callback);
    }

    public static final void o0(ShoppingMessageActivity shoppingMessageActivity, RecentContact recentContact) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        if (recentContact == null) {
            return;
        }
        i4a.a("deleteContact");
        ShoppingMessageVM mViewModel = shoppingMessageActivity.getMViewModel();
        if (mViewModel != null) {
            mViewModel.l(recentContact);
        }
    }

    public static final void p0(ShoppingMessageActivity shoppingMessageActivity, List list) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        shoppingMessageActivity.lastRefreshTime = System.currentTimeMillis();
        shoppingMessageActivity.getMViewModel().k(list);
    }

    public static final void t0(ShoppingMessageActivity shoppingMessageActivity, View view) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        r57.i(shoppingMessageActivity);
    }

    public static final void u0(ShoppingMessageActivity shoppingMessageActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM;
        ShoppingMessageAdapter value;
        List<MessageContactBean> data;
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ShoppingMessageVM mViewModel = shoppingMessageActivity.getMViewModel();
        if (mViewModel == null || (mutableLiveDataM = mViewModel.m()) == null || (value = mutableLiveDataM.getValue()) == null || (data = value.getData()) == null) {
            return;
        }
        dj1.b0(data.get(i).getAccId(), null, null);
    }

    public static final boolean v0(ShoppingMessageActivity shoppingMessageActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        OperatePopupWindow operatePopupWindowR0 = shoppingMessageActivity.r0();
        operatePopupWindowR0.i(Integer.valueOf(i));
        operatePopupWindowR0.j(view, "delete");
        return true;
    }

    public static final void w0(ShoppingMessageActivity shoppingMessageActivity) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        p44.j(shoppingMessageActivity.new b());
    }

    public static final void z0(ShoppingMessageActivity shoppingMessageActivity, View view) {
        Intrinsics.checkNotNullParameter(shoppingMessageActivity, "this$0");
        shoppingMessageActivity.finish();
    }

    public final void A0() {
        if (this.hasObserveContact) {
            return;
        }
        wt1.h().i().c(this.contactObserver);
        wt1.h().i().d(this.contactDeletedObserve);
        this.hasObserveContact = true;
    }

    public final void F0() {
        if (this.hasObserveContact) {
            wt1.h().i().p(this.contactObserver);
            wt1.h().i().q(this.contactDeletedObserve);
            this.hasObserveContact = false;
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_shopping_message;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        A0();
        if (p44.r()) {
            ShoppingMessageVM mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.q();
            }
        } else {
            runOnUiThread(new Runnable() { // from class: com.zj.adlib.ta8
                @Override // java.lang.Runnable
                public final void run() {
                    ShoppingMessageActivity.w0(this.f44882a);
                }
            });
        }
        r57.a(this.onOfficeUnreadCountChange);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        x0();
        y0();
        s0();
    }

    public final void m0() {
        if (System.currentTimeMillis() - this.lastRefreshTime < 60000) {
            return;
        }
        this.lastRefreshTime = System.currentTimeMillis();
        if (!p44.r()) {
            if (isFinishing()) {
                return;
            }
            runOnUiThread(new Runnable() { // from class: com.zj.adlib.ja8
                @Override // java.lang.Runnable
                public final void run() {
                    ShoppingMessageActivity.n0(this.f42542a);
                }
            });
        } else {
            ShoppingMessageVM mViewModel = getMViewModel();
            if (mViewModel != null) {
                mViewModel.q();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        F0();
        r57.h(this.onOfficeUnreadCountChange);
        super.onDestroy();
    }

    public final MallItemShoppingMessageHeaderBinding q0() {
        return (MallItemShoppingMessageHeaderBinding) this.headerView.getValue();
    }

    public final OperatePopupWindow r0() {
        Integer value;
        BaseViewModel.b bVarE;
        MutableLiveData<Integer> mutableLiveDataC;
        if (this.operatePopupWindow == null) {
            ShoppingMessageVM mViewModel = getMViewModel();
            if (mViewModel == null || (bVarE = mViewModel.e()) == null || (mutableLiveDataC = bVarE.c()) == null || (value = mutableLiveDataC.getValue()) == null) {
                value = 0;
            }
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(this, value.intValue());
            operatePopupWindow.h(this.operateCallback);
            this.operatePopupWindow = operatePopupWindow;
        }
        OperatePopupWindow operatePopupWindow2 = this.operatePopupWindow;
        Intrinsics.checkNotNull(operatePopupWindow2);
        return operatePopupWindow2;
    }

    public final void s0() {
        if (getMBinding() != null) {
            ShoppingMessageAdapter shoppingMessageAdapter = new ShoppingMessageAdapter();
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "emptyView");
            shoppingMessageAdapter.g(viewInflate);
            TextView textView = (TextView) viewInflate.findViewById(R.id.bt_empty);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.bt_empty)");
                textView.setVisibility(8);
            }
            View viewFindViewById = q0().getRoot().findViewById(R.id.cl_container);
            if (viewFindViewById != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.cl_container)");
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ua8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShoppingMessageActivity.t0(this.f45104a, view);
                    }
                });
            }
            q0().k(getMViewModel());
            q0().executePendingBindings();
            View root = q0().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "headerView.root");
            BaseQuickAdapter.setHeaderView$default(shoppingMessageAdapter, root, 0, 0, 6, null);
            shoppingMessageAdapter.setHeaderWithEmptyEnable(true);
            y57.d(shoppingMessageAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ka8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ShoppingMessageActivity.u0(this.f42776a, baseQuickAdapter, view, i);
                }
            }, 1, null);
            shoppingMessageAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.zj.adlib.la8
                @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    return ShoppingMessageActivity.v0(this.f43028a, baseQuickAdapter, view, i);
                }
            });
            shoppingMessageAdapter.j();
            getMViewModel().m().setValue(shoppingMessageAdapter);
        }
    }

    public final void x0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void y0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("购物消息");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.sa8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShoppingMessageActivity.z0(this.f44651a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }
}
