package com.byazt.fk;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 71})
public class x implements sp.c, Function {
    public volatile Function c;
    public volatile sp.c tt;

    public x(sp.c cVar) {
        this.tt = cVar;
    }

    public x(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object iVar = sparseArray.get(1);
                if (iVar != null) {
                    iVar = new i((Function) iVar);
                }
                this.tt.onCompletion((sp) iVar);
                break;
            case 2:
                Object iVar2 = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (iVar2 != null) {
                    iVar2 = new i((Function) iVar2);
                }
                this.tt.onRenderStart((sp) iVar2, ((Long) obj2).longValue());
                break;
            case 3:
                Object iVar3 = sparseArray.get(1);
                if (iVar3 != null) {
                    iVar3 = new i((Function) iVar3);
                }
                this.tt.onPrepared((sp) iVar3);
                break;
            case 4:
                Object iVar4 = sparseArray.get(1);
                Object ujVar = sparseArray.get(2);
                if (iVar4 != null) {
                    iVar4 = new i((Function) iVar4);
                }
                if (ujVar != null) {
                    ujVar = new uj((Function) ujVar);
                }
                this.tt.onError((sp) iVar4, (ve) ujVar);
                break;
            case 5:
                Object iVar5 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                if (iVar5 != null) {
                    iVar5 = new i((Function) iVar5);
                }
                this.tt.onSeekCompletion((sp) iVar5, ((Boolean) obj3).booleanValue());
                break;
            case 6:
                Object iVar6 = sparseArray.get(1);
                if (iVar6 != null) {
                    iVar6 = new i((Function) iVar6);
                }
                this.tt.onRelease((sp) iVar6);
                break;
            case 7:
                Object iVar7 = sparseArray.get(1);
                Object obj4 = sparseArray.get(2);
                Object obj5 = sparseArray.get(3);
                if (iVar7 != null) {
                    iVar7 = new i((Function) iVar7);
                }
                this.tt.onVideoSizeChanged((sp) iVar7, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                break;
            case 8:
                Object iVar8 = sparseArray.get(1);
                Object obj6 = sparseArray.get(2);
                Object obj7 = sparseArray.get(3);
                Object obj8 = sparseArray.get(4);
                if (iVar8 != null) {
                    iVar8 = new i((Function) iVar8);
                }
                this.tt.onBufferStart((sp) iVar8, ((Integer) obj6).intValue(), ((Integer) obj7).intValue(), ((Integer) obj8).intValue());
                break;
            case 9:
                Object iVar9 = sparseArray.get(1);
                Object obj9 = sparseArray.get(2);
                if (iVar9 != null) {
                    iVar9 = new i((Function) iVar9);
                }
                this.tt.onBufferEnd((sp) iVar9, ((Integer) obj9).intValue());
                break;
            case 10:
                Object iVar10 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                if (iVar10 != null) {
                    iVar10 = new i((Function) iVar10);
                }
                this.tt.onBufferingUpdate((sp) iVar10, ((Integer) obj10).intValue());
                break;
            case 11:
                Object iVar11 = sparseArray.get(1);
                Object obj11 = sparseArray.get(2);
                Object obj12 = sparseArray.get(3);
                if (iVar11 != null) {
                    iVar11 = new i((Function) iVar11);
                }
                this.tt.onPlayPositionUpdate((sp) iVar11, ((Long) obj11).longValue(), ((Long) obj12).longValue());
                break;
            case 12:
                Object iVar12 = sparseArray.get(1);
                Object obj13 = sparseArray.get(2);
                Object obj14 = sparseArray.get(3);
                if (iVar12 != null) {
                    iVar12 = new i((Function) iVar12);
                }
                this.tt.onMonitorLog((sp) iVar12, (JSONObject) obj13, (String) obj14);
                break;
            case 13:
                Object iVar13 = sparseArray.get(1);
                if (iVar13 != null) {
                    iVar13 = new i((Function) iVar13);
                }
                this.tt.onPause((sp) iVar13);
                break;
            case 14:
                Object iVar14 = sparseArray.get(1);
                if (iVar14 != null) {
                    iVar14 = new i((Function) iVar14);
                }
                this.tt.onResume((sp) iVar14);
                break;
            case 15:
                Object iVar15 = sparseArray.get(1);
                if (iVar15 != null) {
                    iVar15 = new i((Function) iVar15);
                }
                this.tt.onStart((sp) iVar15);
                break;
        }
        return null;
    }

    @Override // com.byazt.fk.sp.c
    public void onBufferEnd(sp spVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onBufferStart(sp spVar, int i, int i2, int i3) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, Integer.valueOf(i3));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onBufferingUpdate(sp spVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onCompletion(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onError(sp spVar, ve veVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        if (veVar != null) {
            veVar = new uj(veVar);
        }
        sparseArray.put(2, veVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onMonitorLog(sp spVar, JSONObject jSONObject, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onPause(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onPlayPositionUpdate(sp spVar, long j, long j2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Long.valueOf(j2));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onPrepared(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onRelease(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onRenderStart(sp spVar, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Long.valueOf(j));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onResume(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onSeekCompletion(sp spVar, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onStart(sp spVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp.c
    public void onVideoSizeChanged(sp spVar, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        if (spVar != null) {
            spVar = new i(spVar);
        }
        sparseArray.put(1, spVar);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        this.c.apply(sparseArray);
    }
}
