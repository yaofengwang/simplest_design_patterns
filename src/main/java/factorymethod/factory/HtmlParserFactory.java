package factorymethod.factory;

import factorymethod.product.HtmlParser;
import factorymethod.product.Parser;

public class HtmlParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new HtmlParser();
    }
}
