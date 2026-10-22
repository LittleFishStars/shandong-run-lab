package com.byazt.nm;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.byazt.nc.yp;
import com.byazt.omf.h;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 15})
public class uj {

    @com.byazt.zqa.c(c = {0, 1, 585, 123})
    public static class c extends com.byazt.yl.ve {
        public yp da;
        public com.byazt.ft.ve i;
        public com.byazt.ft.tt x;

        public c(yp ypVar, boolean z) {
            Map<String, Object> mediaExtraInfo;
            Function function = null;
            this.x = new com.byazt.ft.tt(function) { // from class: com.byazt.nm.uj.c.1
                @Override // com.byazt.ft.tt
                public void c(View view, int i) {
                    if (c.this.f29207a != null) {
                        c.this.f29207a.c(view);
                    }
                }

                @Override // com.byazt.ft.tt
                public void tt(View view, int i) {
                    if (c.this.f29207a != null) {
                        c.this.f29207a.c();
                    }
                }

                @Override // com.byazt.ft.tt
                public void c(View view, String str, int i) {
                    if (c.this.f29207a instanceof com.byazt.fy.uj) {
                        ((com.byazt.fy.uj) c.this.f29207a).c(view, str, i);
                    }
                }

                @Override // com.byazt.ft.tt
                public void c(View view, float f, float f2) {
                    if (c.this.f29207a instanceof com.byazt.fy.uj) {
                        ((com.byazt.fy.uj) c.this.f29207a).c(f, f2);
                    }
                }
            };
            this.i = new com.byazt.ft.ve(function) { // from class: com.byazt.nm.uj.c.2
                @Override // com.byazt.ft.ve
                public void c() {
                    if (c.this.tt != null) {
                        c.this.tt.c();
                    }
                }

                @Override // com.byazt.ft.ve
                public void n() {
                    if (c.this.tt != null) {
                        c.this.tt.n();
                    }
                }

                @Override // com.byazt.ft.ve
                public void tt() {
                    if (c.this.tt != null) {
                        c.this.tt.tt();
                    }
                }

                @Override // com.byazt.ft.ve
                public void uj() {
                    if (c.this.tt != null) {
                        c.this.tt.uj();
                    }
                }

                @Override // com.byazt.ft.ve
                public void ve() {
                    if (c.this.tt != null) {
                        c.this.tt.ve();
                    }
                }

                @Override // com.byazt.ft.ve
                public void c(int i, int i2) {
                    if (c.this.tt != null) {
                        c.this.tt.c(new com.byazt.pp.c(i, "MediaPlayer inter error code:".concat(String.valueOf(i2))));
                    }
                }

                @Override // com.byazt.ft.ve
                public void c(long j, long j2) {
                    if (c.this.tt != null) {
                        c.this.tt.c(j, j2);
                    }
                }
            };
            this.da = ypVar;
            setImageMode(ypVar.getImageMode());
            setInteractionType(this.da.getInteractionType());
            setExpressAd(true);
            if (z && (mediaExtraInfo = ypVar.getMediaExtraInfo()) != null) {
                double dC = com.byazt.xf.tt.c(mediaExtraInfo.get("price"));
                com.byazt.eu.tt.c("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：".concat(String.valueOf(dC)));
                setCpm(dC <= AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : dC);
            }
            this.da.setExpressInteractionListener(this.x);
            this.da.setVideoAdListener(this.i);
            putExtraMsg(MediationConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(MediationConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            Map<String, Object> mediaExtraInfo2 = this.da.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg(mediaExtraInfo2);
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.byazt.yl.ve
        public long getAdId() {
            yp ypVar = this.da;
            if (ypVar != null) {
                return com.byazt.xf.tt.tt(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public View getAdView() {
            yp ypVar = this.da;
            if (ypVar != null) {
                return ypVar.getExpressAdView();
            }
            return null;
        }

        @Override // com.byazt.yl.ve
        public long getCreativeId() {
            yp ypVar = this.da;
            if (ypVar != null) {
                return com.byazt.xf.tt.c(ypVar.getMediaExtraInfo());
            }
            return 0L;
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.sp getDislikeDialog(Activity activity) {
            yp ypVar = this.da;
            return ypVar != null ? ypVar.getDislikeDialog(activity) : super.getDislikeDialog(activity);
        }

        @Override // com.byazt.yl.ve
        public com.byazt.nc.uj getDislikeInfo() {
            yp ypVar = this.da;
            return ypVar != null ? ypVar.getDislikeInfo() : super.getDislikeInfo();
        }

        @Override // com.byazt.yl.ve
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            yp ypVar = this.da;
            if (ypVar == null || (mediaExtraInfo = ypVar.getMediaExtraInfo()) == null) {
                return null;
            }
            setMediaExtraInfo(mediaExtraInfo);
            return super.getMediaExtraInfo();
        }

        @Override // com.byazt.yl.ve
        public String getReqId() {
            yp ypVar = this.da;
            return ypVar != null ? com.byazt.xf.tt.ve(ypVar.getMediaExtraInfo()) : "";
        }

        @Override // com.byazt.yl.ve
        public boolean hasDestroyed() {
            return this.da == null;
        }

        @Override // com.byazt.yl.ve
        public boolean hasDislike() {
            return true;
        }

        @Override // com.byazt.yl.ve
        public void onDestroy() {
            yp ypVar = this.da;
            if (ypVar != null) {
                ypVar.destroy();
                this.da = null;
            }
        }

        @Override // com.byazt.yl.ve
        public void render() {
            yp ypVar = this.da;
            if (ypVar != null) {
                ypVar.render();
            }
        }

        @Override // com.byazt.yl.ve
        public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express: setAdInteractionListener pluginTTAdInteractionListener = ".concat(String.valueOf(ttVar)));
            yp ypVar = this.da;
            if (ypVar != null) {
                ypVar.setAdInteractionListener(ttVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setCanInterruptVideoPlay(boolean z) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express : setCanInterruptVideoPlay b = ".concat(String.valueOf(z)));
            yp ypVar = this.da;
            if (ypVar != null) {
                ypVar.setCanInterruptVideoPlay(z);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express:  activity = " + activity + " pluginDislikeInteractionCallback:" + cVar);
                this.da.setDislikeCallback(activity, cVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express:  ttDislikeDialogAbstract = ".concat(String.valueOf(dialog)));
                this.da.setDislikeDialog(dialog, numArr);
            }
        }

        @Override // com.byazt.yl.ve
        public void setDownloadListener(com.byazt.ocd.ve veVar) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express: setDownloadListener pluginTTAppDownloadListener = ".concat(String.valueOf(veVar)));
            yp ypVar = this.da;
            if (ypVar != null) {
                ypVar.setDownloadListener(veVar);
            }
        }

        @Override // com.byazt.yl.ve
        public void uploadDislikeEvent(String str) {
            if (this.da != null) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "pangle draw express: uploadDislikeEvent event = ".concat(String.valueOf(str)));
                this.da.uploadDislikeEvent(str);
            }
        }
    }

    public void c(final boolean z, h hVar, com.byazt.dj.tt ttVar, final com.byazt.sp.tt ttVar2) {
        if (hVar == null || ttVar2 == null) {
            return;
        }
        hVar.loadExpressDrawFeedAd(ttVar, new com.byazt.nh.a(null) { // from class: com.byazt.nm.uj.1
            @Override // com.byazt.nh.a
            public void c(int i, String str) {
                ttVar2.notifyLoadFail(new com.byazt.pp.c(i, str));
            }

            @Override // com.byazt.nh.a
            public void c(List<yp> list) {
                if (list == null || list.size() == 0) {
                    ttVar2.notifyLoadFail(new com.byazt.pp.c(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但返回广告是空"));
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (yp ypVar : list) {
                    if (ypVar != null) {
                        arrayList.add(new c(ypVar, z));
                    }
                }
                ttVar2.notifyLoadSuccess(arrayList);
            }
        });
    }
}
