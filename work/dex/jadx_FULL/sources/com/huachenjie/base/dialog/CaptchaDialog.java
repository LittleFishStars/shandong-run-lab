package com.huachenjie.base.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.base.R;
import com.huachenjie.base.broadcast.captcha.CaptchaResultListener;
import com.huachenjie.base.broadcast.captcha.CaptchaResultReceiver;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.base.dsbridge_webview.DWebView;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.zj.adlib.ee1;
import com.zj.adlib.fx7;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016R5\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/base/dialog/CaptchaDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "onDestroyView", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "captcha", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function1;", "Lcom/huachenjie/base/broadcast/captcha/CaptchaResultReceiver;", "receiver", "Lcom/huachenjie/base/broadcast/captcha/CaptchaResultReceiver;", "<init>", "()V", "Companion", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public final class CaptchaDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function1<? super String, Unit> callback;

    @NotNull
    private final CaptchaResultReceiver receiver = new CaptchaResultReceiver(new b());

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.CaptchaDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/dialog/CaptchaDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "captcha", "", RenderCallContext.TYPE_CALLBACK, "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull FragmentManager manager, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            CaptchaDialog captchaDialog = new CaptchaDialog();
            captchaDialog.callback = callback;
            captchaDialog.show(manager, Reflection.getOrCreateKotlinClass(CaptchaDialog.class).getSimpleName());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/base/dialog/CaptchaDialog$b", "Lcom/huachenjie/base/broadcast/captcha/CaptchaResultListener;", "", "captcha", "", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements CaptchaResultListener {
        public b() {
        }

        @Override // com.huachenjie.base.broadcast.captcha.CaptchaResultListener
        public void a(@NotNull String captcha) {
            Intrinsics.checkNotNullParameter(captcha, "captcha");
            Function1 function1 = CaptchaDialog.this.callback;
            if (function1 != null) {
                function1.invoke(captcha);
            }
            CaptchaDialog.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CaptchaDialog captchaDialog, View view) {
        Intrinsics.checkNotNullParameter(captchaDialog, "this$0");
        Function1<? super String, Unit> function1 = captchaDialog.callback;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
        captchaDialog.dismissAllowingStateLoss();
    }

    @JvmStatic
    public static final void show(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super String, Unit> function1) {
        INSTANCE.a(fragmentManager, function1);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.base_dialog_captcha;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(32.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        WebContentView webContentView;
        DWebView webView;
        ImageView imageView;
        super.initView();
        setCancelable(false);
        ee1 ee1Var = ee1.f41414a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ee1Var.registerReceiver(contextRequireContext, this.receiver);
        View view = getView();
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.iv_close)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.de1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CaptchaDialog.initView$lambda$0(this.f41159a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 == null || (webContentView = (WebContentView) view2.findViewById(R.id.web_content_view)) == null || (webView = webContentView.getWebView()) == null) {
            return;
        }
        webView.loadUrl(Environment.c + "/#/captcha/verify");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ee1 ee1Var = ee1.f41414a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ee1Var.unregisterReceiver(contextRequireContext, this.receiver);
        super.onDestroyView();
    }
}
