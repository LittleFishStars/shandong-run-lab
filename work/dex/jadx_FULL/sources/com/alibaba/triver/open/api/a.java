package com.alibaba.triver.open.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.utils.g;
import com.baidu.mapapi.http.wrapper.HttpManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25034a = 11;
    public static final int b = 12;
    public static final int c = 13;
    public static final int d = 12;
    public static final int e = 13;
    private static final int f = 1;
    private static final int g = 2;
    private static final String h = "----WebKitFormBoundaryT1HoybnYeFOGFlBR";

    /* JADX INFO: renamed from: com.alibaba.triver.open.api.a$a, reason: collision with other inner class name */
    public interface InterfaceC0170a {
        void a(Object obj);
    }

    public interface b {
        void a(int i, InputStream inputStream, Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        return length < 2 ? "" : strArrSplit[length - 1];
    }

    public static void a(String str, String str2, String str3, JSONObject jSONObject, String str4, String str5, float f2, String str6, final InterfaceC0170a interfaceC0170a) {
        String str7 = "GET";
        if (jSONObject != null) {
            try {
                try {
                    if (TextUtils.equals("application/x-www-form-urlencoded", jSONObject.getString("Content-Type"))) {
                        str5 = com.alibaba.triver.open.api.b.a(JSON.parseObject(str5));
                    }
                } catch (Throwable th) {
                    RVLogger.w(Log.getStackTraceString(th));
                }
            } catch (Exception e2) {
                RVLogger.w(Log.getStackTraceString(e2));
                return;
            }
        }
        if (str4 != null) {
            str4 = str4.toUpperCase();
        }
        NetworkOptions.a aVar = new NetworkOptions.a();
        if ("GET".equals(str4) || "POST".equals(str4) || HttpManager.HTTP_PUT.equals(str4) || HttpManager.HTTP_DELETE.equals(str4) || com.ipd.dsp.internal.g0.c.f38307a.equals(str4) || "PATCH".equals(str4)) {
            str7 = str4;
        }
        NetworkOptions.a aVarA = aVar.a(str7).b(str3).c(str5).d(str6).a((int) f2);
        com.alibaba.triver.open.api.b.a(jSONObject, aVarA);
        final NetworkOptions networkOptionsA = aVarA.a();
        a(str, str2, networkOptionsA, new b() { // from class: com.alibaba.triver.open.api.a.1
            @Override // com.alibaba.triver.open.api.a.b
            public void a(int i, InputStream inputStream, Map<String, String> map) {
                InterfaceC0170a interfaceC0170a2 = interfaceC0170a;
                if (interfaceC0170a2 != null) {
                    interfaceC0170a2.a(com.alibaba.triver.open.api.b.a(i, inputStream, map, networkOptionsA.e()));
                }
            }
        });
    }

    private static void a(String str, String str2, NetworkOptions networkOptions, final b bVar) {
        final RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
        if (rVTransportService != null) {
            final RVHttpRequest rVHttpRequestBuild = RVHttpRequest.newBuilder().url(networkOptions.b()).headers(networkOptions.c()).method(networkOptions.a()).timeout(networkOptions.f()).requestData(!TextUtils.isEmpty(networkOptions.d()) ? networkOptions.d().getBytes() : null).build();
            rVHttpRequestBuild.addExtParams("appId", str);
            rVHttpRequestBuild.addExtParams("pluginId", str2);
            new AsyncTask<Void, Void, Void>() { // from class: com.alibaba.triver.open.api.a.2
                @Override // android.os.AsyncTask
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    b bVar2;
                    try {
                        RVHttpResponse rVHttpResponseA = com.alibaba.triver.open.prefetch.a.a(rVHttpRequestBuild);
                        if (rVHttpResponseA == null) {
                            rVHttpResponseA = rVTransportService.httpRequest(rVHttpRequestBuild);
                        }
                        if (rVHttpResponseA == null || (bVar2 = bVar) == null) {
                            return null;
                        }
                        bVar2.a(rVHttpResponseA.getStatusCode(), rVHttpResponseA.getResStream(), com.alibaba.triver.open.api.b.a(rVHttpResponseA));
                        return null;
                    } catch (IOException e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                        return null;
                    } catch (InterruptedException e3) {
                        RVLogger.w(Log.getStackTraceString(e3));
                        return null;
                    } catch (ExecutionException e4) {
                        RVLogger.w(Log.getStackTraceString(e4));
                        return null;
                    }
                }
            }.executeOnExecutor(((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IO), new Void[0]);
            return;
        }
        RVLogger.e("windmill:NetworkImpl", "No HttpAdapter found,request failed.");
    }

    public static void a(Activity activity, String str, final BridgeCallback bridgeCallback, String str2) {
        if (activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
            activity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "Permission denied"));
            return;
        }
        RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
        RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
        rVDownloadRequest.setDownloadUrl(str);
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getApplicationContext().getExternalCacheDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append("ariver");
        sb.append(str3);
        sb.append(str2);
        rVDownloadRequest.setDownloadDir(sb.toString());
        rVDownloadRequest.setDownloadFileName(g.a(str));
        rVTransportService.addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.triver.open.api.a.3
            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onCancel(String str4) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, str4));
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFailed(String str4, int i, String str5) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, str5));
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFinish(@Nullable String str4) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apFilePath", (Object) FileUtils.filePathToApUrl(str4, ""));
                bridgeCallback.sendJSONResponse(jSONObject);
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onPrepare(String str4) {
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onProgress(String str4, int i) {
            }
        });
    }

    public static void a(Activity activity, final BridgeCallback bridgeCallback, final Map<String, Object> map, final String str, final String str2, final String str3, final String str4, final JSONObject jSONObject) {
        if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
            activity.shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "Permission denied"));
            RVLogger.e("UploadFile no permission");
            return;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.triver.open.api.a.4
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                HttpURLConnection httpURLConnection = null;
                try {
                    try {
                        File file = new File(str);
                        StringBuilder sb = new StringBuilder();
                        Map map2 = map;
                        if (map2 != null) {
                            for (String str5 : map2.keySet()) {
                                sb.append("------WebKitFormBoundaryT1HoybnYeFOGFlBR\r\n");
                                sb.append("Content-Disposition: form-data; name=\"" + str5 + "\"\r\n");
                                sb.append("\r\n");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(map.get(str5));
                                sb2.append("\r\n");
                                sb.append(sb2.toString());
                            }
                        }
                        sb.append("------WebKitFormBoundaryT1HoybnYeFOGFlBR\r\n");
                        String[] strArrSplit = str.split(File.separator);
                        sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + (strArrSplit.length >= 2 ? strArrSplit[strArrSplit.length - 1] : str) + "\"\r\n");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Content-Type: ");
                        sb3.append(str3);
                        sb3.append(WVNativeCallbackUtil.SEPERATER);
                        sb3.append(a.b(str));
                        sb3.append("\r\n");
                        sb.append(sb3.toString());
                        sb.append("\r\n");
                        byte[] bytes = sb.toString().getBytes("UTF-8");
                        byte[] bytes2 = "\r\n------WebKitFormBoundaryT1HoybnYeFOGFlBR--\r\n".getBytes("UTF-8");
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str4).openConnection();
                        try {
                            httpURLConnection2.setRequestMethod("POST");
                            httpURLConnection2.setRequestProperty("Connection", com.google.common.net.b.t0);
                            httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryT1HoybnYeFOGFlBR");
                            httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(((long) bytes.length) + file.length() + ((long) bytes2.length)));
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                                for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                                    httpURLConnection2.setRequestProperty(entry.getKey(), (String) entry.getValue());
                                }
                            }
                            httpURLConnection2.setDoOutput(true);
                            OutputStream outputStream = httpURLConnection2.getOutputStream();
                            FileInputStream fileInputStream = new FileInputStream(file);
                            outputStream.write(bytes);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = fileInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    outputStream.write(bArr, 0, i);
                                }
                            }
                            outputStream.write(bytes2);
                            fileInputStream.close();
                            outputStream.flush();
                            outputStream.close();
                            if (httpURLConnection2.getResponseCode() == 200) {
                                InputStream inputStream = httpURLConnection2.getInputStream();
                                StringBuffer stringBuffer = new StringBuffer();
                                while (true) {
                                    int i2 = inputStream.read();
                                    if (i2 == -1) {
                                        break;
                                    } else {
                                        stringBuffer.append((char) i2);
                                    }
                                }
                                String strTrim = stringBuffer.toString().trim();
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("statusCode", (Object) String.valueOf(httpURLConnection2.getResponseCode()));
                                jSONObject3.put("data", (Object) strTrim);
                                Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                                HashMap map3 = new HashMap();
                                for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                                    if (entry2.getKey() != null) {
                                        map3.put(entry2.getKey(), entry2.getValue());
                                    }
                                }
                                jSONObject3.put("header", (Object) map3);
                                bridgeCallback.sendJSONResponse(jSONObject3);
                            } else {
                                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "response error: " + httpURLConnection2.getResponseCode() + ", " + httpURLConnection2.getResponseMessage()));
                                RVLogger.e("UploadFile errorMessage: " + httpURLConnection2.getResponseCode() + ", " + httpURLConnection2.getResponseMessage());
                            }
                            httpURLConnection2.disconnect();
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            httpURLConnection = httpURLConnection2;
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "File not exist"));
                            RVLogger.w(Log.getStackTraceString(e));
                            RVLogger.e("UploadFile Catch FileNotFoundException", e);
                            if (httpURLConnection == null) {
                                return;
                            }
                            httpURLConnection.disconnect();
                        } catch (IOException e3) {
                            e = e3;
                            httpURLConnection = httpURLConnection2;
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "File upload failed"));
                            RVLogger.w(Log.getStackTraceString(e));
                            RVLogger.e("UploadFile Catch IOException: ", e);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Exception e4) {
                            e = e4;
                            httpURLConnection = httpURLConnection2;
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(12, "File upload failed"));
                            RVLogger.w(Log.getStackTraceString(e));
                            RVLogger.e("UploadFile Catch Exception", e);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                } catch (IOException e6) {
                    e = e6;
                } catch (Exception e7) {
                    e = e7;
                }
            }
        });
    }
}
