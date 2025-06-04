public class Particle {
    /* I first declare the particle's position and velocity. This will be the store for the most
     * basic data in my physics engine. Everything will be built around this particle class'
     * position and velocity vectors */
    protected Vector2 position;
    protected Vector2 velocity;

    public Particle(Vector2 position, Vector2 velocity) {
        // Initialising position and velocity
        this.position = position;
        this.velocity = velocity;
    }

    /* this method is called proportionally to the frame-rate, likely 1:1. it is prefixed
    *  with "particle" because this class will only be inherited by others */
    public void particle_physics_tick(float deltaT) {

        // integrate velocity by acceleration ((0, -1) is a placeholder for now)
        this.velocity.mulAdd(new Vector2(0, -1), deltaT);

        /* integrate position by velocity. here, "velocity" is used instead of
        *  "new_velocity" because the Vector2 class is mutable, so the mulAdd() method
        *  changes the velocity vector directly */
        this.position.mulAdd(velocity, deltaT);
    }
}
