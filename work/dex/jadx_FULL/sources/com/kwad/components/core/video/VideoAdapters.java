package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class VideoAdapters {

    /* JADX INFO: renamed from: com.kwad.components.core.video.VideoAdapters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] anJ;

        static {
            int[] iArr = new int[AdaptType.values().length];
            anJ = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                anJ[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                anJ[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                anJ[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean F(View view) {
            return view.isInLayout() || view.isLayoutRequested();
        }

        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(final View view, View view2, int i, int i2) {
            AdaptType adaptType;
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.d.c.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = dVar2.getRatio() >= 1.0f;
            boolean z2 = dVar.getRatio() >= 1.0f;
            if (z2 && z) {
                adaptType = AdaptType.PORTRAIT_VERTICAL;
            } else if (z2) {
                adaptType = AdaptType.PORTRAIT_HORIZONTAL;
            } else {
                adaptType = z ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            }
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            if (F(view)) {
                view.post(new Runnable() { // from class: com.kwad.components.core.video.VideoAdapters.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setLayoutParams(layoutParams);
                    }
                });
            } else {
                view.setLayoutParams(layoutParams);
            }
        }

        public abstract void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2);
    }

    public static class b extends a {
        private float anM = 0.8f;
        private float anN = 0.9375f;
        private float anO = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float fXO;
            float f;
            float fXP = dVar.xP();
            float fXP2 = dVar2.xP();
            float fXO2 = dVar.xO();
            float fXN = dVar.xN();
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo containerSize: " + fXN + ", " + fXO2);
            int i = AnonymousClass1.anJ[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fXP > fXP2) {
                    float fXN2 = dVar.xN();
                    float f2 = fXN2 / fXP2;
                    float f3 = fXO2 / f2;
                    float f4 = this.anM;
                    if (f3 >= f4) {
                        f = fXN2;
                        fXO = f2;
                    } else {
                        fXO = fXO2 / f4;
                        f = fXO * fXP2;
                    }
                } else {
                    fXO = dVar.xO();
                    f = fXP2 * fXO;
                    float f5 = fXN / f;
                    float f6 = this.anN;
                    if (f5 < f6) {
                        f = fXN / f6;
                        fXO = f / fXP2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = fXO2 * this.anO;
                fXO = f / fXP2;
            } else {
                fXO = -2.1474836E9f;
                f = -2.1474836E9f;
            }
            com.kwad.sdk.core.d.c.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + fXO);
            if (f == -2.1474836E9f || fXO == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = (int) fXO;
                layoutParams.height = (int) f;
            } else {
                layoutParams.height = (int) fXO;
                layoutParams.width = (int) f;
            }
        }
    }

    public static class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        public final void a(@NonNull AdaptType adaptType, @NonNull ViewGroup.LayoutParams layoutParams, @NonNull d dVar, @NonNull d dVar2) {
            float fXN;
            float fXO;
            float fXP = dVar.xP();
            float fXP2 = dVar2.xP();
            int i = AnonymousClass1.anJ[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (fXP >= fXP2) {
                    fXO = dVar.xO();
                    fXN = fXO * fXP2;
                } else {
                    fXN = dVar.xN();
                    fXO = fXN / fXP2;
                }
            } else if (i == 3 || i == 4) {
                fXN = dVar.xO();
                fXO = fXN / fXP2;
            } else {
                fXN = 0.0f;
                fXO = -2.1474836E9f;
            }
            if (fXO == -2.1474836E9f || fXN == -2.1474836E9f) {
                return;
            }
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = (int) fXO;
                layoutParams.height = (int) fXN;
            } else {
                layoutParams.height = (int) fXO;
                layoutParams.width = (int) fXN;
            }
        }
    }

    public static class d {
        float anP;
        float height;
        float width;

        public d(float f, float f2) {
            this.anP = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.anP = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.anP;
        }

        public final float getWidth() {
            return this.width;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.anP + '}';
        }

        public final float xN() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final float xO() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float xP() {
            if (!isValid()) {
                return -1.0f;
            }
            float f = this.height;
            float f2 = this.width;
            return f > f2 ? f / f2 : f2 / f;
        }
    }
}
