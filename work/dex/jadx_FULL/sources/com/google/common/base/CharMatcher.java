package com.google.common.base;

import com.aliyun.vod.common.utils.IOUtils;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class CharMatcher implements Predicate<Character> {
    public static final int K = 65536;

    public static abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.CharMatcher
        public CharMatcher F() {
            return new v(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher J() {
            return this;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }
    }

    public static abstract class NamedFastMatcher extends FastMatcher {
        public final String f;

        public NamedFastMatcher(String str) {
            this.f = (String) com.google.common.base.i.E(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.f;
        }
    }

    public class a extends v {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
            super(charMatcher2);
            this.f = str;
        }

        @Override // com.google.common.base.CharMatcher.u, com.google.common.base.CharMatcher
        public String toString() {
            return this.f;
        }
    }

    @VisibleForTesting
    public static final class a0 extends NamedFastMatcher {
        public static final int L = 1682554634;
        public static final int M = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f31549a = new a0();
        public static final String g = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        public a0() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return g.charAt((L * c) >>> M) == c;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            for (int i = 0; i < 32; i++) {
                bitSet.set(g.charAt(i));
            }
        }
    }

    public static final class b extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharMatcher f31550a;
        public final CharMatcher b;

        public b(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f31550a = (CharMatcher) com.google.common.base.i.E(charMatcher);
            this.b = (CharMatcher) com.google.common.base.i.E(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return this.f31550a.B(c) && this.b.B(c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f31550a.Q(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.b.Q(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strValueOf = String.valueOf(this.f31550a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 19 + strValueOf2.length());
            sb.append("CharMatcher.and(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c extends NamedFastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f31551a = new c();

        public c() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public int A(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean C(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean E(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher F() {
            return CharMatcher.G();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher I(CharMatcher charMatcher) {
            com.google.common.base.i.E(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String M(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String N(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        @Override // com.google.common.base.CharMatcher
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String U(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return (CharMatcher) com.google.common.base.i.E(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String h(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        @Override // com.google.common.base.CharMatcher
        public int i(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int n(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int o(CharSequence charSequence, int i) {
            int length = charSequence.length();
            com.google.common.base.i.d0(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }
    }

    public static final class d extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char[] f31552a;

        public d(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f31552a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Arrays.binarySearch(this.f31552a, c) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            for (char c : this.f31552a) {
                bitSet.set(c);
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.f31552a) {
                sb.append(CharMatcher.R(c));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class e extends NamedFastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f31553a = new e();

        public e() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return c <= 127;
        }
    }

    @GwtIncompatible
    public static final class f extends NamedFastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitSet f31554a;

        public /* synthetic */ f(BitSet bitSet, String str, a aVar) {
            this(bitSet, str);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return this.f31554a.get(c);
        }

        @Override // com.google.common.base.CharMatcher
        public void Q(BitSet bitSet) {
            bitSet.or(this.f31554a);
        }

        public f(BitSet bitSet, String str) {
            super(str);
            this.f31554a = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }
    }

    public static final class g extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CharMatcher f31555a = new g();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            if (c != ' ' && c != 133 && c != 5760) {
                if (c == 8199) {
                    return false;
                }
                if (c != 8287 && c != 12288 && c != 8232 && c != 8233) {
                    switch (c) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c >= 8192 && c <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class h extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f31556a = new h();
        public static final String g = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        public h() {
            super("CharMatcher.digit()", Z(), Y());
        }

        public static char[] Y() {
            char[] cArr = new char[37];
            for (int i = 0; i < 37; i++) {
                cArr[i] = (char) (g.charAt(i) + '\t');
            }
            return cArr;
        }

        public static char[] Z() {
            return g.toCharArray();
        }
    }

    public static final class i extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super Character> f31557a;

        public i(Predicate<? super Character> predicate) {
            this.f31557a = (Predicate) com.google.common.base.i.E(predicate);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return this.f31557a.apply(Character.valueOf(c));
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean apply(Character ch) {
            return this.f31557a.apply(com.google.common.base.i.E(ch));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strValueOf = String.valueOf(this.f31557a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
            sb.append("CharMatcher.forPredicate(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class j extends FastMatcher {
        public final char e;
        public final char f;

        public j(char c, char c2) {
            com.google.common.base.i.d(c2 >= c);
            this.e = c;
            this.f = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return this.e <= c && c <= this.f;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.e, this.f + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strR = CharMatcher.R(this.e);
            String strR2 = CharMatcher.R(this.f);
            StringBuilder sb = new StringBuilder(String.valueOf(strR).length() + 27 + String.valueOf(strR2).length());
            sb.append("CharMatcher.inRange('");
            sb.append(strR);
            sb.append("', '");
            sb.append(strR2);
            sb.append("')");
            return sb.toString();
        }
    }

    public static final class k extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f31558a = new k();
        public static final String g = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";
        public static final String h = "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";

        public k() {
            super("CharMatcher.invisible()", g.toCharArray(), h.toCharArray());
        }
    }

    public static final class l extends FastMatcher {
        public final char e;

        public l(char c) {
            this.e = c;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return c == this.e;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher F() {
            return CharMatcher.s(this.e);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher I(CharMatcher charMatcher) {
            return charMatcher.B(this.e) ? charMatcher : super.I(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String N(CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.e, c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.e);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.B(this.e) ? this : CharMatcher.G();
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strR = CharMatcher.R(this.e);
            StringBuilder sb = new StringBuilder(String.valueOf(strR).length() + 18);
            sb.append("CharMatcher.is('");
            sb.append(strR);
            sb.append("')");
            return sb.toString();
        }
    }

    public static final class m extends FastMatcher {
        public final char e;
        public final char f;

        public m(char c, char c2) {
            this.e = c;
            this.f = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return c == this.e || c == this.f;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(this.e);
            bitSet.set(this.f);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strR = CharMatcher.R(this.e);
            String strR2 = CharMatcher.R(this.f);
            StringBuilder sb = new StringBuilder(String.valueOf(strR).length() + 21 + String.valueOf(strR2).length());
            sb.append("CharMatcher.anyOf(\"");
            sb.append(strR);
            sb.append(strR2);
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class n extends FastMatcher {
        public final char e;

        public n(char c) {
            this.e = c;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return c != this.e;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher F() {
            return CharMatcher.q(this.e);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher I(CharMatcher charMatcher) {
            return charMatcher.B(this.e) ? CharMatcher.c() : this;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            bitSet.set(0, this.e);
            bitSet.set(this.e + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.B(this.e) ? super.b(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strR = CharMatcher.R(this.e);
            StringBuilder sb = new StringBuilder(String.valueOf(strR).length() + 21);
            sb.append("CharMatcher.isNot('");
            sb.append(strR);
            sb.append("')");
            return sb.toString();
        }
    }

    public static final class o extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f31559a = new o();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class p extends NamedFastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f31560a = new p();

        public p() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    public static final class q extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f31561a = new q();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class r extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f31562a = new r();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class s extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f31563a = new s();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class t extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f31564a = new t();

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static class u extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharMatcher f31565a;

        public u(CharMatcher charMatcher) {
            this.f31565a = (CharMatcher) com.google.common.base.i.E(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return !this.f31565a.B(c);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean C(CharSequence charSequence) {
            return this.f31565a.E(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean E(CharSequence charSequence) {
            return this.f31565a.C(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher F() {
            return this.f31565a;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f31565a.Q(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public int i(CharSequence charSequence) {
            return charSequence.length() - this.f31565a.i(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strValueOf = String.valueOf(this.f31565a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
            sb.append(strValueOf);
            sb.append(".negate()");
            return sb.toString();
        }
    }

    public static class v extends u {
        public v(CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher J() {
            return this;
        }
    }

    public static final class w extends NamedFastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f31566a = new w();

        public w() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public int A(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean C(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean E(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher F() {
            return CharMatcher.c();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher I(CharMatcher charMatcher) {
            return (CharMatcher) com.google.common.base.i.E(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String M(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String N(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String O(CharSequence charSequence, CharSequence charSequence2) {
            com.google.common.base.i.E(charSequence2);
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String U(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String V(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String W(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            com.google.common.base.i.E(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String h(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int i(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int n(CharSequence charSequence) {
            com.google.common.base.i.E(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int o(CharSequence charSequence, int i) {
            com.google.common.base.i.d0(i, charSequence.length());
            return -1;
        }
    }

    public static final class x extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharMatcher f31567a;
        public final CharMatcher b;

        public x(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f31567a = (CharMatcher) com.google.common.base.i.E(charMatcher);
            this.b = (CharMatcher) com.google.common.base.i.E(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            return this.f31567a.B(c) || this.b.B(c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void Q(BitSet bitSet) {
            this.f31567a.Q(bitSet);
            this.b.Q(bitSet);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String strValueOf = String.valueOf(this.f31567a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 18 + strValueOf2.length());
            sb.append("CharMatcher.or(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class y extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char[] f31568a;
        public final char[] b;
        public final String f;

        public y(String str, char[] cArr, char[] cArr2) {
            this.f = str;
            this.f31568a = cArr;
            this.b = cArr2;
            com.google.common.base.i.d(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                com.google.common.base.i.d(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    com.google.common.base.i.d(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean B(char c) {
            int iBinarySearch = Arrays.binarySearch(this.f31568a, c);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i = (~iBinarySearch) - 1;
            return i >= 0 && c <= this.b[i];
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f;
        }
    }

    public static final class z extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f31569a = new z();

        public z() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    public static CharMatcher G() {
        return w.f31566a;
    }

    public static CharMatcher H(CharSequence charSequence) {
        return d(charSequence).F();
    }

    @GwtIncompatible
    public static CharMatcher L(int i2, BitSet bitSet, String str) {
        if (i2 == 0) {
            return G();
        }
        if (i2 == 1) {
            return q((char) bitSet.nextSetBit(0));
        }
        if (i2 != 2) {
            return t(i2, bitSet.length()) ? com.google.common.base.j.a0(bitSet, str) : new f(bitSet, str, null);
        }
        char cNextSetBit = (char) bitSet.nextSetBit(0);
        return r(cNextSetBit, (char) bitSet.nextSetBit(cNextSetBit + 1));
    }

    public static String R(char c2) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static CharMatcher S() {
        return z.f31569a;
    }

    public static CharMatcher X() {
        return a0.f31549a;
    }

    public static CharMatcher c() {
        return c.f31551a;
    }

    public static CharMatcher d(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return G();
        }
        if (length != 1) {
            return length != 2 ? new d(charSequence) : r(charSequence.charAt(0), charSequence.charAt(1));
        }
        return q(charSequence.charAt(0));
    }

    public static CharMatcher f() {
        return e.f31553a;
    }

    public static CharMatcher g() {
        return g.f31555a;
    }

    @Deprecated
    public static CharMatcher j() {
        return h.f31556a;
    }

    public static CharMatcher l(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new i(predicate);
    }

    public static CharMatcher m(char c2, char c3) {
        return new j(c2, c3);
    }

    @Deprecated
    public static CharMatcher p() {
        return k.f31558a;
    }

    public static CharMatcher q(char c2) {
        return new l(c2);
    }

    public static m r(char c2, char c3) {
        return new m(c2, c3);
    }

    public static CharMatcher s(char c2) {
        return new n(c2);
    }

    @GwtIncompatible
    public static boolean t(int i2, int i3) {
        return i2 <= 1023 && i3 > (i2 * 4) * 16;
    }

    @Deprecated
    public static CharMatcher u() {
        return o.f31559a;
    }

    public static CharMatcher v() {
        return p.f31560a;
    }

    @Deprecated
    public static CharMatcher w() {
        return q.f31561a;
    }

    @Deprecated
    public static CharMatcher x() {
        return r.f31562a;
    }

    @Deprecated
    public static CharMatcher y() {
        return s.f31563a;
    }

    @Deprecated
    public static CharMatcher z() {
        return t.f31564a;
    }

    public int A(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (B(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean B(char c2);

    public boolean C(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean D(CharSequence charSequence) {
        return !E(charSequence);
    }

    public boolean E(CharSequence charSequence) {
        return n(charSequence) == -1;
    }

    public CharMatcher F() {
        return new u(this);
    }

    public CharMatcher I(CharMatcher charMatcher) {
        return new x(this, charMatcher);
    }

    public CharMatcher J() {
        return com.google.common.base.h.j(this);
    }

    @GwtIncompatible
    public CharMatcher K() {
        String strConcat;
        BitSet bitSet = new BitSet();
        Q(bitSet);
        int iCardinality = bitSet.cardinality();
        if (iCardinality * 2 <= 65536) {
            return L(iCardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i2 = 65536 - iCardinality;
        String string = toString();
        if (string.endsWith(".negate()")) {
            strConcat = string.substring(0, string.length() - 9);
        } else {
            strConcat = ".negate()".length() != 0 ? string.concat(".negate()") : new String(string);
        }
        return new a(this, L(i2, bitSet, strConcat), string);
    }

    public String M(CharSequence charSequence) {
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i2 = 1;
        while (true) {
            iN++;
            while (iN != charArray.length) {
                if (B(charArray[iN])) {
                    i2++;
                } else {
                    charArray[iN - i2] = charArray[iN];
                    iN++;
                }
            }
            return new String(charArray, 0, iN - i2);
        }
    }

    public String N(CharSequence charSequence, char c2) {
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iN] = c2;
        while (true) {
            iN++;
            if (iN >= charArray.length) {
                return new String(charArray);
            }
            if (B(charArray[iN])) {
                charArray[iN] = c2;
            }
        }
    }

    public String O(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return M(charSequence);
        }
        int i2 = 0;
        if (length == 1) {
            return N(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int iN = n(string);
        if (iN == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) string, i2, iN);
            sb.append(charSequence2);
            i2 = iN + 1;
            iN = o(string, i2);
        } while (iN != -1);
        sb.append((CharSequence) string, i2, length2);
        return sb.toString();
    }

    public String P(CharSequence charSequence) {
        return F().M(charSequence);
    }

    @GwtIncompatible
    public void Q(BitSet bitSet) {
        for (int i2 = 65535; i2 >= 0; i2--) {
            if (B((char) i2)) {
                bitSet.set(i2);
            }
        }
    }

    public String T(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < length && B(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = i2;
        while (i4 > i3 && B(charSequence.charAt(i4))) {
            i4--;
        }
        if (i3 == 0 && i4 == i2) {
            return h(charSequence, c2);
        }
        int i5 = i4 + 1;
        return k(charSequence, i3, i5, c2, new StringBuilder(i5 - i3), false);
    }

    public String U(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && B(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = length - 1;
        while (i3 > i2 && B(charSequence.charAt(i3))) {
            i3--;
        }
        return charSequence.subSequence(i2, i3 + 1).toString();
    }

    public String V(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!B(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, length).toString();
            }
        }
        return "";
    }

    public String W(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!B(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new b(this, charMatcher);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    /* JADX INFO: renamed from: e */
    public boolean apply(Character ch) {
        return B(ch.charValue());
    }

    public String h(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (B(cCharAt)) {
                if (cCharAt != c2 || (i2 != length - 1 && B(charSequence.charAt(i2 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i2);
                    sb.append(c2);
                    return k(charSequence, i2 + 1, length, c2, sb, true);
                }
                i2++;
            }
            i2++;
        }
        return charSequence.toString();
    }

    public int i(CharSequence charSequence) {
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (B(charSequence.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public final String k(CharSequence charSequence, int i2, int i3, char c2, StringBuilder sb, boolean z2) {
        while (i2 < i3) {
            char cCharAt = charSequence.charAt(i2);
            if (!B(cCharAt)) {
                sb.append(cCharAt);
                z2 = false;
            } else if (!z2) {
                sb.append(c2);
                z2 = true;
            }
            i2++;
        }
        return sb.toString();
    }

    public int n(CharSequence charSequence) {
        return o(charSequence, 0);
    }

    public int o(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        com.google.common.base.i.d0(i2, length);
        while (i2 < length) {
            if (B(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String toString() {
        return super.toString();
    }
}
