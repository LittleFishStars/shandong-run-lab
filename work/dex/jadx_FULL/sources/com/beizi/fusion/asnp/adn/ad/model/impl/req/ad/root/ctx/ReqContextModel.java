package com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx;

import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ASNPJsonRequestModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.app.ReqAppModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.dev.ReqDeviceModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.ext.ReqContextExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.reg.ReqRegsModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.req.ad.root.ctx.user.ReqUserModel;
import com.beizi.fusion.kg;
import com.huachenjie.base.util.rich_text.RichTextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ReqContextModel extends ASNPJsonRequestModel {

    @kg(key = NativeCallContext.DOMAIN_APP)
    private ReqAppModel app;

    @kg(key = "device")
    private ReqDeviceModel device;

    @kg(key = LoginConstants.EXT)
    private ReqContextExtModel extModel;

    @kg(key = "regs")
    private ReqRegsModel regs;

    @kg(key = RichTextUtils.USER_SCHEME)
    private ReqUserModel user;

    public void setApp(ReqAppModel reqAppModel) {
        this.app = reqAppModel;
    }

    public void setDevice(ReqDeviceModel reqDeviceModel) {
        this.device = reqDeviceModel;
    }

    public void setExtModel(ReqContextExtModel reqContextExtModel) {
        this.extModel = reqContextExtModel;
    }

    public void setRegs(ReqRegsModel reqRegsModel) {
        this.regs = reqRegsModel;
    }

    public void setUser(ReqUserModel reqUserModel) {
        this.user = reqUserModel;
    }
}
