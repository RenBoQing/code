package com.rbq.code.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author RenBoQing&HuHanYue
 * @date 2022年04月19日 10:06
 * @Description
 */
@Component
public final class UUIDtilus {
    private UUIDtilus() {

    }
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
