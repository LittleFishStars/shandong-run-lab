package com.byazt.db;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.byazt.me.da;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 734, 54})
public class ve extends uj {
    public ve(com.byazt.dv.c cVar) {
        super(cVar);
    }

    private com.byazt.oc.c c() {
        return (com.byazt.oc.c) this.sp;
    }

    @Override // com.byazt.db.uj
    public <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 1008) {
            if (!(this.sp instanceof com.byazt.oc.c)) {
                return null;
            }
            c().tt(null);
            return null;
        }
        if (i != 1009) {
            if (i != 1014) {
                if (i == 1016) {
                    boolean z = this.sp instanceof com.byazt.oc.c;
                } else if (i == 8111) {
                    setCpm(pluginValueSet.doubleValue(8016));
                } else if (i == 8140) {
                    String strStringValue = pluginValueSet.stringValue(8045);
                    String strStringValue2 = pluginValueSet.stringValue(8046);
                    int iIntValue = pluginValueSet.intValue(8047);
                    String strStringValue3 = pluginValueSet.stringValue(8048);
                    String strStringValue4 = pluginValueSet.stringValue(8049);
                    String strStringValue5 = pluginValueSet.stringValue(8050);
                    int iIntValue2 = pluginValueSet.intValue(8051);
                    int iIntValue3 = pluginValueSet.intValue(8052);
                    List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
                    String strStringValue6 = pluginValueSet.stringValue(8054);
                    boolean zBooleanValue = pluginValueSet.booleanValue(8055);
                    String strStringValue7 = pluginValueSet.stringValue(8056);
                    String strStringValue8 = pluginValueSet.stringValue(8057);
                    Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
                    String strStringValue9 = pluginValueSet.stringValue(8058);
                    double dDoubleValue = pluginValueSet.doubleValue(8016);
                    boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
                    int iIntValue4 = pluginValueSet.intValue(8060);
                    String strStringValue10 = pluginValueSet.stringValue(8061);
                    String strStringValue11 = pluginValueSet.stringValue(8061);
                    long jLongValue = pluginValueSet.longValue(8078);
                    String strStringValue12 = pluginValueSet.stringValue(8079);
                    Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
                    String strStringValue13 = pluginValueSet.stringValue(8080);
                    String strStringValue14 = pluginValueSet.stringValue(8081);
                    double dDoubleValue2 = pluginValueSet.doubleValue(8082);
                    int iIntValue5 = pluginValueSet.intValue(8059);
                    String strStringValue15 = pluginValueSet.stringValue(8551);
                    String strStringValue16 = pluginValueSet.stringValue(8559);
                    setTitle(strStringValue);
                    setAdDescription(strStringValue2);
                    setAppSize(iIntValue);
                    setIconUrl(strStringValue3);
                    setSource(strStringValue4);
                    setImageUrl(strStringValue5);
                    setImageHeight(iIntValue2);
                    setImageWidth(iIntValue3);
                    setImages(list);
                    setPackageName(strStringValue6);
                    setIsAppDownload(zBooleanValue);
                    setAppName(strStringValue7);
                    setAuthorName(strStringValue8);
                    if (TextUtils.equals(getAdNetWorkName(), "baidu")) {
                        putExtraMsg(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
                    }
                    setLevelTag(strStringValue9);
                    setCpm(dDoubleValue);
                    setExpressAd(zBooleanValue2);
                    setImageMode(iIntValue4);
                    setInteractionType(iIntValue5);
                    setActionText(strStringValue10);
                    setStore(strStringValue11);
                    setPackageSizeBytes(jLongValue);
                    setPermissionsUrl(strStringValue12);
                    setPermissionsMap(map);
                    setPrivacyAgreement(strStringValue13);
                    setVersionName(strStringValue14);
                    setRating(dDoubleValue2);
                    setFunctionDescUrl(strStringValue15);
                    setRegUrl(strStringValue16);
                } else if (i == 8207) {
                    setLevelTag(pluginValueSet.stringValue(8058));
                }
            } else if (this.sp instanceof com.byazt.oc.c) {
                com.byazt.dv.c cVar = ((uj) this).i;
                if (cVar != null) {
                    com.byazt.bg.c.c(cVar.tt());
                }
                c().c();
            }
        } else if (this.sp instanceof com.byazt.oc.c) {
            c().c((View) null);
            return null;
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public View getAdView() {
        if (((uj) this).x == null) {
            return super.getAdView();
        }
        Object objApply = ((uj) this).x.apply(com.byazt.yxi.uj.c().c(6081).c(View.class).tt());
        if (objApply instanceof View) {
            return (View) objApply;
        }
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
    public boolean hasDislike() {
        try {
            if (((uj) this).x != null) {
                Object objApply = ((uj) this).x.apply(com.byazt.yxi.uj.c().c(8135).c(Boolean.class).tt());
                return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        return uj.isReadyStatus(((uj) this).x);
    }

    @Override // com.byazt.yl.ve
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, da daVar, List<View> list4) {
        if (((uj) this).x != null) {
            ((uj) this).x.apply(com.byazt.yxi.uj.c().c(8159).c(Void.class).c(20033, activity).c(8067, viewGroup).c(8068, list).c(8069, list2).c(8070, list3).c(8071, da.c(daVar)).tt());
        }
    }
}
