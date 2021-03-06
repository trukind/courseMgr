package edu.coursemgr.service.interfaces;

import java.io.IOException;
import java.util.EnumMap;

/**
 * Created by chenxianzhang on 2018/8/8 0008 下午 9:19
 */
public interface VerificationCodeService {

    enum VerCodeProperty {
        IMAGE,
        RESULT_CODE
    }

    EnumMap<VerCodeProperty, Object> generateVerCode() throws IOException;
}
