package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderNotifyInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class DataLoaderHelper implements AVMDLDataLoaderListener, AVMDLStartCompleteListener {
    public static final int DATALOADER_KEY_ENABLE_ALOG = 512;
    public static final int DATALOADER_KEY_INT_MAXCACHESIZE = 1;
    public static final int DATALOADER_KEY_INT_OPENTIMEOUT = 3;
    public static final int DATALOADER_KEY_INT_PARALLEL_NUM = 11;
    public static final int DATALOADER_KEY_INT_RWTIMEOUT = 2;
    public static final int DATALOADER_KEY_INT_TRYCOUNT = 4;
    public static final int DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE = 1005;
    public static final int DATALOADER_KEY_STRING_CACHEDIR = 0;
    public static final int IsClose = 1;
    public static final int IsPlayTask = 1;
    public static final int IsPreloadTask = 2;
    public static final int IsStart = 0;
    public static final int IsUnknown = 0;
    public static final String MDL_PREFIX = "mdl://";
    private static final DataLoaderHelper p = new DataLoaderHelper();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private final d b;
    private final d c;
    private final d d;
    private final d e;
    private AVMDLDataLoader i;
    private VideoEventEngineUploader k;
    private boolean m;
    private final ConcurrentHashMap<String, c> f = new ConcurrentHashMap<>();
    private final HashMap<String, ArrayList<TTVideoEngine>> g = new HashMap<>();
    private final ReentrantLock h = new ReentrantLock();
    private boolean l = true;
    private int n = 0;
    private final ReentrantLock o = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f29271a = 1;
    private AVMDLDataLoaderConfigure j = AVMDLDataLoaderConfigure.getDefaultonfigure();

    public class DataLoaderCacheInfo {
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public String mLocalFilePath = null;

        public DataLoaderCacheInfo(DataLoaderHelper dataLoaderHelper) {
        }
    }

    public static class DataLoaderTaskProgressInfo {
        public String mKey = null;
        public String mVideoId = null;
        public String mLocalFilePath = null;
        public long mMediaSize = 0;
        public long mCacheSizeFromZero = 0;
        public int mTaskType = 0;
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29272a = null;
        public long b = 0;
        public PreloaderURLItem c = null;
        public boolean d = false;
        public List<a> e = new CopyOnWriteArrayList();

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f29273a = null;
            public String b = null;
            public String[] c = null;
            public String d = null;
            public long e = 0;
            public long f = 0;
            public long g = 0;
            public long h = 0;
            public long i = 0;

            public a(b bVar) {
            }
        }

        public b(DataLoaderHelper dataLoaderHelper) {
        }

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVarB = b(str);
            if (aVarB != null) {
                return aVarB;
            }
            a aVar = new a(this);
            aVar.f29273a = str;
            this.e.add(aVar);
            return aVar;
        }

        public IPreLoaderItemCallBackListener a() {
            PreloaderURLItem preloaderURLItem = this.c;
            if (preloaderURLItem == null || preloaderURLItem.getCallBackListener() == null) {
                return null;
            }
            return this.c.getCallBackListener();
        }

        public void a(int i) {
            if (a() != null) {
                DataLoaderHelper.c();
                int unused = DataLoaderHelper.s;
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
                a().preloadItemInfo(preLoaderItemCallBackInfo);
            }
        }

        public void a(String str, long j) {
            if (this.e.size() == 0) {
                a aVar = new a(this);
                aVar.f29273a = str;
                aVar.g = j;
                this.e.add(aVar);
            } else {
                TTVideoEngineLog.e("DataLoaderHelper", "[preload] DataLoaderTaskItem setup fail");
            }
            this.b = j;
        }

        public a b(String str) {
            if (this.e.size() > 0) {
                for (int i = 0; i < this.e.size(); i++) {
                    a aVar = this.e.get(i);
                    if (aVar.f29273a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29274a;
        public int b = 0;
        public List<a> c = null;

        public class a {
            public String e;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f29275a = null;
            public long b = 0;
            public long c = 0;
            public List<C0605a> d = null;
            public Error f = null;

            /* JADX INFO: renamed from: com.bykv.vk.component.ttvideo.DataLoaderHelper$c$a$a, reason: collision with other inner class name */
            public class C0605a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public long f29276a = 0;
                public long b = 0;

                public C0605a(a aVar) {
                }
            }

            public a(c cVar) {
            }

            public void a(long j) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                if (this.d.size() == 0) {
                    this.d.add(new C0605a(this));
                }
                this.d.get(0).f29276a = 0L;
                this.d.get(0).b = j;
            }

            public boolean a() {
                long j = this.c;
                long jMin = j > 0 ? Math.min(j, this.b) : this.b;
                List<C0605a> list = this.d;
                C0605a c0605a = list != null ? list.get(list.size() - 1) : null;
                if (this.f == null) {
                    return c0605a != null && this.b > 0 && c0605a.f29276a + c0605a.b >= jMin;
                }
                return true;
            }

            public long b() {
                List<C0605a> list = this.d;
                if (list == null || list.size() <= 0) {
                    return 0L;
                }
                List<C0605a> list2 = this.d;
                return list2.get(list2.size() - 1).b;
            }
        }

        public c(DataLoaderHelper dataLoaderHelper) {
        }

        private a a(String str) {
            List<a> list;
            if (!TextUtils.isEmpty(str) && (list = this.c) != null) {
                for (a aVar : list) {
                    if (aVar.f29275a.equals(str)) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        public long a() {
            long jB = 0;
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    jB += this.c.get(i).b();
                }
            }
            return jB;
        }

        public void a(b bVar) {
            boolean z;
            if (this.c == null) {
                this.c = new ArrayList();
            }
            for (b.a aVar : bVar.e) {
                a aVarA = a(aVar.f29273a);
                if (aVarA == null) {
                    aVarA = new a(this);
                    z = false;
                } else {
                    z = true;
                }
                aVarA.f29275a = aVar.f29273a;
                aVarA.b = aVar.h;
                aVarA.a(aVar.i);
                aVarA.c = aVar.g;
                aVarA.e = aVar.d;
                if (!z) {
                    this.c.add(aVarA);
                }
            }
        }

        public void a(String str, Error error) {
            a aVarA = a(str);
            if (aVarA != null) {
                aVarA.f = error;
            }
        }

        public boolean b() {
            int i;
            boolean z = true;
            if (this.c != null) {
                i = 0;
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    a aVar = this.c.get(i2);
                    if (aVar == null || aVar.a()) {
                        i++;
                    } else {
                        z = false;
                    }
                }
            } else {
                i = 0;
            }
            return z || (i >= 2 && this.b == 1);
        }

        public boolean c() {
            if (this.b != 2) {
                return false;
            }
            if (this.c != null) {
                for (int i = 0; i < this.c.size(); i++) {
                    a aVar = this.c.get(i);
                    if (aVar != null && !aVar.a()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReentrantLock f29277a;
        private final ArrayList<b> b;
        private long c;

        private d(DataLoaderHelper dataLoaderHelper) {
            this.f29277a = new ReentrantLock();
            this.b = new ArrayList<>();
            this.c = 0L;
        }

        private Boolean e() {
            if (this.c >= 1) {
                return Boolean.valueOf(((long) this.b.size()) >= this.c);
            }
            return Boolean.FALSE;
        }

        public b a() {
            this.f29277a.lock();
            if (this.b.size() == 0) {
                this.f29277a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.f29277a.unlock();
            return bVar;
        }

        public void a(long j) {
            this.c = j;
        }

        public boolean a(b bVar) {
            Boolean bool;
            if (bVar == null || bVar.e.size() == 0) {
                return false;
            }
            this.f29277a.lock();
            if (e().booleanValue()) {
                bool = Boolean.FALSE;
            } else {
                this.b.add(bVar);
                bool = Boolean.TRUE;
            }
            this.f29277a.unlock();
            return bool.booleanValue();
        }

        public boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            this.f29277a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).b(str) != null) {
                    bool = Boolean.TRUE;
                    break;
                }
            }
            this.f29277a.unlock();
            return bool.booleanValue();
        }

        public long b() {
            this.f29277a.lock();
            long size = this.b.size();
            this.f29277a.unlock();
            return size;
        }

        public b b(b bVar) {
            b bVarC;
            if (TextUtils.isEmpty(bVar.f29272a)) {
                bVarC = null;
            } else {
                bVarC = d(bVar.f29272a);
                if (bVarC != null) {
                    return bVarC;
                }
            }
            Iterator<b.a> it = bVar.e.iterator();
            while (it.hasNext() && (bVarC = c(it.next().f29273a)) == null) {
            }
            return bVarC;
        }

        public b b(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f29277a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
            }
            this.f29277a.unlock();
            return bVar;
        }

        public b c() {
            this.f29277a.lock();
            if (this.b.size() == 0) {
                this.f29277a.unlock();
                return null;
            }
            ArrayList<b> arrayList = this.b;
            b bVar = arrayList.get(arrayList.size() - 1);
            this.b.remove(bVar);
            this.f29277a.unlock();
            return bVar;
        }

        public b c(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f29277a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (bVar2.b(str) != null) {
                    bVar = bVar2;
                    break;
                }
            }
            if (bVar != null) {
                this.b.remove(bVar);
            }
            this.f29277a.unlock();
            return bVar;
        }

        public b d(String str) {
            b bVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            this.f29277a.lock();
            for (int i = 0; i < this.b.size(); i++) {
                b bVar2 = this.b.get(i);
                if (!TextUtils.isEmpty(bVar2.f29272a) && bVar2.f29272a.equals(str)) {
                    bVar = bVar2;
                    break;
                }
            }
            if (bVar != null) {
                this.b.remove(bVar);
            }
            this.f29277a.unlock();
            return bVar;
        }

        public ArrayList<b> d() {
            try {
                this.f29277a.lock();
                return new ArrayList<>(this.b);
            } finally {
                this.f29277a.unlock();
            }
        }
    }

    private DataLoaderHelper() {
        this.b = new d();
        this.c = new d();
        this.d = new d();
        this.e = new d();
    }

    private String a(String str, String str2, long j, long j2, String[] strArr, String str3) {
        String strEncode;
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        if (j2 <= 0) {
            j2 = 0;
        }
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return null;
            }
        }
        String[] strArrA = a(strArr2);
        String strEncodeUrl = encodeUrl(str);
        if (TextUtils.isEmpty(strEncodeUrl)) {
            return null;
        }
        TTVideoEngineLog.i("DataLoaderHelper", "preloadProxyQuery: key = " + str + ", rawKey = " + str2);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        String strEncodeUrl2 = encodeUrl(str);
        if (TextUtils.isEmpty(strEncodeUrl2)) {
            strEncodeUrl2 = "videoId";
        }
        StringBuffer stringBuffer = new StringBuffer("?rk=");
        stringBuffer.append(strEncodeUrl2);
        stringBuffer.append("&k=");
        stringBuffer.append(strEncodeUrl);
        if (j2 > 0) {
            stringBuffer.append("&s=");
            stringBuffer.append(j + j2);
        }
        if (!TextUtils.isEmpty(str3)) {
            try {
                strEncode = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                m.c(e);
                strEncode = null;
            }
            if (!TextUtils.isEmpty(strEncode)) {
                stringBuffer.append("&p=");
                stringBuffer.append(strEncode);
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < strArrA.length; i++) {
            String strEncodeUrlByQuery = encodeUrlByQuery(strArrA[i]);
            StringBuffer stringBuffer3 = new StringBuffer();
            if (!TextUtils.isEmpty(strEncodeUrlByQuery)) {
                stringBuffer3.append("&u");
                stringBuffer3.append(i);
                stringBuffer3.append("=");
                stringBuffer3.append(strEncodeUrlByQuery);
            }
            if (stringBuffer.length() + stringBuffer2.length() + stringBuffer3.length() + 32 > 3096) {
                break;
            }
            stringBuffer2.append(stringBuffer3);
        }
        if (stringBuffer2.length() <= 0) {
            return null;
        }
        stringBuffer.append(stringBuffer2);
        return stringBuffer.toString();
    }

    private ArrayList<TTVideoEngine> a(String str) {
        ArrayList<TTVideoEngine> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList2 = this.g.get(str);
            if (arrayList2 != null) {
                arrayList = new ArrayList<>(arrayList2);
                TTVideoEngineLog.i("DataLoaderHelper", "get engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
            return arrayList;
        } finally {
            this.h.unlock();
        }
    }

    private void a() {
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        b bVarA = this.b.a();
        if (bVarA != null && this.c.a(bVarA)) {
            this.b.c();
            if (bVarA.c != null) {
                b(bVarA);
            }
        }
    }

    private void a(b bVar) {
        boolean z;
        ArrayList<TTVideoEngine> arrayListA;
        ArrayList<b> arrayListD = this.e.d();
        int i = 0;
        while (true) {
            if (i >= arrayListD.size()) {
                z = true;
                break;
            }
            b bVar2 = arrayListD.get(i);
            if (!TextUtils.isEmpty(bVar2.f29272a) && !TextUtils.isEmpty(bVar.f29272a) && bVar2.f29272a.equals(bVar.f29272a)) {
                z = false;
                break;
            }
            i++;
        }
        if (!z || (arrayListA = a(bVar.f29272a)) == null || arrayListA.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayListA.size(); i2++) {
            arrayListA.get(i2).a();
        }
    }

    private void a(b bVar, b.a aVar) {
        if (bVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. item is null");
            return;
        }
        if (aVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] start mdl preload task fail. track is null");
            notifyPreloadError(bVar.c, -100004);
            return;
        }
        TTVideoEngineLog.i("DataLoaderHelper", "[preload] start mdl preload task.  key = " + aVar.f29273a);
        String str = aVar.f29273a;
        String[] strArr = aVar.c;
        if (strArr != null) {
            String strA = a(str, bVar.f29272a, aVar.f, 0L, strArr, aVar.d);
            aVar.b = strA;
            if (!TextUtils.isEmpty(strA)) {
                this.d.a(bVar);
                if (aVar.f > 0) {
                    long j = aVar.e;
                    if (j > 0) {
                        this.i.preloadResource(aVar.b, (int) j);
                    }
                    this.i.preloadResource(aVar.b, (int) aVar.f, (int) aVar.g);
                } else {
                    this.i.preloadResource(aVar.b, (int) aVar.g);
                }
                TTVideoEngineLog.i("DataLoaderHelper", String.format("[preload] exect preload task ,key is %s; videoId = %s", aVar.f29273a, bVar.f29272a));
                return;
            }
        }
        bVar.a(-100001);
    }

    private void a(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo, boolean z, boolean z2) {
        b bVarB;
        d dVar;
        if (aVMDLDataLoaderNotifyInfo == null || TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
            return;
        }
        String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
        if (strArrSplit.length < 4) {
            return;
        }
        boolean z3 = false;
        try {
            long jLongValue = Long.valueOf(strArrSplit[0]).longValue();
            long jLongValue2 = Long.valueOf(strArrSplit[1]).longValue();
            if (jLongValue2 <= 0 && !z2) {
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] mediaSize <= 0 return " + aVMDLDataLoaderNotifyInfo.logInfo);
                return;
            }
            String str = strArrSplit[2];
            String str2 = strArrSplit[3];
            if (z || z2) {
                bVarB = this.d.b(str);
                if (bVarB == null) {
                    TTVideoEngineLog.i("DataLoaderHelper", "[preload] preload temItem == null return " + aVMDLDataLoaderNotifyInfo.logInfo);
                    return;
                }
                dVar = this.d;
                z3 = true;
            } else {
                bVarB = this.e.b(str);
                if (bVarB == null) {
                    TTVideoEngineLog.i("DataLoaderHelper", "[preload] play temItem == null return " + aVMDLDataLoaderNotifyInfo.logInfo);
                    return;
                }
                dVar = this.e;
            }
            b.a aVarB = bVarB.b(str);
            if (aVarB != null) {
                aVarB.h = jLongValue2;
                aVarB.i = jLongValue;
                aVarB.d = str2;
            }
            String str3 = TextUtils.isEmpty(bVarB.f29272a) ? str : bVarB.f29272a;
            c loadProgressByRawKey = getLoadProgressByRawKey(str3);
            if (loadProgressByRawKey == null) {
                loadProgressByRawKey = new c(this);
            }
            loadProgressByRawKey.f29274a = bVarB.f29272a;
            loadProgressByRawKey.b = z ? 2 : 1;
            loadProgressByRawKey.a(bVarB);
            putByRawKey(str3, loadProgressByRawKey);
            if (loadProgressByRawKey.b() || z2) {
                if (!z3) {
                    dVar.c(str);
                }
                removeLoadProgressByRawKey(str3);
                if (!z) {
                    a(bVarB);
                }
                if (bVarB.a() == null || !z2) {
                    return;
                }
                s++;
                dVar.c(str);
                DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo = new DataLoaderTaskProgressInfo();
                dataLoaderTaskProgressInfo.mCacheSizeFromZero = jLongValue;
                dataLoaderTaskProgressInfo.mMediaSize = jLongValue2;
                dataLoaderTaskProgressInfo.mKey = str;
                dataLoaderTaskProgressInfo.mLocalFilePath = str2;
                dataLoaderTaskProgressInfo.mVideoId = bVarB.f29272a;
                dataLoaderTaskProgressInfo.mTaskType = loadProgressByRawKey.b;
                PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(2);
                preLoaderItemCallBackInfo.preloadDataInfo = dataLoaderTaskProgressInfo;
                preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                bVarB.a().preloadItemInfo(preLoaderItemCallBackInfo);
                TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify end cache size = " + loadProgressByRawKey.a());
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, String str2, long j, PreloaderURLItem preloaderURLItem) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] key invalid.");
            notifyPreloadError(preloaderURLItem, -100001);
            return;
        }
        if (this.i == null || this.f29271a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            notifyPreloadError(preloaderURLItem, -100002);
        } else {
            if (this.c.a(str) || this.b.a(str)) {
                notifyPreloadError(preloaderURLItem, -100003);
                return;
            }
            b bVar = new b(this);
            bVar.a(str, j);
            bVar.f29272a = str2;
            bVar.c = preloaderURLItem;
            this.b.a(bVar);
            a();
        }
    }

    private boolean a(d dVar) {
        boolean z = false;
        if (dVar.b() > 0) {
            while (true) {
                b bVarC = dVar.c();
                if (bVarC == null) {
                    break;
                }
                c(bVarC);
                z = true;
            }
        }
        return z;
    }

    private String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 1) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            String str = strArr[i];
            Boolean bool = Boolean.TRUE;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((String) arrayList.get(size)).equals(str)) {
                    bool = Boolean.FALSE;
                    break;
                }
            }
            if (bool.booleanValue()) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        arrayList.toArray(strArr2);
        return strArr2;
    }

    private DataLoaderCacheInfo b(String str) {
        DataLoaderCacheInfo dataLoaderCacheInfo = null;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length >= 4) {
            dataLoaderCacheInfo = new DataLoaderCacheInfo(this);
            dataLoaderCacheInfo.mLocalFilePath = strArrSplit[3];
            if (!TextUtils.isEmpty(strArrSplit[0])) {
                dataLoaderCacheInfo.mCacheSizeFromZero = Long.parseLong(strArrSplit[0]);
            }
            if (!TextUtils.isEmpty(strArrSplit[1])) {
                dataLoaderCacheInfo.mMediaSize = Long.parseLong(strArrSplit[1]);
            }
        }
        return dataLoaderCacheInfo;
    }

    private void b(b bVar) {
        if (bVar == null) {
            a();
            return;
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] need load mdl first.");
            return;
        }
        this.c.b(bVar);
        long j = bVar.b;
        PreloaderURLItem preloaderURLItem = bVar.c;
        if (preloaderURLItem != null && preloaderURLItem.getUrls() != null && bVar.c.getUrls().length > 0) {
            b.a aVar = bVar.e.get(0);
            aVar.c = bVar.c.getUrls();
            aVar.g = bVar.b;
            aVar.d = bVar.c.getFilePath();
            a(bVar, aVar);
        }
        if (bVar.a() != null) {
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(6);
            preLoaderItemCallBackInfo.preloadType = 0;
            preLoaderItemCallBackInfo.videoPreloadSize = j;
            preLoaderItemCallBackInfo.audioPreloadSize = 0L;
            bVar.a().preloadItemInfo(preLoaderItemCallBackInfo);
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] notify info. type = 0");
        }
        a();
    }

    public static /* synthetic */ int c() {
        int i = s;
        s = i + 1;
        return i;
    }

    private void c(b bVar) {
        if (bVar == null || bVar.d) {
            return;
        }
        bVar.d = true;
        if (bVar.a() != null) {
            s++;
            bVar.a().preloadItemInfo(new PreLoaderItemCallBackInfo(5));
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://127.0.0.1") || lowerCase.startsWith("http://localhost") || lowerCase.startsWith(MDL_PREFIX) || lowerCase.startsWith("file://") || lowerCase.startsWith(WVNativeCallbackUtil.SEPERATER) || lowerCase.endsWith(".mpd") || lowerCase.contains(".mpd?")) ? false : true;
    }

    private boolean d() {
        if (this.i != null) {
            return true;
        }
        if (AVMDLDataLoader.init(false, false) != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "library has not been loaded");
            return false;
        }
        try {
            AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.getInstance();
            this.i = aVMDLDataLoader;
            aVMDLDataLoader.setConfigure(this.j);
            this.i.setListener(this);
            this.i.setStartCompleteListener(this);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String encodeUrlByQuery(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String strQueryComponentEncode = AVMDLDataLoader.queryComponentEncode(str);
            return TextUtils.isEmpty(strQueryComponentEncode) ? URLEncoder.encode(str, "UTF-8") : strQueryComponentEncode;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static DataLoaderHelper getDataLoader() {
        return p;
    }

    public void _addEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.g.put(str, arrayList);
            }
            if (!arrayList.contains(tTVideoEngine)) {
                arrayList.add(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "add engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
            }
        } finally {
            this.h.unlock();
        }
    }

    public String _proxyUrl(String str, String str2, long j, String[] strArr, String str3) {
        if (this.f29271a != 0 || TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (String str4 : strArr2) {
            if (!c(str4)) {
                return str4;
            }
        }
        if (this.i == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "start mdl first");
            return null;
        }
        this.o.lock();
        try {
            String localAddr = this.i.getLocalAddr();
            if (TextUtils.isEmpty(localAddr)) {
                TTVideoEngineLog.e("DataLoaderHelper", "local host error");
                this.o.unlock();
                return null;
            }
            String strA = a(str, str2, 0L, j, strArr2, str3);
            if (TextUtils.isEmpty(strA)) {
                this.o.unlock();
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = this.n;
            this.n = i + 1;
            StringBuffer stringBuffer2 = new StringBuffer();
            TTVideoEngineLog.i("DataLoaderHelper", "proxy url, mInvalidMdlProcotol: " + this.l);
            if (this.l || !this.m) {
                stringBuffer.append("http://");
                stringBuffer.append(localAddr);
                stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
                stringBuffer.append(i);
            } else {
                stringBuffer.append("mdl://id");
                stringBuffer.append(i);
                stringBuffer.append(WVNativeCallbackUtil.SEPERATER);
            }
            stringBuffer.append(strA);
            stringBuffer2.append(strA);
            String auth = this.i.getAuth(strA);
            if (!TextUtils.isEmpty(auth)) {
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
                stringBuffer.append("&ah=");
                stringBuffer.append(auth);
            }
            String string = stringBuffer.toString();
            TTVideoEngineLog.i("DataLoaderHelper", "_proxyUrl: ".concat(String.valueOf(string)));
            this.o.unlock();
            b bVarD = this.e.d(str2);
            if (bVarD == null) {
                bVarD = new b(this);
            }
            b.a aVarA = bVarD.a(str);
            if (aVarA != null) {
                aVarA.f29273a = str;
                bVarD.f29272a = str2;
                aVarA.b = string;
                aVarA.c = strArr2;
                aVarA.d = str3;
                this.e.a(bVarD);
            }
            return string;
        } catch (Throwable th) {
            this.o.unlock();
            throw th;
        }
    }

    public void _removeEngine(TTVideoEngine tTVideoEngine, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.h.lock();
            ArrayList<TTVideoEngine> arrayList = this.g.get(str);
            if (arrayList != null) {
                arrayList.remove(tTVideoEngine);
                TTVideoEngineLog.i("DataLoaderHelper", "remove engine ref,rawKey = " + str + " engine ref count: " + arrayList.size());
                if (arrayList.size() == 0) {
                    this.g.remove(str);
                }
            }
        } finally {
            this.h.unlock();
        }
    }

    public void _removePlayTask(String str) {
        this.e.c(str);
    }

    public void addTask(PreloaderURLItem preloaderURLItem) {
        q++;
        if (preloaderURLItem == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] url item invalid");
            return;
        }
        this.o.lock();
        try {
            a(preloaderURLItem.getKey(), preloaderURLItem.getVideoId(), preloaderURLItem.getPreloadSize(), preloaderURLItem);
        } finally {
            this.o.unlock();
        }
    }

    public void cancelAllTasks() {
        if (this.i == null || this.f29271a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            cancelAllTasksInternal();
            this.o.unlock();
        } catch (Throwable unused) {
            this.o.unlock();
        }
    }

    public void cancelAllTasksInternal() {
        a(this.c);
        a(this.b);
        if (a(this.d)) {
            this.i.cancelAll();
        }
    }

    public void cancelTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.i == null || this.f29271a != 0) {
            TTVideoEngineLog.e("DataLoaderHelper", "need start mdl first");
            return;
        }
        this.o.lock();
        try {
            b bVarC = this.b.c(str);
            if (bVarC == null && (bVarC = this.c.c(str)) == null) {
                bVarC = this.d.c(str);
                if (bVarC != null) {
                    this.i.cancel(str);
                    c(bVarC);
                }
            } else {
                c(bVarC);
            }
            TTVideoEngineLog.i("DataLoaderHelper", "[preload] cancel preload task. key = ".concat(String.valueOf(str)));
            this.o.unlock();
        } catch (Throwable unused) {
            this.o.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.f29271a != 0) {
            return;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                aVMDLDataLoader.clearAllCaches();
            }
        } catch (Throwable th) {
            try {
                m.c(th);
            } finally {
                this.o.unlock();
            }
        }
    }

    public void close() {
        this.o.lock();
        try {
            if (this.f29271a == 1) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader not started, not need close");
            } else {
                this.i.close();
                cancelAllTasksInternal();
                this.f29271a = 1;
            }
        } finally {
            this.o.unlock();
        }
    }

    public DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                DataLoaderCacheInfo dataLoaderCacheInfoB = b(aVMDLDataLoader.getStringCacheInfo(str, str2));
                this.o.unlock();
                return dataLoaderCacheInfoB;
            }
        } catch (Throwable unused) {
        }
        this.o.unlock();
        return null;
    }

    public long getCacheSize(String str) {
        long j = 0;
        if (this.f29271a != 0) {
            return 0L;
        }
        this.o.lock();
        try {
            AVMDLDataLoader aVMDLDataLoader = this.i;
            if (aVMDLDataLoader != null) {
                long cacheSize = aVMDLDataLoader.getCacheSize(str);
                if (cacheSize > 0) {
                    j = cacheSize;
                }
            }
        } catch (Throwable th) {
            try {
                m.c(th);
            } finally {
                this.o.unlock();
            }
        }
        return j;
    }

    public long getCacheSizeByFilePath(String str, String str2) {
        this.o.lock();
        long j = 0;
        try {
            DataLoaderCacheInfo cacheInfoByFilePath = getCacheInfoByFilePath(str, str2);
            if (cacheInfoByFilePath != null) {
                j = cacheInfoByFilePath.mCacheSizeFromZero;
            }
        } catch (Throwable unused) {
        }
        this.o.unlock();
        return j;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public long getInt64Value(int i, long j) {
        return 0L;
    }

    public c getLoadProgressByRawKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f.get(str);
        }
        TTVideoEngineLog.e("DataLoaderHelper", "[preload] get, param is invalid key is null");
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public String getStringValue(int i, long j, String str) {
        return null;
    }

    public void notifyPreloadError(PreloaderURLItem preloaderURLItem, int i) {
        IPreLoaderItemCallBackListener callBackListener = preloaderURLItem.getCallBackListener();
        if (callBackListener != null) {
            s++;
            PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
            preLoaderItemCallBackInfo.preloadError = new Error(Error.DataLoaderPreload, i);
            callBackListener.preloadItemInfo(preLoaderItemCallBackInfo);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderListener
    public void onNotify(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        String str;
        b bVarB;
        if (aVMDLDataLoaderNotifyInfo == null) {
            return;
        }
        int i = aVMDLDataLoaderNotifyInfo.what;
        if (i != 0 && i != 15) {
            if (i != 20) {
                if (i == 3 || i == 4) {
                    if (i == 4) {
                        r++;
                    }
                    if (aVMDLDataLoaderNotifyInfo.logInfo != null) {
                        long j = aVMDLDataLoaderNotifyInfo.parameter;
                        if (j != 3) {
                            a(aVMDLDataLoaderNotifyInfo, j == 2, i == 4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 7) {
                    r++;
                    if (TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                        return;
                    }
                    String[] strArrSplit = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                    if (strArrSplit.length < 4) {
                        return;
                    }
                    String str2 = strArrSplit[2];
                    b bVarB2 = this.d.b(str2);
                    this.d.c(str2);
                    c(bVarB2);
                    return;
                }
                if (i != 8) {
                    if (i != 10 && i != 11) {
                        return;
                    }
                }
            }
            if (i == 8) {
                r++;
            }
            String str3 = aVMDLDataLoaderNotifyInfo.logInfo;
            if ((str3 == null || aVMDLDataLoaderNotifyInfo.parameter != 3) && str3 != null) {
                TTVideoEngineLog.i("DataLoaderHelper", " task fail log = " + aVMDLDataLoaderNotifyInfo.logInfo + ", code = " + aVMDLDataLoaderNotifyInfo.code + ", task type = " + aVMDLDataLoaderNotifyInfo.parameter);
                String[] strArrSplit2 = aVMDLDataLoaderNotifyInfo.logInfo.split(",");
                if (strArrSplit2.length > 0 && (bVarB = this.d.b((str = strArrSplit2[0]))) != null) {
                    d dVar = this.d;
                    Error error = new Error(Error.DataLoaderPreload, (int) aVMDLDataLoaderNotifyInfo.code, aVMDLDataLoaderNotifyInfo.logInfo);
                    String str4 = TextUtils.isEmpty(bVarB.f29272a) ? str : bVarB.f29272a;
                    c loadProgressByRawKey = getLoadProgressByRawKey(str4);
                    if (loadProgressByRawKey == null) {
                        loadProgressByRawKey = new c(this);
                    }
                    loadProgressByRawKey.f29274a = bVarB.f29272a;
                    loadProgressByRawKey.b = (int) aVMDLDataLoaderNotifyInfo.parameter;
                    loadProgressByRawKey.a(bVarB);
                    loadProgressByRawKey.a(str, error);
                    putByRawKey(str4, loadProgressByRawKey);
                    if (!loadProgressByRawKey.b() && !loadProgressByRawKey.c()) {
                        loadProgressByRawKey.b();
                        loadProgressByRawKey.c();
                        return;
                    }
                    dVar.c(str);
                    TTVideoEngineLog.i("DataLoaderHelper", "pop all task item. videoId = " + bVarB.f29272a + " key = " + str);
                    removeLoadProgressByRawKey(str4);
                    if (bVarB.a() == null || aVMDLDataLoaderNotifyInfo.parameter != 2) {
                        return;
                    }
                    PreLoaderItemCallBackInfo preLoaderItemCallBackInfo = new PreLoaderItemCallBackInfo(3);
                    preLoaderItemCallBackInfo.preloadError = error;
                    preLoaderItemCallBackInfo.loadProgress = loadProgressByRawKey;
                    preLoaderItemCallBackInfo.preloadDataInfo = null;
                    s++;
                    bVarB.a().preloadItemInfo(preLoaderItemCallBackInfo);
                    return;
                }
                return;
            }
            return;
        }
        VideoEventEngineUploader videoEventEngineUploader = this.k;
        if (videoEventEngineUploader != null) {
            videoEventEngineUploader.onEvent(aVMDLDataLoaderNotifyInfo.logType, aVMDLDataLoaderNotifyInfo.jsonLog);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLStartCompleteListener
    public void onStartComplete() {
    }

    public void putByRawKey(String str, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] param is invalid");
        } else {
            this.f.put(str, cVar);
        }
    }

    public void removeCacheFile(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.lock();
        try {
            if (this.i == null) {
                TTVideoEngineLog.e("DataLoaderHelper", "mInnerDataLoader == null");
            } else {
                TTVideoEngineLog.i("DataLoaderHelper", "remove mdl file. key ".concat(String.valueOf(str)));
                if (z) {
                    this.i.forceRemoveFileCache(str);
                } else {
                    this.i.removeFileCache(str);
                }
            }
        } catch (Throwable unused) {
        }
        this.o.unlock();
    }

    public void removeLoadProgressByRawKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TTVideoEngineLog.e("DataLoaderHelper", "[preload] remove, param is invalid key is null");
        } else {
            this.f.remove(str);
        }
    }

    public void setCacheInfoLists(String[] strArr, long[] jArr) {
        Arrays.toString(strArr);
        Arrays.toString(jArr);
        this.o.lock();
        try {
            this.j.setCacheInfoList(strArr, jArr);
        } finally {
            this.o.unlock();
        }
    }

    public void setContext(Context context) {
        this.o.lock();
        this.o.unlock();
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.k = videoEventEngineUploader;
    }

    public void setIntValue(int i, int i2) {
        this.o.lock();
        try {
            if (i == 11) {
                this.j.mPreloadParallelNum = i2;
                AVMDLDataLoader aVMDLDataLoader = this.i;
                if (aVMDLDataLoader != null) {
                    aVMDLDataLoader.setIntValue(102, i2);
                }
            } else if (i != 512) {
                boolean z = true;
                if (i == 1005) {
                    if (i2 != 1) {
                        z = false;
                    }
                    this.m = z;
                    TTVideoEngineLog.i("DataLoaderHelper", "config DATALOADER_KEY_SET_MDL_PROTOCOL_ENABLE: " + this.m);
                } else if (i == 1) {
                    this.j.mMaxCacheSize = i2;
                } else if (i == 2) {
                    this.j.mRWTimeOut = i2;
                } else {
                    if (i != 3) {
                        if (i == 4) {
                            this.j.mTryCount = i2;
                        }
                    }
                    this.j.mOpenTimeOut = i2;
                }
            } else {
                this.j.mAlogEnable = i2;
                AVMDLDataLoader aVMDLDataLoader2 = this.i;
                if (aVMDLDataLoader2 != null) {
                    aVMDLDataLoader2.setIntValue(AVMDLDataLoader.KeyIsAlogEnable, i2);
                }
            }
        } catch (Exception e) {
            m.c(e);
        } finally {
            this.o.unlock();
        }
    }

    public void setStringValue(int i, String str) {
        this.o.lock();
        if (i == 0) {
            try {
                this.j.mCacheDir = str;
            } catch (Exception unused) {
            } finally {
                this.o.unlock();
            }
        }
    }

    public void start() {
        this.o.lock();
        try {
            if (this.f29271a == 0) {
                TTVideoEngineLog.e("DataLoaderHelper", "DataLoader has started not need start");
            } else {
                if (!d()) {
                    throw new Exception("init data loader fail");
                }
                this.c.a(4L);
                if (this.j == null) {
                    this.j = AVMDLDataLoaderConfigure.getDefaultonfigure();
                }
                if (this.k != null) {
                    this.j.mEnableReportTaskLog = 1;
                }
                this.i.setConfigure(this.j);
                if (this.i.start() < 0) {
                    throw new Exception("start data loader fail");
                }
                if (this.i.getLongValue(AVMDLDataLoader.KeyIsGetMdlProtocolHandle) == -1) {
                    this.l = true;
                }
                this.f29271a = 0;
            }
            this.o.unlock();
        } catch (Throwable th) {
            this.o.unlock();
            throw th;
        }
    }
}
