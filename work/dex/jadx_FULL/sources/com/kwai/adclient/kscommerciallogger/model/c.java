package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class c {
    private final d aJR;
    private final BusinessType biz;
    private final String category;
    private final String eventId;
    private final JSONObject extraParam;
    private final JSONObject msg;
    private final SubBusinessType subBiz;
    private final String tag;

    public static class a {
        private final String buW;
        private BusinessType buX;
        private SubBusinessType buY;
        private d buZ;
        private JSONObject bva;
        private String bvb;
        private String mTag;
        private JSONObject msg;

        private a(@NonNull String str) {
            this.buW = str;
        }

        public static a Yo() {
            return new a(ILoggerReporter.Category.ERROR_LOG);
        }

        public static a Yp() {
            return new a(ILoggerReporter.Category.APM_LOG);
        }

        public final a B(JSONObject jSONObject) {
            this.msg = jSONObject;
            return this;
        }

        public final c Yq() {
            if (com.kwai.adclient.kscommerciallogger.a.Yf().isDebug()) {
                if (TextUtils.isEmpty(this.buW) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bvb)) {
                    throw new IllegalArgumentException("param is error, please check it");
                }
                if (com.kwai.adclient.kscommerciallogger.a.Yf().Yh() && !com.kwai.adclient.kscommerciallogger.b.iJ(this.bvb)) {
                    throw new IllegalArgumentException("event_id format error, please check it");
                }
            } else {
                if (TextUtils.isEmpty(this.buW) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.bvb)) {
                    return null;
                }
                if (com.kwai.adclient.kscommerciallogger.a.Yf().Yh() && !com.kwai.adclient.kscommerciallogger.b.iJ(this.bvb)) {
                    return null;
                }
            }
            if (com.kwai.adclient.kscommerciallogger.a.Yf().Yg() != null) {
                this.bva = com.kwai.adclient.kscommerciallogger.a.Yf().Yg();
            }
            return new c(this, (byte) 0);
        }

        public final a iK(@NonNull String str) {
            this.mTag = str;
            return this;
        }

        public final a iL(@NonNull String str) {
            this.bvb = str;
            return this;
        }

        public final a b(SubBusinessType subBusinessType) {
            this.buY = subBusinessType;
            return this;
        }

        public final a c(BusinessType businessType) {
            this.buX = businessType;
            return this;
        }

        public final a b(d dVar) {
            this.buZ = dVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String Yi() {
        return this.category;
    }

    public final SubBusinessType Yj() {
        return this.subBiz;
    }

    public final d Yk() {
        return this.aJR;
    }

    public final JSONObject Yl() {
        return this.msg;
    }

    public final JSONObject Ym() {
        return this.extraParam;
    }

    public final String Yn() {
        return this.eventId;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            BusinessType businessType = this.biz;
            if (businessType != null) {
                jSONObject.put(com.alipay.sdk.m.m.b.l, businessType.value);
            }
            SubBusinessType subBusinessType = this.subBiz;
            if (subBusinessType != null) {
                jSONObject.put("sub_biz", subBusinessType.value);
            }
            jSONObject.put("tag", this.tag);
            d dVar = this.aJR;
            if (dVar != null) {
                jSONObject.put("type", dVar.getValue());
            }
            JSONObject jSONObject2 = this.msg;
            if (jSONObject2 != null) {
                jSONObject.put("msg", jSONObject2);
            }
            JSONObject jSONObject3 = this.extraParam;
            if (jSONObject3 != null) {
                jSONObject.put("extra_param", jSONObject3);
            }
            jSONObject.put("event_id", this.eventId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private c(a aVar) {
        this.category = aVar.buW;
        this.biz = aVar.buX;
        this.subBiz = aVar.buY;
        this.tag = aVar.mTag;
        this.aJR = aVar.buZ;
        this.extraParam = aVar.bva;
        this.eventId = aVar.bvb;
        this.msg = aVar.msg == null ? new JSONObject() : aVar.msg;
    }
}
