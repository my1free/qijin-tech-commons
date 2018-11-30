package tech.qijin.commons.trace.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.qijin.commons.web.pojo.EnvEnum;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Trace implements Serializable {

    private String traceId;

    private EnvEnum env;


}
