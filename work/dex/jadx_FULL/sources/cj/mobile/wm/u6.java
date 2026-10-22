package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u6 implements v4<j2, j2> {

    public static class dexa implements y2<j2> {
        public final j2 dexa;

        public dexa(j2 j2Var) {
            this.dexa = j2Var;
        }

        @Override // cj.mobile.wm.y2
        public void a() {
        }

        @Override // cj.mobile.wm.y2
        public void b() {
        }

        @Override // cj.mobile.wm.y2
        /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
        public j2 dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) {
            return this.dexa;
        }

        @Override // cj.mobile.wm.y2
        public String getId() {
            return String.valueOf(this.dexa.dexc());
        }
    }

    @Override // cj.mobile.wm.v4
    public y2<j2> dexa(j2 j2Var, int i, int i2) {
        return new dexa(j2Var);
    }
}
