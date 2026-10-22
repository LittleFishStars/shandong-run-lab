package com.beizi.fusion;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.ImageModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.type.VideoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xl implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28037a;
    private ab b;
    private ab d;
    private final he e;
    private final ge f;
    private final Map h;
    private boolean g = false;
    private final Map c = new HashMap();

    public xl(he heVar, RenderModel renderModel, Map map, int i) {
        this.e = heVar;
        heVar.setScopeViewID(renderModel.getId());
        heVar.bindRenderModel(renderModel);
        this.h = map;
        map.put(b(), this);
        this.f = new yl(heVar.getContext(), renderModel.getLayoutModel(), this, renderModel.getSuperView());
        this.f28037a = i;
    }

    @Override // com.beizi.fusion.ab
    public void a(ab abVar) {
        this.c.put(abVar.b(), abVar);
    }

    public void b(ab abVar) {
        this.b = abVar;
    }

    public void c(ab abVar) {
        this.d = abVar;
    }

    @Override // com.beizi.fusion.ab
    public he d() {
        return this.e;
    }

    @Override // com.beizi.fusion.ab
    public ab e() {
        return this.b;
    }

    @Override // com.beizi.fusion.ab
    public int f() {
        return this.f28037a;
    }

    public int g() {
        Map map = this.c;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public List h() {
        Map map = this.c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new ArrayList(this.c.values());
    }

    public Map i() {
        return this.h;
    }

    @Override // com.beizi.fusion.ab
    public ge a() {
        return this.f;
    }

    @Override // com.beizi.fusion.ab
    public String b() {
        return this.e.getScopeViewID();
    }

    @Override // com.beizi.fusion.ab
    public boolean c() {
        return this.g;
    }

    public void a(AssetModel assetModel) {
        ImageModel image = assetModel.getImage();
        VideoModel video = assetModel.getVideo();
        if (image != null) {
            this.f.a(image.getImageWidth(), image.getImageHeight());
        }
        if (video != null) {
            this.f.a(video.getVideoWidth(), video.getVideoHeight());
        }
        if (image != null || video != null) {
            this.g = true;
        }
        this.e.bindAssetModel(assetModel);
    }
}
