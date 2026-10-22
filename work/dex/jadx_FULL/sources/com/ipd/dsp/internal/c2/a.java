package com.ipd.dsp.internal.c2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.go6;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b D;
    public static final b E;
    public static final b F;
    public static final b G;
    public static final b H;
    public static final b I;
    public static final b J;
    public static final b K;
    public static final b L;
    public static final b M;
    public static final b N;
    public static final b O;
    public static final b P;
    public static final b Q;
    public static final b R;
    public static final b S;
    public static final b T;
    public static final b U;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;
    public static final b x;
    public static final b y;
    public static final b z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f38215a = new b(101, "com.eg.android.AlipayGphone", 73, com.alipay.sdk.m.n.a.m, null);
    public static final b o = new b(108, "com.tencent.mm", (String) null, "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499");

    static {
        String str = "ba09b72ceec15a04d9b91d66ba2226b50254e78e3d59f67e6f61f042c647f017ebc87999548a244d4059d1d8724e79f71cef456f71ac06e3ec128964746e6f140b75a23841fa1bae3690dcdab0cf46fb54b5e6af4b61a1777523f8190137d18dd3572f49dca940f6ad2b59d8e7c39ab6284a937be31ba4f920bfa99b31496d75";
        b = new b(102, "com.sankuai.meituan", str);
        c = new b(201, "com.sankuai.meituan.takeoutnew", str);
        d = new b(202, "com.dianping.v1", "cb9cbaffad8a0fcfff4219f67f64a7d103ed2cd13db966c5b63a643a2e347a543c8cb27dd32b82bde5d426dadbf29f8e7e78e3654bdeed4ed4539461a732aff0935787dbf98882faa4f670f4e16df41382c9bb11ca6598246493c97686c9cc81d2007fc4458bddcb988ea51e6ca93a3865893ba1d6e01121c5dfa48bd821a4b3");
        e = new b(103, AlibcProtocolConstant.APPLINK_PACKAGE_NAME, "8406125f369fde2720f7264923a63dc48e1243c1d9783ed44d8c276602d2d570073d92c155b81d5899e9a8a97e06353ac4b044d07ca3e2333677d199e0969c96489f6323ed5368e1760731704402d0112c002ccd09a06d27946269a438fe4b0216b718b658eed9d165023f24c6ddaec0af6f47ada8306ad0c4f0fcd80d9b6911");
        f = new b(203, "com.tmall.wireless", "9357342f31c8bd4d2c460f931260ccaddb44065570eda4ecff9dd2bf2d85facbe0d1fad903eee8b1c6c1fcce081e5cb1bb18e693a862752374e9d4ecb33ee8755a81dd959eac69d198b8218d49fd8162206259bf5a406b7d8fa969cd5bad8db096250bc52be76fb5c1788d44a0d7f695bfc5611f4923d42b9aef95d93f2f9727");
        g = new b(204, "com.taobao.idlefish", "89253f9181dae9888669b5dfc0fefb91f9630c575f93cc70c8c20be4af7b1714d3f5d5870c59b73d78481ac29e49fffc49a4a2b441fca387ebeeea2bcb2c71590429d901412d633d5eb445529cb57077a78a2b0d46fbf8c12b3c79aa22952c6ab22b80737c43404a5949d83f18720760ee4d191adb93ee9003ed2da9b5bb1a93");
        h = new b(205, "me.ele", "ca34fba71285436ae204450beb73dd8c531ee7822cba2ff466d62fa0d4e5047d9b281917ed26e40754118a95d2867911e4d788507e829a93a5e5f54f7a3dcbb1f0eba181d4c745e2ccbc0084ef5126ca603fd6b558aeaa43adecbde8ea6c540f14ea6da8ed4acd4421949b8e9264a0ce5d671b8cead19d7528d86828296e22af");
        i = new b(104, "com.jingdong.app.mall", "8c470af7c751ee12edbae8dd9e7c98fa60d3c631efa0f7172ed36c86bb85c8288391e718c05fdbef008d61f2e8fce4ef4457a69ae5a2fa53ead0c806c18f8b475847c07bf4451d82845efc30d5fc4aa2500f4bc84234a36749e83a9361c9ec89771a762e3d791eebf3154c2e95d06df95be68b4a4dcff33ef1ba5d6d90758b6d");
        j = new b(105, "com.xunmeng.pinduoduo", "8aee5a990832ea80113e537ac4d4405320614a03657315b1b8de9cd4d2955556b49dc9851f0bb2f28f46ebb70519c4e3e81a93e44a2c613fd176dc135bc5c62d0380e16ace83960e5bbb412d79455d2ef4fdddff3aec56b138f6cdc7c1a4c798ff76cb8e276fa68735cf90e2a4f438cf526e8ae73e6a00f8a76181ae042a93b37f3858ca85b48ac49ca1c8a3b2a20667b76c6f4c442e2bfa8a12f2d37bd13218e63b396cc44baa55b2259a63965bc2516ba3880cf53851a9d362e09d985e008e45464d1415324acede64297c6d7e13d543adb67c62eabfdc527b03b715bdef78183c3bbb53201eb09f4ebaea1fe93bd64cee4c45b6a6f6e498fb0aaf95e1fb5d");
        k = new b(106, "com.smile.gifmaker", "93bce2a30779500e3a3160ce5b557f3fa34df50df25ac1ae38c181c8ad94e4709d00afbc532d27ccfd4a92c8f1bd5b19c1f04f37b8230020035e33eb39de2d482ad4c043f251fb08007cb3eac4a348e140a817784195f0fbafc7480c90f76ef966d220abd9c4ab3d246276c98ce6d77a7fcc4f451ae89eb387d9bff521898d97");
        l = new b(206, "com.kuaishou.nebula", "84959833bc4c1af0269910e2e6292aae4e98842fd8e51b4e6cd7fd17bda30abffdc889d6ee1dd680d4a865cd0dd6456d64ea9ac74756bf59d6aa0b6f344f6208fbce95194be88878ed18a76305abf44d308b26d35b315694a2383c422ca5030cb6fa9795036d4ce33e1185e372860851e52d10c2a3f8f436eb2c706bbfc42301c76e84dc1b4be635cea96f8f4f962bfc79a54472c2878bfbfce11647ae2dfb8f21418457e4fdd1fdba04060e75c40d038b5dd2694706d6601d157442b8e7fd07c2201e9a6dd19ae670973ed26bf54eac34f4c2c2df2a2f5f98a60ead76558297f398dc3b19a7587930506f39ad9bd0b4c65396ec1d14066adefe7dc380a053e1");
        String str2 = "a46d108be827bff2c1ac7ad986c463b8cda9f0e7ddc21295af55bd16f7bfabb36fa33b72a8e76f5a59b48b29cb6e34c38d065589636dd120f39346c37b3753830422cc0c84243fdf0e28d3e5970dcd641c70c9e2e3ec66ac14afd351abb59d6885370e16b64bbfb28fbb234dffe25f5cfb6680c84121770cf3a177bc8a28b78b7c86d30a61eb67b9fbfd92e0c8fc5eb8346a238ddfe08522f091c622789932d9debe6910b4b903d02e5f6ded69f5c13a5d1742dac21050dfbb5f4ea615028d7a8642e4a93e075cf8f0e33a4a654af11f4f9a4905d917f0bbb84e63a1a2e90b8997f936e5bf5a75ea6d19d1d93d2677886e59e95c0bb33505363c05e10a389d0b";
        m = new b(107, "com.ss.android.ugc.aweme", str2);
        n = new b(207, "com.ss.android.ugc.aweme.lite", str2);
        String str3 = "9d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a13";
        p = new b(208, "com.sina.weibo", str3);
        q = new b(209, "com.sina.weibolite", str3);
        r = new b(210, "com.xingin.xhs", "9d9ed5a4a85dd8a2117bc8afdcbf944de13f28e068e1b51492c0cba6882f07bba9eeb1ab2911182246f89d227db3f358fe49c3ffb7d7de7592add1ac74bf125aedc7191420cf632d2c163898c601ac85c0bc90e7d932763e9454128ae33994f5cc622cb3d42448ae4da94636d9fb32b4c5006a7abcec322691706c8eefa48265");
        s = new b(211, "com.ss.android.article.news", str2);
        t = new b(212, "com.ss.android.article.lite", str2);
        u = new b(213, "com.ss.android.article.video", str2);
        v = new b(go6.g, "tv.danmaku.bili", "bfc97a0b763abe924af0bc06a77cfcd42c0352218bdf94c3069ee0046d739acc80f29a63576943d310bdc99fdf92b318b2beb82aa6ed7c1da2b8309b736a3d5a8d453704c5ddb422fcdcf3945b7eec15684e8986ca5be2bced562afeeb64f9922996b5ed58a0783f72e5d6c50db1fb31426ad1f64a555a48543143601f6c1c11");
        w = new b(215, "com.dragon.read", "9ed1fb6f2aaedf2356e73b1cce4a53e5b91ff42175c9bb3490ffc3b2670eee7d0a9ce3cc6208b565a01bc3f6a643839567721cfeec25dfb95f26f335ce71f4e55218767b930521202cae260896036fc1bc3c5820ecc48e4a3881b9946e8565c70a1a19023f771e702f592e47f5bd9fd5933fa09fe18979a84ccf2e115550b02c09059bc87e36a13d8f58486a20166ca9d785b70f34a8da450c41747ae52b94a26d9dd6da5551c6911f7bbfe2a7d51c563fc7ef977687a0245d24c18cd49b8da6e631ec764d0ca7ea2578440f1a81d915d70c220dfc134d9914d304be4042abe37c05116f8e236eadd78215612718b7e52a6894d107fe9fcd56c73803c7fd3103");
        String str4 = "9c7a58a39572c4b379ddfca6765e95d3aec69fe362ce622e629647cf441b9e4b7b695e540fd29b7da7b2ab64793089f2b69112d11ac5776973dd68cff88b671826c1286e57c7294c76c7c118ae41bf9336ff9ae0aa90c65ed7db0749ff137b815b6d3b53abaad72d7817b0b8900caef12eea13d12baf0b8cb30543bfb3489c23";
        x = new b(216, "com.baidu.searchbox", str4);
        y = new b(217, "com.baidu.searchbox.lite", str4);
        z = new b(218, "ctrip.android.view", "893c2c02be7d8bf416bc390fe8bc869f86afc9f272980f5f70e77b8b01c0a585b2152319895224753cf3bfabbec1fa59f53d4ce885b669e1ce9c48f39cbe1881d908608d67baacd1185969efa22c426c7966108f0e830495c8d8cc49897dc915b7439d98fe3b78461e69d76be55e6c402c35adea69bb1ee39b13ac68efe2ce37");
        A = new b(219, "com.Qunar", "9f89ddd4dbfb48863179d1c3b7a5783da2ddf09053c1a85d4dc9250f23d5c4770ac4f9167421c5fd7dc74f454aa1896f20685fa5d3e353993597e769624f2549fe704821d17d4369a0dd52089372dbf137cd5c47c8c327389105619ac6d12978b84634767cb1d4347dd2a537816d173fd57cebcda42eba83b9f130768d556fbf");
        B = new b(MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, "com.achievo.vipshop", "933483f8c01a56744aa3a0547395cac422ea07aea03f384590c1fcbbebd30c71395ea8b6bd1a1b048447490e4baf365a4b49726f354e579635f5407e638657492f6caf665c2718118cccbad92f1ffcab623cc7ca9ea8ca9ad58c47ab2105ba7c7c6d6ffe466d7e9406bbf028cb9bb5433a74cb8547d1b6dedef88456a1679d3d");
        C = new b(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, "com.shizhuang.duapp", "8536be13b746c8d1863efb3ac7c1771b51ef7c4d51d494765626b6caa7a6a92efad3a2f23657557f1a54bfb8ab17ca550e3368948bf730cab7a05cb9dd5483a43c8444b1c7c7ecb8f75ca98ff5721dcccf084da1adfdc59a41df5d07e2c738e9556bc0dbc55c92f724f6579d9c0a45f60d76feff3957d43d7d0906e5bdd99df3");
        D = new b(222, "com.sdu.didi.psnger", "ab688697b6d44018044cbeb9643de9a1927dc0db39cc49fef49e2667bff9f2ef1f21a4d25f973c09d7ea1d172d941299b43efe9393c5f7293a84f69f88c834f5eb9af9772a43757ee89d5d0737b7ee6820612fa8b33050536712bb7b59ae41d9ffdf09b6107776d9193b3e391792c46f02716ab0eab8206aa2ad7b49d87857fb");
        E = new b(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, "com.quark.browser", "aac959f5439f1595907c7fa43a6d628fa6c6e0006470d122ee5edac296e51d24450acf16e3a4aa8b75735e23a8a7cd4925825a9e3311d6c6d4024b4e837d613bb037a25e898380625b042c1cb7eb017f86772b4ae10256f840d75a9b4f646f2fd7a178e58035182358c1eb2b940307107af050384f3b2763b186679e371ea5c9");
        F = new b(224, "com.lucky.luckyclient", "bdf24fba1004fd0e8ac074e3e2fc2fd8f1a3aa5212390482d3de3a99a8fb250b1b891493600cf959d57a856ca1a9c46c8bf1a952f827d05cd42cf030ab0987df09c284c93b9cef8731322e18e3a0c37942b9c90981cbec68361149707ba6074a11b8b482cc09636c57c578f350c50dac22fbb1cee2ef57d482ee4e4322f61bb5845f0be615d032925b8b606268aac4bb336f454eab916cbab2977dca0d9b74c94982c2c5d485249df414bb1767689ff5046f1ebbdf210eae55723338285633e1eb02aa1c6b4be713f93f4d585175b89cfa3f97a0fa2e4583658faff759c24a162ca7061cee4444645783c1dd03b0e93c71b4172cd581fac26204f5f152dc13e1");
        G = new b(225, "com.starbucks.cn", "8b4c211c146643a879c5cd48d27285c974560a5dbfc31e8a7f7023bd501583b16e218de490f129f3dd7506614f65ddf952299cc99cdd3c44b0e268f2f2d6340606eef5d15861a0de5544c2c9d246c1f8d0c45c3735432d68e99f7dad2d742a9a2e2f99c428d8ad03b8aea15dc5f258fa6e273a1382d173c43206694676933b3471bae97e49c442e6eecd04434a4cb3e3079120a8830a7d6c7855e150dce15f0f46764c55c9dbac0ee5f255f7af0f26fde7fa62fb8976fd3d191e03168aa731674e312d1ccb8228b751227eafa445a12279b387d1fed1264c8f6b400fd328cdf6731d412ab2f9305d161736bc46333081f7dd4924c8aca351454bcbaddb6d30f306ef97b7871ce65abe33e4ad90c61d8fc74ecf5b1a91b2f4b4df7091cabb36422aedcae14ad0c37fb210880b2332930c16e63b28e8a0beb5c25a6642f66e076aa332ade1b674820cf3b09e8895317ac11637d4b919a37aa267e304cfdb59514420c0df30920a9303c6d70f35a987d5c42a91d3927895a5820407505267d2b096e5d3c731622c769211dc63a8f12d589c40a01309ee83775fe14e84f121369ca9e4b2d7be0a1fb1e683c8c101454697a7fdfb19474cb4c92d5e5b38f3cd0c3c32ea1c4bffc95ad310333432d4a99f45d984718682150ea6a603a97f0655edd20da6e21699077a95150ba7bb43fe0a524bfc627385fe52ece35a5b3eaf6b1e5bfb");
        H = new b(226, "com.unionpay", "8dc60af5457a3d204ae48409e638aeff5c5b7b2ce82d1e939b1eb8ada8d5005cf8cdb6ffc6986dde16d747b63f4455ebed5ddb24ebc3ab417e0a08385f000f67cad824ec185247cd0743eadb422579bbb2c89c81519f6bf3199c91eff18cfa3ffc18e69df18f0fdbc5f7fcf49aa225f487f3313b71de94089488b34979f92307");
        I = new b(227, "com.netease.cloudmusic", "d4eb1197057d6aadc01780a5374f6317b7300937ee2689e4532442c1f645889b35987003b7399b65f402e83fa2713ff4eb948d51a9ff58eb826fcc4d3df0d27aba22205f91f871946990d5c95b438262d7aaec6ca43f6f0b9e1c82f96300156e0647232873699b5194807121f15836003a05caf5b9a1e1835f511f9fcced9cc8019487d0dd8b54838ee334d75abee122c84e7b50e32196d909ca7cdc6b42f720491624bdcb08d24a5b91025a49aa1a5314ca21321655bd9dd2b530e3adbb2511faf4eb33c250a750991548abfdc0a25a113ee775d70db9776af68230cf4db54348871b16b3ac7e36abc2ea674bda2e7398443ed5a516efc7e6cc647e49b65175");
        J = new b(228, "com.youku.phone", "aad50be123f9037ce96037008b1e5ddde3fe200de6ffbad7d38e8d3afe72044689128a8f6a390bde677fed6bd1437939292219dce46d0e8fa2e79a13f76ee2c4b69fcf6355eb18d0c55ed1c511e582aee7d4211e7f1ff5803899baab85ce5b74e763cb5d1780c01596dce48dc409ca4ab859093a084b9a558bf2ed98e78e179f");
        K = new b(229, "com.yaya.zone", "844b158c85493288b55312e4772025a18425bee652bcbc9e39fb5121dfba9c1f4bcb3a9d202a64bd4cda69d17f232f01092b8fe675dd6accd8bc178646edec66faeae56c5ae9623d3366ae210e624f0f06d78b0ae34b9384628826f6a9d4cc8c64b254681e5fe3521a3d8c6e6db823b3b69635ee55c80d9dd5e750d35dd85211");
        L = new b(301, "com.smzdm.client.android", "a0495c654b271ebc1d7159fce412b22d1229409b4ae297c3967a06b668b10dc7c048daf723fda9d07cf98c870839c1c1a23294c5e31b22735f38fc51d5c68f38255a970bde907496048ec470d4ce450026faa73a1b749b8f1f6c00c90da2c37f90525fe1334bc2dbc7eb685a442997845766121ea1e2ea59cdeba0c61f2e3757");
        M = new b(302, "com.bytedance.ls.merchant", "d29cb076199098d08588db06535630407dcefe56d47bc760a9775810c1abc01e4a1d07a6b4e6b8d61065b2258193f5ef7d6b867b4dd765b0718140de016870cfce303f0d469556e0dd1c7e3cea1fc4fa90b9f8c26fcdc954c23d69e48e9d6da1ac1de514c27c1d24db7aa14291258c1851d0ea672759bd31b129cff0b7ab609ee515ae7dbfc86054c3da567b6855af6bc3dd3beaea16b2f1232eb5d2f185af1f6a6e988905d7e5b7db96805d5c9e7db4883d5cd73a936f630d9e6bc8d2b6488cfde22f8333f5bd297aa3422d4378d894ceab54c6d71d960f3255b6fa6096382d5ae55010ae12538fe8bed15a0bca45ece71df476df52e0347f43d2c848d8cde7");
        N = new b(303, "com.wawj.app.t", "88362e99778dffb8082d2f629c355627fd79d3951962827e8c955237d28ded20e513d0c77740d758b65c1089757d030ee3ebe8d52cb48e2cf9d61da067b63f93f4b939a06da037d68c06b38495c067bec8850783a0cbb80cac523f2acc9558a7b9a356adf7f6de2e3214491bfa8b92547b36b08ed10dcbdc3d5b06315612cbbb94915beb33c654a05aaefd05c3c237f66bdb95a709a7945d8c84483465b07db9aa0e538a355e8de0d55c262ed588b3849909f93b52a84cb6d098e17c52972920472c3224b48ebaa888f14eed9b53c789260ba35582660bba0c1fc4eb6716725519abd455c9c36b4fc30b5acdd7a0eead180b10427a59d67de06bdcb3691ec263");
        O = new b(304, "com.ziroom.ziroomcustomer", "b09bd258d7c89df932ad57cea175f4c9b9c5d445cfa4299154a2bebdf35ea520ab5a5c0f4f8a6350ebe961bf52fdfd8e64bd24a78f386ba93b58c5ac41eba0f348953180283e12792812d1b8721ef271ac235a34f23af79b9ddde6776123a867cfe3a7d01bae99c5f85f570478ebe132846446b0091d75b1b22a7a6b0b9700a43c79a86bca26187aa5cd4fe19d0720153575048c9f63c40e06e3b3996f3495e426694e15efd97f1facfff92125785d763efa4d359fde8f855f5bb5be6414818393e76872a218cc5f071a84420bc0834d39aa1fa9d985aa48e564b6c8aafdf7ad55e52754115755e9254dba21563c8ae022c4987445e554d00f9ebc7bf6fe2627");
        P = new b(305, "com.homelink.android", "8a141d579b66f3454a95aee1d3f8724ddcd194a512674e856e306f7bb8599a159546bb8152c997c3ec6e2ef2ac29f4030085084c78278428ab3501035399b99c1a8a5883e8d0d46658ddeae5fa8225c10e7dfcd865583efe8f4d35221cac4d45ea724a422877748323b4cb44fe498dbd9046b0bcfc206faaa7dd570aa9d85543");
        Q = new b(306, "com.lianjia.beike", "887b89874482b7b7356a7ba46081a0130c69efebdb51e6d60856f4732ec4a0adb736b1176744a2fac96e43b6e52d416406ef95e7c61aa402cc0855f4c5f0f36da5fd2b71428b878dd8e52f8f80dcc893c5a60976db90038aa8f4341df26f57b3aa4fbd90557e51493f3df12f31a33d06b751848975554e7d61892c5d946e8a5de49d173a16c0336441cd4c18f207c944023fde5c0d5c71cb849f40ed67307c6e0371626e33e5f5e9825be3bba60c4983f3a970e9634d319fc1ee2908a1e5fc57fd04fb1b184ab5ed28bc6e23c9c52ac4c50ba1e2698911dd3d84f8a82a20c0be928a5179c8b91198a8da662053eafbf21e612b03233216c1ccfca54f62993b9b");
        R = new b(307, "com.anjuke.android.app", "a5c75d224d98a1e812e4e1d501537b47146ea57fc6776433cd5bdf73d11db81581398df4c9d7757934197cf35d9e489ea71ea81d76af963dbc1fb27cb6d04d64751a9a64376879d64db4948babf77496f7a57f449c9c6e24cf0d564c6c81e82683d532088c8b7ec2f69aa19351ad517dfa330859fc8848641a44484261e89f8f");
        S = new b(308, "com.fangdd.mobile.fddhouseownersell", "9f6b427edd8b12af9799567fa90d8b7ea9538bddcaee518ae8ce8b5edbe23f6ea28f053e8be939260c1a2bcf03d09f33c624d576be513e84f6def90310373458a01c9a387ffcfc0a65b2b4f6fad0aa75d630c0cced238f4b04df123c5fcd5a79e60cf3979e59e2397e2a68686897ac0ff857ff79828791969c2b8c916e2220973653e95d12c617c461872fbe685a134dcf2d4bbe75983521bf102dfd7c6eda5602ec15475084ecd086bc8a61e06634de8970d1080a996a24723f004a810a00ed454380ab14d0ed05d3b9d18c164045bbbf1c61e88f72ed0fd3bf99effc5e4e6da172c307c75f0cf93b47966fcf28906f177202cb2bd291b93ec77adcee52ea81");
        T = new b(309, "com.soufun.app", "cb2363a1329142b588501ea15c3ff5e48c933903f528c90296275c2051aa2c4ace4deca03541e697ba3ebfb16f36552f4f7c993e84ddee4bd3b30633fdbfa30727b8bacc9bacb29f592478f4a63f01babdd71f6a99b29eefcc3e4ce12c7ff8ed11494fa69432019bcb6334742b783252085d00f8aecc0d65c26e5dc1e77ef23d");
        U = new b(310, "com.cainiao.wireless", "b8ce08611aafd3c661048f308b0385d2a24cc8f8c874382b9400b6144c205ab315ba2d07f3e8d212da5816aec91a790776e512a27e1001c1b957a8d0dddbc90f531c29f3cf35ca7fd768d15b992ed054e967fa5139d182ade3e928b6378b6ab9ae25fc2d978f02ef9a62903bfa41199e72dc3de0fec14a1a81bd9b382de5c247c7f5a84cd66fdfcde373d5c2b371b1cb889f3181bf01f8a31e6a99088bf0b26f0a0d02166997e2d6e402561e24919410edcfb7908302cd3a8c477de835bb24a2417e6d5f7f57d700bcb9997159939594806d4803e552f83042a5d430d13532ab4f0c6736be27298a180f02a4c4550405bcca53c19b652ec0b3151a2177a75a6f");
    }

    public static int a(b bVar, boolean z2, @Nullable List<Integer> list) {
        Context context;
        PackageInfo packageInfo;
        if ((!z2 && (list == null || !list.contains(Integer.valueOf(bVar.f38216a)))) || (context = com.ipd.dsp.internal.l1.a.a().getContext()) == null) {
            return 1;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 33) {
                packageInfo = context.getPackageManager().getPackageInfo(bVar.c, PackageManager.PackageInfoFlags.of(134217856L));
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(bVar.c, (i2 >= 28 ? 134217728 : 64) | 128);
            }
            if (packageInfo == null) {
                return 1;
            }
            if (bVar.b > 0) {
                if ((i2 >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode) < bVar.b) {
                    return 2;
                }
            }
            if (!o.c(bVar.d) && !o.c(bVar.e)) {
                return 3;
            }
            Signature[] signatureArrA = a(packageInfo);
            if (signatureArrA != null && signatureArrA.length > 0) {
                if (o.c(bVar.d)) {
                    return a(signatureArrA, bVar.d) ? 4 : 3;
                }
                if (b(signatureArrA, bVar.e)) {
                    return 4;
                }
            }
            return 3;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static boolean b(Signature[] signatureArr, String str) {
        if (signatureArr != null) {
            for (Signature signature : signatureArr) {
                try {
                    if (signature.toCharsString().toLowerCase().equals(str)) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38216a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;

        public b(int i, String str, String str2) {
            this(i, str, 0, str2, (String) null);
        }

        public b(int i, String str, String str2, String str3) {
            this(i, str, 0, str2, str3);
        }

        public b(int i, String str, int i2, String str2, String str3) {
            this.f38216a = i;
            this.c = str;
            this.b = i2;
            this.d = str2;
            this.e = str3;
        }
    }

    public static Signature[] a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo == null) {
                return null;
            }
            if (signingInfo.hasMultipleSigners()) {
                return packageInfo.signingInfo.getApkContentsSigners();
            }
            return packageInfo.signingInfo.getSigningCertificateHistory();
        }
        return packageInfo.signatures;
    }

    public static boolean a(Signature[] signatureArr, String str) {
        BigInteger modulus;
        if (signatureArr != null) {
            for (Signature signature : signatureArr) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
                    try {
                        PublicKey publicKey = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                        if ((publicKey instanceof RSAPublicKey) && (modulus = ((RSAPublicKey) publicKey).getModulus()) != null && str.equals(modulus.toString(16))) {
                            byteArrayInputStream.close();
                            return true;
                        }
                        byteArrayInputStream.close();
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return false;
    }
}
