package yongs.temp.enumType;

public enum Season {
    SPRING("봄", "green"),
    SUMMER("여름", "blue"),
    AUTUMN("가을", "yellow"),
    WINTER("겨울", "white");

    private String ko;
    private String color;

    Season(String ko, String color) {
        this.ko = ko;
        this.color = color;
    }
    public String getKo() {
        return ko;
    }

    public String getColor() {
        return color;
    }
}
