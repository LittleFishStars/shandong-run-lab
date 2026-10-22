package com.aliyun.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.aliyun.utils.a;
import com.aliyun.utils.f;
import com.aliyun.utils.g;
import com.cicada.player.utils.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ThumbnailHelper {
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int MSG_KEY_BITMAP_FAIL = 2;
    private static final int MSG_KEY_BITMAP_SUCCESS = 3;
    private static final int MSG_KEY_PREPARE_FAIL = 0;
    private static final int MSG_KEY_PREPARE_SUCCESS = 1;
    private static final String TAG = "ThumbnailHelper";
    private ThumbnailInfo[] mThumbnailInfoArray;
    private String mUrl;
    private final Object lock = new Object();
    private Map<String, byte[]> mUrlDataMap = new HashMap();
    private volatile boolean hasPrepared = false;
    private OnPrepareListener mOnPrepareListener = null;
    private OnThumbnailGetListener mOnThumbnailGetListener = null;
    private ResultHandler mResultHandler = new ResultHandler(this);

    public class ByteHttp extends a {
        byte[] bytes;
        int len;

        private ByteHttp() {
            this.bytes = null;
            this.len = 0;
        }

        @Override // com.aliyun.utils.a
        public void handleErrorInputStream(InputStream inputStream) {
        }

        @Override // com.aliyun.utils.a
        public void handleOKInputStream(InputStream inputStream) {
            byte[] stream = ThumbnailHelper.readStream(inputStream);
            this.bytes = stream;
            if (stream != null) {
                this.len = stream.length;
            }
        }
    }

    public interface OnImgDataResultListener {
        void onFail();

        void onSuccess(byte[] bArr);
    }

    public interface OnPrepareListener {
        void onPrepareFail();

        void onPrepareSuccess();
    }

    public interface OnThumbnailGetListener {
        void onThumbnailGetFail(long j, String str);

        void onThumbnailGetSuccess(long j, ThumbnailBitmapInfo thumbnailBitmapInfo);
    }

    public static class ResultHandler extends Handler {
        private WeakReference<ThumbnailHelper> thumbnailHelperWeakReference;

        public ResultHandler(ThumbnailHelper thumbnailHelper) {
            super(Looper.getMainLooper());
            this.thumbnailHelperWeakReference = new WeakReference<>(thumbnailHelper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ThumbnailHelper thumbnailHelper = this.thumbnailHelperWeakReference.get();
            if (thumbnailHelper != null) {
                thumbnailHelper.handleMessage(message);
            }
            super.handleMessage(message);
        }
    }

    static {
        f.b();
    }

    public ThumbnailHelper(String str) {
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmap(ThumbnailInfo thumbnailInfo, byte[] bArr) {
        try {
            BitmapRegionDecoder bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance((InputStream) new ByteArrayInputStream(bArr), true);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            int i = thumbnailInfo.mLeft;
            int i2 = thumbnailInfo.mTop;
            return bitmapRegionDecoderNewInstance.decodeRegion(new Rect(i, i2, thumbnailInfo.mWidth + i, thumbnailInfo.mHeight + i2), options);
        } catch (IOException e) {
            e.printStackTrace();
            Logger.d(TAG, "获取缩略图异常。。" + e.getMessage());
            return null;
        }
    }

    private URLConnection getHttpUrlConnection(String str) {
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            try {
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                return uRLConnectionOpenConnection;
            } catch (Exception unused) {
                uRLConnection = uRLConnectionOpenConnection;
                return uRLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    private URLConnection getHttpsUrlConnection(String str) {
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            try {
                if (!(uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
                    return null;
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(5000);
                return uRLConnectionOpenConnection;
            } catch (Exception unused) {
                uRLConnection = uRLConnectionOpenConnection;
                return uRLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    private ThumbnailInfo getInfoByPosition(long j) {
        String str = TAG;
        Logger.d(str, "getInfoByPosition position = " + j);
        ThumbnailInfo[] thumbnailInfoArr = this.mThumbnailInfoArray;
        ThumbnailInfo thumbnailInfo = null;
        if (thumbnailInfoArr == null) {
            Logger.e(str, "mThumbnailInfoArray == null");
            return null;
        }
        int length = thumbnailInfoArr.length;
        for (int i = 0; i < length; i++) {
            ThumbnailInfo thumbnailInfo2 = this.mThumbnailInfoArray[i];
            if (thumbnailInfo2.mStart <= j && thumbnailInfo2.mUntil >= j) {
                thumbnailInfo = thumbnailInfo2;
                break;
            }
        }
        Logger.d(TAG, "mThumbnailInfoArray targetInfo = " + thumbnailInfo);
        return thumbnailInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getResponseCode(URLConnection uRLConnection) throws IOException {
        HttpURLConnection httpURLConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof HttpURLConnection)) {
                return 0;
            }
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getResponseCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native Object[] getThumbnailInfos(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public URLConnection getUrlConnection(String str) {
        if (str.startsWith("https://")) {
            return getHttpsUrlConnection(str);
        }
        if (str.startsWith("http://")) {
            return getHttpUrlConnection(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            OnPrepareListener onPrepareListener = this.mOnPrepareListener;
            if (onPrepareListener != null) {
                onPrepareListener.onPrepareSuccess();
                return;
            }
            return;
        }
        if (i == 0) {
            OnPrepareListener onPrepareListener2 = this.mOnPrepareListener;
            if (onPrepareListener2 != null) {
                onPrepareListener2.onPrepareFail();
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.mOnThumbnailGetListener != null) {
                this.mOnThumbnailGetListener.onThumbnailGetFail(message.getData().getLong("pos"), (String) message.obj);
            }
        } else {
            if (i != 3 || this.mOnThumbnailGetListener == null) {
                return;
            }
            long j = message.getData().getLong("pos");
            long j2 = message.getData().getLong("start");
            long j3 = message.getData().getLong("until");
            Bitmap bitmap = (Bitmap) message.obj;
            ThumbnailBitmapInfo thumbnailBitmapInfo = new ThumbnailBitmapInfo();
            thumbnailBitmapInfo.setPositionRange(new long[]{j2, j3});
            thumbnailBitmapInfo.setThumbnailBitmap(bitmap);
            this.mOnThumbnailGetListener.onThumbnailGetSuccess(j, thumbnailBitmapInfo);
        }
    }

    public static void loadClass() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void requestImgData(final String str, final OnImgDataResultListener onImgDataResultListener) {
        g.f25871a.submit(new Runnable() { // from class: com.aliyun.thumbnail.ThumbnailHelper.3
            /* JADX WARN: Code duplicated, block: B:62:0x0068 A[EXC_TOP_SPLITTER, PHI: r1 r2
              0x0068: PHI (r1v8 byte[]) = (r1v7 byte[]), (r1v10 byte[]) binds: [B:29:0x00a6, B:18:0x0066] A[DONT_GENERATE, DONT_INLINE]
              0x0068: PHI (r2v4 java.io.InputStream) = (r2v3 java.io.InputStream), (r2v6 java.io.InputStream) binds: [B:29:0x00a6, B:18:0x0066] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() {
                InputStream inputStream;
                byte[] stream;
                synchronized (ThumbnailHelper.this.lock) {
                    inputStream = null;
                    stream = ThumbnailHelper.this.mUrlDataMap.containsKey(str) ? (byte[]) ThumbnailHelper.this.mUrlDataMap.get(str) : null;
                }
                if (stream != null) {
                    onImgDataResultListener.onSuccess(stream);
                    return;
                }
                URLConnection urlConnection = ThumbnailHelper.this.getUrlConnection(str);
                if (urlConnection == null) {
                    Logger.e(ThumbnailHelper.TAG, "can not open url" + str);
                } else {
                    try {
                        try {
                            int responseCode = ThumbnailHelper.this.getResponseCode(urlConnection);
                            if (responseCode == 200) {
                                inputStream = urlConnection.getInputStream();
                                stream = ThumbnailHelper.readStream(inputStream);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                Logger.e(ThumbnailHelper.TAG, "open url responseCode = " + responseCode);
                            }
                        } catch (IOException e2) {
                            Logger.e(ThumbnailHelper.TAG, "open url exception = " + e2.getMessage());
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (stream == null) {
                    onImgDataResultListener.onFail();
                    return;
                }
                synchronized (ThumbnailHelper.this.lock) {
                    ThumbnailHelper.this.mUrlDataMap.put(str, stream);
                }
                onImgDataResultListener.onSuccess(stream);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPrepareFailMsg() {
        Message messageObtainMessage = this.mResultHandler.obtainMessage();
        messageObtainMessage.what = 0;
        this.mResultHandler.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPrepareSuccessMsg() {
        Message messageObtainMessage = this.mResultHandler.obtainMessage();
        messageObtainMessage.what = 1;
        this.mResultHandler.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequestBitmapFailMsg(String str, long j) {
        Message messageObtainMessage = this.mResultHandler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.obj = str;
        Bundle bundle = new Bundle();
        bundle.putLong("pos", j);
        messageObtainMessage.setData(bundle);
        this.mResultHandler.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequestBitmapSuccMsg(ThumbnailInfo thumbnailInfo, long j, Bitmap bitmap) {
        Message messageObtainMessage = this.mResultHandler.obtainMessage();
        messageObtainMessage.what = 3;
        messageObtainMessage.obj = bitmap;
        Bundle bundle = new Bundle();
        bundle.putLong("pos", j);
        bundle.putLong("start", thumbnailInfo.mStart);
        bundle.putLong("until", thumbnailInfo.mUntil);
        messageObtainMessage.setData(bundle);
        this.mResultHandler.sendMessage(messageObtainMessage);
    }

    public void prepare() {
        synchronized (this.lock) {
            if (this.hasPrepared) {
                Logger.e(TAG, "prepare again?");
            } else {
                this.hasPrepared = true;
                g.f25871a.submit(new Runnable() { // from class: com.aliyun.thumbnail.ThumbnailHelper.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        ByteHttp byteHttp = new ByteHttp();
                        byteHttp.doGet(ThumbnailHelper.this.mUrl);
                        Matcher matcher = Pattern.compile("([a-zA-Z]+://[^/]+).*[/]").matcher(ThumbnailHelper.this.mUrl);
                        if (matcher.find() && byteHttp.bytes != null) {
                            Object[] thumbnailInfos = ThumbnailHelper.this.getThumbnailInfos(matcher.group(0), new String(byteHttp.bytes));
                            if (thumbnailInfos == null) {
                                ThumbnailHelper.this.mThumbnailInfoArray = null;
                            } else {
                                ThumbnailHelper.this.mThumbnailInfoArray = (ThumbnailInfo[]) thumbnailInfos;
                            }
                        }
                        if (ThumbnailHelper.this.mThumbnailInfoArray != null) {
                            ThumbnailHelper.this.sendPrepareSuccessMsg();
                        } else {
                            ThumbnailHelper.this.sendPrepareFailMsg();
                        }
                    }
                });
            }
        }
    }

    public void requestBitmapAtPosition(final long j) {
        final ThumbnailInfo infoByPosition = getInfoByPosition(j);
        if (infoByPosition != null) {
            requestImgData(infoByPosition.mPath, new OnImgDataResultListener() { // from class: com.aliyun.thumbnail.ThumbnailHelper.2
                @Override // com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener
                public void onFail() {
                    ThumbnailHelper.this.sendRequestBitmapFailMsg("can not get thumbnail at position:" + j, j);
                }

                @Override // com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener
                public void onSuccess(byte[] bArr) {
                    Bitmap bitmap = ThumbnailHelper.this.getBitmap(infoByPosition, bArr);
                    if (bitmap != null) {
                        ThumbnailHelper.this.sendRequestBitmapSuccMsg(infoByPosition, j, bitmap);
                        return;
                    }
                    ThumbnailHelper.this.sendRequestBitmapFailMsg("can not get thumbnail at position:" + j, j);
                }
            });
            return;
        }
        sendRequestBitmapFailMsg("no match thumbnail at position:" + j, j);
    }

    public void setOnPrepareListener(OnPrepareListener onPrepareListener) {
        this.mOnPrepareListener = onPrepareListener;
    }

    public void setOnThumbnailGetListener(OnThumbnailGetListener onThumbnailGetListener) {
        this.mOnThumbnailGetListener = onThumbnailGetListener;
    }
}
