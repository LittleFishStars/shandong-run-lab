
void FUN_0007c9f8(long *param_1)

{
  long lVar1;
  byte bVar2;
  char cVar3;
  char cVar4;
  bool bVar5;
  int iVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  int extraout_w8;
  int extraout_w8_00;
  int extraout_w8_01;
  int extraout_w8_02;
  undefined4 extraout_w8_03;
  int extraout_w8_04;
  int extraout_w8_05;
  undefined4 uVar9;
  undefined4 extraout_w8_06;
  uint extraout_w9;
  uint extraout_w9_00;
  uint extraout_w9_01;
  uint extraout_w9_02;
  int extraout_w10;
  int extraout_w10_00;
  int extraout_w10_01;
  uint uVar10;
  ulong uVar11;
  int iVar12;
  
  iVar6 = *(int *)((long)param_1 + 0xc);
  lVar1 = (long)iVar6 + 1;
  iVar12 = (int)lVar1;
  *(int *)((long)param_1 + 0xc) = iVar12;
  if (*(char *)(*param_1 + (long)iVar6) == '0') {
    bVar2 = *(byte *)(*param_1 + lVar1);
    uVar7 = FUN_0007ce0c(param_1,bVar2,iVar6 + 2);
    iVar6 = 1;
    if ((bVar2 & 0x80) != 0) {
      iVar6 = (bVar2 & 0x7f) + 1;
    }
    iVar6 = iVar6 + iVar12;
    *(int *)((long)param_1 + 0xc) = iVar6;
    if (iVar6 + (int)uVar7 <= (int)param_1[1]) {
      FUN_000d8520(uVar7,6,s_contentType_0001556d);
      uVar7 = FUN_0007ce54();
      if ((int)uVar7 != -1) {
        *(int *)((long)param_1 + 0xc) = (int)uVar7 + *(int *)((long)param_1 + 0xc) + 1;
        FUN_000d8520(uVar7,0x30,s_content__optional__0001427e);
        iVar6 = 1;
        if ((extraout_w9 & 0x80) != 0) {
          iVar6 = (extraout_w9 & 0x7f) + 1;
        }
        *(int *)((long)param_1 + 0xc) = iVar6 + extraout_w8;
        uVar7 = FUN_0007ce54();
        if ((int)uVar7 != -1) {
          iVar6 = FUN_000d4c90(uVar7,2,s_version_00014291,1);
          cVar3 = SCARRY4(iVar6,1);
          cVar4 = iVar6 + 1 < 0;
          bVar5 = iVar6 == -1;
          if ((!bVar5) && (uVar7 = FUN_000d1d18(), bVar5 || cVar4 != cVar3)) {
            iVar6 = FUN_000d2504(uVar7,0x31,s_DigestAlgorithms_000148f3,1);
            cVar3 = SCARRY4(iVar6,1);
            cVar4 = iVar6 + 1 < 0;
            bVar5 = iVar6 == -1;
            if ((!bVar5) && (uVar7 = FUN_000d1d18(), bVar5 || cVar4 != cVar3)) {
              iVar6 = FUN_000d2504(uVar7,0x30,s_contentInfo_00015da6,1);
              cVar3 = SCARRY4(iVar6,1);
              cVar4 = iVar6 + 1 < 0;
              bVar5 = iVar6 == -1;
              if ((!bVar5) && (FUN_000d496c(), bVar5 || cVar4 != cVar3)) {
                uVar7 = FUN_000d6960();
                iVar6 = extraout_w8_00;
                iVar12 = extraout_w10;
                if (extraout_w10 == 0xa0) {
                  uVar7 = FUN_000d6344((long)extraout_w8_00);
                  iVar6 = 1;
                  if ((extraout_w9_00 & 0x80) != 0) {
                    iVar6 = (extraout_w9_00 & 0x7f) + 1;
                  }
                  iVar6 = FUN_000d2504(iVar6 + extraout_w8_01,uVar7,0x30,
                                       s_certificates__optional__00015bcb,1);
                  cVar3 = SCARRY4(iVar6,1);
                  cVar4 = iVar6 + 1 < 0;
                  bVar5 = iVar6 == -1;
                  if ((bVar5) || (FUN_000d1d18(), !bVar5 && cVar4 == cVar3)) goto LAB_0007cb30;
                  param_1[4] = param_1[3];
                  uVar7 = FUN_0007ce54(param_1,0x30,s_tbsCertificate_00015a5b,2);
                  if (((int)uVar7 == -1) ||
                     ((int)param_1[1] < *(int *)((long)param_1 + 0xc) + (int)uVar7))
                  goto LAB_0007cb30;
                  param_1[5] = param_1[3];
                  if ((*(byte *)(*param_1 + (long)*(int *)((long)param_1 + 0xc)) & 0xdf) == 0x80) {
                    uVar7 = FUN_000d6344();
                    iVar6 = 1;
                    if ((extraout_w9_01 & 0x80) != 0) {
                      iVar6 = (extraout_w9_01 & 0x7f) + 1;
                    }
                    iVar6 = FUN_000d2504(iVar6 + extraout_w8_02,uVar7,2,s_version_00014291,3);
                    cVar3 = SCARRY4(iVar6,1);
                    cVar4 = iVar6 + 1 < 0;
                    bVar5 = iVar6 == -1;
                    if ((bVar5) || (uVar7 = FUN_000d1d18(), !bVar5 && cVar4 == cVar3))
                    goto LAB_0007cb30;
                    *(undefined4 *)((long)param_1 + 0xc) = extraout_w8_03;
                  }
                  for (uVar11 = 2; uVar11 != 0xb; uVar11 = uVar11 + 1) {
                    uVar8 = 2;
                    switch((int)uVar11) {
                    case 2:
                      break;
                    default:
                      uVar8 = 0x30;
                      break;
                    case 8:
                      uVar8 = 0xa1;
                      break;
                    case 9:
                      uVar8 = 0xa2;
                      break;
                    case 10:
                      uVar8 = 0xa3;
                    }
                    uVar7 = FUN_000d4c90(uVar7,uVar8,*(undefined8 *)(uVar11 * 8 + 0xe0d58),3);
                    iVar6 = (int)uVar7;
                    if (uVar11 < 8 && iVar6 == -1) goto LAB_0007cb30;
                    if (iVar6 != -1) {
                      *(int *)((long)param_1 + 0xc) = *(int *)((long)param_1 + 0xc) + iVar6;
                    }
                  }
                  iVar6 = FUN_000d4c90(uVar7,0x30,s_signatureAlgorithm_00013eaa,2);
                  cVar3 = SCARRY4(iVar6,1);
                  cVar4 = iVar6 + 1 < 0;
                  bVar5 = iVar6 == -1;
                  if ((bVar5) || (uVar7 = FUN_000d1d18(), !bVar5 && cVar4 == cVar3))
                  goto LAB_0007cb30;
                  iVar6 = FUN_000d2504(uVar7,3,s_signatureValue_000134f4,2);
                  cVar3 = SCARRY4(iVar6,1);
                  cVar4 = iVar6 + 1 < 0;
                  bVar5 = iVar6 == -1;
                  if ((bVar5) || (FUN_000d496c(), !bVar5 && cVar4 == cVar3)) goto LAB_0007cb30;
                  uVar7 = FUN_000d6960();
                  iVar6 = extraout_w8_04;
                  iVar12 = extraout_w10_00;
                }
                if (iVar12 == 0xa1) {
                  uVar7 = FUN_000d6344((long)iVar6);
                  iVar6 = 1;
                  if ((extraout_w9_02 & 0x80) != 0) {
                    iVar6 = (extraout_w9_02 & 0x7f) + 1;
                  }
                  iVar6 = FUN_000d2504(iVar6 + extraout_w8_05,uVar7,0x30,s_crls__optional__00015a4b,
                                       1);
                  cVar3 = SCARRY4(iVar6,1);
                  cVar4 = iVar6 + 1 < 0;
                  bVar5 = iVar6 == -1;
                  if ((bVar5) || (FUN_000d496c(), !bVar5 && cVar4 == cVar3)) goto LAB_0007cb30;
                  uVar7 = FUN_000d6960();
                  iVar12 = extraout_w10_01;
                }
                if (iVar12 == 0x31) {
                  iVar6 = FUN_000d4c90(uVar7,0x31,s_signerInfos_0001440a,1);
                  cVar3 = SCARRY4(iVar6,1);
                  cVar4 = iVar6 + 1 < 0;
                  bVar5 = iVar6 == -1;
                  if ((!bVar5) && (uVar7 = FUN_000d1d18(), bVar5 || cVar4 != cVar3)) {
                    iVar6 = FUN_000d4c90(uVar7,0x30,s_signerInfo_00015887,2);
                    cVar3 = SCARRY4(iVar6,1);
                    cVar4 = iVar6 + 1 < 0;
                    bVar5 = iVar6 == -1;
                    if ((!bVar5) && (uVar7 = FUN_000d1d18(), bVar5 || cVar4 != cVar3)) {
                      param_1[6] = param_1[3];
                      for (uVar11 = 0; uVar11 != 7; uVar11 = uVar11 + 1) {
                        uVar10 = (uint)uVar11;
                        uVar9 = (undefined4)(0xa10430a0303002 >> ((uVar11 & 7) << 3));
                        if (6 < uVar10) {
                          uVar9 = 0x30;
                        }
                        uVar7 = FUN_000d4c90(uVar7,uVar9,*(undefined8 *)(uVar11 * 8 + 0xe0d20),3);
                        iVar6 = (int)uVar7;
                        cVar3 = SCARRY4(iVar6,1);
                        cVar4 = iVar6 + 1 < 0;
                        bVar5 = iVar6 == -1;
                        if ((bVar5) || (uVar7 = FUN_000d1d18(), !bVar5 && cVar4 == cVar3)) {
                          if (uVar10 != 3 && uVar10 != 6) break;
                        }
                        else {
                          *(undefined4 *)((long)param_1 + 0xc) = extraout_w8_06;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
LAB_0007cb30:
  FUN_000cff00();
  return;
}

