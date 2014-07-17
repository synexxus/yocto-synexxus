# Adapted from linux-imx.inc, copyright (C) 2013, 2014 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux kernel for Synexxus boards"

SRC_URI = "git://github.com/SynexxusJReep/linux-synexxus.git;branch=${SRCBRANCH} \
           file://defconfig"

LOCALVERSION = "-3.15.4+yocto"
SRCBRANCH = "3.15.x"
SRCREV = "a40be257d2bdf801dea921f5bc66a32caac8dab0"
DEPENDS += "lzop-native "
COMPATIBLE_MACHINE = "(mx6)"
COMPATIBLE_MACHINE = "(aristeus)"
