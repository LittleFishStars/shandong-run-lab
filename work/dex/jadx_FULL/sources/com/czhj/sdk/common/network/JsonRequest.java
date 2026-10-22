package com.czhj.sdk.common.network;

import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JsonRequest extends SigmobRequest<JSONObject> {
    protected static final String PROTOCOL_CHARSET = "utf-8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29410a = 0;
    private final Listener b;

    public interface Listener extends Response.ErrorListener {
        void onSuccess(JSONObject jSONObject);
    }

    public JsonRequest(String str, Listener listener, int i) {
        super(str, 0, listener);
        this.b = listener;
        setRetryPolicy(new DefaultRetryPolicy(5000, 2, 0.0f));
        setShouldCache(false);
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(JSONObject jSONObject) {
        Listener listener;
        synchronized (this.mLock) {
            listener = this.b;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (listener != null) {
            listener.onSuccess(jSONObject);
        }
    }

    @Override // com.czhj.sdk.common.network.SigmobRequest, com.czhj.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }
}
