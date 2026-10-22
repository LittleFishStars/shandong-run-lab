package com.byazt.zwg;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.byazt.bz.uj;
import com.byazt.hz.t;
import com.byazt.nc.z;
import com.byazt.sbm.a;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1061, 20})
public class c extends z {
    public t c;
    public com.byazt.tn.c tt;

    public c(t tVar) {
        this.c = tVar;
        c();
    }

    @Override // com.byazt.nc.z
    public long getExpirationTimestamp() {
        return Long.MAX_VALUE;
    }

    @Override // com.byazt.nc.z
    public int getInteractionType() {
        t tVar = this.c;
        if (tVar != null) {
            return tVar.m();
        }
        return -1;
    }

    @Override // com.byazt.nc.z
    public Map<String, Object> getMediaExtraInfo() {
        t tVar = this.c;
        if (tVar != null) {
            return tVar.nu();
        }
        return null;
    }

    @Override // com.byazt.nc.z
    public a getMediationManager() {
        return new com.byazt.bz.c(new tt(this.c));
    }

    @Override // com.byazt.nc.z
    public int getRewardVideoAdType() {
        return 0;
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c(ttVar);
        }
    }

    @Override // com.byazt.nc.z
    public void setDownloadListener(final com.byazt.ocd.ve veVar) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c(new com.byazt.zh.tt() { // from class: com.byazt.zwg.c.2
                @Override // com.byazt.zh.tt
                public void c() {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c();
                    }
                }

                @Override // com.byazt.zh.tt
                public void tt() {
                }

                @Override // com.byazt.zh.tt
                public void tt(long j, long j2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.ve(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, int i, int i2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, long j2, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.tt(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(long j, @Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, str, str2);
                    }
                }

                @Override // com.byazt.zh.tt
                public void c(@Nullable String str, @Nullable String str2) {
                    com.byazt.ocd.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.z
    public void setRewardAdInteractionListener(com.byazt.tn.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.nc.z
    public void setRewardPlayAgainController(com.byazt.tn.tt ttVar) {
    }

    @Override // com.byazt.nc.z
    public void setRewardPlayAgainInteractionListener(com.byazt.tn.c cVar) {
    }

    @Override // com.byazt.nc.z
    public void showRewardVideoAd(Activity activity) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c(activity);
        }
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }

    private void c() {
        t tVar = this.c;
        if (tVar == null) {
            return;
        }
        tVar.c(new com.byazt.uhf.c() { // from class: com.byazt.zwg.c.1
            @Override // com.byazt.uhf.c
            public void a() {
                if (c.this.tt != null) {
                    c.this.tt.n();
                }
            }

            @Override // com.byazt.uhf.c
            public void c() {
                if (c.this.tt != null) {
                    c.this.tt.c(null);
                }
            }

            @Override // com.byazt.uhf.c
            public void c(com.byazt.pp.c cVar) {
            }

            @Override // com.byazt.uhf.c
            public void i_() {
                if (c.this.tt != null) {
                    c.this.tt.c();
                }
            }

            @Override // com.byazt.uhf.c
            public void j_() {
                if (c.this.tt != null) {
                    c.this.tt.tt();
                }
            }

            @Override // com.byazt.uhf.c
            public void n() {
                if (c.this.tt != null) {
                    c.this.tt.uj();
                }
            }

            @Override // com.byazt.uhf.c
            public void uj() {
                if (c.this.tt != null) {
                    c.this.tt.ve();
                }
            }

            @Override // com.byazt.uhf.c
            public void c(com.byazt.bo.c cVar) {
                c cVar2 = c.this;
                cVar2.c(cVar, cVar2.tt, "CSJMRewardAd normal");
            }
        });
    }

    @Override // com.byazt.nc.z
    public void showRewardVideoAd(Activity activity, Object obj, String str) {
        t tVar = this.c;
        if (tVar != null) {
            tVar.c(activity, obj, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.bo.c cVar, com.byazt.tn.c cVar2, String str) {
        Bundle bundle;
        String str2;
        uj.c(cVar, str);
        if (cVar2 == null || cVar == null) {
            return;
        }
        boolean zC = cVar.c();
        float fTt = cVar.tt();
        String strVe = cVar.ve();
        Map<String, Object> mapUj = cVar.uj();
        if (mapUj == null) {
            mapUj = new HashMap<>();
        }
        Object obj = mapUj.get(MediationConstant.KEY_REWARD_TYPE);
        int iIntValue = 0;
        int iIntValue2 = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        Object obj2 = mapUj.get(MediationConstant.KEY_EXTRA_INFO);
        if (obj2 instanceof Bundle) {
            bundle = (Bundle) obj2;
        } else {
            bundle = new Bundle();
        }
        bundle.putString("reward_extra_key_reward_name", strVe);
        bundle.putFloat("reward_extra_key_reward_amount", fTt);
        Object obj3 = mapUj.get(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY);
        if (obj3 instanceof Boolean) {
            bundle.putBoolean(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, ((Boolean) obj3).booleanValue());
        }
        Object obj4 = mapUj.get("transId");
        if (obj4 instanceof String) {
            bundle.putString("transId", (String) obj4);
        }
        Object obj5 = mapUj.get(MediationConstant.KEY_REASON);
        if (obj5 instanceof Integer) {
            bundle.putInt(MediationConstant.KEY_REASON, ((Integer) obj5).intValue());
        }
        Object obj6 = mapUj.get("gromoreExtra");
        if (obj6 instanceof String) {
            bundle.putString("gromoreExtra", (String) obj6);
        }
        Object obj7 = mapUj.get("errorCode");
        if (obj7 instanceof Integer) {
            Integer num = (Integer) obj7;
            iIntValue = num.intValue();
            bundle.putInt("errorCode", num.intValue());
        }
        Object obj8 = mapUj.get("errorMsg");
        if (obj8 instanceof String) {
            String str3 = (String) obj8;
            bundle.putString("errorMsg", str3);
            str2 = str3;
        } else {
            str2 = "";
        }
        Object obj9 = mapUj.get(MediationConstant.KEY_ADN_NAME);
        if (obj9 instanceof String) {
            bundle.putString(MediationConstant.KEY_ADN_NAME, (String) obj9);
        }
        Object obj10 = mapUj.get("ecpm");
        if (obj10 instanceof String) {
            bundle.putString("ecpm", (String) obj10);
        }
        Object obj11 = mapUj.get(MediationConstant.BAIDU_REWARD_TYPE);
        if (obj11 instanceof Integer) {
            bundle.putInt(MediationConstant.BAIDU_REWARD_TYPE, ((Integer) obj11).intValue());
        }
        cVar2.c(zC, iIntValue2, bundle);
        if (com.byazt.xf.tt.c("6.4.0.0")) {
            cVar2.c(zC, (int) fTt, strVe != null ? strVe : "", iIntValue, str2);
        }
    }
}
