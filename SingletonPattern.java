public class SingletonPattern {

    static class BasicSingleton {
        private static BasicSingleton instance;

        private BasicSingleton() {
            System.out.println("BasicSingleton instance created.");
        }

        public static BasicSingleton getInstance() {
            if (instance == null) {
                instance = new BasicSingleton();
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from BasicSingleton!");
        }
    }


    static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;

        private ThreadSafeSingleton() {
            System.out.println("ThreadSafeSingleton instance created.");
        }

        public static synchronized ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from ThreadSafeSingleton!");
        }
    }


    static class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();

        private EagerSingleton() {
            System.out.println("EagerSingleton instance created.");
        }

        public static EagerSingleton getInstance() {
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from EagerSingleton!");
        }
    }


    static class DoubleCheckedSingleton {
        private static volatile DoubleCheckedSingleton instance;

        private DoubleCheckedSingleton() {
            System.out.println("DoubleCheckedSingleton instance created.");
        }

        public static DoubleCheckedSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckedSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedSingleton();
                    }
                }
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello from DoubleCheckedSingleton!");
        }
    }


    static class DatabaseConnection {
        private static DatabaseConnection instance;
        private String connectionStatus;

        private DatabaseConnection() {
            connectionStatus = "Connected to Database!";
            System.out.println("Database connection established.");
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public String getConnectionStatus() {
            return connectionStatus;
        }

        public void query(String sql) {
            System.out.println("Executing query: " + sql);
        }
    }


    public static void main(String[] args) {

        System.out.println("===== Basic Singleton =====");
        BasicSingleton obj1 = BasicSingleton.getInstance();
        BasicSingleton obj2 = BasicSingleton.getInstance();
        obj1.showMessage();
        System.out.println("Same instance? " + (obj1 == obj2));

        System.out.println("\n===== Thread-Safe Singleton =====");
        ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
        ts1.showMessage();
        System.out.println("Same instance? " + (ts1 == ts2));

        System.out.println("\n===== Eager Singleton =====");
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();
        es1.showMessage();
        System.out.println("Same instance? " + (es1 == es2));

        System.out.println("\n===== Double-Checked Locking Singleton =====");
        DoubleCheckedSingleton dc1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dc2 = DoubleCheckedSingleton.getInstance();
        dc1.showMessage();
        System.out.println("Same instance? " + (dc1 == dc2));

        System.out.println("\n===== Real-World: Database Connection =====");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println(db1.getConnectionStatus());
        db1.query("SELECT * FROM students");
        db2.query("SELECT * FROM employees");
        System.out.println("Same DB instance? " + (db1 == db2));
    }
}