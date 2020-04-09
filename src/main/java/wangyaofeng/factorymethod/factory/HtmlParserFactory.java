package wangyaofeng.factorymethod.factory;

import wangyaofeng.factorymethod.product.HtmlParser;
import wangyaofeng.factorymethod.product.Parser;

public class HtmlParserFactory implements ParserFactory {
    @Override
    public Parser createParser() {
        return new HtmlParser();
    }
}
