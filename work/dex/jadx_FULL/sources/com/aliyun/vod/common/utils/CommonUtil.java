package com.aliyun.vod.common.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.StatFs;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CommonUtil {

    /* JADX INFO: renamed from: com.aliyun.vod.common.utils.CommonUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ Method val$finishInputLockedMethod;
        final /* synthetic */ InputMethodManager val$inputMethodManager;
        final /* synthetic */ Field val$mHField;
        final /* synthetic */ Field val$mServedViewField;

        public AnonymousClass1(InputMethodManager inputMethodManager, Field field, Field field2, Method method) {
            this.val$inputMethodManager = inputMethodManager;
            this.val$mHField = field;
            this.val$mServedViewField = field2;
            this.val$finishInputLockedMethod = method;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.getWindow().getDecorView().getRootView().getViewTreeObserver().addOnGlobalFocusChangeListener(new ReferenceCleaner(this.val$inputMethodManager, this.val$mHField, this.val$mServedViewField, this.val$finishInputLockedMethod));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static class ReferenceCleaner implements MessageQueue.IdleHandler, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalFocusChangeListener {
        private final Method finishInputLockedMethod;
        private final InputMethodManager inputMethodManager;
        private final Field mHField;
        private final Field mServedViewField;

        public ReferenceCleaner(InputMethodManager inputMethodManager, Field field, Field field2, Method method) {
            this.inputMethodManager = inputMethodManager;
            this.mHField = field;
            this.mServedViewField = field2;
            this.finishInputLockedMethod = method;
        }

        private void clearInputMethodManagerLeak() {
            try {
                synchronized (this.mHField.get(this.inputMethodManager)) {
                    View view = (View) this.mServedViewField.get(this.inputMethodManager);
                    if (view != null) {
                        boolean z = true;
                        if (view.getWindowVisibility() != 8) {
                            view.removeOnAttachStateChangeListener(this);
                            view.addOnAttachStateChangeListener(this);
                        } else {
                            Activity activityExtractActivity = extractActivity(view.getContext());
                            if (activityExtractActivity == null || activityExtractActivity.getWindow() == null) {
                                this.finishInputLockedMethod.invoke(this.inputMethodManager, new Object[0]);
                            } else {
                                View viewPeekDecorView = activityExtractActivity.getWindow().peekDecorView();
                                if (viewPeekDecorView.getWindowVisibility() == 8) {
                                    z = false;
                                }
                                if (z) {
                                    viewPeekDecorView.requestFocusFromTouch();
                                } else {
                                    this.finishInputLockedMethod.invoke(this.inputMethodManager, new Object[0]);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("IMMLeaks", "Unexpected reflection exception", e);
            }
        }

        private Activity extractActivity(Context context) {
            Context baseContext;
            while (!(context instanceof Application)) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
                    return null;
                }
                context = baseContext;
            }
            return null;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            if (view2 == null) {
                return;
            }
            if (view != null) {
                view.removeOnAttachStateChangeListener(this);
            }
            Looper.myQueue().removeIdleHandler(this);
            view2.addOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            Looper.myQueue().removeIdleHandler(this);
            Looper.myQueue().addIdleHandler(this);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            clearInputMethodManagerLeak();
            return false;
        }
    }

    public static long SDFreeSize() {
        if (!isReadWrite() && !isReadOnly()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static void clearDirectory(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                deleteDirectory(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static boolean deleteDirectory(File file) {
        clearDirectory(file);
        return file.delete();
    }

    public static void deleteFileByIds(Context context, long[] jArr) throws IOException {
        for (long j : jArr) {
            deleteDirectory(getAssetPackageDir(context, j));
        }
    }

    public static void fixFocusedViewLeak(Application application) {
    }

    public static void fixInputMethodManagerLeak(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() != context) {
                        return;
                    } else {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static File getAssetPackageDir(Context context, long j) throws IllegalArgumentException, FileNotFoundException {
        File resourcesUnzipPath = getResourcesUnzipPath(context);
        if (resourcesUnzipPath == null) {
            throw new FileNotFoundException();
        }
        return new File(resourcesUnzipPath, "Shop_Effect_" + String.valueOf(j));
    }

    public static String getDatabasePath(Context context) {
        return Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName() + "/qupai.db";
    }

    public static File getResourcesUnzipPath(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir == null || !externalFilesDir.exists()) {
            return null;
        }
        return externalFilesDir;
    }

    public static boolean hasNetwork(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isReadOnly() {
        return Environment.getExternalStorageState().equals("mounted_ro");
    }

    public static boolean isReadWrite() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
