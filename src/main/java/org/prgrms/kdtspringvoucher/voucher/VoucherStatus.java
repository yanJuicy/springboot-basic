package org.prgrms.kdtspringvoucher.voucher;

public enum VoucherStatus {
    FIXED,
    PERCENT;

    public static VoucherStatus getVoucherStatus(String s) {
        switch (s) {
            case "fixed":
                return FIXED;
            case "percent":
                return PERCENT;
            default:
                return null;
        }
    }
}
