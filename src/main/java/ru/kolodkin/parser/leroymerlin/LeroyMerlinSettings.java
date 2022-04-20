package ru.kolodkin.parser.leroymerlin;

import ru.kolodkin.parser.tools.ParserSettings;

public class LeroyMerlinSettings extends ParserSettings {
    //show-more кнопка далее
    public LeroyMerlinSettings(int start, int end, String requiredSection) {
        startPoint = start;
        endPoint = end;
        BASE_URL = "https://leroymerlin.ru";
        PREFIX = "/catalogue/" + requiredSection + "/?page={CurrentId}";
    }

}
