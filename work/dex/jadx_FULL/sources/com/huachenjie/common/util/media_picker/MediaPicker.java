package com.huachenjie.common.util.media_picker;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.zj.adlib.PickedMedia;
import com.zj.adlib.af5;
import com.zj.adlib.rt2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u0012J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/common/util/media_picker/MediaPicker;", "", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "w", "Landroidx/fragment/app/Fragment;", "fragment", "v", "", "Lcom/zj/adlib/wq6;", "items", "", "t", "(Lcom/huachenjie/common/util/media_picker/MediaPickerListener;Ljava/util/List;)V", "n", "(Lcom/huachenjie/common/util/media_picker/MediaPickerListener;)V", "", "code", "", "message", "p", "(Lcom/huachenjie/common/util/media_picker/MediaPickerListener;ILjava/lang/String;)V", "r", "Landroidx/activity/result/ActivityResultCaller;", "caller", "Landroid/content/Context;", "context", "i", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mainHandler", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class MediaPicker {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final MediaPicker f8903a = new MediaPicker();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final void j(Ref.ObjectRef objectRef, Boolean bool) {
        MediaPickerLauncher mediaPickerLauncher;
        Intrinsics.checkNotNullParameter(objectRef, "$launcher");
        Object obj = objectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            mediaPickerLauncher = null;
        } else {
            mediaPickerLauncher = (MediaPickerLauncher) obj;
        }
        Intrinsics.checkNotNullExpressionValue(bool, "success");
        mediaPickerLauncher.j(bool.booleanValue());
    }

    public static final void k(Ref.ObjectRef objectRef, Uri uri) {
        MediaPickerLauncher mediaPickerLauncher;
        Intrinsics.checkNotNullParameter(objectRef, "$launcher");
        Object obj = objectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            mediaPickerLauncher = null;
        } else {
            mediaPickerLauncher = (MediaPickerLauncher) obj;
        }
        mediaPickerLauncher.i(uri == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(uri));
    }

    public static final void l(Ref.ObjectRef objectRef, List list) {
        MediaPickerLauncher mediaPickerLauncher;
        Intrinsics.checkNotNullParameter(objectRef, "$launcher");
        Object obj = objectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            mediaPickerLauncher = null;
        } else {
            mediaPickerLauncher = (MediaPickerLauncher) obj;
        }
        Intrinsics.checkNotNullExpressionValue(list, "uris");
        mediaPickerLauncher.i(list);
    }

    public static final void m(Ref.ObjectRef objectRef, ActivityResult activityResult) {
        MediaPickerLauncher mediaPickerLauncher;
        Intrinsics.checkNotNullParameter(objectRef, "$launcher");
        Object obj = objectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("launcher");
            mediaPickerLauncher = null;
        } else {
            mediaPickerLauncher = (MediaPickerLauncher) obj;
        }
        mediaPickerLauncher.g(activityResult.getResultCode(), activityResult.getData());
    }

    public static final void o(MediaPickerListener mediaPickerListener) {
        Intrinsics.checkNotNullParameter(mediaPickerListener, "$listener");
        mediaPickerListener.b(MediaPickerResult.a.f33925a);
    }

    public static final void q(MediaPickerListener mediaPickerListener, int i, String str) {
        Intrinsics.checkNotNullParameter(mediaPickerListener, "$listener");
        Intrinsics.checkNotNullParameter(str, "$message");
        mediaPickerListener.b(new MediaPickerResult.Error(i, str));
    }

    public static final void s(MediaPickerListener mediaPickerListener) {
        Intrinsics.checkNotNullParameter(mediaPickerListener, "$listener");
        mediaPickerListener.a();
    }

    public static final void u(List list, MediaPickerListener mediaPickerListener) {
        Intrinsics.checkNotNullParameter(list, "$items");
        Intrinsics.checkNotNullParameter(mediaPickerListener, "$listener");
        if (list.isEmpty()) {
            mediaPickerListener.b(MediaPickerResult.a.f33925a);
        } else {
            mediaPickerListener.b(new MediaPickerResult.Success(list));
        }
    }

    @JvmStatic
    @NotNull
    public static final MediaPickerLauncher v(@NotNull Fragment fragment, @NotNull MediaPickerListener listener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        MediaPicker mediaPicker = f8903a;
        Context contextRequireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        return mediaPicker.i(fragment, contextRequireContext, listener);
    }

    @JvmStatic
    @NotNull
    public static final MediaPickerLauncher w(@NotNull FragmentActivity activity, @NotNull MediaPickerListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        return f8903a.i(activity, activity, listener);
    }

    public final MediaPickerLauncher i(ActivityResultCaller caller, Context context, MediaPickerListener listener) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = caller.registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.zj.adlib.lk5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MediaPicker.j(objectRef, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "caller.registerForActivi…Result(success)\n        }");
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = caller.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback() { // from class: com.zj.adlib.mk5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MediaPicker.k(objectRef, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "caller.registerForActivi…se listOf(uri))\n        }");
        final af5 af5Var = new af5(0, 1, null);
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = caller.registerForActivityResult(new rt2(new Function0<Integer>() { // from class: com.huachenjie.common.util.media_picker.MediaPicker$createLauncher$multipleLauncher$1
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m360invoke() {
                return Integer.valueOf(af5Var.getValue());
            }
        }), new ActivityResultCallback() { // from class: com.zj.adlib.nk5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MediaPicker.l(objectRef, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "maxCountRef = MaxCountRe…ickerUris(uris)\n        }");
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult4 = caller.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.ok5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MediaPicker.m(objectRef, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "caller.registerForActivi…e, result.data)\n        }");
        MediaPickerLauncher mediaPickerLauncher = new MediaPickerLauncher(context, listener, activityResultLauncherRegisterForActivityResult2, activityResultLauncherRegisterForActivityResult3, activityResultLauncherRegisterForActivityResult4, activityResultLauncherRegisterForActivityResult, af5Var);
        objectRef.element = mediaPickerLauncher;
        return mediaPickerLauncher;
    }

    public final void n(@NotNull final MediaPickerListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        mainHandler.post(new Runnable() { // from class: com.zj.adlib.kk5
            @Override // java.lang.Runnable
            public final void run() {
                MediaPicker.o(listener);
            }
        });
    }

    public final void p(@NotNull final MediaPickerListener listener, final int code, @NotNull final String message) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Intrinsics.checkNotNullParameter(message, "message");
        mainHandler.post(new Runnable() { // from class: com.zj.adlib.qk5
            @Override // java.lang.Runnable
            public final void run() {
                MediaPicker.q(listener, code, message);
            }
        });
    }

    public final void r(@NotNull final MediaPickerListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        mainHandler.post(new Runnable() { // from class: com.zj.adlib.pk5
            @Override // java.lang.Runnable
            public final void run() {
                MediaPicker.s(listener);
            }
        });
    }

    public final void t(@NotNull final MediaPickerListener listener, @NotNull final List<PickedMedia> items) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        Intrinsics.checkNotNullParameter(items, "items");
        mainHandler.post(new Runnable() { // from class: com.zj.adlib.jk5
            @Override // java.lang.Runnable
            public final void run() {
                MediaPicker.u(items, listener);
            }
        });
    }
}
