package org.prgrms.kdtspringvoucher;

import org.prgrms.kdtspringvoucher.io.Console;
import org.prgrms.kdtspringvoucher.io.Input;
import org.prgrms.kdtspringvoucher.io.Output;
import org.prgrms.kdtspringvoucher.voucher.FixedAmountVoucher;
import org.prgrms.kdtspringvoucher.voucher.PercentAmountVoucher;
import org.prgrms.kdtspringvoucher.voucher.Voucher;
import org.prgrms.kdtspringvoucher.voucher.VoucherService;
import org.prgrms.kdtspringvoucher.voucher.VoucherStatus;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.UUID;

public class CommandLineApplication {

    public static void main(String[] args) {
        new CommandLineApplication().run();
    }

    public void run() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        VoucherService voucherService = context.getBean(VoucherService.class);
        Console console = new Console();

        boolean isExit = false;
        while (!isExit) {
            showMenu(console);
            Command command = Command.getCommand(inputCommand(console));
            switch (command) {
                case EXIT:
                    isExit = true;
                    break;
                case CREATE:
                    createVoucher(console, console, voucherService);
                    break;
                case LIST:
                    showPresentVoucherList(console, voucherService);
                    break;
                default:
                    console.output("잘못된 입력!");
                    break;
            }
        }
    }

    private void showPresentVoucherList(Output output, VoucherService voucherService) {
        List<Voucher> vouchers = voucherService.getVouchers();
        for (Voucher voucher : vouchers) {
            output.output(voucher.toString());
        }
    }

    private void createVoucher(Input input, Output output,  VoucherService voucherService) {
        String cmd = input.inputCommand("Type fixed or percent: ");

        VoucherStatus voucherStatus = VoucherStatus.getVoucherStatus(cmd);
        switch (voucherStatus) {
            case FIXED:
                voucherService.save(new FixedAmountVoucher(UUID.randomUUID(), 100));
                break;
            case PERCENT:
                voucherService.save(new PercentAmountVoucher(UUID.randomUUID(), 50));
                break;
            default:
                output.output("잘못된 입력! fixed or percent 입력");
                break;
        }
    }

    private String inputCommand(Input console) {
        return console.inputCommand("명령어 입력: ");
    }

    private void showMenu(Output out) {
        out.output("=== Voucher Program ===\n" +
                "Type exit to exit the program.\n" +
                "Type create to create a new voucher.\n" +
                "Type list to list all vouchers.");
    }
}
