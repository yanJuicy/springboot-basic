package org.prgrms.kdtspringvoucher;

import org.prgrms.kdtspringvoucher.voucher.MemoryVoucherRepository;
import org.prgrms.kdtspringvoucher.voucher.VoucherRepository;
import org.prgrms.kdtspringvoucher.voucher.VoucherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public VoucherRepository voucherRepository() {
        return new MemoryVoucherRepository();
    }

    @Bean
    public VoucherService voucherService() {
        return new VoucherService(voucherRepository());
    }

}
