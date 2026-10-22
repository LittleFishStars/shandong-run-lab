package com.huachenjie.sport.widget.photowall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class HasCloseImage extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f36750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ConstraintLayout f13795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnCloseClickListener f13796a;
    public ImageView b;

    public interface OnCloseClickListener {
        void onClick(View view);
    }

    public HasCloseImage(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        this.f13796a.onClick(view);
    }

    public final void C() {
        ConstraintLayout constraintLayout = (ConstraintLayout) View.inflate(getContext(), R.layout.layout_has_close_image, this);
        this.f13795a = constraintLayout;
        this.f36750a = (ImageView) constraintLayout.findViewById(R.id.image);
        ImageView imageView = (ImageView) this.f13795a.findViewById(R.id.iv_close);
        this.b = imageView;
        if (this.f13796a != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vy3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f45486a.D(view);
                }
            });
        }
    }

    public void setCloseType() {
        this.f36750a.setImageDrawable(getResources().getDrawable(R.drawable.ic_feedback_image_add));
        this.b.setVisibility(8);
    }

    public void setImage(String str) {
        setImage(str, 0);
    }

    public void setOnCloseClickListener(OnCloseClickListener onCloseClickListener) {
        this.f13796a = onCloseClickListener;
    }

    public HasCloseImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setImage(String str, int i) {
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(getContext()).load(str);
        if (i > 0) {
            requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(i)));
        }
        requestBuilderLoad.into(this.f36750a);
    }

    public HasCloseImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C();
    }

    public void setImage(Bitmap bitmap, int i) {
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(getContext()).load(bitmap);
        if (i > 0) {
            requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(i)));
        }
        requestBuilderLoad.into(this.f36750a);
    }
}
