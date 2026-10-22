package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.l;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> GJ;
    private List<String> GK;
    private volatile SharedPreferences GL;
    private final Object mLock;

    @KsJson
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public int materialType;
        public String preloadId;
    }

    public static class a {
        private static final SplashPreloadManager GM = new SplashPreloadManager(0);
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    public static File ae(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
        if (fileCO == null || !fileCO.exists()) {
            return null;
        }
        return fileCO;
    }

    @AnyThread
    public static boolean i(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.helper.a.bj(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.GL = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.GL.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(preLoadItem.preloadId);
                            if (fileCO == null || !fileCO.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    try {
                                        this.GJ.put(str, preLoadItem);
                                        if (!this.GK.contains(str)) {
                                            this.GK.add(str);
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor editorEdit = this.GL.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    @AnyThread
    public static boolean j(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.helper.a.bi(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static SplashPreloadManager lZ() {
        SplashPreloadManager splashPreloadManager = a.GM;
        if (splashPreloadManager.GL == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void p(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (((long) adInfo.adPreloadInfo.validityPeriod) * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.helper.a.bf(adInfo);
        preLoadItem.materialType = com.kwad.sdk.core.response.helper.a.bi(adInfo) ? 2 : 1;
        synchronized (this.mLock) {
            this.GJ.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.GK.contains(adInfo.adPreloadInfo.preloadId)) {
                this.GK.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.GL != null) {
            SharedPreferences.Editor editorEdit = this.GL.edit();
            editorEdit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            editorEdit.apply();
        }
    }

    private static boolean q(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Hn) && com.kwad.sdk.core.response.helper.a.bj(adInfo);
    }

    @AnyThread
    private boolean r(AdInfo adInfo) {
        if (q(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.helper.a.ba(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(fileCO == null ? "null" : Boolean.valueOf(fileCO.exists()));
            com.kwad.sdk.core.d.c.d("PreloadManager", sb.toString());
            if (fileCO != null && fileCO.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> W() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.GK.size(); i++) {
                String str = this.GK.get(i);
                File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(str);
                if (fileCO != null && fileCO.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.GK.size());
        return arrayList;
    }

    public final void a(long j, int i) {
        int i2;
        int i3;
        int i4;
        int size;
        char c;
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size2 = this.GK.size();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            i3 = 0;
            i4 = 0;
            for (String str : this.GJ.keySet()) {
                PreLoadItem preLoadItem = this.GJ.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < jCurrentTimeMillis) {
                    arrayList.add(str);
                    int i5 = preLoadItem.materialType;
                    if (i5 == 2) {
                        i3++;
                    } else if (i5 == 1) {
                        i4++;
                    }
                }
            }
            SharedPreferences.Editor editorEdit = this.GL.edit();
            for (String str2 : arrayList) {
                this.GK.remove(str2);
                this.GJ.remove(str2);
                editorEdit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.Lx().remove(str2);
            }
            editorEdit.apply();
            size = this.GK.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i6 = size - 15;
            for (i2 = 0; i2 < i6; i2++) {
                String str3 = "";
                synchronized (this.mLock) {
                    long j2 = Long.MAX_VALUE;
                    for (PreLoadItem preLoadItem2 : this.GJ.values()) {
                        long j3 = preLoadItem2.expiredTime;
                        if (j3 < j2) {
                            str3 = preLoadItem2.preloadId;
                            j2 = j3;
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        c = 2;
                        z = true;
                    } else {
                        PreLoadItem preLoadItem3 = this.GJ.get(str3);
                        if (preLoadItem3 != null) {
                            int i7 = preLoadItem3.materialType;
                            c = 2;
                            if (i7 == 2) {
                                i3++;
                            } else {
                                z = true;
                                if (i7 == 1) {
                                    i4++;
                                }
                            }
                            this.GK.remove(str3);
                            this.GJ.remove(str3);
                            this.GL.edit().remove(str3).apply();
                            com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                        } else {
                            c = 2;
                        }
                        z = true;
                        this.GK.remove(str3);
                        this.GJ.remove(str3);
                        this.GL.edit().remove(str3).apply();
                        com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.Lx().remove(str3);
                }
            }
        }
        int i8 = i3;
        List<String> listMa = ma();
        int size3 = size2 - listMa.size();
        List<Integer> listI = i(listMa);
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.a(j, listMa, listI, i, size3, i4, i8);
    }

    @AnyThread
    public final boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    return q(adInfo) ? KSImageLoader.isImageExist(com.kwad.sdk.core.response.helper.a.ba(adInfo).materialUrl) : r(adInfo);
                }
            }
        }
        return false;
    }

    public final List<String> ma() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean start ");
            arrayList = new ArrayList(this.GK);
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean " + this.GK.size());
        return arrayList;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.GJ = new HashMap<>();
        this.GK = new ArrayList();
        init();
    }

    public final List<Integer> i(List<String> list) {
        PreLoadItem preLoadItem;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList start ");
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (this.GJ.containsKey(str) && (preLoadItem = this.GJ.get(str)) != null) {
                    arrayList.add(Integer.valueOf(preLoadItem.materialType));
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList " + arrayList.size());
        return arrayList;
    }

    @AnyThread
    public final int a(AdResultData adResultData, boolean z, int i) {
        Iterator<AdInfo> it;
        String strM;
        boolean zA;
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.k(adResultData);
        int i2 = 0;
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            if (adTemplate != null) {
                Iterator<AdInfo> it2 = adTemplate.adInfoList.iterator();
                while (it2.hasNext()) {
                    AdInfo next = it2.next();
                    if (next.adPreloadInfo != null && this.GL != null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (!r(next)) {
                            if (com.kwad.sdk.core.response.helper.a.bi(next)) {
                                strM = com.kwad.sdk.core.response.helper.a.M(next);
                            } else {
                                strM = com.kwad.sdk.core.response.helper.a.bj(next) ? com.kwad.sdk.core.response.helper.a.ba(next).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(strM)) {
                                String strBf = com.kwad.sdk.core.response.helper.a.bf(next);
                                if (next.adPreloadInfo.preloadType != 1 || aq.isWifiConnected(ServiceProvider.getContext()) || z) {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + strBf + " true url " + strM);
                                    it = it2;
                                    a(adResultData.getPosId(), 1);
                                    com.kwad.sdk.core.network.a.a.C1286a c1286a = new com.kwad.sdk.core.network.a.a.C1286a();
                                    if (q(next)) {
                                        zA = KSImageLoader.loadImageSync(strM) != null;
                                    } else {
                                        zA = k.a(strM, strBf, c1286a);
                                    }
                                    if (zA) {
                                        p(next);
                                        i2++;
                                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 1, i);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 4, c1286a.msg);
                                        com.kwad.components.core.p.a.vL().g(adTemplate, 1, c1286a.msg);
                                    }
                                } else {
                                    it = it2;
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 1, "networkError");
                                }
                            } else {
                                it = it2;
                                com.kwad.components.ad.splashscreen.monitor.b.mv();
                                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            it = it2;
                            com.kwad.components.ad.splashscreen.monitor.b.mv();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 2, i);
                            p(next);
                            i2++;
                        }
                    } else {
                        it = it2;
                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                    it2 = it;
                }
            }
        }
        AdTemplate adTemplate2 = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i2 > 0) {
            l.at("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.p.a.vL().i(adTemplate2, i2);
        } else {
            l.at("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i2;
    }
}
