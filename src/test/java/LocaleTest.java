import java.util.Locale;

import org.junit.Test;

import utils.Utils;

import static org.junit.Assert.assertEquals;

/**
 * @author ding.lid
 */
public class LocaleTest {
    @Test
    public void testSerialize() throws Exception {
        Locale obj = Locale.getDefault();
        assertEquals(obj, Utils.serialize(obj));
    }
}
