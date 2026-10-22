package com.alibaba.triver.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.file.g;
import com.alibaba.ariver.commonability.file.proxy.b;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.video.h;
import com.alibaba.triver.kit.api.common.DomainNameController;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.beizi.fusion.widget.ScrollClickView;
import com.desgemini.mini_media_common.JSContextAdapter;
import com.fl.saas.common.util.FileTypeUtils;
import com.taobao.android.miniimage.AriverImageExtension;
import com.taobao.windmill.module.base.Status;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRImageBridgeExtension extends AriverImageExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24964a = "TRImageBridgeExtension";

    public static byte[] File2byte(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0040 A[PHI: r4
      0x0040: PHI (r4v8 java.lang.String) = (r4v4 java.lang.String), (r4v5 java.lang.String), (r4v6 java.lang.String), (r4v7 java.lang.String) binds: [B:6:0x003e, B:9:0x0048, B:12:0x0051, B:15:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    private JSONObject a(InputStream inputStream) {
        String str;
        String str2 = ScrollClickView.DIR_UP;
        JSONObject jSONObject = new JSONObject();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        jSONObject.put("width", (Object) Integer.valueOf(i));
        jSONObject.put("height", (Object) Integer.valueOf(i2));
        String str3 = options.outMimeType;
        if (TextUtils.isEmpty(str3)) {
            str3 = "unknown";
        } else {
            String str4 = "jpg";
            if (str3.contains("jpg")) {
                str3 = str4;
            } else {
                str4 = "png";
                if (str3.contains("png")) {
                    str3 = str4;
                } else {
                    str4 = FileTypeUtils.FILE_TYPE_GIF;
                    if (str3.contains(FileTypeUtils.FILE_TYPE_GIF)) {
                        str3 = str4;
                    } else {
                        str4 = AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG;
                        if (str3.contains(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
                            str3 = str4;
                        }
                    }
                }
            }
        }
        jSONObject.put("type", (Object) str3);
        try {
            int i3 = Integer.parseInt(new ExifInterface(inputStream).getAttribute("Orientation"));
            if (i3 == 3) {
                str = ScrollClickView.DIR_DOWN;
            } else {
                if (i3 != 6) {
                    if (i3 == 8) {
                        str = "left";
                    }
                    jSONObject.put("orientation", (Object) str2);
                    if (bitmapDecodeStream != null) {
                        bitmapDecodeStream.recycle();
                    }
                    return jSONObject;
                }
                str = "right";
            }
            str2 = str;
        } catch (Exception e) {
            RVLogger.e("getImageInfo", "parse image orientation info error : " + e.getMessage());
        }
        jSONObject.put("orientation", (Object) str2);
        if (bitmapDecodeStream != null) {
            bitmapDecodeStream.recycle();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    @Remote
    @ActionFilter
    public void chooseImage(@BindingApiContext ApiContext apiContext, @BindingParam({"sourceType"}) String[] strArr, @BindingParam({"sizeType"}) String[] strArr2, @BindingParam({"count"}) int i, @BindingParam(booleanDefault = true, value = {"isClipped"}) boolean z, @BindingRequest org.json.JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        boolean z2;
        boolean z3;
        int i2 = i == 0 ? 1 : i;
        if (i2 < 1) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(1, "the value of count is smaller than one"));
            return;
        }
        Pair<Boolean, Boolean> pairA = a(strArr);
        if (jSONObject != null) {
            try {
                z3 = jSONObject.has("cameraFilter") && TextUtils.equals(jSONObject.getString("cameraFilter"), Boolean.TRUE.toString());
            } catch (JSONException e) {
                RVLogger.w(Log.getStackTraceString(e));
                z2 = false;
            }
        }
        z2 = z3;
        Pair<Integer, Integer> pairA2 = a(jSONObject);
        ImageUtils.a(new JSContextAdapter(bridgeCallback, apiContext.getActivity(), apiContext.getAppContext()), pairA.first.booleanValue(), pairA.second.booleanValue(), z2, z, pairA2.first.intValue(), pairA2.second.intValue(), i2);
    }

    @ActionFilter
    public void getImageInfo(@BindingApiContext ApiContext apiContext, @BindingParam({"src"}) String str, @BindingRequest org.json.JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", "src is empty");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        if (!str.startsWith("https://") && !str.startsWith("http://") && !str.startsWith(b.f24036a)) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("error", "src is not support !");
            bridgeCallback.sendJSONResponse(jSONObject3);
            return;
        }
        if (str.startsWith(g.e)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(FileUtils.apUrlToFilePath(str)));
                JSONObject jSONObjectA = a(fileInputStream);
                jSONObjectA.put("success", "true");
                jSONObjectA.put("path", (Object) str);
                bridgeCallback.sendJSONResponse(jSONObjectA);
                fileInputStream.close();
                return;
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("error", "parse error");
                bridgeCallback.sendJSONResponse(jSONObject4);
                return;
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                JSONObject jSONObjectA2 = a(inputStream);
                jSONObjectA2.put("path", (Object) str);
                jSONObjectA2.put("success", "true");
                bridgeCallback.sendJSONResponse(jSONObjectA2);
                inputStream.close();
                httpURLConnection.disconnect();
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("error", (Object) ("network error , code is " + responseCode));
            bridgeCallback.sendJSONResponse(jSONObject5);
        } catch (MalformedURLException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("error", "url error");
            bridgeCallback.sendJSONResponse(jSONObject6);
        } catch (IOException unused) {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("error", "io error");
            bridgeCallback.sendJSONResponse(jSONObject7);
        } catch (Exception e3) {
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("error", (Object) ("unknown error : " + e3.getMessage()));
            bridgeCallback.sendJSONResponse(jSONObject8);
        }
    }

    @ActionFilter
    public void imageViewer(@BindingApiContext ApiContext apiContext, @BindingParam({"images"}) String[] strArr, @BindingParam({"init"}) int i, @BindingRequest org.json.JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(App.class) App app, @BindingParam({"__appxDomain"}) String str) {
        JSContextAdapter jSContextAdapter = new JSContextAdapter(bridgeCallback, apiContext.getActivity());
        if (i < 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msg", "the value of current is smaller than 0");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        String[] strArr2 = new String[strArr.length];
        int i2 = 0;
        for (String string : strArr) {
            try {
                string = JSON.parseObject(string).getString("u");
            } catch (Throwable unused) {
            }
            String strApUrlToFilePath = FileUtils.apUrlToFilePath(string);
            if (strApUrlToFilePath != null && ((strApUrlToFilePath.startsWith("https://") || strApUrlToFilePath.startsWith("http://")) && TRiverUtils.needAuthentication(app) && !DomainNameController.urlBothInOfficialDomainListAndPermissionModelList(strApUrlToFilePath, app, str))) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(-1, "please insure your url  is in domain whitelist: " + strApUrlToFilePath));
                return;
            }
            strArr2[i2] = strApUrlToFilePath;
            i2++;
        }
        ImageUtils.a(jSContextAdapter, JSON.parseArray(JSON.toJSONString(strArr2)), i);
    }

    @ActionFilter
    public void saveImage(@BindingApiContext ApiContext apiContext, @BindingParam({"src"}) String str, @BindingRequest org.json.JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(App.class) App app, @BindingParam({"__appxDomain"}) String str2) {
        if (!TRiverUtils.needAuthentication(app) || DomainNameController.urlBothInOfficialDomainListAndPermissionModelList(str, app, str2)) {
            saveImageToPhotosAlbum(apiContext, str, jSONObject, bridgeCallback);
        } else {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(-1, DomainNameController.ERROR_URL_NOT_IN_WHITE_LIST));
        }
    }

    @ActionFilter
    public void saveImageToPhotosAlbum(@BindingApiContext ApiContext apiContext, @BindingParam({"filePath"}) final String str, @BindingRequest org.json.JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        final Activity activity = apiContext.getActivity();
        final JSContextAdapter jSContextAdapter = new JSContextAdapter(bridgeCallback, activity, apiContext.getAppContext());
        requestPermission(activity, new AriverImageExtension.a() { // from class: com.alibaba.triver.image.TRImageBridgeExtension.1
            public void a() {
                byte[] bArrFile2byte;
                if (TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", (Object) 2);
                    jSONObject2.put("msg", (Object) "url is empty");
                    jSContextAdapter.failed(Status.PARAM_ERR, jSONObject2);
                    return;
                }
                try {
                    String strApUrlToFilePath = FileUtils.apUrlToFilePath(str);
                    if (TextUtils.isEmpty(strApUrlToFilePath)) {
                        strApUrlToFilePath = str;
                    }
                    if ((TextUtils.isEmpty(strApUrlToFilePath) || !strApUrlToFilePath.startsWith("https://")) && !strApUrlToFilePath.startsWith("http://")) {
                        bArrFile2byte = TRImageBridgeExtension.File2byte(new File(strApUrlToFilePath));
                    } else {
                        RVHttpRequest rVHttpRequestBuild = RVHttpRequest.newBuilder().url(strApUrlToFilePath).build();
                        new RVDownloadRequest().setDownloadUrl(strApUrlToFilePath);
                        bArrFile2byte = TRImageBridgeExtension.this.b(((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(rVHttpRequestBuild).getResStream());
                    }
                    if (bArrFile2byte != null && bArrFile2byte.length > 0) {
                        if (Build.VERSION.SDK_INT >= 29) {
                            AriverImageExtension.saveImageQ(activity, BitmapFactory.decodeStream(new ByteArrayInputStream(bArrFile2byte)), jSContextAdapter);
                            return;
                        }
                        if (!AriverImageExtension.isExternalStorageWritable()) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("error", (Object) 15);
                            jSONObject3.put("msg", (Object) "No permission to write during image.saveImage");
                            jSContextAdapter.failed(Status.NO_PERMISSION, jSONObject3);
                            return;
                        }
                        if (jSContextAdapter.getContext() == null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("error", (Object) 17);
                            jSONObject4.put("msg", (Object) "Http response is null or Android Context is null");
                            jSContextAdapter.failed(Status.EXCEPTION, jSONObject4);
                            return;
                        }
                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), String.valueOf(System.currentTimeMillis()));
                        if (file.exists() || file.mkdir()) {
                            TRImageBridgeExtension.this.writeToFile(bArrFile2byte, file, jSContextAdapter);
                            return;
                        }
                        MediaScannerConnection.scanFile(activity, new String[]{file.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("error", (Object) 15);
                        jSONObject5.put("msg", (Object) "No permission to write during image.saveImage");
                        jSContextAdapter.failed(Status.NO_PERMISSION, jSONObject5);
                        return;
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("error", (Object) 17);
                    jSONObject6.put("msg", (Object) "Image data is null");
                    jSContextAdapter.failed(Status.EXCEPTION, jSONObject6);
                } catch (Throwable th) {
                    th.toString();
                }
            }

            public void a(String str2) {
                Log.e(TRImageBridgeExtension.f24964a, "Permission denied");
                HashMap map = new HashMap();
                map.put("error", 13);
                map.put(SendToNativeCallback.KEY_MESSAGE, "Permission denied");
                jSContextAdapter.failed(map);
            }
        }, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    private static Pair<Boolean, Boolean> a(String[] strArr) {
        boolean z;
        boolean z2 = true;
        if (strArr == null || strArr.length == 0) {
            z = true;
        } else {
            boolean z3 = false;
            z = false;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    str.hashCode();
                    if (str.equals(h.d)) {
                        z3 = true;
                    } else if (str.equals(h.f)) {
                        z = true;
                    }
                }
            }
            z2 = z3;
        }
        return new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    @Nullable
    private static Pair<Integer, Integer> a(org.json.JSONObject jSONObject) {
        int i;
        String string;
        int i2;
        int i3 = 1;
        if (jSONObject != null) {
            try {
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("oneSelectionCrop");
                if (jSONObject2 != null && (string = jSONObject2.getString("ratio")) != null) {
                    int iIndexOf = string.indexOf(58);
                    try {
                        int i4 = Integer.parseInt(string.substring(0, iIndexOf));
                        try {
                            i2 = Integer.parseInt(string.substring(iIndexOf + 1, string.length()));
                            i3 = i4;
                        } catch (JSONException e) {
                            e = e;
                            i = 1;
                            i3 = i4;
                        }
                    } catch (NumberFormatException unused) {
                        i2 = 1;
                    }
                    return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i2));
                }
                i2 = 1;
                try {
                    return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i2));
                } catch (JSONException e2) {
                    i = i2;
                    e = e2;
                }
            } catch (JSONException e3) {
                e = e3;
                i = 1;
            }
        } else {
            i2 = 1;
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i2));
        }
        RVLogger.w(Log.getStackTraceString(e));
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i));
    }
}
