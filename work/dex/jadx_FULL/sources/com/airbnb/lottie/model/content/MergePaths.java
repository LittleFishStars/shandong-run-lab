package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.e;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.g25;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MergePaths implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MergePathsMode f23370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f500a;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i != 4) {
                return i != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.f499a = str;
        this.f23370a = mergePathsMode;
        this.f500a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.H()) {
            return new e(this);
        }
        g25.e("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f23370a;
    }

    public String c() {
        return this.f499a;
    }

    public boolean d() {
        return this.f500a;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f23370a + '}';
    }
}
