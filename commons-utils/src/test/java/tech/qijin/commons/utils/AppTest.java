package tech.qijin.commons.utils;

import com.alibaba.fastjson.JSON;
import tech.qijin.commons.utils.builder.ResBuilder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void builderTest() {
        System.out.println(JSON.toJSONString(ResBuilder.genError(1, "heh")));
    }
}
