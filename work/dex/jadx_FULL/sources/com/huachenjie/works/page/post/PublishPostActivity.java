package com.huachenjie.works.page.post;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.coroutines.DataBindingUtil;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.databinding.WorksActivityPublishPostBinding;
import com.huachenjie.works.databinding.WorksItemFooterPublishPostBinding;
import com.huachenjie.works.databinding.WorksItemHeaderPublishPostBinding;
import com.huachenjie.works.external.utils.WorksUtils;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.huachenjie.works.page.post.PublishPostActivity.a;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.qa4;
import com.zj.adlib.qk0;
import com.zj.adlib.tv6;
import com.zj.adlib.zn1;
import java.io.File;
import java.text.DecimalFormat;
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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00022\u001cB\u0007¢\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\b\u0010\u001a\u001a\u00020\u0004H\u0014R\u001f\u0010 \u001a\u00060\u001bR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR#\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%R#\u0010+\u001a\n \"*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/huachenjie/works/page/post/PublishPostActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityPublishPostBinding;", "Lcom/huachenjie/works/page/post/PublishPostVM;", "", "E0", "", bo.g, "G0", "w0", "y0", "A0", "o0", "", "s0", "", "", "", "V", "getLayoutResID", "initView", "initData", "W", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "v0", "onDestroy", "Lcom/huachenjie/works/page/post/PublishPostActivity$a;", "b", "Lkotlin/Lazy;", "q0", "()Lcom/huachenjie/works/page/post/PublishPostActivity$a;", "clickProxy", "Lcom/huachenjie/works/databinding/WorksItemHeaderPublishPostBinding;", "kotlin.jvm.PlatformType", "c", "u0", "()Lcom/huachenjie/works/databinding/WorksItemHeaderPublishPostBinding;", "headBinding", "Lcom/huachenjie/works/databinding/WorksItemFooterPublishPostBinding;", "d", "t0", "()Lcom/huachenjie/works/databinding/WorksItemFooterPublishPostBinding;", "footerBinding", "e", "r0", "()Ljava/lang/String;", "compressPath", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishPostActivity extends BaseMVVMActivity<WorksActivityPublishPostBinding, PublishPostVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "postType";

    @NotNull
    public static final String x = "postTag";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PublishPostActivity.a m937invoke() {
            return this.this$0.new a();
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy headBinding = LazyKt.lazy(new Function0<WorksItemHeaderPublishPostBinding>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$headBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksItemHeaderPublishPostBinding m940invoke() {
            WorksItemHeaderPublishPostBinding worksItemHeaderPublishPostBinding = (WorksItemHeaderPublishPostBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.works_item_header_publish_post, this.this$0.getMBinding().f13902a, false);
            worksItemHeaderPublishPostBinding.setVariable(qk0.p0, PublishPostActivity.m0(this.this$0));
            worksItemHeaderPublishPostBinding.setVariable(qk0.k, this.this$0.q0());
            return worksItemHeaderPublishPostBinding;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy footerBinding = LazyKt.lazy(new Function0<WorksItemFooterPublishPostBinding>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$footerBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksItemFooterPublishPostBinding m939invoke() {
            WorksItemFooterPublishPostBinding worksItemFooterPublishPostBinding = (WorksItemFooterPublishPostBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.works_item_footer_publish_post, this.this$0.getMBinding().f13902a, false);
            worksItemFooterPublishPostBinding.setVariable(qk0.p0, PublishPostActivity.m0(this.this$0));
            return worksItemFooterPublishPostBinding;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy compressPath = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$compressPath$2
        @NotNull
        public final String invoke() {
            return WorksUtils.f37135a.a() + File.separator + System.currentTimeMillis();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/post/PublishPostActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/works/page/post/PublishPostActivity;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            PublishPostActivity.m0(PublishPostActivity.this).t(PublishPostActivity.this);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.post.PublishPostActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/works/page/post/PublishPostActivity$b;", "", "Landroid/content/Context;", "context", "", "postType", "selTagCode", "", "a", "POST_TAG_KEY", "Ljava/lang/String;", "POST_TYPE_KEY", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.a(context, str, str2);
        }

        public final void a(@NotNull Context context, @NotNull String postType, @Nullable String selTagCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(postType, "postType");
            Intent intent = new Intent(context, (Class<?>) PublishPostActivity.class);
            intent.putExtra("postType", postType);
            if (!TextUtils.isEmpty(selTagCode)) {
                intent.putExtra(PublishPostActivity.x, selTagCode);
            }
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37287a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37287a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37287a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37287a.invoke(obj);
        }
    }

    public static final void B0(Function0 function0, View view, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "$checkPriceCallback");
        if (z) {
            return;
        }
        function0.invoke();
    }

    public static final boolean C0(Function0 function0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(function0, "$checkPriceCallback");
        function0.invoke();
        qa4.b(textView);
        return true;
    }

    public static final void D0(PublishPostActivity publishPostActivity, int i) {
        Intrinsics.checkNotNullParameter(publishPostActivity, "this$0");
        if (i == 0) {
            publishPostActivity.t0().f37031a.clearFocus();
        }
    }

    public static final void F0(PublishPostActivity publishPostActivity, View view) {
        Intrinsics.checkNotNullParameter(publishPostActivity, "this$0");
        publishPostActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    public static final void H0(PublishPostActivity publishPostActivity, View view) {
        Intrinsics.checkNotNullParameter(publishPostActivity, "this$0");
        publishPostActivity.finish();
    }

    public static final /* synthetic */ PublishPostVM m0(PublishPostActivity publishPostActivity) {
        return publishPostActivity.getMViewModel();
    }

    public static final void x0(PublishPostAdapter publishPostAdapter, PublishPostActivity publishPostActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(publishPostAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(publishPostActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        publishPostAdapter.e(i);
        publishPostActivity.getMViewModel().s().setValue(Integer.valueOf(i));
    }

    public static final void z0(PublishPostActivity publishPostActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(publishPostActivity, "this$0");
        publishPostActivity.getMBinding().f36792a.setTextColor(zn1.a(z ? R.color.color_2C3E50 : R.color.color_8997A4));
        publishPostActivity.getMViewModel().n().setValue(Integer.valueOf(z ? 1 : 0));
    }

    public final void A0() {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$initRedPack$checkPriceCallback$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m941invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m941invoke() {
                if (this.this$0.o0()) {
                    this.this$0.t0().f37031a.setText(this.this$0.s0());
                    this.this$0.t0().f37031a.setSelection(this.this$0.t0().f37031a.getText().length());
                }
            }
        };
        t0().f37031a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.zj.adlib.q37
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PublishPostActivity.B0(function0, view, z);
            }
        });
        t0().f37031a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.r37
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return PublishPostActivity.C0(function0, textView, i, keyEvent);
            }
        });
        KeyboardUtils.o(this, new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.s37
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                PublishPostActivity.D0(this.f44598a, i);
            }
        });
    }

    public final void E0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName(getString(R.string.works_publish_post_title));
        int i = R.color.color_2C3E50;
        BindingTitleBean backClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.o37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishPostActivity.F0(this.f43658a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(backClick.setStatusBarHeight(value.intValue()).setShowDivider(true));
    }

    public final void G0() {
        ft1.u(this, getString(R.string.works_publish_post_exit), getString(R.string.works_publish_post_sure), new View.OnClickListener() { // from class: com.zj.adlib.u37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishPostActivity.H0(this.f45055a, view);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().q().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.post.PublishPostActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                fv5.a(R.string.works_publish_post_success);
                tv6 tv6Var = tv6.f45013a;
                Context applicationContext = this.this$0.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                tv6Var.c(applicationContext);
                this.this$0.finish();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_publish_post;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().x(getIntent().getStringExtra("postType"));
        getMViewModel().v(getIntent().getStringExtra(x));
        getMViewModel().u();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.white));
        super.initView();
        E0();
        w0();
        y0();
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback() { // from class: com.huachenjie.works.page.post.PublishPostActivity.initView.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (PublishPostActivity.this.p0()) {
                    PublishPostActivity.this.G0();
                } else {
                    PublishPostActivity.this.finish();
                }
            }
        });
    }

    public final boolean o0() {
        String string = t0().f37031a.getText().toString();
        Float floatOrNull = StringsKt.toFloatOrNull(string);
        return floatOrNull == null || floatOrNull.floatValue() < 0.0f || floatOrNull.floatValue() > 100.0f || !(!StringsKt.contains$default(string, Consts.DOT, false, 2, (Object) null) || StringsKt.endsWith$default(string, ".0", false, 2, (Object) null) || StringsKt.endsWith$default(string, Consts.DOT, false, 2, (Object) null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.huachenjie.works.utils.a.INSTANCE.b(r0());
    }

    public final boolean p0() {
        if (!TextUtils.isEmpty(getMViewModel().o().getValue()) || (!v0().isEmpty()) || !TextUtils.isEmpty(getMViewModel().r().getValue())) {
            return true;
        }
        Integer value = getMViewModel().s().getValue();
        if (value == null) {
            value = -1;
        }
        return value.intValue() >= 0;
    }

    public final a q0() {
        return (a) this.clickProxy.getValue();
    }

    public final String r0() {
        return (String) this.compressPath.getValue();
    }

    public final String s0() {
        String string = t0().f37031a.getText().toString();
        Float floatOrNull = StringsKt.toFloatOrNull(string);
        if (floatOrNull == null || floatOrNull.floatValue() < 0.0f) {
            return "0";
        }
        if (floatOrNull.floatValue() > 100.0f) {
            return "100";
        }
        if (!StringsKt.contains$default(string, Consts.DOT, false, 2, (Object) null)) {
            return floatOrNull.toString();
        }
        String strValueOf = floatOrNull.floatValue() % ((float) 1) == 0.0f ? String.valueOf((int) floatOrNull.floatValue()) : new DecimalFormat("#.#").format(floatOrNull);
        Intrinsics.checkNotNullExpressionValue(strValueOf, "{\n            if (redPac…)\n            }\n        }");
        return strValueOf;
    }

    public final WorksItemFooterPublishPostBinding t0() {
        return (WorksItemFooterPublishPostBinding) this.footerBinding.getValue();
    }

    public final WorksItemHeaderPublishPostBinding u0() {
        return (WorksItemHeaderPublishPostBinding) this.headBinding.getValue();
    }

    @NotNull
    public final List<PubWorkMediaData> v0() {
        return u0().f14587a.getSelPictureList();
    }

    public final void w0() {
        getMBinding().f13902a.setItemAnimator(null);
        final PublishPostAdapter value = getMViewModel().m().getValue();
        if (value != null) {
            View root = u0().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "headBinding.root");
            BaseQuickAdapter.setHeaderView$default(value, root, 0, 0, 6, null);
            u0().f14587a.initSelectGridPicture(this, r0());
            View root2 = t0().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "footerBinding.root");
            BaseQuickAdapter.setFooterView$default(value, root2, 0, 0, 6, null);
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.t37
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    PublishPostActivity.x0(value, this, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public final void y0() {
        getMBinding().f36792a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.p37
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PublishPostActivity.z0(this.f43886a, compoundButton, z);
            }
        });
        A0();
    }
}
