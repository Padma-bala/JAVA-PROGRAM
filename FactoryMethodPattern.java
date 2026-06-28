public class FactoryMethodPattern {

    interface Animal {
        void speak();
    }

    static class Dog implements Animal {
        public void speak() {
            System.out.println("Dog says: Woof!");
        }
    }

    static class Cat implements Animal {
        public void speak() {
            System.out.println("Cat says: Meow!");
        }
    }

    static class Duck implements Animal {
        public void speak() {
            System.out.println("Duck says: Quack!");
        }
    }

    static class AnimalFactory {
        public static Animal getAnimal(String type) {
            if (type.equalsIgnoreCase("dog")) {
                return new Dog();
            } else if (type.equalsIgnoreCase("cat")) {
                return new Cat();
            } else if (type.equalsIgnoreCase("duck")) {
                return new Duck();
            } else {
                throw new IllegalArgumentException("Unknown animal: " + type);
            }
        }
    }


    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    static class Rectangle implements Shape {
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    static class Triangle implements Shape {
        public void draw() {
            System.out.println("Drawing a Triangle");
        }
    }

    static class ShapeFactory {
        public static Shape getShape(String type) {
            if (type.equalsIgnoreCase("circle")) {
                return new Circle();
            } else if (type.equalsIgnoreCase("rectangle")) {
                return new Rectangle();
            } else if (type.equalsIgnoreCase("triangle")) {
                return new Triangle();
            } else {
                throw new IllegalArgumentException("Unknown shape: " + type);
            }
        }
    }


    interface Notification {
        void notifyUser();
    }

    static class EmailNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending Email Notification");
        }
    }

    static class SMSNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending SMS Notification");
        }
    }

    static class PushNotification implements Notification {
        public void notifyUser() {
            System.out.println("Sending Push Notification");
        }
    }

    static class NotificationFactory {
        public static Notification getNotification(String type) {
            if (type.equalsIgnoreCase("email")) {
                return new EmailNotification();
            } else if (type.equalsIgnoreCase("sms")) {
                return new SMSNotification();
            } else if (type.equalsIgnoreCase("push")) {
                return new PushNotification();
            } else {
                throw new IllegalArgumentException("Unknown notification: " + type);
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("===== Animal Factory =====");
        Animal dog = AnimalFactory.getAnimal("dog");
        dog.speak();
        Animal cat = AnimalFactory.getAnimal("cat");
        cat.speak();
        Animal duck = AnimalFactory.getAnimal("duck");
        duck.speak();

        System.out.println("\n===== Shape Factory =====");
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();
        Shape triangle = ShapeFactory.getShape("triangle");
        triangle.draw();

        System.out.println("\n===== Notification Factory =====");
        Notification email = NotificationFactory.getNotification("email");
        email.notifyUser();
        Notification sms = NotificationFactory.getNotification("sms");
        sms.notifyUser();
        Notification push = NotificationFactory.getNotification("push");
        push.notifyUser();
    }
}