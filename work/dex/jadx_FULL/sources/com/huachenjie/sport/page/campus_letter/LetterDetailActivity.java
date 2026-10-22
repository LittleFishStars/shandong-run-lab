package com.huachenjie.sport.page.campus_letter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.triver.basic.api.RequestPermission;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivityLetterBinding;
import com.huachenjie.sport.page.campus_letter.LetterDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/sport/page/campus_letter/LetterDetailActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/campus_letter/LetterDetailVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", "url", "r0", "n0", "initWebView", "", "a", "Lkotlin/Lazy;", "m0", "()Ljava/lang/Integer;", "letterFrom", "b", "l0", "()Ljava/lang/String;", LetterDetailActivity.x, "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class LetterDetailActivity extends BaseVmActivity<LetterDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String x = "letterCode";

    @NotNull
    public static final String y = "letter_from";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy letterFrom = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.sport.page.campus_letter.LetterDetailActivity$letterFrom$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m769invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra(LetterDetailActivity.y, 0));
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy letterCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.sport.page.campus_letter.LetterDetailActivity$letterCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(LetterDetailActivity.x)) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.sport.page.campus_letter.LetterDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/page/campus_letter/LetterDetailActivity$a;", "", "Landroid/content/Context;", "context", "", LetterDetailActivity.x, "", "letterFrom", "", "a", "Landroid/app/Activity;", RequestPermission.REQUEST_CODE, "b", "LETTER_CODE", "Ljava/lang/String;", "LETTER_FROM", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String letterCode, int letterFrom) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(letterCode, LetterDetailActivity.x);
            Intent intent = new Intent(context, (Class<?>) LetterDetailActivity.class);
            intent.putExtra(LetterDetailActivity.x, letterCode);
            intent.putExtra(LetterDetailActivity.y, letterFrom);
            context.startActivity(intent);
        }

        public final void b(@NotNull Activity context, int requestCode, @NotNull String letterCode, int letterFrom) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(letterCode, LetterDetailActivity.x);
            Intent intent = new Intent(context, (Class<?>) LetterDetailActivity.class);
            intent.putExtra(LetterDetailActivity.x, letterCode);
            intent.putExtra(LetterDetailActivity.y, letterFrom);
            context.startActivityForResult(intent, requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/sport/page/campus_letter/LetterDetailActivity$b", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "", "shouldOverrideUrlLoading", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable WebResourceRequest request) {
            Uri url;
            String string = (request == null || (url = request.getUrl()) == null) ? null : url.toString();
            if (string == null) {
                string = "";
            }
            if (!StringsKt.startsWith$default(string, "http", false, 2, (Object) null)) {
                return true;
            }
            LetterDetailActivity.this.r0(string);
            return true;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36563a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36563a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36563a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36563a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.sport.page.campus_letter.LetterDetailActivity$initViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "letterBean", "Lcom/huachenjie/base/bean/LetterBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLetterDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LetterDetailActivity.kt\ncom/huachenjie/sport/page/campus_letter/LetterDetailActivity$initViewModel$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n1864#2,3:213\n1864#2,3:216\n*S KotlinDebug\n*F\n+ 1 LetterDetailActivity.kt\ncom/huachenjie/sport/page/campus_letter/LetterDetailActivity$initViewModel$1\n*L\n129#1:213,3\n141#1:216,3\n*E\n"})
    public static final class AnonymousClass1 extends Lambda implements Function1<LetterBean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$0(LetterBean letterBean, View view) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", letterBean.getLinkUrl()).navigation();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LetterBean) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(final LetterBean letterBean) {
            ActivityLetterBinding activityLetterBinding = (ActivityLetterBinding) LetterDetailActivity.this.getBinding();
            if (activityLetterBinding != null) {
                if (!TextUtils.isEmpty(letterBean.getLinkUrl())) {
                    activityLetterBinding.f13305a.setOnClickListener(new View.OnClickListener() { // from class: com.huachenjie.sport.page.campus_letter.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LetterDetailActivity.AnonymousClass1.invoke$lambda$3$lambda$0(letterBean, view);
                        }
                    });
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("<!doctype html><html lang=\"zh\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title></title></head><body>");
                int i = 0;
                String str = "";
                if (StringsKt.contains$default(letterBean.getSchoolLetterContent(), "<img", false, 2, (Object) null)) {
                    int i2 = 0;
                    for (Object obj : StringsKt.split$default(letterBean.getSchoolLetterContent(), new String[]{"<img"}, false, 0, 6, (Object) null)) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str2 = (String) obj;
                        str = i2 == 0 ? str + str2 : str + "<img style = \"width:100%\" " + str2;
                        i2 = i3;
                    }
                } else {
                    str = "" + letterBean.getSchoolLetterContent();
                }
                String str3 = str;
                if (StringsKt.contains$default(str3, "<video", false, 2, (Object) null)) {
                    for (Object obj2 : StringsKt.split$default(str3, new String[]{"<video"}, false, 0, 6, (Object) null)) {
                        int i4 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str4 = (String) obj2;
                        if (i == 0) {
                            stringBuffer.append(str4);
                        } else {
                            stringBuffer.append("<video style = \"width:100%\" " + str4);
                        }
                        i = i4;
                    }
                } else {
                    stringBuffer.append(str3);
                }
                stringBuffer.append("</body></html>");
                activityLetterBinding.f36416a.loadDataWithBaseURL(null, stringBuffer.toString(), "text/html", "utf-8", null);
            }
        }
    }

    public static final void o0(final LetterDetailActivity letterDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(letterDetailActivity, "this$0");
        ft1.g(letterDetailActivity).Q("确定删除这条信息吗？").I(Color.parseColor("#FFFF3D3D")).J(new View.OnClickListener() { // from class: com.zj.adlib.ax4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LetterDetailActivity.p0(this.f40632a, view2);
            }
        }).F(OptionsPickerHelper.e).N("确定").Y();
    }

    public static final void p0(LetterDetailActivity letterDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(letterDetailActivity, "this$0");
        ((LetterDetailVM) ((BaseVmActivity) letterDetailActivity).f8507a).h(letterDetailActivity.l0());
    }

    public static final void q0(LetterDetailActivity letterDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(letterDetailActivity, "this$0");
        letterDetailActivity.finish();
    }

    public static final void s0(String str, LetterDetailActivity letterDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(str, "$url");
        Intrinsics.checkNotNullParameter(letterDetailActivity, "this$0");
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        intent.setAction("android.intent.action.VIEW");
        letterDetailActivity.startActivity(intent);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_letter), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        n0();
        Integer numM0 = m0();
        if (numM0 != null && numM0.intValue() == 0) {
            ((LetterDetailVM) ((BaseVmActivity) this).f8507a).l(l0());
        } else {
            ((LetterDetailVM) ((BaseVmActivity) this).f8507a).k(l0());
        }
        initWebView();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((LetterDetailVM) ((BaseVmActivity) this).f8507a).i().observe(this, new c(new AnonymousClass1()));
        ((LetterDetailVM) ((BaseVmActivity) this).f8507a).h.observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.campus_letter.LetterDetailActivity.initViewModel.2
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
                    Intent intent = new Intent();
                    intent.putExtra("code", LetterDetailActivity.this.l0());
                    LetterDetailActivity.this.setResult(-1, intent);
                    LetterDetailActivity.this.finish();
                }
            }
        }));
    }

    public final void initWebView() {
        WebView webView;
        ActivityLetterBinding activityLetterBinding = (ActivityLetterBinding) getBinding();
        if (activityLetterBinding == null || (webView = activityLetterBinding.f36416a) == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        webView.setWebViewClient(new b());
    }

    public final String l0() {
        return (String) this.letterCode.getValue();
    }

    public final Integer m0() {
        return (Integer) this.letterFrom.getValue();
    }

    public final void n0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ = ((LetterDetailVM) ((BaseVmActivity) this).f8507a).j();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("校园信件");
        bindingTitleBean.setShowDivider(false);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.color_2C3E50));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(Color.parseColor("#000000")));
        bindingTitleBean.setShowRightIcon(true);
        bindingTitleBean.setShowDivider(true);
        bindingTitleBean.setRightIconResId(R.drawable.ic_delete_letter);
        bindingTitleBean.setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.xw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LetterDetailActivity.o0(this.f45907a, view);
            }
        });
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.yw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LetterDetailActivity.q0(this.f46131a, view);
            }
        });
        mutableLiveDataJ.setValue(bindingTitleBean);
        e.p3(this).l3().T2(true).a1();
    }

    public final void r0(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ft1.g(this).Q("该链接将使用浏览器打开，是否允许跳转？").F(OptionsPickerHelper.e).N("允许").J(new View.OnClickListener() { // from class: com.zj.adlib.zw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LetterDetailActivity.s0(url, this, view);
            }
        }).Y();
    }
}
