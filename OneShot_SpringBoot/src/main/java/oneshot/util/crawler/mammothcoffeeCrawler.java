package oneshot.util.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class mammothcoffeeCrawler {
    static int rs = 0;

    public static void mammothcoffeeCrawling() {
        try {
            String URL = "https://www.mmthcoffee.com/sub/menu/list.html";
            Document doc = Jsoup.connect(URL).ignoreContentType(true).get();
            String selector = "#sub > div.sub_con > div.con02 > div > div.cate";
            Elements elements = doc.select(selector);
            StringBuilder query = new StringBuilder();
            String type, menuName, img;
            for (int i = 0; i < elements.size(); i++) {
                type = elements.get(i).select(".c_tit").text();
                Elements innerElements = elements.get(i).select(".clear > .animation");
                for (int j = 0; j < innerElements.size(); j++) {
                    img = "https://www.mmthcoffee.com" + innerElements.get(j).select(".img_wrap > img").attr("src");
                    menuName = innerElements.get(j).select("strong").text();
                    query.append(
                            String.format("(\"2\", \"%s\", \"%s\", null, null, null, \"%s\"),", menuName, img, type));
                }
            }
            try {
                rs += mysqlUtil.insertDB(query.substring(0, query.length() - 1) + ";");
            } catch (Exception e) {
                System.out.println("Mammothcoffee SQL Exception : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Mammothcoffee Crawling Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mammothcoffeeCrawling();
        System.out.println("Mammothcoffee Affected Row : " + rs);
    }

}
