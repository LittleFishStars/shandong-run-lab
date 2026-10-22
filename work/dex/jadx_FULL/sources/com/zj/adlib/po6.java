package com.zj.adlib;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.hv.TTDownloadField;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.OnPermissionInterceptor;
import com.hjq.permissions.OnPermissionPageCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.PermissionFragment;
import com.hjq.permissions.XXPermissions;
import com.huachenjie.common.R;
import com.huachenjie.common.util.permission.PermissionDeniedDialogListener;
import com.huachenjie.common.util.permission.PermissionNameConvert;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b/\u00100J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J>\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\"\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010(R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010-¨\u00061"}, d2 = {"Lcom/zj/adlib/po6;", "Lcom/hjq/permissions/OnPermissionInterceptor;", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "", "allPermissions", "Lcom/hjq/permissions/OnPermissionCallback;", RenderCallContext.TYPE_CALLBACK, "", "launchPermissionRequest", "", "skipRequest", "finishPermissionRequest", "deniedPermissions", "doNotAskAgain", "deniedPermissionRequest", "k", "Landroid/view/ViewGroup;", "decorView", "message", "r", "i", "a", "Ljava/util/List;", "mPermissionDesList", "Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "j", "()Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;", "p", "(Lcom/huachenjie/common/util/permission/PermissionDeniedDialogListener;)V", "deniedDialogListener", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", t.d, "()Landroidx/fragment/app/Fragment;", "q", "(Landroidx/fragment/app/Fragment;)V", "targetFragment", "Ljava/lang/String;", "mPermissionDescription", "Z", "mRequestFlag", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mPermissionPopup", "<init>", "(Ljava/util/List;)V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPermissionInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionInterceptor.kt\ncom/huachenjie/common/util/permission/PermissionInterceptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,226:1\n1864#2,3:227\n*S KotlinDebug\n*F\n+ 1 PermissionInterceptor.kt\ncom/huachenjie/common/util/permission/PermissionInterceptor\n*L\n121#1:227,3\n*E\n"})
public final class po6 implements OnPermissionInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public PopupWindow mPermissionPopup;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Fragment targetFragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public PermissionDeniedDialogListener deniedDialogListener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String mPermissionDescription;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public List<String> mPermissionDesList;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean mRequestFlag;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f18903a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Handler f44027a = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/zj/adlib/po6$a;", "", "Landroid/os/Handler;", "HANDLER", "Landroid/os/Handler;", "a", "()Landroid/os/Handler;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Handler a() {
            return po6.f44027a;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/zj/adlib/po6$b", "Lcom/hjq/permissions/OnPermissionPageCallback;", "", "onGranted", "onDenied", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnPermissionPageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnPermissionCallback f44028a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<String> f18910a;
        public final /* synthetic */ List<String> b;

        public b(OnPermissionCallback onPermissionCallback, List<String> list, List<String> list2) {
            this.f44028a = onPermissionCallback;
            this.f18910a = list;
            this.b = list2;
        }

        @Override // com.hjq.permissions.OnPermissionPageCallback
        public void onDenied() {
            if (this.b.size() == 1 && this.b.contains(Permission.ACCESS_BACKGROUND_LOCATION)) {
                OnPermissionCallback onPermissionCallback = this.f44028a;
                if (onPermissionCallback != null) {
                    onPermissionCallback.onGranted(this.f18910a, true);
                    return;
                }
                return;
            }
            OnPermissionCallback onPermissionCallback2 = this.f44028a;
            if (onPermissionCallback2 != null) {
                onPermissionCallback2.onDenied(this.b, true);
            }
        }

        @Override // com.hjq.permissions.OnPermissionPageCallback
        public void onGranted() {
            OnPermissionCallback onPermissionCallback = this.f44028a;
            if (onPermissionCallback != null) {
                onPermissionCallback.onGranted(this.f18910a, true);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public po6() {
        List list = null;
        this(list, 1, list);
    }

    @JvmOverloads
    public po6(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "mPermissionDesList");
        this.mPermissionDesList = list;
        this.mPermissionDescription = "";
    }

    public static final void g(List list, OnPermissionCallback onPermissionCallback, List list2, View view) {
        Intrinsics.checkNotNullParameter(list, "$deniedPermissions");
        Intrinsics.checkNotNullParameter(list2, "$allPermissions");
        if (list.size() == 1 && list.contains(Permission.ACCESS_BACKGROUND_LOCATION)) {
            if (onPermissionCallback != null) {
                onPermissionCallback.onGranted(list2, true);
            }
        } else if (onPermissionCallback != null) {
            onPermissionCallback.onDenied(list, true);
        }
    }

    public static final void h(Activity activity, List list, OnPermissionCallback onPermissionCallback, List list2, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(list, "$deniedPermissions");
        Intrinsics.checkNotNullParameter(list2, "$allPermissions");
        XXPermissions.startPermissionActivity(activity, (List<String>) list, new b(onPermissionCallback, list2, list));
    }

    public static final void m(po6 po6Var, Activity activity, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(po6Var, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(viewGroup, "$decorView");
        if (!po6Var.mRequestFlag || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        po6Var.r(activity, viewGroup, po6Var.mPermissionDescription);
    }

    public static final void n(OnPermissionCallback onPermissionCallback, List list, View view) {
        Intrinsics.checkNotNullParameter(list, "$deniedPermissions");
        if (onPermissionCallback != null) {
            onPermissionCallback.onDenied(list, false);
        }
    }

    public static final void o(Activity activity, List list, po6 po6Var, OnPermissionCallback onPermissionCallback, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(list, "$allPermissions");
        Intrinsics.checkNotNullParameter(po6Var, "this$0");
        PermissionFragment.launch(activity, list, po6Var, onPermissionCallback);
    }

    @Override // com.hjq.permissions.OnPermissionInterceptor
    public void deniedPermissionRequest(@NotNull final Activity activity, @NotNull final List<String> allPermissions, @NotNull final List<String> deniedPermissions, boolean doNotAskAgain, @Nullable final OnPermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(allPermissions, "allPermissions");
        Intrinsics.checkNotNullParameter(deniedPermissions, "deniedPermissions");
        if (!doNotAskAgain) {
            List mutableList = CollectionsKt.toMutableList(deniedPermissions);
            mutableList.remove(Permission.ACCESS_BACKGROUND_LOCATION);
            if (mutableList.isEmpty()) {
                if (callback != null) {
                    callback.onGranted(allPermissions, true);
                    return;
                }
                return;
            }
        }
        PermissionDeniedDialogListener permissionDeniedDialogListener = this.deniedDialogListener;
        if (permissionDeniedDialogListener != null) {
            String string = activity.getString(R.string.common_dialog_permission_name);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…n_dialog_permission_name)");
            String strF = ys8.f(R.string.common_permission_fail, PermissionNameConvert.f33932a.d(activity, deniedPermissions));
            Intrinsics.checkNotNullExpressionValue(strF, "getString(\n             …ermissions)\n            )");
            String string2 = activity.getString(R.string.common_dialog_permission_cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…dialog_permission_cancel)");
            String string3 = activity.getString(R.string.common_dialog_permission_go_sure);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str…ialog_permission_go_sure)");
            permissionDeniedDialogListener.a(activity, string, strF, string2, string3, new View.OnClickListener() { // from class: com.zj.adlib.no6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    po6.g(deniedPermissions, callback, allPermissions, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.oo6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    po6.h(activity, deniedPermissions, callback, allPermissions, view);
                }
            });
        }
    }

    @Override // com.hjq.permissions.OnPermissionInterceptor
    public void finishPermissionRequest(@NotNull Activity activity, @NotNull List<String> allPermissions, boolean skipRequest, @Nullable OnPermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(allPermissions, "allPermissions");
        this.mRequestFlag = false;
        i();
    }

    public final void i() {
        PopupWindow popupWindow = this.mPermissionPopup;
        if (popupWindow == null) {
            return;
        }
        Intrinsics.checkNotNull(popupWindow);
        if (popupWindow.isShowing()) {
            PopupWindow popupWindow2 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow2);
            popupWindow2.dismiss();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: j, reason: from getter */
    public final PermissionDeniedDialogListener getDeniedDialogListener() {
        return this.deniedDialogListener;
    }

    public final List<String> k(Activity activity, List<String> allPermissions) {
        ArrayList arrayList = new ArrayList(allPermissions.size());
        ArrayList arrayList2 = new ArrayList(allPermissions.size());
        int i = 0;
        for (Object obj : allPermissions) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (!XXPermissions.isGranted(activity, str)) {
                arrayList.add(str);
                String str2 = (String) CollectionsKt.getOrNull(this.mPermissionDesList, i);
                if (str2 == null) {
                    str2 = "";
                }
                arrayList2.add(str2);
            }
            i = i2;
        }
        this.mPermissionDescription = CollectionsKt.joinToString$default(PermissionNameConvert.f33932a.c(activity, arrayList, arrayList2), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return arrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }

    @Override // com.hjq.permissions.OnPermissionInterceptor
    public void launchPermissionRequest(@NotNull final Activity activity, @NotNull final List<String> allPermissions, @Nullable final OnPermissionCallback callback) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(allPermissions, "allPermissions");
        this.mRequestFlag = true;
        final List<String> listK = k(activity, allPermissions);
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) decorView;
        boolean z = false;
        boolean z2 = activity.getResources().getConfiguration().orientation == 1;
        Iterator<String> it = allPermissions.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z2;
                break;
            }
            String next = it.next();
            if (XXPermissions.isSpecial(next) && !XXPermissions.isGranted(activity, next) && (Build.VERSION.SDK_INT >= 30 || !TextUtils.equals(Permission.MANAGE_EXTERNAL_STORAGE, next))) {
                break;
            }
        }
        if (z) {
            PermissionFragment.launch(activity, allPermissions, this, callback);
            f44027a.postDelayed(new Runnable() { // from class: com.zj.adlib.ko6
                @Override // java.lang.Runnable
                public final void run() {
                    po6.m(this.f17762a, activity, viewGroup);
                }
            }, 500L);
            return;
        }
        PermissionDeniedDialogListener permissionDeniedDialogListener = this.deniedDialogListener;
        if (permissionDeniedDialogListener != null) {
            int i = R.string.common_dialog_permission_name;
            String string = activity.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…n_dialog_permission_name)");
            String string2 = activity.getString(i);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…n_dialog_permission_name)");
            String string3 = activity.getString(R.string.common_dialog_permission_cancel);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str…dialog_permission_cancel)");
            String string4 = activity.getString(R.string.common_dialog_permission_sure);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str…n_dialog_permission_sure)");
            permissionDeniedDialogListener.a(activity, string, string2, string3, string4, new View.OnClickListener() { // from class: com.zj.adlib.lo6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    po6.n(callback, listK, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.mo6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    po6.o(activity, allPermissions, this, callback, view);
                }
            });
        }
    }

    public final void p(@Nullable PermissionDeniedDialogListener permissionDeniedDialogListener) {
        this.deniedDialogListener = permissionDeniedDialogListener;
    }

    public final void q(@Nullable Fragment fragment) {
        this.targetFragment = fragment;
    }

    public final void r(Activity activity, ViewGroup decorView, String message) {
        if (this.mPermissionPopup == null) {
            View viewInflate = LayoutInflater.from(activity).inflate(R.layout.common_popup_permission_description, decorView, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(activity)\n         …iption, decorView, false)");
            PopupWindow popupWindow = new PopupWindow(activity);
            this.mPermissionPopup = popupWindow;
            Intrinsics.checkNotNull(popupWindow);
            popupWindow.setContentView(viewInflate);
            PopupWindow popupWindow2 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow2);
            popupWindow2.setWidth(-1);
            PopupWindow popupWindow3 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow3);
            popupWindow3.setHeight(-2);
            PopupWindow popupWindow4 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow4);
            popupWindow4.setAnimationStyle(android.R.style.Animation.Dialog);
            PopupWindow popupWindow5 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow5);
            popupWindow5.setBackgroundDrawable(new ColorDrawable(0));
            PopupWindow popupWindow6 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow6);
            popupWindow6.setTouchable(true);
            PopupWindow popupWindow7 = this.mPermissionPopup;
            Intrinsics.checkNotNull(popupWindow7);
            popupWindow7.setOutsideTouchable(true);
        }
        PopupWindow popupWindow8 = this.mPermissionPopup;
        Intrinsics.checkNotNull(popupWindow8);
        ((TextView) popupWindow8.getContentView().findViewById(R.id.tv_permission_description_message)).setText(message);
        PopupWindow popupWindow9 = this.mPermissionPopup;
        Intrinsics.checkNotNull(popupWindow9);
        Fragment fragment = this.targetFragment;
        View view = decorView;
        if (fragment != null) {
            Intrinsics.checkNotNull(fragment);
            view = fragment.getView();
        }
        popupWindow9.showAtLocation(view, 48, 0, 0);
    }

    public /* synthetic */ po6(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
