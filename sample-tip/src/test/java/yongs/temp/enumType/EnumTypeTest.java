package yongs.temp.enumType;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumTypeTest {
    @Test
    public void Season_검증하기() throws Exception {
        Season season = Season.WINTER;
        String ko = season.getKo();
        String color = season.getColor();

        assertThat(ko).isEqualTo("겨울");
        assertThat(color).isEqualTo("white");
    }

    @Test
    public void CalcuType_검증하기() throws Exception {
        CalcuType calcuType = CalcuType.Type_B;
        long testValue = 100000L;
        long result = calcuType.calcu(testValue);
        assertThat(result).isEqualTo(1000000L);
    }

    @Test
    public void PayType_검증하기() throws Exception {
        String code = "KAKAO_PAY";
        PayType payType = PayType.findByPayCode(code);

        assertThat(payType.name()).isEqualTo("CARD");
        assertThat(payType.getTitle()).isEqualTo("카드");
    }
}

