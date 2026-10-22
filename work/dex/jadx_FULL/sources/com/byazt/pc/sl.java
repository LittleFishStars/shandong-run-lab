package com.byazt.pc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 695, 158})
public class sl extends c {
    @Override // com.byazt.pc.i
    public String c() {
        return "net_request";
    }

    @Override // com.byazt.pc.i
    public void c(final com.byazt.oz.ve veVar) {
        final com.byazt.oz.a aVarU = veVar.u();
        com.byazt.yj.n nVarUj = aVarU.uj();
        veVar.c(false);
        try {
            com.byazt.yj.sp spVarCall = nVarUj.call(new com.byazt.rc.ve(veVar.getUrl(), veVar.a(), veVar.sp(), veVar.m()));
            int iTt = spVarCall.tt();
            veVar.c(spVarCall.c());
            if (spVarCall.tt() != 200) {
                aVarU.x();
                String.valueOf(spVarCall);
                Object objVe = spVarCall.ve();
                c(iTt, spVarCall.uj(), objVe instanceof Throwable ? (Throwable) objVe : null, veVar);
                return;
            }
            final byte[] bArr = (byte[]) spVarCall.ve();
            veVar.c(new tt(bArr, spVarCall));
            final String rawCacheKey = veVar.getRawCacheKey();
            final com.byazt.yj.tt ttVarYp = veVar.yp();
            if (ttVarYp.isRawMemoryCache()) {
                aVarU.tt(veVar.yp()).c(rawCacheKey, bArr);
            }
            aVarU.a().submit(new Runnable() { // from class: com.byazt.pc.sl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ttVarYp.isDiskCache()) {
                        aVarU.ve(veVar.yp()).c(rawCacheKey, bArr);
                    }
                }
            });
        } catch (Throwable th) {
            c(1004, "net request failed!", th, veVar);
        }
    }

    private void c(int i, String str, Throwable th, com.byazt.oz.ve veVar) {
        veVar.c(new x(i, str, th));
    }
}
