package com.alibaba.android.arouter.core;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.ClassUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.android.arouter.utils.MapUtils;
import com.alibaba.android.arouter.utils.PackageUtils;
import com.alibaba.android.arouter.utils.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogisticsCenter {
    static ThreadPoolExecutor executor;
    private static Context mContext;
    private static boolean registerByPlugin;

    /* JADX INFO: renamed from: com.alibaba.android.arouter.core.LogisticsCenter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType;

        static {
            int[] iArr = new int[RouteType.values().length];
            $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void addRouteGroupDynamic(String str, IRouteGroup iRouteGroup) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (Warehouse.groupsIndex.containsKey(str)) {
            Warehouse.groupsIndex.get(str).getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(Warehouse.routes);
            Warehouse.groupsIndex.remove(str);
        }
        if (iRouteGroup != null) {
            iRouteGroup.loadInto(Warehouse.routes);
        }
    }

    public static Postcard buildProvider(String str) {
        RouteMeta routeMeta = Warehouse.providersIndex.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void completion(Postcard postcard) {
        if (postcard == null) {
            throw new NoRouteFoundException("ARouter::No postcard!");
        }
        RouteMeta routeMeta = Warehouse.routes.get(postcard.getPath());
        if (routeMeta != null) {
            postcard.setDestination(routeMeta.getDestination());
            postcard.setType(routeMeta.getType());
            postcard.setPriority(routeMeta.getPriority());
            postcard.setExtra(routeMeta.getExtra());
            Uri uri = postcard.getUri();
            if (uri != null) {
                Map<String, String> mapSplitQueryParameters = TextUtils.splitQueryParameters(uri);
                Map<String, Integer> paramsType = routeMeta.getParamsType();
                if (MapUtils.isNotEmpty(paramsType)) {
                    for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                        setValue(postcard, entry.getValue(), entry.getKey(), mapSplitQueryParameters.get(entry.getKey()));
                    }
                    postcard.getExtras().putStringArray(ARouter.AUTO_INJECT, (String[]) paramsType.keySet().toArray(new String[0]));
                }
                postcard.withString(ARouter.RAW_URI, uri.toString());
            }
            int i = AnonymousClass1.$SwitchMap$com$alibaba$android$arouter$facade$enums$RouteType[routeMeta.getType().ordinal()];
            if (i == 1) {
                Class<?> destination = routeMeta.getDestination();
                IProvider iProvider = Warehouse.providers.get(destination);
                if (iProvider == null) {
                    try {
                        iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iProvider.init(mContext);
                        Warehouse.providers.put(destination, iProvider);
                    } catch (Exception e) {
                        ARouter.logger.error("ARouter::", "Init provider failed!", e);
                        throw new HandlerException("Init provider failed!");
                    }
                }
                postcard.setProvider(iProvider);
                postcard.greenChannel();
            } else if (i == 2) {
                postcard.greenChannel();
            }
        } else {
            if (!Warehouse.groupsIndex.containsKey(postcard.getGroup())) {
                throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
            }
            try {
                if (ARouter.debuggable()) {
                    ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                addRouteGroupDynamic(postcard.getGroup(), null);
                if (ARouter.debuggable()) {
                    ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                completion(postcard);
            } catch (Exception e2) {
                throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e2.getMessage() + "]");
            }
        }
    }

    public static synchronized void init(Context context, ThreadPoolExecutor threadPoolExecutor) throws HandlerException {
        Set<String> fileNameByPackageName;
        mContext = context;
        executor = threadPoolExecutor;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            loadRouterMap();
            if (registerByPlugin) {
                ARouter.logger.info("ARouter::", "Load router map by arouter-auto-register plugin.");
            } else {
                if (ARouter.debuggable() || PackageUtils.isNewVersion(context)) {
                    ARouter.logger.info("ARouter::", "Run with debug mode or new install, rebuild router map.");
                    fileNameByPackageName = ClassUtils.getFileNameByPackageName(mContext, Consts.ROUTE_ROOT_PAKCAGE);
                    if (!fileNameByPackageName.isEmpty()) {
                        context.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).edit().putStringSet(Consts.AROUTER_SP_KEY_MAP, fileNameByPackageName).apply();
                    }
                    PackageUtils.updateVersion(context);
                } else {
                    ARouter.logger.info("ARouter::", "Load router map from cache.");
                    fileNameByPackageName = new HashSet<>(context.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).getStringSet(Consts.AROUTER_SP_KEY_MAP, new HashSet()));
                }
                ARouter.logger.info("ARouter::", "Find router map finished, map size = " + fileNameByPackageName.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : fileNameByPackageName) {
                    if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                        ((IRouteRoot) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(Warehouse.groupsIndex);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                        ((IInterceptorGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(Warehouse.interceptorsIndex);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                        ((IProviderGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(Warehouse.providersIndex);
                    }
                }
            }
            ARouter.logger.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
            if (Warehouse.groupsIndex.size() == 0) {
                ARouter.logger.error("ARouter::", "No mapping files were found, check your configuration please!");
            }
            if (ARouter.debuggable()) {
                ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(Warehouse.groupsIndex.size()), Integer.valueOf(Warehouse.interceptorsIndex.size()), Integer.valueOf(Warehouse.providersIndex.size())));
            }
        } catch (Exception e) {
            throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e.getMessage() + "]");
        }
    }

    private static void loadRouterMap() {
        registerByPlugin = false;
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$arouterapi");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$home");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$compat");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$sport");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$run");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$mall");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$works");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$social_contact");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$login");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$channel");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$mine");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$college");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$IM");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$base");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$common");
        register("com.alibaba.android.arouter.routes.ARouter$$Root$$app");
        register("com.alibaba.android.arouter.routes.ARouter$$Interceptors$$works");
        register("com.alibaba.android.arouter.routes.ARouter$$Interceptors$$channel");
        register("com.alibaba.android.arouter.routes.ARouter$$Interceptors$$mine");
        register("com.alibaba.android.arouter.routes.ARouter$$Interceptors$$common");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$arouterapi");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$home");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$compat");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$sport");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$run");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$mall");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$works");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$social_contact");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$login");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$channel");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$mine");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$college");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$IM");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$base");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$common");
        register("com.alibaba.android.arouter.routes.ARouter$$Providers$$app");
    }

    private static void markRegisteredByPlugin() {
        if (registerByPlugin) {
            return;
        }
        registerByPlugin = true;
    }

    private static void register(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IRouteRoot) {
                registerRouteRoot((IRouteRoot) objNewInstance);
            } else if (objNewInstance instanceof IProviderGroup) {
                registerProvider((IProviderGroup) objNewInstance);
            } else if (objNewInstance instanceof IInterceptorGroup) {
                registerInterceptor((IInterceptorGroup) objNewInstance);
            } else {
                ARouter.logger.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
            }
        } catch (Exception e) {
            ARouter.logger.error("ARouter::", "register class error:" + str, e);
        }
    }

    private static void registerInterceptor(IInterceptorGroup iInterceptorGroup) {
        markRegisteredByPlugin();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(Warehouse.interceptorsIndex);
        }
    }

    private static void registerProvider(IProviderGroup iProviderGroup) {
        markRegisteredByPlugin();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(Warehouse.providersIndex);
        }
    }

    private static void registerRouteRoot(IRouteRoot iRouteRoot) {
        markRegisteredByPlugin();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(Warehouse.groupsIndex);
        }
    }

    private static void setValue(Postcard postcard, Integer num, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th) {
            ARouter.logger.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
        }
    }

    public static void suspend() {
        Warehouse.clear();
    }
}
