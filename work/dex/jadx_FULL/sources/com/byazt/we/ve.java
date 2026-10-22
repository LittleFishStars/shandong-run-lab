package com.byazt.we;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.alipay.sdk.m.m.b;
import com.byazt.bog.a;
import com.byazt.hj.z;
import com.byazt.lm.uj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.sg5;
import com.zj.adlib.xh9;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 916, 54})
public final class ve implements Function<SparseArray<Object>, Object> {
    public static final String TAG = "TTLiveSDkBridge";
    public static final ve c = new ve();
    public volatile ILiveInitCallback n;
    public volatile Function<SparseArray<Object>, Object> tt;
    public volatile C0562ve uj;
    public Map<String, String> ve;

    @com.byazt.zqa.c(c = {0, 1, 916, 24})
    public static final class c implements Function<SparseArray<Object>, Object> {
        public ILiveAdCustomConfig c;

        public c(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.c = iLiveAdCustomConfig;
        }

        @Override // java.util.function.Function
        public Object apply(SparseArray<Object> sparseArray) {
            int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
            if (iIntValue == -99999986) {
                return com.byazt.rl.ve.c().c(10000, 1).tt().sparseArray();
            }
            if (iIntValue == 0) {
                return Integer.valueOf(this.c.openLR((String) sparseArray.get(0)));
            }
            if (iIntValue == 1) {
                return this.c.convertToEnterFromMerge(((Integer) sparseArray.get(0)).intValue());
            }
            if (iIntValue == 2) {
                return this.c.convertToEnterMethod(((Integer) sparseArray.get(0)).intValue(), ((Boolean) sparseArray.get(1)).booleanValue());
            }
            if (iIntValue == 3) {
                return this.c.invoke(((Integer) sparseArray.get(0)).intValue(), (Bundle) sparseArray.get(1));
            }
            if (iIntValue == 4) {
                this.c.onEventV3((String) sparseArray.get(0), (JSONObject) sparseArray.get(1));
                return null;
            }
            if (iIntValue != 5) {
                return null;
            }
            return this.c;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 916, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public final class tt implements ILiveInitCallback {
        private tt() {
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFailed(String str) {
            a.c(ve.TAG, "onLiveInitFailed! ", str);
            if (ve.this.uj != null) {
                ve.this.uj.c(-3, str, false);
            }
        }

        @Override // com.bytedance.android.live.base.api.ILiveInitCallback
        public void onLiveInitFinish() {
            a.tt(ve.TAG, "onLiveInitFinish!");
            com.byazt.we.tt.c();
            if (ve.this.uj != null) {
                ve.this.uj.c(2, null, false);
            }
            ve.this.ve = null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.we.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 916, 917})
    public final class C0562ve implements TTPluginListener {
        public int c;
        public String tt;

        private C0562ve() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            c(i, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.c = i;
            if (ve.this.tt != null) {
                ve.this.tt.apply(com.byazt.rl.ve.c().c(0, i).c(1, classLoader).c(2, resources).c(3, bundle).c(4, ve.this.c(z)).c(-99999987, 3).tt().sparseArray());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(int i, String str, boolean z) {
            this.c = i;
            this.tt = str;
            if (ve.this.tt != null) {
                com.byazt.rl.ve veVarC = com.byazt.rl.ve.c().c(0, i);
                if (str != null) {
                    veVarC.c(1, str);
                }
                veVarC.c(2, ve.this.c(z)).c(-99999987, 2);
                ve.this.tt.apply(veVarC.tt().sparseArray());
            }
        }
    }

    private ve() {
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    public static ve instance() {
        return c;
    }

    private Boolean n(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get("context"));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.byazt.we.tt.c(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            reportException("handleLiveScheme", th);
            a.tt(TAG, th);
            return Boolean.FALSE;
        }
    }

    public static void reportException(String str, Throwable th) {
        try {
            TTAdManager adManager = TTAdSdk.getAdManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", str);
            if (th != null) {
                jSONObject.put("msg", Log.getStackTraceString(th));
            }
            Bundle bundle = new Bundle();
            bundle.putInt("action", 1);
            bundle.putString(sg5.c, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a);
            bundle.putString("event_extra", jSONObject.toString());
            adManager.getExtra(Bundle.class, bundle);
        } catch (Exception e) {
            a.tt(TAG, e);
        }
    }

    public static Function<SparseArray<Object>, Object> toBridge(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new c(iLiveAdCustomConfig);
    }

    private Object uj(Map<String, Object> map) {
        String str;
        try {
            str = (String) map.get("expand_method_name");
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
                Object[] objArr = (Object[]) map.get("expand_method_param");
                if (objArr == null) {
                    return liveRoomService.callExpandMethod(str, new Object[0]);
                }
                for (int i = 0; i < objArr.length; i++) {
                    Object obj = objArr[i];
                    if (obj instanceof Function) {
                        objArr[i] = new com.byazt.we.c((Function) obj);
                    }
                }
                return liveRoomService.callExpandMethod(str, objArr);
            } catch (Throwable th) {
                th = th;
                reportException("invokeLiveExpandMethod-".concat(String.valueOf(str)), th);
                a.tt(TAG, th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private Function<SparseArray<Object>, Object> ve(Map map) {
        return z.c(map.get("c_control"));
    }

    public <T> T callMethod(int i, Map<String, Object> map) {
        if (i == 0) {
            return !com.byazt.we.tt.c(getContext(map.get("context")), c(map.get("bundle"))) ? (T) 2 : (T) 0;
        }
        if (i == 7) {
            return (T) uj(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) n(map);
    }

    public void setLiveInitExtra(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.ve = map;
    }

    private void tt(Map map) {
        ILiveHostContextParam.Builder builderAddHostInitExtra = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get(xh9.WEBSITE_PARAMS_CHANNEL))).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get(b.z0))).provideMethodChannel(new MethodChannelService() { // from class: com.byazt.we.ve.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (ve.this.tt == null) {
                    return null;
                }
                return ve.this.tt.apply(com.byazt.rl.ve.c().c(0, str).c(1, map2).c(-99999987, 0).tt().sparseArray());
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.byazt.jh.c(ve(map))).setHostActionParam(new com.byazt.jh.tt(this.tt)).addHostInitExtra(c(map));
        Map<String, String> map2 = this.ve;
        if (map2 != null) {
            builderAddHostInitExtra.addHostInitExtra(map2);
        }
        if (this.n == null) {
            this.n = new tt();
        }
        if (TTAppContextHolder.getContext() instanceof Application) {
            builderAddHostInitExtra.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get("sub_process"))).booleanValue();
        a.c(TAG, "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.byazt.we.tt.c(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), builderAddHostInitExtra, this.n, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
        int iIntValue = valueSetTt.intValue(-99999987);
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 2);
            return sparseArray2;
        }
        if (iIntValue == 5) {
            tt((Map) valueSetTt.objectValue(0, Map.class));
            return null;
        }
        if (iIntValue != 9) {
            return callMethod(iIntValue, (Map) valueSetTt.objectValue(0, Map.class));
        }
        this.tt = z.c(valueSetTt.objectValue(0, Object.class));
        if (this.uj == null) {
            this.uj = new C0562ve();
            Function<SparseArray<Object>, Object> functionC = z.c(uj.instance().apply(com.byazt.rl.ve.c(2).c(0, 4).c(-99999987, 10).tt().sparseArray()));
            ValueSet valueSetTt2 = com.byazt.rl.ve.c(2).c(-99999987, 106).c(0, this.uj).tt();
            if (functionC != null) {
                functionC.apply(valueSetTt2.sparseArray());
            }
        } else if (this.uj.c == 2 || this.uj.c == -3) {
            this.uj.c(this.uj.c, this.uj.tt, true);
        } else if (this.uj.c != 0) {
            this.uj.c(this.uj.c, null, null, null, true);
        }
        return null;
    }

    private Map<String, String> c(Map map) {
        Object obj = map.get("live_tob_init_extra");
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new HashMap();
    }

    private Bundle c(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map c(boolean z) {
        HashMap map = new HashMap();
        map.put("onlyUpdateState", Boolean.valueOf(z));
        return map;
    }
}
