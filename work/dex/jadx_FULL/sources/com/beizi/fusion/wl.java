package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.creative.CreativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.speed.SpeedModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class wl implements pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pa.a f27985a;
    private final NativeModel b;
    private final CreativeModel c;
    private final Context d;
    private Map e;
    private ab f;
    private boolean g = false;
    private JSONArray h;

    public class a implements pb {
        public a() {
        }

        @Override // com.beizi.fusion.pb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(AssetModel assetModel, String str) {
            if (assetModel == null) {
                return false;
            }
            String id = assetModel.getId();
            if (TextUtils.isEmpty(id)) {
                return false;
            }
            return id.equals(str);
        }
    }

    public wl(Context context, AdItemModel adItemModel, pa.a aVar) {
        this.d = context;
        this.b = adItemModel.getNativeModel();
        this.c = adItemModel.getCreativeModel();
        this.f27985a = aVar;
        a(true);
    }

    private void a(boolean z) {
        pa.a aVar;
        this.e = new ArrayMap();
        NativeModel nativeModel = this.b;
        if (nativeModel != null) {
            this.h = mg.a(nativeModel.asJsonObject(), NativeModel.JSON_KEY_SCHEME);
            List render = z ? this.b.getRender() : null;
            if ((render == null || render.isEmpty()) && (aVar = this.f27985a) != null) {
                render = aVar.a(this.b.getRenderId());
            }
            a(this.d, render, this.b.getAsset(), this.b.getIncome() != null ? this.b.getIncome().getSpeedModel() : null, this.b.getLink() != null && this.b.getLink().getInteractType() == 1, this.b.getDownloadInfo());
        }
    }

    @Override // com.beizi.fusion.pa
    public void b() {
    }

    @Override // com.beizi.fusion.pa
    public void c() {
        if (this.f27985a != null) {
            a(false);
        } else {
            this.g = false;
        }
    }

    @Override // com.beizi.fusion.pa
    public String d() {
        JSONArray jSONArray = this.h;
        String string = jSONArray != null ? jSONArray.toString() : "";
        this.h = null;
        return string;
    }

    @Override // com.beizi.fusion.pa
    public boolean e() {
        return this.g;
    }

    @Override // com.beizi.fusion.pa
    public ab f() {
        return this.f;
    }

    @Override // com.beizi.fusion.pa
    public int g() {
        Map map = this.e;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    private void a(Context context, List list, List list2, SpeedModel speedModel, boolean z, DownloadInfoModel downloadInfoModel) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, ul.b());
            for (int i = 0; i < list.size(); i++) {
                RenderModel renderModel = (RenderModel) list.get(i);
                if (renderModel != null && !TextUtils.isEmpty(renderModel.getId())) {
                    String controlType = renderModel.getViewModel() != null ? renderModel.getViewModel().getControlType() : "";
                    he heVarA = fn.a(context, controlType, renderModel.getInteractionModel() != null ? renderModel.getInteractionModel().getBindEvent() : "");
                    if (heVarA instanceof je) {
                        ((je) heVarA).setRenderWithDownload(z);
                    }
                    if (heVarA instanceof ie) {
                        ((ie) heVarA).bindRenderSpeedPriority(speedModel);
                    }
                    xl xlVar = new xl(heVarA, renderModel, this.e, i);
                    String superView = renderModel.getSuperView();
                    if (!TextUtils.isEmpty(superView) && this.e.containsKey(superView)) {
                        ab abVar = (ab) this.e.get(superView);
                        if (abVar != null) {
                            om.a("RenderHierarchy", String.format("当前model (%s) 的 父节点 (%s) 存在. 设置父子节点关系...", renderModel.getId(), superView));
                            abVar.a(xlVar);
                            xlVar.b(abVar);
                        }
                    } else {
                        this.f = xlVar;
                    }
                    xlVar.c(this.f);
                    if (renderModel.getViewModel() != null) {
                        a(controlType, renderModel.getViewModel());
                        String assetsId = renderModel.getViewModel().getAssetsId();
                        if (!TextUtils.isEmpty(assetsId)) {
                            AssetModel assetModel = (AssetModel) k5.a(list2, assetsId, new a());
                            if (assetModel != null) {
                                xlVar.a(assetModel);
                            }
                        }
                    }
                    if (heVarA instanceof bc) {
                        ((bc) heVarA).bindDownloadInfo(downloadInfoModel);
                    }
                }
            }
            this.g = true;
            return;
        }
        this.g = false;
    }

    private void a(String str, ViewModel viewModel) {
        CreativeModel creativeModel;
        if (!"tag".equalsIgnoreCase(str) || (creativeModel = this.c) == null) {
            return;
        }
        viewModel.setCMD5(creativeModel.getMaterialID());
    }

    @Override // com.beizi.fusion.pa
    public ab a(String str) {
        Map map = this.e;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (ab) this.e.get(str);
    }
}
