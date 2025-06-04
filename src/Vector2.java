public class Vector2 {
    public float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void mulAdd(Vector2 v, float s) {
        this.x += v.x * s;
        this.y += v.y * s;
    }

    public void scl(float s) {
        this.x *= s;
        this.y *= s;
    }
}
