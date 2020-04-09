package wangyaofeng.builder;

import lombok.Data;

@Data
public  class DataSource {
    private String host;
    private Integer port;
    private String database;

    public DataSource(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.database = builder.database;
    }

    public String getConnection(){
        return "mysql://" + this.host + ":" + this.port + "?" + this.database;
    }

    public static class Builder {
        private String host;
        private Integer port;
        private String database;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public Builder setDatabase(String database) {
            this.database = database;
            return this;
        }

        public DataSource build(){
            DataSource dataSource = new DataSource(this);
            return dataSource;
        }
    }

}
