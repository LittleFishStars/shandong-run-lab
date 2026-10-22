package com.byazt.bog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ExitInstallListener;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 935, 20})
public abstract class c {
    public TTAdSdk.InitCallback c;
    public final AtomicBoolean tt = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.byazt.bog.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 935, 44})
    public static abstract class AbstractC0353c<T> {
        private AbstractC0353c() {
        }

        public abstract void c(tt<T> ttVar, int i);
    }

    public interface tt<T> {
        void c(T t);
    }

    @com.byazt.zqa.c(c = {0, 1, 935, 187})
    public class uj implements Function<SparseArray<Object>, Object> {
        private uj() {
        }

        @Override // java.util.function.Function
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray == null || (sparseArray2 = (SparseArray) com.byazt.rl.ve.c(sparseArray).tt().objectValue(-99999979, SparseArray.class)) == null) {
                return null;
            }
            ValueSet valueSetTt = com.byazt.rl.ve.c((SparseArray<Object>) sparseArray2).tt();
            Result resultTt = com.byazt.rl.tt.c().c(valueSetTt.intValue(-999900)).c(valueSetTt.stringValue(-999901)).c(valueSetTt.booleanValue(-999903)).c(com.byazt.rl.ve.c((SparseArray<Object>) valueSetTt.objectValue(-999902, SparseArray.class)).tt()).tt();
            if (resultTt.isSuccess()) {
                c.this.c(1, resultTt);
            }
            c.this.tt(resultTt);
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 935, 132})
    public static abstract class ve implements TTAdManager {
        public volatile Manager c;
        public Map<tt<Manager>, Object> n = new WeakHashMap();
        public volatile Manager tt;
        public volatile boolean uj;
        public volatile boolean ve;

        /* JADX INFO: renamed from: com.byazt.bog.c$ve$1, reason: invalid class name */
        @com.byazt.zqa.c(c = {0, 1, 935, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME})
        public class AnonymousClass1 extends AbstractC0353c<Loader> {
            public Loader c;
            public final tt<Manager> tt;
            public final /* synthetic */ SoftReference ve;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.ve = softReference;
                this.tt = new tt<Manager>() { // from class: com.byazt.bog.c.ve.1.1
                    @Override // com.byazt.bog.c.tt
                    public void c(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.c = manager.createLoader((Context) anonymousClass1.ve.get());
                    }
                };
            }

            @Override // com.byazt.bog.c.AbstractC0353c
            public void c(final tt<Loader> ttVar, int i) {
                Loader loader = this.c;
                if (loader != null) {
                    ttVar.c(loader);
                } else {
                    ve.this.call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.1.2
                        @Override // com.byazt.bog.c.tt
                        public void c(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ve.this.c(anonymousClass1.tt);
                            AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                            anonymousClass2.c = manager.createLoader((Context) anonymousClass2.ve.get());
                            ttVar.c(AnonymousClass1.this.c);
                        }
                    }, i + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final tt<Manager> ttVar, final int i) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            if (this.c == null) {
                if (!this.ve && i > 10000) {
                    throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
                }
                com.byazt.qy.c.c().c(new Runnable() { // from class: com.byazt.bog.c.ve.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ve.this.c != null) {
                                ttVar.c(ve.this.c);
                                return;
                            }
                            a.uj("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        } catch (Throwable th) {
                            a.uj("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                            ve.this.c(th);
                        }
                    }
                });
                return;
            }
            try {
                ttVar.c(this.c);
            } catch (Throwable th) {
                a.uj("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                c(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T tt(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionC;
            if (com.byazt.bog.n.c()) {
                return null;
            }
            SparseArray<Object> sparseArray = com.byazt.rl.ve.c(3).c(9, cls).c(10, bundle).c(-99999987, 6).c(-99999985, cls).tt().sparseArray();
            if (!(manager instanceof com.byazt.bog.ve) || (functionC = ((com.byazt.bog.ve) manager).c(1)) == null) {
                return null;
            }
            return (T) functionC.apply(sparseArray);
        }

        public Object c(Object obj) {
            return obj;
        }

        public void c(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.byazt.bog.n.c()) {
                return null;
            }
            return new n(new AnonymousClass1(new SoftReference(context))).c();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.byazt.bog.n.c()) {
                return null;
            }
            if (this.c != null) {
                return (T) tt(c(bundle), cls, bundle);
            }
            call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.4
                @Override // com.byazt.bog.c.tt
                public void c(Manager manager) {
                    ve.tt(ve.this.c(bundle), cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.c != null ? this.c.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.6.1.1";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.c != null) {
                return this.c.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> functionC;
            ValueSet valueSetTt = com.byazt.rl.ve.c().c(20, bundle).c(-99999987, 19).c(-99999985, Bundle.class).tt();
            if ((this.c instanceof com.byazt.bog.ve) && (functionC = ((com.byazt.bog.ve) this.c).c(1)) != null) {
                Object objApply = functionC.apply(valueSetTt.sparseArray());
                if (objApply instanceof Bundle) {
                    return (Bundle) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.2
                @Override // com.byazt.bog.c.tt
                public void c(Manager manager) {
                    Function<SparseArray<Object>, Object> functionC;
                    SparseArray<Object> sparseArray = com.byazt.rl.ve.c(2).c(8, ve.this.c(obj)).c(-99999987, 4).c(-99999985, Void.class).tt().sparseArray();
                    if (!(manager instanceof com.byazt.bog.ve) || (functionC = ((com.byazt.bog.ve) manager).c(1)) == null) {
                        return;
                    }
                    functionC.apply(sparseArray);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.5
                @Override // com.byazt.bog.c.tt
                public void c(Manager manager) {
                    Function<SparseArray<Object>, Object> functionC;
                    SparseArray<Object> sparseArray = com.byazt.rl.ve.c(2).c(7, context).c(-99999987, 3).c(-99999985, Void.class).tt().sparseArray();
                    if (!(manager instanceof com.byazt.bog.ve) || (functionC = ((com.byazt.bog.ve) manager).c(1)) == null) {
                        return;
                    }
                    functionC.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.6
                @Override // com.byazt.bog.c.tt
                public void c(Manager manager) {
                    Function<SparseArray<Object>, Object> functionC;
                    ValueSet valueSetTt = com.byazt.rl.ve.c().c(11, i).c(-99999987, 1).c(-99999985, Void.class).tt();
                    if (!(manager instanceof com.byazt.bog.ve) || (functionC = ((com.byazt.bog.ve) manager).c(1)) == null) {
                        return;
                    }
                    functionC.apply(valueSetTt.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.byazt.bog.n.c()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_ACTIVITY, activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.byazt.ph.c(exitInstallListener));
            Object objApply = com.byazt.nu.ve.instance(TTAppContextHolder.getContext()).apply(com.byazt.rl.ve.c(2).c(0, map).c(-99999987, 0).c(-99999985, Boolean.class).tt().sparseArray());
            if (objApply == null) {
                return false;
            }
            return ((Boolean) objApply).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            call(new tt<Manager>() { // from class: com.byazt.bog.c.ve.3
                @Override // com.byazt.bog.c.tt
                public void c(Manager manager) {
                    Function<SparseArray<Object>, Object> functionC;
                    Object ttVar = obj;
                    if (com.byazt.gxc.tt.checkType(ttVar)) {
                        ttVar = new com.byazt.gxc.tt(obj);
                    }
                    SparseArray<Object> sparseArray = com.byazt.rl.ve.c(2).c(8, ttVar).c(-99999987, 5).c(-99999985, Void.class).tt().sparseArray();
                    if (!(manager instanceof com.byazt.bog.ve) || (functionC = ((com.byazt.bog.ve) manager).c(1)) == null) {
                        return;
                    }
                    functionC.apply(sparseArray);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionC;
            if (com.byazt.bog.n.c()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetTt = com.byazt.rl.ve.c(com.byazt.fqu.tt.c(adSlot)).c(13, z).c(14, i).c(-99999987, 2).c(-99999985, String.class).tt();
            if ((this.c instanceof com.byazt.bog.ve) && (functionC = ((com.byazt.bog.ve) this.c).c(1)) != null) {
                Object objApply = functionC.apply(valueSetTt.sparseArray());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
            return null;
        }

        public void c(boolean z) {
            this.ve = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Manager manager, boolean z) {
            if (com.byazt.bog.n.c()) {
                return;
            }
            this.uj = z;
            this.c = manager;
            if (!z) {
                this.tt = manager;
            }
            if (this.c == null || !z) {
                return;
            }
            try {
                Iterator<tt<Manager>> it = this.n.keySet().iterator();
                while (it.hasNext()) {
                    it.next().c(this.c);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(tt<Manager> ttVar) {
            if (com.byazt.bog.n.c() || this.uj) {
                return;
            }
            this.n.put(ttVar, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Manager c(Bundle bundle) {
            if (((bundle == null || !bundle.containsKey("layerType")) ? 0 : bundle.getInt("layerType")) == 1 && this.tt != null) {
                return this.tt;
            }
            return this.c;
        }
    }

    public void c(int i, Result result) {
    }

    public void c(Result result) {
    }

    public boolean c() {
        return this.tt.get();
    }

    public abstract boolean c(Context context, com.byazt.rl.ve veVar);

    public abstract void tt(Context context, com.byazt.rl.ve veVar);

    public void tt(Result result) {
        c(result);
        if (!this.tt.compareAndSet(false, true)) {
            a.uj("_tt_ad_sdk_", "finishInit callback already invoked, skip");
            return;
        }
        if (result.isSuccess()) {
            a.tt("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.c;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            a.n("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.c;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.c = null;
    }

    public abstract boolean tt();

    public boolean tt(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.byazt.lm.ve uj();

    public abstract ve ve();

    public void c(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.byazt.bog.n.c()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.byazt.lm.uj.instance().setBridgeFactory(uj());
        if (tt(context, adConfig, initCallback)) {
            this.c = initCallback;
            this.tt.set(false);
            final com.byazt.rl.ve veVarC = com.byazt.rl.ve.c(com.byazt.fqu.c.c(adConfig));
            c(adConfig, veVarC);
            veVarC.c(1, SystemClock.elapsedRealtime());
            veVarC.c(5, "main");
            veVarC.c(4, true);
            veVarC.c(6, 1000);
            veVarC.c(10, 7611);
            veVarC.c(11, "7.6.1.1");
            veVarC.c(12, "com.byted.pangle");
            veVarC.c(14, true);
            veVarC.c(26, com.byazt.zyp.ve.ve());
            veVarC.c(16, com.byazt.lm.uj.instance());
            veVarC.c(17, com.byazt.qy.c.c().tt());
            Thread threadCurrentThread = Thread.currentThread();
            veVarC.c(2, threadCurrentThread.getName());
            veVarC.c(3, threadCurrentThread.getPriority());
            veVarC.c(15, new uj());
            veVarC.c(8301, new MediationInitCLassLoader());
            if (!c(context, veVarC)) {
                com.byazt.qy.c.c().c(new Runnable() { // from class: com.byazt.bog.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tt(context, veVarC);
                    }
                });
            }
            ve().c(true);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 935, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT})
    public static class n extends com.byazt.io.c {
        public AbstractC0353c<Loader> c;

        public n(AbstractC0353c<Loader> abstractC0353c) {
            this.c = abstractC0353c;
        }

        private void c(tt<Loader> ttVar, int i) {
            a.tt("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.c.c(ttVar, i);
        }

        @Override // com.byazt.io.c
        public void a(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.8
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 8);
        }

        @Override // com.byazt.io.c
        public void i(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.2
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(2, true).c(1, function).tt(), null);
                }
            }, 1);
        }

        @Override // com.byazt.io.c
        public void n(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.7
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 7);
        }

        @Override // com.byazt.io.c
        public void sp(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.9
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(2, true).c(1, function).tt(), null);
                }
            }, 5);
        }

        @Override // com.byazt.io.c
        public void tt(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.3
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 6);
        }

        @Override // com.byazt.io.c
        public void uj(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.5
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 1);
        }

        @Override // com.byazt.io.c
        public void ve(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.4
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 9);
        }

        @Override // com.byazt.io.c
        public void x(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.10
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(2, true).c(1, function).tt(), null);
                }
            }, 9);
        }

        @Override // com.byazt.io.c
        public void c(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.1
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(1, function).tt(), null);
                }
            }, 5);
        }

        @Override // com.byazt.io.c
        public void c(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            c(new tt<Loader>() { // from class: com.byazt.bog.c.n.6
                @Override // com.byazt.bog.c.tt
                public void c(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, com.byazt.rl.ve.c(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).c(3, i).c(1, function).tt(), null);
                }
            }, 3);
        }

        @Override // com.byazt.io.c
        public Pair<Integer, String> c(Exception exc) {
            a.uj("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    private void c(AdConfig adConfig, com.byazt.rl.ve veVar) {
        long j;
        Map<String, Object> initExtra;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (adConfig == null || (initExtra = adConfig.getInitExtra()) == null) {
            j = jElapsedRealtime;
        } else {
            Object obj = initExtra.get("csj_b_st_ts");
            long jLongValue = obj instanceof Long ? ((Long) obj).longValue() : jElapsedRealtime;
            Object obj2 = initExtra.get("csj_c_i_ts");
            if (obj2 instanceof Long) {
                jElapsedRealtime = ((Long) obj2).longValue();
            }
            long j2 = jElapsedRealtime;
            jElapsedRealtime = jLongValue;
            j = j2;
        }
        veVar.c(25, jElapsedRealtime);
        veVar.c(24, j);
    }

    public void c(Manager manager, boolean z) {
        a.tt("_tt_ad_sdk_", "update manager");
        ve().c(manager, z);
        ve().register(com.byazt.lm.uj.instance());
    }
}
