#!/bin/sh
# 本机 /etc/ssh/ssh_config.d/*.conf 属主是 nobody，openssh 会直接拒绝；
# 用一个空目录盖住它、再用 /dev/null 盖住 ssh_config，才能连上 GitHub。
# 用法：GIT_SSH_COMMAND="$PWD/scripts/git-ssh-wrap.sh" git push origin main
EMPTY="$(cd "$(dirname "$0")/.." && pwd)/.ssh-empty"
mkdir -p "$EMPTY"
exec bwrap --dev-bind / / \
  --ro-bind /dev/null /etc/ssh/ssh_config \
  --ro-bind "$EMPTY" /etc/ssh/ssh_config.d \
  -- ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no "$@"
