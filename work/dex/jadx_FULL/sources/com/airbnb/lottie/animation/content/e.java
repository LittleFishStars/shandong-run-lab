package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(19)
public class e implements PathContent, GreedyContent {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MergePaths f417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f418a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f23336a = new Path();
    public final Path b = new Path();
    public final Path c = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<PathContent> f419a = new ArrayList();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23337a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f23337a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23337a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23337a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23337a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23337a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public e(MergePaths mergePaths) {
        this.f418a = mergePaths.c();
        this.f417a = mergePaths;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.f419a.size(); i++) {
            this.f419a.get(i).c(list, list2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void e(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content contentPrevious = listIterator.previous();
            if (contentPrevious instanceof PathContent) {
                this.f419a.add((PathContent) contentPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        this.c.reset();
        if (this.f417a.d()) {
            return this.c;
        }
        int i = a.f23337a[this.f417a.b().ordinal()];
        if (i == 1) {
            g();
        } else if (i == 2) {
            h(Path.Op.UNION);
        } else if (i == 3) {
            h(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            h(Path.Op.INTERSECT);
        } else if (i == 5) {
            h(Path.Op.XOR);
        }
        return this.c;
    }

    public final void g() {
        for (int i = 0; i < this.f419a.size(); i++) {
            this.c.addPath(this.f419a.get(i).f());
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f418a;
    }

    @TargetApi(19)
    public final void h(Path.Op op) {
        this.b.reset();
        this.f23336a.reset();
        for (int size = this.f419a.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.f419a.get(size);
            if (pathContent instanceof com.airbnb.lottie.animation.content.a) {
                com.airbnb.lottie.animation.content.a aVar = (com.airbnb.lottie.animation.content.a) pathContent;
                List<PathContent> listK = aVar.k();
                for (int size2 = listK.size() - 1; size2 >= 0; size2--) {
                    Path pathF = listK.get(size2).f();
                    pathF.transform(aVar.l());
                    this.b.addPath(pathF);
                }
            } else {
                this.b.addPath(pathContent.f());
            }
        }
        PathContent pathContent2 = this.f419a.get(0);
        if (pathContent2 instanceof com.airbnb.lottie.animation.content.a) {
            com.airbnb.lottie.animation.content.a aVar2 = (com.airbnb.lottie.animation.content.a) pathContent2;
            List<PathContent> listK2 = aVar2.k();
            for (int i = 0; i < listK2.size(); i++) {
                Path pathF2 = listK2.get(i).f();
                pathF2.transform(aVar2.l());
                this.f23336a.addPath(pathF2);
            }
        } else {
            this.f23336a.set(pathContent2.f());
        }
        this.c.op(this.f23336a, this.b, op);
    }
}
