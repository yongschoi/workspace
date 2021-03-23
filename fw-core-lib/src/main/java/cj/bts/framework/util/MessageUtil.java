package cj.bts.framework.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 *
 * This software is the proprietary information of CJ OliveNetworks
 * </pre>
 *
 * @author yschoi21
 * @since 2021. 1. 28.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 1. 28. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
 @Component
public class MessageUtil {
    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
    	MessageUtil.messageSource = messageSource;
    }

    /**
     * key로 정의된 message를 가져 온다.<br>
     *<br>
     * @param key String key
     * @return getResultMessage 키에 해당하는 메세지
     */
    public static String getMessage(String key) {
        return getMessage(key, null, Locale.getDefault());
    }

    /**
     * key로 정의된 message를 가져 온다.<br>
     * argument 를 가지는 message.
     *<br>
     * @param key String key
     * @param args message
     * @return key에 해당하는 메세지
     */
    public static String getMessage(String key, Object[] args) {
        return getMessage(key, args, Locale.getDefault());
    }

    /**
     * 해당 locale의 message를 가져온다.<br>
     *<br>
     * @param key String key
     * @param locale locale정보
     * @return key에 해당하는 메세지
     */
    public static String getMessage(String key, Locale locale) {
        return getMessage(key, null, locale);
    }
    /**
     * 해당 locale의 message를 가져온다.<br>
     * argument 를 가지는 message.
     *<br>
     * @param key String key
     * @param args message
     * @param locale locale정보
     * @return key에 해당하는 메세지
     */
    public static String getMessage(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale);
    }
}
