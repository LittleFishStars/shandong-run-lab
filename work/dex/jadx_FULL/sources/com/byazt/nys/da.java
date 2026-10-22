package com.byazt.nys;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.dna.gu;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 72})
public class da extends com.byazt.bog.c {
    public static final c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f28856a;
    public sp n;
    public volatile Initializer tt = n();
    public volatile Initializer ve = null;
    public volatile Initializer uj = null;
    public boolean sp = false;
    public int x = Integer.MIN_VALUE;
    public long i = -1;
    public com.byazt.lm.ve da = new com.byazt.lm.ve() { // from class: com.byazt.nys.da.1
        @Override // com.byazt.lm.ve
        public Function<SparseArray<Object>, Object> c(int i) {
            return da.this.c(i);
        }
    };
    public final Object sl = new Object();

    @com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 45})
    public static final class c extends com.byazt.bog.c.ve {
        private c() {
        }

        @Override // com.byazt.bog.c.ve
        public void c(Throwable th) {
            i.c(th);
        }

        @Override // com.byazt.bog.c.ve
        public Object c(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                i.c(TTAppContextHolder.getContext()).c((TTPluginListener) obj);
            }
            if (z) {
                TTPluginListener tTPluginListener = (TTPluginListener) obj;
                return i.c(TTAppContextHolder.getContext()).c(tTPluginListener.packageName(), tTPluginListener.config());
            }
            if (obj instanceof ILiveAdCustomConfig) {
                return com.byazt.we.ve.toBridge((ILiveAdCustomConfig) obj);
            }
            if (com.byazt.gxc.tt.checkType(obj)) {
                return new com.byazt.gxc.tt(obj);
            }
            return obj instanceof TTAdInteractionListener ? new com.byazt.ph.tt((TTAdInteractionListener) obj) : obj;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 442})
    public class tt implements Function<SparseArray<Object>, Object> {
        private tt() {
        }

        public ValueSet onEvent(int i, Result result) {
            com.byazt.bog.a.ve("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (!result.isSuccess()) {
                com.byazt.bog.a.n("_tt_ad_sdk_", "pl init failed, code: " + result.code() + ", msg: " + result.message());
                a.c(result.code(), result.message(), da.this.sp ^ true, null, null);
            } else if (da.this.uj != null) {
                da daVar = da.this;
                daVar.ve = daVar.tt;
                da daVar2 = da.this;
                daVar2.tt = daVar2.uj;
                da daVar3 = da.this;
                daVar3.c(daVar3.tt.getManager(), true);
                da.this.c(2, result);
            }
            if (!da.this.sp) {
                com.byazt.bog.a.ve("_tt_ad_sdk_", "pl init callback, !isNonPlInit, finishInit");
                da.this.tt(result);
            } else if (result.isSuccess() && da.this.c(true) > 0) {
                com.byazt.bog.a.ve("_tt_ad_sdk_", "pl init callback, bst delayed, pl finished first, finishInit");
                da.this.tt(result);
            }
            if (result.isSuccess()) {
                n.c();
            }
            return null;
        }

        @Override // java.util.function.Function
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetTt = com.byazt.rl.ve.c(sparseArray).tt();
            int iIntValue = valueSetTt.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetTt.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet valueSetTt2 = com.byazt.rl.ve.c((SparseArray<Object>) sparseArray2).tt();
                onEvent(iIntValue, com.byazt.rl.tt.c().c(valueSetTt2.intValue(-999900)).c(valueSetTt2.stringValue(-999901)).c(valueSetTt2.booleanValue(-999903)).c(com.byazt.rl.ve.c((SparseArray<Object>) valueSetTt2.objectValue(-999902, SparseArray.class)).tt()).tt());
            }
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_UNLIKE})
    public static final class ve {
        public static final ve c = new ve();
        public volatile Initializer tt;

        private ve() {
        }

        private static Initializer tt(sp spVar) throws uj {
            try {
                Plugin plugin = Zeus.getPlugin("com.byted.pangle");
                spVar.tt("call_create_initializer");
                plugin.setApiBridge(com.byazt.lm.uj.instance());
                if (i.c(TTAppContextHolder.getContext()).c(spVar, 60000) == null) {
                    throw new uj(4205, "Get ClassLoader failed");
                }
                Function pluginBridge = plugin.getPluginBridge();
                if (pluginBridge == null) {
                    throw new uj(4206, "Get Bridge failed");
                }
                spVar.tt("get_bridge_cost");
                SparseArray sparseArray = new SparseArray();
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new i.ve());
                bundle.putInt("api_sdk_version", 7611);
                sparseArray.put(0, bundle);
                sparseArray.put(-99999987, 1);
                spVar.tt("create_bundle_cost");
                Object objApply = pluginBridge.apply(sparseArray);
                if (objApply == null) {
                    throw new uj(4206, "Get Initializer null");
                }
                spVar.tt("get_init_method_cost");
                try {
                    com.byazt.bog.uj ujVar = new com.byazt.bog.uj((Function) objApply);
                    spVar.tt("get_init_instance_cost");
                    com.byazt.bog.a.tt("TTPluginManager", "Create initializer success");
                    return ujVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                if (th2 instanceof uj) {
                    throw th2;
                }
                throw new uj(4206, "Create initializer failed", th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer c(sp spVar) throws uj {
            if (this.tt == null) {
                synchronized (this) {
                    if (this.tt == null) {
                        this.tt = tt(spVar);
                    }
                }
            }
            return this.tt;
        }
    }

    private boolean a() {
        x();
        return this.x == 1;
    }

    private boolean sp() {
        x();
        return this.x == 2;
    }

    private void x() {
        if (this.x == Integer.MIN_VALUE) {
            if (this.f28856a == null) {
                this.f28856a = com.byazt.nys.tt.tt(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
            }
            int i = this.f28856a.getInt("bst_pl_exec_conf", -1);
            this.x = i;
            if (i >= 0) {
                return;
            }
            this.x = this.f28856a.getInt("_use_pl_", 0);
        }
    }

    private static Initializer n() {
        String str;
        Object initialInstance;
        try {
            if (com.byazt.bog.n.c()) {
                return null;
            }
            Zeus.setMainService(com.byazt.ut.uj.getInstance());
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new i.ve());
            bundle.putInt("api_sdk_version", 7611);
            com.byazt.dna.i iVar = (com.byazt.dna.i) com.byazt.ut.uj.getService("boost");
            if (iVar != null) {
                initialInstance = iVar.getInitialInstance(bundle);
                str = null;
            } else {
                str = "service null";
                initialInstance = null;
            }
            if (initialInstance == null) {
                if (str == null) {
                    str = "getNewInstance null";
                }
                a.c(4206, str, false, null, null);
            }
            return new com.byazt.bog.uj((Function) initialInstance);
        } catch (Throwable th) {
            a.c(4206, th.getMessage(), false, null, th);
            com.byazt.bog.a.n("_tt_ad_sdk_", "Get direct initializer failed", th);
            return null;
        }
    }

    @Override // com.byazt.bog.c
    public com.byazt.lm.ve uj() {
        return this.da;
    }

    @Override // com.byazt.bog.c
    public com.byazt.bog.c.ve ve() {
        return c;
    }

    @Override // com.byazt.bog.c
    public boolean tt(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.tt(context, adConfig, initCallback);
        this.n = sp.c("duration");
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.byazt.bog.a.tt("_tt_ad_sdk_", e);
        }
        if (com.byazt.bog.n.c()) {
            tt(com.byazt.rl.tt.c().c(false).c(4204).c("Only support >= 7.0").tt());
            return false;
        }
        a.c(adConfig);
        return true;
    }

    @Override // com.byazt.bog.c
    public void c(Result result) {
        super.c(result);
        a.c();
    }

    @Override // com.byazt.bog.c
    public boolean c(Context context, com.byazt.rl.ve veVar) {
        boolean zC = c(context);
        if (zC && a()) {
            com.byazt.bog.a.ve("_tt_ad_sdk_", "force pl");
            return false;
        }
        if (com.byazt.zyp.ve.tt()) {
            com.byazt.bog.a.n("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.tt != null) {
            this.sp = true;
            c(this.tt.getManager(), false);
            c(context, veVar, zC);
            return false;
        }
        tt(com.byazt.rl.tt.c().c(false).c(4206).tt());
        return true;
    }

    @Override // com.byazt.bog.c
    public void tt(Context context, final com.byazt.rl.ve veVar) {
        com.byazt.bog.a.ve("_tt_ad_sdk_", "async init");
        boolean z = this.sp;
        this.n.tt("wait_asyn_cost");
        i.c(TTAppContextHolder.getContext()).c(new EventListener() { // from class: com.byazt.nys.da.3
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i, Result result) {
                if (i == 0) {
                    if (!result.isSuccess() || da.this.uj != null) {
                        com.byazt.bog.a.uj("_tt_ad_sdk_", "failed event");
                        return null;
                    }
                    com.byazt.bog.a.uj("_tt_ad_sdk_", "from event");
                    da.this.n.tt("wait_pl_install");
                    da daVar = da.this;
                    daVar.c(daVar.n, veVar);
                    return null;
                }
                if (i != 1 || !result.isSuccess() || da.this.uj != null || veVar == null) {
                    return null;
                }
                da.this.n = sp.c("duration");
                veVar.c(1, SystemClock.elapsedRealtime());
                return null;
            }
        });
        if (com.byazt.zyp.ve.tt()) {
            com.byazt.bog.a.uj("_tt_ad_sdk_", "start load pl.");
            c(this.n, veVar);
        } else if (sp()) {
            com.byazt.bog.a.uj("_tt_ad_sdk_", "force boost, dont load pl");
        } else if (c(context)) {
            com.byazt.bog.a.uj("_tt_ad_sdk_", "start load pl..");
            c(this.n, veVar);
        } else {
            com.byazt.bog.a.uj("_tt_ad_sdk_", "no pl");
        }
    }

    private void c(final Context context, final com.byazt.rl.ve veVar, boolean z) {
        long jC = c(z);
        if (jC > 0) {
            com.byazt.qy.c.c().ve().postDelayed(new Runnable() { // from class: com.byazt.nys.da.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.qy.c.c().uj().execute(new Runnable() { // from class: com.byazt.nys.da.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Initializer initializer = da.this.tt;
                            if (da.this.c() || da.this.uj == initializer) {
                                com.byazt.bog.a.ve("_tt_ad_sdk_", "skip boost init, plugin already finished");
                                return;
                            }
                            ValueSet valueSetTt = com.byazt.rl.ve.c(veVar.tt().sparseArray()).c(27, SystemClock.elapsedRealtime()).tt();
                            if (initializer != null) {
                                initializer.init(context, valueSetTt);
                            }
                        }
                    });
                }
            }, jC);
        } else {
            this.tt.init(context, veVar.tt());
        }
    }

    private boolean c(Context context) {
        return com.byazt.nys.tt.uj(context);
    }

    @Override // com.byazt.bog.c
    public boolean tt() {
        return (com.byazt.bog.n.c() || this.tt == null || !this.tt.isInitSuccess()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> c(int i) {
        if (i == 2) {
            return com.byazt.we.ve.instance();
        }
        if (i == 3) {
            return com.byazt.nu.ve.instance(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.byazt.qc.c.instance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sp spVar, com.byazt.rl.ve veVar) {
        if (this.uj == null || !this.uj.isInitSuccess()) {
            com.byazt.rl.ve veVarC = com.byazt.rl.ve.c(veVar.tt().sparseArray());
            veVarC.c(15, new tt());
            try {
                if (this.uj == null) {
                    synchronized (ve.class) {
                        try {
                            if (this.uj == null) {
                                Initializer initializerC = ve.c.c(spVar);
                                this.uj = initializerC;
                                c(initializerC, spVar, veVarC);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Exception e) {
                int iC = e instanceof uj ? ((uj) e).c() : 4206;
                com.byazt.bog.a.n("_tt_ad_sdk_", "loadPl failed, code: " + iC + ", msg: " + e.getMessage());
                a.c(iC, e.getMessage(), true, spVar, e);
                if (this.sp) {
                    return;
                }
                tt(com.byazt.rl.tt.c().c(false).c(4206).c(e.getMessage()).tt());
            }
        }
    }

    private void c(Manager manager, Result result) {
        if (manager == null || !(manager instanceof com.byazt.bog.ve)) {
            return;
        }
        Function<SparseArray<Object>, Object> functionC = ((com.byazt.bog.ve) manager).c(1);
        if (functionC instanceof Function) {
            com.byazt.bog.a.ve("_tt_ad_sdk_", "quitWork, notify bst manager to quit");
            functionC.apply(com.byazt.rl.ve.c(1).c(-99999987, 16).c(-99999985, Void.class).c(17, true).c(21, result.values() == null ? null : result.values().sparseArray()).tt().sparseArray());
        }
    }

    private static void c(Initializer initializer, sp spVar, com.byazt.rl.ve veVar) throws uj {
        if (initializer != null) {
            try {
                spVar.c();
                JSONObject jSONObject = new JSONObject();
                spVar.c(jSONObject, 20L);
                jSONObject.put("zeus", i.c(TTAppContextHolder.getContext()).c());
                initializer.init(TTAppContextHolder.getContext(), veVar.c(9, jSONObject).tt());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.byazt.bog.a.tt("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new uj(4207, "Init error", e);
            }
        }
        throw new uj(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "initializer null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long c(boolean z) {
        x();
        if (this.x != 0 || !z) {
            return 0L;
        }
        if (this.i < 0) {
            try {
                this.i = this.f28856a.getLong("bstlayer_init_delay_time", 0L);
            } catch (Throwable unused) {
                this.i = 0L;
            }
        }
        return this.i;
    }

    @Override // com.byazt.bog.c
    public void c(int i, Result result) {
        int iIntValue = -1;
        try {
            gu guVar = (gu) com.byazt.ut.uj.getService("m_d_s");
            if (guVar != null) {
                synchronized (this.sl) {
                    try {
                        Object data = guVar.getData(3);
                        iIntValue = data instanceof Integer ? ((Integer) data).intValue() : -1;
                        if (iIntValue < 0) {
                            guVar.setData(3, Integer.valueOf(i));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.byazt.bog.a.uj("_tt_ad_sdk_", th2.getMessage());
        }
        if (i == 2 || iIntValue == 2) {
            Initializer initializer = this.ve;
            if (this.sp && initializer != null && initializer.isInitSuccess()) {
                c(initializer.getManager(), result);
                this.ve = null;
            }
        }
    }
}
