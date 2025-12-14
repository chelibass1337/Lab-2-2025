import functions.FunctionPoint;
import functions.TabulatedFunction;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование табулированной функции ===\n");
        System.out.println("1. Создаем функцию y = x^2 на интервале [-2, 2] с 5 точками:");
        TabulatedFunction parabola = new TabulatedFunction(-2, 2, 5);
        for (int i = 0; i < parabola.getPointsCount(); i++) {
            double x = parabola.getPointX(i);
            parabola.setPointY(i, x * x);
        }
        parabola.printPoints();
        System.out.println("\n2. Вычисляем значения функции в различных точках:");
        double[] testPoints = {-2,-1,0,1,2};
        for (double x : testPoints) {
            double y = parabola.getFunctionValue(x);
            System.out.printf("  f(%.1f) = ", x);
            if (Double.isNaN(y)) {
                System.out.println("не определено (вне области определения)");
            } else {
                System.out.printf("%.4f%n", y);
            }
        }
        System.out.println("\n3. Заменяем точку с индексом 2:");
        FunctionPoint newPoint = new FunctionPoint(-0.5, 0.25);
        parabola.setPoint(2, newPoint);
        System.out.println("   После замены:");
        parabola.printPoints();
        System.out.println("\n4. Добавляем новые точки:");
        parabola.addPoint(new FunctionPoint(1.5, 2.25));
        parabola.addPoint(new FunctionPoint(0.8, 0.64));
        System.out.println("   После добавления:");
        parabola.printPoints();
        System.out.println("\n5. Удаляем точку с индексом 3:");
        parabola.deletePoint(3);
        System.out.println("   После удаления:");
        parabola.printPoints();
        System.out.println("\n6. Новые значения функции:");
        for (double x : new double[]{-1, 0, 0.8, 1.5}) {
            double y = parabola.getFunctionValue(x);
            System.out.printf("  f(%.1f) = %.4f%n", x, y);
        }
        
        System.out.println("\n=== Тестирование завершено ===");
    }
}