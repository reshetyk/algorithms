package ood.parkinglot;

import org.apache.commons.lang3.Validate;

/**
 * Created by Reshetuyk on 25.03.2017.
 */
public class Size implements Comparable<Size> {
    private int width;
    private int height;

    public Size(Size size) {
        this(size.getWidth(), size.getHeight());
    }

    public Size(int width, int height) {
        Validate.inclusiveBetween(1, Integer.MAX_VALUE, height, "Height [" + height + "] is invalid ");
        Validate.inclusiveBetween(1, Integer.MAX_VALUE, width, "Width [" + width + "] is invalid ");
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (height != size.height) return false;
        if (width != size.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public int compareTo(Size o) {
        if (o.getArea() > this.getArea())
            return 1;

        if (o.getArea() < this.getArea())
            return -1;

        return 0;
    }
}
