package com.byazt.db;

import android.app.Activity;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 734, 46})
public class n extends uj {
    public n(com.byazt.dv.c cVar) {
        super(cVar);
    }

    private com.byazt.ln.c c() {
        return (com.byazt.ln.c) this.sp;
    }

    @Override // com.byazt.yl.ve
    public boolean adnHasAdVideoCachedApi() {
        if (((uj) this).x == null) {
            return super.adnHasAdVideoCachedApi();
        }
        Object objApply = ((uj) this).x.apply(com.byazt.yxi.uj.c().c(8211).c(Boolean.class).tt());
        return objApply instanceof Boolean ? ((Boolean) objApply).booleanValue() : super.adnHasAdVideoCachedApi();
    }

    @Override // com.byazt.db.uj
    public <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(getCpm());
        }
        if (i == 8111) {
            if (pluginValueSet == null) {
                return null;
            }
            if (!isClientBidding() && !isMultiBiddingAd()) {
                return null;
            }
            setCpm(pluginValueSet.doubleValue(8016));
            return null;
        }
        int iIntValue = 0;
        if (i == 8129) {
            if (pluginValueSet == null) {
                return null;
            }
            setExpressAd(Boolean.valueOf(pluginValueSet.booleanValue(8033, false)).booleanValue());
            return null;
        }
        if (i == 1008) {
            if (c() == null) {
                return null;
            }
            c().c();
            return null;
        }
        if (i == 1017) {
            if (c() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            c().c(new com.byazt.pp.c(iIntValue, strStringValue));
            return null;
        }
        if (i == 1009) {
            if (c() == null) {
                return null;
            }
            c().g_();
            return null;
        }
        if (i == 1014) {
            if (c() == null) {
                return null;
            }
            c().h_();
            return null;
        }
        if (i == 1026) {
            if (c() == null) {
                return null;
            }
            c().uj();
            return null;
        }
        if (i == 1021) {
            if (c() == null) {
                return null;
            }
            c().n();
            return null;
        }
        if (i == 1037) {
            if (c() == null) {
                return null;
            }
            c().a();
            return null;
        }
        if (i != 1018 || c() == null) {
            return null;
        }
        final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
        final float fIntValue = pluginValueSet.intValue(8018);
        final String strStringValue2 = pluginValueSet.stringValue(UIMsg.m_AppUI.MSG_FAV_BUS_OLD);
        c().c(new com.byazt.bo.c() { // from class: com.byazt.db.n.1
            @Override // com.byazt.bo.c
            public boolean c() {
                return zBooleanValue;
            }

            @Override // com.byazt.bo.c
            public float tt() {
                return fIntValue;
            }

            @Override // com.byazt.bo.c
            public Map<String, Object> uj() {
                return null;
            }

            @Override // com.byazt.bo.c
            public String ve() {
                return strStringValue2;
            }
        });
        return null;
    }

    @Override // com.byazt.yl.ve
    public String getReqId() {
        if (((uj) this).x == null) {
            return super.getReqId();
        }
        Object objApply = ((uj) this).x.apply(com.byazt.yxi.uj.c().c(8147).c(String.class).tt());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        return uj.isReadyStatus(((uj) this).x);
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        super.showAd(activity, obj, str);
        if (((uj) this).x != null) {
            ((uj) this).x.apply(com.byazt.yxi.uj.c().c(8113).c(Void.class).c(20033, activity).tt());
        }
    }
}
