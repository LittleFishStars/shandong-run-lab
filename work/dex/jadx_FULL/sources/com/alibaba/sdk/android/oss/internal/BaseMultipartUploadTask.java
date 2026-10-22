package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected final int PART_SIZE_ALIGN_NUM;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected Uri mUploadUri;
    protected long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = iAvailableProcessors;
        int i = iAvailableProcessors < 5 ? iAvailableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = iAvailableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.mPoolExecutor = new ThreadPoolExecutor(i, iAvailableProcessors, 3000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES;
    }

    public abstract void abortThisUpload();

    public long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
        }
    }

    public void checkException() throws ServiceException, ClientException, IOException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            }
            if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            }
            if (!(exc instanceof ClientException)) {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
            throw ((ClientException) exc);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0056 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0L;
            File file = new File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
            try {
                parcelFileDescriptorOpenFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                this.mFileLength = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException e) {
                    OSSLog.logThrowable2Local(e);
                }
            } catch (IOException e2) {
                throw new ClientException(e2.getMessage(), e2, Boolean.TRUE);
            }
        }
        if (this.mFileLength == 0) {
            throw new ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i = this.mPartAttr[1];
        OSSLog.logDebug("[checkInitData] - partNumber : " + i);
        OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i > 1 && partSize < 102400) {
            throw new ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        long j2 = j / partSize;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 == 1) {
            partSize = j;
        } else if (j2 > 5000) {
            partSize = ceilPartSize(j / ((long) 4999));
            long j3 = this.mFileLength;
            j2 = (j3 / partSize) + (j3 % partSize == 0 ? 0L : 1L);
        }
        int i = (int) partSize;
        iArr[0] = i;
        iArr[1] = (int) j2;
        this.mRequest.setPartSize(i);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i);
        long j4 = this.mFileLength % partSize;
        if (j4 != 0) {
            partSize = j4;
        }
        this.mLastPartSize = partSize;
    }

    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ServiceException, ClientException {
        CompleteMultipartUploadResult completeMultipartUploadResultSyncCompleteMultipartUpload;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() { // from class: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.2
                @Override // java.util.Comparator
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                for (String str : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!str.equals(OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(str, this.mRequest.getMetadata().getRawMetadata().get(str));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResultSyncCompleteMultipartUpload = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResultSyncCompleteMultipartUpload = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResultSyncCompleteMultipartUpload;
    }

    public abstract Result doMultipartUpload() throws ServiceException, ClientException, InterruptedException, IOException;

    public abstract void initMultipartUploadId() throws ServiceException, ClientException, IOException;

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }

    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    public abstract void processException(Exception exc);

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:32:0x00a7, B:34:0x00bc, B:35:0x00c7, B:37:0x00e0, B:46:0x011a, B:40:0x00ee, B:41:0x0100, B:42:0x0101, B:44:0x010d, B:45:0x0110), top: B:102:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e0 A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:32:0x00a7, B:34:0x00bc, B:35:0x00c7, B:37:0x00e0, B:46:0x011a, B:40:0x00ee, B:41:0x0100, B:42:0x0101, B:44:0x010d, B:45:0x0110), top: B:102:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ee A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:32:0x00a7, B:34:0x00bc, B:35:0x00c7, B:37:0x00e0, B:46:0x011a, B:40:0x00ee, B:41:0x0100, B:42:0x0101, B:44:0x010d, B:45:0x0110), top: B:102:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0101 A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:32:0x00a7, B:34:0x00bc, B:35:0x00c7, B:37:0x00e0, B:46:0x011a, B:40:0x00ee, B:41:0x0100, B:42:0x0101, B:44:0x010d, B:45:0x0110), top: B:102:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x010d A[Catch: all -> 0x012b, TryCatch #5 {all -> 0x012b, blocks: (B:32:0x00a7, B:34:0x00bc, B:35:0x00c7, B:37:0x00e0, B:46:0x011a, B:40:0x00ee, B:41:0x0100, B:42:0x0101, B:44:0x010d, B:45:0x0110), top: B:102:0x00a7 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x011d A[Catch: IOException -> 0x0154, TRY_ENTER, TryCatch #3 {IOException -> 0x0154, blocks: (B:48:0x011d, B:50:0x0122, B:52:0x0127, B:74:0x0150, B:78:0x0158, B:80:0x015d), top: B:101:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0122 A[Catch: IOException -> 0x0154, TryCatch #3 {IOException -> 0x0154, blocks: (B:48:0x011d, B:50:0x0122, B:52:0x0127, B:74:0x0150, B:78:0x0158, B:80:0x015d), top: B:101:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0127 A[Catch: IOException -> 0x0154, TRY_LEAVE, TryCatch #3 {IOException -> 0x0154, blocks: (B:48:0x011d, B:50:0x0122, B:52:0x0127, B:74:0x0150, B:78:0x0158, B:80:0x015d), top: B:101:0x0001 }] */
    public void uploadPart(int i, int i2, int i3) throws Throwable {
        Throwable th;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        RandomAccessFile randomAccessFile;
        UploadPartRequest uploadPartRequest;
        UploadPartResult uploadPartResultSyncUploadPart;
        PartETag partETag;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (this.mContext.getCancellationHandler().isCancelled()) {
                    this.mPoolExecutor.getQueue().clear();
                    return;
                }
                synchronized (this.mLock) {
                    this.mRunPartTaskCount++;
                }
                preUploadPart(i, i2, i3);
                byte[] bArr = new byte[i2];
                long partSize = ((long) i) * this.mRequest.getPartSize();
                if (this.mUploadUri != null) {
                    InputStream inputStreamOpenInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStreamOpenInputStream);
                        try {
                            bufferedInputStream2.skip(partSize);
                            bufferedInputStream2.read(bArr, 0, i2);
                            randomAccessFile = null;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = inputStreamOpenInputStream;
                            try {
                                uploadPartRequest = new UploadPartRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, i + 1);
                                uploadPartRequest.setPartContent(bArr);
                                uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                                uploadPartRequest.setCRC64(this.mRequest.getCRC64());
                                uploadPartResultSyncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                                synchronized (this.mLock) {
                                    try {
                                        partETag = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart.getETag());
                                        long j = i2;
                                        partETag.setPartSize(j);
                                        if (this.mCheckCRC64) {
                                            partETag.setCRC64(uploadPartResultSyncUploadPart.getClientCRC().longValue());
                                        }
                                        this.mPartETags.add(partETag);
                                        this.mUploadedLength += j;
                                        uploadPartFinish(partETag);
                                        if (this.mContext.getCancellationHandler().isCancelled()) {
                                            if (this.mPartETags.size() == i3 - this.mPartExceptionCount) {
                                                notifyMultipartThread();
                                            }
                                            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                                        } else if (this.mPartETags.size() != this.mRunPartTaskCount - this.mPartExceptionCount) {
                                            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
                                            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e = e;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Throwable th3) {
                                th = th3;
                                randomAccessFile2 = randomAccessFile;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = inputStreamOpenInputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = inputStreamOpenInputStream;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                } else {
                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.mUploadFile, "r");
                    try {
                        randomAccessFile3.seek(partSize);
                        randomAccessFile3.readFully(bArr, 0, i2);
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile = randomAccessFile3;
                        uploadPartRequest = new UploadPartRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, i + 1);
                        uploadPartRequest.setPartContent(bArr);
                        uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                        uploadPartRequest.setCRC64(this.mRequest.getCRC64());
                        uploadPartResultSyncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                        synchronized (this.mLock) {
                            partETag = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart.getETag());
                            long j2 = i2;
                            partETag.setPartSize(j2);
                            if (this.mCheckCRC64) {
                                partETag.setCRC64(uploadPartResultSyncUploadPart.getClientCRC().longValue());
                            }
                            this.mPartETags.add(partETag);
                            this.mUploadedLength += j2;
                            uploadPartFinish(partETag);
                            if (this.mContext.getCancellationHandler().isCancelled()) {
                                if (this.mPartETags.size() == i3 - this.mPartExceptionCount) {
                                    notifyMultipartThread();
                                }
                                onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                            } else if (this.mPartETags.size() != this.mRunPartTaskCount - this.mPartExceptionCount) {
                                TaskCancelException taskCancelException2 = new TaskCancelException("multipart cancel");
                                throw new ClientException(taskCancelException2.getMessage(), taskCancelException2, Boolean.TRUE);
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                                return;
                            }
                            return;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                    }
                }
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e5) {
                        OSSLog.logThrowable2Local(e5);
                        throw th;
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream == null) {
                    throw th;
                }
                inputStream.close();
                throw th;
            } catch (IOException e6) {
                OSSLog.logThrowable2Local(e6);
                return;
            }
        } catch (Exception e7) {
            e = e7;
            inputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedInputStream = null;
        }
        try {
            processException(e);
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result result = (Result) doMultipartUpload();
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (Exception e2) {
            ClientException clientException = e2 instanceof ClientException ? (ClientException) e2 : new ClientException(e2.toString(), e2);
            OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }
}
