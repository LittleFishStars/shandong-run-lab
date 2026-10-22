package com.kc.aw;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.hv.TTDownloadField;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fp {
    public static final _fp _c = new _fp();
    public static int _d = 0;
    public final _a _a = new _a();
    public volatile boolean _b;

    @Keep
    public static final class _a implements Application.ActivityLifecycleCallbacks {
        public _i _a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (_fp._d == 0) {
                _i _iVar = this._a;
                if (_iVar != null) {
                    _iVar._a();
                }
                _c _cVar_a = _c._a();
                _cVar_a.getClass();
                com.kc.aw.lib.utils._d._b(new _e(_cVar_a));
            }
            _fp._d++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int i = _fp._d;
            if (i > 0) {
                _fp._d = i - 1;
            }
            if (_fp._d <= 0) {
                _i _iVar = this._a;
                if (_iVar != null) {
                    _iVar._b();
                }
                _c _cVar_a = _c._a();
                _cVar_a.getClass();
                com.kc.aw.lib.utils._d._b(new _f(_cVar_a));
            }
        }
    }

    public static boolean _a(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName)) {
                int i = runningAppProcessInfo.importance;
                return (i == 100 || i == 200) ? false : true;
            }
        }
        return true;
    }

    public final void _a(Context context, _i _iVar) {
        synchronized (_fp.class) {
            try {
                if (!this._b) {
                    int i = 0;
                    try {
                        Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
                        Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, new Object[0]);
                        Field declaredField = cls.getDeclaredField("mActivities");
                        declaredField.setAccessible(true);
                        Map map = (Map) declaredField.get(objInvoke);
                        if (map != null && map.size() > 0) {
                            i = 1;
                        }
                    } catch (Throwable unused) {
                    }
                    _d = i;
                    Application application = (Application) context.getApplicationContext();
                    _a _aVar = this._a;
                    _aVar._a = _iVar;
                    application.registerActivityLifecycleCallbacks(_aVar);
                }
                this._b = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
