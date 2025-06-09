
public class Polygon {
    // list of vertices as mentioned
    private float[] vertices;

    public Polygon(float[] vertices) {
        this.vertices = vertices;
    }

    public void set_vertex(int index, float x, float y) {
        // fetching vertices is slightly more complicated needing to
        // double the index to adjust for holding them {x, y, x, y..}
        this.vertices[2 * index] = x;
        this.vertices[(2 * index) + 1] = y;
    }

    // returning a vector 2 because this is most convenient
    // for working with positions outside of this class
    public Vector2 get_vertex(int index) {
        return new Vector2(
                this.vertices[2 * index],
                this.vertices[(2 * index) + 1]
        );
    }

    // returning the specialised array because any method which uses
    // the entire array will likely be iterating through it
    public float[] get_vertices() {
        return this.vertices;
    }


}
