package androidx.window.flow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.flow.SidecarWindowBackend;
import androidx.window.flow.WindowLayoutInfo;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.aliyun.tea.logging.DefaultLogger;
import com.byazt.hv.TTDownloadField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/WindowBackend;", "windowExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "(Landroidx/window/layout/ExtensionInterfaceCompat;)V", "getWindowExtension", "()Landroidx/window/layout/ExtensionInterfaceCompat;", "setWindowExtension", "windowLayoutChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "getWindowLayoutChangeCallbacks$annotations", "()V", "getWindowLayoutChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackRemovedForActivity", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "isActivityRegistered", "", "registerLayoutChangeCallback", "executor", "Ljava/util/concurrent/Executor;", RenderCallContext.TYPE_CALLBACK, "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "unregisterLayoutChangeCallback", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SidecarWindowBackend implements WindowBackend {
    public static final boolean DEBUG = false;

    @NotNull
    private static final String TAG = "WindowServer";

    @Nullable
    private static volatile SidecarWindowBackend globalInstance;

    @GuardedBy("globalLock")
    @VisibleForTesting
    @Nullable
    private ExtensionInterfaceCompat windowExtension;

    @NotNull
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ReentrantLock globalLock = new ReentrantLock();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$Companion;", "", "()V", DefaultLogger.DEBUG, "", "TAG", "", "globalInstance", "Landroidx/window/layout/SidecarWindowBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "context", "Landroid/content/Context;", "initAndVerifyExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "isSidecarVersionSupported", "sidecarVersion", "Landroidx/window/core/Version;", "resetInstance", "", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SidecarWindowBackend getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (SidecarWindowBackend.globalInstance == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.globalLock;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.INSTANCE.initAndVerifyExtension(context));
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.globalInstance;
            Intrinsics.checkNotNull(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        @Nullable
        public final ExtensionInterfaceCompat initAndVerifyExtension(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (!isSidecarVersionSupported(SidecarCompat.INSTANCE.getSidecarVersion())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.validateExtensionInterface()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @VisibleForTesting
        public final boolean isSidecarVersionSupported(@Nullable Version sidecarVersion) {
            return sidecarVersion != null && sidecarVersion.compareTo(Version.INSTANCE.getVERSION_0_1()) >= 0;
        }

        @VisibleForTesting
        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "(Landroidx/window/layout/SidecarWindowBackend;)V", "onWindowLayoutChanged", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @VisibleForTesting
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend this$0;

        public ExtensionListenerImpl(SidecarWindowBackend sidecarWindowBackend) {
            Intrinsics.checkNotNullParameter(sidecarWindowBackend, "this$0");
            this.this$0 = sidecarWindowBackend;
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            for (WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper : this.this$0.getWindowLayoutChangeCallbacks()) {
                if (Intrinsics.areEqual(windowLayoutChangeCallbackWrapper.getActivity(), activity)) {
                    windowLayoutChangeCallbackWrapper.accept(newLayout);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", RenderCallContext.TYPE_CALLBACK, "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Landroidx/core/util/Consumer;", "lastInfo", "getLastInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "(Landroidx/window/layout/WindowLayoutInfo;)V", SubscribeResouceItemModel.ACCEPT, "", "newLayoutInfo", "window_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class WindowLayoutChangeCallbackWrapper {

        @NotNull
        private final Activity activity;

        @NotNull
        private final Consumer<WindowLayoutInfo> callback;

        @NotNull
        private final Executor executor;

        @Nullable
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> consumer) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(consumer, RenderCallContext.TYPE_CALLBACK);
            this.activity = activity;
            this.executor = executor;
            this.callback = consumer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: accept$lambda-0, reason: not valid java name */
        public static final void m77accept$lambda0(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(windowLayoutChangeCallbackWrapper, "this$0");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.getCallback().accept(windowLayoutInfo);
        }

        public final void accept(@NotNull final WindowLayoutInfo newLayoutInfo) {
            Intrinsics.checkNotNullParameter(newLayoutInfo, "newLayoutInfo");
            this.lastInfo = newLayoutInfo;
            this.executor.execute(new Runnable(this, newLayoutInfo) { // from class: com.zj.adlib.mb8

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f43263a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ WindowLayoutInfo f18168a;

                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }

        @NotNull
        public final Consumer<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        @Nullable
        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(@Nullable WindowLayoutInfo windowLayoutInfo) {
            this.lastInfo = windowLayoutInfo;
        }
    }

    @VisibleForTesting
    public SidecarWindowBackend(@Nullable ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.windowExtension;
        if (extensionInterfaceCompat2 == null) {
            return;
        }
        extensionInterfaceCompat2.setExtensionCallback(new ExtensionListenerImpl(this));
    }

    @GuardedBy("sLock")
    private final void callbackRemovedForActivity(Activity activity) {
        ExtensionInterfaceCompat extensionInterfaceCompat;
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        boolean z = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity(), activity)) {
                    z = true;
                    break;
                }
            }
        }
        if (z || (extensionInterfaceCompat = this.windowExtension) == null) {
            return;
        }
        extensionInterfaceCompat.onWindowLayoutChangeListenerRemoved(activity);
    }

    @VisibleForTesting
    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    @NotNull
    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    @Override // androidx.window.flow.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<WindowLayoutInfo> callback) {
        WindowLayoutInfo lastInfo;
        Object next;
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat windowExtension = getWindowExtension();
            if (windowExtension == null) {
                callback.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                return;
            }
            boolean zIsActivityRegistered = isActivityRegistered(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, callback);
            getWindowLayoutChangeCallbacks().add(windowLayoutChangeCallbackWrapper);
            if (zIsActivityRegistered) {
                Iterator<T> it = getWindowLayoutChangeCallbacks().iterator();
                do {
                    lastInfo = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(activity, ((WindowLayoutChangeCallbackWrapper) next).getActivity()));
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) next;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    lastInfo = windowLayoutChangeCallbackWrapper2.getLastInfo();
                }
                if (lastInfo != null) {
                    windowLayoutChangeCallbackWrapper.accept(lastInfo);
                }
            } else {
                windowExtension.onWindowLayoutChangeListenerAdded(activity);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setWindowExtension(@Nullable ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
    }

    @Override // androidx.window.flow.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull Consumer<WindowLayoutInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        synchronized (globalLock) {
            if (getWindowExtension() == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper : getWindowLayoutChangeCallbacks()) {
                if (windowLayoutChangeCallbackWrapper.getCallback() == callback) {
                    Intrinsics.checkNotNullExpressionValue(windowLayoutChangeCallbackWrapper, "callbackWrapper");
                    arrayList.add(windowLayoutChangeCallbackWrapper);
                }
            }
            getWindowLayoutChangeCallbacks().removeAll(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity());
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
