import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
public class Te {
    @Test
    public static void main(String[] args) {
        //获取默认时区的当前时间
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
