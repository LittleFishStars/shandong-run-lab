package cj.mobile.wm;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ie {
    public static String dexa(List<String> list) {
        try {
            PrivateKey privateKeyDexa = dexa();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, privateKeyDexa);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(new String(cipher.doFinal(Base64.getDecoder().decode(it.next())), "UTF-8"));
            }
            String string = sb.toString();
            f1.dexa("RsaUtils", "decrypt data = " + string);
            return string;
        } catch (Exception e) {
            f1.dexb("RsaUtils", "decrypt error: " + e.getMessage());
            return null;
        }
    }

    public static PrivateKey dexa() {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2g/duaUwEmZ+OG1V56FkqOLP1cgoxXneup+3ebOQh90NiBEiV5Bln3Lsvw5nWWic2eyMTr4lReVnAUWY/Gq1Dj9f1wLTgT64I399j1NasccgFrVDhxaDHCuEGqXo6CgTy2v62610QUpA+OnoNxDjjZiG4DRVfcWCR5+WrbvERWuCjuJkg3Rmz0MMyKYiNqDz9N9OxHcfZU2h9tOwCuNMaGf4PSxNSUZYT9Glkra5j7qCJc5ZaN4TRlKOlY+1e9ff+/ZG5VsVJBlyrVyHZqLd5DwtxPM7KIspk8macGrSuBdruTE2WKd4dZUVYEUGLzPXZRVnkv69xMq/CaQjMgHONAgMBAAECggEAX1HOgJBnjiN5K+tkmbVaE+3nNnGnlx8CHGpBlZ+DCaYsP92C1x14k0C5Vfmutz8AKbjnmdlcOvvIfuNEJgLVqGpQXF2XWWrjtmjNL0MyFn+Z+jUI/9CJ5kntOeB7ICKpcPgkfP2w7dxgzs8VfWkUWNa3F3tlxSHeUHUvAnh/WBMfE4pLB27OIFMctXio7dgr28a/VDfnHx74OC7fiLVd7AoE0wXN8na/uuXm2HoNJN32asj2hvK54zxOgoBQ8LUgKOvGCUEtjQLikj0D5/CCiCKjpympHHiX15rOz0EMAjTTljhv309ne7HTsuMxNuN3JY40gqZfLP87Vx68sICTwQKBgQDj7xkaBXqzfyxCW7cffs7e08qyAh/3+0aIW4nCIxMS1XW5TqEc+He3od7ZoX63TwiPDW4YqxnkBwnrAmc5Gb8+kx/++/Vxt1CajBQWuL27oImyy7AQ8OtmtxYuquyPwnj27UDxLH9ruMtNxlYOO17l3dES5GzFH7zcKxK6EGTSMQKBgQDM/TGQ//sWqv0RRuXnyz+0R+h5jX046LFiUAZKuBjEBRELKQry6ngO8fiWh021aZaHiO+HZKAw5+9MtZMuMXACtl57dqNAgpNkqkdMV6wKW86MqvwpSkkqbgSemtxW1/4leqNV889FFOIDj52JPN+dlWERzu4pHPVyQCnMcrHkHQKBgQCp+j9E6Xskap0t60l3wlAxWc3Zy73dZ1SlEWZ9ET0DGY6OH3YErcJRffQ7ZbSirNycGY7V9Jr9MsaRrBwgN/QnjP4aX/kc0XDZn8bHXwOW7VRisoVdTNyvn696I9sAJi2hLzLz55QqWAe8u0CnolzVnQJyTUhUBKQJqFFx0hHtsQKBgQCUxCPWwY+t8cXbZgKv6BeBdLZIkOCSDn29haorS9PdXnfyC4VAqd0bq4vnYqaIw+pUzpJXRjXjiE9o8lWwLnzF2yhSndT4mkrxwYog43edxObvu59pL9pNiq6blHPYKsTs2kXzuQ9xaShlwTJpSN5YdPKPhAffmn6eveYX1B06GQKBgH4XyT0Ws/FvnhabQk50Evv2jtVa4v2NBlnMFkXj5PfN4lGNDNeZX0PK71NN4midYWsd53emLaMuqHtiQ7TZPUiuMDjDaykmIb0HPUW6NZlYSzA4EXseU3T0ggYhofFcHO5+BTE00DDrgVEbmxWBFrGXu9J2a36U5wjn3yk6X4MG")));
    }
}
