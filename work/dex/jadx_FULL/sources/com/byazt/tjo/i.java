package com.byazt.tjo;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.byazt.yf.u;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 42})
public class i extends com.byazt.ch.uj {
    @Override // com.byazt.ch.uj
    public Map<String, Object> getMediationExtraInfo() {
        com.byazt.eu.tt.tt("TMe", "getMediationExtraInfo");
        return com.byazt.yf.da.u();
    }

    @Override // com.byazt.ch.uj
    public void loadDrawToken(Context context, com.byazt.ch.c cVar, final com.byazt.cw.c cVar2, Function<SparseArray<Object>, Object> function) {
        if (context == null || cVar == null) {
            com.byazt.eu.tt.uj("TMe", "参数错误");
            return;
        }
        com.byazt.eu.tt.tt("TMe", "mediationManager loadDrawToken context = " + context + " adSlot = " + cVar + " pluginIMediationDrawAdTokenCallback = " + cVar2 + " classLoader = " + function);
        cVar.c(com.byazt.vxy.c.tt());
        com.byazt.ll.tt ttVarC = com.byazt.zh.c.c(9, cVar, function);
        if (ttVarC != null) {
            final com.byazt.hz.sp spVar = new com.byazt.hz.sp(context);
            spVar.c(ttVarC, new com.byazt.zh.ve() { // from class: com.byazt.tjo.i.3
                @Override // com.byazt.zh.ve
                public void c(String str) {
                    com.byazt.cw.c cVar3 = cVar2;
                    if (cVar3 != null) {
                        cVar3.c(str, new com.byazt.da.uj(spVar));
                    }
                }

                @Override // com.byazt.zh.ve
                public void c(com.byazt.pp.c cVar3) {
                    com.byazt.cw.c cVar4;
                    if (cVar3 == null || (cVar4 = cVar2) == null) {
                        return;
                    }
                    cVar4.c(cVar3.c, cVar3.tt);
                }
            });
        }
    }

