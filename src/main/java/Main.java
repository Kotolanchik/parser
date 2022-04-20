import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.kolodkin.parser.nanegative.model.Feedback;
import ru.kolodkin.parser.nanegative.model.Shop;
import ru.kolodkin.parser.nanegative.HtmlLoaderNanegative;
import ru.kolodkin.parser.nanegative.NanegativeSettings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        HtmlLoaderNanegative loaderNanegative = new HtmlLoaderNanegative(new NanegativeSettings(1, 11));
        List<String> links = new ArrayList<>();
        Elements elements = loaderNanegative.GetSourceByPageId(1).getElementsByClass("find-list-box").select("a[href]");
        for (Element e : elements) {
            links.add(e.attr("href"));
        }

        List<Shop> shops = new ArrayList<>();

        for (int i = 0; i < links.size(); i++) {
            Document specificStore = loaderNanegative.GetSourceByPrefixMagazine(links.get(i)); // конкретный магазин
            int lastPage = Integer.parseInt(specificStore
                    .getElementsByClass("all-pages")
                    .text().split(" ")[3]);// конец пагинации для конкретного магазина

            ArrayList<Feedback> feedbacks = new ArrayList<>();
            String title = specificStore.title();
            int rating = Integer.parseInt(specificStore.getElementsByClass("text").select("span[itemprop=ratingValue]").text());

            for (int j = 0; j < 1; j++) { //количество обрабатываемых страниц должен стоять lastPage
                Document doc = loaderNanegative.GetSourceByPageIdShop(j, links.get(i));

                for (Element element : doc.getElementsByClass("reviewers-box")) {
                    feedbacks.add(new Feedback(
                                    element.select("span[itemprop=author]").text(),
                                    element.select("td[itemprop=pro]").text(),
                                    element.select("td[itemprop=contra]").text(),
                                    element.select("td[itemprop=reviewBody]").text()
                            )
                    );
                }
                // System.out.println("ADD");
            }
//            feedbacks.forEach(System.out::println);
//            System.out.println(title);
//            System.out.println(rating);
//            System.out.println(links.get(i));
//
//            System.out.println();
//            System.out.println();

            shops.add(new Shop(title,rating,links.get(i), feedbacks));

        }

        shops.forEach(System.out::println);
//        Document document = loaderNanegative.GetSourceByPrefixMagazine(links.get(0));
//        int lastPage = Integer.parseInt(document.getElementsByClass("all-pages").text().split(" ")[3]);

        // document.selectXpath("//div[@class='reviewers-box']");
        //System.out.println(document.selectXpath("//div[@class='reviewers-box']"));

        //List<Shop> shops = new ArrayList<>();
//
//        List<Feedback> feedbacks = new ArrayList<>();
//        for (int i = 0; i < lastPage; i++) {
//
//            for (Element element : document.getElementsByClass("reviewers-box")) {
//                feedbacks.add(new Feedback(
//                                element.select("span[itemprop=author]").text(),
//                                element.select("td[itemprop=pro]").text(),
//                                element.select("td[itemprop=contra]").text(),
//                                element.select("td[itemprop=reviewBody]").text()
//                        )
//                );
//            }
//        }
//        feedbacks.forEach(System.out::println);

//        for (Element element : document.selectXpath("//div[@class='reviewers-box']")) {
//            System.out.println("НАЧАЛО "+element+ "КОНЕЦ");
//        }
    }
}
