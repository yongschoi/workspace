import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 *
 * common은 main()클래스가 없으므로 JUnit Test환경을 위해 contextLoads()를 제공한다.
 */
@SpringBootApplication
public class ModuleCommonApplicationTests {
    public void contextLoads() {}
}