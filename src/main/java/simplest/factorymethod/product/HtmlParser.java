package simplest.factorymethod.product;

public class HtmlParser implements Parser {
    @Override
    public String parse(String htmlFileName) {
        return "{'name':'wang'}";
    }
}
