
import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}
class MyClass {

    @MyAnnotation("This is a method annotation")
    public void myMethod() {
        System.out.println("Inside myMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        MyAnnotation annotation = obj.getClass().getDeclaredMethod("myMethod").getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println("Annotation value: " + annotation.value());
        } else {
            System.out.println("Annotation not found");
        }
    }
}
