package com.aliyun.svideosdk.common.impl;

import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.svideosdk.common.AliyunIThumbnailFetcher;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.ProjectUtil;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl;
import com.aliyun.svideosdk.transcode.NativeParser;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements AliyunIThumbnailFetcher {
    private static final String j = "com.aliyun.svideosdk.common.impl.d";
    private long e;
    private HandlerThread h;
    private Handler i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f25635a = new c();
    private HashMap<String, h> b = new HashMap<>();
    private HashMap<String, f> c = new HashMap<>();
    private LinkedHashMap<Long, C0220d> d = new LinkedHashMap<>();
    private long f = 0;
    private long g = 0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25636a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MediaType.values().length];
            b = iArr;
            try {
                iArr[MediaType.ANY_IMAGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[MediaType.ANY_VIDEO_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[VideoDisplayMode.values().length];
            f25636a = iArr2;
            try {
                iArr2[VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25636a[VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            getLooper().quitSafely();
            d.this.i = null;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f25638a;
        private List<Integer> b = new ArrayList();

        public synchronized int a() {
            int iIntValue;
            if (this.b.size() == 0) {
                iIntValue = this.f25638a;
                this.f25638a = iIntValue + 1;
                this.b.add(Integer.valueOf(iIntValue));
            } else {
                iIntValue = this.b.remove(0).intValue();
            }
            return iIntValue;
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.impl.d$d, reason: collision with other inner class name */
    public class C0220d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f25639a;
        MediaType b;
        long c;

        public C0220d(d dVar, String str, MediaType mediaType) {
            this.f25639a = str;
            this.b = mediaType;
        }

        public long a() {
            return this.c;
        }

        public void a(long j) {
        }

        public void b(long j) {
            this.c = j;
        }

        public void c(long j) {
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.aliyun.svideosdk.common.impl.a f25640a;
        Map<Long, List<Long>> b = new HashMap();

        public e(d dVar, com.aliyun.svideosdk.common.impl.a aVar) {
            this.f25640a = aVar;
        }
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("ThumbnailIOThread");
        this.h = handlerThread;
        this.i = null;
        handlerThread.setPriority(1);
        this.h.start();
        this.i = new b(this.h.getLooper());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:9:0x0049  */
    private void a(com.aliyun.svideosdk.common.impl.a aVar) {
        int iG;
        int iF;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Log.d(j, this + " Call setCropInfo");
        com.aliyun.svideosdk.common.impl.e eVarA = aVar.a();
        int iD = eVarA.d();
        int iC = eVarA.c();
        eVarA.b();
        VideoDisplayMode videoDisplayModeJ = eVarA.j();
        int i11 = eVarA.i();
        if (i11 == 0) {
            iG = eVarA.g();
            iF = eVarA.f();
            i = iG;
        } else {
            if (i11 != 90) {
                if (i11 == 180) {
                    iG = eVarA.g();
                    iF = eVarA.f();
                    i = iG;
                } else if (i11 != 270) {
                    iF = 0;
                    i = 0;
                }
            }
            iG = eVarA.f();
            iF = eVarA.g();
            i = iG;
        }
        float f = i * 1.0f;
        float f2 = iF;
        float f3 = iD;
        float f4 = iC;
        if (f / f2 == (f3 * 1.0f) / f4) {
            if (i11 == 90 || i11 == 270) {
                i8 = 0;
                i9 = 0;
                i10 = iF;
            } else {
                i8 = 0;
                i9 = 0;
                i10 = i;
                i = iF;
            }
            aVar.a(i11, i8, i9, i10, i);
            return;
        }
        if (a.f25636a[videoDisplayModeJ.ordinal()] == 2) {
            if ((f2 * 1.0f) / f4 > f / f3) {
                i3 = (int) (((iC * i) * 1.0f) / f3);
            } else {
                i2 = (int) (((iD * iF) * 1.0f) / f4);
                i3 = iF;
            }
            i4 = (i - i2) / 2;
            int i12 = (iF - i3) / 2;
            if (i11 != 0 || i11 == 180) {
                i5 = i4;
                i6 = i2;
                i7 = i3;
            } else {
                i5 = i12;
                i12 = i4;
                i6 = i3;
                i7 = i2;
            }
            aVar.a(i11, i5, i12, i6, i7);
        }
        i3 = iF;
        i2 = i;
        i4 = (i - i2) / 2;
        int i13 = (iF - i3) / 2;
        if (i11 != 0) {
            i5 = i4;
            i6 = i2;
            i7 = i3;
        } else {
            i5 = i4;
            i6 = i2;
            i7 = i3;
        }
        aVar.a(i11, i5, i13, i6, i7);
    }

    public long a(long j2) {
        long j3 = this.g - this.f;
        return j2 > j3 ? j3 : j2;
    }

    public Map<String, e> a(long[] jArr) {
        C0220d c0220d;
        HashMap map = new HashMap();
        if (this.d.size() == 0) {
            return map;
        }
        for (long j2 : jArr) {
            Iterator<Map.Entry<Long, C0220d>> it = this.d.entrySet().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().getKey().longValue();
                if (j2 <= jLongValue) {
                    break;
                }
                j3 = jLongValue;
            }
            if (j3 >= 0 && (c0220d = this.d.get(Long.valueOf(j3))) != null) {
                long j4 = j2 - j3;
                String str = c0220d.f25639a;
                e eVar = (e) map.get(str);
                int i = a.b[c0220d.b.ordinal()];
                if (i == 1) {
                    if (eVar == null) {
                        eVar = new e(this, this.c.get(str));
                        map.put(str, eVar);
                    }
                    List<Long> arrayList = eVar.b.get(Long.valueOf(j3));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        eVar.b.put(Long.valueOf(j3), arrayList);
                    }
                    arrayList.add(Long.valueOf(j4 * 1000));
                } else if (i == 2) {
                    if (eVar == null) {
                        e eVar2 = new e(this, this.b.get(str));
                        map.put(str, eVar2);
                        eVar = eVar2;
                    }
                    List<Long> arrayList2 = eVar.b.get(Long.valueOf(j3));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                        eVar.b.put(Long.valueOf(j3), arrayList2);
                    }
                    arrayList2.add(Long.valueOf((j4 + c0220d.a()) * 1000));
                }
            }
        }
        return map;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int addImageSource(String str, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return -20003002;
        }
        if (!new File(str).exists()) {
            return -20003002;
        }
        f fVar = this.c.get(str);
        long j4 = this.e;
        if (fVar == null) {
            f fVar2 = new f(this.h.getLooper());
            com.aliyun.svideosdk.common.impl.e eVarA = fVar2.a();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            eVarA.a(str);
            eVarA.d(options.outWidth);
            eVarA.c(options.outHeight);
            eVarA.a(MediaType.ANY_IMAGE_TYPE);
            this.c.put(str, fVar2);
        }
        if (j3 > j2) {
            Log.e("AliYunLog", "Invalid overlapDuration:" + j3);
            j3 = j2;
        }
        long j5 = this.e;
        if (j5 == 0) {
            this.e = j5 + j2;
            this.g = j2;
        } else {
            long jA = a(j3);
            if (jA == j2) {
                return 0;
            }
            this.e += j2 - jA;
            this.g = j2;
            this.f = jA;
        }
        this.d.put(Long.valueOf(j4), new C0220d(this, str, MediaType.ANY_IMAGE_TYPE));
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[Catch: all -> 0x015d, SYNTHETIC, TRY_LEAVE, TryCatch #9 {, blocks: (B:4:0x0004, B:9:0x000f, B:13:0x001c, B:17:0x0062, B:41:0x00c0, B:43:0x00ca, B:46:0x00d7, B:48:0x00e3, B:49:0x0108, B:21:0x0068, B:69:0x0153, B:74:0x015c, B:73:0x0159, B:35:0x00b3, B:39:0x00b9, B:58:0x013d, B:62:0x0143), top: B:89:0x0004, inners: #3, #4, #5, #10 }] */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int addVideoSource(String str) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        int i2;
        int i3;
        long j2;
        if (TextUtils.isEmpty(str)) {
            return -20003002;
        }
        if (!new File(str).exists()) {
            return -20003002;
        }
        String strB = com.aliyun.common.utils.g.b(str);
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                    j2 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    Log.e("AliYunLog", "parseStreamSize failed", e);
                    NativeParser nativeParser = new NativeParser();
                    nativeParser.init(str);
                    try {
                        try {
                            int i4 = Integer.parseInt(nativeParser.getValue(6));
                            int i5 = Integer.parseInt(nativeParser.getValue(7));
                            int i6 = Integer.parseInt(nativeParser.getValue(14));
                            long j3 = Long.parseLong(nativeParser.getValue(3));
                            nativeParser.release();
                            nativeParser.dispose();
                            if (mediaMetadataRetriever2 != null) {
                                try {
                                    mediaMetadataRetriever2.release();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            i = i4;
                            i2 = i5;
                            i3 = i6;
                            j2 = j3;
                        } catch (Exception unused) {
                            Log.e("AliYunLog", "parse rotation failed");
                            nativeParser.release();
                            nativeParser.dispose();
                            if (mediaMetadataRetriever2 != null) {
                                try {
                                    mediaMetadataRetriever2.release();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            return -20003002;
                        }
                    } catch (Throwable th2) {
                        nativeParser.release();
                        nativeParser.dispose();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (mediaMetadataRetriever != null) {
                        throw th;
                    }
                    try {
                        mediaMetadataRetriever.release();
                        throw th;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    throw th;
                }
                mediaMetadataRetriever.release();
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
        }
        if (strB.contains(FileTypeUtils.FILE_TYPE_GIF)) {
            return addImageSource(str, j2 / 1000, 0L);
        }
        h hVar = this.b.get(str);
        long j4 = this.e;
        if (hVar == null) {
            h hVar2 = new h(this.h.getLooper());
            com.aliyun.svideosdk.common.impl.e eVarA = hVar2.a();
            eVarA.a(str);
            eVarA.e(i3);
            eVarA.d(i);
            eVarA.c(i2);
            eVarA.a(MediaType.ANY_VIDEO_TYPE);
            this.b.put(str, hVar2);
        }
        C0220d c0220d = new C0220d(this, str, MediaType.ANY_VIDEO_TYPE);
        long j5 = j2 / 1000;
        c0220d.b(0L);
        c0220d.a(j5);
        c0220d.c(j5);
        this.e += j5;
        this.d.put(Long.valueOf(j4), c0220d);
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[Catch: all -> 0x0205, SYNTHETIC, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0007, B:9:0x0012, B:13:0x001f, B:15:0x002b, B:18:0x0039, B:22:0x0086, B:47:0x00e6, B:48:0x010b, B:65:0x013f, B:67:0x0145, B:68:0x016c, B:70:0x0173, B:75:0x017e, B:77:0x01a2, B:76:0x0192, B:80:0x01ad, B:26:0x008c, B:99:0x01fb, B:104:0x0204, B:103:0x0201, B:40:0x00d7, B:44:0x00dd, B:89:0x01e6, B:93:0x01ec), top: B:113:0x0007, inners: #1, #2, #5, #6 }] */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int addVideoSource(String str, long j2, long j3, long j4) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        int i2;
        int i3;
        long j5;
        long j6 = j4;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return -20003002;
            }
            if (!new File(str).exists()) {
                return -20003002;
            }
            if (com.aliyun.common.utils.g.b(str).contains(FileTypeUtils.FILE_TYPE_GIF)) {
                return addImageSource(str, j3 - j2, j4);
            }
            h hVar = this.b.get(str);
            long j7 = this.e;
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                        j5 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        mediaMetadataRetriever2 = mediaMetadataRetriever;
                        Log.e("AliYunLog", "AddVideoSource parseStreamSize failed", e);
                        NativeParser nativeParser = new NativeParser();
                        nativeParser.init(str);
                        try {
                            try {
                                int i4 = Integer.parseInt(nativeParser.getValue(6));
                                int i5 = Integer.parseInt(nativeParser.getValue(7));
                                int i6 = Integer.parseInt(nativeParser.getValue(14));
                                long j8 = Long.parseLong(nativeParser.getValue(3));
                                nativeParser.release();
                                nativeParser.dispose();
                                if (mediaMetadataRetriever2 != null) {
                                    try {
                                        mediaMetadataRetriever2.release();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                i = i4;
                                i2 = i5;
                                i3 = i6;
                                j5 = j8;
                            } catch (Throwable th2) {
                                nativeParser.release();
                                nativeParser.dispose();
                                throw th2;
                            }
                        } catch (Exception unused) {
                            Log.e("AliYunLog", "AddVideoSource parse rotation failed");
                            nativeParser.release();
                            nativeParser.dispose();
                            if (mediaMetadataRetriever2 != null) {
                                try {
                                    mediaMetadataRetriever2.release();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (mediaMetadataRetriever != null) {
                            throw th;
                        }
                        try {
                            mediaMetadataRetriever.release();
                            throw th;
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                }
                if (hVar == null) {
                    hVar = new h(this.h.getLooper());
                    com.aliyun.svideosdk.common.impl.e eVarA = hVar.a();
                    eVarA.a(str);
                    eVarA.e(i3);
                    eVarA.d(i);
                    eVarA.c(i2);
                    eVarA.a(MediaType.ANY_VIDEO_TYPE);
                    this.b.put(str, hVar);
                }
                C0220d c0220d = new C0220d(this, str, MediaType.ANY_VIDEO_TYPE);
                long j9 = j5 / 1000;
                hVar.a().b(j9);
                long j10 = (j3 > j9 || j3 == 0) ? j9 : j3;
                long j11 = j2 < 0 ? 0L : j2;
                if (j10 > j9 || j11 < 0 || j10 <= j11) {
                    Log.e("AliYunLog", "Invalid time interval [" + j11 + "," + j10 + "]");
                    return -20003002;
                }
                long j12 = j10 - j11;
                if (j6 > j12) {
                    Log.e("AliYunLog", "Invalid overlapDuration:overlapDuration " + j6 + ", endTime " + j10 + ", startTime " + j11);
                    j6 = j12;
                }
                if (this.e > 0) {
                    long jA = a(j6);
                    long j13 = j11 + jA;
                    if (j13 >= j10) {
                        return 0;
                    }
                    c0220d.b(j13);
                    c0220d.a(j10);
                    long j14 = j12 - jA;
                    c0220d.c(j14);
                    this.e += j14;
                    this.g = j14;
                    this.f = jA;
                } else {
                    c0220d.b(j11);
                    c0220d.a(j10);
                    c0220d.c(j12);
                    this.e += j12;
                    this.g = j12;
                }
                this.d.put(Long.valueOf(j7), c0220d);
                return 0;
            } catch (Throwable th4) {
                th = th4;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    throw th;
                }
                mediaMetadataRetriever.release();
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d9 A[Catch: all -> 0x0114, PHI: r1 r11
      0x00d9: PHI (r1v25 java.lang.String) = (r1v21 java.lang.String), (r1v31 java.lang.String) binds: [B:33:0x00d3, B:23:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x00d9: PHI (r11v2 long) = (r11v1 long), (r11v4 long) binds: [B:33:0x00d3, B:23:0x008f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x002c, B:9:0x0035, B:11:0x0040, B:14:0x0049, B:15:0x005b, B:17:0x0061, B:22:0x007c, B:36:0x00e1, B:35:0x00d9, B:25:0x0092, B:27:0x00a0, B:28:0x00ae, B:30:0x00ba, B:32:0x00c0, B:37:0x00e8, B:41:0x0105, B:40:0x00ff, B:29:0x00b3), top: B:50:0x0005 }] */
    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int fromConfigJson(String str) {
        String path;
        long out;
        long overlapDuration;
        long j2;
        String str2;
        Log.d(j, this + " Call fromConfigJson:" + str);
        ProjectJSONSupportImpl projectJSONSupportImpl = new ProjectJSONSupportImpl();
        if (TextUtils.isEmpty(str)) {
            Log.e("AliYunLog", "Json mPath cannot be null");
            return -20003002;
        }
        AliyunEditorProject project = ProjectUtil.readProject(new File(str), projectJSONSupportImpl);
        if (project == null) {
            Log.e("AliYunLog", "json file is invalid");
            return -20003002;
        }
        int iAddVideoSource = 0;
        for (VideoTrackClip videoTrackClip : project.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            TransitionBase transition = videoTrackClip.getTransition();
            int type = videoTrackClip.getType();
            long overlapDuration2 = 0;
            if (type == 0) {
                String strB = com.aliyun.common.utils.g.b(videoTrackClip.getSource().getPath());
                if (Boolean.valueOf(strB == null ? videoTrackClip.getSource().getPath().endsWith(FileTypeUtils.FILE_TYPE_GIF) : strB.contains(FileTypeUtils.FILE_TYPE_GIF)).booleanValue()) {
                    path = videoTrackClip.getSource().getPath();
                    out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
                    if (transition == null) {
                        str2 = path;
                        overlapDuration = 0;
                        j2 = out;
                    } else {
                        overlapDuration = transition.getOverlapDuration() / 1000;
                        j2 = out;
                        str2 = path;
                    }
                    iAddVideoSource = addImageSource(str2, j2, overlapDuration);
                } else {
                    String path2 = videoTrackClip.getSource().getPath();
                    long in = (long) (videoTrackClip.getIn() * 1000.0f);
                    long out2 = (long) (videoTrackClip.getOut() * 1000.0f);
                    if (transition != null) {
                        overlapDuration2 = transition.getOverlapDuration() / 1000;
                    }
                    iAddVideoSource = addVideoSource(path2, in, out2, overlapDuration2);
                }
            } else if (type == 1) {
                path = videoTrackClip.getSource().getPath();
                out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
                if (transition == null) {
                    str2 = path;
                    overlapDuration = 0;
                    j2 = out;
                } else {
                    overlapDuration = transition.getOverlapDuration() / 1000;
                    j2 = out;
                    str2 = path;
                }
                iAddVideoSource = addImageSource(str2, j2, overlapDuration);
            }
            if (iAddVideoSource != 0) {
                return iAddVideoSource;
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized long getTotalDuration() {
        return this.e;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized void release() {
        Log.d(j, this + " Call release");
        for (Map.Entry<String, h> entry : this.b.entrySet()) {
            if (entry.getValue().c()) {
                entry.getValue().g();
            }
            entry.getValue().d();
        }
        Iterator<Map.Entry<String, f>> it = this.c.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d();
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public int requestThumbnailImage(int i, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion) {
        long[] jArr;
        if (i > 0) {
            jArr = new long[i];
            long j2 = this.e / ((long) i);
            for (int i2 = 0; i2 < i; i2++) {
                jArr[i2] = (((long) i2) * j2) + (j2 / 2);
            }
        } else {
            jArr = null;
        }
        return requestThumbnailImage(jArr, onThumbnailCompletion);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int requestThumbnailImage(long[] jArr, AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion) {
        if (jArr != null) {
            if (jArr.length != 0) {
                int iA = this.f25635a.a();
                Iterator<Map.Entry<String, e>> it = a(jArr).entrySet().iterator();
                while (it.hasNext()) {
                    e value = it.next().getValue();
                    com.aliyun.svideosdk.common.impl.a aVar = value.f25640a;
                    if (aVar != null) {
                        aVar.a(jArr);
                        if (!value.f25640a.b()) {
                            a(value.f25640a);
                            com.aliyun.svideosdk.common.impl.a aVar2 = value.f25640a;
                            if (aVar2.a(aVar2.a().e()) != 0) {
                                Log.e("AliYunLog", "VideoThumbnailWrapper prepare failed!");
                                return -20007006;
                            }
                        }
                        if (!value.f25640a.c()) {
                            value.f25640a.e();
                        }
                        for (Map.Entry<Long, List<Long>> entry : value.b.entrySet()) {
                            value.f25640a.a(entry.getKey().longValue() * 1000, entry.getValue(), onThumbnailCompletion, 1000 * this.d.get(entry.getKey()).a());
                        }
                    }
                }
                return iA;
            }
        }
        Log.e("AliYunLog", "requestThumbnailImage failed: param is invalid");
        if (onThumbnailCompletion != null) {
            onThumbnailCompletion.onError(-2);
        }
        return -2;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public int setFastMode(boolean z) {
        Log.d(j, this + " Call setFastMode fastMode:" + z);
        Iterator<Map.Entry<String, h>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            int iA = it.next().getValue().a(z);
            if (iA != 0) {
                Log.e("AliYunLog", "setFastMode failed,error code:" + iA);
                return iA;
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIThumbnailFetcher
    public synchronized int setParameters(int i, int i2, AliyunIThumbnailFetcher.CropMode cropMode, VideoDisplayMode videoDisplayMode, int i3) {
        Log.d(j, this + " Call setParameters");
        Iterator<Map.Entry<String, h>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            h value = it.next().getValue();
            int iA = value.a(i, i2);
            if (iA != 0) {
                Log.e("AliYunLog", "Invalid width[" + i + "] or height[" + i2 + "]!");
                return iA;
            }
            value.a().a(cropMode);
            value.a().a(videoDisplayMode);
        }
        Iterator<Map.Entry<String, f>> it2 = this.c.entrySet().iterator();
        while (it2.hasNext()) {
            f value2 = it2.next().getValue();
            int iA2 = value2.a(i, i2);
            if (iA2 != 0) {
                Log.e("AliYunLog", "Invalid width[" + i + "] or height[" + i2 + "]!");
                return iA2;
            }
            value2.a().a(cropMode);
            value2.a().a(videoDisplayMode);
        }
        return 0;
    }
}
