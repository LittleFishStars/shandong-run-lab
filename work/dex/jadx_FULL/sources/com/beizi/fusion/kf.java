package com.beizi.fusion;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class kf implements pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27469a;
    private String b;
    private String c;
    private oc d;
    private int e;
    private b g;
    private boolean f = true;
    private boolean h = false;
    private boolean i = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27470a;

        public a(ImageView imageView) {
            this.f27470a = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObjectAnimator.ofFloat(this.f27470a, "alpha", 0.0f, 1.0f).start();
        }
    }

    public class d implements nb {
        private d() {
        }

        @Override // com.beizi.fusion.nb
        public void a() {
        }

        @Override // com.beizi.fusion.nb
        public void a(Bitmap bitmap) {
            kf.this.g.a(new BitmapDrawable(kf.this.f27469a.getResources(), bitmap), 2);
        }
    }

    public kf(Context context) {
        this.f27469a = context;
    }

    @Override // com.beizi.fusion.pc
    public pc a(String str) {
        this.c = str;
        return this;
    }

    @Override // com.beizi.fusion.pc
    public pc b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.beizi.fusion.pc
    public pc c(boolean z) {
        this.i = z;
        return this;
    }

    @Override // com.beizi.fusion.pc
    public pc a(int i) {
        this.e = i;
        return this;
    }

    @Override // com.beizi.fusion.pc
    public pc b(boolean z) {
        this.f = z;
        return this;
    }

    @Override // com.beizi.fusion.pc
    public pc a(oc ocVar) {
        this.d = ocVar;
        return this;
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImageView f27471a;
        private final oc b;

        private b(ImageView imageView, oc ocVar) {
            super(Looper.getMainLooper());
            this.f27471a = imageView;
            this.b = ocVar;
        }

        private void b() {
            oc ocVar = this.b;
            if (ocVar != null) {
                ocVar.b();
            }
        }

        public void a(Object obj, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.obj = obj;
            sendMessage(messageObtain);
        }

        public void c() {
            sendEmptyMessage(3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ImageView imageView = this.f27471a;
                if (imageView != null) {
                    Object obj = message.obj;
                    if (obj instanceof Bitmap) {
                        imageView.setImageBitmap((Bitmap) obj);
                        b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    a();
                }
            } else {
                ImageView imageView2 = this.f27471a;
                if (imageView2 != null) {
                    Object obj2 = message.obj;
                    if (obj2 instanceof Drawable) {
                        imageView2.setBackground((Drawable) obj2);
                    }
                }
                this.f27471a = null;
            }
        }

        private void a() {
            oc ocVar = this.b;
            if (ocVar != null) {
                ocVar.a();
            }
        }
    }

    public class c implements nb {
        private c() {
        }

        @Override // com.beizi.fusion.nb
        public void a(Bitmap bitmap) {
            b bVar = kf.this.g;
            if (bVar != null) {
                bVar.a(bitmap, 1);
                if (kf.this.h) {
                    w4 w4VarA = w4.a();
                    kf kfVar = kf.this;
                    w4VarA.a(kfVar.f27469a, bitmap, new d());
                }
            }
        }

        @Override // com.beizi.fusion.nb
        public void a() {
            w4 w4VarA = w4.a();
            kf kfVar = kf.this;
            Bitmap bitmapA = w4VarA.a(kfVar.f27469a, kfVar.c, kfVar.e);
            if (bitmapA != null) {
                b bVar = kf.this.g;
                if (bVar != null) {
                    bVar.a(bitmapA, 1);
                    return;
                }
                return;
            }
            b bVar2 = kf.this.g;
            if (bVar2 != null) {
                bVar2.c();
            }
        }
    }

    @Override // com.beizi.fusion.pc
    public pc a(boolean z) {
        this.h = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.beizi.fusion.pc
    public void a(ImageView imageView) {
        if (imageView != null) {
            if (this.i) {
                imageView.post(new a(imageView));
            }
            this.g = new b(imageView, this.d);
            w4.a().a(this.f27469a, this.b, this.f, new c());
        }
    }
}
