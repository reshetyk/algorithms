package ood.parkinglot;

import com.sun.glass.ui.Size;

/**
* Created by Reshetuyk on 23.03.2017.
*/
enum SpaceType {
    REGUAL(new Size(100, 100)),
    HANDICAPPED(new Size(200, 200)),
    COMPACT(new Size(50, 50)),
    LARGE(new Size(300, 300));

    private Size size;

    SpaceType(Size size) {
        this.size = size;
    }

    public boolean withinInSize (Size size) {
        return this.size.height <= size.height && this.size.width <= size.width;
    }
}
