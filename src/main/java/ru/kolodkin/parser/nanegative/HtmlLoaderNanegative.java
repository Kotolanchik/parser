package ru.kolodkin.parser.nanegative;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlLoaderNanegative {
    String url;
    String baseUrl;

    public HtmlLoaderNanegative(NanegativeSettings settings) {
        url = settings.BASE_URL + settings.PREFIX;
        baseUrl = settings.BASE_URL;
    }

    public Document GetSourceByPageId(int id) throws IOException { // конкретная страница с магазинами
        String currentURL = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentURL).get();
    }

    public Document GetSourceByPrefixMagazine(String prefix_magazine) throws IOException { // конкретный магазин со списком отзывов
        String currentURL = baseUrl + prefix_magazine;
        return Jsoup.connect(currentURL).get();
    }

    public Document GetSourceByPageIdShop(int id, String prefix_magazine) throws IOException {
        String currentURL = baseUrl + prefix_magazine + "?page=" + id;
        return Jsoup.connect(currentURL).get();
    }
}
