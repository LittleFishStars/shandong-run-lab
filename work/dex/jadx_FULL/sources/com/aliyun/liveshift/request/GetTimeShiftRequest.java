package com.aliyun.liveshift.request;

import android.content.Context;
import android.text.TextUtils;
import com.aliyun.liveshift.bean.TimeLineContent;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.source.LiveShift;
import com.aliyun.utils.b;
import com.aliyun.utils.d;
import com.aliyun.utils.e;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetTimeShiftRequest extends b {
    private static final String TAG = "GetTimeShiftRequest";
    private d httpClientHelper;
    private WeakReference<Context> mContextWeak;
    private String[] mCustomHeaders;
    private String mHttpProxy;
    private LiveShift mLiveShiftSource;
    private int mNetworkTimeout;
    private String mReferer;
    private String mUserAgent;

    public GetTimeShiftRequest(Context context, LiveShift liveShift, b.d dVar) {
        super(context, dVar);
        this.mReferer = null;
        this.mNetworkTimeout = -1;
        this.mHttpProxy = null;
        this.mUserAgent = null;
        this.mCustomHeaders = null;
        this.httpClientHelper = null;
        this.mContextWeak = new WeakReference<>(context);
        this.mLiveShiftSource = liveShift;
    }

    @Override // com.aliyun.utils.b
    public void runInBackground() throws Throwable {
        int value;
        String str;
        String timeLineUrl = this.mLiveShiftSource.getTimeLineUrl();
        if (this.wantStop) {
            sendFailResult(-1, "", "");
            return;
        }
        try {
            d dVar = new d(timeLineUrl);
            this.httpClientHelper = dVar;
            dVar.d(this.mReferer);
            this.httpClientHelper.c(this.mHttpProxy);
            this.httpClientHelper.a(this.mNetworkTimeout);
            this.httpClientHelper.e(this.mUserAgent);
            this.httpClientHelper.a(this.mCustomHeaders);
            String strB = this.httpClientHelper.b();
            if (TextUtils.isEmpty(strB)) {
                sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
                return;
            }
            JSONObject jSONObject = new JSONObject(strB);
            if (e.a(jSONObject, "retCode") != 0) {
                sendFailResult(ErrorCode.ERROR_SERVER_LIVESHIFT_REQUEST_ERROR.getValue(), "request fail", "");
            } else {
                sendSuccessResult(TimeLineContent.getInfoFromJson(jSONObject.getJSONObject("content")), "");
            }
        } catch (JSONException unused) {
            value = ErrorCode.ERROR_SERVER_LIVESHIFT_DATA_PARSER_ERROR.getValue();
            str = "response not json";
            sendFailResult(value, str, "");
        } catch (Exception unused2) {
            value = ErrorCode.ERROR_SERVER_LIVESHIFT_UNKNOWN.getValue();
            str = "unknow error";
            sendFailResult(value, str, "");
        }
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }

    public void setHttpProxy(String str) {
        this.mHttpProxy = str;
    }

    public void setRefer(String str) {
        this.mReferer = str;
    }

    public void setTimeout(int i) {
        this.mNetworkTimeout = i;
    }

    public void setUerAgent(String str) {
        this.mUserAgent = str;
    }

    @Override // com.aliyun.utils.b
    public void stopInner() {
        d dVar = this.httpClientHelper;
        if (dVar != null) {
            dVar.e();
        }
    }
}
