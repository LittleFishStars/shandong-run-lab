package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeRoundImageView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.speed.SpeedModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.he;
import com.beizi.fusion.ie;
import com.beizi.fusion.mf;
import com.beizi.fusion.no;
import com.beizi.fusion.oc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeImageView extends ScopeRoundImageView implements he, ie {
    private String g;
    protected RenderModel h;
    protected AssetModel i;
    protected SpeedModel j;
    private ScopeExpressContainer k;

    public class a implements oc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ he.a f27046a;

        public a(he.a aVar) {
            this.f27046a = aVar;
        }

        @Override // com.beizi.fusion.oc
        public void a() {
            ScopeImageView.this.b(this.f27046a);
        }

        @Override // com.beizi.fusion.oc
        public void b() {
            if (ScopeImageView.this.e()) {
                return;
            }
            ScopeImageView.this.a(this.f27046a);
        }
    }

    public ScopeImageView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(he.a aVar) {
        if (aVar != null) {
            aVar.b(this.h.getId());
        }
    }

    private boolean b() {
        ViewGroup.LayoutParams layoutParams;
        AssetModel assetModel = this.i;
        if (assetModel == null || assetModel.getImage() == null) {
            return false;
        }
        int imageWidth = this.i.getImage().getImageWidth();
        int imageHeight = this.i.getImage().getImageHeight();
        if (imageWidth <= 0 || imageHeight <= 0 || (layoutParams = getLayoutParams()) == null) {
            return false;
        }
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        float fAbs = Math.abs((((float) (((double) i) * 1.0d)) / i2) - (((float) (((double) imageWidth) * 1.0d)) / imageHeight));
        if (fAbs > 0.15f) {
            return true;
        }
        if (fAbs > 0.1f) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
            return false;
        }
        setScaleType(ImageView.ScaleType.FIT_XY);
        return false;
    }

    private boolean c() {
        SpeedModel speedModel = this.j;
        return speedModel != null && speedModel.isAnimation();
    }

    private boolean d() {
        SpeedModel speedModel = this.j;
        return speedModel != null && speedModel.isPlaceHolder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        SpeedModel speedModel = this.j;
        return speedModel != null && speedModel.isImageSpeed();
    }

    @Override // com.beizi.fusion.he
    public void bindAssetModel(AssetModel assetModel) {
        this.i = assetModel;
    }

    @Override // com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        this.h = renderModel;
        ViewModel viewModel = renderModel.getViewModel();
        if (viewModel != null) {
            setBorderColor(viewModel.getBorderColor());
            setRectRadius(no.h(viewModel.getBorderRadius()));
            setBorderWidth(no.i(viewModel.getBorderSize()));
        }
    }

    @Override // com.beizi.fusion.ie
    public void bindRenderSpeedPriority(SpeedModel speedModel) {
        this.j = speedModel;
    }

    public void fillContent(he.a aVar) {
        String imageURL;
        String placeHolder;
        ViewModel viewModel = this.h.getViewModel();
        if (viewModel == null) {
            b(aVar);
            return;
        }
        AssetModel assetModel = this.i;
        if (assetModel == null || assetModel.getImage() == null) {
            imageURL = viewModel.getImageURL();
            placeHolder = "";
        } else {
            imageURL = this.i.getImage().getUrl();
            placeHolder = this.i.getImage().getPlaceHolder();
        }
        if (TextUtils.isEmpty(imageURL)) {
            if (TextUtils.isEmpty(viewModel.getAssetsId())) {
                a(aVar);
                return;
            } else {
                b(aVar);
                return;
            }
        }
        mf.a(getContext()).b(imageURL).a(viewModel.useGaussianBlur() && b()).a(d() ? placeHolder : "").c(c()).a(R.drawable.asnp_ad_guarantee).b(true).a(new a(aVar)).a(this);
        if (e()) {
            a(aVar);
        }
    }

    @Override // com.beizi.fusion.he
    public ScopeExpressContainer getExpressRoot() {
        return this.k;
    }

    @Override // com.beizi.fusion.he
    public int getLayer() {
        return this.h.getLayer();
    }

    @Override // com.beizi.fusion.he
    public String getScopeViewID() {
        return this.g;
    }

    @Override // com.beizi.fusion.he
    public void onViewDestroy() {
    }

    public void onViewPause(boolean z) {
    }

    public void onViewResume(boolean z) {
    }

    @Override // com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        this.k = scopeExpressContainer;
    }

    @Override // com.beizi.fusion.he
    public void setScopeViewID(String str) {
        this.g = str;
        setId(no.i(str));
    }

    public ScopeImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScopeImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(he.a aVar) {
        if (aVar != null) {
            aVar.a(this.h.getId());
        }
    }
}