    @Override // com.byazt.ch.uj
    public void loadNativeToken(Context context, com.byazt.ch.c cVar, final com.byazt.cw.ve veVar, Function<SparseArray<Object>, Object> function) {
        if (context == null || cVar == null) {
            com.byazt.eu.tt.uj("TMe", "参数错误");
            return;
        }
        com.byazt.eu.tt.tt("TMe", "mediationManager loadNativeToken context = " + context + " adSlot = " + cVar + " pluginIMediationNativeAdTokenCallback = " + veVar + " classLoader = " + function);
        cVar.c(com.byazt.vxy.c.tt());
        com.byazt.ll.tt ttVarC = com.byazt.zh.c.c(5, cVar, function);
        if (ttVarC != null) {
            final com.byazt.hz.i iVar = new com.byazt.hz.i(context);
            iVar.c(ttVarC, new com.byazt.zh.ve() { // from class: com.byazt.tjo.i.2
                @Override // com.byazt.zh.ve
                public void c(String str) {
                    com.byazt.cw.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(str, new com.byazt.zu.c(iVar));
                    }
                }

                @Override // com.byazt.zh.ve
                public void c(com.byazt.pp.c cVar2) {
                    com.byazt.cw.ve veVar2;
                    if (cVar2 == null || (veVar2 = veVar) == null) {
                        return;
                    }
                    veVar2.c(cVar2.c, cVar2.tt);
                }
            });
        }
    }

    @Override // com.byazt.ch.uj
    public Object mtool(int i, PluginValueSet pluginValueSet) {
        String networkSdkVersion;
        String adapterVersion;
        if (i == 8259) {
            return getMediationExtraInfo();
        }
        if (i == 1001) {
            return Boolean.valueOf(com.byazt.yf.da.c());
        }
        if (i == 1002) {
            return Boolean.valueOf(com.byazt.yf.da.c(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1002)));
        }
        if (i == 1003) {
            return Boolean.valueOf(com.byazt.yf.da.tt(pluginValueSet.stringValue(1001), pluginValueSet.stringValue(1003)));
        }
        if (i == 1004) {
            return com.byazt.yf.da.uj();
        }
        if (i == 1005) {
            return com.byazt.yf.da.da();
        }
        if (i == 1006) {
            return com.byazt.yf.da.i();
        }
        if (i == 1007) {
            return com.byazt.yf.da.sl();
        }
        if (i == 1008) {
            com.byazt.yf.da.tt(2);
        } else if (i == 1009) {
            com.byazt.yf.da.t();
        } else {
            if (i == 1010) {
                return Boolean.valueOf(com.byazt.yf.da.uj(pluginValueSet.stringValue(1001)));
            }
            if (i == 1011) {
                String strStringValue = pluginValueSet.stringValue(1001);
                com.byazt.id.c cVarN = com.byazt.yf.da.n(strStringValue);
                com.byazt.ly.uj ujVarA = com.byazt.yf.da.a(strStringValue);
                if (cVarN != null) {
                    networkSdkVersion = cVarN.getNetworkSdkVersion();
                    adapterVersion = cVarN.getAdapterSdkVersion();
                } else if (ujVarA != null) {
                    String networkSdkVersion2 = ujVarA.getNetworkSdkVersion();
                    adapterVersion = ujVarA.getAdapterVersion();
                    networkSdkVersion = networkSdkVersion2;
                } else {
                    networkSdkVersion = "";
                    adapterVersion = "";
                }
                HashMap map = new HashMap(2);
                map.put("networdSdkVersion", networkSdkVersion);
                map.put("adapterSdkVersion", adapterVersion);
                return map;
            }
            if (i == 2001) {
                if (pluginValueSet == null) {
                    return null;
                }
                com.byazt.lx.c.init((Function) pluginValueSet.objectValue(2002, Function.class));
                return com.byazt.lx.c.getInstance();
            }
            if (i == 1012) {
                return Boolean.valueOf(com.byazt.bp.c.t().qy().ve());
            }
        }
        return null;
    }

    @Override // com.byazt.ch.uj
    public void preload(Activity activity, List<com.byazt.ch.n> list, int i, int i2, Function<SparseArray<Object>, Object> function) {
        com.byazt.ll.tt ttVarC;
        com.byazt.eu.tt.tt("TMe", "mediationManager preload activity = " + activity + " list = " + list + " parallelNum = " + i + " requestIntervalS = " + i2 + " classLoader = " + function);
        if (list == null || list.size() == 0) {
            com.byazt.eu.tt.uj("TMe", "参数错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.ch.n nVar : list) {
            if (nVar != null && (ttVarC = com.byazt.zh.c.c(nVar.c(), nVar.c(com.byazt.vxy.c.tt()), function)) != null) {
                arrayList.add(new u(ttVarC, nVar.tt()));
            }
        }
        if (arrayList.size() > 0) {
            com.byazt.yf.da.c(activity, arrayList, i, i2);
        } else {
            com.byazt.eu.tt.uj("TMe", "参数错误");
        }
    }

    @Override // com.byazt.ch.uj
    public void requestPermissionIfNecessary(Context context) {
        com.byazt.eu.tt.tt("TMe", "mediationManager requestPermissionIfNecessary context = ".concat(String.valueOf(context)));
        com.byazt.yf.da.c(context);
    }

    @Override // com.byazt.ch.uj
    public void setPulisherDid(String str) {
        com.byazt.eu.tt.tt("TMe", "mediationManager setPulisherDid configUserInfoForSegment = ".concat(String.valueOf(str)));
        com.byazt.yf.da.c(str);
    }

    @Override // com.byazt.ch.uj
    public void setThemeStatus(int i) {
        com.byazt.eu.tt.tt("TMe", "mediationManager setThemeStatus themeStatus = ".concat(String.valueOf(i)));
        com.byazt.yf.da.c(i);
    }

    @Override // com.byazt.ch.uj
    public void setUserInfoForSegment(com.byazt.je.ve veVar) {
        com.byazt.yf.da.c(ve.c(veVar));
    }

    @Override // com.byazt.ch.uj
    public int showOpenOrInstallAppDialog(final com.byazt.cw.uj ujVar) {
        com.byazt.eu.tt.tt("TMe", "mediationManager showOpenOrInstallAppDialog");
        return com.byazt.yf.da.c(new com.byazt.yf.ve() { // from class: com.byazt.tjo.i.1
            @Override // com.byazt.yf.ve
            public void c(int i) {
                com.byazt.cw.uj ujVar2 = ujVar;
                if (ujVar2 != null) {
                    ujVar2.c(i);
                }
            }
        });
    }

    @Override // com.byazt.ch.uj
    public void updateLocalExtra(Map<String, Object> map) {
        com.byazt.eu.tt.tt("TMe", "mediationManager updateLocalExtra map = ".concat(String.valueOf(map)) == null ? "null" : map.toString());
        com.byazt.bp.c.t().tt(map);
    }

    @Override // com.byazt.ch.uj
    public void updatePrivacyConfig(com.byazt.dj.uj ujVar) {
        com.byazt.eu.tt.tt("TMe", "mediationManager updatePrivacyConfig customController = ".concat(String.valueOf(ujVar)));
        com.byazt.yf.da.c(ujVar);
    }

    @Override // com.byazt.ch.uj
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        com.byazt.eu.tt.tt("TMe", "mediationManager requestPermissionIfNecessary context = " + context + " permissions = " + iArr);
        com.byazt.yf.da.c(context, iArr);
    }
}
