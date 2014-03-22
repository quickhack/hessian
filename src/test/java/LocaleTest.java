import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
