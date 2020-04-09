package wangyaofeng.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DataSourceTest {

    @Test
    public void build() {

        DataSource dataSource = new DataSource.Builder()
                .setHost("127.0.0.1")
                .setPort(3306)
                .setDatabase("userdb")
                .build();

        log.debug("{}", dataSource.getConnection());

    }

}