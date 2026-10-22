package com.bykv.vk.component.ttvideo.network;

import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
final class NetworkManager {

    public interface OnCompletionListener {
        void onCompletion(JSONObject jSONObject);

        void onError(LiveError liveError);
    }

    private NetworkManager() {
    }

    public static void doRequest(INetworkClient iNetworkClient, String str, String str2, OnCompletionListener onCompletionListener) {
        LiveError liveError;
        JSONObject jSONObject;
        if (str2 == null) {
            return;
        }
        INetworkClient.Result resultDoRequest = iNetworkClient.doRequest(str, str2);
        if (resultDoRequest == null) {
            onCompletionListener.onError(new LiveError(LiveError.EMPTY, "result is null", null));
            return;
        }
        Exception exc = resultDoRequest.e;
        if (exc == null && (jSONObject = resultDoRequest.response) != null) {
            onCompletionListener.onCompletion(jSONObject);
            return;
        }
        HashMap map = new HashMap();
        JSONObject jSONObject2 = resultDoRequest.response;
        if (jSONObject2 != null) {
            map.put("rawResp", jSONObject2);
        }
        if (exc instanceof IOException) {
            map.put("description", "network IO exception");
            liveError = new LiveError(LiveError.NETWORK_IO_ERROR, exc.toString(), map);
        } else if (exc instanceof JSONException) {
            map.put("description", "parse JSON failure");
            String str3 = resultDoRequest.body;
            if (str3 != null) {
                map.put("rowBody", str3);
            }
            String str4 = resultDoRequest.header;
            if (str4 != null) {
                map.put("responseHeader", str4);
            }
            liveError = new LiveError(LiveError.PARSE_JSON, exc.getMessage(), map);
        } else {
            map.put("description", "response not successful");
            liveError = new LiveError(-100004, exc.getMessage(), map);
        }
        onCompletionListener.onError(liveError);
    }
}
