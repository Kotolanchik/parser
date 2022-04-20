package ru.kolodkin.parser.leroymerlin;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class HtmlLoaderLeroyMerlin {
    String url;
    String baseUrl;

    public HtmlLoaderLeroyMerlin(LeroyMerlinSettings settings) {
        url = settings.BASE_URL + settings.PREFIX;
        baseUrl = settings.BASE_URL;
    }

    public Document GetSourceByPageId(int id) throws IOException { // конкретная страница с магазинами

        String currentURL = url.replace("{CurrentId}", Integer.toString(id));
        return Jsoup.connect(currentURL).get();
    }

    public String GetSourceByPrefixMagazineStr(String prefix_magazine) throws IOException { // конкретный магазин со списком отзывов
        String currentURL = baseUrl + prefix_magazine;
        return currentURL;
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
