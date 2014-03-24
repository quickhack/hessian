package hessian;

import com.ace4j.com.caucho.hessian.test.A0;
import com.ace4j.com.caucho.hessian.test.TestCons;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static utils.Utils.serialize;

/**
 * @author ding.lid
 */
public class HessianTest {
    @Test
    public void test_hessian() throws Exception {
        A0 a0 = new A0();
        assertEquals(a0, serialize(a0));

        TestCons testCons = new TestCons("a", 3);
        assertEquals(testCons, serialize(testCons));
    }
}
