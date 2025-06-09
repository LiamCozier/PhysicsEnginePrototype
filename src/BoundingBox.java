
public class BoundingBox {
    private Vector2 position;
    private float width, height;

    // initialise mentioned variables.
    public BoundingBox(Vector2 position, float width, float height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    // getters & setters omitted for brevity's sake

    // returns the minimum and maximum corner of the bounding box in global space.
    // extremely useful for AABB overlap detection.
    public Vector2[] get_corners() {
        return new Vector2[] {
                new Vector2(position.x - (width / 2), this.position.y - (height / 2)),
                new Vector2(position.x + (width / 2), this.position.y + (height / 2)),
        };
    }
}
