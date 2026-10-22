package com.bykv.vk.component.ttvideo.log;

import com.bykv.vk.component.ttvideo.player.Keep;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public final class LiveError extends Error {
    public static final int AGAIN_ERROR = -100014;
    public static final int BYTEVC1_URL_IS_NULL = -100017;
    public static final int DNS_PARSE_ERROR = -100010;
    public static final int EMPTY = -100011;
    public static final int INFO_DND_ERROR = -100012;
    public static final int IO_BLOCKED = -100018;
    public static final int LIVE_API_URL_INVALID = -100006;
    public static final int LIVE_DATA_EMPTY = -100005;
    public static final int NETWORK_IO_ERROR = -100008;
    public static final int NO_ERROR = 0;
    public static final int PARSE_JSON = -100000;
    public static final int PLAYER_DATASOURCE = -100002;
    public static final int PLAYER_INTERNAL = -100003;
    public static final int PLAYER_PREPARE = -100001;
    public static final int PLAYER_STALL = -100015;
    public static final int PLAY_DNS_ERROR = -100013;
    public static final int QUIC_LOAD_LIBRARY_ERROR = -499499;
    public static final int RESPONSE_ERROR = -100004;
    public static final int SEI_UPLOAD_TIME_OUT = -100016;
    public static final int STALL_RETRY_TIMEOUT = -100007;
    public static final int STREAM_DRYUP = -100009;
    private static final String TAG = "Live Error";
    public int code;
    public Map info;
    public long timeStamp;

    public LiveError(int i, String str, Map<String, String> map) {
        super(str);
        this.code = i;
        this.info = map;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getInfoJSON() {
        if (this.info == null) {
            this.info = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(this.info);
        try {
            jSONObject.put("timestamp", this.timeStamp);
            jSONObject.put("message", super.toString());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.info == null) {
            this.info = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(this.info);
        try {
            jSONObject.put("message", super.toString());
            jSONObject.put("code", this.code);
            jSONObject.put("timestamp", this.timeStamp);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
