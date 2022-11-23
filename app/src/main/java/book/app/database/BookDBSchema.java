package book.app.database;

public class BookDBSchema {
    public static final class BookTable {
        public static final String NAME = "Books";

        public static final class Cols {
            public static final String TITLE = "title";
            public static final String UUID = "uuid";
            public static final String AUTHORS = "authors";
            public static final String PUBLISHER = "publisher";
            public static final String PUB_TIME = "pub_time";
            public static final String ISBN = "isbn";

        }
    }
}
