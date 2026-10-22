package com.byazt.oq;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.nr.eo;
import com.byazt.nr.z;
import com.byazt.tm.DynamicImageFlipSlide;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1112})
public class ImageFlipSlideGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28904a;
    public FrameLayout c;
    public String da;
    public String i;
    public ObjectAnimator n;
    public String sl;
    public boolean sp;
    public String t;
    public BookPageView tt;
    public List<String> u;
    public float uj;
    public ImageView ve;
    public ImageFlipSlide x;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.uj = 0.0f;
        this.sp = z;
        uj();
        setVisibility(4);
        post(new Runnable() { // from class: com.byazt.oq.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    private void uj() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.sp);
        this.x = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.c = frameLayout;
        addView(frameLayout);
        if (!this.sp) {
            BookPageView bookPageView = new BookPageView(getContext());
            this.tt = bookPageView;
            this.c.addView(bookPageView);
            return;
        }
        View view = new View(getContext());
        view.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(eo.c(getContext(), 2.0f), -1);
        layoutParams.gravity = 17;
        this.c.addView(view, layoutParams);
        ImageView imageView = new ImageView(getContext());
        z.c(getContext(), "tt_im_fs_handle", imageView, 320);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(eo.c(getContext(), 44.0f), eo.c(getContext(), 44.0f));
        layoutParams2.gravity = 17;
        this.c.addView(imageView, layoutParams2);
        this.ve = new ImageView(getContext());
        z.c(getContext(), "tt_im_fs_tip", this.ve, 320);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(eo.c(getContext(), 196.0f), eo.c(getContext(), 300.0f));
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = eo.c(getContext(), 6.0f);
        this.c.addView(this.ve, layoutParams3);
    }

    public float getRatio() {
        return this.uj;
    }

    public void setFilterColors(List<String> list) {
        this.u = list;
    }

    public void setRatio(float f) {
        this.uj = f;
        post(new Runnable() { // from class: com.byazt.oq.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup imageFlipSlideGroup = ImageFlipSlideGroup.this;
                if (imageFlipSlideGroup.sp) {
                    imageFlipSlideGroup.x.c(ImageFlipSlideGroup.this.uj);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.c.getLayoutParams();
                    ImageFlipSlideGroup imageFlipSlideGroup2 = ImageFlipSlideGroup.this;
                    layoutParams.leftMargin = (int) (((1.0f - imageFlipSlideGroup2.uj) - 0.5f) * imageFlipSlideGroup2.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.c.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                float width = ImageFlipSlideGroup.this.getWidth();
                float width2 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup3 = ImageFlipSlideGroup.this;
                point.x = ((int) (width - (width2 * imageFlipSlideGroup3.uj))) - 100;
                float height = imageFlipSlideGroup3.getHeight();
                float width3 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup4 = ImageFlipSlideGroup.this;
                float f2 = imageFlipSlideGroup4.uj;
                point.y = ((int) (height - (width3 * f2))) - 100;
                if (f2 > 0.3f) {
                    double d = point.x;
                    double width4 = imageFlipSlideGroup4.getWidth() * 2;
                    ImageFlipSlideGroup imageFlipSlideGroup5 = ImageFlipSlideGroup.this;
                    point.x = (int) (d - (width4 * (((double) imageFlipSlideGroup5.uj) - 0.3d)));
                    point.y = (int) (((double) point.y) + (((double) (imageFlipSlideGroup5.getHeight() / 2)) * (((double) ImageFlipSlideGroup.this.uj) - 0.3d)));
                }
                ImageFlipSlideGroup.this.tt.c(point);
                ImageFlipSlideGroup imageFlipSlideGroup6 = ImageFlipSlideGroup.this;
                imageFlipSlideGroup6.tt.setAlpha(1.0f - (imageFlipSlideGroup6.uj - 0.3f));
                ImageFlipSlideGroup.this.x.c(ImageFlipSlideGroup.this.tt.getFilterAreaPath());
            }
        });
    }

    public void tt() {
        ObjectAnimator objectAnimator = this.n;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void ve() {
        if (TextUtils.isEmpty(this.da)) {
            this.x.c(this.i, this.sl, this.u);
        } else {
            this.x.c(this.da, this.t, (List<String>) null);
        }
    }

    public void c(final DynamicImageFlipSlide.c cVar) {
        if (this.f28904a) {
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        this.f28904a = true;
        this.n.cancel();
        if (this.ve != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.ve.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.uj;
        fArr[1] = this.sp ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oq.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.c.setVisibility(8);
                DynamicImageFlipSlide.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void tt(String str, String str2) {
        this.da = str;
        this.t = str2;
    }

    public void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.n = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.setRepeatCount(-1);
        this.n.setRepeatMode(2);
        this.n.start();
    }

    public void c(String str, String str2) {
        this.i = str;
        this.sl = str2;
    }
}
