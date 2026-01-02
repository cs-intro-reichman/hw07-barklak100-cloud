/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
	public static void main(String[] args) {
    // 1. הגדרות הקנבס (גודל וטווח צירים)
    int size = 800;
    StdDraw.setCanvasSize(size, size);
    StdDraw.setXscale(0, 1);
    StdDraw.setYscale(0, 1);
    
    // אופציונלי: מהירות ציור גבוהה יותר
    StdDraw.enableDoubleBuffering();

    // 2. הגדרת פרמטרים לפתית השלג
    int depth = 4; // עומק הרקורסיה (נסה לשנות מ-0 עד 6)
    
    // קואורדינטות בסיס למשולש שווה צלעות שממורכז במסך
    double x1 = 0.2, y1 = 0.3;
    double x2 = 0.8, y2 = 0.3;
    
    // חישוב הקודקוד השלישי (x3, y3) בעזרת טריגונומטריה/פיתגורס
    // אורך הצלע הוא 0.6, לכן הגובה הוא sqrt(3)/2 * 0.6
    double x3 = 0.5;
    double y3 = y1 + (Math.sqrt(3) / 2.0) * (x2 - x1);

    // 3. קריאה לפונקציה curve שלוש פעמים ליצירת פתית השלג המלא
    // סדר הנקודות כאן קובע שהמשולשים ייבנו כלפי חוץ
    curve(depth, x1, y1, x2, y2); // צלע תחתונה (משמאל לימין)
    curve(depth, x2, y2, x3, y3); // צלע ימנית (מלמטה למעלה)
    curve(depth, x3, y3, x1, y1); // צלע שמאלית (מלמעלה למטה)

    StdDraw.show();
}
	


	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double ax = x1 + (x2 - x1) / 3.0;
        double ay = y1 + (y2 - y1) / 3.0;

        
        double bx = x1 + 2.0 * (x2 - x1) / 3.0;
        double by = y1 + 2.0 * (y2 - y1) / 3.0;

        double sqrt3_6 = Math.sqrt(3.0) / 6.0;
        double p3x = sqrt3_6 * (y1 - y2) + 0.5 * (x1 + x2);
        double p3y = sqrt3_6 * (x2 - x1) + 0.5 * (y1 + y2);

        curve(n - 1, x1, y1, ax, ay);   
        curve(n - 1, ax, ay, p3x, p3y); 
        curve(n - 1, p3x, p3y, bx, by); 
        curve(n - 1, bx, by, x2, y2);   
    }

	}

      
    


   