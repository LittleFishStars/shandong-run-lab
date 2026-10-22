package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 9})
public class aw extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.omf.d c;

    public aw(com.byazt.omf.d dVar) {
        this.c = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("sendMaterialMeta", (com.byazt.pct.n<?, ?>) new aw(dVar));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        boolean zTt;
        com.byazt.ete.ic icVarC = com.byazt.omf.c.c(jSONObject.optJSONObject("creative"));
        com.byazt.omf.d dVar = this.c;
        if (dVar != null && icVarC != null) {
            dVar.ve(icVarC);
        }
        com.byazt.omf.d dVar2 = this.c;
        if (dVar2 != null) {
            zTt = dVar2.tt(icVarC);
            if (icVarC != null && icVarC.i() == 4) {
                final String strUj = icVarC.uj();
                if (this.c.sp(strUj) == null) {
                    com.byazt.wz.c cVarC = com.byazt.yih.x.c(com.byazt.omf.gt.getContext(), icVarC, this.c.md());
                    cVarC.c(new com.byazt.pop.c() { // from class: com.byazt.qx.aw.1
                        @Override // com.byazt.pop.c
                        public void c() {
                            com.byazt.nt.c.c(strUj);
                        }

                        @Override // com.byazt.pop.c
                        public void tt(long j, long j2, String str, String str2) {
                            com.byazt.nt.c.tt(strUj, j, j2);
                        }

                        @Override // com.byazt.pop.c
                        public void ve(long j, long j2, String str, String str2) {
                            com.byazt.nt.c.ve(strUj, j, j2);
                        }

                        @Override // com.byazt.pop.c
                        public void c(long j, long j2, String str, String str2) {
                            com.byazt.nt.c.c(strUj, j, j2);
                        }

                        @Override // com.byazt.pop.c
                        public void c(long j, String str, String str2) {
                            com.byazt.nt.c.tt(strUj);
                        }

                        @Override // com.byazt.pop.c
                        public void c(String str, String str2) {
                            com.byazt.nt.c.ve(strUj);
                        }
                    });
                    this.c.c(strUj, cVarC);
                }
            }
        } else {
            zTt = false;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (zTt) {
            jSONObject2.put("code", 0);
            jSONObject2.put("msg", "success");
        } else {
            jSONObject2.put("code", 11);
            jSONObject2.put("msg", "show 7 factors failed");
        }
        return jSONObject2;
    }
}
