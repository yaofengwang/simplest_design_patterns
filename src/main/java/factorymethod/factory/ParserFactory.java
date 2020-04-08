package factorymethod.factory;

import factorymethod.product.Parser;

public interface ParserFactory {
    Parser createParser();
}
