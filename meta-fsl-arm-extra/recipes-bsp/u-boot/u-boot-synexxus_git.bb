require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=ebafed481faf3c293f94cb69f160d63447d80aa"
COMPATIBLE_MACHINE = "(aristeus)"

PROVIDES = "u-boot"

SRCREV = "00d135f1dba3f9cfb78ef4f5cc162166037a3b89"
SRC_URI = "git://github.com/SynexxusJReep/u-boot-synexxus.git;branch=master"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
