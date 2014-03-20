import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Locale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ding.lid
 */
public class LocaleTest {
    @Test
    public void testSerialize() throws Exception {
        Locale obj = Locale.getDefault();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        AbstractHessianOutput out = new Hessian2Output(os);
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader != null) {
            out.setSerializerFactory(new SerializerFactory(classLoader));
        } else {
            out.setSerializerFactory(new SerializerFactory());
        }

        out.writeObject(obj);
        out.flush();
        byte[] val = os.toByteArray();
        if (out != null) {
            out.close();
        }
        if (os != null) {
            os.close();
        }

        InputStream is = new ByteArrayInputStream(val);
        Hessian2Input in = new Hessian2Input(is);
        SerializerFactory serFactory = new SerializerFactory(Thread.currentThread().getContextClassLoader());
        in.setSerializerFactory(serFactory);
        Object ret = in.readObject();
        if (in != null) {
            in.close();
        }
        if (is != null) {
            is.close();
        }

        assertEquals(obj, ret);
    }
}
