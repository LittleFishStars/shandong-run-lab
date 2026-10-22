package com.kc.aw;

import androidx.core.app.NotificationCompat;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.huachenjie.common.constants.UserConstants;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.Error;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _nq {
    public JSONObject _a;
    public Error _b;

    public _nq() {
        JSONObject jSONObject = new JSONObject();
        this._a = jSONObject;
        try {
            synchronized (jSONObject) {
                try {
                    this._a.put(NotificationCompat.CATEGORY_ERROR, 0);
                    this._a.put("env", com.kc.aw.lib.utils._a._a());
                    JSONObject jSONObject2 = this._a;
                    PtgAdSdk.getConfig().getClass();
                    jSONObject2.put("support", 1);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage()));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public _nq(int i) {
        this();
        _ns _nsVar = _ns._a;
        this._b = _nsVar;
    }

    public final String _a(String str) {
        try {
            synchronized (this._a) {
                JSONObject jSONObject = this._a;
                if (jSONObject == null) {
                    return "";
                }
                Object objOpt = jSONObject.opt(str);
                return objOpt == null ? "" : objOpt.toString();
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public final void _a(double d) {
        try {
            synchronized (this._a) {
                this._a.put("costPrice", d);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _a(int i) {
        try {
            synchronized (this._a) {
                this._a.put("category", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _a(long j) {
        try {
            synchronized (this._a) {
                this._a.put("consumerOrgPrice", j);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(double d) {
        try {
            synchronized (this._a) {
                this._a.put("secondPrice", d);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(int i) {
        try {
            synchronized (this._a) {
                this._a.put("ct", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(long j) {
        try {
            synchronized (this._a) {
                this._a.put("consumerPrice", j);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _b(String str) {
        try {
            synchronized (this._a) {
                this._a.put("appVersionCode", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _c(int i) {
        try {
            synchronized (this._a) {
                this._a.put("layer", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _c(String str) {
        try {
            synchronized (this._a) {
                this._a.put("appVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _d(int i) {
        try {
            synchronized (this._a) {
                this._a.put("priority", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _d(String str) {
        try {
            synchronized (this._a) {
                this._a.put("bidLossReason", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _e(int i) {
        try {
            synchronized (this._a) {
                this._a.put(NotificationCompat.CATEGORY_ERROR, i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _e(String str) {
        try {
            synchronized (this._a) {
                this._a.put("consumerSlotId", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _f(int i) {
        try {
            synchronized (this._a) {
                this._a.put(UserTrackConstant.ERROR_TYPE, i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _f(String str) {
        try {
            synchronized (this._a) {
                this._a.put("consumerType", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _g(int i) {
        try {
            synchronized (this._a) {
                this._a.put("filterCode", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _g(String str) {
        try {
            synchronized (this._a) {
                this._a.put(SendToNativeCallback.KEY_MESSAGE, str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _h(int i) {
        try {
            synchronized (this._a) {
                this._a.put("successType", i);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _h(String str) {
        try {
            synchronized (this._a) {
                this._a.put("filterMessage", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _i(String str) {
        try {
            synchronized (this._a) {
                try {
                    this._a.put("mediaId", Long.valueOf(str).longValue());
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _j(String str) {
        try {
            synchronized (this._a) {
                this._a.put("policyVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _k(String str) {
        try {
            synchronized (this._a) {
                this._a.put("sdkVersion", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _l(String str) {
        try {
            synchronized (this._a) {
                this._a.put("sdkVersionName", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _m(String str) {
        try {
            synchronized (this._a) {
                this._a.put("slotId", str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }

    public final void _n(String str) {
        try {
            synchronized (this._a) {
                this._a.put(UserConstants.URL_PARAMS.b, str);
            }
        } catch (Exception e) {
            Error error = this._b;
            if (error != null) {
                error.onError(new AdErrorImpl(PtgErrorCode.SDK_INTERNAL_ERROR, e.getMessage(), (Object) null));
            }
        }
    }
}
