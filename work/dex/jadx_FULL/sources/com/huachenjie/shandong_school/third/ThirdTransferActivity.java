package com.huachenjie.shandong_school.third;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alipay.sdk.m.n.c;
import com.blankj.utilcode.util.a;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.huachenjie.shandong_school.splash.SplashActivity;
import com.huachenjie.shandong_school.third.ThirdTransferActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0010R-\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/shandong_school/third/ThirdTransferActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "i", "Landroid/net/Uri;", "a", "Lkotlin/Lazy;", y6b.f, "()Landroid/net/Uri;", "uri", "", "b", "f", "()Ljava/lang/String;", "path", "kotlin.jvm.PlatformType", "c", y6b.g, "url", "", "Lkotlin/Pair;", "d", "e", "()Ljava/util/List;", "paramsList", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nThirdTransferActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThirdTransferActivity.kt\ncom/huachenjie/shandong_school/third/ThirdTransferActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1855#2,2:147\n*S KotlinDebug\n*F\n+ 1 ThirdTransferActivity.kt\ncom/huachenjie/shandong_school/third/ThirdTransferActivity\n*L\n136#1:147,2\n*E\n"})
public final class ThirdTransferActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final List<Runnable> f12682a = new ArrayList();

    @NotNull
    public static final List<String> c = CollectionsKt.mutableListOf(new String[]{zj7.i.WORKS_DETAIL, zj7.g.GOOD_DETAIL, zj7.i.POST_DETAIL, zj7.h.OTHER_HOME, RoutePathConstants.Base.b});

    @NotNull
    public static final String f = "path";

    @NotNull
    public static final String g = "url";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy uri = LazyKt.lazy(new Function0<Uri>() { // from class: com.huachenjie.shandong_school.third.ThirdTransferActivity$uri$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Uri m754invoke() {
            return this.this$0.getIntent().getData();
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy path = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.shandong_school.third.ThirdTransferActivity$path$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Uri uriG = this.this$0.g();
            if (uriG != null) {
                return uriG.getQueryParameter("path");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy url = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.shandong_school.third.ThirdTransferActivity$url$2
        {
            super(0);
        }

        public final String invoke() {
            String queryParameter;
            Uri uriG = this.this$0.g();
            if (uriG == null || (queryParameter = uriG.getQueryParameter("url")) == null) {
                queryParameter = "";
            }
            return URLDecoder.decode(queryParameter, "UTF-8");
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy paramsList = LazyKt.lazy(new Function0<List<Pair<? extends String, ? extends String>>>() { // from class: com.huachenjie.shandong_school.third.ThirdTransferActivity$paramsList$2
        {
            super(0);
        }

        @NotNull
        public final List<Pair<String, String>> invoke() {
            Set<String> queryParameterNames;
            String queryParameter;
            ArrayList arrayList = new ArrayList();
            Uri uriG = this.this$0.g();
            if (uriG != null && (queryParameterNames = uriG.getQueryParameterNames()) != null) {
                ThirdTransferActivity thirdTransferActivity = this.this$0;
                for (String str : queryParameterNames) {
                    if (!Intrinsics.areEqual(str, "path")) {
                        if (Intrinsics.areEqual(str, "url")) {
                            queryParameter = thirdTransferActivity.h();
                        } else {
                            Uri uriG2 = thirdTransferActivity.g();
                            Intrinsics.checkNotNull(uriG2);
                            queryParameter = uriG2.getQueryParameter(str);
                            if (queryParameter == null) {
                                queryParameter = "";
                            }
                        }
                        arrayList.add(new Pair(str, queryParameter));
                    }
                }
            }
            return arrayList;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.third.ThirdTransferActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/shandong_school/third/ThirdTransferActivity$a;", "", "", "a", "", "", "ALLOW_JUMP_LIST", "Ljava/util/List;", "Ljava/lang/Runnable;", "JUMP_TASK_LIST", "PATH_KEY", "Ljava/lang/String;", "URL_KEY", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nThirdTransferActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThirdTransferActivity.kt\ncom/huachenjie/shandong_school/third/ThirdTransferActivity$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1855#2,2:147\n*S KotlinDebug\n*F\n+ 1 ThirdTransferActivity.kt\ncom/huachenjie/shandong_school/third/ThirdTransferActivity$Companion\n*L\n42#1:147,2\n*E\n"})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            Iterator it = ThirdTransferActivity.f12682a.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            ThirdTransferActivity.f12682a.clear();
        }
    }

    public static final void j(ThirdTransferActivity thirdTransferActivity) {
        Intrinsics.checkNotNullParameter(thirdTransferActivity, "this$0");
        thirdTransferActivity.i();
    }

    public final List<Pair<String, String>> e() {
        return (List) this.paramsList.getValue();
    }

    public final String f() {
        return (String) this.path.getValue();
    }

    public final Uri g() {
        return (Uri) this.uri.getValue();
    }

    public final String h() {
        return (String) this.url.getValue();
    }

    public final void i() {
        try {
            try {
                Postcard postcardBuild = ARouter.getInstance().build(f());
                Iterator<T> it = e().iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    postcardBuild.withString((String) pair.getFirst(), (String) pair.getSecond());
                }
                postcardBuild.navigation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String host;
        super.onCreate(savedInstanceState);
        ThirdUtil thirdUtil = ThirdUtil.f7255a;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "this.application");
        thirdUtil.h(application);
        if (ActivityLifecycleManager.l().q() instanceof AdCancelInterface) {
            finish();
            return;
        }
        if (!CollectionsKt.contains(c, f())) {
            if (a.D().size() == 1) {
                startActivity(new Intent(this, (Class<?>) SplashActivity.class));
            }
            finish();
            return;
        }
        if (!ai9.l()) {
            startActivity(new Intent(this, (Class<?>) WelcomeLoginActivity.class));
            List<Runnable> list = f12682a;
            list.clear();
            list.add(new Runnable() { // from class: com.zj.adlib.a59
                @Override // java.lang.Runnable
                public final void run() {
                    ThirdTransferActivity.j(this.f40454a);
                }
            });
            finish();
            return;
        }
        try {
            host = new URI(h()).getHost();
        } catch (Exception unused) {
            host = "";
        }
        if (Intrinsics.areEqual(f(), RoutePathConstants.Base.b)) {
            Intrinsics.checkNotNullExpressionValue(host, c.f);
            if (!StringsKt.endsWith$default(host, "huachenjie.com", false, 2, (Object) null)) {
                if (a.D().size() == 1) {
                    startActivity(new Intent(this, (Class<?>) SplashActivity.class));
                }
                finish();
                return;
            }
        }
        i();
    }
}
