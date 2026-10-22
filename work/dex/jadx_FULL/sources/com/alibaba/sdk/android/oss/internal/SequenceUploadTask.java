package com.alibaba.sdk.android.oss.internal;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new ArrayList();
        this.mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws Throwable {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                List<PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    HashMap map = new HashMap();
                    for (PartETag partETag : this.mPartETags) {
                        map.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                    }
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        try {
                            File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                            this.mCRC64RecordFile = file2;
                            if (!file2.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                            try {
                                objectOutputStream2.writeObject(map);
                                objectOutputStream2.close();
                            } catch (IOException e) {
                                e = e;
                                objectOutputStream = objectOutputStream2;
                                OSSLog.logThrowable2Local(e);
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                objectOutputStream = objectOutputStream2;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            }
        }
        super.checkException();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x013a  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void initMultipartUploadId() throws ServiceException, ClientException, IOException {
        String strCalculateMd5Str;
        Map map;
        boolean zIsTruncated;
        if (!OSSUtils.isEmptyString(((ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                try {
                    strCalculateMd5Str = BinaryUtil.calculateMd5Str(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Throwable th) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    throw th;
                }
            } else {
                strCalculateMd5Str = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strCalculateMd5Str);
            sb.append(((ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(String.valueOf(((ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            sb.append("-sequence");
            String strCalculateMd5Str2 = BinaryUtil.calculateMd5Str(sb.toString().getBytes());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((ResumableUploadRequest) this.mRequest).getRecordDirectory());
            String str = File.separator;
            sb2.append(str);
            sb2.append(strCalculateMd5Str2);
            File file = new File(sb2.toString());
            this.mRecordFile = file;
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
                OSSLog.logDebug("sequence [initUploadId] - Found record file, uploadid: " + this.mUploadId);
            }
            if (!OSSUtils.isEmptyString(this.mUploadId)) {
                if (this.mCheckCRC64) {
                    File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + str + this.mUploadId);
                    if (file2.exists()) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file2));
                        try {
                            try {
                                map = (Map) objectInputStream.readObject();
                                try {
                                    file2.delete();
                                } catch (ClassNotFoundException e) {
                                    e = e;
                                    OSSLog.logThrowable2Local(e);
                                }
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                                map = null;
                            }
                            objectInputStream.close();
                            file2.delete();
                        } catch (Throwable th2) {
                            objectInputStream.close();
                            file2.delete();
                            throw th2;
                        }
                    } else {
                        map = null;
                    }
                } else {
                    map = null;
                }
                int nextPartNumberMarker = 0;
                do {
                    ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                    if (nextPartNumberMarker > 0) {
                        listPartsRequest.setPartNumberMarker(Integer.valueOf(nextPartNumberMarker));
                    }
                    OSSAsyncTask<ListPartsResult> oSSAsyncTaskListParts = this.mApiOperation.listParts(listPartsRequest, null);
                    try {
                        ListPartsResult listPartsResult = (ListPartsResult) oSSAsyncTaskListParts.getResult();
                        zIsTruncated = listPartsResult.isTruncated();
                        nextPartNumberMarker = listPartsResult.getNextPartNumberMarker();
                        List<PartSummary> parts = listPartsResult.getParts();
                        for (int i = 0; i < parts.size(); i++) {
                            PartSummary partSummary = parts.get(i);
                            PartETag partETag = new PartETag(partSummary.getPartNumber(), partSummary.getETag());
                            partETag.setPartSize(partSummary.getSize());
                            if (map != null && map.size() > 0 && map.containsKey(Integer.valueOf(partETag.getPartNumber()))) {
                                partETag.setCRC64(((Long) map.get(Integer.valueOf(partETag.getPartNumber()))).longValue());
                            }
                            this.mPartETags.add(partETag);
                            this.mUploadedLength += partSummary.getSize();
                            this.mAlreadyUploadIndex.add(Integer.valueOf(partSummary.getPartNumber()));
                            if (i == 0) {
                                this.mFirstPartSize = partSummary.getSize();
                            }
                        }
                    } catch (ClientException e3) {
                        throw e3;
                    } catch (ServiceException e4) {
                        if (e4.getStatusCode() != 404) {
                            throw e4;
                        }
                        this.mUploadId = null;
                        zIsTruncated = false;
                    }
                    oSSAsyncTaskListParts.waitUntilFinished();
                } while (zIsTruncated);
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (OSSUtils.isEmptyString(this.mUploadId)) {
            InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), ((ResumableUploadRequest) this.mRequest).getMetadata());
            initiateMultipartUploadRequest.isSequential = true;
            this.mUploadId = ((InitiateMultipartUploadResult) this.mApiOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult()).getUploadId();
            if (this.mRecordFile != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.mRecordFile));
                bufferedWriter.write(this.mUploadId);
                bufferedWriter.close();
            }
        }
        ((ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(Exception exc) {
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b8 A[Catch: IOException -> 0x01af, TRY_LEAVE, TryCatch #10 {IOException -> 0x01af, blocks: (B:94:0x01ab, B:98:0x01b3, B:100:0x01b8), top: B:110:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b9 A[Catch: ServiceException -> 0x010b, Exception -> 0x010e, all -> 0x01a7, TryCatch #3 {Exception -> 0x010e, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd A[Catch: ServiceException -> 0x010b, Exception -> 0x010e, all -> 0x01a7, TRY_LEAVE, TryCatch #3 {Exception -> 0x010e, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00e9 A[Catch: IOException -> 0x0131, TRY_ENTER, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ee A[Catch: IOException -> 0x0131, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3 A[Catch: IOException -> 0x0131, TRY_LEAVE, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f8 A[Catch: ServiceException -> 0x010b, Exception -> 0x010e, all -> 0x01a7, TRY_ENTER, TryCatch #3 {Exception -> 0x010e, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x012d A[Catch: IOException -> 0x0131, TRY_ENTER, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0135 A[Catch: IOException -> 0x0131, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x013a A[Catch: IOException -> 0x0131, TRY_LEAVE, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0150 A[Catch: all -> 0x01a7, TryCatch #7 {all -> 0x01a7, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a, B:77:0x0148, B:79:0x0150, B:80:0x0154, B:82:0x016e, B:83:0x018c), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0154 A[Catch: all -> 0x01a7, TryCatch #7 {all -> 0x01a7, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a, B:77:0x0148, B:79:0x0150, B:80:0x0154, B:82:0x016e, B:83:0x018c), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x016e A[Catch: all -> 0x01a7, TryCatch #7 {all -> 0x01a7, blocks: (B:29:0x0070, B:30:0x0089, B:32:0x00b9, B:33:0x00c4, B:35:0x00dd, B:43:0x00f8, B:44:0x010a, B:77:0x0148, B:79:0x0150, B:80:0x0154, B:82:0x016e, B:83:0x018c), top: B:104:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0199 A[Catch: IOException -> 0x0131, TRY_ENTER, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x019e A[Catch: IOException -> 0x0131, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01a3 A[Catch: IOException -> 0x0131, TRY_LEAVE, TryCatch #8 {IOException -> 0x0131, blocks: (B:37:0x00e9, B:39:0x00ee, B:41:0x00f3, B:64:0x012d, B:68:0x0135, B:70:0x013a, B:85:0x0199, B:87:0x019e, B:89:0x01a3), top: B:109:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x01b3 A[Catch: IOException -> 0x01af, TryCatch #10 {IOException -> 0x01af, blocks: (B:94:0x01ab, B:98:0x01b3, B:100:0x01b8), top: B:110:0x01ab }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPart(int i, int i2, int i3) throws Throwable {
        ?? r1;
        ?? bufferedInputStream;
        ?? randomAccessFile;
        PartETag partETag;
        UploadPartRequest uploadPartRequest;
        UploadPartResult uploadPartResultSyncUploadPart;
        PartETag partETag2;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                if (this.mContext.getCancellationHandler().isCancelled()) {
                    return;
                }
                this.mRunPartTaskCount++;
                preUploadPart(i, i2, i3);
                long partSize = ((long) i) * ((ResumableUploadRequest) this.mRequest).getPartSize();
                byte[] bArr = new byte[i2];
                if (this.mUploadUri == null) {
                    randomAccessFile = new RandomAccessFile(this.mUploadFile, "r");
                    try {
                        randomAccessFile.seek(partSize);
                        randomAccessFile.readFully(bArr, 0, i2);
                        r1 = 0;
                        bufferedInputStream = 0;
                        randomAccessFile = randomAccessFile;
                        uploadPartRequest = new UploadPartRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i + 1);
                        uploadPartRequest.setPartContent(bArr);
                        uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                        uploadPartRequest.setCRC64(((ResumableUploadRequest) this.mRequest).getCRC64());
                        uploadPartResultSyncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                        partETag2 = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart.getETag());
                        long j = i2;
                        partETag2.setPartSize(j);
                        if (this.mCheckCRC64) {
                            partETag2.setCRC64(uploadPartResultSyncUploadPart.getClientCRC().longValue());
                        }
                        this.mPartETags.add(partETag2);
                        this.mUploadedLength += j;
                        uploadPartFinish(partETag2);
                        if (!this.mContext.getCancellationHandler().isCancelled()) {
                            TaskCancelException taskCancelException = new TaskCancelException("sequence upload task cancel");
                            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
                        }
                        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                        if (randomAccessFile != 0) {
                            randomAccessFile.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (bufferedInputStream != 0) {
                            bufferedInputStream.close();
                            return;
                        }
                        return;
                    } catch (ServiceException e) {
                        e = e;
                        r1 = 0;
                        bufferedInputStream = 0;
                        if (e.getStatusCode() != 409) {
                            processException(e);
                        } else {
                            partETag = new PartETag(r0.getPartNumber(), e.getPartEtag());
                            partETag.setPartSize(r0.getPartContent().length);
                            if (this.mCheckCRC64) {
                                partETag.setCRC64(new CheckedInputStream(new ByteArrayInputStream(r0.getPartContent()), new CRC64()).getChecksum().getValue());
                            }
                            this.mPartETags.add(partETag);
                            this.mUploadedLength += (long) i2;
                        }
                        if (randomAccessFile != 0) {
                            randomAccessFile.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (bufferedInputStream != 0) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        r1 = 0;
                        bufferedInputStream = 0;
                        r0 = randomAccessFile;
                        r1 = r1;
                        bufferedInputStream = bufferedInputStream;
                        processException(e);
                        if (r0 != 0) {
                            r0.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (bufferedInputStream != 0) {
                            bufferedInputStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        r1 = 0;
                        bufferedInputStream = 0;
                        r0 = randomAccessFile;
                        if (r0 != 0) {
                            r0.close();
                            if (r1 != 0) {
                                r1.close();
                            }
                            if (bufferedInputStream != 0) {
                                bufferedInputStream.close();
                            }
                        } else {
                            if (r1 != 0) {
                                r1.close();
                            }
                            if (bufferedInputStream != 0) {
                                bufferedInputStream.close();
                            }
                        }
                        throw th;
                    }
                }
                InputStream inputStreamOpenInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                try {
                    bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
                    try {
                        bufferedInputStream.skip(partSize);
                        bufferedInputStream.read(bArr, 0, i2);
                        r1 = inputStreamOpenInputStream;
                        randomAccessFile = 0;
                        bufferedInputStream = bufferedInputStream;
                        try {
                            try {
                                try {
                                    uploadPartRequest = new UploadPartRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i + 1);
                                    try {
                                        uploadPartRequest.setPartContent(bArr);
                                        uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                                        uploadPartRequest.setCRC64(((ResumableUploadRequest) this.mRequest).getCRC64());
                                        uploadPartResultSyncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                                        partETag2 = new PartETag(uploadPartRequest.getPartNumber(), uploadPartResultSyncUploadPart.getETag());
                                        long j2 = i2;
                                        partETag2.setPartSize(j2);
                                        if (this.mCheckCRC64) {
                                            partETag2.setCRC64(uploadPartResultSyncUploadPart.getClientCRC().longValue());
                                        }
                                        this.mPartETags.add(partETag2);
                                        this.mUploadedLength += j2;
                                        uploadPartFinish(partETag2);
                                        if (!this.mContext.getCancellationHandler().isCancelled()) {
                                            TaskCancelException taskCancelException2 = new TaskCancelException("sequence upload task cancel");
                                            throw new ClientException(taskCancelException2.getMessage(), taskCancelException2, Boolean.TRUE);
                                        }
                                        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                                        if (randomAccessFile != 0) {
                                            randomAccessFile.close();
                                        }
                                        if (r1 != 0) {
                                            r1.close();
                                        }
                                        if (bufferedInputStream != 0) {
                                            bufferedInputStream.close();
                                            return;
                                        }
                                        return;
                                    } catch (ServiceException e3) {
                                        e = e3;
                                        r0 = uploadPartRequest;
                                        if (e.getStatusCode() != 409) {
                                            processException(e);
                                        } else {
                                            partETag = new PartETag(r0.getPartNumber(), e.getPartEtag());
                                            partETag.setPartSize(r0.getPartContent().length);
                                            if (this.mCheckCRC64) {
                                                partETag.setCRC64(new CheckedInputStream(new ByteArrayInputStream(r0.getPartContent()), new CRC64()).getChecksum().getValue());
                                            }
                                            this.mPartETags.add(partETag);
                                            this.mUploadedLength += (long) i2;
                                        }
                                        if (randomAccessFile != 0) {
                                            randomAccessFile.close();
                                        }
                                        if (r1 != 0) {
                                            r1.close();
                                        }
                                        if (bufferedInputStream != 0) {
                                            bufferedInputStream.close();
                                        }
                                    }
                                } catch (ServiceException e4) {
                                    e = e4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                r0 = randomAccessFile;
                                r1 = r1;
                                bufferedInputStream = bufferedInputStream;
                                try {
                                    processException(e);
                                    if (r0 != 0) {
                                        r0.close();
                                    }
                                    if (r1 != 0) {
                                        r1.close();
                                    }
                                    if (bufferedInputStream != 0) {
                                        bufferedInputStream.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            r0 = randomAccessFile;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                    if (r1 != 0) {
                                        r1.close();
                                    }
                                    if (bufferedInputStream != 0) {
                                        bufferedInputStream.close();
                                    }
                                } catch (IOException e6) {
                                    OSSLog.logThrowable2Local(e6);
                                }
                            } else {
                                if (r1 != 0) {
                                    r1.close();
                                }
                                if (bufferedInputStream != 0) {
                                    bufferedInputStream.close();
                                }
                            }
                            throw th;
                        }
                    } catch (ServiceException e7) {
                        e = e7;
                        r1 = inputStreamOpenInputStream;
                        randomAccessFile = 0;
                        if (e.getStatusCode() != 409) {
                            processException(e);
                        } else {
                            partETag = new PartETag(r0.getPartNumber(), e.getPartEtag());
                            partETag.setPartSize(r0.getPartContent().length);
                            if (this.mCheckCRC64) {
                                partETag.setCRC64(new CheckedInputStream(new ByteArrayInputStream(r0.getPartContent()), new CRC64()).getChecksum().getValue());
                            }
                            this.mPartETags.add(partETag);
                            this.mUploadedLength += (long) i2;
                        }
                        if (randomAccessFile != 0) {
                            randomAccessFile.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (bufferedInputStream != 0) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e8) {
                        e = e8;
                        r1 = inputStreamOpenInputStream;
                        bufferedInputStream = bufferedInputStream;
                        processException(e);
                        if (r0 != 0) {
                            r0.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                        if (bufferedInputStream != 0) {
                            bufferedInputStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        r1 = inputStreamOpenInputStream;
                        if (r0 != 0) {
                            r0.close();
                            if (r1 != 0) {
                                r1.close();
                            }
                            if (bufferedInputStream != 0) {
                                bufferedInputStream.close();
                            }
                        } else {
                            if (r1 != 0) {
                                r1.close();
                            }
                            if (bufferedInputStream != 0) {
                                bufferedInputStream.close();
                            }
                        }
                        throw th;
                    }
                } catch (ServiceException e9) {
                    e = e9;
                    bufferedInputStream = 0;
                    r1 = inputStreamOpenInputStream;
                    randomAccessFile = 0;
                } catch (Exception e10) {
                    e = e10;
                    bufferedInputStream = 0;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = 0;
                }
                if (r0 != 0) {
                    r0.close();
                    if (r1 != 0) {
                        r1.close();
                    }
                    if (bufferedInputStream != 0) {
                        bufferedInputStream.close();
                    }
                } else {
                    if (r1 != 0) {
                        r1.close();
                    }
                    if (bufferedInputStream != 0) {
                        bufferedInputStream.close();
                    }
                }
                throw th;
            } catch (IOException e11) {
                OSSLog.logThrowable2Local(e11);
                return;
            }
        } catch (ServiceException e12) {
            e = e12;
            r1 = r0;
            randomAccessFile = r1;
            bufferedInputStream = randomAccessFile;
        } catch (Exception e13) {
            e = e13;
            ?? r2 = r0;
            bufferedInputStream = r2;
            r0 = r0;
            r1 = r2;
        } catch (Throwable th6) {
            th = th6;
            r1 = r0;
            bufferedInputStream = r1;
        }
        if (e.getStatusCode() != 409) {
            processException(e);
        } else {
            partETag = new PartETag(r0.getPartNumber(), e.getPartEtag());
            partETag.setPartSize(r0.getPartContent().length);
            if (this.mCheckCRC64) {
                partETag.setCRC64(new CheckedInputStream(new ByteArrayInputStream(r0.getPartContent()), new CRC64()).getChecksum().getValue());
            }
            this.mPartETags.add(partETag);
            this.mUploadedLength += (long) i2;
        }
        if (randomAccessFile != 0) {
            randomAccessFile.close();
        }
        if (r1 != 0) {
            r1.close();
        }
        if (bufferedInputStream != 0) {
            bufferedInputStream.close();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws Throwable {
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i = iArr[0];
        int i2 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long jLongValue = this.mUploadedLength;
            if (jLongValue > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            }
            if (this.mFirstPartSize != i) {
                throw new ClientException("The part size setting is inconsistent with before");
            }
            if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                jLongValue = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j2 = jLongValue;
            OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j2, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i);
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        return resumableUploadResult;
    }
}
