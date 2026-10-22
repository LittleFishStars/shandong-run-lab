package com.igexin.push.core.d;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class g {
    com.getui.gtc.dyc.b.c b = new com.getui.gtc.dyc.b.c() { // from class: com.igexin.push.core.d.g.1
        @Override // com.getui.gtc.dyc.b.c
        public final void a(Map map, Map map2) {
            g.this.a((Map<String, String>) map2);
        }

        @Override // com.getui.gtc.dyc.b.c
        public final void b(String str) {
            g.this.a(str);
        }
    };

    private com.getui.gtc.dyc.b.c a() {
        return this.b;
    }

    public abstract void a(String str);

    public abstract void a(Map<String, String> map);
}
