package com.bumptech.glide.integration.webp.decoder;

import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WebpDrawableResource extends DrawableResource<WebpDrawable> implements Initializable {
    public WebpDrawableResource(WebpDrawable webpDrawable) {
        super(webpDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<WebpDrawable> getResourceClass() {
        return WebpDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return ((WebpDrawable) this.drawable).getSize();
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void initialize() {
        ((WebpDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        ((WebpDrawable) this.drawable).stop();
        ((WebpDrawable) this.drawable).recycle();
    }
}
