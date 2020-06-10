
package Exp;

/**
 * Experiment Class
 */
public class Experiment {
  public String setup;

  public int day;

  public String time;

  public boolean completed;

  public float accuracy;

  /**
   * Experiment Constructor
   * @param s
   * @param d
   * @param t
   * @param c
   * @param a
   */
  Experiment(String s, int d, String t, boolean c, float a) {
        setup=s;
        day=d;
        time=t;
        completed=c;
        accuracy=a;
  }

  /**
   * ToString method for experiments
   * @return
   */
  @Override
  public String toString() {
        return "Experiment{" +
                "setup='" + setup + '\'' +
                ", day=" + day +
                ", time='" + time + '\'' +
                ", accuracy=" + accuracy +
                ", completed=" + completed +
                '}';
  }

}
