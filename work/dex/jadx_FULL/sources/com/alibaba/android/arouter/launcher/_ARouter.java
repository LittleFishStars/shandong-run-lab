package com.alibaba.android.arouter.launcher;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.core.InstrumentationHook;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.thread.DefaultPoolExecutor;
import com.alibaba.android.arouter.utils.DefaultLogger;
import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
final class _ARouter {
    private static InterceptorService interceptorService;
    private static Context mContext;
    private static Handler mHandler;
    static ILogger logger = new DefaultLogger("ARouter::");
    private static volatile boolean monitorMode = false;
    private static volatile boolean debuggable = false;
    private static volatile boolean autoInject = false;
    private static volatile _ARouter instance = null;
    private static volatile boolean hasInit = false;
    private static volatile ThreadPoolExecutor executor = DefaultPoolExecutor.getInstance();

    /* JADX INFO: renamed from: com.alibaba.android.arouter.launcher._ARouter$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType;

        static {
            int[] iArr = new int[RouteType.values().length];
            $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private _ARouter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object _navigation(final Postcard postcard, final int i, final NavigationCallback navigationCallback) {
        final Context context = postcard.getContext();
        int i2 = AnonymousClass4.$SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[postcard.getType().ordinal()];
        if (i2 == 1) {
            final Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            runInMainThread(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.3
                @Override // java.lang.Runnable
                public void run() {
                    _ARouter.this.startActivity(i, context, intent, postcard, navigationCallback);
                }
            });
            return null;
        }
        if (i2 == 2) {
            return postcard.getProvider();
        }
        if (i2 == 3 || i2 == 4 || i2 == 5) {
            try {
                Object objNewInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof Fragment) {
                    ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                } else if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) objNewInstance).setArguments(postcard.getExtras());
                }
                return objNewInstance;
            } catch (Exception e) {
                logger.error("ARouter::", "Fetch fragment instance error, " + TextUtils.formatStackTrace(e.getStackTrace()));
            }
        }
        return null;
    }

    public static void afterInit() {
        interceptorService = (InterceptorService) ARouter.getInstance().build("/arouter/service/interceptor").navigation();
    }

    @Deprecated
    public static void attachBaseContext() {
        Log.i("ARouter::", "ARouter start attachBaseContext");
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(objInvoke, new InstrumentationHook());
            Log.i("ARouter::", "ARouter hook instrumentation success!");
        } catch (Exception e) {
            Log.e("ARouter::", "ARouter hook instrumentation failed! [" + e.getMessage() + "]");
        }
    }

    @Deprecated
    public static boolean canAutoInject() {
        return autoInject;
    }

    public static boolean debuggable() {
        return debuggable;
    }

    public static synchronized void destroy() {
        if (debuggable()) {
            hasInit = false;
            LogisticsCenter.suspend();
            logger.info("ARouter::", "ARouter destroy success!");
        } else {
            logger.error("ARouter::", "Destroy can be used in debug mode only!");
        }
    }

    @Deprecated
    public static synchronized void enableAutoInject() {
        autoInject = true;
    }

    private String extractGroup(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf(WVNativeCallbackUtil.SEPERATER, 1));
            if (TextUtils.isEmpty(strSubstring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e) {
            logger.warning("ARouter::", "Failed to extract default group! " + e.getMessage());
            return null;
        }
    }

    public static _ARouter getInstance() {
        if (!hasInit) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (instance == null) {
            synchronized (_ARouter.class) {
                if (instance == null) {
                    instance = new _ARouter();
                }
            }
        }
        return instance;
    }

    public static synchronized boolean init(Application application) {
        mContext = application;
        LogisticsCenter.init(application, executor);
        logger.info("ARouter::", "ARouter init success!");
        hasInit = true;
        mHandler = new Handler(Looper.getMainLooper());
        return true;
    }

    public static void inject(Object obj) {
        AutowiredService autowiredService = (AutowiredService) ARouter.getInstance().build("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static boolean isMonitorMode() {
        return monitorMode;
    }

    public static synchronized void monitorMode() {
        monitorMode = true;
        logger.info("ARouter::", "ARouter monitorMode on");
    }

    public static synchronized void openDebug() {
        debuggable = true;
        logger.info("ARouter::", "ARouter openDebug");
    }

    public static synchronized void openLog() {
        logger.showLog(true);
        logger.info("ARouter::", "ARouter openLog");
    }

    public static synchronized void printStackTrace() {
        logger.showStackTrace(true);
        logger.info("ARouter::", "ARouter printStackTrace");
    }

    private void runInMainThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static synchronized void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        executor = threadPoolExecutor;
    }

    public static void setLogger(ILogger iLogger) {
        if (iLogger != null) {
            logger = iLogger;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivity(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i, postcard.getOptionsBundle());
        } else {
            logger.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    public boolean addRouteGroup(IRouteGroup iRouteGroup) {
        if (iRouteGroup == null) {
            return false;
        }
        try {
            HashMap map = new HashMap();
            iRouteGroup.loadInto(map);
            String str = null;
            for (Map.Entry<String, RouteMeta> entry : map.entrySet()) {
                String strExtractGroup = extractGroup(entry.getKey());
                RouteMeta value = entry.getValue();
                if (str == null) {
                    str = strExtractGroup;
                }
                if (str == null || !str.equals(strExtractGroup) || !str.equals(value.getGroup())) {
                    return false;
                }
            }
            LogisticsCenter.addRouteGroupDynamic(str, iRouteGroup);
            logger.info("ARouter::", "Add route group [" + str + "] finish, " + map.size() + " new route meta.");
            return true;
        } catch (Exception e) {
            logger.error("ARouter::", "Add route group dynamic exception!", e);
            return false;
        }
    }

    public Postcard build(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return build(str, extractGroup(str), Boolean.TRUE);
    }

    public <T> T navigation(Class<? extends T> cls) {
        try {
            Postcard postcardBuildProvider = LogisticsCenter.buildProvider(cls.getName());
            if (postcardBuildProvider == null) {
                postcardBuildProvider = LogisticsCenter.buildProvider(cls.getSimpleName());
            }
            if (postcardBuildProvider == null) {
                return null;
            }
            postcardBuildProvider.setContext(mContext);
            LogisticsCenter.completion(postcardBuildProvider);
            return (T) postcardBuildProvider.getProvider();
        } catch (NoRouteFoundException e) {
            logger.warning("ARouter::", e.getMessage());
            return null;
        }
    }

    public Postcard build(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.toString())) {
            PathReplaceService pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class);
            if (pathReplaceService != null) {
                uri = pathReplaceService.forUri(uri);
            }
            return new Postcard(uri.getPath(), extractGroup(uri.getPath()), uri, null);
        }
        throw new HandlerException("ARouter::Parameter invalid!");
    }

    public Object navigation(Context context, final Postcard postcard, final int i, final NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) ARouter.getInstance().navigation(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? mContext : context);
        try {
            LogisticsCenter.completion(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (!postcard.isGreenChannel()) {
                interceptorService.doInterceptions(postcard, new InterceptorCallback() { // from class: com.alibaba.android.arouter.launcher._ARouter.2
                    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                    public void onContinue(Postcard postcard2) {
                        _ARouter.this._navigation(postcard2, i, navigationCallback);
                    }

                    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                    public void onInterrupt(Throwable th) {
                        NavigationCallback navigationCallback2 = navigationCallback;
                        if (navigationCallback2 != null) {
                            navigationCallback2.onInterrupt(postcard);
                        }
                        _ARouter.logger.info("ARouter::", "Navigation failed, termination by interceptor : " + th.getMessage());
                    }
                });
                return null;
            }
            return _navigation(postcard, i, navigationCallback);
        } catch (NoRouteFoundException e) {
            logger.warning("ARouter::", e.getMessage());
            if (debuggable()) {
                runInMainThread(new Runnable() { // from class: com.alibaba.android.arouter.launcher._ARouter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(_ARouter.mContext, "There's no route matched!\n Path = [" + postcard.getPath() + "]\n Group = [" + postcard.getGroup() + "]", 1).show();
                    }
                });
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) ARouter.getInstance().navigation(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public Postcard build(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class)) != null) {
                str = pathReplaceService.forString(str);
            }
            return new Postcard(str, str2);
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }
}
