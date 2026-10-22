package com.ipd.dsp.internal.v1;

import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends com.ipd.dsp.internal.v1.a {

    /* JADX INFO: renamed from: com.ipd.dsp.internal.v1.b$b, reason: collision with other inner class name */
    public static class C0923b extends com.ipd.dsp.internal.v1.a.d<Integer> {
        public static final long f = 2500;
        public com.ipd.dsp.internal.v1.a b;
        public Random c;
        public ArrayList<C0924b> d;
        public volatile boolean e;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.v1.b$b$a */
        public class a extends Animation {
            public final PathMeasure f;
            public final float[] g = new float[2];
            public final float[] h = new float[2];
            public final /* synthetic */ Path i;
            public final /* synthetic */ View j;
            public final /* synthetic */ float k;

            public a(Path path, View view, float f) {
                this.i = path;
                this.j = view;
                this.k = f;
                this.f = new PathMeasure(path, false);
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                PathMeasure pathMeasure = this.f;
                pathMeasure.getPosTan(pathMeasure.getLength() * f, this.g, this.h);
                View view = this.j;
                view.setX(this.g[0] - (view.getMeasuredWidth() / 2.0f));
                this.j.setY(this.g[1]);
                this.j.setRotation(this.k * f);
            }
        }

        /* JADX INFO: renamed from: com.ipd.dsp.internal.v1.b$b$b, reason: collision with other inner class name */
        public static class C0924b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f38579a;
            public final float b;

            public C0924b(float f, float f2) {
                this.f38579a = f;
                this.b = f2;
            }

            public final float a() {
                return this.b - this.f38579a;
            }
        }

        @Override // com.ipd.dsp.internal.v1.a.d
        public View a(Context context) {
            ImageView imageView = new ImageView(context);
            int iA = (int) s.a(context, 80.0f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(iA, iA * 2));
            imageView.setRotation(b());
            return imageView;
        }

        public final int b() {
            int iNextInt = this.c.nextInt(5);
            if (iNextInt == 1) {
                return 30;
            }
            if (iNextInt == 2) {
                return 0;
            }
            if (iNextInt != 3) {
                return iNextInt != 4 ? 45 : -45;
            }
            return -30;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public C0923b(com.ipd.dsp.internal.v1.a aVar) {
            this.d = new ArrayList<>();
            this.b = aVar;
            this.c = new Random();
            this.f38578a = new ArrayList();
            for (int i = 0; i < 30; i++) {
                this.f38578a.add((T) Integer.valueOf(i));
            }
        }

        @Override // com.ipd.dsp.internal.v1.a.d
        public Animation b(ViewGroup viewGroup, com.ipd.dsp.internal.v1.a.c cVar) {
            try {
                Path pathA = a(viewGroup, cVar.f38577a);
                cVar.b.c = pathA;
                Animation animationA = a(pathA, cVar.f38577a);
                animationA.setDuration(f);
                return animationA;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.ipd.dsp.internal.v1.a.d
        public void a(ViewGroup viewGroup, com.ipd.dsp.internal.v1.a.c cVar) {
            if (cVar.c % 10 == 0) {
                ((ImageView) cVar.f38577a).setImageResource(R.drawable.ipd_ic_redpack_1);
            } else {
                ((ImageView) cVar.f38577a).setImageResource(R.drawable.ipd_ic_redpack_2);
            }
            cVar.b.f38576a = ((long) cVar.c) * 166;
            cVar.f38577a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.qma
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44247a.a(view);
                }
            });
        }

        public final /* synthetic */ void a(View view) {
            if (this.e) {
                return;
            }
            this.e = true;
            this.b.i();
        }

        @Override // com.ipd.dsp.internal.v1.a.d
        public void a() {
            this.b = null;
            this.c = null;
            ArrayList<C0924b> arrayList = this.d;
            if (arrayList != null) {
                arrayList.clear();
                this.d = null;
            }
            List<T> list = this.f38578a;
            if (list != 0) {
                list.clear();
                this.f38578a = null;
            }
        }

        public final Path a(ViewGroup viewGroup, View view) {
            C0924b c0924b;
            Path path = new Path();
            view.measure(0, 0);
            int width = viewGroup.getWidth() - view.getMeasuredWidth();
            int height = viewGroup.getHeight();
            float f2 = width / 3.0f;
            if (this.d.isEmpty()) {
                this.d.add(new C0924b(view.getMeasuredWidth() / 2.0f, f2));
                float f3 = f2 * 2.0f;
                this.d.add(new C0924b(f2, f3));
                this.d.add(new C0924b(f3, viewGroup.getWidth() - (view.getMeasuredWidth() / 2.0f)));
            }
            if (this.d.size() == 1) {
                c0924b = this.d.get(0);
            } else {
                ArrayList<C0924b> arrayList = this.d;
                c0924b = arrayList.get(this.c.nextInt(arrayList.size()));
            }
            this.d.remove(c0924b);
            path.moveTo(this.c.nextInt(Math.max(width, 2)) + 150, -view.getMeasuredHeight());
            int i = height / 2;
            float f4 = height;
            path.cubicTo(this.c.nextInt(Math.max(((int) c0924b.a()) / 2, 2)) + c0924b.f38579a + 250.0f, this.c.nextInt(Math.max(i, 2)), this.c.nextInt(Math.max((int) c0924b.a(), 2)) + c0924b.f38579a + 125.0f, this.c.nextInt(Math.max(i, 2)) + (f4 / 2.0f), c0924b.f38579a + (c0924b.a() - this.c.nextInt(80)), f4);
            return path;
        }

        public final Animation a(Path path, View view) {
            return new a(path, view, view.getRotation());
        }
    }

    public b(Context context) {
        super(context);
        setAdapter(new C0923b(this));
    }
}
