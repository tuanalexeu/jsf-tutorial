package book.beans;


import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@SessionScoped
public class SliderBean implements Serializable {

    private static final Logger logger =
            Logger.getLogger(SliderBean.class.getName());
    private int min = 0;
    private int max = 10;
    private int leftside = 4;
    private int rightside = 6;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getLeftside() {
        return leftside;
    }

    public void setLeftside(int leftside) {
        this.leftside = leftside;
    }

    public int getRightside() {
        return rightside;
    }

    public void setRightside(int rightside) {
        this.rightside = rightside;
    }

    public void sliderListener() {
        logger.log(Level.INFO, "Min:{0}  Max:{1}  Left side:{2}   Right Side:{3}", new Object[]{min, max, leftside, rightside});
    }
}
