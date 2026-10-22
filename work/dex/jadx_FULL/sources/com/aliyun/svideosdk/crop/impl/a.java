package com.aliyun.svideosdk.crop.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.common.utils.m;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.crop.AliyunICrop;
import com.aliyun.svideosdk.crop.CropCallback;
import com.aliyun.svideosdk.crop.CropParam;
import com.aliyun.svideosdk.transcode.NativeParser;
import com.aliyun.svideosdk.transcode.NativeTranscode2;
import com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class a implements AliyunICrop {
    private static final ArrayList<String> l = new C0224a();
    private static final ArrayList<String> m = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25699a;
    private CropCallback b;
    private NativeTranscode2 c;
    private NativeTranscode2InitStruct d;
    private MediaMetadataRetriever e;
    private CropParam f;
    private byte g;
    private final Object h;
    private Handler i;
    private long j;
    private com.aliyun.common.c.b.a k;

    /* JADX INFO: renamed from: com.aliyun.svideosdk.crop.impl.a$a, reason: collision with other inner class name */
    public static class C0224a extends ArrayList {
        public C0224a() {
            add("aac");
            add(FileTypeUtils.FILE_TYPE_MP3);
            add("amr");
            add("pcm");
            add("no_audio");
            add("unknown");
        }
    }

    public static class b extends ArrayList {
        public b() {
            add("h264");
            add("hevc");
            add("mpeg4");
            add("3gp");
            add("h263");
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.b != null) {
                a.this.b.onComplete(0L);
            }
        }
    }

    public class d implements NativeTranscode2.TranscodeCallback {

        /* JADX INFO: renamed from: com.aliyun.svideosdk.crop.impl.a$d$a, reason: collision with other inner class name */
        public class RunnableC0225a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25702a;

            public RunnableC0225a(int i) {
                this.f25702a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b != null) {
                    a.this.b.onProgress(this.f25702a);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25703a;

            public b(int i) {
                this.f25703a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.h) {
                    if (a.this.c != null) {
                        a.this.c.uninit();
                    }
                    a.this.g = (byte) 0;
                }
                a.this.a(com.aliyun.svideosdk.common.a.a(this.f25703a));
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.h) {
                    long duration = a.this.c != null ? a.this.c.getDuration() : 0L;
                    if (a.this.b != null && a.this.g == 1) {
                        a.this.g = (byte) 0;
                        a.this.b.onComplete(duration);
                    } else if (a.this.b != null && a.this.g == 2) {
                        a.this.g = (byte) 0;
                        a.this.b.onCancelComplete();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.aliyun.svideosdk.crop.impl.a$d$d, reason: collision with other inner class name */
        public class RunnableC0226d implements Runnable {
            public RunnableC0226d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.uninit();
                }
            }
        }

        public d() {
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onError(int i) {
            a.this.i.post(new b(i));
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onExit() {
            if (a.this.g == 1) {
                a aVar = a.this;
                aVar.a(aVar.j);
            }
            a.this.j = 0L;
            a.this.i.post(new c());
            a.this.i.postDelayed(new RunnableC0226d(), 200L);
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onProgress(int i) {
            a.this.i.post(new RunnableC0225a(i));
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f25706a;

        public e(long j) {
            this.f25706a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2 = "adr";
            File file = new File(a.this.f.getOutputPath());
            if (file.exists()) {
                HashMap<String, String> map = new HashMap<>();
                try {
                    map.put(AliyunLogKey.KEY_SIZE, String.valueOf(file.length()));
                    try {
                        map.put(RVParams.TITLE_COLOR, String.valueOf((System.nanoTime() - this.f25706a) / 1000));
                        map.put(AliyunLogKey.KEY_OUTPUT_PATH, a.this.f.getOutputPath());
                        a.this.e.setDataSource(file.getPath());
                        map.put("dr", a.this.e.extractMetadata(9) + "000");
                        map.put(AliyunLogKey.KEY_WIDTH, a.this.e.extractMetadata(18));
                        map.put(AliyunLogKey.KEY_HEIGHT, a.this.e.extractMetadata(19));
                        map.put(AliyunLogKey.KEY_VIDEO_CODEC, a.this.e.extractMetadata(12));
                        map.put("fm", a.this.e.extractMetadata(12));
                        map.put("br", a.this.e.extractMetadata(20));
                        map.put(AliyunLogKey.KEY_FPS, String.valueOf(m.a(a.this.f.getOutputPath())));
                        str2 = "adr";
                        try {
                            map.put(str2, a.this.e.extractMetadata(9) + "000");
                            str = "vdr";
                            try {
                                map.put(str, a.this.e.extractMetadata(9) + "000");
                            } catch (Exception unused) {
                                map.put("dr", "0");
                                map.put(AliyunLogKey.KEY_WIDTH, "0");
                                map.put(AliyunLogKey.KEY_HEIGHT, "0");
                                map.put(AliyunLogKey.KEY_VIDEO_CODEC, "unknown");
                                map.put("fm", "unknown");
                                map.put("br", "0");
                                map.put(AliyunLogKey.KEY_FPS, "0");
                                map.put(str2, "0");
                                map.put(str, "0");
                            }
                        } catch (Exception unused2) {
                            str = "vdr";
                        }
                    } catch (Exception unused3) {
                        str = "vdr";
                        str2 = "adr";
                    }
                } catch (Exception unused4) {
                    str = "vdr";
                }
                if (a.this.k != null) {
                    a.this.k.b(map);
                }
            }
        }
    }

    public class f implements Thread.UncaughtExceptionHandler {
        public f(a aVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            com.aliyun.common.c.a.a.b("AliYunLog", "parse File failed, msg is " + th.getMessage());
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25707a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[VideoCodecs.values().length];
            c = iArr;
            try {
                iArr[VideoCodecs.H264_HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[VideoCodecs.H264_SOFT_OPENH264.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[VideoDisplayMode.values().length];
            b = iArr2;
            try {
                iArr2[VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[MediaType.values().length];
            f25707a = iArr3;
            try {
                iArr3[MediaType.ANY_IMAGE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25707a[MediaType.ANY_AUDIO_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25707a[MediaType.ANY_VIDEO_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Context context) {
        String strA = com.aliyun.common.c.c.a.a();
        this.f25699a = strA;
        this.c = new NativeTranscode2();
        this.d = new NativeTranscode2InitStruct();
        this.e = new MediaMetadataRetriever();
        this.g = (byte) 0;
        this.h = new Object();
        this.i = null;
        this.j = 0L;
        this.k = new com.aliyun.common.c.b.a(context, strA);
        com.aliyun.common.c.a.a.c("AliYunLog", "AliyunCrop2 constructor");
        NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
        com.aliyun.common.c.b.a aVar = this.k;
        nativeTranscode2InitStruct.reportId = aVar == null ? -1L : aVar.a();
        this.i = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        return a(i, true);
    }

    private int a(int i, boolean z) {
        CropCallback cropCallback;
        com.aliyun.common.c.a.a.b("AliYunLog", "crop occur error :" + i);
        if (z && (cropCallback = this.b) != null) {
            cropCallback.onError(i);
        }
        com.aliyun.common.c.b.a aVar = this.k;
        if (aVar != null) {
            aVar.a(i);
        }
        return i;
    }

    private int a(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e2) {
            com.aliyun.common.c.a.a.b("AliYunLog", "cannot read exif" + e2);
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e  */
    private int a(String str, String str2, Rect rect) {
        int i;
        boolean zA;
        if (str == null || !new File(str).exists()) {
            i = -20002003;
        } else if (str2 == null) {
            i = -20003021;
        } else {
            com.aliyun.svideosdk.common.b.c.a aVar = new com.aliyun.svideosdk.common.b.c.a();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            float f2 = (i2 * 1.0f) / i3;
            float fWidth = (rect.width() * 1.0f) / rect.height();
            int iA = a(str);
            if (f2 != fWidth) {
                int i4 = g.b[this.f.getScaleMode().ordinal()];
                if (i4 == 1) {
                    zA = aVar.a(str, str2, this.f.getOutputWidth(), this.f.getOutputHeight(), i2, i3, this.f.getFillColor(), iA, Bitmap.Config.ARGB_8888);
                } else if (i4 != 2) {
                    zA = false;
                } else {
                    zA = aVar.a(str, str2, rect, this.f.getOutputWidth(), this.f.getOutputHeight(), iA, Bitmap.Config.ARGB_8888);
                }
            } else {
                zA = aVar.a(str, str2, rect, this.f.getOutputWidth(), this.f.getOutputHeight(), iA, Bitmap.Config.ARGB_8888);
            }
            if (zA) {
                this.i.post(new c());
                return 0;
            }
            i = -20004007;
        }
        return a(i);
    }

    private int a(boolean z) {
        int iInit;
        if (this.f.getInputPath() == null || this.f.getInputPath().isEmpty() || !new File(this.f.getInputPath()).exists()) {
            iInit = -20003004;
        } else if (this.f.getOutputPath() == null || this.f.getOutputPath().isEmpty()) {
            iInit = -20003021;
        } else {
            com.aliyun.common.c.a.a.a("AliYunLog", "Call start crop video");
            NativeParser nativeParser = new NativeParser();
            nativeParser.init(this.f.getInputPath());
            boolean zContains = m.contains(nativeParser.getValue(1));
            boolean zContains2 = l.contains(nativeParser.getValue(16));
            nativeParser.release();
            nativeParser.dispose();
            synchronized (this.h) {
                if (this.g != 0) {
                    return a(-20010001);
                }
                this.g = (byte) 1;
                if (this.f == null) {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    iInit = -20010002;
                } else if (z && !zContains) {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    iInit = -20004001;
                } else if (zContains2) {
                    NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
                    nativeTranscode2InitStruct.needAudio = true;
                    nativeTranscode2InitStruct.needVideo = z;
                    iInit = this.c.init(nativeTranscode2InitStruct);
                    if (iInit == 0) {
                        int iStart = this.c.start();
                        if (iStart >= 0) {
                            this.j = System.nanoTime();
                            return 0;
                        }
                        synchronized (this.h) {
                            this.g = (byte) 0;
                        }
                        return a(iStart);
                    }
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    com.aliyun.common.c.a.a.b("AliYunLog", "NativeTranscode init failed, return " + iInit);
                } else {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    iInit = -20004002;
                }
            }
        }
        return a(iInit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.k != null) {
            Thread thread = new Thread(new e(j));
            thread.setUncaughtExceptionHandler(new f(this));
            thread.start();
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void cancel() {
        com.aliyun.common.c.a.a.c("AliYunLog", "AliyunCrop cancel");
        synchronized (this.h) {
            if (this.g == 1) {
                this.g = (byte) 2;
                com.aliyun.common.c.a.a.a("AliYunLog", "call crop cancel");
                this.k.c();
                this.c.cancel();
            }
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void dispose() {
        com.aliyun.common.c.a.a.c("AliYunLog", "AliyunCrop2 dispose");
        synchronized (this.h) {
            NativeTranscode2 nativeTranscode2 = this.c;
            if (nativeTranscode2 != null) {
                nativeTranscode2.dispose();
            }
            this.b = null;
            com.aliyun.common.c.b.a aVar = this.k;
            if (aVar != null) {
                aVar.b();
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.e;
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.g = (byte) 0;
            } else {
                this.g = (byte) 0;
            }
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public long getVideoDuration(String str) throws Exception {
        String value;
        if (TextUtils.isEmpty(str)) {
            com.aliyun.common.c.a.a.b("AliYunLog", "videoPath is empty");
            return 0L;
        }
        NativeParser nativeParser = new NativeParser();
        int iInit = nativeParser.init(str);
        if (iInit != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "NativeParser init failed: " + iInit);
            value = null;
        } else {
            value = nativeParser.getValue(3);
        }
        nativeParser.release();
        nativeParser.dispose();
        if (value == null || value.isEmpty()) {
            return 0L;
        }
        return Long.parseLong(value);
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void setCropCallback(CropCallback cropCallback) {
        this.b = cropCallback;
        this.d.cb = new d();
    }

    /* JADX WARN: Code duplicated, block: B:68:0x012d  */
    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int setCropParam(CropParam cropParam) {
        String str;
        NativeTranscode2 nativeTranscode2;
        int iA;
        com.aliyun.svideosdk.c.e eVar;
        int i;
        Exception exc;
        int i2;
        int i3;
        int outputHeight;
        com.aliyun.common.c.a.a.c("AliYunLog", "AliyunCrop setCropParam");
        if (cropParam == null) {
            str = "AliyunCrop setCropParam failed ,param is null";
        } else {
            int outputWidth = cropParam.getOutputWidth();
            if (outputWidth % 2 != 0) {
                cropParam.setOutputWidth(outputWidth - 1);
            }
            int outputHeight2 = cropParam.getOutputHeight();
            if (outputHeight2 % 2 != 0) {
                cropParam.setOutputHeight(outputHeight2 - 1);
            }
            if (cropParam.getInputPath() != null && new File(cropParam.getInputPath()).exists() && cropParam.getOutputPath() != null) {
                this.f = cropParam;
                if (cropParam.getMediaType() == MediaType.ANY_IMAGE_TYPE) {
                    return 0;
                }
                if (cropParam.getScaleMode().ordinal() == 0) {
                    this.d.cropBackColor = cropParam.getFillColor();
                }
                Rect cropRect = cropParam.getCropRect();
                if (cropRect == null) {
                    cropRect = new Rect();
                }
                if (cropParam.getScaleMode().ordinal() == 0 && cropRect.isEmpty()) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(cropParam.getInputPath());
                    try {
                        try {
                            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                            if (i4 == 90 || i4 == 270) {
                                int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                                try {
                                    i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                                    i3 = i5;
                                    try {
                                        mediaMetadataRetriever.release();
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                    }
                                } catch (Exception e3) {
                                    exc = e3;
                                    i2 = i5;
                                    i = 0;
                                    com.aliyun.common.c.a.a.b("AliYunLog", "AliyunCrop setCropParam failed  catch exception " + exc.toString());
                                    exc.printStackTrace();
                                    try {
                                        mediaMetadataRetriever.release();
                                        i3 = i2;
                                    } catch (Exception e4) {
                                        e = e4;
                                        i3 = i2;
                                        e.printStackTrace();
                                    }
                                }
                                if (i > cropParam.getOutputWidth() || i3 <= cropParam.getOutputHeight()) {
                                    float f2 = i;
                                    float f3 = i3;
                                    float fMin = Math.min(f2 / cropParam.getOutputWidth(), f3 / cropParam.getOutputHeight());
                                    int outputWidth2 = (int) ((((f2 / fMin) - cropParam.getOutputWidth()) / 2.0f) * fMin);
                                    cropRect.left = outputWidth2;
                                    cropRect.right = (int) (outputWidth2 + (cropParam.getOutputWidth() * fMin));
                                    int outputHeight3 = (int) ((((f3 / fMin) - cropParam.getOutputHeight()) / 2.0f) * fMin);
                                    cropRect.top = outputHeight3;
                                    outputHeight = (int) (outputHeight3 + (cropParam.getOutputHeight() * fMin));
                                } else {
                                    int outputWidth3 = (i - cropParam.getOutputWidth()) / 2;
                                    cropRect.left = outputWidth3;
                                    cropRect.right = outputWidth3 + cropParam.getOutputWidth();
                                    int outputHeight4 = (i3 - cropParam.getOutputHeight()) / 2;
                                    cropRect.top = outputHeight4;
                                    outputHeight = outputHeight4 + cropParam.getOutputHeight();
                                }
                                cropRect.bottom = outputHeight;
                            } else {
                                i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                                try {
                                    i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e5) {
                                    exc = e5;
                                    i2 = 0;
                                    com.aliyun.common.c.a.a.b("AliYunLog", "AliyunCrop setCropParam failed  catch exception " + exc.toString());
                                    exc.printStackTrace();
                                    mediaMetadataRetriever.release();
                                    i3 = i2;
                                }
                                if (i > cropParam.getOutputWidth()) {
                                    float f4 = i;
                                    float f5 = i3;
                                    float fMin2 = Math.min(f4 / cropParam.getOutputWidth(), f5 / cropParam.getOutputHeight());
                                    int outputWidth4 = (int) ((((f4 / fMin2) - cropParam.getOutputWidth()) / 2.0f) * fMin2);
                                    cropRect.left = outputWidth4;
                                    cropRect.right = (int) (outputWidth4 + (cropParam.getOutputWidth() * fMin2));
                                    int outputHeight5 = (int) ((((f5 / fMin2) - cropParam.getOutputHeight()) / 2.0f) * fMin2);
                                    cropRect.top = outputHeight5;
                                    outputHeight = (int) (outputHeight5 + (cropParam.getOutputHeight() * fMin2));
                                } else {
                                    float f6 = i;
                                    float f7 = i3;
                                    float fMin3 = Math.min(f6 / cropParam.getOutputWidth(), f7 / cropParam.getOutputHeight());
                                    int outputWidth5 = (int) ((((f6 / fMin3) - cropParam.getOutputWidth()) / 2.0f) * fMin3);
                                    cropRect.left = outputWidth5;
                                    cropRect.right = (int) (outputWidth5 + (cropParam.getOutputWidth() * fMin3));
                                    int outputHeight6 = (int) ((((f7 / fMin3) - cropParam.getOutputHeight()) / 2.0f) * fMin3);
                                    cropRect.top = outputHeight6;
                                    outputHeight = (int) (outputHeight6 + (cropParam.getOutputHeight() * fMin3));
                                }
                                cropRect.bottom = outputHeight;
                            }
                        } catch (Exception e6) {
                            i = 0;
                            exc = e6;
                            i2 = 0;
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                        throw th;
                    }
                }
                this.d.intputPath = cropParam.getInputPath();
                this.d.outputPath = cropParam.getOutputPath();
                this.d.cropMode = cropParam.getScaleMode() == VideoDisplayMode.FILL ? 0 : 1;
                NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
                int i6 = cropRect.left;
                nativeTranscode2InitStruct.cropX = i6;
                int i7 = cropRect.top;
                nativeTranscode2InitStruct.cropY = i7;
                nativeTranscode2InitStruct.cropWidth = cropRect.right - i6;
                nativeTranscode2InitStruct.cropHeight = cropRect.bottom - i7;
                TimeUnit timeUnit = TimeUnit.MICROSECONDS;
                nativeTranscode2InitStruct.startTime = cropParam.getStartTime(timeUnit);
                this.d.endTime = cropParam.getEndTime(timeUnit);
                this.d.outputWidth = cropParam.getOutputWidth();
                this.d.outputHeight = cropParam.getOutputHeight();
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.AudioCodecIdKey.a(), com.aliyun.svideosdk.c.b.SoftAAC.a());
                int i8 = g.c[this.f.getVideoCodec().ordinal()];
                if (i8 != 1) {
                    if (i8 == 2) {
                        nativeTranscode2 = this.c;
                        iA = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                        eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_OPENH264;
                    }
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.f.getCrf());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), cropParam.getFrameRate());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), cropParam.getGop());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), cropParam.getQuality().ordinal());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), cropParam.getvideobitrate());
                    return 0;
                }
                nativeTranscode2 = this.c;
                iA = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_HARDWARE;
                nativeTranscode2.setExtraParam(iA, eVar.a());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.f.getCrf());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), cropParam.getFrameRate());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), cropParam.getGop());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), cropParam.getQuality().ordinal());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), cropParam.getvideobitrate());
                return 0;
            }
            str = "AliyunCrop setCropParam failed ,input path " + cropParam.getInputPath() + " output path " + cropParam.getOutputPath();
        }
        com.aliyun.common.c.a.a.b("AliYunLog", str);
        return -20010002;
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void setUseHW(boolean z) {
        com.aliyun.common.c.a.a.c("AliYunLog", "AliyunCrop setUseHW:" + z);
        this.d.useHWDecoder = z;
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCrop() {
        com.aliyun.common.c.a.a.c("AliYunLog", "Call start crop");
        CropParam cropParam = this.f;
        if (cropParam == null) {
            return a(-20010002);
        }
        int i = g.f25707a[cropParam.getMediaType().ordinal()];
        if (i == 1) {
            return com.aliyun.svideosdk.common.a.a(a(this.f.getInputPath(), this.f.getOutputPath(), this.f.getCropRect()));
        }
        if (i != 2) {
            return i != 3 ? a(-20004004) : com.aliyun.svideosdk.common.a.a(a(true));
        }
        String inputPath = this.f.getInputPath();
        String outputPath = this.f.getOutputPath();
        CropParam cropParam2 = this.f;
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return com.aliyun.svideosdk.common.a.a(startCropAudio(inputPath, outputPath, cropParam2.getStartTime(timeUnit), this.f.getEndTime(timeUnit)));
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCropAudio(String str, String str2, long j, long j2) {
        return startCropAudio(str, str2, j, j2, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCropAudio(String str, String str2, long j, long j2, TimeUnit timeUnit) {
        if (str == null || !new File(str).exists()) {
            return a(-20002003);
        }
        if (str2 == null) {
            return a(-20003021);
        }
        CropParam cropParam = new CropParam();
        cropParam.setInputPath(str);
        cropParam.setOutputPath(str2);
        cropParam.setStartTime(j, timeUnit);
        cropParam.setEndTime(j2, timeUnit);
        int cropParam2 = setCropParam(cropParam);
        return cropParam2 != 0 ? a(cropParam2) : com.aliyun.svideosdk.common.a.a(a(false));
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public String version() {
        return "6.7.0";
    }
}
