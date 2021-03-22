package yongs.temp.enumType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayType {
    CASH("현금", Arrays.asList("ACCOUNT_TRANSFER", "REMITTANCE", "ON_SITE_PAYMENT")),
    CARD("카드", Arrays.asList("PAYCO", "CARD", "KAKAO_PAY")),
    ETC("기타", Arrays.asList("POINT", "COUPON")),
    EMPTY("없음", Collections.EMPTY_LIST);

    private String title;
    private List<String> payList;

    PayType(String title, List<String> payList) {
        this.title = title;
        this.payList = payList;
    }

    //  code 값에 따라서 PayType을 알수 있다.
    public static PayType findByPayCode(String code) {
        return Arrays.stream(PayType.values())
                .filter(payType -> payType.hasPayType(code))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayType(String code) {
        return payList.stream().anyMatch(pay -> pay.equals(code));
    }

    public String getTitle() {
        return title;
    }
}
