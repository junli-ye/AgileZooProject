import org.junit.jupiter.api.BeforeEach;
import java.util.Random;

public class KongFuPandaAdapterTest {
    private Random mockRandom;
    private KongFuPandaAdapter panda;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach is running...");
        // Mock Random: 可以灵活控制 nextInt() 和 nextBoolean()
        mockRandom = new Random() {
            private int callCount = 0;

            @Override
            public int nextInt(int bound) {
                if (callCount == 0) {
                    callCount++;
                    return 9; // XP 增长 10
                } else {
                    return 0; // 学习第一个技能
                }
            }

            @Override
            public boolean nextBoolean() {
                return true; // 每次都学技能
            }
        };

        panda = new KongFuPandaAdapter("Po", 5, mockRandom);
    }

}
