package com.alibaba.sdk.android.oss.network;

import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.OSSRetryType;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.ipd.dsp.internal.g0.c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    private OkHttpClient client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser<T> responseParser;
    private OSSRetryHandler retryHandler;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser, ExecutionContext executionContext, int i) {
        this.responseParser = responseParser;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i);
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, Response response) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(response);
        HashMap map = new HashMap();
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            map.put(headers.name(i), headers.value(i));
        }
        responseMessage.setHeaders(map);
        responseMessage.setStatusCode(response.code());
        responseMessage.setContentLength(response.body().contentLength());
        responseMessage.setContent(response.body().byteStream());
        return responseMessage;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0195 A[Catch: Exception -> 0x02cb, TryCatch #4 {Exception -> 0x02cb, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:12:0x0050, B:13:0x0062, B:15:0x0068, B:16:0x007f, B:70:0x01fa, B:27:0x00c6, B:28:0x00cc, B:29:0x00d2, B:33:0x00dd, B:35:0x00ea, B:63:0x0195, B:65:0x019d, B:66:0x01a8, B:68:0x01c9, B:69:0x01e6, B:38:0x0101, B:40:0x010b, B:43:0x0127, B:44:0x012f, B:45:0x0130, B:47:0x0138, B:50:0x0166, B:56:0x0170, B:57:0x0173, B:58:0x0174, B:60:0x017c, B:61:0x018a, B:11:0x004a, B:88:0x02c3, B:89:0x02ca), top: B:155:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x019d A[Catch: Exception -> 0x02cb, TryCatch #4 {Exception -> 0x02cb, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:12:0x0050, B:13:0x0062, B:15:0x0068, B:16:0x007f, B:70:0x01fa, B:27:0x00c6, B:28:0x00cc, B:29:0x00d2, B:33:0x00dd, B:35:0x00ea, B:63:0x0195, B:65:0x019d, B:66:0x01a8, B:68:0x01c9, B:69:0x01e6, B:38:0x0101, B:40:0x010b, B:43:0x0127, B:44:0x012f, B:45:0x0130, B:47:0x0138, B:50:0x0166, B:56:0x0170, B:57:0x0173, B:58:0x0174, B:60:0x017c, B:61:0x018a, B:11:0x004a, B:88:0x02c3, B:89:0x02ca), top: B:155:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x01c9 A[Catch: Exception -> 0x02cb, TryCatch #4 {Exception -> 0x02cb, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:12:0x0050, B:13:0x0062, B:15:0x0068, B:16:0x007f, B:70:0x01fa, B:27:0x00c6, B:28:0x00cc, B:29:0x00d2, B:33:0x00dd, B:35:0x00ea, B:63:0x0195, B:65:0x019d, B:66:0x01a8, B:68:0x01c9, B:69:0x01e6, B:38:0x0101, B:40:0x010b, B:43:0x0127, B:44:0x012f, B:45:0x0130, B:47:0x0138, B:50:0x0166, B:56:0x0170, B:57:0x0173, B:58:0x0174, B:60:0x017c, B:61:0x018a, B:11:0x004a, B:88:0x02c3, B:89:0x02ca), top: B:155:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01e6 A[Catch: Exception -> 0x02cb, TryCatch #4 {Exception -> 0x02cb, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:12:0x0050, B:13:0x0062, B:15:0x0068, B:16:0x007f, B:70:0x01fa, B:27:0x00c6, B:28:0x00cc, B:29:0x00d2, B:33:0x00dd, B:35:0x00ea, B:63:0x0195, B:65:0x019d, B:66:0x01a8, B:68:0x01c9, B:69:0x01e6, B:38:0x0101, B:40:0x010b, B:43:0x0127, B:44:0x012f, B:45:0x0130, B:47:0x0138, B:50:0x0166, B:56:0x0170, B:57:0x0173, B:58:0x0174, B:60:0x017c, B:61:0x018a, B:11:0x004a, B:88:0x02c3, B:89:0x02ca), top: B:155:0x0004 }] */
    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        Call callNewCall;
        Request requestBuild;
        Exception clientException;
        ResponseMessage responseMessageBuildResponseMessage;
        long statSize;
        String stringBody;
        InputStream content;
        long contentLength;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            if (this.context.getApplicationContext() != null) {
                OSSLog.logInfo(OSSUtils.buildBaseLogInfo(this.context.getApplicationContext()));
            }
            OSSLog.logDebug("[call] - ");
            OSSRequest request = this.context.getRequest();
            OSSUtils.ensureRequestValid(request, this.message);
            OSSUtils.signRequest(this.message);
            if (this.context.getCancellationHandler().isCancelled()) {
                throw new InterruptedIOException("This task is cancelled!");
            }
            Request.Builder builderUrl = new Request.Builder().url(request instanceof ListBucketsRequest ? this.message.buildOSSServiceURL() : this.message.buildCanonicalURL());
            for (String str : this.message.getHeaders().keySet()) {
                builderUrl = builderUrl.addHeader(str, (String) this.message.getHeaders().get(str));
            }
            String str2 = (String) this.message.getHeaders().get("Content-Type");
            OSSLog.logDebug("request method = " + this.message.getMethod());
            int i = AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[this.message.getMethod().ordinal()];
            if (i == 1 || i == 2) {
                OSSUtils.assertTrue(str2 != null, "Content type can't be null when upload!");
                if (this.message.getUploadData() != null) {
                    content = new ByteArrayInputStream(this.message.getUploadData());
                    contentLength = this.message.getUploadData().length;
                } else {
                    if (this.message.getUploadFilePath() != null) {
                        File file = new File(this.message.getUploadFilePath());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        long length = file.length();
                        if (length <= 0) {
                            throw new ClientException("the length of file is 0!");
                        }
                        stringBody = null;
                        content = fileInputStream;
                        statSize = length;
                    } else if (this.message.getUploadUri() != null) {
                        content = this.context.getApplicationContext().getContentResolver().openInputStream(this.message.getUploadUri());
                        try {
                            parcelFileDescriptorOpenFileDescriptor = this.context.getApplicationContext().getContentResolver().openFileDescriptor(this.message.getUploadUri(), "r");
                            try {
                                statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                                parcelFileDescriptorOpenFileDescriptor.close();
                                stringBody = null;
                            } catch (Throwable th) {
                                th = th;
                                if (parcelFileDescriptorOpenFileDescriptor != null) {
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            parcelFileDescriptorOpenFileDescriptor = null;
                        }
                    } else if (this.message.getContent() != null) {
                        content = this.message.getContent();
                        contentLength = this.message.getContentLength();
                    } else {
                        statSize = 0;
                        stringBody = this.message.getStringBody();
                        content = null;
                    }
                    if (content != null) {
                        if (this.message.isCheckCRC64()) {
                            content = new CheckedInputStream(content, new CRC64());
                        }
                        this.message.setContent(content);
                        this.message.setContentLength(statSize);
                        builderUrl = builderUrl.method(this.message.getMethod().toString(), NetworkProgressHelper.addProgressRequestBody(content, statSize, str2, this.context));
                    } else if (stringBody != null) {
                        builderUrl = builderUrl.method(this.message.getMethod().toString(), RequestBody.create(MediaType.parse(str2), stringBody.getBytes("UTF-8")));
                    } else {
                        builderUrl = builderUrl.method(this.message.getMethod().toString(), RequestBody.create((MediaType) null, new byte[0]));
                    }
                }
                statSize = contentLength;
                stringBody = null;
                if (content != null) {
                    if (this.message.isCheckCRC64()) {
                        content = new CheckedInputStream(content, new CRC64());
                    }
                    this.message.setContent(content);
                    this.message.setContentLength(statSize);
                    builderUrl = builderUrl.method(this.message.getMethod().toString(), NetworkProgressHelper.addProgressRequestBody(content, statSize, str2, this.context));
                } else if (stringBody != null) {
                    builderUrl = builderUrl.method(this.message.getMethod().toString(), RequestBody.create(MediaType.parse(str2), stringBody.getBytes("UTF-8")));
                } else {
                    builderUrl = builderUrl.method(this.message.getMethod().toString(), RequestBody.create((MediaType) null, new byte[0]));
                }
            } else if (i == 3) {
                builderUrl = builderUrl.get();
            } else if (i == 4) {
                builderUrl = builderUrl.head();
            } else if (i == 5) {
                builderUrl = builderUrl.delete();
            }
            requestBuild = builderUrl.build();
            try {
                if (request instanceof GetObjectRequest) {
                    this.client = NetworkProgressHelper.addProgressResponseListener(this.client, this.context);
                    OSSLog.logDebug("getObject");
                }
                callNewCall = this.client.newCall(requestBuild);
                try {
                    this.context.getCancellationHandler().setCall(callNewCall);
                    Response responseExecute = callNewCall.execute();
                    if (OSSLog.isEnableLog()) {
                        Map multimap = responseExecute.headers().toMultimap();
                        StringBuilder sb = new StringBuilder();
                        sb.append("response:---------------------\n");
                        sb.append("response code: " + responseExecute.code() + " for url: " + requestBuild.url() + "\n");
                        for (String str3 : multimap.keySet()) {
                            sb.append("responseHeader [" + str3 + "]: ");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append((String) ((List) multimap.get(str3)).get(0));
                            sb2.append("\n");
                            sb.append(sb2.toString());
                        }
                        OSSLog.logDebug(sb.toString());
                    }
                    responseMessageBuildResponseMessage = buildResponseMessage(this.message, responseExecute);
                    clientException = null;
                } catch (Exception e) {
                    e = e;
                    OSSLog.logError("Encounter local execpiton: " + e.toString());
                    if (OSSLog.isEnableLog()) {
                        e.printStackTrace();
                    }
                    clientException = new ClientException(e.getMessage(), e);
                    responseMessageBuildResponseMessage = null;
                }
            } catch (Exception e2) {
                e = e2;
                callNewCall = null;
            }
            if (clientException == null && (responseMessageBuildResponseMessage.getStatusCode() == 203 || responseMessageBuildResponseMessage.getStatusCode() >= 300)) {
                clientException = ResponseParsers.parseResponseErrorXML(responseMessageBuildResponseMessage, requestBuild.method().equals(c.f38307a));
            } else if (clientException == null) {
                try {
                    T t = (T) this.responseParser.parse(responseMessageBuildResponseMessage);
                    if (this.context.getCompletedCallback() != null) {
                        this.context.getCompletedCallback().onSuccess(this.context.getRequest(), t);
                    }
                    return t;
                } catch (IOException e3) {
                    clientException = new ClientException(e3.getMessage(), e3);
                }
            }
            if ((callNewCall != null && callNewCall.isCanceled()) || this.context.getCancellationHandler().isCancelled()) {
                clientException = new ClientException("Task is cancelled!", clientException.getCause(), Boolean.TRUE);
            }
            OSSRetryType oSSRetryTypeShouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
            OSSLog.logError("[run] - retry, retry type: " + oSSRetryTypeShouldRetry);
            if (oSSRetryTypeShouldRetry == OSSRetryType.OSSRetryTypeShouldRetry) {
                this.currentRetryCount++;
                if (this.context.getRetryCallback() != null) {
                    this.context.getRetryCallback().onRetryCallback();
                }
                try {
                    Thread.sleep(this.retryHandler.timeInterval(this.currentRetryCount, oSSRetryTypeShouldRetry));
                } catch (InterruptedException e4) {
                    Thread.currentThread().interrupt();
                    e4.printStackTrace();
                }
                return (T) call();
            }
            if (oSSRetryTypeShouldRetry != OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry) {
                if (clientException instanceof ClientException) {
                    if (this.context.getCompletedCallback() == null) {
                        throw clientException;
                    }
                    this.context.getCompletedCallback().onFailure(this.context.getRequest(), (ClientException) clientException, null);
                    throw clientException;
                }
                if (this.context.getCompletedCallback() == null) {
                    throw clientException;
                }
                this.context.getCompletedCallback().onFailure(this.context.getRequest(), null, (ServiceException) clientException);
                throw clientException;
            }
            if (responseMessageBuildResponseMessage != null) {
                String str4 = (String) responseMessageBuildResponseMessage.getHeaders().get("Date");
                try {
                    DateUtil.setCurrentServerTime(DateUtil.parseRfc822Date(str4).getTime());
                    this.message.getHeaders().put("Date", str4);
                } catch (Exception unused) {
                    OSSLog.logError("[error] - synchronize time, reponseDate:" + str4);
                }
            }
            this.currentRetryCount++;
            if (this.context.getRetryCallback() != null) {
                this.context.getRetryCallback().onRetryCallback();
            }
            return (T) call();
        } catch (Exception e5) {
            e = e5;
            callNewCall = null;
            requestBuild = null;
        }
    }
}
