package com.lblandi.productms.features.port;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PortUtils {
    private final Environment env;

    public PortUtils(Environment env) {
        this.env = env;
    }

    public int getLocalServerPort() {
        Optional<String> port = Optional.ofNullable(env.getProperty("local.server.port"));
        return port.map(Integer::parseInt).orElse(8080);
    }
}


