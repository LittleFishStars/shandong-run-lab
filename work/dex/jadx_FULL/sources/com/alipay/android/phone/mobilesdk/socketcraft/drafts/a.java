package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends Draft_10 {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
        return Draft_10.b(aVar) == 13 ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft c() {
        return new a();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_10, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.b a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar) {
        super.a(bVar);
        bVar.a(com.google.common.net.b.R1, "13");
        return bVar;
    }
}
