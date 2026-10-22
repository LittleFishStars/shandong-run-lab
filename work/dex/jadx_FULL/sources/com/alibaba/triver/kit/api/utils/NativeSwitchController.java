package com.alibaba.triver.kit.api.utils;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativeSwitchController {
    public static final String ALL_OPTIMIZATION = "debug.tb.allOptimization";
    public static final String DATA_PRELOAD = "debug.tb.dataPreload";
    public static final String ENABLE_NSR_PRELOAD = "debug.tb.nsrPreload";
    public static final String JSI_WORKER = "debug.tb.jsiWorker";
    public static final String PREFETCH_JS_EXE = "debug.tb.prefetchJsExecute";
    public static final String PRE_EXE_INDEX_JS = "debug.tb.preExeIndexJs";
    public static final String RELEASE_FORCE_LOG_ERROR = "debug.tb.releaseLogError";
    public static final String RENDER_PRELOAD = "debug.tb.renderPreload";
    public static final String RENDER_TEMPLATE_SNAPSHOT_IN_RENDER_ENABLE = "debug.tb.trsire";
    public static final String RENDER_TEMPLATE_SNAPSHOT_POST = "debug.tb.rtsp";
    public static final String SHOP_WORKER = "debug.tb.swPreload";
    public static final String SHOP_WORKER_PLUGIN = "debug.tb.swPreloadPL";
    public static final String TB_VIDEO = "debug.tb.tbVideo";
    public static final String WORKER_CODE_PRELOAD = "debug.tb.workerCodePreload";
    public static final String WORKER_PRELOAD = "debug.tb.workerPreload";
    public static final String ENABLE_NATIVE_SWITCH = "debug.tb.nativeSwitch";
    public static boolean ENABLE_NATIVE = SystemProperties.getBooleanValue(ENABLE_NATIVE_SWITCH, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);

    public static boolean enableAllPerformanceOptimization() {
        return readConfigByKey(ALL_OPTIMIZATION, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableForceReleaseErrorLog() {
        return SystemProperties.getBooleanValue(RELEASE_FORCE_LOG_ERROR, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableIndexJsPreExecute() {
        return readConfigByKey(PRE_EXE_INDEX_JS, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableJSIWorker() {
        return enableAllPerformanceOptimization() || readConfigByKey(JSI_WORKER, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableNSRPreload() {
        return readConfigByKey(ENABLE_NSR_PRELOAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enablePrefetchJs() {
        return enableAllPerformanceOptimization() || readConfigByKey(PREFETCH_JS_EXE, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableRenderPreload() {
        return enableAllPerformanceOptimization() || readConfigByKey(RENDER_PRELOAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableRenderTemplateSnapshoPost() {
        return readConfigByKey(RENDER_TEMPLATE_SNAPSHOT_POST, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableRenderTemplateSnapshotInRender() {
        return readConfigByKey(RENDER_TEMPLATE_SNAPSHOT_IN_RENDER_ENABLE, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableShopWorkerPreload() {
        return enableAllPerformanceOptimization() || readConfigByKey(SHOP_WORKER, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableShopWorkerPreloadOfficialPlugin() {
        return enableAllPerformanceOptimization() || readConfigByKey(SHOP_WORKER_PLUGIN, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableStaticDataPreload() {
        return enableAllPerformanceOptimization() || readConfigByKey(DATA_PRELOAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableTBVideo() {
        return readConfigByKey(TB_VIDEO, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableWorkerCodePreload() {
        return enableAllPerformanceOptimization() || readConfigByKey(WORKER_CODE_PRELOAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean enableWorkerPreload() {
        return enableAllPerformanceOptimization() || readConfigByKey(WORKER_PRELOAD, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean isEnableNative() {
        return ENABLE_NATIVE;
    }

    public static boolean readConfigByKey(String str, String str2) {
        if (ENABLE_NATIVE) {
            return SystemProperties.getBooleanValue(str, str2);
        }
        return false;
    }
}
