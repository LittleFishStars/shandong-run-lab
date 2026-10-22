package com.byazt.cn;

import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.aas.md;
import com.byazt.bv.BaseConstants;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.we.ve;
import com.byazt.ysz.sp;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1569, 20})
public class c implements Function<SparseArray<Object>, Object> {
    public final sp c;

    public c(sp spVar) {
        this.c = spVar;
    }

    private void a(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.c.c(map);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object c(PluginValueSet pluginValueSet) {
        byte b = 0;
        String strStringValue = pluginValueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        strStringValue.hashCode();
        switch (strStringValue.hashCode()) {
            case -1828730287:
                if (!strStringValue.equals("sendGoldExchangeCoupon")) {
                    b = -1;
                }
                break;
            case -955478604:
                b = !strStringValue.equals("getBiddingToken") ? (byte) -1 : (byte) 1;
                break;
            case -366799433:
                b = !strStringValue.equals("onTaskFinish") ? (byte) -1 : (byte) 2;
                break;
            case 862273347:
                b = !strStringValue.equals("onLiveFakeInitFinish") ? (byte) -1 : (byte) 3;
                break;
            case 1186389324:
                b = !strStringValue.equals("getPanglePluginVersion") ? (byte) -1 : (byte) 4;
                break;
            case 1388496268:
                b = !strStringValue.equals("onAuthCallback") ? (byte) -1 : (byte) 5;
                break;
            case 1562160023:
                b = !strStringValue.equals("getPangleApiVersion") ? (byte) -1 : (byte) 6;
                break;
            case 1979487267:
                b = !strStringValue.equals("reportPangleEvent") ? (byte) -1 : (byte) 7;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ve(pluginValueSet);
                return null;
            case 1:
                return n(pluginValueSet);
            case 2:
                uj(pluginValueSet);
                return null;
            case 3:
                tt(pluginValueSet);
                return null;
            case 4:
                return 7611;
            case 5:
                sp(pluginValueSet);
                return null;
            case 6:
                return String.valueOf(p.uj);
            case 7:
                a(pluginValueSet);
                return null;
            default:
                return null;
        }
    }

    private Object n(PluginValueSet pluginValueSet) {
        try {
            Integer numX = x(pluginValueSet);
            if (numX == null) {
                return null;
            }
            return gt.c().c(md.c(numX.intValue(), com.byazt.vxy.c.tt()));
        } catch (Throwable th) {
            m.tt(ve.TAG, "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void sp(PluginValueSet pluginValueSet) {
        try {
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            this.c.c(Integer.valueOf((String) map.get("is_auth")).intValue() != 0, (String) map.get("open_uid"));
        } catch (Exception e) {
            m.tt("LiveServiceBridge", e);
        }
    }

    private void tt(PluginValueSet pluginValueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get("success");
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            m.tt("LiveServiceBridge", e);
            message = e.getMessage();
        }
        this.c.c(i, message, false, true);
    }

    private void uj(PluginValueSet pluginValueSet) {
        try {
            this.c.tt((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            m.tt("LiveServiceBridge", e);
        }
    }

    private void ve(PluginValueSet pluginValueSet) {
        try {
            this.c.ve((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            m.tt("LiveServiceBridge", e);
        }
    }

    private Integer x(PluginValueSet pluginValueSet) {
        String strSp = com.byazt.apd.tt.c().sp();
        if (strSp == null) {
            return null;
        }
        if (strSp.replaceAll(Consts.DOT, "").startsWith("2112")) {
            Object[] objArrArrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (objArrArrayValue == null || objArrArrayValue.length == 0) {
                return null;
            }
            return (Integer) objArrArrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e) {
                m.c(e);
                return;
            }
        }
        new com.byazt.ddx.c.C0382c().c(str).tt(str2).ve(BaseConstants.CATEGORY_UMENG).n(jSONObject.optString("value")).uj(jSONObject.optString("log_extra")).c(new com.byazt.ya.c() { // from class: com.byazt.cn.c.1
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA))) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has(BaseConstants.EVENT_LABEL_IS_AD_EVENT)) {
                    return;
                }
                jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            }
        });
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        if (iIntValue == 0) {
            return c(pluginValueSetTt);
        }
        if (iIntValue == 1) {
            logEvent(pluginValueSetTt.booleanValue(0), pluginValueSetTt.stringValue(1), pluginValueSetTt.stringValue(2), (Map) pluginValueSetTt.objectValue(3, Map.class));
        } else if (iIntValue == 2) {
            this.c.c(pluginValueSetTt.intValue(0), pluginValueSetTt.stringValue(1), c(pluginValueSetTt, 2), false);
        } else if (iIntValue == 3) {
            int iIntValue2 = pluginValueSetTt.intValue(0);
            boolean zC = c(pluginValueSetTt, 4);
            if (1000 == iIntValue2) {
                this.c.c(5, (String) null, zC, false);
                if (!zC) {
                    this.c.c();
                }
            } else if (1001 == iIntValue2) {
                this.c.c(-2, pluginValueSetTt.stringValue(1), zC, false);
            }
        }
        return null;
    }

    private boolean c(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            return map != null && map.containsKey("onlyUpdateState") && Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")));
        } catch (Throwable unused) {
        }
    }
}
