package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface fe extends ya {

    public enum a implements xa {
        SINGLE_VIEW_RENDERED(33, "single_render"),
        RENDER_SUCCESS(34, "render_success"),
        RENDER_FAILED(35, "render_failed");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27294a;
        private final String b;

        a(int i, String str) {
            this.f27294a = i;
            this.b = str;
        }

        @Override // com.beizi.fusion.xa
        public int getEventCode() {
            return this.f27294a;
        }
    }

    void a();

    void a(ab abVar);

    void f();
}
