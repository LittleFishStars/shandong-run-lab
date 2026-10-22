package com.byazt.sp;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.db.a;
import com.byazt.db.i;
import com.byazt.db.n;
import com.byazt.db.sp;
import com.byazt.db.x;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 91, 20})
public class c implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ll.tt f29028a;
    public ve c;
    public com.byazt.dv.tt n;
    public da sp;
    public int tt;
    public Function<SparseArray<Object>, Object> uj;
    public int ve;

    public c(com.byazt.ll.tt ttVar, com.byazt.dv.tt ttVar2, ve veVar) {
        this.tt = ttVar.my();
        this.f29028a = ttVar;
        this.ve = ttVar2.z();
        this.n = ttVar2;
        this.c = veVar;
        this.sp = ttVar2.x();
    }

    private com.byazt.yl.ve c() {
        switch (this.tt) {
            case 1:
                return new com.byazt.db.ve(this.n);
            case 2:
                return new a(this.n);
            case 3:
                return new i(this.n);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                int i = this.ve;
                if (i == 4) {
                    return new sp(this.n, this.c);
                }
                if (i == 3) {
                    return new com.byazt.db.ve(this.n);
                }
                return i == 5 ? new sp(this.n, this.c) : new sp(this.n, this.c);
            case 7:
                int i2 = this.ve;
                if (i2 == 6) {
                    return new x(this.n);
                }
                if (i2 == 7) {
                    return new n(this.n);
                }
                return i2 == 8 ? new a(this.n) : new x(this.n);
            case 8:
                return new n(this.n);
            case 9:
                return new sp(this.n, this.c);
            case 10:
                int i3 = this.ve;
                if (i3 == 1) {
                    return new a(this.n);
                }
                if (i3 == 2) {
                    return new n(this.n);
                }
                return null;
        }
    }

    public String getBiddingToken(Context context, String str, Object obj) {
        if (this.uj != null) {
            Object objApply = this.uj.apply(com.byazt.yxi.uj.c().c(8139).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp, str).c(8044, obj).c(String.class).tt());
            if (objApply instanceof String) {
                return objApply.toString();
            }
        }
        return null;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        int iIntValue = pluginValueSetTt.intValue(-99999987);
        Class cls = (Class) pluginValueSetTt.objectValue(-99999985, Class.class);
        if (iIntValue == 8108) {
            this.c.notifyLoadFail(new com.byazt.pp.c(pluginValueSetTt.intValue(8014), pluginValueSetTt.stringValue(8015)));
        } else if (iIntValue == 8112) {
            Function function = (Function) pluginValueSetTt.objectValue(8303, Function.class);
            int iIntValue2 = pluginValueSetTt.intValue(8014);
            String strStringValue = pluginValueSetTt.stringValue(8015);
            ArrayList arrayList = new ArrayList(1);
            if (function instanceof com.byazt.yl.ve) {
                arrayList.add((com.byazt.yl.ve) function);
            } else if (function instanceof Function) {
                Object objApply = function.apply(com.byazt.yxi.uj.c().c(-99999977).tt());
                if (objApply instanceof com.byazt.yl.ve) {
                    arrayList.add((com.byazt.yl.ve) objApply);
                }
            }
            this.c.notifyVideoCache(arrayList, new com.byazt.pp.c(iIntValue2, strStringValue));
        } else if (iIntValue == 8107) {
            List list = (List) pluginValueSetTt.objectValue(8303, List.class);
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof com.byazt.yl.ve) {
                        arrayList2.add((com.byazt.yl.ve) obj);
                    } else if (obj instanceof Function) {
                        Object objApply2 = ((Function) obj).apply(com.byazt.yxi.uj.c().c(-99999977).tt());
                        if (objApply2 instanceof com.byazt.yl.ve) {
                            arrayList2.add((com.byazt.yl.ve) objApply2);
                        }
                    }
                }
            }
            this.c.notifyLoadSuccess(arrayList2);
        } else {
            if (iIntValue == 8127) {
                return c();
            }
            if (iIntValue == 8110) {
                return Boolean.valueOf(this.n.c());
            }
            if (iIntValue == 8136) {
                return Boolean.valueOf(this.n.gu());
            }
            if (iIntValue == 8141) {
                return Boolean.valueOf(this.n.gr());
            }
            if (iIntValue == 8137) {
                return this.n.zm();
            }
            if (iIntValue == 8226) {
                return Integer.valueOf(this.n.my());
            }
            if (iIntValue == 8138) {
                this.uj = (Function) pluginValueSetTt.objectValue(8043, Function.class);
            } else if (iIntValue == 8210) {
                return Boolean.valueOf(this.c.hasNotifyFail());
            }
        }
        return com.byazt.hf.c.c(cls);
    }
}
