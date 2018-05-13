package com.example.rohit.bayersprojectgooglemaps;

import android.os.Environment;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Rohit on 20-04-2017.
 */

public class CustomMapTileProvider implements TileProvider
{
    private static final int TILE_WIDTH = 256;
    private static final int TILE_HEIGHT = 256;
    private static final int BUFFER_SIZE = 16 * 1024;

    @Override
    public Tile getTile(int x, int y, int zoom) {
        byte[] image = readTileImage(x, y, zoom);
        return image == null ? null : new Tile(TILE_WIDTH, TILE_HEIGHT, image);
    }

    private byte[] readTileImage(int x, int y, int zoom) {
        FileInputStream in = null;
        ByteArrayOutputStream buffer = null;

        try { in = new FileInputStream(getTileFile(x, y, zoom));
            buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[BUFFER_SIZE];

            while ((nRead = in .read(data, 0, BUFFER_SIZE)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        } finally {
            if ( in != null)
                try { in .close();
                } catch (Exception ignored) {}
            if (buffer != null)
                try {
                    buffer.close();
                } catch (Exception ignored) {}
        }
    }

    private File getTileFile(int x, int y, int zoom) {
        File sdcard = Environment.getExternalStorageDirectory();
        String tileFile = "/TILES_FOLDER/" + zoom + '/' + x + '/' + y + ".png";
        File file = new File(sdcard, tileFile);
        return file;
    }
}
