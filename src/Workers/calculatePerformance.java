package Workers;

public interface calculatePerformance {

    // Returns a numeric performance score (0-100 for example)
    double CalculatePerformance();
    // Returns a readable label based on the numeric score ("Excellent", "Good", etc.)
    String getPerformance();
}
