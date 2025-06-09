public class RigidBody extends Particle{
    Shape shape;
    float orientation;
    float angular_velocity;

    public RigidBody(Vector2 position, Vector2 velocity, float orientation, float angular_velocity) {
        super(position, velocity);
        this.orientation = orientation;
        this.angular_velocity = angular_velocity;
    }

    public void physics_tick(float deltaT) {
        particle_physics_tick(deltaT);

        this.orientation += angular_velocity;
    }

    public Vector2 get_centre_of_mass() {
        Polygon poly = shape.get_polygon();
        float[] vertices = poly.get_vertices();
        float sum_x = 0, sum_y = 0;

        for (int i=0; i<vertices.length/2; i++) {
            sum_x += vertices[2 * i];
            sum_y += vertices[(2 * i) + 1];
        }

        float mean_x = sum_x / ((float) vertices.length / 2);
        float mean_y = sum_y / ((float) vertices.length / 2);

        return new Vector2(mean_x, mean_y);

    }

    public Polygon get_rotated_polygon() {
        Polygon poly = shape.get_polygon();
        Vector2 centre_of_mass = get_centre_of_mass();

        float sina = (float) Math.sin(orientation);
        float cosa = (float) Math.cos(orientation);

        float[] old_vertices = poly.get_vertices();
        float[] new_vertices = new float[old_vertices.length];
        for (int i=0; i<old_vertices.length/2; i++) {
            float x = old_vertices[i * 2];
            float y = old_vertices[(i * 2) + 1];

            x -= centre_of_mass.x;
            y -= centre_of_mass.y;

            x = (x * cosa) - (y * sina);
            y = (y * cosa) + (x * sina);

            x += centre_of_mass.x;
            y += centre_of_mass.y;

            new_vertices[i * 2] = x;
            new_vertices[(i * 2) + 1] = y;
        }

        return new Polygon(new_vertices);
    }
}