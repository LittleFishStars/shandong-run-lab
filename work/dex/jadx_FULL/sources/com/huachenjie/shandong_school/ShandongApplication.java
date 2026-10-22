package com.huachenjie.shandong_school;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.multidex.MultiDexApplication;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.huachenjie.base.util.manager.IMallModule;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.cache_webview.interceptor.ResourceInterceptor;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.permission.PermissionDeniedDialogListener;
import com.huachenjie.im.IIMModule;
import com.huachenjie.im.custom.ShareOrderAttachment;
import com.huachenjie.step.PermissionDelegate;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/huachenjie/shandong_school/ShandongApplication;", "Landroidx/multidex/MultiDexApplication;", "Lcom/huachenjie/common/util/ActivityLifecycleManager$BackgroundNotifyInterface;", "Landroid/content/Context;", "base", "", "attachBaseContext", "onCreate", "onToBackGround", "onToForeGround", "", com.alibaba.ariver.permission.b.b, "onTrimMemory", "onLowMemory", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "filter", "Landroid/content/Intent;", "registerReceiver", "flags", "i", "j", "k", t.d, "", y6b.g, "c", "e", "f", "d", y6b.f, "b", "m", "", "a", "J", "hideTimeMillis", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class ShandongApplication extends MultiDexApplication implements ActivityLifecycleManager.BackgroundNotifyInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static ShandongApplication f12622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long hideTimeMillis;

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.ShandongApplication$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/shandong_school/ShandongApplication$a;", "", "Lcom/huachenjie/shandong_school/ShandongApplication;", "sInstance", "Lcom/huachenjie/shandong_school/ShandongApplication;", "a", "()Lcom/huachenjie/shandong_school/ShandongApplication;", "b", "(Lcom/huachenjie/shandong_school/ShandongApplication;)V", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final native ShandongApplication a();

        public final native void b(@Nullable ShandongApplication shandongApplication);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$b", "Lcom/huachenjie/common/cache_webview/interceptor/ResourceInterceptor;", "", "url", "", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class b implements ResourceInterceptor {
        @Override // com.huachenjie.common.cache_webview.interceptor.ResourceInterceptor
        public native boolean a(@NotNull String url);
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$c", "Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "Landroid/content/Context;", "context", "", "title", "", "content", "cancelText", "confirmText", "Landroid/view/View$OnClickListener;", "cancelClickListener", "confirmClickListener", "", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c implements PermissionDeniedDialogListener {

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$c$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
        public static final class a extends DialogUtil.PositiveNegativeClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View.OnClickListener f36017a;
            public final /* synthetic */ View.OnClickListener b;

            public a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
                this.f36017a = onClickListener;
                this.b = onClickListener2;
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void a() {
                this.b.onClick(null);
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void b() {
                this.f36017a.onClick(null);
            }
        }

        @Override // com.huachenjie.common.util.permission.PermissionDeniedDialogListener
        public native void a(@NotNull Context context, @NotNull String title, @NotNull CharSequence content, @NotNull String cancelText, @NotNull String confirmText, @NotNull View.OnClickListener cancelClickListener, @NotNull View.OnClickListener confirmClickListener);
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$d", "Lcom/huachenjie/step/PermissionDelegate;", "Landroid/content/Context;", "context", "", "requiredPermission", "hintMessage", "Lkotlin/Function1;", "", "", "acpListener", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class d implements PermissionDelegate {
        public static final native void c(Function1 function1, boolean z);

        @Override // com.huachenjie.step.PermissionDelegate
        public native void a(@NotNull Context context, @NotNull String requiredPermission, @NotNull String hintMessage, @NotNull Function1<? super Boolean, Unit> acpListener);
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$e", "Lcom/huachenjie/base/util/manager/IMallModule;", "Lcom/huachenjie/base/works/BaseSearchResultFragment;", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class e implements IMallModule {
        @Override // com.huachenjie.base.util.manager.IMallModule
        @NotNull
        public native BaseSearchResultFragment<?, ?> a();
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J;\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/shandong_school/ShandongApplication$f", "Lcom/huachenjie/im/IIMModule;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", ALPParamConstant.SHOPID, "Lkotlin/Function1;", "Lcom/huachenjie/im/custom/ShareOrderAttachment;", "Lkotlin/ParameterName;", "name", "orderAttachment", "", "selCallback", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class f implements IIMModule {
        @Override // com.huachenjie.im.IIMModule
        public native void a(@NotNull FragmentManager fragmentManager, @NotNull String shopId, @NotNull Function1<? super ShareOrderAttachment, Unit> selCallback);
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public native void attachBaseContext(@NotNull Context base);

    public final native void b();

    public final void c() {
    }

    public final native void d();

    public final void e() {
    }

    public final native void f();

    public final native void g();

    public final native boolean h();

    public final native void i();

    public final native void j();

    public final native void k();

    public final native void l();

    public final native void m();

    @Override // android.app.Application
    public native void onCreate();

    @Override // android.app.Application, android.content.ComponentCallbacks
    public native void onLowMemory();

    @Override // com.huachenjie.common.util.ActivityLifecycleManager.BackgroundNotifyInterface
    public native void onToBackGround();

    @Override // com.huachenjie.common.util.ActivityLifecycleManager.BackgroundNotifyInterface
    public native void onToForeGround();

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public native void onTrimMemory(int level);

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public native Intent registerReceiver(@Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter);

    @Override // android.content.ContextWrapper, android.content.Context
    @Nullable
    public native Intent registerReceiver(@Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, int flags);
}
