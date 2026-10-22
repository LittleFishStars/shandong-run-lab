package com.getui.gtc.f;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class e {
    public com.getui.gtc.dyc.b.c c = new com.getui.gtc.dyc.b.d() { // from class: com.getui.gtc.f.e.1
        @Override // com.getui.gtc.dyc.b.d
        public final void a(Exception exc) {
            e.this.a(exc);
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void a(Map map, Map map2) {
            e.this.a(map, map2);
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void b(String str) {
            e.this.a(str);
        }
    };

    public void a(Exception exc) {
    }

    public abstract void a(String str);

    public abstract void a(Map<String, String> map, Map<String, String> map2);
}
