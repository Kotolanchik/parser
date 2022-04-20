import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect
    }
}

class Article{
    private String url;
    private String name;

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
