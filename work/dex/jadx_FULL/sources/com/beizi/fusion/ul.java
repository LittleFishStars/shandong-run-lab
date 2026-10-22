package com.beizi.fusion;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ul {

    public static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ab abVar, ab abVar2) {
            int i = no.i(abVar.b());
            int i2 = no.i(abVar2.b());
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
    }

    public static class b implements Comparator {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RenderModel renderModel, RenderModel renderModel2) {
            if (renderModel.getLayer() < renderModel2.getLayer()) {
                return -1;
            }
            if (renderModel.getLayer() == renderModel2.getLayer()) {
                return no.i(renderModel.getId()) < no.i(renderModel2.getId()) ? -1 : 0;
            }
            return 1;
        }
    }

    public static Comparator a() {
        return new a();
    }

    public static Comparator b() {
        return new b();
    }
}
