
void FUN_000c1fd8(undefined1 *param_1)

{
  ulong uVar1;
  ulong uVar2;
  long *plVar3;
  undefined1 in_ZR;
  long lVar4;
  ulong uVar5;
  long lVar6;
  ulong uVar7;
  long *extraout_x9;
  ulong uVar8;
  ulong extraout_x10;
  ulong extraout_x11;
  long *plVar9;
  long lVar10;
  ulong uVar11;
  ulong uVar12;
  undefined1 auVar13 [16];
  undefined1 auVar14 [16];
  
  lVar4 = FUN_000d2b14(*param_1);
  uVar7 = extraout_x10;
  plVar3 = extraout_x9;
  if ((bool)in_ZR) {
    plVar3 = (long *)(lVar4 + 1);
    uVar7 = extraout_x11;
  }
  if (uVar7 < 0x21) {
    if (uVar7 < 0x11) {
      if (uVar7 < 9) {
        if (3 < uVar7) {
          uVar5 = (ulong)*(uint *)((long)plVar3 + (uVar7 - 4));
          lVar4 = uVar7 + (uint)((int)*plVar3 << 3);
          goto LAB_000c22bc;
        }
        uVar5 = 0x9ae16a3b2f90404f;
        if (uVar7 != 0) {
          uVar7 = (uVar7 + (ulong)*(byte *)((long)plVar3 + (uVar7 - 1)) * 4) * -0x36b62838af619aa9 ^
                  (ulong)CONCAT11(*(undefined1 *)((long)plVar3 + (uVar7 >> 1)),(char)*plVar3) *
                  -0x651e95c4d06fbfb1;
          uVar5 = (uVar7 ^ uVar7 >> 0x2f) * -0x651e95c4d06fbfb1;
        }
      }
      else {
        uVar11 = *(ulong *)((long)plVar3 + (uVar7 - 8));
        uVar5 = uVar11 + uVar7;
        uVar5 = FUN_000c2480(*plVar3,uVar5 << ((ulong)(uint)-(int)uVar7 & 0x3f) |
                                     uVar5 >> (uVar7 & 0x3f));
        uVar5 = uVar5 ^ uVar11;
      }
LAB_000c2108:
      FUN_000cfdf0(uVar5);
      return;
    }
    lVar10 = *(long *)((long)plVar3 + (uVar7 - 8));
    uVar5 = plVar3[1] ^ 0xc949d7c7509e6557;
    uVar11 = *plVar3 * -0x4b6d499041670d8d - plVar3[1];
    lVar4 = (uVar11 >> 0x2b | uVar11 * 0x200000) +
            *(long *)((long)plVar3 + (uVar7 - 0x10)) * -0x3c5a37a36834ced9 +
            (lVar10 * -0x41befec400000000 | (ulong)(lVar10 * -0x651e95c4d06fbfb1) >> 0x1e);
    uVar5 = *plVar3 * -0x4b6d499041670d8d + uVar7 + lVar10 * 0x651e95c4d06fbfb1 +
            (uVar5 >> 0x14 | uVar5 << 0x2c);
  }
  else {
    if (uVar7 < 0x41) {
      lVar10 = *(long *)((long)plVar3 + (uVar7 - 0x10));
      lVar6 = plVar3[3];
      uVar8 = *plVar3 + (lVar10 + uVar7) * -0x3c5a37a36834ced9;
      uVar5 = uVar8 + plVar3[1];
      uVar11 = *(long *)((long)plVar3 + (uVar7 - 0x20)) + plVar3[2];
      uVar12 = uVar5 + plVar3[2];
      lVar4 = *(long *)((long)plVar3 + (uVar7 - 8)) + lVar6;
      uVar1 = lVar4 + uVar11;
      uVar7 = *(long *)((long)plVar3 + (uVar7 - 0x18)) + uVar11;
      uVar2 = uVar7 + lVar10;
      lVar10 = (uVar5 >> 7 | uVar5 << 0x39) + (uVar8 >> 0x25 | uVar8 * 0x8000000) +
               (uVar8 + lVar6 >> 0x34 | (uVar8 + lVar6) * 0x1000) +
               (uVar12 >> 0x1f | uVar12 << 0x21);
      uVar7 = (uVar2 + lVar4 + lVar10) * -0x3c5a37a36834ced9 +
              (uVar12 + lVar6 + (uVar11 >> 0x25 | uVar11 * 0x8000000) + (uVar7 >> 7 | uVar7 << 0x39)
               + (uVar1 >> 0x34 | uVar1 * 0x1000) + (uVar2 >> 0x1f | uVar2 << 0x21)) *
              -0x651e95c4d06fbfb1;
      uVar7 = lVar10 + (uVar7 ^ uVar7 >> 0x2f) * -0x3c5a37a36834ced9;
      uVar5 = (uVar7 ^ uVar7 >> 0x2f) * -0x651e95c4d06fbfb1;
      goto LAB_000c2108;
    }
    lVar4 = *(long *)((long)plVar3 + (uVar7 - 0x28));
    uVar5 = *(long *)((long)plVar3 + (uVar7 - 0x38)) + *(long *)((long)plVar3 + (uVar7 - 0x10));
    uVar11 = FUN_000c2480(*(long *)((long)plVar3 + (uVar7 - 0x30)) + uVar7,
                          *(undefined8 *)((long)plVar3 + (uVar7 - 0x18)));
    auVar13 = FUN_000c24b0((long)plVar3 + (uVar7 - 0x40),uVar7,uVar11);
    auVar14 = FUN_000c24b0((long)plVar3 + (uVar7 - 0x20),uVar5 + 0xb492b66fbe98f273,lVar4);
    plVar9 = plVar3 + 4;
    lVar10 = *plVar3 + lVar4 * -0x4b6d499041670d8d;
    lVar4 = -(uVar7 - 1 & 0xffffffffffffffc0);
    do {
      uVar7 = lVar10 + auVar13._0_8_ + uVar5 + plVar9[-3];
      uVar12 = (uVar7 >> 0x25 | uVar7 * 0x8000000) * -0x4b6d499041670d8d ^ auVar14._8_8_;
      uVar7 = uVar5 + auVar13._8_8_ + plVar9[2];
      uVar11 = uVar11 + auVar14._0_8_;
      lVar10 = (uVar11 >> 0x21 | uVar11 * 0x80000000) * -0x4b6d499041670d8d;
      uVar5 = plVar9[1] + auVar13._0_8_ + (uVar7 >> 0x2a | uVar7 * 0x400000) * -0x4b6d499041670d8d;
      auVar13 = FUN_000c24b0(plVar9 + -4,auVar13._8_8_ * -0x4b6d499041670d8d,uVar12 + auVar14._0_8_)
      ;
      auVar14 = FUN_000c24b0(plVar9,lVar10 + auVar14._8_8_,uVar5 + plVar9[-2]);
      lVar4 = lVar4 + 0x40;
      plVar9 = plVar9 + 8;
      uVar11 = uVar12;
    } while (lVar4 != 0);
    lVar4 = FUN_000c2480(auVar13._0_8_,auVar14._0_8_);
    lVar4 = uVar12 + (uVar5 ^ uVar5 >> 0x2f) * -0x4b6d499041670d8d + lVar4;
    lVar6 = FUN_000c2480(auVar13._8_8_,auVar14._8_8_);
    uVar5 = lVar6 + lVar10;
  }
LAB_000c22bc:
  FUN_000cfdf0(lVar4,uVar5);
  FUN_000c2480();
  return;
}

