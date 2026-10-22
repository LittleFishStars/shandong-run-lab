package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface qe extends ya {

    public enum a implements xa {
        REWARD_CLAIM_EVENT(600, "reward_claim");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27689a;
        private final String b;

        a(int i, String str) {
            this.f27689a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f27689a;
        }
    }

    void g(xa xaVar);
}
