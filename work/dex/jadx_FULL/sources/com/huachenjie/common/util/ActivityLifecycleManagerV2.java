package com.huachenjie.common.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.hv.TTDownloadField;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b \u0010!J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u0016\u0010\u0019R\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/huachenjie/common/util/ActivityLifecycleManagerV2;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "", "Landroid/app/Activity;", "c", "Lcom/huachenjie/common/util/ActivityLifecycleManagerV2$ActivityLifecycleInterface;", RenderCallContext.TYPE_CALLBACK, "", "e", "f", TTDownloadField.TT_ACTIVITY, "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "Ljava/util/LinkedList;", "a", "Lkotlin/Lazy;", "b", "()Ljava/util/LinkedList;", "activityList", "activityLifecycleList", "", "d", "()I", "activitySize", "<init>", "()V", "ActivityLifecycleInterface", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nActivityLifecycleManagerV2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityLifecycleManagerV2.kt\ncom/huachenjie/common/util/ActivityLifecycleManagerV2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1855#2,2:90\n1855#2,2:92\n*S KotlinDebug\n*F\n+ 1 ActivityLifecycleManagerV2.kt\ncom/huachenjie/common/util/ActivityLifecycleManagerV2\n*L\n42#1:90,2\n72#1:92,2\n*E\n"})
public final class ActivityLifecycleManagerV2 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ActivityLifecycleManagerV2 f33902a = new ActivityLifecycleManagerV2();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy activityList = LazyKt.lazy(new Function0<LinkedList<Activity>>() { // from class: com.huachenjie.common.util.ActivityLifecycleManagerV2$activityList$2
        @NotNull
        public final LinkedList<Activity> invoke() {
            return new LinkedList<>();
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final Lazy activityLifecycleList = LazyKt.lazy(new Function0<LinkedList<ActivityLifecycleInterface>>() { // from class: com.huachenjie.common.util.ActivityLifecycleManagerV2$activityLifecycleList$2
        @NotNull
        public final LinkedList<ActivityLifecycleManagerV2.ActivityLifecycleInterface> invoke() {
            return new LinkedList<>();
        }
    });

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/util/ActivityLifecycleManagerV2$ActivityLifecycleInterface;", "", "", "a", "b", "common_release"}, k = 1, mv = {1, 8, 0})
    public interface ActivityLifecycleInterface {
        void a();

        void b();
    }

    public final LinkedList<ActivityLifecycleInterface> a() {
        return (LinkedList) activityLifecycleList.getValue();
    }

    public final LinkedList<Activity> b() {
        return (LinkedList) activityList.getValue();
    }

    @NotNull
    public final List<Activity> c() {
        return b();
    }

    public final int d() {
        return b().size();
    }

    public final void e(@NotNull ActivityLifecycleInterface callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        a().add(callback);
    }

    public final void f(@NotNull ActivityLifecycleInterface callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        a().remove(callback);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        if (b().isEmpty()) {
            Iterator<T> it = a().iterator();
            while (it.hasNext()) {
                ((ActivityLifecycleInterface) it.next()).a();
            }
        }
        b().add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        b().remove(activity);
        if (b().isEmpty()) {
            Iterator<T> it = a().iterator();
            while (it.hasNext()) {
                ((ActivityLifecycleInterface) it.next()).b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
    }
}
