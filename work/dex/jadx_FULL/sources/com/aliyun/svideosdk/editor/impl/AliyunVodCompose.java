package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.sdk.android.vod.upload.model.FilePartInfo;
import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AliyunIBaseCompose;
import com.aliyun.svideosdk.editor.AliyunIComposeCallBack;
import com.aliyun.svideosdk.editor.AliyunIRenderCallback;
import com.aliyun.svideosdk.editor.AliyunIVodCompose;
import com.aliyun.svideosdk.editor.AliyunIVodUpload;
import com.aliyun.svideosdk.editor.ComposeAndUploadCallBack;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunVodCompose implements AliyunIVodCompose {
    private static final long FIRST_PART_PACKET_SIZE = 102400;
    private static final long PACKET_HEAD_SIZE = 48;
    private static final long PACKET_SIZE = 262144;
    private static WeakReference<Context> contextWeakReference;
    private AliyunIBaseCompose mAliyunIBaseCompose;
    private AliyunIVodUpload mAliyunIVodUpload;
    private ComposeAndUploadCallBack mComposeAndUploadCallBack;
    private String mOutputPath;
    private RandomAccessFile mRandomAccessFile;
    private String mTempOutputPath;
    private String mUploadAddress;
    private String mUploadAuth;
    private String mVideoId;
    private AliyunIVodCompose.AliyunComposeState state;
    private AliyunIVodCompose.AliyunComposeUploadState uploadState = AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE;
    private boolean mReportEnabled = true;
    private long mPartSize = 1048576;
    private long mPartListSize = 0;
    private List<FilePartInfo> mPartInfoList = new ArrayList();
    private HandlerThread mHandleThread = null;
    private Handler mIOHandler = null;
    private final com.aliyun.svideosdk.editor.a mPacketCallBack = new a();

    public class a implements com.aliyun.svideosdk.editor.a {

        /* JADX INFO: renamed from: com.aliyun.svideosdk.editor.impl.AliyunVodCompose$a$a, reason: collision with other inner class name */
        public class RunnableC0229a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f25729a;
            final /* synthetic */ byte[] b;

            public RunnableC0229a(int i, byte[] bArr) {
                this.f25729a = i;
                this.b = bArr;
            }

            /* JADX WARN: Code duplicated, block: B:37:0x012c A[EXC_TOP_SPLITTER, PHI: r1
              0x012c: PHI (r1v3 java.nio.channels.FileLock) = (r1v2 java.nio.channels.FileLock), (r1v6 java.nio.channels.FileLock) binds: [B:27:0x012a, B:21:0x0120] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
            @Override // java.lang.Runnable
            public void run() {
                if (AliyunVodCompose.this.mRandomAccessFile == null) {
                    AliyunVodCompose aliyunVodCompose = AliyunVodCompose.this;
                    aliyunVodCompose.mTempOutputPath = aliyunVodCompose.mOutputPath.replace(".mp4", "-temp.mp4");
                    try {
                        AliyunVodCompose.this.mRandomAccessFile = new RandomAccessFile(AliyunVodCompose.this.mTempOutputPath, "rw");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                FileLock fileLockLock = null;
                try {
                    fileLockLock = AliyunVodCompose.this.mRandomAccessFile.getChannel().lock(AliyunVodCompose.this.mRandomAccessFile.getFilePointer(), AliyunVodCompose.this.mRandomAccessFile.getFilePointer() + ((long) this.f25729a), false);
                    AliyunVodCompose.this.mRandomAccessFile.write(this.b);
                    long length = AliyunVodCompose.this.mRandomAccessFile.length();
                    if (length == 262192) {
                        FilePartInfo filePartInfo = new FilePartInfo();
                        filePartInfo.setPartNumber(1);
                        filePartInfo.setSeek(0L);
                        filePartInfo.setSize(102400L);
                        AliyunVodCompose.this.mPartListSize = filePartInfo.getSize();
                        AliyunVodCompose.this.mPartInfoList.add(filePartInfo);
                    }
                    if (length > 102400) {
                        long j = length - AliyunVodCompose.this.mPartListSize;
                        if (j >= AliyunVodCompose.this.mPartSize) {
                            int i = (int) (j / AliyunVodCompose.this.mPartSize);
                            for (int i2 = 0; i2 < i; i2++) {
                                FilePartInfo filePartInfo2 = new FilePartInfo();
                                filePartInfo2.setPartNumber(AliyunVodCompose.this.mPartInfoList.size() + 1);
                                filePartInfo2.setSeek(AliyunVodCompose.this.mPartListSize);
                                filePartInfo2.setSize(AliyunVodCompose.this.mPartSize);
                                AliyunVodCompose.this.mPartListSize += filePartInfo2.getSize();
                                AliyunVodCompose.this.mPartInfoList.add(filePartInfo2);
                            }
                        }
                    }
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException unused2) {
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                } catch (Throwable th) {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
                AliyunVodCompose.this.onUpload(false);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f25730a;

            public b(long j) {
                this.f25730a = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AliyunVodCompose.this.mRandomAccessFile != null) {
                    try {
                        AliyunVodCompose.this.mRandomAccessFile.seek(this.f25730a);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AliyunVodCompose.this.mRandomAccessFile != null) {
                    try {
                        if (AliyunVodCompose.this.mPartListSize != AliyunVodCompose.this.mRandomAccessFile.length()) {
                            FilePartInfo filePartInfo = new FilePartInfo();
                            filePartInfo.setPartNumber(AliyunVodCompose.this.mPartInfoList.size() + 1);
                            filePartInfo.setSeek(AliyunVodCompose.this.mPartListSize);
                            filePartInfo.setSize(AliyunVodCompose.this.mRandomAccessFile.length() - AliyunVodCompose.this.mPartListSize);
                            AliyunVodCompose.this.mPartListSize += filePartInfo.getSize();
                            AliyunVodCompose.this.mPartInfoList.add(filePartInfo);
                            AliyunVodCompose.this.onUpload(true);
                        }
                        AliyunVodCompose.this.mRandomAccessFile.close();
                        AliyunVodCompose.this.mRandomAccessFile = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void a(long j, int i) {
            AliyunVodCompose.this.getIOHandler().post(new b(j));
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void a(ByteBuffer byteBuffer, int i) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            AliyunVodCompose.this.getIOHandler().post(new RunnableC0229a(i, bArr));
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void onComposeCompleted() {
            AliyunVodCompose.this.getIOHandler().post(new c());
        }
    }

    public class b implements ComposeAndUploadCallBack.VideoUploadAuthCallBack {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack
        public void onFailure(int i, String str) {
            AliyunVodCompose.this.mComposeAndUploadCallBack.onUploadFailed(String.valueOf(i), str);
        }

        @Override // com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack
        public void onSuccess(String str, String str2, String str3) {
            if (AliyunVodCompose.this.mAliyunIVodUpload == null) {
                AliyunVodCompose.this.mAliyunIVodUpload = new AliyunVodUpload();
                AliyunVodCompose.this.mAliyunIVodUpload.init((Context) AliyunVodCompose.contextWeakReference.get(), AliyunVodCompose.this.mComposeAndUploadCallBack, AliyunVodCompose.this.mReportEnabled);
            }
            AliyunVodCompose.this.mVideoId = str;
            AliyunVodCompose.this.mUploadAddress = str2;
            AliyunVodCompose.this.mUploadAuth = str3;
            AliyunVodCompose.this.uploadState = AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH_SUCCEED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getIOHandler() {
        if (this.mIOHandler == null) {
            HandlerThread handlerThread = new HandlerThread("PacketIOThread");
            this.mHandleThread = handlerThread;
            handlerThread.start();
            this.mIOHandler = new Handler(this.mHandleThread.getLooper());
        }
        return this.mIOHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpload(boolean z) {
        AliyunIVodCompose.AliyunComposeUploadState aliyunComposeUploadState = this.uploadState;
        if (aliyunComposeUploadState == AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE) {
            this.uploadState = AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH;
            this.mComposeAndUploadCallBack.getVideoUploadAuth(new b());
        } else if (aliyunComposeUploadState == AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH_SUCCEED && this.mPartInfoList.size() > 1) {
            this.mAliyunIVodUpload.uploadVideoWithVod(this.mTempOutputPath, this.mUploadAddress, this.mUploadAuth, this.mPartInfoList);
            this.uploadState = AliyunIVodCompose.AliyunComposeUploadState.STATE_VIDEO_UPLOADING;
        } else if (this.uploadState == AliyunIVodCompose.AliyunComposeUploadState.STATE_VIDEO_UPLOADING) {
            this.mAliyunIVodUpload.updatePartInfoList(this.mTempOutputPath, this.mPartInfoList, z);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        if (this.mAliyunIBaseCompose == null) {
            return -20011023;
        }
        if (this.mComposeAndUploadCallBack != null) {
            cancelUpload();
        }
        return this.mAliyunIBaseCompose.cancelCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int cancelUpload() {
        AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.cancelUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(String str, String str2, AliyunIComposeCallBack aliyunIComposeCallBack) {
        AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.compose(str, str2, aliyunIComposeCallBack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int composeAndUpload(String str, String str2, ComposeAndUploadCallBack composeAndUploadCallBack) {
        this.mOutputPath = str2;
        this.mComposeAndUploadCallBack = composeAndUploadCallBack;
        AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose instanceof AliyunBaseCompose) {
            ((AliyunBaseCompose) aliyunIBaseCompose).setPacketCallBack(this.mPacketCallBack);
        }
        return compose(str, str2, composeAndUploadCallBack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public AliyunIVodCompose.AliyunComposeState getState() {
        return this.state;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(Context context) {
        contextWeakReference = new WeakReference<>(context);
        if (this.mAliyunIBaseCompose == null) {
            this.mAliyunIBaseCompose = new AliyunBaseCompose();
        }
        return this.mAliyunIBaseCompose.init(contextWeakReference.get());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int init(Context context, boolean z) {
        this.mReportEnabled = z;
        contextWeakReference = new WeakReference<>(context);
        if (this.mAliyunIBaseCompose == null) {
            this.mAliyunIBaseCompose = new AliyunBaseCompose();
        }
        return this.mAliyunIBaseCompose.init(contextWeakReference.get());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.pauseCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int pauseUpload() {
        AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.pauseUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int refreshWithUploadAuth(String str) {
        AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.refreshWithUploadAuth(str);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose != null) {
            aliyunIBaseCompose.release();
            this.mAliyunIBaseCompose = null;
        }
        AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload != null) {
            aliyunIVodUpload.release();
            this.mAliyunIVodUpload = null;
        }
        if (!com.aliyun.common.utils.q.b(this.mTempOutputPath)) {
            com.aliyun.common.utils.g.a(this.mTempOutputPath);
            this.mTempOutputPath = null;
        }
        if (this.mIOHandler != null) {
            this.mHandleThread.quit();
            this.mHandleThread = null;
            this.mIOHandler = null;
            RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    this.mRandomAccessFile = null;
                } catch (IOException unused) {
                }
            }
        }
        this.mComposeAndUploadCallBack = null;
        AliyunIVodCompose.AliyunComposeState aliyunComposeState = AliyunIVodCompose.AliyunComposeState.STATE_IDLE;
        this.state = null;
        this.uploadState = AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.resumeCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int resumeUpload() {
        AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.resumeUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void setRenderCallback(AliyunIRenderCallback aliyunIRenderCallback) {
        this.mAliyunIBaseCompose.setRenderCallback(aliyunIRenderCallback);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int uploadImageWithVod(String str, String str2, String str3, AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.mAliyunIVodUpload == null) {
            AliyunVodUpload aliyunVodUpload = new AliyunVodUpload();
            this.mAliyunIVodUpload = aliyunVodUpload;
            aliyunVodUpload.init(contextWeakReference.get(), aliyunIVodUploadCallBack, this.mReportEnabled);
        }
        this.state = AliyunIVodCompose.AliyunComposeState.STATE_IMAGE_UPLOADING;
        return this.mAliyunIVodUpload.uploadImageWithVod(str, str2, str3);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int uploadVideoWithVod(String str, String str2, String str3, AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.mAliyunIVodUpload == null) {
            AliyunVodUpload aliyunVodUpload = new AliyunVodUpload();
            this.mAliyunIVodUpload = aliyunVodUpload;
            aliyunVodUpload.init(contextWeakReference.get(), aliyunIVodUploadCallBack, this.mReportEnabled);
        }
        this.state = AliyunIVodCompose.AliyunComposeState.STATE_VIDEO_UPLOADING;
        return this.mAliyunIVodUpload.uploadVideoWithVod(str, str2, str3);
    }
}
