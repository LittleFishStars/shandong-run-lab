package com.alibaba.ariver.resource.parser;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceEnviromentProxy;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.parser.a.c;
import com.alibaba.ariver.resource.parser.a.d;
import com.alibaba.ariver.resource.parser.a.f;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class PackageParseUtils {
    private static final String LEGACY_TAR_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2y61svV7Q0gmvxprTt6YX76rps8R+q+C+Qtkkk2+njIABsf10sHnl/5aQBh2s+kdo6YGlJrnKdxVso2JRzy+QbRBUgTdJmKfm5uGPdcqYuO0ur4b/QCyHTMoKJjBT8iI3hYIGhn0hACDao4xIsgzJ39grRKUa6120WbInlOLWSQIDAQAB";
    private static final String NEW_SIGN_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl96KRuzoQDgt3q3478MYKwTGDV0Fz5w+sKOfz+Ar+/XkwqLjVW7bAk+/nOD9Z4mnwM+BsgU/G5KGQ9WMjcXAow/eRBSf93iqcBX5+DdlkbneNyQP7Mvcy8EwOAa3y7AetEpTeYrv5cppFUjq4TVu9w+DwV1qegfvJEAA+6gFJEcJPxD9fxJggCF02tL3k9/WDnaNYVN3dCq8fN4jWZLr6KWlAX5UW5ZVtXP9IWObFnvRNjgXQhW/LzJLdbcDlQ5U6ImFyIFf//vn3vEhzlpU6EkxdGr+FWwsRiMTY9aZ1fJiFlgAZQpInV6cbDM8LgNGPtDsYUibIi3rVFtYtHAxQwIDAQAB";
    public static final String TAG = "AriverRes:PackageParseUtils";
    private static LruCache<String, a> sParsedResult;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f24448a;
        private String b;
        private Map<String, Resource> c;
        private ParseFailedException d;

        public a(boolean z) {
            if (z) {
                this.f24448a = new CountDownLatch(1);
            } else {
                this.f24448a = new CountDownLatch(0);
            }
        }
    }

    static {
        int i = 3;
        try {
            String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_lru_pkg_count", "");
            if (!TextUtils.isEmpty(config) && (i = Integer.parseInt(config)) > 10) {
                i = 10;
            }
        } catch (Throwable unused) {
        }
        sParsedResult = new LruCache<>(i);
    }

    public static void fastReadTarIntoMemory(Map<String, Resource> map, String str, ParseContext parseContext) throws Throwable {
        long jCalculateSize = FileUtils.calculateSize(str);
        Closeable closeable = null;
        if (!IOUtils.isNIOEnabled() || jCalculateSize > 5242880 || jCalculateSize < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            RVLogger.d(TAG, "parse tar file with Stream " + str);
            try {
                f fVar = new f(new BufferedInputStream(new FileInputStream(str)));
                try {
                    readTarStreamIntoMemory(map, fVar, parseContext);
                    IOUtils.closeQuietly(fVar);
                } catch (Throwable th) {
                    th = th;
                    closeable = fVar;
                    IOUtils.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            RVLogger.d(TAG, "parse tar file with NIO " + str);
            byte[] buf = IOUtils.getBuf(2048);
            try {
                d dVar = new d(str);
                while (true) {
                    try {
                        c cVarA = dVar.a();
                        if (cVarA == null) {
                            IOUtils.returnBuf(buf);
                            IOUtils.closeQuietly(dVar);
                            return;
                        }
                        String strB = cVarA.b();
                        if (!cVarA.j() && !TextUtils.isEmpty(strB) && !inBlackList(parseContext, strB)) {
                            PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                            while (true) {
                                int iA = dVar.a(buf);
                                if (iA == -1) {
                                    break;
                                } else {
                                    poolingByteArrayOutputStream.write(buf, 0, iA);
                                }
                            }
                            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                            IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            if (byteArray != null) {
                                putData(map, parseContext, strB, byteArray);
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = dVar;
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private static String getCacheKey(ParseContext parseContext) {
        return !TextUtils.isEmpty(parseContext.templateAppId) ? parseContext.templateAppId : parseContext.packagePath;
    }

    @Nullable
    public static Map<String, Resource> getPreParsedPackage(ParseContext parseContext) {
        a aVar = sParsedResult.get(getCacheKey(parseContext));
        if (aVar != null && TextUtils.equals(parseContext.onlineHost, aVar.b)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                aVar.f24448a.await(5L, TimeUnit.SECONDS);
                RVLogger.w(TAG, "getPreParsedPackage await preParse cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                if (aVar.d != null) {
                    RVLogger.w(TAG, "getPreParsedPackage got exception!" + aVar.d);
                    sParsedResult.remove(getCacheKey(parseContext));
                    throw aVar.d;
                }
                if (aVar.c != null) {
                    boolean z = !TextUtils.equals(parseContext.onlineHost, aVar.b);
                    RVLogger.d(TAG, "getPreParsedPackage got data! size: " + aVar.c.size() + " onlineHostChanged: " + z);
                    if (TextUtils.isEmpty(parseContext.templateAppId) && !z) {
                        return aVar.c;
                    }
                    if (!TextUtils.isEmpty(parseContext.onlineHost)) {
                        RVLogger.d(TAG, "getPreParsedPackage replace vhost " + aVar.b + " to " + parseContext.onlineHost);
                        HashMap map = new HashMap(aVar.c.size());
                        for (Map.Entry entry : aVar.c.entrySet()) {
                            String strReplace = ((String) entry.getKey()).replace(aVar.b, parseContext.onlineHost);
                            map.put(strReplace, new OfflineResource(strReplace, ((Resource) entry.getValue()).getBytes()));
                        }
                        return map;
                    }
                }
                return null;
            } catch (InterruptedException e) {
                RVLogger.w(TAG, "getPreParsedPackage await preParse exception!", e);
            }
        }
        return null;
    }

    private static boolean inBlackList(ParseContext parseContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        List<Pattern> list = parseContext.ignorePatterns;
        if (list != null) {
            Iterator<Pattern> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().matcher(str).matches()) {
                    return true;
                }
            }
        }
        return TextUtils.equals(str, "CERT.json") || TextUtils.equals(str, "SIGN.json") || str.startsWith(RVConstants.PKG_EXT_PREFIX) || str.startsWith(RVConstants.SUB_PACKAGE_DIR_PREFIX) || str.contains("ios") || str.contains("hpmfile.json");
    }

    public static Map<String, Resource> parsePackage(ParseContext parseContext) {
        return parsePackage(parseContext, false);
    }

    public static void preParsePackage(AppModel appModel) {
        RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager == null || !rVResourceManager.isAvailable(appModel)) {
            RVLogger.d(TAG, "skip preParsePackage because not available!");
            return;
        }
        String installPath = ((RVResourceManager) RVProxy.get(RVResourceManager.class)).getInstallPath(appModel);
        ParseContext parseContext = new ParseContext();
        parseContext.packagePath = installPath;
        parseContext.adaptAppModel(appModel);
        preParsePackage(parseContext);
    }

    private static void putData(Map<String, Resource> map, ParseContext parseContext, String str, byte[] bArr) {
        if (!str.startsWith("_animation")) {
            if (!TextUtils.isEmpty(parseContext.onlineHost)) {
                str = FileUtils.combinePath(parseContext.onlineHost, str);
            } else if (str.contains(WVNativeCallbackUtil.SEPERATER)) {
                str = "https://" + str;
            }
        }
        RVLogger.d(TAG, "readTarStreamIntoMemory entryName " + str);
        map.put(str, new OfflineResource(str, bArr));
    }

    public static void readTarStreamIntoMemory(Map<String, Resource> map, f fVar, ParseContext parseContext) {
        byte[] buf = IOUtils.getBuf(2048);
        while (true) {
            try {
                c cVarA = fVar.a();
                if (cVarA == null) {
                    IOUtils.returnBuf(buf);
                    IOUtils.closeQuietly(fVar);
                    return;
                }
                String strB = cVarA.b();
                if (!cVarA.j() && !TextUtils.isEmpty(strB) && !inBlackList(parseContext, strB)) {
                    PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                    while (true) {
                        int i = fVar.read(buf);
                        if (i == -1) {
                            break;
                        } else {
                            poolingByteArrayOutputStream.write(buf, 0, i);
                        }
                    }
                    byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                    IOUtils.closeQuietly(poolingByteArrayOutputStream);
                    if (byteArray != null) {
                        putData(map, parseContext, strB, byteArray);
                    }
                }
            } catch (Throwable th) {
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(fVar);
                throw th;
            }
        }
    }

    private static void verifyPackage(ParseContext parseContext, String str, File[] fileArr) {
        JSONObject object;
        String legacySignPublicKey;
        String strCombinePath = FileUtils.combinePath(str, "CERT.json");
        String strCombinePath2 = FileUtils.combinePath(str, "SIGN.json");
        if (!FileUtils.exists(strCombinePath) && !FileUtils.exists(strCombinePath2)) {
            RVLogger.w(TAG, "cert not exists!");
            throw new ParseFailedException(4, "CERT_PATH_NOT_EXIST");
        }
        boolean zExists = FileUtils.exists(strCombinePath2);
        RVLogger.d(TAG, "useNewSignKey : " + zExists);
        if (zExists) {
            object = JSONUtils.parseObject(IOUtils.read(strCombinePath2));
            legacySignPublicKey = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getNewSignPublicKey();
            if (TextUtils.isEmpty(legacySignPublicKey)) {
                legacySignPublicKey = NEW_SIGN_PUBLIC_KEY;
            }
        } else {
            object = JSONUtils.parseObject(FileUtils.read(strCombinePath));
            legacySignPublicKey = ((RVResourceEnviromentProxy) RVProxy.get(RVResourceEnviromentProxy.class)).getLegacySignPublicKey();
            if (TextUtils.isEmpty(legacySignPublicKey)) {
                legacySignPublicKey = LEGACY_TAR_PUBLIC_KEY;
            }
        }
        if (object == null || object.isEmpty()) {
            RVLogger.e(TAG, "joCert is empty");
            throw new ParseFailedException(5, "TAR_SIGNATURE_IS_EMPTY");
        }
        try {
            for (File file : fileArr) {
                String name = file.getName();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!inBlackList(parseContext, name)) {
                    Object obj = object.get(name);
                    if (obj == null) {
                        throw new ParseFailedException(6, "entry " + name + " has no cert!");
                    }
                    String string = obj.toString();
                    boolean zA = com.alibaba.ariver.resource.parser.a.a(str + WVNativeCallbackUtil.SEPERATER + name, legacySignPublicKey, string);
                    RVLogger.d(TAG, "signKey " + name + " signValue " + string + " result:" + zA + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    if (!zA) {
                        throw new ParseFailedException(6, "VERIFY_FAIL");
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            throw new ParseFailedException(7, e.getMessage());
        }
    }

    public static Map<String, Resource> parsePackage(ParseContext parseContext, boolean z) {
        try {
            RVLogger.d(TAG, "parsePackage with " + parseContext);
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_ContentPackage_parse_ + parseContext.appId);
            if (parseContext.packagePath == null) {
                throw new ParseFailedException(2, "PACKAGE_PATH_NULL");
            }
            if (!z) {
                try {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_ContentPackage_waitPrepare_ + parseContext.appId);
                    Map<String, Resource> preParsedPackage = getPreParsedPackage(parseContext);
                    if (preParsedPackage != null) {
                        parseContext.fromCache = true;
                        RVLogger.d(TAG, "parsePackage hit cache!");
                        RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_waitPrepare_ + parseContext.appId);
                        RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_parse_ + parseContext.appId);
                        return preParsedPackage;
                    }
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_waitPrepare_ + parseContext.appId);
                } catch (Throwable th) {
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_waitPrepare_ + parseContext.appId);
                    throw th;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = parseContext.packagePath;
            if (str == null) {
                throw new ParseFailedException(1, "INVALID_PARAM packagePath is null, appId" + parseContext.appId);
            }
            File file = new File(str);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                RVLogger.e(TAG, "childrenFiles length == 0");
                throw new ParseFailedException(2, "OFFLINE_PATH_NOT_EXIST");
            }
            if (parseContext.needVerify) {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_ContentPackage_verify_ + parseContext.appId);
                verifyPackage(parseContext, str, fileArrListFiles);
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_verify_ + parseContext.appId);
            }
            try {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                RVLogger.d(TAG, "lastModified " + file.lastModified() + " setResult:" + file.setLastModified(jCurrentTimeMillis2) + " newTime:" + jCurrentTimeMillis2 + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis2));
            } catch (Throwable th2) {
                RVLogger.e(TAG, "lastModified exception!", th2);
            }
            String str2 = parseContext.mainFileName;
            if (str2 == null) {
                str2 = parseContext.appId + ".tar";
            }
            String strCombinePath = FileUtils.combinePath(parseContext.packagePath, str2);
            HashMap map = new HashMap();
            try {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_ContentPackage_read_ + parseContext.appId);
                fastReadTarIntoMemory(map, strCombinePath, parseContext);
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_read_ + parseContext.appId);
                if (!z && map.size() > 0 && parseContext.needCache) {
                    a aVar = new a(false);
                    aVar.b = parseContext.onlineHost;
                    aVar.c = map;
                    sParsedResult.put(getCacheKey(parseContext), aVar);
                }
                RVLogger.d(TAG, "parse package " + parseContext.appId + " elapse " + (System.currentTimeMillis() - jCurrentTimeMillis));
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_parse_ + parseContext.appId);
                return map;
            } catch (Throwable th3) {
                try {
                    RVLogger.e(TAG, "readTarStreamIntoMemory exception!", th3);
                    throw new ParseFailedException(7, "readIntoPackageException:" + th3.getMessage());
                } catch (Throwable th4) {
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_read_ + parseContext.appId);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_ContentPackage_parse_ + parseContext.appId);
            throw th5;
        }
    }

    public static void preParsePackage(ParseContext parseContext) {
        if (parseContext == null || TextUtils.isEmpty(parseContext.packagePath)) {
            return;
        }
        RVLogger.w(TAG, "preParsePackage begin for " + parseContext.packagePath);
        if (sParsedResult.get(getCacheKey(parseContext)) != null) {
            RVLogger.w(TAG, "preParsePackage but already contains in cache!");
            return;
        }
        a aVar = new a(true);
        aVar.b = parseContext.onlineHost;
        sParsedResult.put(getCacheKey(parseContext), aVar);
        try {
            Map<String, Resource> map = parsePackage(parseContext, true);
            if (map != null) {
                aVar.c = map;
            }
        } catch (Throwable th) {
            try {
                RVLogger.w(TAG, "preParsePackage exception!", th);
                if (th instanceof ParseFailedException) {
                    aVar.d = th;
                }
            } finally {
                aVar.f24448a.countDown();
            }
        }
    }
}
