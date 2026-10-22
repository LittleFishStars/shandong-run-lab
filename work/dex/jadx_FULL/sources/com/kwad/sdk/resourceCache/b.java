package com.kwad.sdk.resourceCache;

import android.content.Context;
import android.content.SharedPreferences;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.cg;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.wrapper.m;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class b {
    private static volatile SharedPreferences GL;
    private static int bnF;
    private static int bnG;
    private static int bnH;
    public static WarmUpResponse.WarmupVideos warmupVideos = new WarmUpResponse.WarmupVideos();
    public static WarmUpResponse.WarmupImages warmupImages = new WarmUpResponse.WarmupImages();
    public static WarmUpResponse.WarmupZips warmupZips = new WarmUpResponse.WarmupZips();
    private static final Object mLock = new Object();
    private static ConcurrentHashMap<String, WarmUpResponse.ResourceItem> bnE = new ConcurrentHashMap<>();

    public interface a {
    }

    private static void M(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    M(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    public static void N(File file) {
        if (file == null || !file.exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的文件夹不存在: " + file);
            return;
        }
        if (!file.isDirectory()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "指定的路径不是一个文件夹: " + file);
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    N(file2);
                } else if (file2.delete()) {
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "文件已删除: " + file2.getAbsolutePath());
                } else {
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件失败: " + file2.getAbsolutePath());
                }
            }
        }
        if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "文件夹已删除: " + file.getAbsolutePath());
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "删除文件夹失败: " + file.getAbsolutePath());
        }
    }

    private static String P(Context context, String str) {
        String strEH = cg.eH(context);
        if (strEH == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strEH);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("warmup");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    private static void TS() {
        Iterator<String> it = bnE.keySet().iterator();
        while (it.hasNext()) {
            WarmUpResponse.ResourceItem resourceItem = bnE.get(it.next());
            if (resourceItem != null && resourceItem.endTime < System.currentTimeMillis()) {
                hA(resourceItem.cachePath);
                it.remove();
            }
        }
    }

    private static void a(WarmUpResponse.ResourceItem resourceItem) {
        if (resourceItem == null) {
            return;
        }
        if (resourceItem.isZip) {
            M(new File(resourceItem.zipDir));
        } else {
            hA(resourceItem.cachePath);
        }
    }

    public static ArrayList<WarmUpResponse.ResourceItem> b(ArrayList<WarmUpResponse.ResourceItem> arrayList) {
        ArrayList<WarmUpResponse.ResourceItem> arrayList2 = new ArrayList<>(arrayList);
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (mLock) {
            Iterator<WarmUpResponse.ResourceItem> it = arrayList2.iterator();
            while (it.hasNext()) {
                WarmUpResponse.ResourceItem next = it.next();
                if (next != null && bnE.containsKey(next.resourceKey)) {
                    WarmUpResponse.ResourceItem resourceItem = bnE.get(next.resourceKey);
                    if (resourceItem != null) {
                        if (next.endTime < jCurrentTimeMillis) {
                            a(resourceItem);
                            bnE.remove(next.resourceKey);
                            it.remove();
                        } else if (resourceItem.isCached && resourceItem.md5.equals(next.md5)) {
                            resourceItem.endTime = next.endTime;
                            it.remove();
                        } else {
                            a(resourceItem);
                        }
                    }
                } else if (next == null || next.endTime < jCurrentTimeMillis) {
                    it.remove();
                }
            }
        }
        Collections.sort(arrayList2, new Comparator<WarmUpResponse.ResourceItem>() { // from class: com.kwad.sdk.resourceCache.b.3
            private static int a(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return Integer.compare(resourceItem3.priority, resourceItem2.priority);
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(WarmUpResponse.ResourceItem resourceItem2, WarmUpResponse.ResourceItem resourceItem3) {
                return a(resourceItem2, resourceItem3);
            }
        });
        return arrayList2;
    }

    private static void c(WarmUpResponse.ResourceItem resourceItem) {
        new WarmUpResponse.ResourceItem();
        resourceItem.isCached = true;
        synchronized (mLock) {
            bnE.put(resourceItem.resourceKey, resourceItem);
        }
        if (GL != null) {
            SharedPreferences.Editor editorEdit = GL.edit();
            editorEdit.putString(resourceItem.resourceKey, resourceItem.toJson().toString());
            editorEdit.apply();
        }
    }

    public static void cI(Context context) {
        com.kwad.sdk.core.d.c.d("WarmUpManager", "requestWarmUp call");
        GL = context.getSharedPreferences("ksadsdk_warmup_resource", 0);
        initData();
        new l<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.1
            @NonNull
            private static com.kwad.sdk.resourceCache.a TX() {
                return new com.kwad.sdk.resourceCache.a();
            }

            @NonNull
            private static WarmUpResponse hB(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WarmUpResponse warmUpResponse = new WarmUpResponse();
                warmUpResponse.parseJson(jSONObject);
                return warmUpResponse;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ f createRequest() {
                return TX();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return hB(str);
            }
        }.request(new o<com.kwad.sdk.resourceCache.a, WarmUpResponse>() { // from class: com.kwad.sdk.resourceCache.b.2
            private void a(@NonNull final WarmUpResponse warmUpResponse) {
                try {
                    if (warmUpResponse.cleanResourceWarmup) {
                        b.GL.edit().clear().apply();
                        b.bnE.clear();
                        b.N(new File(m.Yb().getExternalCacheDir() + "/com.ksad.warmup/"));
                        b.N(new File(m.Yb().getFilesDir(), "/kds_native/font/"));
                        return;
                    }
                    int unused = b.bnF = warmUpResponse.minWarmupDiskSize;
                    int unused2 = b.bnG = ((int) (b.m(new File(m.Yb().getExternalCacheDir() + "/com.ksad.warmup/")) / 1048576.0d)) + ((int) (b.m(new File(m.Yb().getFilesDir(), "/kds_native/font/")) / 1048576.0d));
                    int unused3 = b.bnH = b.bnF - b.bnG;
                    com.kwad.sdk.core.d.c.d("WarmUpManager", "可用空间上限: " + b.bnF + "MB剩余可用空间: " + b.bnH + "MB本地已使用空间: " + b.bnG + "MB");
                    b(warmUpResponse);
                    i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.b.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            WarmUpResponse warmUpResponse2 = warmUpResponse;
                            if (!warmUpResponse2.disableZipWarmup) {
                                WarmUpResponse.WarmupZips warmupZips2 = warmUpResponse2.warmupZips;
                                b.warmupZips = warmupZips2;
                                b.a(b.b(warmupZips2.zips), 3, null);
                            }
                            WarmUpResponse warmUpResponse3 = warmUpResponse;
                            if (!warmUpResponse3.disableFontWarmup) {
                                WarmUpResponse.WarmupZips warmupZips3 = warmUpResponse3.warmupZips;
                                b.warmupZips = warmupZips3;
                                b.a(b.b(warmupZips3.fontZips), 4, null);
                            }
                            WarmUpResponse warmUpResponse4 = warmUpResponse;
                            if (!warmUpResponse4.disableImageWarmup) {
                                WarmUpResponse.WarmupImages warmupImages2 = warmUpResponse4.warmupImages;
                                b.warmupImages = warmupImages2;
                                b.a(b.b(warmupImages2.images), 2, null);
                            }
                            WarmUpResponse warmUpResponse5 = warmUpResponse;
                            if (!warmUpResponse5.disableVideoWarmup) {
                                WarmUpResponse.WarmupVideos warmupVideos2 = warmUpResponse5.warmupVideos;
                                b.warmupVideos = warmupVideos2;
                                b.a(b.b(warmupVideos2.videos), 1, null);
                            }
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "checklist: " + b.bnE.size() + b.warmupZips.zips.size() + b.warmupImages.images.size() + b.warmupVideos.videos.size());
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            private static void b(WarmUpResponse warmUpResponse) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(warmUpResponse.warmupZips.zips);
                arrayList.addAll(warmUpResponse.warmupZips.fontZips);
                arrayList.addAll(warmUpResponse.warmupImages.images);
                arrayList.addAll(warmUpResponse.warmupVideos.videos);
                b.bnE.values();
                c.a(arrayList, new ArrayList(b.bnE.values()), b.bnH);
                arrayList.clear();
            }

            private static void hC(String str) {
                com.kwad.sdk.core.d.c.d("WarmUpManager", "onError: " + str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                hC(str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((WarmUpResponse) baseResultData);
            }
        });
    }

    public static /* synthetic */ int fT(int i) {
        int i2 = bnH - i;
        bnH = i2;
        return i2;
    }

    private static void hA(String str) {
        com.kwad.sdk.core.d.c.d("WarmUpManager", "deleteCacheFile call " + str);
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file does not exist: " + str);
        } else if (file.delete()) {
            com.kwad.sdk.core.d.c.d("WarmUpManager", "Cache file deleted: " + str);
        } else {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "Failed to delete cache file: " + str);
        }
    }

    private static void initData() {
        Map<String, ?> all = GL.getAll();
        ArrayList arrayList = new ArrayList();
        if (all == null || all.isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            WarmUpResponse.ResourceItem resourceItem = new WarmUpResponse.ResourceItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        resourceItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(resourceItem.resourceKey) && !TextUtils.isEmpty(resourceItem.cachePath)) {
                            if ((resourceItem.isZip ? new File(resourceItem.zipDir) : new File(resourceItem.cachePath)).exists()) {
                                synchronized (mLock) {
                                    try {
                                        bnE.put(str, resourceItem);
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            } else {
                                arrayList.add(resourceItem.resourceKey);
                                com.kwad.sdk.core.d.c.d("WarmUpManager", "Remove null file list " + resourceItem.resourceKey);
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
        SharedPreferences.Editor editorEdit = GL.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    public static long m(File file) {
        long jM;
        long j = 0;
        if (file == null) {
            return 0L;
        }
        if (!file.isDirectory()) {
            if (file.isFile()) {
                return file.length();
            }
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                jM = file2.length();
            } else {
                if (file2.isDirectory()) {
                    jM = m(file2);
                }
            }
            j += jM;
        }
        return j;
    }

    @AnyThread
    public static int a(List<WarmUpResponse.ResourceItem> list, int i, a aVar) {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i2 = 0;
        for (WarmUpResponse.ResourceItem resourceItem : list) {
            if (resourceItem != null) {
                String str = resourceItem.url;
                if (bnH >= resourceItem.downloadSize && !TextUtils.isEmpty(resourceItem.md5) && !TextUtils.isEmpty(str)) {
                    boolean zIsWifiConnected = aq.isWifiConnected(ServiceProvider.getContext());
                    boolean z = true;
                    if ((i == 1 && warmupVideos.wifiOnly && !zIsWifiConnected) || ((i == 3 || i == 4) && warmupZips.wifiOnly && !zIsWifiConnected)) {
                        z = false;
                    }
                    if (z) {
                        File fileA = a(i, resourceItem);
                        try {
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件开始 " + fileA);
                            c.b(resourceItem, i);
                            if (com.kwad.sdk.core.download.a.a(str, fileA, new com.kwad.sdk.core.download.a.InterfaceC1279a() { // from class: com.kwad.sdk.resourceCache.b.4
                                @Override // com.kwad.sdk.core.download.a.InterfaceC1279a
                                public final void A(int i3, int i4) {
                                    com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件下载中 " + i3 + " " + i4);
                                }

                                @Override // com.kwad.sdk.core.download.a.InterfaceC1279a
                                public final boolean B(int i3, int i4) {
                                    com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件开始下载 " + i3 + " " + i4);
                                    int i5 = i4 / 1048576;
                                    if (i5 <= b.bnH) {
                                        return true;
                                    }
                                    com.kwad.sdk.core.d.c.d("WarmUpManager", "磁盘空间不足! 需要至少 " + i5 + " MB 当前可用空间: " + b.bnH + " MB");
                                    return false;
                                }

                                @Override // com.kwad.sdk.core.download.a.InterfaceC1279a
                                public final void C(int i3, int i4) {
                                    com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件下载完成 " + i3 + " " + i4);
                                    b.fT(i4 / 1048576);
                                }
                            }, false)) {
                                com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件已下载 " + fileA);
                                if (!TextUtils.equals(an.getFileMD5Digest(fileA), resourceItem.md5)) {
                                    com.kwad.sdk.core.d.c.d("WarmUpManager", "save: md5校验失败 " + fileA);
                                    c.c(resourceItem, i);
                                    hA(fileA.getAbsolutePath());
                                } else {
                                    c.d(resourceItem, i);
                                    c(resourceItem);
                                }
                            }
                            TS();
                        } catch (IOException e) {
                            com.kwad.sdk.core.d.c.d("WarmUpManager", "save: 文件失败 ");
                            c.a(resourceItem, i, 0, e.getMessage());
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                        i2++;
                    }
                }
            }
        }
        if (i == 3) {
            try {
                for (WarmUpResponse.ResourceItem resourceItem2 : warmupZips.zips) {
                    a(resourceItem2, i);
                    hA(resourceItem2.cachePath);
                }
            } catch (IOException e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        } else if (i == 4) {
            try {
                for (WarmUpResponse.ResourceItem resourceItem3 : warmupZips.fontZips) {
                    a(resourceItem3, i);
                    hA(resourceItem3.cachePath);
                }
            } catch (IOException e3) {
                com.kwad.sdk.core.d.c.printStackTrace(e3);
            }
        }
        return i2;
    }

    private static String b(WarmUpResponse.ResourceItem resourceItem) {
        if (resourceItem != null && !TextUtils.isEmpty(resourceItem.url)) {
            String str = resourceItem.url;
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf != -1 && iLastIndexOf < str.length() - 1) {
                return str.substring(iLastIndexOf);
            }
            com.kwad.sdk.core.d.c.d("WarmUpManager", "No file extension found in URL: " + str);
            return null;
        }
        com.kwad.sdk.core.d.c.d("WarmUpManager", "warmupItem or url is null");
        return null;
    }

    private static File a(int i, WarmUpResponse.ResourceItem resourceItem) {
        File file;
        String str;
        if (i == 4) {
            file = new File(m.Yb().getFilesDir(), "/kds_native/font/");
        } else {
            file = new File(m.Yb().getExternalCacheDir(), "/com.ksad.warmup/");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (i == 1) {
            str = "video/";
        } else if (i != 2) {
            str = i != 3 ? "" : "zip/";
        } else {
            str = "image/";
        }
        String strB = b(resourceItem);
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, resourceItem.resourceKey + strB);
        if (!file3.exists()) {
            try {
                File parentFile = file3.getParentFile();
                Objects.requireNonNull(parentFile);
                if (!parentFile.exists()) {
                    file3.getParentFile().mkdirs();
                }
                file3.createNewFile();
            } catch (IOException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (i == 3 || i == 4) {
            resourceItem.isZip = true;
            resourceItem.zipDir = file2.getAbsolutePath() + WVNativeCallbackUtil.SEPERATER + resourceItem.resourceKey;
        }
        resourceItem.cachePath = file3.getAbsolutePath();
        return file3;
    }

    private static void a(WarmUpResponse.ResourceItem resourceItem, int i) {
        if (resourceItem == null) {
            return;
        }
        String str = resourceItem.resourceKey;
        if (!str.matches("[a-zA-Z0-9_-]+")) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "Invalid zipname: " + str);
            return;
        }
        String str2 = m.Yb().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str + ".zip";
        String str3 = m.Yb().getExternalCacheDir() + "/com.ksad.warmup/zip/" + str;
        if (i == 4) {
            str2 = m.Yb().getFilesDir() + "/kds_native/font/" + str + ".zip";
            str3 = m.Yb().getFilesDir() + "/kds_native/font/" + str;
        }
        if (!new File(str2).exists()) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "File does not exist: " + str2);
            return;
        }
        String strP = P(m.Yb(), str);
        if (strP == null) {
            return;
        }
        File file = new File(strP);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str2));
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                while (nextEntry != null) {
                    if (!nextEntry.getName().startsWith("__MACOSX/") && !nextEntry.getName().startsWith("._")) {
                        String str4 = strP + File.separator + nextEntry.getName();
                        String name = nextEntry.getName();
                        if (!nextEntry.isDirectory()) {
                            String str5 = "";
                            try {
                                HashMap<String, String> map = resourceItem.md5FileMap;
                                if (map != null && map.containsKey(name)) {
                                    str5 = resourceItem.md5FileMap.get(name);
                                }
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                            }
                            a(zipInputStream, str4, str5, resourceItem, i, name);
                        } else {
                            new File(str4).mkdir();
                        }
                        zipInputStream.closeEntry();
                        com.kwad.sdk.core.d.c.d("WarmUpManager", "unzip: 文件已解压 " + str4);
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    }
                }
                u.e(file, new File(str3));
                zipInputStream.close();
            } catch (Throwable th2) {
                try {
                    zipInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (FileNotFoundException e) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: FileNotFoundException: " + e.getMessage());
        } catch (IOException e2) {
            com.kwad.sdk.core.d.c.e("WarmUpManager", "unzip: IOException: " + e2.getMessage());
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    private static void a(ZipInputStream zipInputStream, String str, String str2, @NonNull WarmUpResponse.ResourceItem resourceItem, int i, String str3) throws Throwable {
        StringBuilder sb;
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 != -1) {
                            fileOutputStream2.write(bArr, 0, i2);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e = e;
                                com.kwad.sdk.core.d.c.printStackTrace(e);
                                sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                                sb.append(e.getMessage());
                                com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                            }
                        }
                    }
                    fileOutputStream2.close();
                } catch (EOFException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: EOFException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            sb.append(e.getMessage());
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: IOException: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e = e5;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            sb = new StringBuilder("extractFile: FileOutputStream close error: ");
                            sb.append(e.getMessage());
                            com.kwad.sdk.core.d.c.e("WarmUpManager", sb.toString());
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            com.kwad.sdk.core.d.c.printStackTrace(e6);
                            com.kwad.sdk.core.d.c.e("WarmUpManager", "extractFile: FileOutputStream close error: " + e6.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (EOFException e7) {
            e = e7;
        } catch (IOException e8) {
            e = e8;
        }
        if (file.exists() && !TextUtils.isEmpty(str2)) {
            if (!TextUtils.equals(an.getFileMD5Digest(file), str2)) {
                file.delete();
                c.a(resourceItem, i, str2, 1);
                return;
            } else {
                c.a(resourceItem, i, str2);
                return;
            }
        }
        if (file.exists()) {
            return;
        }
        c.a(resourceItem, i, str2, 2);
    }
}
