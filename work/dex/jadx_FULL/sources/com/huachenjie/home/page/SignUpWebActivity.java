package com.huachenjie.home.page;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.huachenjie.common.webview.WebViewActivity;
import com.huachenjie.common.webview.WebViewVM;
import com.huachenjie.home.util.TasksUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/home/page/SignUpWebActivity;", "Lcom/huachenjie/common/webview/WebViewActivity;", "Lcom/huachenjie/common/webview/WebViewVM;", "Landroid/webkit/WebView;", "view", "", "url", "", "w0", "a", "Lkotlin/Lazy;", "x0", "()Ljava/lang/String;", SignUpWebActivity.A, "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class SignUpWebActivity extends WebViewActivity<WebViewVM> {

    @NotNull
    public static final String A = "taskConfigNo";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String z = "url";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy taskConfigNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.home.page.SignUpWebActivity$taskConfigNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(SignUpWebActivity.A);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.home.page.SignUpWebActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/home/page/SignUpWebActivity$a;", "", "Landroid/content/Context;", "context", "", "url", SignUpWebActivity.A, "", "a", "KEY_TASK_CONFIG_NO", "Ljava/lang/String;", "KEY_URL", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String url, @NotNull String taskConfigNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(taskConfigNo, SignUpWebActivity.A);
            Intent intent = new Intent(context, (Class<?>) SignUpWebActivity.class);
            intent.putExtra("url", url);
            intent.putExtra(SignUpWebActivity.A, taskConfigNo);
            context.startActivity(intent);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    @Override // com.huachenjie.common.webview.WebViewActivity
    public void w0(@Nullable WebView view, @Nullable String url) {
        boolean z2;
        if (url != null) {
            z2 = StringsKt.startsWith$default(url, "https://jinshuju.cool", false, 2, (Object) null);
        }
        if (z2 && StringsKt.contains$default(url, "success", false, 2, (Object) null)) {
            TasksUtil tasksUtil = TasksUtil.f34372a;
            String strX0 = x0();
            Intrinsics.checkNotNullExpressionValue(strX0, A);
            TasksUtil.k(tasksUtil, strX0, null, 2, null);
        }
        super.w0(view, url);
    }

    public final String x0() {
        return (String) this.taskConfigNo.getValue();
    }
}
