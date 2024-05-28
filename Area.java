import java.util.ArrayList;

public class Area {
    public static void area(Circle[] circles){
         ArrayList<ArrayList<Circle>> groups = new ArrayList<>();
    
        for (Circle circle : circles) {
            boolean foundGroup = false;
        
            for (ArrayList<Circle> group : groups) {
                if (group.size() > 0) {
                    double prevX = group.get(0).getX();
                    double prevY = group.get(0).getY();
                
                    if (circle.getX() == prevX || circle.getY() == prevY) {
                        group.add(circle);
                        foundGroup = true;
                        break;
                    }
                }
            }
        
            if (!foundGroup) {
                ArrayList<Circle> newGroup = new ArrayList<>();
                newGroup.add(circle);
                groups.add(newGroup);
            }
        }

        System.out.println("Группы окружностей, центры которых лежат на одной прямой:");
        for (ArrayList<Circle> group : groups) {
            for (Circle circle : group) {
                System.out.println("Радиус: " + circle.getRadius() + ", Координаты центра: (" + circle.getX() + ", " + circle.getY() + ")");
            }
            System.out.println();
        }

        Circle maxAreaCircle = circles[0];
        Circle minAreaCircle = circles[0];
    
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > maxAreaCircle.getArea()) {
                maxAreaCircle = circles[i];
            }
            if (circles[i].getArea() < minAreaCircle.getArea()) {
                minAreaCircle = circles[i];
            }
        }
    
        System.out.println("Наибольшая площадь: " + maxAreaCircle.getArea());
        System.out.println("Наименьшая площадь: " + minAreaCircle.getArea());
    }
}
