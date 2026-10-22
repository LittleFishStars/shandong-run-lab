package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.innterNative.NativeType;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.ipd.dsp.internal.e1.i;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class MixNativeHandler implements MixNativeAPI, NativeLoadListener {
    private static final WeakHashMap<Class<?>, EnumMap<NativeStyle, EnumMap<NativeType, Method>>> loadMap = new WeakHashMap<>();
    private String appId;
    private NativeType customNativeType;
    private AdParams mAdParams;
    private AdSource mAdSource;
    private WeakReference<Context> mContextRef;
    private NativeLoadListener mListener;
    private String posId;
    private final String TAG = CommConstant.getObjTag(i.g, this);
    private NativeStyle mNativeStyle = NativeStyle.NONE;
    private boolean isCache = false;

    private void handleLoadEvent(Consumer<? super NativeLoadListener> consumer) {
        Optional.ofNullable(this.mListener).ifPresent(consumer);
    }

    private void registerLoadMethod(Class<?> cls) {
        if (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            EnumMap<NativeStyle, EnumMap<NativeType, Method>> enumMap = new EnumMap<>(NativeStyle.class);
            for (Method method : declaredMethods) {
                MixNativeLoad mixNativeLoad = (MixNativeLoad) method.getAnnotation(MixNativeLoad.class);
                if (mixNativeLoad != null) {
                    NativeStyle nativeStyleStyle = mixNativeLoad.style();
                    EnumMap<NativeType, Method> enumMap2 = enumMap.get(nativeStyleStyle);
                    if (enumMap2 == null) {
                        enumMap2 = new EnumMap<>(NativeType.class);
                        enumMap.put(nativeStyleStyle, enumMap2);
                    }
                    enumMap2.put(mixNativeLoad.type(), method);
                }
            }
            loadMap.put(cls, enumMap);
        }
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void clearCache() {
        this.isCache = false;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void destroy() {
        this.mListener = null;
    }

    public AdParams getAdParams() {
        return this.mAdParams;
    }

    public AdSource getAdSource() {
        return this.mAdSource;
    }

    public NativeStyle getAdStyle() {
        if (this.mNativeStyle == NativeStyle.NONE) {
            this.mNativeStyle = NativeStyle.create(this.mAdSource.getAdStyle());
        }
        return this.mNativeStyle;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.mAdSource.app_key;
    }

    public int getBidfloor() {
        return this.mAdSource.bidfloor;
    }

    @Nullable
    public Context getContext() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getExt() {
        return this.mAdSource.getExt();
    }

    public String getKey() {
        return this.mAdParams.getKey();
    }

    public String getPosId() {
        return this.posId;
    }

    public String getSDKBidToken() {
        return this.mAdSource.token;
    }

    public NativeType getType(int i) {
        return null;
    }

    public <T> void handleAd(T t, @Nullable Function<? super T, ? extends NativeAd> function) {
        NativeAd nativeAdApply;
        try {
            if (t == null) {
                LogcatUtil.e(this.TAG, "onLoadFailed, native is empty");
                onLoadFailed(this.TAG + "onLoadFailed, native is empty");
                return;
            }
            if (function == null) {
                LogcatUtil.e(this.TAG, "handleAd success but mapper is null");
                nativeAdApply = null;
            } else {
                nativeAdApply = function.apply(t);
            }
            if (nativeAdApply != null) {
                onNativeAdLoaded(nativeAdApply);
                return;
            }
            LogcatUtil.e(this.TAG, "handleAd success but nativeAd is null");
            onLoadFailed(this.TAG + ",native is empty");
        } catch (Exception e) {
            e.printStackTrace();
            LogcatUtil.e(this.TAG, "onLoadFailed, native load exception");
            onLoadFailed(this.TAG + "onLoadFailed, native load exception");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void handleListAd(List<T> list, Function<? super T, ? extends NativeAd> function) {
        handleAd(Check.findFirstNonNull(list), function);
    }

    public abstract void init();

    public boolean isC2CBidAd() {
        return this.mAdSource.isC2SBidAd;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public boolean isGromore() {
        return this.mAdSource.isGromore();
    }

    public boolean isSDKBidAd() {
        return this.mAdSource.isSDKBidAd;
    }

    public boolean isUseSurfaceView() {
        return this.mAdParams.isUseSurfaceView();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e A[PHI: r0 r2
      0x004e: PHI (r0v6 java.lang.Class<?>) = (r0v5 java.lang.Class<?>), (r0v3 java.lang.Class<?>) binds: [B:17:0x004a, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE]
      0x004e: PHI (r2v6 java.util.EnumMap<com.fl.saas.base.innterNative.NativeStyle, java.util.EnumMap<com.fl.saas.base.innterNative.NativeType, java.lang.reflect.Method>>) = 
      (r2v5 java.util.EnumMap<com.fl.saas.base.innterNative.NativeStyle, java.util.EnumMap<com.fl.saas.base.innterNative.NativeType, java.lang.reflect.Method>>)
      (r2v3 java.util.EnumMap<com.fl.saas.base.innterNative.NativeStyle, java.util.EnumMap<com.fl.saas.base.innterNative.NativeType, java.lang.reflect.Method>>)
     binds: [B:17:0x004a, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0087  */
    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x0109 A[Catch: Exception -> 0x010f, TRY_LEAVE, TryCatch #0 {Exception -> 0x010f, blocks: (B:44:0x00b2, B:46:0x00d9, B:49:0x00dd, B:51:0x00e7, B:53:0x00eb, B:55:0x00f5, B:56:0x0101, B:57:0x0109), top: B:66:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0138  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x006e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x0138, please report this as an issue */
    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void load(Activity activity) {
        String str;
        NativeStyle adStyle;
        EnumMap<NativeType, Method> enumMap;
        EnumMap<NativeType, Method> enumMap2;
        NativeType type;
        Method method;
        Class<?>[] parameterTypes;
        NativeType nativeType;
        NativeStyle nativeStyle;
        LogcatUtil.d(this.TAG, "load:start");
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference == null || weakReference.get() == null) {
            str = "mContext is null";
        } else {
            Class<?> superclass = getClass();
            WeakHashMap<Class<?>, EnumMap<NativeStyle, EnumMap<NativeType, Method>>> weakHashMap = loadMap;
            if (weakHashMap.get(superclass) == null) {
                registerLoadMethod(superclass);
            }
            EnumMap<NativeStyle, EnumMap<NativeType, Method>> enumMap3 = weakHashMap.get(superclass);
            if (enumMap3 == null || enumMap3.isEmpty()) {
                superclass = getClass().getSuperclass();
                registerLoadMethod(superclass);
                enumMap3 = weakHashMap.get(superclass);
                if (enumMap3 == null || enumMap3.isEmpty()) {
                    str = "No method found with MixNativeLoad annotation";
                } else {
                    adStyle = getAdStyle();
                    if (enumMap3.size() == 1) {
                        nativeStyle = NativeStyle.NONE;
                        if (enumMap3.containsKey(nativeStyle)) {
                            enumMap = enumMap3.get(nativeStyle);
                        } else {
                            enumMap = enumMap3.get(adStyle);
                        }
                    } else {
                        enumMap = enumMap3.get(adStyle);
                    }
                    enumMap2 = enumMap;
                    if (enumMap2 == null) {
                        type = this.customNativeType;
                        if (type == null) {
                            type = getType(this.mAdSource.getAdType());
                        }
                        if (type != null || type == (nativeType = NativeType.None) || (enumMap2.size() == 1 && enumMap2.containsKey(nativeType))) {
                            type = NativeType.None;
                        }
                        method = enumMap2.get(type);
                        if (method != null) {
                            onLoadFailed("method is null, class:" + superclass.getName());
                            return;
                        }
                        try {
                            init();
                            method.setAccessible(true);
                            LogcatUtil.d(this.TAG, "load:" + method.getName());
                            parameterTypes = method.getParameterTypes();
                            if (parameterTypes != null || parameterTypes.length == 0) {
                                method.invoke(this, new Object[0]);
                            } else if (Activity.class.isAssignableFrom(parameterTypes[0])) {
                                if (parameterTypes.length == 2 && AdSource.class.isAssignableFrom(parameterTypes[1])) {
                                    method.invoke(this, activity, this.mAdSource);
                                } else {
                                    method.invoke(this, activity);
                                }
                            }
                            return;
                        } catch (Exception e) {
                            onLoadFailed("method invoke exception, class:" + superclass.getName() + "method:" + method.getName());
                            e.printStackTrace();
                            return;
                        }
                    }
                    str = "TypeMap is null, NativeStyle:" + adStyle.name();
                }
            } else {
                adStyle = getAdStyle();
                if (enumMap3.size() == 1) {
                    nativeStyle = NativeStyle.NONE;
                    if (enumMap3.containsKey(nativeStyle)) {
                        enumMap = enumMap3.get(nativeStyle);
                    } else {
                        enumMap = enumMap3.get(adStyle);
                    }
                } else {
                    enumMap = enumMap3.get(adStyle);
                }
                enumMap2 = enumMap;
                if (enumMap2 == null) {
                    type = this.customNativeType;
                    if (type == null) {
                        type = getType(this.mAdSource.getAdType());
                    }
                    if (type != null) {
                        type = NativeType.None;
                    } else {
                        type = NativeType.None;
                    }
                    method = enumMap2.get(type);
                    if (method != null) {
                        onLoadFailed("method is null, class:" + superclass.getName());
                        return;
                    }
                    init();
                    method.setAccessible(true);
                    LogcatUtil.d(this.TAG, "load:" + method.getName());
                    parameterTypes = method.getParameterTypes();
                    if (parameterTypes != null) {
                        method.invoke(this, new Object[0]);
                    } else {
                        method.invoke(this, new Object[0]);
                    }
                    return;
                }
                str = "TypeMap is null, NativeStyle:" + adStyle.name();
            }
        }
        onLoadFailed(str);
    }

    @Override // com.fl.saas.base.interfaces.AdViewListener
    public void onAdFailed(final YdError ydError) {
        LogcatUtil.d(this.TAG, "onAdFailed:" + ydError);
        handleLoadEvent(new Consumer() { // from class: com.zj.adlib.yp5
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((NativeLoadListener) obj).onAdFailed(ydError);
            }
        });
    }

    public void onLoadFailed(String str) {
        LogcatUtil.e(this.TAG, str);
        onAdFailed(YdError.create(20403, str));
    }

    @Override // com.fl.saas.api.mixNative.NativeLoadListener
    public void onNativeAdLoaded(@NonNull final NativeAd nativeAd) {
        LogcatUtil.d(this.TAG, "onNativeAdLoaded");
        handleLoadEvent(new Consumer() { // from class: com.zj.adlib.xp5
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((NativeLoadListener) obj).onNativeAdLoaded(nativeAd);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdId(String str, String str2) {
        this.appId = str;
        this.posId = str2;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdParams(AdParams adParams) {
        this.mAdParams = adParams;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setAdSource(AdSource adSource) {
        this.mAdSource = adSource;
        this.appId = adSource.app_id;
        this.posId = adSource.tagid;
        this.mNativeStyle = NativeStyle.create(adSource.getAdStyle());
        return this;
    }

    public MixNativeHandler setAdStyle(NativeStyle nativeStyle) {
        this.mNativeStyle = nativeStyle;
        return this;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public void setCache() {
        this.isCache = true;
        this.mListener = null;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setContext(Context context) {
        this.mContextRef = new WeakReference<>(context);
        return this;
    }

    public void setCustomNativeType(NativeType nativeType) {
        this.customNativeType = nativeType;
    }

    @Override // com.fl.saas.base.adapter.MixNativeAPI
    public MixNativeAPI setLoadListener(NativeLoadListener nativeLoadListener) {
        this.mListener = nativeLoadListener;
        return this;
    }
}
