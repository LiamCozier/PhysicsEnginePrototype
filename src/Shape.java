/* I chose to make the shape an abstract class because it will never need to be directly initialised
*  and will just act as a parent class to the entire shape family */
public abstract class Shape {

    /* Declaring both abstract methods in here because they don't need a definition yet. it also forces
    *  any class inheriting shape to have these methods, so I can use them on any of this class' children
    *  without worry of compatibility */
    public abstract Polygon get_polygon();
    public abstract BoundingBox get_bounding_box();
}

