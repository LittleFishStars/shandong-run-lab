package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.permission.PermissionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.adn.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vf extends z0 implements wc {
    private final String A;
    private final String B;
    private ASNPUnifiedExpressContainer C;
    private Map D;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private final String z;

    public class a implements pb {
        public a() {
        }

        @Override // com.beizi.fusion.pb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(AssetModel assetModel, Object obj) {
            return assetModel.getVideo() != null;
        }
    }

    public static class b implements bf.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PermissionModel f27864a;

        private b(PermissionModel permissionModel) {
            this.f27864a = permissionModel;
        }

        @Override // com.beizi.fusion.bf.a
        public String a() {
            return this.f27864a.getDescribe();
        }

        @Override // com.beizi.fusion.bf.a
        public String getTitle() {
            return this.f27864a.getTitle();
        }
    }

    public class c implements fe {
        private c() {
        }

        @Override // com.beizi.fusion.fe
        public void a() {
        }

        @Override // com.beizi.fusion.ya
        public void a(ee eeVar) {
        }

        @Override // com.beizi.fusion.fe
        public void f() {
        }

        @Override // com.beizi.fusion.fe
        public void a(ab abVar) {
            he heVarD = abVar.d();
            if (heVarD instanceof zc) {
                zc zcVar = (zc) heVarD;
                xc xcVarA = vf.this.a(abVar.d(), zcVar.getInteractionType(), zcVar.getActionType());
                if (xcVarA != null) {
                    zcVar.bindInteractionForm(xcVarA);
                }
            }
        }
    }

    public static class d implements bf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DownloadInfoModel f27866a;

        private d(DownloadInfoModel downloadInfoModel) {
            this.f27866a = downloadInfoModel;
        }

        @Override // com.beizi.fusion.bf
        public List a() {
            if (this.f27866a.getPermission() == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<PermissionModel> it = this.f27866a.getPermission().iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next()));
            }
            return arrayList;
        }

        @Override // com.beizi.fusion.bf
        public String b() {
            return this.f27866a.getPermissionUrl();
        }

        @Override // com.beizi.fusion.bf
        public String c() {
            return this.f27866a.getVersion();
        }

        @Override // com.beizi.fusion.bf
        public String d() {
            return this.f27866a.getAppIntroduction();
        }

        @Override // com.beizi.fusion.bf
        public String e() {
            return this.f27866a.getDeveloper();
        }

        @Override // com.beizi.fusion.bf
        public String f() {
            return this.f27866a.getPolicyUrl();
        }

        @Override // com.beizi.fusion.bf
        public String getName() {
            return this.f27866a.getName();
        }
    }

    public vf(Context context, AdItemModel adItemModel, ba baVar, AdTraceModel adTraceModel) {
        super(context, adItemModel, baVar, adTraceModel);
        this.v = "title";
        this.w = "desc";
        this.x = "image";
        this.y = RemoteMessageConst.Notification.ICON;
        this.z = "video";
        this.A = "actionText";
        this.B = "adLogo";
        w();
    }

    private void s() {
    }

    private List t() {
        NativeModel nativeModelA = a(this.b);
        if (nativeModelA != null) {
            return nativeModelA.getAsset();
        }
        return null;
    }

    private List u() {
        Map map = this.D;
        return map != null ? (List) map.get("image") : Collections.EMPTY_LIST;
    }

    private AssetModel v() {
        return (AssetModel) k5.a(t(), null, new a());
    }

    private void w() {
        List<AssetModel> listT = t();
        if (listT != null) {
            this.D = new HashMap();
            for (AssetModel assetModel : listT) {
                String strTrim = assetModel.getId().trim();
                if (!TextUtils.isEmpty(strTrim)) {
                    switch (strTrim.charAt(0)) {
                        case '1':
                            if (assetModel.getImage() != null) {
                                Map map = this.D;
                                map.put("image", a((List) map.get("image"), assetModel.getImage().getUrl()));
                            }
                            break;
                        case '2':
                            if (assetModel.getVideo() != null) {
                                Map map2 = this.D;
                                map2.put("video", a((List) map2.get("video"), assetModel.getVideo().getUrl()));
                            }
                            break;
                        case '3':
                            if (assetModel.getTitle() != null) {
                                Map map3 = this.D;
                                map3.put("title", a((List) map3.get("title"), assetModel.getTitle().getText()));
                            }
                            break;
                        case '4':
                            if (assetModel.getTitle() != null) {
                                Map map4 = this.D;
                                map4.put("desc", a((List) map4.get("desc"), assetModel.getTitle().getText()));
                            }
                            break;
                        case '5':
                            if (assetModel.getImage() != null) {
                                Map map5 = this.D;
                                map5.put(RemoteMessageConst.Notification.ICON, a((List) map5.get(RemoteMessageConst.Notification.ICON), assetModel.getImage().getUrl()));
                            }
                            break;
                        case '6':
                            if (assetModel.getTitle() != null) {
                                Map map6 = this.D;
                                map6.put("actionText", a((List) map6.get("actionText"), assetModel.getTitle().getText()));
                            }
                            break;
                        case '7':
                            if (assetModel.getImage() != null) {
                                Map map7 = this.D;
                                map7.put("adLogo", a((List) map7.get("adLogo"), assetModel.getImage().getUrl()));
                            }
                            break;
                    }
                }
            }
        }
    }

    private void x() {
        ce ceVarA = ce.a.a(this.f28077a, this.c);
        ceVarA.a(this.b);
        if (ceVarA instanceof wa) {
            wa waVar = (wa) ceVarA;
            if (waVar.d() != null) {
                waVar.d().a(new c());
            }
        }
        if (ceVarA instanceof dn) {
            ((dn) ceVarA).a(this.C);
        }
        ceVarA.c();
    }

    @Override // com.beizi.fusion.z0, com.beizi.fusion.ib
    public void b() {
        super.b();
        ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer = this.C;
        if (aSNPUnifiedExpressContainer != null) {
            aSNPUnifiedExpressContainer.onViewDestroy();
            this.C.removeFromParent();
        }
    }

    @Override // com.beizi.fusion.wc
    public List c() {
        return u();
    }

    @Override // com.beizi.fusion.wc
    public bf d() {
        NativeModel nativeModelA = a(this.b);
        if (nativeModelA == null || nativeModelA.getDownloadInfo() == null) {
            return null;
        }
        return new d(nativeModelA.getDownloadInfo());
    }

    @Override // com.beizi.fusion.wc
    public String g() {
        return a("actionText");
    }

    @Override // com.beizi.fusion.wc
    public String getAdLogoUrl() {
        return a("adLogo");
    }

    @Override // com.beizi.fusion.wc
    public String getDesc() {
        return a("desc");
    }

    @Override // com.beizi.fusion.wc
    public String getIconUrl() {
        return a(RemoteMessageConst.Notification.ICON);
    }

    @Override // com.beizi.fusion.wc
    public String getTitle() {
        return a("title");
    }

    @Override // com.beizi.fusion.wc
    public String h() {
        return a("image");
    }

    @Override // com.beizi.fusion.wc
    public u0 i() {
        if (c() == null || c().size() <= 1) {
            return v() != null ? u0.PATTERN_VIDEO : u0.PATTERN_TEXT_IMAGE;
        }
        return u0.PATTERN_3_IMAGES;
    }

    @Override // com.beizi.fusion.ib
    public View a() {
        return this.C;
    }

    @Override // com.beizi.fusion.wc
    public void a(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List list) {
        this.C = aSNPUnifiedExpressContainer;
        ScopeExpressContainer.d.a(aSNPUnifiedExpressContainer, b(this.b), q(), r());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b((View) it.next());
        }
        x();
    }

    private void b(View view) {
        if (this.C != null) {
            view.setTag(dm.a(this.f28077a, "scope_root_container"), this.C);
            a(view, "click", "click").a((Object) null);
        } else {
            s();
        }
    }

    private String a(String str) {
        List list;
        Map map = this.D;
        return (map == null || (list = (List) map.get(str)) == null || list.isEmpty()) ? "" : (String) list.get(0);
    }

    private List a(List list, String str) {
        if (list == null) {
            list = new ArrayList();
        }
        list.add(str);
        return list;
    }
}
