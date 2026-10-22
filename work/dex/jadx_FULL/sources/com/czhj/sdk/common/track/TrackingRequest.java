package com.czhj.sdk.common.track;

import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.Request;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TrackingRequest extends Request<NetworkResponse> {
    private static final int ZERO_RETRIES = 0;
    private static int reTryFailCount;
    private final RequestListener mListener;

    public interface RequestListener extends Response.ErrorListener {
        void onSuccess(NetworkResponse networkResponse);
    }

    public TrackingRequest(String str, int i, int i2, RequestListener requestListener) {
        super(0, str, requestListener);
        this.mListener = requestListener;
        if (i < 0) {
            i = 0;
        } else if (i > 3) {
            i = 3;
        }
        setShouldRetryServerErrors(true);
        setRetryPolicy(new DefaultRetryPolicy(i2, i2, i, 0.0f));
        setShouldCache(false);
    }

    public TrackingRequest(String str, int i, RequestListener requestListener) {
        this(str, i, Config.sharedInstance().getNetworkTimeout(), requestListener);
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        SigmobLog.e("send tracking: " + getUrl() + " fail");
        super.deliverError(volleyError);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(NetworkResponse networkResponse) {
        RequestListener requestListener;
        synchronized (this.mLock) {
            requestListener = this.mListener;
        }
        SigmobLog.i("send tracking: " + getUrl() + " success");
        if (requestListener != null) {
            requestListener.onSuccess(networkResponse);
        }
    }

    @Override // com.czhj.volley.Request
    public int getMaxLength() {
        return 100;
    }

    @Override // com.czhj.volley.Request
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        return Response.success(networkResponse, null);
    }
}
