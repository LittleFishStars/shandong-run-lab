package com.byazt.io;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.rl.ve;
import com.byazt.sh.a;
import com.byazt.sh.n;
import com.byazt.sh.uj;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1422, 20})
public abstract class c {

    /* JADX INFO: renamed from: com.byazt.io.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1422, 44})
    public static class C0438c implements TTAdNative {
        public final c c;

        public C0438c(c cVar) {
            this.c = cVar;
        }

        private ValueSet c(AdSlot adSlot) {
            ve veVarC = ve.c(com.byazt.fqu.tt.c(adSlot));
            veVarC.c(8302, MediationAdClassLoader.getInstance());
            return veVarC.tt();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.c.i(c(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    nativeExpressAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.c.ve(c(adSlot), new com.byazt.sh.c(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    drawFeedAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.c.x(c(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    nativeExpressAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.c.c(c(adSlot), new com.byazt.sh.tt(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    feedAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.c.a(c(adSlot), new com.byazt.sh.ve(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    fullScreenVideoAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.c.uj(c(adSlot), new uj(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    nativeAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.c.sp(c(adSlot), new n(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    nativeExpressAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.c.n(c(adSlot), new a(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    rewardVideoAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.c.c(c(adSlot), new tt(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairC = this.c.c(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.byazt.io.c.c.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairC.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairC.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.c.tt(c(adSlot), new com.byazt.sh.tt(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairC = this.c.c(e);
                    feedAdListener.onError(((Integer) pairC.first).intValue(), (String) pairC.second);
                }
            }
        }
    }

    public abstract void a(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> c(Exception exc);

    public TTAdNative c() {
        return new C0438c(this);
    }

    public abstract void c(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void c(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void i(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void n(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void sp(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void tt(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void uj(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void ve(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void x(ValueSet valueSet, Function<SparseArray<Object>, Object> function);
}
