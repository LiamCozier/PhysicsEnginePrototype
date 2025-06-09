import java.util.List;

public class TileSet {

    // Global space position of tileset,
    // all tiles are relative to this position.
    Vector2 position;
    Tile[] tiles;

    public TileSet(Vector2 position) {
        // initialize global position
        this.position = position;
    }

    /*
       returns the global position of a tile in the set the
       calculation is just tile_position + tileset_position
       this calculation is the case for most local to global
       space transformations
    */
    public Vector2 get_tile_global_position(Tile tile) {
        return new Vector2(
                tile.get_position().x + this.position.x,
                tile.get_position().y + this.position.y
        );
    }

    /*
       this is a crude example of how rendering could be achieved in a tileset class,
       it first gets the position of the tile in question, then converts it to screen space
       finally it renders it, at the correct screen position, using the calculation:
       screen_position = global_position - camera_position
       where camera_position is the imaginary "global_position" for the camera
     */
    public void render(Camera c) {
        for (int i=0; i<tiles.length; i++) {
            Vector2 screen_position = c.to_camera_space(get_tile_global_position(tiles[i]));
            tiles[i].render(screen_position);
        }
    }

}
