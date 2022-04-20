package ru.kolodkin.parser.nanegative;

import ru.kolodkin.parser.tools.ParserSettings;

public class NanegativeSettings extends ParserSettings {
    public static String MAGAZINE_PREFIX;
    public static String PAGE_MAGAZINE_PREFIX;

    public NanegativeSettings(int start, int end) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://nanegative.ru";
        PREFIX = "/internet-magaziny?page={CurrentId}";
        MAGAZINE_PREFIX = "{magazine}";
        PAGE_MAGAZINE_PREFIX = MAGAZINE_PREFIX + "?page={CurrentId}";
    }
}
