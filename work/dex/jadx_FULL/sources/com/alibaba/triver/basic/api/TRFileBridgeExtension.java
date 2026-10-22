package com.alibaba.triver.basic.api;

import android.text.TextUtils;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.file.f;
import com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension;
import com.alibaba.ariver.commonability.file.l;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRFileBridgeExtension extends FileBridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24683a = "https://resource/";
    private static final String b = "TRFileBridgeExtension";

    private String a(JSONObject jSONObject, String str) {
        String string = CommonUtils.getString(jSONObject, str);
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
            if (!TextUtils.isEmpty(string)) {
                string = com.alibaba.ariver.commonability.file.a.c(string);
            }
        }
        if (!TextUtils.isEmpty(string) && string.startsWith("file://")) {
            string = string.replaceAll("file://", "");
        }
        if (TextUtils.isEmpty(string) || !f.e(string)) {
            return null;
        }
        return string;
    }

    @Override // com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension
    @Remote
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getFileInfo(@BindingApiContext ApiContext apiContext, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        String strA;
        String strT;
        String string = CommonUtils.getString(jSONObject, "filePath");
        if (TextUtils.isEmpty(string)) {
            string = CommonUtils.getString(jSONObject, "apFilePath");
        }
        if (TextUtils.isEmpty(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        if (l.a(string)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String string2 = CommonUtils.getString(jSONObject, "digestAlgorithm");
        if (TextUtils.isEmpty(string2)) {
            string2 = TKDownloadReason.KSAD_TK_MD5;
        }
        if (!TextUtils.equals(TKDownloadReason.KSAD_TK_MD5, string2) && !TextUtils.equals("sha1", string2)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", (Object) 16);
            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, "digestAlgorithm 参数只支持 md5 或 sha1");
            bridgeCallback.sendJSONResponse(jSONObject2);
            return;
        }
        try {
            String string3 = CommonUtils.getString(jSONObject, "filePath");
            if (TextUtils.isEmpty(string3)) {
                String string4 = CommonUtils.getString(jSONObject, "apFilePath");
                if (TextUtils.isEmpty(string4)) {
                    strA = "";
                } else {
                    strA = string4.startsWith("https://resource/") ? a(jSONObject, "filePath") : FileUtils.apUrlToFilePath(string4);
                }
            } else if (string3.startsWith("https://resource/")) {
                jSONObject.remove("filePath");
                jSONObject.put("apFilePath", (Object) string3);
                strA = a(jSONObject, "filePath");
            } else {
                strA = FileUtils.apUrlToFilePath(string3);
            }
            if (TextUtils.isEmpty(strA) || !new File(strA).exists()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("error", (Object) 12);
                jSONObject3.put(SendToNativeCallback.KEY_MESSAGE, "文件不存在");
                bridgeCallback.sendJSONResponse(jSONObject3);
                return;
            }
            if (TKDownloadReason.KSAD_TK_MD5.equals(string2)) {
                strT = f.u(strA);
            } else {
                strT = "sha1".equals(string2) ? f.t(strA) : null;
            }
            JSONObject jSONObject4 = new JSONObject();
            if (TextUtils.isEmpty(strT)) {
                jSONObject4.put("error", (Object) 17);
                jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, "计算文件摘要信息错误");
            } else {
                jSONObject4.put("size", Long.valueOf(f.i(strA)));
                jSONObject4.put("digest", (Object) strT);
            }
            bridgeCallback.sendJSONResponse(jSONObject4);
            RVLogger.d(b, "getFileInfo...");
        } catch (Exception e) {
            RVLogger.d(b, "getFileInfo exception" + e.toString());
        }
    }
}
